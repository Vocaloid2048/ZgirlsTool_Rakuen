package voc.net.tools.zgirls_tool.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.R;

public class StarActivity extends AppCompatActivity {

    LinearLayout tabLayout ;
    ScrollView scrollView ;

     boolean lvl1_open = false ;
     boolean lvl2_open = false ;
     boolean lvl3_open = false ;
     boolean lvl4_open = false ;
     boolean lvl5_open = false ;
     boolean lvl6_open = false ;

    int 	I	=	1	;
    int 	II	=	2	;
    int 	III	=	4	;
    int 	IV	=	8	;
    int 	V	=	16	;
    int 	VI	=	32	;
    int 	VII	=	64	;
    int 	VIII	=	128	;
    int 	IX	=	256	;
    int 	X	=	512	;
    int 	XI	=	1024	;
    int 	XII	=	2048	;
    int 	XIII	=	4096	;
    int 	XIV	=	8192	;
    int 	XV	=	16384	;
    int 	XVI	=	32768	;
    int 	XVII	=	65536	;
    int 	XVIII	=	131072	;
    int 	XIX	=	262144	;
    int 	XX	=	524288	;
    int 	XXI	=	1048576	;
    int 	XXII	=	2097152	;
    int 	XXIII	=	4194304	;
    int 	XXIV	=	8388608	;
    int 	XXV	=	16777216	;

    LinearLayout lvl1 , lvl2 , lvl3 , lvl4 , lvl5 , lvl6 ;

    TextView star01,	star02,	star03,	star04,	star05,	star06,	star07,	star08,	star09,	star10,	star11,	star12,	star13,	star14,	star15,	star16,	star17,	star18,	star19,	star20,	star21,	star22,	star23,	star24,	star25;

    CheckBox cb1,	cb2,	cb3,	cb4,	cb5,	cb6,	cb7,	cb8,	cb9,	cb10,	cb11,	cb12,	cb13,	cb14,	cb15,	cb16,	cb17,	cb18,	cb19,	cb20,	cb21,	cb22,	cb23,	cb24,	cb25,	cb26,	cb27,	cb28,	cb29,	cb30,	cb31;

    TextView	total01,	total02,	total03,	total04,	total05,	total06,	total07,	total08,	total09,	total10,	total11,	total12,	total13,	total14,	total15,	total16,	total17,	total18,	total19,	total20,	total21,	total22,	total23,	total24,	total25,	total26,	total27,	total28,	total29,	total30,	total31;

    Button  choose , have ;

    LinearLayout choose_l , have_l ;

    String choosed ;

