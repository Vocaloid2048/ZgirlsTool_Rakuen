package voc.net.tools.zgirls_tool.ui;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import org.apache.http.util.EncodingUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;

import voc.net.tools.zgirls_tool.R;
import voc.net.tools.zgirls_tool.util.HttpHandler;

public class DataTroopActivity extends AppCompatActivity {

    CardView  troop_card ;
    TextView troop_tv;
    TextView troop_total;

    TextView	arm01	,	arm02	,	arm03	,	arm04	,	arm05	,	arm06	,	arm07	,	arm08	,	arm09	,	arm10	;
    TextView	mili01	,	mili02	,	mili03	,	mili04	,	mili05	,	mili06	,	mili07	,	mili08	,	mili09	,	mili10	;
    TextView	mobile01	,	mobile02	,	mobile03	,	mobile04	,	mobile05	,	mobile06	,	mobile07	,	mobile08	,	mobile09	,	mobile10	;
    TextView	infect01	,	infect02	,	infect03	,	infect04	,	infect05	,	infect06	,	infect07	,	infect08	,	infect09	,	infect10	;
    TextView	project01	,	project02	,	project03	,	project04	,	project05	,	project06	,	project07	,	project08	,	project09	,	project10	;

    ImageView arm01_img	,	arm02_img	,	arm03_img	,	arm04_img	,	arm05_img	,	arm06_img	,	arm07_img	,	arm08_img	,	arm09_img	,	arm10_img	;
    ImageView	mili01_img	,	mili02_img	,	mili03_img	,	mili04_img	,	mili05_img	,	mili06_img	,	mili07_img	,	mili08_img	,	mili09_img	,	mili10_img	;
    ImageView	mobile01_img	,	mobile02_img	,	mobile03_img	,	mobile04_img	,	mobile05_img	,	mobile06_img	,	mobile07_img	,	mobile08_img	,	mobile09_img	,	mobile10_img	;
    ImageView	infect01_img	,	infect02_img	,	infect03_img	,	infect04_img	,	infect05_img	,	infect06_img	,	infect07_img	,	infect08_img	,	infect09_img	,	infect10_img	;
    ImageView	project01_img	,	project02_img	,	project03_img	,	project04_img	,	project05_img	,	project06_img	,	project07_img	,	project08_img	,	project09_img	,	project10_img	;

    ImageView	enabler_img_01,	enabler_img_02,	enabler_img_03,	enabler_img_04,	enabler_img_05;
    private View decorView;
    String DataBasePath = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/database/database.db";
    String DataBaseFile = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/database";
    int code_num = 0;
    // myDbAdapter helper;
    String DataBasePath2 = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/database";
    String path_test , path_final ;
    long uid ;
    String downloadpath ;
    private static final int ERROR = 2;
    private static final int SHOW_UPDATE_DIALOG = 1;
    private final static String TAG = "DataTroopActivity";

    long UID;
    long UID2;
    String ppl ;
    private static final String fileName = "user_session";
    private static final String fileDir = Environment.getExternalStorageDirectory().getPath() +"/data/data/com.xingjoys.zgirls.app/config/";


    String armyName  ;
    long armyFreeNum , armyMarchNum ;

