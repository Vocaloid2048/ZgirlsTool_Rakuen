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
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.R;

public class LegendaryActivity extends AppCompatActivity {

    int weapon_lvl2 = 	4900	;
    int weapon_lvl3 =	7100	;
    int weapon_lvl4 =	9700	;
    int weapon_lvl5 =	13100	;
    int weapon_lvl6 =	17100	;
    int weapon_lvl7 =	21600	;
    int weapon_lvl8 =	26600	;
    int weapon_lvl9 =	31200	;
    int weapon_lvl10 =	35600	;
    int weapon_lvl11 =	40000	;
    int weapon_lvl12 =	44500	;
    int weapon_lvl13 =	49200	;
    int weapon_lvl14 =	54300	;
    int weapon_lvl15 =	60000	;
    int weapon_lvl16 =	66400	;
    int weapon_lvl17 =	73600	;
    int weapon_lvl18 =	81800	;
    int weapon_lvl19 =	91200	;
    int weapon_lvl20 =	101900	;
    int weapon_lvl21 =	114000	;
    int weapon_lvl22 =	127700	;
    int weapon_lvl23 =	143200	;
    int weapon_lvl24 =	160600	;
    int weapon_lvl25 =	180000	;
    int weapon_lvl26 =	201600	;
    int weapon_lvl27 =	225600	;
    int weapon_lvl28 =	252100	;
    int weapon_lvl29 =	281200	;
    int weapon_lvl30 =	313100	;
    int weapon_lvl31 =	348000	;
    int weapon_lvl32 =	386000	;
    int weapon_lvl33 =	427200	;
    int weapon_lvl34 =	471800	;
    int weapon_lvl35 =	520000	;
    int weapon_lvl36 =	571900	;
    int weapon_lvl37 =	627600	;
    int weapon_lvl38 =	687300	;
    int weapon_lvl39 =	751200	;
    int weapon_lvl40 =	819400	;
    int weapon_lvl41 =	892000	;
    int weapon_lvl42 =	969200	;
    int weapon_lvl43 =	1051200	;
    int weapon_lvl44 =	1138100	;
    int weapon_lvl45 =	1230000	;
    int weapon_lvl46 =	1327100	;
    int weapon_lvl47 =	1429600	;
    int weapon_lvl48 =	1537600	;
    int weapon_lvl49 =	1651200	;
    int weapon_lvl50 =	1770600	;

    int diamond_ut10 = 	1000	;int brs_ut10 =	1000	; int ors_ut10 = 	0	;int ars_ut10 =	0	;
    int diamond_ut20 = 	5000	;int brs_ut20 =	4000	; int ors_ut20 = 	0	;int ars_ut20 =	0	;
    int diamond_ut30 =	10000	;int brs_ut30 =	12000	; int ors_ut30 =	6800	;int ars_ut30 =	0	;
    int diamond_ut40 =	45000	;int brs_ut40 =	34000	; int ors_ut40 =	13500	;int ars_ut40 =	10000	;

    int sr_ut0 =	10	; int diamond_remode_ut0 =	100	; int or_ut0 =	10	;
    int sr_ut1 =	20	; int diamond_remode_ut1 =	200	; int or_ut1 =	20	;
    int sr_ut2 =	30	; int diamond_remode_ut2 =	300	; int or_ut2 =	30	;
    int sr_ut3 =	40	; int diamond_remode_ut3 =	400	; int or_ut3 =	40	;
    int sr_ut4 =	50	; int diamond_remode_ut4 =	500	; int or_ut4 =	50	;


    int weaponId = 0 ;
    int weaponTId = 0 ;
    int weaponType = 0 ;
    int weaponC = 0 ;

    int now , aim , exp;

    ImageView weapon_choose , weapon_a , weapon_b ;
    ImageView  weapon_a2 , weapon_b2 ;
    TextView weapon_total , weapon_exp1 , weapon_exp2 , weapon_exp3 , weapon_exp4 , weapon_exp5 , weapon_exp6;
    SeekBar now_seek , aim_seek , exp_seek ;
    TextView now_tv , aim_tv , exp_tv;
    private RadioGroup radioGroup;
    private RadioButton
            radioButton0,
            radioButton1,
            radioButton2;

