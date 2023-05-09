package voc.net.tools.zgirls_tool.ui;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
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
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import org.apache.http.util.EncodingUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.old_ui.DataEnablerActivity;
import voc.net.tools.zgirls_tool.util.HttpHandler;
import voc.net.tools.zgirls_tool.R;
import voc.net.tools.zgirls_tool.util.ScreenSizeUtils;
import voc.net.tools.zgirls_tool.util.SortArrayListAscendingDescending;

import static android.view.View.GONE;

public class DataListActivity extends AppCompatActivity implements View.OnClickListener, OnChartValueSelectedListener {
    String[] NAME_LIST ;
    String[] NAME_LIST2 ;
    CardView rss_card , mecha_card , enabler_card , exp_card , star_card , troop_card , progress_card , boomer_card;
    TextView rss_tv , mecha_tv , enabler_tv , exp_tv , star_tv , troop_tv , progress_tv , boomer_tv;
    TextView troop_total;
    TextView boomer_total;

    TextView	arm10	;
    TextView	mili10	;
    TextView	mobile10	;
    TextView	infect10	;
    TextView	project10	;
    TextView	arm09	;
    TextView	mili09	;
    TextView	mobile09	;
    TextView	infect09	;
    TextView	project09	;

    ImageView	arm10_img	;
    ImageView	mili10_img	;
    ImageView	mobile10_img	;
    ImageView	infect10_img	;
    ImageView	project10_img	;
    ImageView	arm09_img	;
    ImageView	mili09_img	;
    ImageView	mobile09_img	;
    ImageView	infect09_img	;
    ImageView	project09_img	;
    ImageView troop_pie;

    int nah = 0 ;
    int bah = 0 ;

    String ppl;

    ImageView	enabler_img_01,	enabler_img_02,	enabler_img_03,	enabler_img_04,	enabler_img_05;
    ImageView	mecha_img01,	mecha_img02,	mecha_img03,	mecha_img04,	mecha_img05;

    TextView food , fuel , steel , alloy , obsidian , kyanite , kyanite_basic , kyanite_cluster , glory_mark , catalyst , diamond;
    TextView name1 , level1 , energy1 , power1 ;
    TextView name2 , level2 , energy2 , power2 ;
    TextView name3 , level3 , energy3 , power3 ;
    TextView name4 , level4 , energy4 , power4 ;
    TextView EXP100 , EXP5K, EXP10K , EXP20K  , EXP50K , EXP80K , EXP100K , EXPALL  ;

    TextView armed_id_tv , armed_process_tv , armed_total_tv , armed_count_tv , armed_per;
    TextView mili_id_tv , mili_process_tv , mili_total_tv , mili_count_tv , mili_per ;
    TextView mobile_id_tv , mobile_process_tv , mobile_total_tv , mobile_count_tv , mobile_per;
    TextView infect_id_tv , infect_process_tv , infect_total_tv , infect_count_tv , infect_per;
    TextView project_id_tv , project_process_tv , project_total_tv , project_count_tv , project_per;

    ArrayList<Long> sortedArrayListDescending ;
    ArrayList<Long> sortedArrayListDescending2 ;
    private ProgressDialog pd;
    // private SwipeRefreshLayout swipeRefreshLayout ;

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
    private final static String TAG = "DataListActivity";

    int large_img_x = 100;
    int large_img_y = 130;
    int small_img_x = 80;
    int small_img_y = 100;
    int large_troop_x = 84;
    int large_troop_y = 114;
    int small_troop_x = 67;
    int small_troop_y = 91;
    int large_tv_x = 100;
    int small_tv_x = 80;

    long[] troop_show_name = new long[10];

    long process_show_name ;

    boolean sleep = false ;

    String jsonStr;
    String str;

    long UID;
    long UID2;
    String verifyCode ;

    private static final String fileName = "user_session";
    private static final String fileDir = Environment.getExternalStorageDirectory().getPath() +"/data/data/com.xingjoys.zgirls.app/config/";

    long fuel_final , food_final , steel_final , alloy_final , obsidian_final , kyanite_final , kyanite_basic_final , kyanite_cluster_final , glory_mark_final , catalyst_final , diamond_final ;
    String star_final ;
    String mechaName ,  armyName , enablerName ;
    String boomName , buildingName  ;
    long boomId , boomNum , mechaLv;
    long armyFreeNum , armyMarchNum , enablerLv , progressId , progressTotal , progressRemain , progressCount;
    long buildingId , buildingLvl , buildingGlory ;
    long fuel_re , food_re , steel_re ,  alloy_re ,obsidian_re ,kyanite_re ,kyanite_basic_re ,kyanite_cluster_re ,glory_mark_re ,catalyst_re ,diamond_re ;

    String[] mechaNameArray = new String[4];
    long[] mechaLvArray = new long[4];
    String[] mechaNameArray2 = new String[4];
    long[] mechaLvArray2 = new long[4];

    String[] armyNameArray = new String[60];
    long[] armyFreeNumArray = new long[60];
    long[] armyMarchNumArray = new long[60];

    long[] armyCountNumArray = new long[60];
    long[] armyFinishNumArray = new long[60];
    long[] armyIdNumArray = new long[60];

    //ArrayList<Progress> armyFinishCountArray = new  ArrayList<Progress>();

    String[] enablerNameArray = new String[128];
    long[] enablerLvArray = new long[128];

    long[] starArray = new long[4];

    long[] expArray = new long[7];

    long[] buildingLvlArray = new long[80];
    String[] buildingNameArray = new String[80];

    long[] progressIdArray = new long[5];
    long[] progressTotalArray = {1,1,1,1,1};
    long[] progressRemainArray = new long[5];
    long[] progressCountArray = new long[5];

    long[] boomerNum = new long[15];
    long[] boomerId = new long[15];
    String[] boomNameArray = new String[15];

    long arm_progress  = 100, arm_total = 10000;
    long mili_progress = 100, mili_total = 10000;
    long mobile_progress = 100, mobile_total = 10000;
    long infect_progress = 100, infect_total = 10000;
    long project_progress = 100, project_total = 10000;

    ImageView star01 ;
    ImageView star02 ;
    ImageView star03 ;
    ImageView star04 ;
    TextView starName ;

    ImageView armed_img , mili_img , mobile_img , infect_img , project_img ;

    ImageView 	Boomer01_img ,	Boomer02_img ,	Boomer03_img ,	Boomer04_img ,	Boomer05_img ,	Boomer06_img ,	Boomer07_img ,	Boomer08_img ,	Boomer09_img ,	Boomer10_img ,	Boomer11_img ,	Boomer12_img ,	Boomer13_img ,	Boomer14_img ,	Boomer15_img ;
    TextView 	Boomer01_tv ,	Boomer02_tv ,	Boomer03_tv ,	Boomer04_tv ,	Boomer05_tv ,	Boomer06_tv ,	Boomer07_tv ,	Boomer08_tv ,	Boomer09_tv ,	Boomer10_tv ,	Boomer11_tv ,	Boomer12_tv ,	Boomer13_tv ,	Boomer14_tv ,	Boomer15_tv ;
    //ImageView 	eicon01 ,	eicon02 ,	eicon03 ,	eicon04 ,	eicon05 ,	eicon06 ,	eicon07 ,	eicon08 ,	eicon09 ,	eicon10 ,	eicon11 ,	eicon12 ,	eicon13 ,	eicon14 ,	eicon15 ,	eicon16 ,	eicon17 ,	eicon18 ,	eicon19 ,	eicon20 ,	eicon21 ,	eicon22 ,	eicon23 ,	eicon24 ,	eicon25 ,	eicon26 ,	eicon27 ,	eicon28 ,	eicon29 ,	eicon30 ,	eicon31 ,	eicon32 ,	eicon33 ,	eicon34 ,	eicon35 ,	eicon36 ,	eicon37 ,	eicon38 ,	eicon39 ,	eicon40 ,	eicon41 ,	eicon42 ,	eicon43 ,	eicon44 ,	eicon45 ,	eicon46 ,	eicon47 ,	eicon48 ;
    // PieChart pieChart1;

