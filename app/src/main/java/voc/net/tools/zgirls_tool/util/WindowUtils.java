package voc.net.tools.zgirls_tool.util;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import voc.net.tools.zgirls_tool.R;

/**
 * Created by LiuKuo at 2018/4/25
 */

public class WindowUtils {
    private static final String LOG_TAG = "WindowUtils";
    private static View mView  , mView2= null;
    private static WindowManager mWindowManager ,mWindowManager2= null;
    private static Context mContext = null;

    public static Boolean isShown = false;
    public static Boolean V1isShown = false;
    public static WindowManager.LayoutParams layoutParams;
    public static final int PRIMARY_FOREGROUND_NOTIF_SERVICE_ID = 719;
    public static ListView listView;
    public static ArrayAdapter<String> adapter;
    public static ArrayList<String> arrayList;
    public static int X;
    public static int Y;

    /**
     * 显示弹出框
     *
     * @param context
     */
    public static void showPopupWindow(final Context context) {
        layoutParams = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else {
            layoutParams.type = WindowManager.LayoutParams.TYPE_PHONE;
        }
        layoutParams.format = PixelFormat.RGBA_8888;
        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        layoutParams.width = 250;
        layoutParams.height = 250;
        if (isShown) {
            return;
        }
        isShown = true;

        // 获取应用的Context
        mContext = context.getApplicationContext();
        // 获取WindowManager
        mWindowManager = (WindowManager) mContext
                .getSystemService(Context.WINDOW_SERVICE);

        mWindowManager2 = (WindowManager) mContext
                .getSystemService(Context.WINDOW_SERVICE);

        mView = setUpView(context);
      //  mView2 = setUpView2(context);

        final WindowManager.LayoutParams params = new WindowManager.LayoutParams();

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N && Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            params.type = WindowManager.LayoutParams.TYPE_PHONE;
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            params.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else{
X = params.x;
Y = params.y;
            params.type = WindowManager.LayoutParams.TYPE_TOAST;
        }

        // 设置flag

        int flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        // | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        // 如果设置了WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE，弹出的View收不到Back键的事件
        params.flags = flags;
        // 不设置这个弹出框的透明遮罩显示为黑色
        params.format = PixelFormat.TRANSLUCENT;
        // FLAG_NOT_TOUCH_MODAL不阻塞事件传递到后面的窗口
        // 设置 FLAG_NOT_FOCUSABLE 悬浮窗口较小时，后面的应用图标由不可长按变为可长按
        // 不设置这个flag的话，home页的划屏会有问题

        params.width = 250;
        params.height = 250;

        mWindowManager.addView(mView, params);



    }

    private static View setUpView(final Context context) {

        View view;
        view = LayoutInflater.from(context).inflate(R.layout.window_view, null);
        Button btn = view.findViewById(R.id.ic_btn);
        btn.setOnTouchListener(new FloatingOnTouchListener() {});
        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mWindowManager.removeView(mView);
                isShown = false;
                Toast.makeText(context, "BYE", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final WindowManager.LayoutParams params2 = new WindowManager.LayoutParams();
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N && Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
                    params2.type = WindowManager.LayoutParams.TYPE_PHONE;
                } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    params2.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
                } else{

                    params2.type = WindowManager.LayoutParams.TYPE_TOAST;
                }
                // 设置flag

                int flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
                // | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
                // 如果设置了WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE，弹出的View收不到Back键的事件
                params2.flags = flags;
                // 不设置这个弹出框的透明遮罩显示为黑色
                params2.format = PixelFormat.TRANSLUCENT;
                // FLAG_NOT_TOUCH_MODAL不阻塞事件传递到后面的窗口
                // 设置 FLAG_NOT_FOCUSABLE 悬浮窗口较小时，后面的应用图标由不可长按变为可长按
                // 不设置这个flag的话，home页的划屏会有问题

                params2.width = 800;
                params2.height = 1200;
                params2.gravity = Gravity.LEFT;
        }});
        return view;

    }//private static View setUpView2(final Context context) {
        //View view2;
       // view2 = LayoutInflater.from(context).inflate(R.layout.activity_kizuna, null);


        /*adapter.clear();
        adapter.add("Easter Egg : 0719");
        adapter.add("Happy Birthday");
        adapter.add("To me");
        adapter.add("xd");
        adapter.add("BTW");
        adapter.add("Thanks everyone");
        adapter.add("I'm glad about it !");
        adapter.add("Wish Corona pass soon");
        adapter.add("Wars never appear again");
        adapter.add("Guys walk back to their normal life");
        adapter.add("Hope you be great everyday");
        */
      //  return view2;
   // }

    /**
     * 隐藏弹出框
     */
    public static void hidePopupWindow() {
        if (isShown && null != mView) {
            mWindowManager.removeView(mView);
            isShown = false;
        }
        if (isShown && null != mView2) {
            mWindowManager.removeView(mView2);
            isShown = false;
        }

    }
    private static class FloatingOnTouchListener implements View.OnTouchListener {
        private int x;
        private int y;

        @Override
        public boolean onTouch(View view, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    x = (int) event.getRawX();
                    y = (int) event.getRawY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    int nowX = (int) event.getRawX();
                    int nowY = (int) event.getRawY();
                    int movedX = nowX - x;
                    int movedY = nowY - y;
                    x = nowX;
                    y = nowY;
                    layoutParams.x = layoutParams.x + movedX;
                    layoutParams.y = layoutParams.y + movedY;
                    mWindowManager.updateViewLayout(view, layoutParams);
                    break;
                default:
                    break;
            }
            return false;
        }
    }
}