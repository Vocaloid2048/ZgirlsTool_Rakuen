package voc.net.tools.zgirls_tool.ui;

 /**
 * Package voc.net.games.virtualworld was
 * Created by Voc-夜芷冰 , Programmer of Xectorda
 * Copyright © 2020 Xectorda 版權所有
 */

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import voc.net.tools.zgirls_tool.R;

public class LogoActivity extends AppCompatActivity {

    private int WRITE_EXTERNAL_STORAGE = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        YoYo.with(Techniques.SlideInUp)
                .duration(2500)
                .repeat(0)
                .playOn(findViewById(R.id.xectdora_tv));

        makeRequest();

    }

    protected void makeRequest() {
        int permission = ContextCompat.checkSelfPermission(LogoActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    1);
        } else {mHandler.sendEmptyMessageDelayed(GOTO_MAIN_ACTIVITY, 2500);}

    }

    private static final int GOTO_MAIN_ACTIVITY = 0;
    private static final int DOWNLOAD_TASK_ACTIVITY = 1;
    private static final int DOWNLOAD2_TASK_ACTIVITY = 2;
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {

            switch (msg.what) {
                case GOTO_MAIN_ACTIVITY:
                    Intent intent = new Intent();
                    intent.setClass(LogoActivity.this, SplashActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                default:
                    break;
            }
        }

    };

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    makeRequest();
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {
                    mHandler.sendEmptyMessageDelayed(GOTO_MAIN_ACTIVITY, 2500);
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}