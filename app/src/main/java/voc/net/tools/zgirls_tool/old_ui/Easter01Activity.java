package voc.net.tools.zgirls_tool.old_ui;

import android.animation.ObjectAnimator;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import voc.net.tools.zgirls_tool.R;
import voc.net.tools.zgirls_tool.util.ScreenSizeUtils;

public class Easter01Activity extends AppCompatActivity {
    private static final int MX = FrameLayout.LayoutParams.MATCH_PARENT;
    private static final int MY = FrameLayout.LayoutParams.MATCH_PARENT;
    private View decorView;
    Drawable platlogo;
    final static int[] FLAVORS = {//棒棒糖中圓的顏色
            Color.parseColor("#F25E95"),
            Color.parseColor("#CC3D72"),
            // 0xFFFF9800, 0xFFFFB74D, // orange
            //            0xFFF06292, 0xFFF8BBD0, // bubblegum
            //            0xFFAFB42B, 0xFFCDDC39, // lime
            //            0xFFFFEB3B, 0xFFFFF176, // lemon
             //          0xFF795548, 0xFFA1887F // mystery flavor
            //
            //            0xFFC5FCB4, 0xFFC5FCD4, //#C5FCD4
            //            0xFFA364B8, 0xFFA364D8, //A364D8
            //            0xFFE49214, 0xFFE49234,  //E49234
            //            0xFFD11A86, 0xFFD11AA6,  //D11AA6
            //            0xFF2A04C2, 0xFF2A04E2,  //2A04E2


    };
    FrameLayout mLayout;
    int mTapCount;
    public static final String EGG_MODE = "egg_mode";
    int mKeyCount;
    private Easter01Activity mActivity;
    PathInterpolator mInterpolator = new PathInterpolator(0f, 0f, 0.5f, 1f);


    static int newColorIndex() {
        return 2*((int) (Math.random()*FLAVORS.length/2));
    }


    Drawable makeRipple() {
        final int idx = newColorIndex();
        final ShapeDrawable popbg = new ShapeDrawable(new OvalShape());
        popbg.getPaint().setColor(FLAVORS[idx]);
        final RippleDrawable ripple = new RippleDrawable(
                ColorStateList.valueOf(FLAVORS[idx+1]),
                popbg, null);
        return ripple;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easter01);
        mLayout = new FrameLayout ( this );
        mActivity = this;
        setContentView ( mLayout );

