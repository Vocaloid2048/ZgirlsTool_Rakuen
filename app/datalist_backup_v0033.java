package voc.net.tools.zgirls_tool;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
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
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
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

public class DataListActivity extends AppCompatActivity{

    CardView rss_card , mecha_card , enabler_card , exp_card , star_card , troop_card , progress_card;
    TextView rss_tv , mecha_tv , enabler_tv , exp_tv , star_tv , troop_tv , progress_tv;
    TextView troop_total;

    TextView	arm01	,	arm02	,	arm03	,	arm04	,	arm05	,	arm06	,	arm07	,	arm08	,	arm09	,	arm10	;
    TextView	mili01	,	mili02	,	mili03	,	mili04	,	mili05	,	mili06	,	mili07	,	mili08	,	mili09	,	mili10	;
    TextView	mobile01	,	mobile02	,	mobile03	,	mobile04	,	mobile05	,	mobile06	,	mobile07	,	mobile08	,	mobile09	,	mobile10	;
    TextView	infect01	,	infect02	,	infect03	,	infect04	,	infect05	,	infect06	,	infect07	,	infect08	,	infect09	,	infect10	;
    TextView	project01	,	project02	,	project03	,	project04	,	project05	,	project06	,	project07	,	project08	,	project09	,	project10	;

    ImageView	arm01_img	,	arm02_img	,	arm03_img	,	arm04_img	,	arm05_img	,	arm06_img	,	arm07_img	,	arm08_img	,	arm09_img	,	arm10_img	;
    ImageView	mili01_img	,	mili02_img	,	mili03_img	,	mili04_img	,	mili05_img	,	mili06_img	,	mili07_img	,	mili08_img	,	mili09_img	,	mili10_img	;
    ImageView	mobile01_img	,	mobile02_img	,	mobile03_img	,	mobile04_img	,	mobile05_img	,	mobile06_img	,	mobile07_img	,	mobile08_img	,	mobile09_img	,	mobile10_img	;
    ImageView	infect01_img	,	infect02_img	,	infect03_img	,	infect04_img	,	infect05_img	,	infect06_img	,	infect07_img	,	infect08_img	,	infect09_img	,	infect10_img	;
    ImageView	project01_img	,	project02_img	,	project03_img	,	project04_img	,	project05_img	,	project06_img	,	project07_img	,	project08_img	,	project09_img	,	project10_img	;

    ImageView	enabler_img_01,	enabler_img_02,	enabler_img_03,	enabler_img_04,	enabler_img_05,	enabler_img_06,	enabler_img_07,	enabler_img_08,	enabler_img_09,	enabler_img_10,	enabler_img_11,	enabler_img_12,	enabler_img_13,	enabler_img_14,	enabler_img_15,	enabler_img_16,	enabler_img_17,	enabler_img_18,	enabler_img_19,	enabler_img_20,	enabler_img_21,	enabler_img_22,	enabler_img_23,	enabler_img_24,	enabler_img_25,	enabler_img_26,	enabler_img_27,	enabler_img_28,	enabler_img_29,	enabler_img_30,	enabler_img_31,	enabler_img_32,	enabler_img_33,	enabler_img_34,	enabler_img_35,	enabler_img_36,	enabler_img_37,	enabler_img_38,	enabler_img_39,	enabler_img_40,	enabler_img_41,	enabler_img_42,	enabler_img_43,	enabler_img_44,	enabler_img_45,	enabler_img_46,	enabler_img_47,	enabler_img_48,	enabler_img_49,	enabler_img_50;


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

    private ProgressDialog pd;
    // private SwipeRefreshLayout swipeRefreshLayout ;

    private View decorView;
    String DataBasePath = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/database/database.db";
    String DataBaseFile = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/database";
    int code_num = 0;
    // myDbAdapter helper;
    String DataBasePath2 = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/database";
    String path_test , path_final ;
    String uid ;
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

    long UID;

    private static final String fileName = "user_session";
    private static final String fileDir = Environment.getExternalStorageDirectory().getPath() +"/data/data/com.xingjoys.zgirls.app/config/";

    long fuel_final , food_final , steel_final , alloy_final , obsidian_final , kyanite_final , kyanite_basic_final , kyanite_cluster_final , glory_mark_final , catalyst_final , diamond_final ;
    String star_final ;
    String mechaName , mechaLv , armyName , enablerName ;
    long armyFreeNum , armyMarchNum , enablerLv , progressId , progressTotal , progressRemain , progressCount;

    long fuel_re , food_re , steel_re ,  alloy_re ,obsidian_re ,kyanite_re ,kyanite_basic_re ,kyanite_cluster_re ,glory_mark_re ,catalyst_re ,diamond_re ;

    String[] mechaNameArray = new String[4];
    String[] mechaLvArray = new String[4];

    String[] armyNameArray = new String[50];
    long[] armyFreeNumArray = new long[50];
    long[] armyMarchNumArray = new long[50];

    String[] enablerNameArray = new String[48];
    long[] enablerLvArray = new long[48];

    long[] starArray = new long[4];

    long[] progressIdArray = new long[5];
    long[] progressTotalArray = new long[5];
    long[] progressRemainArray = new long[5];
    long[] progressCountArray = new long[5];

    long arm_progress , arm_total ;
    long mili_progress , mili_total ;
    long mobile_progress , mobile_total ;
    long infect_progress , infect_total ;
    long project_progress , project_total ;

    ImageView star01 ;
    ImageView star02 ;
    ImageView star03 ;
    ImageView star04 ;
    TextView starName ;

