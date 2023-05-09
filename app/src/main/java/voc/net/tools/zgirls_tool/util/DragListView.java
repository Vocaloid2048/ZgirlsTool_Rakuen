package voc.net.tools.zgirls_tool.util;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DragListView extends ListView {

    /**
     * 速度模板，影响视图移动时的速度变化
     * <p>
     * https://blog.csdn.net/Sure_Min/article/details/107103371
     * MODE_LINEAR                 // 线性变化模式
     * MODE_ACCELERATE             // 加速模式
     * MODE_DECELERATE             // 减速模式
     * MODE_ACCELERATE_DECELERATE  // 先加速后加速模式
     */
    public static final int MODE_LINEAR = 0x001;
    public static final int MODE_ACCELERATE = 0x002;
    public static final int MODE_DECELERATE = 0x003;
    public static final int MODE_ACCELERATE_DECELERATE = 0x004;

    private Context context;

    // 拖动时的视图
    private View dragView;


    private WindowManager windowManager;
    private WindowManager.LayoutParams windowLayoutParams;
    private BaseDragAdapter adapter;


    /**
     * 可设置选项
     */
    // 移动动画储持续时间，单位毫秒
    private long duration = 300;

    // 速度模板
    private int speedMode = MODE_ACCELERATE_DECELERATE;

    // 自动滚动的速度
    private int scrollSpeed = 50;


    /**
     * 运行参数
     */
    // 拖动块的原始坐标
    private int originalPosition = -1;

    // 拖动块当前所在坐标
    private int currentPosition = -1;

    // 用于记录上次点击事件MotionEvent.getX();
    private int lastX;

    // 用于记录上次点击事件MotionEvent.getY();
    private int lastY;

    // 用于记录上次点击事件MotionEvent.getRawX();
    private int lastRawX;

    // 用于记录上次点击事件MotionEvent.getRawY();
    private int lastRawY;

    // 拖动块中心点x坐标，用于判断拖动块所处的列表位置
    private int dragCenterX;

    // 拖动块中心点y坐标，用于判断拖动块所处的列表位置
    private int dragCenterY;

    // 滑动上边界，拖动块中心超过该边界时列表自动向下滑动
    private int upScrollBorder;

    // 滑动下边界，拖动块中心超过该边界时列表自动向上滑动
    private int downScrollBorder;

    // 状态栏高度
    private int statusHeight;

    // 拖动时的列表刷新标识符
    private boolean dragRefresh;

    // 拖动锁定标记，为false时选中块可被拖动
    private boolean dragLock = true;

    // 动画列表，存放当前屏幕上正在播放的所有滑动动画的动画对象
    private ArrayList<Animator> animatorList;

    // 视图列表，存放当前屏幕上正在播放的所有滑动动画的视图对象
    private ArrayList<View> dragViews;


    /**
     * 可监听接口
     */
    // 拖动块视图对象生成器，可通过设置该接口自定义一个拖动视图的样式，不设置时会有默认实现
    private DragViewCreator dragViewCreator;

    // 拖动监听接口，拖动开始和结束时会在该接口回调
    private OnDragingListener dragingListener;

    // 当前拖动目标位置改变时，每次改变都会在该接口回调
    private OnDragTargetChangedListener targetChangedListener;


    // 内部接口，动画观察者，滑动动画结束是回调
    private AnimatorObserver animatorObserver;

    private Handler handler = new Handler();

    // 列表自动滚动线程
    private Runnable scrollRunnable = new Runnable() {
        @Override
        public void run() {
            int scrollY;

            // 滚动到顶或到底时停止滚动
            if (getFirstVisiblePosition() == 0 || getLastVisiblePosition() == getCount() - 1) {
                handler.removeCallbacks(scrollRunnable);
            }

            // 触控点y坐标超过上边界时，出发列表自动向下滚动
            if (lastY > upScrollBorder) {
                scrollY = scrollSpeed;
                handler.postDelayed(scrollRunnable, 25);
            }
            // 触控点y坐标超过下边界时，出发列表自动向上滚动
            else if (lastY < downScrollBorder) {
                scrollY = -scrollSpeed;
                handler.postDelayed(scrollRunnable, 25);
            }
            // // 触控点y坐标处于上下边界之间时，停止滚动
            else {
                scrollY = 0;
                handler.removeCallbacks(scrollRunnable);
            }

            smoothScrollBy(scrollY, 10);
        }
    };

    public DragListView(Context context) {
        super(context);
        init(context);
    }

    public DragListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DragListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     * 初始化方法
     *
     * @param context
     */
    private void init(Context context) {
        this.context = context;
        statusHeight = getStatusHeight();
        windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        animatorList = new ArrayList<>();
        dragViews = new ArrayList<>();

        // 拖动块视图对象生成器的默认实现，返回一个与被拖动项外观一致的ImageView
        dragViewCreator = new DragViewCreator() {
            @Override
            public View createDragView(int width, int height, Bitmap viewCache) {
                ImageView imageView = new ImageView(DragListView.this.context);
                imageView.setImageBitmap(viewCache);

                return imageView;
            }
        };
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:

                downScrollBorder = getHeight() / 5;
                upScrollBorder = getHeight() * 4 / 5;

                // 手指按下时记录相关坐标
                lastX = (int) motionEvent.getX();
                lastY = (int) motionEvent.getY();
                lastRawX = (int) motionEvent.getRawX();
                lastRawY = (int) motionEvent.getRawY();

                currentPosition = pointToPosition(lastRawX, lastRawY);

                if (currentPosition == AdapterView.INVALID_POSITION || !adapter.isDragAvailable(currentPosition)) {
                    return true;
                }

                originalPosition = currentPosition;

                break;
        }

        return super.dispatchTouchEvent(motionEvent);
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_MOVE:

                if (!dragLock) {
                    int currentRawX = (int) motionEvent.getRawX();
                    int currentRawY = (int) motionEvent.getRawY();

                    if (dragView == null) {
                        createDragImageView(getChildAt(pointToPosition(lastRawX, lastRawY) - getFirstVisiblePosition()));

                        getChildAt(originalPosition - getFirstVisiblePosition()).setVisibility(View.INVISIBLE);

                        if (dragingListener != null) {
                            dragingListener.onStart(originalPosition);
                        }
                    }
                    drag(currentRawY - lastRawY);
                    if (dragingListener != null) {
                        dragingListener.onDraging((int) motionEvent.getX(), (int) motionEvent.getY(), currentRawX, currentRawY);
                    }

                    int position = pointToPosition(dragCenterX, dragCenterY);

                    // 满足交换条件时让目标位置的原有视图上滑或下滑
                    if (position != AdapterView.INVALID_POSITION && currentPosition != position && adapter.isDragAvailable(position)) {
                        translation(position, currentPosition);
                        currentPosition = position;

                        if (targetChangedListener != null) {
                            targetChangedListener.onTargetChanged(currentPosition);
                        }
                    }

                    // 更新点击位置
                    lastX = (int) motionEvent.getX();
                    lastY = (int) motionEvent.getY();
                    lastRawX = currentRawX;
                    lastRawY = currentRawY;

                    // 返回true消耗掉这次点击事件，防止ListView本身接收到这次点击事件后触发滚动
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
                // 手指抬起时，如果所有滑动动画都已播放完毕，则直接执行拖动完成逻辑
                if (animatorList.size() == 0) {
                    resetDataAndView();
                    if (dragingListener != null) {
                        dragingListener.onFinish(currentPosition);
                    }
                }
                // 如果还有未播放完成的滑动动画，则注册观察者，延时执行拖动完成逻辑
                else {
                    animatorObserver = new AnimatorObserver() {
                        @Override
                        public void onAllAnimatorFinish() {
                            resetDataAndView();
                            if (dragingListener != null) {
                                dragingListener.onFinish(currentPosition);
                            }
                        }
                    };
                }
                break;
        }

        return super.onTouchEvent(motionEvent);
    }

    /**
     * 创建拖动块视图方法
     *
     * @param view 被拖动位置的视图对象
     */
    private void createDragImageView(View view) {

        if (view == null) {
            return;
        }

        removeDragImageView();
        int[] location = new int[2];

        view.getLocationOnScreen(location);
        view.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();

        windowLayoutParams = new WindowManager.LayoutParams();
        windowLayoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        windowLayoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        windowLayoutParams.format = PixelFormat.TRANSPARENT;
        windowLayoutParams.gravity = Gravity.TOP | Gravity.LEFT;
        windowLayoutParams.x = location[0];
        windowLayoutParams.y = location[1] - statusHeight;
        windowLayoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;

        dragCenterX = windowLayoutParams.x + view.getWidth() / 2;
        dragCenterY = windowLayoutParams.y + view.getHeight() / 2;

        dragView = dragViewCreator.createDragView(view.getWidth(), view.getHeight(), bitmap);

        if (dragView == null) {
            throw new NullPointerException("dragView can not be null");
        } else {
            windowManager.addView(dragView, windowLayoutParams);
        }
    }

    /**
     * 移除拖动视图方法
     */
    private void removeDragImageView() {
        if (dragView != null && windowManager != null) {
            windowManager.removeView(dragView);
            dragView = null;
            windowLayoutParams = null;
        }
    }

    /**
     * 拖动方法
     *
     * @param dy
     */
    private void drag(int dy) {
        dragCenterY += dy;
        windowLayoutParams.y += dy;
        windowManager.updateViewLayout(dragView, windowLayoutParams);

        handler.post(scrollRunnable);
    }

    /**
     * 移动指定位置视图方法
     *
     * @param fromPosition 移动起始位置
     * @param toPosition   移动目标位置
     */
    private void translation(int fromPosition, int toPosition) {

        View fromView = getChildAt(fromPosition - getFirstVisiblePosition());
        View toView = getChildAt(toPosition - getFirstVisiblePosition());

        if (fromView == null || toView == null) {
            return;
        }

        float distance = (toView.getY() - toView.getTranslationY()) - (fromView.getY() - fromView.getTranslationY());

        ObjectAnimator animator = ObjectAnimator.ofFloat(fromView, "translationY", 0, distance);
        animator.setDuration(duration);
        animator.setInterpolator(getAnimatorInterpolator());
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                animatorList.remove(animation);
                // 所有滑动动画都播放结束时，执行相关操作
                if (animatorList.size() == 0) {
                    // 重置所有滑动过的视图的translateY，避免列表刷新后视图重叠
                    resetTranslate(dragViews);
                    dragViews.clear();
                    adapter.exchangeData(originalPosition, currentPosition);
                    addOnLayoutChangeListener(new OnLayoutChangeListener() {
                        @Override
                        public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                            if (dragRefresh) {
                                removeOnLayoutChangeListener(this);
                                resetChildVisibility();
                                getChildAt(currentPosition - getFirstVisiblePosition()).setVisibility(View.INVISIBLE);
                                originalPosition = currentPosition;
                                dragRefresh = false;

                                if (animatorObserver != null) {
                                    animatorObserver.onAllAnimatorFinish();
                                    animatorObserver = null;
                                }
                            }
                        }
                    });
                    dragRefresh = true;
                    adapter.notifyDataSetChanged();
                }
            }
        });

        animatorList.add(animator);
        dragViews.add(fromView);
        animator.start();
    }

    /**
     * 重置列表所有项的可见性方法
     */
    private void resetChildVisibility() {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child != null) {
                child.setVisibility(VISIBLE);
            }
        }
    }

    /**
     * 重置指定视图的translateY属性方法
     *
     * @param list
     */
    private void resetTranslate(ArrayList<View> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                list.get(i).setTranslationY(0);
            }
        }
    }

    /**
     * 重置数据和视图相关数据方法
     */
    private void resetDataAndView() {
        if (currentPosition == -1) {
            return;
        }
        getChildAt(currentPosition - getFirstVisiblePosition()).setVisibility(View.VISIBLE);
        originalPosition = -1;
        currentPosition = -1;
        handler.removeCallbacks(scrollRunnable);
        removeDragImageView();
    }

    @Override
    public void setAdapter(ListAdapter adapter) {
        if (adapter instanceof BaseDragAdapter) {
            this.adapter = (BaseDragAdapter) adapter;
            super.setAdapter(adapter);
        } else {
            throw new IllegalStateException("the adapter must extends BaseDragAdapter");
        }
    }

    /**
     * 根据速度模板创建动画迭代器
     *
     * @return
     */
    private TimeInterpolator getAnimatorInterpolator() {
        switch (speedMode) {
            case MODE_LINEAR:
                return new LinearInterpolator();
            case MODE_ACCELERATE:
                return new AccelerateInterpolator();
            case MODE_DECELERATE:
                return new DecelerateInterpolator();
            case MODE_ACCELERATE_DECELERATE:
                return new AccelerateDecelerateInterpolator();
            default:
                return null;
        }
    }

    /**
     * 拖动解锁方法，调用者需手动调用该方法后才能开启列表拖动功能
     */
    public void unlockDrag() {
        dragLock = false;
    }

    /**
     * 拖动锁定方法，调用者调用该方法后关闭列表拖动功能
     */
    public void lockDrag() {
        dragLock = true;
    }

    /**
     * 设置移动动画持续时间
     *
     * @param duration 时间，单位毫秒
     */
    public void setDuration(long duration) {
        this.duration = duration;
    }

    /**
     * 设置速度模式，可选项：
     * MODE_LINEAR                线性变化模式
     * MODE_ACCELERATE            加速模式
     * MODE_DECELERATE            减速模式
     * MODE_ACCELERATE_DECELERATE 先加速后加速模式
     *
     * @param speedMode
     */
    public void setSpeedMode(int speedMode) {
        this.speedMode = speedMode;
    }

    /**
     * 设置自动滚动速度
     *
     * @param scrollSpeed 速度，单位：dp/10ms
     */
    public void setScrollSpeed(int scrollSpeed) {
        this.scrollSpeed = scrollSpeed;
    }

    /**
     * 设置拖动块视图对象生成器方法
     *
     * @param creator
     */
    public void setDragViewCreator(DragViewCreator creator) {
        if (creator == null) {
            return;
        }

        this.dragViewCreator = creator;
    }

    /**
     * 设置拖动监听接口
     *
     * @param dragingListener
     */
    public void setOnDragingListener(OnDragingListener dragingListener) {
        this.dragingListener = dragingListener;
    }

    /**
     * 设置拖动目标位置改变监听接口
     *
     * @param targetChangedListener
     */
    public void setOnDragTargetChangedListener(OnDragTargetChangedListener targetChangedListener) {
        this.targetChangedListener = targetChangedListener;
    }

    private int getStatusHeight() {
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            return context.getResources().getDimensionPixelSize(resourceId);
        }

        return 0;
    }

    /**
     * 动画观察者
     */
    private interface AnimatorObserver {

        /**
         * 滑动动画播放结束时回调
         */
        void onAllAnimatorFinish();

    }

    /**
     * 拖动块视图对象生成器
     */
    public interface DragViewCreator {

        /**
         * 创建拖动块视图对象方法，可通过实现该方法自定义拖动块样式
         */
        View createDragView(int width, int height, Bitmap viewCache);

    }

    /**
     * 拖动监听接口
     */
    public interface OnDragingListener {

        /**
         * 拖动开始时回调
         *
         * @param startPosition 拖动起始坐标
         */
        void onStart(int startPosition);

        /**
         * 拖动过程中回调
         *
         * @param x    触控点相对ListView的x坐标
         * @param y    触控点相对ListView的y坐标
         * @param rawX 触控点相对屏幕的x坐标
         * @param rawY 触控点相对屏幕的y坐标
         */
        void onDraging(int x, int y, int rawX, int rawY);

        /**
         * 拖动结束时回调
         *
         * @param finalPosition 拖动终点坐标
         */
        void onFinish(int finalPosition);

    }

    /**
     * 拖动目标位置改变监听接口
     */
    public interface OnDragTargetChangedListener {

        /**
         * 拖动过程中，每次目标位置改变，会在该方法回调
         *
         * @param targetPosition 拖动目标位置坐标
         */
        void onTargetChanged(int targetPosition);

    }
}