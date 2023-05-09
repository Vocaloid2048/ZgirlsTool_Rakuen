package voc.net.tools.zgirls_tool.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.R;
import voc.net.tools.zgirls_tool.util.ScreenSizeUtils;
import voc.net.tools.zgirls_tool.util.Tech;
import voc.net.tools.zgirls_tool.util.TechAdapter;
import voc.net.tools.zgirls_tool.util.TechLib;
import voc.net.tools.zgirls_tool.util.TechLib_Time;

public class NewTechActivity extends AppCompatActivity {

    SeekBar start_pb1,	start_pb2,	start_pb3,	start_pb4,	start_pb5,	start_pb6,	start_pb7,	start_pb8,	start_pb9,	start_pb10;
    SeekBar end_pb1,	end_pb2,	end_pb3,	end_pb4,	end_pb5,	end_pb6,	end_pb7,	end_pb8,	end_pb9,	end_pb10;
    TextView start_tv1,	start_tv2,	start_tv3,	start_tv4,	start_tv5,	start_tv6,	start_tv7,	start_tv8,	start_tv9,	start_tv10;
    TextView end_tv1,	end_tv2,	end_tv3,	end_tv4,	end_tv5,	end_tv6,	end_tv7,	end_tv8,	end_tv9,	end_tv10;
    LinearLayout team_ll1,	team_ll2,	team_ll3,	team_ll4,	team_ll5,	team_ll6,	team_ll7,	team_ll8,	team_ll9,	team_ll10;

    ImageView tech01_img,	tech02_img,	tech03_img,	tech04_img,	tech05_img,	tech06_img,	tech07_img,	tech08_img,	tech09_img,	tech10_img;
    TextView tech01_tv,	tech02_tv,	tech03_tv,	tech04_tv,	tech05_tv,	tech06_tv,	tech07_tv,	tech08_tv,	tech09_tv,	tech10_tv;
    CardView tech01_card,	tech02_card,	tech03_card,	tech04_card,	tech05_card,	tech06_card,	tech07_card,	tech08_card,	tech09_card,	tech10_card;

    int[] tech_len = {5	,	5	,	5	,	15	,	15	,	5	,	15	,	5	,	15	,	5	,	15	,	15	,	10	,	15	,	15	,	15	,	15	,	15	,	15	,	10	,	9	,	5	,	5	,	10	,	10	,	10	,	5	,	10	,	10	,	15	,	15	,	15	,	15	,	15	,	10	,	5	,	5	,	5	,	5	,	10	,	5	,	5	,	10	,	10	,	15	,	10	,	10	,	20	,	10	,	10	,	10	,	20	,	10	,	3	,	3	,	3	,	10	,	3	,	3	,	3	,	1	,	3	,	3	,	3	,	2	,	1	,	5	,	5	,	5	,	15	,	5	,	5	,	5	,	15	,	5	,	5	,	5	,	5	,	1	,	7	,	7	,	7	,	20	,	7	,	7	,	7	,	20	,	7	,	7	,	7	,	7	,	10	,	10	,	10	,	10	,	10	,	10	,	10	,	10	,	10	,	10	,	10	,	10	,	10	,	10	,	10	,	10	,	10	,	10	,	1	,	10	,	10	,	10	,	10	,	10	,	10	,	10	,	10	,	10	,	10	,	10	,	10	,	10	,	10	,	10	,	10	,	1	,	10	,	10	,	10	,	10	,	10	,	10	,	10	,	10	,	10	,	10	,	10};
    int tech_cal_id = -1;
    int tech_cal_buffId = -1;

    public int[] techBuff = {R.string.tech_buff1,	R.string.tech_buff2,	R.string.tech_buff3,	R.string.tech_buff4,	R.string.tech_buff5,	R.string.tech_buff6,	R.string.tech_buff7,	R.string.tech_buff8,	R.string.tech_buff9,	R.string.tech_buff10,	R.string.tech_buff11,	R.string.tech_buff12,	R.string.tech_buff13,	R.string.tech_buff14,	R.string.tech_buff15,	R.string.tech_buff16,	R.string.tech_buff17,	R.string.tech_buff18,	R.string.tech_buff19,	R.string.tech_buff20,	R.string.tech_buff21,	R.string.tech_buff22,	R.string.tech_buff23,	R.string.tech_buff24,	R.string.tech_buff25,	R.string.tech_buff26,	R.string.tech_buff27,	R.string.tech_buff28,	R.string.tech_buff29,	R.string.tech_buff30,	R.string.tech_buff31,	R.string.tech_buff32,	R.string.tech_buff33,	R.string.tech_buff34,	R.string.tech_buff35,	R.string.tech_buff36,	R.string.tech_buff37,	R.string.tech_buff38,	R.string.tech_buff39,	R.string.tech_buff40,	R.string.tech_buff41,	R.string.tech_buff42,	R.string.tech_buff43,	R.string.tech_buff44,	R.string.tech_buff45,	R.string.tech_buff46,	R.string.tech_buff47,	R.string.tech_buff48,	R.string.tech_buff49,	R.string.tech_buff50,	R.string.tech_buff51,	R.string.tech_buff52,	R.string.tech_buff53,	R.string.tech_buff54,	R.string.tech_buff55,	R.string.tech_buff56,	R.string.tech_buff57,	R.string.tech_buff58,	R.string.tech_buff59,	R.string.tech_buff60,	R.string.tech_buff61,	R.string.tech_buff62,	R.string.tech_buff63,	R.string.tech_buff64,	R.string.tech_buff65,	R.string.tech_buff66,	R.string.tech_buff67,	R.string.tech_buff68,	R.string.tech_buff69,	R.string.tech_buff70,	R.string.tech_buff71,	R.string.tech_buff72,	R.string.tech_buff73,	R.string.tech_buff74,	R.string.tech_buff75,	R.string.tech_buff76,	R.string.tech_buff77,	R.string.tech_buff78,	R.string.tech_buff79,	R.string.tech_buff80,	R.string.tech_buff81,	R.string.tech_buff82,	R.string.tech_buff83,	R.string.tech_buff84,	R.string.tech_buff85,	R.string.tech_buff86,	R.string.tech_buff87};
    public int[] techIMG = {R.drawable.science_res_a_2,R.drawable.science_res_a_3,R.drawable.science_res_a_4,R.drawable.science_res_a_5,R.drawable.science_res_a_6,R.drawable.science_res_a_7,R.drawable.science_res_a_8,R.drawable.science_res_a_9,R.drawable.science_res_a_10,R.drawable.science_res_a_11,R.drawable.science_res_a_2,R.drawable.science_res_a_3,R.drawable.science_res_a_4,R.drawable.science_res_a_5,R.drawable.science_res_a_6,R.drawable.science_res_a_7,R.drawable.science_res_a_8,R.drawable.science_res_a_9,R.drawable.science_res_a_10,R.drawable.science_res_a_11,R.drawable.science_dev_a_1,R.drawable.science_dev_a_6,R.drawable.science_dev_a_7,R.drawable.science_dev_a_2,R.drawable.science_dev_a_4,R.drawable.science_dev_a_5,R.drawable.science_dev_a_3,R.drawable.science_dev_a_6,R.drawable.science_dev_a_7,R.drawable.science_dev_a_1,R.drawable.science_dev_a_2,R.drawable.science_dev_a_4,R.drawable.science_dev_a_5,R.drawable.science_dev_a_3,R.drawable.science_def_a_1,R.drawable.science_def_a_2,R.drawable.science_def_a_3,R.drawable.science_def_a_4,R.drawable.science_def_a_7,R.drawable.science_def_a_5,R.drawable.science_def_a_6,R.drawable.science_def_a_8,R.drawable.science_def_a_9,R.drawable.science_def_a_10,R.drawable.science_def_a_1,R.drawable.science_def_a_2,R.drawable.science_def_a_3,R.drawable.science_def_a_5,R.drawable.science_def_a_6,R.drawable.science_def_a_7,R.drawable.science_def_a_8,R.drawable.science_def_a_9,R.drawable.science_mil_a_1,R.drawable.science_mil_a_2,R.drawable.science_mil_a_3,R.drawable.science_mil_a_4,R.drawable.science_mil_a_6,R.drawable.science_mil_a_7,R.drawable.science_mil_a_8,R.drawable.science_mil_a_9,R.drawable.science_mil_a_11,R.drawable.science_mil_a_12,R.drawable.science_mil_a_13,R.drawable.science_mil_a_14,R.drawable.science_mil_a_16,R.drawable.science_mil_a_11,R.drawable.science_mil_a_2,R.drawable.science_mil_a_3,R.drawable.science_mil_a_4,R.drawable.science_mil_a_1,R.drawable.science_mil_a_7,R.drawable.science_mil_a_8,R.drawable.science_mil_a_9,R.drawable.science_mil_a_6,R.drawable.science_mil_a_12,R.drawable.science_mil_a_13,R.drawable.science_mil_a_14,R.drawable.science_mil_a_16,R.drawable.science_mil_a_11,R.drawable.science_mil_a_2,R.drawable.science_mil_a_3,R.drawable.science_mil_a_4,R.drawable.science_mil_a_1,R.drawable.science_mil_a_7,R.drawable.science_mil_a_8,R.drawable.science_mil_a_9,R.drawable.science_mil_a_6,R.drawable.science_mil_a_12,R.drawable.science_mil_a_13,R.drawable.science_mil_a_14,R.drawable.science_mil_a_16,R.drawable.science_fit_a_1,R.drawable.science_fit_a_2,R.drawable.science_fit_a_6,R.drawable.science_fit_a_3,R.drawable.science_fit_a_4,R.drawable.science_fit_a_7,R.drawable.science_fit_a_8,R.drawable.science_fit_a_5,R.drawable.science_fit_a_9,R.drawable.science_fit_a_10,R.drawable.science_fit_a_11,R.drawable.science_fit_a_12,R.drawable.science_fit_a_13,R.drawable.science_fit_a_17,R.drawable.science_fit_a_14,R.drawable.science_fit_a_15,R.drawable.science_fit_a_16,R.drawable.science_fit_a_17,R.drawable.science_fit_a_18,R.drawable.science_deaf_a_1,R.drawable.science_deaf_a_2,R.drawable.science_deaf_a_11,R.drawable.science_deaf_a_3,R.drawable.science_deaf_a_4,R.drawable.science_deaf_a_12,R.drawable.science_deaf_a_13,R.drawable.science_deaf_a_9,R.drawable.science_deaf_a_14,R.drawable.science_deaf_a_10,R.drawable.science_deaf_a_14,R.drawable.science_deaf_a_7,R.drawable.science_deaf_a_8,R.drawable.science_deaf_a_15,R.drawable.science_deaf_a_9,R.drawable.science_deaf_a_16,R.drawable.science_deaf_a_17,R.drawable.science_zombie_9,R.drawable.science_zombie_2,R.drawable.science_zombie_1,R.drawable.science_zombie_11,R.drawable.science_zombie_10,R.drawable.science_zombie_8,R.drawable.science_zombie_4,R.drawable.science_zombie_5,R.drawable.science_zombie_6,R.drawable.science_zombie_7,R.drawable.science_zombie_3};
    public int[] techName = {R.string.tech_r1,	R.string.tech_r2,	R.string.tech_r3,	R.string.tech_r4,	R.string.tech_r5,	R.string.tech_r6,	R.string.tech_r7,	R.string.tech_r8,	R.string.tech_r9,	R.string.tech_r10,	R.string.tech_r11,	R.string.tech_r12,	R.string.tech_r13,	R.string.tech_r14,	R.string.tech_r15,	R.string.tech_r16,	R.string.tech_r17,	R.string.tech_r18,	R.string.tech_r19,	R.string.tech_r20,	R.string.tech_r21,	R.string.tech_r22,	R.string.tech_r23,	R.string.tech_r24,	R.string.tech_r25,	R.string.tech_r26,	R.string.tech_r27,	R.string.tech_r28,	R.string.tech_r29,	R.string.tech_r30,	R.string.tech_r31,	R.string.tech_r32,	R.string.tech_r33,	R.string.tech_r34,	R.string.tech_r35,	R.string.tech_r36,	R.string.tech_r37,	R.string.tech_r38,	R.string.tech_r39,	R.string.tech_r40,	R.string.tech_r41,	R.string.tech_r42,	R.string.tech_r43,	R.string.tech_r44,	R.string.tech_r45,	R.string.tech_r46,	R.string.tech_r47,	R.string.tech_r48,	R.string.tech_r49,	R.string.tech_r50,	R.string.tech_r51,	R.string.tech_r52,	R.string.tech_r53,	R.string.tech_r54,	R.string.tech_r55,	R.string.tech_r56,	R.string.tech_r57,	R.string.tech_r58,	R.string.tech_r59,	R.string.tech_r60,	R.string.tech_r61,	R.string.tech_r62,	R.string.tech_r63,	R.string.tech_r64,	R.string.tech_r65,	R.string.tech_r66,	R.string.tech_r67,	R.string.tech_r68,	R.string.tech_r69,	R.string.tech_r70,	R.string.tech_r71,	R.string.tech_r72,	R.string.tech_r73,	R.string.tech_r74,	R.string.tech_r75,	R.string.tech_r76,	R.string.tech_r77,	R.string.tech_r78,	R.string.tech_r79,	R.string.tech_r80,	R.string.tech_r81,	R.string.tech_r82,	R.string.tech_r83,	R.string.tech_r84,	R.string.tech_r85,	R.string.tech_r86,	R.string.tech_r87,	R.string.tech_r88,	R.string.tech_r89,	R.string.tech_r90,	R.string.tech_r91,	R.string.tech_r92,	R.string.tech_r93,	R.string.tech_r94,	R.string.tech_r95,	R.string.tech_r96,	R.string.tech_r97,	R.string.tech_r98,	R.string.tech_r99,	R.string.tech_r100,	R.string.tech_r101,	R.string.tech_r102,	R.string.tech_r103,	R.string.tech_r104,	R.string.tech_r105,	R.string.tech_r106,	R.string.tech_r107,	R.string.tech_r108,	R.string.tech_r109,	R.string.tech_r110,	R.string.tech_r111,	R.string.tech_r112,	R.string.tech_r113,	R.string.tech_r114,	R.string.tech_r115,	R.string.tech_r116,	R.string.tech_r117,	R.string.tech_r118,	R.string.tech_r119,	R.string.tech_r120,	R.string.tech_r121,	R.string.tech_r122,	R.string.tech_r123,	R.string.tech_r124,	R.string.tech_r125,	R.string.tech_r126,	R.string.tech_r127,	R.string.tech_r128,	R.string.tech_r129,	R.string.tech_r130,	R.string.tech_r131,	R.string.tech_r132,	R.string.tech_r133,	R.string.tech_r134,	R.string.tech_r135,	R.string.tech_r136,	R.string.tech_r137,	R.string.tech_r138};


    private static String PATH_TPS_SAVE = Environment.getExternalStorageDirectory().getPath () +"/voc/zgt/tech/";
    TextView fuel_tv , food_tv , steel_tv , alloy_tv , time_tv , kyanite_tv , kyanite_basic_tv , kyanite_cluster_tv , power_tv ,diamond_tv;

    long[] fuel_team = {0,0,0,0,0,0,0,0,0,0};
    long[] food_team = {0,0,0,0,0,0,0,0,0,0};
    long[] steel_team = {0,0,0,0,0,0,0,0,0,0};
    long[] alloy_team = {0,0,0,0,0,0,0,0,0,0};
    long[] time_team = {0,0,0,0,0,0,0,0,0,0};
    long[] kyanite_team = {0,0,0,0,0,0,0,0,0,0};
    long[] kyanite_basic_team = {0,0,0,0,0,0,0,0,0,0};
    long[] kyanite_cluster_team = {0,0,0,0,0,0,0,0,0,0};
    long[] power_team = {0,0,0,0,0,0,0,0,0,0} ;
    long[] diam_team = {0,0,0,0,0,0,0,0,0,0} ;
    long[] x_id = {0,0,0,0,0,0,0,0,0,0} ;
    int[] tech_lvl_start = {0,0,0,0,0,0,0,0,0,0};
    int[] tech_lvl_end = {0,0,0,0,0,0,0,0,0,0};
    int[] tech_id = {0,0,0,0,0,0,0,0,0,0};