    int base , total , total_e , base_e, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legendary);
        BackgroundReload();
        init();

        now_seek.setMax(0);
        aim_seek.setMax(1);
        exp_seek.setMax(weapon_lvl2);

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
                if (weaponC == 1){
                    if (aim_seek.getProgress() <= now_seek.getProgress()){aim_seek.setProgress(now_seek.getProgress()+1);}
                    if (now_seek.getProgress()<1){now_seek.setProgress(1);}
                    if (now_seek.getProgress()>=1&&now_seek.getProgress()<10){weapon_a.setImageResource(R.drawable.legend_equip_katana1);}
                    if (now_seek.getProgress()>=10&&now_seek.getProgress()<20){weapon_a.setImageResource(R.drawable.legend_equip_katana2);}
                    if (now_seek.getProgress()>=20&&now_seek.getProgress()<30){weapon_a.setImageResource(R.drawable.legend_equip_katana3);}
                    if (now_seek.getProgress()>=30&&now_seek.getProgress()<40){weapon_a.setImageResource(R.drawable.legend_equip_katana4);}
                    if (now_seek.getProgress()>=40&&now_seek.getProgress()<50){weapon_a.setImageResource(R.drawable.legend_equip_katana5);}
                    if (now_seek.getProgress()>=49){now_seek.setProgress(49);}
                }
                if (weaponC == 2){
                    if (aim_seek.getProgress() <= now_seek.getProgress()){aim_seek.setProgress(now_seek.getProgress()+1);}
                    if (now_seek.getProgress()<1){now_seek.setProgress(1);}
                    if (now_seek.getProgress()>=1&&now_seek.getProgress()<10){weapon_a.setImageResource(R.drawable.legend_shield1);}
                    if (now_seek.getProgress()>=10&&now_seek.getProgress()<20){weapon_a.setImageResource(R.drawable.legend_shield2);}
                    if (now_seek.getProgress()>=20&&now_seek.getProgress()<30){weapon_a.setImageResource(R.drawable.legend_shield3);}
                    if (now_seek.getProgress()>=30&&now_seek.getProgress()<40){weapon_a.setImageResource(R.drawable.legend_shield4);}
                    if (now_seek.getProgress()>=40&&now_seek.getProgress()<50){weapon_a.setImageResource(R.drawable.legend_shield5);}
                    if (now_seek.getProgress()>=49){now_seek.setProgress(49);}
                }
                if (weaponC == 3){
                    if (aim_seek.getProgress() <= now_seek.getProgress()){aim_seek.setProgress(now_seek.getProgress()+1);}
                    if (now_seek.getProgress()<1){now_seek.setProgress(1);}
                    if (now_seek.getProgress()>=1&&now_seek.getProgress()<10){weapon_a.setImageResource(R.drawable.legend_equip_gun1);}
                    if (now_seek.getProgress()>=10&&now_seek.getProgress()<20){weapon_a.setImageResource(R.drawable.legend_equip_gun2);}
                    if (now_seek.getProgress()>=20&&now_seek.getProgress()<30){weapon_a.setImageResource(R.drawable.legend_equip_gun3);}
                    if (now_seek.getProgress()>=30&&now_seek.getProgress()<40){weapon_a.setImageResource(R.drawable.legend_equip_gun4);}
                    if (now_seek.getProgress()>=40&&now_seek.getProgress()<50){weapon_a.setImageResource(R.drawable.legend_equip_gun5);}
                    if (now_seek.getProgress()>=49){now_seek.setProgress(49);}
                }
                now = now_seek.getProgress();
                now_tv.setText(String.valueOf(now));
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
                if (weaponC == 1){
                    if (aim_seek.getProgress()<2){aim_seek.setProgress(2);}
                    if (aim_seek.getProgress()>=2&&aim_seek.getProgress()<10){weapon_b.setImageResource(R.drawable.legend_equip_katana1);}
                    if (aim_seek.getProgress()>=10&&aim_seek.getProgress()<20){weapon_b.setImageResource(R.drawable.legend_equip_katana2);}
                    if (aim_seek.getProgress()>=20&&aim_seek.getProgress()<30){weapon_b.setImageResource(R.drawable.legend_equip_katana3);}
                    if (aim_seek.getProgress()>=30&&aim_seek.getProgress()<40){weapon_b.setImageResource(R.drawable.legend_equip_katana4);}
                    if (aim_seek.getProgress()>=40&&aim_seek.getProgress()<50){weapon_b.setImageResource(R.drawable.legend_equip_katana5);}
                    if (aim_seek.getProgress()>=50){aim_seek.setProgress(50);}
                }
                if (weaponC == 2){
                    if (aim_seek.getProgress()<2){aim_seek.setProgress(2);}
                    if (aim_seek.getProgress()>=2&&aim_seek.getProgress()<10){weapon_b.setImageResource(R.drawable.legend_shield1);}
                    if (aim_seek.getProgress()>=10&&aim_seek.getProgress()<20){weapon_b.setImageResource(R.drawable.legend_shield2);}
                    if (aim_seek.getProgress()>=20&&aim_seek.getProgress()<30){weapon_b.setImageResource(R.drawable.legend_shield3);}
                    if (aim_seek.getProgress()>=30&&aim_seek.getProgress()<40){weapon_b.setImageResource(R.drawable.legend_shield4);}
                    if (aim_seek.getProgress()>=40&&aim_seek.getProgress()<50){weapon_b.setImageResource(R.drawable.legend_shield5);}
                    if (aim_seek.getProgress()>=50){aim_seek.setProgress(50);}
                }
                if (weaponC == 3){
                    if (aim_seek.getProgress()<2){aim_seek.setProgress(2);}
                    if (aim_seek.getProgress()>=2&&aim_seek.getProgress()<10){weapon_b.setImageResource(R.drawable.legend_equip_gun1);}
                    if (aim_seek.getProgress()>=10&&aim_seek.getProgress()<20){weapon_b.setImageResource(R.drawable.legend_equip_gun2);}
                    if (aim_seek.getProgress()>=20&&aim_seek.getProgress()<30){weapon_b.setImageResource(R.drawable.legend_equip_gun3);}
                    if (aim_seek.getProgress()>=30&&aim_seek.getProgress()<40){weapon_b.setImageResource(R.drawable.legend_equip_gun4);}
                    if (aim_seek.getProgress()>=40&&aim_seek.getProgress()<50){weapon_b.setImageResource(R.drawable.legend_equip_gun5);}
                    if (aim_seek.getProgress()>=50){aim_seek.setProgress(50);}
                }
                aim = aim_seek.getProgress();
                aim_tv.setText(String.valueOf(aim));
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
            }
        });
    }

    public void init() {
        weapon_a = findViewById(R.id.weapon_a_img);
        weapon_b = findViewById(R.id.weapon_b_img);
        weapon_choose = findViewById(R.id.weapon_choose);
        weapon_a2 = findViewById(R.id.weapon_a_img2);
        weapon_b2 = findViewById(R.id.weapon_b_img2);

        weapon_total = findViewById(R.id.legen_rare_total_tv);
        weapon_exp1 = findViewById(R.id.legen_rare1_tv);
        weapon_exp2 = findViewById(R.id.legen_rare2_tv);
        weapon_exp3 = findViewById(R.id.legen_rare3_tv);
        weapon_exp4 = findViewById(R.id.legen_rare4_tv);
        weapon_exp5 = findViewById(R.id.legen_rare5_tv);
        weapon_exp6 = findViewById(R.id.legen_rare6_tv);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioButton0 = (RadioButton) findViewById(R.id.radioButton0);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);

        now_seek = findViewById(R.id.now_seek);
        aim_seek = findViewById(R.id.aim_seek);
        exp_seek = findViewById(R.id.exp_seek);
        now_tv = findViewById(R.id.now_seek_tv);
        aim_tv = findViewById(R.id.aim_seek_tv);
        exp_tv = findViewById(R.id.exp_seek_tv);
    }

    public void weapon_choose(View view){
        final Dialog dialog = new Dialog(this, R.style.NormalDialogStyle_N);
        view = View.inflate(this, R.layout.legendary_choose, null);
        ImageView weap01_lvl1 = view.findViewById(R.id.weap01_lvl1);
        ImageView weap01_lvl2 = view.findViewById(R.id.weap01_lvl2);
        ImageView weap01_lvl3 = view.findViewById(R.id.weap01_lvl3);
        ImageView weap01_lvl4 = view.findViewById(R.id.weap01_lvl4);
        ImageView weap01_lvl5 = view.findViewById(R.id.weap01_lvl5);
        ImageView weap02_lvl1 = view.findViewById(R.id.weap02_lvl1);
        ImageView weap02_lvl2 = view.findViewById(R.id.weap02_lvl2);
        ImageView weap02_lvl3 = view.findViewById(R.id.weap02_lvl3);
        ImageView weap02_lvl4 = view.findViewById(R.id.weap02_lvl4);
        ImageView weap02_lvl5 = view.findViewById(R.id.weap02_lvl5);
        ImageView weap03_lvl1 = view.findViewById(R.id.weap03_lvl1);
        ImageView weap03_lvl2 = view.findViewById(R.id.weap03_lvl2);
        ImageView weap03_lvl3 = view.findViewById(R.id.weap03_lvl3);
        ImageView weap03_lvl4 = view.findViewById(R.id.weap03_lvl4);
        ImageView weap03_lvl5 = view.findViewById(R.id.weap03_lvl5);

        weap01_lvl1.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();weaponId = 1 ; setImgBase();}});
        weap01_lvl2.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();weaponId = 2 ; setImgBase();}});
        weap01_lvl3.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();weaponId = 3 ; setImgBase();}});
        weap01_lvl4.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();weaponId = 4 ; setImgBase();}});
        weap01_lvl5.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();weaponId = 5 ; setImgBase();}});
        weap02_lvl1.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();weaponId = 6 ; setImgBase();}});
        weap02_lvl2.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();weaponId = 7 ; setImgBase();}});
        weap02_lvl3.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();weaponId = 8 ; setImgBase();}});
        weap02_lvl4.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();weaponId = 9 ; setImgBase();}});
        weap02_lvl5.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();weaponId = 10 ; setImgBase();}});
        weap03_lvl1.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();weaponId = 11 ; setImgBase();}});
        weap03_lvl2.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();weaponId = 12 ; setImgBase();}});
        weap03_lvl3.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();weaponId = 13 ; setImgBase();}});
        weap03_lvl4.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();weaponId = 14 ; setImgBase();}});
        weap03_lvl5.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();weaponId = 15 ; setImgBase();}});

        if (weaponId == 1|weaponId == 6|weaponId == 11){now_seek.setProgress(1);}
        if (weaponId == 2|weaponId == 7|weaponId == 12){now_seek.setProgress(10);}
        if (weaponId == 3|weaponId == 8|weaponId == 13){now_seek.setProgress(20);}
        if (weaponId == 4|weaponId == 9|weaponId == 14){now_seek.setProgress(30);}
        if (weaponId == 5|weaponId == 10|weaponId == 15){now_seek.setProgress(40);}

        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        //view.setMinimumHeight((int) (ScreenSizeUtils.getInstance(this).getScreenHeight()));
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);
        dialog.setCancelable(false);
        dialog.show();
    }

    public void setImgBase (){
        now_seek.setMax(50);
        aim_seek.setMax(50);
        weaponTId = 0 ;
        if (weaponId == 0){weapon_choose.setImageResource(R.drawable.blank_box_show);weaponType = 0;}
        if (weaponId == 1){weapon_choose.setImageResource(R.drawable.legend_equip_katana1);weaponType = 1;weaponC=1;}
        if (weaponId == 2){weapon_choose.setImageResource(R.drawable.legend_equip_katana2);weaponType = 2;weaponC=1;}
        if (weaponId == 3){weapon_choose.setImageResource(R.drawable.legend_equip_katana3);weaponType = 3;weaponC=1;}
        if (weaponId == 4){weapon_choose.setImageResource(R.drawable.legend_equip_katana4);weaponType = 4;weaponC=1;}
        if (weaponId == 5){weapon_choose.setImageResource(R.drawable.legend_equip_katana5);weaponType = 5;weaponC=1;}
        if (weaponId == 6){weapon_choose.setImageResource(R.drawable.legend_shield1);weaponType = 1;weaponC=2;}
        if (weaponId == 7){weapon_choose.setImageResource(R.drawable.legend_shield2);weaponType = 2;weaponC=2;}
        if (weaponId == 8){weapon_choose.setImageResource(R.drawable.legend_shield3);weaponType = 3;weaponC=2;}
        if (weaponId == 9){weapon_choose.setImageResource(R.drawable.legend_shield4);weaponType = 4;weaponC=2;}
        if (weaponId == 10){weapon_choose.setImageResource(R.drawable.legend_shield5);weaponType = 5;weaponC=2;}
        if (weaponId == 11){weapon_choose.setImageResource(R.drawable.legend_equip_gun1);weaponType = 1;weaponC=3;}
        if (weaponId == 12){weapon_choose.setImageResource(R.drawable.legend_equip_gun2);weaponType = 2;weaponC=3;}
        if (weaponId == 13){weapon_choose.setImageResource(R.drawable.legend_equip_gun3);weaponType = 3;weaponC=3;}
        if (weaponId == 14){weapon_choose.setImageResource(R.drawable.legend_equip_gun4);weaponType = 4;weaponC=3;}
        if (weaponId == 15){weapon_choose.setImageResource(R.drawable.legend_equip_gun5);weaponType = 5;weaponC=3;}

        if (weaponId == 0){weapon_a.setImageResource(R.drawable.blank_box_show);weapon_a2.setImageResource(R.drawable.blank_box_show);weaponType = 0;}
        if (weaponId == 1){weapon_a.setImageResource(R.drawable.legend_equip_katana1);weapon_a2.setImageResource(R.drawable.legend_equip_katana1);weaponType = 1;weaponC=1;}
        if (weaponId == 2){weapon_a.setImageResource(R.drawable.legend_equip_katana2);weapon_a2.setImageResource(R.drawable.legend_equip_katana2);weaponType = 2;weaponC=1;}
        if (weaponId == 3){weapon_a.setImageResource(R.drawable.legend_equip_katana3);weapon_a2.setImageResource(R.drawable.legend_equip_katana3);weaponType = 3;weaponC=1;}
        if (weaponId == 4){weapon_a.setImageResource(R.drawable.legend_equip_katana4);weapon_a2.setImageResource(R.drawable.legend_equip_katana4);weaponType = 4;weaponC=1;}
        if (weaponId == 5){weapon_a.setImageResource(R.drawable.legend_equip_katana5);weapon_a2.setImageResource(R.drawable.legend_equip_katana5);weaponType = 5;weaponC=1;}
        if (weaponId == 6){weapon_a.setImageResource(R.drawable.legend_shield1);weapon_a2.setImageResource(R.drawable.legend_shield1);weaponType = 6;weaponC=2;}
        if (weaponId == 7){weapon_a.setImageResource(R.drawable.legend_shield2);weapon_a2.setImageResource(R.drawable.legend_shield2);weaponType = 7;weaponC=2;}
        if (weaponId == 8){weapon_a.setImageResource(R.drawable.legend_shield3);weapon_a2.setImageResource(R.drawable.legend_shield3);weaponType = 8;weaponC=2;}
        if (weaponId == 9){weapon_a.setImageResource(R.drawable.legend_shield4);weapon_a2.setImageResource(R.drawable.legend_shield4);weaponType = 9;weaponC=2;}
        if (weaponId == 10){weapon_a.setImageResource(R.drawable.legend_shield5);weapon_a2.setImageResource(R.drawable.legend_shield5);weaponType = 10;weaponC=2;}
        if (weaponId == 11){weapon_a.setImageResource(R.drawable.legend_equip_gun1);weapon_a2.setImageResource(R.drawable.legend_equip_gun1);weaponType = 11;weaponC=3;}
        if (weaponId == 12){weapon_a.setImageResource(R.drawable.legend_equip_gun2);weapon_a2.setImageResource(R.drawable.legend_equip_gun2);weaponType = 12;weaponC=3;}
        if (weaponId == 13){weapon_a.setImageResource(R.drawable.legend_equip_gun3);weapon_a2.setImageResource(R.drawable.legend_equip_gun3);weaponType = 13;weaponC=3;}
        if (weaponId == 14){weapon_a.setImageResource(R.drawable.legend_equip_gun4);weapon_a2.setImageResource(R.drawable.legend_equip_gun4);weaponType = 14;weaponC=3;}
        if (weaponId == 15){weapon_a.setImageResource(R.drawable.legend_equip_gun5);weapon_a2.setImageResource(R.drawable.legend_equip_gun5);weaponType = 15;weaponC=3;}

        if (weaponId == 0){weapon_b.setImageResource(R.drawable.blank_box_show);weapon_b2.setImageResource(R.drawable.blank_box_show);weaponType = 0;}
        if (weaponId == 1){weapon_b.setImageResource(R.drawable.legend_equip_katana1);weapon_b2.setImageResource(R.drawable.legend_equip_katana2);weaponType = 1;weaponC=1;}
        if (weaponId == 2){weapon_b.setImageResource(R.drawable.legend_equip_katana2);weapon_b2.setImageResource(R.drawable.legend_equip_katana3);weaponType = 2;weaponC=1;}
        if (weaponId == 3){weapon_b.setImageResource(R.drawable.legend_equip_katana3);weapon_b2.setImageResource(R.drawable.legend_equip_katana4);weaponType = 3;weaponC=1;}
        if (weaponId == 4){weapon_b.setImageResource(R.drawable.legend_equip_katana4);weapon_b2.setImageResource(R.drawable.legend_equip_katana5);weaponType = 4;weaponC=1;}
        if (weaponId == 5){weapon_b.setImageResource(R.drawable.legend_equip_katana5);weapon_b2.setImageResource(R.drawable.blank_box_show);weaponType = 5;weaponC=1;}
        if (weaponId == 6){weapon_b.setImageResource(R.drawable.legend_shield1);weapon_b2.setImageResource(R.drawable.legend_shield2);weaponType = 6;weaponC=2;}
        if (weaponId == 7){weapon_b.setImageResource(R.drawable.legend_shield2);weapon_b2.setImageResource(R.drawable.legend_shield3);weaponType = 7;weaponC=2;}
        if (weaponId == 8){weapon_b.setImageResource(R.drawable.legend_shield3);weapon_b2.setImageResource(R.drawable.legend_shield4);weaponType = 8;weaponC=2;}
        if (weaponId == 9){weapon_b.setImageResource(R.drawable.legend_shield4);weapon_b2.setImageResource(R.drawable.legend_shield5);weaponType = 9;weaponC=2;}
        if (weaponId == 10){weapon_b.setImageResource(R.drawable.legend_shield5);weapon_b2.setImageResource(R.drawable.blank_box_show);weaponType = 10;weaponC=2;}
        if (weaponId == 11){weapon_b.setImageResource(R.drawable.legend_equip_gun1);weapon_b2.setImageResource(R.drawable.legend_equip_gun2);weaponType = 11;weaponC=3;}
        if (weaponId == 12){weapon_b.setImageResource(R.drawable.legend_equip_gun2);weapon_b2.setImageResource(R.drawable.legend_equip_gun3);weaponType = 12;weaponC=3;}
        if (weaponId == 13){weapon_b.setImageResource(R.drawable.legend_equip_gun3);weapon_b2.setImageResource(R.drawable.legend_equip_gun4);weaponType = 13;weaponC=3;}
        if (weaponId == 14){weapon_b.setImageResource(R.drawable.legend_equip_gun4);weapon_b2.setImageResource(R.drawable.legend_equip_gun5);weaponType = 14;weaponC=3;}
        if (weaponId == 15){weapon_b.setImageResource(R.drawable.legend_equip_gun5);weapon_b2.setImageResource(R.drawable.blank_box_show);weaponType = 15;weaponC=3;}

        if (weaponType == 1){now_seek.setProgress(1);}
        if (weaponType == 2){now_seek.setProgress(10);}
        if (weaponType == 3){now_seek.setProgress(20);}
        if (weaponType == 4){now_seek.setProgress(30);}
        if (weaponType == 5){now_seek.setProgress(40);}
        if (aim_seek.getProgress() <= now_seek.getProgress()){aim_seek.setProgress(now_seek.getProgress()+1);}
    }

    public void calculate() {
        now = now_seek.getProgress();
        aim = aim_seek.getProgress();

        /**
         * 20201019 21:44 --> total should 累加
         * total = weapon_lvl2;
         * total = weapon_lvl2+total = weapon_lvl3;
         * etc ...
         * --------------------------------------
         * Ingame Data List : Remember to input Boomer and Building lvl
         */
        if (now == 1)	{base = 0;}	;	if (aim == 2)	{total = weapon_lvl2;}
        if (now == 2)	{base = weapon_lvl2;}	;	if (aim == 3)	{total = weapon_lvl2 +	weapon_lvl3;	;}
        if (now == 3)	{base = weapon_lvl3;}	;	if (aim == 4)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	;}
        if (now == 4)	{base = weapon_lvl4;}	;	if (aim == 5)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	;}
        if (now == 5)	{base = weapon_lvl5;}	;	if (aim == 6)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	;}
        if (now == 6)	{base = weapon_lvl6;}	;	if (aim == 7)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	;}
        if (now == 7)	{base = weapon_lvl7;}	;	if (aim == 8)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	;}
        if (now == 8)	{base = weapon_lvl8;}	;	if (aim == 9)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	;}
        if (now == 9)	{base = weapon_lvl9;}	;	if (aim == 10)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	;}
        if (now == 10)	{base = weapon_lvl10;}	;	if (aim == 11)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	;}
        if (now == 11)	{base = weapon_lvl11;}	;	if (aim == 12)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	;}
        if (now == 12)	{base = weapon_lvl12;}	;	if (aim == 13)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	;}
        if (now == 13)	{base = weapon_lvl13;}	;	if (aim == 14)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	;}
        if (now == 14)	{base = weapon_lvl14;}	;	if (aim == 15)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	;}
        if (now == 15)	{base = weapon_lvl15;}	;	if (aim == 16)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16		;}
        if (now == 16)	{base = weapon_lvl16;}	;	if (aim == 17)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17		;}
        if (now == 17)	{base = weapon_lvl17;}	;	if (aim == 18)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18		;}
        if (now == 18)	{base = weapon_lvl18;}	;	if (aim == 19)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19		;}
        if (now == 19)	{base = weapon_lvl19;}	;	if (aim == 20)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20		;}
        if (now == 20)	{base = weapon_lvl20;}	;	if (aim == 21)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21		;}
        if (now == 21)	{base = weapon_lvl21;}	;	if (aim == 22)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22		;}
        if (now == 22)	{base = weapon_lvl22;}	;	if (aim == 23)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23		;}
        if (now == 23)	{base = weapon_lvl23;}	;	if (aim == 24)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24		;}
        if (now == 24)	{base = weapon_lvl24;}	;	if (aim == 25)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25		;}
        if (now == 25)	{base = weapon_lvl25;}	;	if (aim == 26)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26		;}
        if (now == 26)	{base = weapon_lvl26;}	;	if (aim == 27)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27		;}
        if (now == 27)	{base = weapon_lvl27;}	;	if (aim == 28)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28		;}
        if (now == 28)	{base = weapon_lvl28;}	;	if (aim == 29)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29		;}
        if (now == 29)	{base = weapon_lvl29;}	;	if (aim == 30)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30		;}
        if (now == 30)	{base = weapon_lvl30;}	;	if (aim == 31)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31		;}
        if (now == 31)	{base = weapon_lvl31;}	;	if (aim == 32)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32		;}
        if (now == 32)	{base = weapon_lvl32;}	;	if (aim == 33)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33		;}
        if (now == 33)	{base = weapon_lvl33;}	;	if (aim == 34)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34		;}
        if (now == 34)	{base = weapon_lvl34;}	;	if (aim == 35)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35		;}
        if (now == 35)	{base = weapon_lvl35;}	;	if (aim == 36)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36		;}
        if (now == 36)	{base = weapon_lvl36;}	;	if (aim == 37)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37		;}
        if (now == 37)	{base = weapon_lvl37;}	;	if (aim == 38)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37	 + weapon_lvl38	;}
        if (now == 38)	{base = weapon_lvl38;}	;	if (aim == 39)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37	 + weapon_lvl38	 + weapon_lvl39	;}
        if (now == 39)	{base = weapon_lvl39;}	;	if (aim == 40)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37	 + weapon_lvl38	 + weapon_lvl39	 + weapon_lvl40	;}
        if (now == 40)	{base = weapon_lvl40;}	;	if (aim == 41)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37	 + weapon_lvl38	 + weapon_lvl39	 + weapon_lvl40	 + weapon_lvl41	;}
        if (now == 41)	{base = weapon_lvl41;}	;	if (aim == 42)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37	 + weapon_lvl38	 + weapon_lvl39	 + weapon_lvl40	 + weapon_lvl41	 + weapon_lvl42	;}
        if (now == 42)	{base = weapon_lvl42;}	;	if (aim == 43)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37	 + weapon_lvl38	 + weapon_lvl39	 + weapon_lvl40	 + weapon_lvl41	 + weapon_lvl42	 + weapon_lvl43	;}
        if (now == 43)	{base = weapon_lvl43;}	;	if (aim == 44)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37	 + weapon_lvl38	 + weapon_lvl39	 + weapon_lvl40	 + weapon_lvl41	 + weapon_lvl42	 + weapon_lvl43	 + weapon_lvl44	;}
        if (now == 44)	{base = weapon_lvl44;}	;	if (aim == 45)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37	 + weapon_lvl38	 + weapon_lvl39	 + weapon_lvl40	 + weapon_lvl41	 + weapon_lvl42	 + weapon_lvl43	 + weapon_lvl44	 + weapon_lvl45	;}
        if (now == 45)	{base = weapon_lvl45;}	;	if (aim == 46)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37	 + weapon_lvl38	 + weapon_lvl39	 + weapon_lvl40	 + weapon_lvl41	 + weapon_lvl42	 + weapon_lvl43	 + weapon_lvl44	 + weapon_lvl45	 + weapon_lvl46	;}
        if (now == 46)	{base = weapon_lvl46;}	;	if (aim == 47)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37	 + weapon_lvl38	 + weapon_lvl39	 + weapon_lvl40	 + weapon_lvl41	 + weapon_lvl42	 + weapon_lvl43	 + weapon_lvl44	 + weapon_lvl45	 + weapon_lvl46	 + weapon_lvl47	;}
        if (now == 47)	{base = weapon_lvl47;}	;	if (aim == 48)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37	 + weapon_lvl38	 + weapon_lvl39	 + weapon_lvl40	 + weapon_lvl41	 + weapon_lvl42	 + weapon_lvl43	 + weapon_lvl44	 + weapon_lvl45	 + weapon_lvl46	 + weapon_lvl47	 + weapon_lvl48	;}
        if (now == 48)	{base = weapon_lvl48;}	;	if (aim == 49)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37	 + weapon_lvl38	 + weapon_lvl39	 + weapon_lvl40	 + weapon_lvl41	 + weapon_lvl42	 + weapon_lvl43	 + weapon_lvl44	 + weapon_lvl45	 + weapon_lvl46	 + weapon_lvl47	 + weapon_lvl48	 + weapon_lvl49	;}
        if (now == 49)	{base = weapon_lvl49;}	;	if (aim == 50)	{total = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37	 + weapon_lvl38	 + weapon_lvl39	 + weapon_lvl40	 + weapon_lvl41	 + weapon_lvl42	 + weapon_lvl43	 + weapon_lvl44	 + weapon_lvl45	 + weapon_lvl46	 + weapon_lvl47	 + weapon_lvl48	 + weapon_lvl49	 + weapon_lvl50	;}

        if (now == 2)	{total_e = weapon_lvl2;}
        if (now == 3)	{total_e = weapon_lvl3;}
        if (now == 4)	{total_e = weapon_lvl4;}
        if (now == 5)	{total_e = weapon_lvl5;}
        if (now == 6)	{total_e = weapon_lvl6;}
        if (now == 7)	{total_e = weapon_lvl7;}
        if (now == 8)	{total_e = weapon_lvl8;}
        if (now == 9)	{total_e = weapon_lvl9;}
        if (now == 10)	{total_e = weapon_lvl10;}
        if (now == 11)	{total_e = weapon_lvl11;}
        if (now == 12)	{total_e = weapon_lvl12;}
        if (now == 13)	{total_e = weapon_lvl13;}
        if (now == 14)	{total_e = weapon_lvl14;}
        if (now == 15)	{total_e = weapon_lvl15;}
        if (now == 16)	{total_e = weapon_lvl16;}
        if (now == 17)	{total_e = weapon_lvl17;}
        if (now == 18)	{total_e = weapon_lvl18;}
        if (now == 19)	{total_e = weapon_lvl19;}
        if (now == 20)	{total_e = weapon_lvl20;}
        if (now == 21)	{total_e = weapon_lvl21;}
        if (now == 22)	{total_e = weapon_lvl22;}
        if (now == 23)	{total_e = weapon_lvl23;}
        if (now == 24)	{total_e = weapon_lvl24;}
        if (now == 25)	{total_e = weapon_lvl25;}
        if (now == 26)	{total_e = weapon_lvl26;}
        if (now == 27)	{total_e = weapon_lvl27;}
        if (now == 28)	{total_e = weapon_lvl28;}
        if (now == 29)	{total_e = weapon_lvl29;}
        if (now == 30)	{total_e = weapon_lvl30;}
        if (now == 31)	{total_e = weapon_lvl31;}
        if (now == 32)	{total_e = weapon_lvl32;}
        if (now == 33)	{total_e = weapon_lvl33;}
        if (now == 34)	{total_e = weapon_lvl34;}
        if (now == 35)	{total_e = weapon_lvl35;}
        if (now == 36)	{total_e = weapon_lvl36;}
        if (now == 37)	{total_e = weapon_lvl37;}
        if (now == 38)	{total_e = weapon_lvl38;}
        if (now == 39)	{total_e = weapon_lvl39;}
        if (now == 40)	{total_e = weapon_lvl40;}
        if (now == 41)	{total_e = weapon_lvl41;}
        if (now == 42)	{total_e = weapon_lvl42;}
        if (now == 43)	{total_e = weapon_lvl43;}
        if (now == 44)	{total_e = weapon_lvl44;}
        if (now == 45)	{total_e = weapon_lvl45;}
        if (now == 46)	{total_e = weapon_lvl46;}
        if (now == 47)	{total_e = weapon_lvl47;}
        if (now == 48)	{total_e = weapon_lvl48;}
        if (now == 49)	{total_e = weapon_lvl49;}
        if (now == 50)	{total_e = weapon_lvl50;}

        if (now == 1)	{base = 0;}
        if (now == 2)	{base = weapon_lvl2;}
        if (now == 3)	{base = weapon_lvl2 +	weapon_lvl3;	;}
        if (now == 4)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	;}
        if (now == 5)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	;}
        if (now == 6)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	;}
        if (now == 7)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	;}
        if (now == 8)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	;}
        if (now == 9)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	;}
        if (now == 10)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	;}
        if (now == 11)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	;}
        if (now == 12)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	;}
        if (now == 13)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	;}
        if (now == 14)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	;}
        if (now == 15)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	;}
        if (now == 16)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16		;}
        if (now == 17)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17		;}
        if (now == 18)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18		;}
        if (now == 19)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19		;}
        if (now == 20)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20		;}
        if (now == 21)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21		;}
        if (now == 22)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22		;}
        if (now == 23)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23		;}
        if (now == 24)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24		;}
        if (now == 25)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25		;}
        if (now == 26)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26		;}
        if (now == 27)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27		;}
        if (now == 28)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28		;}
        if (now == 29)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29		;}
        if (now == 30)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30		;}
        if (now == 31)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31		;}
        if (now == 32)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32		;}
        if (now == 33)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33		;}
        if (now == 34)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34		;}
        if (now == 35)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35		;}
        if (now == 36)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36		;}
        if (now == 37)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37		;}
        if (now == 38)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37	 + weapon_lvl38	;}
        if (now == 39)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37	 + weapon_lvl38	 + weapon_lvl39	;}
        if (now == 40)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37	 + weapon_lvl38	 + weapon_lvl39	 + weapon_lvl40	;}
        if (now == 41)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37	 + weapon_lvl38	 + weapon_lvl39	 + weapon_lvl40	 + weapon_lvl41	;}
        if (now == 42)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37	 + weapon_lvl38	 + weapon_lvl39	 + weapon_lvl40	 + weapon_lvl41	 + weapon_lvl42	;}
        if (now == 43)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37	 + weapon_lvl38	 + weapon_lvl39	 + weapon_lvl40	 + weapon_lvl41	 + weapon_lvl42	 + weapon_lvl43	;}
        if (now == 44)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37	 + weapon_lvl38	 + weapon_lvl39	 + weapon_lvl40	 + weapon_lvl41	 + weapon_lvl42	 + weapon_lvl43	 + weapon_lvl44	;}
        if (now == 45)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37	 + weapon_lvl38	 + weapon_lvl39	 + weapon_lvl40	 + weapon_lvl41	 + weapon_lvl42	 + weapon_lvl43	 + weapon_lvl44	 + weapon_lvl45	;}
        if (now == 46)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37	 + weapon_lvl38	 + weapon_lvl39	 + weapon_lvl40	 + weapon_lvl41	 + weapon_lvl42	 + weapon_lvl43	 + weapon_lvl44	 + weapon_lvl45	 + weapon_lvl46	;}
        if (now == 47)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37	 + weapon_lvl38	 + weapon_lvl39	 + weapon_lvl40	 + weapon_lvl41	 + weapon_lvl42	 + weapon_lvl43	 + weapon_lvl44	 + weapon_lvl45	 + weapon_lvl46	 + weapon_lvl47	;}
        if (now == 48)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37	 + weapon_lvl38	 + weapon_lvl39	 + weapon_lvl40	 + weapon_lvl41	 + weapon_lvl42	 + weapon_lvl43	 + weapon_lvl44	 + weapon_lvl45	 + weapon_lvl46	 + weapon_lvl47	 + weapon_lvl48	;}
        if (now == 49)	{base = weapon_lvl2 +	weapon_lvl3	 + weapon_lvl4	 + weapon_lvl5	 + weapon_lvl6	 + weapon_lvl7	 + weapon_lvl8	 + weapon_lvl9	 + weapon_lvl10	 + weapon_lvl11	 + weapon_lvl12	 + weapon_lvl13	 + weapon_lvl14	 + weapon_lvl15	 + weapon_lvl16	 + weapon_lvl17	 + weapon_lvl18	 + weapon_lvl19	 + weapon_lvl20	 + weapon_lvl21	 + weapon_lvl22	 + weapon_lvl23	 + weapon_lvl24	 + weapon_lvl25	 + weapon_lvl26	 + weapon_lvl27	 + weapon_lvl28	 + weapon_lvl29	 + weapon_lvl30	 + weapon_lvl31	 + weapon_lvl32	 + weapon_lvl33	 + weapon_lvl34	 + weapon_lvl35	 + weapon_lvl36	 + weapon_lvl37	 + weapon_lvl38	 + weapon_lvl39	 + weapon_lvl40	 + weapon_lvl41	 + weapon_lvl42	 + weapon_lvl43	 + weapon_lvl44	 + weapon_lvl45	 + weapon_lvl46	 + weapon_lvl47	 + weapon_lvl48	 + weapon_lvl49	;}

        if (now == 1)	{base_e = weapon_lvl2;}	;
        if (now == 2)	{base_e = weapon_lvl3;}	;
        if (now == 3)	{base_e = weapon_lvl4;}	;
        if (now == 4)	{base_e = weapon_lvl5;}	;
        if (now == 5)	{base_e = weapon_lvl6;}	;
        if (now == 6)	{base_e = weapon_lvl7;}	;
        if (now == 7)	{base_e = weapon_lvl8;}	;
        if (now == 8)	{base_e = weapon_lvl9;}	;
        if (now == 9)	{base_e = weapon_lvl10;}	;
        if (now == 10)	{base_e = weapon_lvl11;}	;
        if (now == 11)	{base_e = weapon_lvl12;}	;
        if (now == 12)	{base_e = weapon_lvl13;}	;
        if (now == 13)	{base_e = weapon_lvl14;}	;
        if (now == 14)	{base_e = weapon_lvl15;}	;
        if (now == 15)	{base_e = weapon_lvl16;}	;
        if (now == 16)	{base_e = weapon_lvl17;}	;
        if (now == 17)	{base_e = weapon_lvl18;}	;
        if (now == 18)	{base_e = weapon_lvl19;}	;
        if (now == 19)	{base_e = weapon_lvl20;}	;
        if (now == 20)	{base_e = weapon_lvl21;}	;
        if (now == 21)	{base_e = weapon_lvl22;}	;
        if (now == 22)	{base_e = weapon_lvl23;}	;
        if (now == 23)	{base_e = weapon_lvl24;}	;
        if (now == 24)	{base_e = weapon_lvl25;}	;
        if (now == 25)	{base_e = weapon_lvl26;}	;
        if (now == 26)	{base_e = weapon_lvl27;}	;
        if (now == 27)	{base_e = weapon_lvl28;}	;
        if (now == 28)	{base_e = weapon_lvl29;}	;
        if (now == 29)	{base_e = weapon_lvl30;}	;
        if (now == 30)	{base_e = weapon_lvl31;}	;
        if (now == 31)	{base_e = weapon_lvl32;}	;
        if (now == 32)	{base_e = weapon_lvl33;}	;
        if (now == 33)	{base_e = weapon_lvl34;}	;
        if (now == 34)	{base_e = weapon_lvl35;}	;
        if (now == 35)	{base_e = weapon_lvl36;}	;
        if (now == 36)	{base_e = weapon_lvl37;}	;
        if (now == 37)	{base_e = weapon_lvl38;}	;
        if (now == 38)	{base_e = weapon_lvl39;}	;
        if (now == 39)	{base_e = weapon_lvl40;}	;
        if (now == 40)	{base_e = weapon_lvl41;}	;
        if (now == 41)	{base_e = weapon_lvl42;}	;
        if (now == 42)	{base_e = weapon_lvl43;}	;
        if (now == 43)	{base_e = weapon_lvl44;}	;
        if (now == 44)	{base_e = weapon_lvl45;}	;
        if (now == 45)	{base_e = weapon_lvl46;}	;
        if (now == 46)	{base_e = weapon_lvl47;}	;
        if (now == 47)	{base_e = weapon_lvl48;}	;
        if (now == 48)	{base_e = weapon_lvl49;}	;
        if (now == 49)	{base_e = weapon_lvl50;}	;



        exp_seek.setMax(base_e);
        exp = exp_seek.getProgress();

        result = total-exp-base;

        Log.i("total",prettyCount(total));
        Log.i("base",prettyCount(base));
        Log.i("exp",prettyCount(exp));
        Log.i("total_e",prettyCount(total_e));
        Log.i("base_e",prettyCount(base_e));

        Log.i("RESULT", String.valueOf(result));

        double fina = result;
        int a = result/100;
        int b = result/500;
        int c = result/1000;
        int d = result/2000;
        int e = result/5000;
        int f = result/10000;

        Log.i("XD", String.valueOf(fina/97));

        if (fina/100 > a &&fina/100>0 ){a = a+1;}
        if (fina/500 > b &&fina/500>0){b = b+1;}
        if (fina/1000 > c &&fina/1000>0){c = c+1;}
        if (fina/2000 > d &&fina/2000>0){d = d+1;}
        if (fina/5000 > e &&fina/5000>0){e = e+1;}
        if (fina/10000 > f &&fina/10000>0){f = f+1;}

        weapon_total.setText(prettyCount(fina));
        weapon_exp1.setText(prettyCount(a));
        weapon_exp2.setText(prettyCount(b));
        weapon_exp3.setText(prettyCount(c));
        weapon_exp4.setText(prettyCount(d));
        weapon_exp5.setText(prettyCount(e));
        weapon_exp6.setText(prettyCount(f));

      //int refine_sr = 0 , refine_diamond = 0 , refine_or = 0 , lvl_diamond = 0 , lvl_brs = 0 , lvlv_ors = 0 , lvl_ars = 0;
        TextView lvl_tv1 , lvl_tv2 , lvl_tv3 , lvl_tv4 , refine_tv1  ,refine_tv2 , refine_tv3 , refine_tv4;

        lvl_tv1 = findViewById(R.id.lvl_up_rare1_tv);
        lvl_tv2 = findViewById(R.id.lvl_up_rare2_tv);
        lvl_tv3 = findViewById(R.id.lvl_up_rare3_tv);
        lvl_tv4 = findViewById(R.id.lvl_up_rare4_tv);
        refine_tv1 = findViewById(R.id.refine_rare1_tv);
        refine_tv2 = findViewById(R.id.refine_rare2_tv);
        refine_tv3 = findViewById(R.id.refine_rare4_tv);
        refine_tv4 = findViewById(R.id.refine_rare5_tv);

        now_seek.setMax(50);
        aim_seek.setMax(50);

        ImageView refine_a = findViewById(R.id.refine_a_img);
        ImageView refine_a2 = findViewById(R.id.refine_b_img);

        if (weaponId == 0){refine_a.setImageResource(R.drawable.blank_box_show);refine_a2.setImageResource(R.drawable.blank_box_show);weaponType = 0;}
        if (weaponId == 1){refine_a.setImageResource(R.drawable.legend_equip_katana1);refine_a2.setImageResource(R.drawable.legend_equip_katana1);weaponType = 1;weaponC=1;}
        if (weaponId == 2){refine_a.setImageResource(R.drawable.legend_equip_katana2);refine_a2.setImageResource(R.drawable.legend_equip_katana2);weaponType = 2;weaponC=1;}
        if (weaponId == 3){refine_a.setImageResource(R.drawable.legend_equip_katana3);refine_a2.setImageResource(R.drawable.legend_equip_katana3);weaponType = 3;weaponC=1;}
        if (weaponId == 4){refine_a.setImageResource(R.drawable.legend_equip_katana4);refine_a2.setImageResource(R.drawable.legend_equip_katana4);weaponType = 4;weaponC=1;}
        if (weaponId == 5){refine_a.setImageResource(R.drawable.legend_equip_katana5);refine_a2.setImageResource(R.drawable.legend_equip_katana5);weaponType = 5;weaponC=1;}
        if (weaponId == 6){refine_a.setImageResource(R.drawable.legend_shield1);refine_a2.setImageResource(R.drawable.legend_shield1);weaponType = 6;weaponC=2;}
        if (weaponId == 7){refine_a.setImageResource(R.drawable.legend_shield2);refine_a2.setImageResource(R.drawable.legend_shield2);weaponType = 7;weaponC=2;}
        if (weaponId == 8){refine_a.setImageResource(R.drawable.legend_shield3);refine_a2.setImageResource(R.drawable.legend_shield3);weaponType = 8;weaponC=2;}
        if (weaponId == 9){refine_a.setImageResource(R.drawable.legend_shield4);refine_a2.setImageResource(R.drawable.legend_shield4);weaponType = 9;weaponC=2;}
        if (weaponId == 10){refine_a.setImageResource(R.drawable.legend_shield5);refine_a2.setImageResource(R.drawable.legend_shield5);weaponType = 10;weaponC=2;}
        if (weaponId == 11){refine_a.setImageResource(R.drawable.legend_equip_gun1);refine_a2.setImageResource(R.drawable.legend_equip_gun1);weaponType = 11;weaponC=3;}
        if (weaponId == 12){refine_a.setImageResource(R.drawable.legend_equip_gun2);refine_a2.setImageResource(R.drawable.legend_equip_gun2);weaponType = 12;weaponC=3;}
        if (weaponId == 13){refine_a.setImageResource(R.drawable.legend_equip_gun3);refine_a2.setImageResource(R.drawable.legend_equip_gun3);weaponType = 13;weaponC=3;}
        if (weaponId == 14){refine_a.setImageResource(R.drawable.legend_equip_gun4);refine_a2.setImageResource(R.drawable.legend_equip_gun4);weaponType = 14;weaponC=3;}
        if (weaponId == 15){refine_a.setImageResource(R.drawable.legend_equip_gun5);refine_a2.setImageResource(R.drawable.legend_equip_gun5);weaponType = 15;weaponC=3;}

        // Lvl_Update Part
        if (weaponType == 1|weaponType == 6|weaponType == 11){lvl_tv1.setText(prettyCount(diamond_ut10));lvl_tv2.setText(prettyCount(brs_ut10));lvl_tv3.setText(prettyCount(ors_ut10));lvl_tv4.setText(prettyCount(ars_ut10));}
        if (weaponType == 2|weaponType == 7|weaponType == 12){lvl_tv1.setText(prettyCount(diamond_ut20));lvl_tv2.setText(prettyCount(brs_ut20));lvl_tv3.setText(prettyCount(ors_ut20));lvl_tv4.setText(prettyCount(ars_ut20));}
        if (weaponType == 3|weaponType == 8|weaponType == 13){lvl_tv1.setText(prettyCount(diamond_ut30));lvl_tv2.setText(prettyCount(brs_ut30));lvl_tv3.setText(prettyCount(ors_ut30));lvl_tv4.setText(prettyCount(ars_ut30));}
        if (weaponType == 4|weaponType == 9|weaponType == 14){lvl_tv1.setText(prettyCount(diamond_ut40));lvl_tv2.setText(prettyCount(brs_ut40));lvl_tv3.setText(prettyCount(ors_ut40));lvl_tv4.setText(prettyCount(ars_ut40));}
        if (weaponType == 5|weaponType == 10|weaponType == 15){lvl_tv1.setText(prettyCount(0));lvl_tv2.setText(prettyCount(0));lvl_tv3.setText(prettyCount(0));lvl_tv4.setText(prettyCount(0));}

        if (weaponType == 1|weaponType == 6|weaponType == 11){refine_tv1.setText(prettyCount(diamond_remode_ut0));refine_tv2.setText(prettyCount(sr_ut0));refine_tv3.setText(prettyCount(diamond_remode_ut0));refine_tv4.setText(prettyCount(or_ut0));}
        if (weaponType == 2|weaponType == 7|weaponType == 12){refine_tv1.setText(prettyCount(diamond_remode_ut1));refine_tv2.setText(prettyCount(sr_ut1));refine_tv3.setText(prettyCount(diamond_remode_ut1));refine_tv4.setText(prettyCount(or_ut1));}
        if (weaponType == 3|weaponType == 8|weaponType == 13){refine_tv1.setText(prettyCount(diamond_remode_ut2));refine_tv2.setText(prettyCount(sr_ut2));refine_tv3.setText(prettyCount(diamond_remode_ut2));refine_tv4.setText(prettyCount(or_ut2));}
        if (weaponType == 4|weaponType == 9|weaponType == 14){refine_tv1.setText(prettyCount(diamond_remode_ut3));refine_tv2.setText(prettyCount(sr_ut3));refine_tv3.setText(prettyCount(diamond_remode_ut3));refine_tv4.setText(prettyCount(or_ut3));}
        if (weaponType == 5|weaponType == 10|weaponType == 15){refine_tv1.setText(prettyCount(diamond_remode_ut4));refine_tv2.setText(prettyCount(sr_ut4));refine_tv3.setText(prettyCount(diamond_remode_ut4));refine_tv4.setText(prettyCount(or_ut4));}

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
    public void pageChange (View view) {
        ScrollView upgrade  ,lvl_up , refine ;
        upgrade = findViewById(R.id.upgrade);
        lvl_up = findViewById(R.id.lvl_up);
        refine = findViewById(R.id.refine);

        upgrade.setVisibility(View.INVISIBLE);
        lvl_up.setVisibility(View.INVISIBLE);
        refine.setVisibility(View.INVISIBLE);

        switch (view.getId())
        {
            case R.id.radioButton0:
                upgrade.setVisibility(View.VISIBLE);
                break;
            case R.id.radioButton1:
                lvl_up.setVisibility(View.VISIBLE);

                break;
            case R.id.radioButton2:
                refine.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

}