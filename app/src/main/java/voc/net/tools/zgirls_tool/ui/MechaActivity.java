package voc.net.tools.zgirls_tool.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.R;
import voc.net.tools.zgirls_tool.util.ScreenSizeUtils;

public class MechaActivity extends AppCompatActivity {

    int mecha_lv2_fuel	=	0	;	int mecha_lv2_food	=	6600000	;	int mecha_lv2_steel	=	0	;	int mecha_lv2_alloy	=	0	;	int mecha_lv2_diamond	=	760	;	int mecha_lv2_cc	=	100	;	int mecha_lv2_ac	=	0	;
    int mecha_lv3_fuel	=	9500000	;	int mecha_lv3_food	=	0	;	int mecha_lv3_steel	=	0	;	int mecha_lv3_alloy	=	0	;	int mecha_lv3_diamond	=	1000	;	int mecha_lv3_cc	=	300	;	int mecha_lv3_ac	=	0	;
    int mecha_lv4_fuel	=	0	;	int mecha_lv4_food	=	0	;	int mecha_lv4_steel	=	0	;	int mecha_lv4_alloy	=	2100000	;	int mecha_lv4_diamond	=	1300	;	int mecha_lv4_cc	=	500	;	int mecha_lv4_ac	=	0	;
    int mecha_lv5_fuel	=	0	;	int mecha_lv5_food	=	0	;	int mecha_lv5_steel	=	661400	;	int mecha_lv5_alloy	=	0	;	int mecha_lv5_diamond	=	1500	;	int mecha_lv5_cc	=	700	;	int mecha_lv5_ac	=	0	;
    int mecha_lv6_fuel	=	0	;	int mecha_lv6_food	=	19200000	;	int mecha_lv6_steel	=	0	;	int mecha_lv6_alloy	=	0	;	int mecha_lv6_diamond	=	1800	;	int mecha_lv6_cc	=	900	;	int mecha_lv6_ac	=	0	;
    int mecha_lv7_fuel	=	22900000	;	int mecha_lv7_food	=	0	;	int mecha_lv7_steel	=	0	;	int mecha_lv7_alloy	=	0	;	int mecha_lv7_diamond	=	2100	;	int mecha_lv7_cc	=	1100	;	int mecha_lv7_ac	=	0	;
    int mecha_lv8_fuel	=	0	;	int mecha_lv8_food	=	0	;	int mecha_lv8_steel	=	0	;	int mecha_lv8_alloy	=	4400000	;	int mecha_lv8_diamond	=	2400	;	int mecha_lv8_cc	=	1300	;	int mecha_lv8_ac	=	0	;
    int mecha_lv9_fuel	=	0	;	int mecha_lv9_food	=	0	;	int mecha_lv9_steel	=	1300000	;	int mecha_lv9_alloy	=	0	;	int mecha_lv9_diamond	=	2800	;	int mecha_lv9_cc	=	1500	;	int mecha_lv9_ac	=	0	;
    int mecha_lv10_fuel	=	0	;	int mecha_lv10_food	=	34600000	;	int mecha_lv10_steel	=	0	;	int mecha_lv10_alloy	=	0	;	int mecha_lv10_diamond	=	3100	;	int mecha_lv10_cc	=	1850	;	int mecha_lv10_ac	=	0	;
    int mecha_lv11_fuel	=	39000000	;	int mecha_lv11_food	=	0	;	int mecha_lv11_steel	=	0	;	int mecha_lv11_alloy	=	0	;	int mecha_lv11_diamond	=	3500	;	int mecha_lv11_cc	=	2350	;	int mecha_lv11_ac	=	0	;
    int mecha_lv12_fuel	=	0	;	int mecha_lv12_food	=	0	;	int mecha_lv12_steel	=	0	;	int mecha_lv12_alloy	=	7200000	;	int mecha_lv12_diamond	=	3900	;	int mecha_lv12_cc	=	3770	;	int mecha_lv12_ac	=	0	;
    int mecha_lv13_fuel	=	0	;	int mecha_lv13_food	=	0	;	int mecha_lv13_steel	=	2000000	;	int mecha_lv13_alloy	=	0	;	int mecha_lv13_diamond	=	4200	;	int mecha_lv13_cc	=	4850	;	int mecha_lv13_ac	=	0	;
    int mecha_lv14_fuel	=	0	;	int mecha_lv14_food	=	52900000	;	int mecha_lv14_steel	=	0	;	int mecha_lv14_alloy	=	0	;	int mecha_lv14_diamond	=	4600	;	int mecha_lv14_cc	=	6580	;	int mecha_lv14_ac	=	0	;
    int mecha_lv15_fuel	=	57900000	;	int mecha_lv15_food	=	0	;	int mecha_lv15_steel	=	0	;	int mecha_lv15_alloy	=	0	;	int mecha_lv15_diamond	=	5000	;	int mecha_lv15_cc	=	7860	;	int mecha_lv15_ac	=	0	;
    int mecha_lv16_fuel	=	0	;	int mecha_lv16_food	=	0	;	int mecha_lv16_steel	=	0	;	int mecha_lv16_alloy	=	10500000	;	int mecha_lv16_diamond	=	5500	;	int mecha_lv16_cc	=	9440	;	int mecha_lv16_ac	=	0	;
    int mecha_lv17_fuel	=	0	;	int mecha_lv17_food	=	0	;	int mecha_lv17_steel	=	2900000	;	int mecha_lv17_alloy	=	0	;	int mecha_lv17_diamond	=	5900	;	int mecha_lv17_cc	=	11080	;	int mecha_lv17_ac	=	0	;
    int mecha_lv18_fuel	=	0	;	int mecha_lv18_food	=	74000000	;	int mecha_lv18_steel	=	0	;	int mecha_lv18_alloy	=	0	;	int mecha_lv18_diamond	=	6400	;	int mecha_lv18_cc	=	12720	;	int mecha_lv18_ac	=	0	;
    int mecha_lv19_fuel	=	79800000	;	int mecha_lv19_food	=	0	;	int mecha_lv19_steel	=	0	;	int mecha_lv19_alloy	=	0	;	int mecha_lv19_diamond	=	6800	;	int mecha_lv19_cc	=	14800	;	int mecha_lv19_ac	=	0	;
    int mecha_lv20_fuel	=	0	;	int mecha_lv20_food	=	0	;	int mecha_lv20_steel	=	0	;	int mecha_lv20_alloy	=	14300000	;	int mecha_lv20_diamond	=	7300	;	int mecha_lv20_cc	=	17800	;	int mecha_lv20_ac	=	0	;
    int mecha_lv21_fuel	=	0	;	int mecha_lv21_food	=	0	;	int mecha_lv21_steel	=	3800000	;	int mecha_lv21_alloy	=	0	;	int mecha_lv21_diamond	=	7800	;	int mecha_lv21_cc	=	20500	;	int mecha_lv21_ac	=	0	;
    int mecha_lv22_fuel	=	0	;	int mecha_lv22_food	=	83200000	;	int mecha_lv22_steel	=	0	;	int mecha_lv22_alloy	=	0	;	int mecha_lv22_diamond	=	8300	;	int mecha_lv22_cc	=	0	;	int mecha_lv22_ac	=	530	;
    int mecha_lv23_fuel	=	88700000	;	int mecha_lv23_food	=	0	;	int mecha_lv23_steel	=	0	;	int mecha_lv23_alloy	=	0	;	int mecha_lv23_diamond	=	8900	;	int mecha_lv23_cc	=	0	;	int mecha_lv23_ac	=	760	;
    int mecha_lv24_fuel	=	0	;	int mecha_lv24_food	=	0	;	int mecha_lv24_steel	=	0	;	int mecha_lv24_alloy	=	15700000	;	int mecha_lv24_diamond	=	9400	;	int mecha_lv24_cc	=	0	;	int mecha_lv24_ac	=	850	;
    int mecha_lv25_fuel	=	0	;	int mecha_lv25_food	=	0	;	int mecha_lv25_steel	=	3900000	;	int mecha_lv25_alloy	=	0	;	int mecha_lv25_diamond	=	10000	;	int mecha_lv25_cc	=	0	;	int mecha_lv25_ac	=	1033	;
    int mecha_lv26_fuel	=	0	;	int mecha_lv26_food	=	87200000	;	int mecha_lv26_steel	=	0	;	int mecha_lv26_alloy	=	0	;	int mecha_lv26_diamond	=	10500	;	int mecha_lv26_cc	=	0	;	int mecha_lv26_ac	=	1170	;
    int mecha_lv27_fuel	=	92200000	;	int mecha_lv27_food	=	0	;	int mecha_lv27_steel	=	0	;	int mecha_lv27_alloy	=	0	;	int mecha_lv27_diamond	=	11100	;	int mecha_lv27_cc	=	0	;	int mecha_lv27_ac	=	1260	;
    int mecha_lv28_fuel	=	0	;	int mecha_lv28_food	=	0	;	int mecha_lv28_steel	=	0	;	int mecha_lv28_alloy	=	16200000	;	int mecha_lv28_diamond	=	11700	;	int mecha_lv28_cc	=	0	;	int mecha_lv28_ac	=	1320	;
    int mecha_lv29_fuel	=	0	;	int mecha_lv29_food	=	0	;	int mecha_lv29_steel	=	4200000	;	int mecha_lv29_alloy	=	0	;	int mecha_lv29_diamond	=	12300	;	int mecha_lv29_cc	=	0	;	int mecha_lv29_ac	=	1450	;
    int mecha_lv30_fuel	=	0	;	int mecha_lv30_food	=	92500000	;	int mecha_lv30_steel	=	0	;	int mecha_lv30_alloy	=	0	;	int mecha_lv30_diamond	=	13000	;	int mecha_lv30_cc	=	0	;	int mecha_lv30_ac	=	1570	;
    int mecha_lv31_fuel	=	97200000	;	int mecha_lv31_food	=	0	;	int mecha_lv31_steel	=	0	;	int mecha_lv31_alloy	=	0	;	int mecha_lv31_diamond	=	13600	;	int mecha_lv31_cc	=	0	;	int mecha_lv31_ac	=	1640	;
    int mecha_lv32_fuel	=	0	;	int mecha_lv32_food	=	0	;	int mecha_lv32_steel	=	0	;	int mecha_lv32_alloy	=	17000000	;	int mecha_lv32_diamond	=	14200	;	int mecha_lv32_cc	=	0	;	int mecha_lv32_ac	=	1727	;
    int mecha_lv33_fuel	=	0	;	int mecha_lv33_food	=	0	;	int mecha_lv33_steel	=	4600000	;	int mecha_lv33_alloy	=	0	;	int mecha_lv33_diamond	=	14900	;	int mecha_lv33_cc	=	0	;	int mecha_lv33_ac	=	1800	;
    int mecha_lv34_fuel	=	0	;	int mecha_lv34_food	=	102600000	;	int mecha_lv34_steel	=	0	;	int mecha_lv34_alloy	=	0	;	int mecha_lv34_diamond	=	15600	;	int mecha_lv34_cc	=	0	;	int mecha_lv34_ac	=	1867	;
    int mecha_lv35_fuel	=	107300000	;	int mecha_lv35_food	=	0	;	int mecha_lv35_steel	=	0	;	int mecha_lv35_alloy	=	0	;	int mecha_lv35_diamond	=	16300	;	int mecha_lv35_cc	=	0	;	int mecha_lv35_ac	=	1927	;
    int mecha_lv36_fuel	=	0	;	int mecha_lv36_food	=	0	;	int mecha_lv36_steel	=	0	;	int mecha_lv36_alloy	=	18700000	;	int mecha_lv36_diamond	=	17000	;	int mecha_lv36_cc	=	0	;	int mecha_lv36_ac	=	2007	;
    int mecha_lv37_fuel	=	0	;	int mecha_lv37_food	=	0	;	int mecha_lv37_steel	=	4900000	;	int mecha_lv37_alloy	=	0	;	int mecha_lv37_diamond	=	17700	;	int mecha_lv37_cc	=	0	;	int mecha_lv37_ac	=	2090	;
    int mecha_lv38_fuel	=	0	;	int mecha_lv38_food	=	110900000	;	int mecha_lv38_steel	=	0	;	int mecha_lv38_alloy	=	0	;	int mecha_lv38_diamond	=	18500	;	int mecha_lv38_cc	=	0	;	int mecha_lv38_ac	=	2175	;
    int mecha_lv39_fuel	=	127000000	;	int mecha_lv39_food	=	0	;	int mecha_lv39_steel	=	0	;	int mecha_lv39_alloy	=	0	;	int mecha_lv39_diamond	=	19200	;	int mecha_lv39_cc	=	0	;	int mecha_lv39_ac	=	2263	;
    int mecha_lv40_fuel	=	0	;	int mecha_lv40_food	=	0	;	int mecha_lv40_steel	=	0	;	int mecha_lv40_alloy	=	20000000	;	int mecha_lv40_diamond	=	20000	;	int mecha_lv40_cc	=	0	;	int mecha_lv40_ac	=	2430	;
    int mecha_lv41_fuel	=	0	;	int mecha_lv41_food	=	0	;	int mecha_lv41_steel	=	6800000	;	int mecha_lv41_alloy	=	0	;	int mecha_lv41_diamond	=	20800	;	int mecha_lv41_cc	=	0	;	int mecha_lv41_ac	=	2572	;
    int mecha_lv42_fuel	=	0	;	int mecha_lv42_food	=	155800000	;	int mecha_lv42_steel	=	0	;	int mecha_lv42_alloy	=	0	;	int mecha_lv42_diamond	=	21600	;	int mecha_lv42_cc	=	0	;	int mecha_lv42_ac	=	2680	;
    int mecha_lv43_fuel	=	161800000	;	int mecha_lv43_food	=	0	;	int mecha_lv43_steel	=	0	;	int mecha_lv43_alloy	=	0	;	int mecha_lv43_diamond	=	22400	;	int mecha_lv43_cc	=	0	;	int mecha_lv43_ac	=	2765	;
    int mecha_lv44_fuel	=	0	;	int mecha_lv44_food	=	0	;	int mecha_lv44_steel	=	0	;	int mecha_lv44_alloy	=	28000000	;	int mecha_lv44_diamond	=	23300	;	int mecha_lv44_cc	=	0	;	int mecha_lv44_ac	=	2866	;
    int mecha_lv45_fuel	=	0	;	int mecha_lv45_food	=	0	;	int mecha_lv45_steel	=	7300000	;	int mecha_lv45_alloy	=	0	;	int mecha_lv45_diamond	=	24000	;	int mecha_lv45_cc	=	0	;	int mecha_lv45_ac	=	2945	;
    int mecha_lv46_fuel	=	0	;	int mecha_lv46_food	=	180300000	;	int mecha_lv46_steel	=	0	;	int mecha_lv46_alloy	=	0	;	int mecha_lv46_diamond	=	24900	;	int mecha_lv46_cc	=	0	;	int mecha_lv46_ac	=	3012	;
    int mecha_lv47_fuel	=	171200000	;	int mecha_lv47_food	=	0	;	int mecha_lv47_steel	=	0	;	int mecha_lv47_alloy	=	0	;	int mecha_lv47_diamond	=	25800	;	int mecha_lv47_cc	=	0	;	int mecha_lv47_ac	=	3170	;
    int mecha_lv48_fuel	=	0	;	int mecha_lv48_food	=	0	;	int mecha_lv48_steel	=	0	;	int mecha_lv48_alloy	=	32200000	;	int mecha_lv48_diamond	=	26600	;	int mecha_lv48_cc	=	0	;	int mecha_lv48_ac	=	3248	;
    int mecha_lv49_fuel	=	0	;	int mecha_lv49_food	=	0	;	int mecha_lv49_steel	=	10600000	;	int mecha_lv49_alloy	=	0	;	int mecha_lv49_diamond	=	27500	;	int mecha_lv49_cc	=	0	;	int mecha_lv49_ac	=	3368	;
    int mecha_lv50_fuel	=	0	;	int mecha_lv50_food	=	0	;	int mecha_lv50_steel	=	13100000	;	int mecha_lv50_alloy	=	0	;	int mecha_lv50_diamond	=	29000	;	int mecha_lv50_cc	=	0	;	int mecha_lv50_ac	=	3505	;

    ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;

