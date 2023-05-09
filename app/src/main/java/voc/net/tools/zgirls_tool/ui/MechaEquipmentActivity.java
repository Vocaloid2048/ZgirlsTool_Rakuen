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
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.R;
import voc.net.tools.zgirls_tool.util.ScreenSizeUtils;

public class MechaEquipmentActivity extends AppCompatActivity {

    int rare1_lvl1 =	300	;	int rare2_lvl1 =	750	;	int rare3_lvl1 =	1575	;	int rare4_lvl1 =	2295	;	int rare5_lvl1 =	3000	;
    int rare1_lvl2 = 	480	;	int rare2_lvl2 =	1200	;	int rare3_lvl2 =	2520	;	int rare4_lvl2 =	3672	;	int rare5_lvl2 =	4800	;
    int rare1_lvl3 =	696	;	int rare2_lvl3 =	1740	;	int rare3_lvl3 =	3654	;	int rare4_lvl3 =	5324	;	int rare5_lvl3 =	6960	;
    int rare1_lvl4 =	966	;	int rare2_lvl4 =	2415	;	int rare3_lvl4 =	5071	;	int rare4_lvl4 =	7390	;	int rare5_lvl4 =	9660	;
    int rare1_lvl5 =	1317	;	int rare2_lvl5 =	3293	;	int rare3_lvl5 =	6915	;	int rare4_lvl5 =	10074	;	int rare5_lvl5 =	13170	;
    int rare1_lvl6 =	1791	;	int rare2_lvl6 =	4477	;	int rare3_lvl6 =	9402	;	int rare4_lvl6 =	13699	;	int rare5_lvl6 =	17908	;
    int rare1_lvl7 =	2454	;	int rare2_lvl7 =	6136	;	int rare3_lvl7 =	12885	;	int rare4_lvl7 =	18774	;	int rare5_lvl7 =	24542	;
    int rare1_lvl8 =	3416	;	int rare2_lvl8 =	8541	;	int rare3_lvl8 =	17935	;	int rare4_lvl8 =	26134	;	int rare5_lvl8 =	34162	;
    int rare1_lvl9 =	4859	;	int rare2_lvl9 =	12148	;	int rare3_lvl9 =	25510	;	int rare4_lvl9 =	37171	;	int rare5_lvl9 =	48590	;


    int green_up = 97 ;
    int blue_up = 255 ;
    int purple_up = 405 ;
    int orange_up = 502 ;
    int gold_up = 750 ;

    int base , total ;

    String rare_choosed = "green";

    String G = "green";
    String B = "blue";
    String P = "purple";
    String O = "orange";
    String Y = "gold";

    /*
    Elements	EXP of 1 element
    Green 			97
    Blue 			255
    Purple 			405
    Orange 			502
    Gold			750
     */

