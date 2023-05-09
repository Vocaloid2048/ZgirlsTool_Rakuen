package voc.net.tools.zgirls_tool.old_ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.R;

public class EXPCActivity extends AppCompatActivity {

    int exp_16 =	200000	;	int exp_26 =	880000	;	int exp_36 =	6850000	;	int exp_46 =	90600000	;
    int exp_17 =	264000	;	int exp_27 =	920000	;	int exp_37 =	8740000	;	int exp_47 =	119000000	;
    int exp_18 =	282000	;	int exp_28 =	1050000	;	int exp_38 =	9830000	;	int exp_48 =	147000000	;
    int exp_19 =	316000	;	int exp_29 =	1130000	;	int exp_39 =	11800000	;	int exp_49 =	222000000	;
    int exp_20 =	360000	;	int exp_30 =	1310000	;	int exp_40 =	16300000	;	int exp_50 =	250000000	;
    int exp_21 =	445000	;	int exp_31 =	1860000	;	int exp_41 =	21820000	;
    int exp_22 =	540000	;	int exp_32 =	2650000	;	int exp_42 =	30300000	;
    int exp_23 =	581000	;	int exp_33 =	2980000	;	int exp_43 =	38800000	;
    int exp_24 =	637000	;	int exp_34 =	3820000	;	int exp_44 =	52400000	;
    int exp_25 =	745000	;	int exp_35 =	4320000	;	int exp_45 =	67500000	;