    String[] armyNameArray = new String[50];
    long[] armyFreeNumArray = new long[50];
    long[] armyMarchNumArray = new long[50];
    boolean sleep = false ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_troop);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                UID2 = 0;
            } else {
                UID2 = extras.getLong("UID");
            }
        } else {
            UID2 = (Long) savedInstanceState.getSerializable("UID");
        }
        getSavedLoginDataJson();
        new TakeData().execute();
       // pd = new ProgressDialog(DataTroopActivity.this);
       // pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
       // pd.setTitle(R.string.update_title);
        //pd.show();
       // mHandler.sendEmptyMessageDelayed(WAIT_REFRESH, 3000);
       // progress_pd();
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String color1 = sharedPreferences.getString("color1", "F1870F");
        String theme = sharedPreferences.getString("theme", "dark");
        // swipeRefreshLayout = findViewById(R.id.swipe_container);

        //   if (theme.equals("custom")) { swipeRefreshLayout.setColorSchemeColors(Color.parseColor("#"+color1)); }
        //  if (theme.equals("base")) { swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.	background_base	)); }
        //   if (theme.equals("dark")) { swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.	background_dark	)); }
        //  if (theme.equals("pink")) { swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.	background_pink	)); }
        //   if (theme.equals("leek")) { swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.	background_leek	)); }
        //   if (theme.equals("summer")) { swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.	background_summer	)); }
        init();
        // 建立SQLiteOpenHelper物件
        //METHOD END
        String fileName = "background.png";
        Resources res = getResources();
        String pathName = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/background/" + fileName;
        Bitmap bitmap = BitmapFactory.decodeFile(pathName);
        BitmapDrawable bd = new BitmapDrawable(res, bitmap);
        ImageView view = findViewById(R.id.data_troop_bg);
        view.setImageDrawable(bd);
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
                        View.SYSTEM_UI_FLAG_FULLSCREEN;
    }
    public void init (){
        troop_card = findViewById(R.id.troop_card);
        troop_tv = findViewById(R.id.troop);

        troop_total = findViewById(R.id.troop_total);

        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 4;
        options.inJustDecodeBounds = false;
        Bitmap 	bitmap01 	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.arm01, options);
        Bitmap 	bitmap02	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.mili01, options);
        Bitmap 	bitmap03	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.mobile01, options);
        Bitmap 	bitmap04	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.infect01, options);
        Bitmap 	bitmap05	=  BitmapFactory.decodeResource(getResources(), R.drawable.project01, options);
        Bitmap 	bitmap06	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.arm02, options);
        Bitmap 	bitmap07	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.mili02, options);
        Bitmap 	bitmap08	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.mobile02, options);
        Bitmap 	bitmap09	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.infect02, options);
        Bitmap 	bitmap10	=  BitmapFactory.decodeResource(getResources(), R.drawable.project02, options);
        Bitmap 	bitmap11	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.arm03, options);
        Bitmap 	bitmap12	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.mili03, options);
        Bitmap 	bitmap13	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.mobile03, options);
        Bitmap 	bitmap14	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.infect03, options);
        Bitmap 	bitmap15	=  BitmapFactory.decodeResource(getResources(), R.drawable.project03, options);
        Bitmap 	bitmap16	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.arm04, options);
        Bitmap 	bitmap17	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.mili04, options);
        Bitmap 	bitmap18	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.mobile04, options);
        Bitmap 	bitmap19	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.infect04, options);
        Bitmap 	bitmap20	=  BitmapFactory.decodeResource(getResources(), R.drawable.project04, options);
        Bitmap 	bitmap21	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.arm05, options);
        Bitmap 	bitmap22	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.mili05, options);
        Bitmap 	bitmap23	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.mobile05, options);
        Bitmap 	bitmap24	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.infect05, options);
        Bitmap 	bitmap25	=  BitmapFactory.decodeResource(getResources(), R.drawable.project05, options);
        Bitmap 	bitmap26	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.arm06, options);
        Bitmap 	bitmap27	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.mili06, options);
        Bitmap 	bitmap28	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.mobile06, options);
        Bitmap 	bitmap29	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.infect06, options);
        Bitmap 	bitmap30	=  BitmapFactory.decodeResource(getResources(), R.drawable.project06, options);
        Bitmap 	bitmap31	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.arm07, options);
        Bitmap 	bitmap32	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.mili07, options);
        Bitmap 	bitmap33	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.mobile07, options);
        Bitmap 	bitmap34	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.infect07, options);
        Bitmap 	bitmap35	=  BitmapFactory.decodeResource(getResources(), R.drawable.project07, options);
        Bitmap 	bitmap36	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.arm08, options);
        Bitmap 	bitmap37	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.mili08, options);
        Bitmap 	bitmap38	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.mobile08, options);
        Bitmap 	bitmap39	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.infect08, options);
        Bitmap 	bitmap40	=  BitmapFactory.decodeResource(getResources(), R.drawable.project08, options);
        Bitmap 	bitmap41	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.arm09, options);
        Bitmap 	bitmap42	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.mili09, options);
        Bitmap 	bitmap43	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.mobile09, options);
        Bitmap 	bitmap44	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.infect09, options);
        Bitmap 	bitmap45	=  BitmapFactory.decodeResource(getResources(), R.drawable.project09, options);
        Bitmap 	bitmap46	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.arm10, options);
        Bitmap 	bitmap47	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.mili10, options);
        Bitmap 	bitmap48	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.mobile10, options);
        Bitmap 	bitmap49	 =  BitmapFactory.decodeResource(getResources( ), R.drawable.infect10, options);
        Bitmap 	bitmap50	=  BitmapFactory.decodeResource(getResources(), R.drawable.project10, options);


        arm01_img	 = findViewById(R.id.	arm01_img	);
        mili01_img	 = findViewById(R.id.	mili01_img	);
        mobile01_img	 = findViewById(R.id.	mobile01_img	);
        infect01_img	 = findViewById(R.id.	infect01_img	);
        project01_img	 = findViewById(R.id.	project01_img	);
        arm02_img	 = findViewById(R.id.	arm02_img	);
        mili02_img	 = findViewById(R.id.	mili02_img	);
        mobile02_img	 = findViewById(R.id.	mobile02_img	);
        infect02_img	 = findViewById(R.id.	infect02_img	);
        project02_img	 = findViewById(R.id.	project02_img	);
        arm03_img	 = findViewById(R.id.	arm03_img	);
        mili03_img	 = findViewById(R.id.	mili03_img	);
        mobile03_img	 = findViewById(R.id.	mobile03_img	);
        infect03_img	 = findViewById(R.id.	infect03_img	);
        project03_img	 = findViewById(R.id.	project03_img	);
        arm04_img	 = findViewById(R.id.	arm04_img	);
        mili04_img	 = findViewById(R.id.	mili04_img	);
        mobile04_img	 = findViewById(R.id.	mobile04_img	);
        infect04_img	 = findViewById(R.id.	infect04_img	);
        project04_img	 = findViewById(R.id.	project04_img	);
        arm05_img	 = findViewById(R.id.	arm05_img	);
        mili05_img	 = findViewById(R.id.	mili05_img	);
        mobile05_img	 = findViewById(R.id.	mobile05_img	);
        infect05_img	 = findViewById(R.id.	infect05_img	);
        project05_img	 = findViewById(R.id.	project05_img	);
        arm06_img	 = findViewById(R.id.	arm06_img	);
        mili06_img	 = findViewById(R.id.	mili06_img	);
        mobile06_img	 = findViewById(R.id.	mobile06_img	);
        infect06_img	 = findViewById(R.id.	infect06_img	);
        project06_img	 = findViewById(R.id.	project06_img	);
        arm07_img	 = findViewById(R.id.	arm07_img	);
        mili07_img	 = findViewById(R.id.	mili07_img	);
        mobile07_img	 = findViewById(R.id.	mobile07_img	);
        infect07_img	 = findViewById(R.id.	infect07_img	);
        project07_img	 = findViewById(R.id.	project07_img	);
        arm08_img	 = findViewById(R.id.	arm08_img	);
        mili08_img	 = findViewById(R.id.	mili08_img	);
        mobile08_img	 = findViewById(R.id.	mobile08_img	);
        infect08_img	 = findViewById(R.id.	infect08_img	);
        project08_img	 = findViewById(R.id.	project08_img	);
        arm09_img	 = findViewById(R.id.	arm09_img	);
        mili09_img	 = findViewById(R.id.	mili09_img	);
        mobile09_img	 = findViewById(R.id.	mobile09_img	);
        infect09_img	 = findViewById(R.id.	infect09_img	);
        project09_img	 = findViewById(R.id.	project09_img	);
        arm10_img	 = findViewById(R.id.	arm10_img	);
        mili10_img	 = findViewById(R.id.	mili10_img	);
        mobile10_img	 = findViewById(R.id.	mobile10_img	);
        infect10_img	 = findViewById(R.id.	infect10_img	);
        project10_img	 = findViewById(R.id.	project10_img	);

        arm01_img	.setImageBitmap(bitmap01);
        mili01_img	.setImageBitmap(bitmap02);
        mobile01_img	.setImageBitmap(bitmap03);
        infect01_img	.setImageBitmap(bitmap04);
        project01_img	.setImageBitmap(bitmap05);
        arm02_img	.setImageBitmap(bitmap06);
        mili02_img	.setImageBitmap(bitmap07);
        mobile02_img	.setImageBitmap(bitmap08);
        infect02_img	.setImageBitmap(bitmap09);
        project02_img	.setImageBitmap(bitmap10);
        arm03_img	.setImageBitmap(bitmap11);
        mili03_img	.setImageBitmap(bitmap12);
        mobile03_img	.setImageBitmap(bitmap13);
        infect03_img	.setImageBitmap(bitmap14);
        project03_img	.setImageBitmap(bitmap15);
        arm04_img	.setImageBitmap(bitmap16);
        mili04_img	.setImageBitmap(bitmap17);
        mobile04_img	.setImageBitmap(bitmap18);
        infect04_img	.setImageBitmap(bitmap19);
        project04_img	.setImageBitmap(bitmap20);
        arm05_img	.setImageBitmap(bitmap21);
        mili05_img	.setImageBitmap(bitmap22);
        mobile05_img	.setImageBitmap(bitmap23);
        infect05_img	.setImageBitmap(bitmap24);
        project05_img	.setImageBitmap(bitmap25);
        arm06_img	.setImageBitmap(bitmap26);
        mili06_img	.setImageBitmap(bitmap27);
        mobile06_img	.setImageBitmap(bitmap28);
        infect06_img	.setImageBitmap(bitmap29);
        project06_img	.setImageBitmap(bitmap30);
        arm07_img	.setImageBitmap(bitmap31);
        mili07_img	.setImageBitmap(bitmap32);
        mobile07_img	.setImageBitmap(bitmap33);
        infect07_img	.setImageBitmap(bitmap34);
        project07_img	.setImageBitmap(bitmap35);
        arm08_img	.setImageBitmap(bitmap36);
        mili08_img	.setImageBitmap(bitmap37);
        mobile08_img	.setImageBitmap(bitmap38);
        infect08_img	.setImageBitmap(bitmap39);
        project08_img	.setImageBitmap(bitmap40);
        arm09_img	.setImageBitmap(bitmap41);
        mili09_img	.setImageBitmap(bitmap42);
        mobile09_img	.setImageBitmap(bitmap43);
        infect09_img	.setImageBitmap(bitmap44);
        project09_img	.setImageBitmap(bitmap45);
        arm10_img	.setImageBitmap(bitmap46);
        mili10_img	.setImageBitmap(bitmap47);
        mobile10_img	.setImageBitmap(bitmap48);
        infect10_img	.setImageBitmap(bitmap49);
        project10_img	.setImageBitmap(bitmap50);



        arm01	=	findViewById(R.id.	arm01_tv	);
        mili01	=	findViewById(R.id.	mili01_tv	);
        mobile01	=	findViewById(R.id.	mobile01_tv	);
        infect01	=	findViewById(R.id.	infect01_tv	);
        project01	=	findViewById(R.id.	project01_tv	);
        arm02	=	findViewById(R.id.	arm02_tv	);
        mili02	=	findViewById(R.id.	mili02_tv	);
        mobile02	=	findViewById(R.id.	mobile02_tv	);
        infect02	=	findViewById(R.id.	infect02_tv	);
        project02	=	findViewById(R.id.	project02_tv	);
        arm03	=	findViewById(R.id.	arm03_tv	);
        mili03	=	findViewById(R.id.	mili03_tv	);
        mobile03	=	findViewById(R.id.	mobile03_tv	);
        infect03	=	findViewById(R.id.	infect03_tv	);
        project03	=	findViewById(R.id.	project03_tv	);
        arm04	=	findViewById(R.id.	arm04_tv	);
        mili04	=	findViewById(R.id.	mili04_tv	);
        mobile04	=	findViewById(R.id.	mobile04_tv	);
        infect04	=	findViewById(R.id.	infect04_tv	);
        project04	=	findViewById(R.id.	project04_tv	);
        arm05	=	findViewById(R.id.	arm05_tv	);
        mili05	=	findViewById(R.id.	mili05_tv	);
        mobile05	=	findViewById(R.id.	mobile05_tv	);
        infect05	=	findViewById(R.id.	infect05_tv	);
        project05	=	findViewById(R.id.	project05_tv	);
        arm06	=	findViewById(R.id.	arm06_tv	);
        mili06	=	findViewById(R.id.	mili06_tv	);
        mobile06	=	findViewById(R.id.	mobile06_tv	);
        infect06	=	findViewById(R.id.	infect06_tv	);
        project06	=	findViewById(R.id.	project06_tv	);
        arm07	=	findViewById(R.id.	arm07_tv	);
        mili07	=	findViewById(R.id.	mili07_tv	);
        mobile07	=	findViewById(R.id.	mobile07_tv	);
        infect07	=	findViewById(R.id.	infect07_tv	);
        project07	=	findViewById(R.id.	project07_tv	);
        arm08	=	findViewById(R.id.	arm08_tv	);
        mili08	=	findViewById(R.id.	mili08_tv	);
        mobile08	=	findViewById(R.id.	mobile08_tv	);
        infect08	=	findViewById(R.id.	infect08_tv	);
        project08	=	findViewById(R.id.	project08_tv	);
        arm09	=	findViewById(R.id.	arm09_tv	);
        mili09	=	findViewById(R.id.	mili09_tv	);
        mobile09	=	findViewById(R.id.	mobile09_tv	);
        infect09	=	findViewById(R.id.	infect09_tv	);
        project09	=	findViewById(R.id.	project09_tv	);
        arm10	=	findViewById(R.id.	arm10_tv	);
        mili10	=	findViewById(R.id.	mili10_tv	);
        mobile10	=	findViewById(R.id.	mobile10_tv	);
        infect10	=	findViewById(R.id.	infect10_tv	);
        project10	=	findViewById(R.id.	project10_tv	);

    }
    public void cbg() {
        //取出数据（注意这里直接用实例取就行了，不用获取编辑器editor）
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String theme = sharedPreferences.getString("theme", "dark");
        String color1 = sharedPreferences.getString("color1", "F1870F");
        String color2 = sharedPreferences.getString("color2", "C56E0D");
        if (theme.equals("base")) {
            troop_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_base_alpha	));
            troop_tv	.setBackgroundColor(getResources().getColor(R.color.	background_base_press	));
            troop_total	.setBackgroundColor(getResources().getColor(R.color.	background_base_press	));
        }

        if (theme.equals("dark")) {
            troop_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_dark_alpha	));
            troop_tv	.setBackgroundColor(getResources().getColor(R.color.	background_dark_press	));
            troop_total	.setBackgroundColor(getResources().getColor(R.color.	background_dark_press	));

        }

        if (theme.equals("pink")) {
            troop_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_pink_alpha	));
            troop_tv	.setBackgroundColor(getResources().getColor(R.color.	background_pink_press	));
            troop_total	.setBackgroundColor(getResources().getColor(R.color.	background_pink_press	));

        }

        if (theme.equals("leek")) {
            troop_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_leek_alpha	));
            troop_tv	.setBackgroundColor(getResources().getColor(R.color.	background_leek_press	));
            troop_total	.setBackgroundColor(getResources().getColor(R.color.	background_leek_press	));

        }

        if (theme.equals("summer")) {
            troop_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_summer_alpha	));
            troop_tv	.setBackgroundColor(getResources().getColor(R.color.	background_summer_press	));
            troop_total	.setBackgroundColor(getResources().getColor(R.color.	background_summer_press	));

        }
        if (theme.equals("custom")) {
            troop_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            troop_tv	.setBackgroundColor(Color.parseColor("#"+color2));
            troop_total	.setBackgroundColor(Color.parseColor("#"+color2));
        }
    }
    public void dataRefresh (){
        getSavedLoginDataJson();
        mHandler.sendEmptyMessageDelayed(DATA_REFRESH, 3000);
        //Toast.makeText(this, "Star : "+starArray[0]+" "+starArray[1]+" "+starArray[2]+" "+starArray[3], Toast.LENGTH_SHORT).show();

        String	T_TEMP00 , T_TEMP01	,	T_TEMP02	,	T_TEMP03	,	T_TEMP04	,	T_TEMP05	,	T_TEMP06	,	T_TEMP07	,	T_TEMP08	,	T_TEMP09	,	T_TEMP10	,	T_TEMP11	,	T_TEMP12	,	T_TEMP13	,	T_TEMP14	,	T_TEMP15	,	T_TEMP16	,	T_TEMP17	,	T_TEMP18	,	T_TEMP19	,	T_TEMP20	,	T_TEMP21	,	T_TEMP22	,	T_TEMP23	,	T_TEMP24	,	T_TEMP25	,	T_TEMP26	,	T_TEMP27	,	T_TEMP28	,	T_TEMP29	,	T_TEMP30	,	T_TEMP31	,	T_TEMP32	,	T_TEMP33	,	T_TEMP34	,	T_TEMP35	,	T_TEMP36	,	T_TEMP37	,	T_TEMP38	,	T_TEMP39	,	T_TEMP40	,	T_TEMP41	,	T_TEMP42	,	T_TEMP43	,	T_TEMP44	,	T_TEMP45	,	T_TEMP46	,	T_TEMP47	,	T_TEMP48	,	T_TEMP49	,	T_TEMP50	;

        T_TEMP00 = prettyCount(	armyFreeNumArray[ 0]+	armyMarchNumArray[ 0 ] +	armyFreeNumArray[ 1]+	armyMarchNumArray[ 1 ] +	armyFreeNumArray[ 2]+	armyMarchNumArray[ 2 ] +	armyFreeNumArray[ 3]+	armyMarchNumArray[ 3 ] +	armyFreeNumArray[ 4]+	armyMarchNumArray[ 4 ] +	armyFreeNumArray[ 5]+	armyMarchNumArray[ 5 ] +	armyFreeNumArray[ 6]+	armyMarchNumArray[ 6 ] +	armyFreeNumArray[ 7]+	armyMarchNumArray[ 7 ] +	armyFreeNumArray[ 8]+	armyMarchNumArray[ 8 ] +	armyFreeNumArray[ 9]+	armyMarchNumArray[ 9 ] +	armyFreeNumArray[ 10]+	armyMarchNumArray[ 10 ] +	armyFreeNumArray[ 11]+	armyMarchNumArray[ 11 ] +	armyFreeNumArray[ 12]+	armyMarchNumArray[ 12 ] +	armyFreeNumArray[ 13]+	armyMarchNumArray[ 13 ] +	armyFreeNumArray[ 14]+	armyMarchNumArray[ 14 ] +	armyFreeNumArray[ 15]+	armyMarchNumArray[ 15 ] +	armyFreeNumArray[ 16]+	armyMarchNumArray[ 16 ] +	armyFreeNumArray[ 17]+	armyMarchNumArray[ 17 ] +	armyFreeNumArray[ 18]+	armyMarchNumArray[ 18 ] +	armyFreeNumArray[ 19]+	armyMarchNumArray[ 19 ] +	armyFreeNumArray[ 20]+	armyMarchNumArray[ 20 ] +	armyFreeNumArray[ 21]+	armyMarchNumArray[ 21 ] +	armyFreeNumArray[ 22]+	armyMarchNumArray[ 22 ] +	armyFreeNumArray[ 23]+	armyMarchNumArray[ 23 ] +	armyFreeNumArray[ 24]+	armyMarchNumArray[ 24 ] +	armyFreeNumArray[ 25]+	armyMarchNumArray[ 25 ] +	armyFreeNumArray[ 26]+	armyMarchNumArray[ 26 ] +	armyFreeNumArray[ 27]+	armyMarchNumArray[ 27 ] +	armyFreeNumArray[ 28]+	armyMarchNumArray[ 28 ] +	armyFreeNumArray[ 29]+	armyMarchNumArray[ 29 ] +	armyFreeNumArray[ 30]+	armyMarchNumArray[ 30 ] +	armyFreeNumArray[ 31]+	armyMarchNumArray[ 31 ] +	armyFreeNumArray[ 32]+	armyMarchNumArray[ 32 ] +	armyFreeNumArray[ 33]+	armyMarchNumArray[ 33 ] +	armyFreeNumArray[ 34]+	armyMarchNumArray[ 34 ] +	armyFreeNumArray[ 35]+	armyMarchNumArray[ 35 ] +	armyFreeNumArray[ 36]+	armyMarchNumArray[ 36 ] +	armyFreeNumArray[ 37]+	armyMarchNumArray[ 37 ] +	armyFreeNumArray[ 38]+	armyMarchNumArray[ 38 ] +	armyFreeNumArray[ 39]+	armyMarchNumArray[ 39 ] +	armyFreeNumArray[ 40]+	armyMarchNumArray[ 40 ] +	armyFreeNumArray[ 41]+	armyMarchNumArray[ 41 ] +	armyFreeNumArray[ 42]+	armyMarchNumArray[ 42 ] +	armyFreeNumArray[ 43]+	armyMarchNumArray[ 43 ] +	armyFreeNumArray[ 44]+	armyMarchNumArray[ 44 ] +	armyFreeNumArray[ 45]+	armyMarchNumArray[ 45 ] +	armyFreeNumArray[ 46]+	armyMarchNumArray[ 46 ] +	armyFreeNumArray[ 47]+	armyMarchNumArray[ 47 ] +	armyFreeNumArray[ 48]+	armyMarchNumArray[ 48 ] +	armyFreeNumArray[ 49]+	armyMarchNumArray[ 49 ]) ;

        troop_total.setText(getString(R.string.troop_total)+" "+T_TEMP00+" ");
        T_TEMP01	 = prettyCount(armyFreeNumArray[	0	]+armyMarchNumArray[	0	]);
        T_TEMP02	 = prettyCount(armyFreeNumArray[	1	]+armyMarchNumArray[	1	]);
        T_TEMP03	 = prettyCount(armyFreeNumArray[	2	]+armyMarchNumArray[	2	]);
        T_TEMP04	 = prettyCount(armyFreeNumArray[	3	]+armyMarchNumArray[	3	]);
        T_TEMP05	 = prettyCount(armyFreeNumArray[	4	]+armyMarchNumArray[	4	]);
        T_TEMP06	 = prettyCount(armyFreeNumArray[	5	]+armyMarchNumArray[	5	]);
        T_TEMP07	 = prettyCount(armyFreeNumArray[	6	]+armyMarchNumArray[	6	]);
        T_TEMP08	 = prettyCount(armyFreeNumArray[	7	]+armyMarchNumArray[	7	]);
        T_TEMP09	 = prettyCount(armyFreeNumArray[	8	]+armyMarchNumArray[	8	]);
        T_TEMP10	 = prettyCount(armyFreeNumArray[	9	]+armyMarchNumArray[	9	]);
        T_TEMP11	 = prettyCount(armyFreeNumArray[	10	]+armyMarchNumArray[	10	]);
        T_TEMP12	 = prettyCount(armyFreeNumArray[	11	]+armyMarchNumArray[	11	]);
        T_TEMP13	 = prettyCount(armyFreeNumArray[	12	]+armyMarchNumArray[	12	]);
        T_TEMP14	 = prettyCount(armyFreeNumArray[	13	]+armyMarchNumArray[	13	]);
        T_TEMP15	 = prettyCount(armyFreeNumArray[	14	]+armyMarchNumArray[	14	]);
        T_TEMP16	 = prettyCount(armyFreeNumArray[	15	]+armyMarchNumArray[	15	]);
        T_TEMP17	 = prettyCount(armyFreeNumArray[	16	]+armyMarchNumArray[	16	]);
        T_TEMP18	 = prettyCount(armyFreeNumArray[	17	]+armyMarchNumArray[	17	]);
        T_TEMP19	 = prettyCount(armyFreeNumArray[	18	]+armyMarchNumArray[	18	]);
        T_TEMP20	 = prettyCount(armyFreeNumArray[	19	]+armyMarchNumArray[	19	]);
        T_TEMP21	 = prettyCount(armyFreeNumArray[	20	]+armyMarchNumArray[	20	]);
        T_TEMP22	 = prettyCount(armyFreeNumArray[	21	]+armyMarchNumArray[	21	]);
        T_TEMP23	 = prettyCount(armyFreeNumArray[	22	]+armyMarchNumArray[	22	]);
        T_TEMP24	 = prettyCount(armyFreeNumArray[	23	]+armyMarchNumArray[	23	]);
        T_TEMP25	 = prettyCount(armyFreeNumArray[	24	]+armyMarchNumArray[	24	]);
        T_TEMP26	 = prettyCount(armyFreeNumArray[	25	]+armyMarchNumArray[	25	]);
        T_TEMP27	 = prettyCount(armyFreeNumArray[	26	]+armyMarchNumArray[	26	]);
        T_TEMP28	 = prettyCount(armyFreeNumArray[	27	]+armyMarchNumArray[	27	]);
        T_TEMP29	 = prettyCount(armyFreeNumArray[	28	]+armyMarchNumArray[	28	]);
        T_TEMP30	 = prettyCount(armyFreeNumArray[	29	]+armyMarchNumArray[	29	]);
        T_TEMP31	 = prettyCount(armyFreeNumArray[	30	]+armyMarchNumArray[	30	]);
        T_TEMP32	 = prettyCount(armyFreeNumArray[	31	]+armyMarchNumArray[	31	]);
        T_TEMP33	 = prettyCount(armyFreeNumArray[	32	]+armyMarchNumArray[	32	]);
        T_TEMP34	 = prettyCount(armyFreeNumArray[	33	]+armyMarchNumArray[	33	]);
        T_TEMP35	 = prettyCount(armyFreeNumArray[	34	]+armyMarchNumArray[	34	]);
        T_TEMP36	 = prettyCount(armyFreeNumArray[	35	]+armyMarchNumArray[	35	]);
        T_TEMP37	 = prettyCount(armyFreeNumArray[	36	]+armyMarchNumArray[	36	]);
        T_TEMP38	 = prettyCount(armyFreeNumArray[	37	]+armyMarchNumArray[	37	]);
        T_TEMP39	 = prettyCount(armyFreeNumArray[	38	]+armyMarchNumArray[	38	]);
        T_TEMP40	 = prettyCount(armyFreeNumArray[	39	]+armyMarchNumArray[	39	]);
        T_TEMP41	 = prettyCount(armyFreeNumArray[	40	]+armyMarchNumArray[	40	]);
        T_TEMP42	 = prettyCount(armyFreeNumArray[	41	]+armyMarchNumArray[	41	]);
        T_TEMP43	 = prettyCount(armyFreeNumArray[	42	]+armyMarchNumArray[	42	]);
        T_TEMP44	 = prettyCount(armyFreeNumArray[	43	]+armyMarchNumArray[	43	]);
        T_TEMP45	 = prettyCount(armyFreeNumArray[	44	]+armyMarchNumArray[	44	]);
        T_TEMP46	 = prettyCount(armyFreeNumArray[	45	]+armyMarchNumArray[	45	]);
        T_TEMP47	 = prettyCount(armyFreeNumArray[	46	]+armyMarchNumArray[	46	]);
        T_TEMP48	 = prettyCount(armyFreeNumArray[	47	]+armyMarchNumArray[	47	]);
        T_TEMP49	 = prettyCount(armyFreeNumArray[	48	]+armyMarchNumArray[	48	]);
        T_TEMP50	 = prettyCount(armyFreeNumArray[	49	]+armyMarchNumArray[	49	]);


        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        //取出数据（注意这里直接用实例取就行了，不用获取编辑器editor）
        boolean show = sharedPreferences.getBoolean("troop_show_0", false);
        if (!show){
            if(T_TEMP01	.equals("0")){	mili01	.setVisibility(View.INVISIBLE);	mili01_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP02	.equals("0")){	mili02	.setVisibility(View.INVISIBLE);	mili02_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP03	.equals("0")){	mili03	.setVisibility(View.INVISIBLE);	mili03_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP04	.equals("0")){	mili04	.setVisibility(View.INVISIBLE);	mili04_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP05	.equals("0")){	mili05	.setVisibility(View.INVISIBLE);	mili05_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP06	.equals("0")){	mili06	.setVisibility(View.INVISIBLE);	mili06_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP07	.equals("0")){	mili07	.setVisibility(View.INVISIBLE);	mili07_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP08	.equals("0")){	mili08	.setVisibility(View.INVISIBLE);	mili08_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP09	.equals("0")){	mili09	.setVisibility(View.INVISIBLE);	mili09_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP10	.equals("0")){	mili10	.setVisibility(View.INVISIBLE);	mili10_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP11	.equals("0")){	mobile01	.setVisibility(View.INVISIBLE);	mobile01_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP12	.equals("0")){	mobile02	.setVisibility(View.INVISIBLE);	mobile02_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP13	.equals("0")){	mobile03	.setVisibility(View.INVISIBLE);	mobile03_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP14	.equals("0")){	mobile04	.setVisibility(View.INVISIBLE);	mobile04_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP15	.equals("0")){	mobile05	.setVisibility(View.INVISIBLE);	mobile05_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP16	.equals("0")){	mobile06	.setVisibility(View.INVISIBLE);	mobile06_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP17	.equals("0")){	mobile07	.setVisibility(View.INVISIBLE);	mobile07_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP18	.equals("0")){	mobile08	.setVisibility(View.INVISIBLE);	mobile08_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP19	.equals("0")){	mobile09	.setVisibility(View.INVISIBLE);	mobile09_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP20	.equals("0")){	mobile10	.setVisibility(View.INVISIBLE);	mobile10_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP21	.equals("0")){	arm01	.setVisibility(View.INVISIBLE);	arm01_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP22	.equals("0")){	arm02	.setVisibility(View.INVISIBLE);	arm02_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP23	.equals("0")){	arm03	.setVisibility(View.INVISIBLE);	arm03_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP24	.equals("0")){	arm04	.setVisibility(View.INVISIBLE);	arm04_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP25	.equals("0")){	arm05	.setVisibility(View.INVISIBLE);	arm05_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP26	.equals("0")){	arm06	.setVisibility(View.INVISIBLE);	arm06_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP27	.equals("0")){	arm07	.setVisibility(View.INVISIBLE);	arm07_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP28	.equals("0")){	arm08	.setVisibility(View.INVISIBLE);	arm08_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP29	.equals("0")){	arm09	.setVisibility(View.INVISIBLE);	arm09_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP30	.equals("0")){	arm10	.setVisibility(View.INVISIBLE);	arm10_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP31	.equals("0")){	infect01	.setVisibility(View.INVISIBLE);	infect01_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP32	.equals("0")){	infect02	.setVisibility(View.INVISIBLE);	infect02_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP33	.equals("0")){	infect03	.setVisibility(View.INVISIBLE);	infect03_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP34	.equals("0")){	infect04	.setVisibility(View.INVISIBLE);	infect04_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP35	.equals("0")){	infect05	.setVisibility(View.INVISIBLE);	infect05_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP36	.equals("0")){	infect06	.setVisibility(View.INVISIBLE);	infect06_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP37	.equals("0")){	infect07	.setVisibility(View.INVISIBLE);	infect07_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP38	.equals("0")){	infect08	.setVisibility(View.INVISIBLE);	infect08_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP39	.equals("0")){	infect09	.setVisibility(View.INVISIBLE);	infect09_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP40	.equals("0")){	infect10	.setVisibility(View.INVISIBLE);	infect10_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP41	.equals("0")){	project01	.setVisibility(View.INVISIBLE);	project01_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP42	.equals("0")){	project02	.setVisibility(View.INVISIBLE);	project02_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP43	.equals("0")){	project03	.setVisibility(View.INVISIBLE);	project03_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP44	.equals("0")){	project04	.setVisibility(View.INVISIBLE);	project04_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP45	.equals("0")){	project05	.setVisibility(View.INVISIBLE);	project05_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP46	.equals("0")){	project06	.setVisibility(View.INVISIBLE);	project06_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP47	.equals("0")){	project07	.setVisibility(View.INVISIBLE);	project07_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP48	.equals("0")){	project08	.setVisibility(View.INVISIBLE);	project08_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP49	.equals("0")){	project09	.setVisibility(View.INVISIBLE);	project09_img	.setVisibility(View.INVISIBLE);	}
            if(T_TEMP50	.equals("0")){	project10	.setVisibility(View.INVISIBLE);	project10_img	.setVisibility(View.INVISIBLE);	}



            //  Log.i("SHOW_0","NO");
            //  Log.i("T_TEMP46",T_TEMP46);
        }
        mili01	.setText(	T_TEMP01	);
        mili02	.setText(	T_TEMP02	);
        mili03	.setText(	T_TEMP03	);
        mili04	.setText(	T_TEMP04	);
        mili05	.setText(	T_TEMP05	);
        mili06	.setText(	T_TEMP06	);
        mili07	.setText(	T_TEMP07	);
        mili08	.setText(	T_TEMP08	);
        mili09	.setText(	T_TEMP09	);
        mili10	.setText(	T_TEMP10	);
        mobile01	.setText(	T_TEMP11	);
        mobile02	.setText(	T_TEMP12	);
        mobile03	.setText(	T_TEMP13	);
        mobile04	.setText(	T_TEMP14	);
        mobile05	.setText(	T_TEMP15	);
        mobile06	.setText(	T_TEMP16	);
        mobile07	.setText(	T_TEMP17	);
        mobile08	.setText(	T_TEMP18	);
        mobile09	.setText(	T_TEMP19	);
        mobile10	.setText(	T_TEMP20	);
        arm01	.setText(	T_TEMP21	);
        arm02	.setText(	T_TEMP22	);
        arm03	.setText(	T_TEMP23	);
        arm04	.setText(	T_TEMP24	);
        arm05	.setText(	T_TEMP25	);
        arm06	.setText(	T_TEMP26	);
        arm07	.setText(	T_TEMP27	);
        arm08	.setText(	T_TEMP28	);
        arm09	.setText(	T_TEMP29	);
        arm10	.setText(	T_TEMP30	);
        infect01	.setText(	T_TEMP31	);
        infect02	.setText(	T_TEMP32	);
        infect03	.setText(	T_TEMP33	);
        infect04	.setText(	T_TEMP34	);
        infect05	.setText(	T_TEMP35	);
        infect06	.setText(	T_TEMP36	);
        infect07	.setText(	T_TEMP37	);
        infect08	.setText(	T_TEMP38	);
        infect09	.setText(	T_TEMP39	);
        infect10	.setText(	T_TEMP40	);
        project01	.setText(	T_TEMP41	);
        project02	.setText(	T_TEMP42	);
        project03	.setText(	T_TEMP43	);
        project04	.setText(	T_TEMP44	);
        project05	.setText(	T_TEMP45	);
        project06	.setText(	T_TEMP46	);
        project07	.setText(	T_TEMP47	);
        project08	.setText(	T_TEMP48	);
        project09	.setText(	T_TEMP49	);
        project10	.setText(	T_TEMP50	);

        //Toast.makeText(this, helper.DataName(), Toast.LENGTH_SHORT).show();
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener(){
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if (visibility == 0)
                    decorView.setSystemUiVisibility(hideSystemBars());

            }
        });
        cbg();
    }
    public String prettyCount(Number number) {
        char[] suffix = {' ', 'K', 'M', 'G', 'T', 'P', 'E', 'Z', 'Y'};
        long numValue = number.longValue();
        int value = (int) Math.floor(Math.log10(numValue));
        int base = value / 3;
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        int decimal_num = sharedPreferences.getInt("decimal_num", 0);
        boolean decimal  = sharedPreferences.getBoolean("decimal", false);
        if (decimal == true){
            if (value >= 3 && base < suffix.length) {
                if (decimal_num == 0){
                    return new DecimalFormat("##").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                if (decimal_num == 1){
                    return new DecimalFormat("##.#").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                if (decimal_num == 2){
                    return new DecimalFormat("##.##").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                if (decimal_num == 3){
                    return new DecimalFormat("##.###").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                if (decimal_num == 4){
                    return new DecimalFormat("##.####").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                if (decimal_num == 5){
                    return new DecimalFormat("##.#####").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                // Muility
            } else {
                return new DecimalFormat("#,###").format(numValue);
            }}
        return new DecimalFormat("###,###,###,###,###").format(numValue);
    }

    public String prettyCount2(Number number) {
        char[] suffix = {' ', 'K', 'M', 'G', 'T', 'P', 'E', 'Z', 'Y'};
        long numValue = number.longValue();
        int value = (int) Math.floor(Math.log10(numValue));
        int base = value / 3;
        String plus = "";
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        int decimal_num = sharedPreferences.getInt("decimal_num", 0);
        boolean decimal  = sharedPreferences.getBoolean("decimal", false);
        if (numValue>0){plus = "+";}
        if (decimal == true){
            if (value >= 3 && base < suffix.length) {
                if (decimal_num == 0){
                    return plus+new DecimalFormat("##").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                if (decimal_num == 1){
                    return plus+new DecimalFormat("##.#").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                if (decimal_num == 2){
                    return plus+new DecimalFormat("##.##").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                if (decimal_num == 3){
                    return plus+new DecimalFormat("##.###").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                if (decimal_num == 4){
                    return plus+new DecimalFormat("##.####").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                if (decimal_num == 5){
                    return plus+new DecimalFormat("##.#####").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                // Muility
            } else {
                return plus+new DecimalFormat("#,###").format(numValue);
            }}
        return plus+new DecimalFormat("###,###,###,###,###").format(numValue);
    }

    public boolean isPermissionsAvaiable(String[] permissions)
    {
        for (String permission : permissions)
        {
            if (ActivityCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED)
            {
                return false;
            }
        }
        return true;
    }

    public boolean isExternalStoragePermissionsAvaiable()
    {
        String[] p = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        return isPermissionsAvaiable(p);
    }

    public boolean isSDCardWritable()
    {
        return isSDcardAvaiable() && isExternalStoragePermissionsAvaiable();
    }

    private boolean isSDcardAvaiable()
    {
        String sdCardState = Environment.getExternalStorageState();
        return sdCardState.equals(Environment.MEDIA_MOUNTED);
    }

    private boolean prepareDirectory(String path)
    {
        try {
            File file = new File(path);
            if (file.exists() && file.isDirectory())
            {
                return true;
            }
            else
            {
                boolean result = file.mkdirs();
                return result;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private String getDBDirectoryPath()
    {
        if (isSDCardWritable())
        {
            String directory =  fileDir;
            if (prepareDirectory(directory))
            {
                return directory;
            }
        }

        return null;
    }

    private JSONObject getSavedLoginDataJson()
    {
        String pathName = getDBDirectoryPath();
        if (pathName == null)
        {
            return null;
        }

        File path = new File(pathName);
        File file = new File(pathName + fileName);
        if (!path.exists() || !file.exists())
        {
            return null;
        }

        FileInputStream fin = null;
        try
        {
            fin = new FileInputStream(file);
            int length = fin.available();
            byte[] buffer = new byte[length];
            fin.read(buffer);
            String text = EncodingUtils.getString(buffer, "UTF-8");
            fin.close();

            JSONObject result = new JSONObject(text);
            UID = result.getLong("uid");
            //Log.i("UID_DATALIST", String.valueOf(UID));
            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    private class TakeData extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Toast.makeText(DataListActivity.this,"Json Data is downloading",Toast.LENGTH_LONG).show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            String url = "http://vt.25u.com/vt/zgt/user.json";
            //Set URL from Zgirls Server
            url = "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid="; //未完成適配,2020.09.02-0912
            //http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=350893843000164 完成RSS , TROOPS適配,2020.09.08
            // UID
            url = url+UID;
            // Depends URL
            SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
            boolean input_json_list = sharedPreferences.getBoolean("input_json_list", true);

            ppl = sharedPreferences.getString("ppl", "Yourself");

            String aa = "311325387000015" ;
            String b= "422204583000015" ;
            String cc = "350294313000015" ;
            String d = "15261753000019" ;
            String ee = "998621791000046" ;
            String f = "9213185000015" ;
            String g = "365391265000043" ;
            String h = "525907835000046" ;
            String ii = "24892075000008" ;

            if (ppl.matches("루미너스 - LUMI")) { uid = Long.parseLong(aa);}
            if (ppl.matches("Awoken mommaker")) { uid = Long.parseLong(b);}
            if (ppl.matches("Kristineee")) { uid = Long.parseLong(cc);}
            if (ppl.matches("BkParade")) { uid = Long.parseLong(d);}
            if (ppl.matches("《Innocent》")) { uid = Long.parseLong(ee);}
            if (ppl.matches("꧁cosmodnc꧂")) { uid = Long.parseLong(f);}
            if (ppl.matches("Golden_Yúrishima")) { uid = Long.parseLong(g);}
            if (ppl.matches("7@rgaryen")) { uid = Long.parseLong(h);}
            if (ppl.matches("MARCELO ALEXIS")) { uid = Long.parseLong(ii);}
            if (ppl.matches("Yourself")) { uid = UID;}
            if (ppl.matches("Custom")) { uid = UID2;}

            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=311325387000015" lumi
            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=422204583000015" Awoken
            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=423362547000009" BULLET
            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=326125136000029" 寂靜夜影
            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=385084201000018" 时钟狂三
            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=610026094000009" Moonphilia
            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=350294313000015" Kristineee
            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=15261753000019" BkParade
            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=998621791000046" 《Innocent》
            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=9213185000015" ꧁cosmodnc꧂
            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=459643483000042" M16A1
            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=92903777000015" Golden~Yuria
            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=365391265000043" Golden_Yúrishima
            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=525907835000046" 7@rgaryen
            if (input_json_list == true){url = "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid="+uid;}
            else {
                url = "http://vt.25u.com/vt/zgt/user.json";
                sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("ppl", "DEMO");
                editor.apply();
            }if (ppl.matches("DEMO")) { url = "http://vt.25u.com/vt/zgt/user.json";}
            String jsonStr = sh.makeServiceCall(url);
                    // Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray troops = jsonObj.getJSONArray("armys");


                    for (int i = 0; i < troops.length(); i++) {
                        JSONObject a = troops.getJSONObject(i);
                        armyFreeNum = a.getInt("armyFreeNum");
                        armyFreeNumArray [i] = armyFreeNum;
                        armyMarchNum = a.getInt("armyMarchNum");
                        armyMarchNumArray [i] = armyMarchNum;
                        armyName = a.getString("armyName");
                        armyNameArray [i] =armyName;
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String url = "http://vt.25u.com/vt/zgt/user.json";
                            SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("ppl", "DEMO");
                            editor.apply();
                            //             Toast.makeText(getApplicationContext(),
                            //                    "Json parsing error: " + e.getMessage(),
                            //                    Toast.LENGTH_LONG).show();
                        }
                    });

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String url = "http://vt.25u.com/vt/zgt/user.json";
                        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("ppl", "DEMO");
                        editor.apply();
                        //    Toast.makeText(getApplicationContext(),
                        //            "Couldn't get json from server. Check LogCat for possible errors!",
                        //           Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Log.i("TROOP_Grab","ok");
           dataRefresh();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        sleep = true ;
        finishAndRemoveTask();

    }
    private static final int DATA_REFRESH = 0;
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {

            switch (msg.what) {
                case DATA_REFRESH:
                    if (!sleep){
                        new TakeData().execute();
                    }
                    break;
                default:
                    break;
            }
        }

    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent i = new Intent(DataTroopActivity.this , DataListActivity.class);
            i.putExtra("UID",uid);
            SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("ppl", ppl);
            editor.apply();
            sleep = true ;
            finishAndRemoveTask();
            startActivity(i);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}