    int[] tech_s = {0,0,0,0,0,0,0,0,0,0};
    int[] tech_e = {0,0,0,0,0,0,0,0,0,0};
    int[] tech_m = {0,0,0,0,0,0,0,0,0,0};
    long[] tech_idA = {0,0,0,0,0,0,0,0,0,0};

    boolean isLoad = false;


    long fuel , food , steel , alloy , kyanite , kyanite_basic , kyanite_cluster , power , diamond ,tech_val,time;

    private List<Tech> techList = new ArrayList<>();
    private RecyclerView.Adapter adapter;
    private TechAdapter mAdapter;
    RecyclerView mList ;
    private LinearLayoutManager linearLayoutManager;

    SharedPreferences sharedPreferences ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_tech);
        sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        fuel_tv = findViewById(R.id.tech_fuel);
        food_tv = findViewById(R.id.tech_food);
        steel_tv = findViewById(R.id.tech_steel);
        alloy_tv = findViewById(R.id.tech_alloy);
        kyanite_tv = findViewById(R.id.tech_kyanite);
        kyanite_basic_tv = findViewById(R.id.tech_kyanite_basic);
        kyanite_cluster_tv = findViewById(R.id.tech_kyanite_cluster);
        power_tv = findViewById(R.id.tech_power);
        time_tv = findViewById(R.id.tech_time);
        diamond_tv = findViewById(R.id.tech_diam);
        new_init();
        BackgroundReload();
        cbg();
        // Troop List
        mAdapter = new TechAdapter(getApplicationContext(), techList);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mList = findViewById(R.id.train_list);
        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.setAdapter(mAdapter);

        start_pb1	.setMax(0);	start_pb1	.setProgress(0);
        start_pb2	.setMax(0);	start_pb2	.setProgress(0);
        start_pb3	.setMax(0);	start_pb3	.setProgress(0);
        start_pb4	.setMax(0);	start_pb4	.setProgress(0);
        start_pb5	.setMax(0);	start_pb5	.setProgress(0);
        start_pb6	.setMax(0);	start_pb6	.setProgress(0);
        start_pb7	.setMax(0);	start_pb7	.setProgress(0);
        start_pb8	.setMax(0);	start_pb8	.setProgress(0);
        start_pb9	.setMax(0);	start_pb9	.setProgress(0);
        start_pb10	.setMax(0);	start_pb10	.setProgress(0);

        end_pb1	.setMax(1);	end_pb1	.setProgress(1);
        end_pb2	.setMax(1);	end_pb2	.setProgress(1);
        end_pb3	.setMax(1);	end_pb3	.setProgress(1);
        end_pb4	.setMax(1);	end_pb4	.setProgress(1);
        end_pb5	.setMax(1);	end_pb5	.setProgress(1);
        end_pb6	.setMax(1);	end_pb6	.setProgress(1);
        end_pb7	.setMax(1);	end_pb7	.setProgress(1);
        end_pb8	.setMax(1);	end_pb8	.setProgress(1);
        end_pb9	.setMax(1);	end_pb9	.setProgress(1);
        end_pb10	.setMax(1);	end_pb10	.setProgress(1);

        tech01_img.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { showTech(tech01_img,v,tech01_tv,tech02_card,1); }});
        tech02_img.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { showTech(tech02_img,v,tech02_tv,tech03_card,2); }});
        tech03_img.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { showTech(tech03_img,v,tech03_tv,tech04_card,3); }});
        tech04_img.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { showTech(tech04_img,v,tech04_tv,tech05_card,4); }});
        tech05_img.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { showTech(tech05_img,v,tech05_tv,tech06_card,5); }});
        tech06_img.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { showTech(tech06_img,v,tech06_tv,tech07_card,6); }});
        tech07_img.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { showTech(tech07_img,v,tech07_tv,tech08_card,7); }});
        tech08_img.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { showTech(tech08_img,v,tech08_tv,tech09_card,8); }});
        tech09_img.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { showTech(tech09_img,v,tech09_tv,tech10_card,9); }});
        tech10_img.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { showTech(tech10_img,v,tech10_tv,tech10_card,10); }});

        start_pb1	.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {@Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { testing_S(1,progress); }@Override public void onStartTrackingTouch(SeekBar seekBar){}@Override public void onStopTrackingTouch(SeekBar seekBar) { }});
        start_pb2	.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {@Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { testing_S(2,progress); }@Override public void onStartTrackingTouch(SeekBar seekBar){}@Override public void onStopTrackingTouch(SeekBar seekBar) { }});
        start_pb3	.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {@Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { testing_S(3,progress); }@Override public void onStartTrackingTouch(SeekBar seekBar){}@Override public void onStopTrackingTouch(SeekBar seekBar) { }});
        start_pb4	.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {@Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { testing_S(4,progress); }@Override public void onStartTrackingTouch(SeekBar seekBar){}@Override public void onStopTrackingTouch(SeekBar seekBar) { }});
        start_pb5	.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {@Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { testing_S(5,progress); }@Override public void onStartTrackingTouch(SeekBar seekBar){}@Override public void onStopTrackingTouch(SeekBar seekBar) { }});
        start_pb6	.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {@Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { testing_S(6,progress); }@Override public void onStartTrackingTouch(SeekBar seekBar){}@Override public void onStopTrackingTouch(SeekBar seekBar) { }});
        start_pb7	.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {@Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { testing_S(7,progress); }@Override public void onStartTrackingTouch(SeekBar seekBar){}@Override public void onStopTrackingTouch(SeekBar seekBar) { }});
        start_pb8	.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {@Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { testing_S(8,progress); }@Override public void onStartTrackingTouch(SeekBar seekBar){}@Override public void onStopTrackingTouch(SeekBar seekBar) { }});
        start_pb9	.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {@Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { testing_S(9,progress); }@Override public void onStartTrackingTouch(SeekBar seekBar){}@Override public void onStopTrackingTouch(SeekBar seekBar) { }});
        start_pb10	.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {@Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { testing_S(10,progress); }@Override public void onStartTrackingTouch(SeekBar seekBar){}@Override public void onStopTrackingTouch(SeekBar seekBar) { }});

        end_pb1	.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {@Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { testing_E(1,progress); }@Override public void onStartTrackingTouch(SeekBar seekBar){}@Override public void onStopTrackingTouch(SeekBar seekBar) { }});
        end_pb2	.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {@Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { testing_E(2,progress); }@Override public void onStartTrackingTouch(SeekBar seekBar){}@Override public void onStopTrackingTouch(SeekBar seekBar) { }});
        end_pb3	.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {@Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { testing_E(3,progress); }@Override public void onStartTrackingTouch(SeekBar seekBar){}@Override public void onStopTrackingTouch(SeekBar seekBar) { }});
        end_pb4	.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {@Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { testing_E(4,progress); }@Override public void onStartTrackingTouch(SeekBar seekBar){}@Override public void onStopTrackingTouch(SeekBar seekBar) { }});
        end_pb5	.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {@Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { testing_E(5,progress); }@Override public void onStartTrackingTouch(SeekBar seekBar){}@Override public void onStopTrackingTouch(SeekBar seekBar) { }});
        end_pb6	.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {@Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { testing_E(6,progress); }@Override public void onStartTrackingTouch(SeekBar seekBar){}@Override public void onStopTrackingTouch(SeekBar seekBar) { }});
        end_pb7	.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {@Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { testing_E(7,progress); }@Override public void onStartTrackingTouch(SeekBar seekBar){}@Override public void onStopTrackingTouch(SeekBar seekBar) { }});
        end_pb8	.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {@Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { testing_E(8,progress); }@Override public void onStartTrackingTouch(SeekBar seekBar){}@Override public void onStopTrackingTouch(SeekBar seekBar) { }});
        end_pb9	.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {@Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { testing_E(9,progress); }@Override public void onStartTrackingTouch(SeekBar seekBar){}@Override public void onStopTrackingTouch(SeekBar seekBar) { }});
        end_pb10	.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {@Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { testing_E(10,progress); }@Override public void onStartTrackingTouch(SeekBar seekBar){}@Override public void onStopTrackingTouch(SeekBar seekBar) { }});


        Load();
        Log.w("WTH", String.valueOf(start_pb1.getProgress()));
    }

    public void testing_S(int test,int progress){
        if (test == 1){if (progress>=	end_pb1.getProgress()){	start_pb1.setProgress(	end_pb1.getProgress()	-1);}start_tv1.setText(String.valueOf(start_pb1.getProgress()));end_tv1.setText(String.valueOf(end_pb1.getProgress()));}
        if (test == 2){if (progress>=	end_pb2.getProgress()){	start_pb2.setProgress(	end_pb2.getProgress()	-1);}start_tv2.setText(String.valueOf(start_pb2.getProgress()));end_tv2.setText(String.valueOf(end_pb2.getProgress()));}
        if (test == 3){if (progress>=	end_pb3.getProgress()){	start_pb3.setProgress(	end_pb3.getProgress()	-1);}start_tv3.setText(String.valueOf(start_pb3.getProgress()));end_tv3.setText(String.valueOf(end_pb3.getProgress()));}
        if (test == 4){if (progress>=	end_pb4.getProgress()){	start_pb4.setProgress(	end_pb4.getProgress()	-1);}start_tv4.setText(String.valueOf(start_pb4.getProgress()));end_tv4.setText(String.valueOf(end_pb4.getProgress()));}
        if (test == 5){if (progress>=	end_pb5.getProgress()){	start_pb5.setProgress(	end_pb5.getProgress()	-1);}start_tv5.setText(String.valueOf(start_pb5.getProgress()));end_tv5.setText(String.valueOf(end_pb5.getProgress()));}
        if (test == 6){if (progress>=	end_pb6.getProgress()){	start_pb6.setProgress(	end_pb6.getProgress()	-1);}start_tv6.setText(String.valueOf(start_pb6.getProgress()));end_tv6.setText(String.valueOf(end_pb6.getProgress()));}
        if (test == 7){if (progress>=	end_pb7.getProgress()){	start_pb7.setProgress(	end_pb7.getProgress()	-1);}start_tv7.setText(String.valueOf(start_pb7.getProgress()));end_tv7.setText(String.valueOf(end_pb7.getProgress()));}
        if (test == 8){if (progress>=	end_pb8.getProgress()){	start_pb8.setProgress(	end_pb8.getProgress()	-1);}start_tv8.setText(String.valueOf(start_pb8.getProgress()));end_tv8.setText(String.valueOf(end_pb8.getProgress()));}
        if (test == 9){if (progress>=	end_pb9.getProgress()){	start_pb9.setProgress(	end_pb9.getProgress()	-1);}start_tv9.setText(String.valueOf(start_pb9.getProgress()));end_tv9.setText(String.valueOf(end_pb9.getProgress()));}
        if (test == 10){if (progress>=	end_pb10.getProgress()){	start_pb10.setProgress(	end_pb10.getProgress()	-1);}start_tv10.setText(String.valueOf(start_pb10.getProgress()));end_tv10.setText(String.valueOf(end_pb10.getProgress()));}
        tech_cal(test);
        Log.wtf("PB1","START : "+String.valueOf(start_pb1.getProgress())+" END : "+String.valueOf(end_pb1.getProgress()));
    }
    public void testing_E(int test,int progress){
        if (test == 1){if (progress<=	start_pb1.getProgress()){	end_pb1.setProgress(	start_pb1.getProgress()	+1);}	start_tv1.setText(String.valueOf(start_pb1.getProgress()));end_tv1.setText(String.valueOf(end_pb1.getProgress()));}
        if (test == 2){if (progress<=	start_pb2.getProgress()){	end_pb2.setProgress(	start_pb2.getProgress()	+1);}	start_tv2.setText(String.valueOf(start_pb2.getProgress()));end_tv2.setText(String.valueOf(end_pb2.getProgress()));}
        if (test == 3){if (progress<=	start_pb3.getProgress()){	end_pb3.setProgress(	start_pb3.getProgress()	+1);}	start_tv3.setText(String.valueOf(start_pb3.getProgress()));end_tv3.setText(String.valueOf(end_pb3.getProgress()));}
        if (test == 4){if (progress<=	start_pb4.getProgress()){	end_pb4.setProgress(	start_pb4.getProgress()	+1);}	start_tv4.setText(String.valueOf(start_pb4.getProgress()));end_tv4.setText(String.valueOf(end_pb4.getProgress()));}
        if (test == 5){if (progress<=	start_pb5.getProgress()){	end_pb5.setProgress(	start_pb5.getProgress()	+1);}	start_tv5.setText(String.valueOf(start_pb5.getProgress()));end_tv5.setText(String.valueOf(end_pb5.getProgress()));}
        if (test == 6){if (progress<=	start_pb6.getProgress()){	end_pb6.setProgress(	start_pb6.getProgress()	+1);}	start_tv6.setText(String.valueOf(start_pb6.getProgress()));end_tv6.setText(String.valueOf(end_pb6.getProgress()));}
        if (test == 7){if (progress<=	start_pb7.getProgress()){	end_pb7.setProgress(	start_pb7.getProgress()	+1);}	start_tv7.setText(String.valueOf(start_pb7.getProgress()));end_tv7.setText(String.valueOf(end_pb7.getProgress()));}
        if (test == 8){if (progress<=	start_pb8.getProgress()){	end_pb8.setProgress(	start_pb8.getProgress()	+1);}	start_tv8.setText(String.valueOf(start_pb8.getProgress()));end_tv8.setText(String.valueOf(end_pb8.getProgress()));}
        if (test == 9){if (progress<=	start_pb9.getProgress()){	end_pb9.setProgress(	start_pb9.getProgress()	+1);}	start_tv9.setText(String.valueOf(start_pb9.getProgress()));end_tv9.setText(String.valueOf(end_pb9.getProgress()));}
        if (test == 10){if (progress<=	start_pb10.getProgress()){	end_pb10.setProgress(	start_pb10.getProgress()	+1);}	start_tv10.setText(String.valueOf(start_pb10.getProgress()));end_tv10.setText(String.valueOf(end_pb10.getProgress()));}
        tech_cal(test);
        Log.wtf("PB1","START : "+String.valueOf(start_pb1.getProgress())+" END : "+String.valueOf(end_pb1.getProgress()));
    }

    public void showTech(ImageView troop_choose, View view, TextView troop_name, CardView next_card, int x){
        final Dialog dialog = new Dialog(this, R.style.NormalDialogStyle_N);
        view = View.inflate(this, R.layout.tech_choose, null);
        ImageView	tech_ico1	 = view.findViewById(R.id.	tech_ico1);
        ImageView	tech_ico2	 = view.findViewById(R.id.	tech_ico2);
        ImageView	tech_ico3	 = view.findViewById(R.id.	tech_ico3);
        ImageView	tech_ico4	 = view.findViewById(R.id.	tech_ico4);
        ImageView	tech_ico5	 = view.findViewById(R.id.	tech_ico5);
        ImageView	tech_ico6	 = view.findViewById(R.id.	tech_ico6);
        ImageView	tech_ico7	 = view.findViewById(R.id.	tech_ico7);
        ImageView	tech_ico8	 = view.findViewById(R.id.	tech_ico8);
        ImageView	tech_ico9	 = view.findViewById(R.id.	tech_ico9);
        ImageView	tech_ico10	 = view.findViewById(R.id.	tech_ico10);
        ImageView	tech_ico11	 = view.findViewById(R.id.	tech_ico11);
        ImageView	tech_ico12	 = view.findViewById(R.id.	tech_ico12);
        ImageView	tech_ico13	 = view.findViewById(R.id.	tech_ico13);
        ImageView	tech_ico14	 = view.findViewById(R.id.	tech_ico14);
        ImageView	tech_ico15	 = view.findViewById(R.id.	tech_ico15);
        ImageView	tech_ico16	 = view.findViewById(R.id.	tech_ico16);
        ImageView	tech_ico17	 = view.findViewById(R.id.	tech_ico17);
        ImageView	tech_ico18	 = view.findViewById(R.id.	tech_ico18);
        ImageView	tech_ico19	 = view.findViewById(R.id.	tech_ico19);
        ImageView	tech_ico20	 = view.findViewById(R.id.	tech_ico20);
        ImageView	tech_ico21	 = view.findViewById(R.id.	tech_ico21);
        ImageView	tech_ico22	 = view.findViewById(R.id.	tech_ico22);
        ImageView	tech_ico23	 = view.findViewById(R.id.	tech_ico23);
        ImageView	tech_ico24	 = view.findViewById(R.id.	tech_ico24);
        ImageView	tech_ico25	 = view.findViewById(R.id.	tech_ico25);
        ImageView	tech_ico26	 = view.findViewById(R.id.	tech_ico26);
        ImageView	tech_ico27	 = view.findViewById(R.id.	tech_ico27);
        ImageView	tech_ico28	 = view.findViewById(R.id.	tech_ico28);
        ImageView	tech_ico29	 = view.findViewById(R.id.	tech_ico29);
        ImageView	tech_ico30	 = view.findViewById(R.id.	tech_ico30);
        ImageView	tech_ico31	 = view.findViewById(R.id.	tech_ico31);
        ImageView	tech_ico32	 = view.findViewById(R.id.	tech_ico32);
        ImageView	tech_ico33	 = view.findViewById(R.id.	tech_ico33);
        ImageView	tech_ico34	 = view.findViewById(R.id.	tech_ico34);
        ImageView	tech_ico35	 = view.findViewById(R.id.	tech_ico35);
        ImageView	tech_ico36	 = view.findViewById(R.id.	tech_ico36);
        ImageView	tech_ico37	 = view.findViewById(R.id.	tech_ico37);
        ImageView	tech_ico38	 = view.findViewById(R.id.	tech_ico38);
        ImageView	tech_ico39	 = view.findViewById(R.id.	tech_ico39);
        ImageView	tech_ico40	 = view.findViewById(R.id.	tech_ico40);
        ImageView	tech_ico41	 = view.findViewById(R.id.	tech_ico41);
        ImageView	tech_ico42	 = view.findViewById(R.id.	tech_ico42);
        ImageView	tech_ico43	 = view.findViewById(R.id.	tech_ico43);
        ImageView	tech_ico44	 = view.findViewById(R.id.	tech_ico44);
        ImageView	tech_ico45	 = view.findViewById(R.id.	tech_ico45);
        ImageView	tech_ico46	 = view.findViewById(R.id.	tech_ico46);
        ImageView	tech_ico47	 = view.findViewById(R.id.	tech_ico47);
        ImageView	tech_ico48	 = view.findViewById(R.id.	tech_ico48);
        ImageView	tech_ico49	 = view.findViewById(R.id.	tech_ico49);
        ImageView	tech_ico50	 = view.findViewById(R.id.	tech_ico50);
        ImageView	tech_ico51	 = view.findViewById(R.id.	tech_ico51);
        ImageView	tech_ico52	 = view.findViewById(R.id.	tech_ico52);
        ImageView	tech_ico53	 = view.findViewById(R.id.	tech_ico53);
        ImageView	tech_ico54	 = view.findViewById(R.id.	tech_ico54);
        ImageView	tech_ico55	 = view.findViewById(R.id.	tech_ico55);
        ImageView	tech_ico56	 = view.findViewById(R.id.	tech_ico56);
        ImageView	tech_ico57	 = view.findViewById(R.id.	tech_ico57);
        ImageView	tech_ico58	 = view.findViewById(R.id.	tech_ico58);
        ImageView	tech_ico59	 = view.findViewById(R.id.	tech_ico59);
        ImageView	tech_ico60	 = view.findViewById(R.id.	tech_ico60);
        ImageView	tech_ico61	 = view.findViewById(R.id.	tech_ico61);
        ImageView	tech_ico62	 = view.findViewById(R.id.	tech_ico62);
        ImageView	tech_ico63	 = view.findViewById(R.id.	tech_ico63);
        ImageView	tech_ico64	 = view.findViewById(R.id.	tech_ico64);
        ImageView	tech_ico65	 = view.findViewById(R.id.	tech_ico65);
        ImageView	tech_ico66	 = view.findViewById(R.id.	tech_ico66);
        ImageView	tech_ico67	 = view.findViewById(R.id.	tech_ico67);
        ImageView	tech_ico68	 = view.findViewById(R.id.	tech_ico68);
        ImageView	tech_ico69	 = view.findViewById(R.id.	tech_ico69);
        ImageView	tech_ico70	 = view.findViewById(R.id.	tech_ico70);
        ImageView	tech_ico71	 = view.findViewById(R.id.	tech_ico71);
        ImageView	tech_ico72	 = view.findViewById(R.id.	tech_ico72);
        ImageView	tech_ico73	 = view.findViewById(R.id.	tech_ico73);
        ImageView	tech_ico74	 = view.findViewById(R.id.	tech_ico74);
        ImageView	tech_ico75	 = view.findViewById(R.id.	tech_ico75);
        ImageView	tech_ico76	 = view.findViewById(R.id.	tech_ico76);
        ImageView	tech_ico77	 = view.findViewById(R.id.	tech_ico77);
        ImageView	tech_ico78	 = view.findViewById(R.id.	tech_ico78);
        ImageView	tech_ico79	 = view.findViewById(R.id.	tech_ico79);
        ImageView	tech_ico80	 = view.findViewById(R.id.	tech_ico80);
        ImageView	tech_ico81	 = view.findViewById(R.id.	tech_ico81);
        ImageView	tech_ico82	 = view.findViewById(R.id.	tech_ico82);
        ImageView	tech_ico83	 = view.findViewById(R.id.	tech_ico83);
        ImageView	tech_ico84	 = view.findViewById(R.id.	tech_ico84);
        ImageView	tech_ico85	 = view.findViewById(R.id.	tech_ico85);
        ImageView	tech_ico86	 = view.findViewById(R.id.	tech_ico86);
        ImageView	tech_ico87	 = view.findViewById(R.id.	tech_ico87);
        ImageView	tech_ico88	 = view.findViewById(R.id.	tech_ico88);
        ImageView	tech_ico89	 = view.findViewById(R.id.	tech_ico89);
        ImageView	tech_ico90	 = view.findViewById(R.id.	tech_ico90);
        ImageView	tech_ico91	 = view.findViewById(R.id.	tech_ico91);
        ImageView	tech_ico92	 = view.findViewById(R.id.	tech_ico92);
        ImageView	tech_ico93	 = view.findViewById(R.id.	tech_ico93);
        ImageView	tech_ico94	 = view.findViewById(R.id.	tech_ico94);
        ImageView	tech_ico95	 = view.findViewById(R.id.	tech_ico95);
        ImageView	tech_ico96	 = view.findViewById(R.id.	tech_ico96);
        ImageView	tech_ico97	 = view.findViewById(R.id.	tech_ico97);
        ImageView	tech_ico98	 = view.findViewById(R.id.	tech_ico98);
        ImageView	tech_ico99	 = view.findViewById(R.id.	tech_ico99);
        ImageView	tech_ico100	 = view.findViewById(R.id.	tech_ico100);
        ImageView	tech_ico101	 = view.findViewById(R.id.	tech_ico101);
        ImageView	tech_ico102	 = view.findViewById(R.id.	tech_ico102);
        ImageView	tech_ico103	 = view.findViewById(R.id.	tech_ico103);
        ImageView	tech_ico104	 = view.findViewById(R.id.	tech_ico104);
        ImageView	tech_ico105	 = view.findViewById(R.id.	tech_ico105);
        ImageView	tech_ico106	 = view.findViewById(R.id.	tech_ico106);
        ImageView	tech_ico107	 = view.findViewById(R.id.	tech_ico107);
        ImageView	tech_ico108	 = view.findViewById(R.id.	tech_ico108);
        ImageView	tech_ico109	 = view.findViewById(R.id.	tech_ico109);
        ImageView	tech_ico110	 = view.findViewById(R.id.	tech_ico110);
        ImageView	tech_ico111	 = view.findViewById(R.id.	tech_ico111);
        ImageView	tech_ico112	 = view.findViewById(R.id.	tech_ico112);
        ImageView	tech_ico113	 = view.findViewById(R.id.	tech_ico113);
        ImageView	tech_ico114	 = view.findViewById(R.id.	tech_ico114);
        ImageView	tech_ico115	 = view.findViewById(R.id.	tech_ico115);
        ImageView	tech_ico116	 = view.findViewById(R.id.	tech_ico116);
        ImageView	tech_ico117	 = view.findViewById(R.id.	tech_ico117);
        ImageView	tech_ico118	 = view.findViewById(R.id.	tech_ico118);
        ImageView	tech_ico119	 = view.findViewById(R.id.	tech_ico119);
        ImageView	tech_ico120	 = view.findViewById(R.id.	tech_ico120);
        ImageView	tech_ico121	 = view.findViewById(R.id.	tech_ico121);
        ImageView	tech_ico122	 = view.findViewById(R.id.	tech_ico122);
        ImageView	tech_ico123	 = view.findViewById(R.id.	tech_ico123);
        ImageView	tech_ico124	 = view.findViewById(R.id.	tech_ico124);
        ImageView	tech_ico125	 = view.findViewById(R.id.	tech_ico125);
        ImageView	tech_ico126	 = view.findViewById(R.id.	tech_ico126);
        ImageView	tech_ico127	 = view.findViewById(R.id.	tech_ico127);
        ImageView	tech_ico128	 = view.findViewById(R.id.	tech_ico128);
        ImageView	tech_ico129	 = view.findViewById(R.id.	tech_ico129);
        ImageView	tech_ico130	 = view.findViewById(R.id.	tech_ico130);
        ImageView	tech_ico131	 = view.findViewById(R.id.	tech_ico131);
        ImageView	tech_ico132	 = view.findViewById(R.id.	tech_ico132);
        ImageView	tech_ico133	 = view.findViewById(R.id.	tech_ico133);
        ImageView	tech_ico134	 = view.findViewById(R.id.	tech_ico134);
        ImageView	tech_ico135	 = view.findViewById(R.id.	tech_ico135);
        ImageView	tech_ico136	 = view.findViewById(R.id.	tech_ico136);
        ImageView	tech_ico137	 = view.findViewById(R.id.	tech_ico137);
        ImageView	tech_ico138	 = view.findViewById(R.id.	tech_ico138);

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

        tech_ico1.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_res_a_2); tech_id[x-1] =1;tech_cal_buffId =1 ; then(next_card,troop_name,x);}});
        tech_ico2.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_res_a_3); tech_id[x-1] =2;tech_cal_buffId =2 ; then(next_card,troop_name,x);}});
        tech_ico3.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_res_a_4); tech_id[x-1] =3;tech_cal_buffId =3 ; then(next_card,troop_name,x);}});
        tech_ico4.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_res_a_5); tech_id[x-1] =4;tech_cal_buffId =4 ; then(next_card,troop_name,x);}});
        tech_ico5.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_res_a_6); tech_id[x-1] =5;tech_cal_buffId =5 ; then(next_card,troop_name,x);}});
        tech_ico6.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_res_a_7); tech_id[x-1] =6;tech_cal_buffId =6 ; then(next_card,troop_name,x);}});
        tech_ico7.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_res_a_8); tech_id[x-1] =7;tech_cal_buffId =7 ; then(next_card,troop_name,x);}});
        tech_ico8.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_res_a_9); tech_id[x-1] =8;tech_cal_buffId =8 ; then(next_card,troop_name,x);}});
        tech_ico9.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_res_a_10); tech_id[x-1] =9;tech_cal_buffId =9 ; then(next_card,troop_name,x);}});
        tech_ico10.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_res_a_11); tech_id[x-1] =10;tech_cal_buffId =10 ; then(next_card,troop_name,x);}});
        tech_ico11.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_res_a_2); tech_id[x-1] =11;tech_cal_buffId =1 ; then(next_card,troop_name,x);}});
        tech_ico12.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_res_a_3); tech_id[x-1] =12;tech_cal_buffId =2 ; then(next_card,troop_name,x);}});
        tech_ico13.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_res_a_4); tech_id[x-1] =13;tech_cal_buffId =3 ; then(next_card,troop_name,x);}});
        tech_ico14.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_res_a_5); tech_id[x-1] =14;tech_cal_buffId =4 ; then(next_card,troop_name,x);}});
        tech_ico15.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_res_a_6); tech_id[x-1] =15;tech_cal_buffId =5 ; then(next_card,troop_name,x);}});
        tech_ico16.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_res_a_7); tech_id[x-1] =16;tech_cal_buffId =6 ; then(next_card,troop_name,x);}});
        tech_ico17.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_res_a_8); tech_id[x-1] =17;tech_cal_buffId =7 ; then(next_card,troop_name,x);}});
        tech_ico18.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_res_a_9); tech_id[x-1] =18;tech_cal_buffId =8 ; then(next_card,troop_name,x);}});
        tech_ico19.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_res_a_10); tech_id[x-1] =19;tech_cal_buffId =9 ; then(next_card,troop_name,x);}});
        tech_ico20.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_res_a_11); tech_id[x-1] =20;tech_cal_buffId =10 ; then(next_card,troop_name,x);}});
        tech_ico21.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_dev_a_1); tech_id[x-1] =21;tech_cal_buffId =11 ; then(next_card,troop_name,x);}});
        tech_ico22.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_dev_a_6); tech_id[x-1] =22;tech_cal_buffId =12 ; then(next_card,troop_name,x);}});
        tech_ico23.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_dev_a_7); tech_id[x-1] =23;tech_cal_buffId =13 ; then(next_card,troop_name,x);}});
        tech_ico24.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_dev_a_2); tech_id[x-1] =24;tech_cal_buffId =14 ; then(next_card,troop_name,x);}});
        tech_ico25.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_dev_a_4); tech_id[x-1] =25;tech_cal_buffId =15 ; then(next_card,troop_name,x);}});
        tech_ico26.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_dev_a_5); tech_id[x-1] =26;tech_cal_buffId =16 ; then(next_card,troop_name,x);}});
        tech_ico27.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_dev_a_3); tech_id[x-1] =27;tech_cal_buffId =17 ; then(next_card,troop_name,x);}});
        tech_ico28.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_dev_a_6); tech_id[x-1] =28;tech_cal_buffId =12 ; then(next_card,troop_name,x);}});
        tech_ico29.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_dev_a_7); tech_id[x-1] =29;tech_cal_buffId =13 ; then(next_card,troop_name,x);}});
        tech_ico30.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_dev_a_1); tech_id[x-1] =30;tech_cal_buffId =11 ; then(next_card,troop_name,x);}});
        tech_ico31.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_dev_a_2); tech_id[x-1] =31;tech_cal_buffId =14 ; then(next_card,troop_name,x);}});
        tech_ico32.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_dev_a_4); tech_id[x-1] =32;tech_cal_buffId =15 ; then(next_card,troop_name,x);}});
        tech_ico33.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_dev_a_5); tech_id[x-1] =33;tech_cal_buffId =16 ; then(next_card,troop_name,x);}});
        tech_ico34.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_dev_a_3); tech_id[x-1] =34;tech_cal_buffId =17 ; then(next_card,troop_name,x);}});
        tech_ico35.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_def_a_1); tech_id[x-1] =35;tech_cal_buffId =18 ; then(next_card,troop_name,x);}});
        tech_ico36.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_def_a_2); tech_id[x-1] =36;tech_cal_buffId =19 ; then(next_card,troop_name,x);}});
        tech_ico37.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_def_a_3); tech_id[x-1] =37;tech_cal_buffId =20 ; then(next_card,troop_name,x);}});
        tech_ico38.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_def_a_4); tech_id[x-1] =38;tech_cal_buffId =21 ; then(next_card,troop_name,x);}});
        tech_ico39.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_def_a_7); tech_id[x-1] =39;tech_cal_buffId =22 ; then(next_card,troop_name,x);}});
        tech_ico40.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_def_a_5); tech_id[x-1] =40;tech_cal_buffId =23 ; then(next_card,troop_name,x);}});
        tech_ico41.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_def_a_6); tech_id[x-1] =41;tech_cal_buffId =24 ; then(next_card,troop_name,x);}});
        tech_ico42.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_def_a_8); tech_id[x-1] =42;tech_cal_buffId =25 ; then(next_card,troop_name,x);}});
        tech_ico43.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_def_a_9); tech_id[x-1] =43;tech_cal_buffId =26 ; then(next_card,troop_name,x);}});
        tech_ico44.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_def_a_10); tech_id[x-1] =44;tech_cal_buffId =27 ; then(next_card,troop_name,x);}});
        tech_ico45.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_def_a_1); tech_id[x-1] =45;tech_cal_buffId =18 ; then(next_card,troop_name,x);}});
        tech_ico46.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_def_a_2); tech_id[x-1] =46;tech_cal_buffId =19 ; then(next_card,troop_name,x);}});
        tech_ico47.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_def_a_3); tech_id[x-1] =47;tech_cal_buffId =20 ; then(next_card,troop_name,x);}});
        tech_ico48.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_def_a_5); tech_id[x-1] =48;tech_cal_buffId =21 ; then(next_card,troop_name,x);}});
        tech_ico49.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_def_a_6); tech_id[x-1] =49;tech_cal_buffId =24 ; then(next_card,troop_name,x);}});
        tech_ico50.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_def_a_7); tech_id[x-1] =50;tech_cal_buffId =22 ; then(next_card,troop_name,x);}});
        tech_ico51.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_def_a_8); tech_id[x-1] =51;tech_cal_buffId =25 ; then(next_card,troop_name,x);}});
        tech_ico52.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_def_a_9); tech_id[x-1] =52;tech_cal_buffId =26 ; then(next_card,troop_name,x);}});
        tech_ico53.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_1); tech_id[x-1] =53;tech_cal_buffId =28 ; then(next_card,troop_name,x);}});
        tech_ico54.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_2); tech_id[x-1] =54;tech_cal_buffId =29 ; then(next_card,troop_name,x);}});
        tech_ico55.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_3); tech_id[x-1] =55;tech_cal_buffId =30 ; then(next_card,troop_name,x);}});
        tech_ico56.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_4); tech_id[x-1] =56;tech_cal_buffId =31 ; then(next_card,troop_name,x);}});
        tech_ico57.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_6); tech_id[x-1] =57;tech_cal_buffId =32 ; then(next_card,troop_name,x);}});
        tech_ico58.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_7); tech_id[x-1] =58;tech_cal_buffId =33 ; then(next_card,troop_name,x);}});
        tech_ico59.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_8); tech_id[x-1] =59;tech_cal_buffId =34 ; then(next_card,troop_name,x);}});
        tech_ico60.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_9); tech_id[x-1] =60;tech_cal_buffId =35 ; then(next_card,troop_name,x);}});
        tech_ico61.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_11); tech_id[x-1] =61;tech_cal_buffId =36 ; then(next_card,troop_name,x);}});
        tech_ico62.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_12); tech_id[x-1] =62;tech_cal_buffId =37 ; then(next_card,troop_name,x);}});
        tech_ico63.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_13); tech_id[x-1] =63;tech_cal_buffId =38 ; then(next_card,troop_name,x);}});
        tech_ico64.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_14); tech_id[x-1] =64;tech_cal_buffId =39 ; then(next_card,troop_name,x);}});
        tech_ico65.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_16); tech_id[x-1] =65;tech_cal_buffId =40 ; then(next_card,troop_name,x);}});
        tech_ico66.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_11); tech_id[x-1] =66;tech_cal_buffId =36 ; then(next_card,troop_name,x);}});
        tech_ico67.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_2); tech_id[x-1] =67;tech_cal_buffId =29 ; then(next_card,troop_name,x);}});
        tech_ico68.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_3); tech_id[x-1] =68;tech_cal_buffId =30 ; then(next_card,troop_name,x);}});
        tech_ico69.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_4); tech_id[x-1] =69;tech_cal_buffId =31 ; then(next_card,troop_name,x);}});
        tech_ico70.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_1); tech_id[x-1] =70;tech_cal_buffId =28 ; then(next_card,troop_name,x);}});
        tech_ico71.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_7); tech_id[x-1] =71;tech_cal_buffId =33 ; then(next_card,troop_name,x);}});
        tech_ico72.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_8); tech_id[x-1] =72;tech_cal_buffId =34 ; then(next_card,troop_name,x);}});
        tech_ico73.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_9); tech_id[x-1] =73;tech_cal_buffId =35 ; then(next_card,troop_name,x);}});
        tech_ico74.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_6); tech_id[x-1] =74;tech_cal_buffId =32 ; then(next_card,troop_name,x);}});
        tech_ico75.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_12); tech_id[x-1] =75;tech_cal_buffId =37 ; then(next_card,troop_name,x);}});
        tech_ico76.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_13); tech_id[x-1] =76;tech_cal_buffId =38 ; then(next_card,troop_name,x);}});
        tech_ico77.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_14); tech_id[x-1] =77;tech_cal_buffId =39 ; then(next_card,troop_name,x);}});
        tech_ico78.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_16); tech_id[x-1] =78;tech_cal_buffId =40 ; then(next_card,troop_name,x);}});
        tech_ico79.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_11); tech_id[x-1] =79;tech_cal_buffId =36 ; then(next_card,troop_name,x);}});
        tech_ico80.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_2); tech_id[x-1] =80;tech_cal_buffId =29 ; then(next_card,troop_name,x);}});
        tech_ico81.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_3); tech_id[x-1] =81;tech_cal_buffId =30 ; then(next_card,troop_name,x);}});
        tech_ico82.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_4); tech_id[x-1] =82;tech_cal_buffId =31 ; then(next_card,troop_name,x);}});
        tech_ico83.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_1); tech_id[x-1] =83;tech_cal_buffId =28 ; then(next_card,troop_name,x);}});
        tech_ico84.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_7); tech_id[x-1] =84;tech_cal_buffId =33 ; then(next_card,troop_name,x);}});
        tech_ico85.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_8); tech_id[x-1] =85;tech_cal_buffId =34 ; then(next_card,troop_name,x);}});
        tech_ico86.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_9); tech_id[x-1] =86;tech_cal_buffId =35 ; then(next_card,troop_name,x);}});
        tech_ico87.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_6); tech_id[x-1] =87;tech_cal_buffId =32 ; then(next_card,troop_name,x);}});
        tech_ico88.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_12); tech_id[x-1] =88;tech_cal_buffId =37 ; then(next_card,troop_name,x);}});
        tech_ico89.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_13); tech_id[x-1] =89;tech_cal_buffId =38 ; then(next_card,troop_name,x);}});
        tech_ico90.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_14); tech_id[x-1] =90;tech_cal_buffId =39 ; then(next_card,troop_name,x);}});
        tech_ico91.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_mil_a_16); tech_id[x-1] =91;tech_cal_buffId =40 ; then(next_card,troop_name,x);}});
        tech_ico92.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_fit_a_1); tech_id[x-1] =92;tech_cal_buffId =41 ; then(next_card,troop_name,x);}});
        tech_ico93.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_fit_a_2); tech_id[x-1] =93;tech_cal_buffId =42 ; then(next_card,troop_name,x);}});
        tech_ico94.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_fit_a_6); tech_id[x-1] =94;tech_cal_buffId =43 ; then(next_card,troop_name,x);}});
        tech_ico95.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_fit_a_3); tech_id[x-1] =95;tech_cal_buffId =44 ; then(next_card,troop_name,x);}});
        tech_ico96.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_fit_a_4); tech_id[x-1] =96;tech_cal_buffId =45 ; then(next_card,troop_name,x);}});
        tech_ico97.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_fit_a_7); tech_id[x-1] =97;tech_cal_buffId =46 ; then(next_card,troop_name,x);}});
        tech_ico98.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_fit_a_8); tech_id[x-1] =98;tech_cal_buffId =47 ; then(next_card,troop_name,x);}});
        tech_ico99.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_fit_a_5); tech_id[x-1] =99;tech_cal_buffId =48 ; then(next_card,troop_name,x);}});
        tech_ico100.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_fit_a_9); tech_id[x-1] =100;tech_cal_buffId =49 ; then(next_card,troop_name,x);}});
        tech_ico101.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_fit_a_10); tech_id[x-1] =101;tech_cal_buffId =50 ; then(next_card,troop_name,x);}});
        tech_ico102.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_fit_a_11); tech_id[x-1] =102;tech_cal_buffId =51 ; then(next_card,troop_name,x);}});
        tech_ico103.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_fit_a_12); tech_id[x-1] =103;tech_cal_buffId =52 ; then(next_card,troop_name,x);}});
        tech_ico104.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_fit_a_13); tech_id[x-1] =104;tech_cal_buffId =53 ; then(next_card,troop_name,x);}});
        tech_ico105.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_fit_a_17); tech_id[x-1] =105;tech_cal_buffId =54 ; then(next_card,troop_name,x);}});
        tech_ico106.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_fit_a_14); tech_id[x-1] =106;tech_cal_buffId =55 ; then(next_card,troop_name,x);}});
        tech_ico107.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_fit_a_15); tech_id[x-1] =107;tech_cal_buffId =56 ; then(next_card,troop_name,x);}});
        tech_ico108.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_fit_a_16); tech_id[x-1] =108;tech_cal_buffId =57 ; then(next_card,troop_name,x);}});
        tech_ico109.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_fit_a_17); tech_id[x-1] =109;tech_cal_buffId =58 ; then(next_card,troop_name,x);}});
        tech_ico110.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_fit_a_18); tech_id[x-1] =110;tech_cal_buffId =59 ; then(next_card,troop_name,x);}});
        tech_ico111.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_deaf_a_1); tech_id[x-1] =111;tech_cal_buffId =60 ; then(next_card,troop_name,x);}});
        tech_ico112.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_deaf_a_2); tech_id[x-1] =112;tech_cal_buffId =61 ; then(next_card,troop_name,x);}});
        tech_ico113.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_deaf_a_11); tech_id[x-1] =113;tech_cal_buffId =62 ; then(next_card,troop_name,x);}});
        tech_ico114.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_deaf_a_3); tech_id[x-1] =114;tech_cal_buffId =63 ; then(next_card,troop_name,x);}});
        tech_ico115.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_deaf_a_4); tech_id[x-1] =115;tech_cal_buffId =64 ; then(next_card,troop_name,x);}});
        tech_ico116.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_deaf_a_12); tech_id[x-1] =116;tech_cal_buffId =65 ; then(next_card,troop_name,x);}});
        tech_ico117.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_deaf_a_13); tech_id[x-1] =117;tech_cal_buffId =66 ; then(next_card,troop_name,x);}});
        tech_ico118.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_deaf_a_9); tech_id[x-1] =118;tech_cal_buffId =67 ; then(next_card,troop_name,x);}});
        tech_ico119.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_deaf_a_14); tech_id[x-1] =119;tech_cal_buffId =68 ; then(next_card,troop_name,x);}});
        tech_ico120.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_deaf_a_10); tech_id[x-1] =120;tech_cal_buffId =69 ; then(next_card,troop_name,x);}});
        tech_ico121.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_deaf_a_14); tech_id[x-1] =121;tech_cal_buffId =70 ; then(next_card,troop_name,x);}});
        tech_ico122.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_deaf_a_7); tech_id[x-1] =122;tech_cal_buffId =71 ; then(next_card,troop_name,x);}});
        tech_ico123.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_deaf_a_8); tech_id[x-1] =123;tech_cal_buffId =72 ; then(next_card,troop_name,x);}});
        tech_ico124.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_deaf_a_15); tech_id[x-1] =124;tech_cal_buffId =73 ; then(next_card,troop_name,x);}});
        tech_ico125.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_deaf_a_9); tech_id[x-1] =125;tech_cal_buffId =74 ; then(next_card,troop_name,x);}});
        tech_ico126.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_deaf_a_16); tech_id[x-1] =126;tech_cal_buffId =75 ; then(next_card,troop_name,x);}});
        tech_ico127.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_deaf_a_17); tech_id[x-1] =127;tech_cal_buffId =76 ; then(next_card,troop_name,x);}});
        tech_ico128.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_zombie_9); tech_id[x-1] =128;tech_cal_buffId =77 ; then(next_card,troop_name,x);}});
        tech_ico129.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_zombie_2); tech_id[x-1] =129;tech_cal_buffId =78 ; then(next_card,troop_name,x);}});
        tech_ico130.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_zombie_1); tech_id[x-1] =130;tech_cal_buffId =79 ; then(next_card,troop_name,x);}});
        tech_ico131.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_zombie_11); tech_id[x-1] =131;tech_cal_buffId =80 ; then(next_card,troop_name,x);}});
        tech_ico132.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_zombie_10); tech_id[x-1] =132;tech_cal_buffId =81 ; then(next_card,troop_name,x);}});
        tech_ico133.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_zombie_8); tech_id[x-1] =133;tech_cal_buffId =82 ; then(next_card,troop_name,x);}});
        tech_ico134.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_zombie_4); tech_id[x-1] =134;tech_cal_buffId =83 ; then(next_card,troop_name,x);}});
        tech_ico135.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_zombie_5); tech_id[x-1] =135;tech_cal_buffId =84 ; then(next_card,troop_name,x);}});
        tech_ico136.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_zombie_6); tech_id[x-1] =136;tech_cal_buffId =85 ; then(next_card,troop_name,x);}});
        tech_ico137.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_zombie_7); tech_id[x-1] =137;tech_cal_buffId =86 ; then(next_card,troop_name,x);}});
        tech_ico138.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();troop_choose.setImageResource(R.drawable.science_zombie_3); tech_id[x-1] =138;tech_cal_buffId =87 ; then(next_card,troop_name,x);}});

    }

    public void then (CardView next_card,TextView troop_name,int x){
        next_card.setVisibility(View.VISIBLE);
        troop_name.setText(getString(techName[tech_id[x-1]-1]));
        int start_pb = 0, end_pb = 0;
        x_id[x-1] = tech_id[x-1];
        if (x == 1){	team_ll1.setVisibility(View.VISIBLE);	start_pb1.setMax	(tech_len[tech_id[x-1]]-1);end_pb1.setMax(	tech_len[tech_id[x-1]]);start_pb = start_pb1.getProgress();end_pb = end_pb1.getProgress();}
        if (x == 2){	team_ll2.setVisibility(View.VISIBLE);	start_pb2.setMax	(tech_len[tech_id[x-1]]-1);end_pb2.setMax(	tech_len[tech_id[x-1]]);start_pb = start_pb2.getProgress();end_pb = end_pb2.getProgress();}
        if (x == 3){	team_ll3.setVisibility(View.VISIBLE);	start_pb3.setMax	(tech_len[tech_id[x-1]]-1);end_pb3.setMax(	tech_len[tech_id[x-1]]);start_pb = start_pb3.getProgress();end_pb = end_pb3.getProgress();}
        if (x == 4){	team_ll4.setVisibility(View.VISIBLE);	start_pb4.setMax	(tech_len[tech_id[x-1]]-1);end_pb4.setMax(	tech_len[tech_id[x-1]]);start_pb = start_pb4.getProgress();end_pb = end_pb4.getProgress();}
        if (x == 5){	team_ll5.setVisibility(View.VISIBLE);	start_pb5.setMax	(tech_len[tech_id[x-1]]-1);end_pb5.setMax(	tech_len[tech_id[x-1]]);start_pb = start_pb5.getProgress();end_pb = end_pb5.getProgress();}
        if (x == 6){	team_ll6.setVisibility(View.VISIBLE);	start_pb6.setMax	(tech_len[tech_id[x-1]]-1);end_pb6.setMax(	tech_len[tech_id[x-1]]);start_pb = start_pb6.getProgress();end_pb = end_pb6.getProgress();}
        if (x == 7){	team_ll7.setVisibility(View.VISIBLE);	start_pb7.setMax	(tech_len[tech_id[x-1]]-1);end_pb7.setMax(	tech_len[tech_id[x-1]]);start_pb = start_pb7.getProgress();end_pb = end_pb7.getProgress();}
        if (x == 8){	team_ll8.setVisibility(View.VISIBLE);	start_pb8.setMax	(tech_len[tech_id[x-1]]-1);end_pb8.setMax(	tech_len[tech_id[x-1]]);start_pb = start_pb8.getProgress();end_pb = end_pb8.getProgress();}
        if (x == 9){	team_ll9.setVisibility(View.VISIBLE);	start_pb9.setMax	(tech_len[tech_id[x-1]]-1);end_pb9.setMax(	tech_len[tech_id[x-1]]);start_pb = start_pb9.getProgress();end_pb = end_pb9.getProgress();}
        if (x == 10){	team_ll10.setVisibility(View.VISIBLE);	start_pb10.setMax	(tech_len[tech_id[x-1]]-1);end_pb10.setMax(	tech_len[tech_id[x-1]]);start_pb = start_pb10.getProgress();end_pb = end_pb10.getProgress();}
        tech_cal(x);
    }

    public void tech_cal(int x){
        TechLib techLib = new TechLib();
        int start_pb = 0, end_pb = 0;
        fuel_team = new long[] {0,0,0,0,0,0,0,0,0,0};
        food_team = new long[] {0,0,0,0,0,0,0,0,0,0};
        steel_team = new long[] {0,0,0,0,0,0,0,0,0,0};
        alloy_team = new long[] {0,0,0,0,0,0,0,0,0,0};
        time_team = new long[] {0,0,0,0,0,0,0,0,0,0};
        kyanite_team = new long[] {0,0,0,0,0,0,0,0,0,0};
        kyanite_basic_team = new long[] {0,0,0,0,0,0,0,0,0,0};
        kyanite_cluster_team = new long[] {0,0,0,0,0,0,0,0,0,0};
        power_team = new long[] {0,0,0,0,0,0,0,0,0,0} ;
        diam_team = new long[] {0,0,0,0,0,0,0,0,0,0} ;

        TechLib_Time techLib_T = new TechLib_Time();

        for (int a = 0; a<9 ; a++){
            if (a ==0){if(isLoad == true ){start_pb = tech_s[a] ; end_pb = tech_e[a];Log.w("TTR", String.valueOf(start_pb));}else{start_pb = start_pb1.getProgress();end_pb = 	end_pb1.getProgress();}}
            if (a ==1){if(isLoad == true ){start_pb = tech_s[a] ; end_pb = tech_e[a];}else{start_pb =	start_pb2.getProgress();end_pb =	end_pb2.getProgress();}}
            if (a ==2){if(isLoad == true ){start_pb = tech_s[a] ; end_pb = tech_e[a];}else{start_pb =	start_pb3.getProgress();end_pb =	end_pb3.getProgress();}}
            if (a ==3){if(isLoad == true ){start_pb = tech_s[a] ; end_pb = tech_e[a];}else{start_pb =	start_pb4.getProgress();end_pb =	end_pb4.getProgress();}}
            if (a ==4){if(isLoad == true ){start_pb = tech_s[a] ; end_pb = tech_e[a];}else{start_pb =	start_pb5.getProgress();end_pb =	end_pb5.getProgress();}}
            if (a ==5){if(isLoad == true ){start_pb = tech_s[a] ; end_pb = tech_e[a];}else{start_pb =	start_pb6.getProgress();end_pb =	end_pb6.getProgress();}}
            if (a ==6){if(isLoad == true ){start_pb = tech_s[a] ; end_pb = tech_e[a];}else{start_pb =	start_pb7.getProgress();end_pb =	end_pb7.getProgress();}}
            if (a ==7){if(isLoad == true ){start_pb = tech_s[a] ; end_pb = tech_e[a];}else{start_pb =	start_pb8.getProgress();end_pb =	end_pb8.getProgress();}}
            if (a ==8){if(isLoad == true ){start_pb = tech_s[a] ; end_pb = tech_e[a];}else{start_pb =	start_pb9.getProgress();end_pb =	end_pb9.getProgress();}}
            if (a ==9){if(isLoad == true ){start_pb = tech_s[a] ; end_pb = tech_e[a];}else{start_pb =	start_pb10.getProgress();end_pb =	end_pb10.getProgress();}}
            Log.w("TTT", String.valueOf(start_pb));

            if(x_id[a] == 1){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){Log.wtf("LVL",String.valueOf(lvl)); fuel_team[x-1] = fuel_team[x-1] + techLib.燃料提純_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.燃料提純_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.燃料提純_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.燃料提純_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.燃料提純_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.燃料提純_power[lvl];time_team[x-1] = time_team[x-1] + techLib_T.燃料提純_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 2){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.肥料_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.肥料_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.肥料_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.肥料_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.肥料_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.肥料_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.肥料_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 3){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.儲藏室擴容_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.儲藏室擴容_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.儲藏室擴容_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.儲藏室擴容_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.儲藏室擴容_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.儲藏室擴容_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.儲藏室擴容_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 4){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.壓裂採油_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.壓裂採油_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.壓裂採油_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.壓裂採油_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.壓裂採油_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.壓裂採油_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.壓裂採油_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 5){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.冷藏運輸_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.冷藏運輸_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.冷藏運輸_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.冷藏運輸_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.冷藏運輸_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.冷藏運輸_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.冷藏運輸_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 6){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.軋鋼_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.軋鋼_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.軋鋼_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.軋鋼_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.軋鋼_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.軋鋼_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.軋鋼_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 7){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.爆破採礦_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.爆破採礦_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.爆破採礦_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.爆破採礦_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.爆破採礦_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.爆破採礦_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.爆破採礦_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 8){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高溫熔爐_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高溫熔爐_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高溫熔爐_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高溫熔爐_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高溫熔爐_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高溫熔爐_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高溫熔爐_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 9){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.碎礦器_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.碎礦器_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.碎礦器_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.碎礦器_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.碎礦器_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.碎礦器_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.碎礦器_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 10){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.鑽石提煉_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.鑽石提煉_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.鑽石提煉_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.鑽石提煉_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.鑽石提煉_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.鑽石提煉_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.鑽石提煉_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 11){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級燃料提純_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級燃料提純_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級燃料提純_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級燃料提純_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級燃料提純_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級燃料提純_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級燃料提純_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 12){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級肥料_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級肥料_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級肥料_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級肥料_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級肥料_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級肥料_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級肥料_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 13){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級儲藏室擴容_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級儲藏室擴容_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級儲藏室擴容_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級儲藏室擴容_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級儲藏室擴容_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級儲藏室擴容_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級儲藏室擴容_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 14){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級壓裂採油_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級壓裂採油_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級壓裂採油_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級壓裂採油_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級壓裂採油_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級壓裂採油_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級壓裂採油_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 15){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級冷藏運輸_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級冷藏運輸_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級冷藏運輸_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級冷藏運輸_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級冷藏運輸_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級冷藏運輸_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級冷藏運輸_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 16){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級軋鋼_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級軋鋼_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級軋鋼_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級軋鋼_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級軋鋼_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級軋鋼_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級軋鋼_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 17){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級爆破採礦_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級爆破採礦_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級爆破採礦_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級爆破採礦_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級爆破採礦_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級爆破採礦_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級爆破採礦_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 18){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級高溫熔爐_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級高溫熔爐_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級高溫熔爐_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級高溫熔爐_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級高溫熔爐_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級高溫熔爐_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級高溫熔爐_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 19){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級碎礦器_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級碎礦器_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級碎礦器_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級碎礦器_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級碎礦器_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級碎礦器_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級碎礦器_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 20){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級鑽石提煉_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級鑽石提煉_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級鑽石提煉_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級鑽石提煉_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級鑽石提煉_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級鑽石提煉_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級鑽石提煉_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 21){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.懸掛系統_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.懸掛系統_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.懸掛系統_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.懸掛系統_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.懸掛系統_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.懸掛系統_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.懸掛系統_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 22){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.急行軍_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.急行軍_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.急行軍_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.急行軍_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.急行軍_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.急行軍_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.急行軍_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 23){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.興奮劑_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.興奮劑_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.興奮劑_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.興奮劑_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.興奮劑_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.興奮劑_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.興奮劑_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 24){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.工程機械_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.工程機械_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.工程機械_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.工程機械_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.工程機械_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.工程機械_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.工程機械_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 25){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.醫療器械_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.醫療器械_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.醫療器械_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.醫療器械_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.醫療器械_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.醫療器械_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.醫療器械_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 26){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.醫療包_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.醫療包_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.醫療包_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.醫療包_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.醫療包_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.醫療包_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.醫療包_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 27){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.緊急軍糧_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.緊急軍糧_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.緊急軍糧_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.緊急軍糧_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.緊急軍糧_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.緊急軍糧_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.緊急軍糧_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 28){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級急行軍_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級急行軍_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級急行軍_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級急行軍_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級急行軍_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級急行軍_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級急行軍_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 29){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級興奮劑_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級興奮劑_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級興奮劑_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級興奮劑_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級興奮劑_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級興奮劑_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級興奮劑_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 30){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級懸掛系統_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級懸掛系統_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級懸掛系統_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級懸掛系統_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級懸掛系統_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級懸掛系統_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級懸掛系統_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 31){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級工程器械_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級工程器械_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級工程器械_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級工程器械_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級工程器械_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級工程器械_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級工程器械_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 32){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級醫療設施_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級醫療設施_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級醫療設施_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級醫療設施_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級醫療設施_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級醫療設施_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級醫療設施_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 33){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級醫療包_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級醫療包_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級醫療包_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級醫療包_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級醫療包_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級醫療包_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級醫療包_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 34){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級補給罐頭_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級補給罐頭_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級補給罐頭_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級補給罐頭_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級補給罐頭_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級補給罐頭_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級補給罐頭_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 35){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.加固圍牆_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.加固圍牆_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.加固圍牆_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.加固圍牆_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.加固圍牆_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.加固圍牆_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.加固圍牆_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 36){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.彈藥補給_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.彈藥補給_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.彈藥補給_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.彈藥補給_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.彈藥補給_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.彈藥補給_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.彈藥補給_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 37){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.合金學園圍牆_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.合金學園圍牆_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.合金學園圍牆_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.合金學園圍牆_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.合金學園圍牆_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.合金學園圍牆_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.合金學園圍牆_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 38){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.彈道學_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.彈道學_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.彈道學_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.彈道學_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.彈道學_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.彈道學_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.彈道學_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 39){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.預製破片_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.預製破片_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.預製破片_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.預製破片_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.預製破片_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.預製破片_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.預製破片_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 40){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.城防結構_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.城防結構_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.城防結構_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.城防結構_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.城防結構_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.城防結構_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.城防結構_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 41){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.粘著燃料_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.粘著燃料_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.粘著燃料_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.粘著燃料_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.粘著燃料_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.粘著燃料_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.粘著燃料_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 42){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.聚能炸藥_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.聚能炸藥_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.聚能炸藥_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.聚能炸藥_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.聚能炸藥_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.聚能炸藥_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.聚能炸藥_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 43){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.機械化生產_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.機械化生產_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.機械化生產_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.機械化生產_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.機械化生產_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.機械化生產_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.機械化生產_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 44){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.戰地急救_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.戰地急救_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.戰地急救_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.戰地急救_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.戰地急救_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.戰地急救_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.戰地急救_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 45){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級加固圍牆_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級加固圍牆_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級加固圍牆_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級加固圍牆_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級加固圍牆_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級加固圍牆_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級加固圍牆_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 46){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級彈藥補給_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級彈藥補給_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級彈藥補給_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級彈藥補給_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級彈藥補給_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級彈藥補給_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級彈藥補給_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 47){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級合金學園圍牆_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級合金學園圍牆_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級合金學園圍牆_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級合金學園圍牆_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級合金學園圍牆_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級合金學園圍牆_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級合金學園圍牆_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 48){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級城防結構_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級城防結構_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級城防結構_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級城防結構_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級城防結構_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級城防結構_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級城防結構_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 49){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級黏著燃料_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級黏著燃料_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級黏著燃料_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級黏著燃料_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級黏著燃料_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級黏著燃料_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級黏著燃料_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 50){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級預製破片_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級預製破片_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級預製破片_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級預製破片_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級預製破片_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級預製破片_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級預製破片_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 51){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級聚能炸藥_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級聚能炸藥_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級聚能炸藥_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級聚能炸藥_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級聚能炸藥_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級聚能炸藥_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級聚能炸藥_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 52){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級機械化生產_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級機械化生產_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級機械化生產_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級機械化生產_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級機械化生產_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級機械化生產_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級機械化生產_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 53){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.動員令_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.動員令_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.動員令_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.動員令_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.動員令_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.動員令_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.動員令_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 54){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.搏鬥術_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.搏鬥術_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.搏鬥術_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.搏鬥術_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.搏鬥術_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.搏鬥術_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.搏鬥術_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 55){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.精準射擊_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.精準射擊_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.精準射擊_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.精準射擊_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.精準射擊_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.精準射擊_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.精準射擊_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 56){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.聯裝彈夾_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.聯裝彈夾_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.聯裝彈夾_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.聯裝彈夾_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.聯裝彈夾_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.聯裝彈夾_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.聯裝彈夾_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 57){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.偵察營_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.偵察營_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.偵察營_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.偵察營_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.偵察營_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.偵察營_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.偵察營_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 58){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.強化護甲_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.強化護甲_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.強化護甲_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.強化護甲_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.強化護甲_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.強化護甲_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.強化護甲_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 59){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.防彈纖維_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.防彈纖維_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.防彈纖維_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.防彈纖維_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.防彈纖維_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.防彈纖維_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.防彈纖維_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 60){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.強化裝甲_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.強化裝甲_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.強化裝甲_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.強化裝甲_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.強化裝甲_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.強化裝甲_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.強化裝甲_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 61){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.軍團_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.軍團_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.軍團_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.軍團_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.軍團_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.軍團_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.軍團_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 62){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.進擊學員體質_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.進擊學員體質_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.進擊學員體質_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.進擊學員體質_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.進擊學員體質_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.進擊學員體質_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.進擊學員體質_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 63){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.火力學員體質_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.火力學員體質_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.火力學員體質_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.火力學員體質_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.火力學員體質_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.火力學員體質_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.火力學員體質_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 64){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.機動小組加固_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.機動小組加固_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.機動小組加固_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.機動小組加固_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.機動小組加固_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.機動小組加固_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.機動小組加固_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 65){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.軍事訓練_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.軍事訓練_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.軍事訓練_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.軍事訓練_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.軍事訓練_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.軍事訓練_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.軍事訓練_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 66){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.中級軍團_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.中級軍團_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.中級軍團_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.中級軍團_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.中級軍團_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.中級軍團_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.中級軍團_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 67){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.中級搏鬥術_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.中級搏鬥術_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.中級搏鬥術_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.中級搏鬥術_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.中級搏鬥術_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.中級搏鬥術_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.中級搏鬥術_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 68){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.中級精準射擊_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.中級精準射擊_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.中級精準射擊_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.中級精準射擊_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.中級精準射擊_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.中級精準射擊_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.中級精準射擊_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 69){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.中級聯裝彈夾_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.中級聯裝彈夾_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.中級聯裝彈夾_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.中級聯裝彈夾_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.中級聯裝彈夾_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.中級聯裝彈夾_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.中級聯裝彈夾_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 70){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.中級動員令_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.中級動員令_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.中級動員令_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.中級動員令_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.中級動員令_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.中級動員令_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.中級動員令_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 71){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.中級強化護甲_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.中級強化護甲_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.中級強化護甲_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.中級強化護甲_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.中級強化護甲_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.中級強化護甲_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.中級強化護甲_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 72){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.中級防彈纖維_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.中級防彈纖維_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.中級防彈纖維_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.中級防彈纖維_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.中級防彈纖維_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.中級防彈纖維_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.中級防彈纖維_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 73){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.中級強化裝甲_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.中級強化裝甲_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.中級強化裝甲_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.中級強化裝甲_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.中級強化裝甲_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.中級強化裝甲_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.中級強化裝甲_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 74){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.中級偵察營_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.中級偵察營_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.中級偵察營_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.中級偵察營_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.中級偵察營_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.中級偵察營_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.中級偵察營_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 75){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.中級進擊學員體質_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.中級進擊學員體質_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.中級進擊學員體質_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.中級進擊學員體質_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.中級進擊學員體質_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.中級進擊學員體質_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.中級進擊學員體質_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 76){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.中級火力學員體質_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.中級火力學員體質_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.中級火力學員體質_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.中級火力學員體質_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.中級火力學員體質_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.中級火力學員體質_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.中級火力學員體質_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 77){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.中級機動小組加固_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.中級機動小組加固_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.中級機動小組加固_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.中級機動小組加固_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.中級機動小組加固_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.中級機動小組加固_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.中級機動小組加固_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 78){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.中級軍事訓練_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.中級軍事訓練_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.中級軍事訓練_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.中級軍事訓練_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.中級軍事訓練_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.中級軍事訓練_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.中級軍事訓練_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 79){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級軍團_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級軍團_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級軍團_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級軍團_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級軍團_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級軍團_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級軍團_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 80){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級搏鬥術_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級搏鬥術_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級搏鬥術_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級搏鬥術_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級搏鬥術_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級搏鬥術_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級搏鬥術_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 81){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級精準射擊_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級精準射擊_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級精準射擊_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級精準射擊_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級精準射擊_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級精準射擊_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級精準射擊_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 82){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級聯裝彈夾_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級聯裝彈夾_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級聯裝彈夾_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級聯裝彈夾_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級聯裝彈夾_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級聯裝彈夾_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級聯裝彈夾_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 83){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級動員令_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級動員令_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級動員令_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級動員令_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級動員令_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級動員令_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級動員令_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 84){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級強化護甲_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級強化護甲_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級強化護甲_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級強化護甲_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級強化護甲_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級強化護甲_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級強化護甲_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 85){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級防彈纖維_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級防彈纖維_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級防彈纖維_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級防彈纖維_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級防彈纖維_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級防彈纖維_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級防彈纖維_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 86){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級強化裝甲_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級強化裝甲_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級強化裝甲_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級強化裝甲_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級強化裝甲_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級強化裝甲_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級強化裝甲_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 87){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級偵察營_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級偵察營_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級偵察營_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級偵察營_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級偵察營_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級偵察營_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級偵察營_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 88){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級進擊學員體質_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級進擊學員體質_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級進擊學員體質_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級進擊學員體質_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級進擊學員體質_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級進擊學員體質_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級進擊學員體質_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 89){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級火力學員體質_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級火力學員體質_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級火力學員體質_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級火力學員體質_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級火力學員體質_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級火力學員體質_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級火力學員體質_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 90){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級機動小組加固_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級機動小組加固_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級機動小組加固_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級機動小組加固_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級機動小組加固_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級機動小組加固_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級機動小組加固_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 91){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高級軍事訓練_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高級軍事訓練_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高級軍事訓練_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高級軍事訓練_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高級軍事訓練_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高級軍事訓練_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高級軍事訓練_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 92){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.戰例研究_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.戰例研究_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.戰例研究_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.戰例研究_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.戰例研究_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.戰例研究_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.戰例研究_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 93){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.攻堅戰訓練_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.攻堅戰訓練_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.攻堅戰訓練_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.攻堅戰訓練_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.攻堅戰訓練_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.攻堅戰訓練_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.攻堅戰訓練_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 94){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.野外作戰專家_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.野外作戰專家_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.野外作戰專家_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.野外作戰專家_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.野外作戰專家_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.野外作戰專家_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.野外作戰專家_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 95){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.爆裂彈頭_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.爆裂彈頭_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.爆裂彈頭_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.爆裂彈頭_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.爆裂彈頭_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.爆裂彈頭_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.爆裂彈頭_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 96){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.高射巨砲_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.高射巨砲_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.高射巨砲_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.高射巨砲_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.高射巨砲_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.高射巨砲_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.高射巨砲_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 97){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.狙擊訓練_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.狙擊訓練_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.狙擊訓練_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.狙擊訓練_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.狙擊訓練_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.狙擊訓練_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.狙擊訓練_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 98){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.機槍加固_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.機槍加固_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.機槍加固_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.機槍加固_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.機槍加固_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.機槍加固_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.機槍加固_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 99){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.巨力揮舞_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.巨力揮舞_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.巨力揮舞_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.巨力揮舞_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.巨力揮舞_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.巨力揮舞_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.巨力揮舞_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 100){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.合金武士刀_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.合金武士刀_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.合金武士刀_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.合金武士刀_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.合金武士刀_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.合金武士刀_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.合金武士刀_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 101){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.潛能激發_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.潛能激發_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.潛能激發_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.潛能激發_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.潛能激發_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.潛能激發_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.潛能激發_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 102){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.運動戰訓練_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.運動戰訓練_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.運動戰訓練_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.運動戰訓練_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.運動戰訓練_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.運動戰訓練_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.運動戰訓練_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 103){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.叢林戰鬥訓練_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.叢林戰鬥訓練_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.叢林戰鬥訓練_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.叢林戰鬥訓練_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.叢林戰鬥訓練_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.叢林戰鬥訓練_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.叢林戰鬥訓練_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 104){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.體質訓練_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.體質訓練_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.體質訓練_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.體質訓練_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.體質訓練_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.體質訓練_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.體質訓練_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 105){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.電子對抗_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.電子對抗_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.電子對抗_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.電子對抗_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.電子對抗_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.電子對抗_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.電子對抗_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 106){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.納米纖維_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.納米纖維_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.納米纖維_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.納米纖維_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.納米纖維_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.納米纖維_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.納米纖維_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 107){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.鋼鐵車身_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.鋼鐵車身_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.鋼鐵車身_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.鋼鐵車身_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.鋼鐵車身_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.鋼鐵車身_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.鋼鐵車身_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 108){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.合金盔甲_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.合金盔甲_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.合金盔甲_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.合金盔甲_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.合金盔甲_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.合金盔甲_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.合金盔甲_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 109){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.重點突擊_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.重點突擊_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.重點突擊_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.重點突擊_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.重點突擊_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.重點突擊_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.重點突擊_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 110){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.作戰動員_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.作戰動員_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.作戰動員_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.作戰動員_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.作戰動員_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.作戰動員_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.作戰動員_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 111){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.堅持不懈_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.堅持不懈_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.堅持不懈_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.堅持不懈_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.堅持不懈_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.堅持不懈_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.堅持不懈_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 112){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.協同作戰_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.協同作戰_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.協同作戰_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.協同作戰_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.協同作戰_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.協同作戰_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.協同作戰_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 113){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.戰場勘察_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.戰場勘察_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.戰場勘察_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.戰場勘察_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.戰場勘察_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.戰場勘察_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.戰場勘察_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 114){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.電子瞄準鏡_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.電子瞄準鏡_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.電子瞄準鏡_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.電子瞄準鏡_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.電子瞄準鏡_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.電子瞄準鏡_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.電子瞄準鏡_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 115){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.火焰噴射器_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.火焰噴射器_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.火焰噴射器_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.火焰噴射器_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.火焰噴射器_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.火焰噴射器_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.火焰噴射器_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 116){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.迷彩偽裝服_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.迷彩偽裝服_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.迷彩偽裝服_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.迷彩偽裝服_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.迷彩偽裝服_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.迷彩偽裝服_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.迷彩偽裝服_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 117){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.合金橫梁_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.合金橫梁_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.合金橫梁_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.合金橫梁_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.合金橫梁_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.合金橫梁_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.合金橫梁_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 118){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.合金巨劍_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.合金巨劍_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.合金巨劍_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.合金巨劍_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.合金巨劍_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.合金巨劍_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.合金巨劍_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 119){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.盾牌加固_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.盾牌加固_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.盾牌加固_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.盾牌加固_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.盾牌加固_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.盾牌加固_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.盾牌加固_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 120){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.巨型儲藏室_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.巨型儲藏室_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.巨型儲藏室_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.巨型儲藏室_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.巨型儲藏室_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.巨型儲藏室_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.巨型儲藏室_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 121){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.防禦壁壘_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.防禦壁壘_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.防禦壁壘_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.防禦壁壘_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.防禦壁壘_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.防禦壁壘_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.防禦壁壘_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 122){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.陶瓷防彈衣_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.陶瓷防彈衣_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.陶瓷防彈衣_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.陶瓷防彈衣_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.陶瓷防彈衣_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.陶瓷防彈衣_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.陶瓷防彈衣_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 123){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.合金車身_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.合金車身_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.合金車身_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.合金車身_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.合金車身_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.合金車身_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.合金車身_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 124){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.堅守陣地_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.堅守陣地_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.堅守陣地_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.堅守陣地_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.堅守陣地_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.堅守陣地_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.堅守陣地_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 125){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.合金盾牌_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.合金盾牌_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.合金盾牌_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.合金盾牌_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.合金盾牌_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.合金盾牌_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.合金盾牌_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 126){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.要地駐守_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.要地駐守_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.要地駐守_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.要地駐守_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.要地駐守_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.要地駐守_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.要地駐守_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 127){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.醫療保障_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.醫療保障_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.醫療保障_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.醫療保障_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.醫療保障_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.醫療保障_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.醫療保障_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 128){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.生化改造_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.生化改造_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.生化改造_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.生化改造_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.生化改造_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.生化改造_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.生化改造_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 129){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.骨骼強化_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.骨骼強化_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.骨骼強化_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.骨骼強化_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.骨骼強化_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.骨骼強化_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.骨骼強化_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 130){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.強化病毒傳播_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.強化病毒傳播_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.強化病毒傳播_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.強化病毒傳播_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.強化病毒傳播_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.強化病毒傳播_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.強化病毒傳播_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 131){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.強化生化裝甲_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.強化生化裝甲_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.強化生化裝甲_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.強化生化裝甲_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.強化生化裝甲_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.強化生化裝甲_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.強化生化裝甲_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 132){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.強化腐蝕病毒_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.強化腐蝕病毒_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.強化腐蝕病毒_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.強化腐蝕病毒_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.強化腐蝕病毒_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.強化腐蝕病毒_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.強化腐蝕病毒_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 133){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.死體馴養_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.死體馴養_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.死體馴養_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.死體馴養_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.死體馴養_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.死體馴養_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.死體馴養_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 134){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.強化噴吐_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.強化噴吐_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.強化噴吐_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.強化噴吐_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.強化噴吐_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.強化噴吐_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.強化噴吐_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 135){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.納米生化裝甲_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.納米生化裝甲_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.納米生化裝甲_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.納米生化裝甲_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.納米生化裝甲_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.納米生化裝甲_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.納米生化裝甲_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 136){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.強化狂亂病毒_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.強化狂亂病毒_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.強化狂亂病毒_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.強化狂亂病毒_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.強化狂亂病毒_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.強化狂亂病毒_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.強化狂亂病毒_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 137){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.外骨骼裝甲_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.外骨骼裝甲_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.外骨骼裝甲_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.外骨骼裝甲_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.外骨骼裝甲_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.外骨骼裝甲_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.外骨骼裝甲_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }
            if(x_id[a] == 138){for (int lvl = start_pb+1; lvl < end_pb+1 ; lvl++){ fuel_team[x-1] = fuel_team[x-1] + techLib.肌肉強化_fuel[lvl];food_team[x-1] = food_team[x-1] + techLib.肌肉強化_food[lvl];steel_team[x-1] = steel_team[x-1]+techLib.肌肉強化_steel[lvl];alloy_team[x-1] = alloy_team[x-1]+ techLib.肌肉強化_alloy[lvl];diam_team[x-1] = diam_team[x-1]+techLib.肌肉強化_diam[lvl];power_team[x-1] =power_team[x-1]+ techLib.肌肉強化_power[lvl]; time_team[x-1] = time_team[x-1] + techLib_T.肌肉強化_time[lvl]; }tech_lvl_start[x-1] = start_pb;tech_lvl_end[x-1] = end_pb; }

        }
        fuel = food  = alloy = steel = kyanite = kyanite_basic = kyanite_cluster = power = time= 0 ;

        long d = 0;
        long h = 0;
        long m = 2;
        long sec = 40;

        fuel	=	fuel_team[0]+	fuel_team[1]+	fuel_team[2]+	fuel_team[3]+	fuel_team[4]+	fuel_team[5]+	fuel_team[6]+	fuel_team[7]+	fuel_team[8]+	fuel_team[9];
        food	=	food_team[0]+	food_team[1]+	food_team[2]+	food_team[3]+	food_team[4]+	food_team[5]+	food_team[6]+	food_team[7]+	food_team[8]+	food_team[9];
        steel	=	steel_team[0]+	steel_team[1]+	steel_team[2]+	steel_team[3]+	steel_team[4]+	steel_team[5]+	steel_team[6]+	steel_team[7]+	steel_team[8]+	steel_team[9];
        alloy	=	alloy_team[0]+	alloy_team[1]+	alloy_team[2]+	alloy_team[3]+	alloy_team[4]+	alloy_team[5]+	alloy_team[6]+	alloy_team[7]+	alloy_team[8]+	alloy_team[9];
        time	=	time_team[0]+	time_team[1]+	time_team[2]+	time_team[3]+	time_team[4]+	time_team[5]+	time_team[6]+	time_team[7]+	time_team[8]+	time_team[9];
        kyanite	=	kyanite_team[0]+	kyanite_team[1]+	kyanite_team[2]+	kyanite_team[3]+	kyanite_team[4]+	kyanite_team[5]+	kyanite_team[6]+	kyanite_team[7]+	kyanite_team[8]+	kyanite_team[9];
        kyanite_basic	=	kyanite_basic_team[0]+	kyanite_basic_team[1]+	kyanite_basic_team[2]+	kyanite_basic_team[3]+	kyanite_basic_team[4]+	kyanite_basic_team[5]+	kyanite_basic_team[6]+	kyanite_basic_team[7]+	kyanite_basic_team[8]+	kyanite_basic_team[9];
        kyanite_cluster	=	kyanite_cluster_team[0]+	kyanite_cluster_team[1]+	kyanite_cluster_team[2]+	kyanite_cluster_team[3]+	kyanite_cluster_team[4]+	kyanite_cluster_team[5]+	kyanite_cluster_team[6]+	kyanite_cluster_team[7]+	kyanite_cluster_team[8]+	kyanite_cluster_team[9];
        power	=	power_team[0]+	power_team[1]+	power_team[2]+	power_team[3]+	power_team[4]+	power_team[5]+	power_team[6]+	power_team[7]+	power_team[8]+	power_team[9];
        diamond	=	diam_team[0]+	diam_team[1]+	diam_team[2]+	diam_team[3]+	diam_team[4]+	diam_team[5]+	diam_team[6]+	diam_team[7]+	diam_team[8]+	diam_team[9];

        String Fuel_String = null, Food_String= null , Steel_String = null, Alloy_String= null , Time_String = null, Kyanite_String = null, Kyanite_basic_String = null, Kyanite_cluster_String = null, Cost_String = null, Power_String = null,Diamond_String = null, Load_String = null, Total_String = null;

        long time2 = (d * 86400) + (h * 3600) + m * 60 + sec;

        DecimalFormat df = new DecimalFormat("#.#####");

        Log.i("time2", String.valueOf(time2));

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
        Power_String = formatter8.format(power);

        DecimalFormat formatter9 = new DecimalFormat("###,###,###,###,###,###");
        Diamond_String = formatter9.format(diamond);

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
        diamond_tv.setText(prettyCount(diamond));


        Log.i("FUEL", prettyCount(fuel));

        if (time_tv.getText() == ""){time_tv.setText("00:00:00");}
        isLoad = false;
    }

    public void cbg() {
        //取出数据（注意这里直接用实例取就行了，不用获取编辑器editor）
        String theme = sharedPreferences.getString("theme", "dark");
        String color1 = sharedPreferences.getString("color1", "F1870F");
        String color2 = sharedPreferences.getString("color2", "C56E0D");

        if (theme.equals("base")) {
            tech01_card	.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            tech02_card	.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            tech03_card	.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            tech04_card	.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            tech05_card	.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            tech06_card	.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            tech07_card	.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            tech08_card	.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            tech09_card	.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            tech10_card	.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));


        }

        if (theme.equals("dark")) {
            tech01_card	.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            tech02_card	.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            tech03_card	.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            tech04_card	.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            tech05_card	.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            tech06_card	.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            tech07_card	.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            tech08_card	.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            tech09_card	.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            tech10_card	.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
        }

        if (theme.equals("pink")) {
            tech01_card	.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            tech02_card	.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            tech03_card	.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            tech04_card	.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            tech05_card	.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            tech06_card	.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            tech07_card	.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            tech08_card	.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            tech09_card	.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            tech10_card	.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));

        }

        if (theme.equals("leek")) {
            tech01_card	.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            tech02_card	.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            tech03_card	.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            tech04_card	.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            tech05_card	.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            tech06_card	.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            tech07_card	.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            tech08_card	.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            tech09_card	.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            tech10_card	.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));

        }

        if (theme.equals("summer")) {
            tech01_card	.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            tech02_card	.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            tech03_card	.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            tech04_card	.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            tech05_card	.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            tech06_card	.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            tech07_card	.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            tech08_card	.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            tech09_card	.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            tech10_card	.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));

        }

        if (theme.equals("custom")) {
            tech01_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            tech02_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            tech03_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            tech04_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            tech05_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            tech06_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            tech07_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            tech08_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            tech09_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            tech10_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
        }
    }

    private void new_init() {

        start_pb1	 = findViewById(R.id.	start_pb1	);
        start_pb2	 = findViewById(R.id.	start_pb2	);
        start_pb3	 = findViewById(R.id.	start_pb3	);
        start_pb4	 = findViewById(R.id.	start_pb4	);
        start_pb5	 = findViewById(R.id.	start_pb5	);
        start_pb6	 = findViewById(R.id.	start_pb6	);
        start_pb7	 = findViewById(R.id.	start_pb7	);
        start_pb8	 = findViewById(R.id.	start_pb8	);
        start_pb9	 = findViewById(R.id.	start_pb9	);
        start_pb10	 = findViewById(R.id.	start_pb10	);
        end_pb1	 = findViewById(R.id.	end_pb1	);
        end_pb2	 = findViewById(R.id.	end_pb2	);
        end_pb3	 = findViewById(R.id.	end_pb3	);
        end_pb4	 = findViewById(R.id.	end_pb4	);
        end_pb5	 = findViewById(R.id.	end_pb5	);
        end_pb6	 = findViewById(R.id.	end_pb6	);
        end_pb7	 = findViewById(R.id.	end_pb7	);
        end_pb8	 = findViewById(R.id.	end_pb8	);
        end_pb9	 = findViewById(R.id.	end_pb9	);
        end_pb10	 = findViewById(R.id.	end_pb10	);
        start_tv1	 = findViewById(R.id.	start_tv1	);
        start_tv2	 = findViewById(R.id.	start_tv2	);
        start_tv3	 = findViewById(R.id.	start_tv3	);
        start_tv4	 = findViewById(R.id.	start_tv4	);
        start_tv5	 = findViewById(R.id.	start_tv5	);
        start_tv6	 = findViewById(R.id.	start_tv6	);
        start_tv7	 = findViewById(R.id.	start_tv7	);
        start_tv8	 = findViewById(R.id.	start_tv8	);
        start_tv9	 = findViewById(R.id.	start_tv9	);
        start_tv10	 = findViewById(R.id.	start_tv10	);
        end_tv1	 = findViewById(R.id.	end_tv1	);
        end_tv2	 = findViewById(R.id.	end_tv2	);
        end_tv3	 = findViewById(R.id.	end_tv3	);
        end_tv4	 = findViewById(R.id.	end_tv4	);
        end_tv5	 = findViewById(R.id.	end_tv5	);
        end_tv6	 = findViewById(R.id.	end_tv6	);
        end_tv7	 = findViewById(R.id.	end_tv7	);
        end_tv8	 = findViewById(R.id.	end_tv8	);
        end_tv9	 = findViewById(R.id.	end_tv9	);
        end_tv10	 = findViewById(R.id.	end_tv10	);
        team_ll1	 = findViewById(R.id.	team_ll1	);
        team_ll2	 = findViewById(R.id.	team_ll2	);
        team_ll3	 = findViewById(R.id.	team_ll3	);
        team_ll4	 = findViewById(R.id.	team_ll4	);
        team_ll5	 = findViewById(R.id.	team_ll5	);
        team_ll6	 = findViewById(R.id.	team_ll6	);
        team_ll7	 = findViewById(R.id.	team_ll7	);
        team_ll8	 = findViewById(R.id.	team_ll8	);
        team_ll9	 = findViewById(R.id.	team_ll9	);
        team_ll10	 = findViewById(R.id.	team_ll10	);



        tech01_img	 =findViewById(R.id.	tech_img1);
        tech02_img	 =findViewById(R.id.	tech_img2);
        tech03_img	 =findViewById(R.id.	tech_img3);
        tech04_img	 =findViewById(R.id.	tech_img4);
        tech05_img	 =findViewById(R.id.	tech_img5);
        tech06_img	 =findViewById(R.id.	tech_img6);
        tech07_img	 =findViewById(R.id.	tech_img7);
        tech08_img	 =findViewById(R.id.	tech_img8);
        tech09_img	 =findViewById(R.id.	tech_img9);
        tech10_img	 =findViewById(R.id.	tech_img10);

        tech01_tv	 =findViewById(R.id.	tech_name1);
        tech02_tv	 =findViewById(R.id.	tech_name2);
        tech03_tv	 =findViewById(R.id.	tech_name3);
        tech04_tv	 =findViewById(R.id.	tech_name4);
        tech05_tv	 =findViewById(R.id.	tech_name5);
        tech06_tv	 =findViewById(R.id.	tech_name6);
        tech07_tv	 =findViewById(R.id.	tech_name7);
        tech08_tv	 =findViewById(R.id.	tech_name8);
        tech09_tv	 =findViewById(R.id.	tech_name9);
        tech10_tv	 =findViewById(R.id.	tech_name10);

        tech01_card	 =findViewById(R.id.	tech_card1);
        tech02_card	 =findViewById(R.id.	tech_card2);
        tech03_card	 =findViewById(R.id.	tech_card3);
        tech04_card	 =findViewById(R.id.	tech_card4);
        tech05_card	 =findViewById(R.id.	tech_card5);
        tech06_card	 =findViewById(R.id.	tech_card6);
        tech07_card	 =findViewById(R.id.	tech_card7);
        tech08_card	 =findViewById(R.id.	tech_card8);
        tech09_card	 =findViewById(R.id.	tech_card9);
        tech10_card	 =findViewById(R.id.	tech_card10);


        team_ll1.setVisibility(View.GONE);
        team_ll2.setVisibility(View.GONE);
        team_ll3.setVisibility(View.GONE);
        team_ll4.setVisibility(View.GONE);
        team_ll5.setVisibility(View.GONE);
        team_ll6.setVisibility(View.GONE);
        team_ll7.setVisibility(View.GONE);
        team_ll8.setVisibility(View.GONE);
        team_ll9.setVisibility(View.GONE);
        team_ll10.setVisibility(View.GONE);

    }

    public void BackgroundReload (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.bg);

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

    public void clean (View view){
        tech01_img.setImageResource(R.drawable.blank_box);
        tech02_img.setImageResource(R.drawable.blank_box);
        tech03_img.setImageResource(R.drawable.blank_box);
        tech04_img.setImageResource(R.drawable.blank_box);
        tech05_img.setImageResource(R.drawable.blank_box);
        tech06_img.setImageResource(R.drawable.blank_box);
        tech07_img.setImageResource(R.drawable.blank_box);
        tech08_img.setImageResource(R.drawable.blank_box);
        tech09_img.setImageResource(R.drawable.blank_box);
        tech10_img.setImageResource(R.drawable.blank_box);
        tech01_tv.setText(getString(R.string.choose_tech));
        tech02_tv.setText(getString(R.string.choose_troops));
        tech02_tv.setText(getString(R.string.choose_tech));
        tech03_tv.setText(getString(R.string.choose_tech));
        tech04_tv.setText(getString(R.string.choose_tech));
        tech05_tv.setText(getString(R.string.choose_tech));
        tech06_tv.setText(getString(R.string.choose_tech));
        tech07_tv.setText(getString(R.string.choose_tech));
        tech08_tv.setText(getString(R.string.choose_tech));
        tech09_tv.setText(getString(R.string.choose_tech));
        tech10_tv.setText(getString(R.string.choose_tech));
        tech02_card.setVisibility(View.GONE);
        tech03_card.setVisibility(View.GONE);
        tech04_card.setVisibility(View.GONE);
        tech05_card.setVisibility(View.GONE);
        tech06_card.setVisibility(View.GONE);
        tech07_card.setVisibility(View.GONE);
        tech08_card.setVisibility(View.GONE);
        tech09_card.setVisibility(View.GONE);
        tech10_card.setVisibility(View.GONE);
        start_pb1	.setMax(0);	start_pb1	.setProgress(0);
        start_pb2	.setMax(0);	start_pb2	.setProgress(0);
        start_pb3	.setMax(0);	start_pb3	.setProgress(0);
        start_pb4	.setMax(0);	start_pb4	.setProgress(0);
        start_pb5	.setMax(0);	start_pb5	.setProgress(0);
        start_pb6	.setMax(0);	start_pb6	.setProgress(0);
        start_pb7	.setMax(0);	start_pb7	.setProgress(0);
        start_pb8	.setMax(0);	start_pb8	.setProgress(0);
        start_pb9	.setMax(0);	start_pb9	.setProgress(0);
        start_pb10	.setMax(0);	start_pb10	.setProgress(0);

        end_pb1	.setMax(1);	end_pb1	.setProgress(1);
        end_pb2	.setMax(1);	end_pb2	.setProgress(1);
        end_pb3	.setMax(1);	end_pb3	.setProgress(1);
        end_pb4	.setMax(1);	end_pb4	.setProgress(1);
        end_pb5	.setMax(1);	end_pb5	.setProgress(1);
        end_pb6	.setMax(1);	end_pb6	.setProgress(1);
        end_pb7	.setMax(1);	end_pb7	.setProgress(1);
        end_pb8	.setMax(1);	end_pb8	.setProgress(1);
        end_pb9	.setMax(1);	end_pb9	.setProgress(1);
        end_pb10	.setMax(1);	end_pb10	.setProgress(1);
        team_ll1.setVisibility(View.GONE);
        team_ll2.setVisibility(View.GONE);
        team_ll3.setVisibility(View.GONE);
        team_ll4.setVisibility(View.GONE);
        team_ll5.setVisibility(View.GONE);
        team_ll6.setVisibility(View.GONE);
        team_ll7.setVisibility(View.GONE);
        team_ll8.setVisibility(View.GONE);
        team_ll9.setVisibility(View.GONE);
        team_ll10.setVisibility(View.GONE);

        fuel_team = new long[] {0,0,0,0,0,0,0,0,0,0};
        food_team = new long[] {0,0,0,0,0,0,0,0,0,0};
        steel_team = new long[] {0,0,0,0,0,0,0,0,0,0};
        alloy_team = new long[] {0,0,0,0,0,0,0,0,0,0};
        time_team = new long[] {0,0,0,0,0,0,0,0,0,0};
        kyanite_team = new long[] {0,0,0,0,0,0,0,0,0,0};
        kyanite_basic_team = new long[] {0,0,0,0,0,0,0,0,0,0};
        kyanite_cluster_team = new long[] {0,0,0,0,0,0,0,0,0,0};
        power_team = new long[] {0,0,0,0,0,0,0,0,0,0} ;
        diam_team = new long[] {0,0,0,0,0,0,0,0,0,0} ;
        x_id = new long[] {0,0,0,0,0,0,0,0,0,0} ;
        tech_lvl_start = new int[] {0,0,0,0,0,0,0,0,0,0};
        tech_lvl_end = new int[]{0,0,0,0,0,0,0,0,0,0};
        tech_id = new int[]{0,0,0,0,0,0,0,0,0,0};
    }
    public void toSave(View view){
        save();
    }
    public void save(){
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPreferences = getSharedPreferences("user_info",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        int[] tech_s = {start_pb1.getProgress(),	start_pb2.getProgress(),	start_pb3.getProgress(),	start_pb4.getProgress(),	start_pb5.getProgress(),	start_pb6.getProgress(),	start_pb7.getProgress(),	start_pb8.getProgress(),	start_pb9.getProgress(),	start_pb10.getProgress()};

        int[] tech_e = { end_pb1.getProgress(),	end_pb2.getProgress(),	end_pb3.getProgress(),	end_pb4.getProgress(),	end_pb5.getProgress(),	end_pb6.getProgress(),	end_pb7.getProgress(),	end_pb8.getProgress(),	end_pb9.getProgress(),	end_pb10.getProgress()};

        int[] tech_m = { end_pb1.getMax(),	end_pb2.getMax(),	end_pb3.getMax(),	end_pb4.getMax(),	end_pb5.getMax(),	end_pb6.getMax(),	end_pb7.getMax(),	end_pb8.getMax(),	end_pb9.getMax(),	end_pb10.getMax()};

        long[] tech_ids = x_id;

        String file_content =  "{"+	"tech01_id : " +tech_ids[0]+   	 ","+"tech01_s :"	    +tech_s[0]+ 	 ","+"tech01_e :"	    +tech_e[0]+ 	 ","+"tech01_m :"	    +tech_m[0]+ 	","+"tech02_id : "  	 +tech_ids[1]+	 ","+"tech02_s :"	    +tech_s[1]+	 ","+"tech02_e :"	    +tech_e[1]+	 ","+"tech02_m :"	    +tech_m[1]+	","+"tech03_id : "	 +tech_ids[2]+	 ","+"tech03_s :"	    +tech_s[2]+	 ","+"tech03_e :"	    +tech_e[2]+	 ","+"tech03_m :"	    +tech_m[2]+	","+"tech04_id : "	 +tech_ids[3]+	 ","+"tech04_s :"	    +tech_s[3]+	 ","+"tech04_e :"	    +tech_e[3]+	 ","+"tech04_m :"	    +tech_m[3]+	","+"tech05_id : "	 +tech_ids[4]+	 ","+"tech05_s :"	    +tech_s[4]+	 ","+"tech05_e :"	    +tech_e[4]+	 ","+"tech05_m :"	    +tech_m[4]+	","+"tech06_id : "	 +tech_ids[5]+	 ","+"tech06_s :"	    +tech_s[5]+	 ","+"tech06_e :"	    +tech_e[5]+	 ","+"tech06_m :"	    +tech_m[5]+	","+"tech07_id : "	 +tech_ids[6]+	 ","+"tech07_s :"	    +tech_s[6]+	 ","+"tech07_e :"	    +tech_e[6]+	 ","+"tech07_m :"	    +tech_m[6]+	","+"tech08_id : "	 +tech_ids[7]+	 ","+"tech08_s :"	    +tech_s[7]+	 ","+"tech08_e :"	    +tech_e[7]+	 ","+"tech08_m :"	    +tech_m[7]+	","+"tech09_id : "	 +tech_ids[8]+	 ","+"tech09_s :"	    +tech_s[8]+	 ","+"tech09_e :"	    +tech_e[8]+	 ","+"tech09_m :"	    +tech_m[8]+	","+"tech10_id : "	 +tech_ids[9]+	 ","+"tech10_s :"	    +tech_s[9]+	 ","+"tech10_e :"	    +tech_e[9]+	 ","+"tech10_m :"	    +tech_m[9]+"}";
        editor.putString("tech_shared",file_content);
        editor.apply();


    }

    public void Load() {
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String text = sharedPreferences.getString("tech_shared","{}");
        Log.w("TS",text);
        JSONObject result = null;
        try {
            result = new JSONObject(text);
            tech_s[0] = result.getInt("tech01_s");
            tech_s[1] = result.getInt("tech02_s");
            tech_s[2] = result.getInt("tech03_s");
            tech_s[3] = result.getInt("tech04_s");
            tech_s[4] = result.getInt("tech05_s");
            tech_s[5] = result.getInt("tech06_s");
            tech_s[6] = result.getInt("tech07_s");
            tech_s[7] = result.getInt("tech08_s");
            tech_s[8] = result.getInt("tech09_s");
            tech_s[9] = result.getInt("tech10_s");

            tech_e[0] = result.getInt("tech01_e");
            tech_e[1] = result.getInt("tech02_e");
            tech_e[2] = result.getInt("tech03_e");
            tech_e[3] = result.getInt("tech04_e");
            tech_e[4] = result.getInt("tech05_e");
            tech_e[5] = result.getInt("tech06_e");
            tech_e[6] = result.getInt("tech07_e");
            tech_e[7] = result.getInt("tech08_e");
            tech_e[8] = result.getInt("tech09_e");
            tech_e[9] = result.getInt("tech10_e");

            tech_m[0] = result.getInt("tech01_m");
            tech_m[1] = result.getInt("tech02_m");
            tech_m[2] = result.getInt("tech03_m");
            tech_m[3] = result.getInt("tech04_m");
            tech_m[4] = result.getInt("tech05_m");
            tech_m[5] = result.getInt("tech06_m");
            tech_m[6] = result.getInt("tech07_m");
            tech_m[7] = result.getInt("tech08_m");
            tech_m[8] = result.getInt("tech09_m");
            tech_m[9] = result.getInt("tech10_m");

            tech_idA[0] = result.getLong("tech01_id");
            tech_idA[1] = result.getLong("tech02_id");
            tech_idA[2] = result.getLong("tech03_id");
            tech_idA[3] = result.getLong("tech04_id");
            tech_idA[4] = result.getLong("tech05_id");
            tech_idA[5] = result.getLong("tech06_id");
            tech_idA[6] = result.getLong("tech07_id");
            tech_idA[7] = result.getLong("tech08_id");
            tech_idA[8] = result.getLong("tech09_id");
            tech_idA[9] = result.getLong("tech10_id");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int y = 0 ; y < 10 ; y++) {
            tech_id[y] = (int) tech_idA[y];
            x_id[y] = (int) tech_idA[y];
            tech_lvl_start[y] = tech_s[y];
            tech_lvl_end[y] = tech_e[y];
        }
        if (tech_idA[0] != 0){
            tech01_card.setVisibility(View.VISIBLE);
            start_pb1.setVisibility(View.VISIBLE);
            end_pb1.setVisibility(View.VISIBLE);
            tech01_img.setVisibility(View.VISIBLE);
            tech01_tv.setVisibility(View.VISIBLE);
            team_ll1.setVisibility(View.VISIBLE);

            tech01_img.setImageResource(techIMG[tech_id[0]-1]);
            tech01_tv.setText(techName[(int) tech_id[0]]);
            start_pb1.setProgress(tech_s[0]);
            Log.w("DAM", String.valueOf(tech_s[0]));
            start_pb1.setMax(tech_m[0]-1);
            end_pb1.setProgress(tech_e[0]);
            end_pb1.setMax(tech_m[0]);

            tech02_card.setVisibility(View.VISIBLE);
            tech02_img.setVisibility(View.VISIBLE);
            tech02_tv.setVisibility(View.VISIBLE);
        }
        if (tech_idA[1] != 0){
            tech02_card.setVisibility(View.VISIBLE);
            start_pb2.setVisibility(View.VISIBLE);
            end_pb2.setVisibility(View.VISIBLE);
            tech02_img.setVisibility(View.VISIBLE);
            tech02_tv.setVisibility(View.VISIBLE);
            team_ll2.setVisibility(View.VISIBLE);

            tech02_img.setImageResource(techIMG[tech_id[1]-1]);
            tech02_tv.setText(techName[(int) tech_id[1]]);
            start_pb2.setProgress(tech_s[1]);
            start_pb2.setMax(tech_m[1]-1);
            end_pb2.setProgress(tech_e[1]);
            end_pb2.setMax(tech_m[1]);

            tech03_card.setVisibility(View.VISIBLE);
            tech03_img.setVisibility(View.VISIBLE);
            tech03_tv.setVisibility(View.VISIBLE);
        }
        if (tech_idA[2] != 0){
            tech03_card.setVisibility(View.VISIBLE);
            start_pb3.setVisibility(View.VISIBLE);
            end_pb3.setVisibility(View.VISIBLE);
            tech03_img.setVisibility(View.VISIBLE);
            tech03_tv.setVisibility(View.VISIBLE);
            team_ll3.setVisibility(View.VISIBLE);

            tech03_img.setImageResource(techIMG[tech_id[2]-1]);
            tech03_tv.setText(techName[(int) tech_id[2]]);
            start_pb3.setProgress(tech_s[2]);
            start_pb3.setMax(tech_m[2]-1);
            end_pb3.setProgress(tech_e[2]);
            end_pb3.setMax(tech_m[2]);

            tech04_card.setVisibility(View.VISIBLE);
            tech04_img.setVisibility(View.VISIBLE);
            tech04_tv.setVisibility(View.VISIBLE);
        }
        if (tech_idA[3] != 0){
            tech04_card.setVisibility(View.VISIBLE);
            start_pb4.setVisibility(View.VISIBLE);
            end_pb4.setVisibility(View.VISIBLE);
            tech04_img.setVisibility(View.VISIBLE);
            tech04_tv.setVisibility(View.VISIBLE);
            team_ll4.setVisibility(View.VISIBLE);

            tech04_img.setImageResource(techIMG[tech_id[3]-1]);
            tech04_tv.setText(techName[(int) tech_id[3]]);
            start_pb4.setProgress(tech_s[0]);
            start_pb4.setMax(tech_m[3]-1);
            end_pb4.setProgress(tech_e[3]);
            end_pb4.setMax(tech_m[3]);

            tech05_card.setVisibility(View.VISIBLE);
            tech05_img.setVisibility(View.VISIBLE);
            tech05_tv.setVisibility(View.VISIBLE);
        }
        if (tech_idA[4] != 0){
            tech05_card.setVisibility(View.VISIBLE);
            start_pb5.setVisibility(View.VISIBLE);
            end_pb5.setVisibility(View.VISIBLE);
            tech05_img.setVisibility(View.VISIBLE);
            tech05_tv.setVisibility(View.VISIBLE);
            team_ll5.setVisibility(View.VISIBLE);

            tech05_img.setImageResource(techIMG[tech_id[4]-1]);
            tech05_tv.setText(techName[(int) tech_id[4]]);
            start_pb5.setProgress(tech_s[0]);
            start_pb5.setMax(tech_m[4]-1);
            end_pb5.setProgress(tech_e[4]);
            end_pb5.setMax(tech_m[4]);

            tech06_card.setVisibility(View.VISIBLE);
            tech06_img.setVisibility(View.VISIBLE);
            tech06_tv.setVisibility(View.VISIBLE);
        }
        if (tech_idA[5] != 0){
            tech06_card.setVisibility(View.VISIBLE);
            start_pb6.setVisibility(View.VISIBLE);
            end_pb6.setVisibility(View.VISIBLE);
            tech06_img.setVisibility(View.VISIBLE);
            tech06_tv.setVisibility(View.VISIBLE);
            team_ll6.setVisibility(View.VISIBLE);

            tech06_img.setImageResource(techIMG[tech_id[5]-1]);
            tech06_tv.setText(techName[(int) tech_id[5]]);
            start_pb6.setProgress(tech_s[0]);
            start_pb6.setMax(tech_m[5]-1);
            end_pb6.setProgress(tech_e[5]);
            end_pb6.setMax(tech_m[5]);

            tech07_card.setVisibility(View.VISIBLE);
            tech07_img.setVisibility(View.VISIBLE);
            tech07_tv.setVisibility(View.VISIBLE);
        }
        if (tech_idA[6] != 0){
            tech07_card.setVisibility(View.VISIBLE);
            start_pb7.setVisibility(View.VISIBLE);
            end_pb7.setVisibility(View.VISIBLE);
            tech07_img.setVisibility(View.VISIBLE);
            tech07_tv.setVisibility(View.VISIBLE);
            team_ll7.setVisibility(View.VISIBLE);

            tech07_img.setImageResource(techIMG[tech_id[6]-1]);
            tech07_tv.setText(techName[(int) tech_id[6]]);
            start_pb7.setProgress(tech_s[0]);
            start_pb7.setMax(tech_m[6]-1);
            end_pb7.setProgress(tech_e[6]);
            end_pb7.setMax(tech_m[6]);

            tech08_card.setVisibility(View.VISIBLE);
            tech08_img.setVisibility(View.VISIBLE);
            tech08_tv.setVisibility(View.VISIBLE);
        }
        if (tech_idA[7] != 0){
            tech08_card.setVisibility(View.VISIBLE);
            start_pb8.setVisibility(View.VISIBLE);
            end_pb8.setVisibility(View.VISIBLE);
            tech08_img.setVisibility(View.VISIBLE);
            tech08_tv.setVisibility(View.VISIBLE);
            team_ll8.setVisibility(View.VISIBLE);

            tech08_img.setImageResource(techIMG[tech_id[7]-1]);
            tech08_tv.setText(techName[(int) tech_id[7]]);
            start_pb8.setProgress(tech_s[0]);
            start_pb8.setMax(tech_m[7]-1);
            end_pb8.setProgress(tech_e[7]);
            end_pb8.setMax(tech_m[7]);

            tech09_card.setVisibility(View.VISIBLE);
            tech09_img.setVisibility(View.VISIBLE);
            tech09_tv.setVisibility(View.VISIBLE);
        }
        if (tech_idA[8] != 0){
            tech09_card.setVisibility(View.VISIBLE);
            start_pb9.setVisibility(View.VISIBLE);
            end_pb9.setVisibility(View.VISIBLE);
            tech09_img.setVisibility(View.VISIBLE);
            tech09_tv.setVisibility(View.VISIBLE);
            team_ll9.setVisibility(View.VISIBLE);

            tech09_img.setImageResource(techIMG[tech_id[8]-1]);
            tech09_tv.setText(techName[(int) tech_id[8]]);
            start_pb9.setProgress(tech_s[0]);
            start_pb9.setMax(tech_m[8]-1);
            end_pb9.setProgress(tech_e[8]);
            end_pb9.setMax(tech_m[8]);

            tech10_card.setVisibility(View.VISIBLE);
            tech10_img.setVisibility(View.VISIBLE);
            tech10_tv.setVisibility(View.VISIBLE);
        }
        if (tech_idA[9] != 0){
            tech10_card.setVisibility(View.VISIBLE);
            start_pb10.setVisibility(View.VISIBLE);
            end_pb10.setVisibility(View.VISIBLE);
            tech10_img.setVisibility(View.VISIBLE);
            tech10_tv.setVisibility(View.VISIBLE);
            team_ll10.setVisibility(View.VISIBLE);

            tech10_img.setImageResource(techIMG[tech_id[9]-1]);
            tech10_tv.setText(techName[(int) tech_id[9]]);
            start_pb10.setProgress(tech_s[0]);
            start_pb10.setMax(tech_m[9]-1);
            end_pb10.setProgress(tech_e[9]);
            end_pb10.setMax(tech_m[9]);
        }
        for (int a=1;a < 10 ; a++){
            isLoad = true;
            start_pb1	.setProgress(tech_s[0]);	end_pb1	.setProgress(tech_e[0]);	 start_pb1	.setMax(tech_m[0]	 -1);   end_pb1	.setMax(tech_m[0]);
            start_pb2	.setProgress(tech_s[1]);	end_pb2	.setProgress(tech_e[1]);	 start_pb2	.setMax(tech_m[1]	 -1);   end_pb2	.setMax(tech_m[1]);
            start_pb3	.setProgress(tech_s[2]);	end_pb3	.setProgress(tech_e[2]);	 start_pb3	.setMax(tech_m[2]	 -1);   end_pb3	.setMax(tech_m[2]);
            start_pb4	.setProgress(tech_s[3]);	end_pb4	.setProgress(tech_e[3]);	 start_pb4	.setMax(tech_m[3]	 -1);   end_pb4	.setMax(tech_m[3]);
            start_pb5	.setProgress(tech_s[4]);	end_pb5	.setProgress(tech_e[4]);	 start_pb5	.setMax(tech_m[4]	 -1);   end_pb5	.setMax(tech_m[4]);
            start_pb6	.setProgress(tech_s[5]);	end_pb6	.setProgress(tech_e[5]);	 start_pb6	.setMax(tech_m[5]	 -1);   end_pb6	.setMax(tech_m[5]);
            start_pb7	.setProgress(tech_s[6]);	end_pb7	.setProgress(tech_e[6]);	 start_pb7	.setMax(tech_m[6]	 -1);   end_pb7	.setMax(tech_m[6]);
            start_pb8	.setProgress(tech_s[7]);	end_pb8	.setProgress(tech_e[7]);	 start_pb8	.setMax(tech_m[7]	 -1);   end_pb8	.setMax(tech_m[7]);
            start_pb9	.setProgress(tech_s[8]);	end_pb9	.setProgress(tech_e[8]);	 start_pb9	.setMax(tech_m[8]	 -1);   end_pb9	.setMax(tech_m[8]);
            start_pb10	.setProgress(tech_s[9]);	end_pb10	.setProgress(tech_e[9]);	 start_pb10	.setMax(tech_m[9]	 -1);   end_pb10	.setMax(tech_m[9]);

            tech_cal(a);
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        save();
    }
    @Override
    protected void onPause() {
        super.onPause();
        save();
    }

    }