    long mili_1_all =	0;	long mili_1_free =	0;	long mili_1_march =	0;
    long mili_2_all =	0;	long mili_2_free =	0;	long mili_2_march =	0;
    long mili_3_all =	0;	long mili_3_free =	0;	long mili_3_march =	0;
    long mili_4_all =	0;	long mili_4_free =	0;	long mili_4_march =	0;
    long mili_5_all =	0;	long mili_5_free =	0;	long mili_5_march =	0;
    long mili_6_all =	0;	long mili_6_free =	0;	long mili_6_march =	0;
    long mili_7_all =	0;	long mili_7_free =	0;	long mili_7_march =	0;
    long mili_8_all =	0;	long mili_8_free =	0;	long mili_8_march =	0;
    long mili_9_all =	0;	long mili_9_free =	0;	long mili_9_march =	0;
    long mili_10_all =	0;	long mili_10_free =	0;	long mili_10_march =	0;
    long mobile_1_all =	0;	long mobile_1_free =	0;	long mobile_1_march =	0;
    long mobile_2_all =	0;	long mobile_2_free =	0;	long mobile_2_march =	0;
    long mobile_3_all =	0;	long mobile_3_free =	0;	long mobile_3_march =	0;
    long mobile_4_all =	0;	long mobile_4_free =	0;	long mobile_4_march =	0;
    long mobile_5_all =	0;	long mobile_5_free =	0;	long mobile_5_march =	0;
    long mobile_6_all =	0;	long mobile_6_free =	0;	long mobile_6_march =	0;
    long mobile_7_all =	0;	long mobile_7_free =	0;	long mobile_7_march =	0;
    long mobile_8_all =	0;	long mobile_8_free =	0;	long mobile_8_march =	0;
    long mobile_9_all =	0;	long mobile_9_free =	0;	long mobile_9_march =	0;
    long mobile_10_all =	0;	long mobile_10_free =	0;	long mobile_10_march =	0;
    long armed_1_all = 	0;	long armed_1_free = 	0;	long armed_1_march = 	0;
    long armed_2_all =	0;	long armed_2_free =	0;	long armed_2_march =	0;
    long armed_3_all =	0;	long armed_3_free =	0;	long armed_3_march =	0;
    long armed_4_all =	0;	long armed_4_free =	0;	long armed_4_march =	0;
    long armed_5_all =	0;	long armed_5_free =	0;	long armed_5_march =	0;
    long armed_6_all =	0;	long armed_6_free =	0;	long armed_6_march =	0;
    long armed_7_all =	0;	long armed_7_free =	0;	long armed_7_march =	0;
    long armed_8_all =	0;	long armed_8_free =	0;	long armed_8_march =	0;
    long armed_9_all =	0;	long armed_9_free =	0;	long armed_9_march =	0;
    long armed_10_all =	0;	long armed_10_free =	0;	long armed_10_march =	0;
    long infect_1_all =	0;	long infect_1_free =	0;	long infect_1_march =	0;
    long infect_2_all =	0;	long infect_2_free =	0;	long infect_2_march =	0;
    long infect_3_all =	0;	long infect_3_free =	0;	long infect_3_march =	0;
    long infect_4_all =	0;	long infect_4_free =	0;	long infect_4_march =	0;
    long infect_5_all =	0;	long infect_5_free =	0;	long infect_5_march =	0;
    long infect_6_all =	0;	long infect_6_free =	0;	long infect_6_march =	0;
    long infect_7_all =	0;	long infect_7_free =	0;	long infect_7_march =	0;
    long infect_8_all =	0;	long infect_8_free =	0;	long infect_8_march =	0;
    long infect_9_all =	0;	long infect_9_free =	0;	long infect_9_march =	0;
    long infect_10_all =	0;	long infect_10_free =	0;	long infect_10_march =	0;
    long proj_1_all =	0;	long proj_1_free =	0;	long proj_1_march =	0;
    long proj_2_all =	0;	long proj_2_free =	0;	long proj_2_march =	0;
    long proj_3_all =	0;	long proj_3_free =	0;	long proj_3_march =	0;
    long proj_4_all =	0;	long proj_4_free =	0;	long proj_4_march =	0;
    long proj_5_all =	0;	long proj_5_free =	0;	long proj_5_march =	0;
    long proj_6_all =	0;	long proj_6_free =	0;	long proj_6_march =	0;
    long proj_7_all =	0;	long proj_7_free =	0;	long proj_7_march =	0;
    long proj_8_all =	0;	long proj_8_free =	0;	long proj_8_march =	0;
    long proj_9_all =	0;	long proj_9_free =	0;	long proj_9_march =	0;
    long proj_10_all =	0;	long proj_10_free =	0;	long proj_10_march =	0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);
        getSavedLoginDataJson();
        pd = new ProgressDialog(this);
        pd.setMessage(getString(R.string.loading));
        pd.create();
        pd.show();
        //pieChart1 = findViewById(R.id.consume_pie1_chart);
        NAME_LIST = new String[]{this.getString(R.string.mili_1), this.getString(R.string.mili_2), this.getString(R.string.mili_3), this.getString(R.string.mili_4), this.getString(R.string.mili_5), this.getString(R.string.mili_6), this.getString(R.string.mili_7), this.getString(R.string.mili_8), this.getString(R.string.mili_9), this.getString(R.string.mili_10), this.getString(R.string.mobile_1), this.getString(R.string.mobile_2), this.getString(R.string.mobile_3), this.getString(R.string.mobile_4), this.getString(R.string.mobile_5), this.getString(R.string.mobile_6), this.getString(R.string.mobile_7), this.getString(R.string.mobile_8), this.getString(R.string.mobile_9), this.getString(R.string.mobile_10), this.getString(R.string.arm_1), this.getString(R.string.arm_2), this.getString(R.string.arm_3), this.getString(R.string.arm_4), this.getString(R.string.arm_5), this.getString(R.string.arm_6), this.getString(R.string.arm_7), this.getString(R.string.arm_8), this.getString(R.string.arm_9), this.getString(R.string.arm_10), this.getString(R.string.infect_1), this.getString(R.string.infect_2), this.getString(R.string.infect_3), this.getString(R.string.infect_4), this.getString(R.string.infect_5), this.getString(R.string.infect_6), this.getString(R.string.infect_7), this.getString(R.string.infect_8), this.getString(R.string.infect_9), this.getString(R.string.infect_10), this.getString(R.string.proj_1), this.getString(R.string.proj_2), this.getString(R.string.proj_3), this.getString(R.string.proj_4), this.getString(R.string.proj_5), this.getString(R.string.proj_6), this.getString(R.string.proj_7), this.getString(R.string.proj_8), this.getString(R.string.proj_9), this.getString(R.string.proj_10)};
        NAME_LIST2 = new String[]{this.getString(R.string.mili),this.getString(R.string.mobile),this.getString(R.string.armed),this.getString(R.string.infecion),this.getString(R.string.project)};
        /*
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                UID2 = 0;
                verifyCode = "0";
            } else {
                UID2 = extras.getLong("UID");
                verifyCode = extras.getString("verifyCode");
            }
        } else {
            UID2 = (Long) savedInstanceState.getSerializable("UID");
            verifyCode = (String) savedInstanceState.getSerializable("verifyCode");
        }
         */
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        init();
        String color1 = sharedPreferences.getString("color1", "F1870F");
        String theme = sharedPreferences.getString("theme", "dark");
        getSavedLoginDataJson();
        mHandler.sendEmptyMessageDelayed(TAKE_DATA_REFRESH,100);

        // swipeRefreshLayout = findViewById(R.id.swipe_container);

        //   if (theme.equals("custom")) { swipeRefreshLayout.setColorSchemeColors(Color.parseColor("#"+color1)); }
        //  if (theme.equals("base")) { swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.	background_base	)); }
        //   if (theme.equals("dark")) { swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.	background_dark	)); }
        //  if (theme.equals("pink")) { swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.	background_pink	)); }
        //   if (theme.equals("leek")) { swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.	background_leek	)); }
        //   if (theme.equals("summer")) { swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.	background_summer	)); }
        troop_pie = findViewById(R.id.troop_pie);
        BackgroundReload();
        // 建立SQLiteOpenHelper物件
        //METHOD END
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
        progressRefresh();
    }
    public void BackgroundReload (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.data_bg);

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
        rss_card = findViewById(R.id.rss_card);
        mecha_card = findViewById(R.id.mecha_card);
        //  enabler_card = findViewById(R.id.enabler_card);
        //   exp_card = findViewById(R.id.exp_card);
        //  star_card = findViewById(R.id.star_card);
        troop_card = findViewById(R.id.troop_card);
        progress_card = findViewById(R.id.project_process_card);
        boomer_card = findViewById(R.id.boomer_card);
        rss_tv = findViewById(R.id.rss);
        mecha_tv = findViewById(R.id.mecha);
        //   enabler_tv = findViewById(R.id.enabler);
        //    exp_tv = findViewById(R.id.exp);
        //    star_tv = findViewById(R.id.star_stone);
        troop_tv = findViewById(R.id.troop);
        progress_tv = findViewById(R.id.process);
        boomer_tv = findViewById(R.id.boomer);

        troop_total = findViewById(R.id.troop_total);
        boomer_total = findViewById(R.id.boomer_total);

        food = findViewById(R.id.data_food);
        fuel = findViewById(R.id.data_fuel);
        steel = findViewById(R.id.data_steel);
        alloy = findViewById(R.id.data_alloy);
        obsidian = findViewById(R.id.data_obsidian);
        kyanite = findViewById(R.id.data_kyanite);
        kyanite_basic = findViewById(R.id.data_kyanite_basic);
        kyanite_cluster = findViewById(R.id.data_kyanite_cluster);
        glory_mark = findViewById(R.id.data_glory_mark);
        catalyst = findViewById(R.id.data_catalyst);
        diamond = findViewById(R.id.data_diamond);

        name1 = findViewById(R.id.mecha_name01);
        level1 = findViewById(R.id.mecha_level01);
        energy1 = findViewById(R.id.mecha_energy01);
        power1 = findViewById(R.id.mecha_power01);
        name2 = findViewById(R.id.mecha_name02);
        level2 = findViewById(R.id.mecha_level02);
        energy2 = findViewById(R.id.mecha_energy02);
        power2 = findViewById(R.id.mecha_power02);
        name3 = findViewById(R.id.mecha_name03);
        level3 = findViewById(R.id.mecha_level03);
        energy3 = findViewById(R.id.mecha_energy03);
        power3 = findViewById(R.id.mecha_power03);
        name4 = findViewById(R.id.mecha_name04);
        level4 = findViewById(R.id.mecha_level04);
        energy4 = findViewById(R.id.mecha_energy04);
        power4 = findViewById(R.id.mecha_power04);

        EXP100	=	findViewById(R.id.exp_1_et);
        EXP5K	=	findViewById(R.id.exp_2_et);
        EXP10K	=	findViewById(R.id.exp_3_et);
        EXP20K	=	findViewById(R.id.exp_4_et);
        EXP50K	=	findViewById(R.id.exp_5_et);
        EXP80K	=	findViewById(R.id.exp_6_et);
        EXP100K	=	findViewById(R.id.exp_7_et);
        EXPALL	=	findViewById(R.id.exp_total_et);

        arm10_img	 = findViewById(R.id.	arm10_img	);
        mili10_img	 = findViewById(R.id.	mili10_img	);
        mobile10_img	 = findViewById(R.id.	mobile10_img	);
        infect10_img	 = findViewById(R.id.	infect10_img	);
        project10_img	 = findViewById(R.id.	project10_img	);
        arm09_img	 = findViewById(R.id.	arm09_img	);
        mili09_img	 = findViewById(R.id.	mili09_img	);
        mobile09_img	 = findViewById(R.id.	mobile09_img	);
        infect09_img	 = findViewById(R.id.	infect09_img	);
        project09_img	 = findViewById(R.id.	project09_img	);

        arm10	=	findViewById(R.id.	arm10_tv	);
        mili10	=	findViewById(R.id.	mili10_tv	);
        mobile10	=	findViewById(R.id.	mobile10_tv	);
        infect10	=	findViewById(R.id.	infect10_tv	);
        project10	=	findViewById(R.id.	project10_tv	);
        arm09	=	findViewById(R.id.	arm09_tv	);
        mili09	=	findViewById(R.id.	mili09_tv	);
        mobile09	=	findViewById(R.id.	mobile09_tv	);
        infect09	=	findViewById(R.id.	infect09_tv	);
        project09	=	findViewById(R.id.	project09_tv	);

        ///  enabler_img_01	 = findViewById (R.id.	enabler_img_01);
        //  enabler_img_02	 = findViewById (R.id.	enabler_img_02);
        //  enabler_img_03	 = findViewById (R.id.	enabler_img_03);
        //  enabler_img_04	 = findViewById (R.id.	enabler_img_04);
        //  enabler_img_05	 = findViewById (R.id.	enabler_img_05);

        mecha_img01	 = findViewById (R.id.	mecha_img01);
        mecha_img02	 = findViewById (R.id.	mecha_img02);
        mecha_img03	 = findViewById (R.id.	mecha_img03);
        mecha_img04	 = findViewById (R.id.	mecha_img04);

        armed_id_tv	 = findViewById (R.id.	armed_process_tv);
        armed_process_tv	 = findViewById (R.id.	armed_process_time);
        armed_per	 = findViewById (R.id.	armed_process_percent);
        armed_total_tv	 = findViewById (R.id.	armed_process_total);
        //   armed_pd	 = findViewById (R.id.	armed_process_bar);
        armed_img	 = findViewById (R.id.	armed_process_img);
        armed_count_tv	 = findViewById (R.id.	armed_process_count);

        mili_id_tv	 = findViewById (R.id.	military_process_tv);
        mili_process_tv	 = findViewById (R.id.	military_process_time);
        mili_per	 = findViewById (R.id.	military_process_percent);
        mili_total_tv	 = findViewById (R.id.	military_process_total);
        //    mili_pd	 = findViewById (R.id.	military_process_bar);
        mili_img	 = findViewById (R.id.	military_process_img);
        mili_count_tv	 = findViewById (R.id.	military_process_count);

        mobile_id_tv	 = findViewById (R.id.	mobile_process_tv);
        mobile_process_tv	 = findViewById (R.id.	mobile_process_time);
        mobile_per	 = findViewById (R.id.	mobile_process_percent);
        mobile_total_tv	 = findViewById (R.id.	mobile_process_total);
        //  mobile_pd	 = findViewById (R.id.	mobile_process_bar);
        mobile_img	 = findViewById (R.id.	mobile_process_img);
        mobile_count_tv	 = findViewById (R.id.	mobile_process_count);

        infect_id_tv	 = findViewById (R.id.	infect_process_tv);
        infect_process_tv	 = findViewById (R.id.	infect_process_time);
        infect_per	 = findViewById (R.id.	infect_process_percent);
        infect_total_tv	 = findViewById (R.id.	infect_process_total);
        //      infect_pd	 = findViewById (R.id.	infect_process_bar);
        infect_img	 = findViewById (R.id.	infect_process_img);
        infect_count_tv	 = findViewById (R.id.	infect_process_count);

        project_id_tv	 = findViewById (R.id.	project_process_tv);
        project_process_tv	 = findViewById (R.id.	project_process_time);
        project_per	 = findViewById (R.id.	project_process_percent);
        project_total_tv	 = findViewById (R.id.	project_process_total);
        //     project_pd	 = findViewById (R.id.	project_process_bar);
        project_img	 = findViewById (R.id.	project_process_img);
        project_count_tv	 = findViewById (R.id.	project_process_count);

        Boomer01_tv	 = findViewById(R.id.	boom_tv1);
        Boomer02_tv	 = findViewById(R.id.	boom_tv2);
        Boomer03_tv	 = findViewById(R.id.	boom_tv3);
        Boomer04_tv	 = findViewById(R.id.	boom_tv4);
        Boomer05_tv	 = findViewById(R.id.	boom_tv5);
        Boomer06_tv	 = findViewById(R.id.	boom_tv6);
        Boomer07_tv	 = findViewById(R.id.	boom_tv7);
        Boomer08_tv	 = findViewById(R.id.	boom_tv8);
        Boomer09_tv	 = findViewById(R.id.	boom_tv9);
        Boomer10_tv	 = findViewById(R.id.	boom_tv10);
        Boomer11_tv	 = findViewById(R.id.	boom_tv11);
        Boomer12_tv	 = findViewById(R.id.	boom_tv12);
        Boomer13_tv	 = findViewById(R.id.	boom_tv13);
        Boomer14_tv	 = findViewById(R.id.	boom_tv14);
        Boomer15_tv	 = findViewById(R.id.	boom_tv15);

        Boomer01_img	 = findViewById(R.id.	boom_img1);
        Boomer02_img	 = findViewById(R.id.	boom_img2);
        Boomer03_img	 = findViewById(R.id.	boom_img3);
        Boomer04_img	 = findViewById(R.id.	boom_img4);
        Boomer05_img	 = findViewById(R.id.	boom_img5);
        Boomer06_img	 = findViewById(R.id.	boom_img6);
        Boomer07_img	 = findViewById(R.id.	boom_img7);
        Boomer08_img	 = findViewById(R.id.	boom_img8);
        Boomer09_img	 = findViewById(R.id.	boom_img9);
        Boomer10_img	 = findViewById(R.id.	boom_img10);
        Boomer11_img	 = findViewById(R.id.	boom_img11);
        Boomer12_img	 = findViewById(R.id.	boom_img12);
        Boomer13_img	 = findViewById(R.id.	boom_img13);
        Boomer14_img	 = findViewById(R.id.	boom_img14);
        Boomer15_img	 = findViewById(R.id.	boom_img15);

        arm10_img.setOnClickListener(this);
        mili10_img.setOnClickListener(this);
        mobile10_img.setOnClickListener(this);
        infect10_img.setOnClickListener(this);
        project10_img.setOnClickListener(this);
        arm09_img.setOnClickListener(this);
        mili09_img.setOnClickListener(this);
        mobile09_img.setOnClickListener(this);
        infect09_img.setOnClickListener(this);
        project09_img.setOnClickListener(this);

        armed_img.setOnClickListener(this);
        mili_img.setOnClickListener(this);
        mobile_img.setOnClickListener(this);
        infect_img.setOnClickListener(this);
        project_img.setOnClickListener(this);

        Boomer01_img	.setOnClickListener(this);
        Boomer02_img	.setOnClickListener(this);
        Boomer03_img	.setOnClickListener(this);
        Boomer04_img	.setOnClickListener(this);
        Boomer05_img	.setOnClickListener(this);
        Boomer06_img	.setOnClickListener(this);
        Boomer07_img	.setOnClickListener(this);
        Boomer08_img	.setOnClickListener(this);
        Boomer09_img	.setOnClickListener(this);
        Boomer10_img	.setOnClickListener(this);
        Boomer11_img	.setOnClickListener(this);
        Boomer12_img	.setOnClickListener(this);
        Boomer13_img	.setOnClickListener(this);
        Boomer14_img	.setOnClickListener(this);
        Boomer15_img	.setOnClickListener(this);

        mecha_img01.setImageResource(R.drawable.mecha_mecha);
        mecha_img02.setImageResource(R.drawable.mecha_land);
        mecha_img03.setImageResource(R.drawable.mecha_air);
        mecha_img04.setImageResource(R.drawable.mecha_mana);

    }
    public void cbg() {
        //取出数据（注意这里直接用实例取就行了，不用获取编辑器editor）
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String theme = sharedPreferences.getString("theme", "dark");
        String color1 = sharedPreferences.getString("color1", "F1870F");
        String color2 = sharedPreferences.getString("color2", "C56E0D");
        if (theme.equals("base")) {
            rss_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_base_alpha	));
            rss_tv	.setBackgroundColor(getResources().getColor(R.color.	background_base_press	));
            mecha_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_base_alpha	));
            mecha_tv	.setBackgroundColor(getResources().getColor(R.color.	background_base_press	));
            //   enabler_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_base_alpha	));
            //   enabler_tv	.setBackgroundColor(getResources().getColor(R.color.	background_base_press	));
            //    exp_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_base_alpha	));
            //    exp_tv	.setBackgroundColor(getResources().getColor(R.color.	background_base_press	));
            //   star_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_base_alpha	));
            //   star_tv	.setBackgroundColor(getResources().getColor(R.color.	background_base_press	));
            troop_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_base_alpha	));
            troop_tv	.setBackgroundColor(getResources().getColor(R.color.	background_base_press	));
            troop_total	.setBackgroundColor(getResources().getColor(R.color.	background_base_press	));
            progress_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_base_alpha	));
            progress_tv	.setBackgroundColor(getResources().getColor(R.color.	background_base_press	));
            boomer_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_base_alpha	));
            boomer_tv	.setBackgroundColor(getResources().getColor(R.color.	background_base_press	));
            troop_pie	.setBackgroundColor(getResources().getColor(R.color.	background_base_press	));
            boomer_total	.setBackgroundColor(getResources().getColor(R.color.	background_base_press	));
        }

        if (theme.equals("dark")) {
            rss_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_dark_alpha	));
            rss_tv	.setBackgroundColor(getResources().getColor(R.color.	background_dark_press	));
            mecha_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_dark_alpha	));
            mecha_tv	.setBackgroundColor(getResources().getColor(R.color.	background_dark_press	));
            //    enabler_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_dark_alpha	));
            //    enabler_tv	.setBackgroundColor(getResources().getColor(R.color.	background_dark_press	));
            //    exp_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_dark_alpha	));
            //    exp_tv	.setBackgroundColor(getResources().getColor(R.color.	background_dark_press	));
            //    star_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_dark_alpha	));
            //    star_tv	.setBackgroundColor(getResources().getColor(R.color.	background_dark_press	));
            troop_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_dark_alpha	));
            troop_tv	.setBackgroundColor(getResources().getColor(R.color.	background_dark_press	));
            troop_total	.setBackgroundColor(getResources().getColor(R.color.	background_dark_press	));
            progress_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_dark_alpha	));
            progress_tv	.setBackgroundColor(getResources().getColor(R.color.	background_dark_press	));
            boomer_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_dark_alpha	));
            boomer_tv	.setBackgroundColor(getResources().getColor(R.color.	background_dark_press	));
            troop_pie	.setBackgroundColor(getResources().getColor(R.color.	background_dark_press	));
            boomer_total	.setBackgroundColor(getResources().getColor(R.color.	background_dark_press	));

        }

        if (theme.equals("pink")) {
            rss_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_pink_alpha	));
            rss_tv	.setBackgroundColor(getResources().getColor(R.color.	background_pink_press	));
            mecha_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_pink_alpha	));
            mecha_tv	.setBackgroundColor(getResources().getColor(R.color.	background_pink_press	));
            //    enabler_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_pink_alpha	));
            //    enabler_tv	.setBackgroundColor(getResources().getColor(R.color.	background_pink_press	));
            //   exp_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_pink_alpha	));
            //   exp_tv	.setBackgroundColor(getResources().getColor(R.color.	background_pink_press	));
            //   star_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_pink_alpha	));
            //    star_tv	.setBackgroundColor(getResources().getColor(R.color.	background_pink_press	));
            troop_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_pink_alpha	));
            troop_tv	.setBackgroundColor(getResources().getColor(R.color.	background_pink_press	));
            troop_total	.setBackgroundColor(getResources().getColor(R.color.	background_pink_press	));
            progress_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_pink_alpha	));
            progress_tv	.setBackgroundColor(getResources().getColor(R.color.	background_pink_press	));
            boomer_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_pink_alpha	));
            boomer_tv	.setBackgroundColor(getResources().getColor(R.color.	background_pink_press	));
            troop_pie	.setBackgroundColor(getResources().getColor(R.color.	background_pink_press	));
            boomer_total	.setBackgroundColor(getResources().getColor(R.color.	background_pink_press	));

        }

        if (theme.equals("leek")) {
            rss_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_leek_alpha	));
            rss_tv	.setBackgroundColor(getResources().getColor(R.color.	background_leek_press	));
            mecha_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_leek_alpha	));
            mecha_tv	.setBackgroundColor(getResources().getColor(R.color.	background_leek_press	));
            //   enabler_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_leek_alpha	));
            //   enabler_tv	.setBackgroundColor(getResources().getColor(R.color.	background_leek_press	));
            //  exp_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_leek_alpha	));
            //   exp_tv	.setBackgroundColor(getResources().getColor(R.color.	background_leek_press	));
            //   star_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_leek_alpha	));
            //   star_tv	.setBackgroundColor(getResources().getColor(R.color.	background_leek_press	));
            troop_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_leek_alpha	));
            troop_tv	.setBackgroundColor(getResources().getColor(R.color.	background_leek_press	));
            troop_total	.setBackgroundColor(getResources().getColor(R.color.	background_leek_press	));
            progress_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_leek_alpha	));
            progress_tv	.setBackgroundColor(getResources().getColor(R.color.	background_leek_press	));
            boomer_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_leek_alpha	));
            boomer_tv	.setBackgroundColor(getResources().getColor(R.color.	background_leek_press	));
            troop_pie	.setBackgroundColor(getResources().getColor(R.color.	background_leek_press	));
            boomer_total	.setBackgroundColor(getResources().getColor(R.color.	background_leek_press	));

        }

        if (theme.equals("summer")) {
            rss_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_summer_alpha	));
            rss_tv	.setBackgroundColor(getResources().getColor(R.color.	background_summer_press	));
            mecha_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_summer_alpha	));
            mecha_tv	.setBackgroundColor(getResources().getColor(R.color.	background_summer_press	));
            //    enabler_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_summer_alpha	));
            //    enabler_tv	.setBackgroundColor(getResources().getColor(R.color.	background_summer_press	));
            //    exp_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_summer_alpha	));
            //   exp_tv	.setBackgroundColor(getResources().getColor(R.color.	background_summer_press	));
            //    star_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_summer_alpha	));
            //    star_tv	.setBackgroundColor(getResources().getColor(R.color.	background_summer_press	));
            troop_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_summer_alpha	));
            troop_tv	.setBackgroundColor(getResources().getColor(R.color.	background_summer_press	));
            troop_total	.setBackgroundColor(getResources().getColor(R.color.	background_summer_press	));
            progress_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_summer_alpha	));
            progress_tv	.setBackgroundColor(getResources().getColor(R.color.	background_summer_press	));
            boomer_tv	.setBackgroundColor(getResources().getColor(R.color.	background_summer_press	));
            boomer_total	.setBackgroundColor(getResources().getColor(R.color.	background_summer_press	));
            troop_pie	.setBackgroundColor(getResources().getColor(R.color.	background_summer_press	));
            boomer_card	.setBackgroundColor(getResources().getColor(R.color.	background_summer_alpha	));

        }
        if (theme.equals("custom")) {
            rss_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            rss_tv	.setBackgroundColor(Color.parseColor("#"+color2));
            mecha_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            mecha_tv	.setBackgroundColor(Color.parseColor("#"+color2));
            //   enabler_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            //   enabler_tv	.setBackgroundColor(Color.parseColor("#"+color2));
            //   exp_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            //   exp_tv	.setBackgroundColor(Color.parseColor("#"+color2));
            //    star_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            //    star_tv	.setBackgroundColor(Color.parseColor("#"+color2));
            troop_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            troop_tv	.setBackgroundColor(Color.parseColor("#"+color2));
            troop_total	.setBackgroundColor(Color.parseColor("#"+color2));
            progress_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            progress_tv	.setBackgroundColor(Color.parseColor("#"+color2));
            boomer_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            boomer_tv	.setBackgroundColor(Color.parseColor("#"+color2));
            troop_pie	.setBackgroundColor(Color.parseColor("#"+color2));
            boomer_total	.setBackgroundColor(Color.parseColor("#"+color2));
        }
        boolean rss_card_show = sharedPreferences.getBoolean("rss_card_show", true);
        boolean mecha_card_show = sharedPreferences.getBoolean("mecha_card_show", true);
        boolean troop_card_show = sharedPreferences.getBoolean("troop_card_show", true);
        boolean enabler_card_show = sharedPreferences.getBoolean("enabler_card_show", true);
        boolean progress_card_show = sharedPreferences.getBoolean("progress_card_show", false);
        boolean star_card_show = sharedPreferences.getBoolean("star_card_show", false);
        boolean exp_card_show = sharedPreferences.getBoolean("exp_card_show", false);
        boolean land_card_show = sharedPreferences.getBoolean("land_card_show", false);

        if (rss_card_show){rss_card.setVisibility(View.VISIBLE);}else{rss_card.setVisibility(GONE);}
        if (mecha_card_show){mecha_card.setVisibility(View.VISIBLE);}else{mecha_card.setVisibility(GONE);}
        if (troop_card_show){troop_card.setVisibility(View.VISIBLE);}else{troop_card.setVisibility(GONE);}
        //    if (enabler_card_show){enabler_card.setVisibility(View.VISIBLE);}else{enabler_card.setVisibility(GONE);}
        if (progress_card_show){progress_card.setVisibility(View.VISIBLE);}else{progress_card.setVisibility(GONE);}
        //    if (star_card_show){star_card.setVisibility(View.VISIBLE);}else{star_card.setVisibility(GONE);}
        // if (exp_card_show){exp_card.setVisibility(View.VISIBLE);}else{exp_card.setVisibility(GONE);}
        //exp_card.setVisibility(GONE);
        if (land_card_show){boomer_card.setVisibility(View.VISIBLE);}else{boomer_card.setVisibility(GONE);}
    }

    public void dataRefresh (){
        if (pd.isShowing()){pd.dismiss();}
        mHandler.sendEmptyMessageDelayed(TAKE_DATA_REFRESH, 3000);
        troop_method();
        rss();
        // exp();
        mecha();
        // enabler();
        // star();
        troop();
        boomer();

    }

    private void rss() {
        String FOOD_S , FUEL_S , STEEL_S , ALLOY_S , OBSIDIAN_S , KYANITE_S , KYANITE_BASIC_S, KYANITE_CLUSTER_S , GLORY_MARK_S , CATALYST_S , DIAMOND_S ;
        FOOD_S = prettyCount(food_final);
        FUEL_S = prettyCount(fuel_final);
        STEEL_S = prettyCount(steel_final);
        ALLOY_S = prettyCount(alloy_final);
        OBSIDIAN_S = prettyCount(obsidian_final);
        KYANITE_S = prettyCount(kyanite_final);
        KYANITE_BASIC_S = prettyCount(kyanite_basic_final);
        KYANITE_CLUSTER_S = prettyCount(kyanite_cluster_final);
        GLORY_MARK_S = prettyCount(glory_mark_final);
        CATALYST_S = prettyCount(catalyst_final);
        DIAMOND_S = prettyCount(diamond_final);

        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        boolean transform_show  = sharedPreferences.getBoolean("transform_show", true);

        String FOOD_UD = "", FUEL_UD = "", STEEL_UD = "", ALLOY_UD = "", KYAN_UD = "", KYANB_UD = "", KYANC_UD= "", OBS_UD = "", GLORY_UD = "", CATA_UD = "", DIAM_UD= "" ;

        if (transform_show){
            FOOD_UD = " ("+prettyCount2(food_final - food_re)+")";
            FUEL_UD = " ("+prettyCount2(fuel_final - fuel_re)+")";
            STEEL_UD = " ("+prettyCount2(steel_final - steel_re)+")";
            ALLOY_UD = " ("+prettyCount2(alloy_final - alloy_re)+")";
            OBS_UD =  " ("+prettyCount2(obsidian_final - obsidian_re)+")";
            KYAN_UD = " ("+prettyCount2(kyanite_final - kyanite_re)+")";
            KYANB_UD = " ("+prettyCount2(kyanite_basic_final - kyanite_basic_re)+")";
            KYANC_UD = " ("+prettyCount2(kyanite_cluster_final - kyanite_cluster_re)+")";
            GLORY_UD = " ("+prettyCount2(glory_mark_final - glory_mark_re)+")";
            CATA_UD = " ("+prettyCount2(catalyst_final - catalyst_re)+")";
            DIAM_UD = " ("+prettyCount2(diamond_final - diamond_re)+")";
        }

        food.setText(FOOD_S + FOOD_UD);
        fuel.setText(FUEL_S + FUEL_UD);
        steel.setText(STEEL_S + STEEL_UD);
        alloy.setText(ALLOY_S + ALLOY_UD);
        obsidian.setText(OBSIDIAN_S +OBS_UD);
        kyanite.setText(KYANITE_S + KYAN_UD);
        kyanite_basic.setText(KYANITE_BASIC_S + KYANB_UD);
        kyanite_cluster.setText(KYANITE_CLUSTER_S + KYANC_UD);
        glory_mark.setText(GLORY_MARK_S + GLORY_UD);
        catalyst.setText(CATALYST_S + CATA_UD);
        diamond.setText(DIAMOND_S + DIAM_UD);
    }

    private void exp() {
        String exp_total_String = null , exp_1_String = null ,	exp_2_String = null ,	exp_3_String = null ,	exp_4_String = null ,	exp_5_String = null ,	exp_6_String = null ,	exp_7_String = null ;
        //long EXP_ALL = helper.DataEXP100()*100+helper.DataEXP5K()*5000+helper.DataEXP10K()*10000+helper.DataEXP20K()*20000+helper.DataEXP50K()*50000+helper.DataEXP80K()*80000+helper.DataEXP100K()*100000;

        //TOTAL
        // exp_total_String = prettyCount(EXP_ALL);

        //EXP 500
        // exp_1_String = prettyCount(helper.DataEXP100());

        //EXP 5000
        //  exp_2_String = prettyCount(helper.DataEXP5K());

        //EXP 10000
        //  exp_3_String = prettyCount(helper.DataEXP10K());

        //EXP 20000
        //  exp_4_String = prettyCount(helper.DataEXP20K());

        //EXP 50000
        //  exp_5_String = prettyCount(helper.DataEXP50K());

        //EXP 80000
        //  exp_6_String = prettyCount(helper.DataEXP80K());

        //EXP 100000
        //  exp_7_String = prettyCount(helper.DataEXP100K());

        String EXPALL_S = prettyCount(expArray[0]*100+expArray[1]*5000+expArray[2]*10000+expArray[3]*20000+expArray[4]*50000+expArray[5]*80000+expArray[6]*100000);
        EXPALL.setText(EXPALL_S);
        EXP100.setText(prettyCount(expArray[0]));
        EXP5K.setText(prettyCount(expArray[1]));
        EXP10K.setText(prettyCount(expArray[2]));
        EXP20K.setText(prettyCount(expArray[3]));
        EXP50K.setText(prettyCount(expArray[4]));
        EXP80K.setText(prettyCount(expArray[5]));
        EXP100K.setText(prettyCount(expArray[6]));
    }

    private void mecha() {
        String lv = getResources().getString((R.string.lv))+" ";
        String atk = getResources().getString((R.string.atk));

        Log.i("mechaLvArray2",prettyCount(mechaLvArray2[0]));
        Log.i("mechaLvArray2",prettyCount(mechaLvArray2[1]));

        if (mechaNameArray2[0] != null &&mechaNameArray2[0].equals("Mecha")){mechaNameArray[0] = "Mecha" ; mechaLvArray[0] = mechaLvArray2[0];Log.i("ok","ok");}
        else if (mechaNameArray2[1] != null &&mechaNameArray2[1].equals("Mecha")){mechaNameArray[0] = "Mecha" ; mechaLvArray[0] = mechaLvArray2[1];}
        else if (mechaNameArray2[2] != null &&mechaNameArray2[2].equals("Mecha")){mechaNameArray[0] = "Mecha" ; mechaLvArray[0] = mechaLvArray2[2];}
        else if (mechaNameArray2[3] != null &&mechaNameArray2[3].equals("Mecha")){mechaNameArray[0] = "Mecha" ; mechaLvArray[0] = mechaLvArray2[3];}

        if (mechaNameArray2[0] != null &&mechaNameArray2[0].equals("Land Mecha")){mechaNameArray[1] = "Land Mecha" ; mechaLvArray[1] = mechaLvArray2[0];}
        else if (mechaNameArray2[1] != null &&mechaNameArray2[1].equals("Land Mecha")){mechaNameArray[1] = "Land Mecha" ; mechaLvArray[1] = mechaLvArray2[1];}
        else if (mechaNameArray2[2] != null &&mechaNameArray2[2].equals("Land Mecha")){mechaNameArray[1] = "Land Mecha" ; mechaLvArray[1] = mechaLvArray2[2];}
        else if (mechaNameArray2[3] != null &&mechaNameArray2[3].equals("Land Mecha")){mechaNameArray[1] = "Land Mecha" ; mechaLvArray[1] = mechaLvArray2[3];}

        if (mechaNameArray2[0] != null &&mechaNameArray2[0].equals("Air Mecha")){mechaNameArray[2] = "Air Mecha" ; mechaLvArray[2] = mechaLvArray2[0];}
        else if (mechaNameArray2[1] != null &&mechaNameArray2[1].equals("Air Mecha")){mechaNameArray[2] = "Air Mecha" ; mechaLvArray[2] = mechaLvArray2[1];}
        else if (mechaNameArray2[2] != null &&mechaNameArray2[2].equals("Air Mecha")){mechaNameArray[2] = "Air Mecha" ; mechaLvArray[2] = mechaLvArray2[2];}
        else if (mechaNameArray2[3] != null &&mechaNameArray2[3].equals("Air Mecha")){mechaNameArray[2] = "Air Mecha" ; mechaLvArray[2] = mechaLvArray2[3];}

        if (mechaNameArray2[0] != null &&mechaNameArray2[0].equals("Mana Mecha")){mechaNameArray[3] = "Mana Mecha" ; mechaLvArray[3] = mechaLvArray2[0];}
        else if (mechaNameArray2[1] != null &&mechaNameArray2[1].equals("Mana Mecha")){mechaNameArray[3] = "Mana Mecha" ; mechaLvArray[3] = mechaLvArray2[1];}
        else if (mechaNameArray2[2] != null &&mechaNameArray2[2].equals("Mana Mecha")){mechaNameArray[3] = "Mana Mecha" ; mechaLvArray[3] = mechaLvArray2[2];}
        else if (mechaNameArray2[3] != null &&mechaNameArray2[3].equals("Mana Mecha")){mechaNameArray[3] = "Mana Mecha" ; mechaLvArray[3] = mechaLvArray2[3];}

        level1.setText(lv+prettyCount(mechaLvArray[0]));
        level2.setText(lv+prettyCount(mechaLvArray[1]));
        level3.setText(lv+prettyCount(mechaLvArray[2]));
        level4.setText(lv+prettyCount(mechaLvArray[3]));
    }

    private void enabler() {
        String lv = getResources().getString((R.string.lv))+" ";
        TextView	ename01	 = findViewById(R.id.	enabler_name01);	TextView	epower01	 = findViewById(R.id.	enabler_power01);	TextView	elevel01	 = findViewById(R.id.	enabler_level01);
        TextView	ename02	 = findViewById(R.id.	enabler_name02);	TextView	epower02	 = findViewById(R.id.	enabler_power02);	TextView	elevel02	 = findViewById(R.id.	enabler_level02);
        TextView	ename03	 = findViewById(R.id.	enabler_name03);	TextView	epower03	 = findViewById(R.id.	enabler_power03);	TextView	elevel03	 = findViewById(R.id.	enabler_level03);
        TextView	ename04	 = findViewById(R.id.	enabler_name04);	TextView	epower04	 = findViewById(R.id.	enabler_power04);	TextView	elevel04	 = findViewById(R.id.	enabler_level04);
        TextView	ename05	 = findViewById(R.id.	enabler_name05);	TextView	epower05	 = findViewById(R.id.	enabler_power05);	TextView	elevel05	 = findViewById(R.id.	enabler_level05);
        TextView	ename06	 = findViewById(R.id.	enabler_name06);	TextView	epower06	 = findViewById(R.id.	enabler_power06);	TextView	elevel06	 = findViewById(R.id.	enabler_level06);
        TextView	ename07	 = findViewById(R.id.	enabler_name07);	TextView	epower07	 = findViewById(R.id.	enabler_power07);	TextView	elevel07	 = findViewById(R.id.	enabler_level07);
        TextView	ename08	 = findViewById(R.id.	enabler_name08);	TextView	epower08	 = findViewById(R.id.	enabler_power08);	TextView	elevel08	 = findViewById(R.id.	enabler_level08);
        TextView	ename09	 = findViewById(R.id.	enabler_name09);	TextView	epower09	 = findViewById(R.id.	enabler_power09);	TextView	elevel09	 = findViewById(R.id.	enabler_level09);
        TextView	ename10	 = findViewById(R.id.	enabler_name10);	TextView	epower10	 = findViewById(R.id.	enabler_power10);	TextView	elevel10	 = findViewById(R.id.	enabler_level10);
        TextView	ename11	 = findViewById(R.id.	enabler_name11);	TextView	epower11	 = findViewById(R.id.	enabler_power11);	TextView	elevel11	 = findViewById(R.id.	enabler_level11);
        TextView	ename12	 = findViewById(R.id.	enabler_name12);	TextView	epower12	 = findViewById(R.id.	enabler_power12);	TextView	elevel12	 = findViewById(R.id.	enabler_level12);
        TextView	ename13	 = findViewById(R.id.	enabler_name13);	TextView	epower13	 = findViewById(R.id.	enabler_power13);	TextView	elevel13	 = findViewById(R.id.	enabler_level13);
        TextView	ename14	 = findViewById(R.id.	enabler_name14);	TextView	epower14	 = findViewById(R.id.	enabler_power14);	TextView	elevel14	 = findViewById(R.id.	enabler_level14);
        TextView	ename15	 = findViewById(R.id.	enabler_name15);	TextView	epower15	 = findViewById(R.id.	enabler_power15);	TextView	elevel15	 = findViewById(R.id.	enabler_level15);
        TextView	ename16	 = findViewById(R.id.	enabler_name16);	TextView	epower16	 = findViewById(R.id.	enabler_power16);	TextView	elevel16	 = findViewById(R.id.	enabler_level16);
        TextView	ename17	 = findViewById(R.id.	enabler_name17);	TextView	epower17	 = findViewById(R.id.	enabler_power17);	TextView	elevel17	 = findViewById(R.id.	enabler_level17);
        TextView	ename18	 = findViewById(R.id.	enabler_name18);	TextView	epower18	 = findViewById(R.id.	enabler_power18);	TextView	elevel18	 = findViewById(R.id.	enabler_level18);
        TextView	ename19	 = findViewById(R.id.	enabler_name19);	TextView	epower19	 = findViewById(R.id.	enabler_power19);	TextView	elevel19	 = findViewById(R.id.	enabler_level19);
        TextView	ename20	 = findViewById(R.id.	enabler_name20);	TextView	epower20	 = findViewById(R.id.	enabler_power20);	TextView	elevel20	 = findViewById(R.id.	enabler_level20);
        TextView	ename21	 = findViewById(R.id.	enabler_name21);	TextView	epower21	 = findViewById(R.id.	enabler_power21);	TextView	elevel21	 = findViewById(R.id.	enabler_level21);
        TextView	ename22	 = findViewById(R.id.	enabler_name22);	TextView	epower22	 = findViewById(R.id.	enabler_power22);	TextView	elevel22	 = findViewById(R.id.	enabler_level22);
        TextView	ename23	 = findViewById(R.id.	enabler_name23);	TextView	epower23	 = findViewById(R.id.	enabler_power23);	TextView	elevel23	 = findViewById(R.id.	enabler_level23);
        TextView	ename24	 = findViewById(R.id.	enabler_name24);	TextView	epower24	 = findViewById(R.id.	enabler_power24);	TextView	elevel24	 = findViewById(R.id.	enabler_level24);
        TextView	ename25	 = findViewById(R.id.	enabler_name25);	TextView	epower25	 = findViewById(R.id.	enabler_power25);	TextView	elevel25	 = findViewById(R.id.	enabler_level25);
        TextView	ename26	 = findViewById(R.id.	enabler_name26);	TextView	epower26	 = findViewById(R.id.	enabler_power26);	TextView	elevel26	 = findViewById(R.id.	enabler_level26);
        TextView	ename27	 = findViewById(R.id.	enabler_name27);	TextView	epower27	 = findViewById(R.id.	enabler_power27);	TextView	elevel27	 = findViewById(R.id.	enabler_level27);
        TextView	ename28	 = findViewById(R.id.	enabler_name28);	TextView	epower28	 = findViewById(R.id.	enabler_power28);	TextView	elevel28	 = findViewById(R.id.	enabler_level28);
        TextView	ename29	 = findViewById(R.id.	enabler_name29);	TextView	epower29	 = findViewById(R.id.	enabler_power29);	TextView	elevel29	 = findViewById(R.id.	enabler_level29);
        TextView	ename30	 = findViewById(R.id.	enabler_name30);	TextView	epower30	 = findViewById(R.id.	enabler_power30);	TextView	elevel30	 = findViewById(R.id.	enabler_level30);
        TextView	ename31	 = findViewById(R.id.	enabler_name31);	TextView	epower31	 = findViewById(R.id.	enabler_power31);	TextView	elevel31	 = findViewById(R.id.	enabler_level31);
        TextView	ename32	 = findViewById(R.id.	enabler_name32);	TextView	epower32	 = findViewById(R.id.	enabler_power32);	TextView	elevel32	 = findViewById(R.id.	enabler_level32);
        TextView	ename33	 = findViewById(R.id.	enabler_name33);	TextView	epower33	 = findViewById(R.id.	enabler_power33);	TextView	elevel33	 = findViewById(R.id.	enabler_level33);
        TextView	ename34	 = findViewById(R.id.	enabler_name34);	TextView	epower34	 = findViewById(R.id.	enabler_power34);	TextView	elevel34	 = findViewById(R.id.	enabler_level34);
        TextView	ename35	 = findViewById(R.id.	enabler_name35);	TextView	epower35	 = findViewById(R.id.	enabler_power35);	TextView	elevel35	 = findViewById(R.id.	enabler_level35);
        TextView	ename36	 = findViewById(R.id.	enabler_name36);	TextView	epower36	 = findViewById(R.id.	enabler_power36);	TextView	elevel36	 = findViewById(R.id.	enabler_level36);
        TextView	ename37	 = findViewById(R.id.	enabler_name37);	TextView	epower37	 = findViewById(R.id.	enabler_power37);	TextView	elevel37	 = findViewById(R.id.	enabler_level37);
        TextView	ename38	 = findViewById(R.id.	enabler_name38);	TextView	epower38	 = findViewById(R.id.	enabler_power38);	TextView	elevel38	 = findViewById(R.id.	enabler_level38);
        TextView	ename39	 = findViewById(R.id.	enabler_name39);	TextView	epower39	 = findViewById(R.id.	enabler_power39);	TextView	elevel39	 = findViewById(R.id.	enabler_level39);
        TextView	ename40	 = findViewById(R.id.	enabler_name40);	TextView	epower40	 = findViewById(R.id.	enabler_power40);	TextView	elevel40	 = findViewById(R.id.	enabler_level40);
        TextView	ename41	 = findViewById(R.id.	enabler_name41);	TextView	epower41	 = findViewById(R.id.	enabler_power41);	TextView	elevel41	 = findViewById(R.id.	enabler_level41);
        TextView	ename42	 = findViewById(R.id.	enabler_name42);	TextView	epower42	 = findViewById(R.id.	enabler_power42);	TextView	elevel42	 = findViewById(R.id.	enabler_level42);
        TextView	ename43	 = findViewById(R.id.	enabler_name43);	TextView	epower43	 = findViewById(R.id.	enabler_power43);	TextView	elevel43	 = findViewById(R.id.	enabler_level43);
        TextView	ename44	 = findViewById(R.id.	enabler_name44);	TextView	epower44	 = findViewById(R.id.	enabler_power44);	TextView	elevel44	 = findViewById(R.id.	enabler_level44);
        TextView	ename45	 = findViewById(R.id.	enabler_name45);	TextView	epower45	 = findViewById(R.id.	enabler_power45);	TextView	elevel45	 = findViewById(R.id.	enabler_level45);
        TextView	ename46	 = findViewById(R.id.	enabler_name46);	TextView	epower46	 = findViewById(R.id.	enabler_power46);	TextView	elevel46	 = findViewById(R.id.	enabler_level46);
        TextView	ename47	 = findViewById(R.id.	enabler_name47);	TextView	epower47	 = findViewById(R.id.	enabler_power47);	TextView	elevel47	 = findViewById(R.id.	enabler_level47);
        TextView	ename48	 = findViewById(R.id.	enabler_name48);	TextView	epower48	 = findViewById(R.id.	enabler_power48);	TextView	elevel48	 = findViewById(R.id.	enabler_level48);
        TextView	ename49	 = findViewById(R.id.	enabler_name49);	TextView	epower49	 = findViewById(R.id.	enabler_power49);	TextView	elevel49	 = findViewById(R.id.	enabler_level49);
        TextView	ename50	 = findViewById(R.id.	enabler_name50);	TextView	epower50	 = findViewById(R.id.	enabler_power50);	TextView	elevel50	 = findViewById(R.id.	enabler_level50);

        elevel02	.setText(lv+enablerLvArray[0]);
        elevel01	.setText(lv+enablerLvArray[1]);
        elevel06	.setText(lv+enablerLvArray[2]);
        elevel05	.setText(lv+enablerLvArray[3]);
        elevel04	.setText(lv+enablerLvArray[4]);
        elevel03	.setText(lv+enablerLvArray[5]);
        elevel10	.setText(lv+enablerLvArray[6]);
        elevel09	.setText(lv+enablerLvArray[7]);
        elevel08	.setText(lv+enablerLvArray[8]);
        elevel07	.setText(lv+enablerLvArray[9]);
        elevel14	.setText(lv+enablerLvArray[10]);
        elevel13	.setText(lv+enablerLvArray[11]);
        elevel12	.setText(lv+enablerLvArray[12]);
        elevel11	.setText(lv+enablerLvArray[13]);
        elevel18	.setText(lv+enablerLvArray[14]);
        elevel17	.setText(lv+enablerLvArray[15]);
        elevel16	.setText(lv+enablerLvArray[16]);
        elevel15	.setText(lv+enablerLvArray[17]);
        elevel22	.setText(lv+enablerLvArray[18]);
        elevel21	.setText(lv+enablerLvArray[19]);
        elevel20	.setText(lv+enablerLvArray[20]);
        elevel19	.setText(lv+enablerLvArray[21]);
        elevel26	.setText(lv+enablerLvArray[22]);
        elevel25	.setText(lv+enablerLvArray[23]);
        elevel24	.setText(lv+enablerLvArray[24]);
        elevel23	.setText(lv+enablerLvArray[25]);
        elevel30	.setText(lv+enablerLvArray[26]);
        elevel29	.setText(lv+enablerLvArray[27]);
        elevel28	.setText(lv+enablerLvArray[28]);
        elevel27	.setText(lv+enablerLvArray[29]);
        elevel34	.setText(lv+enablerLvArray[30]);
        elevel33	.setText(lv+enablerLvArray[31]);
        elevel32	.setText(lv+enablerLvArray[32]);
        elevel31	.setText(lv+enablerLvArray[33]);
        elevel38	.setText(lv+enablerLvArray[34]);
        elevel37	.setText(lv+enablerLvArray[35]);
        elevel36	.setText(lv+enablerLvArray[36]);
        elevel35	.setText(lv+enablerLvArray[37]);
        elevel42	.setText(lv+enablerLvArray[38]);
        elevel41	.setText(lv+enablerLvArray[39]);
        elevel40	.setText(lv+enablerLvArray[40]);
        elevel39	.setText(lv+enablerLvArray[41]);
        elevel46	.setText(lv+enablerLvArray[42]);
        elevel45	.setText(lv+enablerLvArray[43]);
        elevel44	.setText(lv+enablerLvArray[44]);
        elevel43	.setText(lv+enablerLvArray[45]);
        elevel50	.setText(lv+enablerLvArray[46]);
        elevel49	.setText(lv+enablerLvArray[47]);
        elevel48	.setText(lv+enablerLvArray[48]);
        elevel47	.setText(lv+enablerLvArray[49]);

        if (enablerLvArray[0] 	 == 0 ) {	elevel02	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[1]	 == 0 ) {	elevel01	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[2]	 == 0 ) {	elevel06	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[3]	 == 0 ) {	elevel05	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[4]	 == 0 ) {	elevel04	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[5]	 == 0 ) {	elevel03	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[6]	 == 0 ) {	elevel10	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[7]	 == 0 ) {	elevel09	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[8]	 == 0 ) {	elevel08	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[9]	 == 0 ) {	elevel07	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[10]	 == 0 ) {	elevel14	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[11]	 == 0 ) {	elevel13	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[12]	 == 0 ) {	elevel12	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[13]	 == 0 ) {	elevel11	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[14]	 == 0 ) {	elevel18	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[15]	 == 0 ) {	elevel17	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[16]	 == 0 ) {	elevel16	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[17]	 == 0 ) {	elevel15	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[18]	 == 0 ) {	elevel22	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[19]	 == 0 ) {	elevel21	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[20]	 == 0 ) {	elevel20	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[21]	 == 0 ) {	elevel19	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[22]	 == 0 ) {	elevel26	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[23]	 == 0 ) {	elevel25	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[24]	 == 0 ) {	elevel24	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[25]	 == 0 ) {	elevel23	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[26]	 == 0 ) {	elevel30	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[27]	 == 0 ) {	elevel29	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[28]	 == 0 ) {	elevel28	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[29]	 == 0 ) {	elevel27	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[30]	 == 0 ) {	elevel34	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[31]	 == 0 ) {	elevel33	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[32]	 == 0 ) {	elevel32	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[33]	 == 0 ) {	elevel31	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[34]	 == 0 ) {	elevel38	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[35]	 == 0 ) {	elevel37	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[36]	 == 0 ) {	elevel36	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[37]	 == 0 ) {	elevel35	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[38]	 == 0 ) {	elevel42	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[39]	 == 0 ) {	elevel41	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[40]	 == 0 ) {	elevel40	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[41]	 == 0 ) {	elevel39	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[42]	 == 0 ) {	elevel46	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[43]	 == 0 ) {	elevel45	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[44]	 == 0 ) {	elevel44	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[45]	 == 0 ) {	elevel43	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[46]	 == 0 ) {	elevel50	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[47]	 == 0 ) {	elevel49	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[48]	 == 0 ) {	elevel48	.setText(getString(R.string.enabler_s01));}
        if (enablerLvArray[49]	 == 0 ) {	elevel47	.setText(getString(R.string.enabler_s01));}


    }

    private void star(){
        starReName(0 , star01);
        starReName(1 , star02);
        starReName(2 , star03);
        starReName(3 , star04);



        if (starArray[0] == 0 && starArray[1] == 0 && starArray[2] == 0 && starArray[3] == 0)   {starName.setText("");}
        if (starArray[0] == 1 && starArray[1] == 4 && starArray[2] == 0 && starArray[3] == 0)   {starName.setText(getString(R.string.star01));}
        if (starArray[0] == 2 && starArray[1] == 7 && starArray[2] == 0 && starArray[3] == 0)   {starName.setText(getString(R.string.star02));}
        if (starArray[0] == 2 && starArray[1] == 4 && starArray[2] == 8 && starArray[3] == 0)   {starName.setText(getString(R.string.star03));}
        if (starArray[0] == 4 && starArray[1] == 6 && starArray[2] == 9 && starArray[3] == 0)   {starName.setText(getString(R.string.star04));}
        if (starArray[0] == 3 && starArray[1] == 6 && starArray[2] == 10 && starArray[3] == 0)   {starName.setText(getString(R.string.star05));}
        if (starArray[0] == 6 && starArray[1] == 9 && starArray[2] == 11 && starArray[3] == 0)   {starName.setText(getString(R.string.star06));}
        if (starArray[0] == 3 && starArray[1] == 10 && starArray[2] == 12 && starArray[3] == 0)   {starName.setText(getString(R.string.star07));}
        if (starArray[0] == 8 && starArray[1] == 11 && starArray[2] == 12 && starArray[3] == 0)   {starName.setText(getString(R.string.star08));}
        if (starArray[0] == 9 && starArray[1] == 11 && starArray[2] == 13 && starArray[3] == 0)   {starName.setText(getString(R.string.star09));}
        if (starArray[0] == 6 && starArray[1] == 10 && starArray[2] == 14 && starArray[3] == 0)   {starName.setText(getString(R.string.star10));}
        if (starArray[0] == 8 && starArray[1] == 13 && starArray[2] == 14 && starArray[3] == 0)   {starName.setText(getString(R.string.star11));}
        if (starArray[0] == 9 && starArray[1] == 12 && starArray[2] == 14 && starArray[3] == 0)   {starName.setText(getString(R.string.star12));}
        if (starArray[0] == 3 && starArray[1] == 4 && starArray[2] == 15 && starArray[3] == 0)   {starName.setText(getString(R.string.star13));}
        if (starArray[0] == 4 && starArray[1] == 14 && starArray[2] == 15 && starArray[3] == 0)   {starName.setText(getString(R.string.star14));}
        if (starArray[0] == 2 && starArray[1] == 5 && starArray[2] == 8 && starArray[3] == 16)   {starName.setText(getString(R.string.star15));}
        if (starArray[0] == 4 && starArray[1] == 8 && starArray[2] == 14 && starArray[3] == 16)   {starName.setText(getString(R.string.star16));}
        if (starArray[0] == 2 && starArray[1] == 8 && starArray[2] == 13 && starArray[3] == 15)   {starName.setText(getString(R.string.star17));}
        if (starArray[0] == 3 && starArray[1] == 5 && starArray[2] == 9 && starArray[3] == 17)   {starName.setText(getString(R.string.star18));}
        if (starArray[0] == 6 && starArray[1] == 10 && starArray[2] == 15 && starArray[3] == 17)   {starName.setText(getString(R.string.star19));}
        if (starArray[0] == 9 && starArray[1] == 14 && starArray[2] == 16 && starArray[3] == 17)   {starName.setText(getString(R.string.star20));}
        if (starArray[0] == 3 && starArray[1] == 13 && starArray[2] == 15 && starArray[3] == 16)   {starName.setText(getString(R.string.star21));}
        if (starArray[0] == 4 && starArray[1] == 8 && starArray[2] == 15 && starArray[3] == 18)   {starName.setText(getString(R.string.star22));}
        if (starArray[0] == 3 && starArray[1] == 6 && starArray[2] == 17 && starArray[3] == 18)   {starName.setText(getString(R.string.star23));}
        if (starArray[0] == 2 && starArray[1] == 4 && starArray[2] == 7 && starArray[3] == 18)   {starName.setText(getString(R.string.star24));}
        if (starArray[0] == 5 && starArray[1] == 6 && starArray[2] == 10 && starArray[3] == 19)   {starName.setText(getString(R.string.star25));}
        if (starArray[0] == 5 && starArray[1] == 15 && starArray[2] == 17 && starArray[3] == 19)   {starName.setText(getString(R.string.star26));}
        if (starArray[0] == 5 && starArray[1] == 14 && starArray[2] == 18 && starArray[3] == 19)   {starName.setText(getString(R.string.star27));}
        if (starArray[0] == 15 && starArray[1] == 17 && starArray[2] == 18 && starArray[3] == 19)   {starName.setText(getString(R.string.star28));}
        if (starArray[0] == 4 && starArray[1] == 5 && starArray[2] == 17 && starArray[3] == 20)   {starName.setText(getString(R.string.star29));}
        if (starArray[0] == 14 && starArray[1] == 17 && starArray[2] == 18 && starArray[3] == 20)   {starName.setText(getString(R.string.star30));}
        if (starArray[0] == 12 && starArray[1] == 14 && starArray[2] == 17 && starArray[3] == 20)   {starName.setText(getString(R.string.star31));}

    }

    private void troop(){
        String T_TEMP00 = prettyCount(	armyFreeNumArray[ 0]+	armyMarchNumArray[ 0 ] +	armyFreeNumArray[ 1]+	armyMarchNumArray[ 1 ] +	armyFreeNumArray[ 2]+	armyMarchNumArray[ 2 ] +	armyFreeNumArray[ 3]+	armyMarchNumArray[ 3 ] +	armyFreeNumArray[ 4]+	armyMarchNumArray[ 4 ] +	armyFreeNumArray[ 5]+	armyMarchNumArray[ 5 ] +	armyFreeNumArray[ 6]+	armyMarchNumArray[ 6 ] +	armyFreeNumArray[ 7]+	armyMarchNumArray[ 7 ] +	armyFreeNumArray[ 8]+	armyMarchNumArray[ 8 ] +	armyFreeNumArray[ 9]+	armyMarchNumArray[ 9 ] +	armyFreeNumArray[ 10]+	armyMarchNumArray[ 10 ] +	armyFreeNumArray[ 11]+	armyMarchNumArray[ 11 ] +	armyFreeNumArray[ 12]+	armyMarchNumArray[ 12 ] +	armyFreeNumArray[ 13]+	armyMarchNumArray[ 13 ] +	armyFreeNumArray[ 14]+	armyMarchNumArray[ 14 ] +	armyFreeNumArray[ 15]+	armyMarchNumArray[ 15 ] +	armyFreeNumArray[ 16]+	armyMarchNumArray[ 16 ] +	armyFreeNumArray[ 17]+	armyMarchNumArray[ 17 ] +	armyFreeNumArray[ 18]+	armyMarchNumArray[ 18 ] +	armyFreeNumArray[ 19]+	armyMarchNumArray[ 19 ] +	armyFreeNumArray[ 20]+	armyMarchNumArray[ 20 ] +	armyFreeNumArray[ 21]+	armyMarchNumArray[ 21 ] +	armyFreeNumArray[ 22]+	armyMarchNumArray[ 22 ] +	armyFreeNumArray[ 23]+	armyMarchNumArray[ 23 ] +	armyFreeNumArray[ 24]+	armyMarchNumArray[ 24 ] +	armyFreeNumArray[ 25]+	armyMarchNumArray[ 25 ] +	armyFreeNumArray[ 26]+	armyMarchNumArray[ 26 ] +	armyFreeNumArray[ 27]+	armyMarchNumArray[ 27 ] +	armyFreeNumArray[ 28]+	armyMarchNumArray[ 28 ] +	armyFreeNumArray[ 29]+	armyMarchNumArray[ 29 ] +	armyFreeNumArray[ 30]+	armyMarchNumArray[ 30 ] +	armyFreeNumArray[ 31]+	armyMarchNumArray[ 31 ] +	armyFreeNumArray[ 32]+	armyMarchNumArray[ 32 ] +	armyFreeNumArray[ 33]+	armyMarchNumArray[ 33 ] +	armyFreeNumArray[ 34]+	armyMarchNumArray[ 34 ] +	armyFreeNumArray[ 35]+	armyMarchNumArray[ 35 ] +	armyFreeNumArray[ 36]+	armyMarchNumArray[ 36 ] +	armyFreeNumArray[ 37]+	armyMarchNumArray[ 37 ] +	armyFreeNumArray[ 38]+	armyMarchNumArray[ 38 ] +	armyFreeNumArray[ 39]+	armyMarchNumArray[ 39 ] +	armyFreeNumArray[ 40]+	armyMarchNumArray[ 40 ] +	armyFreeNumArray[ 41]+	armyMarchNumArray[ 41 ] +	armyFreeNumArray[ 42]+	armyMarchNumArray[ 42 ] +	armyFreeNumArray[ 43]+	armyMarchNumArray[ 43 ] +	armyFreeNumArray[ 44]+	armyMarchNumArray[ 44 ] +	armyFreeNumArray[ 45]+	armyMarchNumArray[ 45 ] +	armyFreeNumArray[ 46]+	armyMarchNumArray[ 46 ] +	armyFreeNumArray[ 47]+	armyMarchNumArray[ 47 ] +	armyFreeNumArray[ 48]+	armyMarchNumArray[ 48 ] +	armyFreeNumArray[ 49]+	armyMarchNumArray[ 49 ]) ;
        troop_total.setText(getString(R.string.troop_total)+" "+T_TEMP00+" ");
        ArrayList troopList = new ArrayList();
        troopList.add(armyFreeNumArray[ 0  ]+	armyMarchNumArray[  0  ]);
        troopList.add(armyFreeNumArray[ 1  ]+	armyMarchNumArray[  1  ]);
        troopList.add(armyFreeNumArray[ 2  ]+	armyMarchNumArray[  2  ]);
        troopList.add(armyFreeNumArray[ 3  ]+	armyMarchNumArray[  3  ]);
        troopList.add(armyFreeNumArray[ 4  ]+	armyMarchNumArray[  4  ]);
        troopList.add(armyFreeNumArray[ 5  ]+	armyMarchNumArray[  5  ]);
        troopList.add(armyFreeNumArray[ 6  ]+	armyMarchNumArray[  6  ]);
        troopList.add(armyFreeNumArray[ 7  ]+	armyMarchNumArray[  7  ]);
        troopList.add(armyFreeNumArray[ 8  ]+	armyMarchNumArray[  8  ]);
        troopList.add(armyFreeNumArray[ 9  ]+	armyMarchNumArray[  9  ]);
        troopList.add(armyFreeNumArray[ 10  ]+	armyMarchNumArray[  10  ]);
        troopList.add(armyFreeNumArray[ 11  ]+	armyMarchNumArray[  11  ]);
        troopList.add(armyFreeNumArray[ 12  ]+	armyMarchNumArray[  12  ]);
        troopList.add(armyFreeNumArray[ 13  ]+	armyMarchNumArray[  13  ]);
        troopList.add(armyFreeNumArray[ 14  ]+	armyMarchNumArray[  14  ]);
        troopList.add(armyFreeNumArray[ 15  ]+	armyMarchNumArray[  15  ]);
        troopList.add(armyFreeNumArray[ 16  ]+	armyMarchNumArray[  16  ]);
        troopList.add(armyFreeNumArray[ 17  ]+	armyMarchNumArray[  17  ]);
        troopList.add(armyFreeNumArray[ 18  ]+	armyMarchNumArray[  18  ]);
        troopList.add(armyFreeNumArray[ 19  ]+	armyMarchNumArray[  19  ]);
        troopList.add(armyFreeNumArray[ 20  ]+	armyMarchNumArray[  20  ]);
        troopList.add(armyFreeNumArray[ 21  ]+	armyMarchNumArray[  21  ]);
        troopList.add(armyFreeNumArray[ 22  ]+	armyMarchNumArray[  22  ]);
        troopList.add(armyFreeNumArray[ 23  ]+	armyMarchNumArray[  23  ]);
        troopList.add(armyFreeNumArray[ 24  ]+	armyMarchNumArray[  24  ]);
        troopList.add(armyFreeNumArray[ 25  ]+	armyMarchNumArray[  25  ]);
        troopList.add(armyFreeNumArray[ 26  ]+	armyMarchNumArray[  26  ]);
        troopList.add(armyFreeNumArray[ 27  ]+	armyMarchNumArray[  27  ]);
        troopList.add(armyFreeNumArray[ 28  ]+	armyMarchNumArray[  28  ]);
        troopList.add(armyFreeNumArray[ 29  ]+	armyMarchNumArray[  29  ]);
        troopList.add(armyFreeNumArray[ 30  ]+	armyMarchNumArray[  30  ]);
        troopList.add(armyFreeNumArray[ 31  ]+	armyMarchNumArray[  31  ]);
        troopList.add(armyFreeNumArray[ 32  ]+	armyMarchNumArray[  32  ]);
        troopList.add(armyFreeNumArray[ 33  ]+	armyMarchNumArray[  33  ]);
        troopList.add(armyFreeNumArray[ 34  ]+	armyMarchNumArray[  34  ]);
        troopList.add(armyFreeNumArray[ 35  ]+	armyMarchNumArray[  35  ]);
        troopList.add(armyFreeNumArray[ 36  ]+	armyMarchNumArray[  36  ]);
        troopList.add(armyFreeNumArray[ 37  ]+	armyMarchNumArray[  37  ]);
        troopList.add(armyFreeNumArray[ 38  ]+	armyMarchNumArray[  38  ]);
        troopList.add(armyFreeNumArray[ 39  ]+	armyMarchNumArray[  39  ]);
        troopList.add(armyFreeNumArray[ 40  ]+	armyMarchNumArray[  40  ]);
        troopList.add(armyFreeNumArray[ 41  ]+	armyMarchNumArray[  41  ]);
        troopList.add(armyFreeNumArray[ 42  ]+	armyMarchNumArray[  42  ]);
        troopList.add(armyFreeNumArray[ 43  ]+	armyMarchNumArray[  43  ]);
        troopList.add(armyFreeNumArray[ 44  ]+	armyMarchNumArray[  44  ]);
        troopList.add(armyFreeNumArray[ 45  ]+	armyMarchNumArray[  45  ]);
        troopList.add(armyFreeNumArray[ 46  ]+	armyMarchNumArray[  46  ]);
        troopList.add(armyFreeNumArray[ 47  ]+	armyMarchNumArray[  47  ]);
        troopList.add(armyFreeNumArray[ 48  ]+	armyMarchNumArray[  48  ]);
        troopList.add(armyFreeNumArray[ 49  ]+	armyMarchNumArray[  49  ]);


        SortArrayListAscendingDescending sortArrayList = new SortArrayListAscendingDescending(troopList);

        sortedArrayListDescending = sortArrayList.sortDescending();
        sorted();
        arm10.setText(prettyCount(sortedArrayListDescending.get(0)));
        mili10.setText(prettyCount(sortedArrayListDescending.get(1)));
        mobile10.setText(prettyCount(sortedArrayListDescending.get(2)));
        infect10.setText(prettyCount(sortedArrayListDescending.get(3)));
        project10.setText(prettyCount(sortedArrayListDescending.get(4)));
        arm09.setText(prettyCount(sortedArrayListDescending.get(5)));
        mili09.setText(prettyCount(sortedArrayListDescending.get(6)));
        mobile09.setText(prettyCount(sortedArrayListDescending.get(7)));
        infect09.setText(prettyCount(sortedArrayListDescending.get(8)));
        project09.setText(prettyCount(sortedArrayListDescending.get(9)));
    }

    public void progressRefresh (){

        mHandler.sendEmptyMessageDelayed(PROGRESS_REFRESH, 1000);

        if (armyFinishNumArray[0] 	 !=0){progressTotalArray[0] =	armyFinishNumArray[0];	; progressCountArray[0] = 	armyIdNumArray[0]	; progressCountArray[0] = 	armyCountNumArray[0];}
        if (armyFinishNumArray[1]	 !=0){progressTotalArray[0] =	armyFinishNumArray[1];	; progressIdArray[0] = 	armyIdNumArray[1]	; progressCountArray[0] = 	armyCountNumArray[1];}
        if (armyFinishNumArray[2]	 !=0){progressTotalArray[0] =	armyFinishNumArray[2];	; progressIdArray[0] = 	armyIdNumArray[2]	; progressCountArray[0] = 	armyCountNumArray[2];}
        if (armyFinishNumArray[3]	 !=0){progressTotalArray[0] =	armyFinishNumArray[3];	; progressIdArray[0] = 	armyIdNumArray[3]	; progressCountArray[0] = 	armyCountNumArray[3];}
        if (armyFinishNumArray[4]	 !=0){progressTotalArray[0] =	armyFinishNumArray[4];	; progressIdArray[0] = 	armyIdNumArray[4]	; progressCountArray[0] = 	armyCountNumArray[4];}
        if (armyFinishNumArray[5]	 !=0){progressTotalArray[0] =	armyFinishNumArray[5];	; progressIdArray[0] = 	armyIdNumArray[5]	; progressCountArray[0] = 	armyCountNumArray[5];}
        if (armyFinishNumArray[6]	 !=0){progressTotalArray[0] =	armyFinishNumArray[6];	; progressIdArray[0] = 	armyIdNumArray[6]	; progressCountArray[0] = 	armyCountNumArray[6];}
        if (armyFinishNumArray[7]	 !=0){progressTotalArray[0] =	armyFinishNumArray[7];	; progressIdArray[0] = 	armyIdNumArray[7]	; progressCountArray[0] = 	armyCountNumArray[7];}
        if (armyFinishNumArray[8]	 !=0){progressTotalArray[0] =	armyFinishNumArray[8];	; progressIdArray[0] = 	armyIdNumArray[8]	; progressCountArray[0] = 	armyCountNumArray[8];}
        if (armyFinishNumArray[9]	 !=0){progressTotalArray[0] =	armyFinishNumArray[9];	; progressIdArray[0] = 	armyIdNumArray[9]	; progressCountArray[0] = 	armyCountNumArray[9];}
        if (armyFinishNumArray[10]	 !=0){progressTotalArray[1] =	armyFinishNumArray[10];	; progressIdArray[1] = 	armyIdNumArray[10]	; progressCountArray[1] =	armyCountNumArray[10];}
        if (armyFinishNumArray[11]	 !=0){progressTotalArray[1] =	armyFinishNumArray[11];	; progressIdArray[1] = 	armyIdNumArray[11]	; progressCountArray[1] =	armyCountNumArray[11];}
        if (armyFinishNumArray[12]	 !=0){progressTotalArray[1] =	armyFinishNumArray[12];	; progressIdArray[1] = 	armyIdNumArray[12]	; progressCountArray[1] =	armyCountNumArray[12];}
        if (armyFinishNumArray[13]	 !=0){progressTotalArray[1] =	armyFinishNumArray[13];	; progressIdArray[1] = 	armyIdNumArray[13]	; progressCountArray[1] =	armyCountNumArray[13];}
        if (armyFinishNumArray[14]	 !=0){progressTotalArray[1] =	armyFinishNumArray[14];	; progressIdArray[1] = 	armyIdNumArray[14]	; progressCountArray[1] =	armyCountNumArray[14];}
        if (armyFinishNumArray[15]	 !=0){progressTotalArray[1] =	armyFinishNumArray[15];	; progressIdArray[1] = 	armyIdNumArray[15]	; progressCountArray[1] =	armyCountNumArray[15];}
        if (armyFinishNumArray[16]	 !=0){progressTotalArray[1] =	armyFinishNumArray[16];	; progressIdArray[1] = 	armyIdNumArray[16]	; progressCountArray[1] =	armyCountNumArray[16];}
        if (armyFinishNumArray[17]	 !=0){progressTotalArray[1] =	armyFinishNumArray[17];	; progressIdArray[1] = 	armyIdNumArray[17]	; progressCountArray[1] =	armyCountNumArray[17];}
        if (armyFinishNumArray[18]	 !=0){progressTotalArray[1] =	armyFinishNumArray[18];	; progressIdArray[1] = 	armyIdNumArray[18]	; progressCountArray[1] =	armyCountNumArray[18];}
        if (armyFinishNumArray[19]	 !=0){progressTotalArray[1] =	armyFinishNumArray[19];	; progressIdArray[1] = 	armyIdNumArray[19]	; progressCountArray[1] =	armyCountNumArray[19];}
        if (armyFinishNumArray[20]	 !=0){progressTotalArray[2] =	armyFinishNumArray[20];	; progressIdArray[2] = 	armyIdNumArray[20]	; progressCountArray[2] =	armyCountNumArray[20];}
        if (armyFinishNumArray[21]	 !=0){progressTotalArray[2] =	armyFinishNumArray[21];	; progressIdArray[2] = 	armyIdNumArray[21]	; progressCountArray[2] =	armyCountNumArray[21];}
        if (armyFinishNumArray[22]	 !=0){progressTotalArray[2] =	armyFinishNumArray[22];	; progressIdArray[2] = 	armyIdNumArray[22]	; progressCountArray[2] =	armyCountNumArray[22];}
        if (armyFinishNumArray[23]	 !=0){progressTotalArray[2] =	armyFinishNumArray[23];	; progressIdArray[2] = 	armyIdNumArray[23]	; progressCountArray[2] =	armyCountNumArray[23];}
        if (armyFinishNumArray[24]	 !=0){progressTotalArray[2] =	armyFinishNumArray[24];	; progressIdArray[2] = 	armyIdNumArray[24]	; progressCountArray[2] =	armyCountNumArray[24];}
        if (armyFinishNumArray[25]	 !=0){progressTotalArray[2] =	armyFinishNumArray[25];	; progressIdArray[2] = 	armyIdNumArray[25]	; progressCountArray[2] =	armyCountNumArray[25];}
        if (armyFinishNumArray[26]	 !=0){progressTotalArray[2] =	armyFinishNumArray[26];	; progressIdArray[2] = 	armyIdNumArray[26]	; progressCountArray[2] =	armyCountNumArray[26];}
        if (armyFinishNumArray[27]	 !=0){progressTotalArray[2] =	armyFinishNumArray[27];	; progressIdArray[2] = 	armyIdNumArray[27]	; progressCountArray[2] =	armyCountNumArray[27];}
        if (armyFinishNumArray[28]	 !=0){progressTotalArray[2] =	armyFinishNumArray[28];	; progressIdArray[2] = 	armyIdNumArray[28]	; progressCountArray[2] =	armyCountNumArray[28];}
        if (armyFinishNumArray[29]	 !=0){progressTotalArray[2] =	armyFinishNumArray[29];	; progressIdArray[2] = 	armyIdNumArray[29]	; progressCountArray[2] =	armyCountNumArray[29];}
        if (armyFinishNumArray[30]	 !=0){progressTotalArray[3] =	armyFinishNumArray[30];	; progressIdArray[3] = 	armyIdNumArray[30]	; progressCountArray[3] =	armyCountNumArray[30];}
        if (armyFinishNumArray[31]	 !=0){progressTotalArray[3] =	armyFinishNumArray[31];	; progressIdArray[3] = 	armyIdNumArray[31]	; progressCountArray[3] =	armyCountNumArray[31];}
        if (armyFinishNumArray[32]	 !=0){progressTotalArray[3] =	armyFinishNumArray[32];	; progressIdArray[3] = 	armyIdNumArray[32]	; progressCountArray[3] =	armyCountNumArray[32];}
        if (armyFinishNumArray[33]	 !=0){progressTotalArray[3] =	armyFinishNumArray[33];	; progressIdArray[3] = 	armyIdNumArray[33]	; progressCountArray[3] =	armyCountNumArray[33];}
        if (armyFinishNumArray[34]	 !=0){progressTotalArray[3] =	armyFinishNumArray[34];	; progressIdArray[3] = 	armyIdNumArray[34]	; progressCountArray[3] =	armyCountNumArray[34];}
        if (armyFinishNumArray[35]	 !=0){progressTotalArray[3] =	armyFinishNumArray[35];	; progressIdArray[3] = 	armyIdNumArray[35]	; progressCountArray[3] =	armyCountNumArray[35];}
        if (armyFinishNumArray[36]	 !=0){progressTotalArray[3] =	armyFinishNumArray[36];	; progressIdArray[3] = 	armyIdNumArray[36]	; progressCountArray[3] =	armyCountNumArray[36];}
        if (armyFinishNumArray[37]	 !=0){progressTotalArray[3] =	armyFinishNumArray[37];	; progressIdArray[3] = 	armyIdNumArray[37]	; progressCountArray[3] =	armyCountNumArray[37];}
        if (armyFinishNumArray[38]	 !=0){progressTotalArray[3] =	armyFinishNumArray[38];	; progressIdArray[3] = 	armyIdNumArray[38]	; progressCountArray[3] =	armyCountNumArray[38];}
        if (armyFinishNumArray[39]	 !=0){progressTotalArray[3] =	armyFinishNumArray[39];	; progressIdArray[3] = 	armyIdNumArray[39]	; progressCountArray[3] =	armyCountNumArray[39];}
        if (armyFinishNumArray[40]	 !=0){progressTotalArray[4] =	armyFinishNumArray[40];	; progressIdArray[4] = 	armyIdNumArray[40]	; progressCountArray[4] =	armyCountNumArray[40];}
        if (armyFinishNumArray[41]	 !=0){progressTotalArray[4] =	armyFinishNumArray[41];	; progressIdArray[4] = 	armyIdNumArray[41]	; progressCountArray[4] =	armyCountNumArray[41];}
        if (armyFinishNumArray[42]	 !=0){progressTotalArray[4] =	armyFinishNumArray[42];	; progressIdArray[4] = 	armyIdNumArray[42]	; progressCountArray[4] =	armyCountNumArray[42];}
        if (armyFinishNumArray[43]	 !=0){progressTotalArray[4] =	armyFinishNumArray[43];	; progressIdArray[4] = 	armyIdNumArray[43]	; progressCountArray[4] =	armyCountNumArray[43];}
        if (armyFinishNumArray[44]	 !=0){progressTotalArray[4] =	armyFinishNumArray[44];	; progressIdArray[4] = 	armyIdNumArray[44]	; progressCountArray[4] =	armyCountNumArray[44];}
        if (armyFinishNumArray[45]	 !=0){progressTotalArray[4] =	armyFinishNumArray[45];	; progressIdArray[4] = 	armyIdNumArray[45]	; progressCountArray[4] =	armyCountNumArray[45];}
        if (armyFinishNumArray[46]	 !=0){progressTotalArray[4] =	armyFinishNumArray[46];	; progressIdArray[4] = 	armyIdNumArray[46]	; progressCountArray[4] =	armyCountNumArray[46];}
        if (armyFinishNumArray[47]	 !=0){progressTotalArray[4] =	armyFinishNumArray[47];	; progressIdArray[4] = 	armyIdNumArray[47]	; progressCountArray[4] =	armyCountNumArray[47];}
        if (armyFinishNumArray[48]	 !=0){progressTotalArray[4] =	armyFinishNumArray[48];	; progressIdArray[4] = 	armyIdNumArray[48]	; progressCountArray[4] =	armyCountNumArray[48];}
        if (armyFinishNumArray[49]	 !=0){progressTotalArray[4] =	armyFinishNumArray[49];	; progressIdArray[4] = 	armyIdNumArray[49]	; progressCountArray[4] =	armyCountNumArray[49];}


        Long now_time = new Date().getTime();

        progressRemainArray[0] = progressTotalArray[0] - now_time / 1000;

        progressRemainArray[1] = progressTotalArray[1] - now_time / 1000;

        progressRemainArray[2] = progressTotalArray[2] - now_time / 1000;

        progressRemainArray[3] = progressTotalArray[3] - now_time / 1000;

        progressRemainArray[4] = progressTotalArray[4] - now_time / 1000;

        arm_progress = progressRemainArray[0] ;
        mili_progress = progressRemainArray[1] ;
        mobile_progress = progressRemainArray[2] ;
        infect_progress = progressRemainArray[3] ;
        project_progress = progressRemainArray[4] ;

        armed_process_tv.setText(getString(R.string.progress_time)+FormatTime(arm_progress));
        mili_process_tv.setText(getString(R.string.progress_time)+FormatTime(mili_progress));
        mobile_process_tv.setText(getString(R.string.progress_time)+FormatTime(mobile_progress));
        infect_process_tv.setText(getString(R.string.progress_time)+FormatTime(infect_progress));
        project_process_tv.setText(getString(R.string.progress_time)+FormatTime(project_progress));

        arm_total = progressTotalArray[0] ;
        mili_total = progressTotalArray[1] ;
        mobile_total = progressTotalArray[2] ;
        infect_total = progressTotalArray[3] ;
        project_total = progressTotalArray[4] ;

        Timestamp ts1=new Timestamp(arm_total*1000);
        Timestamp ts2=new Timestamp(mili_total*1000);
        Timestamp ts3=new Timestamp(mobile_total*1000);
        Timestamp ts4=new Timestamp(infect_total*1000);
        Timestamp ts5=new Timestamp(project_total*1000);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        armed_total_tv.setText(getString(R.string.total_time)+ " "+formatter.format(ts1));
        mili_total_tv.setText(getString(R.string.total_time)+ " "+formatter.format(ts2));
        mobile_total_tv.setText(getString(R.string.total_time)+ " "+formatter.format(ts3));
        infect_total_tv.setText(getString(R.string.total_time)+ " "+formatter.format(ts4));
        project_total_tv.setText(getString(R.string.total_time)+ " "+formatter.format(ts5));


        if (arm_progress <= 0 && arm_total >= 0){armed_process_tv.setText(getString(R.string.progress_done));}
        if (mili_progress <= 0 && mili_total >= 0){mili_process_tv.setText(getString(R.string.progress_done));}
        if (mobile_progress <= 0 && mobile_total >= 0){mobile_process_tv.setText(getString(R.string.progress_done));}
        if (infect_progress <= 0 && infect_total >= 0){infect_process_tv.setText(getString(R.string.progress_done));}
        if (project_progress <= 0 && project_total >= 0){project_process_tv.setText(getString(R.string.progress_done));}

        if (progressCountArray[0] == 0 ){progressIdArray[0] = -1 ;armed_process_tv.setText(getString(R.string.process_nothing));armed_total_tv.setText("");}
        if (progressCountArray[1] == 0 ){progressIdArray[1] = -2 ;mili_process_tv.setText(getString(R.string.process_nothing));mili_total_tv.setText("");}
        if (progressCountArray[2] == 0 ){progressIdArray[2] = -3 ;mobile_process_tv.setText(getString(R.string.process_nothing));mobile_total_tv.setText("");}
        if (progressCountArray[3] == 0 ){progressIdArray[3] = -4 ;infect_process_tv.setText(getString(R.string.process_nothing));infect_total_tv.setText("");}
        if (progressCountArray[4] == 0 ){progressIdArray[4] = -5 ;project_process_tv.setText(getString(R.string.process_nothing));project_total_tv.setText("");}

        kat((int) 1, mili_id_tv , mili_img);
        kat((int) 2, mobile_id_tv , mobile_img);
        kat((int) 0, armed_id_tv , armed_img);
        kat((int) 3, infect_id_tv , infect_img);
        kat((int) 4, project_id_tv , project_img);

        //    armed_pd.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#1BB495")));
        //    mili_pd.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#1BB495")));
        //   mobile_pd.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#1BB495")));
        //    infect_pd.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#1BB495")));
        //    project_pd.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#1BB495")));

        /*
        armed_pd.setMax((int) arm_total);
        armed_pd.setProgress((int)(arm_total-arm_progress));
        mili_pd.setMax((int) mili_total);
        mili_pd.setProgress((int)(mili_total-mili_progress));
        mobile_pd.setMax((int) mobile_total);
        mobile_pd.setProgress((int)(mobile_total-mobile_progress));
        infect_pd.setMax((int) infect_total);
        infect_pd.setProgress((int)(infect_total-infect_progress));
        project_pd.setMax((int) project_total);
        project_pd.setProgress((int)(project_total-project_progress));

         */

        //SET-TEXT

        armed_count_tv.setText(prettyCount(progressCountArray[0]));
        mili_count_tv.setText(prettyCount(progressCountArray[1]));
        mobile_count_tv.setText(prettyCount(progressCountArray[2]));
        infect_count_tv.setText(prettyCount(progressCountArray[3]));
        project_count_tv.setText(prettyCount(progressCountArray[4]));

        if (arm_progress == 0 && arm_total == 0){armed_process_tv.setText("");armed_total_tv.setText("");}
        if (mili_progress == 0 && mili_total == 0){mili_process_tv.setText("");mili_total_tv.setText("");}
        if (mobile_progress == 0 && mobile_total == 0){mobile_process_tv.setText("");mobile_total_tv.setText("");}
        if (infect_progress == 0 && infect_total == 0){infect_process_tv.setText("");infect_total_tv.setText("");}
        if (project_progress == 0 && project_total == 0){project_process_tv.setText("");project_total_tv.setText("");}



    }

    public void boomer (){
        Boomer01_tv	.setText(prettyCount(boomerNum[0]));
        Boomer02_tv	.setText(prettyCount(boomerNum[1]));
        Boomer03_tv	.setText(prettyCount(boomerNum[2]));
        Boomer04_tv	.setText(prettyCount(boomerNum[3]));
        Boomer05_tv	.setText(prettyCount(boomerNum[4]));
        Boomer06_tv	.setText(prettyCount(boomerNum[5]));
        Boomer07_tv	.setText(prettyCount(boomerNum[6]));
        Boomer08_tv	.setText(prettyCount(boomerNum[7]));
        Boomer09_tv	.setText(prettyCount(boomerNum[8]));
        Boomer10_tv	.setText(prettyCount(boomerNum[9]));
        Boomer11_tv	.setText(prettyCount(boomerNum[10]));
        Boomer12_tv	.setText(prettyCount(boomerNum[11]));
        Boomer13_tv	.setText(prettyCount(boomerNum[12]));
        Boomer14_tv	.setText(prettyCount(boomerNum[13]));
        Boomer15_tv	.setText(prettyCount(boomerNum[14]));
        boomer_total.setText(getString(R.string.boomer_total)+" "+prettyCount(boomerNum[0]+	boomerNum[1]+	boomerNum[2]+	boomerNum[3]+	boomerNum[4]+	boomerNum[5]+	boomerNum[6]+	boomerNum[7]+	boomerNum[8]+	boomerNum[9]+	boomerNum[10]+	boomerNum[11]+	boomerNum[12]+	boomerNum[13]+	boomerNum[14]));
    }

    public void kat (int i , TextView tv , ImageView img){
        if (progressIdArray[i] ==	 -1){	tv	.setText(getString(R.string.	mili	)+"   "+	getString(R.string.romen_0	));	img	.setImageResource(R.drawable.	app_icon_round	);}
        if (progressIdArray[i] ==	 -2){	tv	.setText(getString(R.string.	mobile	)+"   "+	getString(R.string.romen_0	));	img	.setImageResource(R.drawable.	app_icon_round	);}
        if (progressIdArray[i] ==	 -3){	tv	.setText(getString(R.string.	armed	)+"   "+	getString(R.string.romen_0	));	img	.setImageResource(R.drawable.	app_icon_round	);}
        if (progressIdArray[i] ==	 -4){	tv	.setText(getString(R.string.	infecion	)+"   "+	getString(R.string.romen_0	));	img	.setImageResource(R.drawable.	app_icon_round	);}
        if (progressIdArray[i] ==	 -5){	tv	.setText(getString(R.string.	project	)+"   "+	getString(R.string.romen_0	));	img	.setImageResource(R.drawable.	app_icon_round	);}
        if (progressIdArray[i] ==	0){	tv	.setText(getString(R.string.	mili_1	)+"   "+	getString(R.string.romen_1	));	img	.setImageResource(R.drawable.	hs_mili01	);}
        if (progressIdArray[i] ==	1){	tv	.setText(getString(R.string.	mili_2	)+"   "+	getString(R.string.romen_2	));	img	.setImageResource(R.drawable.	hs_mili02	);}
        if (progressIdArray[i] ==	2){	tv	.setText(getString(R.string.	mili_3	)+"   "+	getString(R.string.romen_3	));	img	.setImageResource(R.drawable.	hs_mili03	);}
        if (progressIdArray[i] ==	3){	tv	.setText(getString(R.string.	mili_4	)+"   "+	getString(R.string.romen_4	));	img	.setImageResource(R.drawable.	hs_mili04	);}
        if (progressIdArray[i] ==	4){	tv	.setText(getString(R.string.	mili_5	)+"   "+	getString(R.string.romen_5	));	img	.setImageResource(R.drawable.	hs_mili05	);}
        if (progressIdArray[i] ==	5){	tv	.setText(getString(R.string.	mili_6	)+"   "+	getString(R.string.romen_6	));	img	.setImageResource(R.drawable.	hs_mili06	);}
        if (progressIdArray[i] ==	6){	tv	.setText(getString(R.string.	mili_7	)+"   "+	getString(R.string.romen_7	));	img	.setImageResource(R.drawable.	hs_mili07	);}
        if (progressIdArray[i] ==	7){	tv	.setText(getString(R.string.	mili_8	)+"   "+	getString(R.string.romen_8	));	img	.setImageResource(R.drawable.	hs_mili08	);}
        if (progressIdArray[i] ==	8){	tv	.setText(getString(R.string.	mili_9	)+"   "+	getString(R.string.romen_9	));	img	.setImageResource(R.drawable.	hs_mili09	);}
        if (progressIdArray[i] ==	9){	tv	.setText(getString(R.string.	mili_10	)+"   "+	getString(R.string.romen_10	));	img	.setImageResource(R.drawable.	hs_mili10	);}
        if (progressIdArray[i] ==	10){	tv	.setText(getString(R.string.	mobile_1	)+"   "+	getString(R.string.romen_1	));	img	.setImageResource(R.drawable.	hs_mobile01	);}
        if (progressIdArray[i] ==	11){	tv	.setText(getString(R.string.	mobile_2	)+"   "+	getString(R.string.romen_2	));	img	.setImageResource(R.drawable.	hs_mobile02	);}
        if (progressIdArray[i] ==	12){	tv	.setText(getString(R.string.	mobile_3	)+"   "+	getString(R.string.romen_3	));	img	.setImageResource(R.drawable.	hs_mobile03	);}
        if (progressIdArray[i] ==	13){	tv	.setText(getString(R.string.	mobile_4	)+"   "+	getString(R.string.romen_4	));	img	.setImageResource(R.drawable.	hs_mobile04	);}
        if (progressIdArray[i] ==	14){	tv	.setText(getString(R.string.	mobile_5	)+"   "+	getString(R.string.romen_5	));	img	.setImageResource(R.drawable.	hs_mobile05	);}
        if (progressIdArray[i] ==	15){	tv	.setText(getString(R.string.	mobile_6	)+"   "+	getString(R.string.romen_6	));	img	.setImageResource(R.drawable.	hs_mobile06	);}
        if (progressIdArray[i] ==	16){	tv	.setText(getString(R.string.	mobile_7	)+"   "+	getString(R.string.romen_7	));	img	.setImageResource(R.drawable.	hs_mobile07	);}
        if (progressIdArray[i] ==	17){	tv	.setText(getString(R.string.	mobile_8	)+"   "+	getString(R.string.romen_8	));	img	.setImageResource(R.drawable.	hs_mobile08	);}
        if (progressIdArray[i] ==	18){	tv	.setText(getString(R.string.	mobile_9	)+"   "+	getString(R.string.romen_9	));	img	.setImageResource(R.drawable.	hs_mobile09	);}
        if (progressIdArray[i] ==	19){	tv	.setText(getString(R.string.	mobile_10	)+"   "+	getString(R.string.romen_10	));	img	.setImageResource(R.drawable.	hs_mobile10	);}
        if (progressIdArray[i] ==	20){	tv	.setText(getString(R.string.	arm_1	)+"   "+	getString(R.string.romen_1	));	img	.setImageResource(R.drawable.	hs_arm01	);}
        if (progressIdArray[i] ==	21){	tv	.setText(getString(R.string.	arm_2	)+"   "+	getString(R.string.romen_2	));	img	.setImageResource(R.drawable.	hs_arm02	);}
        if (progressIdArray[i] ==	22){	tv	.setText(getString(R.string.	arm_3	)+"   "+	getString(R.string.romen_3	));	img	.setImageResource(R.drawable.	hs_arm03	);}
        if (progressIdArray[i] ==	23){	tv	.setText(getString(R.string.	arm_4	)+"   "+	getString(R.string.romen_4	));	img	.setImageResource(R.drawable.	hs_arm04	);}
        if (progressIdArray[i] ==	24){	tv	.setText(getString(R.string.	arm_5	)+"   "+	getString(R.string.romen_5	));	img	.setImageResource(R.drawable.	hs_arm05	);}
        if (progressIdArray[i] ==	25){	tv	.setText(getString(R.string.	arm_6	)+"   "+	getString(R.string.romen_6	));	img	.setImageResource(R.drawable.	hs_arm06	);}
        if (progressIdArray[i] ==	26){	tv	.setText(getString(R.string.	arm_7	)+"   "+	getString(R.string.romen_7	));	img	.setImageResource(R.drawable.	hs_arm07	);}
        if (progressIdArray[i] ==	27){	tv	.setText(getString(R.string.	arm_8	)+"   "+	getString(R.string.romen_8	));	img	.setImageResource(R.drawable.	hs_arm08	);}
        if (progressIdArray[i] ==	28){	tv	.setText(getString(R.string.	arm_9	)+"   "+	getString(R.string.romen_9	));	img	.setImageResource(R.drawable.	hs_arm09	);}
        if (progressIdArray[i] ==	29){	tv	.setText(getString(R.string.	arm_10	)+"   "+	getString(R.string.romen_10	));	img	.setImageResource(R.drawable.	hs_arm10	);}
        if (progressIdArray[i] ==	30){	tv	.setText(getString(R.string.	infect_1	)+"   "+	getString(R.string.romen_1	));	infect_img	.setImageResource(R.drawable.	hs_infect01	);}
        if (progressIdArray[i] ==	31){	tv	.setText(getString(R.string.	infect_2	)+"   "+	getString(R.string.romen_2	));	infect_img	.setImageResource(R.drawable.	hs_infect02	);}
        if (progressIdArray[i] ==	32){	tv	.setText(getString(R.string.	infect_3	)+"   "+	getString(R.string.romen_3	));	infect_img	.setImageResource(R.drawable.	hs_infect03	);}
        if (progressIdArray[i] ==	33){	tv	.setText(getString(R.string.	infect_4	)+"   "+	getString(R.string.romen_4	));	infect_img	.setImageResource(R.drawable.	hs_infect04	);}
        if (progressIdArray[i] ==	34){	tv	.setText(getString(R.string.	infect_5	)+"   "+	getString(R.string.romen_5	));	infect_img	.setImageResource(R.drawable.	hs_infect05	);}
        if (progressIdArray[i] ==	35){	tv	.setText(getString(R.string.	infect_6	)+"   "+	getString(R.string.romen_6	));	infect_img	.setImageResource(R.drawable.	hs_infect06	);}
        if (progressIdArray[i] ==	36){	tv	.setText(getString(R.string.	infect_7	)+"   "+	getString(R.string.romen_7	));	infect_img	.setImageResource(R.drawable.	hs_infect07	);}
        if (progressIdArray[i] ==	37){	tv	.setText(getString(R.string.	infect_8	)+"   "+	getString(R.string.romen_8	));	infect_img	.setImageResource(R.drawable.	hs_infect08	);}
        if (progressIdArray[i] ==	38){	tv	.setText(getString(R.string.	infect_9	)+"   "+	getString(R.string.romen_9	));	infect_img	.setImageResource(R.drawable.	hs_infect09	);}
        if (progressIdArray[i] ==	39){	tv	.setText(getString(R.string.	infect_10	)+"   "+	getString(R.string.romen_10	));	infect_img	.setImageResource(R.drawable.	hs_infect10	);}
        if (progressIdArray[i] ==	40){	tv	.setText(getString(R.string.	proj_1	)+"   "+	getString(R.string.romen_1	));	img	.setImageResource(R.drawable.	hs_project01	);}
        if (progressIdArray[i] ==	41){	tv	.setText(getString(R.string.	proj_2	)+"   "+	getString(R.string.romen_2	));	img	.setImageResource(R.drawable.	hs_project02	);}
        if (progressIdArray[i] ==	42){	tv	.setText(getString(R.string.	proj_3	)+"   "+	getString(R.string.romen_3	));	img	.setImageResource(R.drawable.	hs_project03	);}
        if (progressIdArray[i] ==	43){	tv	.setText(getString(R.string.	proj_4	)+"   "+	getString(R.string.romen_4	));	img	.setImageResource(R.drawable.	hs_project04	);}
        if (progressIdArray[i] ==	44){	tv	.setText(getString(R.string.	proj_5	)+"   "+	getString(R.string.romen_5	));	img	.setImageResource(R.drawable.	hs_project05	);}
        if (progressIdArray[i] ==	45){	tv	.setText(getString(R.string.	proj_6	)+"   "+	getString(R.string.romen_6	));	img	.setImageResource(R.drawable.	hs_project06	);}
        if (progressIdArray[i] ==	46){	tv	.setText(getString(R.string.	proj_7	)+"   "+	getString(R.string.romen_7	));	img	.setImageResource(R.drawable.	hs_project07	);}
        if (progressIdArray[i] ==	47){	tv	.setText(getString(R.string.	proj_8	)+"   "+	getString(R.string.romen_8	));	img	.setImageResource(R.drawable.	hs_project08	);}
        if (progressIdArray[i] ==	48){	tv	.setText(getString(R.string.	proj_9	)+"   "+	getString(R.string.romen_9	));	img	.setImageResource(R.drawable.	hs_project09	);}
        if (progressIdArray[i] ==	49){	tv	.setText(getString(R.string.	proj_10	)+"   "+	getString(R.string.romen_10	));	img	.setImageResource(R.drawable.	hs_project10	);}
    }

    public void sorted (){
        queue(R.id.arm10_img,sortedArrayListDescending,0,arm10);
        queue(R.id.mili10_img,sortedArrayListDescending,1,mili10);
        queue(R.id.mobile10_img,sortedArrayListDescending,2,mobile10);
        queue(R.id.infect10_img,sortedArrayListDescending,3,infect10);
        queue(R.id.project10_img,sortedArrayListDescending,4,project10);
        queue(R.id.arm09_img,sortedArrayListDescending,5,arm09);
        queue(R.id.mili09_img,sortedArrayListDescending,6,mili09);
        queue(R.id.mobile09_img,sortedArrayListDescending,7,mobile09);
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
            uid = result.getLong("uid");
            verifyCode = result.getString("verifyCode");
            Log.i("UID", String.valueOf(uid));
            Log.i("verifyCode", String.valueOf(verifyCode));
            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

    private class TakeData extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Toast.makeText(.. stActivity.this,"Json Data is downloading",Toast.LENGTH_LONG).show();

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
            fuel_re = fuel_final ;
            food_re = food_final ;
            steel_re = steel_final ;
            alloy_re = alloy_final ;
            obsidian_re = obsidian_final ;
            kyanite_re = kyanite_final ;
            kyanite_basic_re = kyanite_basic_final ;
            kyanite_cluster_re = kyanite_cluster_final ;
            catalyst_re = catalyst_final ;
            glory_mark_re = glory_mark_final ;
            diamond_re = diamond_final ;

            arm_total = arm_total+1;
            mili_total = mili_total+1;
            mobile_total = mobile_total+1;
            infect_total = infect_total+1;
            project_total = project_total+1;

                /*

                ppl = sharedPreferences.getString("ppl", "루미너스 - LUMI");

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

                 */
            if (input_json_list == true){url = "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid="+uid+"&psw="+verifyCode;jsonStr = sh.makeServiceCall(url);
                if (!jsonStr.equals("")) {
                    try {
                        JSONObject jsonObj = new JSONObject(jsonStr);


                        // Getting JSON Array node


                        // looping through All Contacts
                        if(jsonObj.has("mechas")){
                            JSONArray mecha = jsonObj.getJSONArray("mechas");
                            for (int i = 0; i < mecha.length(); i++) {
                                JSONObject c = mecha.getJSONObject(i);
                                mechaName = c.getString("mechaName");
                                mechaNameArray2 [i] = mechaName;
                                mechaLv = c.getLong("mechaLv");
                                mechaLvArray2 [i] = mechaLv;
                            }}
                        if(jsonObj.has("resource")) {
                            JSONObject rss = jsonObj.getJSONObject("resource");
                            for (int i = 0; i < rss.length(); i++) {

                                if(rss.has("wood")){ fuel_final = rss.getInt("wood");}else{ fuel_final = 0;}
                                if(rss.has("food")){ food_final = rss.getInt("food");}else{ food_final = 0;}
                                if(rss.has("iron")){ steel_final = rss.getInt("iron");}else{ steel_final = 0;}
                                if(rss.has("stone")){ alloy_final = rss.getInt("stone");}else{ alloy_final = 0;}
                                if(rss.has("crystal")){ obsidian_final = rss.getInt("crystal");}else{ obsidian_final = 0;}
                                if(rss.has("crystal1")){ kyanite_final = rss.getInt("crystal1");}else{ kyanite_final = 0;}
                                if(rss.has("crystal2")){ kyanite_basic_final = rss.getInt("crystal2");}else{ kyanite_basic_final = 0;}
                                if(rss.has("crystal3")){ kyanite_cluster_final = rss.getInt("crystal3");}else{ kyanite_cluster_final = 0;}
                                if(rss.has("glory_mark")){ glory_mark_final = rss.getInt("glory_mark");}else{ glory_mark_final = 0;}
                                if(rss.has("scientificStone")){ catalyst_final = rss.getInt("scientificStone");}else{ catalyst_final = 0;}
                                if(rss.has("diamond")){ diamond_final = rss.getInt("diamond");}else{ diamond_final = 0;}
                            }
                        }
                        if(jsonObj.has("armys")) {
                            JSONArray troops = jsonObj.getJSONArray("armys");
                            for (int i = 0; i < troops.length(); i++) {
                                JSONObject a = troops.getJSONObject(i);
                                armyFreeNum = a.getInt("armyFreeNum");
                                armyFreeNumArray [i] = armyFreeNum;
                                armyMarchNum = a.getInt("armyMarchNum");
                                armyMarchNumArray [i] = armyMarchNum;
                                armyName = a.getString("armyName");
                                armyNameArray [i] =armyName;
                                if (a.has("armyFinishTime")&&a.has("armyTrain")){
                                    armyFinishNumArray[i] = 0;
                                    armyCountNumArray[i] = a.getLong("armyTrain");
                                    armyFinishNumArray[i] = a.getLong("armyFinishTime");
                                    armyIdNumArray[i] = i;
                                }
                            }
                        }
                        if(jsonObj.has("heros")) {
                            JSONArray enablers = jsonObj.getJSONArray("heros");
                            for (int i = 0; i < enablers.length(); i++) {
                                JSONObject c = enablers.getJSONObject(i);
                                enablerName = c.getString("heroName");
                                enablerNameArray [i] = enablerName;
                                enablerLv = c.getInt("heroLv");
                                enablerLvArray [i] = enablerLv;
                            }
                        }
                        if(jsonObj.has("star")) {
                            JSONObject star = jsonObj.getJSONObject("star");
                            for (int i = 0; i < star.length(); i++) {
                                starArray[0] = star.getInt("starA");
                                starArray[1] = star.getInt("starB");
                                starArray[2] = star.getInt("starC");
                                starArray[3] = star.getInt("starD");
                            }
                        }
                        if(jsonObj.has("exp")) {
                            JSONObject exp = jsonObj.getJSONObject("exp");
                            for (int i = 0; i < exp.length(); i++) {
                                expArray[0] = exp.getLong("100");
                                expArray[1] = exp.getLong("5000");
                                expArray[2] = exp.getLong("10000");
                                expArray[3] = exp.getLong("20000");
                                expArray[4] = exp.getLong("50000");
                                expArray[5] = exp.getLong("80000");
                                expArray[6] = exp.getLong("100000");
                            }
                        }
                        /*
                        if(jsonObj.has("progress")) {
                            JSONArray progress = jsonObj.getJSONArray("progress");
                            for (int i = 0; i < progress.length(); i++) {
                                JSONObject c = progress.getJSONObject(i);
                                progressId = c.getLong("id");
                                progressIdArray [i] = progressId;
                                progressRemain = c.getLong("process_time");
                                progressRemainArray [i] = progressRemain;
                                progressTotal = c.getLong("total_time");
                                progressTotalArray [i] = progressTotal;
                                progressCount = c.getLong("count");
                                progressCountArray [i] = progressCount;
                            }
                        }
                         */
                        if(jsonObj.has("fort")){
                            JSONArray boom = jsonObj.getJSONArray("fort");
                            for (int i = 0; i < boom.length(); i++) {
                                JSONObject c = boom.getJSONObject(i);
                                boomName = c.getString("fortName");
                                boomNameArray [i] = boomName;
                                boomNum = c.getInt("fortNum");
                                boomerNum [i] = boomNum;
                            }
                        }

                        if(jsonObj.has("building")){
                            JSONArray building = jsonObj.getJSONArray("building");
                            for (int i = 0; i < building.length(); i++) {
                                JSONObject c = building.getJSONObject(i);
                                buildingName = c.getString("buildName");
                                buildingNameArray [i] = buildingName;
                                buildingLvl = c.getInt("lvl");
                                buildingGlory = c.getInt("glory");
                                buildingLvlArray [i] = buildingLvl+buildingGlory;
                            }
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
                }}
            else {
                finish();
            }
                /*    url = "http://vt.25u.com/vt/zgt/user.json";
                    sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("ppl", "DEMO");
                    editor.apply();
                    jsonStr = sh.makeServiceCall(url);
                }
                if (jsonStr.equals("{}")|jsonStr.equals("")){
                    jsonStr = "{\"activityShop\":[{\"needCount\":\"150000|300000\",\"price\":\"150000|300000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"120000|300000\",\"price\":\"120000|300000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"150000|300000\",\"price\":\"150000|300000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"100000|100000\",\"price\":\"100000|100000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"150000|150000\",\"price\":\"150000|150000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"200000|200000\",\"price\":\"200000|200000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"20000|20000\",\"price\":\"20000|20000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"60000|60000\",\"price\":\"60000|60000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"30000|30000\",\"price\":\"30000|30000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"100000|140000|200000|270000|350000|450000\",\"price\":\"100000|140000|200000|270000|350000|450000\",\"name\":\"Festival limit\",\"count\":\"1|2|3|4|5|6\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"300|300\",\"price\":\"300|300\",\"name\":\"Festival limit\",\"count\":\"1000|2000\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"100|100\",\"price\":\"100|100\",\"name\":\"Festival limit\",\"count\":\"1000|2000\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"600|720|850\",\"price\":\"600|720|850\",\"name\":\"Festival limit\",\"count\":\"150|300|450\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"1800|2100|2500\",\"price\":\"1800|2100|2500\",\"name\":\"Festival limit\",\"count\":\"50|100|150\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"3600|4300|5100\",\"price\":\"3600|4300|5100\",\"name\":\"Festival limit\",\"count\":\"25|50|100\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"90000|130000|180000|240000|310000|400000\",\"price\":\"90000|130000|180000|240000|310000|400000\",\"name\":\"Festival limit\",\"count\":\"1|2|3|4|5|6\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"800|1000|1200\",\"price\":\"800|1000|1200\",\"name\":\"Festival limit\",\"count\":\"20|50|100\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"50000|80000|110000|130000|170000|220000\",\"price\":\"50000|80000|110000|130000|170000|220000\",\"name\":\"Festival limit\",\"count\":\"1|2|3|4|5|6\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"4|5\",\"price\":\"4|5\",\"name\":\"Festival limit\",\"count\":\"5000|10000\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"60000|90000|120000|160000|220000|300000\",\"price\":\"60000|90000|120000|160000|220000|300000\",\"name\":\"Festival limit\",\"count\":\"1|2|3|4|5|6\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"5|6\",\"price\":\"5|6\",\"name\":\"Festival limit\",\"count\":\"5000|10000\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"1000|1000\",\"price\":\"1000|1000\",\"name\":\"Festival limit\",\"count\":\"300|600\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"1000|1000\",\"price\":\"1000|1000\",\"name\":\"Festival limit\",\"count\":\"300|600\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"150000|300000\",\"price\":\"150000|300000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"150000|300000\",\"price\":\"150000|300000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"50000|100000\",\"price\":\"50000|100000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"100000|100000\",\"price\":\"100000|100000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"50000|100000\",\"price\":\"50000|100000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"50000|100000\",\"price\":\"50000|100000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"20000|30000\",\"price\":\"20000|30000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"20000|30000\",\"price\":\"20000|30000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"20000|30000\",\"price\":\"20000|30000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"20000|30000\",\"price\":\"20000|30000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"200000|300000\",\"price\":\"200000|300000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"200000|300000\",\"price\":\"200000|300000\",\"name\":\"Festival limit\",\"count\":\"1|1\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"200000|300000\",\"price\":\"200000|300000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"30|100|200|300|350|400\",\"price\":\"30|100|200|300|350|400\",\"name\":\"RSS Set\",\"count\":\"10|30|60|100|150|210\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"2|5|8|10|12|15\",\"price\":\"2|5|8|10|12|15\",\"name\":\"RSS Set\",\"count\":\"300|900|1800|3000|4500|6300\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"2|5|8|10|12|15\",\"price\":\"2|5|8|10|12|15\",\"name\":\"RSS Set\",\"count\":\"300|900|1800|3000|4500|6300\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"2|5|8|10|12|15\",\"price\":\"2|5|8|10|12|15\",\"name\":\"RSS Set\",\"count\":\"250|750|1500|2500|3750|5250\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"2|5|8|10|12|15\",\"price\":\"2|5|8|10|12|15\",\"name\":\"RSS Set\",\"count\":\"225|675|1350|2250|3375|4725\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"5|15|25|30|35|40\",\"price\":\"5|15|25|30|35|40\",\"name\":\"RSS Set\",\"count\":\"100|300|600|1000|1500|2100\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"10|15|20|30|35|40\",\"price\":\"10|15|20|30|35|40\",\"name\":\"RSS Set\",\"count\":\"80|240|480|800|1200|1680\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"2|3|4|5|6|7\",\"price\":\"2|3|4|5|6|7\",\"name\":\"RSS Set\",\"count\":\"600|1800|3600|6000|9000|12600\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"10|15|20|25|30|40\",\"price\":\"10|15|20|25|30|40\",\"name\":\"RSS Set\",\"count\":\"100|300|600|1000|1500|2100\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"10|20\",\"price\":\"10|20\",\"name\":\"Enabler Set\",\"count\":\"100|200\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"50|100|150|200|250|300\",\"price\":\"50|100|150|200|250|300\",\"name\":\"Enabler Set\",\"count\":\"15|45|90|150|225|315\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"150|300|450|650|800|1000\",\"price\":\"150|300|450|650|800|1000\",\"name\":\"Enabler Set\",\"count\":\"5|15|30|50|75|105\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"4|7|10|14|17|20\",\"price\":\"4|7|10|14|17|20\",\"name\":\"Enabler Set\",\"count\":\"250|750|1500|2500|3750|5250\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"50|75|100|125|150|175\",\"price\":\"50|75|100|125|150|175\",\"name\":\"Enabler Set\",\"count\":\"20|60|120|200|300|420\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"30|35|40|45|50|100\",\"price\":\"30|35|40|45|50|100\",\"name\":\"Enabler Set\",\"count\":\"40|120|240|400|600|840\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"1|2|3|4|5|6\",\"price\":\"1|2|3|4|5|6\",\"name\":\"Transform Set\",\"count\":\"1000|3000|6000|10000|15000|21000\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"2|5|8|11|13|12\",\"price\":\"2|5|8|11|13|12\",\"name\":\"Transform Set\",\"count\":\"200|600|1200|2000|3000|4200\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"5|7|9|12|15|18\",\"price\":\"5|7|9|12|15|18\",\"name\":\"Transform Set\",\"count\":\"200|600|1200|2000|3000|4200\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"20|35|50|65|80|95\",\"price\":\"20|35|50|65|80|95\",\"name\":\"Transform Set\",\"count\":\"50|150|300|500|750|1050\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"60|90|120|150|180|210\",\"price\":\"60|90|120|150|180|210\",\"name\":\"Arena Set\",\"count\":\"20|60|120|200|300|420\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"5|7|9|11|13|15\",\"price\":\"5|7|9|11|13|15\",\"name\":\"Arena Set\",\"count\":\"250|750|1500|2500|3750|5250\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"5|20|35|50|65|80\",\"price\":\"5|20|35|50|65|80\",\"name\":\"Arena Set\",\"count\":\"45|135|270|450|675|945\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"20|60|100|140|180|220\",\"price\":\"20|60|100|140|180|220\",\"name\":\"Arena Set\",\"count\":\"20|60|120|200|300|420\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"250|400|550|700|850|1000\",\"price\":\"250|400|550|700|850|1000\",\"name\":\"Arena Set\",\"count\":\"1|3|6|10|15|21\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"250|400|550|700|850|1000\",\"price\":\"250|400|550|700|850|1000\",\"name\":\"Arena Set\",\"count\":\"1|3|6|10|15|21\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"30000|40000|50000\",\"price\":\"30000|40000|50000\",\"name\":\"Arena Set\",\"count\":\"1|3|5\",\"needItem\":\"Pumpkin coin\"}],\"heros\":[{\"heroLv\":0,\"heroId\":240067,\"heroName\":\"Raly Rothfield\"},{\"heroLv\":0,\"heroId\":240066,\"heroName\":\"Mira Mulls\"},{\"heroLv\":0,\"heroId\":240065,\"heroName\":\"Mika Uehara\"},{\"heroLv\":0,\"heroId\":240064,\"heroName\":\"Risa Terada\"},{\"heroLv\":0,\"heroId\":240071,\"heroName\":\"Kuroda Namida\"},{\"heroLv\":0,\"heroId\":240070,\"heroName\":\"Kurul Egheim\"},{\"heroLv\":0,\"heroId\":240069,\"heroName\":\"Chiyo taku\"},{\"heroLv\":0,\"heroId\":240068,\"heroName\":\"Celesia·Klim\"},{\"heroLv\":0,\"heroId\":240075,\"heroName\":\"Iris\"},{\"heroLv\":0,\"heroId\":240074,\"heroName\":\"Lois Elum\"},{\"heroLv\":0,\"heroId\":240073,\"heroName\":\"Shirley Foster\"},{\"heroLv\":15,\"heroId\":240072,\"heroName\":\"Catherine Edward\"},{\"heroLv\":0,\"heroId\":240077,\"heroName\":\"Narumi Ruri\"},{\"heroLv\":22,\"heroId\":240076,\"heroName\":\"Sylvia Landon\"},{\"heroLv\":31,\"heroId\":240031,\"heroName\":\"Fudo\"},{\"heroLv\":15,\"heroId\":240030,\"heroName\":\"Saki\"},{\"heroLv\":0,\"heroId\":240035,\"heroName\":\"Sara\"},{\"heroLv\":0,\"heroId\":240034,\"heroName\":\"Uzuki\"},{\"heroLv\":0,\"heroId\":240033,\"heroName\":\"Carol\"},{\"heroLv\":0,\"heroId\":240032,\"heroName\":\"Masami\"},{\"heroLv\":0,\"heroId\":240039,\"heroName\":\"Hiyori\"},{\"heroLv\":0,\"heroId\":240038,\"heroName\":\"Kirine\"},{\"heroLv\":0,\"heroId\":240037,\"heroName\":\"Chika\"},{\"heroLv\":0,\"heroId\":240036,\"heroName\":\"Sariko\"},{\"heroLv\":0,\"heroId\":240043,\"heroName\":\"Youko\"},{\"heroLv\":15,\"heroId\":240042,\"heroName\":\"Nana\"},{\"heroLv\":0,\"heroId\":240041,\"heroName\":\"Minami\"},{\"heroLv\":0,\"heroId\":240040,\"heroName\":\"Mio\"},{\"heroLv\":10,\"heroId\":240047,\"heroName\":\"Eleanor\"},{\"heroLv\":0,\"heroId\":240046,\"heroName\":\"Sumika\"},{\"heroLv\":0,\"heroId\":240045,\"heroName\":\"Gin\"},{\"heroLv\":0,\"heroId\":240044,\"heroName\":\"Izumi\"},{\"heroLv\":0,\"heroId\":240051,\"heroName\":\"Donner\"},{\"heroLv\":0,\"heroId\":240050,\"heroName\":\"Comet\"},{\"heroLv\":15,\"heroId\":240049,\"heroName\":\"Kayo\"},{\"heroLv\":10,\"heroId\":240048,\"heroName\":\"Chen\"},{\"heroLv\":0,\"heroId\":240055,\"heroName\":\"Liuk\"},{\"heroLv\":0,\"heroId\":240054,\"heroName\":\"Zero\"},{\"heroLv\":0,\"heroId\":240053,\"heroName\":\"Ana O'\"},{\"heroLv\":0,\"heroId\":240052,\"heroName\":\"Saori\"},{\"heroLv\":0,\"heroId\":240059,\"heroName\":\"Esther\"},{\"heroLv\":0,\"heroId\":240058,\"heroName\":\"Akiyama\"},{\"heroLv\":0,\"heroId\":240057,\"heroName\":\"Zrs-2\"},{\"heroLv\":0,\"heroId\":240056,\"heroName\":\"Odelia\"},{\"heroLv\":0,\"heroId\":240063,\"heroName\":\"MisakiTouhyo\"},{\"heroLv\":0,\"heroId\":240062,\"heroName\":\"Shiori Kushima\"},{\"heroLv\":0,\"heroId\":240061,\"heroName\":\"Yesi Cheng\"},{\"heroLv\":0,\"heroId\":240060,\"heroName\":\"Alice\"}],\"mechas\":[{\"mechaName\":\"Mecha\",\"mechaLv\":5},{\"mechaName\":\"Mana Mecha\",\"mechaLv\":5}],\"resource\":{\"chip\":0,\"crystal3\":24000,\"crystal2\":180000,\"crystal1\":597990,\"crystal\":1590000,\"glory_mark\":321220,\"food\":606941,\"stone\":179170,\"diamond\":19745,\"iron\":1001773,\"scientificStone\":0,\"wood\":1123523,\"silver\":500},\"StarStone\":[{\"name\":\"Polaris\",\"stars\":\"Star Stone I|Star Stone IV\"},{\"name\":\"Al Nair\",\"stars\":\"Star Stone II|Star Stone VII\"},{\"name\":\"Alnilam\",\"stars\":\"Star Stone II|Star Stone IV|Star Stone VIII\"},{\"name\":\"Miaplacidus\",\"stars\":\"Star Stone IV|Star Stone VI|Star Stone IX\"},{\"name\":\"Elnath\",\"stars\":\"Star Stone III|Star Stone VI|Star Stone X\"},{\"name\":\"Bellatrix\",\"stars\":\"Star Stone VI|Star Stone IX|Star Stone XI\"},{\"name\":\"Shaula\",\"stars\":\"Star Stone III|Star Stone X|Star Stone XII\"},{\"name\":\"Gacrux\",\"stars\":\"Star Stone VIII|Star Stone XI|Star Stone XII\"},{\"name\":\"Castor\",\"stars\":\"Star Stone IX|Star Stone XI|Star Stone XIII\"},{\"name\":\"Adhara\",\"stars\":\"Star Stone VI|Star Stone X|Star Stone XIV\"},{\"name\":\"Regulus\",\"stars\":\"Star Stone VIII|Star Stone XIII|Star Stone XIV\"},{\"name\":\"Mimosa\",\"stars\":\"Star Stone IX|Star Stone XII|Star Stone XIV\"},{\"name\":\"Deneb\",\"stars\":\"Star Stone III|Star Stone IV|Star Stone XV\"},{\"name\":\"Fomalhaut\",\"stars\":\"Star Stone IV|Star Stone XIV|Star Stone XV\"},{\"name\":\"Pollux\",\"stars\":\"Star Stone II|Star Stone V|Star Stone VIII|Star Stone XVI\"},{\"name\":\"Spica\",\"stars\":\"Star Stone IV|Star Stone VIII|Star Stone XIV|Star Stone XVI\"},{\"name\":\"Antares\",\"stars\":\"Star Stone II|Star Stone VIII|Star Stone XIII|Star Stone XV\"},{\"name\":\"CruxAustralis\",\"stars\":\"Star Stone III|Star Stone V|Star Stone IX|Star Stone XVII\"},{\"name\":\"Aldebaran\",\"stars\":\"Star Stone VI|Star Stone X|Star Stone XV|Star Stone XVII\"},{\"name\":\"Altair\",\"stars\":\"Star Stone IX|Star Stone XIV|Star Stone XVI|Star Stone XVII\"},{\"name\":\"Agena\",\"stars\":\"Star Stone III|Star Stone XIII|Star Stone XV|Star Stone XVI\"},{\"name\":\"Betelgeux\",\"stars\":\"Star Stone IV|Star Stone VIII|Star Stone XV|Star Stone XVIII\"},{\"name\":\"Achernar\",\"stars\":\"Star Stone III|Star Stone VI|Star Stone XVII|Star Stone XVIII\"},{\"name\":\"Procyon\",\"stars\":\"Star Stone II|Star Stone IV|Star Stone VII|Star Stone XVIII\"},{\"name\":\"Rigel\",\"stars\":\"Star Stone V|Star Stone VI|Star Stone X|Star Stone XIX\"},{\"name\":\"Capella\",\"stars\":\"Star Stone V|Star Stone XV|Star Stone XVII|Star Stone XIX\"},{\"name\":\"Vega Lyra\",\"stars\":\"Star Stone V|Star Stone XIV|Star Stone XVIII|Star Stone XIX\"},{\"name\":\"Arcturus\",\"stars\":\"Star Stone XV|Star Stone XVII|Star Stone XVIII|Star Stone XIX\"},{\"name\":\"Rigil Kent\",\"stars\":\"Star Stone IV|Star Stone V|Star Stone XVII|Star Stone XX\"},{\"name\":\"Canopus\",\"stars\":\"Star Stone XIV|Star Stone XVII|Star Stone XVIII|Star Stone XX\"},{\"name\":\"Sirius\",\"stars\":\"Star Stone XII|Star Stone XIV|Star Stone XVII|Star Stone XX\"}],\"armys\":[{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Sports Freshman\"},{\"armyFreeNum\":1570,\"armyMarchNum\":0,\"armyName\":\"Execution Freshman\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Sports Sophomore\"},{\"armyTrain\":710,\"armyFreeNum\":6318,\"armyMarchNum\":0,\"armyName\":\"Execution Sophomore\",\"armyFinishTime\":1603898945},{\"armyFreeNum\":469,\"armyMarchNum\":0,\"armyName\":\"Sophomore Attacker\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Junior Attacker\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Budo Senior\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Chunibyo Striker\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Karate Striker\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Strategy Master\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Extreme Sports Team\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Defensive Aids Team\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"High-speed Guard Team\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Heavy Ranged Team\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"School Armoured Team\"},{\"armyTrain\":710,\"armyFreeNum\":4535,\"armyMarchNum\":0,\"armyName\":\"Combat Comm. Team\",\"armyFinishTime\":1603904068},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Heavy Armed Team\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Combat Assaulter Team\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Ranged Aids Team\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Dead Reaper Team\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Shooter Freshman\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Assaulter Freshman\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Shooter Sophomore\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Assaulter Sophomore\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Fire Support Sophomore\"},{\"armyTrain\":710,\"armyFreeNum\":5450,\"armyMarchNum\":0,\"armyName\":\"Fire Support Junior\",\"armyFinishTime\":1603909695},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Kyudo Senior\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Holy Sister\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Shinto Miko\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Dead Hunter\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Tainted Girl\"},{\"armyTrain\":710,\"armyFreeNum\":6685,\"armyMarchNum\":0,\"armyName\":\"Viral Girl\",\"armyFinishTime\":1603892975},{\"armyFreeNum\":3455,\"armyMarchNum\":0,\"armyName\":\"Destructive Girl\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Transformed Girl\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Melanized Girl\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Combat Girl\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Fevered Girl\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Evolved Girl\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Dark Killer\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Dark Valkyria\"},{\"armyTrain\":710,\"armyFreeNum\":2080,\"armyMarchNum\":0,\"armyName\":\"Project Zero · Annihilate\",\"armyFinishTime\":1603918087},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Project One · Freedom\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Project One · Barrier\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Project Zero · Support\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Project Zero · Hunt\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Project One · Ambition\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Project Zero · Cleanse\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Project One · Fortress\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Project Zero · Adjudicate\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Project One · Unyielding\"}],\"fort\":[{\"fortNum\":1620,\"fortName\":\"Lv1 Grenade\"},{\"fortNum\":0,\"fortName\":\"Lv2 Grenade\"},{\"fortNum\":0,\"fortName\":\"Lv3 Grenade\"},{\"fortNum\":0,\"fortName\":\"Lv4 Grenade\"},{\"fortNum\":0,\"fortName\":\"Lv5 Grenade\"},{\"fortNum\":0,\"fortName\":\"Lv1 Mine\"},{\"fortNum\":0,\"fortName\":\"Lv2 Mine\"},{\"fortFinishTime\":1603893275,\"fortNum\":1200,\"fortBuild\":200,\"fortName\":\"Lv3 Mine\"},{\"fortNum\":0,\"fortName\":\"Lv4 Mine\"},{\"fortNum\":0,\"fortName\":\"Lv5 Mine\"},{\"fortNum\":0,\"fortName\":\"Lv1 Firebomb\"},{\"fortNum\":0,\"fortName\":\"Lv2 Firebomb\"},{\"fortNum\":0,\"fortName\":\"Lv3 Firebomb\"},{\"fortNum\":0,\"fortName\":\"Lv4 Firebomb\"},{\"fortNum\":0,\"fortName\":\"Lv5 Firebomb\"}],\"building\":[{\"buildName\":\"Teaching Building\",\"lvl\":19,\"glory\":0},{\"buildName\":\"Z-11\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Embassy\",\"lvl\":18,\"glory\":0},{\"buildName\":\"Laboratory\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Storeroom\",\"lvl\":9,\"glory\":0},{\"buildName\":\"Student Union\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Shelter\",\"lvl\":9,\"glory\":0},{\"buildName\":\"Shelter\",\"lvl\":7,\"glory\":0},{\"buildName\":\"Shelter\",\"lvl\":11,\"glory\":0},{\"buildName\":\"Shelter\",\"lvl\":11,\"glory\":0},{\"buildName\":\"Shelter\",\"lvl\":7,\"glory\":0},{\"buildName\":\"Shelter\",\"lvl\":9,\"glory\":0},{\"buildName\":\"Shelter\",\"lvl\":9,\"glory\":0},{\"buildName\":\"Shelter\",\"lvl\":9,\"glory\":0},{\"buildName\":\"Clinic\",\"lvl\":5,\"glory\":0},{\"buildName\":\"Clinic\",\"lvl\":10,\"glory\":0},{\"buildName\":\"Alloy Mine\",\"lvl\":15,\"glory\":0},{\"buildName\":\"Oil Well\",\"lvl\":14,\"glory\":0},{\"buildName\":\"Oil Well\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Oil Well\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Oil Well\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Oil Well\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Steel Mill\",\"lvl\":16,\"glory\":0},{\"buildName\":\"Farm\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Farm\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Farm\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Farm\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Farm\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Farm\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Farm\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Farm\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Farm\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Farm\",\"lvl\":6,\"glory\":0},{\"buildName\":\"War Factory\",\"lvl\":14,\"glory\":0},{\"buildName\":\"Comm. Building\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Tower\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Tower\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Wall\",\"lvl\":18,\"glory\":0},{\"buildName\":\"Military Office\",\"lvl\":11,\"glory\":0},{\"buildName\":\"Mobile Team Factory\",\"lvl\":16,\"glory\":0},{\"buildName\":\"Armed Forces\",\"lvl\":16,\"glory\":0},{\"buildName\":\"Infection Institute\",\"lvl\":8,\"glory\":0},{\"buildName\":\"Logistics Center\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Shrine\",\"lvl\":2,\"glory\":0},{\"buildName\":\"Armory\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Cafeteria\",\"lvl\":5,\"glory\":0},{\"buildName\":\"Prison\",\"lvl\":2,\"glory\":0},{\"buildName\":\"Clone Lab\",\"lvl\":4,\"glory\":0},{\"buildName\":\"Dorm\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Star Stone Institute\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Smelting Workshop\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Arena\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Mystical Building\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Obsidian Refine Building\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Training House\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Tech. Institute\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Project Origin Institute\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Vehicle Institute\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Tech. Research Lab.\",\"lvl\":1,\"glory\":0}]}";
                    sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("ppl", "DEMO");
                    editor.apply();
                    jsonStr = sh.makeServiceCall(url);
                }
*/
            // Log.e(TAG, "Response from url: " + jsonStr);


            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Log.i("TOTAL_Grab","ok");
            TextView watching = findViewById(R.id.watching_tv);
            String all = getString(R.string.watching)+ppl;
            watching.setText(all);
            progressReset();
            dataRefresh();
            //bar_char();
            preferencesRefresh();
        }
    }

    public void troop_pie (View view){
        chart_bar(1);
    }
    private void progressReset() {


        if (armyFinishNumArray[0] 	 !=0){progressTotalArray[0] =	armyFinishNumArray[0];	; progressCountArray[0] = 	armyIdNumArray[0]	; progressCountArray[0] = 	armyCountNumArray[0];}
        if (armyFinishNumArray[1]	 !=0){progressTotalArray[0] =	armyFinishNumArray[1];	; progressIdArray[0] = 	armyIdNumArray[1]	; progressCountArray[0] = 	armyCountNumArray[1];}
        if (armyFinishNumArray[2]	 !=0){progressTotalArray[0] =	armyFinishNumArray[2];	; progressIdArray[0] = 	armyIdNumArray[2]	; progressCountArray[0] = 	armyCountNumArray[2];}
        if (armyFinishNumArray[3]	 !=0){progressTotalArray[0] =	armyFinishNumArray[3];	; progressIdArray[0] = 	armyIdNumArray[3]	; progressCountArray[0] = 	armyCountNumArray[3];}
        if (armyFinishNumArray[4]	 !=0){progressTotalArray[0] =	armyFinishNumArray[4];	; progressIdArray[0] = 	armyIdNumArray[4]	; progressCountArray[0] = 	armyCountNumArray[4];}
        if (armyFinishNumArray[5]	 !=0){progressTotalArray[0] =	armyFinishNumArray[5];	; progressIdArray[0] = 	armyIdNumArray[5]	; progressCountArray[0] = 	armyCountNumArray[5];}
        if (armyFinishNumArray[6]	 !=0){progressTotalArray[0] =	armyFinishNumArray[6];	; progressIdArray[0] = 	armyIdNumArray[6]	; progressCountArray[0] = 	armyCountNumArray[6];}
        if (armyFinishNumArray[7]	 !=0){progressTotalArray[0] =	armyFinishNumArray[7];	; progressIdArray[0] = 	armyIdNumArray[7]	; progressCountArray[0] = 	armyCountNumArray[7];}
        if (armyFinishNumArray[8]	 !=0){progressTotalArray[0] =	armyFinishNumArray[8];	; progressIdArray[0] = 	armyIdNumArray[8]	; progressCountArray[0] = 	armyCountNumArray[8];}
        if (armyFinishNumArray[9]	 !=0){progressTotalArray[0] =	armyFinishNumArray[9];	; progressIdArray[0] = 	armyIdNumArray[9]	; progressCountArray[0] = 	armyCountNumArray[9];}
        if (armyFinishNumArray[10]	 !=0){progressTotalArray[1] =	armyFinishNumArray[10];	; progressIdArray[1] = 	armyIdNumArray[10]	; progressCountArray[1] =	armyCountNumArray[10];}
        if (armyFinishNumArray[11]	 !=0){progressTotalArray[1] =	armyFinishNumArray[11];	; progressIdArray[1] = 	armyIdNumArray[11]	; progressCountArray[1] =	armyCountNumArray[11];}
        if (armyFinishNumArray[12]	 !=0){progressTotalArray[1] =	armyFinishNumArray[12];	; progressIdArray[1] = 	armyIdNumArray[12]	; progressCountArray[1] =	armyCountNumArray[12];}
        if (armyFinishNumArray[13]	 !=0){progressTotalArray[1] =	armyFinishNumArray[13];	; progressIdArray[1] = 	armyIdNumArray[13]	; progressCountArray[1] =	armyCountNumArray[13];}
        if (armyFinishNumArray[14]	 !=0){progressTotalArray[1] =	armyFinishNumArray[14];	; progressIdArray[1] = 	armyIdNumArray[14]	; progressCountArray[1] =	armyCountNumArray[14];}
        if (armyFinishNumArray[15]	 !=0){progressTotalArray[1] =	armyFinishNumArray[15];	; progressIdArray[1] = 	armyIdNumArray[15]	; progressCountArray[1] =	armyCountNumArray[15];}
        if (armyFinishNumArray[16]	 !=0){progressTotalArray[1] =	armyFinishNumArray[16];	; progressIdArray[1] = 	armyIdNumArray[16]	; progressCountArray[1] =	armyCountNumArray[16];}
        if (armyFinishNumArray[17]	 !=0){progressTotalArray[1] =	armyFinishNumArray[17];	; progressIdArray[1] = 	armyIdNumArray[17]	; progressCountArray[1] =	armyCountNumArray[17];}
        if (armyFinishNumArray[18]	 !=0){progressTotalArray[1] =	armyFinishNumArray[18];	; progressIdArray[1] = 	armyIdNumArray[18]	; progressCountArray[1] =	armyCountNumArray[18];}
        if (armyFinishNumArray[19]	 !=0){progressTotalArray[1] =	armyFinishNumArray[19];	; progressIdArray[1] = 	armyIdNumArray[19]	; progressCountArray[1] =	armyCountNumArray[19];}
        if (armyFinishNumArray[20]	 !=0){progressTotalArray[2] =	armyFinishNumArray[20];	; progressIdArray[2] = 	armyIdNumArray[20]	; progressCountArray[2] =	armyCountNumArray[20];}
        if (armyFinishNumArray[21]	 !=0){progressTotalArray[2] =	armyFinishNumArray[21];	; progressIdArray[2] = 	armyIdNumArray[21]	; progressCountArray[2] =	armyCountNumArray[21];}
        if (armyFinishNumArray[22]	 !=0){progressTotalArray[2] =	armyFinishNumArray[22];	; progressIdArray[2] = 	armyIdNumArray[22]	; progressCountArray[2] =	armyCountNumArray[22];}
        if (armyFinishNumArray[23]	 !=0){progressTotalArray[2] =	armyFinishNumArray[23];	; progressIdArray[2] = 	armyIdNumArray[23]	; progressCountArray[2] =	armyCountNumArray[23];}
        if (armyFinishNumArray[24]	 !=0){progressTotalArray[2] =	armyFinishNumArray[24];	; progressIdArray[2] = 	armyIdNumArray[24]	; progressCountArray[2] =	armyCountNumArray[24];}
        if (armyFinishNumArray[25]	 !=0){progressTotalArray[2] =	armyFinishNumArray[25];	; progressIdArray[2] = 	armyIdNumArray[25]	; progressCountArray[2] =	armyCountNumArray[25];}
        if (armyFinishNumArray[26]	 !=0){progressTotalArray[2] =	armyFinishNumArray[26];	; progressIdArray[2] = 	armyIdNumArray[26]	; progressCountArray[2] =	armyCountNumArray[26];}
        if (armyFinishNumArray[27]	 !=0){progressTotalArray[2] =	armyFinishNumArray[27];	; progressIdArray[2] = 	armyIdNumArray[27]	; progressCountArray[2] =	armyCountNumArray[27];}
        if (armyFinishNumArray[28]	 !=0){progressTotalArray[2] =	armyFinishNumArray[28];	; progressIdArray[2] = 	armyIdNumArray[28]	; progressCountArray[2] =	armyCountNumArray[28];}
        if (armyFinishNumArray[29]	 !=0){progressTotalArray[2] =	armyFinishNumArray[29];	; progressIdArray[2] = 	armyIdNumArray[29]	; progressCountArray[2] =	armyCountNumArray[29];}
        if (armyFinishNumArray[30]	 !=0){progressTotalArray[3] =	armyFinishNumArray[30];	; progressIdArray[3] = 	armyIdNumArray[30]	; progressCountArray[3] =	armyCountNumArray[30];}
        if (armyFinishNumArray[31]	 !=0){progressTotalArray[3] =	armyFinishNumArray[31];	; progressIdArray[3] = 	armyIdNumArray[31]	; progressCountArray[3] =	armyCountNumArray[31];}
        if (armyFinishNumArray[32]	 !=0){progressTotalArray[3] =	armyFinishNumArray[32];	; progressIdArray[3] = 	armyIdNumArray[32]	; progressCountArray[3] =	armyCountNumArray[32];}
        if (armyFinishNumArray[33]	 !=0){progressTotalArray[3] =	armyFinishNumArray[33];	; progressIdArray[3] = 	armyIdNumArray[33]	; progressCountArray[3] =	armyCountNumArray[33];}
        if (armyFinishNumArray[34]	 !=0){progressTotalArray[3] =	armyFinishNumArray[34];	; progressIdArray[3] = 	armyIdNumArray[34]	; progressCountArray[3] =	armyCountNumArray[34];}
        if (armyFinishNumArray[35]	 !=0){progressTotalArray[3] =	armyFinishNumArray[35];	; progressIdArray[3] = 	armyIdNumArray[35]	; progressCountArray[3] =	armyCountNumArray[35];}
        if (armyFinishNumArray[36]	 !=0){progressTotalArray[3] =	armyFinishNumArray[36];	; progressIdArray[3] = 	armyIdNumArray[36]	; progressCountArray[3] =	armyCountNumArray[36];}
        if (armyFinishNumArray[37]	 !=0){progressTotalArray[3] =	armyFinishNumArray[37];	; progressIdArray[3] = 	armyIdNumArray[37]	; progressCountArray[3] =	armyCountNumArray[37];}
        if (armyFinishNumArray[38]	 !=0){progressTotalArray[3] =	armyFinishNumArray[38];	; progressIdArray[3] = 	armyIdNumArray[38]	; progressCountArray[3] =	armyCountNumArray[38];}
        if (armyFinishNumArray[39]	 !=0){progressTotalArray[3] =	armyFinishNumArray[39];	; progressIdArray[3] = 	armyIdNumArray[39]	; progressCountArray[3] =	armyCountNumArray[39];}
        if (armyFinishNumArray[40]	 !=0){progressTotalArray[4] =	armyFinishNumArray[40];	; progressIdArray[4] = 	armyIdNumArray[40]	; progressCountArray[4] =	armyCountNumArray[40];}
        if (armyFinishNumArray[41]	 !=0){progressTotalArray[4] =	armyFinishNumArray[41];	; progressIdArray[4] = 	armyIdNumArray[41]	; progressCountArray[4] =	armyCountNumArray[41];}
        if (armyFinishNumArray[42]	 !=0){progressTotalArray[4] =	armyFinishNumArray[42];	; progressIdArray[4] = 	armyIdNumArray[42]	; progressCountArray[4] =	armyCountNumArray[42];}
        if (armyFinishNumArray[43]	 !=0){progressTotalArray[4] =	armyFinishNumArray[43];	; progressIdArray[4] = 	armyIdNumArray[43]	; progressCountArray[4] =	armyCountNumArray[43];}
        if (armyFinishNumArray[44]	 !=0){progressTotalArray[4] =	armyFinishNumArray[44];	; progressIdArray[4] = 	armyIdNumArray[44]	; progressCountArray[4] =	armyCountNumArray[44];}
        if (armyFinishNumArray[45]	 !=0){progressTotalArray[4] =	armyFinishNumArray[45];	; progressIdArray[4] = 	armyIdNumArray[45]	; progressCountArray[4] =	armyCountNumArray[45];}
        if (armyFinishNumArray[46]	 !=0){progressTotalArray[4] =	armyFinishNumArray[46];	; progressIdArray[4] = 	armyIdNumArray[46]	; progressCountArray[4] =	armyCountNumArray[46];}
        if (armyFinishNumArray[47]	 !=0){progressTotalArray[4] =	armyFinishNumArray[47];	; progressIdArray[4] = 	armyIdNumArray[47]	; progressCountArray[4] =	armyCountNumArray[47];}
        if (armyFinishNumArray[48]	 !=0){progressTotalArray[4] =	armyFinishNumArray[48];	; progressIdArray[4] = 	armyIdNumArray[48]	; progressCountArray[4] =	armyCountNumArray[48];}
        if (armyFinishNumArray[49]	 !=0){progressTotalArray[4] =	armyFinishNumArray[49];	; progressIdArray[4] = 	armyIdNumArray[49]	; progressCountArray[4] =	armyCountNumArray[49];}


        arm_progress = progressRemainArray[0] ;
        mili_progress = progressRemainArray[1] ;
        mobile_progress = progressRemainArray[2] ;
        infect_progress = progressRemainArray[3] ;
        project_progress = progressRemainArray[4] ;

        arm_total = progressTotalArray[0] ;
        mili_total = progressTotalArray[1] ;
        mobile_total = progressTotalArray[2] ;
        infect_total = progressTotalArray[3] ;
        project_total = progressTotalArray[4] ;

        if (arm_progress <= 0 && arm_total >= 0){armed_process_tv.setText(getString(R.string.progress_done));}
        if (mili_progress <= 0 && mili_total >= 0){mili_process_tv.setText(getString(R.string.progress_done));}
        if (mobile_progress <= 0 && mobile_total >= 0){mobile_process_tv.setText(getString(R.string.progress_done));}
        if (infect_progress <= 0 && infect_total >= 0){infect_process_tv.setText(getString(R.string.progress_done));}
        if (project_progress <= 0 && project_total >= 0){project_process_tv.setText(getString(R.string.progress_done));}

        if (progressCountArray[0] == 0 ){progressIdArray[0] = -1 ;armed_process_tv.setText(getString(R.string.process_nothing));armed_total_tv.setText("");}
        if (progressCountArray[1] == 0 ){progressIdArray[1] = -2 ;mili_process_tv.setText(getString(R.string.process_nothing));mili_total_tv.setText("");}
        if (progressCountArray[2] == 0 ){progressIdArray[2] = -3 ;mobile_process_tv.setText(getString(R.string.process_nothing));mobile_total_tv.setText("");}
        if (progressCountArray[3] == 0 ){progressIdArray[3] = -4 ;infect_process_tv.setText(getString(R.string.process_nothing));infect_total_tv.setText("");}
        if (progressCountArray[4] == 0 ){progressIdArray[4] = -5 ;project_process_tv.setText(getString(R.string.process_nothing));project_total_tv.setText("");}
    }

    public String FormatTime (Long l){
        String Time_String = "";
        long days = l / 86400;
        long hours = l / 3600;
        long minutes = (l % 3600) / 60;
        long seconds = l % 60;


        hours = hours - 24*days;

        Time_String = String.format("%02dd %02d:%02d:%02d", days , hours, minutes, seconds);
        return Time_String ;

    }

    public void dataEnaber (View view){
        Intent i = new Intent(DataListActivity.this , DataEnablerActivity.class);
        i.putExtra("UID",uid);
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("ppl", ppl);
        editor.apply();
        startActivity(i);
    }
    public void dataEnaber2 (View view){
        Intent i = new Intent(DataListActivity.this , DataEnablerActivity.class);
        i.putExtra("UID",uid);
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("ppl", ppl);
        editor.apply();
        sleep = true ;
        finish();
        startActivity(i);
    }
    public void dataTroop (View view){
        Intent i = new Intent(DataListActivity.this , DataTroopActivity.class);
        i.putExtra("UID",uid);
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("ppl", ppl);
        editor.apply();
        sleep = true ;
        finish();
        startActivity(i);
    }
    public void testSortAscendingDescending() throws Exception {

    }

    private static final int TAKE_DATA_REFRESH = 0;
    private static final int DATA_REFRESH = 2;
    private static final int PROGRESS_REFRESH = 1;
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {

            switch (msg.what) {
                case TAKE_DATA_REFRESH:
                    if (!sleep){
                        new TakeData().execute();
                    }
                    break;
                case DATA_REFRESH:
                    dataRefresh();
                    break;
                case PROGRESS_REFRESH:
                    progressRefresh();
                default:
                    break;
            }
        }

    };



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            sleep = true ;
            finishAndRemoveTask();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    public void queue (int i  , ArrayList<Long> s , int num , TextView tv){
        ImageView img = findViewById(i);
        if (s.get(num) ==	(armyFreeNumArray[ 0]+	armyMarchNumArray[ 0 ]))	{img.setImageResource(R.drawable.	mili01	);img.setBackgroundResource(R.drawable.	troops_bg2);	troop_show_name[num] =	1;}
        if (s.get(num) ==	(armyFreeNumArray[ 1]+	armyMarchNumArray[ 1 ]))	{img.setImageResource(R.drawable.	mili02	);img.setBackgroundResource(R.drawable.	troops_bg2);	troop_show_name[num] =	2;}
        if (s.get(num) ==	(armyFreeNumArray[ 2]+	armyMarchNumArray[ 2 ]))	{img.setImageResource(R.drawable.	mili03	);img.setBackgroundResource(R.drawable.	troops_bg2);	troop_show_name[num] =	3;}
        if (s.get(num) ==	(armyFreeNumArray[ 3]+	armyMarchNumArray[ 3 ]))	{img.setImageResource(R.drawable.	mili04	);img.setBackgroundResource(R.drawable.	troops_bg2);	troop_show_name[num] =	4;}
        if (s.get(num) ==	(armyFreeNumArray[ 4]+	armyMarchNumArray[ 4 ]))	{img.setImageResource(R.drawable.	mili05	);img.setBackgroundResource(R.drawable.	troops_bg2);	troop_show_name[num] =	5;}
        if (s.get(num) ==	(armyFreeNumArray[ 5]+	armyMarchNumArray[ 5 ]))	{img.setImageResource(R.drawable.	mili06	);img.setBackgroundResource(R.drawable.	troops_bg2);	troop_show_name[num] =	6;}
        if (s.get(num) ==	(armyFreeNumArray[ 6]+	armyMarchNumArray[ 6 ]))	{img.setImageResource(R.drawable.	mili07	);img.setBackgroundResource(R.drawable.	troops_bg2);	troop_show_name[num] =	7;}
        if (s.get(num) ==	(armyFreeNumArray[ 7]+	armyMarchNumArray[ 7 ]))	{img.setImageResource(R.drawable.	mili08	);img.setBackgroundResource(R.drawable.	troops_bg2);	troop_show_name[num] =	8;}
        if (s.get(num) ==	(armyFreeNumArray[ 8]+	armyMarchNumArray[ 8 ]))	{img.setImageResource(R.drawable.	mili09	);img.setBackgroundResource(R.drawable.	troops_bg2);	troop_show_name[num] =	9;}
        if (s.get(num) ==	(armyFreeNumArray[ 9]+	armyMarchNumArray[ 9 ]))	{img.setImageResource(R.drawable.	mili10	);img.setBackgroundResource(R.drawable.	troops_bg2);	troop_show_name[num] =	10;}
        if (s.get(num) ==	(armyFreeNumArray[ 10]+	armyMarchNumArray[ 10 ]))	{img.setImageResource(R.drawable.	mobile01	);img.setBackgroundResource(R.drawable.	troops_bg3);	troop_show_name[num] =	11;}
        if (s.get(num) ==	(armyFreeNumArray[ 11]+	armyMarchNumArray[ 11 ]))	{img.setImageResource(R.drawable.	mobile02	);img.setBackgroundResource(R.drawable.	troops_bg3);	troop_show_name[num] =	12;}
        if (s.get(num) ==	(armyFreeNumArray[ 12]+	armyMarchNumArray[ 12 ]))	{img.setImageResource(R.drawable.	mobile03	);img.setBackgroundResource(R.drawable.	troops_bg3);	troop_show_name[num] =	13;}
        if (s.get(num) ==	(armyFreeNumArray[ 13]+	armyMarchNumArray[ 13 ]))	{img.setImageResource(R.drawable.	mobile04	);img.setBackgroundResource(R.drawable.	troops_bg3);	troop_show_name[num] =	14;}
        if (s.get(num) ==	(armyFreeNumArray[ 14]+	armyMarchNumArray[ 14 ]))	{img.setImageResource(R.drawable.	mobile05	);img.setBackgroundResource(R.drawable.	troops_bg3);	troop_show_name[num] =	15;}
        if (s.get(num) ==	(armyFreeNumArray[ 15]+	armyMarchNumArray[ 15 ]))	{img.setImageResource(R.drawable.	mobile06	);img.setBackgroundResource(R.drawable.	troops_bg3);	troop_show_name[num] =	16;}
        if (s.get(num) ==	(armyFreeNumArray[ 16]+	armyMarchNumArray[ 16 ]))	{img.setImageResource(R.drawable.	mobile07	);img.setBackgroundResource(R.drawable.	troops_bg3);	troop_show_name[num] =	17;}
        if (s.get(num) ==	(armyFreeNumArray[ 17]+	armyMarchNumArray[ 17 ]))	{img.setImageResource(R.drawable.	mobile08	);img.setBackgroundResource(R.drawable.	troops_bg3);	troop_show_name[num] =	18;}
        if (s.get(num) ==	(armyFreeNumArray[ 18]+	armyMarchNumArray[ 18 ]))	{img.setImageResource(R.drawable.	mobile09	);img.setBackgroundResource(R.drawable.	troops_bg3);	troop_show_name[num] =	19;}
        if (s.get(num) ==	(armyFreeNumArray[ 19]+	armyMarchNumArray[ 19 ]))	{img.setImageResource(R.drawable.	mobile10	);img.setBackgroundResource(R.drawable.	troops_bg3);	troop_show_name[num] =	20;}
        if (s.get(num) ==	(armyFreeNumArray[ 20]+	armyMarchNumArray[ 20 ]))	{img.setImageResource(R.drawable.	arm01	);img.setBackgroundResource(R.drawable.	troops_bg1);	troop_show_name[num] =	21;}
        if (s.get(num) ==	(armyFreeNumArray[ 21]+	armyMarchNumArray[ 21 ]))	{img.setImageResource(R.drawable.	arm02	);img.setBackgroundResource(R.drawable.	troops_bg1);	troop_show_name[num] =	22;}
        if (s.get(num) ==	(armyFreeNumArray[ 22]+	armyMarchNumArray[ 22 ]))	{img.setImageResource(R.drawable.	arm03	);img.setBackgroundResource(R.drawable.	troops_bg1);	troop_show_name[num] =	23;}
        if (s.get(num) ==	(armyFreeNumArray[ 23]+	armyMarchNumArray[ 23 ]))	{img.setImageResource(R.drawable.	arm04	);img.setBackgroundResource(R.drawable.	troops_bg1);	troop_show_name[num] =	24;}
        if (s.get(num) ==	(armyFreeNumArray[ 24]+	armyMarchNumArray[ 24 ]))	{img.setImageResource(R.drawable.	arm05	);img.setBackgroundResource(R.drawable.	troops_bg1);	troop_show_name[num] =	25;}
        if (s.get(num) ==	(armyFreeNumArray[ 25]+	armyMarchNumArray[ 25 ]))	{img.setImageResource(R.drawable.	arm06	);img.setBackgroundResource(R.drawable.	troops_bg1);	troop_show_name[num] =	26;}
        if (s.get(num) ==	(armyFreeNumArray[ 26]+	armyMarchNumArray[ 26 ]))	{img.setImageResource(R.drawable.	arm07	);img.setBackgroundResource(R.drawable.	troops_bg1);	troop_show_name[num] =	27;}
        if (s.get(num) ==	(armyFreeNumArray[ 27]+	armyMarchNumArray[ 27 ]))	{img.setImageResource(R.drawable.	arm08	);img.setBackgroundResource(R.drawable.	troops_bg1);	troop_show_name[num] =	28;}
        if (s.get(num) ==	(armyFreeNumArray[ 28]+	armyMarchNumArray[ 28 ]))	{img.setImageResource(R.drawable.	arm09	);img.setBackgroundResource(R.drawable.	troops_bg1);	troop_show_name[num] =	29;}
        if (s.get(num) ==	(armyFreeNumArray[ 29]+	armyMarchNumArray[ 29 ]))	{img.setImageResource(R.drawable.	arm10	);img.setBackgroundResource(R.drawable.	troops_bg1);	troop_show_name[num] =	30;}
        if (s.get(num) ==	(armyFreeNumArray[ 30]+	armyMarchNumArray[ 30 ]))	{img.setImageResource(R.drawable.	infect01	);img.setBackgroundResource(R.drawable.	troops_bg4);	troop_show_name[num] =	31;}
        if (s.get(num) ==	(armyFreeNumArray[ 31]+	armyMarchNumArray[ 31 ]))	{img.setImageResource(R.drawable.	infect02	);img.setBackgroundResource(R.drawable.	troops_bg4);	troop_show_name[num] =	32;}
        if (s.get(num) ==	(armyFreeNumArray[ 32]+	armyMarchNumArray[ 32 ]))	{img.setImageResource(R.drawable.	infect03	);img.setBackgroundResource(R.drawable.	troops_bg4);	troop_show_name[num] =	33;}
        if (s.get(num) ==	(armyFreeNumArray[ 33]+	armyMarchNumArray[ 33 ]))	{img.setImageResource(R.drawable.	infect04	);img.setBackgroundResource(R.drawable.	troops_bg4);	troop_show_name[num] =	34;}
        if (s.get(num) ==	(armyFreeNumArray[ 34]+	armyMarchNumArray[ 34 ]))	{img.setImageResource(R.drawable.	infect05	);img.setBackgroundResource(R.drawable.	troops_bg4);	troop_show_name[num] =	35;}
        if (s.get(num) ==	(armyFreeNumArray[ 35]+	armyMarchNumArray[ 35 ]))	{img.setImageResource(R.drawable.	infect06	);img.setBackgroundResource(R.drawable.	troops_bg4);	troop_show_name[num] =	36;}
        if (s.get(num) ==	(armyFreeNumArray[ 36]+	armyMarchNumArray[ 36 ]))	{img.setImageResource(R.drawable.	infect07	);img.setBackgroundResource(R.drawable.	troops_bg4);	troop_show_name[num] =	37;}
        if (s.get(num) ==	(armyFreeNumArray[ 37]+	armyMarchNumArray[ 37 ]))	{img.setImageResource(R.drawable.	infect08	);img.setBackgroundResource(R.drawable.	troops_bg4);	troop_show_name[num] =	38;}
        if (s.get(num) ==	(armyFreeNumArray[ 38]+	armyMarchNumArray[ 38 ]))	{img.setImageResource(R.drawable.	infect09	);img.setBackgroundResource(R.drawable.	troops_bg4);	troop_show_name[num] =	39;}
        if (s.get(num) ==	(armyFreeNumArray[ 39]+	armyMarchNumArray[ 39 ]))	{img.setImageResource(R.drawable.	infect10	);img.setBackgroundResource(R.drawable.	troops_bg4);	troop_show_name[num] =	40;}
        if (s.get(num) ==	(armyFreeNumArray[ 40]+	armyMarchNumArray[ 40 ]))	{img.setImageResource(R.drawable.	project01	);img.setBackgroundResource(R.drawable.	troops_bg5);	troop_show_name[num] =	41;}
        if (s.get(num) ==	(armyFreeNumArray[ 41]+	armyMarchNumArray[ 41 ]))	{img.setImageResource(R.drawable.	project02	);img.setBackgroundResource(R.drawable.	troops_bg5);	troop_show_name[num] =	42;}
        if (s.get(num) ==	(armyFreeNumArray[ 42]+	armyMarchNumArray[ 42 ]))	{img.setImageResource(R.drawable.	project03	);img.setBackgroundResource(R.drawable.	troops_bg5);	troop_show_name[num] =	43;}
        if (s.get(num) ==	(armyFreeNumArray[ 43]+	armyMarchNumArray[ 43 ]))	{img.setImageResource(R.drawable.	project04	);img.setBackgroundResource(R.drawable.	troops_bg5);	troop_show_name[num] =	44;}
        if (s.get(num) ==	(armyFreeNumArray[ 44]+	armyMarchNumArray[ 44 ]))	{img.setImageResource(R.drawable.	project05	);img.setBackgroundResource(R.drawable.	troops_bg5);	troop_show_name[num] =	45;}
        if (s.get(num) ==	(armyFreeNumArray[ 45]+	armyMarchNumArray[ 45 ]))	{img.setImageResource(R.drawable.	project06	);img.setBackgroundResource(R.drawable.	troops_bg5);	troop_show_name[num] =	46;}
        if (s.get(num) ==	(armyFreeNumArray[ 46]+	armyMarchNumArray[ 46 ]))	{img.setImageResource(R.drawable.	project07	);img.setBackgroundResource(R.drawable.	troops_bg5);	troop_show_name[num] =	47;}
        if (s.get(num) ==	(armyFreeNumArray[ 47]+	armyMarchNumArray[ 47 ]))	{img.setImageResource(R.drawable.	project08	);img.setBackgroundResource(R.drawable.	troops_bg5);	troop_show_name[num] =	48;}
        if (s.get(num) ==	(armyFreeNumArray[ 48]+	armyMarchNumArray[ 48 ]))	{img.setImageResource(R.drawable.	project09	);img.setBackgroundResource(R.drawable.	troops_bg5);	troop_show_name[num] =	49;}
        if (s.get(num) ==	(armyFreeNumArray[ 49]+	armyMarchNumArray[ 49 ]))	{img.setImageResource(R.drawable.	project10	);img.setBackgroundResource(R.drawable.	troops_bg5);	troop_show_name[num] =	50;}
        if (s.get(num) ==	0)	{img.setVisibility(GONE);tv.setVisibility(GONE);}

    }

    public void starReName(int i , ImageView img ){
        if (starArray[i] == 0)	{img.setVisibility(GONE);}
        if (starArray[i] == 1)	{img.setImageResource(R.drawable.star01);}
        if (starArray[i] == 2)	{img.setImageResource(R.drawable.star02);}
        if (starArray[i] == 3)	{img.setImageResource(R.drawable.star03);}
        if (starArray[i] == 4)	{img.setImageResource(R.drawable.star04);}
        if (starArray[i] == 5)	{img.setImageResource(R.drawable.star05);}
        if (starArray[i] == 6)	{img.setImageResource(R.drawable.star06);}
        if (starArray[i] == 7)	{img.setImageResource(R.drawable.star07);}
        if (starArray[i] == 8)	{img.setImageResource(R.drawable.star08);}
        if (starArray[i] == 9)	{img.setImageResource(R.drawable.star09);}
        if (starArray[i] == 10)	{img.setImageResource(R.drawable.star10);}
        if (starArray[i] == 11)	{img.setImageResource(R.drawable.star11);}
        if (starArray[i] == 12)	{img.setImageResource(R.drawable.star12);}
        if (starArray[i] == 13)	{img.setImageResource(R.drawable.star13);}
        if (starArray[i] == 14)	{img.setImageResource(R.drawable.star14);}
        if (starArray[i] == 15)	{img.setImageResource(R.drawable.star15);}
        if (starArray[i] == 16)	{img.setImageResource(R.drawable.star16);}
        if (starArray[i] == 17)	{img.setImageResource(R.drawable.star17);}
        if (starArray[i] == 18)	{img.setImageResource(R.drawable.star18);}
        if (starArray[i] == 19)	{img.setImageResource(R.drawable.star19);}
        if (starArray[i] == 20)	{img.setImageResource(R.drawable.star20);}
    }

    public void onClick(View v) {
        // Perform action on click
        switch(v.getId())
        {
            case R.id.arm10_img :
                nah = 0 ;
                troopIntro(v);
                break;
            case R.id.mili10_img :
                nah = 1 ;
                troopIntro(v);
                break;
            case R.id.mobile10_img :
                nah = 2 ;
                troopIntro(v);
                break;
            case R.id.infect10_img :
                nah = 3 ;
                troopIntro(v);
                break;
            case R.id.project10_img :
                nah = 4 ;
                troopIntro(v);
                break;
            case R.id.arm09_img :
                nah = 5 ;
                troopIntro(v);
                break;
            case R.id.mili09_img :
                nah = 6 ;
                troopIntro(v);
                break;
            case R.id.mobile09_img :
                nah = 7 ;
                troopIntro(v);
                break;
            case R.id.infect09_img :
                nah = 8 ;
                troopIntro(v);
                break;
            case R.id.project09_img :
                nah = 9 ;
                troopIntro(v);
                break;
            case R.id.armed_process_img :
                if (progressIdArray[0] != -1 && progressIdArray[0] !=0){
                    process_show_name = (1+progressIdArray[0]);
                    troopIntro2(v);
                }else {process_show_name = (-3);}
                break;
            case R.id.military_process_img :
                if (progressIdArray[1] != -1&&progressIdArray[1] !=0){
                    process_show_name = (1+progressIdArray[1]);
                    troopIntro2(v);
                }else {process_show_name = (-1);}
                break;
            case R.id.mobile_process_img :
                if (progressIdArray[2] != -1&&progressIdArray[2] !=0){
                    process_show_name = (1+progressIdArray[2]);
                    troopIntro2(v);
                }else {process_show_name = (-2);}
                break;
            case R.id.infect_process_img :
                if (progressIdArray[3] != -1&&progressIdArray[3] !=0){
                    process_show_name = (1+progressIdArray[3]);
                    troopIntro2(v);
                }else {process_show_name = (-4);}
                break;
            case R.id.project_process_img :
                if (progressIdArray[4] != -1&&progressIdArray[4] !=0){
                    process_show_name = (1+progressIdArray[4]);
                    troopIntro2(v);
                }else {process_show_name = (-5);}
                break;
            case R.id.boom_img1 :
                bah = 1 ;
                boomerIntro(v);
                break;
            case R.id.boom_img2 :
                bah = 2 ;
                boomerIntro(v);
                break;
            case R.id.boom_img3 :
                bah = 3 ;
                boomerIntro(v);
                break;
            case R.id.boom_img4 :
                bah = 4 ;
                boomerIntro(v);
                break;
            case R.id.boom_img5 :
                bah = 5 ;
                boomerIntro(v);
                break;
            case R.id.boom_img6 :
                bah = 6 ;
                boomerIntro(v);
                break;
            case R.id.boom_img7 :
                bah = 7 ;
                boomerIntro(v);
                break;
            case R.id.boom_img8 :
                bah = 8 ;
                boomerIntro(v);
                break;
            case R.id.boom_img9 :
                bah = 9 ;
                boomerIntro(v);
                break;
            case R.id.boom_img10 :
                bah = 10 ;
                boomerIntro(v);
                break;
            case R.id.boom_img11 :
                bah = 11 ;
                boomerIntro(v);
                break;
            case R.id.boom_img12 :
                bah = 12 ;
                boomerIntro(v);
                break;
            case R.id.boom_img13 :
                bah = 13 ;
                boomerIntro(v);
                break;
            case R.id.boom_img14 :
                bah = 14 ;
                boomerIntro(v);
                break;
            case R.id.boom_img15 :
                bah = 15 ;
                boomerIntro(v);
                break;


        }
    }

    public void troopIntro (View view){
        final Dialog dialog = new Dialog(this, R.style.NormalDialogStyle_N);
        view = View.inflate(this, R.layout.troop_about, null);
        //TextView dc_server = view.findViewById(R.id.dc_server);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        //view.setMinimumHeight((int) (ScreenSizeUtils.getInstance(this).getScreenHeight()));
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int) (ScreenSizeUtils.getInstance(this).getScreenWidth());
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);
        ImageView img = view.findViewById(R.id.troop_img);
        TextView name = view.findViewById(R.id.troop_name);
        TextView intro = view.findViewById(R.id.troop_intro);

        int num = nah;

        if(troop_show_name[num] == 1 ){	img.setImageResource(R.drawable.	mili01	); name.setText(getString(R.string.	mili_1	)); intro.setText(getString(R.string.		mili01_intro	));}
        if(troop_show_name[num] == 2 ){	img.setImageResource(R.drawable.	mili02	); name.setText(getString(R.string.	mili_2	)); intro.setText(getString(R.string.		mili02_intro	));}
        if(troop_show_name[num] == 3 ){	img.setImageResource(R.drawable.	mili03	); name.setText(getString(R.string.	mili_3	)); intro.setText(getString(R.string.		mili03_intro	));}
        if(troop_show_name[num] == 4 ){	img.setImageResource(R.drawable.	mili04	); name.setText(getString(R.string.	mili_4	)); intro.setText(getString(R.string.		mili04_intro	));}
        if(troop_show_name[num] == 5 ){	img.setImageResource(R.drawable.	mili05	); name.setText(getString(R.string.	mili_5	)); intro.setText(getString(R.string.		mili05_intro	));}
        if(troop_show_name[num] == 6 ){	img.setImageResource(R.drawable.	mili06	); name.setText(getString(R.string.	mili_6	)); intro.setText(getString(R.string.		mili06_intro	));}
        if(troop_show_name[num] == 7 ){	img.setImageResource(R.drawable.	mili07	); name.setText(getString(R.string.	mili_7	)); intro.setText(getString(R.string.		mili07_intro	));}
        if(troop_show_name[num] == 8 ){	img.setImageResource(R.drawable.	mili08	); name.setText(getString(R.string.	mili_8	)); intro.setText(getString(R.string.		mili08_intro	));}
        if(troop_show_name[num] == 9 ){	img.setImageResource(R.drawable.	mili09	); name.setText(getString(R.string.	mili_9	)); intro.setText(getString(R.string.		mili09_intro	));}
        if(troop_show_name[num] == 10 ){	img.setImageResource(R.drawable.	mili10	); name.setText(getString(R.string.	mili_10	)); intro.setText(getString(R.string.		mili10_intro	));}
        if(troop_show_name[num] == 11 ){	img.setImageResource(R.drawable.	mobile01	); name.setText(getString(R.string.	mobile_1	)); intro.setText(getString(R.string.		mobile01_intro	));}
        if(troop_show_name[num] == 12 ){	img.setImageResource(R.drawable.	mobile02	); name.setText(getString(R.string.	mobile_2	)); intro.setText(getString(R.string.		mobile02_intro	));}
        if(troop_show_name[num] == 13 ){	img.setImageResource(R.drawable.	mobile03	); name.setText(getString(R.string.	mobile_3	)); intro.setText(getString(R.string.		mobile03_intro	));}
        if(troop_show_name[num] == 14 ){	img.setImageResource(R.drawable.	mobile04	); name.setText(getString(R.string.	mobile_4	)); intro.setText(getString(R.string.		mobile04_intro	));}
        if(troop_show_name[num] == 15 ){	img.setImageResource(R.drawable.	mobile05	); name.setText(getString(R.string.	mobile_5	)); intro.setText(getString(R.string.		mobile05_intro	));}
        if(troop_show_name[num] == 16 ){	img.setImageResource(R.drawable.	mobile06	); name.setText(getString(R.string.	mobile_6	)); intro.setText(getString(R.string.		mobile06_intro	));}
        if(troop_show_name[num] == 17 ){	img.setImageResource(R.drawable.	mobile07	); name.setText(getString(R.string.	mobile_7	)); intro.setText(getString(R.string.		mobile07_intro	));}
        if(troop_show_name[num] == 18 ){	img.setImageResource(R.drawable.	mobile08	); name.setText(getString(R.string.	mobile_8	)); intro.setText(getString(R.string.		mobile08_intro	));}
        if(troop_show_name[num] == 19 ){	img.setImageResource(R.drawable.	mobile09	); name.setText(getString(R.string.	mobile_9	)); intro.setText(getString(R.string.		mobile09_intro	));}
        if(troop_show_name[num] == 20 ){	img.setImageResource(R.drawable.	mobile10	); name.setText(getString(R.string.	mobile_10	)); intro.setText(getString(R.string.		mobile10_intro	));}
        if(troop_show_name[num] == 21 ){	img.setImageResource(R.drawable.	arm01	); name.setText(getString(R.string.	arm_1	)); intro.setText(getString(R.string.		arm01_intro	));}
        if(troop_show_name[num] == 22 ){	img.setImageResource(R.drawable.	arm02	); name.setText(getString(R.string.	arm_2	)); intro.setText(getString(R.string.		arm02_intro	));}
        if(troop_show_name[num] == 23 ){	img.setImageResource(R.drawable.	arm03	); name.setText(getString(R.string.	arm_3	)); intro.setText(getString(R.string.		arm03_intro	));}
        if(troop_show_name[num] == 24 ){	img.setImageResource(R.drawable.	arm04	); name.setText(getString(R.string.	arm_4	)); intro.setText(getString(R.string.		arm04_intro	));}
        if(troop_show_name[num] == 25 ){	img.setImageResource(R.drawable.	arm05	); name.setText(getString(R.string.	arm_5	)); intro.setText(getString(R.string.		arm05_intro	));}
        if(troop_show_name[num] == 26 ){	img.setImageResource(R.drawable.	arm06	); name.setText(getString(R.string.	arm_6	)); intro.setText(getString(R.string.		arm06_intro	));}
        if(troop_show_name[num] == 27 ){	img.setImageResource(R.drawable.	arm07	); name.setText(getString(R.string.	arm_7	)); intro.setText(getString(R.string.		arm07_intro	));}
        if(troop_show_name[num] == 28 ){	img.setImageResource(R.drawable.	arm08	); name.setText(getString(R.string.	arm_8	)); intro.setText(getString(R.string.		arm08_intro	));}
        if(troop_show_name[num] == 29 ){	img.setImageResource(R.drawable.	arm09	); name.setText(getString(R.string.	arm_9	)); intro.setText(getString(R.string.		arm09_intro	));}
        if(troop_show_name[num] == 30 ){	img.setImageResource(R.drawable.	arm10	); name.setText(getString(R.string.	arm_10	)); intro.setText(getString(R.string.		arm10_intro	));}
        if(troop_show_name[num] == 31 ){	img.setImageResource(R.drawable.	infect01	); name.setText(getString(R.string.	infect_1	)); intro.setText(getString(R.string.		infect01_intro	));}
        if(troop_show_name[num] == 32 ){	img.setImageResource(R.drawable.	infect02	); name.setText(getString(R.string.	infect_2	)); intro.setText(getString(R.string.		infect02_intro	));}
        if(troop_show_name[num] == 33 ){	img.setImageResource(R.drawable.	infect03	); name.setText(getString(R.string.	infect_3	)); intro.setText(getString(R.string.		infect03_intro	));}
        if(troop_show_name[num] == 34 ){	img.setImageResource(R.drawable.	infect04	); name.setText(getString(R.string.	infect_4	)); intro.setText(getString(R.string.		infect04_intro	));}
        if(troop_show_name[num] == 35 ){	img.setImageResource(R.drawable.	infect05	); name.setText(getString(R.string.	infect_5	)); intro.setText(getString(R.string.		infect05_intro	));}
        if(troop_show_name[num] == 36 ){	img.setImageResource(R.drawable.	infect06	); name.setText(getString(R.string.	infect_6	)); intro.setText(getString(R.string.		infect06_intro	));}
        if(troop_show_name[num] == 37 ){	img.setImageResource(R.drawable.	infect07	); name.setText(getString(R.string.	infect_7	)); intro.setText(getString(R.string.		infect07_intro	));}
        if(troop_show_name[num] == 38 ){	img.setImageResource(R.drawable.	infect08	); name.setText(getString(R.string.	infect_8	)); intro.setText(getString(R.string.		infect08_intro	));}
        if(troop_show_name[num] == 39 ){	img.setImageResource(R.drawable.	infect09	); name.setText(getString(R.string.	infect_9	)); intro.setText(getString(R.string.		infect09_intro	));}
        if(troop_show_name[num] == 40 ){	img.setImageResource(R.drawable.	infect10	); name.setText(getString(R.string.	infect_10	)); intro.setText(getString(R.string.		infect10_intro	));}
        if(troop_show_name[num] == 41 ){	img.setImageResource(R.drawable.	project01	); name.setText(getString(R.string.	proj_1	)); intro.setText(getString(R.string.		project01_intro	));}
        if(troop_show_name[num] == 42 ){	img.setImageResource(R.drawable.	project02	); name.setText(getString(R.string.	proj_2	)); intro.setText(getString(R.string.		project02_intro	));}
        if(troop_show_name[num] == 43 ){	img.setImageResource(R.drawable.	project03	); name.setText(getString(R.string.	proj_3	)); intro.setText(getString(R.string.		project03_intro	));}
        if(troop_show_name[num] == 44 ){	img.setImageResource(R.drawable.	project04	); name.setText(getString(R.string.	proj_4	)); intro.setText(getString(R.string.		project04_intro	));}
        if(troop_show_name[num] == 45 ){	img.setImageResource(R.drawable.	project05	); name.setText(getString(R.string.	proj_5	)); intro.setText(getString(R.string.		project05_intro	));}
        if(troop_show_name[num] == 46 ){	img.setImageResource(R.drawable.	project06	); name.setText(getString(R.string.	proj_6	)); intro.setText(getString(R.string.		project06_intro	));}
        if(troop_show_name[num] == 47 ){	img.setImageResource(R.drawable.	project07	); name.setText(getString(R.string.	proj_7	)); intro.setText(getString(R.string.		project07_intro	));}
        if(troop_show_name[num] == 48 ){	img.setImageResource(R.drawable.	project08	); name.setText(getString(R.string.	proj_8	)); intro.setText(getString(R.string.		project08_intro	));}
        if(troop_show_name[num] == 49 ){	img.setImageResource(R.drawable.	project09	); name.setText(getString(R.string.	proj_9	)); intro.setText(getString(R.string.		project09_intro	));}
        if(troop_show_name[num] == 50 ){	img.setImageResource(R.drawable.	project10	); name.setText(getString(R.string.	proj_10	)); intro.setText(getString(R.string.		project10_intro	));}

        dialog.show();



    }
    public void troopIntro2 (View view){
        final Dialog dialog = new Dialog(this, R.style.NormalDialogStyle_N);
        view = View.inflate(this, R.layout.troop_about, null);
        //TextView dc_server = view.findViewById(R.id.dc_server);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        //view.setMinimumHeight((int) (ScreenSizeUtils.getInstance(this).getScreenHeight()));
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int) (ScreenSizeUtils.getInstance(this).getScreenWidth());
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);
        ImageView img = view.findViewById(R.id.troop_img);
        TextView name = view.findViewById(R.id.troop_name);
        TextView intro = view.findViewById(R.id.troop_intro);

        Log.i("progressIdArray01", String.valueOf(progressIdArray[0]));
        Log.i("progressIdArray02", String.valueOf(progressIdArray[1]));
        Log.i("progressIdArray03", String.valueOf(progressIdArray[2]));
        Log.i("progressIdArray04", String.valueOf(progressIdArray[3]));
        Log.i("progressIdArray05", String.valueOf(progressIdArray[4]));

        if(process_show_name == -1){	img.setImageResource(R.drawable.	app_icon_round	); name.setText(getString(R.string.	mili	)); intro.setText("");}
        if(process_show_name == -2){	img.setImageResource(R.drawable.	app_icon_round	); name.setText(getString(R.string.	mobile	)); intro.setText("");}
        if(process_show_name == -3){	img.setImageResource(R.drawable.	app_icon_round	); name.setText(getString(R.string.	armed	)); intro.setText("");}
        if(process_show_name == -4){	img.setImageResource(R.drawable.	app_icon_round	); name.setText(getString(R.string.	infecion	)); intro.setText("");}
        if(process_show_name == -5){	img.setImageResource(R.drawable.	app_icon_round	); name.setText(getString(R.string.	project	)); intro.setText("");}
        if(process_show_name == 1){	img.setImageResource(R.drawable.	mili01	); name.setText(getString(R.string.	mili_1	)); intro.setText(getString(R.string.		mili01_intro	));}
        if(process_show_name == 2){	img.setImageResource(R.drawable.	mili02	); name.setText(getString(R.string.	mili_2	)); intro.setText(getString(R.string.		mili02_intro	));}
        if(process_show_name == 3){	img.setImageResource(R.drawable.	mili03	); name.setText(getString(R.string.	mili_3	)); intro.setText(getString(R.string.		mili03_intro	));}
        if(process_show_name == 4){	img.setImageResource(R.drawable.	mili04	); name.setText(getString(R.string.	mili_4	)); intro.setText(getString(R.string.		mili04_intro	));}
        if(process_show_name == 5){	img.setImageResource(R.drawable.	mili05	); name.setText(getString(R.string.	mili_5	)); intro.setText(getString(R.string.		mili05_intro	));}
        if(process_show_name == 6){	img.setImageResource(R.drawable.	mili06	); name.setText(getString(R.string.	mili_6	)); intro.setText(getString(R.string.		mili06_intro	));}
        if(process_show_name == 7){	img.setImageResource(R.drawable.	mili07	); name.setText(getString(R.string.	mili_7	)); intro.setText(getString(R.string.		mili07_intro	));}
        if(process_show_name == 8){	img.setImageResource(R.drawable.	mili08	); name.setText(getString(R.string.	mili_8	)); intro.setText(getString(R.string.		mili08_intro	));}
        if(process_show_name == 9){	img.setImageResource(R.drawable.	mili09	); name.setText(getString(R.string.	mili_9	)); intro.setText(getString(R.string.		mili09_intro	));}
        if(process_show_name == 10){	img.setImageResource(R.drawable.	mili10	); name.setText(getString(R.string.	mili_10	)); intro.setText(getString(R.string.		mili10_intro	));}
        if(process_show_name == 11){	img.setImageResource(R.drawable.	mobile01	); name.setText(getString(R.string.	mobile_1	)); intro.setText(getString(R.string.		mobile01_intro	));}
        if(process_show_name == 12){	img.setImageResource(R.drawable.	mobile02	); name.setText(getString(R.string.	mobile_2	)); intro.setText(getString(R.string.		mobile02_intro	));}
        if(process_show_name == 13){	img.setImageResource(R.drawable.	mobile03	); name.setText(getString(R.string.	mobile_3	)); intro.setText(getString(R.string.		mobile03_intro	));}
        if(process_show_name == 14){	img.setImageResource(R.drawable.	mobile04	); name.setText(getString(R.string.	mobile_4	)); intro.setText(getString(R.string.		mobile04_intro	));}
        if(process_show_name == 15){	img.setImageResource(R.drawable.	mobile05	); name.setText(getString(R.string.	mobile_5	)); intro.setText(getString(R.string.		mobile05_intro	));}
        if(process_show_name == 16){	img.setImageResource(R.drawable.	mobile06	); name.setText(getString(R.string.	mobile_6	)); intro.setText(getString(R.string.		mobile06_intro	));}
        if(process_show_name == 17){	img.setImageResource(R.drawable.	mobile07	); name.setText(getString(R.string.	mobile_7	)); intro.setText(getString(R.string.		mobile07_intro	));}
        if(process_show_name == 18){	img.setImageResource(R.drawable.	mobile08	); name.setText(getString(R.string.	mobile_8	)); intro.setText(getString(R.string.		mobile08_intro	));}
        if(process_show_name == 19){	img.setImageResource(R.drawable.	mobile09	); name.setText(getString(R.string.	mobile_9	)); intro.setText(getString(R.string.		mobile09_intro	));}
        if(process_show_name == 20){	img.setImageResource(R.drawable.	mobile10	); name.setText(getString(R.string.	mobile_10	)); intro.setText(getString(R.string.		mobile10_intro	));}
        if(process_show_name == 21){	img.setImageResource(R.drawable.	arm01	); name.setText(getString(R.string.	arm_1	)); intro.setText(getString(R.string.		arm01_intro	));}
        if(process_show_name == 22){	img.setImageResource(R.drawable.	arm02	); name.setText(getString(R.string.	arm_2	)); intro.setText(getString(R.string.		arm02_intro	));}
        if(process_show_name == 23){	img.setImageResource(R.drawable.	arm03	); name.setText(getString(R.string.	arm_3	)); intro.setText(getString(R.string.		arm03_intro	));}
        if(process_show_name == 24){	img.setImageResource(R.drawable.	arm04	); name.setText(getString(R.string.	arm_4	)); intro.setText(getString(R.string.		arm04_intro	));}
        if(process_show_name == 25){	img.setImageResource(R.drawable.	arm05	); name.setText(getString(R.string.	arm_5	)); intro.setText(getString(R.string.		arm05_intro	));}
        if(process_show_name == 26){	img.setImageResource(R.drawable.	arm06	); name.setText(getString(R.string.	arm_6	)); intro.setText(getString(R.string.		arm06_intro	));}
        if(process_show_name == 27){	img.setImageResource(R.drawable.	arm07	); name.setText(getString(R.string.	arm_7	)); intro.setText(getString(R.string.		arm07_intro	));}
        if(process_show_name == 28){	img.setImageResource(R.drawable.	arm08	); name.setText(getString(R.string.	arm_8	)); intro.setText(getString(R.string.		arm08_intro	));}
        if(process_show_name == 29){	img.setImageResource(R.drawable.	arm09	); name.setText(getString(R.string.	arm_9	)); intro.setText(getString(R.string.		arm09_intro	));}
        if(process_show_name == 30){	img.setImageResource(R.drawable.	arm10	); name.setText(getString(R.string.	arm_10	)); intro.setText(getString(R.string.		arm10_intro	));}
        if(process_show_name == 31){	img.setImageResource(R.drawable.	infect01	); name.setText(getString(R.string.	infect_1	)); intro.setText(getString(R.string.		infect01_intro	));}
        if(process_show_name == 32){	img.setImageResource(R.drawable.	infect02	); name.setText(getString(R.string.	infect_2	)); intro.setText(getString(R.string.		infect02_intro	));}
        if(process_show_name == 33){	img.setImageResource(R.drawable.	infect03	); name.setText(getString(R.string.	infect_3	)); intro.setText(getString(R.string.		infect03_intro	));}
        if(process_show_name == 34){	img.setImageResource(R.drawable.	infect04	); name.setText(getString(R.string.	infect_4	)); intro.setText(getString(R.string.		infect04_intro	));}
        if(process_show_name == 35){	img.setImageResource(R.drawable.	infect05	); name.setText(getString(R.string.	infect_5	)); intro.setText(getString(R.string.		infect05_intro	));}
        if(process_show_name == 36){	img.setImageResource(R.drawable.	infect06	); name.setText(getString(R.string.	infect_6	)); intro.setText(getString(R.string.		infect06_intro	));}
        if(process_show_name == 37){	img.setImageResource(R.drawable.	infect07	); name.setText(getString(R.string.	infect_7	)); intro.setText(getString(R.string.		infect07_intro	));}
        if(process_show_name == 38){	img.setImageResource(R.drawable.	infect08	); name.setText(getString(R.string.	infect_8	)); intro.setText(getString(R.string.		infect08_intro	));}
        if(process_show_name == 39){	img.setImageResource(R.drawable.	infect09	); name.setText(getString(R.string.	infect_9	)); intro.setText(getString(R.string.		infect09_intro	));}
        if(process_show_name == 40){	img.setImageResource(R.drawable.	infect10	); name.setText(getString(R.string.	infect_10	)); intro.setText(getString(R.string.		infect10_intro	));}
        if(process_show_name == 41){	img.setImageResource(R.drawable.	project01	); name.setText(getString(R.string.	proj_1	)); intro.setText(getString(R.string.		project01_intro	));}
        if(process_show_name == 42){	img.setImageResource(R.drawable.	project02	); name.setText(getString(R.string.	proj_2	)); intro.setText(getString(R.string.		project02_intro	));}
        if(process_show_name == 43){	img.setImageResource(R.drawable.	project03	); name.setText(getString(R.string.	proj_3	)); intro.setText(getString(R.string.		project03_intro	));}
        if(process_show_name == 44){	img.setImageResource(R.drawable.	project04	); name.setText(getString(R.string.	proj_4	)); intro.setText(getString(R.string.		project04_intro	));}
        if(process_show_name == 45){	img.setImageResource(R.drawable.	project05	); name.setText(getString(R.string.	proj_5	)); intro.setText(getString(R.string.		project05_intro	));}
        if(process_show_name == 46){	img.setImageResource(R.drawable.	project06	); name.setText(getString(R.string.	proj_6	)); intro.setText(getString(R.string.		project06_intro	));}
        if(process_show_name == 47){	img.setImageResource(R.drawable.	project07	); name.setText(getString(R.string.	proj_7	)); intro.setText(getString(R.string.		project07_intro	));}
        if(process_show_name == 48){	img.setImageResource(R.drawable.	project08	); name.setText(getString(R.string.	proj_8	)); intro.setText(getString(R.string.		project08_intro	));}
        if(process_show_name == 49){	img.setImageResource(R.drawable.	project09	); name.setText(getString(R.string.	proj_9	)); intro.setText(getString(R.string.		project09_intro	));}
        if(process_show_name == 50){	img.setImageResource(R.drawable.	project10	); name.setText(getString(R.string.	proj_10	)); intro.setText(getString(R.string.		project10_intro	));}

        dialog.show();
    }

    public void boomerIntro (View view){
        final Dialog dialog = new Dialog(this, R.style.NormalDialogStyle_N);
        view = View.inflate(this, R.layout.troop_about, null);
        //TextView dc_server = view.findViewById(R.id.dc_server);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        //view.setMinimumHeight((int) (ScreenSizeUtils.getInstance(this).getScreenHeight()));
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int) (ScreenSizeUtils.getInstance(this).getScreenWidth());
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);
        ImageView img = view.findViewById(R.id.troop_img);
        TextView name = view.findViewById(R.id.troop_name);
        TextView intro = view.findViewById(R.id.troop_intro);

        if (bah == 1)	{img.setBackgroundResource(R.drawable.romen_num01)	;img.setImageResource(R.drawable.boomer01)	;name.setText(getString(R.string.boomer01_name))	;intro.setText(getString(R.string.boomer01));}
        if (bah == 2)	{img.setBackgroundResource(R.drawable.romen_num02)	;img.setImageResource(R.drawable.boomer02)	;name.setText(getString(R.string.boomer02_name))	;intro.setText(getString(R.string.boomer02));}
        if (bah == 3)	{img.setBackgroundResource(R.drawable.romen_num03)	;img.setImageResource(R.drawable.boomer03)	;name.setText(getString(R.string.boomer03_name))	;intro.setText(getString(R.string.boomer03));}
        if (bah == 4)	{img.setBackgroundResource(R.drawable.romen_num04)	;img.setImageResource(R.drawable.boomer04)	;name.setText(getString(R.string.boomer04_name))	;intro.setText(getString(R.string.boomer04));}
        if (bah == 5)	{img.setBackgroundResource(R.drawable.romen_num05)	;img.setImageResource(R.drawable.boomer05)	;name.setText(getString(R.string.boomer05_name))	;intro.setText(getString(R.string.boomer05));}
        if (bah == 6)	{img.setBackgroundResource(R.drawable.romen_num01)	;img.setImageResource(R.drawable.boomer06)	;name.setText(getString(R.string.boomer06_name))	;intro.setText(getString(R.string.boomer06));}
        if (bah == 7)	{img.setBackgroundResource(R.drawable.romen_num02)	;img.setImageResource(R.drawable.boomer07)	;name.setText(getString(R.string.boomer07_name))	;intro.setText(getString(R.string.boomer07));}
        if (bah == 8)	{img.setBackgroundResource(R.drawable.romen_num03)	;img.setImageResource(R.drawable.boomer08)	;name.setText(getString(R.string.boomer08_name))	;intro.setText(getString(R.string.boomer08));}
        if (bah == 9)	{img.setBackgroundResource(R.drawable.romen_num04)	;img.setImageResource(R.drawable.boomer09)	;name.setText(getString(R.string.boomer09_name))	;intro.setText(getString(R.string.boomer09));}
        if (bah == 10)	{img.setBackgroundResource(R.drawable.romen_num05)	;img.setImageResource(R.drawable.boomer10)	;name.setText(getString(R.string.boomer10_name))	;intro.setText(getString(R.string.boomer10));}
        if (bah == 11)	{img.setBackgroundResource(R.drawable.romen_num01)	;img.setImageResource(R.drawable.boomer11)	;name.setText(getString(R.string.boomer11_name))	;intro.setText(getString(R.string.boomer11));}
        if (bah == 12)	{img.setBackgroundResource(R.drawable.romen_num02)	;img.setImageResource(R.drawable.boomer12)	;name.setText(getString(R.string.boomer12_name))	;intro.setText(getString(R.string.boomer12));}
        if (bah == 13)	{img.setBackgroundResource(R.drawable.romen_num03)	;img.setImageResource(R.drawable.boomer13)	;name.setText(getString(R.string.boomer13_name))	;intro.setText(getString(R.string.boomer13));}
        if (bah == 14)	{img.setBackgroundResource(R.drawable.romen_num04)	;img.setImageResource(R.drawable.boomer14)	;name.setText(getString(R.string.boomer14_name))	;intro.setText(getString(R.string.boomer14));}
        if (bah == 15)	{img.setBackgroundResource(R.drawable.romen_num05)	;img.setImageResource(R.drawable.boomer15)	;name.setText(getString(R.string.boomer15_name))	;intro.setText(getString(R.string.boomer15));}

        dialog.show();
    }

    public void preferencesRefresh() {
        SharedPreferences sharedPreferences = getSharedPreferences("json_data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        /** Storage data grab from Zgirls Server */

        //RSS (Total 11)
        editor.putLong("fuel", fuel_final);
        editor.putLong("food", food_final);
        editor.putLong("steel", steel_final);
        editor.putLong("alloy", alloy_final);
        editor.putLong("obsidian", obsidian_final);
        editor.putLong("kyanite", kyanite_final);
        editor.putLong("kyanite_basic", kyanite_basic_final);
        editor.putLong("kyanite_cluster", kyanite_cluster_final);
        editor.putLong("catalyst", catalyst_final);
        editor.putLong("glory_mark", glory_mark_final);
        editor.putLong("diamond", diamond_final);

        //MECHA (Total 4) (Mecha , Land , Air , Mana)
        editor.putLong("mecha01Lv", mechaLvArray[0]);
        editor.putLong("mecha02Lv", mechaLvArray[1]);
        editor.putLong("mecha03Lv", mechaLvArray[2]);
        editor.putLong("mecha04Lv", mechaLvArray[3]);

        //BOOM (Total 15) (Accoding to DataList's Sort)
        editor.putLong("boom01Num", boomerNum[0]);
        editor.putLong("boom02Num", boomerNum[1]);
        editor.putLong("boom03Num", boomerNum[2]);
        editor.putLong("boom04Num", boomerNum[3]);
        editor.putLong("boom05Num", boomerNum[4]);
        editor.putLong("boom06Num", boomerNum[5]);
        editor.putLong("boom07Num", boomerNum[6]);
        editor.putLong("boom08Num", boomerNum[7]);
        editor.putLong("boom09Num", boomerNum[8]);
        editor.putLong("boom10Num", boomerNum[9]);
        editor.putLong("boom11Num", boomerNum[10]);
        editor.putLong("boom12Num", boomerNum[11]);
        editor.putLong("boom13Num", boomerNum[12]);
        editor.putLong("boom14Num", boomerNum[13]);
        editor.putLong("boom15Num", boomerNum[14]);

        //TROOP (Total 50x3) (Sort : , military , mobile , armed ,  infect , project)
        editor.putLong("army01TotalNum",	armyMarchNumArray[0]	 + armyFreeNumArray[0]);	editor.putLong("army01MarchNum",	armyMarchNumArray[0]);	editor.putLong("army01FreeNum",	armyFreeNumArray[0]);
        editor.putLong("army02TotalNum",	armyMarchNumArray[1]	 + armyFreeNumArray[1]);	editor.putLong("army02MarchNum",	armyMarchNumArray[1]);	editor.putLong("army02FreeNum",	armyFreeNumArray[1]);
        editor.putLong("army03TotalNum",	armyMarchNumArray[2]	 + armyFreeNumArray[2]);	editor.putLong("army03MarchNum",	armyMarchNumArray[2]);	editor.putLong("army03FreeNum",	armyFreeNumArray[2]);
        editor.putLong("army04TotalNum",	armyMarchNumArray[3]	 + armyFreeNumArray[3]);	editor.putLong("army04MarchNum",	armyMarchNumArray[3]);	editor.putLong("army04FreeNum",	armyFreeNumArray[3]);
        editor.putLong("army05TotalNum",	armyMarchNumArray[4]	 + armyFreeNumArray[4]);	editor.putLong("army05MarchNum",	armyMarchNumArray[4]);	editor.putLong("army05FreeNum",	armyFreeNumArray[4]);
        editor.putLong("army06TotalNum",	armyMarchNumArray[5]	 + armyFreeNumArray[5]);	editor.putLong("army06MarchNum",	armyMarchNumArray[5]);	editor.putLong("army06FreeNum",	armyFreeNumArray[5]);
        editor.putLong("army07TotalNum",	armyMarchNumArray[6]	 + armyFreeNumArray[6]);	editor.putLong("army07MarchNum",	armyMarchNumArray[6]);	editor.putLong("army07FreeNum",	armyFreeNumArray[6]);
        editor.putLong("army08TotalNum",	armyMarchNumArray[7]	 + armyFreeNumArray[7]);	editor.putLong("army08MarchNum",	armyMarchNumArray[7]);	editor.putLong("army08FreeNum",	armyFreeNumArray[7]);
        editor.putLong("army09TotalNum",	armyMarchNumArray[8]	 + armyFreeNumArray[8]);	editor.putLong("army09MarchNum",	armyMarchNumArray[8]);	editor.putLong("army09FreeNum",	armyFreeNumArray[8]);
        editor.putLong("army10TotalNum",	armyMarchNumArray[9]	 + armyFreeNumArray[9]);	editor.putLong("army10MarchNum",	armyMarchNumArray[9]);	editor.putLong("army10FreeNum",	armyFreeNumArray[9]);
        editor.putLong("army11TotalNum",	armyMarchNumArray[10]	 + armyFreeNumArray[10]);	editor.putLong("army11MarchNum",	armyMarchNumArray[10]);	editor.putLong("army11FreeNum",	armyFreeNumArray[10]);
        editor.putLong("army12TotalNum",	armyMarchNumArray[11]	 + armyFreeNumArray[11]);	editor.putLong("army12MarchNum",	armyMarchNumArray[11]);	editor.putLong("army12FreeNum",	armyFreeNumArray[11]);
        editor.putLong("army13TotalNum",	armyMarchNumArray[12]	 + armyFreeNumArray[12]);	editor.putLong("army13MarchNum",	armyMarchNumArray[12]);	editor.putLong("army13FreeNum",	armyFreeNumArray[12]);
        editor.putLong("army14TotalNum",	armyMarchNumArray[13]	 + armyFreeNumArray[13]);	editor.putLong("army14MarchNum",	armyMarchNumArray[13]);	editor.putLong("army14FreeNum",	armyFreeNumArray[13]);
        editor.putLong("army15TotalNum",	armyMarchNumArray[14]	 + armyFreeNumArray[14]);	editor.putLong("army15MarchNum",	armyMarchNumArray[14]);	editor.putLong("army15FreeNum",	armyFreeNumArray[14]);
        editor.putLong("army16TotalNum",	armyMarchNumArray[15]	 + armyFreeNumArray[15]);	editor.putLong("army16MarchNum",	armyMarchNumArray[15]);	editor.putLong("army16FreeNum",	armyFreeNumArray[15]);
        editor.putLong("army17TotalNum",	armyMarchNumArray[16]	 + armyFreeNumArray[16]);	editor.putLong("army17MarchNum",	armyMarchNumArray[16]);	editor.putLong("army17FreeNum",	armyFreeNumArray[16]);
        editor.putLong("army18TotalNum",	armyMarchNumArray[17]	 + armyFreeNumArray[17]);	editor.putLong("army18MarchNum",	armyMarchNumArray[17]);	editor.putLong("army18FreeNum",	armyFreeNumArray[17]);
        editor.putLong("army19TotalNum",	armyMarchNumArray[18]	 + armyFreeNumArray[18]);	editor.putLong("army19MarchNum",	armyMarchNumArray[18]);	editor.putLong("army19FreeNum",	armyFreeNumArray[18]);
        editor.putLong("army20TotalNum",	armyMarchNumArray[19]	 + armyFreeNumArray[19]);	editor.putLong("army20MarchNum",	armyMarchNumArray[19]);	editor.putLong("army20FreeNum",	armyFreeNumArray[19]);
        editor.putLong("army21TotalNum",	armyMarchNumArray[20]	 + armyFreeNumArray[20]);	editor.putLong("army21MarchNum",	armyMarchNumArray[20]);	editor.putLong("army21FreeNum",	armyFreeNumArray[20]);
        editor.putLong("army22TotalNum",	armyMarchNumArray[21]	 + armyFreeNumArray[21]);	editor.putLong("army22MarchNum",	armyMarchNumArray[21]);	editor.putLong("army22FreeNum",	armyFreeNumArray[21]);
        editor.putLong("army23TotalNum",	armyMarchNumArray[22]	 + armyFreeNumArray[22]);	editor.putLong("army23MarchNum",	armyMarchNumArray[22]);	editor.putLong("army23FreeNum",	armyFreeNumArray[22]);
        editor.putLong("army24TotalNum",	armyMarchNumArray[23]	 + armyFreeNumArray[23]);	editor.putLong("army24MarchNum",	armyMarchNumArray[23]);	editor.putLong("army24FreeNum",	armyFreeNumArray[23]);
        editor.putLong("army25TotalNum",	armyMarchNumArray[24]	 + armyFreeNumArray[24]);	editor.putLong("army25MarchNum",	armyMarchNumArray[24]);	editor.putLong("army25FreeNum",	armyFreeNumArray[24]);
        editor.putLong("army26TotalNum",	armyMarchNumArray[25]	 + armyFreeNumArray[25]);	editor.putLong("army26MarchNum",	armyMarchNumArray[25]);	editor.putLong("army26FreeNum",	armyFreeNumArray[25]);
        editor.putLong("army27TotalNum",	armyMarchNumArray[26]	 + armyFreeNumArray[26]);	editor.putLong("army27MarchNum",	armyMarchNumArray[26]);	editor.putLong("army27FreeNum",	armyFreeNumArray[26]);
        editor.putLong("army28TotalNum",	armyMarchNumArray[27]	 + armyFreeNumArray[27]);	editor.putLong("army28MarchNum",	armyMarchNumArray[27]);	editor.putLong("army28FreeNum",	armyFreeNumArray[27]);
        editor.putLong("army29TotalNum",	armyMarchNumArray[28]	 + armyFreeNumArray[28]);	editor.putLong("army29MarchNum",	armyMarchNumArray[28]);	editor.putLong("army29FreeNum",	armyFreeNumArray[28]);
        editor.putLong("army30TotalNum",	armyMarchNumArray[29]	 + armyFreeNumArray[29]);	editor.putLong("army30MarchNum",	armyMarchNumArray[29]);	editor.putLong("army30FreeNum",	armyFreeNumArray[29]);
        editor.putLong("army31TotalNum",	armyMarchNumArray[30]	 + armyFreeNumArray[30]);	editor.putLong("army31MarchNum",	armyMarchNumArray[30]);	editor.putLong("army31FreeNum",	armyFreeNumArray[30]);
        editor.putLong("army32TotalNum",	armyMarchNumArray[31]	 + armyFreeNumArray[31]);	editor.putLong("army32MarchNum",	armyMarchNumArray[31]);	editor.putLong("army32FreeNum",	armyFreeNumArray[31]);
        editor.putLong("army33TotalNum",	armyMarchNumArray[32]	 + armyFreeNumArray[32]);	editor.putLong("army33MarchNum",	armyMarchNumArray[32]);	editor.putLong("army33FreeNum",	armyFreeNumArray[32]);
        editor.putLong("army34TotalNum",	armyMarchNumArray[33]	 + armyFreeNumArray[33]);	editor.putLong("army34MarchNum",	armyMarchNumArray[33]);	editor.putLong("army34FreeNum",	armyFreeNumArray[33]);
        editor.putLong("army35TotalNum",	armyMarchNumArray[34]	 + armyFreeNumArray[34]);	editor.putLong("army35MarchNum",	armyMarchNumArray[34]);	editor.putLong("army35FreeNum",	armyFreeNumArray[34]);
        editor.putLong("army36TotalNum",	armyMarchNumArray[35]	 + armyFreeNumArray[35]);	editor.putLong("army36MarchNum",	armyMarchNumArray[35]);	editor.putLong("army36FreeNum",	armyFreeNumArray[35]);
        editor.putLong("army37TotalNum",	armyMarchNumArray[36]	 + armyFreeNumArray[36]);	editor.putLong("army37MarchNum",	armyMarchNumArray[36]);	editor.putLong("army37FreeNum",	armyFreeNumArray[36]);
        editor.putLong("army38TotalNum",	armyMarchNumArray[37]	 + armyFreeNumArray[37]);	editor.putLong("army38MarchNum",	armyMarchNumArray[37]);	editor.putLong("army38FreeNum",	armyFreeNumArray[37]);
        editor.putLong("army39TotalNum",	armyMarchNumArray[38]	 + armyFreeNumArray[38]);	editor.putLong("army39MarchNum",	armyMarchNumArray[38]);	editor.putLong("army39FreeNum",	armyFreeNumArray[38]);
        editor.putLong("army40TotalNum",	armyMarchNumArray[39]	 + armyFreeNumArray[39]);	editor.putLong("army40MarchNum",	armyMarchNumArray[39]);	editor.putLong("army40FreeNum",	armyFreeNumArray[39]);
        editor.putLong("army41TotalNum",	armyMarchNumArray[40]	 + armyFreeNumArray[40]);	editor.putLong("army41MarchNum",	armyMarchNumArray[40]);	editor.putLong("army41FreeNum",	armyFreeNumArray[40]);
        editor.putLong("army42TotalNum",	armyMarchNumArray[41]	 + armyFreeNumArray[41]);	editor.putLong("army42MarchNum",	armyMarchNumArray[41]);	editor.putLong("army42FreeNum",	armyFreeNumArray[41]);
        editor.putLong("army43TotalNum",	armyMarchNumArray[42]	 + armyFreeNumArray[42]);	editor.putLong("army43MarchNum",	armyMarchNumArray[42]);	editor.putLong("army43FreeNum",	armyFreeNumArray[42]);
        editor.putLong("army44TotalNum",	armyMarchNumArray[43]	 + armyFreeNumArray[43]);	editor.putLong("army44MarchNum",	armyMarchNumArray[43]);	editor.putLong("army44FreeNum",	armyFreeNumArray[43]);
        editor.putLong("army45TotalNum",	armyMarchNumArray[44]	 + armyFreeNumArray[44]);	editor.putLong("army45MarchNum",	armyMarchNumArray[44]);	editor.putLong("army45FreeNum",	armyFreeNumArray[44]);
        editor.putLong("army46TotalNum",	armyMarchNumArray[45]	 + armyFreeNumArray[45]);	editor.putLong("army46MarchNum",	armyMarchNumArray[45]);	editor.putLong("army46FreeNum",	armyFreeNumArray[45]);
        editor.putLong("army47TotalNum",	armyMarchNumArray[46]	 + armyFreeNumArray[46]);	editor.putLong("army47MarchNum",	armyMarchNumArray[46]);	editor.putLong("army47FreeNum",	armyFreeNumArray[46]);
        editor.putLong("army48TotalNum",	armyMarchNumArray[47]	 + armyFreeNumArray[47]);	editor.putLong("army48MarchNum",	armyMarchNumArray[47]);	editor.putLong("army48FreeNum",	armyFreeNumArray[47]);
        editor.putLong("army49TotalNum",	armyMarchNumArray[48]	 + armyFreeNumArray[48]);	editor.putLong("army49MarchNum",	armyMarchNumArray[48]);	editor.putLong("army49FreeNum",	armyFreeNumArray[48]);
        editor.putLong("army50TotalNum",	armyMarchNumArray[49]	 + armyFreeNumArray[49]);	editor.putLong("army50MarchNum",	armyMarchNumArray[49]);	editor.putLong("army50FreeNum",	armyFreeNumArray[49]);

        //PROCESS (TOTAL 5x4)
        editor.putLong("armProgressId",progressIdArray[0]); editor.putLong("armProgressRemain",progressRemainArray[0]); editor.putLong("armProgressTotal",progressTotalArray[0]); editor.putLong("armProgressCount",progressCountArray[0]);
        editor.putLong("miliProgressId",progressIdArray[1]); editor.putLong("miliProgressRemain",progressRemainArray[1]); editor.putLong("miliProgressTotal",progressTotalArray[1]); editor.putLong("miliProgressCount",progressCountArray[1]);
        editor.putLong("mobileProgressId",progressIdArray[2]); editor.putLong("mobileProgressRemain",progressRemainArray[2]); editor.putLong("mobileProgressTotal",progressTotalArray[2]); editor.putLong("mobileProgressCount",progressCountArray[2]);
        editor.putLong("infectProgressId",progressIdArray[3]); editor.putLong("infectProgressRemain",progressRemainArray[3]); editor.putLong("infectProgressTotal",progressTotalArray[3]); editor.putLong("infectProgressCount",progressCountArray[3]);
        editor.putLong("projectProgressId",progressIdArray[4]); editor.putLong("projectProgressRemain",progressRemainArray[4]); editor.putLong("projectProgressTotal",progressTotalArray[4]); editor.putLong("projectProgressCount",progressCountArray[4]);

        //STAR (TOTAL 4)
        editor.putLong("star01", starArray[0]);
        editor.putLong("star02", starArray[1]);
        editor.putLong("star03", starArray[2]);
        editor.putLong("star04", starArray[3]);

        //ENABLER (TOTAL 48) (ACCODING TO JSON SORT)
        editor.putLong("enabler01Lv",	enablerLvArray[0]);
        editor.putLong("enabler02Lv",	enablerLvArray[1]);
        editor.putLong("enabler03Lv",	enablerLvArray[2]);
        editor.putLong("enabler04Lv",	enablerLvArray[3]);
        editor.putLong("enabler05Lv",	enablerLvArray[4]);
        editor.putLong("enabler06Lv",	enablerLvArray[5]);
        editor.putLong("enabler07Lv",	enablerLvArray[6]);
        editor.putLong("enabler08Lv",	enablerLvArray[7]);
        editor.putLong("enabler09Lv",	enablerLvArray[8]);
        editor.putLong("enabler10Lv",	enablerLvArray[9]);
        editor.putLong("enabler11Lv",	enablerLvArray[10]);
        editor.putLong("enabler12Lv",	enablerLvArray[11]);
        editor.putLong("enabler13Lv",	enablerLvArray[12]);
        editor.putLong("enabler14Lv",	enablerLvArray[13]);
        editor.putLong("enabler15Lv",	enablerLvArray[14]);
        editor.putLong("enabler16Lv",	enablerLvArray[15]);
        editor.putLong("enabler17Lv",	enablerLvArray[16]);
        editor.putLong("enabler18Lv",	enablerLvArray[17]);
        editor.putLong("enabler19Lv",	enablerLvArray[18]);
        editor.putLong("enabler20Lv",	enablerLvArray[19]);
        editor.putLong("enabler21Lv",	enablerLvArray[20]);
        editor.putLong("enabler22Lv",	enablerLvArray[21]);
        editor.putLong("enabler23Lv",	enablerLvArray[22]);
        editor.putLong("enabler24Lv",	enablerLvArray[23]);
        editor.putLong("enabler25Lv",	enablerLvArray[24]);
        editor.putLong("enabler26Lv",	enablerLvArray[25]);
        editor.putLong("enabler27Lv",	enablerLvArray[26]);
        editor.putLong("enabler28Lv",	enablerLvArray[27]);
        editor.putLong("enabler29Lv",	enablerLvArray[28]);
        editor.putLong("enabler30Lv",	enablerLvArray[29]);
        editor.putLong("enabler31Lv",	enablerLvArray[30]);
        editor.putLong("enabler32Lv",	enablerLvArray[31]);
        editor.putLong("enabler33Lv",	enablerLvArray[32]);
        editor.putLong("enabler34Lv",	enablerLvArray[33]);
        editor.putLong("enabler35Lv",	enablerLvArray[34]);
        editor.putLong("enabler36Lv",	enablerLvArray[35]);
        editor.putLong("enabler37Lv",	enablerLvArray[36]);
        editor.putLong("enabler38Lv",	enablerLvArray[37]);
        editor.putLong("enabler39Lv",	enablerLvArray[38]);
        editor.putLong("enabler40Lv",	enablerLvArray[39]);
        editor.putLong("enabler41Lv",	enablerLvArray[40]);
        editor.putLong("enabler42Lv",	enablerLvArray[41]);
        editor.putLong("enabler43Lv",	enablerLvArray[42]);
        editor.putLong("enabler44Lv",	enablerLvArray[43]);
        editor.putLong("enabler45Lv",	enablerLvArray[44]);
        editor.putLong("enabler46Lv",	enablerLvArray[45]);
        editor.putLong("enabler47Lv",	enablerLvArray[46]);
        editor.putLong("enabler48Lv",	enablerLvArray[47]);
        editor.putLong("enabler49Lv",	enablerLvArray[48]);
        editor.putLong("enabler50Lv",	enablerLvArray[49]);

        //EXP (TOTAL 7+1)
        editor.putLong("exp100",	expArray[0]);
        editor.putLong("exp5k",	    expArray[1]);
        editor.putLong("exp10k",	expArray[2]);
        editor.putLong("exp20k",	expArray[3]);
        editor.putLong("exp50k",	expArray[4]);
        editor.putLong("exp80k",	expArray[5]);
        editor.putLong("exp100k",	expArray[6]);

        Set<String> nameSet = new HashSet<>(Arrays.asList(buildingNameArray));
        editor.putStringSet("buildingName",nameSet);

        String strArray[] = new String[buildingLvlArray.length];

        for (int i = 0; i < buildingLvlArray.length; i++){
            strArray[i] = String.valueOf(buildingLvlArray[i]);}
        Set<String> lvlSet = new HashSet<>(Arrays.asList(strArray));
        editor.putStringSet("buildingLvl",lvlSet);

        editor.apply();

        Log.i("SharedPreferences","done");
    }
    public void question (View view){
        String language = Locale.getDefault().toString();
        String link = "guide_en.pdf";
        if (language.contains("zh")&&language.contains("#Hant")){
            link = "guide_hk.pdf";
        } else if (language.contains("zh")&&language.contains("#Hans")){
            link = "guide_cn.pdf";
        } else {
            link = "guide_en.pdf";
        }
    }

    public void troop_method () {
        mili_1_all =	armyFreeNumArray[0] +	armyMarchNumArray[0] ;			 mili_1_free =	armyFreeNumArray[0] ;			 mili_1_march =	armyMarchNumArray[0] ;
        mili_2_all =	armyFreeNumArray[1] +	armyMarchNumArray[1] ;			 mili_2_free =	armyFreeNumArray[1] ;			 mili_2_march =	armyMarchNumArray[1] ;
        mili_3_all =	armyFreeNumArray[2] +	armyMarchNumArray[2] ;			 mili_3_free =	armyFreeNumArray[2] ;			 mili_3_march =	armyMarchNumArray[2] ;
        mili_4_all =	armyFreeNumArray[3] +	armyMarchNumArray[3] ;			 mili_4_free =	armyFreeNumArray[3] ;			 mili_4_march =	armyMarchNumArray[3] ;
        mili_5_all =	armyFreeNumArray[4] +	armyMarchNumArray[4] ;			 mili_5_free =	armyFreeNumArray[4] ;			 mili_5_march =	armyMarchNumArray[4] ;
        mili_6_all =	armyFreeNumArray[5] +	armyMarchNumArray[5] ;			 mili_6_free =	armyFreeNumArray[5] ;			 mili_6_march =	armyMarchNumArray[5] ;
        mili_7_all =	armyFreeNumArray[6] +	armyMarchNumArray[6] ;			 mili_7_free =	armyFreeNumArray[6] ;			 mili_7_march =	armyMarchNumArray[6] ;
        mili_8_all =	armyFreeNumArray[7] +	armyMarchNumArray[7] ;			 mili_8_free =	armyFreeNumArray[7] ;			 mili_8_march =	armyMarchNumArray[7] ;
        mili_9_all =	armyFreeNumArray[8] +	armyMarchNumArray[8] ;			 mili_9_free =	armyFreeNumArray[8] ;			 mili_9_march =	armyMarchNumArray[8] ;
        mili_10_all =	armyFreeNumArray[9] +	armyMarchNumArray[9] ;			 mili_10_free =	armyFreeNumArray[9] ;			 mili_10_march =	armyMarchNumArray[9] ;
        mobile_1_all =	armyFreeNumArray[10] +	armyMarchNumArray[10] ;			 mobile_1_free =	armyFreeNumArray[10] ;			 mobile_1_march =	armyMarchNumArray[10] ;
        mobile_2_all =	armyFreeNumArray[11] +	armyMarchNumArray[11] ;			 mobile_2_free =	armyFreeNumArray[11] ;			 mobile_2_march =	armyMarchNumArray[11] ;
        mobile_3_all =	armyFreeNumArray[12] +	armyMarchNumArray[12] ;			 mobile_3_free =	armyFreeNumArray[12] ;			 mobile_3_march =	armyMarchNumArray[12] ;
        mobile_4_all =	armyFreeNumArray[13] +	armyMarchNumArray[13] ;			 mobile_4_free =	armyFreeNumArray[13] ;			 mobile_4_march =	armyMarchNumArray[13] ;
        mobile_5_all =	armyFreeNumArray[14] +	armyMarchNumArray[14] ;			 mobile_5_free =	armyFreeNumArray[14] ;			 mobile_5_march =	armyMarchNumArray[14] ;
        mobile_6_all =	armyFreeNumArray[15] +	armyMarchNumArray[15] ;			 mobile_6_free =	armyFreeNumArray[15] ;			 mobile_6_march =	armyMarchNumArray[15] ;
        mobile_7_all =	armyFreeNumArray[16] +	armyMarchNumArray[16] ;			 mobile_7_free =	armyFreeNumArray[16] ;			 mobile_7_march =	armyMarchNumArray[16] ;
        mobile_8_all =	armyFreeNumArray[17] +	armyMarchNumArray[17] ;			 mobile_8_free =	armyFreeNumArray[17] ;			 mobile_8_march =	armyMarchNumArray[17] ;
        mobile_9_all =	armyFreeNumArray[18] +	armyMarchNumArray[18] ;			 mobile_9_free =	armyFreeNumArray[18] ;			 mobile_9_march =	armyMarchNumArray[18] ;
        mobile_10_all =	armyFreeNumArray[19] +	armyMarchNumArray[19] ;			 mobile_10_free =	armyFreeNumArray[19] ;			 mobile_10_march =	armyMarchNumArray[19] ;
        armed_1_all = 	armyFreeNumArray[20] +	armyMarchNumArray[20] ;			 armed_1_free = 	armyFreeNumArray[20] ;			 armed_1_march = 	armyMarchNumArray[20] ;
        armed_2_all =	armyFreeNumArray[21] +	armyMarchNumArray[21] ;			 armed_2_free =	armyFreeNumArray[21] ;			 armed_2_march =	armyMarchNumArray[21] ;
        armed_3_all =	armyFreeNumArray[22] +	armyMarchNumArray[22] ;			 armed_3_free =	armyFreeNumArray[22] ;			 armed_3_march =	armyMarchNumArray[22] ;
        armed_4_all =	armyFreeNumArray[23] +	armyMarchNumArray[23] ;			 armed_4_free =	armyFreeNumArray[23] ;			 armed_4_march =	armyMarchNumArray[23] ;
        armed_5_all =	armyFreeNumArray[24] +	armyMarchNumArray[24] ;			 armed_5_free =	armyFreeNumArray[24] ;			 armed_5_march =	armyMarchNumArray[24] ;
        armed_6_all =	armyFreeNumArray[25] +	armyMarchNumArray[25] ;			 armed_6_free =	armyFreeNumArray[25] ;			 armed_6_march =	armyMarchNumArray[25] ;
        armed_7_all =	armyFreeNumArray[26] +	armyMarchNumArray[26] ;			 armed_7_free =	armyFreeNumArray[26] ;			 armed_7_march =	armyMarchNumArray[26] ;
        armed_8_all =	armyFreeNumArray[27] +	armyMarchNumArray[27] ;			 armed_8_free =	armyFreeNumArray[27] ;			 armed_8_march =	armyMarchNumArray[27] ;
        armed_9_all =	armyFreeNumArray[28] +	armyMarchNumArray[28] ;			 armed_9_free =	armyFreeNumArray[28] ;			 armed_9_march =	armyMarchNumArray[28] ;
        armed_10_all =	armyFreeNumArray[29] +	armyMarchNumArray[29] ;			 armed_10_free =	armyFreeNumArray[29] ;			 armed_10_march =	armyMarchNumArray[29] ;
        infect_1_all =	armyFreeNumArray[30] +	armyMarchNumArray[30] ;			 infect_1_free =	armyFreeNumArray[30] ;			 infect_1_march =	armyMarchNumArray[30] ;
        infect_2_all =	armyFreeNumArray[31] +	armyMarchNumArray[31] ;			 infect_2_free =	armyFreeNumArray[31] ;			 infect_2_march =	armyMarchNumArray[31] ;
        infect_3_all =	armyFreeNumArray[32] +	armyMarchNumArray[32] ;			 infect_3_free =	armyFreeNumArray[32] ;			 infect_3_march =	armyMarchNumArray[32] ;
        infect_4_all =	armyFreeNumArray[33] +	armyMarchNumArray[33] ;			 infect_4_free =	armyFreeNumArray[33] ;			 infect_4_march =	armyMarchNumArray[33] ;
        infect_5_all =	armyFreeNumArray[34] +	armyMarchNumArray[34] ;			 infect_5_free =	armyFreeNumArray[34] ;			 infect_5_march =	armyMarchNumArray[34] ;
        infect_6_all =	armyFreeNumArray[35] +	armyMarchNumArray[35] ;			 infect_6_free =	armyFreeNumArray[35] ;			 infect_6_march =	armyMarchNumArray[35] ;
        infect_7_all =	armyFreeNumArray[36] +	armyMarchNumArray[36] ;			 infect_7_free =	armyFreeNumArray[36] ;			 infect_7_march =	armyMarchNumArray[36] ;
        infect_8_all =	armyFreeNumArray[37] +	armyMarchNumArray[37] ;			 infect_8_free =	armyFreeNumArray[37] ;			 infect_8_march =	armyMarchNumArray[37] ;
        infect_9_all =	armyFreeNumArray[38] +	armyMarchNumArray[38] ;			 infect_9_free =	armyFreeNumArray[38] ;			 infect_9_march =	armyMarchNumArray[38] ;
        infect_10_all =	armyFreeNumArray[39] +	armyMarchNumArray[39] ;			 infect_10_free =	armyFreeNumArray[39] ;			 infect_10_march =	armyMarchNumArray[39] ;
        proj_1_all =	armyFreeNumArray[40] +	armyMarchNumArray[40] ;			 proj_1_free =	armyFreeNumArray[40] ;			 proj_1_march =	armyMarchNumArray[40] ;
        proj_2_all =	armyFreeNumArray[41] +	armyMarchNumArray[41] ;			 proj_2_free =	armyFreeNumArray[41] ;			 proj_2_march =	armyMarchNumArray[41] ;
        proj_3_all =	armyFreeNumArray[42] +	armyMarchNumArray[42] ;			 proj_3_free =	armyFreeNumArray[42] ;			 proj_3_march =	armyMarchNumArray[42] ;
        proj_4_all =	armyFreeNumArray[43] +	armyMarchNumArray[43] ;			 proj_4_free =	armyFreeNumArray[43] ;			 proj_4_march =	armyMarchNumArray[43] ;
        proj_5_all =	armyFreeNumArray[44] +	armyMarchNumArray[44] ;			 proj_5_free =	armyFreeNumArray[44] ;			 proj_5_march =	armyMarchNumArray[44] ;
        proj_6_all =	armyFreeNumArray[45] +	armyMarchNumArray[45] ;			 proj_6_free =	armyFreeNumArray[45] ;			 proj_6_march =	armyMarchNumArray[45] ;
        proj_7_all =	armyFreeNumArray[46] +	armyMarchNumArray[46] ;			 proj_7_free =	armyFreeNumArray[46] ;			 proj_7_march =	armyMarchNumArray[46] ;
        proj_8_all =	armyFreeNumArray[47] +	armyMarchNumArray[47] ;			 proj_8_free =	armyFreeNumArray[47] ;			 proj_8_march =	armyMarchNumArray[47] ;
        proj_9_all =	armyFreeNumArray[48] +	armyMarchNumArray[48] ;			 proj_9_free =	armyFreeNumArray[48] ;			 proj_9_march =	armyMarchNumArray[48] ;
        proj_10_all =	armyFreeNumArray[49] +	armyMarchNumArray[49] ;			 proj_10_free =	armyFreeNumArray[49] ;			 proj_10_march =	armyMarchNumArray[49] ;

    }

    /**
     * Mirage Function from ChartActivity
     * @param type :
     *             1. Troops Pie
     *             2. Troops bar
     */

    public void chart_bar(int type) {
        if (type == 1){
            // Method
            long arm = armed_1_all +	armed_2_all +	armed_3_all +	armed_4_all +	armed_5_all +	armed_6_all +	armed_7_all +	armed_8_all +	armed_9_all +	armed_10_all ;
            long mili = mili_1_all +	mili_2_all +	mili_3_all +	mili_4_all +	mili_5_all +	mili_6_all +	mili_7_all +	mili_8_all +	mili_9_all +	mili_10_all ;
            long mobile = mobile_1_all +	mobile_2_all +	mobile_3_all +	mobile_4_all +	mobile_5_all +	mobile_6_all +	mobile_7_all +	mobile_8_all +	mobile_9_all +	mobile_10_all ;
            long infect = infect_1_all +	infect_2_all +	infect_3_all +	infect_4_all +	infect_5_all +	infect_6_all +	infect_7_all +	infect_8_all +	infect_9_all +	infect_10_all ;
            long proj = proj_1_all +	proj_2_all +	proj_3_all +	proj_4_all +	proj_5_all +	proj_6_all +	proj_7_all +	proj_8_all +	proj_9_all +	proj_10_all ;

            final Dialog dialog = new Dialog(this, R.style.NormalDialogStyle_N);
            View view = View.inflate(this, R.layout.pie_chart, null);
            PieChart TroopPie = view.findViewById(R.id.troop_sum_pie);
            dialog.setContentView(view);
            dialog.setCanceledOnTouchOutside(true);
            //view.setMinimumHeight((int) (ScreenSizeUtils.getInstance(this).getScreenHeight()));
            Window dialogWindow = dialog.getWindow();
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width = (int) (ScreenSizeUtils.getInstance(this).getScreenWidth()*0.95);
            lp.height = (int) WindowManager.LayoutParams.WRAP_CONTENT;
            lp.gravity = Gravity.CENTER;
            dialogWindow.setAttributes(lp);

            //TroopPie.setCenterTextTypeface(Typeface.createFromAsset(getAssets(), "OpenSans-Light.ttf"));
            TroopPie.setCenterText(getString(R.string.troop_sum_chart_title));
            TroopPie.setCenterTextColor(Color.WHITE);

            TroopPie.setExtraOffsets(20.f, 0.f, 20.f, 0.f);

            TroopPie.setDrawHoleEnabled(true);
            TroopPie.setHoleColor(0x33000000);

            TroopPie.setTransparentCircleColor(Color.WHITE);
            TroopPie.setTransparentCircleAlpha(120);

            TroopPie.setHoleRadius(58f);
            TroopPie.setTransparentCircleRadius(61f);

            TroopPie.setDrawCenterText(true);

            TroopPie.setRotationAngle(0);
            // enable rotation of the TroopPie by touch
            TroopPie.setRotationEnabled(true);
            TroopPie.setHighlightPerTapEnabled(true);
            TroopPie.setDescription(" ");

            // NOTE: The order of the entries when being added to the entries array determines their position around the center of
            // the chart.
            ArrayList<PieEntry> pieEntries = new ArrayList<PieEntry>();
            pieEntries.add(new PieEntry(arm, getString(R.string.armed)));
            pieEntries.add(new PieEntry(mili, getString(R.string.mili)));
            pieEntries.add(new PieEntry(mobile, getString(R.string.mobile)));
            pieEntries.add(new PieEntry(infect, getString(R.string.infecion)));
            pieEntries.add(new PieEntry(proj, getString(R.string.project)));

            //String centerText = "时间分配";
            //pieChart1.setCenterText(centerText);//设置圆环中间的文字
            PieDataSet pieDataSet = new PieDataSet(pieEntries, "");
            ArrayList<Integer> colors = new ArrayList<>();

// 饼图颜色\

            colors.add(Color.rgb(186, 95, 95));
            colors.add(Color.rgb(78, 97, 187));
            colors.add(Color.rgb(97, 171, 138));
            colors.add(Color.rgb(123, 90, 173));
            colors.add(Color.rgb(174, 91, 135));

            pieDataSet.setColors(colors);
            //dataSet.setSelectionShift(0f);


            pieDataSet.setValueLinePart1OffsetPercentage(80.f);
            pieDataSet.setValueLinePart1Length(0.2f);
            pieDataSet.setValueLinePart2Length(0.4f);

            pieDataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
            pieDataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

            PieData data = new PieData(pieDataSet);
            data.setValueTextSize(12f);
            data.setValueTextColor(Color.WHITE);
            data.setDataSet(pieDataSet);

//各个饼状图所占比例数字的设置
            TroopPie.setData(data);
            TroopPie.highlightValues(null);
            TroopPie.invalidate();

            // TroopPie.setUnit(" €");
            // TroopPie.setDrawUnitsInChart(true);

            // add a selection listener
            TroopPie.setOnChartValueSelectedListener(this);
            dialog.show();
        }
    }
}

