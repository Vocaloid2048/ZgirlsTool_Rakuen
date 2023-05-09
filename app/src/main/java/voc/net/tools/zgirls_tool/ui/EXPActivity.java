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
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.R;
import voc.net.tools.zgirls_tool.util.ScreenSizeUtils;

public class EXPActivity extends AppCompatActivity {

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

    ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;

    EditText  enabler_exp  ;
    SeekBar now_seek , aim_seek ;
    CheckBox buff_exp ;
    TextView exp_total , exp_1 ,	exp_2 ,	exp_3 ,	exp_4 ,	exp_5 ,	exp_6 ,	exp_7 ;
    TextView now_exp , aim_tv ;

    TextView HEROA_TV ;

    double total_exp;

    String hero_a ;
    int now=0 , aim=0;
    long exp_inside = 0 ;
    ImageView HEROA ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp);

        listView = findViewById(R.id.list_exp);

        exp_total = findViewById(R.id.exp_total_et)	;
        exp_1 = findViewById(R.id.exp_1_et)	;
        exp_2 = findViewById(R.id.exp_2_et)	;
        exp_3 = findViewById(R.id.exp_3_et)	;
        exp_4 = findViewById(R.id.exp_4_et)	;
        exp_5 = findViewById(R.id.exp_5_et)	;
        exp_6 = findViewById(R.id.exp_6_et)	;
        exp_7 = findViewById(R.id.exp_7_et)	;

        now_seek = findViewById(R.id.now_seek);
        aim_seek = findViewById(R.id.aim_seek);
        now_exp = findViewById(R.id.now_seek_tv);
        aim_tv = findViewById(R.id.aim_seek_tv);
        buff_exp = findViewById(R.id.exp_cb);
        enabler_exp = findViewById(R.id.expc_aim_et);

        HEROA_TV = findViewById(R.id.hero_a_tv);
        HEROA = findViewById(R.id.hero_a);

        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.list_tv, arrayList);
        listView.setAdapter(adapter);
        buff_exp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
        now_seek.setMax(0);
        aim_seek.setMax(0);
        enabler_exp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                calculate();
            }
        });
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
                if (now_seek.getProgress() < 15){now_seek.setProgress(15);}
                now = now_seek.getProgress();
                aim = aim_seek.getProgress();
                now_exp.setText(prettyCount(now));
                aim_tv.setText(prettyCount(aim));
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
                if (now_seek.getProgress() < 15){now_seek.setProgress(15);}
                now = now_seek.getProgress();
                aim = aim_seek.getProgress();
                now_exp.setText(prettyCount(now));
                aim_tv.setText(prettyCount(aim));
                calculate();
            }
        });

        BackgroundReload();
    }
    public void BackgroundReload (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.exp_bg);

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

    public void hero_a (View view){
        final Dialog dialog = new Dialog(this, R.style.NormalDialogStyle_N);
        view = View.inflate(this, R.layout.enabler_choose, null);

        SharedPreferences sharedPreferences = getSharedPreferences("json_data", Context.MODE_PRIVATE);
        now_seek.setMax(49);
        aim_seek.setMax(50);
        ImageView	akiyama	=	view.findViewById(R.id.	akiyama	);
        ImageView	alice	=	view.findViewById(R.id.	alice	);
        ImageView	ana_o	=	view.findViewById(R.id.	ana_o	);
        ImageView	carol	=	view.findViewById(R.id.	carol	);
        ImageView	catherine	=	view.findViewById(R.id.	catherine	);
        ImageView	celesia	=	view.findViewById(R.id.	celesia	);
        ImageView	chen	=	view.findViewById(R.id.	chen	);
        ImageView	chika	=	view.findViewById(R.id.	chika	);
        ImageView	chiyo	=	view.findViewById(R.id.	chiyo	);
        ImageView	comet	=	view.findViewById(R.id.	comet	);
        ImageView	donner	=	view.findViewById(R.id.	donner	);
        ImageView	eleanor	=	view.findViewById(R.id.	eleanor	);
        ImageView	esther	=	view.findViewById(R.id.	esther	);
        ImageView	fudo	=	view.findViewById(R.id.	fudo	);
        ImageView	gin	=	view.findViewById(R.id.	gin	);
        ImageView	hiyori	=	view.findViewById(R.id.	hiyori	);
        ImageView	iris	=	view.findViewById(R.id.	iris	);
        ImageView	kayo	=	view.findViewById(R.id.	kayo	);
        ImageView	kirine	=	view.findViewById(R.id.	kirine	);
        ImageView	kuroda	=	view.findViewById(R.id.	kuroda	);
        ImageView	kurul	=	view.findViewById(R.id.	kurul	);
        ImageView	lois	=	view.findViewById(R.id.	lois	);
        ImageView	izumi	=	view.findViewById(R.id.	lzumi	);
        ImageView	liuk	=	view.findViewById(R.id.	liuk	);
        ImageView	masami	=	view.findViewById(R.id.	masami	);
        ImageView	mika	=	view.findViewById(R.id.	mika	);
        ImageView	minami	=	view.findViewById(R.id.	minami	);
        ImageView	mio	=	view.findViewById(R.id.	mio	);
        ImageView	mira	=	view.findViewById(R.id.	mira	);
        ImageView	misaki	=	view.findViewById(R.id.	misaki	);
        ImageView	nana	=	view.findViewById(R.id.	nana	);
        ImageView	narumi	=	view.findViewById(R.id.	narumi	);
        ImageView	odelia	=	view.findViewById(R.id.	odelia	);
        ImageView	raly	=	view.findViewById(R.id.	raly	);
        ImageView	risa	=	view.findViewById(R.id.	risa	);
        ImageView	saki	=	view.findViewById(R.id.	saki	);
        ImageView	saori	=	view.findViewById(R.id.	saori	);
        ImageView	sara	=	view.findViewById(R.id.	sara	);
        ImageView	sariko	=	view.findViewById(R.id.	sariko	);
        ImageView	shiori	=	view.findViewById(R.id.	shiori	);
        ImageView	shirley	=	view.findViewById(R.id.	shirley	);
        ImageView	sumika	=	view.findViewById(R.id.	sumika	);
        ImageView	sylvia	=	view.findViewById(R.id.	sylvia	);
        ImageView	uzuki	=	view.findViewById(R.id.	uzuki	);
        ImageView	yesi	=	view.findViewById(R.id.	yesi	);
        ImageView	youko	=	view.findViewById(R.id.	youko	);
        ImageView	zero	=	view.findViewById(R.id.	zero	);
        ImageView	zrs2	=	view.findViewById(R.id.	zrs2	);

        ImageView	sp_sara	=	view.findViewById(R.id.	sp_sara	);
        ImageView	yui	=	view.findViewById(R.id.	yui	);
        ImageView	demoZ	=	view.findViewById(R.id.	demoZ	);

        akiyama	.setVisibility(View.VISIBLE);
        alice	.setVisibility(View.VISIBLE);
        ana_o	.setVisibility(View.VISIBLE);
        carol	.setVisibility(View.VISIBLE);
        catherine	.setVisibility(View.VISIBLE);
        celesia	.setVisibility(View.VISIBLE);
        chen	.setVisibility(View.VISIBLE);
        chika	.setVisibility(View.VISIBLE);
        chiyo	.setVisibility(View.VISIBLE);
        comet	.setVisibility(View.VISIBLE);
        donner	.setVisibility(View.VISIBLE);
        eleanor	.setVisibility(View.VISIBLE);
        esther	.setVisibility(View.VISIBLE);
        fudo	.setVisibility(View.VISIBLE);
        gin	.setVisibility(View.VISIBLE);
        hiyori	.setVisibility(View.VISIBLE);
        iris	.setVisibility(View.VISIBLE);
        kayo	.setVisibility(View.VISIBLE);
        kirine	.setVisibility(View.VISIBLE);
        kuroda	.setVisibility(View.VISIBLE);
        kurul	.setVisibility(View.VISIBLE);
        lois	.setVisibility(View.VISIBLE);
        liuk	.setVisibility(View.VISIBLE);
        izumi	.setVisibility(View.VISIBLE);
        masami	.setVisibility(View.VISIBLE);
        mika	.setVisibility(View.VISIBLE);
        minami	.setVisibility(View.VISIBLE);
        mio	.setVisibility(View.VISIBLE);
        mira	.setVisibility(View.VISIBLE);
        misaki	.setVisibility(View.VISIBLE);
        nana	.setVisibility(View.VISIBLE);
        narumi	.setVisibility(View.VISIBLE);
        odelia	.setVisibility(View.VISIBLE);
        raly	.setVisibility(View.VISIBLE);
        risa	.setVisibility(View.VISIBLE);
        saki	.setVisibility(View.VISIBLE);
        saori	.setVisibility(View.VISIBLE);
        sara	.setVisibility(View.VISIBLE);
        sariko	.setVisibility(View.VISIBLE);
        shiori	.setVisibility(View.VISIBLE);
        shirley	.setVisibility(View.VISIBLE);
        sumika	.setVisibility(View.VISIBLE);
        sylvia	.setVisibility(View.VISIBLE);
        uzuki	.setVisibility(View.VISIBLE);
        yesi	.setVisibility(View.VISIBLE);
        youko	.setVisibility(View.VISIBLE);
        zero	.setVisibility(View.VISIBLE);
        zrs2	.setVisibility(View.VISIBLE);

        sp_sara	.setVisibility(View.VISIBLE);
        yui	.setVisibility(View.VISIBLE);
        demoZ	.setVisibility(View.VISIBLE);

        akiyama.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="akiyama";HEROA.setImageResource(R.drawable.enabler_akiyama);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler28Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler28Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler28Lv",0)+1);}});
        alice.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="alice";HEROA.setImageResource(R.drawable.enabler_alice);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler34Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler34Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler34Lv",0)+1);}});
        ana_o.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="ana_o";HEROA.setImageResource(R.drawable.enabler_ana_o);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler25Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler25Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler25Lv",0)+1);}});
        carol.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="carol";HEROA.setImageResource(R.drawable.enabler_carol);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler48Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler48Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler48Lv",0)+1);}});
        catherine.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="catherine";HEROA.setImageResource(R.drawable.enabler_catherine);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler05Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler05Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler05Lv",0)+1);}});
        celesia.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="celesia";HEROA.setImageResource(R.drawable.enabler_celesia);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler46Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler46Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler46Lv",0)+1);}});
        chen.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="chen";HEROA.setImageResource(R.drawable.enabler_chen);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler42Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler42Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler42Lv",0)+1);}});
        chika.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="chika";HEROA.setImageResource(R.drawable.enabler_chika);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler22Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler22Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler22Lv",0)+1);}});
        chiyo.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="chiyo";HEROA.setImageResource(R.drawable.enabler_chiyo);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler09Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler09Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler09Lv",0)+1);}});
        comet.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="comet";HEROA.setImageResource(R.drawable.enabler_comet);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler41Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler41Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler41Lv",0)+1);}});
        donner.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="donner";HEROA.setImageResource(R.drawable.enabler_donner);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler20Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler20Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler20Lv",0)+1);}});
        eleanor.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="eleanor";HEROA.setImageResource(R.drawable.enabler_eleanor);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler19Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler19Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler19Lv",0)+1);}});
        esther.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="esther";HEROA.setImageResource(R.drawable.enabler_esther);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler15Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler15Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler15Lv",0)+1);}});
        fudo.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="fudo";HEROA.setImageResource(R.drawable.enabler_fudo);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler27Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler27Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler27Lv",0)+1);}});
        gin.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="gin";HEROA.setImageResource(R.drawable.enabler_gin);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler01Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler01Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler01Lv",0)+1);}});
        hiyori.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="hiyori";HEROA.setImageResource(R.drawable.enabler_hiyori);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler17Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler17Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler17Lv",0)+1);}});
        iris.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="iris";HEROA.setImageResource(R.drawable.enabler_iris);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler07Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler07Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler07Lv",0)+1);}});
        izumi.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="izumi";HEROA.setImageResource(R.drawable.enabler_izumi);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler43Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler43Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler43Lv",0)+1);}});
        kayo.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="kayo";HEROA.setImageResource(R.drawable.enabler_kayo);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler18Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler18Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler18Lv",0)+1);}});
        kirine.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="kirine";HEROA.setImageResource(R.drawable.enabler_kirine);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler21Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler21Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler21Lv",0)+1);}});
        kuroda.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="kuroda";HEROA.setImageResource(R.drawable.enabler_kuroda);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler08Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler08Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler08Lv",0)+1);}});
        kurul.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="kurul";HEROA.setImageResource(R.drawable.enabler_kurul);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler39Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler39Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler39Lv",0)+1);}});
        liuk.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="liuk";HEROA.setImageResource(R.drawable.enabler_liuk);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler40Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler40Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler40Lv",0)+1);}});
        lois.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="lois";HEROA.setImageResource(R.drawable.enabler_lois);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler23Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler23Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler23Lv",0)+1);}});
        masami.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="masami";HEROA.setImageResource(R.drawable.enabler_masami);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler44Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler44Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler44Lv",0)+1);}});
        mika.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="mika";HEROA.setImageResource(R.drawable.enabler_mika);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler06Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler06Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler06Lv",0)+1);}});
        minami.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="minami";HEROA.setImageResource(R.drawable.enabler_minami);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler37Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler37Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler37Lv",0)+1);}});
        mio.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="mio";HEROA.setImageResource(R.drawable.enabler_mio);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler13Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler13Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler13Lv",0)+1);}});
        mira.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="mira";HEROA.setImageResource(R.drawable.enabler_mira);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler14Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler14Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler14Lv",0)+1);}});
        misaki.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="misaki";HEROA.setImageResource(R.drawable.enabler_misaki);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler36Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler36Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler36Lv",0)+1);}});
        nana.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="nana";HEROA.setImageResource(R.drawable.enabler_nana);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler31Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler31Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler31Lv",0)+1);}});
        narumi.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="narumi";HEROA.setImageResource(R.drawable.enabler_narumi);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler12Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler12Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler12Lv",0)+1);}});
        odelia.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="odelia";HEROA.setImageResource(R.drawable.enabler_odelia);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler49Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler49Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler49Lv",0)+1);}});
        raly.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="raly";HEROA.setImageResource(R.drawable.enabler_raly);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler30Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler30Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler30Lv",0)+1);}});
        risa.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="risa";HEROA.setImageResource(R.drawable.enabler_risa);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler35Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler35Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler35Lv",0)+1);}});
        saki.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="saki";HEROA.setImageResource(R.drawable.enabler_saki);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler38Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler38Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler38Lv",0)+1);}});
        saori.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="saori";HEROA.setImageResource(R.drawable.enabler_saori);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler02Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler02Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler02Lv",0)+1);}});
        sara.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="sara";HEROA.setImageResource(R.drawable.enabler_sara);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler26Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler26Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler26Lv",0)+1);}});
        sariko.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="sariko";HEROA.setImageResource(R.drawable.enabler_sariko);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler03Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler03Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler03Lv",0)+1);}});
        shiori.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="shiori";HEROA.setImageResource(R.drawable.enabler_shiori);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler10Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler10Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler10Lv",0)+1);}});
        shirley.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="shirley";HEROA.setImageResource(R.drawable.enabler_shirley);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler32Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler32Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler32Lv",0)+1);}});
        sp_sara.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="sp_sara";HEROA.setImageResource(R.drawable.enabler_sp_sara);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler45Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler45Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler45Lv",0)+1);}});
        sumika.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="sumika";HEROA.setImageResource(R.drawable.enabler_sumika);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler16Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler16Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler16Lv",0)+1);}});
        sylvia.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="sylvia";HEROA.setImageResource(R.drawable.enabler_sylvia);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler50Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler50Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler50Lv",0)+1);}});
        uzuki.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="uzuki";HEROA.setImageResource(R.drawable.enabler_uzuki);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler04Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler04Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler04Lv",0)+1);}});
        yesi.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="yesi";HEROA.setImageResource(R.drawable.enabler_yesi);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler33Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler33Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler33Lv",0)+1);}});
        youko.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="youko";HEROA.setImageResource(R.drawable.enabler_youko);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler11Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler11Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler11Lv",0)+1);}});
        yui.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="yui";HEROA.setImageResource(R.drawable.enabler_yui);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler47Lv",0))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler47Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler47Lv",0)+1);}});
        zero.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="zero";HEROA.setImageResource(R.drawable.enabler_zero);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler24Lv",1))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler24Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler24Lv",0)+1);}});
        zrs2.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="zrs2";HEROA.setImageResource(R.drawable.enabler_zrs2);now_exp.setText(String.valueOf(((int) sharedPreferences.getLong("enabler29Lv",2))));HEROA_TV.setText(splitA(hero_a));now_seek.setProgress((int) sharedPreferences.getLong("enabler29Lv",0));aim_seek.setProgress((int) sharedPreferences.getLong("enabler29Lv",0)+1);}});

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
        int  bf=0 , exp_xp= 0;
        total_exp = 0 ;
        if (enabler_exp.getText() == null | enabler_exp.getText().toString().equals("") ){enabler_exp.setText("0");exp_xp = Integer.parseInt(enabler_exp.getText().toString());}else{exp_xp = Integer.parseInt(enabler_exp.getText().toString());}
        now = now_seek.getProgress();
        aim = aim_seek.getProgress();
        if (now < 16 && aim >= 16) {	total_exp = total_exp + exp_16;	adapter.add(getString(R.string.exp_ut16)	 + " " +exp_16); }
        if (now < 17 && aim >= 17) {	total_exp = total_exp + exp_17;	adapter.add(getString(R.string.exp_ut17)	 + " " +exp_17); }
        if (now < 18 && aim >= 18) {	total_exp = total_exp + exp_18;	adapter.add(getString(R.string.exp_ut18)	 + " " +exp_18); }
        if (now < 19 && aim >= 19) {	total_exp = total_exp + exp_19;	adapter.add(getString(R.string.exp_ut19)	 + " " +exp_19); }
        if (now < 20 && aim >= 20) {	total_exp = total_exp + exp_20;	adapter.add(getString(R.string.exp_ut20)	 + " " +exp_20); }
        if (now < 21 && aim >= 21) {	total_exp = total_exp + exp_21;	adapter.add(getString(R.string.exp_ut21)	 + " " +exp_21); }
        if (now < 22 && aim >= 22) {	total_exp = total_exp + exp_22;	adapter.add(getString(R.string.exp_ut22)	 + " " +exp_22); }
        if (now < 23 && aim >= 23) {	total_exp = total_exp + exp_23;	adapter.add(getString(R.string.exp_ut23)	 + " " +exp_23); }
        if (now < 24 && aim >= 24) {	total_exp = total_exp + exp_24;	adapter.add(getString(R.string.exp_ut24)	 + " " +exp_24); }
        if (now < 25 && aim >= 25) {	total_exp = total_exp + exp_25;	adapter.add(getString(R.string.exp_ut25)	 + " " +exp_25); }
        if (now < 26 && aim >= 26) {	total_exp = total_exp + exp_26;	adapter.add(getString(R.string.exp_ut26)	 + " " +exp_26); }
        if (now < 27 && aim >= 27) {	total_exp = total_exp + exp_27;	adapter.add(getString(R.string.exp_ut27)	 + " " +exp_27); }
        if (now < 28 && aim >= 28) {	total_exp = total_exp + exp_28;	adapter.add(getString(R.string.exp_ut28)	 + " " +exp_28); }
        if (now < 29 && aim >= 29) {	total_exp = total_exp + exp_29;	adapter.add(getString(R.string.exp_ut29)	 + " " +exp_29); }
        if (now < 30 && aim >= 30) {	total_exp = total_exp + exp_30;	adapter.add(getString(R.string.exp_ut30)	 + " " +exp_30); }
        if (now < 31 && aim >= 31) {	total_exp = total_exp + exp_31;	adapter.add(getString(R.string.exp_ut31)	 + " " +exp_31); }
        if (now < 32 && aim >= 32) {	total_exp = total_exp + exp_32;	adapter.add(getString(R.string.exp_ut32)	 + " " +exp_32); }
        if (now < 33 && aim >= 33) {	total_exp = total_exp + exp_33;	adapter.add(getString(R.string.exp_ut33)	 + " " +exp_33); }
        if (now < 34 && aim >= 34) {	total_exp = total_exp + exp_34;	adapter.add(getString(R.string.exp_ut34)	 + " " +exp_34); }
        if (now < 35 && aim >= 35) {	total_exp = total_exp + exp_35;	adapter.add(getString(R.string.exp_ut35)	 + " " +exp_35); }
        if (now < 36 && aim >= 36) {	total_exp = total_exp + exp_36;	adapter.add(getString(R.string.exp_ut36)	 + " " +exp_36); }
        if (now < 37 && aim >= 37) {	total_exp = total_exp + exp_37;	adapter.add(getString(R.string.exp_ut37)	 + " " +exp_37); }
        if (now < 38 && aim >= 38) {	total_exp = total_exp + exp_38;	adapter.add(getString(R.string.exp_ut38)	 + " " +exp_38); }
        if (now < 39 && aim >= 39) {	total_exp = total_exp + exp_39;	adapter.add(getString(R.string.exp_ut39)	 + " " +exp_39); }
        if (now < 40 && aim >= 40) {	total_exp = total_exp + exp_40;	adapter.add(getString(R.string.exp_ut40)	 + " " +exp_40); }
        if (now < 41 && aim >= 41) {	total_exp = total_exp + exp_41;	adapter.add(getString(R.string.exp_ut41)	 + " " +exp_41); }
        if (now < 42 && aim >= 42) {	total_exp = total_exp + exp_42;	adapter.add(getString(R.string.exp_ut42)	 + " " +exp_42); }
        if (now < 43 && aim >= 43) {	total_exp = total_exp + exp_43;	adapter.add(getString(R.string.exp_ut43)	 + " " +exp_43); }
        if (now < 44 && aim >= 44) {	total_exp = total_exp + exp_44;	adapter.add(getString(R.string.exp_ut44)	 + " " +exp_44); }
        if (now < 45 && aim >= 45) {	total_exp = total_exp + exp_45;	adapter.add(getString(R.string.exp_ut45)	 + " " +exp_45); }
        if (now < 46 && aim >= 46) {	total_exp = total_exp + exp_46;	adapter.add(getString(R.string.exp_ut46)	 + " " +exp_46); }
        if (now < 47 && aim >= 47) {	total_exp = total_exp + exp_47;	adapter.add(getString(R.string.exp_ut47)	 + " " +exp_47); }
        if (now < 48 && aim >= 48) {	total_exp = total_exp + exp_48;	adapter.add(getString(R.string.exp_ut48)	 + " " +exp_48); }
        if (now < 49 && aim >= 49) {	total_exp = total_exp + exp_49;	adapter.add(getString(R.string.exp_ut49)	 + " " +exp_49); }
        if (now < 50 && aim >= 50) {	total_exp = total_exp + exp_50;	adapter.add(getString(R.string.exp_ut50)	 + " " +exp_50); }






        Log.i("EXP", String.valueOf(total_exp));

                if (buff_exp.isChecked()) {
                    Log.i("BUFF", "NEED");
                    adapter.add(getString(R.string.buff_day_true));
                    total_exp = (int) (total_exp * 0.8);
                    Log.i("EXP_BUFFED", String.valueOf(total_exp));
                } else {
                    adapter.add(getString(R.string.buff_day_false));
                    bf = 1;
                }
                total_exp = total_exp - exp_xp;

                int exp01 = (int) (total_exp / 500);
                int exp02 = (int) (total_exp / 5000);
                int exp03 = (int) (total_exp / 10000);
                int exp04 = (int) (total_exp / 20000);
                int exp05 = (int) (total_exp / 50000);
                int exp06 = (int) (total_exp / 80000);
                int exp07 = (int) (total_exp / 100000);

                Log.i("EXP1", String.valueOf(exp01));
                Log.i("EXP2", String.valueOf(exp02));
                Log.i("EXP3", String.valueOf(exp03));
                Log.i("EXP4", String.valueOf(exp04));
                Log.i("EXP5", String.valueOf(exp05));
                Log.i("EXP6", String.valueOf(exp06));
                Log.i("EXP7", String.valueOf(exp07));

                if ((total_exp / 500) > exp01) {
                    exp01 = exp01 + 1;
                }
                if ((total_exp / 5000) > exp02) {
                    exp02 = exp02 + 1;
                }
                if ((total_exp / 10000) > exp03) {
                    exp03 = exp03 + 1;
                }
                if ((total_exp / 20000) > exp04) {
                    exp04 = exp04 + 1;
                }
                if ((total_exp / 50000) > exp05) {
                    exp05 = exp05 + 1;
                }
                if ((total_exp / 80000) > exp06) {
                    exp06 = exp06 + 1;
                }
                if ((total_exp / 100000) > exp07) {
                    exp07 = exp07 + 1;
                }

                Log.i("EXP1", String.valueOf(exp01));
                Log.i("EXP2", String.valueOf(exp02));
                Log.i("EXP3", String.valueOf(exp03));
                Log.i("EXP4", String.valueOf(exp04));
                Log.i("EXP5", String.valueOf(exp05));
                Log.i("EXP6", String.valueOf(exp06));
                Log.i("EXP7", String.valueOf(exp07));

                /**
                 * Method INT TO TXT (DONE)
                 */
                String exp_total_String = null, exp_1_String = null, exp_2_String = null, exp_3_String = null, exp_4_String = null, exp_5_String = null, exp_6_String = null, exp_7_String = null;

                exp_total.setText(prettyCount(total_exp));
                exp_1.setText(prettyCount(exp01));
                exp_2.setText(prettyCount(exp02));
                exp_3.setText(prettyCount(exp03));
                exp_4.setText(prettyCount(exp04));
                exp_5.setText(prettyCount(exp05));
                exp_6.setText(prettyCount(exp06));
                exp_7.setText(prettyCount(exp07));

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
    public String splitA(String string){
        if(string.matches("saki")){ string = getString(R.string.saki_name);}
        if(string.matches("fudo")){ string = getString(R.string.fudo_name);}
        if(string.matches("masami")){ string = getString(R.string.masami_name);}
        if(string.matches("carol")){ string = getString(R.string.carol_name);}
        if(string.matches("uzuki")){ string = getString(R.string.uzuki_name);}
        if(string.matches("sara")){ string = getString(R.string.sara_name);}
        if(string.matches("sariko")){ string = getString(R.string.sariko_name);}
        if(string.matches("chika")){ string = getString(R.string.chika_name);}
        if(string.matches("kirine")){ string = getString(R.string.kirine_name);}
        if(string.matches("hiyori")){ string = getString(R.string.hiyori_name);}
        if(string.matches("mio")){ string = getString(R.string.mio_name);}
        if(string.matches("izumi")){ string = getString(R.string.izumi_name);}
        if(string.matches("gin")){ string = getString(R.string.gin_name);}
        if(string.matches("nana")){ string = getString(R.string.nana_name);}
        if(string.matches("sumika")){ string = getString(R.string.sumika_name);}
        if(string.matches("kayo")){ string = getString(R.string.kayo_name);}
        if(string.matches("youko")){ string = getString(R.string.youko_name);}
        if(string.matches("saori")){ string = getString(R.string.saori_name);}
        if(string.matches("comet")){ string = getString(R.string.comet_name);}
        if(string.matches("donner")){ string = getString(R.string.donner_name);}
        if(string.matches("minami")){ string = getString(R.string.minami_name);}
        if(string.matches("chen")){ string = getString(R.string.chen_name);}
        if(string.matches("eleanor")){ string = getString(R.string.eleanor_name);}
        if(string.matches("zero")){ string = getString(R.string.zero_name);}
        if(string.matches("ana_o")){ string = getString(R.string.ana_o_name);}
        if(string.matches("odelia")){ string = getString(R.string.odelia_name);}
        if(string.matches("zrs2")){ string = getString(R.string.zrs_2_name);}
        if(string.matches("liuk")){ string = getString(R.string.liuk_name);}
        if(string.matches("akiyama")){ string = getString(R.string.akiyama_name);}
        if(string.matches("esther")){ string = getString(R.string.esther_name);}
        if(string.matches("alice")){ string = getString(R.string.alice_name);}
        if(string.matches("yesi")){ string = getString(R.string.yesi_name);}
        if(string.matches("shiori")){ string = getString(R.string.shiori_name);}
        if(string.matches("misaki")){ string = getString(R.string.misaki_name);}
        if(string.matches("risa")){ string = getString(R.string.risa_name);}
        if(string.matches("mika")){ string = getString(R.string.mika_name);}
        if(string.matches("mira")){ string = getString(R.string.mira_name);}
        if(string.matches("raly")){ string = getString(R.string.raly_name);}
        if(string.matches("celesia")){ string = getString(R.string.celesia_name);}
        if(string.matches("chiyo")){ string = getString(R.string.chiyo_name);}
        if(string.matches("kurul")){ string = getString(R.string.kurul_name);}
        if(string.matches("kuroda")){ string = getString(R.string.kuroda_name);}
        if(string.matches("catherine")){ string = getString(R.string.catherine_name);}
        if(string.matches("shirley")){ string = getString(R.string.shirley_name);}
        if(string.matches("lois")){ string = getString(R.string.lois_name);}
        if(string.matches("iris")){ string = getString(R.string.iris_name);}
        if(string.matches("sylvia")){ string = getString(R.string.sylvia_name);}
        if(string.matches("narumi")){ string = getString(R.string.narumi_name);}
        if(string.matches("sp_sara")){ string = getString(R.string.bland_sara_name);}
        if(string.matches("yui")){ string = getString(R.string.yui_name);}
        return string;
    }

}