        String fileName = "background.png";
        Resources res = getResources();
        String pathName = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/background/" + fileName;
        Bitmap bitmap = BitmapFactory.decodeFile(pathName);
        BitmapDrawable bd = new BitmapDrawable(res, bitmap);
       //ImageView img = findViewById(R.id.easter_bg);
       // img.setBackground(bd);
        final ImageView im2 = new ImageView(this);
        im2.setImageDrawable(bd);
        im2.setBackgroundColor(Color.parseColor("#CC313131"));
        im2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int width = (int) (ScreenSizeUtils.getInstance(this).getScreenWidth());
        int height = (int) (ScreenSizeUtils.getInstance(this).getScreenHeight());
        mLayout.addView(im2, new FrameLayout.LayoutParams(MX , MY));
      //  mLayout.setBackground(bd);
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener(){
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if (visibility == 0)
                    decorView.setSystemUiVisibility(hideSystemBars());

            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }
    private int hideSystemBars(){
        return //View.SYSTEM_UI_FLAG_LAYOUT_STABLE|
                //    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|
                        // View.SYSTEM_UI_FLAG_FULLSCREEN|
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
    }
    @Override
    public void onAttachedToWindow() {
        final DisplayMetrics dm = getResources().getDisplayMetrics();
        final float dp = dm.density;
        final int size = (int)
                (Math.min(Math.min(dm.widthPixels, dm.heightPixels), 600*dp) - 100*dp);


        final View stick = new View(this) {
            Paint mPaint = new Paint();
            Path mShadow = new Path();


            @Override
            public void onAttachedToWindow() {
                super.onAttachedToWindow();
                setWillNotDraw(false);
                setOutlineProvider(new ViewOutlineProvider() {
                    @Override
                    public void getOutline(View view, Outline outline) {
                        outline.setRect(0, getHeight() / 2, getWidth(), getHeight());
                    }
                });
            }
            @Override
            public void onDraw(Canvas c) {
                final int w = c.getWidth();
                final int h = c.getHeight() / 2;
                c.translate(0, h);
                final GradientDrawable g = new GradientDrawable();
                g.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                g.setGradientCenter(w * 0.75f, 0);
                g.setColors(new int[] { Color.parseColor("#1BB495"), Color.parseColor("#3F9D94"), });
                g.setBounds(0, 0, w, h);
                g.draw(c);
                mPaint.setColor(Color.parseColor("#2FBC57"));
                mShadow.reset();
                mShadow.moveTo(0,0);
                mShadow.lineTo(w, 0);
                mShadow.lineTo(w, size/2 + 1.5f*w);
                mShadow.lineTo(0, size/2);
                mShadow.close();
                c.drawPath(mShadow, mPaint);
            }
        };
        mLayout.addView(stick, new FrameLayout.LayoutParams((int) (32 * dp),
                ViewGroup.LayoutParams.MATCH_PARENT, Gravity.CENTER_HORIZONTAL));
        stick.setAlpha(0f);


        final ImageView im = new ImageView(this);
        im.setTranslationZ(20);
        im.setScaleX(0);
        im.setScaleY(0);
        platlogo = getDrawable(R.drawable.app_icon_round);
        platlogo.setAlpha(0);
        im.setImageDrawable(platlogo);
        im.setBackground(makeRipple());
        im.setClickable(true);
        final ShapeDrawable highlight = new ShapeDrawable(new OvalShape());
        highlight.getPaint().setColor(0x10FFFFFF);
        highlight.setBounds((int)(size*.15f), (int)(size*.15f),
                (int)(size*.6f), (int)(size*.6f));
        im.getOverlay().add(highlight);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTapCount == 0) {
                    im.animate()
                            .translationZ(40)
                            .scaleX(1)
                            .scaleY(1)
                            .setInterpolator(mInterpolator)
                            .setDuration(700)
                            .setStartDelay(500)
                            .start();


                    final ObjectAnimator a = ObjectAnimator.ofInt(platlogo, "alpha", 0, 255);
                    a.setInterpolator(mInterpolator);
                    a.setStartDelay(1000);
                    a.start();


                    stick.animate()
                            .translationZ(20)
                            .alpha(1)
                            .setInterpolator(mInterpolator)
                            .setDuration(700)
                            .setStartDelay(750)
                            .start();


                    im.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            if (mTapCount < 5) return false;//點選次數要大於等於5,之後長按才能進入遊戲
                            final ContentResolver cr = getContentResolver();
                            if (Settings.System.getLong(cr, EGG_MODE, 0)
                                    == 0) {
                                // For posterity: the moment this user unlocked the easter egg
                                Settings.System.putLong(cr,
                                        EGG_MODE,
                                        System.currentTimeMillis());
                            }
                            im.post(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        platlogo = getDrawable(R.drawable.app_icon_round);
                                        im.setImageDrawable(platlogo);
                                        Toast.makeText(Easter01Activity.this, "@1006 孤魂 色批你好，色批再见", Toast.LENGTH_LONG).show();
                                        //Toast.makeText(Easter01Activity.this, "No more hentai idea for you .", Toast.LENGTH_SHORT).show();
                                    } catch (ActivityNotFoundException ex) {
                                        Log.e("PlatLogoActivity", "No more eggs.");
                                    }
                                }
                            });
                            return true;
                        }
                    });
                }
                else {
                    im.setBackground(makeRipple());
                }
                mTapCount++;
            }
        });


        // Enable hardware keyboard input for TV compatibility.
        im.setFocusable(true);
        im.requestFocus();
        im.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode != KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
                    ++mKeyCount;
                    if (mKeyCount > 2) {
                        if (mTapCount > 5) {
                            im.performLongClick();
                        } else {
                            im.performClick();
                        }
                    }
                    return true;
                } else {
                    return false;
                }
            }
        });


        mLayout.addView(im, new FrameLayout.LayoutParams(size, size, Gravity.CENTER));


        im.animate().scaleX(0.3f).scaleY(0.3f)
                .setInterpolator(mInterpolator)
                .setDuration(500)
                .setStartDelay(800)
                .start();
    }
    private static final int GOTO_MAIN_ACTIVITY = 0;
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {

            switch (msg.what) {
                case GOTO_MAIN_ACTIVITY:
                    finish();
                    break;

                default:
                    break;
            }
        }

    };
}
