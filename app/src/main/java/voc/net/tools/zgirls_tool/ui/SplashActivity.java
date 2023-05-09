package voc.net.tools.zgirls_tool.ui;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.BuildConfig;
import voc.net.tools.zgirls_tool.R;

public class SplashActivity extends AppCompatActivity {
    private static final String TAG = "SplashActivity";
    int time = 3000 ;
    TextView ver;
    private View decorView ;
    ImageView icon ;
    private static final int PERMISSION_REQUEST_FINE_LOCATION = 1;
    private static final int PERMISSION_REQUEST_BACKGROUND_LOCATION = 2;
    public static final String CHANNEL_ID = "ZGT_UPDATE";
    public static final int REQUEST_CODE_DAY1 = 1;
    public static final int REQUEST_CODE_DAY2 = 2;
    public static final int REQUEST_CODE_DAY3 = 3;
    public static final int REQUEST_CODE_DAY4 = 4;
    public static final int REQUEST_CODE_DAY5_7 = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        BackgroundReload();

        SharedPreferences sharedPreferences = getSharedPreferences("login_time", Context.MODE_PRIVATE);
        long login_time = sharedPreferences.getLong("login",0);
        //if (login_time == 0){importSH("user_info.xml",Environment.getExternalStorageDirectory().getPath () + "/voc/zgt/backup/");}
        login_time = login_time+1;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong("login",login_time);
        editor.apply();

        /**
         * Notification Of Day1
         *  Intent intent = new Intent(SplashActivity.this, Receiver.class);
         *         PendingIntent pendingIntent = PendingIntent.getBroadcast(SplashActivity.this, REQUEST_CODE_DAY1, intent, 0);
         *         AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
         *         am.setRepeating(am.RTC_WAKEUP, Long.parseLong("1621066821000"), 3 * 60 * 1000, pendingIntent);
         */


        String versionName = BuildConfig.VERSION_NAME;
        int versionCode = BuildConfig.VERSION_CODE;
        icon = findViewById(R.id.imageView4);
        Animation logoMoveAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        icon.startAnimation(logoMoveAnimation);
        ver = findViewById(R.id.version_tv);
        ver.setText(versionName);
        Log.i("Permission", "abled");

        int permission = ContextCompat.checkSelfPermission(SplashActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            makeRequest();
        }else {mHandler.sendEmptyMessageDelayed(GOTO_MAIN_ACTIVITY, 2500);}

      //  videoView.start();
        //mHandler.sendEmptyMessageDelayed(GOTO_MAIN_ACTIVITY, 2500); //3秒跳轉
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener(){
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if (visibility == 0)
                    decorView.setSystemUiVisibility(hideSystemBars());

            }
        });
    }
        private static final int GOTO_MAIN_ACTIVITY = 0;
        private Handler mHandler = new Handler() {
            public void handleMessage(android.os.Message msg) {

                switch (msg.what) {
                    case GOTO_MAIN_ACTIVITY:
                        Intent intent = new Intent();
                        //將原本Activity的換成MainActivity
                        intent.setClass(SplashActivity.this, DeskActivity.class);
                        startActivity(intent);
                        finish();
                        break;

                    default:
                        break;
                }
            }

        };

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
                        View.SYSTEM_UI_FLAG_FULLSCREEN|
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
    }


    protected void makeRequest() {
        ActivityCompat.requestPermissions(this,
                new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                500);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 500: {
                if (grantResults.length == 0
                        || grantResults[0] !=
                        PackageManager.PERMISSION_GRANTED) {
                    Log.i("1", "Permission has been denied by user");
                } else {
                    Log.i("1", "Permission has been granted by user");
                    mHandler.sendEmptyMessageDelayed(GOTO_MAIN_ACTIVITY, 2500); //3秒跳轉
                }
                return;
            }
        }
    }
    public void BackgroundReload (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.splash_bg);

        Resources res = getResources();
        String fileNamePNG = "background.png";
        String fileNameGIF = "background.gif";
        String fileNameJPG = "background.jpg";
        String pathName = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/background/";

        Bitmap bitmap = BitmapFactory.decodeFile(pathName+fileNamePNG);
        BitmapDrawable bd = new BitmapDrawable(res, bitmap);

        Bitmap bitmap2 = BitmapFactory.decodeFile(pathName+fileNameJPG);
        BitmapDrawable bd2 = new BitmapDrawable(res, bitmap2);

        File gifFile = new File(pathName,fileNameGIF);
        GifDrawable gifFromFile = null;
        try { gifFromFile = new GifDrawable(gifFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (gif_png.matches("gif")){gifImageView1.setImageDrawable(gifFromFile);}
        if (gif_png.matches("png")){gifImageView1.setImageDrawable(bd);}
        if (gif_png.matches("jpg")){gifImageView1.setImageDrawable(bd2);}
    }

    @Override
    protected void onResume() {
        super.onResume();
        BackgroundReload();
        //把保存的資料拿回來使用
    }
    @Override
    protected void onPause() {
        super.onPause();
        BackgroundReload();

        //時把需要保存的資料保存
    }
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "Example Service Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);
        }
    }
    private void importSH(String sh_name, String location){


        File sd = new File(Environment.getExternalStorageDirectory().
                getAbsolutePath() +location);


        File data = Environment.getDataDirectory();
        FileChannel source=null;
        FileChannel destination=null;
        String currentDBPath = "/data/"+ SplashActivity.this.getPackageName() +"/shared_prefs/"+ sh_name;
        String backupDBPath = sh_name;
        File currentDB = new File(sd, backupDBPath);
        File backupDB = new File(data, currentDBPath);



        try {
            source = new FileInputStream(currentDB).getChannel();
            destination = new FileOutputStream(backupDB).getChannel();

            destination.transferFrom(source, 0, source.size());
            source.close();
            destination.close();

            // Toast.makeText(this, "App need to exit to load new setting", Toast.LENGTH_SHORT).show(); //will not show when rebooting. Not sure how to fix it.
            SharedPreferences shared = getSharedPreferences("user_info", Context.MODE_PRIVATE);
            String value =shared.getString("Demo List",null);
            if (value != null) {

                shared.edit().remove("Demo List").commit(); //remove the item created by dummy SharedPreferences, as mention.
            }

            //restartin app to original activity.
            Intent mStartActivity = new Intent(SplashActivity.this, SplashActivity.class);
            int mPendingIntentId = 123456;
            PendingIntent mPendingIntent = PendingIntent.getActivity(SplashActivity.this, mPendingIntentId,    mStartActivity, PendingIntent.FLAG_CANCEL_CURRENT);
            AlarmManager mgr = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
            mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mPendingIntent);
            System.exit(0);

        } catch(IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }

    }
}