    SeekBar now_seek , aim_seek , exp_seek;
    TextView now_lv , aim_lv ;
    TextView exp_tv ;
    TextView mecha_e_total , mecha_e_green , mecha_e_blue , mecha_e_purple , mecha_e_orange , mecha_e_gold , choosed;
    int now = 1;
    int aim = 2;
    int prog = 0;
    Button rare_a1 , rare_a2 , rare_a3 , rare_a4 , rare_a5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mecha_equipment);
        now_seek = findViewById(R.id.now_seek);
        aim_seek = findViewById(R.id.aim_seek);
        exp_seek = findViewById(R.id.exp_seek);
        now_lv = findViewById(R.id.now_seek_tv);
        aim_lv = findViewById(R.id.aim_seek_tv);
        exp_tv = findViewById(R.id.exp_seek_tv);
        mecha_e_total = findViewById(R.id.mecha_e_total);
        mecha_e_green = findViewById(R.id.mecha_e_green);
        mecha_e_blue = findViewById(R.id.mecha_e_blue);
        mecha_e_purple = findViewById(R.id.mecha_e_purple);
        mecha_e_orange = findViewById(R.id.mecha_e_orange);
        mecha_e_gold = findViewById(R.id.mecha_e_gold);
        rare_a1 = findViewById(R.id.rare_a1);
        rare_a2 = findViewById(R.id.rare_a2);
        rare_a3 = findViewById(R.id.rare_a3);
        rare_a4 = findViewById(R.id.rare_a4);
        rare_a5 = findViewById(R.id.rare_a5);
        choosed = findViewById(R.id.mecha_e_choosed);

        rare_choosed = G;
        choosed.setText(getString(R.string.public_you_choose)+"  "+G.toUpperCase());
        calculate();
        calculate();

        rare_a1.setOnClickListener(new Button.OnClickListener() {@Override public void onClick(View view) {rare_choosed = G;choosed.setText(getString(R.string.public_you_choose)+"  "+G.toUpperCase());calculate();calculate();}});
        rare_a2.setOnClickListener(new Button.OnClickListener() {@Override public void onClick(View view) {rare_choosed = B;choosed.setText(getString(R.string.public_you_choose)+"  "+B.toUpperCase());calculate();calculate();}});
        rare_a3.setOnClickListener(new Button.OnClickListener() {@Override public void onClick(View view) {rare_choosed = P;choosed.setText(getString(R.string.public_you_choose)+"  "+P.toUpperCase());calculate();calculate();}});
        rare_a4.setOnClickListener(new Button.OnClickListener() {@Override public void onClick(View view) {rare_choosed = O;choosed.setText(getString(R.string.public_you_choose)+"  "+O.toUpperCase());calculate();calculate();}});
        rare_a5.setOnClickListener(new Button.OnClickListener() {@Override public void onClick(View view) {rare_choosed = Y;choosed.setText(getString(R.string.public_you_choose)+"  "+Y.toUpperCase());calculate();calculate();}});

      //  Rare();

        now_seek.setMax(10);
        now_seek.setProgress(1);
        aim_seek.setMax(10);
        aim_seek.setProgress(2);
        exp_seek.setMax(300);
        exp_seek.setProgress(0);

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
                if (progress >=9){
                    now_seek.setProgress(9);
                    now = 9 ;
                    now_lv.setText(String.valueOf(9));
                }
                if (progress <1){
                    now_seek.setProgress(1);
                    now = 1 ;
                    now_lv.setText(String.valueOf(1));
                }
                if (progress >=1&&progress<=9){
                    now_seek.setProgress(progress);
                    now = progress ;
                    now_lv.setText(String.valueOf(progress));
                }
                if (aim_seek.getProgress()<=now_seek.getProgress()){
                    aim_seek.setProgress(now_seek.getProgress()+1);
                    aim = now_seek.getProgress()+1;
                    aim_lv.setText(String.valueOf(now_seek.getProgress()+1));
                }
                calculate();
                calculate();
            }
        });

        aim_seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
                if (aim_seek.getProgress()>now_seek.getProgress()&&aim_seek.getProgress()>1){
                    aim_seek.setProgress(aim_seek.getProgress());
                    aim = aim_seek.getProgress() ;
                    aim_lv.setText(String.valueOf(aim_seek.getProgress()));

                }
                calculate();
                calculate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub
                if (progress >=10){
                    aim_seek.setProgress(10);
                    aim = 10 ;
                    aim_lv.setText(String.valueOf(10));
                }
                if (progress <2){
                    aim_seek.setProgress(2);
                    aim = 2 ;
                    aim_lv.setText(String.valueOf(2));
                }
                if (aim_seek.getProgress()<=now_seek.getProgress()){
                    aim_seek.setProgress(now_seek.getProgress()+1);
                    aim = now_seek.getProgress()+1;
                    aim_lv.setText(String.valueOf(now_seek.getProgress()+1));
                }
                if (aim_seek.getProgress()>now_seek.getProgress()&&aim_seek.getProgress()>1){
                    aim_seek.setProgress(aim_seek.getProgress());
                    aim = aim_seek.getProgress() ;
                    aim_lv.setText(String.valueOf(aim_seek.getProgress()));

                }
                calculate();
                calculate();
            }
        });

        exp_seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

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
                exp_tv.setText(String.valueOf(progress));
                calculate();
                calculate();
            }
        });

        BackgroundReload();
    }

    public void Rare() {
        final Dialog dialog = new Dialog(this, R.style.NormalDialogStyle_N);
        View view = View.inflate(this, R.layout.mecha_e_choose, null);
        ImageView rare1 = view.findViewById(R.id.rare1);
        ImageView rare2 = view.findViewById(R.id.rare2);
        ImageView rare3 = view.findViewById(R.id.rare3);
        ImageView rare4 = view.findViewById(R.id.rare4);
        ImageView rare5 = view.findViewById(R.id.rare5);

        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        //view.setMinimumHeight((int) (ScreenSizeUtils.getInstance(this).getScreenHeight()));
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int) (ScreenSizeUtils.getInstance(this).getScreenWidth());
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);
        dialog.setCancelable(false);
        dialog.show();

        rare1.setOnClickListener(new Button.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();rare_choosed = G;choosed.setText(getString(R.string.public_you_choose)+"  "+G.toUpperCase());calculate();calculate();}});
        rare2.setOnClickListener(new Button.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();rare_choosed = B;choosed.setText(getString(R.string.public_you_choose)+"  "+B.toUpperCase());calculate();calculate();}});
        rare3.setOnClickListener(new Button.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();rare_choosed = P;choosed.setText(getString(R.string.public_you_choose)+"  "+P.toUpperCase());calculate();calculate();}});
        rare4.setOnClickListener(new Button.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();rare_choosed = O;choosed.setText(getString(R.string.public_you_choose)+"  "+O.toUpperCase());calculate();calculate();}});
        rare5.setOnClickListener(new Button.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();rare_choosed = Y;choosed.setText(getString(R.string.public_you_choose)+"  "+Y.toUpperCase());calculate();calculate();}});

    }

    public void BackgroundReload (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.bg);

        Resources res = getResources();
        String fileNamePNG = "background.png";
        String fileNameGIF = "background.gif";
        String fileNameJPG = "background.jpg";
        String fileNameJPEG = "background.jpeg";
        String pathName = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/background/";

        Bitmap bitmap = BitmapFactory.decodeFile(pathName+fileNamePNG);
        BitmapDrawable bd = new BitmapDrawable(res, bitmap);

        Bitmap bitmap2 = BitmapFactory.decodeFile(pathName+fileNameJPG);
        BitmapDrawable bd2 = new BitmapDrawable(res, bitmap2);

        Bitmap bitmap3 = BitmapFactory.decodeFile(pathName+fileNameJPEG);
        BitmapDrawable bd3 = new BitmapDrawable(res, bitmap3);

        File gifFile = new File(pathName,fileNameGIF);
        GifDrawable gifFromFile = null;
        try { gifFromFile = new GifDrawable(gifFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (gif_png.matches("gif")){gifImageView1.setImageDrawable(gifFromFile);}
        if (gif_png.matches("png")){gifImageView1.setImageDrawable(bd);}
        if (gif_png.matches("jpg")){gifImageView1.setImageDrawable(bd2);}
        if (gif_png.matches("jpeg")){gifImageView1.setImageDrawable(bd3);}
    }

    public void calculate (){
        base = total = prog = 0 ;
        Log.i("You choose ",rare_choosed);

        if (rare_choosed.equals(G)){
            if (now == 1){	exp_seek.setMax(rare1_lvl1);	base = 0;}
            if (now == 2){	exp_seek.setMax(rare1_lvl2);	base = rare1_lvl1;}
            if (now == 3){	exp_seek.setMax(rare1_lvl3);	base = rare1_lvl1	 + rare1_lvl2	;}
            if (now == 4){	exp_seek.setMax(rare1_lvl4);	base = rare1_lvl1	 + rare1_lvl2	 + rare1_lvl3	;}
            if (now == 5){	exp_seek.setMax(rare1_lvl5);	base = rare1_lvl1	 + rare1_lvl2	 + rare1_lvl3	 + rare1_lvl4	;}
            if (now == 6){	exp_seek.setMax(rare1_lvl6);	base = rare1_lvl1	 + rare1_lvl2	 + rare1_lvl3	 + rare1_lvl4	 + rare1_lvl5	;}
            if (now == 7){	exp_seek.setMax(rare1_lvl7);	base = rare1_lvl1	 + rare1_lvl2	 + rare1_lvl3	 + rare1_lvl4	 + rare1_lvl5	 + rare1_lvl6	;}
            if (now == 8){	exp_seek.setMax(rare1_lvl8);	base = rare1_lvl1	 + rare1_lvl2	 + rare1_lvl3	 + rare1_lvl4	 + rare1_lvl5	 + rare1_lvl6	 + rare1_lvl7	;}
            if (now == 9){	exp_seek.setMax(rare1_lvl9);	base = rare1_lvl1	 + rare1_lvl2	 + rare1_lvl3	 + rare1_lvl4	 + rare1_lvl5	 + rare1_lvl6	 + rare1_lvl7	 + rare1_lvl8	;}


            if (aim >= 2){	total = total + rare1_lvl1;}
            if (aim >= 3){	total = total + rare1_lvl2;}
            if (aim >= 4){	total = total + rare1_lvl3;}
            if (aim >= 5){	total = total + rare1_lvl4;}
            if (aim >= 6){	total = total + rare1_lvl5;}
            if (aim >= 7){	total = total + rare1_lvl6;}
            if (aim >= 8){	total = total + rare1_lvl7;}
            if (aim >= 9){	total = total + rare1_lvl8;}
            if (aim >= 10){	total = total + rare1_lvl9;}

            prog = exp_seek.getProgress();
            Log.i("PROG",prettyCount(prog));

        }
        if (rare_choosed.equals(B)){
            if (now == 1){	exp_seek.setMax(rare2_lvl1);	base = 0;}
            if (now == 2){	exp_seek.setMax(rare2_lvl2);	base = rare2_lvl1;}
            if (now == 3){	exp_seek.setMax(rare2_lvl3);	base = rare2_lvl1	 + rare2_lvl2	;}
            if (now == 4){	exp_seek.setMax(rare2_lvl4);	base = rare2_lvl1	 + rare2_lvl2	 + rare2_lvl3	;}
            if (now == 5){	exp_seek.setMax(rare2_lvl5);	base = rare2_lvl1	 + rare2_lvl2	 + rare2_lvl3	 + rare2_lvl4	;}
            if (now == 6){	exp_seek.setMax(rare2_lvl6);	base = rare2_lvl1	 + rare2_lvl2	 + rare2_lvl3	 + rare2_lvl4	 + rare2_lvl5	;}
            if (now == 7){	exp_seek.setMax(rare2_lvl7);	base = rare2_lvl1	 + rare2_lvl2	 + rare2_lvl3	 + rare2_lvl4	 + rare2_lvl5	 + rare2_lvl6	;}
            if (now == 8){	exp_seek.setMax(rare2_lvl8);	base = rare2_lvl1	 + rare2_lvl2	 + rare2_lvl3	 + rare2_lvl4	 + rare2_lvl5	 + rare2_lvl6	 + rare2_lvl7	;}
            if (now == 9){	exp_seek.setMax(rare2_lvl9);	base = rare2_lvl1	 + rare2_lvl2	 + rare2_lvl3	 + rare2_lvl4	 + rare2_lvl5	 + rare2_lvl6	 + rare2_lvl7	 + rare2_lvl8	;}


            if (aim >= 2){	total = total + rare2_lvl1;}
            if (aim >= 3){	total = total + rare2_lvl2;}
            if (aim >= 4){	total = total + rare2_lvl3;}
            if (aim >= 5){	total = total + rare2_lvl4;}
            if (aim >= 6){	total = total + rare2_lvl5;}
            if (aim >= 7){	total = total + rare2_lvl6;}
            if (aim >= 8){	total = total + rare2_lvl7;}
            if (aim >= 9){	total = total + rare2_lvl8;}
            if (aim >= 10){	total = total + rare2_lvl9;}

            prog = exp_seek.getProgress();
            Log.i("PROG",prettyCount(prog));
        }

        if (rare_choosed.equals(P)){
            if (now == 1){	exp_seek.setMax(rare3_lvl1);	base = 0;}
            if (now == 2){	exp_seek.setMax(rare3_lvl2);	base = rare3_lvl1;}
            if (now == 3){	exp_seek.setMax(rare3_lvl3);	base = rare3_lvl1	 + rare3_lvl2	;}
            if (now == 4){	exp_seek.setMax(rare3_lvl4);	base = rare3_lvl1	 + rare3_lvl2	 + rare3_lvl3	;}
            if (now == 5){	exp_seek.setMax(rare3_lvl5);	base = rare3_lvl1	 + rare3_lvl2	 + rare3_lvl3	 + rare3_lvl4	;}
            if (now == 6){	exp_seek.setMax(rare3_lvl6);	base = rare3_lvl1	 + rare3_lvl2	 + rare3_lvl3	 + rare3_lvl4	 + rare3_lvl5	;}
            if (now == 7){	exp_seek.setMax(rare3_lvl7);	base = rare3_lvl1	 + rare3_lvl2	 + rare3_lvl3	 + rare3_lvl4	 + rare3_lvl5	 + rare3_lvl6	;}
            if (now == 8){	exp_seek.setMax(rare3_lvl8);	base = rare3_lvl1	 + rare3_lvl2	 + rare3_lvl3	 + rare3_lvl4	 + rare3_lvl5	 + rare3_lvl6	 + rare3_lvl7	;}
            if (now == 9){	exp_seek.setMax(rare3_lvl9);	base = rare3_lvl1	 + rare3_lvl2	 + rare3_lvl3	 + rare3_lvl4	 + rare3_lvl5	 + rare3_lvl6	 + rare3_lvl7	 + rare3_lvl8	;}


            if (aim >= 2){	total = total + rare3_lvl1;}
            if (aim >= 3){	total = total + rare3_lvl2;}
            if (aim >= 4){	total = total + rare3_lvl3;}
            if (aim >= 5){	total = total + rare3_lvl4;}
            if (aim >= 6){	total = total + rare3_lvl5;}
            if (aim >= 7){	total = total + rare3_lvl6;}
            if (aim >= 8){	total = total + rare3_lvl7;}
            if (aim >= 9){	total = total + rare3_lvl8;}
            if (aim >= 10){	total = total + rare3_lvl9;}

            prog = exp_seek.getProgress();
            Log.i("PROG",prettyCount(prog));
        }

        if (rare_choosed.equals(O)){
            if (now == 1){	exp_seek.setMax(rare4_lvl1);	base = 0;}
            if (now == 2){	exp_seek.setMax(rare4_lvl2);	base = rare4_lvl1;}
            if (now == 3){	exp_seek.setMax(rare4_lvl3);	base = rare4_lvl1	 + rare4_lvl2	;}
            if (now == 4){	exp_seek.setMax(rare4_lvl4);	base = rare4_lvl1	 + rare4_lvl2	 + rare4_lvl3	;}
            if (now == 5){	exp_seek.setMax(rare4_lvl5);	base = rare4_lvl1	 + rare4_lvl2	 + rare4_lvl3	 + rare4_lvl4	;}
            if (now == 6){	exp_seek.setMax(rare4_lvl6);	base = rare4_lvl1	 + rare4_lvl2	 + rare4_lvl3	 + rare4_lvl4	 + rare4_lvl5	;}
            if (now == 7){	exp_seek.setMax(rare4_lvl7);	base = rare4_lvl1	 + rare4_lvl2	 + rare4_lvl3	 + rare4_lvl4	 + rare4_lvl5	 + rare4_lvl6	;}
            if (now == 8){	exp_seek.setMax(rare4_lvl8);	base = rare4_lvl1	 + rare4_lvl2	 + rare4_lvl3	 + rare4_lvl4	 + rare4_lvl5	 + rare4_lvl6	 + rare4_lvl7	;}
            if (now == 9){	exp_seek.setMax(rare4_lvl9);	base = rare4_lvl1	 + rare4_lvl2	 + rare4_lvl3	 + rare4_lvl4	 + rare4_lvl5	 + rare4_lvl6	 + rare4_lvl7	 + rare4_lvl8	;}


            if (aim >= 2){	total = total + rare4_lvl1;}
            if (aim >= 3){	total = total + rare4_lvl2;}
            if (aim >= 4){	total = total + rare4_lvl3;}
            if (aim >= 5){	total = total + rare4_lvl4;}
            if (aim >= 6){	total = total + rare4_lvl5;}
            if (aim >= 7){	total = total + rare4_lvl6;}
            if (aim >= 8){	total = total + rare4_lvl7;}
            if (aim >= 9){	total = total + rare4_lvl8;}
            if (aim >= 10){	total = total + rare4_lvl9;}

            prog = exp_seek.getProgress();
            Log.i("PROG",prettyCount(prog));
        }

        if (rare_choosed.equals(Y)){
            if (now == 1){	exp_seek.setMax(rare5_lvl1);	base = 0;}
            if (now == 2){	exp_seek.setMax(rare5_lvl2);	base = rare5_lvl1;}
            if (now == 3){	exp_seek.setMax(rare5_lvl3);	base = rare5_lvl1	 + rare5_lvl2	;}
            if (now == 4){	exp_seek.setMax(rare5_lvl4);	base = rare5_lvl1	 + rare5_lvl2	 + rare5_lvl3	;}
            if (now == 5){	exp_seek.setMax(rare5_lvl5);	base = rare5_lvl1	 + rare5_lvl2	 + rare5_lvl3	 + rare5_lvl4	;}
            if (now == 6){	exp_seek.setMax(rare5_lvl6);	base = rare5_lvl1	 + rare5_lvl2	 + rare5_lvl3	 + rare5_lvl4	 + rare5_lvl5	;}
            if (now == 7){	exp_seek.setMax(rare5_lvl7);	base = rare5_lvl1	 + rare5_lvl2	 + rare5_lvl3	 + rare5_lvl4	 + rare5_lvl5	 + rare5_lvl6	;}
            if (now == 8){	exp_seek.setMax(rare5_lvl8);	base = rare5_lvl1	 + rare5_lvl2	 + rare5_lvl3	 + rare5_lvl4	 + rare5_lvl5	 + rare5_lvl6	 + rare5_lvl7	;}
            if (now == 9){	exp_seek.setMax(rare5_lvl9);	base = rare5_lvl1	 + rare5_lvl2	 + rare5_lvl3	 + rare5_lvl4	 + rare5_lvl5	 + rare5_lvl6	 + rare5_lvl7	 + rare5_lvl8	;}


            if (aim >= 2){	total = total + rare5_lvl1;}
            if (aim >= 3){	total = total + rare5_lvl2;}
            if (aim >= 4){	total = total + rare5_lvl3;}
            if (aim >= 5){	total = total + rare5_lvl4;}
            if (aim >= 6){	total = total + rare5_lvl5;}
            if (aim >= 7){	total = total + rare5_lvl6;}
            if (aim >= 8){	total = total + rare5_lvl7;}
            if (aim >= 9){	total = total + rare5_lvl8;}
            if (aim >= 10){	total = total + rare5_lvl9;}

            prog = exp_seek.getProgress();
            Log.i("PROG",prettyCount(prog));
        }
        double fina = (total-(prog+base));
        int a = (total-(prog+base))/97;
        int b = (total-(prog+base))/255;
        int c = (total-(prog+base))/405;
        int d = (total-(prog+base))/502;
        int e = (total-(prog+base))/750;

        Log.i("XD", String.valueOf(fina/97));

        if (fina/97 > a &&fina/97>0 ){a = a+1;}
        if (fina/255 > b &&fina/255>0){b = b+1;}
        if (fina/405 > c &&fina/405>0){c = c+1;}
        if (fina/502 > d &&fina/502>0){d = d+1;}
        if (fina/750 > e &&fina/750>0){e = e+1;}

        mecha_e_total.setText(prettyCount(fina));
        mecha_e_green.setText(prettyCount(a));
        mecha_e_blue.setText(prettyCount(b));
        mecha_e_purple.setText(prettyCount(c));
        mecha_e_orange.setText(prettyCount(d));
        mecha_e_gold.setText(prettyCount(e));


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
                    return new DecimalFormat("##.###").format(numValue / Math.pow(10, base * 3))+ suffix[base];
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