    SeekBar now_seek , aim_seek  ;
    TextView now_tv , aim_tv  ;
    TextView mecha_fuel_tv , mecha_food_tv ,	mecha_steel_tv ,mecha_alloy_tv ,mecha_diamond_tv ,mecha_ac_tv ,mecha_cc_tv  ;
    TextView mecha_fueld_tv , mecha_foodd_tv ,	mecha_steeld_tv ,mecha_alloyd_tv ;
    int mecha_fuel = 0 , mecha_food = 0,	mecha_steel= 0 ,mecha_alloy= 0 ,mecha_diamond= 0 ,mecha_ac= 0 ,mecha_cc= 0 ,mecha_fueld = 0 , mecha_foodd = 0,	mecha_steeld= 0 ,mecha_alloyd= 0  ;
    CheckBox cb_rss ,cb_diam ;
    int now= 0 , aim = 0;
    String mecha_name ;

    ImageView mecha_img ;

    TextView mecha_tv ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mecha);

        listView = findViewById(R.id.list_mecha);

        mecha_fuel_tv = findViewById(R.id.mecha_fuel_et)	;
        mecha_food_tv = findViewById(R.id.mecha_food_et)	;
        mecha_steel_tv = findViewById(R.id.mecha_steel_et)	;
        mecha_alloy_tv = findViewById(R.id.mecha_alloy_et)	;
        mecha_diamond_tv = findViewById(R.id.mecha_diamond_et)	;
        mecha_ac_tv = findViewById(R.id.mecha_ac_et)	;
        mecha_cc_tv = findViewById(R.id.mecha_cc_et)	;

        mecha_fueld_tv = findViewById(R.id.mecha_fuel_et2)	;
        mecha_foodd_tv = findViewById(R.id.mecha_food_et2)	;
        mecha_steeld_tv = findViewById(R.id.mecha_steel_et2)	;
        mecha_alloyd_tv = findViewById(R.id.mecha_alloy_et2)	;

        mecha_img = findViewById(R.id.mecha);
        mecha_tv = findViewById(R.id.mecha_tv);

        now_seek = findViewById(R.id.mecha_now_et);
        aim_seek = findViewById(R.id.mecha_aim_et);

        cb_rss = findViewById(R.id.cb_rss);
        cb_diam = findViewById(R.id.cb_diam);

        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.list_tv, arrayList);
        listView.setAdapter(adapter);

        now_tv = findViewById(R.id.mecha_now_tv);
        aim_tv = findViewById(R.id.mecha_aim_tv);
        now_seek.setMax(49);
        aim_seek.setMax(50);
        now_seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub
                if (now_seek.getProgress() >= aim_seek.getProgress()){aim_seek.setProgress(now_seek.getProgress()+1);}
                now = now_seek.getProgress();
                aim = aim_seek.getProgress();
                now_tv.setText(String.valueOf(now));
                aim_tv.setText(String.valueOf(aim));

                calculate();
            }
        });

        aim_seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub
                if (aim_seek.getProgress() <= now_seek.getProgress()){aim_seek.setProgress(now_seek.getProgress()+1);}

                now = now_seek.getProgress();
                aim = aim_seek.getProgress();
                now_tv.setText(String.valueOf(now));
                aim_tv.setText(String.valueOf(aim));
                calculate();
            }
        });

        BackgroundReload();
    }
    public void BackgroundReload (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.mecha_bg);

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

    public void mecha_choose(View view){
        final Dialog dialog = new Dialog(this, R.style.NormalDialogStyle_N);
        view = View.inflate(this, R.layout.mecha_choose, null);

        SharedPreferences sharedPreferences = getSharedPreferences("json_data", Context.MODE_PRIVATE);

        ImageView	mecha01	=	view.findViewById(R.id.	mecha01	);
        ImageView	mecha02	=	view.findViewById(R.id.	mecha02	);
        ImageView	mecha03	=	view.findViewById(R.id.	mecha03	);
        ImageView	mecha04	=	view.findViewById(R.id.	mecha04	);

        mecha01.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();mecha_name = getString(R.string.mecha_name);mecha_img.setImageResource(R.drawable.mecha_mecha);now_seek.setProgress(Integer.parseInt(String.valueOf((sharedPreferences.getLong("mecha01Lv",0)))));}});
        mecha02.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();mecha_name = getString(R.string.mecha_land_name);mecha_img.setImageResource(R.drawable.mecha_land);now_seek.setProgress(Integer.parseInt(String.valueOf((sharedPreferences.getLong("mecha02Lv",0)))));}});
        mecha03.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();mecha_name = getString(R.string.mecha_air_name);mecha_img.setImageResource(R.drawable.mecha_air);now_seek.setProgress(Integer.parseInt(String.valueOf((sharedPreferences.getLong("mecha03Lv",0)))));}});
        mecha04.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();mecha_name = getString(R.string.mecha_mana_name);mecha_img.setImageResource(R.drawable.mecha_mana);now_seek.setProgress(Integer.parseInt(String.valueOf((sharedPreferences.getLong("mecha04Lv",0)))));}});

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
    }

    public void calculate () {
        adapter.clear();
        mecha_fuel = 0 ; mecha_food = 0;	mecha_steel= 0 ;mecha_alloy= 0 ;mecha_fueld = 0 ; mecha_foodd = 0;	mecha_steeld= 0 ;mecha_alloyd= 0 ;mecha_diamond= 0 ;mecha_ac= 0 ;mecha_cc= 0;

        if(now ==1	&& aim >=2)	{mecha_fuel = mecha_fuel+mecha_lv2_fuel;	mecha_food = mecha_food+mecha_lv2_food;	mecha_steel = mecha_steel+mecha_lv2_steel;	mecha_alloy = mecha_alloy+mecha_lv2_alloy;	mecha_diamond = mecha_diamond+mecha_lv2_diamond;	mecha_ac = mecha_ac+mecha_lv2_ac;	mecha_cc = mecha_cc+mecha_lv2_cc;	adapter.add(getString(R.string.mecha_upgrade)+"2");	mecha_foodd = mecha_foodd+	mecha_lv2_diamond;}
        if(now <3	&& aim >=3)	{mecha_fuel = mecha_fuel+mecha_lv3_fuel;	mecha_food = mecha_food+mecha_lv3_food;	mecha_steel = mecha_steel+mecha_lv3_steel;	mecha_alloy = mecha_alloy+mecha_lv3_alloy;	mecha_diamond = mecha_diamond+mecha_lv3_diamond;	mecha_ac = mecha_ac+mecha_lv3_ac;	mecha_cc = mecha_cc+mecha_lv3_cc;	adapter.add(getString(R.string.mecha_upgrade)+"3");	mecha_fueld = mecha_fueld+	mecha_lv3_diamond;}
        if(now <4	&& aim >=4)	{mecha_fuel = mecha_fuel+mecha_lv4_fuel;	mecha_food = mecha_food+mecha_lv4_food;	mecha_steel = mecha_steel+mecha_lv4_steel;	mecha_alloy = mecha_alloy+mecha_lv4_alloy;	mecha_diamond = mecha_diamond+mecha_lv4_diamond;	mecha_ac = mecha_ac+mecha_lv4_ac;	mecha_cc = mecha_cc+mecha_lv4_cc;	adapter.add(getString(R.string.mecha_upgrade)+"4");	mecha_alloyd = mecha_alloyd+	mecha_lv4_diamond;}
        if(now <5	&& aim >=5)	{mecha_fuel = mecha_fuel+mecha_lv5_fuel;	mecha_food = mecha_food+mecha_lv5_food;	mecha_steel = mecha_steel+mecha_lv5_steel;	mecha_alloy = mecha_alloy+mecha_lv5_alloy;	mecha_diamond = mecha_diamond+mecha_lv5_diamond;	mecha_ac = mecha_ac+mecha_lv5_ac;	mecha_cc = mecha_cc+mecha_lv5_cc;	adapter.add(getString(R.string.mecha_upgrade)+"5");	mecha_steeld = mecha_steeld+	mecha_lv5_diamond;}
        if(now <6	&& aim >=6)	{mecha_fuel = mecha_fuel+mecha_lv6_fuel;	mecha_food = mecha_food+mecha_lv6_food;	mecha_steel = mecha_steel+mecha_lv6_steel;	mecha_alloy = mecha_alloy+mecha_lv6_alloy;	mecha_diamond = mecha_diamond+mecha_lv6_diamond;	mecha_ac = mecha_ac+mecha_lv6_ac;	mecha_cc = mecha_cc+mecha_lv6_cc;	adapter.add(getString(R.string.mecha_upgrade)+"6");	mecha_foodd = mecha_foodd+	mecha_lv6_diamond;}
        if(now <7	&& aim >=7)	{mecha_fuel = mecha_fuel+mecha_lv7_fuel;	mecha_food = mecha_food+mecha_lv7_food;	mecha_steel = mecha_steel+mecha_lv7_steel;	mecha_alloy = mecha_alloy+mecha_lv7_alloy;	mecha_diamond = mecha_diamond+mecha_lv7_diamond;	mecha_ac = mecha_ac+mecha_lv7_ac;	mecha_cc = mecha_cc+mecha_lv7_cc;	adapter.add(getString(R.string.mecha_upgrade)+"7");	mecha_fueld = mecha_fueld+	mecha_lv7_diamond;}
        if(now <8	&& aim >=8)	{mecha_fuel = mecha_fuel+mecha_lv8_fuel;	mecha_food = mecha_food+mecha_lv8_food;	mecha_steel = mecha_steel+mecha_lv8_steel;	mecha_alloy = mecha_alloy+mecha_lv8_alloy;	mecha_diamond = mecha_diamond+mecha_lv8_diamond;	mecha_ac = mecha_ac+mecha_lv8_ac;	mecha_cc = mecha_cc+mecha_lv8_cc;	adapter.add(getString(R.string.mecha_upgrade)+"8");	mecha_alloyd = mecha_alloyd+	mecha_lv8_diamond;}
        if(now <9	&& aim >=9)	{mecha_fuel = mecha_fuel+mecha_lv9_fuel;	mecha_food = mecha_food+mecha_lv9_food;	mecha_steel = mecha_steel+mecha_lv9_steel;	mecha_alloy = mecha_alloy+mecha_lv9_alloy;	mecha_diamond = mecha_diamond+mecha_lv9_diamond;	mecha_ac = mecha_ac+mecha_lv9_ac;	mecha_cc = mecha_cc+mecha_lv9_cc;	adapter.add(getString(R.string.mecha_upgrade)+"9");	mecha_steeld = mecha_steeld+	mecha_lv9_diamond;}
        if(now <10	&& aim >=10)	{mecha_fuel = mecha_fuel+mecha_lv10_fuel;	mecha_food = mecha_food+mecha_lv10_food;	mecha_steel = mecha_steel+mecha_lv10_steel;	mecha_alloy = mecha_alloy+mecha_lv10_alloy;	mecha_diamond = mecha_diamond+mecha_lv10_diamond;	mecha_ac = mecha_ac+mecha_lv10_ac;	mecha_cc = mecha_cc+mecha_lv10_cc;	adapter.add(getString(R.string.mecha_upgrade)+"10");	mecha_foodd = mecha_foodd+	mecha_lv10_diamond;}
        if(now <11	&& aim >=11)	{mecha_fuel = mecha_fuel+mecha_lv11_fuel;	mecha_food = mecha_food+mecha_lv11_food;	mecha_steel = mecha_steel+mecha_lv11_steel;	mecha_alloy = mecha_alloy+mecha_lv11_alloy;	mecha_diamond = mecha_diamond+mecha_lv11_diamond;	mecha_ac = mecha_ac+mecha_lv11_ac;	mecha_cc = mecha_cc+mecha_lv11_cc;	adapter.add(getString(R.string.mecha_upgrade)+"11");	mecha_fueld = mecha_fueld+	mecha_lv11_diamond;}
        if(now <12	&& aim >=12)	{mecha_fuel = mecha_fuel+mecha_lv12_fuel;	mecha_food = mecha_food+mecha_lv12_food;	mecha_steel = mecha_steel+mecha_lv12_steel;	mecha_alloy = mecha_alloy+mecha_lv12_alloy;	mecha_diamond = mecha_diamond+mecha_lv12_diamond;	mecha_ac = mecha_ac+mecha_lv12_ac;	mecha_cc = mecha_cc+mecha_lv12_cc;	adapter.add(getString(R.string.mecha_upgrade)+"12");	mecha_alloyd = mecha_alloyd+	mecha_lv12_diamond;}
        if(now <13	&& aim >=13)	{mecha_fuel = mecha_fuel+mecha_lv13_fuel;	mecha_food = mecha_food+mecha_lv13_food;	mecha_steel = mecha_steel+mecha_lv13_steel;	mecha_alloy = mecha_alloy+mecha_lv13_alloy;	mecha_diamond = mecha_diamond+mecha_lv13_diamond;	mecha_ac = mecha_ac+mecha_lv13_ac;	mecha_cc = mecha_cc+mecha_lv13_cc;	adapter.add(getString(R.string.mecha_upgrade)+"13");	mecha_steeld = mecha_steeld+	mecha_lv13_diamond;}
        if(now <14	&& aim >=14)	{mecha_fuel = mecha_fuel+mecha_lv14_fuel;	mecha_food = mecha_food+mecha_lv14_food;	mecha_steel = mecha_steel+mecha_lv14_steel;	mecha_alloy = mecha_alloy+mecha_lv14_alloy;	mecha_diamond = mecha_diamond+mecha_lv14_diamond;	mecha_ac = mecha_ac+mecha_lv14_ac;	mecha_cc = mecha_cc+mecha_lv14_cc;	adapter.add(getString(R.string.mecha_upgrade)+"14");	mecha_foodd = mecha_foodd+	mecha_lv14_diamond;}
        if(now <15	&& aim >=15)	{mecha_fuel = mecha_fuel+mecha_lv15_fuel;	mecha_food = mecha_food+mecha_lv15_food;	mecha_steel = mecha_steel+mecha_lv15_steel;	mecha_alloy = mecha_alloy+mecha_lv15_alloy;	mecha_diamond = mecha_diamond+mecha_lv15_diamond;	mecha_ac = mecha_ac+mecha_lv15_ac;	mecha_cc = mecha_cc+mecha_lv15_cc;	adapter.add(getString(R.string.mecha_upgrade)+"15");	mecha_fueld = mecha_fueld+	mecha_lv15_diamond;}
        if(now <16	&& aim >=16)	{mecha_fuel = mecha_fuel+mecha_lv16_fuel;	mecha_food = mecha_food+mecha_lv16_food;	mecha_steel = mecha_steel+mecha_lv16_steel;	mecha_alloy = mecha_alloy+mecha_lv16_alloy;	mecha_diamond = mecha_diamond+mecha_lv16_diamond;	mecha_ac = mecha_ac+mecha_lv16_ac;	mecha_cc = mecha_cc+mecha_lv16_cc;	adapter.add(getString(R.string.mecha_upgrade)+"16");	mecha_alloyd = mecha_alloyd+	mecha_lv16_diamond;}
        if(now <17	&& aim >=17)	{mecha_fuel = mecha_fuel+mecha_lv17_fuel;	mecha_food = mecha_food+mecha_lv17_food;	mecha_steel = mecha_steel+mecha_lv17_steel;	mecha_alloy = mecha_alloy+mecha_lv17_alloy;	mecha_diamond = mecha_diamond+mecha_lv17_diamond;	mecha_ac = mecha_ac+mecha_lv17_ac;	mecha_cc = mecha_cc+mecha_lv17_cc;	adapter.add(getString(R.string.mecha_upgrade)+"17");	mecha_steeld = mecha_steeld+	mecha_lv17_diamond;}
        if(now <18	&& aim >=18)	{mecha_fuel = mecha_fuel+mecha_lv18_fuel;	mecha_food = mecha_food+mecha_lv18_food;	mecha_steel = mecha_steel+mecha_lv18_steel;	mecha_alloy = mecha_alloy+mecha_lv18_alloy;	mecha_diamond = mecha_diamond+mecha_lv18_diamond;	mecha_ac = mecha_ac+mecha_lv18_ac;	mecha_cc = mecha_cc+mecha_lv18_cc;	adapter.add(getString(R.string.mecha_upgrade)+"18");	mecha_foodd = mecha_foodd+	mecha_lv18_diamond;}
        if(now <19	&& aim >=19)	{mecha_fuel = mecha_fuel+mecha_lv19_fuel;	mecha_food = mecha_food+mecha_lv19_food;	mecha_steel = mecha_steel+mecha_lv19_steel;	mecha_alloy = mecha_alloy+mecha_lv19_alloy;	mecha_diamond = mecha_diamond+mecha_lv19_diamond;	mecha_ac = mecha_ac+mecha_lv19_ac;	mecha_cc = mecha_cc+mecha_lv19_cc;	adapter.add(getString(R.string.mecha_upgrade)+"19");	mecha_fueld = mecha_fueld+	mecha_lv19_diamond;}
        if(now <20	&& aim >=20)	{mecha_fuel = mecha_fuel+mecha_lv20_fuel;	mecha_food = mecha_food+mecha_lv20_food;	mecha_steel = mecha_steel+mecha_lv20_steel;	mecha_alloy = mecha_alloy+mecha_lv20_alloy;	mecha_diamond = mecha_diamond+mecha_lv20_diamond;	mecha_ac = mecha_ac+mecha_lv20_ac;	mecha_cc = mecha_cc+mecha_lv20_cc;	adapter.add(getString(R.string.mecha_upgrade)+"20");	mecha_alloyd = mecha_alloyd+	mecha_lv20_diamond;}
        if(now <21	&& aim >=21)	{mecha_fuel = mecha_fuel+mecha_lv21_fuel;	mecha_food = mecha_food+mecha_lv21_food;	mecha_steel = mecha_steel+mecha_lv21_steel;	mecha_alloy = mecha_alloy+mecha_lv21_alloy;	mecha_diamond = mecha_diamond+mecha_lv21_diamond;	mecha_ac = mecha_ac+mecha_lv21_ac;	mecha_cc = mecha_cc+mecha_lv21_cc;	adapter.add(getString(R.string.mecha_upgrade)+"21");	mecha_steeld = mecha_steeld+	mecha_lv21_diamond;}
        if(now <22	&& aim >=22)	{mecha_fuel = mecha_fuel+mecha_lv22_fuel;	mecha_food = mecha_food+mecha_lv22_food;	mecha_steel = mecha_steel+mecha_lv22_steel;	mecha_alloy = mecha_alloy+mecha_lv22_alloy;	mecha_diamond = mecha_diamond+mecha_lv22_diamond;	mecha_ac = mecha_ac+mecha_lv22_ac;	mecha_cc = mecha_cc+mecha_lv22_cc;	adapter.add(getString(R.string.mecha_upgrade)+"22");	mecha_foodd = mecha_foodd+	mecha_lv22_diamond;}
        if(now <23	&& aim >=23)	{mecha_fuel = mecha_fuel+mecha_lv23_fuel;	mecha_food = mecha_food+mecha_lv23_food;	mecha_steel = mecha_steel+mecha_lv23_steel;	mecha_alloy = mecha_alloy+mecha_lv23_alloy;	mecha_diamond = mecha_diamond+mecha_lv23_diamond;	mecha_ac = mecha_ac+mecha_lv23_ac;	mecha_cc = mecha_cc+mecha_lv23_cc;	adapter.add(getString(R.string.mecha_upgrade)+"23");	mecha_fueld = mecha_fueld+	mecha_lv23_diamond;}
        if(now <24	&& aim >=24)	{mecha_fuel = mecha_fuel+mecha_lv24_fuel;	mecha_food = mecha_food+mecha_lv24_food;	mecha_steel = mecha_steel+mecha_lv24_steel;	mecha_alloy = mecha_alloy+mecha_lv24_alloy;	mecha_diamond = mecha_diamond+mecha_lv24_diamond;	mecha_ac = mecha_ac+mecha_lv24_ac;	mecha_cc = mecha_cc+mecha_lv24_cc;	adapter.add(getString(R.string.mecha_upgrade)+"24");	mecha_alloyd = mecha_alloyd+	mecha_lv24_diamond;}
        if(now <25	&& aim >=25)	{mecha_fuel = mecha_fuel+mecha_lv25_fuel;	mecha_food = mecha_food+mecha_lv25_food;	mecha_steel = mecha_steel+mecha_lv25_steel;	mecha_alloy = mecha_alloy+mecha_lv25_alloy;	mecha_diamond = mecha_diamond+mecha_lv25_diamond;	mecha_ac = mecha_ac+mecha_lv25_ac;	mecha_cc = mecha_cc+mecha_lv25_cc;	adapter.add(getString(R.string.mecha_upgrade)+"25");	mecha_steeld = mecha_steeld+	mecha_lv25_diamond;}
        if(now <26	&& aim >=26)	{mecha_fuel = mecha_fuel+mecha_lv26_fuel;	mecha_food = mecha_food+mecha_lv26_food;	mecha_steel = mecha_steel+mecha_lv26_steel;	mecha_alloy = mecha_alloy+mecha_lv26_alloy;	mecha_diamond = mecha_diamond+mecha_lv26_diamond;	mecha_ac = mecha_ac+mecha_lv26_ac;	mecha_cc = mecha_cc+mecha_lv26_cc;	adapter.add(getString(R.string.mecha_upgrade)+"26");	mecha_foodd = mecha_foodd+	mecha_lv26_diamond;}
        if(now <27	&& aim >=27)	{mecha_fuel = mecha_fuel+mecha_lv27_fuel;	mecha_food = mecha_food+mecha_lv27_food;	mecha_steel = mecha_steel+mecha_lv27_steel;	mecha_alloy = mecha_alloy+mecha_lv27_alloy;	mecha_diamond = mecha_diamond+mecha_lv27_diamond;	mecha_ac = mecha_ac+mecha_lv27_ac;	mecha_cc = mecha_cc+mecha_lv27_cc;	adapter.add(getString(R.string.mecha_upgrade)+"27");	mecha_fueld = mecha_fueld+	mecha_lv27_diamond;}
        if(now <28	&& aim >=28)	{mecha_fuel = mecha_fuel+mecha_lv28_fuel;	mecha_food = mecha_food+mecha_lv28_food;	mecha_steel = mecha_steel+mecha_lv28_steel;	mecha_alloy = mecha_alloy+mecha_lv28_alloy;	mecha_diamond = mecha_diamond+mecha_lv28_diamond;	mecha_ac = mecha_ac+mecha_lv28_ac;	mecha_cc = mecha_cc+mecha_lv28_cc;	adapter.add(getString(R.string.mecha_upgrade)+"28");	mecha_alloyd = mecha_alloyd+	mecha_lv28_diamond;}
        if(now <29	&& aim >=29)	{mecha_fuel = mecha_fuel+mecha_lv29_fuel;	mecha_food = mecha_food+mecha_lv29_food;	mecha_steel = mecha_steel+mecha_lv29_steel;	mecha_alloy = mecha_alloy+mecha_lv29_alloy;	mecha_diamond = mecha_diamond+mecha_lv29_diamond;	mecha_ac = mecha_ac+mecha_lv29_ac;	mecha_cc = mecha_cc+mecha_lv29_cc;	adapter.add(getString(R.string.mecha_upgrade)+"29");	mecha_steeld = mecha_steeld+	mecha_lv29_diamond;}
        if(now <30	&& aim >=30)	{mecha_fuel = mecha_fuel+mecha_lv30_fuel;	mecha_food = mecha_food+mecha_lv30_food;	mecha_steel = mecha_steel+mecha_lv30_steel;	mecha_alloy = mecha_alloy+mecha_lv30_alloy;	mecha_diamond = mecha_diamond+mecha_lv30_diamond;	mecha_ac = mecha_ac+mecha_lv30_ac;	mecha_cc = mecha_cc+mecha_lv30_cc;	adapter.add(getString(R.string.mecha_upgrade)+"30");	mecha_foodd = mecha_foodd+	mecha_lv30_diamond;}
        if(now <31	&& aim >=31)	{mecha_fuel = mecha_fuel+mecha_lv31_fuel;	mecha_food = mecha_food+mecha_lv31_food;	mecha_steel = mecha_steel+mecha_lv31_steel;	mecha_alloy = mecha_alloy+mecha_lv31_alloy;	mecha_diamond = mecha_diamond+mecha_lv31_diamond;	mecha_ac = mecha_ac+mecha_lv31_ac;	mecha_cc = mecha_cc+mecha_lv31_cc;	adapter.add(getString(R.string.mecha_upgrade)+"31");	mecha_fueld = mecha_fueld+	mecha_lv31_diamond;}
        if(now <32	&& aim >=32)	{mecha_fuel = mecha_fuel+mecha_lv32_fuel;	mecha_food = mecha_food+mecha_lv32_food;	mecha_steel = mecha_steel+mecha_lv32_steel;	mecha_alloy = mecha_alloy+mecha_lv32_alloy;	mecha_diamond = mecha_diamond+mecha_lv32_diamond;	mecha_ac = mecha_ac+mecha_lv32_ac;	mecha_cc = mecha_cc+mecha_lv32_cc;	adapter.add(getString(R.string.mecha_upgrade)+"32");	mecha_alloyd = mecha_alloyd+	mecha_lv32_diamond;}
        if(now <33	&& aim >=33)	{mecha_fuel = mecha_fuel+mecha_lv33_fuel;	mecha_food = mecha_food+mecha_lv33_food;	mecha_steel = mecha_steel+mecha_lv33_steel;	mecha_alloy = mecha_alloy+mecha_lv33_alloy;	mecha_diamond = mecha_diamond+mecha_lv33_diamond;	mecha_ac = mecha_ac+mecha_lv33_ac;	mecha_cc = mecha_cc+mecha_lv33_cc;	adapter.add(getString(R.string.mecha_upgrade)+"33");	mecha_steeld = mecha_steeld+	mecha_lv33_diamond;}
        if(now <34	&& aim >=34)	{mecha_fuel = mecha_fuel+mecha_lv34_fuel;	mecha_food = mecha_food+mecha_lv34_food;	mecha_steel = mecha_steel+mecha_lv34_steel;	mecha_alloy = mecha_alloy+mecha_lv34_alloy;	mecha_diamond = mecha_diamond+mecha_lv34_diamond;	mecha_ac = mecha_ac+mecha_lv34_ac;	mecha_cc = mecha_cc+mecha_lv34_cc;	adapter.add(getString(R.string.mecha_upgrade)+"34");	mecha_foodd = mecha_foodd+	mecha_lv34_diamond;}
        if(now <35	&& aim >=35)	{mecha_fuel = mecha_fuel+mecha_lv35_fuel;	mecha_food = mecha_food+mecha_lv35_food;	mecha_steel = mecha_steel+mecha_lv35_steel;	mecha_alloy = mecha_alloy+mecha_lv35_alloy;	mecha_diamond = mecha_diamond+mecha_lv35_diamond;	mecha_ac = mecha_ac+mecha_lv35_ac;	mecha_cc = mecha_cc+mecha_lv35_cc;	adapter.add(getString(R.string.mecha_upgrade)+"35");	mecha_fueld = mecha_fueld+	mecha_lv35_diamond;}
        if(now <36	&& aim >=36)	{mecha_fuel = mecha_fuel+mecha_lv36_fuel;	mecha_food = mecha_food+mecha_lv36_food;	mecha_steel = mecha_steel+mecha_lv36_steel;	mecha_alloy = mecha_alloy+mecha_lv36_alloy;	mecha_diamond = mecha_diamond+mecha_lv36_diamond;	mecha_ac = mecha_ac+mecha_lv36_ac;	mecha_cc = mecha_cc+mecha_lv36_cc;	adapter.add(getString(R.string.mecha_upgrade)+"36");	mecha_alloyd = mecha_alloyd+	mecha_lv36_diamond;}
        if(now <37	&& aim >=37)	{mecha_fuel = mecha_fuel+mecha_lv37_fuel;	mecha_food = mecha_food+mecha_lv37_food;	mecha_steel = mecha_steel+mecha_lv37_steel;	mecha_alloy = mecha_alloy+mecha_lv37_alloy;	mecha_diamond = mecha_diamond+mecha_lv37_diamond;	mecha_ac = mecha_ac+mecha_lv37_ac;	mecha_cc = mecha_cc+mecha_lv37_cc;	adapter.add(getString(R.string.mecha_upgrade)+"37");	mecha_steeld = mecha_steeld+	mecha_lv37_diamond;}
        if(now <38	&& aim >=38)	{mecha_fuel = mecha_fuel+mecha_lv38_fuel;	mecha_food = mecha_food+mecha_lv38_food;	mecha_steel = mecha_steel+mecha_lv38_steel;	mecha_alloy = mecha_alloy+mecha_lv38_alloy;	mecha_diamond = mecha_diamond+mecha_lv38_diamond;	mecha_ac = mecha_ac+mecha_lv38_ac;	mecha_cc = mecha_cc+mecha_lv38_cc;	adapter.add(getString(R.string.mecha_upgrade)+"38");	mecha_foodd = mecha_foodd+	mecha_lv38_diamond;}
        if(now <39	&& aim >=39)	{mecha_fuel = mecha_fuel+mecha_lv39_fuel;	mecha_food = mecha_food+mecha_lv39_food;	mecha_steel = mecha_steel+mecha_lv39_steel;	mecha_alloy = mecha_alloy+mecha_lv39_alloy;	mecha_diamond = mecha_diamond+mecha_lv39_diamond;	mecha_ac = mecha_ac+mecha_lv39_ac;	mecha_cc = mecha_cc+mecha_lv39_cc;	adapter.add(getString(R.string.mecha_upgrade)+"39");	mecha_fueld = mecha_fueld+	mecha_lv39_diamond;}
        if(now <40	&& aim >=40)	{mecha_fuel = mecha_fuel+mecha_lv40_fuel;	mecha_food = mecha_food+mecha_lv40_food;	mecha_steel = mecha_steel+mecha_lv40_steel;	mecha_alloy = mecha_alloy+mecha_lv40_alloy;	mecha_diamond = mecha_diamond+mecha_lv40_diamond;	mecha_ac = mecha_ac+mecha_lv40_ac;	mecha_cc = mecha_cc+mecha_lv40_cc;	adapter.add(getString(R.string.mecha_upgrade)+"40");	mecha_alloyd = mecha_alloyd+	mecha_lv40_diamond;}
        if(now <41	&& aim >=41)	{mecha_fuel = mecha_fuel+mecha_lv41_fuel;	mecha_food = mecha_food+mecha_lv41_food;	mecha_steel = mecha_steel+mecha_lv41_steel;	mecha_alloy = mecha_alloy+mecha_lv41_alloy;	mecha_diamond = mecha_diamond+mecha_lv41_diamond;	mecha_ac = mecha_ac+mecha_lv41_ac;	mecha_cc = mecha_cc+mecha_lv41_cc;	adapter.add(getString(R.string.mecha_upgrade)+"41");	mecha_steeld = mecha_steeld+	mecha_lv41_diamond;}
        if(now <42	&& aim >=42)	{mecha_fuel = mecha_fuel+mecha_lv42_fuel;	mecha_food = mecha_food+mecha_lv42_food;	mecha_steel = mecha_steel+mecha_lv42_steel;	mecha_alloy = mecha_alloy+mecha_lv42_alloy;	mecha_diamond = mecha_diamond+mecha_lv42_diamond;	mecha_ac = mecha_ac+mecha_lv42_ac;	mecha_cc = mecha_cc+mecha_lv42_cc;	adapter.add(getString(R.string.mecha_upgrade)+"42");	mecha_foodd = mecha_foodd+	mecha_lv42_diamond;}
        if(now <43	&& aim >=43)	{mecha_fuel = mecha_fuel+mecha_lv43_fuel;	mecha_food = mecha_food+mecha_lv43_food;	mecha_steel = mecha_steel+mecha_lv43_steel;	mecha_alloy = mecha_alloy+mecha_lv43_alloy;	mecha_diamond = mecha_diamond+mecha_lv43_diamond;	mecha_ac = mecha_ac+mecha_lv43_ac;	mecha_cc = mecha_cc+mecha_lv43_cc;	adapter.add(getString(R.string.mecha_upgrade)+"43");	mecha_fueld = mecha_fueld+	mecha_lv43_diamond;}
        if(now <44	&& aim >=44)	{mecha_fuel = mecha_fuel+mecha_lv44_fuel;	mecha_food = mecha_food+mecha_lv44_food;	mecha_steel = mecha_steel+mecha_lv44_steel;	mecha_alloy = mecha_alloy+mecha_lv44_alloy;	mecha_diamond = mecha_diamond+mecha_lv44_diamond;	mecha_ac = mecha_ac+mecha_lv44_ac;	mecha_cc = mecha_cc+mecha_lv44_cc;	adapter.add(getString(R.string.mecha_upgrade)+"44");	mecha_alloyd = mecha_alloyd+	mecha_lv44_diamond;}
        if(now <45	&& aim >=45)	{mecha_fuel = mecha_fuel+mecha_lv45_fuel;	mecha_food = mecha_food+mecha_lv45_food;	mecha_steel = mecha_steel+mecha_lv45_steel;	mecha_alloy = mecha_alloy+mecha_lv45_alloy;	mecha_diamond = mecha_diamond+mecha_lv45_diamond;	mecha_ac = mecha_ac+mecha_lv45_ac;	mecha_cc = mecha_cc+mecha_lv45_cc;	adapter.add(getString(R.string.mecha_upgrade)+"45");	mecha_steeld = mecha_steeld+	mecha_lv45_diamond;}
        if(now <46	&& aim >=46)	{mecha_fuel = mecha_fuel+mecha_lv46_fuel;	mecha_food = mecha_food+mecha_lv46_food;	mecha_steel = mecha_steel+mecha_lv46_steel;	mecha_alloy = mecha_alloy+mecha_lv46_alloy;	mecha_diamond = mecha_diamond+mecha_lv46_diamond;	mecha_ac = mecha_ac+mecha_lv46_ac;	mecha_cc = mecha_cc+mecha_lv46_cc;	adapter.add(getString(R.string.mecha_upgrade)+"46");	mecha_foodd = mecha_foodd+	mecha_lv46_diamond;}
        if(now <47	&& aim >=47)	{mecha_fuel = mecha_fuel+mecha_lv47_fuel;	mecha_food = mecha_food+mecha_lv47_food;	mecha_steel = mecha_steel+mecha_lv47_steel;	mecha_alloy = mecha_alloy+mecha_lv47_alloy;	mecha_diamond = mecha_diamond+mecha_lv47_diamond;	mecha_ac = mecha_ac+mecha_lv47_ac;	mecha_cc = mecha_cc+mecha_lv47_cc;	adapter.add(getString(R.string.mecha_upgrade)+"47");	mecha_fueld = mecha_fueld+	mecha_lv47_diamond;}
        if(now <48	&& aim >=48)	{mecha_fuel = mecha_fuel+mecha_lv48_fuel;	mecha_food = mecha_food+mecha_lv48_food;	mecha_steel = mecha_steel+mecha_lv48_steel;	mecha_alloy = mecha_alloy+mecha_lv48_alloy;	mecha_diamond = mecha_diamond+mecha_lv48_diamond;	mecha_ac = mecha_ac+mecha_lv48_ac;	mecha_cc = mecha_cc+mecha_lv48_cc;	adapter.add(getString(R.string.mecha_upgrade)+"48");	mecha_alloyd = mecha_alloyd+	mecha_lv48_diamond;}
        if(now <49	&& aim >=49)	{mecha_fuel = mecha_fuel+mecha_lv49_fuel;	mecha_food = mecha_food+mecha_lv49_food;	mecha_steel = mecha_steel+mecha_lv49_steel;	mecha_alloy = mecha_alloy+mecha_lv49_alloy;	mecha_diamond = mecha_diamond+mecha_lv49_diamond;	mecha_ac = mecha_ac+mecha_lv49_ac;	mecha_cc = mecha_cc+mecha_lv49_cc;	adapter.add(getString(R.string.mecha_upgrade)+"49");	mecha_steeld = mecha_steeld+	mecha_lv49_diamond;}
        if(now <50	&& aim >=50)	{mecha_fuel = mecha_fuel+mecha_lv50_fuel;	mecha_food = mecha_food+mecha_lv50_food;	mecha_steel = mecha_steel+mecha_lv50_steel;	mecha_alloy = mecha_alloy+mecha_lv50_alloy;	mecha_diamond = mecha_diamond+mecha_lv50_diamond;	mecha_ac = mecha_ac+mecha_lv50_ac;	mecha_cc = mecha_cc+mecha_lv50_cc;	adapter.add(getString(R.string.mecha_upgrade)+"50");	mecha_steeld = mecha_steeld+	mecha_lv50_diamond;}

            /**
             * Method INT TO TXT (DONE)
             */
            String mecha_fuel_tv_String = null ,	mecha_food_tv_String = null ,	mecha_steel_tv_String = null ,	mecha_alloy_tv_String = null , mecha_fueld_tv_String = null ,	mecha_foodd_tv_String = null ,	mecha_steeld_tv_String = null ,	mecha_alloyd_tv_String = null ,	mecha_diamond_tv_String = null ,	mecha_cc_tv_String = null ,	mecha_ac_tv_String = null ;

            //Fuel
            if (mecha_fuel >=1000 && mecha_fuel <1000000){
                DecimalFormat formatter = new DecimalFormat("###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_fuel_tv_String = formatter.format(mecha_fuel);
            }
            else if (mecha_fuel >=1000000 && mecha_fuel <1000000000){
                DecimalFormat formatter = new DecimalFormat("###,###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_fuel_tv_String = formatter.format(mecha_fuel);
            }
            else if (mecha_fuel >=1000000000){
                DecimalFormat formatter = new DecimalFormat("###,###,###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_fuel_tv_String = formatter.format(mecha_fuel);
            }else { DecimalFormat formatter = new DecimalFormat("#"); formatter.setRoundingMode(RoundingMode.UP); mecha_fuel_tv_String = formatter.format(mecha_fuel);}

            //Food
            if (mecha_food >=1000 && mecha_food <1000000){
                DecimalFormat formatter = new DecimalFormat("###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_food_tv_String = formatter.format(mecha_food);
            }
            else if (mecha_food >=1000000 && mecha_food <1000000000){
                DecimalFormat formatter = new DecimalFormat("###,###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_food_tv_String = formatter.format(mecha_food);
            }
            else if (mecha_food >=1000000000){
                DecimalFormat formatter = new DecimalFormat("###,###,###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_food_tv_String = formatter.format(mecha_food);
            }else { DecimalFormat formatter = new DecimalFormat("#"); formatter.setRoundingMode(RoundingMode.UP); mecha_food_tv_String = formatter.format(mecha_food);}

            //Steel
            if (mecha_steel >=1000 && mecha_steel <1000000){
                DecimalFormat formatter = new DecimalFormat("###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_steel_tv_String = formatter.format(mecha_steel);
            }
            else if (mecha_steel >=1000000 && mecha_steel <1000000000){
                DecimalFormat formatter = new DecimalFormat("###,###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_steel_tv_String = formatter.format(mecha_steel);
            }
            else if (mecha_steel >=1000000000){
                DecimalFormat formatter = new DecimalFormat("###,###,###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_steel_tv_String = formatter.format(mecha_steel);
            }else { DecimalFormat formatter = new DecimalFormat("#"); formatter.setRoundingMode(RoundingMode.UP); mecha_steel_tv_String = formatter.format(mecha_steel);}

            //Alloy
            if (mecha_alloy >=1000 && mecha_alloy <1000000){
                DecimalFormat formatter = new DecimalFormat("###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_alloy_tv_String = formatter.format(mecha_alloy);
            }
            else if (mecha_alloy >=1000000 && mecha_alloy <1000000000){
                DecimalFormat formatter = new DecimalFormat("###,###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_alloy_tv_String = formatter.format(mecha_alloy);
            }
            else if (mecha_alloy >=1000000000){
                DecimalFormat formatter = new DecimalFormat("###,###,###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_alloy_tv_String = formatter.format(mecha_alloy);
            }else { DecimalFormat formatter = new DecimalFormat("#"); formatter.setRoundingMode(RoundingMode.UP); mecha_alloy_tv_String = formatter.format(mecha_alloy);}

            //Diamond
            if (mecha_diamond >=1000 && mecha_diamond <1000000){
                DecimalFormat formatter = new DecimalFormat("###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_diamond_tv_String = formatter.format(mecha_diamond);
            }
            else if (mecha_diamond >=1000000 && mecha_diamond <1000000000){
                DecimalFormat formatter = new DecimalFormat("###,###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_diamond_tv_String = formatter.format(mecha_diamond);
            }
            else if (mecha_diamond >=1000000000){
                DecimalFormat formatter = new DecimalFormat("###,###,###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_diamond_tv_String = formatter.format(mecha_diamond);
            }else { DecimalFormat formatter = new DecimalFormat("#"); formatter.setRoundingMode(RoundingMode.UP); mecha_diamond_tv_String = formatter.format(mecha_diamond);}

            //Construct Core
            if (mecha_cc >=1000 && mecha_cc <1000000){
                DecimalFormat formatter = new DecimalFormat("###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_cc_tv_String = formatter.format(mecha_cc);
            }
            else if (mecha_cc >=1000000 && mecha_cc <1000000000){
                DecimalFormat formatter = new DecimalFormat("###,###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_cc_tv_String = formatter.format(mecha_cc);
            }
            else if (mecha_cc >=1000000000){
                DecimalFormat formatter = new DecimalFormat("###,###,###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_cc_tv_String = formatter.format(mecha_cc);
            }else { DecimalFormat formatter = new DecimalFormat("#"); formatter.setRoundingMode(RoundingMode.UP); mecha_cc_tv_String = formatter.format(mecha_cc);}

            //Advanced Construct Core
            if (mecha_ac >=1000 && mecha_ac <1000000){
                DecimalFormat formatter = new DecimalFormat("###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_ac_tv_String = formatter.format(mecha_ac);
            }
            else if (mecha_ac >=1000000 && mecha_ac <1000000000){
                DecimalFormat formatter = new DecimalFormat("###,###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_ac_tv_String = formatter.format(mecha_ac);
            }
            else if (mecha_ac >=1000000000){
                DecimalFormat formatter = new DecimalFormat("###,###,###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_ac_tv_String = formatter.format(mecha_ac);
            }else { DecimalFormat formatter = new DecimalFormat("#"); formatter.setRoundingMode(RoundingMode.UP); mecha_ac_tv_String = formatter.format(mecha_ac);}

            //Fuel
            if (mecha_fueld >=1000 && mecha_fueld <1000000){
                DecimalFormat formatter = new DecimalFormat("###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_fueld_tv_String = formatter.format(mecha_fueld);
            }
            else if (mecha_fueld >=1000000 && mecha_fueld <1000000000){
                DecimalFormat formatter = new DecimalFormat("###,###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_fueld_tv_String = formatter.format(mecha_fueld);
            }
            else if (mecha_fueld >=1000000000){
                DecimalFormat formatter = new DecimalFormat("###,###,###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_fueld_tv_String = formatter.format(mecha_fueld);
            }else { DecimalFormat formatter = new DecimalFormat("#"); formatter.setRoundingMode(RoundingMode.UP); mecha_fueld_tv_String = formatter.format(mecha_fueld);}

            //Food
            if (mecha_foodd >=1000 && mecha_foodd <1000000){
                DecimalFormat formatter = new DecimalFormat("###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_foodd_tv_String = formatter.format(mecha_foodd);
            }
            else if (mecha_foodd >=1000000 && mecha_food <1000000000){
                DecimalFormat formatter = new DecimalFormat("###,###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_foodd_tv_String = formatter.format(mecha_foodd);
            }
            else if (mecha_foodd >=1000000000){
                DecimalFormat formatter = new DecimalFormat("###,###,###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_foodd_tv_String = formatter.format(mecha_foodd);
            }else { DecimalFormat formatter = new DecimalFormat("#"); formatter.setRoundingMode(RoundingMode.UP); mecha_foodd_tv_String = formatter.format(mecha_foodd);}

            //Steel
            if (mecha_steeld >=1000 && mecha_steeld <1000000){
                DecimalFormat formatter = new DecimalFormat("###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_steeld_tv_String = formatter.format(mecha_steeld);
            }
            else if (mecha_steeld >=1000000 && mecha_steeld <1000000000){
                DecimalFormat formatter = new DecimalFormat("###,###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_steeld_tv_String = formatter.format(mecha_steeld);
            }
            else if (mecha_steeld >=1000000000){
                DecimalFormat formatter = new DecimalFormat("###,###,###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_steeld_tv_String = formatter.format(mecha_steeld);
            }else { DecimalFormat formatter = new DecimalFormat("#"); formatter.setRoundingMode(RoundingMode.UP); mecha_steeld_tv_String = formatter.format(mecha_steeld);}

            //Alloy
            if (mecha_alloyd >=1000 && mecha_alloyd <1000000){
                DecimalFormat formatter = new DecimalFormat("###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_alloyd_tv_String = formatter.format(mecha_alloyd);
            }
            else if (mecha_alloyd >=1000000 && mecha_alloyd <1000000000){
                DecimalFormat formatter = new DecimalFormat("###,###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_alloyd_tv_String = formatter.format(mecha_alloyd);
            }
            else if (mecha_alloyd >=1000000000){
                DecimalFormat formatter = new DecimalFormat("###,###,###,###");
                formatter.setRoundingMode(RoundingMode.UP);
                mecha_alloyd_tv_String = formatter.format(mecha_alloyd);
            }else { DecimalFormat formatter = new DecimalFormat("#"); formatter.setRoundingMode(RoundingMode.UP); mecha_alloyd_tv_String = formatter.format(mecha_alloyd);}


            if (cb_rss.isChecked()){
                mecha_fuel_tv.setVisibility(View.VISIBLE);
                mecha_food_tv.setVisibility(View.VISIBLE);
                mecha_steel_tv.setVisibility(View.VISIBLE);
                mecha_alloy_tv.setVisibility(View.VISIBLE);
                mecha_fueld_tv.setVisibility(View.GONE);
                mecha_foodd_tv.setVisibility(View.GONE);
                mecha_steeld_tv.setVisibility(View.GONE);
                mecha_alloyd_tv.setVisibility(View.GONE);
            }
            if (cb_diam.isChecked()){
                mecha_fuel_tv.setVisibility(View.GONE);
                mecha_food_tv.setVisibility(View.GONE);
                mecha_steel_tv.setVisibility(View.GONE);
                mecha_alloy_tv.setVisibility(View.GONE);
                mecha_fueld_tv.setVisibility(View.VISIBLE);
                mecha_foodd_tv.setVisibility(View.VISIBLE);
                mecha_steeld_tv.setVisibility(View.VISIBLE);
                mecha_alloyd_tv.setVisibility(View.VISIBLE);
            }
            if (cb_rss.isChecked()&&cb_diam.isChecked()){
                mecha_fuel_tv.setVisibility(View.VISIBLE);
                mecha_food_tv.setVisibility(View.VISIBLE);
                mecha_steel_tv.setVisibility(View.VISIBLE);
                mecha_alloy_tv.setVisibility(View.VISIBLE);
                mecha_fueld_tv.setVisibility(View.VISIBLE);
                mecha_foodd_tv.setVisibility(View.VISIBLE);
                mecha_steeld_tv.setVisibility(View.VISIBLE);
                mecha_alloyd_tv.setVisibility(View.VISIBLE);
                }
            mecha_fuel_tv.setText	(prettyCount(mecha_fuel));
            mecha_food_tv.setText	(prettyCount(mecha_food));
            mecha_steel_tv.setText	(prettyCount(mecha_steel));
            mecha_alloy_tv.setText	(prettyCount(mecha_alloy));
            mecha_fueld_tv.setText	(prettyCount(mecha_fueld));
            mecha_foodd_tv.setText	(prettyCount(mecha_foodd));
            mecha_steeld_tv.setText	(prettyCount(mecha_steeld));
            mecha_alloyd_tv.setText	(prettyCount(mecha_alloyd));
            mecha_diamond_tv.setText	(prettyCount(mecha_diamond));
            mecha_cc_tv.setText	(prettyCount(mecha_cc));
            mecha_ac_tv.setText	(prettyCount(mecha_ac));


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
    public String splitA(String string){
        StringBuilder myName = new StringBuilder(string);
        char upper = Character.toUpperCase(string.charAt(0));
        myName.setCharAt(0, upper);
        String me = String.valueOf(myName);
        return me;
    }
}