package voc.net.tools.zgirls_tool.ui;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.apache.http.util.EncodingUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.R;
import voc.net.tools.zgirls_tool.util.HttpHandler;
import voc.net.tools.zgirls_tool.util.ScreenSizeUtils;
import voc.net.tools.zgirls_tool.util.TroopAdapter;
import voc.net.tools.zgirls_tool.util.Troops;

public class NewTroopsActivity extends AppCompatActivity {

    private static final String TAG = "NewTriiosActivity";
    EditText buff01 , buff02 , buff03;

    TextView fuel_tv , food_tv , steel_tv , alloy_tv , time_tv , kyanite_tv , kyanite_basic_tv , kyanite_cluster_tv , damage_tv , defense_tv , hp_tv , speed_tv , load_tv , cost_tv , power_tv , total_tv;
    double cost , power ;
    long temp , total ,time;

    long[] troopTotal = new long[60];
    long[] troopIn = new long[60];
    long[] troopOut = new long[60];
    //LinearLayout proj , arm , mili , mobile , infect , buff;
    private static String PATH_TPS_SAVE = Environment.getExternalStorageDirectory().getPath () +"/voc/zgt/troops/";

    EditText day , hour , min , sec ;
    long count_l = 1 ;
    long count_t = 1 ;
    int troop_id = 1 ;
    int troop_idA[] = {0,0,0,0,0,0,0,0,0,0};

    String jsonStr;
    String str;
    long UID;
//Cause: failed to decrypt safe contents entry: javax.crypto.BadPaddingException: Given final block not properly padded. Such issues can arise if a bad key is used during decryption.
    long uid ;
    String verifyCode ;

    private static final String fileName = "user_session";
    private static final String fileDir = Environment.getExternalStorageDirectory().getPath() +"/data/data/com.xingjoys.zgirls.app/config/";

    private List<Troops> troopList = new ArrayList<>();
    private RecyclerView.Adapter adapter;
    private TroopAdapter mAdapter;
    RecyclerView mList ;
    private LinearLayoutManager linearLayoutManager;
    public int[] troopName = {R.string.mili_1,	R.string.mili_2,	R.string.mili_3,	R.string.mili_4,	R.string.mili_5,	R.string.mili_6,	R.string.mili_7,	R.string.mili_8,	R.string.mili_9,	R.string.mili_10,	R.string.mobile_1,	R.string.mobile_2,	R.string.mobile_3,	R.string.mobile_4,	R.string.mobile_5,	R.string.mobile_6,	R.string.mobile_7,	R.string.mobile_8,	R.string.mobile_9,	R.string.mobile_10,	R.string.arm_1,	R.string.arm_2,	R.string.arm_3,	R.string.arm_4,	R.string.arm_5,	R.string.arm_6,	R.string.arm_7,	R.string.arm_8,	R.string.arm_9,	R.string.arm_10,	R.string.infect_1,	R.string.infect_2,	R.string.infect_3,	R.string.infect_4,	R.string.infect_5,	R.string.infect_6,	R.string.infect_7,	R.string.infect_8,	R.string.infect_9,	R.string.infect_10,	R.string.proj_1,	R.string.proj_2,	R.string.proj_3,	R.string.proj_4,	R.string.proj_5,	R.string.proj_6,	R.string.proj_7,	R.string.proj_8,	R.string.proj_9,	R.string.proj_10};

    int[] fuel_db ={0,0,31,0,57,0,0,108,133,0,0,0,0,20,27,0,56,0,104,0,57,10,14,20,27,35,46,53,68,77,29,43,64,88,116,151,173,212,255,330,0,0,0,0,0,0,0,0,0,0};
    int[] food_db ={0,0,31,0,57,0,0,108,133,0,57,100,155,175,228,271,269,253,276,189,0,90,130,185,241,296,254,217,181,155,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    int[] steel_db ={61,100,119,169,164,245,253,203,206,323,0,0,0,2,5,15,9,27,15,52,0,0,0,2,3,4,5,7,10,13,5,10,14,20,27,34,37,41,52,60,2,3,5,7,0,0,0,0,0,0};
    int[] alloy_db ={0,0,0,7,9,18,22,25,30,39,0,0,0,0,0,0,3,5,8,11,0,0,0,0,0,0,5,9,15,19,0,0,0,0,0,0,2,3,4,5,6,12,17,24,0,0,0,0,0,0};
    int[] time_db ={16,20,28,44,58,75,95,118,144,173,16,20,28,44,58,75,95,118,144,173,16,20,28,44,58,75,95,118,144,173,16,20,28,44,58,75,95,118,144,173,80,100,140,220,290,375,475,590,720,865};
    int[] kyanite_db ={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,4,5,7,7,8,10,12};
    int[] kyanite_basic_db ={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,4,5,6};
    int[] kyanite_cluster_db ={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1};
    int[] damage_db ={6 ,8 ,22 ,15 ,38 ,24 ,29 ,70 ,84 ,49 ,11 ,15 ,20 ,32 ,41 ,44 ,63 ,64 ,91 ,90 ,8 ,11 ,26 ,35 ,28 ,32 ,68 ,47 ,98 ,65 ,17 ,23 ,22 ,42 ,38 ,68 ,83 ,70 ,84 ,139 ,166 ,38 ,78 ,278 ,394 ,118 ,514 ,158 ,640 ,200};
    int[] defense_db ={14 ,19 ,13 ,35 ,22 ,56 ,68 ,41 ,49 ,114 ,8 ,11 ,15 ,17 ,22 ,32 ,344 ,47 ,49 ,65 ,6 ,8 ,13 ,17 ,19 ,24 ,34 ,35 ,49 ,49 ,1 ,1 ,19 ,2 ,32 ,4 ,4 ,59 ,70 ,8 ,8 ,136 ,228 ,16 ,20 ,324 ,24 ,424 ,28 ,530};
    int[] hp_db ={8 ,9 ,6 ,15 ,9 ,22 ,26 ,15 ,18 ,42 ,4 ,4 ,6 ,7 ,9 ,11 ,13 ,15 ,18 ,21 ,3 ,3 ,4 ,5 ,6 ,8 ,10 ,11 ,13 ,15 ,5 ,6 ,15 ,9 ,23 ,14 ,16 ,39 ,46 ,26 ,26 ,104 ,168 ,42 ,58 ,236 ,74 ,304 ,90 ,376};
    int[] range_db ={1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,4 ,4 ,1 ,4 ,1 ,4 ,1 ,5 ,5 ,8 ,8 ,5 ,5 ,8 ,5 ,8 ,5 ,11 ,11 ,1 ,11 ,1 ,11 ,11 ,1 ,1 ,11 ,13 ,1 ,1 ,13 ,13 ,1 ,13 ,1 ,13 ,1};
    int[] speed_db ={8 ,8 ,9 ,8 ,9 ,8 ,8 ,9 ,9 ,8 ,14 ,14 ,14 ,13 ,13 ,14 ,13 ,14 ,13 ,14 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,8 ,13 ,13 ,5 ,13 ,5 ,13 ,13 ,5 ,5 ,13 ,8 ,8 ,9 ,8 ,9 ,8 ,8 ,9 ,9 ,8};
    int[] load_db ={22 ,22 ,25 ,25 ,27 ,27 ,30 ,30 ,33 ,33 ,50 ,50 ,52 ,38 ,41 ,55 ,44 ,58 ,47 ,61 ,22 ,22 ,22 ,22 ,27 ,27 ,27 ,30 ,30 ,33 ,22 ,22 ,25 ,25 ,27 ,27 ,30 ,30 ,33 ,33 ,22 ,22 ,25 ,25 ,27 ,27 ,30 ,30 ,33 ,33};
    double[] cost_db ={0.24 ,0.42 ,0.62 ,0.83 ,1.04 ,1.25 ,1.46 ,1.67 ,1.88 ,2.08 ,0.21 ,0.42 ,0.62 ,0.83 ,1.04 ,1.25 ,1.46 ,1.67 ,1.88 ,2.08 ,0.21 ,0.42 ,0.62 ,0.83 ,1.04 ,1.25 ,1.46 ,1.67 ,1.88 ,2.08 ,0.04 ,0.04 ,0.08 ,0.08 ,0.12 ,0.12 ,0.17 ,0.17 ,0.21 ,0.21 ,1.25 ,2.50 ,3.75 ,5.00 ,6.25 ,7.50 ,8.75 ,10.00 ,11.25 ,12.50};
    double[] power_db ={1.0 ,1.4 ,1.9 ,2.5 ,3.2 ,4.0 ,4.9 ,5.9 ,7.0 ,8.2 ,1.0 ,1.4 ,1.9 ,2.5 ,3.2 ,4.0 ,4.9 ,5.9 ,7.0 ,8.2 ,1.0 ,1.4 ,1.9 ,2.5 ,3.2 ,4.0 ,4.9 ,5.9 ,7.0 ,8.2 ,1.0 ,1.4 ,1.9 ,2.5 ,3.2 ,4.0 ,4.9 ,5.9 ,7.0 ,8.2 ,6.4 ,8.0 ,9.8 ,11.8 ,14.0 ,16.4 ,19.0 ,21.8 ,24.8 ,28.0 };
    int[] troop_train_pts = {1,2,4,7,13,21,33,49,70,97};

    String buildingName ;
    long buildingLvl , buildingGlory ;

    long[] buildingLvlArray = new long[80];
    String[] buildingNameArray = new String[80];

    String armyName ;
    long armyFreeNum , armyMarchNum ;

    String[] armyNameArray = new String[60];
    long[] armyFreeNumArray = new long[60];
    long[] armyMarchNumArray = new long[60];

    long[] armyCountNumArray = new long[60];
    long[] armyFinishNumArray = new long[60];
    long[] armyIdNumArray = new long[60];

    long[] team_count = new long[10];
    long[] team_id = new long[10];


    /**
     * This is NewTroops UI Parts
     * 10 Groups in this version -> 1.0.12
     */

    EditText team01_et,	team02_et,	team03_et,	team04_et,	team05_et,	team06_et,	team07_et,	team08_et,	team09_et,	team10_et;
    ImageView team01_img,	team02_img,	team03_img,	team04_img,	team05_img,	team06_img,	team07_img,	team08_img,	team09_img,	team10_img;
    TextView team01_tv,	team02_tv,	team03_tv,	team04_tv,	team05_tv,	team06_tv,	team07_tv,	team08_tv,	team09_tv,	team10_tv;
    CardView team01_card,	team02_card,	team03_card,	team04_card,	team05_card,	team06_card,	team07_card,	team08_card,	team09_card,	team10_card;

    long fuel , food , steel , alloy , kyanite , kyanite_basic , kyanite_cluster , damage ,  defense , range ,hp , speed , load ;

    long[] fuel_team = {0,0,0,0,0,0,0,0,0,0};
    long[] food_team = {0,0,0,0,0,0,0,0,0,0};
    long[] steel_team = {0,0,0,0,0,0,0,0,0,0};
    long[] alloy_team = {0,0,0,0,0,0,0,0,0,0};
    long[] time_team = {0,0,0,0,0,0,0,0,0,0};
    long[] kyanite_team = {0,0,0,0,0,0,0,0,0,0};
    long[] kyanite_basic_team = {0,0,0,0,0,0,0,0,0,0};
    long[] kyanite_cluster_team = {0,0,0,0,0,0,0,0,0,0};
    long[] damage_team = {0,0,0,0,0,0,0,0,0,0};
    long[] defense_team = {0,0,0,0,0,0,0,0,0,0};
    long[] range_team= {0,0,0,0,0,0,0,0,0,0};
    long[] hp_team = {0,0,0,0,0,0,0,0,0,0};
    long[] speed_team = {0,0,0,0,0,0,0,0,0,0};
    long[] load_team  ={0,0,0,0,0,0,0,0,0,0};
    double[] cost_team = {0,0,0,0,0,0,0,0,0,0} ;
    double[] power_team = {0,0,0,0,0,0,0,0,0,0} ;
    SharedPreferences sharedPreferences ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_troops);

        new_init();

        buff01	= findViewById(R.id.buff01c_et);
        buff02	= findViewById(R.id.buff02_et);
        buff03	= findViewById(R.id.buff03_et);

        day	= findViewById(R.id.buff01_et1);
        hour	= findViewById(R.id.buff01_et2);
        min	= findViewById(R.id.buff01_et3);
        sec	= findViewById(R.id.buff01_et4);

        fuel_tv = findViewById(R.id.troop_fuel);
        food_tv = findViewById(R.id.troop_food);
        steel_tv = findViewById(R.id.troop_steel);
        alloy_tv = findViewById(R.id.troop_alloy);
        kyanite_tv = findViewById(R.id.troop_kyanite);
        kyanite_basic_tv = findViewById(R.id.troop_kyanite_basic);
        kyanite_cluster_tv = findViewById(R.id.troop_kyanite_cluster);
        load_tv = findViewById(R.id.troop_load);
        cost_tv = findViewById(R.id.troop_cost);
        power_tv = findViewById(R.id.troop_power);
        time_tv = findViewById(R.id.troop_time);
        total_tv = findViewById(R.id.troop_total);
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String text = sharedPreferences.getString("troops_shared","{}");
        if (!text.equals("{}")) { Load(); }
        ImageView troop_choose = findViewById(R.id.troop_choose);