    ProgressBar armed_pd , mili_pd , mobile_pd , infect_pd , project_pd ;
    ImageView armed_img , mili_img , mobile_img , infect_img , project_img ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);
        getSavedLoginDataJson();
        new TakeData().execute();


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
        star01 = findViewById(R.id.star_a);
        star02 = findViewById(R.id.star_b);
        star03 = findViewById(R.id.star_c);
        star04 = findViewById(R.id.star_d);
        starName = findViewById(R.id.star_name);
        init();
        // 建立SQLiteOpenHelper物件
        //METHOD END
        String fileName = "background.png";
        Resources res = getResources();
        String pathName = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/background/" + fileName;
        Bitmap bitmap = BitmapFactory.decodeFile(pathName);
        BitmapDrawable bd = new BitmapDrawable(res, bitmap);
        ImageView view = findViewById(R.id.data_bg);
        view.setImageDrawable(bd);
        dataRefresh();


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
        enabler_card = findViewById(R.id.enabler_card);
        exp_card = findViewById(R.id.exp_card);
        star_card = findViewById(R.id.star_card);
        troop_card = findViewById(R.id.troop_card);
        progress_card = findViewById(R.id.project_process_card);
        rss_tv = findViewById(R.id.rss);
        mecha_tv = findViewById(R.id.mecha);
        enabler_tv = findViewById(R.id.enabler);
        exp_tv = findViewById(R.id.exp);
        star_tv = findViewById(R.id.star_stone);
        troop_tv = findViewById(R.id.troop);
        progress_tv = findViewById(R.id.process);

        troop_total = findViewById(R.id.troop_total);

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

        enabler_img_01	 = findViewById (R.id.	enabler_img_01);
        enabler_img_02	 = findViewById (R.id.	enabler_img_02);
        enabler_img_03	 = findViewById (R.id.	enabler_img_03);
        enabler_img_04	 = findViewById (R.id.	enabler_img_04);
        enabler_img_05	 = findViewById (R.id.	enabler_img_05);
        enabler_img_06	 = findViewById (R.id.	enabler_img_06);
        enabler_img_07	 = findViewById (R.id.	enabler_img_07);
        enabler_img_08	 = findViewById (R.id.	enabler_img_08);
        enabler_img_09	 = findViewById (R.id.	enabler_img_09);
        enabler_img_10	 = findViewById (R.id.	enabler_img_10);
        enabler_img_11	 = findViewById (R.id.	enabler_img_11);
        enabler_img_12	 = findViewById (R.id.	enabler_img_12);
        enabler_img_13	 = findViewById (R.id.	enabler_img_13);
        enabler_img_14	 = findViewById (R.id.	enabler_img_14);
        enabler_img_15	 = findViewById (R.id.	enabler_img_15);
        enabler_img_16	 = findViewById (R.id.	enabler_img_16);
        enabler_img_17	 = findViewById (R.id.	enabler_img_17);
        enabler_img_18	 = findViewById (R.id.	enabler_img_18);
        enabler_img_19	 = findViewById (R.id.	enabler_img_19);
        enabler_img_20	 = findViewById (R.id.	enabler_img_20);
        enabler_img_21	 = findViewById (R.id.	enabler_img_21);
        enabler_img_22	 = findViewById (R.id.	enabler_img_22);
        enabler_img_23	 = findViewById (R.id.	enabler_img_23);
        enabler_img_24	 = findViewById (R.id.	enabler_img_24);
        enabler_img_25	 = findViewById (R.id.	enabler_img_25);
        enabler_img_26	 = findViewById (R.id.	enabler_img_26);
        enabler_img_27	 = findViewById (R.id.	enabler_img_27);
        enabler_img_28	 = findViewById (R.id.	enabler_img_28);
        enabler_img_29	 = findViewById (R.id.	enabler_img_29);
        enabler_img_30	 = findViewById (R.id.	enabler_img_30);
        enabler_img_31	 = findViewById (R.id.	enabler_img_31);
        enabler_img_32	 = findViewById (R.id.	enabler_img_32);
        enabler_img_33	 = findViewById (R.id.	enabler_img_33);
        enabler_img_34	 = findViewById (R.id.	enabler_img_34);
        enabler_img_35	 = findViewById (R.id.	enabler_img_35);
        enabler_img_36	 = findViewById (R.id.	enabler_img_36);
        enabler_img_37	 = findViewById (R.id.	enabler_img_37);
        enabler_img_38	 = findViewById (R.id.	enabler_img_38);
        enabler_img_39	 = findViewById (R.id.	enabler_img_39);
        enabler_img_40	 = findViewById (R.id.	enabler_img_40);
        enabler_img_41	 = findViewById (R.id.	enabler_img_41);
        enabler_img_42	 = findViewById (R.id.	enabler_img_42);
        enabler_img_43	 = findViewById (R.id.	enabler_img_43);
        enabler_img_44	 = findViewById (R.id.	enabler_img_44);
        enabler_img_45	 = findViewById (R.id.	enabler_img_45);
        enabler_img_46	 = findViewById (R.id.	enabler_img_46);
        enabler_img_47	 = findViewById (R.id.	enabler_img_47);
        enabler_img_48	 = findViewById (R.id.	enabler_img_48);

        armed_id_tv	 = findViewById (R.id.	armed_process_tv);
        armed_process_tv	 = findViewById (R.id.	armed_process_time);
        armed_per	 = findViewById (R.id.	armed_process_percent);
        armed_total_tv	 = findViewById (R.id.	armed_process_total);
        armed_pd	 = findViewById (R.id.	armed_process_bar);
        armed_img	 = findViewById (R.id.	armed_process_img);
        armed_count_tv	 = findViewById (R.id.	armed_process_count);

        mili_id_tv	 = findViewById (R.id.	military_process_tv);
        mili_process_tv	 = findViewById (R.id.	military_process_time);
        mili_per	 = findViewById (R.id.	military_process_percent);
        mili_total_tv	 = findViewById (R.id.	military_process_total);
        mili_pd	 = findViewById (R.id.	military_process_bar);
        mili_img	 = findViewById (R.id.	military_process_img);
        mili_count_tv	 = findViewById (R.id.	military_process_count);

        mobile_id_tv	 = findViewById (R.id.	mobile_process_tv);
        mobile_process_tv	 = findViewById (R.id.	mobile_process_time);
        mobile_per	 = findViewById (R.id.	mobile_process_percent);
        mobile_total_tv	 = findViewById (R.id.	mobile_process_total);
        mobile_pd	 = findViewById (R.id.	mobile_process_bar);
        mobile_img	 = findViewById (R.id.	mobile_process_img);
        mobile_count_tv	 = findViewById (R.id.	mobile_process_count);

        infect_id_tv	 = findViewById (R.id.	infect_process_tv);
        infect_process_tv	 = findViewById (R.id.	infect_process_time);
        infect_per	 = findViewById (R.id.	infect_process_percent);
        infect_total_tv	 = findViewById (R.id.	infect_process_total);
        infect_pd	 = findViewById (R.id.	infect_process_bar);
        infect_img	 = findViewById (R.id.	infect_process_img);
        infect_count_tv	 = findViewById (R.id.	infect_process_count);

        project_id_tv	 = findViewById (R.id.	project_process_tv);
        project_process_tv	 = findViewById (R.id.	project_process_time);
        project_per	 = findViewById (R.id.	project_process_percent);
        project_total_tv	 = findViewById (R.id.	project_process_total);
        project_pd	 = findViewById (R.id.	project_process_bar);
        project_img	 = findViewById (R.id.	project_process_img);
        project_count_tv	 = findViewById (R.id.	project_process_count);

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
            enabler_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_base_alpha	));
            enabler_tv	.setBackgroundColor(getResources().getColor(R.color.	background_base_press	));
            exp_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_base_alpha	));
            exp_tv	.setBackgroundColor(getResources().getColor(R.color.	background_base_press	));
            star_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_base_alpha	));
            star_tv	.setBackgroundColor(getResources().getColor(R.color.	background_base_press	));
            troop_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_base_alpha	));
            troop_tv	.setBackgroundColor(getResources().getColor(R.color.	background_base_press	));
            troop_total	.setBackgroundColor(getResources().getColor(R.color.	background_base_press	));
        }

        if (theme.equals("dark")) {
            rss_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_dark_alpha	));
            rss_tv	.setBackgroundColor(getResources().getColor(R.color.	background_dark_press	));
            mecha_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_dark_alpha	));
            mecha_tv	.setBackgroundColor(getResources().getColor(R.color.	background_dark_press	));
            enabler_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_dark_alpha	));
            enabler_tv	.setBackgroundColor(getResources().getColor(R.color.	background_dark_press	));
            exp_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_dark_alpha	));
            exp_tv	.setBackgroundColor(getResources().getColor(R.color.	background_dark_press	));
            star_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_dark_alpha	));
            star_tv	.setBackgroundColor(getResources().getColor(R.color.	background_dark_press	));
            troop_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_dark_alpha	));
            troop_tv	.setBackgroundColor(getResources().getColor(R.color.	background_dark_press	));
            troop_total	.setBackgroundColor(getResources().getColor(R.color.	background_dark_press	));

        }

        if (theme.equals("pink")) {
            rss_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_pink_alpha	));
            rss_tv	.setBackgroundColor(getResources().getColor(R.color.	background_pink_press	));
            mecha_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_pink_alpha	));
            mecha_tv	.setBackgroundColor(getResources().getColor(R.color.	background_pink_press	));
            enabler_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_pink_alpha	));
            enabler_tv	.setBackgroundColor(getResources().getColor(R.color.	background_pink_press	));
            exp_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_pink_alpha	));
            exp_tv	.setBackgroundColor(getResources().getColor(R.color.	background_pink_press	));
            star_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_pink_alpha	));
            star_tv	.setBackgroundColor(getResources().getColor(R.color.	background_pink_press	));
            troop_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_pink_alpha	));
            troop_tv	.setBackgroundColor(getResources().getColor(R.color.	background_pink_press	));
            troop_total	.setBackgroundColor(getResources().getColor(R.color.	background_pink_press	));

        }

        if (theme.equals("leek")) {
            rss_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_leek_alpha	));
            rss_tv	.setBackgroundColor(getResources().getColor(R.color.	background_leek_press	));
            mecha_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_leek_alpha	));
            mecha_tv	.setBackgroundColor(getResources().getColor(R.color.	background_leek_press	));
            enabler_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_leek_alpha	));
            enabler_tv	.setBackgroundColor(getResources().getColor(R.color.	background_leek_press	));
            exp_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_leek_alpha	));
            exp_tv	.setBackgroundColor(getResources().getColor(R.color.	background_leek_press	));
            star_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_leek_alpha	));
            star_tv	.setBackgroundColor(getResources().getColor(R.color.	background_leek_press	));
            troop_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_leek_alpha	));
            troop_tv	.setBackgroundColor(getResources().getColor(R.color.	background_leek_press	));
            troop_total	.setBackgroundColor(getResources().getColor(R.color.	background_leek_press	));

        }

        if (theme.equals("summer")) {
            rss_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_summer_alpha	));
            rss_tv	.setBackgroundColor(getResources().getColor(R.color.	background_summer_press	));
            mecha_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_summer_alpha	));
            mecha_tv	.setBackgroundColor(getResources().getColor(R.color.	background_summer_press	));
            enabler_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_summer_alpha	));
            enabler_tv	.setBackgroundColor(getResources().getColor(R.color.	background_summer_press	));
            exp_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_summer_alpha	));
            exp_tv	.setBackgroundColor(getResources().getColor(R.color.	background_summer_press	));
            star_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_summer_alpha	));
            star_tv	.setBackgroundColor(getResources().getColor(R.color.	background_summer_press	));
            troop_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_summer_alpha	));
            troop_tv	.setBackgroundColor(getResources().getColor(R.color.	background_summer_press	));
            troop_total	.setBackgroundColor(getResources().getColor(R.color.	background_summer_press	));

        }
        if (theme.equals("custom")) {
            rss_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            rss_tv	.setBackgroundColor(Color.parseColor("#"+color2));
            mecha_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            mecha_tv	.setBackgroundColor(Color.parseColor("#"+color2));
            enabler_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            enabler_tv	.setBackgroundColor(Color.parseColor("#"+color2));
            exp_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            exp_tv	.setBackgroundColor(Color.parseColor("#"+color2));
            star_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            star_tv	.setBackgroundColor(Color.parseColor("#"+color2));
            troop_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            troop_tv	.setBackgroundColor(Color.parseColor("#"+color2));
            troop_total	.setBackgroundColor(Color.parseColor("#"+color2));
        }
    }
    public void dataRefresh (){
        getSavedLoginDataJson();
        new TakeData().execute();
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

        String FOOD_S , FUEL_S , STEEL_S , ALLOY_S , OBSIDIAN_S , KYANITE_S , KYANITE_BASIC_S, KYANITE_CLUSTER_S , GLORY_MARK_S , CATALYST_S , DIAMOND_S ;
        String exp_total_String = null , exp_1_String = null ,	exp_2_String = null ,	exp_3_String = null ,	exp_4_String = null ,	exp_5_String = null ,	exp_6_String = null ,	exp_7_String = null ;

        //FOOD
        FOOD_S = prettyCount(food_final);
        //FUEL

        FUEL_S = prettyCount(fuel_final);
        //STEEL
        STEEL_S = prettyCount(steel_final);
        //ALLOY
        ALLOY_S = prettyCount(alloy_final);
        //OBSIDIAN
        OBSIDIAN_S = prettyCount(obsidian_final);
        //KYANITE
        KYANITE_S = prettyCount(kyanite_final);
        //KYANITE_BASIC
        KYANITE_BASIC_S = prettyCount(kyanite_basic_final);
        //KYANITE_CLUSTER
        KYANITE_CLUSTER_S = prettyCount(kyanite_cluster_final);
        //GLORY_MARK
        GLORY_MARK_S = prettyCount(glory_mark_final);
        //CATALYST
        CATALYST_S = prettyCount(catalyst_final);
        //DIAMOND
        DIAMOND_S = prettyCount(diamond_final);

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

        //   EXPALL.setText(exp_total_String);
        //  EXP100.setText	(exp_1_String);
        //  EXP5K.setText	(exp_2_String);
        //   EXP10K.setText	(exp_3_String);
        //  EXP20K.setText	(exp_4_String);
        //   EXP50K.setText	(exp_5_String);
        //   EXP80K.setText	(exp_6_String);
        //  EXP100K.setText	(exp_7_String);

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
        //Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
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

        String lv = getResources().getString((R.string.lv));
        String atk = getResources().getString((R.string.atk));
        String energy = getResources().getString((R.string.atk));

        name1.setText(mechaNameArray [0]);
        name2.setText(mechaNameArray [1]);
        name3.setText(mechaNameArray [2]);
        name4.setText(mechaNameArray [3]);

        level1.setText(lv+mechaLvArray[0]);
        level2.setText(lv+mechaLvArray[1]);
        level3.setText(lv+mechaLvArray[2]);
        level4.setText(lv+mechaLvArray[3]);

        //power1.setText(atk+prettyCount(Integer.parseInt(helper.DataMPOWER().split(" \n")[0])));
        // power2.setText(atk+prettyCount(Integer.parseInt(helper.DataMPOWER().split(" \n")[1])));
        //  power3.setText(atk+prettyCount(Integer.parseInt(helper.DataMPOWER().split(" \n")[2])));
        //  power4.setText(atk+prettyCount(Integer.parseInt(helper.DataMPOWER().split(" \n")[3])));

        // energy1.setText(energy+prettyCount(Integer.parseInt(helper.DataMENERGY().split(" \n")[0])));
        //  energy2.setText(energy+prettyCount(Integer.parseInt(helper.DataMENERGY().split(" \n")[1])));
        //  energy3.setText(energy+prettyCount(Integer.parseInt(helper.DataMENERGY().split(" \n")[2])));
        //  energy4.setText(energy+prettyCount(Integer.parseInt(helper.DataMENERGY().split(" \n")[3])));

        ename38	.setText(enablerNameArray[0]);	elevel38	.setText(lv+enablerLvArray[0]);	epower38	.setText("");
        ename37	.setText(enablerNameArray[1]);	elevel37	.setText(lv+enablerLvArray[1]);	epower37	.setText("");
        ename36	.setText(enablerNameArray[2]);	elevel36	.setText(lv+enablerLvArray[2]);	epower36	.setText("");
        ename35	.setText(enablerNameArray[3]);	elevel35	.setText(lv+enablerLvArray[3]);	epower35	.setText("");
        ename42	.setText(enablerNameArray[4]);	elevel42	.setText(lv+enablerLvArray[4]);	epower42	.setText("");
        ename41	.setText(enablerNameArray[5]);	elevel41	.setText(lv+enablerLvArray[5]);	epower41	.setText("");
        ename40	.setText(enablerNameArray[6]);	elevel40	.setText(lv+enablerLvArray[6]);	epower40	.setText("");
        ename39	.setText(enablerNameArray[7]);	elevel39	.setText(lv+enablerLvArray[7]);	epower39	.setText("");
        ename46	.setText(enablerNameArray[8]);	elevel46	.setText(lv+enablerLvArray[8]);	epower46	.setText("");
        ename45	.setText(enablerNameArray[9]);	elevel45	.setText(lv+enablerLvArray[9]);	epower45	.setText("");
        ename44	.setText(enablerNameArray[10]);	elevel44	.setText(lv+enablerLvArray[10]);	epower44	.setText("");
        ename43	.setText(enablerNameArray[11]);	elevel43	.setText(lv+enablerLvArray[11]);	epower43	.setText("");
        ename48	.setText(enablerNameArray[12]);	elevel48	.setText(lv+enablerLvArray[12]);	epower48	.setText("");
        ename47	.setText(enablerNameArray[13]);	elevel47	.setText(lv+enablerLvArray[13]);	epower47	.setText("");
        ename02	.setText(enablerNameArray[14]);	elevel02	.setText(lv+enablerLvArray[14]);	epower02	.setText("");
        ename01	.setText(enablerNameArray[15]);	elevel01	.setText(lv+enablerLvArray[15]);	epower01	.setText("");
        ename06	.setText(enablerNameArray[16]);	elevel06	.setText(lv+enablerLvArray[16]);	epower06	.setText("");
        ename05	.setText(enablerNameArray[17]);	elevel05	.setText(lv+enablerLvArray[17]);	epower05	.setText("");
        ename04	.setText(enablerNameArray[18]);	elevel04	.setText(lv+enablerLvArray[18]);	epower04	.setText("");
        ename03	.setText(enablerNameArray[19]);	elevel03	.setText(lv+enablerLvArray[19]);	epower03	.setText("");
        ename10	.setText(enablerNameArray[20]);	elevel10	.setText(lv+enablerLvArray[20]);	epower10	.setText("");
        ename09	.setText(enablerNameArray[21]);	elevel09	.setText(lv+enablerLvArray[21]);	epower09	.setText("");
        ename08	.setText(enablerNameArray[22]);	elevel08	.setText(lv+enablerLvArray[22]);	epower08	.setText("");
        ename07	.setText(enablerNameArray[23]);	elevel07	.setText(lv+enablerLvArray[23]);	epower07	.setText("");
        ename17	.setText(enablerNameArray[24]);	elevel17	.setText(lv+enablerLvArray[24]);	epower17	.setText("");
        ename14	.setText(enablerNameArray[25]);	elevel14	.setText(lv+enablerLvArray[25]);	epower14	.setText("");
        ename21	.setText(enablerNameArray[26]);	elevel21	.setText(lv+enablerLvArray[26]);	epower21	.setText("");
        ename11	.setText(enablerNameArray[27]);	elevel11	.setText(lv+enablerLvArray[27]);	epower11	.setText("");
        ename23	.setText(enablerNameArray[28]);	elevel23	.setText(lv+enablerLvArray[28]);	epower23	.setText("");
        ename15	.setText(enablerNameArray[29]);	elevel15	.setText(lv+enablerLvArray[29]);	epower15	.setText("");
        ename13	.setText(enablerNameArray[30]);	elevel13	.setText(lv+enablerLvArray[30]);	epower13	.setText("");
        ename12	.setText(enablerNameArray[31]);	elevel12	.setText(lv+enablerLvArray[31]);	epower12	.setText("");
        ename20	.setText(enablerNameArray[32]);	elevel20	.setText(lv+enablerLvArray[32]);	epower20	.setText("");
        ename19	.setText(enablerNameArray[33]);	elevel19	.setText(lv+enablerLvArray[33]);	epower19	.setText("");
        ename16	.setText(enablerNameArray[34]);	elevel16	.setText(lv+enablerLvArray[34]);	epower16	.setText("");
        ename22	.setText(enablerNameArray[35]);	elevel22	.setText(lv+enablerLvArray[35]);	epower22	.setText("");
        ename28	.setText(enablerNameArray[36]);	elevel28	.setText(lv+enablerLvArray[36]);	epower28	.setText("");
        ename24	.setText(enablerNameArray[37]);	elevel24	.setText(lv+enablerLvArray[37]);	epower24	.setText("");
        ename25	.setText(enablerNameArray[38]);	elevel25	.setText(lv+enablerLvArray[38]);	epower25	.setText("");
        ename18	.setText(enablerNameArray[39]);	elevel18	.setText(lv+enablerLvArray[39]);	epower18	.setText("");
        ename30	.setText(enablerNameArray[40]);	elevel30	.setText(lv+enablerLvArray[40]);	epower30	.setText("");
        ename29	.setText(enablerNameArray[41]);	elevel29	.setText(lv+enablerLvArray[41]);	epower29	.setText("");
        ename27	.setText(enablerNameArray[42]);	elevel27	.setText(lv+enablerLvArray[42]);	epower27	.setText("");
        ename26	.setText(enablerNameArray[43]);	elevel26	.setText(lv+enablerLvArray[43]);	epower26	.setText("");
        ename34	.setText(enablerNameArray[44]);	elevel34	.setText(lv+enablerLvArray[44]);	epower34	.setText("");
        ename33	.setText(enablerNameArray[45]);	elevel33	.setText(lv+enablerLvArray[45]);	epower33	.setText("");
        ename32	.setText(enablerNameArray[46]);	elevel32	.setText(lv+enablerLvArray[46]);	epower32	.setText("");
        ename31	.setText(enablerNameArray[47]);	elevel31	.setText(lv+enablerLvArray[47]);	epower31	.setText("");


        if (enablerLvArray[0] 	 == 0 ) {	elevel38	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[0] 	 == 1 ) {	elevel38	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[0] 	 == 2 ) {	elevel38	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[0] 	 == 3 ) {	elevel38	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[0] 	 == 4 ) {	elevel38	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[1]	 == 0 ) {	elevel37	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[1]	 == 1 ) {	elevel37	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[1]	 == 2 ) {	elevel37	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[1]	 == 3 ) {	elevel37	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[1]	 == 4 ) {	elevel37	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[2]	 == 0 ) {	elevel36	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[2]	 == 1 ) {	elevel36	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[2]	 == 2 ) {	elevel36	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[2]	 == 3 ) {	elevel36	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[2]	 == 4 ) {	elevel36	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[3]	 == 0 ) {	elevel35	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[3]	 == 1 ) {	elevel35	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[3]	 == 2 ) {	elevel35	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[3]	 == 3 ) {	elevel35	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[3]	 == 4 ) {	elevel35	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[4]	 == 0 ) {	elevel42	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[4]	 == 1 ) {	elevel42	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[4]	 == 2 ) {	elevel42	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[4]	 == 3 ) {	elevel42	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[4]	 == 4 ) {	elevel42	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[5]	 == 0 ) {	elevel41	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[5]	 == 1 ) {	elevel41	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[5]	 == 2 ) {	elevel41	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[5]	 == 3 ) {	elevel41	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[5]	 == 4 ) {	elevel41	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[6]	 == 0 ) {	elevel40	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[6]	 == 1 ) {	elevel40	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[6]	 == 2 ) {	elevel40	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[6]	 == 3 ) {	elevel40	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[6]	 == 4 ) {	elevel40	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[7]	 == 0 ) {	elevel39	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[7]	 == 1 ) {	elevel39	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[7]	 == 2 ) {	elevel39	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[7]	 == 3 ) {	elevel39	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[7]	 == 4 ) {	elevel39	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[8]	 == 0 ) {	elevel46	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[8]	 == 1 ) {	elevel46	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[8]	 == 2 ) {	elevel46	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[8]	 == 3 ) {	elevel46	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[8]	 == 4 ) {	elevel46	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[9]	 == 0 ) {	elevel45	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[9]	 == 1 ) {	elevel45	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[9]	 == 2 ) {	elevel45	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[9]	 == 3 ) {	elevel45	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[9]	 == 4 ) {	elevel45	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[10]	 == 0 ) {	elevel44	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[10]	 == 1 ) {	elevel44	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[10]	 == 2 ) {	elevel44	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[10]	 == 3 ) {	elevel44	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[10]	 == 4 ) {	elevel44	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[11]	 == 0 ) {	elevel43	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[11]	 == 1 ) {	elevel43	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[11]	 == 2 ) {	elevel43	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[11]	 == 3 ) {	elevel43	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[11]	 == 4 ) {	elevel43	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[12]	 == 0 ) {	elevel48	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[12]	 == 1 ) {	elevel48	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[12]	 == 2 ) {	elevel48	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[12]	 == 3 ) {	elevel48	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[12]	 == 4 ) {	elevel48	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[13]	 == 0 ) {	elevel47	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[13]	 == 1 ) {	elevel47	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[13]	 == 2 ) {	elevel47	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[13]	 == 3 ) {	elevel47	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[13]	 == 4 ) {	elevel47	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[14]	 == 0 ) {	elevel02	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[14]	 == 1 ) {	elevel02	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[14]	 == 2 ) {	elevel02	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[14]	 == 3 ) {	elevel02	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[14]	 == 4 ) {	elevel02	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[15]	 == 0 ) {	elevel01	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[15]	 == 1 ) {	elevel01	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[15]	 == 2 ) {	elevel01	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[15]	 == 3 ) {	elevel01	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[15]	 == 4 ) {	elevel01	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[16]	 == 0 ) {	elevel06	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[16]	 == 1 ) {	elevel06	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[16]	 == 2 ) {	elevel06	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[16]	 == 3 ) {	elevel06	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[16]	 == 4 ) {	elevel06	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[17]	 == 0 ) {	elevel05	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[17]	 == 1 ) {	elevel05	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[17]	 == 2 ) {	elevel05	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[17]	 == 3 ) {	elevel05	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[17]	 == 4 ) {	elevel05	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[18]	 == 0 ) {	elevel04	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[18]	 == 1 ) {	elevel04	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[18]	 == 2 ) {	elevel04	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[18]	 == 3 ) {	elevel04	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[18]	 == 4 ) {	elevel04	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[19]	 == 0 ) {	elevel03	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[19]	 == 1 ) {	elevel03	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[19]	 == 2 ) {	elevel03	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[19]	 == 3 ) {	elevel03	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[19]	 == 4 ) {	elevel03	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[20]	 == 0 ) {	elevel10	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[20]	 == 1 ) {	elevel10	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[20]	 == 2 ) {	elevel10	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[20]	 == 3 ) {	elevel10	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[20]	 == 4 ) {	elevel10	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[21]	 == 0 ) {	elevel09	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[21]	 == 1 ) {	elevel09	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[21]	 == 2 ) {	elevel09	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[21]	 == 3 ) {	elevel09	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[21]	 == 4 ) {	elevel09	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[22]	 == 0 ) {	elevel08	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[22]	 == 1 ) {	elevel08	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[22]	 == 2 ) {	elevel08	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[22]	 == 3 ) {	elevel08	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[22]	 == 4 ) {	elevel08	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[23]	 == 0 ) {	elevel07	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[23]	 == 1 ) {	elevel07	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[23]	 == 2 ) {	elevel07	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[23]	 == 3 ) {	elevel07	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[23]	 == 4 ) {	elevel07	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[24]	 == 0 ) {	elevel17	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[24]	 == 1 ) {	elevel17	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[24]	 == 2 ) {	elevel17	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[24]	 == 3 ) {	elevel17	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[24]	 == 4 ) {	elevel17	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[25]	 == 0 ) {	elevel14	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[25]	 == 1 ) {	elevel14	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[25]	 == 2 ) {	elevel14	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[25]	 == 3 ) {	elevel14	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[25]	 == 4 ) {	elevel14	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[26]	 == 0 ) {	elevel21	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[26]	 == 1 ) {	elevel21	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[26]	 == 2 ) {	elevel21	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[26]	 == 3 ) {	elevel21	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[26]	 == 4 ) {	elevel21	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[27]	 == 0 ) {	elevel11	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[27]	 == 1 ) {	elevel11	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[27]	 == 2 ) {	elevel11	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[27]	 == 3 ) {	elevel11	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[27]	 == 4 ) {	elevel11	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[28]	 == 0 ) {	elevel23	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[28]	 == 1 ) {	elevel23	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[28]	 == 2 ) {	elevel23	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[28]	 == 3 ) {	elevel23	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[28]	 == 4 ) {	elevel23	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[29]	 == 0 ) {	elevel15	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[29]	 == 1 ) {	elevel15	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[29]	 == 2 ) {	elevel15	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[29]	 == 3 ) {	elevel15	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[29]	 == 4 ) {	elevel15	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[30]	 == 0 ) {	elevel13	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[30]	 == 1 ) {	elevel13	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[30]	 == 2 ) {	elevel13	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[30]	 == 3 ) {	elevel13	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[30]	 == 4 ) {	elevel13	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[31]	 == 0 ) {	elevel12	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[31]	 == 1 ) {	elevel12	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[31]	 == 2 ) {	elevel12	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[31]	 == 3 ) {	elevel12	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[31]	 == 4 ) {	elevel12	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[32]	 == 0 ) {	elevel20	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[32]	 == 1 ) {	elevel20	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[32]	 == 2 ) {	elevel20	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[32]	 == 3 ) {	elevel20	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[32]	 == 4 ) {	elevel20	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[33]	 == 0 ) {	elevel19	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[33]	 == 1 ) {	elevel19	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[33]	 == 2 ) {	elevel19	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[33]	 == 3 ) {	elevel19	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[33]	 == 4 ) {	elevel19	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[34]	 == 0 ) {	elevel16	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[34]	 == 1 ) {	elevel16	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[34]	 == 2 ) {	elevel16	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[34]	 == 3 ) {	elevel16	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[34]	 == 4 ) {	elevel16	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[35]	 == 0 ) {	elevel22	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[35]	 == 1 ) {	elevel22	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[35]	 == 2 ) {	elevel22	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[35]	 == 3 ) {	elevel22	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[35]	 == 4 ) {	elevel22	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[36]	 == 0 ) {	elevel28	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[36]	 == 1 ) {	elevel28	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[36]	 == 2 ) {	elevel28	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[36]	 == 3 ) {	elevel28	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[36]	 == 4 ) {	elevel28	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[37]	 == 0 ) {	elevel24	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[37]	 == 1 ) {	elevel24	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[37]	 == 2 ) {	elevel24	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[37]	 == 3 ) {	elevel24	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[37]	 == 4 ) {	elevel24	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[38]	 == 0 ) {	elevel25	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[38]	 == 1 ) {	elevel25	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[38]	 == 2 ) {	elevel25	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[38]	 == 3 ) {	elevel25	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[38]	 == 4 ) {	elevel25	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[39]	 == 0 ) {	elevel18	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[39]	 == 1 ) {	elevel18	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[39]	 == 2 ) {	elevel18	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[39]	 == 3 ) {	elevel18	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[39]	 == 4 ) {	elevel18	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[40]	 == 0 ) {	elevel30	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[40]	 == 1 ) {	elevel30	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[40]	 == 2 ) {	elevel30	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[40]	 == 3 ) {	elevel30	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[40]	 == 4 ) {	elevel30	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[41]	 == 0 ) {	elevel29	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[41]	 == 1 ) {	elevel29	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[41]	 == 2 ) {	elevel29	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[41]	 == 3 ) {	elevel29	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[41]	 == 4 ) {	elevel29	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[42]	 == 0 ) {	elevel27	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[42]	 == 1 ) {	elevel27	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[42]	 == 2 ) {	elevel27	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[42]	 == 3 ) {	elevel27	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[42]	 == 4 ) {	elevel27	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[43]	 == 0 ) {	elevel26	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[43]	 == 1 ) {	elevel26	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[43]	 == 2 ) {	elevel26	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[43]	 == 3 ) {	elevel26	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[43]	 == 4 ) {	elevel26	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[44]	 == 0 ) {	elevel34	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[44]	 == 1 ) {	elevel34	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[44]	 == 2 ) {	elevel34	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[44]	 == 3 ) {	elevel34	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[44]	 == 4 ) {	elevel34	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[45]	 == 0 ) {	elevel33	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[45]	 == 1 ) {	elevel33	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[45]	 == 2 ) {	elevel33	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[45]	 == 3 ) {	elevel33	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[45]	 == 4 ) {	elevel33	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[46]	 == 0 ) {	elevel32	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[46]	 == 1 ) {	elevel32	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[46]	 == 2 ) {	elevel32	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[46]	 == 3 ) {	elevel32	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[46]	 == 4 ) {	elevel32	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[47]	 == 0 ) {	elevel31	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[47]	 == 1 ) {	elevel31	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[47]	 == 2 ) {	elevel31	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[47]	 == 3 ) {	elevel31	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[47]	 == 4 ) {	elevel31	.setText(getString(R.string.enabler_s05));}

        if (progressIdArray[0] ==	 -1){	armed_id_tv	.setText(getString(R.string.	armed	));	armed_img	.setImageResource(R.drawable.	blank_box_show	);}
        if (progressIdArray[0] ==	1){	armed_id_tv	.setText(getString(R.string.	arm_1	));	armed_img	.setImageResource(R.drawable.	h_arm01	);}
        if (progressIdArray[0] ==	2){	armed_id_tv	.setText(getString(R.string.	arm_2	));	armed_img	.setImageResource(R.drawable.	h_arm02	);}
        if (progressIdArray[0] ==	3){	armed_id_tv	.setText(getString(R.string.	arm_3	));	armed_img	.setImageResource(R.drawable.	h_arm03	);}
        if (progressIdArray[0] ==	4){	armed_id_tv	.setText(getString(R.string.	arm_4	));	armed_img	.setImageResource(R.drawable.	h_arm04	);}
        if (progressIdArray[0] ==	5){	armed_id_tv	.setText(getString(R.string.	arm_5	));	armed_img	.setImageResource(R.drawable.	h_arm05	);}
        if (progressIdArray[0] ==	6){	armed_id_tv	.setText(getString(R.string.	arm_6	));	armed_img	.setImageResource(R.drawable.	h_arm06	);}
        if (progressIdArray[0] ==	7){	armed_id_tv	.setText(getString(R.string.	arm_7	));	armed_img	.setImageResource(R.drawable.	h_arm07	);}
        if (progressIdArray[0] ==	8){	armed_id_tv	.setText(getString(R.string.	arm_8	));	armed_img	.setImageResource(R.drawable.	h_arm08	);}
        if (progressIdArray[0] ==	9){	armed_id_tv	.setText(getString(R.string.	arm_9	));	armed_img	.setImageResource(R.drawable.	h_arm09	);}
        if (progressIdArray[0] ==	10){	armed_id_tv	.setText(getString(R.string.	arm_10	));	armed_img	.setImageResource(R.drawable.	h_arm10	);}

        if (progressIdArray[1] ==	 -1){	mili_id_tv	.setText(getString(R.string.	mili	));	mili_img	.setImageResource(R.drawable.	blank_box_show	);}
        if (progressIdArray[1] ==	1){	mili_id_tv	.setText(getString(R.string.	mili_1	));	mili_img	.setImageResource(R.drawable.	h_mili01	);}
        if (progressIdArray[1] ==	2){	mili_id_tv	.setText(getString(R.string.	mili_2	));	mili_img	.setImageResource(R.drawable.	h_mili02	);}
        if (progressIdArray[1] ==	3){	mili_id_tv	.setText(getString(R.string.	mili_3	));	mili_img	.setImageResource(R.drawable.	h_mili03	);}
        if (progressIdArray[1] ==	4){	mili_id_tv	.setText(getString(R.string.	mili_4	));	mili_img	.setImageResource(R.drawable.	h_mili04	);}
        if (progressIdArray[1] ==	5){	mili_id_tv	.setText(getString(R.string.	mili_5	));	mili_img	.setImageResource(R.drawable.	h_mili05	);}
        if (progressIdArray[1] ==	6){	mili_id_tv	.setText(getString(R.string.	mili_6	));	mili_img	.setImageResource(R.drawable.	h_mili06	);}
        if (progressIdArray[1] ==	7){	mili_id_tv	.setText(getString(R.string.	mili_7	));	mili_img	.setImageResource(R.drawable.	h_mili07	);}
        if (progressIdArray[1] ==	8){	mili_id_tv	.setText(getString(R.string.	mili_8	));	mili_img	.setImageResource(R.drawable.	h_mili08	);}
        if (progressIdArray[1] ==	9){	mili_id_tv	.setText(getString(R.string.	mili_9	));	mili_img	.setImageResource(R.drawable.	h_mili09	);}
        if (progressIdArray[1] ==	10){	mili_id_tv	.setText(getString(R.string.	mili_10	));	mili_img	.setImageResource(R.drawable.	h_mili10	);}

        if (progressIdArray[2] ==	 -1){	mobile_id_tv	.setText(getString(R.string.	mobile	));	mobile_img	.setImageResource(R.drawable.	blank_box_show	);}
        if (progressIdArray[2] ==	1){	mobile_id_tv	.setText(getString(R.string.	mobile_1	));	mobile_img	.setImageResource(R.drawable.	h_mobile01	);}
        if (progressIdArray[2] ==	2){	mobile_id_tv	.setText(getString(R.string.	mobile_2	));	mobile_img	.setImageResource(R.drawable.	h_mobile02	);}
        if (progressIdArray[2] ==	3){	mobile_id_tv	.setText(getString(R.string.	mobile_3	));	mobile_img	.setImageResource(R.drawable.	h_mobile03	);}
        if (progressIdArray[2] ==	4){	mobile_id_tv	.setText(getString(R.string.	mobile_4	));	mobile_img	.setImageResource(R.drawable.	h_mobile04	);}
        if (progressIdArray[2] ==	5){	mobile_id_tv	.setText(getString(R.string.	mobile_5	));	mobile_img	.setImageResource(R.drawable.	h_mobile05	);}
        if (progressIdArray[2] ==	6){	mobile_id_tv	.setText(getString(R.string.	mobile_6	));	mobile_img	.setImageResource(R.drawable.	h_mobile06	);}
        if (progressIdArray[2] ==	7){	mobile_id_tv	.setText(getString(R.string.	mobile_7	));	mobile_img	.setImageResource(R.drawable.	h_mobile07	);}
        if (progressIdArray[2] ==	8){	mobile_id_tv	.setText(getString(R.string.	mobile_8	));	mobile_img	.setImageResource(R.drawable.	h_mobile08	);}
        if (progressIdArray[2] ==	9){	mobile_id_tv	.setText(getString(R.string.	mobile_9	));	mobile_img	.setImageResource(R.drawable.	h_mobile09	);}
        if (progressIdArray[2] ==	10){	mobile_id_tv	.setText(getString(R.string.	mobile_10	));	mobile_img	.setImageResource(R.drawable.	h_mobile10	);}

        if (progressIdArray[3] ==	 -1){	infect_id_tv	.setText(getString(R.string.	infecion	));	infect_img	.setImageResource(R.drawable.	blank_box_show	);}
        if (progressIdArray[3] ==	1){	infect_id_tv	.setText(getString(R.string.	infect_1	));	infect_img	.setImageResource(R.drawable.	h_infect01	);}
        if (progressIdArray[3] ==	2){	infect_id_tv	.setText(getString(R.string.	infect_2	));	infect_img	.setImageResource(R.drawable.	h_infect02	);}
        if (progressIdArray[3] ==	3){	infect_id_tv	.setText(getString(R.string.	infect_3	));	infect_img	.setImageResource(R.drawable.	h_infect03	);}
        if (progressIdArray[3] ==	4){	infect_id_tv	.setText(getString(R.string.	infect_4	));	infect_img	.setImageResource(R.drawable.	h_infect04	);}
        if (progressIdArray[3] ==	5){	infect_id_tv	.setText(getString(R.string.	infect_5	));	infect_img	.setImageResource(R.drawable.	h_infect05	);}
        if (progressIdArray[3] ==	6){	infect_id_tv	.setText(getString(R.string.	infect_6	));	infect_img	.setImageResource(R.drawable.	h_infect06	);}
        if (progressIdArray[3] ==	7){	infect_id_tv	.setText(getString(R.string.	infect_7	));	infect_img	.setImageResource(R.drawable.	h_infect07	);}
        if (progressIdArray[3] ==	8){	infect_id_tv	.setText(getString(R.string.	infect_8	));	infect_img	.setImageResource(R.drawable.	h_infect08	);}
        if (progressIdArray[3] ==	9){	infect_id_tv	.setText(getString(R.string.	infect_9	));	infect_img	.setImageResource(R.drawable.	h_infect09	);}
        if (progressIdArray[3] ==	10){	infect_id_tv	.setText(getString(R.string.	infect_10	));	infect_img	.setImageResource(R.drawable.	h_infect10	);}

        if (progressIdArray[4] ==	 -1){	project_id_tv	.setText(getString(R.string.	project	));	project_img	.setImageResource(R.drawable.	blank_box_show	);}
        if (progressIdArray[4] ==	1){	project_id_tv	.setText(getString(R.string.	proj_1	));	project_img	.setImageResource(R.drawable.	h_project01	);}
        if (progressIdArray[4] ==	2){	project_id_tv	.setText(getString(R.string.	proj_2	));	project_img	.setImageResource(R.drawable.	h_project02	);}
        if (progressIdArray[4] ==	3){	project_id_tv	.setText(getString(R.string.	proj_3	));	project_img	.setImageResource(R.drawable.	h_project03	);}
        if (progressIdArray[4] ==	4){	project_id_tv	.setText(getString(R.string.	proj_4	));	project_img	.setImageResource(R.drawable.	h_project04	);}
        if (progressIdArray[4] ==	5){	project_id_tv	.setText(getString(R.string.	proj_5	));	project_img	.setImageResource(R.drawable.	h_project05	);}
        if (progressIdArray[4] ==	6){	project_id_tv	.setText(getString(R.string.	proj_6	));	project_img	.setImageResource(R.drawable.	h_project06	);}
        if (progressIdArray[4] ==	7){	project_id_tv	.setText(getString(R.string.	proj_7	));	project_img	.setImageResource(R.drawable.	h_project07	);}
        if (progressIdArray[4] ==	8){	project_id_tv	.setText(getString(R.string.	proj_8	));	project_img	.setImageResource(R.drawable.	h_project08	);}
        if (progressIdArray[4] ==	9){	project_id_tv	.setText(getString(R.string.	proj_9	));	project_img	.setImageResource(R.drawable.	h_project09	);}
        if (progressIdArray[4] ==	10){	project_id_tv	.setText(getString(R.string.	proj_10	));	project_img	.setImageResource(R.drawable.	h_project10	);}


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

        armed_per.setText(Long.toString((arm_total-arm_progress)*100/arm_total)+"%");
        mili_per.setText(Long.toString((mili_total-mili_progress)*100/mili_total)+"%");
        mobile_per.setText(Long.toString((mobile_total-mobile_progress)*100/mobile_total)+"%");
        infect_per.setText(Long.toString((infect_total-infect_progress)*100/infect_total)+"%");
        project_per.setText(Long.toString((project_total-project_progress)*100/project_total)+"%");

        //SET-TEXT

        armed_count_tv.setText(prettyCount(progressCountArray[0]));
        mili_count_tv.setText(prettyCount(progressCountArray[1]));
        mobile_count_tv.setText(prettyCount(progressCountArray[2]));
        infect_count_tv.setText(prettyCount(progressCountArray[3]));
        project_count_tv.setText(prettyCount(progressCountArray[4]));

        armed_process_tv.setText(getString(R.string.progress_time)+FormatTime(arm_progress));
        mili_process_tv.setText(getString(R.string.progress_time)+FormatTime(mili_progress));
        mobile_process_tv.setText(getString(R.string.progress_time)+FormatTime(mobile_progress));
        infect_process_tv.setText(getString(R.string.progress_time)+FormatTime(infect_progress));
        project_process_tv.setText(getString(R.string.progress_time)+FormatTime(project_progress));

        armed_total_tv.setText(getString(R.string.total_time)+FormatTime(arm_total));
        mili_total_tv.setText(getString(R.string.total_time)+FormatTime(mili_total));
        mobile_total_tv.setText(getString(R.string.total_time)+FormatTime(mobile_total));
        infect_total_tv.setText(getString(R.string.total_time)+FormatTime(infect_total));
        project_total_tv.setText(getString(R.string.total_time)+FormatTime(project_total));


        if (arm_progress == 0 && arm_total > 0){armed_process_tv.setText(getString(R.string.progress_done));}
        if (mili_progress == 0 && mili_total > 0){mili_process_tv.setText(getString(R.string.progress_done));}
        if (mobile_progress == 0 && mobile_total > 0){mobile_process_tv.setText(getString(R.string.progress_done));}
        if (infect_progress == 0 && infect_total > 0){infect_process_tv.setText(getString(R.string.progress_done));}
        if (project_progress == 0 && project_total > 0){project_process_tv.setText(getString(R.string.progress_done));}

        if (arm_progress == 0 && arm_total == 0){armed_process_tv.setText("");armed_total_tv.setText("");}
        if (mili_progress == 0 && mili_total == 0){mili_process_tv.setText("");mili_total_tv.setText("");}
        if (mobile_progress == 0 && mobile_total == 0){mobile_process_tv.setText("");mobile_total_tv.setText("");}
        if (infect_progress == 0 && infect_total == 0){infect_process_tv.setText("");infect_total_tv.setText("");}
        if (project_progress == 0 && project_total == 0){project_process_tv.setText("");project_total_tv.setText("");}

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
            String url = "http://cmt.25u.com:9513/zg/user.json";
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
            if (input_json_list == true){url = "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid="+UID;} else {url = "http://cmt.25u.com:9513/zg/user.json";}

            String jsonStr = sh.makeServiceCall(url);

            // Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray mecha = jsonObj.getJSONArray("mechas");
                    JSONObject rss = jsonObj.getJSONObject("resource");
                    //JSONObject star = jsonObj.getJSONObject("StarStone");
                    JSONArray troops = jsonObj.getJSONArray("armys");
                    JSONArray enablers = jsonObj.getJSONArray("heros");
                    JSONArray progress = jsonObj.getJSONArray("progress");

                    // looping through All Contacts
                    for (int i = 0; i < mecha.length(); i++) {
                        JSONObject c = mecha.getJSONObject(i);
                        mechaName = c.getString("mechaName");
                        mechaNameArray [i] = mechaName;
                        mechaLv = c.getString("mechaLv");
                        mechaLvArray [i] = mechaLv;
                    }
                    for (int i = 0; i < rss.length(); i++) {
                        fuel_final = rss.getInt("wood");
                        food_final = rss.getInt("food");
                        steel_final = rss.getInt("iron");
                        alloy_final = rss.getInt("stone");
                        obsidian_final = rss.getInt("chip");
                        kyanite_final = rss.getInt("crystal1");
                        kyanite_basic_final = rss.getInt("crystal2");
                        kyanite_cluster_final = rss.getInt("crystal3");
                        glory_mark_final = rss.getInt("glory_mark");
                        catalyst_final = rss.getInt("scientificStone");
                        diamond_final = rss.getInt("diamond");

                    }
                    for (int i = 0; i < troops.length(); i++) {
                        JSONObject a = troops.getJSONObject(i);
                        armyFreeNum = a.getInt("armyFreeNum");
                        armyFreeNumArray [i] = armyFreeNum;
                        armyMarchNum = a.getInt("armyMarchNum");
                        armyMarchNumArray [i] = armyMarchNum;
                        armyName = a.getString("armyName");
                        armyNameArray [i] =armyName;
                    }
                    for (int i = 0; i < enablers.length(); i++) {
                        JSONObject c = enablers.getJSONObject(i);
                        enablerName = c.getString("heroName");
                        enablerNameArray [i] = enablerName;
                        enablerLv = c.getInt("heroLv");
                        enablerLvArray [i] = enablerLv;
                    }
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

                    starArray[0] = 1;
                    starArray[1] = 4;
                    starArray[2] = 0;
                    starArray[3] = 0;
                    //     starArray[0] = Integer.parseInt(star_final.split(",")[0]);
                    //   starArray[1] = Integer.parseInt(star_final.split(",")[1]);
                    //    starArray[2] = Integer.parseInt(star_final.split(",")[2]);
                    //   starArray[3] = Integer.parseInt(star_final.split(",")[3]);




                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
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
            dataRefresh();

            if (starArray[0] == 0)	{star01.setVisibility(View.GONE);}
            if (starArray[0] == 1)	{star01.setImageResource(R.drawable.star01);}
            if (starArray[0] == 2)	{star01.setImageResource(R.drawable.star02);}
            if (starArray[0] == 3)	{star01.setImageResource(R.drawable.star03);}
            if (starArray[0] == 4)	{star01.setImageResource(R.drawable.star04);}
            if (starArray[0] == 5)	{star01.setImageResource(R.drawable.star05);}
            if (starArray[0] == 6)	{star01.setImageResource(R.drawable.star06);}
            if (starArray[0] == 7)	{star01.setImageResource(R.drawable.star07);}
            if (starArray[0] == 8)	{star01.setImageResource(R.drawable.star08);}
            if (starArray[0] == 9)	{star01.setImageResource(R.drawable.star09);}
            if (starArray[0] == 10)	{star01.setImageResource(R.drawable.star10);}
            if (starArray[0] == 11)	{star01.setImageResource(R.drawable.star11);}
            if (starArray[0] == 12)	{star01.setImageResource(R.drawable.star12);}
            if (starArray[0] == 13)	{star01.setImageResource(R.drawable.star13);}
            if (starArray[0] == 14)	{star01.setImageResource(R.drawable.star14);}
            if (starArray[0] == 15)	{star01.setImageResource(R.drawable.star15);}
            if (starArray[0] == 16)	{star01.setImageResource(R.drawable.star16);}
            if (starArray[0] == 17)	{star01.setImageResource(R.drawable.star17);}
            if (starArray[0] == 18)	{star01.setImageResource(R.drawable.star18);}
            if (starArray[0] == 19)	{star01.setImageResource(R.drawable.star19);}
            if (starArray[0] == 20)	{star01.setImageResource(R.drawable.star20);}

            if (starArray[1] == 0)	{star02.setVisibility(View.GONE);}
            if (starArray[1] == 1)	{star02.setImageResource(R.drawable.star01);}
            if (starArray[1] == 2)	{star02.setImageResource(R.drawable.star02);}
            if (starArray[1] == 3)	{star02.setImageResource(R.drawable.star03);}
            if (starArray[1] == 4)	{star02.setImageResource(R.drawable.star04);}
            if (starArray[1] == 5)	{star02.setImageResource(R.drawable.star05);}
            if (starArray[1] == 6)	{star02.setImageResource(R.drawable.star06);}
            if (starArray[1] == 7)	{star02.setImageResource(R.drawable.star07);}
            if (starArray[1] == 8)	{star02.setImageResource(R.drawable.star08);}
            if (starArray[1] == 9)	{star02.setImageResource(R.drawable.star09);}
            if (starArray[1] == 10)	{star02.setImageResource(R.drawable.star10);}
            if (starArray[1] == 11)	{star02.setImageResource(R.drawable.star11);}
            if (starArray[1] == 12)	{star02.setImageResource(R.drawable.star12);}
            if (starArray[1] == 13)	{star02.setImageResource(R.drawable.star13);}
            if (starArray[1] == 14)	{star02.setImageResource(R.drawable.star14);}
            if (starArray[1] == 15)	{star02.setImageResource(R.drawable.star15);}
            if (starArray[1] == 16)	{star02.setImageResource(R.drawable.star16);}
            if (starArray[1] == 17)	{star02.setImageResource(R.drawable.star17);}
            if (starArray[1] == 18)	{star02.setImageResource(R.drawable.star18);}
            if (starArray[1] == 19)	{star02.setImageResource(R.drawable.star19);}
            if (starArray[1] == 20)	{star02.setImageResource(R.drawable.star20);}

            if (starArray[2] == 0)	{star03.setVisibility(View.GONE);}
            if (starArray[2] == 1)	{star03.setImageResource(R.drawable.star01);}
            if (starArray[2] == 2)	{star03.setImageResource(R.drawable.star02);}
            if (starArray[2] == 3)	{star03.setImageResource(R.drawable.star03);}
            if (starArray[2] == 4)	{star03.setImageResource(R.drawable.star04);}
            if (starArray[2] == 5)	{star03.setImageResource(R.drawable.star05);}
            if (starArray[2] == 6)	{star03.setImageResource(R.drawable.star06);}
            if (starArray[2] == 7)	{star03.setImageResource(R.drawable.star07);}
            if (starArray[2] == 8)	{star03.setImageResource(R.drawable.star08);}
            if (starArray[2] == 9)	{star03.setImageResource(R.drawable.star09);}
            if (starArray[2] == 10)	{star03.setImageResource(R.drawable.star10);}
            if (starArray[2] == 11)	{star03.setImageResource(R.drawable.star11);}
            if (starArray[2] == 12)	{star03.setImageResource(R.drawable.star12);}
            if (starArray[2] == 13)	{star03.setImageResource(R.drawable.star13);}
            if (starArray[2] == 14)	{star03.setImageResource(R.drawable.star14);}
            if (starArray[2] == 15)	{star03.setImageResource(R.drawable.star15);}
            if (starArray[2] == 16)	{star03.setImageResource(R.drawable.star16);}
            if (starArray[2] == 17)	{star03.setImageResource(R.drawable.star17);}
            if (starArray[2] == 18)	{star03.setImageResource(R.drawable.star18);}
            if (starArray[2] == 19)	{star03.setImageResource(R.drawable.star19);}
            if (starArray[2] == 20)	{star03.setImageResource(R.drawable.star20);}

            if (starArray[3] == 0)	{star04.setVisibility(View.GONE);}
            if (starArray[3] == 1)	{star04.setImageResource(R.drawable.star01);}
            if (starArray[3] == 2)	{star04.setImageResource(R.drawable.star02);}
            if (starArray[3] == 3)	{star04.setImageResource(R.drawable.star03);}
            if (starArray[3] == 4)	{star04.setImageResource(R.drawable.star04);}
            if (starArray[3] == 5)	{star04.setImageResource(R.drawable.star05);}
            if (starArray[3] == 6)	{star04.setImageResource(R.drawable.star06);}
            if (starArray[3] == 7)	{star04.setImageResource(R.drawable.star07);}
            if (starArray[3] == 8)	{star04.setImageResource(R.drawable.star08);}
            if (starArray[3] == 9)	{star04.setImageResource(R.drawable.star09);}
            if (starArray[3] == 10)	{star04.setImageResource(R.drawable.star10);}
            if (starArray[3] == 11)	{star04.setImageResource(R.drawable.star11);}
            if (starArray[3] == 12)	{star04.setImageResource(R.drawable.star12);}
            if (starArray[3] == 13)	{star04.setImageResource(R.drawable.star13);}
            if (starArray[3] == 14)	{star04.setImageResource(R.drawable.star14);}
            if (starArray[3] == 15)	{star04.setImageResource(R.drawable.star15);}
            if (starArray[3] == 16)	{star04.setImageResource(R.drawable.star16);}
            if (starArray[3] == 17)	{star04.setImageResource(R.drawable.star17);}
            if (starArray[3] == 18)	{star04.setImageResource(R.drawable.star18);}
            if (starArray[3] == 19)	{star04.setImageResource(R.drawable.star19);}
            if (starArray[3] == 20)	{star04.setImageResource(R.drawable.star20);}

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
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();

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


}