    EditText now_lv , now_exp , exp1_et, exp2_et, exp3_et, exp4_et, exp5_et, exp6_et, exp7_et, exp8_et  ;
    CheckBox exp_cb ;
    long e1 , e2 , e3 ,e4 ,e5 ,e6 ,e7 ,e8 ,total , now , exp , lvl_up , lvl_target;
    TextView upgrade , exp_tv , exp_total ;
    ProgressBar pb_exp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expc);

        exp1_et = findViewById(R.id.expc_1_et);
        exp2_et = findViewById(R.id.expc_2_et);
        exp3_et = findViewById(R.id.expc_3_et);
        exp4_et = findViewById(R.id.expc_4_et);
        exp5_et = findViewById(R.id.expc_5_et);
        exp6_et = findViewById(R.id.expc_6_et);
        exp7_et = findViewById(R.id.expc_7_et);
        exp8_et = findViewById(R.id.expc_8_et);
        exp_cb = findViewById(R.id.expc_cb);
        exp_cb = findViewById(R.id.expc_cb);
        upgrade = findViewById(R.id.lvl_tv);
        exp_tv = findViewById(R.id.exp_tv);
        pb_exp = findViewById(R.id.pb_exp);
        exp_total = findViewById(R.id.expc_total);

        now_lv = findViewById(R.id.expc_now_et);
        now_exp = findViewById(R.id.expc_aim_et);


        BackgroundReload();
    }
    public void BackgroundReload (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.expc_bg);

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

    public void calculate (View view) {
        e1 = e2 = e3 = e4 = e5 = e6 = e7 = e8 = total = lvl_up = lvl_target =0;
        pb_exp.setIndeterminate(false);

        if(exp1_et.getText().toString().matches("")) 	 {exp1_et.setText	(    "0");}
        if(exp2_et.getText().toString().matches(""))	 {exp2_et.setText	(    "0");}
        if(exp3_et.getText().toString().matches(""))	 {exp3_et.setText	(    "0");}
        if(exp4_et.getText().toString().matches(""))	 {exp4_et.setText	(    "0");}
        if(exp5_et.getText().toString().matches(""))	 {exp5_et.setText	(    "0");}
        if(exp6_et.getText().toString().matches(""))	 {exp6_et.setText	(    "0");}
        if(exp7_et.getText().toString().matches(""))	 {exp7_et.setText	(    "0");}
        if(exp8_et.getText().toString().matches(""))	 {exp8_et.setText	(    "0");}
        if(now_lv.getText().toString().matches(""))	 {now_lv.setText	(    "15");}
        if(now_exp.getText().toString().matches(""))	 {now_exp.setText	(    "0");}


        e1	= Integer.parseInt(exp1_et.getText().toString());
        e2	= Integer.parseInt(exp2_et.getText().toString());
        e3	= Integer.parseInt(exp3_et.getText().toString());
        e4	= Integer.parseInt(exp4_et.getText().toString());
        e5	= Integer.parseInt(exp5_et.getText().toString());
        e6	= Integer.parseInt(exp6_et.getText().toString());
        e7	= Integer.parseInt(exp7_et.getText().toString());
        e8	= Integer.parseInt(exp8_et.getText().toString());
        now	= Integer.parseInt(now_lv.getText().toString());
        exp	= Integer.parseInt(now_exp.getText().toString());

        if (now < 15) {
            Log.i("ERROR", "holy");
            Toast.makeText(this, "[ERROR] Now Enable's level Shouldn't smaller than level 15", Toast.LENGTH_SHORT).show();
        }
        if (now > 49) {
            Log.i("ERROR", "holy");
            Toast.makeText(this, "[ERROR] Now Enable's level Shouldn't bigger than level 49", Toast.LENGTH_SHORT).show();
        }
        else {

            e1 =	e1*100;
            e2 =	e2*1000;
            e3 =	e3*5000;
            e4 =	e4*10000;
            e5 =	e5*20000;
            e6 =	e6*50000;
            e7 =	e7*80000;
            e8 =	e8*100000;



            total = e1 + e2 + e3 +e4 +e5 +e6 +e7 +e8 ;
            if (exp_cb.isChecked()){total = (int) (total*1.2);
            }

            if (now==15){
                if (total-exp_16	>0){total =	total-exp_16; lvl_up = 	lvl_up+1;}
                if (total-exp_17	>0){total =	total-exp_17; lvl_up =	lvl_up+1;}
                if (total-exp_18	>0){total =	total-exp_18; lvl_up =	lvl_up+1;}
                if (total-exp_19	>0){total =	total-exp_19; lvl_up =	lvl_up+1;}
                if (total-exp_20	>0){total =	total-exp_20; lvl_up =	lvl_up+1;}
                if (total-exp_21	>0){total =	total-exp_21; lvl_up =	lvl_up+1;}
                if (total-exp_22	>0){total =	total-exp_22; lvl_up =	lvl_up+1;}
                if (total-exp_23	>0){total =	total-exp_23; lvl_up =	lvl_up+1;}
                if (total-exp_24	>0){total =	total-exp_24; lvl_up =	lvl_up+1;}
                if (total-exp_25	>0){total =	total-exp_25; lvl_up =	lvl_up+1;}
                if (total-exp_26	>0){total =	total-exp_26; lvl_up =	lvl_up+1;}
                if (total-exp_27	>0){total =	total-exp_27; lvl_up =	lvl_up+1;}
                if (total-exp_28	>0){total =	total-exp_28; lvl_up =	lvl_up+1;}
                if (total-exp_29	>0){total =	total-exp_29; lvl_up =	lvl_up+1;}
                if (total-exp_30	>0){total =	total-exp_30; lvl_up =	lvl_up+1;}
                if (total-exp_31	>0){total =	total-exp_31; lvl_up =	lvl_up+1;}
                if (total-exp_32	>0){total =	total-exp_32; lvl_up =	lvl_up+1;}
                if (total-exp_33	>0){total =	total-exp_33; lvl_up =	lvl_up+1;}
                if (total-exp_34	>0){total =	total-exp_34; lvl_up =	lvl_up+1;}
                if (total-exp_35	>0){total =	total-exp_35; lvl_up =	lvl_up+1;}
                if (total-exp_36	>0){total =	total-exp_36; lvl_up =	lvl_up+1;}
                if (total-exp_37	>0){total =	total-exp_37; lvl_up =	lvl_up+1;}
                if (total-exp_38	>0){total =	total-exp_38; lvl_up =	lvl_up+1;}
                if (total-exp_39	>0){total =	total-exp_39; lvl_up =	lvl_up+1;}
                if (total-exp_40	>0){total =	total-exp_40; lvl_up =	lvl_up+1;}
                if (total-exp_41	>0){total =	total-exp_41; lvl_up =	lvl_up+1;}
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==16){
                if (total-exp_17	>0){total =	total-exp_17; lvl_up =	lvl_up+1;}
                if (total-exp_18	>0){total =	total-exp_18; lvl_up =	lvl_up+1;}
                if (total-exp_19	>0){total =	total-exp_19; lvl_up =	lvl_up+1;}
                if (total-exp_20	>0){total =	total-exp_20; lvl_up =	lvl_up+1;}
                if (total-exp_21	>0){total =	total-exp_21; lvl_up =	lvl_up+1;}
                if (total-exp_22	>0){total =	total-exp_22; lvl_up =	lvl_up+1;}
                if (total-exp_23	>0){total =	total-exp_23; lvl_up =	lvl_up+1;}
                if (total-exp_24	>0){total =	total-exp_24; lvl_up =	lvl_up+1;}
                if (total-exp_25	>0){total =	total-exp_25; lvl_up =	lvl_up+1;}
                if (total-exp_26	>0){total =	total-exp_26; lvl_up =	lvl_up+1;}
                if (total-exp_27	>0){total =	total-exp_27; lvl_up =	lvl_up+1;}
                if (total-exp_28	>0){total =	total-exp_28; lvl_up =	lvl_up+1;}
                if (total-exp_29	>0){total =	total-exp_29; lvl_up =	lvl_up+1;}
                if (total-exp_30	>0){total =	total-exp_30; lvl_up =	lvl_up+1;}
                if (total-exp_31	>0){total =	total-exp_31; lvl_up =	lvl_up+1;}
                if (total-exp_32	>0){total =	total-exp_32; lvl_up =	lvl_up+1;}
                if (total-exp_33	>0){total =	total-exp_33; lvl_up =	lvl_up+1;}
                if (total-exp_34	>0){total =	total-exp_34; lvl_up =	lvl_up+1;}
                if (total-exp_35	>0){total =	total-exp_35; lvl_up =	lvl_up+1;}
                if (total-exp_36	>0){total =	total-exp_36; lvl_up =	lvl_up+1;}
                if (total-exp_37	>0){total =	total-exp_37; lvl_up =	lvl_up+1;}
                if (total-exp_38	>0){total =	total-exp_38; lvl_up =	lvl_up+1;}
                if (total-exp_39	>0){total =	total-exp_39; lvl_up =	lvl_up+1;}
                if (total-exp_40	>0){total =	total-exp_40; lvl_up =	lvl_up+1;}
                if (total-exp_41	>0){total =	total-exp_41; lvl_up =	lvl_up+1;}
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==17){
                if (total-exp_18	>0){total =	total-exp_18; lvl_up =	lvl_up+1;}
                if (total-exp_19	>0){total =	total-exp_19; lvl_up =	lvl_up+1;}
                if (total-exp_20	>0){total =	total-exp_20; lvl_up =	lvl_up+1;}
                if (total-exp_21	>0){total =	total-exp_21; lvl_up =	lvl_up+1;}
                if (total-exp_22	>0){total =	total-exp_22; lvl_up =	lvl_up+1;}
                if (total-exp_23	>0){total =	total-exp_23; lvl_up =	lvl_up+1;}
                if (total-exp_24	>0){total =	total-exp_24; lvl_up =	lvl_up+1;}
                if (total-exp_25	>0){total =	total-exp_25; lvl_up =	lvl_up+1;}
                if (total-exp_26	>0){total =	total-exp_26; lvl_up =	lvl_up+1;}
                if (total-exp_27	>0){total =	total-exp_27; lvl_up =	lvl_up+1;}
                if (total-exp_28	>0){total =	total-exp_28; lvl_up =	lvl_up+1;}
                if (total-exp_29	>0){total =	total-exp_29; lvl_up =	lvl_up+1;}
                if (total-exp_30	>0){total =	total-exp_30; lvl_up =	lvl_up+1;}
                if (total-exp_31	>0){total =	total-exp_31; lvl_up =	lvl_up+1;}
                if (total-exp_32	>0){total =	total-exp_32; lvl_up =	lvl_up+1;}
                if (total-exp_33	>0){total =	total-exp_33; lvl_up =	lvl_up+1;}
                if (total-exp_34	>0){total =	total-exp_34; lvl_up =	lvl_up+1;}
                if (total-exp_35	>0){total =	total-exp_35; lvl_up =	lvl_up+1;}
                if (total-exp_36	>0){total =	total-exp_36; lvl_up =	lvl_up+1;}
                if (total-exp_37	>0){total =	total-exp_37; lvl_up =	lvl_up+1;}
                if (total-exp_38	>0){total =	total-exp_38; lvl_up =	lvl_up+1;}
                if (total-exp_39	>0){total =	total-exp_39; lvl_up =	lvl_up+1;}
                if (total-exp_40	>0){total =	total-exp_40; lvl_up =	lvl_up+1;}
                if (total-exp_41	>0){total =	total-exp_41; lvl_up =	lvl_up+1;}
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==18){
                if (total-exp_19	>0){total =	total-exp_19; lvl_up =	lvl_up+1;}
                if (total-exp_20	>0){total =	total-exp_20; lvl_up =	lvl_up+1;}
                if (total-exp_21	>0){total =	total-exp_21; lvl_up =	lvl_up+1;}
                if (total-exp_22	>0){total =	total-exp_22; lvl_up =	lvl_up+1;}
                if (total-exp_23	>0){total =	total-exp_23; lvl_up =	lvl_up+1;}
                if (total-exp_24	>0){total =	total-exp_24; lvl_up =	lvl_up+1;}
                if (total-exp_25	>0){total =	total-exp_25; lvl_up =	lvl_up+1;}
                if (total-exp_26	>0){total =	total-exp_26; lvl_up =	lvl_up+1;}
                if (total-exp_27	>0){total =	total-exp_27; lvl_up =	lvl_up+1;}
                if (total-exp_28	>0){total =	total-exp_28; lvl_up =	lvl_up+1;}
                if (total-exp_29	>0){total =	total-exp_29; lvl_up =	lvl_up+1;}
                if (total-exp_30	>0){total =	total-exp_30; lvl_up =	lvl_up+1;}
                if (total-exp_31	>0){total =	total-exp_31; lvl_up =	lvl_up+1;}
                if (total-exp_32	>0){total =	total-exp_32; lvl_up =	lvl_up+1;}
                if (total-exp_33	>0){total =	total-exp_33; lvl_up =	lvl_up+1;}
                if (total-exp_34	>0){total =	total-exp_34; lvl_up =	lvl_up+1;}
                if (total-exp_35	>0){total =	total-exp_35; lvl_up =	lvl_up+1;}
                if (total-exp_36	>0){total =	total-exp_36; lvl_up =	lvl_up+1;}
                if (total-exp_37	>0){total =	total-exp_37; lvl_up =	lvl_up+1;}
                if (total-exp_38	>0){total =	total-exp_38; lvl_up =	lvl_up+1;}
                if (total-exp_39	>0){total =	total-exp_39; lvl_up =	lvl_up+1;}
                if (total-exp_40	>0){total =	total-exp_40; lvl_up =	lvl_up+1;}
                if (total-exp_41	>0){total =	total-exp_41; lvl_up =	lvl_up+1;}
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==19){
                if (total-exp_20	>0){total =	total-exp_20; lvl_up =	lvl_up+1;}
                if (total-exp_21	>0){total =	total-exp_21; lvl_up =	lvl_up+1;}
                if (total-exp_22	>0){total =	total-exp_22; lvl_up =	lvl_up+1;}
                if (total-exp_23	>0){total =	total-exp_23; lvl_up =	lvl_up+1;}
                if (total-exp_24	>0){total =	total-exp_24; lvl_up =	lvl_up+1;}
                if (total-exp_25	>0){total =	total-exp_25; lvl_up =	lvl_up+1;}
                if (total-exp_26	>0){total =	total-exp_26; lvl_up =	lvl_up+1;}
                if (total-exp_27	>0){total =	total-exp_27; lvl_up =	lvl_up+1;}
                if (total-exp_28	>0){total =	total-exp_28; lvl_up =	lvl_up+1;}
                if (total-exp_29	>0){total =	total-exp_29; lvl_up =	lvl_up+1;}
                if (total-exp_30	>0){total =	total-exp_30; lvl_up =	lvl_up+1;}
                if (total-exp_31	>0){total =	total-exp_31; lvl_up =	lvl_up+1;}
                if (total-exp_32	>0){total =	total-exp_32; lvl_up =	lvl_up+1;}
                if (total-exp_33	>0){total =	total-exp_33; lvl_up =	lvl_up+1;}
                if (total-exp_34	>0){total =	total-exp_34; lvl_up =	lvl_up+1;}
                if (total-exp_35	>0){total =	total-exp_35; lvl_up =	lvl_up+1;}
                if (total-exp_36	>0){total =	total-exp_36; lvl_up =	lvl_up+1;}
                if (total-exp_37	>0){total =	total-exp_37; lvl_up =	lvl_up+1;}
                if (total-exp_38	>0){total =	total-exp_38; lvl_up =	lvl_up+1;}
                if (total-exp_39	>0){total =	total-exp_39; lvl_up =	lvl_up+1;}
                if (total-exp_40	>0){total =	total-exp_40; lvl_up =	lvl_up+1;}
                if (total-exp_41	>0){total =	total-exp_41; lvl_up =	lvl_up+1;}
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==20){
                if (total-exp_21	>0){total =	total-exp_21; lvl_up =	lvl_up+1;}
                if (total-exp_22	>0){total =	total-exp_22; lvl_up =	lvl_up+1;}
                if (total-exp_23	>0){total =	total-exp_23; lvl_up =	lvl_up+1;}
                if (total-exp_24	>0){total =	total-exp_24; lvl_up =	lvl_up+1;}
                if (total-exp_25	>0){total =	total-exp_25; lvl_up =	lvl_up+1;}
                if (total-exp_26	>0){total =	total-exp_26; lvl_up =	lvl_up+1;}
                if (total-exp_27	>0){total =	total-exp_27; lvl_up =	lvl_up+1;}
                if (total-exp_28	>0){total =	total-exp_28; lvl_up =	lvl_up+1;}
                if (total-exp_29	>0){total =	total-exp_29; lvl_up =	lvl_up+1;}
                if (total-exp_30	>0){total =	total-exp_30; lvl_up =	lvl_up+1;}
                if (total-exp_31	>0){total =	total-exp_31; lvl_up =	lvl_up+1;}
                if (total-exp_32	>0){total =	total-exp_32; lvl_up =	lvl_up+1;}
                if (total-exp_33	>0){total =	total-exp_33; lvl_up =	lvl_up+1;}
                if (total-exp_34	>0){total =	total-exp_34; lvl_up =	lvl_up+1;}
                if (total-exp_35	>0){total =	total-exp_35; lvl_up =	lvl_up+1;}
                if (total-exp_36	>0){total =	total-exp_36; lvl_up =	lvl_up+1;}
                if (total-exp_37	>0){total =	total-exp_37; lvl_up =	lvl_up+1;}
                if (total-exp_38	>0){total =	total-exp_38; lvl_up =	lvl_up+1;}
                if (total-exp_39	>0){total =	total-exp_39; lvl_up =	lvl_up+1;}
                if (total-exp_40	>0){total =	total-exp_40; lvl_up =	lvl_up+1;}
                if (total-exp_41	>0){total =	total-exp_41; lvl_up =	lvl_up+1;}
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==21){
                if (total-exp_22	>0){total =	total-exp_22; lvl_up =	lvl_up+1;}
                if (total-exp_23	>0){total =	total-exp_23; lvl_up =	lvl_up+1;}
                if (total-exp_24	>0){total =	total-exp_24; lvl_up =	lvl_up+1;}
                if (total-exp_25	>0){total =	total-exp_25; lvl_up =	lvl_up+1;}
                if (total-exp_26	>0){total =	total-exp_26; lvl_up =	lvl_up+1;}
                if (total-exp_27	>0){total =	total-exp_27; lvl_up =	lvl_up+1;}
                if (total-exp_28	>0){total =	total-exp_28; lvl_up =	lvl_up+1;}
                if (total-exp_29	>0){total =	total-exp_29; lvl_up =	lvl_up+1;}
                if (total-exp_30	>0){total =	total-exp_30; lvl_up =	lvl_up+1;}
                if (total-exp_31	>0){total =	total-exp_31; lvl_up =	lvl_up+1;}
                if (total-exp_32	>0){total =	total-exp_32; lvl_up =	lvl_up+1;}
                if (total-exp_33	>0){total =	total-exp_33; lvl_up =	lvl_up+1;}
                if (total-exp_34	>0){total =	total-exp_34; lvl_up =	lvl_up+1;}
                if (total-exp_35	>0){total =	total-exp_35; lvl_up =	lvl_up+1;}
                if (total-exp_36	>0){total =	total-exp_36; lvl_up =	lvl_up+1;}
                if (total-exp_37	>0){total =	total-exp_37; lvl_up =	lvl_up+1;}
                if (total-exp_38	>0){total =	total-exp_38; lvl_up =	lvl_up+1;}
                if (total-exp_39	>0){total =	total-exp_39; lvl_up =	lvl_up+1;}
                if (total-exp_40	>0){total =	total-exp_40; lvl_up =	lvl_up+1;}
                if (total-exp_41	>0){total =	total-exp_41; lvl_up =	lvl_up+1;}
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==22){
                if (total-exp_23	>0){total =	total-exp_23; lvl_up =	lvl_up+1;}
                if (total-exp_24	>0){total =	total-exp_24; lvl_up =	lvl_up+1;}
                if (total-exp_25	>0){total =	total-exp_25; lvl_up =	lvl_up+1;}
                if (total-exp_26	>0){total =	total-exp_26; lvl_up =	lvl_up+1;}
                if (total-exp_27	>0){total =	total-exp_27; lvl_up =	lvl_up+1;}
                if (total-exp_28	>0){total =	total-exp_28; lvl_up =	lvl_up+1;}
                if (total-exp_29	>0){total =	total-exp_29; lvl_up =	lvl_up+1;}
                if (total-exp_30	>0){total =	total-exp_30; lvl_up =	lvl_up+1;}
                if (total-exp_31	>0){total =	total-exp_31; lvl_up =	lvl_up+1;}
                if (total-exp_32	>0){total =	total-exp_32; lvl_up =	lvl_up+1;}
                if (total-exp_33	>0){total =	total-exp_33; lvl_up =	lvl_up+1;}
                if (total-exp_34	>0){total =	total-exp_34; lvl_up =	lvl_up+1;}
                if (total-exp_35	>0){total =	total-exp_35; lvl_up =	lvl_up+1;}
                if (total-exp_36	>0){total =	total-exp_36; lvl_up =	lvl_up+1;}
                if (total-exp_37	>0){total =	total-exp_37; lvl_up =	lvl_up+1;}
                if (total-exp_38	>0){total =	total-exp_38; lvl_up =	lvl_up+1;}
                if (total-exp_39	>0){total =	total-exp_39; lvl_up =	lvl_up+1;}
                if (total-exp_40	>0){total =	total-exp_40; lvl_up =	lvl_up+1;}
                if (total-exp_41	>0){total =	total-exp_41; lvl_up =	lvl_up+1;}
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==23){
                if (total-exp_24	>0){total =	total-exp_24; lvl_up =	lvl_up+1;}
                if (total-exp_25	>0){total =	total-exp_25; lvl_up =	lvl_up+1;}
                if (total-exp_26	>0){total =	total-exp_26; lvl_up =	lvl_up+1;}
                if (total-exp_27	>0){total =	total-exp_27; lvl_up =	lvl_up+1;}
                if (total-exp_28	>0){total =	total-exp_28; lvl_up =	lvl_up+1;}
                if (total-exp_29	>0){total =	total-exp_29; lvl_up =	lvl_up+1;}
                if (total-exp_30	>0){total =	total-exp_30; lvl_up =	lvl_up+1;}
                if (total-exp_31	>0){total =	total-exp_31; lvl_up =	lvl_up+1;}
                if (total-exp_32	>0){total =	total-exp_32; lvl_up =	lvl_up+1;}
                if (total-exp_33	>0){total =	total-exp_33; lvl_up =	lvl_up+1;}
                if (total-exp_34	>0){total =	total-exp_34; lvl_up =	lvl_up+1;}
                if (total-exp_35	>0){total =	total-exp_35; lvl_up =	lvl_up+1;}
                if (total-exp_36	>0){total =	total-exp_36; lvl_up =	lvl_up+1;}
                if (total-exp_37	>0){total =	total-exp_37; lvl_up =	lvl_up+1;}
                if (total-exp_38	>0){total =	total-exp_38; lvl_up =	lvl_up+1;}
                if (total-exp_39	>0){total =	total-exp_39; lvl_up =	lvl_up+1;}
                if (total-exp_40	>0){total =	total-exp_40; lvl_up =	lvl_up+1;}
                if (total-exp_41	>0){total =	total-exp_41; lvl_up =	lvl_up+1;}
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==24){
                if (total-exp_25	>0){total =	total-exp_25; lvl_up =	lvl_up+1;}
                if (total-exp_26	>0){total =	total-exp_26; lvl_up =	lvl_up+1;}
                if (total-exp_27	>0){total =	total-exp_27; lvl_up =	lvl_up+1;}
                if (total-exp_28	>0){total =	total-exp_28; lvl_up =	lvl_up+1;}
                if (total-exp_29	>0){total =	total-exp_29; lvl_up =	lvl_up+1;}
                if (total-exp_30	>0){total =	total-exp_30; lvl_up =	lvl_up+1;}
                if (total-exp_31	>0){total =	total-exp_31; lvl_up =	lvl_up+1;}
                if (total-exp_32	>0){total =	total-exp_32; lvl_up =	lvl_up+1;}
                if (total-exp_33	>0){total =	total-exp_33; lvl_up =	lvl_up+1;}
                if (total-exp_34	>0){total =	total-exp_34; lvl_up =	lvl_up+1;}
                if (total-exp_35	>0){total =	total-exp_35; lvl_up =	lvl_up+1;}
                if (total-exp_36	>0){total =	total-exp_36; lvl_up =	lvl_up+1;}
                if (total-exp_37	>0){total =	total-exp_37; lvl_up =	lvl_up+1;}
                if (total-exp_38	>0){total =	total-exp_38; lvl_up =	lvl_up+1;}
                if (total-exp_39	>0){total =	total-exp_39; lvl_up =	lvl_up+1;}
                if (total-exp_40	>0){total =	total-exp_40; lvl_up =	lvl_up+1;}
                if (total-exp_41	>0){total =	total-exp_41; lvl_up =	lvl_up+1;}
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==25){
                if (total-exp_26	>0){total =	total-exp_26; lvl_up =	lvl_up+1;}
                if (total-exp_27	>0){total =	total-exp_27; lvl_up =	lvl_up+1;}
                if (total-exp_28	>0){total =	total-exp_28; lvl_up =	lvl_up+1;}
                if (total-exp_29	>0){total =	total-exp_29; lvl_up =	lvl_up+1;}
                if (total-exp_30	>0){total =	total-exp_30; lvl_up =	lvl_up+1;}
                if (total-exp_31	>0){total =	total-exp_31; lvl_up =	lvl_up+1;}
                if (total-exp_32	>0){total =	total-exp_32; lvl_up =	lvl_up+1;}
                if (total-exp_33	>0){total =	total-exp_33; lvl_up =	lvl_up+1;}
                if (total-exp_34	>0){total =	total-exp_34; lvl_up =	lvl_up+1;}
                if (total-exp_35	>0){total =	total-exp_35; lvl_up =	lvl_up+1;}
                if (total-exp_36	>0){total =	total-exp_36; lvl_up =	lvl_up+1;}
                if (total-exp_37	>0){total =	total-exp_37; lvl_up =	lvl_up+1;}
                if (total-exp_38	>0){total =	total-exp_38; lvl_up =	lvl_up+1;}
                if (total-exp_39	>0){total =	total-exp_39; lvl_up =	lvl_up+1;}
                if (total-exp_40	>0){total =	total-exp_40; lvl_up =	lvl_up+1;}
                if (total-exp_41	>0){total =	total-exp_41; lvl_up =	lvl_up+1;}
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==26){
                if (total-exp_27	>0){total =	total-exp_27; lvl_up =	lvl_up+1;}
                if (total-exp_28	>0){total =	total-exp_28; lvl_up =	lvl_up+1;}
                if (total-exp_29	>0){total =	total-exp_29; lvl_up =	lvl_up+1;}
                if (total-exp_30	>0){total =	total-exp_30; lvl_up =	lvl_up+1;}
                if (total-exp_31	>0){total =	total-exp_31; lvl_up =	lvl_up+1;}
                if (total-exp_32	>0){total =	total-exp_32; lvl_up =	lvl_up+1;}
                if (total-exp_33	>0){total =	total-exp_33; lvl_up =	lvl_up+1;}
                if (total-exp_34	>0){total =	total-exp_34; lvl_up =	lvl_up+1;}
                if (total-exp_35	>0){total =	total-exp_35; lvl_up =	lvl_up+1;}
                if (total-exp_36	>0){total =	total-exp_36; lvl_up =	lvl_up+1;}
                if (total-exp_37	>0){total =	total-exp_37; lvl_up =	lvl_up+1;}
                if (total-exp_38	>0){total =	total-exp_38; lvl_up =	lvl_up+1;}
                if (total-exp_39	>0){total =	total-exp_39; lvl_up =	lvl_up+1;}
                if (total-exp_40	>0){total =	total-exp_40; lvl_up =	lvl_up+1;}
                if (total-exp_41	>0){total =	total-exp_41; lvl_up =	lvl_up+1;}
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==27){
                if (total-exp_28	>0){total =	total-exp_28; lvl_up =	lvl_up+1;}
                if (total-exp_29	>0){total =	total-exp_29; lvl_up =	lvl_up+1;}
                if (total-exp_30	>0){total =	total-exp_30; lvl_up =	lvl_up+1;}
                if (total-exp_31	>0){total =	total-exp_31; lvl_up =	lvl_up+1;}
                if (total-exp_32	>0){total =	total-exp_32; lvl_up =	lvl_up+1;}
                if (total-exp_33	>0){total =	total-exp_33; lvl_up =	lvl_up+1;}
                if (total-exp_34	>0){total =	total-exp_34; lvl_up =	lvl_up+1;}
                if (total-exp_35	>0){total =	total-exp_35; lvl_up =	lvl_up+1;}
                if (total-exp_36	>0){total =	total-exp_36; lvl_up =	lvl_up+1;}
                if (total-exp_37	>0){total =	total-exp_37; lvl_up =	lvl_up+1;}
                if (total-exp_38	>0){total =	total-exp_38; lvl_up =	lvl_up+1;}
                if (total-exp_39	>0){total =	total-exp_39; lvl_up =	lvl_up+1;}
                if (total-exp_40	>0){total =	total-exp_40; lvl_up =	lvl_up+1;}
                if (total-exp_41	>0){total =	total-exp_41; lvl_up =	lvl_up+1;}
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==28){
                if (total-exp_29	>0){total =	total-exp_29; lvl_up =	lvl_up+1;}
                if (total-exp_30	>0){total =	total-exp_30; lvl_up =	lvl_up+1;}
                if (total-exp_31	>0){total =	total-exp_31; lvl_up =	lvl_up+1;}
                if (total-exp_32	>0){total =	total-exp_32; lvl_up =	lvl_up+1;}
                if (total-exp_33	>0){total =	total-exp_33; lvl_up =	lvl_up+1;}
                if (total-exp_34	>0){total =	total-exp_34; lvl_up =	lvl_up+1;}
                if (total-exp_35	>0){total =	total-exp_35; lvl_up =	lvl_up+1;}
                if (total-exp_36	>0){total =	total-exp_36; lvl_up =	lvl_up+1;}
                if (total-exp_37	>0){total =	total-exp_37; lvl_up =	lvl_up+1;}
                if (total-exp_38	>0){total =	total-exp_38; lvl_up =	lvl_up+1;}
                if (total-exp_39	>0){total =	total-exp_39; lvl_up =	lvl_up+1;}
                if (total-exp_40	>0){total =	total-exp_40; lvl_up =	lvl_up+1;}
                if (total-exp_41	>0){total =	total-exp_41; lvl_up =	lvl_up+1;}
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==29){
                if (total-exp_30	>0){total =	total-exp_30; lvl_up =	lvl_up+1;}
                if (total-exp_31	>0){total =	total-exp_31; lvl_up =	lvl_up+1;}
                if (total-exp_32	>0){total =	total-exp_32; lvl_up =	lvl_up+1;}
                if (total-exp_33	>0){total =	total-exp_33; lvl_up =	lvl_up+1;}
                if (total-exp_34	>0){total =	total-exp_34; lvl_up =	lvl_up+1;}
                if (total-exp_35	>0){total =	total-exp_35; lvl_up =	lvl_up+1;}
                if (total-exp_36	>0){total =	total-exp_36; lvl_up =	lvl_up+1;}
                if (total-exp_37	>0){total =	total-exp_37; lvl_up =	lvl_up+1;}
                if (total-exp_38	>0){total =	total-exp_38; lvl_up =	lvl_up+1;}
                if (total-exp_39	>0){total =	total-exp_39; lvl_up =	lvl_up+1;}
                if (total-exp_40	>0){total =	total-exp_40; lvl_up =	lvl_up+1;}
                if (total-exp_41	>0){total =	total-exp_41; lvl_up =	lvl_up+1;}
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==30){
                if (total-exp_31	>0){total =	total-exp_31; lvl_up =	lvl_up+1;}
                if (total-exp_32	>0){total =	total-exp_32; lvl_up =	lvl_up+1;}
                if (total-exp_33	>0){total =	total-exp_33; lvl_up =	lvl_up+1;}
                if (total-exp_34	>0){total =	total-exp_34; lvl_up =	lvl_up+1;}
                if (total-exp_35	>0){total =	total-exp_35; lvl_up =	lvl_up+1;}
                if (total-exp_36	>0){total =	total-exp_36; lvl_up =	lvl_up+1;}
                if (total-exp_37	>0){total =	total-exp_37; lvl_up =	lvl_up+1;}
                if (total-exp_38	>0){total =	total-exp_38; lvl_up =	lvl_up+1;}
                if (total-exp_39	>0){total =	total-exp_39; lvl_up =	lvl_up+1;}
                if (total-exp_40	>0){total =	total-exp_40; lvl_up =	lvl_up+1;}
                if (total-exp_41	>0){total =	total-exp_41; lvl_up =	lvl_up+1;}
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==31){
                if (total-exp_32	>0){total =	total-exp_32; lvl_up =	lvl_up+1;}
                if (total-exp_33	>0){total =	total-exp_33; lvl_up =	lvl_up+1;}
                if (total-exp_34	>0){total =	total-exp_34; lvl_up =	lvl_up+1;}
                if (total-exp_35	>0){total =	total-exp_35; lvl_up =	lvl_up+1;}
                if (total-exp_36	>0){total =	total-exp_36; lvl_up =	lvl_up+1;}
                if (total-exp_37	>0){total =	total-exp_37; lvl_up =	lvl_up+1;}
                if (total-exp_38	>0){total =	total-exp_38; lvl_up =	lvl_up+1;}
                if (total-exp_39	>0){total =	total-exp_39; lvl_up =	lvl_up+1;}
                if (total-exp_40	>0){total =	total-exp_40; lvl_up =	lvl_up+1;}
                if (total-exp_41	>0){total =	total-exp_41; lvl_up =	lvl_up+1;}
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==32){
                if (total-exp_33	>0){total =	total-exp_33; lvl_up =	lvl_up+1;}
                if (total-exp_34	>0){total =	total-exp_34; lvl_up =	lvl_up+1;}
                if (total-exp_35	>0){total =	total-exp_35; lvl_up =	lvl_up+1;}
                if (total-exp_36	>0){total =	total-exp_36; lvl_up =	lvl_up+1;}
                if (total-exp_37	>0){total =	total-exp_37; lvl_up =	lvl_up+1;}
                if (total-exp_38	>0){total =	total-exp_38; lvl_up =	lvl_up+1;}
                if (total-exp_39	>0){total =	total-exp_39; lvl_up =	lvl_up+1;}
                if (total-exp_40	>0){total =	total-exp_40; lvl_up =	lvl_up+1;}
                if (total-exp_41	>0){total =	total-exp_41; lvl_up =	lvl_up+1;}
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==33){
                if (total-exp_34	>0){total =	total-exp_34; lvl_up =	lvl_up+1;}
                if (total-exp_35	>0){total =	total-exp_35; lvl_up =	lvl_up+1;}
                if (total-exp_36	>0){total =	total-exp_36; lvl_up =	lvl_up+1;}
                if (total-exp_37	>0){total =	total-exp_37; lvl_up =	lvl_up+1;}
                if (total-exp_38	>0){total =	total-exp_38; lvl_up =	lvl_up+1;}
                if (total-exp_39	>0){total =	total-exp_39; lvl_up =	lvl_up+1;}
                if (total-exp_40	>0){total =	total-exp_40; lvl_up =	lvl_up+1;}
                if (total-exp_41	>0){total =	total-exp_41; lvl_up =	lvl_up+1;}
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==34){
                if (total-exp_35	>0){total =	total-exp_35; lvl_up =	lvl_up+1;}
                if (total-exp_36	>0){total =	total-exp_36; lvl_up =	lvl_up+1;}
                if (total-exp_37	>0){total =	total-exp_37; lvl_up =	lvl_up+1;}
                if (total-exp_38	>0){total =	total-exp_38; lvl_up =	lvl_up+1;}
                if (total-exp_39	>0){total =	total-exp_39; lvl_up =	lvl_up+1;}
                if (total-exp_40	>0){total =	total-exp_40; lvl_up =	lvl_up+1;}
                if (total-exp_41	>0){total =	total-exp_41; lvl_up =	lvl_up+1;}
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==35){
                if (total-exp_36	>0){total =	total-exp_36; lvl_up =	lvl_up+1;}
                if (total-exp_37	>0){total =	total-exp_37; lvl_up =	lvl_up+1;}
                if (total-exp_38	>0){total =	total-exp_38; lvl_up =	lvl_up+1;}
                if (total-exp_39	>0){total =	total-exp_39; lvl_up =	lvl_up+1;}
                if (total-exp_40	>0){total =	total-exp_40; lvl_up =	lvl_up+1;}
                if (total-exp_41	>0){total =	total-exp_41; lvl_up =	lvl_up+1;}
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==36){
                if (total-exp_37	>0){total =	total-exp_37; lvl_up =	lvl_up+1;}
                if (total-exp_38	>0){total =	total-exp_38; lvl_up =	lvl_up+1;}
                if (total-exp_39	>0){total =	total-exp_39; lvl_up =	lvl_up+1;}
                if (total-exp_40	>0){total =	total-exp_40; lvl_up =	lvl_up+1;}
                if (total-exp_41	>0){total =	total-exp_41; lvl_up =	lvl_up+1;}
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==37){
                if (total-exp_38	>0){total =	total-exp_38; lvl_up =	lvl_up+1;}
                if (total-exp_39	>0){total =	total-exp_39; lvl_up =	lvl_up+1;}
                if (total-exp_40	>0){total =	total-exp_40; lvl_up =	lvl_up+1;}
                if (total-exp_41	>0){total =	total-exp_41; lvl_up =	lvl_up+1;}
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==38){
                if (total-exp_39	>0){total =	total-exp_39; lvl_up =	lvl_up+1;}
                if (total-exp_40	>0){total =	total-exp_40; lvl_up =	lvl_up+1;}
                if (total-exp_41	>0){total =	total-exp_41; lvl_up =	lvl_up+1;}
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==39){
                if (total-exp_40	>0){total =	total-exp_40; lvl_up =	lvl_up+1;}
                if (total-exp_41	>0){total =	total-exp_41; lvl_up =	lvl_up+1;}
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==40){
                if (total-exp_41	>0){total =	total-exp_41; lvl_up =	lvl_up+1;}
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==41){
                if (total-exp_42	>0){total =	total-exp_42; lvl_up =	lvl_up+1;}
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==42){
                if (total-exp_43	>0){total =	total-exp_43; lvl_up =	lvl_up+1;}
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==43){
                if (total-exp_44	>0){total =	total-exp_44; lvl_up =	lvl_up+1;}
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==44){
                if (total-exp_45	>0){total =	total-exp_45; lvl_up =	lvl_up+1;}
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==45){
                if (total-exp_46	>0){total =	total-exp_46; lvl_up =	lvl_up+1;}
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==46){
                if (total-exp_47	>0){total =	total-exp_47; lvl_up =	lvl_up+1;}
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==47){
                if (total-exp_48	>0){total =	total-exp_48; lvl_up =	lvl_up+1;}
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==48){
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }
            if (now==49){
                if (total-exp_49	>0){total =	total-exp_49; lvl_up =	lvl_up+1;}if (total-exp_50	>0){total =	total-exp_50; lvl_up =	lvl_up+1;}
            }

            if (lvl_up+now == 15)	{lvl_target = exp_16;}
            if (lvl_up+now == 16)	{lvl_target = exp_17;}
            if (lvl_up+now == 17)	{lvl_target = exp_18;}
            if (lvl_up+now == 18)	{lvl_target = exp_19;}
            if (lvl_up+now == 19)	{lvl_target = exp_20;}
            if (lvl_up+now == 20)	{lvl_target = exp_21;}
            if (lvl_up+now == 21)	{lvl_target = exp_22;}
            if (lvl_up+now == 22)	{lvl_target = exp_23;}
            if (lvl_up+now == 23)	{lvl_target = exp_24;}
            if (lvl_up+now == 24)	{lvl_target = exp_25;}
            if (lvl_up+now == 25)	{lvl_target = exp_26;}
            if (lvl_up+now == 26)	{lvl_target = exp_27;}
            if (lvl_up+now == 27)	{lvl_target = exp_28;}
            if (lvl_up+now == 28)	{lvl_target = exp_29;}
            if (lvl_up+now == 29)	{lvl_target = exp_30;}
            if (lvl_up+now == 30)	{lvl_target = exp_31;}
            if (lvl_up+now == 31)	{lvl_target = exp_32;}
            if (lvl_up+now == 32)	{lvl_target = exp_33;}
            if (lvl_up+now == 33)	{lvl_target = exp_34;}
            if (lvl_up+now == 34)	{lvl_target = exp_35;}
            if (lvl_up+now == 35)	{lvl_target = exp_36;}
            if (lvl_up+now == 36)	{lvl_target = exp_37;}
            if (lvl_up+now == 37)	{lvl_target = exp_38;}
            if (lvl_up+now == 38)	{lvl_target = exp_39;}
            if (lvl_up+now == 39)	{lvl_target = exp_40;}
            if (lvl_up+now == 40)	{lvl_target = exp_41;}
            if (lvl_up+now == 41)	{lvl_target = exp_42;}
            if (lvl_up+now == 42)	{lvl_target = exp_43;}
            if (lvl_up+now == 43)	{lvl_target = exp_44;}
            if (lvl_up+now == 44)	{lvl_target = exp_45;}
            if (lvl_up+now == 45)	{lvl_target = exp_46;}
            if (lvl_up+now == 46)	{lvl_target = exp_47;}
            if (lvl_up+now == 47)	{lvl_target = exp_48;}
            if (lvl_up+now == 48)	{lvl_target = exp_49;}
            if (lvl_up+now == 49)	{lvl_target = exp_50;}

            //total = e1 + e2 + e3 +e4 +e5 +e6 +e7 +e8 ;
            exp_total.setText(getString(R.string.expc_p1)+" "+prettyCount((e1 + e2 + e3 +e4 +e5 +e6 +e7 +e8))+getString(R.string.expc_2));

            if (total == 0 ){
                exp_tv.setText("EXP : MAX");
                pb_exp.setMax(100);
                pb_exp.setProgress(100);
                long final_lv = (now+lvl_up);
                upgrade.setText("Lvl "+prettyCount(final_lv));
            }

            exp_tv.setText("EXP : "+(total+exp)+" / "+lvl_target);
            pb_exp.setMax((int) lvl_target);
            pb_exp.setProgress((int) (total+exp));
            long final_lv = (now+lvl_up);
            upgrade.setText("Lvl "+prettyCount(final_lv));


        }

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


}