        // Troop List
        mAdapter = new TroopAdapter(getApplicationContext(), troopList);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mList = findViewById(R.id.train_list);
        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.setAdapter(mAdapter);

        sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);

        sharedPreferences.getString("troop_tv_size", "small");

        long buff1 = sharedPreferences.getLong("buff01", 10);
        long buff2 = sharedPreferences.getLong("buff02", 0);
        long buff3 = sharedPreferences.getLong("buff03", 0);
        long da = sharedPreferences.getLong("D", 0);
        long ho = sharedPreferences.getLong("H", 0);
        long mi = sharedPreferences.getLong("M", 2);
        long se = sharedPreferences.getLong("S", 40);
        long c_t = sharedPreferences.getLong("count_t", 10);
        long c_l = sharedPreferences.getLong("count_l", 10);
        troop_id = sharedPreferences.getInt("troop_id_act", 1);
        buff01.setText(String.valueOf(buff1));
        buff02.setText(String.valueOf(buff2));
        buff03.setText(String.valueOf(buff3));
        day.setText(String.valueOf(da));
        hour.setText(String.valueOf(ho));
        min.setText(String.valueOf(mi));
        sec.setText(String.valueOf(se));
        count_t = c_t;
        count_l = c_l;

        BackgroundReload();
        cbg();

        String troops_tv_size = sharedPreferences.getString("troop_tv_size", "small");
        if (troops_tv_size == "small"){
            fuel_tv.setTextSize(16);
            food_tv.setTextSize(16);
            steel_tv.setTextSize(16);
            alloy_tv.setTextSize(16);
            kyanite_tv.setTextSize(16);
            kyanite_basic_tv.setTextSize(16);
            kyanite_cluster_tv.setTextSize(16);
            load_tv.setTextSize(16);
            cost_tv.setTextSize(16);
            power_tv.setTextSize(16);
            time_tv.setTextSize(16);
        }
        if (troops_tv_size == "big"){
            fuel_tv.setTextSize(18);
            food_tv.setTextSize(18);
            steel_tv.setTextSize(18);
            alloy_tv.setTextSize(18);
            kyanite_tv.setTextSize(18);
            kyanite_basic_tv.setTextSize(18);
            kyanite_cluster_tv.setTextSize(18);
            load_tv.setTextSize(18);
            cost_tv.setTextSize(18);
            power_tv.setTextSize(18);
            time_tv.setTextSize(18);
        }
        input_data();

        team01_img.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { showTroop(team01_img,v,team01_tv,team02_card,1,team01_et); }});
        team02_img.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { showTroop(team02_img,v,team02_tv,team03_card,2,team02_et); }});
        team03_img.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { showTroop(team03_img,v,team03_tv,team04_card,3,team03_et); }});
        team04_img.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { showTroop(team04_img,v,team04_tv,team05_card,4,team04_et); }});
        team05_img.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { showTroop(team05_img,v,team05_tv,team06_card,5,team05_et); }});
        team06_img.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { showTroop(team06_img,v,team06_tv,team07_card,6,team06_et); }});
        team07_img.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { showTroop(team07_img,v,team07_tv,team08_card,7,team07_et); }});
        team08_img.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { showTroop(team08_img,v,team08_tv,team09_card,8,team08_et); }});
        team09_img.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { showTroop(team09_img,v,team09_tv,team10_card,9,team09_et); }});
        team10_img.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { showTroop(team10_img,v,team10_tv,team10_card,10,team10_et); }});

        team01_et.addTextChangedListener(textWatcher);
        team02_et.addTextChangedListener(textWatcher);
        team03_et.addTextChangedListener(textWatcher);
        team04_et.addTextChangedListener(textWatcher);
        team05_et.addTextChangedListener(textWatcher);
        team06_et.addTextChangedListener(textWatcher);
        team07_et.addTextChangedListener(textWatcher);
        team08_et.addTextChangedListener(textWatcher);
        team09_et.addTextChangedListener(textWatcher);
        team10_et.addTextChangedListener(textWatcher);

    }

    TextWatcher textWatcher = new TextWatcher() {

        public void afterTextChanged(Editable s) {
            troop_calcalate();
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            troop_calcalate();

        }
    };

    public void cbg() {
        SharedPreferences sharedPreferences = getSharedPreferences("user_info",MODE_PRIVATE);
        //取出数据（注意这里直接用实例取就行了，不用获取编辑器editor）
        String theme = sharedPreferences.getString("theme", "dark");
        String color1 = sharedPreferences.getString("color1", "F1870F");
        String color2 = sharedPreferences.getString("color2", "C56E0D");

        if (theme.equals("base")) {
            team01_card	.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            team02_card	.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            team03_card	.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            team04_card	.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            team05_card	.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            team06_card	.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            team07_card	.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            team08_card	.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            team09_card	.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            team10_card	.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));


        }

        if (theme.equals("dark")) {
            team01_card	.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            team02_card	.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            team03_card	.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            team04_card	.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            team05_card	.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            team06_card	.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            team07_card	.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            team08_card	.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            team09_card	.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            team10_card	.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
        }

        if (theme.equals("pink")) {
            team01_card	.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            team02_card	.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            team03_card	.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            team04_card	.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            team05_card	.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            team06_card	.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            team07_card	.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            team08_card	.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            team09_card	.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            team10_card	.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));

        }

        if (theme.equals("leek")) {
            team01_card	.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            team02_card	.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            team03_card	.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            team04_card	.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            team05_card	.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            team06_card	.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            team07_card	.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            team08_card	.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            team09_card	.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            team10_card	.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));

        }

        if (theme.equals("summer")) {
            team01_card	.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            team02_card	.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            team03_card	.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            team04_card	.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            team05_card	.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            team06_card	.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            team07_card	.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            team08_card	.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            team09_card	.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            team10_card	.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));

        }

        if (theme.equals("custom")) {
            team01_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            team02_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            team03_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            team04_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            team05_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            team06_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            team07_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            team08_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            team09_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            team10_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
        }
    }

    public void showTroop(ImageView troop_choose, View view, TextView troop_name, CardView next_card, int x, EditText troop_et){
        final Dialog dialog = new Dialog(this, R.style.NormalDialogStyle_N);
        view = View.inflate(this, R.layout.troop_choose, null);

        ImageView	arm01	 = view.findViewById(R.id.	h_arm01)	;
        ImageView	arm02	 = view.findViewById(R.id.	h_arm02)	;
        ImageView	arm03	 = view.findViewById(R.id.	h_arm03)	;
        ImageView	arm04	 = view.findViewById(R.id.	h_arm04)	;
        ImageView	arm05	 = view.findViewById(R.id.	h_arm05)	;
        ImageView	arm06	 = view.findViewById(R.id.	h_arm06)	;
        ImageView	arm07	 = view.findViewById(R.id.	h_arm07)	;
        ImageView	arm08	 = view.findViewById(R.id.	h_arm08)	;
        ImageView	arm09	 = view.findViewById(R.id.	h_arm09)	;
        ImageView	arm10	 = view.findViewById(R.id.	h_arm10)	;
        ImageView	mili01	 = view.findViewById(R.id.	h_mili01)	;
        ImageView	mili02	 = view.findViewById(R.id.	h_mili02)	;
        ImageView	mili03	 = view.findViewById(R.id.	h_mili03)	;
        ImageView	mili04	 = view.findViewById(R.id.	h_mili04)	;
        ImageView	mili05	 = view.findViewById(R.id.	h_mili05)	;
        ImageView	mili06	 = view.findViewById(R.id.	h_mili06)	;
        ImageView	mili07	 = view.findViewById(R.id.	h_mili07)	;
        ImageView	mili08	 = view.findViewById(R.id.	h_mili08)	;
        ImageView	mili09	 = view.findViewById(R.id.	h_mili09)	;
        ImageView	mili10	 = view.findViewById(R.id.	h_mili10)	;
        ImageView	mobile01	 = view.findViewById(R.id.	h_mobile01)	;
        ImageView	mobile02	 = view.findViewById(R.id.	h_mobile02)	;
        ImageView	mobile03	 = view.findViewById(R.id.	h_mobile03)	;
        ImageView	mobile04	 = view.findViewById(R.id.	h_mobile04)	;
        ImageView	mobile05	 = view.findViewById(R.id.	h_mobile05)	;
        ImageView	mobile06	 = view.findViewById(R.id.	h_mobile06)	;
        ImageView	mobile07	 = view.findViewById(R.id.	h_mobile07)	;
        ImageView	mobile08	 = view.findViewById(R.id.	h_mobile08)	;
        ImageView	mobile09	 = view.findViewById(R.id.	h_mobile09)	;
        ImageView	mobile10	 = view.findViewById(R.id.	h_mobile10)	;
        ImageView	infect01	 = view.findViewById(R.id.	h_infect01)	;
        ImageView	infect02	 = view.findViewById(R.id.	h_infect02)	;
        ImageView	infect03	 = view.findViewById(R.id.	h_infect03)	;
        ImageView	infect04	 = view.findViewById(R.id.	h_infect04)	;
        ImageView	infect05	 = view.findViewById(R.id.	h_infect05)	;
        ImageView	infect06	 = view.findViewById(R.id.	h_infect06)	;
        ImageView	infect07	 = view.findViewById(R.id.	h_infect07)	;
        ImageView	infect08	 = view.findViewById(R.id.	h_infect08)	;
        ImageView	infect09	 = view.findViewById(R.id.	h_infect09)	;
        ImageView	infect10	 = view.findViewById(R.id.	h_infect10)	;
        ImageView	project01	 = view.findViewById(R.id.	h_project01)	;
        ImageView	project02	 = view.findViewById(R.id.	h_project02)	;
        ImageView	project03	 = view.findViewById(R.id.	h_project03)	;
        ImageView	project04	 = view.findViewById(R.id.	h_project04)	;
        ImageView	project05	 = view.findViewById(R.id.	h_project05)	;
        ImageView	project06	 = view.findViewById(R.id.	h_project06)	;
        ImageView	project07	 = view.findViewById(R.id.	h_project07)	;
        ImageView	project08	 = view.findViewById(R.id.	h_project08)	;
        ImageView	project09	 = view.findViewById(R.id.	h_project09)	;
        ImageView	project10	 = view.findViewById(R.id.	h_project10)	;
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        //view.setMinimumHeight((int) (ScreenSizeUtils.getInstance(this).getScreenHeight()));
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int) (ScreenSizeUtils.getInstance(this).getScreenWidth()*0.8);
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);
        dialog.show();


        arm01	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_arm01	);	troop_id = 21;	troop_idA[x-1] = 21;	then(next_card,troop_name,troop_et,x);	}});
        arm02	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_arm02	);	troop_id = 22;	troop_idA[x-1] = 22;	then(next_card,troop_name,troop_et,x);	}});
        arm03	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_arm03	);	troop_id = 23;	troop_idA[x-1] = 23;	then(next_card,troop_name,troop_et,x);	}});
        arm04	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_arm04	);	troop_id = 24;	troop_idA[x-1] = 24;	then(next_card,troop_name,troop_et,x);	}});
        arm05	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_arm05	);	troop_id = 25;	troop_idA[x-1] = 25;	then(next_card,troop_name,troop_et,x);	}});
        arm06	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_arm06	);	troop_id = 26;	troop_idA[x-1] = 26;	then(next_card,troop_name,troop_et,x);	}});
        arm07	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_arm07	);	troop_id = 27;	troop_idA[x-1] = 27;	then(next_card,troop_name,troop_et,x);	}});
        arm08	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_arm08	);	troop_id = 28;	troop_idA[x-1] = 28;	then(next_card,troop_name,troop_et,x);	}});
        arm09	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_arm09	);	troop_id = 29;	troop_idA[x-1] = 29;	then(next_card,troop_name,troop_et,x);	}});
        arm10	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_arm10	);	troop_id = 30;	troop_idA[x-1] = 30;	then(next_card,troop_name,troop_et,x);	}});
        mili01	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_mili01	);	troop_id = 1;	troop_idA[x-1] = 1;	then(next_card,troop_name,troop_et,x);	}});
        mili02	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_mili02	);	troop_id = 2;	troop_idA[x-1] = 2;	then(next_card,troop_name,troop_et,x);	}});
        mili03	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_mili03	);	troop_id = 3;	troop_idA[x-1] = 3;	then(next_card,troop_name,troop_et,x);	}});
        mili04	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_mili04	);	troop_id = 4;	troop_idA[x-1] = 4;	then(next_card,troop_name,troop_et,x);	}});
        mili05	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_mili05	);	troop_id = 5;	troop_idA[x-1] = 5;	then(next_card,troop_name,troop_et,x);	}});
        mili06	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_mili06	);	troop_id = 6;	troop_idA[x-1] = 6;	then(next_card,troop_name,troop_et,x);	}});
        mili07	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_mili07	);	troop_id = 7;	troop_idA[x-1] = 7;	then(next_card,troop_name,troop_et,x);	}});
        mili08	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_mili08	);	troop_id = 8;	troop_idA[x-1] = 8;	then(next_card,troop_name,troop_et,x);	}});
        mili09	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_mili09	);	troop_id = 9;	troop_idA[x-1] = 9;	then(next_card,troop_name,troop_et,x);	}});
        mili10	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_mili10	);	troop_id = 10;	troop_idA[x-1] = 10;	then(next_card,troop_name,troop_et,x);	}});
        mobile01	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_mobile01	);	troop_id = 11;	troop_idA[x-1] = 11;	then(next_card,troop_name,troop_et,x);	}});
        mobile02	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_mobile02	);	troop_id = 12;	troop_idA[x-1] = 12;	then(next_card,troop_name,troop_et,x);	}});
        mobile03	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_mobile03	);	troop_id = 13;	troop_idA[x-1] = 13;	then(next_card,troop_name,troop_et,x);	}});
        mobile04	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_mobile04	);	troop_id = 14;	troop_idA[x-1] = 14;	then(next_card,troop_name,troop_et,x);	}});
        mobile05	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_mobile05	);	troop_id = 15;	troop_idA[x-1] = 15;	then(next_card,troop_name,troop_et,x);	}});
        mobile06	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_mobile06	);	troop_id = 16;	troop_idA[x-1] = 16;	then(next_card,troop_name,troop_et,x);	}});
        mobile07	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_mobile07	);	troop_id = 17;	troop_idA[x-1] = 17;	then(next_card,troop_name,troop_et,x);	}});
        mobile08	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_mobile08	);	troop_id = 18;	troop_idA[x-1] = 18;	then(next_card,troop_name,troop_et,x);	}});
        mobile09	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_mobile09	);	troop_id = 19;	troop_idA[x-1] = 19;	then(next_card,troop_name,troop_et,x);	}});
        mobile10	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_mobile10	);	troop_id = 20;	troop_idA[x-1] = 20;	then(next_card,troop_name,troop_et,x);	}});
        infect01	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_infect01	);	troop_id = 31;	troop_idA[x-1] = 31;	then(next_card,troop_name,troop_et,x);	}});
        infect02	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_infect02	);	troop_id = 32;	troop_idA[x-1] = 32;	then(next_card,troop_name,troop_et,x);	}});
        infect03	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_infect03	);	troop_id = 33;	troop_idA[x-1] = 33;	then(next_card,troop_name,troop_et,x);	}});
        infect04	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_infect04	);	troop_id = 34;	troop_idA[x-1] = 34;	then(next_card,troop_name,troop_et,x);	}});
        infect05	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_infect05	);	troop_id = 35;	troop_idA[x-1] = 35;	then(next_card,troop_name,troop_et,x);	}});
        infect06	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_infect06	);	troop_id = 36;	troop_idA[x-1] = 36;	then(next_card,troop_name,troop_et,x);	}});
        infect07	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_infect07	);	troop_id = 37;	troop_idA[x-1] = 37;	then(next_card,troop_name,troop_et,x);	}});
        infect08	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_infect08	);	troop_id = 38;	troop_idA[x-1] = 38;	then(next_card,troop_name,troop_et,x);	}});
        infect09	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_infect09	);	troop_id = 39;	troop_idA[x-1] = 39;	then(next_card,troop_name,troop_et,x);	}});
        infect10	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_infect10	);	troop_id = 40;	troop_idA[x-1] = 40;	then(next_card,troop_name,troop_et,x);	}});
        project01	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_project01	);	troop_id = 41;	troop_idA[x-1] = 41;	then(next_card,troop_name,troop_et,x);	}});
        project02	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_project02	);	troop_id = 42;	troop_idA[x-1] = 42;	then(next_card,troop_name,troop_et,x);	}});
        project03	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_project03	);	troop_id = 43;	troop_idA[x-1] = 43;	then(next_card,troop_name,troop_et,x);	}});
        project04	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_project04	);	troop_id = 44;	troop_idA[x-1] = 44;	then(next_card,troop_name,troop_et,x);	}});
        project05	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_project05	);	troop_id = 45;	troop_idA[x-1] = 45;	then(next_card,troop_name,troop_et,x);	}});
        project06	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_project06	);	troop_id = 46;	troop_idA[x-1] = 46;	then(next_card,troop_name,troop_et,x);	}});
        project07	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_project07	);	troop_id = 47;	troop_idA[x-1] = 47;	then(next_card,troop_name,troop_et,x);	}});
        project08	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_project08	);	troop_id = 48;	troop_idA[x-1] = 48;	then(next_card,troop_name,troop_et,x);	}});
        project09	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_project09	);	troop_id = 49;	troop_idA[x-1] = 49;	then(next_card,troop_name,troop_et,x);	}});
        project10	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	troop_choose.setImageResource(R.drawable.	hs_project10	);	troop_id = 50;	troop_idA[x-1] = 50;	then(next_card,troop_name,troop_et,x);	}});

    }

    public void then (CardView next_card,TextView troop_name,EditText troop_et,int x){
        next_card.setVisibility(View.VISIBLE);
        troop_name.setText(getString(troopName[troop_id-1]));
        troop_et.setVisibility(View.VISIBLE);
        if (x == 1){	fuel_team[0] = fuel_db[troop_id-1];	food_team[0] = food_db[troop_id-1];	steel_team[0] = steel_db[troop_id-1];	alloy_team[0] = alloy_db[troop_id-1];	time_team[0] = time_db[troop_id-1];	kyanite_team[0] = kyanite_db[troop_id-1];	kyanite_basic_team[0] = kyanite_basic_db[troop_id-1];	kyanite_cluster_team[0] = kyanite_cluster_db[troop_id-1];	damage_team[0] = damage_db[troop_id-1];	defense_team[0] = defense_db[troop_id-1];	hp_team[0] = hp_db[troop_id-1];	range_team[0] = range_db[troop_id-1];	speed_team[0] = speed_db[troop_id-1];	load_team[0] = load_db[troop_id-1];	cost_team[0] = cost_db[troop_id-1];	power_team[0] = power_db[troop_id-1];	};
        if (x == 2){	fuel_team[1] = fuel_db[troop_id-1];	food_team[1] = food_db[troop_id-1];	steel_team[1] = steel_db[troop_id-1];	alloy_team[1] = alloy_db[troop_id-1];	time_team[1] = time_db[troop_id-1];	kyanite_team[1] = kyanite_db[troop_id-1];	kyanite_basic_team[1] = kyanite_basic_db[troop_id-1];	kyanite_cluster_team[1] = kyanite_cluster_db[troop_id-1];	damage_team[1] = damage_db[troop_id-1];	defense_team[1] = defense_db[troop_id-1];	hp_team[1] = hp_db[troop_id-1];	range_team[1] = range_db[troop_id-1];	speed_team[1] = speed_db[troop_id-1];	load_team[1] = load_db[troop_id-1];	cost_team[1] = cost_db[troop_id-1];	power_team[1] = power_db[troop_id-1];	};
        if (x == 3){	fuel_team[2] = fuel_db[troop_id-1];	food_team[2] = food_db[troop_id-1];	steel_team[2] = steel_db[troop_id-1];	alloy_team[2] = alloy_db[troop_id-1];	time_team[2] = time_db[troop_id-1];	kyanite_team[2] = kyanite_db[troop_id-1];	kyanite_basic_team[2] = kyanite_basic_db[troop_id-1];	kyanite_cluster_team[2] = kyanite_cluster_db[troop_id-1];	damage_team[2] = damage_db[troop_id-1];	defense_team[2] = defense_db[troop_id-1];	hp_team[2] = hp_db[troop_id-1];	range_team[2] = range_db[troop_id-1];	speed_team[2] = speed_db[troop_id-1];	load_team[2] = load_db[troop_id-1];	cost_team[2] = cost_db[troop_id-1];	power_team[2] = power_db[troop_id-1];	};
        if (x == 4){	fuel_team[3] = fuel_db[troop_id-1];	food_team[3] = food_db[troop_id-1];	steel_team[3] = steel_db[troop_id-1];	alloy_team[3] = alloy_db[troop_id-1];	time_team[3] = time_db[troop_id-1];	kyanite_team[3] = kyanite_db[troop_id-1];	kyanite_basic_team[3] = kyanite_basic_db[troop_id-1];	kyanite_cluster_team[3] = kyanite_cluster_db[troop_id-1];	damage_team[3] = damage_db[troop_id-1];	defense_team[3] = defense_db[troop_id-1];	hp_team[3] = hp_db[troop_id-1];	range_team[3] = range_db[troop_id-1];	speed_team[3] = speed_db[troop_id-1];	load_team[3] = load_db[troop_id-1];	cost_team[3] = cost_db[troop_id-1];	power_team[3] = power_db[troop_id-1];	};
        if (x == 5){	fuel_team[4] = fuel_db[troop_id-1];	food_team[4] = food_db[troop_id-1];	steel_team[4] = steel_db[troop_id-1];	alloy_team[4] = alloy_db[troop_id-1];	time_team[4] = time_db[troop_id-1];	kyanite_team[4] = kyanite_db[troop_id-1];	kyanite_basic_team[4] = kyanite_basic_db[troop_id-1];	kyanite_cluster_team[4] = kyanite_cluster_db[troop_id-1];	damage_team[4] = damage_db[troop_id-1];	defense_team[4] = defense_db[troop_id-1];	hp_team[4] = hp_db[troop_id-1];	range_team[4] = range_db[troop_id-1];	speed_team[4] = speed_db[troop_id-1];	load_team[4] = load_db[troop_id-1];	cost_team[4] = cost_db[troop_id-1];	power_team[4] = power_db[troop_id-1];	};
        if (x == 6){	fuel_team[5] = fuel_db[troop_id-1];	food_team[5] = food_db[troop_id-1];	steel_team[5] = steel_db[troop_id-1];	alloy_team[5] = alloy_db[troop_id-1];	time_team[5] = time_db[troop_id-1];	kyanite_team[5] = kyanite_db[troop_id-1];	kyanite_basic_team[5] = kyanite_basic_db[troop_id-1];	kyanite_cluster_team[5] = kyanite_cluster_db[troop_id-1];	damage_team[5] = damage_db[troop_id-1];	defense_team[5] = defense_db[troop_id-1];	hp_team[5] = hp_db[troop_id-1];	range_team[5] = range_db[troop_id-1];	speed_team[5] = speed_db[troop_id-1];	load_team[5] = load_db[troop_id-1];	cost_team[5] = cost_db[troop_id-1];	power_team[5] = power_db[troop_id-1];	};
        if (x == 7){	fuel_team[6] = fuel_db[troop_id-1];	food_team[6] = food_db[troop_id-1];	steel_team[6] = steel_db[troop_id-1];	alloy_team[6] = alloy_db[troop_id-1];	time_team[6] = time_db[troop_id-1];	kyanite_team[6] = kyanite_db[troop_id-1];	kyanite_basic_team[6] = kyanite_basic_db[troop_id-1];	kyanite_cluster_team[6] = kyanite_cluster_db[troop_id-1];	damage_team[6] = damage_db[troop_id-1];	defense_team[6] = defense_db[troop_id-1];	hp_team[6] = hp_db[troop_id-1];	range_team[6] = range_db[troop_id-1];	speed_team[6] = speed_db[troop_id-1];	load_team[6] = load_db[troop_id-1];	cost_team[6] = cost_db[troop_id-1];	power_team[6] = power_db[troop_id-1];	};
        if (x == 8){	fuel_team[7] = fuel_db[troop_id-1];	food_team[7] = food_db[troop_id-1];	steel_team[7] = steel_db[troop_id-1];	alloy_team[7] = alloy_db[troop_id-1];	time_team[7] = time_db[troop_id-1];	kyanite_team[7] = kyanite_db[troop_id-1];	kyanite_basic_team[7] = kyanite_basic_db[troop_id-1];	kyanite_cluster_team[7] = kyanite_cluster_db[troop_id-1];	damage_team[7] = damage_db[troop_id-1];	defense_team[7] = defense_db[troop_id-1];	hp_team[7] = hp_db[troop_id-1];	range_team[7] = range_db[troop_id-1];	speed_team[7] = speed_db[troop_id-1];	load_team[7] = load_db[troop_id-1];	cost_team[7] = cost_db[troop_id-1];	power_team[7] = power_db[troop_id-1];	};
        if (x == 9){	fuel_team[8] = fuel_db[troop_id-1];	food_team[8] = food_db[troop_id-1];	steel_team[8] = steel_db[troop_id-1];	alloy_team[8] = alloy_db[troop_id-1];	time_team[8] = time_db[troop_id-1];	kyanite_team[8] = kyanite_db[troop_id-1];	kyanite_basic_team[8] = kyanite_basic_db[troop_id-1];	kyanite_cluster_team[8] = kyanite_cluster_db[troop_id-1];	damage_team[8] = damage_db[troop_id-1];	defense_team[8] = defense_db[troop_id-1];	hp_team[8] = hp_db[troop_id-1];	range_team[8] = range_db[troop_id-1];	speed_team[8] = speed_db[troop_id-1];	load_team[8] = load_db[troop_id-1];	cost_team[8] = cost_db[troop_id-1];	power_team[8] = power_db[troop_id-1];	};
        if (x == 10){	fuel_team[9] = fuel_db[troop_id-1];	food_team[9] = food_db[troop_id-1];	steel_team[9] = steel_db[troop_id-1];	alloy_team[9] = alloy_db[troop_id-1];	time_team[9] = time_db[troop_id-1];	kyanite_team[9] = kyanite_db[troop_id-1];	kyanite_basic_team[9] = kyanite_basic_db[troop_id-1];	kyanite_cluster_team[9] = kyanite_cluster_db[troop_id-1];	damage_team[9] = damage_db[troop_id-1];	defense_team[9] = defense_db[troop_id-1];	hp_team[9] = hp_db[troop_id-1];	range_team[9] = range_db[troop_id-1];	speed_team[9] = speed_db[troop_id-1];	load_team[9] = load_db[troop_id-1];	cost_team[9] = cost_db[troop_id-1];	power_team[9] = power_db[troop_id-1];	};


    }

    private void new_init() {
        team01_et	 =findViewById(R.id.	team_count1);
        team02_et	 =findViewById(R.id.	team_count2);
        team03_et	 =findViewById(R.id.	team_count3);
        team04_et	 =findViewById(R.id.	team_count4);
        team05_et	 =findViewById(R.id.	team_count5);
        team06_et	 =findViewById(R.id.	team_count6);
        team07_et	 =findViewById(R.id.	team_count7);
        team08_et	 =findViewById(R.id.	team_count8);
        team09_et	 =findViewById(R.id.	team_count9);
        team10_et	 =findViewById(R.id.	team_count10);

        team01_img	 =findViewById(R.id.	team_img1);
        team02_img	 =findViewById(R.id.	team_img2);
        team03_img	 =findViewById(R.id.	team_img3);
        team04_img	 =findViewById(R.id.	team_img4);
        team05_img	 =findViewById(R.id.	team_img5);
        team06_img	 =findViewById(R.id.	team_img6);
        team07_img	 =findViewById(R.id.	team_img7);
        team08_img	 =findViewById(R.id.	team_img8);
        team09_img	 =findViewById(R.id.	team_img9);
        team10_img	 =findViewById(R.id.	team_img10);

        team01_tv	 =findViewById(R.id.	team_name1);
        team02_tv	 =findViewById(R.id.	team_name2);
        team03_tv	 =findViewById(R.id.	team_name3);
        team04_tv	 =findViewById(R.id.	team_name4);
        team05_tv	 =findViewById(R.id.	team_name5);
        team06_tv	 =findViewById(R.id.	team_name6);
        team07_tv	 =findViewById(R.id.	team_name7);
        team08_tv	 =findViewById(R.id.	team_name8);
        team09_tv	 =findViewById(R.id.	team_name9);
        team10_tv	 =findViewById(R.id.	team_name10);

        team01_card	 =findViewById(R.id.	team_card1);
        team02_card	 =findViewById(R.id.	team_card2);
        team03_card	 =findViewById(R.id.	team_card3);
        team04_card	 =findViewById(R.id.	team_card4);
        team05_card	 =findViewById(R.id.	team_card5);
        team06_card	 =findViewById(R.id.	team_card6);
        team07_card	 =findViewById(R.id.	team_card7);
        team08_card	 =findViewById(R.id.	team_card8);
        team09_card	 =findViewById(R.id.	team_card9);
        team10_card	 =findViewById(R.id.	team_card10);

        team01_et.setText("0");
        team02_et.setText("0");
        team03_et.setText("0");
        team04_et.setText("0");
        team05_et.setText("0");
        team06_et.setText("0");
        team07_et.setText("0");
        team08_et.setText("0");
        team09_et.setText("0");
        team10_et.setText("0");

    }

    public void cal_back(View view){
        ConstraintLayout train_cal = findViewById(R.id.train_ui);
        LinearLayout team_list = findViewById(R.id.team_list);
        LinearLayout buff_list = findViewById(R.id.buff_list);
        RecyclerView train_list = findViewById(R.id.train_list);
        train_cal.setVisibility(View.VISIBLE);
        team_list.setVisibility(View.VISIBLE);
        train_list.setVisibility(View.GONE);
        buff_list.setVisibility(View.GONE);
        troop_calcalate();
    }

    public void dataRefresh(View view) {
        wifi(1);
    }
    public void BackgroundReload (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.troop_bg);

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

    public void input_data() {
        SharedPreferences sharedPreferences = getSharedPreferences("json_data", Context.MODE_PRIVATE);
        troopTotal = armyCountNumArray;
        troopOut = armyMarchNumArray;
        troopIn = armyFreeNumArray;
    }

    public void troop_calcalate (){
        fuel = food  = alloy = steel = kyanite = kyanite_basic = kyanite_cluster = load = 0;
        power = cost = 0;
        total = time= 0 ;

        long d = 0;
        long h = 0;
        long m = 2;
        long s = 40;

        if (String.valueOf(buff01.getText()) != null && !String.valueOf(buff01.getText()).equals("") && String.valueOf(buff01.getText()) != "0"){count_t = Long.parseLong(String.valueOf(buff01.getText()));}else{buff01.setText("10");count_t = Long.parseLong(String.valueOf(buff01.getText()));}
        if (String.valueOf(day.getText()) != null && !String.valueOf(day.getText()).equals("")){d = Long.parseLong(String.valueOf(day.getText()));}else{day.setText("0");d = Long.parseLong(String.valueOf(day.getText()));}
        if (String.valueOf(hour.getText()) != null && !String.valueOf(hour.getText()).equals("")){h = Long.parseLong(String.valueOf(hour.getText()));}else{hour.setText("0");h = Long.parseLong(String.valueOf(hour.getText()));}
        if (String.valueOf(min.getText()) != null && !String.valueOf(min.getText()).equals("")){m = Long.parseLong(String.valueOf(min.getText()));}else{min.setText("0");m = Long.parseLong(String.valueOf(min.getText()));}
        if (String.valueOf(sec.getText()) != null && !String.valueOf(sec.getText()).equals("")){s = Long.parseLong(String.valueOf(sec.getText()));}else{sec.setText("0");s = Long.parseLong(String.valueOf(sec.getText()));}

        if(team01_et.getText().toString().matches(""))	{team01_et.setText(	"0");}
        if(team02_et.getText().toString().matches(""))	{team02_et.setText(	"0");}
        if(team03_et.getText().toString().matches(""))	{team03_et.setText(	"0");}
        if(team04_et.getText().toString().matches(""))	{team04_et.setText(	"0");}
        if(team05_et.getText().toString().matches(""))	{team05_et.setText(	"0");}
        if(team06_et.getText().toString().matches(""))	{team06_et.setText(	"0");}
        if(team07_et.getText().toString().matches(""))	{team07_et.setText(	"0");}
        if(team08_et.getText().toString().matches(""))	{team08_et.setText(	"0");}
        if(team09_et.getText().toString().matches(""))	{team09_et.setText(	"0");}
        if(team10_et.getText().toString().matches(""))	{team10_et.setText(	"0");}

        long team01,	team02,	team03,	team04,	team05,	team06,	team07,	team08,	team09,	team10 = 0;

        team01 = Long.parseLong(team01_et.getText().toString());
        team02 = Long.parseLong(team02_et.getText().toString());
        team03 = Long.parseLong(team03_et.getText().toString());
        team04 = Long.parseLong(team04_et.getText().toString());
        team05 = Long.parseLong(team05_et.getText().toString());
        team06 = Long.parseLong(team06_et.getText().toString());
        team07 = Long.parseLong(team07_et.getText().toString());
        team08 = Long.parseLong(team08_et.getText().toString());
        team09 = Long.parseLong(team09_et.getText().toString());
        team10 = Long.parseLong(team10_et.getText().toString());

        fuel	=	fuel_team[0]	 * team01+	fuel_team[1]	 * team02+	fuel_team[2]	 * team03+	fuel_team[3]	 * team04+	fuel_team[4]	 * team05+	fuel_team[5]	 * team06+	fuel_team[6]	 * team07+	fuel_team[7]	 * team08+	fuel_team[8]	 * team09+	fuel_team[9]	 * team10;
        food	=	food_team[0]	 * team01+	food_team[1]	 * team02+	food_team[2]	 * team03+	food_team[3]	 * team04+	food_team[4]	 * team05+	food_team[5]	 * team06+	food_team[6]	 * team07+	food_team[7]	 * team08+	food_team[8]	 * team09+	food_team[9]	 * team10;
        steel	=	steel_team[0]	 * team01+	steel_team[1]	 * team02+	steel_team[2]	 * team03+	steel_team[3]	 * team04+	steel_team[4]	 * team05+	steel_team[5]	 * team06+	steel_team[6]	 * team07+	steel_team[7]	 * team08+	steel_team[8]	 * team09+	steel_team[9]	 * team10;
        alloy	=	alloy_team[0]	 * team01+	alloy_team[1]	 * team02+	alloy_team[2]	 * team03+	alloy_team[3]	 * team04+	alloy_team[4]	 * team05+	alloy_team[5]	 * team06+	alloy_team[6]	 * team07+	alloy_team[7]	 * team08+	alloy_team[8]	 * team09+	alloy_team[9]	 * team10;
        time	=	time_team[0]	 * team01+	time_team[1]	 * team02+	time_team[2]	 * team03+	time_team[3]	 * team04+	time_team[4]	 * team05+	time_team[5]	 * team06+	time_team[6]	 * team07+	time_team[7]	 * team08+	time_team[8]	 * team09+	time_team[9]	 * team10;
        kyanite	=	kyanite_team[0]	 * team01+	kyanite_team[1]	 * team02+	kyanite_team[2]	 * team03+	kyanite_team[3]	 * team04+	kyanite_team[4]	 * team05+	kyanite_team[5]	 * team06+	kyanite_team[6]	 * team07+	kyanite_team[7]	 * team08+	kyanite_team[8]	 * team09+	kyanite_team[9]	 * team10;
        kyanite_basic	=	kyanite_basic_team[0]	 * team01+	kyanite_basic_team[1]	 * team02+	kyanite_basic_team[2]	 * team03+	kyanite_basic_team[3]	 * team04+	kyanite_basic_team[4]	 * team05+	kyanite_basic_team[5]	 * team06+	kyanite_basic_team[6]	 * team07+	kyanite_basic_team[7]	 * team08+	kyanite_basic_team[8]	 * team09+	kyanite_basic_team[9]	 * team10;
        kyanite_cluster	=	kyanite_cluster_team[0]	 * team01+	kyanite_cluster_team[1]	 * team02+	kyanite_cluster_team[2]	 * team03+	kyanite_cluster_team[3]	 * team04+	kyanite_cluster_team[4]	 * team05+	kyanite_cluster_team[5]	 * team06+	kyanite_cluster_team[6]	 * team07+	kyanite_cluster_team[7]	 * team08+	kyanite_cluster_team[8]	 * team09+	kyanite_cluster_team[9]	 * team10;
        damage	=	damage_team[0]	 * team01+	damage_team[1]	 * team02+	damage_team[2]	 * team03+	damage_team[3]	 * team04+	damage_team[4]	 * team05+	damage_team[5]	 * team06+	damage_team[6]	 * team07+	damage_team[7]	 * team08+	damage_team[8]	 * team09+	damage_team[9]	 * team10;
        defense	=	defense_team[0]	 * team01+	defense_team[1]	 * team02+	defense_team[2]	 * team03+	defense_team[3]	 * team04+	defense_team[4]	 * team05+	defense_team[5]	 * team06+	defense_team[6]	 * team07+	defense_team[7]	 * team08+	defense_team[8]	 * team09+	defense_team[9]	 * team10;
        hp	=	hp_team[0]	 * team01+	hp_team[1]	 * team02+	hp_team[2]	 * team03+	hp_team[3]	 * team04+	hp_team[4]	 * team05+	hp_team[5]	 * team06+	hp_team[6]	 * team07+	hp_team[7]	 * team08+	hp_team[8]	 * team09+	hp_team[9]	 * team10;
        range	=	range_team[0]	 * team01+	range_team[1]	 * team02+	range_team[2]	 * team03+	range_team[3]	 * team04+	range_team[4]	 * team05+	range_team[5]	 * team06+	range_team[6]	 * team07+	range_team[7]	 * team08+	range_team[8]	 * team09+	range_team[9]	 * team10;
        speed	=	speed_team[0]	 * team01+	speed_team[1]	 * team02+	speed_team[2]	 * team03+	speed_team[3]	 * team04+	speed_team[4]	 * team05+	speed_team[5]	 * team06+	speed_team[6]	 * team07+	speed_team[7]	 * team08+	speed_team[8]	 * team09+	speed_team[9]	 * team10;
        load	=	load_team[0]	 * team01+	load_team[1]	 * team02+	load_team[2]	 * team03+	load_team[3]	 * team04+	load_team[4]	 * team05+	load_team[5]	 * team06+	load_team[6]	 * team07+	load_team[7]	 * team08+	load_team[8]	 * team09+	load_team[9]	 * team10;
        cost	=	cost_team[0]	 * team01+	cost_team[1]	 * team02+	cost_team[2]	 * team03+	cost_team[3]	 * team04+	cost_team[4]	 * team05+	cost_team[5]	 * team06+	cost_team[6]	 * team07+	cost_team[7]	 * team08+	cost_team[8]	 * team09+	cost_team[9]	 * team10;
        power	=	power_team[0]	 * team01+	power_team[1]	 * team02+	power_team[2]	 * team03+	power_team[3]	 * team04+	power_team[4]	 * team05+	power_team[5]	 * team06+	power_team[6]	 * team07+	power_team[7]	 * team08+	power_team[8]	 * team09+	power_team[9]	 * team10;

        total = team01+	team02+	team03+	team04+	team05+	team06+	team07+	team08+	team09+	team10;

        String Fuel_String = null, Food_String= null , Steel_String = null, Alloy_String= null , Time_String = null, Kyanite_String = null, Kyanite_basic_String = null, Kyanite_cluster_String = null, Cost_String = null, Power_String = null, Load_String = null, Total_String = null;
        String beta = String.valueOf(buff02.getText());
        String chalie = String.valueOf(buff03.getText());

        long time2 = (d * 86400) + (h * 3600) + m * 60 + s;

        DecimalFormat df = new DecimalFormat("#.#####");
        long final_buff = time2*1000000000/(count_l*count_t);

        Log.i("count_l", String.valueOf(count_l));
        Log.i("count_t", String.valueOf(count_t));
        Log.i("time2", String.valueOf(time2));
        Log.i("FINAL_BUFF", String.valueOf(final_buff));

        /*String alpha = String.valueOf(buff01.getText());
        if (!alpha.equals("")){
            int time_b = Integer.parseInt(alpha);
            time = time/(100-time_b)*100;
            Log.i("DATA_FINAL TIMEB", String.valueOf(time_b)); }
         */
        if (!beta.equals("")){
            int load_b = Integer.parseInt(beta)+100;
            load = load*load_b/100;
        }else {buff02.setText("0");}

        if (!chalie.equals("")){
            int rss_b = Integer.parseInt(chalie);
            if (rss_b > 99){buff03.setText("99");chalie = String.valueOf(buff03.getText());rss_b = Integer.parseInt(chalie);}
            fuel = fuel;
            food = food;
            steel = steel;
            alloy = alloy;
            kyanite = kyanite;
            kyanite_basic = kyanite_basic;
            kyanite_cluster = kyanite_cluster;
            fuel = fuel*(100-rss_b)/100;
            food = food*(100-rss_b)/100;
            steel = steel*(100-rss_b)/100;
            alloy = alloy*(100-rss_b)/100;
            kyanite = kyanite*(100-rss_b)/100;
            kyanite_basic = kyanite_basic*(100-rss_b)/100;
            kyanite_cluster = kyanite_cluster*(100-rss_b)/100;

        }else {buff03.setText("0");}
        DecimalFormat formatter1 = new DecimalFormat("###,###,###,###,###,###");
        Fuel_String = formatter1.format(fuel);


        DecimalFormat formatter2 = new DecimalFormat("###,###,###,###,###,###");
        Food_String = formatter2.format(food);

        DecimalFormat formatter3 = new DecimalFormat("###,###,###,###,###,###");
        Steel_String = formatter3.format(steel);

        DecimalFormat formatter4 = new DecimalFormat("###,###,###,###,###,###");
        Alloy_String = formatter4.format(alloy);

        DecimalFormat formatter5 = new DecimalFormat("###,###,###,###,###,###");
        Kyanite_String = formatter5.format(kyanite);

        DecimalFormat formatter6 = new DecimalFormat("###,###,###,###,###,###");
        Kyanite_basic_String = formatter6.format(kyanite_basic);

        DecimalFormat formatter7 = new DecimalFormat("###,###,###,###,###,###");
        Kyanite_cluster_String = formatter7.format(kyanite_cluster);

        DecimalFormat formatter8 = new DecimalFormat("###,###,###,###,###,###");
        int power2 = (int) power;
        Power_String = formatter8.format(power2);

        DecimalFormat formatter9 = new DecimalFormat("###,###,###,###,###,###");
        Cost_String = formatter9.format(cost);

        DecimalFormat formatterA = new DecimalFormat("###,###,###,###,###,###");
        Load_String = formatterA.format(load);

        DecimalFormat formatterB = new DecimalFormat("###,###,###,###,###,###");
        Total_String = formatterB.format(total);

        long time3 = (long) (time*final_buff)/1000000000;
        if (time3>0 ){time3 = time3+1;}
        Log.i("time3", String.valueOf(time3));
        time = time3;
        //TIME
        if (time >0){
            long days = time / 86400;
            long hours = time / 3600;
            long minutes = (time % 3600) / 60;
            long seconds = time % 60;

            if(days<1){Time_String = String.format("%02d:%02d:%02d", hours, minutes, seconds);}else {Time_String = String.format("%02dd , %02d:%02d:%02d", days , hours, minutes, seconds);}
        }
        fuel_tv.setText(prettyCount(fuel));
        food_tv.setText(prettyCount(food));
        steel_tv.setText(prettyCount(steel));
        alloy_tv.setText(prettyCount(alloy));
        time_tv.setText(Time_String);
        kyanite_tv.setText(prettyCount(kyanite));
        kyanite_basic_tv.setText(prettyCount(kyanite_basic));
        kyanite_cluster_tv.setText(prettyCount(kyanite_cluster));
        power_tv.setText(prettyCount(power));
        load_tv.setText(prettyCount(load));
        cost_tv.setText(prettyCount(cost) + " /h");
        total_tv.setText(getString(R.string.troop_total)+" "+prettyCount(total));


        Log.i("FUEL", prettyCount(fuel));

        if (time_tv.getText() == ""){time_tv.setText("00:00:00");}


        /**
         * Method INT TO TXT (DONE)
         */
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

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //添加数据 - New version put into json file -> 索引put in Sharepre -> "AA_XPRT_BB_XPRT_CC" <- _XPRT_ is use to 分格

        /**
         * {
         *   "team01" : {"armyId":0,"armyCount":100},
         *   "team02" : {"armyId":0,"armyCount":100}
         *   ...
         * }
         */
        editor.putLong("buff01", Long.parseLong(String.valueOf(buff01.getText())));
        editor.putLong("buff02", Long.parseLong(String.valueOf(buff02.getText())));
        editor.putLong("buff03", Long.parseLong(String.valueOf(buff03.getText())));
        editor.putLong("D", Long.parseLong(String.valueOf(day.getText())));
        editor.putLong("H", Long.parseLong(String.valueOf(hour.getText())));
        editor.putLong("M", Long.parseLong(String.valueOf(min.getText())));
        editor.putLong("S", Long.parseLong(String.valueOf(sec.getText())));
        editor.putLong("count_l", count_l);
        editor.putLong("count_t", count_t);
        editor.putInt("troop_id_act", troop_id);
        editor.apply();
        save();
        //preferencesRefresh();

    }
    public void onKE (View view){
        // troop_train_pts = {1,2,4,7,13,21,33,49,70,97};
        wifi(2);
    }

    public void clean (View view){
        team01_et.setText("0");
        team02_et.setText("0");
        team03_et.setText("0");
        team04_et.setText("0");
        team05_et.setText("0");
        team06_et.setText("0");
        team07_et.setText("0");
        team08_et.setText("0");
        team09_et.setText("0");
        team10_et.setText("0");
        team01_img.setImageResource(R.drawable.blank_box);
        team02_img.setImageResource(R.drawable.blank_box);
        team03_img.setImageResource(R.drawable.blank_box);
        team04_img.setImageResource(R.drawable.blank_box);
        team05_img.setImageResource(R.drawable.blank_box);
        team06_img.setImageResource(R.drawable.blank_box);
        team07_img.setImageResource(R.drawable.blank_box);
        team08_img.setImageResource(R.drawable.blank_box);
        team09_img.setImageResource(R.drawable.blank_box);
        team10_img.setImageResource(R.drawable.blank_box);
        team01_tv.setText(getString(R.string.choose_troops));
        team02_tv.setText(getString(R.string.choose_troops));
        team03_tv.setText(getString(R.string.choose_troops));
        team04_tv.setText(getString(R.string.choose_troops));
        team05_tv.setText(getString(R.string.choose_troops));
        team06_tv.setText(getString(R.string.choose_troops));
        team07_tv.setText(getString(R.string.choose_troops));
        team08_tv.setText(getString(R.string.choose_troops));
        team09_tv.setText(getString(R.string.choose_troops));
        team10_tv.setText(getString(R.string.choose_troops));
        team02_card.setVisibility(View.GONE);
        team03_card.setVisibility(View.GONE);
        team04_card.setVisibility(View.GONE);
        team05_card.setVisibility(View.GONE);
        team06_card.setVisibility(View.GONE);
        team07_card.setVisibility(View.GONE);
        team08_card.setVisibility(View.GONE);
        team09_card.setVisibility(View.GONE);
        team10_card.setVisibility(View.GONE);
        team01_et.setVisibility(View.GONE);
        team02_et.setVisibility(View.GONE);
        team03_et.setVisibility(View.GONE);
        team04_et.setVisibility(View.GONE);
        team05_et.setVisibility(View.GONE);
        team06_et.setVisibility(View.GONE);
        team07_et.setVisibility(View.GONE);
        team08_et.setVisibility(View.GONE);
        team09_et.setVisibility(View.GONE);
        team10_et.setVisibility(View.GONE);
        troop_id = -1;
    }

    public void onBuff(View view) {
        LinearLayout team_list = findViewById(R.id.team_list);
        LinearLayout buff_list = findViewById(R.id.buff_list);
        team_list.setVisibility(View.GONE);
        buff_list.setVisibility(View.VISIBLE);
        troop_calcalate();
    }
    public void troop_choose (View view){
        final Dialog dialog = new Dialog(this, R.style.NormalDialogStyle_N);
        view = View.inflate(this, R.layout.troop_choose, null);

        ImageView	arm01	 = view.findViewById(R.id.	h_arm01)	;
        ImageView	arm02	 = view.findViewById(R.id.	h_arm02)	;
        ImageView	arm03	 = view.findViewById(R.id.	h_arm03)	;
        ImageView	arm04	 = view.findViewById(R.id.	h_arm04)	;
        ImageView	arm05	 = view.findViewById(R.id.	h_arm05)	;
        ImageView	arm06	 = view.findViewById(R.id.	h_arm06)	;
        ImageView	arm07	 = view.findViewById(R.id.	h_arm07)	;
        ImageView	arm08	 = view.findViewById(R.id.	h_arm08)	;
        ImageView	arm09	 = view.findViewById(R.id.	h_arm09)	;
        ImageView	arm10	 = view.findViewById(R.id.	h_arm10)	;
        ImageView	mili01	 = view.findViewById(R.id.	h_mili01)	;
        ImageView	mili02	 = view.findViewById(R.id.	h_mili02)	;
        ImageView	mili03	 = view.findViewById(R.id.	h_mili03)	;
        ImageView	mili04	 = view.findViewById(R.id.	h_mili04)	;
        ImageView	mili05	 = view.findViewById(R.id.	h_mili05)	;
        ImageView	mili06	 = view.findViewById(R.id.	h_mili06)	;
        ImageView	mili07	 = view.findViewById(R.id.	h_mili07)	;
        ImageView	mili08	 = view.findViewById(R.id.	h_mili08)	;
        ImageView	mili09	 = view.findViewById(R.id.	h_mili09)	;
        ImageView	mili10	 = view.findViewById(R.id.	h_mili10)	;
        ImageView	mobile01	 = view.findViewById(R.id.	h_mobile01)	;
        ImageView	mobile02	 = view.findViewById(R.id.	h_mobile02)	;
        ImageView	mobile03	 = view.findViewById(R.id.	h_mobile03)	;
        ImageView	mobile04	 = view.findViewById(R.id.	h_mobile04)	;
        ImageView	mobile05	 = view.findViewById(R.id.	h_mobile05)	;
        ImageView	mobile06	 = view.findViewById(R.id.	h_mobile06)	;
        ImageView	mobile07	 = view.findViewById(R.id.	h_mobile07)	;
        ImageView	mobile08	 = view.findViewById(R.id.	h_mobile08)	;
        ImageView	mobile09	 = view.findViewById(R.id.	h_mobile09)	;
        ImageView	mobile10	 = view.findViewById(R.id.	h_mobile10)	;
        ImageView	infect01	 = view.findViewById(R.id.	h_infect01)	;
        ImageView	infect02	 = view.findViewById(R.id.	h_infect02)	;
        ImageView	infect03	 = view.findViewById(R.id.	h_infect03)	;
        ImageView	infect04	 = view.findViewById(R.id.	h_infect04)	;
        ImageView	infect05	 = view.findViewById(R.id.	h_infect05)	;
        ImageView	infect06	 = view.findViewById(R.id.	h_infect06)	;
        ImageView	infect07	 = view.findViewById(R.id.	h_infect07)	;
        ImageView	infect08	 = view.findViewById(R.id.	h_infect08)	;
        ImageView	infect09	 = view.findViewById(R.id.	h_infect09)	;
        ImageView	infect10	 = view.findViewById(R.id.	h_infect10)	;
        ImageView	project01	 = view.findViewById(R.id.	h_project01)	;
        ImageView	project02	 = view.findViewById(R.id.	h_project02)	;
        ImageView	project03	 = view.findViewById(R.id.	h_project03)	;
        ImageView	project04	 = view.findViewById(R.id.	h_project04)	;
        ImageView	project05	 = view.findViewById(R.id.	h_project05)	;
        ImageView	project06	 = view.findViewById(R.id.	h_project06)	;
        ImageView	project07	 = view.findViewById(R.id.	h_project07)	;
        ImageView	project08	 = view.findViewById(R.id.	h_project08)	;
        ImageView	project09	 = view.findViewById(R.id.	h_project09)	;
        ImageView	project10	 = view.findViewById(R.id.	h_project10)	;
        ImageView troop_choose = findViewById(R.id.troop_choose);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        //view.setMinimumHeight((int) (ScreenSizeUtils.getInstance(this).getScreenHeight()));
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int) (ScreenSizeUtils.getInstance(this).getScreenWidth()*0.8);
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);
        dialog.show();

        arm01.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[20];troop_choose.setImageResource(R.drawable.h_arm01);troop_id = 1;}});
        arm02.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[21];troop_choose.setImageResource(R.drawable.h_arm02);troop_id = 2;}});
        arm03.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[22];troop_choose.setImageResource(R.drawable.h_arm03);troop_id = 3;}});
        arm04.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[23];troop_choose.setImageResource(R.drawable.h_arm04);troop_id = 4;}});
        arm05.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[24];troop_choose.setImageResource(R.drawable.h_arm05);troop_id = 5;}});
        arm06.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[25];troop_choose.setImageResource(R.drawable.h_arm06);troop_id = 6;}});
        arm07.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[26];troop_choose.setImageResource(R.drawable.h_arm07);troop_id = 7;}});
        arm08.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[27];troop_choose.setImageResource(R.drawable.h_arm08);troop_id = 8;}});
        arm09.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[28];troop_choose.setImageResource(R.drawable.h_arm09);troop_id = 9;}});
        arm10.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[29];troop_choose.setImageResource(R.drawable.h_arm10);troop_id = 10;}});
        mili01.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[0];troop_choose.setImageResource(R.drawable.h_mili01);troop_id = 11;}});
        mili02.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[1];troop_choose.setImageResource(R.drawable.h_mili02);troop_id = 12;}});
        mili03.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[2];troop_choose.setImageResource(R.drawable.h_mili03);troop_id = 13;}});
        mili04.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[3];troop_choose.setImageResource(R.drawable.h_mili04);troop_id = 14;}});
        mili05.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[4];troop_choose.setImageResource(R.drawable.h_mili05);troop_id = 15;}});
        mili06.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[5];troop_choose.setImageResource(R.drawable.h_mili06);troop_id = 16;}});
        mili07.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[6];troop_choose.setImageResource(R.drawable.h_mili07);troop_id = 17;}});
        mili08.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[7];troop_choose.setImageResource(R.drawable.h_mili08);troop_id = 18;}});
        mili09.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[8];troop_choose.setImageResource(R.drawable.h_mili09);troop_id = 19;}});
        mili10.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[9];troop_choose.setImageResource(R.drawable.h_mili10);troop_id = 20;}});
        mobile01.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[10];troop_choose.setImageResource(R.drawable.h_mobile01);troop_id = 21;}});
        mobile02.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[11];troop_choose.setImageResource(R.drawable.h_mobile02);troop_id = 22;}});
        mobile03.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[12];troop_choose.setImageResource(R.drawable.h_mobile03);troop_id = 23;}});
        mobile04.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[13];troop_choose.setImageResource(R.drawable.h_mobile04);troop_id = 24;}});
        mobile05.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[14];troop_choose.setImageResource(R.drawable.h_mobile05);troop_id = 25;}});
        mobile06.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[15];troop_choose.setImageResource(R.drawable.h_mobile06);troop_id = 26;}});
        mobile07.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[16];troop_choose.setImageResource(R.drawable.h_mobile07);troop_id = 27;}});
        mobile08.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[17];troop_choose.setImageResource(R.drawable.h_mobile08);troop_id = 28;}});
        mobile09.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[18];troop_choose.setImageResource(R.drawable.h_mobile09);troop_id = 29;}});
        mobile10.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[19];troop_choose.setImageResource(R.drawable.h_mobile10);troop_id = 30;}});
        infect01.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[30];troop_choose.setImageResource(R.drawable.h_infect01);troop_id = 31;}});
        infect02.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[31];troop_choose.setImageResource(R.drawable.h_infect02);troop_id = 32;}});
        infect03.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[32];troop_choose.setImageResource(R.drawable.h_infect03);troop_id = 33;}});
        infect04.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[33];troop_choose.setImageResource(R.drawable.h_infect04);troop_id = 34;}});
        infect05.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[34];troop_choose.setImageResource(R.drawable.h_infect05);troop_id = 35;}});
        infect06.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[35];troop_choose.setImageResource(R.drawable.h_infect06);troop_id = 36;}});
        infect07.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[36];troop_choose.setImageResource(R.drawable.h_infect07);troop_id = 37;}});
        infect08.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[37];troop_choose.setImageResource(R.drawable.h_infect08);troop_id = 38;}});
        infect09.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[38];troop_choose.setImageResource(R.drawable.h_infect09);troop_id = 39;}});
        infect10.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[39];troop_choose.setImageResource(R.drawable.h_infect10);troop_id = 40;}});
        project01.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[40];troop_choose.setImageResource(R.drawable.h_project01);troop_id = 41;}});
        project02.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[41];troop_choose.setImageResource(R.drawable.h_project02);troop_id = 42;}});
        project03.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[42];troop_choose.setImageResource(R.drawable.h_project03);troop_id = 43;}});
        project04.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[43];troop_choose.setImageResource(R.drawable.h_project04);troop_id = 44;}});
        project05.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[44];troop_choose.setImageResource(R.drawable.h_project05);troop_id = 45;}});
        project06.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[45];troop_choose.setImageResource(R.drawable.h_project06);troop_id = 46;}});
        project07.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[46];troop_choose.setImageResource(R.drawable.h_project07);troop_id = 47;}});
        project08.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[47];troop_choose.setImageResource(R.drawable.h_project08);troop_id = 48;}});
        project09.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[48];troop_choose.setImageResource(R.drawable.h_project09);troop_id = 49;}});
        project10.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();count_l = time_db[49];troop_choose.setImageResource(R.drawable.h_project10);troop_id = 50;}});


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
            // Depends URL
            SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
            uid = sharedPreferences.getLong("UID",0);
            verifyCode = sharedPreferences.getString("verifyCode","0");
            boolean input_json_list = sharedPreferences.getBoolean("input_json_list", true);
            url = "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid="+uid+"&psw="+verifyCode;
            Log.wtf("URL",url);
            jsonStr = sh.makeServiceCall(url);
            if (!jsonStr.equals("")) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    // Getting JSON Array node
                    if(jsonObj.has("armys")) {
                        JSONArray troops = jsonObj.getJSONArray("armys");
                        for (int i = 0; i < troops.length(); i++) {
                            JSONObject a = troops.getJSONObject(i);
                            armyFreeNum = a.getLong("armyFreeNum");
                            armyFreeNumArray[i] = armyFreeNum;
                            Log.wtf("TTT", "A"+String.valueOf(armyFreeNum));
                            Log.wtf("TTX", "A"+String.valueOf(armyFreeNumArray[i]));
                            armyMarchNum = a.getLong("armyMarchNum");
                            armyMarchNumArray[i] = armyMarchNum;
                            armyName = a.getString("armyName");
                            armyNameArray[i] = armyName;
                            armyCountNumArray[i]=armyMarchNum+armyFreeNum;
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

                    troopTotal = armyCountNumArray;
                    troopOut = armyMarchNumArray;
                    troopIn = armyFreeNumArray;

                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                }
            }


            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Log.i("TOTAL_GrabX","ok");
            finalZ();
        }
    }


    private void finalZ() {
        troop_calcalate();
        ConstraintLayout train_cal = findViewById(R.id.train_ui);
        RecyclerView train_list = findViewById(R.id.train_list);
        train_cal.setVisibility(View.GONE);
        train_list.setVisibility(View.VISIBLE);
        troopList.clear();

        for (int x = 0; x < 49 ; x++){
            Troops troops = new Troops();
            troops.setId(x);
            troops.setTotal(troopTotal[x]);
            troops.setIn_sch(troopIn[x]);
            troops.setOut_sch(troopOut[x]);
            Log.wtf("Troop","Id : "+String.valueOf(x)+" | Total : "+prettyCount(troopOut[x]));
            if (troopTotal[x] !=0){
                troopList.add(troops);}
        }
        ArrayList<Troops> filteredList = new ArrayList<>();
        for (Troops item : troopList) {
            item.getId();
            filteredList.add(item);
        }
        mAdapter.filterList(filteredList);
    }

    private void datalist_tips() {
        final Dialog dialog = new Dialog(this, R.style.NormalDialogStyle_N);
        View view = View.inflate(this, R.layout.datalist_post, null);

        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        //view.setMinimumHeight((int) (ScreenSizeUtils.getInstance(this).getScreenHeight()));
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int) (ScreenSizeUtils.getInstance(this).getScreenWidth()*0.8);
        lp.height = (int) (ScreenSizeUtils.getInstance(this).getScreenHeight()*0.8);
        lp.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);
        dialog.show();


    }

    public class HttpGetRequest extends AsyncTask<String, Void, String> {
        public static final String REQUEST_METHOD = "GET";
        public static final int READ_TIMEOUT = 500;
        public static final int CONNECTION_TIMEOUT = 500;
        @Override
        protected String doInBackground(String... params){
            String stringUrl = params[0];
            String result;
            int var;
            String inputLine;
            try {
                //Create a URL object holding our url
                URL myUrl = new URL(stringUrl);
                //Create a connection
                HttpURLConnection connection =(HttpURLConnection)
                        myUrl.openConnection();
                //Set methods and timeouts
                connection.setRequestMethod(REQUEST_METHOD);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setConnectTimeout(CONNECTION_TIMEOUT);

                //Connect to our url
                connection.connect();
                //Create a new InputStreamReader
                InputStreamReader streamReader = new
                        InputStreamReader(connection.getInputStream());
                //Create a new buffered reader and String Builder
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuilder stringBuilder = new StringBuilder();
                //Check if the line we are reading is not null
                while((inputLine = reader.readLine()) != null){
                    stringBuilder.append(inputLine);
                }
                //Close our InputStream and Buffered reader
                reader.close();
                streamReader.close();
                //Set our result equal to our stringBuilder
                result = stringBuilder.toString();

                String tempWord = "<html>" ;
                result = result.replaceAll(tempWord, "");
                tempWord = "<body>" ;
                result = result.replaceAll(tempWord, "");
                tempWord = "\n";
                result = result.replaceAll(tempWord, "");
                tempWord = "<!DOCTYPE html>";
                result = result.replaceAll(tempWord, "");
                tempWord = "</body>";
                result = result.replaceAll(tempWord, "");
                tempWord = "</html>";
                result = result.replaceAll(tempWord, "");
                tempWord = "<br/>";
                result = result.replaceAll(tempWord, "");
                tempWord = "\"";
                result = result.replaceAll(tempWord, "");
            }
            catch(IOException e){
                e.printStackTrace();
                result = null;
            }
            return result;
        }
        protected void onPostExecute(String result){
            super.onPostExecute(result);
        }
    }

    public void ask_type(){
        final String[] items = { "Wanna to get points","Wanna to increase power"};
        AlertDialog.Builder listDialog =
                new AlertDialog.Builder(NewTroopsActivity.this);
        listDialog.setTitle("Which u want");
        listDialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0){ KE_POINTS();}
                if (which == 1){ KE_POWER();}
            }
        });
        listDialog.show();
    }
    public void toSave(View view){
        save();
    }
    public void save(){
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPreferences = getSharedPreferences("user_info",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        long team01,	team02,	team03,	team04,	team05,	team06,	team07,	team08,	team09,	team10 = 0;

        team01 = Long.parseLong(team01_et.getText().toString());
        team02 = Long.parseLong(team02_et.getText().toString());
        team03 = Long.parseLong(team03_et.getText().toString());
        team04 = Long.parseLong(team04_et.getText().toString());
        team05 = Long.parseLong(team05_et.getText().toString());
        team06 = Long.parseLong(team06_et.getText().toString());
        team07 = Long.parseLong(team07_et.getText().toString());
        team08 = Long.parseLong(team08_et.getText().toString());
        team09 = Long.parseLong(team09_et.getText().toString());
        team10 = Long.parseLong(team10_et.getText().toString());

        int[] troop_ids = troop_idA;

        String file_content = "{"+"team01_id : "	 +troop_ids[0]+	","+"team01_c :"	 +team01+	","+"team02_id :"	 +troop_ids[1]+	","+"team02_c :"	 +team02+	","+"team03_id :"	 +troop_ids[2]+	","+"team03_c :"	 +team03+	","+"team04_id :"	 +troop_ids[3]+	","+"team04_c :"	 +team04+	","+"team05_id :"	 +troop_ids[4]+	","+"team05_c :"	 +team05+	","+"team06_id :"	 +troop_ids[5]+	","+"team06_c :"	 +team06+	","+"team07_id :"	 +troop_ids[6]+	","+"team07_c :"	 +team07+	","+"team08_id :"	 +troop_ids[7]+	","+"team08_c :"	 +team08+	","+"team09_id :"	 +troop_ids[8]+	","+"team09_c :"	 +team09+	","+"team10_id :"	 +troop_ids[9]+	","+"team10_c :"	 +team10+	"}" ;
        editor.putString("troops_shared",file_content);
        editor.apply();


    }

    public void Load() {
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String text = sharedPreferences.getString("troops_shared","{}");

        JSONObject result = null;
        try {
            result = new JSONObject(text);
            team_count[0] = result.getLong("team01_c");
            team_count[1] = result.getLong("team02_c");
            team_count[2] = result.getLong("team03_c");
            team_count[3] = result.getLong("team04_c");
            team_count[4] = result.getLong("team05_c");
            team_count[5] = result.getLong("team06_c");
            team_count[6] = result.getLong("team07_c");
            team_count[7] = result.getLong("team08_c");
            team_count[8] = result.getLong("team09_c");
            team_count[9] = result.getLong("team10_c");

            team_id[0] = result.getLong("team01_id");
            team_id[1] = result.getLong("team02_id");
            team_id[2] = result.getLong("team03_id");
            team_id[3] = result.getLong("team04_id");
            team_id[4] = result.getLong("team05_id");
            team_id[5] = result.getLong("team06_id");
            team_id[6] = result.getLong("team07_id");
            team_id[7] = result.getLong("team08_id");
            team_id[8] = result.getLong("team09_id");
            team_id[9] = result.getLong("team10_id");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int y = 0 ; y < 10 ; y++) {
            troop_idA[y] = (int) team_id[y];
        }
        if (team_id[0] != 0&& team_count[0] > 0){
            team01_card.setVisibility(View.VISIBLE);
            team01_et.setVisibility(View.VISIBLE);
            team01_img.setVisibility(View.VISIBLE);
            team01_tv.setVisibility(View.VISIBLE);
            team01_et.setText(String.valueOf(team_count[0]));
            team01_img.setImageResource(setIco(team_id[0]));
            team01_tv.setText(troopName[(int) team_id[0]]);
            team02_card.setVisibility(View.VISIBLE);
            team02_img.setVisibility(View.VISIBLE);
            team02_tv.setVisibility(View.VISIBLE);
        }
        if (team_id[1] != 0&& team_count[1] > 0){
            team02_card.setVisibility(View.VISIBLE);
            team02_et.setVisibility(View.VISIBLE);
            team02_img.setVisibility(View.VISIBLE);
            team02_tv.setVisibility(View.VISIBLE);
            team02_et.setText(String.valueOf(team_count[1]));
            team02_img.setImageResource(setIco(team_id[1]));
            team02_tv.setText(troopName[(int) team_id[1]]);
            team03_card.setVisibility(View.VISIBLE);
            team03_img.setVisibility(View.VISIBLE);
            team03_tv.setVisibility(View.VISIBLE);
        }
        if (team_id[2] != 0&& team_count[2] > 0){
            team03_card.setVisibility(View.VISIBLE);
            team03_et.setVisibility(View.VISIBLE);
            team03_img.setVisibility(View.VISIBLE);
            team03_tv.setVisibility(View.VISIBLE);
            team03_et.setText(String.valueOf(team_count[2]));
            team03_img.setImageResource(setIco(team_id[2]));
            team03_tv.setText(troopName[(int) team_id[2]]);
            team04_card.setVisibility(View.VISIBLE);
            team04_img.setVisibility(View.VISIBLE);
            team04_tv.setVisibility(View.VISIBLE);
        }
        if (team_id[3] != 0&& team_count[3] > 0){
            team04_card.setVisibility(View.VISIBLE);
            team04_et.setVisibility(View.VISIBLE);
            team04_img.setVisibility(View.VISIBLE);
            team04_tv.setVisibility(View.VISIBLE);
            team04_et.setText(String.valueOf(team_count[3]));
            team04_img.setImageResource(setIco(team_id[3]));
            team04_tv.setText(troopName[(int) team_id[3]]);
            team05_card.setVisibility(View.VISIBLE);
            team05_img.setVisibility(View.VISIBLE);
            team05_tv.setVisibility(View.VISIBLE);
        }
        if (team_id[4] != 0&& team_count[4] > 0){
            team05_card.setVisibility(View.VISIBLE);
            team05_et.setVisibility(View.VISIBLE);
            team05_img.setVisibility(View.VISIBLE);
            team05_tv.setVisibility(View.VISIBLE);
            team05_et.setText(String.valueOf(team_count[4]));
            team05_img.setImageResource(setIco(team_id[4]));
            team05_tv.setText(troopName[(int) team_id[4]]);
            team06_card.setVisibility(View.VISIBLE);
            team06_img.setVisibility(View.VISIBLE);
            team06_tv.setVisibility(View.VISIBLE);
        }
        if (team_id[5] != 0&& team_count[5] > 0){
            team06_card.setVisibility(View.VISIBLE);
            team06_et.setVisibility(View.VISIBLE);
            team06_img.setVisibility(View.VISIBLE);
            team06_tv.setVisibility(View.VISIBLE);
            team06_et.setText(String.valueOf(team_count[5]));
            team06_img.setImageResource(setIco(team_id[5]));
            team06_tv.setText(troopName[(int) team_id[5]]);
            team07_card.setVisibility(View.VISIBLE);
            team07_img.setVisibility(View.VISIBLE);
            team07_tv.setVisibility(View.VISIBLE);
        }
        if (team_id[6] != 0&& team_count[6] > 0){
            team06_card.setVisibility(View.VISIBLE);
            team07_et.setVisibility(View.VISIBLE);
            team07_img.setVisibility(View.VISIBLE);
            team07_tv.setVisibility(View.VISIBLE);
            team07_et.setText(String.valueOf(team_count[6]));
            team07_img.setImageResource(setIco(team_id[6]));
            team07_tv.setText(troopName[(int) team_id[6]]);
            team08_card.setVisibility(View.VISIBLE);
            team08_img.setVisibility(View.VISIBLE);
            team08_tv.setVisibility(View.VISIBLE);
        }
        if (team_id[7] != 0&& team_count[7] > 0){
            team08_card.setVisibility(View.VISIBLE);
            team08_et.setVisibility(View.VISIBLE);
            team08_img.setVisibility(View.VISIBLE);
            team08_tv.setVisibility(View.VISIBLE);
            team08_et.setText(String.valueOf(team_count[7]));
            team08_img.setImageResource(setIco(team_id[7]));
            team08_tv.setText(troopName[(int) team_id[7]]);
            team09_card.setVisibility(View.VISIBLE);
            team09_img.setVisibility(View.VISIBLE);
            team09_tv.setVisibility(View.VISIBLE);
        }
        if (team_id[8] != 0&& team_count[8] > 0){
            team08_card.setVisibility(View.VISIBLE);
            team08_et.setVisibility(View.VISIBLE);
            team08_img.setVisibility(View.VISIBLE);
            team08_tv.setVisibility(View.VISIBLE);
            team08_et.setText(String.valueOf(team_count[8]));
            team08_img.setImageResource(setIco(team_id[8]));
            team08_tv.setText(troopName[(int) team_id[8]]);
            team09_card.setVisibility(View.VISIBLE);
            team09_img.setVisibility(View.VISIBLE);
            team09_tv.setVisibility(View.VISIBLE);
        }
        if (team_id[9] != 0&& team_count[9] > 0){
            team10_card.setVisibility(View.VISIBLE);
            team10_et.setVisibility(View.VISIBLE);
            team10_img.setVisibility(View.VISIBLE);
            team10_tv.setVisibility(View.VISIBLE);
            team10_et.setText(String.valueOf(team_count[9]));
            team10_img.setImageResource(setIco(team_id[9]));
            team10_tv.setText(troopName[(int) team_id[9]]);
        }
        fuel_team[0]   = fuel_db[troop_idA[0]]; food_team[0]   = food_db[troop_idA[0]]; steel_team[0]   = steel_db[troop_idA[0]]; alloy_team[0]   = alloy_db[troop_idA[0]]; time_team[0]   = time_db[troop_idA[0]]; kyanite_team[0]   = kyanite_db[troop_idA[0]]; kyanite_basic_team[0]   = kyanite_basic_db[troop_idA[0]]; kyanite_cluster_team[0]   = kyanite_cluster_db[troop_idA[0]]; damage_team[0]   = damage_db[troop_idA[0]]; defense_team[0]   = defense_db[troop_idA[0]]; hp_team[0]   = hp_db[troop_idA[0]]; range_team[0]   = range_db[troop_idA[0]]; speed_team[0]   = speed_db[troop_idA[0]]; load_team[0]   = load_db[troop_idA[0]]; cost_team[0]   = cost_db[troop_idA[0]]; power_team[0]   = power_db[troop_idA[0]];
        fuel_team[1]  = fuel_db[troop_idA[1]]; food_team[1]  = food_db[troop_idA[1]]; steel_team[1]  = steel_db[troop_idA[1]]; alloy_team[1]  = alloy_db[troop_idA[1]]; time_team[1]  = time_db[troop_idA[1]]; kyanite_team[1]  = kyanite_db[troop_idA[1]]; kyanite_basic_team[1]  = kyanite_basic_db[troop_idA[1]]; kyanite_cluster_team[1]  = kyanite_cluster_db[troop_idA[1]]; damage_team[1]  = damage_db[troop_idA[1]]; defense_team[1]  = defense_db[troop_idA[1]]; hp_team[1]  = hp_db[troop_idA[1]]; range_team[1]  = range_db[troop_idA[1]]; speed_team[1]  = speed_db[troop_idA[1]]; load_team[1]  = load_db[troop_idA[1]]; cost_team[1]  = cost_db[troop_idA[1]]; power_team[1]  = power_db[troop_idA[1]];
        fuel_team[2]  = fuel_db[troop_idA[2]]; food_team[2]  = food_db[troop_idA[2]]; steel_team[2]  = steel_db[troop_idA[2]]; alloy_team[2]  = alloy_db[troop_idA[2]]; time_team[2]  = time_db[troop_idA[2]]; kyanite_team[2]  = kyanite_db[troop_idA[2]]; kyanite_basic_team[2]  = kyanite_basic_db[troop_idA[2]]; kyanite_cluster_team[2]  = kyanite_cluster_db[troop_idA[2]]; damage_team[2]  = damage_db[troop_idA[2]]; defense_team[2]  = defense_db[troop_idA[2]]; hp_team[2]  = hp_db[troop_idA[2]]; range_team[2]  = range_db[troop_idA[2]]; speed_team[2]  = speed_db[troop_idA[2]]; load_team[2]  = load_db[troop_idA[2]]; cost_team[2]  = cost_db[troop_idA[2]]; power_team[2]  = power_db[troop_idA[2]];
        fuel_team[3]  = fuel_db[troop_idA[3]]; food_team[3]  = food_db[troop_idA[3]]; steel_team[3]  = steel_db[troop_idA[3]]; alloy_team[3]  = alloy_db[troop_idA[3]]; time_team[3]  = time_db[troop_idA[3]]; kyanite_team[3]  = kyanite_db[troop_idA[3]]; kyanite_basic_team[3]  = kyanite_basic_db[troop_idA[3]]; kyanite_cluster_team[3]  = kyanite_cluster_db[troop_idA[3]]; damage_team[3]  = damage_db[troop_idA[3]]; defense_team[3]  = defense_db[troop_idA[3]]; hp_team[3]  = hp_db[troop_idA[3]]; range_team[3]  = range_db[troop_idA[3]]; speed_team[3]  = speed_db[troop_idA[3]]; load_team[3]  = load_db[troop_idA[3]]; cost_team[3]  = cost_db[troop_idA[3]]; power_team[3]  = power_db[troop_idA[3]];
        fuel_team[4]  = fuel_db[troop_idA[4]]; food_team[4]  = food_db[troop_idA[4]]; steel_team[4]  = steel_db[troop_idA[4]]; alloy_team[4]  = alloy_db[troop_idA[4]]; time_team[4]  = time_db[troop_idA[4]]; kyanite_team[4]  = kyanite_db[troop_idA[4]]; kyanite_basic_team[4]  = kyanite_basic_db[troop_idA[4]]; kyanite_cluster_team[4]  = kyanite_cluster_db[troop_idA[4]]; damage_team[4]  = damage_db[troop_idA[4]]; defense_team[4]  = defense_db[troop_idA[4]]; hp_team[4]  = hp_db[troop_idA[4]]; range_team[4]  = range_db[troop_idA[4]]; speed_team[4]  = speed_db[troop_idA[4]]; load_team[4]  = load_db[troop_idA[4]]; cost_team[4]  = cost_db[troop_idA[4]]; power_team[4]  = power_db[troop_idA[4]];
        fuel_team[5]  = fuel_db[troop_idA[5]]; food_team[5]  = food_db[troop_idA[5]]; steel_team[5]  = steel_db[troop_idA[5]]; alloy_team[5]  = alloy_db[troop_idA[5]]; time_team[5]  = time_db[troop_idA[5]]; kyanite_team[5]  = kyanite_db[troop_idA[5]]; kyanite_basic_team[5]  = kyanite_basic_db[troop_idA[5]]; kyanite_cluster_team[5]  = kyanite_cluster_db[troop_idA[5]]; damage_team[5]  = damage_db[troop_idA[5]]; defense_team[5]  = defense_db[troop_idA[5]]; hp_team[5]  = hp_db[troop_idA[5]]; range_team[5]  = range_db[troop_idA[5]]; speed_team[5]  = speed_db[troop_idA[5]]; load_team[5]  = load_db[troop_idA[5]]; cost_team[5]  = cost_db[troop_idA[5]]; power_team[5]  = power_db[troop_idA[5]];
        fuel_team[6]  = fuel_db[troop_idA[6]]; food_team[6]  = food_db[troop_idA[6]]; steel_team[6]  = steel_db[troop_idA[6]]; alloy_team[6]  = alloy_db[troop_idA[6]]; time_team[6]  = time_db[troop_idA[6]]; kyanite_team[6]  = kyanite_db[troop_idA[6]]; kyanite_basic_team[6]  = kyanite_basic_db[troop_idA[6]]; kyanite_cluster_team[6]  = kyanite_cluster_db[troop_idA[6]]; damage_team[6]  = damage_db[troop_idA[6]]; defense_team[6]  = defense_db[troop_idA[6]]; hp_team[6]  = hp_db[troop_idA[6]]; range_team[6]  = range_db[troop_idA[6]]; speed_team[6]  = speed_db[troop_idA[6]]; load_team[6]  = load_db[troop_idA[6]]; cost_team[6]  = cost_db[troop_idA[6]]; power_team[6]  = power_db[troop_idA[6]];
        fuel_team[7]  = fuel_db[troop_idA[7]]; food_team[7]  = food_db[troop_idA[7]]; steel_team[7]  = steel_db[troop_idA[7]]; alloy_team[7]  = alloy_db[troop_idA[7]]; time_team[7]  = time_db[troop_idA[7]]; kyanite_team[7]  = kyanite_db[troop_idA[7]]; kyanite_basic_team[7]  = kyanite_basic_db[troop_idA[7]]; kyanite_cluster_team[7]  = kyanite_cluster_db[troop_idA[7]]; damage_team[7]  = damage_db[troop_idA[7]]; defense_team[7]  = defense_db[troop_idA[7]]; hp_team[7]  = hp_db[troop_idA[7]]; range_team[7]  = range_db[troop_idA[7]]; speed_team[7]  = speed_db[troop_idA[7]]; load_team[7]  = load_db[troop_idA[7]]; cost_team[7]  = cost_db[troop_idA[7]]; power_team[7]  = power_db[troop_idA[7]];
        fuel_team[8]  = fuel_db[troop_idA[8]]; food_team[8]  = food_db[troop_idA[8]]; steel_team[8]  = steel_db[troop_idA[8]]; alloy_team[8]  = alloy_db[troop_idA[8]]; time_team[8]  = time_db[troop_idA[8]]; kyanite_team[8]  = kyanite_db[troop_idA[8]]; kyanite_basic_team[8]  = kyanite_basic_db[troop_idA[8]]; kyanite_cluster_team[8]  = kyanite_cluster_db[troop_idA[8]]; damage_team[8]  = damage_db[troop_idA[8]]; defense_team[8]  = defense_db[troop_idA[8]]; hp_team[8]  = hp_db[troop_idA[8]]; range_team[8]  = range_db[troop_idA[8]]; speed_team[8]  = speed_db[troop_idA[8]]; load_team[8]  = load_db[troop_idA[8]]; cost_team[8]  = cost_db[troop_idA[8]]; power_team[8]  = power_db[troop_idA[8]];
        fuel_team[9]  = fuel_db[troop_idA[9]]; food_team[9]  = food_db[troop_idA[9]]; steel_team[9]  = steel_db[troop_idA[9]]; alloy_team[9]  = alloy_db[troop_idA[9]]; time_team[9]  = time_db[troop_idA[9]]; kyanite_team[9]  = kyanite_db[troop_idA[9]]; kyanite_basic_team[9]  = kyanite_basic_db[troop_idA[9]]; kyanite_cluster_team[9]  = kyanite_cluster_db[troop_idA[9]]; damage_team[9]  = damage_db[troop_idA[9]]; defense_team[9]  = defense_db[troop_idA[9]]; hp_team[9]  = hp_db[troop_idA[9]]; range_team[9]  = range_db[troop_idA[9]]; speed_team[9]  = speed_db[troop_idA[9]]; load_team[9]  = load_db[troop_idA[9]]; cost_team[9]  = cost_db[troop_idA[9]]; power_team[9]  = power_db[troop_idA[9]];

        troop_calcalate();


    }
    public int setIco (long tid){
        if(	tid == 21	){return R.drawable.	hs_arm01	;}
        if(	tid == 22	){return R.drawable.	hs_arm02	;}
        if(	tid == 23	){return R.drawable.	hs_arm03	;}
        if(	tid == 24	){return R.drawable.	hs_arm04	;}
        if(	tid == 25	){return R.drawable.	hs_arm05	;}
        if(	tid == 26	){return R.drawable.	hs_arm06	;}
        if(	tid == 27	){return R.drawable.	hs_arm07	;}
        if(	tid == 28	){return R.drawable.	hs_arm08	;}
        if(	tid == 29	){return R.drawable.	hs_arm09	;}
        if(	tid == 30	){return R.drawable.	hs_arm10	;}
        if(	tid == 1	){return R.drawable.	hs_mili01	;}
        if(	tid == 2	){return R.drawable.	hs_mili02	;}
        if(	tid == 3	){return R.drawable.	hs_mili03	;}
        if(	tid == 4	){return R.drawable.	hs_mili04	;}
        if(	tid == 5	){return R.drawable.	hs_mili05	;}
        if(	tid == 6	){return R.drawable.	hs_mili06	;}
        if(	tid == 7	){return R.drawable.	hs_mili07	;}
        if(	tid == 8	){return R.drawable.	hs_mili08	;}
        if(	tid == 9	){return R.drawable.	hs_mili09	;}
        if(	tid == 10	){return R.drawable.	hs_mili10	;}
        if(	tid == 11	){return R.drawable.	hs_mobile01	;}
        if(	tid == 12	){return R.drawable.	hs_mobile02	;}
        if(	tid == 13	){return R.drawable.	hs_mobile03	;}
        if(	tid == 14	){return R.drawable.	hs_mobile04	;}
        if(	tid == 15	){return R.drawable.	hs_mobile05	;}
        if(	tid == 16	){return R.drawable.	hs_mobile06	;}
        if(	tid == 17	){return R.drawable.	hs_mobile07	;}
        if(	tid == 18	){return R.drawable.	hs_mobile08	;}
        if(	tid == 19	){return R.drawable.	hs_mobile09	;}
        if(	tid == 20	){return R.drawable.	hs_mobile10	;}
        if(	tid == 31	){return R.drawable.	hs_infect01	;}
        if(	tid == 32	){return R.drawable.	hs_infect02	;}
        if(	tid == 33	){return R.drawable.	hs_infect03	;}
        if(	tid == 34	){return R.drawable.	hs_infect04	;}
        if(	tid == 35	){return R.drawable.	hs_infect05	;}
        if(	tid == 36	){return R.drawable.	hs_infect06	;}
        if(	tid == 37	){return R.drawable.	hs_infect07	;}
        if(	tid == 38	){return R.drawable.	hs_infect08	;}
        if(	tid == 39	){return R.drawable.	hs_infect09	;}
        if(	tid == 40	){return R.drawable.	hs_infect10	;}
        if(	tid == 41	){return R.drawable.	hs_project01	;}
        if(	tid == 42	){return R.drawable.	hs_project02	;}
        if(	tid == 43	){return R.drawable.	hs_project03	;}
        if(	tid == 44	){return R.drawable.	hs_project04	;}
        if(	tid == 45	){return R.drawable.	hs_project05	;}
        if(	tid == 46	){return R.drawable.	hs_project06	;}
        if(	tid == 47	){return R.drawable.	hs_project07	;}
        if(	tid == 48	){return R.drawable.	hs_project08	;}
        if(	tid == 49	){return R.drawable.	hs_project09	;}
        if(	tid == 50	){return R.drawable.	hs_project10	;}

        return 0;
    }

    // -----

    private void KE_POINTS() {
        long[] train_building = new long[5]; // Mili , Mobile , Armed , Infect , Project
        int temp_x = 0;
        for (int y = 0 ; y < buildingNameArray.length ; y++){
            if (buildingNameArray[y].equals("Military Office")){train_building[0] = buildingLvlArray[y];}
            if (buildingNameArray[y].equals("Mobile Team Factory")){train_building[1] = buildingLvlArray[y];}
            if (buildingNameArray[y].equals("Armed Forces")){train_building[2] = buildingLvlArray[y];}
            if (buildingNameArray[y].equals("Infection Institute")){train_building[3] = buildingLvlArray[y];}
            if (buildingNameArray[y].equals("Project Origin Institute")){train_building[4] = buildingLvlArray[y];}
        }
        long[] train_buildingB = train_building;
        Arrays.sort(train_building);
        if (train_building[4] == train_buildingB[0]){temp_x = 1;}
        if (train_building[4] == train_buildingB[1]){temp_x = 2;}
        if (train_building[4] == train_buildingB[2]){temp_x = 3;}
        if (train_building[4] == train_buildingB[3]){temp_x = 4;}
        if (train_building[4] == train_buildingB[4]){temp_x = 5;}


    }

    private void KE_POWER() {

    }

    public  void  wifi (int code){
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        if (!isConnected) {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setTitle(getString(R.string.network_lost_title));
            builder1.setMessage(getString(R.string.network_lost));
            builder1.setIcon(R.drawable.app_icon_round);

            builder1.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            startActivity(new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
        }


        else {
            new TakeDataX(code).execute();

        }
    }
    private class TakeDataX extends AsyncTask<Void, Void, Void> {
        int code = -1;
        String jsonStr = "";
        public TakeDataX(int code) {
            this.code = code;
        }

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
            // Depends URL
            SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
            if (sharedPreferences.getLong("UID",0) == 0){getSavedLoginDataJson();}
            if (sharedPreferences.getString("verifyCode","0") == "0"){getSavedLoginDataJson();}
            uid = sharedPreferences.getLong("UID",0);
            verifyCode = sharedPreferences.getString("verifyCode","0");
            boolean input_json_list = sharedPreferences.getBoolean("input_json_list", true);
            url = "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid="+uid+"&psw="+verifyCode;
            Log.wtf("URL",url);
            jsonStr = sh.makeServiceCall(url);

            Log.w("STR","AX"+jsonStr);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Log.i("TOTAL_GrabX","ok");
            Log.w("STR2","AX"+jsonStr);
            if ( jsonStr.contains("{")) {
                SharedPreferences sharedPreferences = getSharedPreferences("user_info",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                    if (code == 1){
                        new TakeData().execute();
                    }
                } else {
                    datalist_tips();

                }
        }
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
            SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putLong("UID",uid);
            editor.putString("verifyCode",verifyCode);
            editor.apply();
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
    protected void onStop() {
        super.onStop();
        save();
    }
}