    int total_star = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);

        BackgroundReload();

         lvl1 = findViewById(R.id.star_lvl1);
         lvl2 = findViewById(R.id.star_lvl2);
         lvl3 = findViewById(R.id.star_lvl3);
         lvl4 = findViewById(R.id.star_lvl4);
         lvl5 = findViewById(R.id.star_lvl5);
         lvl6 = findViewById(R.id.star_lvl6);
         tabLayout = findViewById(R.id.tabLayout);
         scrollView = findViewById(R.id.scrollView);

         have = findViewById(R.id.star_have_btn);
         choose = findViewById(R.id.star_choose_btn);

         have_l = findViewById(R.id.star_have);
         choose_l = findViewById(R.id.star_choose);

        star01 = findViewById(R.id.	star01_tv);
        star02 = findViewById(R.id.	star02_tv);
        star03 = findViewById(R.id.	star03_tv);
        star04 = findViewById(R.id.	star04_tv);
        star05 = findViewById(R.id.	star05_tv);
        star06 = findViewById(R.id.	star06_tv);
        star07 = findViewById(R.id.	star07_tv);
        star08 = findViewById(R.id.	star08_tv);
        star09 = findViewById(R.id.	star09_tv);
        star10 = findViewById(R.id.	star10_tv);
        star11 = findViewById(R.id.	star11_tv);
        star12 = findViewById(R.id.	star12_tv);
        star13 = findViewById(R.id.	star13_tv);
        star14 = findViewById(R.id.	star14_tv);
        star15 = findViewById(R.id.	star15_tv);
        star16 = findViewById(R.id.	star16_tv);
        star17 = findViewById(R.id.	star17_tv);
        star18 = findViewById(R.id.	star18_tv);
        star19 = findViewById(R.id.	star19_tv);
        star20 = findViewById(R.id.	star20_tv);
        star21 = findViewById(R.id.	star21_tv);
        star22 = findViewById(R.id.	star22_tv);
        star23 = findViewById(R.id.	star23_tv);
        star24 = findViewById(R.id.	star24_tv);
        star25 = findViewById(R.id.	star25_tv);

        cb1 = findViewById(R.id.	cb1);
        cb2 = findViewById(R.id.	cb2);
        cb3 = findViewById(R.id.	cb3);
        cb4 = findViewById(R.id.	cb4);
        cb5 = findViewById(R.id.	cb5);
        cb6 = findViewById(R.id.	cb6);
        cb7 = findViewById(R.id.	cb7);
        cb8 = findViewById(R.id.	cb8);
        cb9 = findViewById(R.id.	cb9);
        cb10 = findViewById(R.id.	cb10);
        cb11 = findViewById(R.id.	cb11);
        cb12 = findViewById(R.id.	cb12);
        cb13 = findViewById(R.id.	cb13);
        cb14 = findViewById(R.id.	cb14);
        cb15 = findViewById(R.id.	cb15);
        cb16 = findViewById(R.id.	cb16);
        cb17 = findViewById(R.id.	cb17);
        cb18 = findViewById(R.id.	cb18);
        cb19 = findViewById(R.id.	cb19);
        cb20 = findViewById(R.id.	cb20);
        cb21 = findViewById(R.id.	cb21);
        cb22 = findViewById(R.id.	cb22);
        cb23 = findViewById(R.id.	cb23);
        cb24 = findViewById(R.id.	cb24);
        cb25 = findViewById(R.id.	cb25);
        cb26 = findViewById(R.id.	cb26);
        cb27 = findViewById(R.id.	cb27);
        cb28 = findViewById(R.id.	cb28);
        cb29 = findViewById(R.id.	cb29);
        cb30 = findViewById(R.id.	cb30);
        cb31 = findViewById(R.id.	cb31);

        total01 = findViewById(R.id.	total_1);
        total02 = findViewById(R.id.	total_2);
        total03 = findViewById(R.id.	total_3);
        total04 = findViewById(R.id.	total_4);
        total05 = findViewById(R.id.	total_5);
        total06 = findViewById(R.id.	total_6);
        total07 = findViewById(R.id.	total_7);
        total08 = findViewById(R.id.	total_8);
        total09 = findViewById(R.id.	total_9);
        total10 = findViewById(R.id.	total_10);
        total11 = findViewById(R.id.	total_11);
        total12 = findViewById(R.id.	total_12);
        total13 = findViewById(R.id.	total_13);
        total14 = findViewById(R.id.	total_14);
        total15 = findViewById(R.id.	total_15);
        total16 = findViewById(R.id.	total_16);
        total17 = findViewById(R.id.	total_17);
        total18 = findViewById(R.id.	total_18);
        total19 = findViewById(R.id.	total_19);
        total20 = findViewById(R.id.	total_20);
        total21 = findViewById(R.id.	total_21);
        total22 = findViewById(R.id.	total_22);
        total23 = findViewById(R.id.	total_23);
        total24 = findViewById(R.id.	total_24);
        total25 = findViewById(R.id.	total_25);
        total26 = findViewById(R.id.	total_26);
        total27 = findViewById(R.id.	total_27);
        total28 = findViewById(R.id.	total_28);
        total29 = findViewById(R.id.	total_29);
        total30 = findViewById(R.id.	total_30);
        total31 = findViewById(R.id.	total_31);

        total01.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	I	+	IV					)));
        total02.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	II	+	VII					)));
        total03.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	II	+	IV	+	VIII			)));
        total04.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	IV	+	VI	+	IX			)));
        total05.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	III	+	VI	+	X			)));
        total06.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	VI	+	IX	+	XI			)));
        total07.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	III	+	X	+	XII			)));
        total08.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	VIII	+	XI	+	XII			)));
        total09.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	IX	+	XI	+	XIII			)));
        total10.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	VI	+	X	+	XIV			)));
        total11.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	VIII	+	XIII	+	XIV			)));
        total12.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	IX	+	XII	+	XIV			)));
        total13.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	III	+	IV	+	XV			)));
        total14.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	IV	+	XIV	+	XV			)));
        total15.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	II	+	V	+	VIII	+	XVI	)));
        total16.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	IV	+	VIII	+	XIV	+	XVI	)));
        total17.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	II	+	VIII	+	XIII	+	XV	)));
        total18.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	III	+	V	+	IX	+	XVII	)));
        total19.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	VI	+	X	+	XV	+	XVII	)));
        total20.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	IX	+	XIV	+	XVI	+	XVII	)));
        total21.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	III	+	XIII	+	XV	+	XVI	)));
        total22.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	IV	+	VIII	+	XV	+	XVIII	)));
        total23.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	III	+	VI	+	XVII	+	XVIII	)));
        total24.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	II	+	IV	+	VII	+	XVIII	)));
        total25.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	V	+	VI	+	X	+	XIX	)));
        total26.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	V	+	XV	+	XVII	+	XIX	)));
        total27.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	V	+	XIV	+	XVIII	+	XIX	)));
        total28.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	XV	+	XVII	+	XVIII	+	XIX	)));
        total29.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	IV	+	V	+	XVII	+	XX	)));
        total30.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	XIV	+	XVII	+	XVIII	+	XX	)));
        total31.setText(getString(R.string.tb_star)+" I : "+(prettyCount(	XII	+	XIV	+	XVII	+	XX	)));


        total01.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total02.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total03.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total04.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total05.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total06.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total07.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total08.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total09.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total10.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total11.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total12.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total13.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total14.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total15.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total16.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total17.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total18.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total19.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total20.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total21.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total22.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total23.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total24.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total25.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total26.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total27.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total28.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total29.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total30.setTextColor(getResources().getColor(R.color.colorPinkyful));
        total31.setTextColor(getResources().getColor(R.color.colorPinkyful));


    }

    public void star_lvl1 (View view) { if (!lvl1_open){ lvl1.setVisibility(View.VISIBLE); lvl1_open = true;} else { lvl1.setVisibility(View.GONE);lvl1_open = false;} }
    public void star_lvl2 (View view) { if (!lvl2_open){ lvl2.setVisibility(View.VISIBLE); lvl2_open = true;} else { lvl2.setVisibility(View.GONE);lvl2_open = false;} }
    public void star_lvl3 (View view) { if (!lvl3_open){ lvl3.setVisibility(View.VISIBLE); lvl3_open = true;} else { lvl3.setVisibility(View.GONE);lvl3_open = false;} }
    public void star_lvl4 (View view) { if (!lvl4_open){ lvl4.setVisibility(View.VISIBLE); lvl4_open = true;} else { lvl4.setVisibility(View.GONE);lvl4_open = false;} }
    public void star_lvl5 (View view) { if (!lvl5_open){ lvl5.setVisibility(View.VISIBLE); lvl5_open = true; } else { lvl5.setVisibility(View.GONE);lvl5_open = false;} }
    public void star_lvl6 (View view) { if (!lvl6_open){ lvl6.setVisibility(View.VISIBLE); lvl6_open = true;} else { lvl6.setVisibility(View.GONE);lvl6_open = false;} }

    public void have (View view) {  have_l.setVisibility(View.VISIBLE);choose_l.setVisibility(View.GONE);have.setTextColor(getResources().getColor(R.color.colorPinkyful));choose.setTextColor(getResources().getColor(R.color.colorWhite));}
    public void choose (View view) {choose_l.setVisibility(View.VISIBLE);have_l.setVisibility(View.GONE);choose.setTextColor(getResources().getColor(R.color.colorPinkyful));have.setTextColor(getResources().getColor(R.color.colorWhite));}
    public void BackgroundReload (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.star_bg);

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

        total_star = 0 ;
        choosed = "";

        if (cb1.isChecked()){total_star = total_star +	I	+	IV					;	choosed = choosed+getString(R.string.star01)+"  ->  "+(	I	+	IV	)+" "+getString(R.string.gwo)+"\n";}
        if (cb2.isChecked()){total_star = total_star +	II	+	VII					;	choosed = choosed+getString(R.string.star02)+"  ->  "+(	II	+	VII	)+" "+getString(R.string.gwo)+"\n";}
        if (cb3.isChecked()){total_star = total_star +	II	+	IV	+	VIII			;	choosed = choosed+getString(R.string.star03)+"  ->  "+(	II	+	IV	+	VIII	)+" "+getString(R.string.gwo)+"\n";}
        if (cb4.isChecked()){total_star = total_star +	IV	+	VI	+	IX			;	choosed = choosed+getString(R.string.star04)+"  ->  "+(	IV	+	VI	+	IX	)+" "+getString(R.string.gwo)+"\n";}
        if (cb5.isChecked()){total_star = total_star +	III	+	VI	+	X			;	choosed = choosed+getString(R.string.star05)+"  ->  "+(	III	+	VI	+	X	)+" "+getString(R.string.gwo)+"\n";}
        if (cb6.isChecked()){total_star = total_star +	VI	+	IX	+	XI			;	choosed = choosed+getString(R.string.star06)+"  ->  "+(	VI	+	IX	+	XI	)+" "+getString(R.string.gwo)+"\n";}
        if (cb7.isChecked()){total_star = total_star +	III	+	X	+	XII			;	choosed = choosed+getString(R.string.star07)+"  ->  "+(	III	+	X	+	XII	)+" "+getString(R.string.gwo)+"\n";}
        if (cb8.isChecked()){total_star = total_star +	VIII	+	XI	+	XII			;	choosed = choosed+getString(R.string.star08)+"  ->  "+(	VIII	+	XI	+	XII	)+" "+getString(R.string.gwo)+"\n";}
        if (cb9.isChecked()){total_star = total_star +	IX	+	XI	+	XIII			;	choosed = choosed+getString(R.string.star09)+"  ->  "+(	IX	+	XI	+	XIII	)+" "+getString(R.string.gwo)+"\n";}
        if (cb10.isChecked()){total_star = total_star +	VI	+	X	+	XIV			;	choosed = choosed+getString(R.string.star10)+"  ->  "+(	VI	+	X	+	XIV	)+" "+getString(R.string.gwo)+"\n";}
        if (cb11.isChecked()){total_star = total_star +	VIII	+	XIII	+	XIV			;	choosed = choosed+getString(R.string.star11)+"  ->  "+(	VIII	+	XIII	+	XIV	)+" "+getString(R.string.gwo)+"\n";}
        if (cb12.isChecked()){total_star = total_star +	IX	+	XII	+	XIV			;	choosed = choosed+getString(R.string.star12)+"  ->  "+(	IX	+	XII	+	XIV	)+" "+getString(R.string.gwo)+"\n";}
        if (cb13.isChecked()){total_star = total_star +	III	+	IV	+	XV			;	choosed = choosed+getString(R.string.star13)+"  ->  "+(	III	+	IV	+	XV	)+" "+getString(R.string.gwo)+"\n";}
        if (cb14.isChecked()){total_star = total_star +	IV	+	XIV	+	XV			;	choosed = choosed+getString(R.string.star14)+"  ->  "+(	IV	+	XIV	+	XV	)+" "+getString(R.string.gwo)+"\n";}
        if (cb15.isChecked()){total_star = total_star +	II	+	V	+	VIII	+	XVI	;	choosed = choosed+getString(R.string.star15)+"  ->  "+(	II	+	V	+	VIII	+	XVI	)+" "+getString(R.string.gwo)+"\n";}
        if (cb16.isChecked()){total_star = total_star +	IV	+	VIII	+	XIV	+	XVI	;	choosed = choosed+getString(R.string.star16)+"  ->  "+(	IV	+	VIII	+	XIV	+	XVI	)+" "+getString(R.string.gwo)+"\n";}
        if (cb17.isChecked()){total_star = total_star +	II	+	VIII	+	XIII	+	XV	;	choosed = choosed+getString(R.string.star17)+"  ->  "+(	II	+	VIII	+	XIII	+	XV	)+" "+getString(R.string.gwo)+"\n";}
        if (cb18.isChecked()){total_star = total_star +	III	+	V	+	IX	+	XVII	;	choosed = choosed+getString(R.string.star18)+"  ->  "+(	III	+	V	+	IX	+	XVII	)+" "+getString(R.string.gwo)+"\n";}
        if (cb19.isChecked()){total_star = total_star +	VI	+	X	+	XV	+	XVII	;	choosed = choosed+getString(R.string.star19)+"  ->  "+(	VI	+	X	+	XV	+	XVII	)+" "+getString(R.string.gwo)+"\n";}
        if (cb20.isChecked()){total_star = total_star +	IX	+	XIV	+	XVI	+	XVII	;	choosed = choosed+getString(R.string.star20)+"  ->  "+(	IX	+	XIV	+	XVI	+	XVII	)+" "+getString(R.string.gwo)+"\n";}
        if (cb21.isChecked()){total_star = total_star +	III	+	XIII	+	XV	+	XVI	;	choosed = choosed+getString(R.string.star21)+"  ->  "+(	III	+	XIII	+	XV	+	XVI	)+" "+getString(R.string.gwo)+"\n";}
        if (cb22.isChecked()){total_star = total_star +	IV	+	VIII	+	XV	+	XVIII	;	choosed = choosed+getString(R.string.star22)+"  ->  "+(	IV	+	VIII	+	XV	+	XVIII	)+" "+getString(R.string.gwo)+"\n";}
        if (cb23.isChecked()){total_star = total_star +	III	+	VI	+	XVII	+	XVIII	;	choosed = choosed+getString(R.string.star23)+"  ->  "+(	III	+	VI	+	XVII	+	XVIII	)+" "+getString(R.string.gwo)+"\n";}
        if (cb24.isChecked()){total_star = total_star +	II	+	IV	+	VII	+	XVIII	;	choosed = choosed+getString(R.string.star24)+"  ->  "+(	II	+	IV	+	VII	+	XVIII	)+" "+getString(R.string.gwo)+"\n";}
        if (cb25.isChecked()){total_star = total_star +	V	+	VI	+	X	+	XIX	;	choosed = choosed+getString(R.string.star25)+"  ->  "+(	V	+	VI	+	X	+	XIX	)+" "+getString(R.string.gwo)+"\n";}
        if (cb26.isChecked()){total_star = total_star +	V	+	XV	+	XVII	+	XIX	;	choosed = choosed+getString(R.string.star26)+"  ->  "+(	V	+	XV	+	XVII	+	XIX	)+" "+getString(R.string.gwo)+"\n";}
        if (cb27.isChecked()){total_star = total_star +	V	+	XIV	+	XVIII	+	XIX	;	choosed = choosed+getString(R.string.star27)+"  ->  "+(	V	+	XIV	+	XVIII	+	XIX	)+" "+getString(R.string.gwo)+"\n";}
        if (cb28.isChecked()){total_star = total_star +	XV	+	XVII	+	XVIII	+	XIX	;	choosed = choosed+getString(R.string.star28)+"  ->  "+(	XV	+	XVII	+	XVIII	+	XIX	)+" "+getString(R.string.gwo)+"\n";}
        if (cb29.isChecked()){total_star = total_star +	IV	+	V	+	XVII	+	XX	;	choosed = choosed+getString(R.string.star29)+"  ->  "+(	IV	+	V	+	XVII	+	XX	)+" "+getString(R.string.gwo)+"\n";}
        if (cb30.isChecked()){total_star = total_star +	XIV	+	XVII	+	XVIII	+	XX	;	choosed = choosed+getString(R.string.star30)+"  ->  "+(	XIV	+	XVII	+	XVIII	+	XX	)+" "+getString(R.string.gwo)+"\n";}
        if (cb31.isChecked()){total_star = total_star +	XII	+	XIV	+	XVII	+	XX	;	choosed = choosed+getString(R.string.star31)+"  ->  "+(	XII	+	XIV	+	XVII	+	XX	)+" "+getString(R.string.gwo)+"\n";}



        androidx.appcompat.app.AlertDialog.Builder builder = new AlertDialog.Builder(
                this);
        builder.setTitle(getString(R.string.public_you_need)+" "+prettyCount(total_star)+getString(R.string.gwo)+" ("+getString(R.string.tb_star) +" I )") // 标题
                .setIcon(R.drawable.app_icon_round) // icon
                .setMessage(getString(R.string.public_you_choose)+"\n"+choosed);//"Happy Birthday"
        builder.show();

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
