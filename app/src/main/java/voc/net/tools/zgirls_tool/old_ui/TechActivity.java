package voc.net.tools.zgirls_tool.old_ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.R;

public class TechActivity extends AppCompatActivity {

    LinearLayout rss,school,def,mili,mili_def,mili_off,bio;

    EditText rss01,	rss02,	rss03,	rss04,	rss05,	rss06,	rss07,	rss08,	rss09,	rss10,	rss11,	rss12,	rss13,	rss14,	rss15,	rss16,	rss17,	rss18,	rss19,	rss20;
    EditText	sch01,	sch02,	sch03,	sch04,	sch05,	sch06,	sch07,	sch08,	sch09,	sch10,	sch11,	sch12,	sch13,	sch14;
    EditText	def01,	def02,	def03,	def04,	def05,	def06,	def07,	def08,	def09,	def10,	def11,	def12,	def13,	def14,	def15,	def16,	def17,	def18;
    EditText	mili01,	mili02,	mili03,	mili04,	mili05,	mili06,	mili07,	mili08,	mili09,	mili10,	mili11,	mili12,	mili13,	mili14,	mili15,	mili16,	mili17,	mili18,	mili19,	mili20,	mili21,	mili22,	mili23,	mili24,	mili25,	mili26,	mili27,	mili28,	mili29,	mili30,	mili31,	mili32,	mili33,	mili34,	mili35,	mili36,	mili37,	mili38,	mili39;
    EditText	mili_off01,	mili_off02,	mili_off03,	mili_off04,	mili_off05,	mili_off06,	mili_off07,	mili_off08,	mili_off09,	mili_off10,	mili_off11,	mili_off12,	mili_off13,	mili_off14,	mili_off15,	mili_off16,	mili_off17,	mili_off18,	mili_off19;
    EditText	mili_def01,	mili_def02,	mili_def03,	mili_def04,	mili_def05,	mili_def06,	mili_def07,	mili_def08,	mili_def09,	mili_def10,	mili_def11,	mili_def12,	mili_def13,	mili_def14,	mili_def15,	mili_def16,	mili_def17;
    EditText	bio01,	bio02,	bio03,	bio04,	bio05,	bio06,	bio07,	bio08,	bio09,	bio10,	bio11;

    ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;

    String buffed = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech);

        rss = findViewById(R.id.rss_tlist);
        school = findViewById(R.id.school_tlist);
        def = findViewById(R.id.def_tlist);
        mili = findViewById(R.id.mili_tlist);
        mili_def = findViewById(R.id.mili_def_tlist);
        mili_off = findViewById(R.id.mili_off_tlist);
        bio = findViewById(R.id.bio_tlist);

        rss01=	findViewById	(R.id.rss_01_et);
        rss02=	findViewById	(R.id.rss_02_et);
        rss03=	findViewById	(R.id.rss_03_et);
        rss04=	findViewById	(R.id.rss_04_et);
        rss05=	findViewById	(R.id.rss_05_et);
        rss06=	findViewById	(R.id.rss_06_et);
        rss07=	findViewById	(R.id.rss_07_et);
        rss08=	findViewById	(R.id.rss_08_et);
        rss09=	findViewById	(R.id.rss_09_et);
        rss10=	findViewById	(R.id.rss_10_et);
        rss11=	findViewById	(R.id.rss_11_et);
        rss12=	findViewById	(R.id.rss_12_et);
        rss13=	findViewById	(R.id.rss_13_et);
        rss14=	findViewById	(R.id.rss_14_et);
        rss15=	findViewById	(R.id.rss_15_et);
        rss16=	findViewById	(R.id.rss_16_et);
        rss17=	findViewById	(R.id.rss_17_et);
        rss18=	findViewById	(R.id.rss_18_et);
        rss19=	findViewById	(R.id.rss_19_et);
        rss20=	findViewById	(R.id.rss_20_et);

        sch01=	findViewById	(R.id.sch_01_et);
        sch02=	findViewById	(R.id.sch_02_et);
        sch03=	findViewById	(R.id.sch_03_et);
        sch04=	findViewById	(R.id.sch_04_et);
        sch05=	findViewById	(R.id.sch_05_et);
        sch06=	findViewById	(R.id.sch_06_et);
        sch07=	findViewById	(R.id.sch_07_et);
        sch08=	findViewById	(R.id.sch_08_et);
        sch09=	findViewById	(R.id.sch_09_et);
        sch10=	findViewById	(R.id.sch_10_et);
        sch11=	findViewById	(R.id.sch_11_et);
        sch12=	findViewById	(R.id.sch_12_et);
        sch13=	findViewById	(R.id.sch_13_et);
        sch14=	findViewById	(R.id.sch_14_et);

        def01=	findViewById	(R.id.def_01_et);
        def02=	findViewById	(R.id.def_02_et);
        def03=	findViewById	(R.id.def_03_et);
        def04=	findViewById	(R.id.def_04_et);
        def05=	findViewById	(R.id.def_05_et);
        def06=	findViewById	(R.id.def_06_et);
        def07=	findViewById	(R.id.def_07_et);
        def08=	findViewById	(R.id.def_08_et);
        def09=	findViewById	(R.id.def_09_et);
        def10=	findViewById	(R.id.def_10_et);
        def11=	findViewById	(R.id.def_11_et);
        def12=	findViewById	(R.id.def_12_et);
        def13=	findViewById	(R.id.def_13_et);
        def14=	findViewById	(R.id.def_14_et);
        def15=	findViewById	(R.id.def_15_et);
        def16=	findViewById	(R.id.def_16_et);
        def17=	findViewById	(R.id.def_17_et);
        def18=	findViewById	(R.id.def_18_et);

        mili01=	findViewById	(R.id.mili_01_et);
        mili02=	findViewById	(R.id.mili_02_et);
        mili03=	findViewById	(R.id.mili_03_et);
        mili04=	findViewById	(R.id.mili_04_et);
        mili05=	findViewById	(R.id.mili_05_et);
        mili06=	findViewById	(R.id.mili_06_et);
        mili07=	findViewById	(R.id.mili_07_et);
        mili08=	findViewById	(R.id.mili_08_et);
        mili09=	findViewById	(R.id.mili_09_et);
        mili10=	findViewById	(R.id.mili_10_et);
        mili11=	findViewById	(R.id.mili_11_et);
        mili12=	findViewById	(R.id.mili_12_et);
        mili13=	findViewById	(R.id.mili_13_et);
        mili14=	findViewById	(R.id.mili_14_et);
        mili15=	findViewById	(R.id.mili_15_et);
        mili16=	findViewById	(R.id.mili_16_et);
        mili17=	findViewById	(R.id.mili_17_et);
        mili18=	findViewById	(R.id.mili_18_et);
        mili19=	findViewById	(R.id.mili_19_et);
        mili20=	findViewById	(R.id.mili_20_et);
        mili21=	findViewById	(R.id.mili_21_et);
        mili22=	findViewById	(R.id.mili_22_et);
        mili23=	findViewById	(R.id.mili_23_et);
        mili24=	findViewById	(R.id.mili_24_et);
        mili25=	findViewById	(R.id.mili_25_et);
        mili26=	findViewById	(R.id.mili_26_et);
        mili27=	findViewById	(R.id.mili_27_et);
        mili28=	findViewById	(R.id.mili_28_et);
        mili29=	findViewById	(R.id.mili_29_et);
        mili30=	findViewById	(R.id.mili_30_et);
        mili31=	findViewById	(R.id.mili_31_et);
        mili32=	findViewById	(R.id.mili_32_et);
        mili33=	findViewById	(R.id.mili_33_et);
        mili34=	findViewById	(R.id.mili_34_et);
        mili35=	findViewById	(R.id.mili_35_et);
        mili36=	findViewById	(R.id.mili_36_et);
        mili37=	findViewById	(R.id.mili_37_et);
        mili38=	findViewById	(R.id.mili_38_et);
        mili39=	findViewById	(R.id.mili_39_et);

        mili_off01=	findViewById	(R.id.mili_off01_et);
        mili_off02=	findViewById	(R.id.mili_off02_et);
        mili_off03=	findViewById	(R.id.mili_off03_et);
        mili_off04=	findViewById	(R.id.mili_off04_et);
        mili_off05=	findViewById	(R.id.mili_off05_et);
        mili_off06=	findViewById	(R.id.mili_off06_et);
        mili_off07=	findViewById	(R.id.mili_off07_et);
        mili_off08=	findViewById	(R.id.mili_off08_et);
        mili_off09=	findViewById	(R.id.mili_off09_et);
        mili_off10=	findViewById	(R.id.mili_off10_et);
        mili_off11=	findViewById	(R.id.mili_off11_et);
        mili_off12=	findViewById	(R.id.mili_off12_et);
        mili_off13=	findViewById	(R.id.mili_off13_et);
        mili_off14=	findViewById	(R.id.mili_off14_et);
        mili_off15=	findViewById	(R.id.mili_off15_et);
        mili_off16=	findViewById	(R.id.mili_off16_et);
        mili_off17=	findViewById	(R.id.mili_off17_et);
        mili_off18=	findViewById	(R.id.mili_off18_et);
        mili_off19=	findViewById	(R.id.mili_off19_et);

        mili_def01=	findViewById	(R.id.mili_def01_et);
        mili_def02=	findViewById	(R.id.mili_def02_et);
        mili_def03=	findViewById	(R.id.mili_def03_et);
        mili_def04=	findViewById	(R.id.mili_def04_et);
        mili_def05=	findViewById	(R.id.mili_def05_et);
        mili_def06=	findViewById	(R.id.mili_def06_et);
        mili_def07=	findViewById	(R.id.mili_def07_et);
        mili_def08=	findViewById	(R.id.mili_def08_et);
        mili_def09=	findViewById	(R.id.mili_def09_et);
        mili_def10=	findViewById	(R.id.mili_def10_et);
        mili_def11=	findViewById	(R.id.mili_def11_et);
        mili_def12=	findViewById	(R.id.mili_def12_et);
        mili_def13=	findViewById	(R.id.mili_def13_et);
        mili_def14=	findViewById	(R.id.mili_def14_et);
        mili_def15=	findViewById	(R.id.mili_def15_et);
        mili_def16=	findViewById	(R.id.mili_def16_et);
        mili_def17=	findViewById	(R.id.mili_def17_et);

        bio01=	findViewById	(R.id.bio_01_et);
        bio02=	findViewById	(R.id.bio_02_et);
        bio03=	findViewById	(R.id.bio_03_et);
        bio04=	findViewById	(R.id.bio_04_et);
        bio05=	findViewById	(R.id.bio_05_et);
        bio06=	findViewById	(R.id.bio_06_et);
        bio07=	findViewById	(R.id.bio_07_et);
        bio08=	findViewById	(R.id.bio_08_et);
        bio09=	findViewById	(R.id.bio_09_et);
        bio10=	findViewById	(R.id.bio_10_et);
        bio11=	findViewById	(R.id.bio_11_et);

        listView = findViewById(R.id.list_tech);

        //METHOD END

        BackgroundReload();

        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.list_tv, arrayList);
        listView.setAdapter(adapter);
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

    public void rss (View view){
        rss.setVisibility(View.VISIBLE);
        school.setVisibility(View.GONE);
        def.setVisibility(View.GONE);
        mili.setVisibility(View.GONE);
        mili_def.setVisibility(View.GONE);
        mili_off.setVisibility(View.GONE);
        bio.setVisibility(View.GONE);

    }
    public void school (View view){
        school.setVisibility(View.VISIBLE);
        rss.setVisibility(View.GONE);
        def.setVisibility(View.GONE);
        mili.setVisibility(View.GONE);
        mili_def.setVisibility(View.GONE);
        mili_off.setVisibility(View.GONE);
        bio.setVisibility(View.GONE);

    }
    public void defense (View view){
        def.setVisibility(View.VISIBLE);
        school.setVisibility(View.GONE);
        rss.setVisibility(View.GONE);
        mili.setVisibility(View.GONE);
        mili_def.setVisibility(View.GONE);
        mili_off.setVisibility(View.GONE);
        bio.setVisibility(View.GONE);

    }
    public void military (View view){
        mili.setVisibility(View.VISIBLE);
        school.setVisibility(View.GONE);
        def.setVisibility(View.GONE);
        rss.setVisibility(View.GONE);
        mili_def.setVisibility(View.GONE);
        mili_off.setVisibility(View.GONE);
        bio.setVisibility(View.GONE);

    }
    public void military_off (View view){
        mili_off.setVisibility(View.VISIBLE);
        school.setVisibility(View.GONE);
        def.setVisibility(View.GONE);
        mili.setVisibility(View.GONE);
        mili_def.setVisibility(View.GONE);
        rss.setVisibility(View.GONE);
        bio.setVisibility(View.GONE);

    }
    public void military_def (View view){
        mili_def.setVisibility(View.VISIBLE);
        school.setVisibility(View.GONE);
        def.setVisibility(View.GONE);
        mili.setVisibility(View.GONE);
        rss.setVisibility(View.GONE);
        mili_off.setVisibility(View.GONE);
        bio.setVisibility(View.GONE);

    }
    public void bio (View view){
        bio.setVisibility(View.VISIBLE);
        school.setVisibility(View.GONE);
        def.setVisibility(View.GONE);
        mili.setVisibility(View.GONE);
        mili_def.setVisibility(View.GONE);
        mili_off.setVisibility(View.GONE);
        rss.setVisibility(View.GONE);

    }
    public void calculate (View view){
        adapter.clear();

        String rss01_S = 	rss01.getText().toString();
        String rss02_S =	rss02.getText().toString();
        String rss03_S =	rss03.getText().toString();
        String rss04_S =	rss04.getText().toString();
        String rss05_S =	rss05.getText().toString();
        String rss06_S =	rss06.getText().toString();
        String rss07_S =	rss07.getText().toString();
        String rss08_S =	rss08.getText().toString();
        String rss09_S =	rss09.getText().toString();
        String rss10_S =	rss10.getText().toString();
        String rss11_S =	rss11.getText().toString();
        String rss12_S =	rss12.getText().toString();
        String rss13_S =	rss13.getText().toString();
        String rss14_S =	rss14.getText().toString();
        String rss15_S =	rss15.getText().toString();
        String rss16_S =	rss16.getText().toString();
        String rss17_S =	rss17.getText().toString();
        String rss18_S =	rss18.getText().toString();
        String rss19_S =	rss19.getText().toString();
        String rss20_S =	rss20.getText().toString();

        String def01_S = 	def01.getText().toString();
        String def02_S =	def02.getText().toString();
        String def03_S =	def03.getText().toString();
        String def04_S =	def04.getText().toString();
        String def05_S =	def05.getText().toString();
        String def06_S =	def06.getText().toString();
        String def07_S =	def07.getText().toString();
        String def08_S =	def08.getText().toString();
        String def09_S =	def09.getText().toString();
        String def10_S =	def10.getText().toString();
        String def11_S =	def11.getText().toString();
        String def12_S =	def12.getText().toString();
        String def13_S =	def13.getText().toString();
        String def14_S =	def14.getText().toString();
        String def15_S =	def15.getText().toString();
        String def16_S =	def16.getText().toString();
        String def17_S =	def17.getText().toString();
        String def18_S =	def18.getText().toString();

        String sch01_S = 	sch01.getText().toString();
        String sch02_S =	sch02.getText().toString();
        String sch03_S =	sch03.getText().toString();
        String sch04_S =	sch04.getText().toString();
        String sch05_S =	sch05.getText().toString();
        String sch06_S =	sch06.getText().toString();
        String sch07_S =	sch07.getText().toString();
        String sch08_S =	sch08.getText().toString();
        String sch09_S =	sch09.getText().toString();
        String sch10_S =	sch10.getText().toString();
        String sch11_S =	sch11.getText().toString();
        String sch12_S =	sch12.getText().toString();
        String sch13_S =	sch13.getText().toString();
        String sch14_S =	sch14.getText().toString();

        String mili01_S = 	mili01.getText().toString();
        String mili02_S =	mili02.getText().toString();
        String mili03_S =	mili03.getText().toString();
        String mili04_S =	mili04.getText().toString();
        String mili05_S =	mili05.getText().toString();
        String mili06_S =	mili06.getText().toString();
        String mili07_S =	mili07.getText().toString();
        String mili08_S =	mili08.getText().toString();
        String mili09_S =	mili09.getText().toString();
        String mili10_S =	mili10.getText().toString();
        String mili11_S =	mili11.getText().toString();
        String mili12_S =	mili12.getText().toString();
        String mili13_S =	mili13.getText().toString();
        String mili14_S =	mili14.getText().toString();
        String mili15_S =	mili15.getText().toString();
        String mili16_S =	mili16.getText().toString();
        String mili17_S =	mili17.getText().toString();
        String mili18_S =	mili18.getText().toString();
        String mili19_S =	mili19.getText().toString();
        String mili20_S =	mili20.getText().toString();
        String mili21_S =	mili21.getText().toString();
        String mili22_S =	mili22.getText().toString();
        String mili23_S =	mili23.getText().toString();
        String mili24_S =	mili24.getText().toString();
        String mili25_S =	mili25.getText().toString();
        String mili26_S =	mili26.getText().toString();
        String mili27_S =	mili27.getText().toString();
        String mili28_S =	mili28.getText().toString();
        String mili29_S =	mili29.getText().toString();
        String mili30_S =	mili30.getText().toString();
        String mili31_S =	mili31.getText().toString();
        String mili32_S =	mili32.getText().toString();
        String mili33_S =	mili33.getText().toString();
        String mili34_S =	mili34.getText().toString();
        String mili35_S =	mili35.getText().toString();
        String mili36_S =	mili36.getText().toString();
        String mili37_S =	mili37.getText().toString();
        String mili38_S =	mili38.getText().toString();
        String mili39_S =	mili39.getText().toString();

        String mili_off01_S = 	mili_off01.getText().toString();
        String mili_off02_S =	mili_off02.getText().toString();
        String mili_off03_S =	mili_off03.getText().toString();
        String mili_off04_S =	mili_off04.getText().toString();
        String mili_off05_S =	mili_off05.getText().toString();
        String mili_off06_S =	mili_off06.getText().toString();
        String mili_off07_S =	mili_off07.getText().toString();
        String mili_off08_S =	mili_off08.getText().toString();
        String mili_off09_S =	mili_off09.getText().toString();
        String mili_off10_S =	mili_off10.getText().toString();
        String mili_off11_S =	mili_off11.getText().toString();
        String mili_off12_S =	mili_off12.getText().toString();
        String mili_off13_S =	mili_off13.getText().toString();
        String mili_off14_S =	mili_off14.getText().toString();
        String mili_off15_S =	mili_off15.getText().toString();
        String mili_off16_S =	mili_off16.getText().toString();
        String mili_off17_S =	mili_off17.getText().toString();
        String mili_off18_S =	mili_off18.getText().toString();
        String mili_off19_S =	mili_off19.getText().toString();

        String mili_def01_S = 	mili_def01.getText().toString();
        String mili_def02_S =	mili_def02.getText().toString();
        String mili_def03_S =	mili_def03.getText().toString();
        String mili_def04_S =	mili_def04.getText().toString();
        String mili_def05_S =	mili_def05.getText().toString();
        String mili_def06_S =	mili_def06.getText().toString();
        String mili_def07_S =	mili_def07.getText().toString();
        String mili_def08_S =	mili_def08.getText().toString();
        String mili_def09_S =	mili_def09.getText().toString();
        String mili_def10_S =	mili_def10.getText().toString();
        String mili_def11_S =	mili_def11.getText().toString();
        String mili_def12_S =	mili_def12.getText().toString();
        String mili_def13_S =	mili_def13.getText().toString();
        String mili_def14_S =	mili_def14.getText().toString();
        String mili_def15_S =	mili_def15.getText().toString();
        String mili_def16_S =	mili_def16.getText().toString();
        String mili_def17_S =	mili_def17.getText().toString();

        String bio01_S = 	bio01.getText().toString();
        String bio02_S =	bio02.getText().toString();
        String bio03_S =	bio03.getText().toString();
        String bio04_S =	bio04.getText().toString();
        String bio05_S =	bio05.getText().toString();
        String bio06_S =	bio06.getText().toString();
        String bio07_S =	bio07.getText().toString();
        String bio08_S =	bio08.getText().toString();
        String bio09_S =	bio09.getText().toString();
        String bio10_S =	bio10.getText().toString();
        String bio11_S =	bio11.getText().toString();

        if(rss01_S == ""){	rss01.setText(	"0");}	if(sch01_S == ""){	sch01.setText(	"0");}	if(def01_S == ""){	def01.setText(	"0");}	if(mili01_S == ""){	mili01.setText(	"0");}	if(mili_off01_S == ""){	mili_off01.setText(	"0");}	if(mili_def01_S == ""){	mili_def01.setText(	"0");}	if(bio01_S == ""){	bio01.setText(	"0");}
        if(rss02_S == ""){	rss02.setText(	"0");}	if(sch02_S == ""){	sch02.setText(	"0");}	if(def02_S == ""){	def02.setText(	"0");}	if(mili02_S == ""){	mili02.setText(	"0");}	if(mili_off02_S == ""){	mili_off02.setText(	"0");}	if(mili_def02_S == ""){	mili_def02.setText(	"0");}	if(bio02_S == ""){	bio02.setText(	"0");}
        if(rss03_S == ""){	rss03.setText(	"0");}	if(sch03_S == ""){	sch03.setText(	"0");}	if(def03_S == ""){	def03.setText(	"0");}	if(mili03_S == ""){	mili03.setText(	"0");}	if(mili_off03_S == ""){	mili_off03.setText(	"0");}	if(mili_def03_S == ""){	mili_def03.setText(	"0");}	if(bio03_S == ""){	bio03.setText(	"0");}
        if(rss04_S == ""){	rss04.setText(	"0");}	if(sch04_S == ""){	sch04.setText(	"0");}	if(def04_S == ""){	def04.setText(	"0");}	if(mili04_S == ""){	mili04.setText(	"0");}	if(mili_off04_S == ""){	mili_off04.setText(	"0");}	if(mili_def04_S == ""){	mili_def04.setText(	"0");}	if(bio04_S == ""){	bio04.setText(	"0");}
        if(rss05_S == ""){	rss05.setText(	"0");}	if(sch05_S == ""){	sch05.setText(	"0");}	if(def05_S == ""){	def05.setText(	"0");}	if(mili05_S == ""){	mili05.setText(	"0");}	if(mili_off05_S == ""){	mili_off05.setText(	"0");}	if(mili_def05_S == ""){	mili_def05.setText(	"0");}	if(bio05_S == ""){	bio05.setText(	"0");}
        if(rss06_S == ""){	rss06.setText(	"0");}	if(sch06_S == ""){	sch06.setText(	"0");}	if(def06_S == ""){	def06.setText(	"0");}	if(mili06_S == ""){	mili06.setText(	"0");}	if(mili_off06_S == ""){	mili_off06.setText(	"0");}	if(mili_def06_S == ""){	mili_def06.setText(	"0");}	if(bio06_S == ""){	bio06.setText(	"0");}
        if(rss07_S == ""){	rss07.setText(	"0");}	if(sch07_S == ""){	sch07.setText(	"0");}	if(def07_S == ""){	def07.setText(	"0");}	if(mili07_S == ""){	mili07.setText(	"0");}	if(mili_off07_S == ""){	mili_off07.setText(	"0");}	if(mili_def07_S == ""){	mili_def07.setText(	"0");}	if(bio07_S == ""){	bio07.setText(	"0");}
        if(rss08_S == ""){	rss08.setText(	"0");}	if(sch08_S == ""){	sch08.setText(	"0");}	if(def08_S == ""){	def08.setText(	"0");}	if(mili08_S == ""){	mili08.setText(	"0");}	if(mili_off08_S == ""){	mili_off08.setText(	"0");}	if(mili_def08_S == ""){	mili_def08.setText(	"0");}	if(bio08_S == ""){	bio08.setText(	"0");}
        if(rss09_S == ""){	rss09.setText(	"0");}	if(sch09_S == ""){	sch09.setText(	"0");}	if(def09_S == ""){	def09.setText(	"0");}	if(mili09_S == ""){	mili09.setText(	"0");}	if(mili_off09_S == ""){	mili_off09.setText(	"0");}	if(mili_def09_S == ""){	mili_def09.setText(	"0");}	if(bio09_S == ""){	bio09.setText(	"0");}
        if(rss10_S == ""){	rss10.setText(	"0");}	if(sch10_S == ""){	sch10.setText(	"0");}	if(def10_S == ""){	def10.setText(	"0");}	if(mili10_S == ""){	mili10.setText(	"0");}	if(mili_off10_S == ""){	mili_off10.setText(	"0");}	if(mili_def10_S == ""){	mili_def10.setText(	"0");}	if(bio10_S == ""){	bio10.setText(	"0");}
        if(rss11_S == ""){	rss11.setText(	"0");}	if(sch11_S == ""){	sch11.setText(	"0");}	if(def11_S == ""){	def11.setText(	"0");}	if(mili11_S == ""){	mili11.setText(	"0");}	if(mili_off11_S == ""){	mili_off11.setText(	"0");}	if(mili_def11_S == ""){	mili_def11.setText(	"0");}	if(bio11_S == ""){	bio11.setText(	"0");}
        if(rss12_S == ""){	rss12.setText(	"0");}	if(sch12_S == ""){	sch12.setText(	"0");}	if(def12_S == ""){	def12.setText(	"0");}	if(mili12_S == ""){	mili12.setText(	"0");}	if(mili_off12_S == ""){	mili_off12.setText(	"0");}	if(mili_def12_S == ""){	mili_def12.setText(	"0");}
        if(rss13_S == ""){	rss13.setText(	"0");}	if(sch13_S == ""){	sch13.setText(	"0");}	if(def13_S == ""){	def13.setText(	"0");}	if(mili13_S == ""){	mili13.setText(	"0");}	if(mili_off13_S == ""){	mili_off13.setText(	"0");}	if(mili_def13_S == ""){	mili_def13.setText(	"0");}
        if(rss14_S == ""){	rss14.setText(	"0");}	if(sch14_S == ""){	sch14.setText(	"0");}	if(def14_S == ""){	def14.setText(	"0");}	if(mili14_S == ""){	mili14.setText(	"0");}	if(mili_off14_S == ""){	mili_off14.setText(	"0");}	if(mili_def14_S == ""){	mili_def14.setText(	"0");}
        if(rss15_S == ""){	rss15.setText(	"0");}		if(mili15_S == ""){	mili15.setText(	"0");}	if(mili_off15_S == ""){	mili_off15.setText(	"0");}
        if(rss16_S == ""){	rss16.setText(	"0");}			if(mili16_S == ""){	mili16.setText(	"0");}	if(mili_off16_S == ""){	mili_off16.setText(	"0");}
        if(rss17_S == ""){	rss17.setText(	"0");}				if(mili17_S == ""){	mili17.setText(	"0");}	if(mili_off17_S == ""){	mili_off17.setText(	"0");}
        if(rss18_S == ""){	rss18.setText(	"0");}			if(mili18_S == ""){	mili18.setText(	"0");}	if(mili_off18_S == ""){	mili_off18.setText(	"0");}
        if(rss19_S == ""){	rss19.setText(	"0");}							if(mili19_S == ""){	mili19.setText(	"0");}	if(mili_off19_S == ""){	mili_off19.setText(	"0");}
        if(rss20_S == ""){	rss20.setText(	"0");}							if(mili20_S == ""){	mili20.setText(	"0");} if(mili_def14_S == ""){	mili15.setText(	"0");} if(mili_def16_S == ""){	mili16.setText(	"0");} if(mili_def17_S == ""){	mili17.setText(	"0");}
        if(mili21_S == ""){	mili21.setText(	"0");}
        if(mili22_S == ""){	mili22.setText(	"0");}
        if(mili23_S == ""){	mili23.setText(	"0");}
        if(mili24_S == ""){	mili24.setText(	"0");}
        if(mili25_S == ""){	mili25.setText(	"0");}
        if(mili26_S == ""){	mili26.setText(	"0");}
        if(mili27_S == ""){	mili27.setText(	"0");}
        if(mili28_S == ""){	mili28.setText(	"0");}
        if(mili29_S == ""){	mili29.setText(	"0");}
        if(mili30_S == ""){	mili30.setText(	"0");}
        if(mili31_S == ""){	mili31.setText(	"0");}
        if(mili32_S == ""){	mili32.setText(	"0");}
        if(mili33_S == ""){	mili33.setText(	"0");}
        if(mili34_S == ""){	mili34.setText(	"0");}
        if(mili35_S == ""){	mili35.setText(	"0");}
        if(mili36_S == ""){	mili36.setText(	"0");}
        if(mili37_S == ""){	mili37.setText(	"0");}
        if(mili38_S == ""){	mili38.setText(	"0");}
        if(mili39_S == ""){	mili39.setText(	"0");}

        if(def15_S == ""){	def15.setText(	"0");}
        if(def16_S == ""){	def16.setText(	"0");}
        if(def17_S == ""){	def17.setText(	"0");}
        if(def18_S == ""){	def18.setText(	"0");}



        int    燃料生產率提高    =  0  ;
        int    食物生產率提高    =  0  ;
        int    儲藏室保護資源增加  =  0  ;
        int    燃料採集速度增快   =  0  ;
        int    食物採集速度增快   =  0  ;
        int    鋼鐵生產率提高    =  0  ;
        int    鋼鐵採集速度增快   =  0  ;
        int    合金生產率提高    =  0  ;
        int    合金採集速度增快   =  0  ;
        int    鑽石採集速度增加   =  0  ;

        int    部隊負重提高 =  0  ;
        int    增加打怪行軍速度   =  0  ;
        int    體力恢復加速 =  0  ;
        int    建築建造速度加快   =  0  ;
        int    傷兵數量上限提高   =  0  ;
        int    傷兵恢復速度加快   =  0  ;
        int    部隊消耗食物降低   =  0  ;

        int    城防值增加  =  0  ;
        int    守軍攻擊增加 =  0  ;
        int    守軍防禦增加 =  0  ;
        int    防禦武器攻擊增加   =  0  ;
        int    燃燒彈對火力學員傷害提高   =  0  ;
        int    防禦武器上限增加   =  0  ;
        int    防禦武器上限增加_   =  0  ;
        int    防禦武器攻擊增加_   =  0  ;
        int    手雷對進擊學員傷害提高    =  0  ;
        int    地雷對機動小組傷害提高    =  0  ;
        int    防禦武器建造速度加快 =  0  ;
        int    出征戰鬥中_損失的學員一定比例轉化為傷兵   =  0  ;

        int    學員訓練速度增加   =  0  ;
        int    進擊學員攻擊提高   =  0  ;
        int    火力學員攻擊提高   =  0  ;
        int    機動小組攻擊提高   =  0  ;
        int    行軍速度提高 =  0  ;
        int    進擊學員防禦提高   =  0  ;
        int    火力學員防禦提高   =  0  ;
        int    機動小組防禦提高   =  0  ;
        int    出征部隊上限增加1支 =  0  ;
        int    進擊學員生命提高   =  0  ;
        int    火力學員生命提高   =  0  ;
        int    機動小組生命提高   =  0  ;
        int    單支出兵上限提升   =  0  ;

        int    部隊攻擊力提升    =  0  ;
        int    部隊攻城攻擊力提升  =  0  ;
        int    野外戰鬥攻擊力提升  =  0  ;
        int    火力學員攻城攻擊力提升    =  0  ;
        int    機動小組攻城攻擊力提升    =  0  ;
        int    火力學員野外攻擊力提升    =  0  ;
        int    機動小組野外攻擊力提升    =  0  ;
        int    進擊學員攻城攻擊力提升    =  0  ;
        int    進擊學員野外攻擊力提升    =  0  ;
        int    行軍速度提升 =  0  ;
        int    攻城行軍速度提升   =  0  ;
        int    野外行軍速度提升   =  0  ;
        int    攻城防禦提升 =  0  ;
        int    攻擊指揮官總部攻擊力提升   =  0  ;
        int    火力學員攻城防禦力提升    =  0  ;
        int    車輛攻城防禦力提升  =  0  ;
        int    進擊學員攻城防禦力提升    =  0  ;
        int    攻擊巨炮攻擊力提升  =  0  ;

        int    部隊防禦力提升    =  0  ;
        int    部隊守城攻擊力提升  =  0  ;
        int    野外戰鬥防禦力提升  =  0  ;
        int    火力學員守城攻擊力提升    =  0  ;
        int    車輛守城攻擊力提升  =  0  ;
        int    火力學員野外防禦力提升    =  0  ;
        int    機動小組野外防禦力提升    =  0  ;
        int    進擊學員守城攻擊力提升    =  0  ;
        int    進擊學員野外防禦力提升    =  0  ;
        int    儲藏室容量提升    =  0  ;
        int    火力學員守城防禦力提升    =  0  ;
        int    車輛守城防禦力提升  =  0  ;
        int    部隊佔領指揮官總部防禦力提升 =  0  ;
        int    進擊學員守城防禦力提升    =  0  ;
        int    部隊佔領巨炮防禦力提升    =  0  ;
        int    傷兵上限提升 =  0  ;

        int    死體部隊行軍速度增加 =  0  ;
        int    死體兵防禦增加    =  0  ;
        int    死體兵攻擊增加    =  0  ;
        int    死體野外防禦力增加  =  0  ;
        int    死體野外攻擊力增加  =  0  ;
        int    死體負重增加 =  0  ;
        int    死體兵攻城攻擊增加  =  0  ;
        int    死體攻城防禦增加   =  0  ;
        int    死體守城攻擊增加   =  0  ;
        int    死體守城防禦增加   =  0  ;
        int    死體兵生命增加    =  0  ;

        /**
         *  RSS PART
         */
        if(rss01_S	.matches("0")){燃料生產率提高 = 燃料生產率提高+ 0;}	if(rss01_S	.matches("1")){燃料生產率提高 = 燃料生產率提高+ 2;}	if(rss01_S	.matches("2")){燃料生產率提高 = 燃料生產率提高+ 4;}	if(rss01_S	.matches("3")){燃料生產率提高 = 燃料生產率提高+ 6;}	if(rss01_S	.matches("4")){燃料生產率提高 = 燃料生產率提高+8;}	if(rss01_S	.matches("5")){燃料生產率提高 = 燃料生產率提高+ 10;}

        if(rss02_S	.matches("0")){食物生產率提高 = 食物生產率提高+ 0;}	if(rss02_S	.matches("1")){食物生產率提高 = 食物生產率提高+ 2;}	if(rss02_S	.matches("2")){食物生產率提高 = 食物生產率提高+ 4;}	if(rss02_S	.matches("3")){食物生產率提高 = 食物生產率提高+ 6;}	if(rss02_S	.matches("4")){食物生產率提高 = 食物生產率提高+8;}	if(rss02_S	.matches("5")){食物生產率提高 = 食物生產率提高+ 10;}

        if(rss03_S	.matches("0")){儲藏室保護資源增加 = 儲藏室保護資源增加+ 0;}	if(rss03_S	.matches("1")){儲藏室保護資源增加 = 儲藏室保護資源增加+ 2000;}	if(rss03_S	.matches("2")){儲藏室保護資源增加 = 儲藏室保護資源增加+ 4000;}	if(rss03_S	.matches("3")){儲藏室保護資源增加 = 儲藏室保護資源增加+ 6000;}	if(rss03_S	.matches("4")){儲藏室保護資源增加 = 儲藏室保護資源增加+8000;}	if(rss03_S	.matches("5")){儲藏室保護資源增加 = 儲藏室保護資源增加+ 10000;}

        if(rss04_S	.matches("0"))	{燃料採集速度增快 = 燃料採集速度增快+ 0;}
        if(rss04_S	.matches("1"))	{燃料採集速度增快 = 燃料採集速度增快+ 1;}
        if(rss04_S	.matches("2"))	{燃料採集速度增快 = 燃料採集速度增快+ 2;}
        if(rss04_S	.matches("3"))	{燃料採集速度增快 = 燃料採集速度增快+ 3;}
        if(rss04_S	.matches("4"))	{燃料採集速度增快 = 燃料採集速度增快+ 4;}
        if(rss04_S	.matches("5"))	{燃料採集速度增快 = 燃料採集速度增快+ 6;}
        if(rss04_S	.matches("6"))	{燃料採集速度增快 = 燃料採集速度增快+ 8;}
        if(rss04_S	.matches("7"))	{燃料採集速度增快 = 燃料採集速度增快+ 10;}
        if(rss04_S	.matches("8"))	{燃料採集速度增快 = 燃料採集速度增快+ 12;}
        if(rss04_S	.matches("9"))	{燃料採集速度增快 = 燃料採集速度增快+ 14;}
        if(rss04_S	.matches("10"))	{燃料採集速度增快 = 燃料採集速度增快+ 16;}
        if(rss04_S	.matches("11"))	{燃料採集速度增快 = 燃料採集速度增快+ 18;}
        if(rss04_S	.matches("12"))	{燃料採集速度增快 = 燃料採集速度增快+ 20;}
        if(rss04_S	.matches("13"))	{燃料採集速度增快 = 燃料採集速度增快+ 24;}
        if(rss04_S	.matches("14"))	{燃料採集速度增快 = 燃料採集速度增快+ 26;}
        if(rss04_S	.matches("15"))	{燃料採集速度增快 = 燃料採集速度增快+ 28;}

        if(rss05_S	.matches("0"))	{食物採集速度增快 = 食物採集速度增快+ 0;}
        if(rss05_S	.matches("1"))	{食物採集速度增快 = 食物採集速度增快+ 1;}
        if(rss05_S	.matches("2"))	{食物採集速度增快 = 食物採集速度增快+ 2;}
        if(rss05_S	.matches("3"))	{食物採集速度增快 = 食物採集速度增快+ 3;}
        if(rss05_S	.matches("4"))	{食物採集速度增快 = 食物採集速度增快+ 4;}
        if(rss05_S	.matches("5"))	{食物採集速度增快 = 食物採集速度增快+ 6;}
        if(rss05_S	.matches("6"))	{食物採集速度增快 = 食物採集速度增快+ 8;}
        if(rss05_S	.matches("7"))	{食物採集速度增快 = 食物採集速度增快+ 10;}
        if(rss05_S	.matches("8"))	{食物採集速度增快 = 食物採集速度增快+ 12;}
        if(rss05_S	.matches("9"))	{食物採集速度增快 = 食物採集速度增快+ 14;}
        if(rss05_S	.matches("10"))	{食物採集速度增快 = 食物採集速度增快+ 16;}
        if(rss05_S	.matches("11"))	{食物採集速度增快 = 食物採集速度增快+ 18;}
        if(rss05_S	.matches("12"))	{食物採集速度增快 = 食物採集速度增快+ 20;}
        if(rss05_S	.matches("13"))	{食物採集速度增快 = 食物採集速度增快+ 24;}
        if(rss05_S	.matches("14"))	{食物採集速度增快 = 食物採集速度增快+ 26;}
        if(rss05_S	.matches("15"))	{食物採集速度增快 = 食物採集速度增快+ 28;}

        if(rss06_S	.matches("0")){鋼鐵生產率提高 = 鋼鐵生產率提高+ 0;}	if(rss06_S	.matches("1")){鋼鐵生產率提高 = 鋼鐵生產率提高+ 2;}	if(rss06_S	.matches("2")){鋼鐵生產率提高 = 鋼鐵生產率提高+ 4;}	if(rss06_S	.matches("3")){鋼鐵生產率提高 = 鋼鐵生產率提高+ 6;}	if(rss06_S	.matches("4")){鋼鐵生產率提高 = 鋼鐵生產率提高+8;}	if(rss06_S	.matches("5")){鋼鐵生產率提高 = 鋼鐵生產率提高+ 10;}

        if(rss07_S	.matches("0"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 0;}
        if(rss07_S	.matches("1"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 1;}
        if(rss07_S	.matches("2"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 2;}
        if(rss07_S	.matches("3"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 3;}
        if(rss07_S	.matches("4"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 4;}
        if(rss07_S	.matches("5"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 6;}
        if(rss07_S	.matches("6"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 8;}
        if(rss07_S	.matches("7"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 10;}
        if(rss07_S	.matches("8"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 12;}
        if(rss07_S	.matches("9"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 14;}
        if(rss07_S	.matches("10"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 16;}
        if(rss07_S	.matches("11"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 18;}
        if(rss07_S	.matches("12"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 20;}
        if(rss07_S	.matches("13"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 24;}
        if(rss07_S	.matches("14"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 26;}
        if(rss07_S	.matches("15"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 28;}

        if(rss08_S	.matches("0")){合金生產率提高 = 合金生產率提高+ 0;}	if(rss08_S	.matches("1")){合金生產率提高 = 合金生產率提高+ 2;}	if(rss08_S	.matches("2")){合金生產率提高 = 合金生產率提高+ 4;}	if(rss08_S	.matches("3")){合金生產率提高 = 合金生產率提高+ 6;}	if(rss08_S	.matches("4")){合金生產率提高 = 合金生產率提高+8;}	if(rss08_S	.matches("5")){合金生產率提高 = 合金生產率提高+ 10;}

        if(rss09_S	.matches("0"))	{合金採集速度增快 = 合金採集速度增快+ 0;}
        if(rss09_S	.matches("1"))	{合金採集速度增快 = 合金採集速度增快+ 1;}
        if(rss09_S	.matches("2"))	{合金採集速度增快 = 合金採集速度增快+ 2;}
        if(rss09_S	.matches("3"))	{合金採集速度增快 = 合金採集速度增快+ 3;}
        if(rss09_S	.matches("4"))	{合金採集速度增快 = 合金採集速度增快+ 4;}
        if(rss09_S	.matches("5"))	{合金採集速度增快 = 合金採集速度增快+ 6;}
        if(rss09_S	.matches("6"))	{合金採集速度增快 = 合金採集速度增快+ 8;}
        if(rss09_S	.matches("7"))	{合金採集速度增快 = 合金採集速度增快+ 10;}
        if(rss09_S	.matches("8"))	{合金採集速度增快 = 合金採集速度增快+ 12;}
        if(rss09_S	.matches("9"))	{合金採集速度增快 = 合金採集速度增快+ 14;}
        if(rss09_S	.matches("10"))	{合金採集速度增快 = 合金採集速度增快+ 16;}
        if(rss09_S	.matches("11"))	{合金採集速度增快 = 合金採集速度增快+ 18;}
        if(rss09_S	.matches("12"))	{合金採集速度增快 = 合金採集速度增快+ 20;}
        if(rss09_S	.matches("13"))	{合金採集速度增快 = 合金採集速度增快+ 24;}
        if(rss09_S	.matches("14"))	{合金採集速度增快 = 合金採集速度增快+ 26;}
        if(rss09_S	.matches("15"))	{合金採集速度增快 = 合金採集速度增快+ 28;}

        if(rss10_S	.matches("0")){鑽石採集速度增加 = 鑽石採集速度增加+ 0;}	if(rss10_S	.matches("1")){鑽石採集速度增加 = 鑽石採集速度增加+ 2;}	if(rss10_S	.matches("2")){鑽石採集速度增加 = 鑽石採集速度增加+ 4;}	if(rss10_S	.matches("3")){鑽石採集速度增加 = 鑽石採集速度增加+ 6;}	if(rss10_S	.matches("4")){鑽石採集速度增加 = 鑽石採集速度增加+8;}	if(rss10_S	.matches("5")){鑽石採集速度增加 = 鑽石採集速度增加+ 10;}

        if(rss11_S	.matches("0"))	{燃料生產率提高 = 燃料生產率提高+ 0;}
        if(rss11_S	.matches("1"))	{燃料生產率提高 = 燃料生產率提高+ 2;}
        if(rss11_S	.matches("2"))	{燃料生產率提高 = 燃料生產率提高+ 4;}
        if(rss11_S	.matches("3"))	{燃料生產率提高 = 燃料生產率提高+ 6;}
        if(rss11_S	.matches("4"))	{燃料生產率提高 = 燃料生產率提高+ 8;}
        if(rss11_S	.matches("5"))	{燃料生產率提高 = 燃料生產率提高+ 10;}
        if(rss11_S	.matches("6"))	{燃料生產率提高 = 燃料生產率提高+ 12;}
        if(rss11_S	.matches("7"))	{燃料生產率提高 = 燃料生產率提高+ 14;}
        if(rss11_S	.matches("8"))	{燃料生產率提高 = 燃料生產率提高+ 16;}
        if(rss11_S	.matches("9"))	{燃料生產率提高 = 燃料生產率提高+ 18;}
        if(rss11_S	.matches("10"))	{燃料生產率提高 = 燃料生產率提高+ 20;}
        if(rss11_S	.matches("11"))	{燃料生產率提高 = 燃料生產率提高+ 22;}
        if(rss11_S	.matches("12"))	{燃料生產率提高 = 燃料生產率提高+ 24;}
        if(rss11_S	.matches("13"))	{燃料生產率提高 = 燃料生產率提高+ 26;}
        if(rss11_S	.matches("14"))	{燃料生產率提高 = 燃料生產率提高+ 28;}
        if(rss11_S	.matches("15"))	{燃料生產率提高 = 燃料生產率提高+ 30;}

        if(rss12_S	.matches("0"))	{食物生產率提高 = 食物生產率提高+ 0;}
        if(rss12_S	.matches("1"))	{食物生產率提高 = 食物生產率提高+ 2;}
        if(rss12_S	.matches("2"))	{食物生產率提高 = 食物生產率提高+ 4;}
        if(rss12_S	.matches("3"))	{食物生產率提高 = 食物生產率提高+ 6;}
        if(rss12_S	.matches("4"))	{食物生產率提高 = 食物生產率提高+ 8;}
        if(rss12_S	.matches("5"))	{食物生產率提高 = 食物生產率提高+ 10;}
        if(rss12_S	.matches("6"))	{食物生產率提高 = 食物生產率提高+ 12;}
        if(rss12_S	.matches("7"))	{食物生產率提高 = 食物生產率提高+ 14;}
        if(rss12_S	.matches("8"))	{食物生產率提高 = 食物生產率提高+ 16;}
        if(rss12_S	.matches("9"))	{食物生產率提高 = 食物生產率提高+ 18;}
        if(rss12_S	.matches("10"))	{食物生產率提高 = 食物生產率提高+ 20;}
        if(rss12_S	.matches("11"))	{食物生產率提高 = 食物生產率提高+ 22;}
        if(rss12_S	.matches("12"))	{食物生產率提高 = 食物生產率提高+ 24;}
        if(rss12_S	.matches("13"))	{食物生產率提高 = 食物生產率提高+ 26;}
        if(rss12_S	.matches("14"))	{食物生產率提高 = 食物生產率提高+ 28;}
        if(rss12_S	.matches("15"))	{食物生產率提高 = 食物生產率提高+ 30;}

        if(rss13_S	.matches("0")){儲藏室保護資源增加 = 儲藏室保護資源增加+ 0;}
        if(rss13_S	.matches("1")){儲藏室保護資源增加 = 儲藏室保護資源增加+ 2000;}
        if(rss13_S	.matches("2")){儲藏室保護資源增加 = 儲藏室保護資源增加+ 4000;}
        if(rss13_S	.matches("3")){儲藏室保護資源增加 = 儲藏室保護資源增加+ 6000;}
        if(rss13_S	.matches("4")){儲藏室保護資源增加 = 儲藏室保護資源增加+8000;}
        if(rss13_S	.matches("5")){儲藏室保護資源增加 = 儲藏室保護資源增加+ 10000;}
        if(rss13_S	.matches("6")){儲藏室保護資源增加 = 儲藏室保護資源增加+ 12000;}
        if(rss13_S	.matches("7")){儲藏室保護資源增加 = 儲藏室保護資源增加+ 14000;}
        if(rss13_S	.matches("8")){儲藏室保護資源增加 = 儲藏室保護資源增加+ 1600;}
        if(rss13_S	.matches("9")){儲藏室保護資源增加 = 儲藏室保護資源增加+18000;}
        if(rss13_S	.matches("10")){儲藏室保護資源增加 = 儲藏室保護資源增加+ 20000;}

        if(rss14_S	.matches("0"))	{燃料採集速度增快 = 燃料採集速度增快+ 0;}
        if(rss14_S	.matches("1"))	{燃料採集速度增快 = 燃料採集速度增快+ 1;}
        if(rss14_S	.matches("2"))	{燃料採集速度增快 = 燃料採集速度增快+ 2;}
        if(rss14_S	.matches("3"))	{燃料採集速度增快 = 燃料採集速度增快+ 3;}
        if(rss14_S	.matches("4"))	{燃料採集速度增快 = 燃料採集速度增快+ 4;}
        if(rss14_S	.matches("5"))	{燃料採集速度增快 = 燃料採集速度增快+ 6;}
        if(rss14_S	.matches("6"))	{燃料採集速度增快 = 燃料採集速度增快+ 8;}
        if(rss14_S	.matches("7"))	{燃料採集速度增快 = 燃料採集速度增快+ 10;}
        if(rss14_S	.matches("8"))	{燃料採集速度增快 = 燃料採集速度增快+ 12;}
        if(rss14_S	.matches("9"))	{燃料採集速度增快 = 燃料採集速度增快+ 14;}
        if(rss14_S	.matches("10"))	{燃料採集速度增快 = 燃料採集速度增快+ 16;}
        if(rss14_S	.matches("11"))	{燃料採集速度增快 = 燃料採集速度增快+ 18;}
        if(rss14_S	.matches("12"))	{燃料採集速度增快 = 燃料採集速度增快+ 20;}
        if(rss14_S	.matches("13"))	{燃料採集速度增快 = 燃料採集速度增快+ 24;}
        if(rss14_S	.matches("14"))	{燃料採集速度增快 = 燃料採集速度增快+ 26;}
        if(rss14_S	.matches("15"))	{燃料採集速度增快 = 燃料採集速度增快+ 28;}

        if(rss15_S	.matches("0"))	{食物採集速度增快 = 食物採集速度增快+ 0;}
        if(rss15_S	.matches("1"))	{食物採集速度增快 = 食物採集速度增快+ 1;}
        if(rss15_S	.matches("2"))	{食物採集速度增快 = 食物採集速度增快+ 2;}
        if(rss15_S	.matches("3"))	{食物採集速度增快 = 食物採集速度增快+ 3;}
        if(rss15_S	.matches("4"))	{食物採集速度增快 = 食物採集速度增快+ 4;}
        if(rss15_S	.matches("5"))	{食物採集速度增快 = 食物採集速度增快+ 6;}
        if(rss15_S	.matches("6"))	{食物採集速度增快 = 食物採集速度增快+ 8;}
        if(rss15_S	.matches("7"))	{食物採集速度增快 = 食物採集速度增快+ 10;}
        if(rss15_S	.matches("8"))	{食物採集速度增快 = 食物採集速度增快+ 12;}
        if(rss15_S	.matches("9"))	{食物採集速度增快 = 食物採集速度增快+ 14;}
        if(rss15_S	.matches("10"))	{食物採集速度增快 = 食物採集速度增快+ 16;}
        if(rss15_S	.matches("11"))	{食物採集速度增快 = 食物採集速度增快+ 18;}
        if(rss15_S	.matches("12"))	{食物採集速度增快 = 食物採集速度增快+ 20;}
        if(rss15_S	.matches("13"))	{食物採集速度增快 = 食物採集速度增快+ 24;}
        if(rss15_S	.matches("14"))	{食物採集速度增快 = 食物採集速度增快+ 26;}
        if(rss15_S	.matches("15"))	{食物採集速度增快 = 食物採集速度增快+ 28;}

        if(rss16_S	.matches("0"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 0;}
        if(rss16_S	.matches("1"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 2;}
        if(rss16_S	.matches("2"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 4;}
        if(rss16_S	.matches("3"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 6;}
        if(rss16_S	.matches("4"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 8;}
        if(rss16_S	.matches("5"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 10;}
        if(rss16_S	.matches("6"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 12;}
        if(rss16_S	.matches("7"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 14;}
        if(rss16_S	.matches("8"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 16;}
        if(rss16_S	.matches("9"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 18;}
        if(rss16_S	.matches("10"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 20;}
        if(rss16_S	.matches("11"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 22;}
        if(rss16_S	.matches("12"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 24;}
        if(rss16_S	.matches("13"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 26;}
        if(rss16_S	.matches("14"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 28;}
        if(rss16_S	.matches("15"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 30;}

        if(rss17_S	.matches("0"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 0;}
        if(rss17_S	.matches("1"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 1;}
        if(rss17_S	.matches("2"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 2;}
        if(rss17_S	.matches("3"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 3;}
        if(rss17_S	.matches("4"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 4;}
        if(rss17_S	.matches("5"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 6;}
        if(rss17_S	.matches("6"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 8;}
        if(rss17_S	.matches("7"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 10;}
        if(rss17_S	.matches("8"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 12;}
        if(rss17_S	.matches("9"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 14;}
        if(rss17_S	.matches("10"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 16;}
        if(rss17_S	.matches("11"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 18;}
        if(rss17_S	.matches("12"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 20;}
        if(rss17_S	.matches("13"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 24;}
        if(rss17_S	.matches("14"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 26;}
        if(rss17_S	.matches("15"))	{鋼鐵採集速度增快 = 鋼鐵採集速度增快+ 28;}

        if(rss18_S	.matches("0"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 0;}
        if(rss18_S	.matches("1"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 2;}
        if(rss18_S	.matches("2"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 4;}
        if(rss18_S	.matches("3"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 6;}
        if(rss18_S	.matches("4"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 8;}
        if(rss18_S	.matches("5"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 10;}
        if(rss18_S	.matches("6"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 12;}
        if(rss18_S	.matches("7"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 14;}
        if(rss18_S	.matches("8"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 16;}
        if(rss18_S	.matches("9"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 18;}
        if(rss18_S	.matches("10"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 20;}
        if(rss18_S	.matches("11"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 22;}
        if(rss18_S	.matches("12"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 24;}
        if(rss18_S	.matches("13"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 26;}
        if(rss18_S	.matches("14"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 28;}
        if(rss18_S	.matches("15"))	{鋼鐵生產率提高 = 鋼鐵生產率提高+ 30;}

        if(rss19_S	.matches("0"))	{合金採集速度增快 = 合金採集速度增快+ 0;}
        if(rss19_S	.matches("1"))	{合金採集速度增快 = 合金採集速度增快+ 1;}
        if(rss19_S	.matches("2"))	{合金採集速度增快 = 合金採集速度增快+ 2;}
        if(rss19_S	.matches("3"))	{合金採集速度增快 = 合金採集速度增快+ 3;}
        if(rss19_S	.matches("4"))	{合金採集速度增快 = 合金採集速度增快+ 4;}
        if(rss19_S	.matches("5"))	{合金採集速度增快 = 合金採集速度增快+ 6;}
        if(rss19_S	.matches("6"))	{合金採集速度增快 = 合金採集速度增快+ 8;}
        if(rss19_S	.matches("7"))	{合金採集速度增快 = 合金採集速度增快+ 10;}
        if(rss19_S	.matches("8"))	{合金採集速度增快 = 合金採集速度增快+ 12;}
        if(rss19_S	.matches("9"))	{合金採集速度增快 = 合金採集速度增快+ 14;}
        if(rss19_S	.matches("10"))	{合金採集速度增快 = 合金採集速度增快+ 16;}
        if(rss19_S	.matches("11"))	{合金採集速度增快 = 合金採集速度增快+ 18;}
        if(rss19_S	.matches("12"))	{合金採集速度增快 = 合金採集速度增快+ 20;}
        if(rss19_S	.matches("13"))	{合金採集速度增快 = 合金採集速度增快+ 24;}
        if(rss19_S	.matches("14"))	{合金採集速度增快 = 合金採集速度增快+ 26;}
        if(rss19_S	.matches("15"))	{合金採集速度增快 = 合金採集速度增快+ 28;}

        if(rss20_S	.matches("0")){鑽石採集速度增加 = 鑽石採集速度增加+ 0;}
        if(rss20_S	.matches("1")){鑽石採集速度增加 = 鑽石採集速度增加+ 1;}
        if(rss20_S	.matches("2")){鑽石採集速度增加 = 鑽石採集速度增加+ 2;}
        if(rss20_S	.matches("3")){鑽石採集速度增加 = 鑽石採集速度增加+ 3;}
        if(rss20_S	.matches("4")){鑽石採集速度增加 = 鑽石採集速度增加+4;}
        if(rss20_S	.matches("5")){鑽石採集速度增加 = 鑽石採集速度增加+ 5;}
        if(rss20_S	.matches("6")){鑽石採集速度增加 = 鑽石採集速度增加+ 6;}
        if(rss20_S	.matches("7")){鑽石採集速度增加 = 鑽石採集速度增加+ 7;}
        if(rss20_S	.matches("8")){鑽石採集速度增加 = 鑽石採集速度增加+ 8;}
        if(rss20_S	.matches("9")){鑽石採集速度增加 = 鑽石採集速度增加+9;}
        if(rss20_S	.matches("10")){鑽石採集速度增加 = 鑽石採集速度增加+ 10;}

        /**
         *  RSS PART
         *  --------------
         *  SCH PART
         */

        if(sch01_S	.matches("0")){部隊負重提高 = 部隊負重提高+	0	;}
        if(sch01_S	.matches("1")){部隊負重提高 = 部隊負重提高+	1	;}
        if(sch01_S	.matches("2")){部隊負重提高 = 部隊負重提高+	2	;}
        if(sch01_S	.matches("3")){部隊負重提高 = 部隊負重提高+	3	;}
        if(sch01_S	.matches("4")){部隊負重提高 = 部隊負重提高+	4	;}
        if(sch01_S	.matches("5")){部隊負重提高 = 部隊負重提高+	5	;}
        if(sch01_S	.matches("6")){部隊負重提高 = 部隊負重提高+	7	;}
        if(sch01_S	.matches("7")){部隊負重提高 = 部隊負重提高+	9	;}
        if(sch01_S	.matches("8")){部隊負重提高 = 部隊負重提高+	11	;}
        if(sch01_S	.matches("9")){部隊負重提高 = 部隊負重提高+	12	;}
        if(sch01_S	.matches("10")){部隊負重提高 = 部隊負重提高+	15	;}

        if(sch02_S	.matches("0")){增加打怪行軍速度 = 增加打怪行軍速度+	0	;}
        if(sch02_S	.matches("1")){增加打怪行軍速度 = 增加打怪行軍速度+	2	;}
        if(sch02_S	.matches("2")){增加打怪行軍速度 = 增加打怪行軍速度+	4	;}
        if(sch02_S	.matches("3")){增加打怪行軍速度 = 增加打怪行軍速度+	6	;}
        if(sch02_S	.matches("4")){增加打怪行軍速度 = 增加打怪行軍速度+	8	;}
        if(sch02_S	.matches("5")){增加打怪行軍速度 = 增加打怪行軍速度+	10	;}

        if(sch03_S	.matches("0")){體力恢復加速 = 體力恢復加速+	0	;}
        if(sch03_S	.matches("1")){體力恢復加速 = 體力恢復加速+	1	;}
        if(sch03_S	.matches("2")){體力恢復加速 = 體力恢復加速+	2	;}
        if(sch03_S	.matches("3")){體力恢復加速 = 體力恢復加速+	3	;}
        if(sch03_S	.matches("4")){體力恢復加速 = 體力恢復加速+	4	;}
        if(sch03_S	.matches("5")){體力恢復加速 = 體力恢復加速+	5	;}

        if(sch04_S	.matches("0")){建築建造速度加快 = 建築建造速度加快+	0	;}
        if(sch04_S	.matches("1")){建築建造速度加快 = 建築建造速度加快+	1	;}
        if(sch04_S	.matches("2")){建築建造速度加快 = 建築建造速度加快+	2	;}
        if(sch04_S	.matches("3")){建築建造速度加快 = 建築建造速度加快+	3	;}
        if(sch04_S	.matches("4")){建築建造速度加快 = 建築建造速度加快+	4	;}
        if(sch04_S	.matches("5")){建築建造速度加快 = 建築建造速度加快+	5	;}
        if(sch04_S	.matches("6")){建築建造速度加快 = 建築建造速度加快+	6	;}
        if(sch04_S	.matches("7")){建築建造速度加快 = 建築建造速度加快+	7	;}
        if(sch04_S	.matches("8")){建築建造速度加快 = 建築建造速度加快+	8	;}
        if(sch04_S	.matches("9")){建築建造速度加快 = 建築建造速度加快+	9	;}
        if(sch04_S	.matches("10")){建築建造速度加快 = 建築建造速度加快+	12	;}

        if(sch05_S	.matches("0")){傷兵數量上限提高 = 傷兵數量上限提高+	0	;}
        if(sch05_S	.matches("1")){傷兵數量上限提高 = 傷兵數量上限提高+	2000 	;}
        if(sch05_S	.matches("2")){傷兵數量上限提高 = 傷兵數量上限提高+	4000 	;}
        if(sch05_S	.matches("3")){傷兵數量上限提高 = 傷兵數量上限提高+	6000 	;}
        if(sch05_S	.matches("4")){傷兵數量上限提高 = 傷兵數量上限提高+	8000 	;}
        if(sch05_S	.matches("5")){傷兵數量上限提高 = 傷兵數量上限提高+	10000 	;}
        if(sch05_S	.matches("6")){傷兵數量上限提高 = 傷兵數量上限提高+	12000 	;}
        if(sch05_S	.matches("7")){傷兵數量上限提高 = 傷兵數量上限提高+	14000 	;}
        if(sch05_S	.matches("8")){傷兵數量上限提高 = 傷兵數量上限提高+	16000 	;}
        if(sch05_S	.matches("9")){傷兵數量上限提高 = 傷兵數量上限提高+	18000 	;}
        if(sch05_S	.matches("10")){傷兵數量上限提高 = 傷兵數量上限提高+	20000 	;}

        if(sch06_S	.matches("0")){傷兵恢復速度加快 = 傷兵恢復速度加快+	0	;}
        if(sch06_S	.matches("1")){傷兵恢復速度加快 = 傷兵恢復速度加快+	2 	;}
        if(sch06_S	.matches("2")){傷兵恢復速度加快 = 傷兵恢復速度加快+	4 	;}
        if(sch06_S	.matches("3")){傷兵恢復速度加快 = 傷兵恢復速度加快+	6 	;}
        if(sch06_S	.matches("4")){傷兵恢復速度加快 = 傷兵恢復速度加快+	8 	;}
        if(sch06_S	.matches("5")){傷兵恢復速度加快 = 傷兵恢復速度加快+	10 	;}
        if(sch06_S	.matches("6")){傷兵恢復速度加快 = 傷兵恢復速度加快+	12 	;}
        if(sch06_S	.matches("7")){傷兵恢復速度加快 = 傷兵恢復速度加快+	14 	;}
        if(sch06_S	.matches("8")){傷兵恢復速度加快 = 傷兵恢復速度加快+	16 	;}
        if(sch06_S	.matches("9")){傷兵恢復速度加快 = 傷兵恢復速度加快+	18 	;}
        if(sch06_S	.matches("10")){傷兵恢復速度加快 = 傷兵恢復速度加快+	20 	;}

        if(sch07_S	.matches("0")){部隊消耗食物降低 = 部隊消耗食物降低+	0	;}
        if(sch07_S	.matches("1")){部隊消耗食物降低 = 部隊消耗食物降低+	2	;}
        if(sch07_S	.matches("2")){部隊消耗食物降低 = 部隊消耗食物降低+	4	;}
        if(sch07_S	.matches("3")){部隊消耗食物降低 = 部隊消耗食物降低+	6	;}
        if(sch07_S	.matches("4")){部隊消耗食物降低 = 部隊消耗食物降低+	8	;}
        if(sch07_S	.matches("5")){部隊消耗食物降低 = 部隊消耗食物降低+	10	;}

        if(sch08_S	.matches("0")){增加打怪行軍速度 = 增加打怪行軍速度 +	0	;}
        if(sch08_S	.matches("1")){增加打怪行軍速度 = 增加打怪行軍速度 +	4	;}
        if(sch08_S	.matches("2")){增加打怪行軍速度 = 增加打怪行軍速度 +	8	;}
        if(sch08_S	.matches("3")){增加打怪行軍速度 = 增加打怪行軍速度 +	12	;}
        if(sch08_S	.matches("4")){增加打怪行軍速度 = 增加打怪行軍速度 +	16	;}
        if(sch08_S	.matches("5")){增加打怪行軍速度 = 增加打怪行軍速度 +	20	;}
        if(sch08_S	.matches("6")){增加打怪行軍速度 = 增加打怪行軍速度 +	25	;}
        if(sch08_S	.matches("7")){增加打怪行軍速度 = 增加打怪行軍速度 +	30	;}
        if(sch08_S	.matches("8")){增加打怪行軍速度 = 增加打怪行軍速度 +	35	;}
        if(sch08_S	.matches("9")){增加打怪行軍速度 = 增加打怪行軍速度 +	40	;}
        if(sch08_S	.matches("10")){增加打怪行軍速度 = 增加打怪行軍速度 +	45	;}

        if(sch09_S	.matches("0")){體力恢復加速 = 體力恢復加速 +	0	;}
        if(sch09_S	.matches("1")){體力恢復加速 = 體力恢復加速 +	1	;}
        if(sch09_S	.matches("2")){體力恢復加速 = 體力恢復加速 +	2	;}
        if(sch09_S	.matches("3")){體力恢復加速 = 體力恢復加速 +	3	;}
        if(sch09_S	.matches("4")){體力恢復加速 = 體力恢復加速 +	4	;}
        if(sch09_S	.matches("5")){體力恢復加速 = 體力恢復加速 +	5	;}
        if(sch09_S	.matches("6")){體力恢復加速 = 體力恢復加速 +	7	;}
        if(sch09_S	.matches("7")){體力恢復加速 = 體力恢復加速 +	9	;}
        if(sch09_S	.matches("8")){體力恢復加速 = 體力恢復加速 +	11	;}
        if(sch09_S	.matches("9")){體力恢復加速 = 體力恢復加速 +	13	;}
        if(sch09_S	.matches("10")){體力恢復加速 = 體力恢復加速 +	15	;}

        if(sch10_S	.matches("0")){部隊負重提高 = 部隊負重提高 +	0	;}
        if(sch10_S	.matches("1")){部隊負重提高 = 部隊負重提高 +	2	;}
        if(sch10_S	.matches("2")){部隊負重提高 = 部隊負重提高 +	4	;}
        if(sch10_S	.matches("3")){部隊負重提高 = 部隊負重提高 +	6	;}
        if(sch10_S	.matches("4")){部隊負重提高 = 部隊負重提高 +	8	;}
        if(sch10_S	.matches("5")){部隊負重提高 = 部隊負重提高 +	10	;}
        if(sch10_S	.matches("6")){部隊負重提高 = 部隊負重提高 +	12	;}
        if(sch10_S	.matches("7")){部隊負重提高 = 部隊負重提高 +	14	;}
        if(sch10_S	.matches("8")){部隊負重提高 = 部隊負重提高 +	16	;}
        if(sch10_S	.matches("9")){部隊負重提高 = 部隊負重提高 +	18	;}
        if(sch10_S	.matches("10")){部隊負重提高 = 部隊負重提高 +	20	;}
        if(sch10_S	.matches("11")){部隊負重提高 = 部隊負重提高 +	22	;}
        if(sch10_S	.matches("12")){部隊負重提高 = 部隊負重提高 +	24	;}
        if(sch10_S	.matches("13")){部隊負重提高 = 部隊負重提高 +	26	;}
        if(sch10_S	.matches("14")){部隊負重提高 = 部隊負重提高 +	28	;}
        if(sch10_S	.matches("15")){部隊負重提高 = 部隊負重提高 +	30	;}

        if(sch11_S	.matches("0")){建築建造速度加快 = 建築建造速度加快 +	0	;}
        if(sch11_S	.matches("1")){建築建造速度加快 = 建築建造速度加快 +	1	;}
        if(sch11_S	.matches("2")){建築建造速度加快 = 建築建造速度加快 +	2	;}
        if(sch11_S	.matches("3")){建築建造速度加快 = 建築建造速度加快 +	3	;}
        if(sch11_S	.matches("4")){建築建造速度加快 = 建築建造速度加快 +	4	;}
        if(sch11_S	.matches("5")){建築建造速度加快 = 建築建造速度加快 +	5	;}
        if(sch11_S	.matches("6")){建築建造速度加快 = 建築建造速度加快 +	6	;}
        if(sch11_S	.matches("7")){建築建造速度加快 = 建築建造速度加快 +	7	;}
        if(sch11_S	.matches("8")){建築建造速度加快 = 建築建造速度加快 +	8	;}
        if(sch11_S	.matches("9")){建築建造速度加快 = 建築建造速度加快 +	9	;}
        if(sch11_S	.matches("10")){建築建造速度加快 = 建築建造速度加快 +	10	;}
        if(sch11_S	.matches("11")){建築建造速度加快 = 建築建造速度加快 +	11	;}
        if(sch11_S	.matches("12")){建築建造速度加快 = 建築建造速度加快 +	12	;}
        if(sch11_S	.matches("13")){建築建造速度加快 = 建築建造速度加快 +	13	;}
        if(sch11_S	.matches("14")){建築建造速度加快 = 建築建造速度加快 +	15	;}
        if(sch11_S	.matches("15")){建築建造速度加快 = 建築建造速度加快 +	18	;}

        if(sch12_S	.matches("0")){傷兵數量上限提高 = 傷兵數量上限提高 +	0 	;}
        if(sch12_S	.matches("1")){傷兵數量上限提高 = 傷兵數量上限提高 +	2000 	;}
        if(sch12_S	.matches("2")){傷兵數量上限提高 = 傷兵數量上限提高 +	4000 	;}
        if(sch12_S	.matches("3")){傷兵數量上限提高 = 傷兵數量上限提高 +	6000 	;}
        if(sch12_S	.matches("4")){傷兵數量上限提高 = 傷兵數量上限提高 +	8000 	;}
        if(sch12_S	.matches("5")){傷兵數量上限提高 = 傷兵數量上限提高 +	10000	;}
        if(sch12_S	.matches("6")){傷兵數量上限提高 = 傷兵數量上限提高 +	12000 	;}
        if(sch12_S	.matches("7")){傷兵數量上限提高 = 傷兵數量上限提高 +	14000 	;}
        if(sch12_S	.matches("8")){傷兵數量上限提高 = 傷兵數量上限提高 +	16000 	;}
        if(sch12_S	.matches("9")){傷兵數量上限提高 = 傷兵數量上限提高 +	18000 	;}
        if(sch12_S	.matches("10")){傷兵數量上限提高 = 傷兵數量上限提高 +	20000 	;}
        if(sch12_S	.matches("11")){傷兵數量上限提高 = 傷兵數量上限提高 +	22000 	;}
        if(sch12_S	.matches("12")){傷兵數量上限提高 = 傷兵數量上限提高 +	24000 	;}
        if(sch12_S	.matches("13")){傷兵數量上限提高 = 傷兵數量上限提高 +	26000 	;}
        if(sch12_S	.matches("14")){傷兵數量上限提高 = 傷兵數量上限提高 +	28000 	;}
        if(sch12_S	.matches("15")){傷兵數量上限提高 = 傷兵數量上限提高 +	30000 	;}

        if(sch13_S	.matches("0")){傷兵恢復速度加快 = 傷兵恢復速度加快 +	0 	;}
        if(sch13_S	.matches("1")){傷兵恢復速度加快 = 傷兵恢復速度加快 +	2	;}
        if(sch13_S	.matches("2")){傷兵恢復速度加快 = 傷兵恢復速度加快 +	4	;}
        if(sch13_S	.matches("3")){傷兵恢復速度加快 = 傷兵恢復速度加快 +	6	;}
        if(sch13_S	.matches("4")){傷兵恢復速度加快 = 傷兵恢復速度加快 +	8	;}
        if(sch13_S	.matches("5")){傷兵恢復速度加快 = 傷兵恢復速度加快 +	10	;}
        if(sch13_S	.matches("6")){傷兵恢復速度加快 = 傷兵恢復速度加快 +	12	;}
        if(sch13_S	.matches("7")){傷兵恢復速度加快 = 傷兵恢復速度加快 +	14	;}
        if(sch13_S	.matches("8")){傷兵恢復速度加快 = 傷兵恢復速度加快 +	16	;}
        if(sch13_S	.matches("9")){傷兵恢復速度加快 = 傷兵恢復速度加快 +	18	;}
        if(sch13_S	.matches("10")){傷兵恢復速度加快 = 傷兵恢復速度加快 +	20	;}
        if(sch13_S	.matches("11")){傷兵恢復速度加快 = 傷兵恢復速度加快 +	22	;}
        if(sch13_S	.matches("12")){傷兵恢復速度加快 = 傷兵恢復速度加快 +	24	;}
        if(sch13_S	.matches("13")){傷兵恢復速度加快 = 傷兵恢復速度加快 +	26	;}
        if(sch13_S	.matches("14")){傷兵恢復速度加快 = 傷兵恢復速度加快 +	28	;}
        if(sch13_S	.matches("15")){傷兵恢復速度加快 = 傷兵恢復速度加快 +	30	;}

        if(sch14_S	.matches("0")){部隊消耗食物降低 = 部隊消耗食物降低 +	0 	;}
        if(sch14_S	.matches("1")){部隊消耗食物降低 = 部隊消耗食物降低 +	1	;}
        if(sch14_S	.matches("2")){部隊消耗食物降低 = 部隊消耗食物降低 +	2	;}
        if(sch14_S	.matches("3")){部隊消耗食物降低 = 部隊消耗食物降低 +	3	;}
        if(sch14_S	.matches("4")){部隊消耗食物降低 = 部隊消耗食物降低 +	4	;}
        if(sch14_S	.matches("5")){部隊消耗食物降低 = 部隊消耗食物降低 +	5	;}
        if(sch14_S	.matches("6")){部隊消耗食物降低 = 部隊消耗食物降低 +	6	;}
        if(sch14_S	.matches("7")){部隊消耗食物降低 = 部隊消耗食物降低 +	7	;}
        if(sch14_S	.matches("8")){部隊消耗食物降低 = 部隊消耗食物降低 +	8	;}
        if(sch14_S	.matches("9")){部隊消耗食物降低 = 部隊消耗食物降低 +	9	;}
        if(sch14_S	.matches("10")){部隊消耗食物降低 = 部隊消耗食物降低 +	10	;}
        if(sch14_S	.matches("11")){部隊消耗食物降低 = 部隊消耗食物降低 +	11	;}
        if(sch14_S	.matches("12")){部隊消耗食物降低 = 部隊消耗食物降低 +	12	;}
        if(sch14_S	.matches("13")){部隊消耗食物降低 = 部隊消耗食物降低 +	13	;}
        if(sch14_S	.matches("14")){部隊消耗食物降低 = 部隊消耗食物降低 +	14	;}
        if(sch14_S	.matches("15")){部隊消耗食物降低 = 部隊消耗食物降低 +	15	;}

        /**
         *  SCH PART
         *  --------------
         *  DEF PART
         */

        if(def01_S	.matches("0")){城防值增加 = 城防值增加+	0	;}
        if(def01_S	.matches("1")){城防值增加 = 城防值增加+	90 	;}
        if(def01_S	.matches("2")){城防值增加 = 城防值增加+	180 	;}
        if(def01_S	.matches("3")){城防值增加 = 城防值增加+	270 	;}
        if(def01_S	.matches("4")){城防值增加 = 城防值增加+	360 	;}
        if(def01_S	.matches("5")){城防值增加 = 城防值增加+	450 	;}
        if(def01_S	.matches("6")){城防值增加 = 城防值增加+	540 	;}
        if(def01_S	.matches("7")){城防值增加 = 城防值增加+	630 	;}
        if(def01_S	.matches("8")){城防值增加 = 城防值增加+	720 	;}
        if(def01_S	.matches("9")){城防值增加 = 城防值增加+	810 	;}
        if(def01_S	.matches("10")){城防值增加 = 城防值增加+	900 	;}

        if(def02_S	.matches("0")){守軍攻擊增加 = 守軍攻擊增加 +	0	;}
        if(def02_S	.matches("1")){守軍攻擊增加 = 守軍攻擊增加 +	1	;}
        if(def02_S	.matches("2")){守軍攻擊增加 = 守軍攻擊增加 +	2	;}
        if(def02_S	.matches("3")){守軍攻擊增加 = 守軍攻擊增加 +	3	;}
        if(def02_S	.matches("4")){守軍攻擊增加 = 守軍攻擊增加 +	4	;}
        if(def02_S	.matches("5")){守軍攻擊增加 = 守軍攻擊增加 +	5	;}

        if(def03_S	.matches("0")){守軍防禦增加 = 守軍防禦增加 +	0	;}
        if(def03_S	.matches("1")){守軍防禦增加 = 守軍防禦增加 +	1	;}
        if(def03_S	.matches("2")){守軍防禦增加 = 守軍防禦增加 +	2	;}
        if(def03_S	.matches("3")){守軍防禦增加 = 守軍防禦增加 +	3	;}
        if(def03_S	.matches("4")){守軍防禦增加 = 守軍防禦增加 +	4	;}
        if(def03_S	.matches("5")){守軍防禦增加 = 守軍防禦增加 +	5	;}

        if(def04_S	.matches("0")){防禦武器攻擊增加 = 防禦武器攻擊增加 +	0	;}
        if(def04_S	.matches("1")){防禦武器攻擊增加 = 防禦武器攻擊增加 +	1	;}
        if(def04_S	.matches("2")){防禦武器攻擊增加 = 防禦武器攻擊增加 +	2	;}
        if(def04_S	.matches("3")){防禦武器攻擊增加 = 防禦武器攻擊增加 +	3	;}
        if(def04_S	.matches("4")){防禦武器攻擊增加 = 防禦武器攻擊增加 +	4	;}
        if(def04_S	.matches("5")){防禦武器攻擊增加 = 防禦武器攻擊增加 +	5	;}

        if(def05_S	.matches("0")){燃燒彈對火力學員傷害提高 = 燃燒彈對火力學員傷害提高 +	0	;}
        if(def05_S	.matches("1")){燃燒彈對火力學員傷害提高 = 燃燒彈對火力學員傷害提高 +	1	;}
        if(def05_S	.matches("2")){燃燒彈對火力學員傷害提高 = 燃燒彈對火力學員傷害提高 +	2	;}
        if(def05_S	.matches("3")){燃燒彈對火力學員傷害提高 = 燃燒彈對火力學員傷害提高 +	3	;}
        if(def05_S	.matches("4")){燃燒彈對火力學員傷害提高 = 燃燒彈對火力學員傷害提高 +	4	;}
        if(def05_S	.matches("5")){燃燒彈對火力學員傷害提高 = 燃燒彈對火力學員傷害提高 +	5	;}

        if(def06_S	.matches("0")){防禦武器上限增加 = 防禦武器上限增加 +	0 	;}
        if(def06_S	.matches("1")){防禦武器上限增加 = 防禦武器上限增加 +	200 	;}
        if(def06_S	.matches("2")){防禦武器上限增加 = 防禦武器上限增加 +	400 	;}
        if(def06_S	.matches("3")){防禦武器上限增加 = 防禦武器上限增加 +	650 	;}
        if(def06_S	.matches("4")){防禦武器上限增加 = 防禦武器上限增加 +	900 	;}
        if(def06_S	.matches("5")){防禦武器上限增加 = 防禦武器上限增加 +	1200 	;}
        if(def06_S	.matches("6")){防禦武器上限增加 = 防禦武器上限增加 +	1500 	;}
        if(def06_S	.matches("7")){防禦武器上限增加 = 防禦武器上限增加 +	1850 	;}
        if(def06_S	.matches("8")){防禦武器上限增加 = 防禦武器上限增加 +	2200 	;}
        if(def06_S	.matches("9")){防禦武器上限增加 = 防禦武器上限增加 +	2600 	;}
        if(def06_S	.matches("10")){防禦武器上限增加 = 防禦武器上限增加 +	2000 	;}

        if(def07_S	.matches("0")){手雷對進擊學員傷害提高 = 手雷對進擊學員傷害提高 +	0	;}
        if(def07_S	.matches("1")){手雷對進擊學員傷害提高 = 手雷對進擊學員傷害提高 +	1	;}
        if(def07_S	.matches("2")){手雷對進擊學員傷害提高 = 手雷對進擊學員傷害提高 +	2	;}
        if(def07_S	.matches("3")){手雷對進擊學員傷害提高 = 手雷對進擊學員傷害提高 +	3	;}
        if(def07_S	.matches("4")){手雷對進擊學員傷害提高 = 手雷對進擊學員傷害提高 +	4	;}
        if(def07_S	.matches("5")){手雷對進擊學員傷害提高 = 手雷對進擊學員傷害提高 +	5	;}

        if(def08_S	.matches("0")){地雷對機動小組傷害提高 = 地雷對機動小組傷害提高 +	0	;}
        if(def08_S	.matches("1")){地雷對機動小組傷害提高 = 地雷對機動小組傷害提高 +	1	;}
        if(def08_S	.matches("2")){地雷對機動小組傷害提高 = 地雷對機動小組傷害提高 +	2	;}
        if(def08_S	.matches("3")){地雷對機動小組傷害提高 = 地雷對機動小組傷害提高 +	3	;}
        if(def08_S	.matches("4")){地雷對機動小組傷害提高 = 地雷對機動小組傷害提高 +	4	;}
        if(def08_S	.matches("5")){地雷對機動小組傷害提高 = 地雷對機動小組傷害提高 +	5	;}

        if(def09_S	.matches("0")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	0	;}
        if(def09_S	.matches("1")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	2	;}
        if(def09_S	.matches("2")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	4	;}
        if(def09_S	.matches("3")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	6	;}
        if(def09_S	.matches("4")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	8	;}
        if(def09_S	.matches("5")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	10	;}
        if(def09_S	.matches("6")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	12	;}
        if(def09_S	.matches("7")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	14	;}
        if(def09_S	.matches("8")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	16	;}
        if(def09_S	.matches("9")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	18	;}
        if(def09_S	.matches("10")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	20	;}

        if(def10_S	.matches("0")){出征戰鬥中_損失的學員一定比例轉化為傷兵 = 出征戰鬥中_損失的學員一定比例轉化為傷兵 +	0	;}
        if(def10_S	.matches("1")){出征戰鬥中_損失的學員一定比例轉化為傷兵 = 出征戰鬥中_損失的學員一定比例轉化為傷兵 +	1	;}
        if(def10_S	.matches("2")){出征戰鬥中_損失的學員一定比例轉化為傷兵 = 出征戰鬥中_損失的學員一定比例轉化為傷兵 +	2	;}
        if(def10_S	.matches("3")){出征戰鬥中_損失的學員一定比例轉化為傷兵 = 出征戰鬥中_損失的學員一定比例轉化為傷兵 +	3	;}
        if(def10_S	.matches("4")){出征戰鬥中_損失的學員一定比例轉化為傷兵 = 出征戰鬥中_損失的學員一定比例轉化為傷兵 +	4	;}
        if(def10_S	.matches("5")){出征戰鬥中_損失的學員一定比例轉化為傷兵 = 出征戰鬥中_損失的學員一定比例轉化為傷兵 +	5	;}
        if(def10_S	.matches("6")){出征戰鬥中_損失的學員一定比例轉化為傷兵 = 出征戰鬥中_損失的學員一定比例轉化為傷兵 +	6	;}
        if(def10_S	.matches("7")){出征戰鬥中_損失的學員一定比例轉化為傷兵 = 出征戰鬥中_損失的學員一定比例轉化為傷兵 +	7	;}
        if(def10_S	.matches("8")){出征戰鬥中_損失的學員一定比例轉化為傷兵 = 出征戰鬥中_損失的學員一定比例轉化為傷兵 +	8	;}
        if(def10_S	.matches("9")){出征戰鬥中_損失的學員一定比例轉化為傷兵 = 出征戰鬥中_損失的學員一定比例轉化為傷兵 +	9	;}
        if(def10_S	.matches("10")){出征戰鬥中_損失的學員一定比例轉化為傷兵 = 出征戰鬥中_損失的學員一定比例轉化為傷兵 +	10	;}

        if(def11_S	.matches("0")){城防值增加 = 城防值增加 +	0 	;}
        if(def11_S	.matches("1")){城防值增加 = 城防值增加 +	140 	;}
        if(def11_S	.matches("2")){城防值增加 = 城防值增加 +	280 	;}
        if(def11_S	.matches("3")){城防值增加 = 城防值增加 +	420 	;}
        if(def11_S	.matches("4")){城防值增加 = 城防值增加 +	560 	;}
        if(def11_S	.matches("5")){城防值增加 = 城防值增加 +	700 	;}
        if(def11_S	.matches("6")){城防值增加 = 城防值增加 +	840 	;}
        if(def11_S	.matches("7")){城防值增加 = 城防值增加 +	980 	;}
        if(def11_S	.matches("8")){城防值增加 = 城防值增加 +	1120 	;}
        if(def11_S	.matches("9")){城防值增加 = 城防值增加 +	1260 	;}
        if(def11_S	.matches("10")){城防值增加 = 城防值增加 +	1400 	;}
        if(def11_S	.matches("11")){城防值增加 = 城防值增加 +	1540 	;}
        if(def11_S	.matches("12")){城防值增加 = 城防值增加 +	1680 	;}
        if(def11_S	.matches("13")){城防值增加 = 城防值增加 +	1820 	;}
        if(def11_S	.matches("14")){城防值增加 = 城防值增加 +	1960 	;}
        if(def11_S	.matches("15")){城防值增加 = 城防值增加 +	2100 	;}

        if(def12_S	.matches("0")){守軍攻擊增加 = 守軍攻擊增加 +	0	;}
        if(def12_S	.matches("1")){守軍攻擊增加 = 守軍攻擊增加 +	1	;}
        if(def12_S	.matches("2")){守軍攻擊增加 = 守軍攻擊增加 +	2	;}
        if(def12_S	.matches("3")){守軍攻擊增加 = 守軍攻擊增加 +	3	;}
        if(def12_S	.matches("4")){守軍攻擊增加 = 守軍攻擊增加 +	4	;}
        if(def12_S	.matches("5")){守軍攻擊增加 = 守軍攻擊增加 +	5	;}
        if(def12_S	.matches("6")){守軍攻擊增加 = 守軍攻擊增加 +	6	;}
        if(def12_S	.matches("7")){守軍攻擊增加 = 守軍攻擊增加 +	7	;}
        if(def12_S	.matches("8")){守軍攻擊增加 = 守軍攻擊增加 +	8	;}
        if(def12_S	.matches("9")){守軍攻擊增加 = 守軍攻擊增加 +	9	;}
        if(def12_S	.matches("10")){守軍攻擊增加 = 守軍攻擊增加 +	10	;}

        if(def13_S	.matches("0")){守軍防禦增加 = 守軍防禦增加 +	0	;}
        if(def13_S	.matches("1")){守軍防禦增加 = 守軍防禦增加 +	1	;}
        if(def13_S	.matches("2")){守軍防禦增加 = 守軍防禦增加 +	2	;}
        if(def13_S	.matches("3")){守軍防禦增加 = 守軍防禦增加 +	3	;}
        if(def13_S	.matches("4")){守軍防禦增加 = 守軍防禦增加 +	4	;}
        if(def13_S	.matches("5")){守軍防禦增加 = 守軍防禦增加 +	5	;}
        if(def13_S	.matches("6")){守軍防禦增加 = 守軍防禦增加 +	6	;}
        if(def13_S	.matches("7")){守軍防禦增加 = 守軍防禦增加 +	7	;}
        if(def13_S	.matches("8")){守軍防禦增加 = 守軍防禦增加 +	8	;}
        if(def13_S	.matches("9")){守軍防禦增加 = 守軍防禦增加 +	9	;}
        if(def13_S	.matches("10")){守軍防禦增加 = 守軍防禦增加 +	10	;}

        if(def14_S	.matches("0")){防禦武器攻擊增加_ = 防禦武器攻擊增加_ +	0 	;}
        if(def14_S	.matches("1")){防禦武器攻擊增加_ = 防禦武器攻擊增加_ +	450 	;}
        if(def14_S	.matches("2")){防禦武器攻擊增加_ = 防禦武器攻擊增加_ +	900 	;}
        if(def14_S	.matches("3")){防禦武器攻擊增加_ = 防禦武器攻擊增加_ +	1400 	;}
        if(def14_S	.matches("4")){防禦武器攻擊增加_ = 防禦武器攻擊增加_ +	1900 	;}
        if(def14_S	.matches("5")){防禦武器攻擊增加_ = 防禦武器攻擊增加_ +	2450 	;}
        if(def14_S	.matches("6")){防禦武器攻擊增加_ = 防禦武器攻擊增加_ +	3000 	;}
        if(def14_S	.matches("7")){防禦武器攻擊增加_ = 防禦武器攻擊增加_ +	3600 	;}
        if(def14_S	.matches("8")){防禦武器攻擊增加_ = 防禦武器攻擊增加_ +	4200 	;}
        if(def14_S	.matches("9")){防禦武器攻擊增加_ = 防禦武器攻擊增加_ +	4850 	;}
        if(def14_S	.matches("10")){防禦武器攻擊增加_ = 防禦武器攻擊增加_ +	5500 	;}
        if(def14_S	.matches("11")){防禦武器攻擊增加_ = 防禦武器攻擊增加_ +	6200 	;}
        if(def14_S	.matches("12")){防禦武器攻擊增加_ = 防禦武器攻擊增加_ +	6900 	;}
        if(def14_S	.matches("13")){防禦武器攻擊增加_ = 防禦武器攻擊增加_ +	7650 	;}
        if(def14_S	.matches("14")){防禦武器攻擊增加_ = 防禦武器攻擊增加_ +	8400 	;}
        if(def14_S	.matches("15")){防禦武器攻擊增加_ = 防禦武器攻擊增加_ +	9200 	;}
        if(def14_S	.matches("16")){防禦武器攻擊增加_ = 防禦武器攻擊增加_ +	10000 	;}
        if(def14_S	.matches("17")){防禦武器攻擊增加_ = 防禦武器攻擊增加_ +	10850	;}
        if(def14_S	.matches("18")){防禦武器攻擊增加_ = 防禦武器攻擊增加_ +	11750 	;}
        if(def14_S	.matches("19")){防禦武器攻擊增加_ = 防禦武器攻擊增加_ +	12750 	;}
        if(def14_S	.matches("20")){防禦武器攻擊增加_ = 防禦武器攻擊增加_ +	13950 	;}

        if(def15_S	.matches("0")){手雷對進擊學員傷害提高 = 手雷對進擊學員傷害提高 +	0	;}
        if(def15_S	.matches("1")){手雷對進擊學員傷害提高 = 手雷對進擊學員傷害提高 +	1	;}
        if(def15_S	.matches("2")){手雷對進擊學員傷害提高 = 手雷對進擊學員傷害提高 +	2	;}
        if(def15_S	.matches("3")){手雷對進擊學員傷害提高 = 手雷對進擊學員傷害提高 +	3	;}
        if(def15_S	.matches("4")){手雷對進擊學員傷害提高 = 手雷對進擊學員傷害提高 +	4	;}
        if(def15_S	.matches("5")){手雷對進擊學員傷害提高 = 手雷對進擊學員傷害提高 +	5	;}
        if(def15_S	.matches("6")){手雷對進擊學員傷害提高 = 手雷對進擊學員傷害提高 +	6	;}
        if(def15_S	.matches("7")){手雷對進擊學員傷害提高 = 手雷對進擊學員傷害提高 +	7	;}
        if(def15_S	.matches("8")){手雷對進擊學員傷害提高 = 手雷對進擊學員傷害提高 +	8	;}
        if(def15_S	.matches("9")){手雷對進擊學員傷害提高 = 手雷對進擊學員傷害提高 +	9	;}
        if(def15_S	.matches("10")){手雷對進擊學員傷害提高 = 手雷對進擊學員傷害提高 +	10	;}

        if(def16_S	.matches("0")){燃燒彈對火力學員傷害提高 = 燃燒彈對火力學員傷害提高 +	0	;}
        if(def16_S	.matches("1")){燃燒彈對火力學員傷害提高 = 燃燒彈對火力學員傷害提高 +	1	;}
        if(def16_S	.matches("2")){燃燒彈對火力學員傷害提高 = 燃燒彈對火力學員傷害提高 +	2	;}
        if(def16_S	.matches("3")){燃燒彈對火力學員傷害提高 = 燃燒彈對火力學員傷害提高 +	3	;}
        if(def16_S	.matches("4")){燃燒彈對火力學員傷害提高 = 燃燒彈對火力學員傷害提高 +	4	;}
        if(def16_S	.matches("5")){燃燒彈對火力學員傷害提高 = 燃燒彈對火力學員傷害提高 +	5	;}
        if(def16_S	.matches("6")){燃燒彈對火力學員傷害提高 = 燃燒彈對火力學員傷害提高 +	6	;}
        if(def16_S	.matches("7")){燃燒彈對火力學員傷害提高 = 燃燒彈對火力學員傷害提高 +	7	;}
        if(def16_S	.matches("8")){燃燒彈對火力學員傷害提高 = 燃燒彈對火力學員傷害提高 +	8	;}
        if(def16_S	.matches("9")){燃燒彈對火力學員傷害提高 = 燃燒彈對火力學員傷害提高 +	9	;}
        if(def16_S	.matches("10")){燃燒彈對火力學員傷害提高 = 燃燒彈對火力學員傷害提高 +	10	;}

        if(def17_S	.matches("0")){地雷對機動小組傷害提高 = 地雷對機動小組傷害提高 +	0	;}
        if(def17_S	.matches("1")){地雷對機動小組傷害提高 = 地雷對機動小組傷害提高 +	1	;}
        if(def17_S	.matches("2")){地雷對機動小組傷害提高 = 地雷對機動小組傷害提高 +	2	;}
        if(def17_S	.matches("3")){地雷對機動小組傷害提高 = 地雷對機動小組傷害提高 +	3	;}
        if(def17_S	.matches("4")){地雷對機動小組傷害提高 = 地雷對機動小組傷害提高 +	4	;}
        if(def17_S	.matches("5")){地雷對機動小組傷害提高 = 地雷對機動小組傷害提高 +	5	;}
        if(def17_S	.matches("6")){地雷對機動小組傷害提高 = 地雷對機動小組傷害提高 +	6	;}
        if(def17_S	.matches("7")){地雷對機動小組傷害提高 = 地雷對機動小組傷害提高 +	7	;}
        if(def17_S	.matches("8")){地雷對機動小組傷害提高 = 地雷對機動小組傷害提高 +	8	;}
        if(def17_S	.matches("9")){地雷對機動小組傷害提高 = 地雷對機動小組傷害提高 +	9	;}
        if(def17_S	.matches("10")){地雷對機動小組傷害提高 = 地雷對機動小組傷害提高 +	10	;}

        if(def18_S	.matches("0")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	0 	;}
        if(def18_S	.matches("1")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	2 	;}
        if(def18_S	.matches("2")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	4 	;}
        if(def18_S	.matches("3")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	6 	;}
        if(def18_S	.matches("4")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	8 	;}
        if(def18_S	.matches("5")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	10 	;}
        if(def18_S	.matches("6")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	12 	;}
        if(def18_S	.matches("7")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	14 	;}
        if(def18_S	.matches("8")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	16 	;}
        if(def18_S	.matches("9")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	18 	;}
        if(def18_S	.matches("10")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	20 	;}
        if(def18_S	.matches("11")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	22 	;}
        if(def18_S	.matches("12")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	24 	;}
        if(def18_S	.matches("13")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	26 	;}
        if(def18_S	.matches("14")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	28 	;}
        if(def18_S	.matches("15")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	30 	;}
        if(def18_S	.matches("16")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	32 	;}
        if(def18_S	.matches("17")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	34 	;}
        if(def18_S	.matches("18")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	36 	;}
        if(def18_S	.matches("19")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	38 	;}
        if(def18_S	.matches("20")){防禦武器建造速度加快 = 防禦武器建造速度加快 +	40 	;}

        /**
         *  DEF PART
         *  --------------
         *  MILI PART
         */

        if(mili01_S	.matches("0")){學員訓練速度增加 = 學員訓練速度增加 +	0	;}
        if(mili01_S	.matches("1")){學員訓練速度增加 = 學員訓練速度增加 +	1	;}
        if(mili01_S	.matches("2")){學員訓練速度增加 = 學員訓練速度增加 +	2	;}
        if(mili01_S	.matches("3")){學員訓練速度增加 = 學員訓練速度增加 +	3	;}
        if(mili01_S	.matches("4")){學員訓練速度增加 = 學員訓練速度增加 +	4	;}
        if(mili01_S	.matches("5")){學員訓練速度增加 = 學員訓練速度增加 +	5	;}
        if(mili01_S	.matches("6")){學員訓練速度增加 = 學員訓練速度增加 +	6	;}
        if(mili01_S	.matches("7")){學員訓練速度增加 = 學員訓練速度增加 +	7	;}
        if(mili01_S	.matches("8")){學員訓練速度增加 = 學員訓練速度增加 +	8	;}
        if(mili01_S	.matches("9")){學員訓練速度增加 = 學員訓練速度增加 +	9	;}
        if(mili01_S	.matches("10")){學員訓練速度增加 = 學員訓練速度增加 +	10	;}

        if(mili02_S	.matches("0")){進擊學員攻擊提高 = 進擊學員攻擊提高 +	0	;}
        if(mili02_S	.matches("1")){進擊學員攻擊提高 = 進擊學員攻擊提高 +	1	;}
        if(mili02_S	.matches("2")){進擊學員攻擊提高 = 進擊學員攻擊提高 +	2	;}
        if(mili02_S	.matches("3")){進擊學員攻擊提高 = 進擊學員攻擊提高 +	3	;}

        if(mili03_S	.matches("0")){火力學員攻擊提高 = 火力學員攻擊提高 +	0	;}
        if(mili03_S	.matches("1")){火力學員攻擊提高 = 火力學員攻擊提高 +	1	;}
        if(mili03_S	.matches("2")){火力學員攻擊提高 = 火力學員攻擊提高 +	2	;}
        if(mili03_S	.matches("3")){火力學員攻擊提高 = 火力學員攻擊提高 +	3	;}

        if(mili04_S	.matches("0")){機動小組攻擊提高 = 機動小組攻擊提高 +	0	;}
        if(mili04_S	.matches("1")){機動小組攻擊提高 = 機動小組攻擊提高 +	1	;}
        if(mili04_S	.matches("2")){機動小組攻擊提高 = 機動小組攻擊提高 +	2	;}
        if(mili04_S	.matches("3")){機動小組攻擊提高 = 機動小組攻擊提高 +	3	;}

        if(mili05_S	.matches("0")){行軍速度提高 = 行軍速度提高 +	0	;}
        if(mili05_S	.matches("1")){行軍速度提高 = 行軍速度提高 +	1	;}
        if(mili05_S	.matches("2")){行軍速度提高 = 行軍速度提高 +	2	;}
        if(mili05_S	.matches("3")){行軍速度提高 = 行軍速度提高 +	3	;}
        if(mili05_S	.matches("4")){行軍速度提高 = 行軍速度提高 +	4	;}
        if(mili05_S	.matches("5")){行軍速度提高 = 行軍速度提高 +	5	;}
        if(mili05_S	.matches("6")){行軍速度提高 = 行軍速度提高 +	6	;}
        if(mili05_S	.matches("7")){行軍速度提高 = 行軍速度提高 +	7	;}
        if(mili05_S	.matches("8")){行軍速度提高 = 行軍速度提高 +	8	;}
        if(mili05_S	.matches("9")){行軍速度提高 = 行軍速度提高 +	9	;}
        if(mili05_S	.matches("10")){行軍速度提高 = 行軍速度提高 +	10	;}

        if(mili06_S	.matches("0")){進擊學員防禦提高 = 進擊學員防禦提高 +	0	;}
        if(mili06_S	.matches("1")){進擊學員防禦提高 = 進擊學員防禦提高 +	1	;}
        if(mili06_S	.matches("2")){進擊學員防禦提高 = 進擊學員防禦提高 +	2	;}
        if(mili06_S	.matches("3")){進擊學員防禦提高 = 進擊學員防禦提高 +	3	;}

        if(mili07_S	.matches("0")){火力學員防禦提高 = 火力學員防禦提高 +	0	;}
        if(mili07_S	.matches("1")){火力學員防禦提高 = 火力學員防禦提高 +	1	;}
        if(mili07_S	.matches("2")){火力學員防禦提高 = 火力學員防禦提高 +	2	;}
        if(mili07_S	.matches("3")){火力學員防禦提高 = 火力學員防禦提高 +	3	;}

        if(mili08_S	.matches("0")){機動小組防禦提高 = 機動小組防禦提高 +	0	;}
        if(mili08_S	.matches("1")){機動小組防禦提高 = 機動小組防禦提高 +	1	;}
        if(mili08_S	.matches("2")){機動小組防禦提高 = 機動小組防禦提高 +	2	;}
        if(mili08_S	.matches("3")){機動小組防禦提高 = 機動小組防禦提高 +	3	;}

        if(mili09_S	.matches("0")){出征部隊上限增加1支 = 出征部隊上限增加1支 +	0	;}
        if(mili09_S	.matches("0")){出征部隊上限增加1支 = 出征部隊上限增加1支 +	1	;}

        if(mili10_S	.matches("0")){進擊學員生命提高 = 進擊學員生命提高 +	0	;}
        if(mili10_S	.matches("1")){進擊學員生命提高 = 進擊學員生命提高 +	1	;}
        if(mili10_S	.matches("2")){進擊學員生命提高 = 進擊學員生命提高 +	2	;}
        if(mili10_S	.matches("3")){進擊學員生命提高 = 進擊學員生命提高 +	3	;}

        if(mili11_S	.matches("0")){火力學員生命提高 = 火力學員生命提高 +	0	;}
        if(mili11_S	.matches("1")){火力學員生命提高 = 火力學員生命提高 +	1	;}
        if(mili11_S	.matches("2")){火力學員生命提高 = 火力學員生命提高 +	2	;}
        if(mili11_S	.matches("3")){火力學員生命提高 = 火力學員生命提高 +	3	;}

        if(mili12_S	.matches("0")){機動小組生命提高 = 機動小組生命提高 +	0	;}
        if(mili12_S	.matches("1")){機動小組生命提高 = 機動小組生命提高 +	1	;}
        if(mili12_S	.matches("2")){機動小組生命提高 = 機動小組生命提高 +	2	;}
        if(mili12_S	.matches("3")){機動小組生命提高 = 機動小組生命提高 +	3	;}

        if(mili13_S	.matches("0")){單支出兵上限提升 = 單支出兵上限提升 +	0	;}
        if(mili13_S	.matches("1")){單支出兵上限提升 = 單支出兵上限提升 +	2000	;}
        if(mili13_S	.matches("2")){單支出兵上限提升 = 單支出兵上限提升 +	4000	;}
        if(mili13_S	.matches("3")){單支出兵上限提升 = 單支出兵上限提升 +	6000	;}

        if(mili14_S	.matches("0")){出征部隊上限增加1支 = 出征部隊上限增加1支 +	0	;}
        if(mili14_S	.matches("0")){出征部隊上限增加1支 = 出征部隊上限增加1支 +	1	;}

        if(mili15_S	.matches("0")){進擊學員攻擊提高 = 進擊學員攻擊提高 +	0	;}
        if(mili15_S	.matches("1")){進擊學員攻擊提高 = 進擊學員攻擊提高 +	1	;}
        if(mili15_S	.matches("2")){進擊學員攻擊提高 = 進擊學員攻擊提高 +	2	;}
        if(mili15_S	.matches("3")){進擊學員攻擊提高 = 進擊學員攻擊提高 +	3	;}
        if(mili15_S	.matches("4")){進擊學員攻擊提高 = 進擊學員攻擊提高 +	4	;}
        if(mili15_S	.matches("5")){進擊學員攻擊提高 = 進擊學員攻擊提高 +	5	;}

        if(mili16_S	.matches("0")){火力學員攻擊提高 = 火力學員攻擊提高 +	0	;}
        if(mili16_S	.matches("1")){火力學員攻擊提高 = 火力學員攻擊提高 +	1	;}
        if(mili16_S	.matches("2")){火力學員攻擊提高 = 火力學員攻擊提高 +	2	;}
        if(mili16_S	.matches("3")){火力學員攻擊提高 = 火力學員攻擊提高 +	3	;}
        if(mili16_S	.matches("4")){火力學員攻擊提高 = 火力學員攻擊提高 +	4	;}
        if(mili16_S	.matches("5")){火力學員攻擊提高 = 火力學員攻擊提高 +	5	;}

        if(mili17_S	.matches("0")){機動小組攻擊提高 = 機動小組攻擊提高 +	0	;}
        if(mili17_S	.matches("1")){機動小組攻擊提高 = 機動小組攻擊提高 +	1	;}
        if(mili17_S	.matches("2")){機動小組攻擊提高 = 機動小組攻擊提高 +	2	;}
        if(mili17_S	.matches("3")){機動小組攻擊提高 = 機動小組攻擊提高 +	3	;}
        if(mili17_S	.matches("4")){機動小組攻擊提高 = 機動小組攻擊提高 +	4	;}
        if(mili17_S	.matches("5")){機動小組攻擊提高 = 機動小組攻擊提高 +	5	;}

        if(mili18_S	.matches("0")){學員訓練速度增加 = 學員訓練速度增加 +	0	;}
        if(mili18_S	.matches("1")){學員訓練速度增加 = 學員訓練速度增加 +	1	;}
        if(mili18_S	.matches("2")){學員訓練速度增加 = 學員訓練速度增加 +	2	;}
        if(mili18_S	.matches("3")){學員訓練速度增加 = 學員訓練速度增加 +	3	;}
        if(mili18_S	.matches("4")){學員訓練速度增加 = 學員訓練速度增加 +	4	;}
        if(mili18_S	.matches("5")){學員訓練速度增加 = 學員訓練速度增加 +	5	;}
        if(mili18_S	.matches("6")){學員訓練速度增加 = 學員訓練速度增加 +	6	;}
        if(mili18_S	.matches("7")){學員訓練速度增加 = 學員訓練速度增加 +	7	;}
        if(mili18_S	.matches("8")){學員訓練速度增加 = 學員訓練速度增加 +	8	;}
        if(mili18_S	.matches("9")){學員訓練速度增加 = 學員訓練速度增加 +	9	;}
        if(mili18_S	.matches("10")){學員訓練速度增加 = 學員訓練速度增加 +	10	;}
        if(mili18_S	.matches("11")){學員訓練速度增加 = 學員訓練速度增加 +	11	;}
        if(mili18_S	.matches("12")){學員訓練速度增加 = 學員訓練速度增加 +	12	;}
        if(mili18_S	.matches("13")){學員訓練速度增加 = 學員訓練速度增加 +	13	;}
        if(mili18_S	.matches("14")){學員訓練速度增加 = 學員訓練速度增加 +	14	;}
        if(mili18_S	.matches("15")){學員訓練速度增加 = 學員訓練速度增加 +	15	;}

        if(mili19_S	.matches("0")){進擊學員防禦提高 = 進擊學員防禦提高 +	0	;}
        if(mili19_S	.matches("1")){進擊學員防禦提高 = 進擊學員防禦提高 +	1	;}
        if(mili19_S	.matches("2")){進擊學員防禦提高 = 進擊學員防禦提高 +	2	;}
        if(mili19_S	.matches("3")){進擊學員防禦提高 = 進擊學員防禦提高 +	3	;}
        if(mili19_S	.matches("4")){進擊學員防禦提高 = 進擊學員防禦提高 +	4	;}
        if(mili19_S	.matches("5")){進擊學員防禦提高 = 進擊學員防禦提高 +	5	;}

        if(mili20_S	.matches("0")){火力學員防禦提高 = 火力學員防禦提高 +	0	;}
        if(mili20_S	.matches("1")){火力學員防禦提高 = 火力學員防禦提高 +	1	;}
        if(mili20_S	.matches("2")){火力學員防禦提高 = 火力學員防禦提高 +	2	;}
        if(mili20_S	.matches("3")){火力學員防禦提高 = 火力學員防禦提高 +	3	;}
        if(mili20_S	.matches("4")){火力學員防禦提高 = 火力學員防禦提高 +	4	;}
        if(mili20_S	.matches("5")){火力學員防禦提高 = 火力學員防禦提高 +	5	;}

        if(mili21_S	.matches("0")){機動小組防禦提高 = 機動小組防禦提高 +	0	;}
        if(mili21_S	.matches("1")){機動小組防禦提高 = 機動小組防禦提高 +	1	;}
        if(mili21_S	.matches("2")){機動小組防禦提高 = 機動小組防禦提高 +	2	;}
        if(mili21_S	.matches("3")){機動小組防禦提高 = 機動小組防禦提高 +	3	;}
        if(mili21_S	.matches("4")){機動小組防禦提高 = 機動小組防禦提高 +	4	;}
        if(mili21_S	.matches("5")){機動小組防禦提高 = 機動小組防禦提高 +	5	;}

        if(mili22_S	.matches("0")){行軍速度提高 = 行軍速度提高 +	0	;}
        if(mili22_S	.matches("1")){行軍速度提高 = 行軍速度提高 +	1	;}
        if(mili22_S	.matches("2")){行軍速度提高 = 行軍速度提高 +	2	;}
        if(mili22_S	.matches("3")){行軍速度提高 = 行軍速度提高 +	3	;}
        if(mili22_S	.matches("4")){行軍速度提高 = 行軍速度提高 +	4	;}
        if(mili22_S	.matches("5")){行軍速度提高 = 行軍速度提高 +	5	;}
        if(mili22_S	.matches("6")){行軍速度提高 = 行軍速度提高 +	6	;}
        if(mili22_S	.matches("7")){行軍速度提高 = 行軍速度提高 +	7	;}
        if(mili22_S	.matches("8")){行軍速度提高 = 行軍速度提高 +	8	;}
        if(mili22_S	.matches("9")){行軍速度提高 = 行軍速度提高 +	9	;}
        if(mili22_S	.matches("10")){行軍速度提高 = 行軍速度提高 +	10	;}
        if(mili22_S	.matches("11")){行軍速度提高 = 行軍速度提高 +	11	;}
        if(mili22_S	.matches("12")){行軍速度提高 = 行軍速度提高 +	12	;}
        if(mili22_S	.matches("13")){行軍速度提高 = 行軍速度提高 +	13	;}
        if(mili22_S	.matches("14")){行軍速度提高 = 行軍速度提高 +	14	;}
        if(mili22_S	.matches("15")){行軍速度提高 = 行軍速度提高 +	15	;}

        if(mili23_S	.matches("0")){進擊學員生命提高 = 進擊學員生命提高 +	0	;}
        if(mili23_S	.matches("1")){進擊學員生命提高 = 進擊學員生命提高 +	1	;}
        if(mili23_S	.matches("2")){進擊學員生命提高 = 進擊學員生命提高 +	2	;}
        if(mili23_S	.matches("3")){進擊學員生命提高 = 進擊學員生命提高 +	3	;}
        if(mili23_S	.matches("4")){進擊學員生命提高 = 進擊學員生命提高 +	4	;}
        if(mili23_S	.matches("5")){進擊學員生命提高 = 進擊學員生命提高 +	5	;}

        if(mili24_S	.matches("0")){火力學員生命提高 = 火力學員生命提高 +	0	;}
        if(mili24_S	.matches("1")){火力學員生命提高 = 火力學員生命提高 +	1	;}
        if(mili24_S	.matches("2")){火力學員生命提高 = 火力學員生命提高 +	2	;}
        if(mili24_S	.matches("3")){火力學員生命提高 = 火力學員生命提高 +	3	;}
        if(mili24_S	.matches("4")){火力學員生命提高 = 火力學員生命提高 +	4	;}
        if(mili24_S	.matches("5")){火力學員生命提高 = 火力學員生命提高 +	5	;}

        if(mili25_S	.matches("0")){機動小組生命提高 = 機動小組生命提高 +	0	;}
        if(mili25_S	.matches("1")){機動小組生命提高 = 機動小組生命提高 +	1	;}
        if(mili25_S	.matches("2")){機動小組生命提高 = 機動小組生命提高 +	2	;}
        if(mili25_S	.matches("3")){機動小組生命提高 = 機動小組生命提高 +	3	;}
        if(mili25_S	.matches("4")){機動小組生命提高 = 機動小組生命提高 +	4	;}
        if(mili25_S	.matches("5")){機動小組生命提高 = 機動小組生命提高 +	5	;}

        if(mili26_S	.matches("0")){單支出兵上限提升 = 單支出兵上限提升 +	0 	;}
        if(mili26_S	.matches("1")){單支出兵上限提升 = 單支出兵上限提升 +	2000 	;}
        if(mili26_S	.matches("2")){單支出兵上限提升 = 單支出兵上限提升 +	4000 	;}
        if(mili26_S	.matches("3")){單支出兵上限提升 = 單支出兵上限提升 +	6000 	;}
        if(mili26_S	.matches("4")){單支出兵上限提升 = 單支出兵上限提升 +	8000 	;}
        if(mili26_S	.matches("5")){單支出兵上限提升 = 單支出兵上限提升 +	10000 	;}

        if(mili27_S	.matches("0")){出征部隊上限增加1支 = 出征部隊上限增加1支 +	0	;}
        if(mili27_S	.matches("0")){出征部隊上限增加1支 = 出征部隊上限增加1支 +	1	;}

        if(mili28_S	.matches("0")){進擊學員攻擊提高 = 進擊學員攻擊提高 +	0 	;}
        if(mili28_S	.matches("1")){進擊學員攻擊提高 = 進擊學員攻擊提高 +	1	;}
        if(mili28_S	.matches("2")){進擊學員攻擊提高 = 進擊學員攻擊提高 +	2	;}
        if(mili28_S	.matches("3")){進擊學員攻擊提高 = 進擊學員攻擊提高 +	3	;}
        if(mili28_S	.matches("4")){進擊學員攻擊提高 = 進擊學員攻擊提高 +	4	;}
        if(mili28_S	.matches("5")){進擊學員攻擊提高 = 進擊學員攻擊提高 +	5	;}
        if(mili28_S	.matches("6")){進擊學員攻擊提高 = 進擊學員攻擊提高 +	6	;}
        if(mili28_S	.matches("7")){進擊學員攻擊提高 = 進擊學員攻擊提高 +	7	;}

        if(mili29_S	.matches("0")){火力學員攻擊提高 = 火力學員攻擊提高 +	0 	;}
        if(mili29_S	.matches("1")){火力學員攻擊提高 = 火力學員攻擊提高 +	1	;}
        if(mili29_S	.matches("2")){火力學員攻擊提高 = 火力學員攻擊提高 +	2	;}
        if(mili29_S	.matches("3")){火力學員攻擊提高 = 火力學員攻擊提高 +	3	;}
        if(mili29_S	.matches("4")){火力學員攻擊提高 = 火力學員攻擊提高 +	4	;}
        if(mili29_S	.matches("5")){火力學員攻擊提高 = 火力學員攻擊提高 +	5	;}
        if(mili29_S	.matches("6")){火力學員攻擊提高 = 火力學員攻擊提高 +	6	;}
        if(mili29_S	.matches("7")){火力學員攻擊提高 = 火力學員攻擊提高 +	7	;}

        if(mili30_S	.matches("0")){機動小組攻擊提高 = 機動小組攻擊提高 +	0 	;}
        if(mili30_S	.matches("1")){機動小組攻擊提高 = 機動小組攻擊提高 +	1	;}
        if(mili30_S	.matches("2")){機動小組攻擊提高 = 機動小組攻擊提高 +	2	;}
        if(mili30_S	.matches("3")){機動小組攻擊提高 = 機動小組攻擊提高 +	3	;}
        if(mili30_S	.matches("4")){機動小組攻擊提高 = 機動小組攻擊提高 +	4	;}
        if(mili30_S	.matches("5")){機動小組攻擊提高 = 機動小組攻擊提高 +	5	;}
        if(mili30_S	.matches("6")){機動小組攻擊提高 = 機動小組攻擊提高 +	6	;}
        if(mili30_S	.matches("7")){機動小組攻擊提高 = 機動小組攻擊提高 +	7	;}

        if(mili31_S	.matches("0")){學員訓練速度增加 = 學員訓練速度增加 +	0	;}
        if(mili31_S	.matches("1")){學員訓練速度增加 = 學員訓練速度增加 +	1	;}
        if(mili31_S	.matches("2")){學員訓練速度增加 = 學員訓練速度增加 +	2	;}
        if(mili31_S	.matches("3")){學員訓練速度增加 = 學員訓練速度增加 +	3	;}
        if(mili31_S	.matches("4")){學員訓練速度增加 = 學員訓練速度增加 +	4	;}
        if(mili31_S	.matches("5")){學員訓練速度增加 = 學員訓練速度增加 +	5	;}
        if(mili31_S	.matches("6")){學員訓練速度增加 = 學員訓練速度增加 +	6	;}
        if(mili31_S	.matches("7")){學員訓練速度增加 = 學員訓練速度增加 +	7	;}
        if(mili31_S	.matches("8")){學員訓練速度增加 = 學員訓練速度增加 +	8	;}
        if(mili31_S	.matches("9")){學員訓練速度增加 = 學員訓練速度增加 +	9	;}
        if(mili31_S	.matches("10")){學員訓練速度增加 = 學員訓練速度增加 +	10	;}
        if(mili31_S	.matches("11")){學員訓練速度增加 = 學員訓練速度增加 +	11	;}
        if(mili31_S	.matches("12")){學員訓練速度增加 = 學員訓練速度增加 +	12	;}
        if(mili31_S	.matches("13")){學員訓練速度增加 = 學員訓練速度增加 +	13	;}
        if(mili31_S	.matches("14")){學員訓練速度增加 = 學員訓練速度增加 +	14	;}
        if(mili31_S	.matches("15")){學員訓練速度增加 = 學員訓練速度增加 +	15	;}
        if(mili31_S	.matches("16")){學員訓練速度增加 = 學員訓練速度增加 +	16	;}
        if(mili31_S	.matches("17")){學員訓練速度增加 = 學員訓練速度增加 +	17	;}
        if(mili31_S	.matches("18")){學員訓練速度增加 = 學員訓練速度增加 +	18	;}
        if(mili31_S	.matches("19")){學員訓練速度增加 = 學員訓練速度增加 +	19	;}
        if(mili31_S	.matches("20")){學員訓練速度增加 = 學員訓練速度增加 +	20	;}

        if(mili32_S	.matches("0")){進擊學員防禦提高 = 進擊學員防禦提高 +	0 	;}
        if(mili32_S	.matches("1")){進擊學員防禦提高 = 進擊學員防禦提高 +	1	;}
        if(mili32_S	.matches("2")){進擊學員防禦提高 = 進擊學員防禦提高 +	2	;}
        if(mili32_S	.matches("3")){進擊學員防禦提高 = 進擊學員防禦提高 +	3	;}
        if(mili32_S	.matches("4")){進擊學員防禦提高 = 進擊學員防禦提高 +	4	;}
        if(mili32_S	.matches("5")){進擊學員防禦提高 = 進擊學員防禦提高 +	5	;}
        if(mili32_S	.matches("6")){進擊學員防禦提高 = 進擊學員防禦提高 +	6	;}
        if(mili32_S	.matches("7")){進擊學員防禦提高 = 進擊學員防禦提高 +	7	;}

        if(mili33_S	.matches("0")){火力學員防禦提高 = 火力學員防禦提高 +	0 	;}
        if(mili33_S	.matches("1")){火力學員防禦提高 = 火力學員防禦提高 +	1	;}
        if(mili33_S	.matches("2")){火力學員防禦提高 = 火力學員防禦提高 +	2	;}
        if(mili33_S	.matches("3")){火力學員防禦提高 = 火力學員防禦提高 +	3	;}
        if(mili33_S	.matches("4")){火力學員防禦提高 = 火力學員防禦提高 +	4	;}
        if(mili33_S	.matches("5")){火力學員防禦提高 = 火力學員防禦提高 +	5	;}
        if(mili33_S	.matches("6")){火力學員防禦提高 = 火力學員防禦提高 +	6	;}
        if(mili33_S	.matches("7")){火力學員防禦提高 = 火力學員防禦提高 +	7	;}

        if(mili34_S	.matches("0")){機動小組防禦提高 = 機動小組防禦提高 +	0 	;}
        if(mili34_S	.matches("1")){機動小組防禦提高 = 機動小組防禦提高 +	1	;}
        if(mili34_S	.matches("2")){機動小組防禦提高 = 機動小組防禦提高 +	2	;}
        if(mili34_S	.matches("3")){機動小組防禦提高 = 機動小組防禦提高 +	3	;}
        if(mili34_S	.matches("4")){機動小組防禦提高 = 機動小組防禦提高 +	4	;}
        if(mili34_S	.matches("5")){機動小組防禦提高 = 機動小組防禦提高 +	5	;}
        if(mili34_S	.matches("6")){機動小組防禦提高 = 機動小組防禦提高 +	6	;}
        if(mili34_S	.matches("7")){機動小組防禦提高 = 機動小組防禦提高 +	7	;}

        if(mili35_S	.matches("0")){行軍速度提高 = 行軍速度提高 +	0	;}
        if(mili35_S	.matches("1")){行軍速度提高 = 行軍速度提高 +	1	;}
        if(mili35_S	.matches("2")){行軍速度提高 = 行軍速度提高 +	2	;}
        if(mili35_S	.matches("3")){行軍速度提高 = 行軍速度提高 +	3	;}
        if(mili35_S	.matches("4")){行軍速度提高 = 行軍速度提高 +	4	;}
        if(mili35_S	.matches("5")){行軍速度提高 = 行軍速度提高 +	5	;}
        if(mili35_S	.matches("6")){行軍速度提高 = 行軍速度提高 +	6	;}
        if(mili35_S	.matches("7")){行軍速度提高 = 行軍速度提高 +	7	;}
        if(mili35_S	.matches("8")){行軍速度提高 = 行軍速度提高 +	8	;}
        if(mili35_S	.matches("9")){行軍速度提高 = 行軍速度提高 +	9	;}
        if(mili35_S	.matches("10")){行軍速度提高 = 行軍速度提高 +	10	;}
        if(mili35_S	.matches("11")){行軍速度提高 = 行軍速度提高 +	11	;}
        if(mili35_S	.matches("12")){行軍速度提高 = 行軍速度提高 +	12	;}
        if(mili35_S	.matches("13")){行軍速度提高 = 行軍速度提高 +	13	;}
        if(mili35_S	.matches("14")){行軍速度提高 = 行軍速度提高 +	14	;}
        if(mili35_S	.matches("15")){行軍速度提高 = 行軍速度提高 +	15	;}
        if(mili35_S	.matches("16")){行軍速度提高 = 行軍速度提高 +	16	;}
        if(mili35_S	.matches("17")){行軍速度提高 = 行軍速度提高 +	17	;}
        if(mili35_S	.matches("18")){行軍速度提高 = 行軍速度提高 +	18	;}
        if(mili35_S	.matches("19")){行軍速度提高 = 行軍速度提高 +	19	;}
        if(mili35_S	.matches("20")){行軍速度提高 = 行軍速度提高 +	20	;}

        if(mili36_S	.matches("0")){進擊學員生命提高 = 進擊學員生命提高 +	0 	;}
        if(mili36_S	.matches("1")){進擊學員生命提高 = 進擊學員生命提高 +	1	;}
        if(mili36_S	.matches("2")){進擊學員生命提高 = 進擊學員生命提高 +	2	;}
        if(mili36_S	.matches("3")){進擊學員生命提高 = 進擊學員生命提高 +	3	;}
        if(mili36_S	.matches("4")){進擊學員生命提高 = 進擊學員生命提高 +	4	;}
        if(mili36_S	.matches("5")){進擊學員生命提高 = 進擊學員生命提高 +	5	;}
        if(mili36_S	.matches("6")){進擊學員生命提高 = 進擊學員生命提高 +	6	;}
        if(mili36_S	.matches("7")){進擊學員生命提高 = 進擊學員生命提高 +	7	;}

        if(mili37_S	.matches("0")){火力學員生命提高 = 火力學員生命提高 +	0 	;}
        if(mili37_S	.matches("1")){火力學員生命提高 = 火力學員生命提高 +	1	;}
        if(mili37_S	.matches("2")){火力學員生命提高 = 火力學員生命提高 +	2	;}
        if(mili37_S	.matches("3")){火力學員生命提高 = 火力學員生命提高 +	3	;}
        if(mili37_S	.matches("4")){火力學員生命提高 = 火力學員生命提高 +	4	;}
        if(mili37_S	.matches("5")){火力學員生命提高 = 火力學員生命提高 +	5	;}
        if(mili37_S	.matches("6")){火力學員生命提高 = 火力學員生命提高 +	6	;}
        if(mili37_S	.matches("7")){火力學員生命提高 = 火力學員生命提高 +	7	;}

        if(mili38_S	.matches("0")){機動小組生命提高 = 機動小組生命提高 +	0 	;}
        if(mili38_S	.matches("1")){機動小組生命提高 = 機動小組生命提高 +	1	;}
        if(mili38_S	.matches("2")){機動小組生命提高 = 機動小組生命提高 +	2	;}
        if(mili38_S	.matches("3")){機動小組生命提高 = 機動小組生命提高 +	3	;}
        if(mili38_S	.matches("4")){機動小組生命提高 = 機動小組生命提高 +	4	;}
        if(mili38_S	.matches("5")){機動小組生命提高 = 機動小組生命提高 +	5	;}
        if(mili38_S	.matches("6")){機動小組生命提高 = 機動小組生命提高 +	6	;}
        if(mili38_S	.matches("7")){機動小組生命提高 = 機動小組生命提高 +	7	;}

        if(mili39_S	.matches("0")){單支出兵上限提升 = 單支出兵上限提升 +	0 	;}
        if(mili39_S	.matches("1")){單支出兵上限提升 = 單支出兵上限提升 +	2000 	;}
        if(mili39_S	.matches("2")){單支出兵上限提升 = 單支出兵上限提升 +	4000 	;}
        if(mili39_S	.matches("3")){單支出兵上限提升 = 單支出兵上限提升 +	6000 	;}
        if(mili39_S	.matches("4")){單支出兵上限提升 = 單支出兵上限提升 +	8000 	;}
        if(mili39_S	.matches("5")){單支出兵上限提升 = 單支出兵上限提升 +	10000 	;}
        if(mili39_S	.matches("6")){單支出兵上限提升 = 單支出兵上限提升 +	12000 	;}
        if(mili39_S	.matches("7")){單支出兵上限提升 = 單支出兵上限提升 +	14000 	;}

        /**
         *  MILI PART
         *  --------------
         *  MILI_OFF PART
         */

        if(mili_off01_S	.matches("0")){部隊攻擊力提升 = 部隊攻擊力提升 +	0	;}
        if(mili_off01_S	.matches("1")){部隊攻擊力提升 = 部隊攻擊力提升 +	1	;}
        if(mili_off01_S	.matches("2")){部隊攻擊力提升 = 部隊攻擊力提升 +	2	;}
        if(mili_off01_S	.matches("3")){部隊攻擊力提升 = 部隊攻擊力提升 +	3	;}
        if(mili_off01_S	.matches("4")){部隊攻擊力提升 = 部隊攻擊力提升 +	4	;}
        if(mili_off01_S	.matches("5")){部隊攻擊力提升 = 部隊攻擊力提升 +	5	;}
        if(mili_off01_S	.matches("6")){部隊攻擊力提升 = 部隊攻擊力提升 +	6	;}
        if(mili_off01_S	.matches("7")){部隊攻擊力提升 = 部隊攻擊力提升 +	8	;}
        if(mili_off01_S	.matches("8")){部隊攻擊力提升 = 部隊攻擊力提升 +	10	;}
        if(mili_off01_S	.matches("9")){部隊攻擊力提升 = 部隊攻擊力提升 +	13	;}
        if(mili_off01_S	.matches("10")){部隊攻擊力提升 = 部隊攻擊力提升 +	18	;}

        if(mili_off02_S	.matches("0")){部隊攻城攻擊力提升 = 部隊攻城攻擊力提升 +	0	;}
        if(mili_off02_S	.matches("1")){部隊攻城攻擊力提升 = 部隊攻城攻擊力提升 +	1	;}
        if(mili_off02_S	.matches("2")){部隊攻城攻擊力提升 = 部隊攻城攻擊力提升 +	2	;}
        if(mili_off02_S	.matches("3")){部隊攻城攻擊力提升 = 部隊攻城攻擊力提升 +	3	;}
        if(mili_off02_S	.matches("4")){部隊攻城攻擊力提升 = 部隊攻城攻擊力提升 +	4	;}
        if(mili_off02_S	.matches("5")){部隊攻城攻擊力提升 = 部隊攻城攻擊力提升 +	5	;}
        if(mili_off02_S	.matches("6")){部隊攻城攻擊力提升 = 部隊攻城攻擊力提升 +	6	;}
        if(mili_off02_S	.matches("7")){部隊攻城攻擊力提升 = 部隊攻城攻擊力提升 +	8	;}
        if(mili_off02_S	.matches("8")){部隊攻城攻擊力提升 = 部隊攻城攻擊力提升 +	10	;}
        if(mili_off02_S	.matches("9")){部隊攻城攻擊力提升 = 部隊攻城攻擊力提升 +	13	;}
        if(mili_off02_S	.matches("10")){部隊攻城攻擊力提升 = 部隊攻城攻擊力提升 +	18	;}

        if(mili_off03_S	.matches("0")){野外戰鬥攻擊力提升 = 野外戰鬥攻擊力提升 +	0	;}
        if(mili_off03_S	.matches("1")){野外戰鬥攻擊力提升 = 野外戰鬥攻擊力提升 +	1	;}
        if(mili_off03_S	.matches("2")){野外戰鬥攻擊力提升 = 野外戰鬥攻擊力提升 +	2	;}
        if(mili_off03_S	.matches("3")){野外戰鬥攻擊力提升 = 野外戰鬥攻擊力提升 +	3	;}
        if(mili_off03_S	.matches("4")){野外戰鬥攻擊力提升 = 野外戰鬥攻擊力提升 +	4	;}
        if(mili_off03_S	.matches("5")){野外戰鬥攻擊力提升 = 野外戰鬥攻擊力提升 +	5	;}
        if(mili_off03_S	.matches("6")){野外戰鬥攻擊力提升 = 野外戰鬥攻擊力提升 +	7	;}
        if(mili_off03_S	.matches("7")){野外戰鬥攻擊力提升 = 野外戰鬥攻擊力提升 +	9	;}
        if(mili_off03_S	.matches("8")){野外戰鬥攻擊力提升 = 野外戰鬥攻擊力提升 +	12	;}
        if(mili_off03_S	.matches("9")){野外戰鬥攻擊力提升 = 野外戰鬥攻擊力提升 +	15	;}
        if(mili_off03_S	.matches("10")){野外戰鬥攻擊力提升 = 野外戰鬥攻擊力提升 +	20	;}

        if(mili_off04_S	.matches("0")){火力學員攻城攻擊力提升 = 火力學員攻城攻擊力提升 +	0	;}
        if(mili_off04_S	.matches("1")){火力學員攻城攻擊力提升 = 火力學員攻城攻擊力提升 +	1	;}
        if(mili_off04_S	.matches("2")){火力學員攻城攻擊力提升 = 火力學員攻城攻擊力提升 +	2	;}
        if(mili_off04_S	.matches("3")){火力學員攻城攻擊力提升 = 火力學員攻城攻擊力提升 +	3	;}
        if(mili_off04_S	.matches("4")){火力學員攻城攻擊力提升 = 火力學員攻城攻擊力提升 +	4	;}
        if(mili_off04_S	.matches("5")){火力學員攻城攻擊力提升 = 火力學員攻城攻擊力提升 +	5	;}
        if(mili_off04_S	.matches("6")){火力學員攻城攻擊力提升 = 火力學員攻城攻擊力提升 +	6	;}
        if(mili_off04_S	.matches("7")){火力學員攻城攻擊力提升 = 火力學員攻城攻擊力提升 +	8	;}
        if(mili_off04_S	.matches("8")){火力學員攻城攻擊力提升 = 火力學員攻城攻擊力提升 +	10	;}
        if(mili_off04_S	.matches("9")){火力學員攻城攻擊力提升 = 火力學員攻城攻擊力提升 +	12	;}
        if(mili_off04_S	.matches("10")){火力學員攻城攻擊力提升 = 火力學員攻城攻擊力提升 +	15	;}

        if(mili_off05_S	.matches("0")){機動小組攻城攻擊力提升 = 機動小組攻城攻擊力提升 +	0	;}
        if(mili_off05_S	.matches("1")){機動小組攻城攻擊力提升 = 機動小組攻城攻擊力提升 +	1	;}
        if(mili_off05_S	.matches("2")){機動小組攻城攻擊力提升 = 機動小組攻城攻擊力提升 +	2	;}
        if(mili_off05_S	.matches("3")){機動小組攻城攻擊力提升 = 機動小組攻城攻擊力提升 +	3	;}
        if(mili_off05_S	.matches("4")){機動小組攻城攻擊力提升 = 機動小組攻城攻擊力提升 +	4	;}
        if(mili_off05_S	.matches("5")){機動小組攻城攻擊力提升 = 機動小組攻城攻擊力提升 +	5	;}
        if(mili_off05_S	.matches("6")){機動小組攻城攻擊力提升 = 機動小組攻城攻擊力提升 +	6	;}
        if(mili_off05_S	.matches("7")){機動小組攻城攻擊力提升 = 機動小組攻城攻擊力提升 +	8	;}
        if(mili_off05_S	.matches("8")){機動小組攻城攻擊力提升 = 機動小組攻城攻擊力提升 +	10	;}
        if(mili_off05_S	.matches("9")){機動小組攻城攻擊力提升 = 機動小組攻城攻擊力提升 +	12	;}
        if(mili_off05_S	.matches("10")){機動小組攻城攻擊力提升 = 機動小組攻城攻擊力提升 +	15	;}

        if(mili_off06_S	.matches("0")){機動小組攻城攻擊力提升 = 機動小組攻城攻擊力提升 +	0	;}
        if(mili_off06_S	.matches("1")){機動小組攻城攻擊力提升 = 機動小組攻城攻擊力提升 +	1	;}
        if(mili_off06_S	.matches("2")){機動小組攻城攻擊力提升 = 機動小組攻城攻擊力提升 +	2	;}
        if(mili_off06_S	.matches("3")){機動小組攻城攻擊力提升 = 機動小組攻城攻擊力提升 +	3	;}
        if(mili_off06_S	.matches("4")){機動小組攻城攻擊力提升 = 機動小組攻城攻擊力提升 +	4	;}
        if(mili_off06_S	.matches("5")){機動小組攻城攻擊力提升 = 機動小組攻城攻擊力提升 +	5	;}
        if(mili_off06_S	.matches("6")){機動小組攻城攻擊力提升 = 機動小組攻城攻擊力提升 +	6	;}
        if(mili_off06_S	.matches("7")){機動小組攻城攻擊力提升 = 機動小組攻城攻擊力提升 +	7	;}
        if(mili_off06_S	.matches("8")){機動小組攻城攻擊力提升 = 機動小組攻城攻擊力提升 +	8	;}
        if(mili_off06_S	.matches("9")){機動小組攻城攻擊力提升 = 機動小組攻城攻擊力提升 +	9	;}
        if(mili_off06_S	.matches("10")){機動小組攻城攻擊力提升 = 機動小組攻城攻擊力提升 +	10	;}

        if(mili_off07_S	.matches("0")){火力學員野外攻擊力提升 = 火力學員野外攻擊力提升 +	0	;}
        if(mili_off07_S	.matches("1")){火力學員野外攻擊力提升 = 火力學員野外攻擊力提升 +	1	;}
        if(mili_off07_S	.matches("2")){火力學員野外攻擊力提升 = 火力學員野外攻擊力提升 +	2	;}
        if(mili_off07_S	.matches("3")){火力學員野外攻擊力提升 = 火力學員野外攻擊力提升 +	3	;}
        if(mili_off07_S	.matches("4")){火力學員野外攻擊力提升 = 火力學員野外攻擊力提升 +	4	;}
        if(mili_off07_S	.matches("5")){火力學員野外攻擊力提升 = 火力學員野外攻擊力提升 +	5	;}
        if(mili_off07_S	.matches("6")){火力學員野外攻擊力提升 = 火力學員野外攻擊力提升 +	6	;}
        if(mili_off07_S	.matches("7")){火力學員野外攻擊力提升 = 火力學員野外攻擊力提升 +	8	;}
        if(mili_off07_S	.matches("8")){火力學員野外攻擊力提升 = 火力學員野外攻擊力提升 +	10	;}
        if(mili_off07_S	.matches("9")){火力學員野外攻擊力提升 = 火力學員野外攻擊力提升 +	12	;}
        if(mili_off07_S	.matches("10")){火力學員野外攻擊力提升 = 火力學員野外攻擊力提升 +	15	;}

        if(mili_off08_S	.matches("0")){機動小組野外攻擊力提升 = 機動小組野外攻擊力提升 +	0	;}
        if(mili_off08_S	.matches("1")){機動小組野外攻擊力提升 = 機動小組野外攻擊力提升 +	1	;}
        if(mili_off08_S	.matches("2")){機動小組野外攻擊力提升 = 機動小組野外攻擊力提升 +	2	;}
        if(mili_off08_S	.matches("3")){機動小組野外攻擊力提升 = 機動小組野外攻擊力提升 +	3	;}
        if(mili_off08_S	.matches("4")){機動小組野外攻擊力提升 = 機動小組野外攻擊力提升 +	4	;}
        if(mili_off08_S	.matches("5")){機動小組野外攻擊力提升 = 機動小組野外攻擊力提升 +	5	;}
        if(mili_off08_S	.matches("6")){機動小組野外攻擊力提升 = 機動小組野外攻擊力提升 +	6	;}
        if(mili_off08_S	.matches("7")){機動小組野外攻擊力提升 = 機動小組野外攻擊力提升 +	8	;}
        if(mili_off08_S	.matches("8")){機動小組野外攻擊力提升 = 機動小組野外攻擊力提升 +	10	;}
        if(mili_off08_S	.matches("9")){機動小組野外攻擊力提升 = 機動小組野外攻擊力提升 +	12	;}
        if(mili_off08_S	.matches("10")){機動小組野外攻擊力提升 = 機動小組野外攻擊力提升 +	15	;}

        if(mili_off09_S	.matches("0")){機動小組野外攻擊力提升 = 機動小組野外攻擊力提升 +	0	;}
        if(mili_off09_S	.matches("1")){機動小組野外攻擊力提升 = 機動小組野外攻擊力提升 +	1	;}
        if(mili_off09_S	.matches("2")){機動小組野外攻擊力提升 = 機動小組野外攻擊力提升 +	2	;}
        if(mili_off09_S	.matches("3")){機動小組野外攻擊力提升 = 機動小組野外攻擊力提升 +	3	;}
        if(mili_off09_S	.matches("4")){機動小組野外攻擊力提升 = 機動小組野外攻擊力提升 +	4	;}
        if(mili_off09_S	.matches("5")){機動小組野外攻擊力提升 = 機動小組野外攻擊力提升 +	5	;}
        if(mili_off09_S	.matches("6")){機動小組野外攻擊力提升 = 機動小組野外攻擊力提升 +	6	;}
        if(mili_off09_S	.matches("7")){機動小組野外攻擊力提升 = 機動小組野外攻擊力提升 +	7	;}
        if(mili_off09_S	.matches("8")){機動小組野外攻擊力提升 = 機動小組野外攻擊力提升 +	8	;}
        if(mili_off09_S	.matches("9")){機動小組野外攻擊力提升 = 機動小組野外攻擊力提升 +	9	;}
        if(mili_off09_S	.matches("10")){機動小組野外攻擊力提升 = 機動小組野外攻擊力提升 +	10	;}

        if(mili_off10_S	.matches("0")){行軍速度提升 = 行軍速度提升 +	0	;}
        if(mili_off10_S	.matches("1")){行軍速度提升 = 行軍速度提升 +	1	;}
        if(mili_off10_S	.matches("2")){行軍速度提升 = 行軍速度提升 +	2	;}
        if(mili_off10_S	.matches("3")){行軍速度提升 = 行軍速度提升 +	3	;}
        if(mili_off10_S	.matches("4")){行軍速度提升 = 行軍速度提升 +	5	;}
        if(mili_off10_S	.matches("5")){行軍速度提升 = 行軍速度提升 +	7	;}
        if(mili_off10_S	.matches("6")){行軍速度提升 = 行軍速度提升 +	10	;}
        if(mili_off10_S	.matches("7")){行軍速度提升 = 行軍速度提升 +	13	;}
        if(mili_off10_S	.matches("8")){行軍速度提升 = 行軍速度提升 +	17	;}
        if(mili_off10_S	.matches("9")){行軍速度提升 = 行軍速度提升 +	22	;}
        if(mili_off10_S	.matches("10")){行軍速度提升 = 行軍速度提升 +	30	;}

        if(mili_off11_S	.matches("0")){攻城行軍速度提升 = 攻城行軍速度提升 +	0	;}
        if(mili_off11_S	.matches("1")){攻城行軍速度提升 = 攻城行軍速度提升 +	1	;}
        if(mili_off11_S	.matches("2")){攻城行軍速度提升 = 攻城行軍速度提升 +	2	;}
        if(mili_off11_S	.matches("3")){攻城行軍速度提升 = 攻城行軍速度提升 +	3	;}
        if(mili_off11_S	.matches("4")){攻城行軍速度提升 = 攻城行軍速度提升 +	5	;}
        if(mili_off11_S	.matches("5")){攻城行軍速度提升 = 攻城行軍速度提升 +	7	;}
        if(mili_off11_S	.matches("6")){攻城行軍速度提升 = 攻城行軍速度提升 +	10	;}
        if(mili_off11_S	.matches("7")){攻城行軍速度提升 = 攻城行軍速度提升 +	13	;}
        if(mili_off11_S	.matches("8")){攻城行軍速度提升 = 攻城行軍速度提升 +	17	;}
        if(mili_off11_S	.matches("9")){攻城行軍速度提升 = 攻城行軍速度提升 +	22	;}
        if(mili_off11_S	.matches("10")){攻城行軍速度提升 = 攻城行軍速度提升 +	30	;}

        if(mili_off12_S	.matches("0")){野外行軍速度提升 = 野外行軍速度提升 +	0	;}
        if(mili_off12_S	.matches("1")){野外行軍速度提升 = 野外行軍速度提升 +	1	;}
        if(mili_off12_S	.matches("2")){野外行軍速度提升 = 野外行軍速度提升 +	2	;}
        if(mili_off12_S	.matches("3")){野外行軍速度提升 = 野外行軍速度提升 +	3	;}
        if(mili_off12_S	.matches("4")){野外行軍速度提升 = 野外行軍速度提升 +	5	;}
        if(mili_off12_S	.matches("5")){野外行軍速度提升 = 野外行軍速度提升 +	7	;}
        if(mili_off12_S	.matches("6")){野外行軍速度提升 = 野外行軍速度提升 +	10	;}
        if(mili_off12_S	.matches("7")){野外行軍速度提升 = 野外行軍速度提升 +	13	;}
        if(mili_off12_S	.matches("8")){野外行軍速度提升 = 野外行軍速度提升 +	17	;}
        if(mili_off12_S	.matches("9")){野外行軍速度提升 = 野外行軍速度提升 +	22	;}
        if(mili_off12_S	.matches("10")){野外行軍速度提升 = 野外行軍速度提升 +	30	;}

        if(mili_off13_S	.matches("0")){攻城防禦提升 = 攻城防禦提升 +	0	;}
        if(mili_off13_S	.matches("1")){攻城防禦提升 = 攻城防禦提升 +	1	;}
        if(mili_off13_S	.matches("2")){攻城防禦提升 = 攻城防禦提升 +	2	;}
        if(mili_off13_S	.matches("3")){攻城防禦提升 = 攻城防禦提升 +	3	;}
        if(mili_off13_S	.matches("4")){攻城防禦提升 = 攻城防禦提升 +	4	;}
        if(mili_off13_S	.matches("5")){攻城防禦提升 = 攻城防禦提升 +	5	;}
        if(mili_off13_S	.matches("6")){攻城防禦提升 = 攻城防禦提升 +	7	;}
        if(mili_off13_S	.matches("7")){攻城防禦提升 = 攻城防禦提升 +	9	;}
        if(mili_off13_S	.matches("8")){攻城防禦提升 = 攻城防禦提升 +	12	;}
        if(mili_off13_S	.matches("9")){攻城防禦提升 = 攻城防禦提升 +	15	;}
        if(mili_off13_S	.matches("10")){攻城防禦提升 = 攻城防禦提升 +	20	;}

        if(mili_off14_S	.matches("0")){攻擊指揮官總部攻擊力提升 = 攻擊指揮官總部攻擊力提升 +	0	;}
        if(mili_off14_S	.matches("1")){攻擊指揮官總部攻擊力提升 = 攻擊指揮官總部攻擊力提升 +	1	;}
        if(mili_off14_S	.matches("2")){攻擊指揮官總部攻擊力提升 = 攻擊指揮官總部攻擊力提升 +	2	;}
        if(mili_off14_S	.matches("3")){攻擊指揮官總部攻擊力提升 = 攻擊指揮官總部攻擊力提升 +	3	;}
        if(mili_off14_S	.matches("4")){攻擊指揮官總部攻擊力提升 = 攻擊指揮官總部攻擊力提升 +	5	;}
        if(mili_off14_S	.matches("5")){攻擊指揮官總部攻擊力提升 = 攻擊指揮官總部攻擊力提升 +	7	;}
        if(mili_off14_S	.matches("6")){攻擊指揮官總部攻擊力提升 = 攻擊指揮官總部攻擊力提升 +	9	;}
        if(mili_off14_S	.matches("7")){攻擊指揮官總部攻擊力提升 = 攻擊指揮官總部攻擊力提升 +	12	;}
        if(mili_off14_S	.matches("8")){攻擊指揮官總部攻擊力提升 = 攻擊指揮官總部攻擊力提升 +	15	;}
        if(mili_off14_S	.matches("9")){攻擊指揮官總部攻擊力提升 = 攻擊指揮官總部攻擊力提升 +	18	;}
        if(mili_off14_S	.matches("10")){攻擊指揮官總部攻擊力提升 = 攻擊指揮官總部攻擊力提升 +	25	;}

        if(mili_off15_S	.matches("0")){火力學員攻城防禦力提升 = 火力學員攻城防禦力提升 +	0	;}
        if(mili_off15_S	.matches("1")){火力學員攻城防禦力提升 = 火力學員攻城防禦力提升 +	1	;}
        if(mili_off15_S	.matches("2")){火力學員攻城防禦力提升 = 火力學員攻城防禦力提升 +	2	;}
        if(mili_off15_S	.matches("3")){火力學員攻城防禦力提升 = 火力學員攻城防禦力提升 +	3	;}
        if(mili_off15_S	.matches("4")){火力學員攻城防禦力提升 = 火力學員攻城防禦力提升 +	4	;}
        if(mili_off15_S	.matches("5")){火力學員攻城防禦力提升 = 火力學員攻城防禦力提升 +	5	;}
        if(mili_off15_S	.matches("6")){火力學員攻城防禦力提升 = 火力學員攻城防禦力提升 +	6	;}
        if(mili_off15_S	.matches("7")){火力學員攻城防禦力提升 = 火力學員攻城防禦力提升 +	8	;}
        if(mili_off15_S	.matches("8")){火力學員攻城防禦力提升 = 火力學員攻城防禦力提升 +	10	;}
        if(mili_off15_S	.matches("9")){火力學員攻城防禦力提升 = 火力學員攻城防禦力提升 +	12	;}
        if(mili_off15_S	.matches("10")){火力學員攻城防禦力提升 = 火力學員攻城防禦力提升 +	15	;}

        if(mili_off16_S	.matches("0")){車輛攻城防禦力提升 = 車輛攻城防禦力提升 +	0	;}
        if(mili_off16_S	.matches("1")){車輛攻城防禦力提升 = 車輛攻城防禦力提升 +	1	;}
        if(mili_off16_S	.matches("2")){車輛攻城防禦力提升 = 車輛攻城防禦力提升 +	2	;}
        if(mili_off16_S	.matches("3")){車輛攻城防禦力提升 = 車輛攻城防禦力提升 +	3	;}
        if(mili_off16_S	.matches("4")){車輛攻城防禦力提升 = 車輛攻城防禦力提升 +	4	;}
        if(mili_off16_S	.matches("5")){車輛攻城防禦力提升 = 車輛攻城防禦力提升 +	5	;}
        if(mili_off16_S	.matches("6")){車輛攻城防禦力提升 = 車輛攻城防禦力提升 +	6	;}
        if(mili_off16_S	.matches("7")){車輛攻城防禦力提升 = 車輛攻城防禦力提升 +	8	;}
        if(mili_off16_S	.matches("8")){車輛攻城防禦力提升 = 車輛攻城防禦力提升 +	10	;}
        if(mili_off16_S	.matches("9")){車輛攻城防禦力提升 = 車輛攻城防禦力提升 +	12	;}
        if(mili_off16_S	.matches("10")){車輛攻城防禦力提升 = 車輛攻城防禦力提升 +	15	;}

        if(mili_off17_S	.matches("0")){進擊學員攻城防禦力提升 = 進擊學員攻城防禦力提升 +	0	;}
        if(mili_off17_S	.matches("1")){進擊學員攻城防禦力提升 = 進擊學員攻城防禦力提升 +	1	;}
        if(mili_off17_S	.matches("2")){進擊學員攻城防禦力提升 = 進擊學員攻城防禦力提升 +	2	;}
        if(mili_off17_S	.matches("3")){進擊學員攻城防禦力提升 = 進擊學員攻城防禦力提升 +	3	;}
        if(mili_off17_S	.matches("4")){進擊學員攻城防禦力提升 = 進擊學員攻城防禦力提升 +	4	;}
        if(mili_off17_S	.matches("5")){進擊學員攻城防禦力提升 = 進擊學員攻城防禦力提升 +	5	;}
        if(mili_off17_S	.matches("6")){進擊學員攻城防禦力提升 = 進擊學員攻城防禦力提升 +	6	;}
        if(mili_off17_S	.matches("7")){進擊學員攻城防禦力提升 = 進擊學員攻城防禦力提升 +	8	;}
        if(mili_off17_S	.matches("8")){進擊學員攻城防禦力提升 = 進擊學員攻城防禦力提升 +	10	;}
        if(mili_off17_S	.matches("9")){進擊學員攻城防禦力提升 = 進擊學員攻城防禦力提升 +	12	;}
        if(mili_off17_S	.matches("10")){進擊學員攻城防禦力提升 = 進擊學員攻城防禦力提升 +	15	;}

        if(mili_off18_S	.matches("0")){攻擊巨炮攻擊力提升 = 攻擊巨炮攻擊力提升  +	0	;}
        if(mili_off18_S	.matches("1")){攻擊巨炮攻擊力提升 = 攻擊巨炮攻擊力提升  +	1	;}
        if(mili_off18_S	.matches("2")){攻擊巨炮攻擊力提升 = 攻擊巨炮攻擊力提升  +	2	;}
        if(mili_off18_S	.matches("3")){攻擊巨炮攻擊力提升 = 攻擊巨炮攻擊力提升  +	3	;}
        if(mili_off18_S	.matches("4")){攻擊巨炮攻擊力提升 = 攻擊巨炮攻擊力提升  +	5	;}
        if(mili_off18_S	.matches("5")){攻擊巨炮攻擊力提升 = 攻擊巨炮攻擊力提升  +	7	;}
        if(mili_off18_S	.matches("6")){攻擊巨炮攻擊力提升 = 攻擊巨炮攻擊力提升  +	9	;}
        if(mili_off18_S	.matches("7")){攻擊巨炮攻擊力提升 = 攻擊巨炮攻擊力提升  +	12	;}
        if(mili_off18_S	.matches("8")){攻擊巨炮攻擊力提升 = 攻擊巨炮攻擊力提升  +	15	;}
        if(mili_off18_S	.matches("9")){攻擊巨炮攻擊力提升 = 攻擊巨炮攻擊力提升  +	18	;}
        if(mili_off18_S	.matches("10")){攻擊巨炮攻擊力提升 = 攻擊巨炮攻擊力提升  +	25	;}

        if(mili_off19_S	.matches("0")){單支出兵上限提升 = 單支出兵上限提升  +	0	;}
        if(mili_off19_S	.matches("1")){單支出兵上限提升 = 單支出兵上限提升  +	10000	;}

        /**
         *  MILI_OFF PART
         *  --------------
         *  MILI_DEF PART
         */

        if(mili_def01_S	.matches("0")){部隊防禦力提升 = 部隊防禦力提升 +	0	;}
        if(mili_def01_S	.matches("1")){部隊防禦力提升 = 部隊防禦力提升 +	1	;}
        if(mili_def01_S	.matches("2")){部隊防禦力提升 = 部隊防禦力提升 +	2	;}
        if(mili_def01_S	.matches("3")){部隊防禦力提升 = 部隊防禦力提升 +	3	;}
        if(mili_def01_S	.matches("4")){部隊防禦力提升 = 部隊防禦力提升 +	4	;}
        if(mili_def01_S	.matches("5")){部隊防禦力提升 = 部隊防禦力提升 +	5	;}
        if(mili_def01_S	.matches("6")){部隊防禦力提升 = 部隊防禦力提升 +	6	;}
        if(mili_def01_S	.matches("7")){部隊防禦力提升 = 部隊防禦力提升 +	8	;}
        if(mili_def01_S	.matches("8")){部隊防禦力提升 = 部隊防禦力提升 +	10	;}
        if(mili_def01_S	.matches("9")){部隊防禦力提升 = 部隊防禦力提升 +	13	;}
        if(mili_def01_S	.matches("10")){部隊防禦力提升 = 部隊防禦力提升 +	18	;}

        if(mili_def02_S	.matches("0")){部隊守城攻擊力提升 = 部隊守城攻擊力提升 +	0	;}
        if(mili_def02_S	.matches("1")){部隊守城攻擊力提升 = 部隊守城攻擊力提升 +	1	;}
        if(mili_def02_S	.matches("2")){部隊守城攻擊力提升 = 部隊守城攻擊力提升 +	2	;}
        if(mili_def02_S	.matches("3")){部隊守城攻擊力提升 = 部隊守城攻擊力提升 +	3	;}
        if(mili_def02_S	.matches("4")){部隊守城攻擊力提升 = 部隊守城攻擊力提升 +	4	;}
        if(mili_def02_S	.matches("5")){部隊守城攻擊力提升 = 部隊守城攻擊力提升 +	5	;}
        if(mili_def02_S	.matches("6")){部隊守城攻擊力提升 = 部隊守城攻擊力提升 +	7	;}
        if(mili_def02_S	.matches("7")){部隊守城攻擊力提升 = 部隊守城攻擊力提升 +	9	;}
        if(mili_def02_S	.matches("8")){部隊守城攻擊力提升 = 部隊守城攻擊力提升 +	12	;}
        if(mili_def02_S	.matches("9")){部隊守城攻擊力提升 = 部隊守城攻擊力提升 +	15	;}
        if(mili_def02_S	.matches("10")){部隊守城攻擊力提升 = 部隊守城攻擊力提升 +	20	;}

        if(mili_def03_S	.matches("0")){野外戰鬥防禦力提升 = 野外戰鬥防禦力提升 +	0	;}
        if(mili_def03_S	.matches("1")){野外戰鬥防禦力提升 = 野外戰鬥防禦力提升 +	1	;}
        if(mili_def03_S	.matches("2")){野外戰鬥防禦力提升 = 野外戰鬥防禦力提升 +	2	;}
        if(mili_def03_S	.matches("3")){野外戰鬥防禦力提升 = 野外戰鬥防禦力提升 +	3	;}
        if(mili_def03_S	.matches("4")){野外戰鬥防禦力提升 = 野外戰鬥防禦力提升 +	4	;}
        if(mili_def03_S	.matches("5")){野外戰鬥防禦力提升 = 野外戰鬥防禦力提升 +	5	;}
        if(mili_def03_S	.matches("6")){野外戰鬥防禦力提升 = 野外戰鬥防禦力提升 +	6	;}
        if(mili_def03_S	.matches("7")){野外戰鬥防禦力提升 = 野外戰鬥防禦力提升 +	8	;}
        if(mili_def03_S	.matches("8")){野外戰鬥防禦力提升 = 野外戰鬥防禦力提升 +	10	;}
        if(mili_def03_S	.matches("9")){野外戰鬥防禦力提升 = 野外戰鬥防禦力提升 +	13	;}
        if(mili_def03_S	.matches("10")){野外戰鬥防禦力提升 = 野外戰鬥防禦力提升 +	18	;}

        if(mili_def04_S	.matches("0")){火力學員守城攻擊力提升 = 火力學員守城攻擊力提升 +	0	;}
        if(mili_def04_S	.matches("1")){火力學員守城攻擊力提升 = 火力學員守城攻擊力提升 +	1	;}
        if(mili_def04_S	.matches("2")){火力學員守城攻擊力提升 = 火力學員守城攻擊力提升 +	2	;}
        if(mili_def04_S	.matches("3")){火力學員守城攻擊力提升 = 火力學員守城攻擊力提升 +	3	;}
        if(mili_def04_S	.matches("4")){火力學員守城攻擊力提升 = 火力學員守城攻擊力提升 +	4	;}
        if(mili_def04_S	.matches("5")){火力學員守城攻擊力提升 = 火力學員守城攻擊力提升 +	5	;}
        if(mili_def04_S	.matches("6")){火力學員守城攻擊力提升 = 火力學員守城攻擊力提升 +	6	;}
        if(mili_def04_S	.matches("7")){火力學員守城攻擊力提升 = 火力學員守城攻擊力提升 +	7	;}
        if(mili_def04_S	.matches("8")){火力學員守城攻擊力提升 = 火力學員守城攻擊力提升 +	10	;}
        if(mili_def04_S	.matches("9")){火力學員守城攻擊力提升 = 火力學員守城攻擊力提升 +	12	;}
        if(mili_def04_S	.matches("10")){火力學員守城攻擊力提升 = 火力學員守城攻擊力提升 +	15	;}

        if(mili_def05_S	.matches("0")){車輛守城攻擊力提升 = 車輛守城攻擊力提升 +	0	;}
        if(mili_def05_S	.matches("1")){車輛守城攻擊力提升 = 車輛守城攻擊力提升 +	1	;}
        if(mili_def05_S	.matches("2")){車輛守城攻擊力提升 = 車輛守城攻擊力提升 +	2	;}
        if(mili_def05_S	.matches("3")){車輛守城攻擊力提升 = 車輛守城攻擊力提升 +	3	;}
        if(mili_def05_S	.matches("4")){車輛守城攻擊力提升 = 車輛守城攻擊力提升 +	4	;}
        if(mili_def05_S	.matches("5")){車輛守城攻擊力提升 = 車輛守城攻擊力提升 +	5	;}
        if(mili_def05_S	.matches("6")){車輛守城攻擊力提升 = 車輛守城攻擊力提升 +	6	;}
        if(mili_def05_S	.matches("7")){車輛守城攻擊力提升 = 車輛守城攻擊力提升 +	7	;}
        if(mili_def05_S	.matches("8")){車輛守城攻擊力提升 = 車輛守城攻擊力提升 +	10	;}
        if(mili_def05_S	.matches("9")){車輛守城攻擊力提升 = 車輛守城攻擊力提升 +	12	;}
        if(mili_def05_S	.matches("10")){車輛守城攻擊力提升 = 車輛守城攻擊力提升 +	15	;}

        if(mili_def06_S	.matches("0")){火力學員野外防禦力提升 = 火力學員野外防禦力提升 +	0	;}
        if(mili_def06_S	.matches("1")){火力學員野外防禦力提升 = 火力學員野外防禦力提升 +	1	;}
        if(mili_def06_S	.matches("2")){火力學員野外防禦力提升 = 火力學員野外防禦力提升 +	2	;}
        if(mili_def06_S	.matches("3")){火力學員野外防禦力提升 = 火力學員野外防禦力提升 +	3	;}
        if(mili_def06_S	.matches("4")){火力學員野外防禦力提升 = 火力學員野外防禦力提升 +	4	;}
        if(mili_def06_S	.matches("5")){火力學員野外防禦力提升 = 火力學員野外防禦力提升 +	5	;}
        if(mili_def06_S	.matches("6")){火力學員野外防禦力提升 = 火力學員野外防禦力提升 +	6	;}
        if(mili_def06_S	.matches("7")){火力學員野外防禦力提升 = 火力學員野外防禦力提升 +	7	;}
        if(mili_def06_S	.matches("8")){火力學員野外防禦力提升 = 火力學員野外防禦力提升 +	10	;}
        if(mili_def06_S	.matches("9")){火力學員野外防禦力提升 = 火力學員野外防禦力提升 +	12	;}
        if(mili_def06_S	.matches("10")){火力學員野外防禦力提升 = 火力學員野外防禦力提升 +	15	;}

        if(mili_def07_S	.matches("0")){機動小組野外防禦力提升 = 機動小組野外防禦力提升 +	0	;}
        if(mili_def07_S	.matches("1")){機動小組野外防禦力提升 = 機動小組野外防禦力提升 +	1	;}
        if(mili_def07_S	.matches("2")){機動小組野外防禦力提升 = 機動小組野外防禦力提升 +	2	;}
        if(mili_def07_S	.matches("3")){機動小組野外防禦力提升 = 機動小組野外防禦力提升 +	3	;}
        if(mili_def07_S	.matches("4")){機動小組野外防禦力提升 = 機動小組野外防禦力提升 +	4	;}
        if(mili_def07_S	.matches("5")){機動小組野外防禦力提升 = 機動小組野外防禦力提升 +	5	;}
        if(mili_def07_S	.matches("6")){機動小組野外防禦力提升 = 機動小組野外防禦力提升 +	6	;}
        if(mili_def07_S	.matches("7")){機動小組野外防禦力提升 = 機動小組野外防禦力提升 +	7	;}
        if(mili_def07_S	.matches("8")){機動小組野外防禦力提升 = 機動小組野外防禦力提升 +	10	;}
        if(mili_def07_S	.matches("9")){機動小組野外防禦力提升 = 機動小組野外防禦力提升 +	12	;}
        if(mili_def07_S	.matches("10")){機動小組野外防禦力提升 = 機動小組野外防禦力提升 +	15	;}

        if(mili_def08_S	.matches("0")){進擊學員守城防禦力提升 = 進擊學員守城防禦力提升 +	0	;}
        if(mili_def08_S	.matches("1")){進擊學員守城防禦力提升 = 進擊學員守城防禦力提升 +	1	;}
        if(mili_def08_S	.matches("2")){進擊學員守城防禦力提升 = 進擊學員守城防禦力提升 +	2	;}
        if(mili_def08_S	.matches("3")){進擊學員守城防禦力提升 = 進擊學員守城防禦力提升 +	3	;}
        if(mili_def08_S	.matches("4")){進擊學員守城防禦力提升 = 進擊學員守城防禦力提升 +	4	;}
        if(mili_def08_S	.matches("5")){進擊學員守城防禦力提升 = 進擊學員守城防禦力提升 +	5	;}
        if(mili_def08_S	.matches("6")){進擊學員守城防禦力提升 = 進擊學員守城防禦力提升 +	6	;}
        if(mili_def08_S	.matches("7")){進擊學員守城防禦力提升 = 進擊學員守城防禦力提升 +	7	;}
        if(mili_def08_S	.matches("8")){進擊學員守城防禦力提升 = 進擊學員守城防禦力提升 +	10	;}
        if(mili_def08_S	.matches("9")){進擊學員守城防禦力提升 = 進擊學員守城防禦力提升 +	12	;}
        if(mili_def08_S	.matches("10")){進擊學員守城防禦力提升 = 進擊學員守城防禦力提升 +	15	;}

        if(mili_def09_S	.matches("0")){進擊學員野外防禦力提升 = 進擊學員野外防禦力提升 +	0	;}
        if(mili_def09_S	.matches("1")){進擊學員野外防禦力提升 = 進擊學員野外防禦力提升 +	1	;}
        if(mili_def09_S	.matches("2")){進擊學員野外防禦力提升 = 進擊學員野外防禦力提升 +	2	;}
        if(mili_def09_S	.matches("3")){進擊學員野外防禦力提升 = 進擊學員野外防禦力提升 +	3	;}
        if(mili_def09_S	.matches("4")){進擊學員野外防禦力提升 = 進擊學員野外防禦力提升 +	4	;}
        if(mili_def09_S	.matches("5")){進擊學員野外防禦力提升 = 進擊學員野外防禦力提升 +	5	;}
        if(mili_def09_S	.matches("6")){進擊學員野外防禦力提升 = 進擊學員野外防禦力提升 +	6	;}
        if(mili_def09_S	.matches("7")){進擊學員野外防禦力提升 = 進擊學員野外防禦力提升 +	7	;}
        if(mili_def09_S	.matches("8")){進擊學員野外防禦力提升 = 進擊學員野外防禦力提升 +	10	;}
        if(mili_def09_S	.matches("9")){進擊學員野外防禦力提升 = 進擊學員野外防禦力提升 +	12	;}
        if(mili_def09_S	.matches("10")){進擊學員野外防禦力提升 = 進擊學員野外防禦力提升 +	15	;}

        if(mili_def10_S	.matches("0")){儲藏室容量提升 = 儲藏室容量提升 +	0	;}
        if(mili_def10_S	.matches("1")){儲藏室容量提升 = 儲藏室容量提升 +	1000	;}
        if(mili_def10_S	.matches("2")){儲藏室容量提升 = 儲藏室容量提升 +	2000	;}
        if(mili_def10_S	.matches("3")){儲藏室容量提升 = 儲藏室容量提升 +	3000	;}
        if(mili_def10_S	.matches("4")){儲藏室容量提升 = 儲藏室容量提升 +	5000	;}
        if(mili_def10_S	.matches("5")){儲藏室容量提升 = 儲藏室容量提升 +	7000	;}
        if(mili_def10_S	.matches("6")){儲藏室容量提升 = 儲藏室容量提升 +	9000	;}
        if(mili_def10_S	.matches("7")){儲藏室容量提升 = 儲藏室容量提升 +	12000	;}
        if(mili_def10_S	.matches("8")){儲藏室容量提升 = 儲藏室容量提升 +	15000	;}
        if(mili_def10_S	.matches("9")){儲藏室容量提升 = 儲藏室容量提升 +	20000	;}
        if(mili_def10_S	.matches("10")){儲藏室容量提升 = 儲藏室容量提升 +	30000	;}

        if(mili_def11_S	.matches("0")){守軍防禦增加 = 守軍防禦增加 +	0	;}
        if(mili_def11_S	.matches("1")){守軍防禦增加 = 守軍防禦增加 +	1	;}
        if(mili_def11_S	.matches("2")){守軍防禦增加 = 守軍防禦增加 +	2	;}
        if(mili_def11_S	.matches("3")){守軍防禦增加 = 守軍防禦增加 +	3	;}
        if(mili_def11_S	.matches("4")){守軍防禦增加 = 守軍防禦增加 +	5	;}
        if(mili_def11_S	.matches("5")){守軍防禦增加 = 守軍防禦增加 +	7	;}
        if(mili_def11_S	.matches("6")){守軍防禦增加 = 守軍防禦增加 +	9	;}
        if(mili_def11_S	.matches("7")){守軍防禦增加 = 守軍防禦增加 +	12	;}
        if(mili_def11_S	.matches("8")){守軍防禦增加 = 守軍防禦增加 +	15	;}
        if(mili_def11_S	.matches("9")){守軍防禦增加 = 守軍防禦增加 +	18	;}
        if(mili_def11_S	.matches("10")){守軍防禦增加 = 守軍防禦增加 +	25	;}

        if(mili_def12_S	.matches("0")){火力學員守城防禦力提升 = 火力學員守城防禦力提升 +	0	;}
        if(mili_def12_S	.matches("1")){火力學員守城防禦力提升 = 火力學員守城防禦力提升 +	1	;}
        if(mili_def12_S	.matches("2")){火力學員守城防禦力提升 = 火力學員守城防禦力提升 +	2	;}
        if(mili_def12_S	.matches("3")){火力學員守城防禦力提升 = 火力學員守城防禦力提升 +	3	;}
        if(mili_def12_S	.matches("4")){火力學員守城防禦力提升 = 火力學員守城防禦力提升 +	4	;}
        if(mili_def12_S	.matches("5")){火力學員守城防禦力提升 = 火力學員守城防禦力提升 +	5	;}
        if(mili_def12_S	.matches("6")){火力學員守城防禦力提升 = 火力學員守城防禦力提升 +	6	;}
        if(mili_def12_S	.matches("7")){火力學員守城防禦力提升 = 火力學員守城防禦力提升 +	7	;}
        if(mili_def12_S	.matches("8")){火力學員守城防禦力提升 = 火力學員守城防禦力提升 +	10	;}
        if(mili_def12_S	.matches("9")){火力學員守城防禦力提升 = 火力學員守城防禦力提升 +	12	;}
        if(mili_def12_S	.matches("10")){火力學員守城防禦力提升 = 火力學員守城防禦力提升 +	15	;}

        if(mili_def13_S	.matches("0")){車輛守城防禦力提升 = 車輛守城防禦力提升 +	0	;}
        if(mili_def13_S	.matches("1")){車輛守城防禦力提升 = 車輛守城防禦力提升 +	1	;}
        if(mili_def13_S	.matches("2")){車輛守城防禦力提升 = 車輛守城防禦力提升 +	2	;}
        if(mili_def13_S	.matches("3")){車輛守城防禦力提升 = 車輛守城防禦力提升 +	3	;}
        if(mili_def13_S	.matches("4")){車輛守城防禦力提升 = 車輛守城防禦力提升 +	4	;}
        if(mili_def13_S	.matches("5")){車輛守城防禦力提升 = 車輛守城防禦力提升 +	5	;}
        if(mili_def13_S	.matches("6")){車輛守城防禦力提升 = 車輛守城防禦力提升 +	6	;}
        if(mili_def13_S	.matches("7")){車輛守城防禦力提升 = 車輛守城防禦力提升 +	7	;}
        if(mili_def13_S	.matches("8")){車輛守城防禦力提升 = 車輛守城防禦力提升 +	10	;}
        if(mili_def13_S	.matches("9")){車輛守城防禦力提升 = 車輛守城防禦力提升 +	12	;}
        if(mili_def13_S	.matches("10")){車輛守城防禦力提升 = 車輛守城防禦力提升 +	15	;}

        if(mili_def14_S	.matches("0")){部隊佔領指揮官總部防禦力提升 = 部隊佔領指揮官總部防禦力提升 +	0	;}
        if(mili_def14_S	.matches("1")){部隊佔領指揮官總部防禦力提升 = 部隊佔領指揮官總部防禦力提升 +	1	;}
        if(mili_def14_S	.matches("2")){部隊佔領指揮官總部防禦力提升 = 部隊佔領指揮官總部防禦力提升 +	2	;}
        if(mili_def14_S	.matches("3")){部隊佔領指揮官總部防禦力提升 = 部隊佔領指揮官總部防禦力提升 +	3	;}
        if(mili_def14_S	.matches("4")){部隊佔領指揮官總部防禦力提升 = 部隊佔領指揮官總部防禦力提升 +	5	;}
        if(mili_def14_S	.matches("5")){部隊佔領指揮官總部防禦力提升 = 部隊佔領指揮官總部防禦力提升 +	7	;}
        if(mili_def14_S	.matches("6")){部隊佔領指揮官總部防禦力提升 = 部隊佔領指揮官總部防禦力提升 +	9	;}
        if(mili_def14_S	.matches("7")){部隊佔領指揮官總部防禦力提升 = 部隊佔領指揮官總部防禦力提升 +	12	;}
        if(mili_def14_S	.matches("8")){部隊佔領指揮官總部防禦力提升 = 部隊佔領指揮官總部防禦力提升 +	15	;}
        if(mili_def14_S	.matches("9")){部隊佔領指揮官總部防禦力提升 = 部隊佔領指揮官總部防禦力提升 +	18	;}
        if(mili_def14_S	.matches("10")){部隊佔領指揮官總部防禦力提升 = 部隊佔領指揮官總部防禦力提升 +	25	;}

        if(mili_def15_S	.matches("0")){進擊學員守城防禦力提升 = 進擊學員守城防禦力提升 +	0	;}
        if(mili_def15_S	.matches("1")){進擊學員守城防禦力提升 = 進擊學員守城防禦力提升 +	1	;}
        if(mili_def15_S	.matches("2")){進擊學員守城防禦力提升 = 進擊學員守城防禦力提升 +	2	;}
        if(mili_def15_S	.matches("3")){進擊學員守城防禦力提升 = 進擊學員守城防禦力提升 +	3	;}
        if(mili_def15_S	.matches("4")){進擊學員守城防禦力提升 = 進擊學員守城防禦力提升 +	4	;}
        if(mili_def15_S	.matches("5")){進擊學員守城防禦力提升 = 進擊學員守城防禦力提升 +	5	;}
        if(mili_def15_S	.matches("6")){進擊學員守城防禦力提升 = 進擊學員守城防禦力提升 +	6	;}
        if(mili_def15_S	.matches("7")){進擊學員守城防禦力提升 = 進擊學員守城防禦力提升 +	7	;}
        if(mili_def15_S	.matches("8")){進擊學員守城防禦力提升 = 進擊學員守城防禦力提升 +	10	;}
        if(mili_def15_S	.matches("9")){進擊學員守城防禦力提升 = 進擊學員守城防禦力提升 +	12	;}
        if(mili_def15_S	.matches("10")){進擊學員守城防禦力提升 = 進擊學員守城防禦力提升 +	15	;}

        if(mili_def16_S	.matches("0")){部隊佔領巨炮防禦力提升 = 部隊佔領巨炮防禦力提升 +	0	;}
        if(mili_def16_S	.matches("1")){部隊佔領巨炮防禦力提升 = 部隊佔領巨炮防禦力提升 +	1	;}
        if(mili_def16_S	.matches("2")){部隊佔領巨炮防禦力提升 = 部隊佔領巨炮防禦力提升 +	2	;}
        if(mili_def16_S	.matches("3")){部隊佔領巨炮防禦力提升 = 部隊佔領巨炮防禦力提升 +	3	;}
        if(mili_def16_S	.matches("4")){部隊佔領巨炮防禦力提升 = 部隊佔領巨炮防禦力提升 +	5	;}
        if(mili_def16_S	.matches("5")){部隊佔領巨炮防禦力提升 = 部隊佔領巨炮防禦力提升 +	7	;}
        if(mili_def16_S	.matches("6")){部隊佔領巨炮防禦力提升 = 部隊佔領巨炮防禦力提升 +	9	;}
        if(mili_def16_S	.matches("7")){部隊佔領巨炮防禦力提升 = 部隊佔領巨炮防禦力提升 +	12	;}
        if(mili_def16_S	.matches("8")){部隊佔領巨炮防禦力提升 = 部隊佔領巨炮防禦力提升 +	15	;}
        if(mili_def16_S	.matches("9")){部隊佔領巨炮防禦力提升 = 部隊佔領巨炮防禦力提升 +	18	;}
        if(mili_def16_S	.matches("10")){部隊佔領巨炮防禦力提升 = 部隊佔領巨炮防禦力提升 +	25	;}

        if(mili_def17_S	.matches("0")){傷兵上限提升 = 傷兵上限提升 +	0	;}
        if(mili_def17_S	.matches("1")){傷兵上限提升 = 傷兵上限提升 +	10000	;}

        /**
         *  MILI_DEF PART
         *  --------------
         *  BIO PART
         */

        if(bio01_S	.matches("0")){死體部隊行軍速度增加 = 死體部隊行軍速度增加 +	0	;}
        if(bio01_S	.matches("1")){死體部隊行軍速度增加 = 死體部隊行軍速度增加 +	1	;}
        if(bio01_S	.matches("2")){死體部隊行軍速度增加 = 死體部隊行軍速度增加 +	2	;}
        if(bio01_S	.matches("3")){死體部隊行軍速度增加 = 死體部隊行軍速度增加 +	3	;}
        if(bio01_S	.matches("4")){死體部隊行軍速度增加 = 死體部隊行軍速度增加 +	5	;}
        if(bio01_S	.matches("5")){死體部隊行軍速度增加 = 死體部隊行軍速度增加 +	7	;}
        if(bio01_S	.matches("6")){死體部隊行軍速度增加 = 死體部隊行軍速度增加 +	10	;}
        if(bio01_S	.matches("7")){死體部隊行軍速度增加 = 死體部隊行軍速度增加 +	13	;}
        if(bio01_S	.matches("8")){死體部隊行軍速度增加 = 死體部隊行軍速度增加 +	17	;}
        if(bio01_S	.matches("9")){死體部隊行軍速度增加 = 死體部隊行軍速度增加 +	22	;}
        if(bio01_S	.matches("10")){死體部隊行軍速度增加 = 死體部隊行軍速度增加 +	30	;}

        if(bio02_S	.matches("0")){死體兵防禦增加 = 死體兵防禦增加 +	0	;}
        if(bio02_S	.matches("1")){死體兵防禦增加 = 死體兵防禦增加 +	1	;}
        if(bio02_S	.matches("2")){死體兵防禦增加 = 死體兵防禦增加 +	2	;}
        if(bio02_S	.matches("3")){死體兵防禦增加 = 死體兵防禦增加 +	3	;}
        if(bio02_S	.matches("4")){死體兵防禦增加 = 死體兵防禦增加 +	4	;}
        if(bio02_S	.matches("5")){死體兵防禦增加 = 死體兵防禦增加 +	5	;}
        if(bio02_S	.matches("6")){死體兵防禦增加 = 死體兵防禦增加 +	6	;}
        if(bio02_S	.matches("7")){死體兵防禦增加 = 死體兵防禦增加 +	8	;}
        if(bio02_S	.matches("8")){死體兵防禦增加 = 死體兵防禦增加 +	10	;}
        if(bio02_S	.matches("9")){死體兵防禦增加 = 死體兵防禦增加 +	12	;}
        if(bio02_S	.matches("10")){死體兵防禦增加 = 死體兵防禦增加 +	15	;}

        if(bio03_S	.matches("0")){死體兵攻擊增加 = 死體兵攻擊增加 +	0	;}
        if(bio03_S	.matches("1")){死體兵攻擊增加 = 死體兵攻擊增加 +	1	;}
        if(bio03_S	.matches("2")){死體兵攻擊增加 = 死體兵攻擊增加 +	2	;}
        if(bio03_S	.matches("3")){死體兵攻擊增加 = 死體兵攻擊增加 +	3	;}
        if(bio03_S	.matches("4")){死體兵攻擊增加 = 死體兵攻擊增加 +	4	;}
        if(bio03_S	.matches("5")){死體兵攻擊增加 = 死體兵攻擊增加 +	5	;}
        if(bio03_S	.matches("6")){死體兵攻擊增加 = 死體兵攻擊增加 +	6	;}
        if(bio03_S	.matches("7")){死體兵攻擊增加 = 死體兵攻擊增加 +	8	;}
        if(bio03_S	.matches("8")){死體兵攻擊增加 = 死體兵攻擊增加 +	10	;}
        if(bio03_S	.matches("9")){死體兵攻擊增加 = 死體兵攻擊增加 +	12	;}
        if(bio03_S	.matches("10")){死體兵攻擊增加 = 死體兵攻擊增加 +	15	;}

        if(bio04_S	.matches("0")){死體野外防禦力增加 = 死體野外防禦力增加 +	0	;}
        if(bio04_S	.matches("1")){死體野外防禦力增加 = 死體野外防禦力增加 +	1	;}
        if(bio04_S	.matches("2")){死體野外防禦力增加 = 死體野外防禦力增加 +	2	;}
        if(bio04_S	.matches("3")){死體野外防禦力增加 = 死體野外防禦力增加 +	3	;}
        if(bio04_S	.matches("4")){死體野外防禦力增加 = 死體野外防禦力增加 +	4	;}
        if(bio04_S	.matches("5")){死體野外防禦力增加 = 死體野外防禦力增加 +	5	;}
        if(bio04_S	.matches("6")){死體野外防禦力增加 = 死體野外防禦力增加 +	6	;}
        if(bio04_S	.matches("7")){死體野外防禦力增加 = 死體野外防禦力增加 +	8	;}
        if(bio04_S	.matches("8")){死體野外防禦力增加 = 死體野外防禦力增加 +	10	;}
        if(bio04_S	.matches("9")){死體野外防禦力增加 = 死體野外防禦力增加 +	12	;}
        if(bio04_S	.matches("10")){死體野外防禦力增加 = 死體野外防禦力增加 +	15	;}

        if(bio05_S	.matches("0")){死體野外攻擊力增加 = 死體野外攻擊力增加 +	0	;}
        if(bio05_S	.matches("1")){死體野外攻擊力增加 = 死體野外攻擊力增加 +	1	;}
        if(bio05_S	.matches("2")){死體野外攻擊力增加 = 死體野外攻擊力增加 +	2	;}
        if(bio05_S	.matches("3")){死體野外攻擊力增加 = 死體野外攻擊力增加 +	3	;}
        if(bio05_S	.matches("4")){死體野外攻擊力增加 = 死體野外攻擊力增加 +	4	;}
        if(bio05_S	.matches("5")){死體野外攻擊力增加 = 死體野外攻擊力增加 +	5	;}
        if(bio05_S	.matches("6")){死體野外攻擊力增加 = 死體野外攻擊力增加 +	6	;}
        if(bio05_S	.matches("7")){死體野外攻擊力增加 = 死體野外攻擊力增加 +	8	;}
        if(bio05_S	.matches("8")){死體野外攻擊力增加 = 死體野外攻擊力增加 +	10	;}
        if(bio05_S	.matches("9")){死體野外攻擊力增加 = 死體野外攻擊力增加 +	12	;}
        if(bio05_S	.matches("10")){死體野外攻擊力增加 = 死體野外攻擊力增加 +	15	;}

        if(bio06_S	.matches("0")){死體負重增加 = 死體負重增加 +	0	;}
        if(bio06_S	.matches("1")){死體負重增加 = 死體負重增加 +	1	;}
        if(bio06_S	.matches("2")){死體負重增加 = 死體負重增加 +	2	;}
        if(bio06_S	.matches("3")){死體負重增加 = 死體負重增加 +	3	;}
        if(bio06_S	.matches("4")){死體負重增加 = 死體負重增加 +	4	;}
        if(bio06_S	.matches("5")){死體負重增加 = 死體負重增加 +	5	;}
        if(bio06_S	.matches("6")){死體負重增加 = 死體負重增加 +	6	;}
        if(bio06_S	.matches("7")){死體負重增加 = 死體負重增加 +	8	;}
        if(bio06_S	.matches("8")){死體負重增加 = 死體負重增加 +	10	;}
        if(bio06_S	.matches("9")){死體負重增加 = 死體負重增加 +	12	;}
        if(bio06_S	.matches("10")){死體負重增加 = 死體負重增加 +	15	;}

        if(bio07_S	.matches("0")){死體兵攻城攻擊增加 = 死體兵攻城攻擊增加 +	0	;}
        if(bio07_S	.matches("1")){死體兵攻城攻擊增加 = 死體兵攻城攻擊增加 +	1	;}
        if(bio07_S	.matches("2")){死體兵攻城攻擊增加 = 死體兵攻城攻擊增加 +	2	;}
        if(bio07_S	.matches("3")){死體兵攻城攻擊增加 = 死體兵攻城攻擊增加 +	3	;}
        if(bio07_S	.matches("4")){死體兵攻城攻擊增加 = 死體兵攻城攻擊增加 +	4	;}
        if(bio07_S	.matches("5")){死體兵攻城攻擊增加 = 死體兵攻城攻擊增加 +	5	;}
        if(bio07_S	.matches("6")){死體兵攻城攻擊增加 = 死體兵攻城攻擊增加 +	6	;}
        if(bio07_S	.matches("7")){死體兵攻城攻擊增加 = 死體兵攻城攻擊增加 +	8	;}
        if(bio07_S	.matches("8")){死體兵攻城攻擊增加 = 死體兵攻城攻擊增加 +	10	;}
        if(bio07_S	.matches("9")){死體兵攻城攻擊增加 = 死體兵攻城攻擊增加 +	12	;}
        if(bio07_S	.matches("10")){死體兵攻城攻擊增加 = 死體兵攻城攻擊增加 +	15	;}

        if(bio08_S	.matches("0")){死體攻城防禦增加 = 死體攻城防禦增加 +	0	;}
        if(bio08_S	.matches("1")){死體攻城防禦增加 = 死體攻城防禦增加 +	1	;}
        if(bio08_S	.matches("2")){死體攻城防禦增加 = 死體攻城防禦增加 +	2	;}
        if(bio08_S	.matches("3")){死體攻城防禦增加 = 死體攻城防禦增加 +	3	;}
        if(bio08_S	.matches("4")){死體攻城防禦增加 = 死體攻城防禦增加 +	4	;}
        if(bio08_S	.matches("5")){死體攻城防禦增加 = 死體攻城防禦增加 +	5	;}
        if(bio08_S	.matches("6")){死體攻城防禦增加 = 死體攻城防禦增加 +	6	;}
        if(bio08_S	.matches("7")){死體攻城防禦增加 = 死體攻城防禦增加 +	8	;}
        if(bio08_S	.matches("8")){死體攻城防禦增加 = 死體攻城防禦增加 +	10	;}
        if(bio08_S	.matches("9")){死體攻城防禦增加 = 死體攻城防禦增加 +	12	;}
        if(bio08_S	.matches("10")){死體攻城防禦增加 = 死體攻城防禦增加 +	15	;}

        if(bio09_S	.matches("0")){死體守城攻擊增加 = 死體守城攻擊增加 +	0	;}
        if(bio09_S	.matches("1")){死體守城攻擊增加 = 死體守城攻擊增加 +	1	;}
        if(bio09_S	.matches("2")){死體守城攻擊增加 = 死體守城攻擊增加 +	2	;}
        if(bio09_S	.matches("3")){死體守城攻擊增加 = 死體守城攻擊增加 +	3	;}
        if(bio09_S	.matches("4")){死體守城攻擊增加 = 死體守城攻擊增加 +	4	;}
        if(bio09_S	.matches("5")){死體守城攻擊增加 = 死體守城攻擊增加 +	5	;}
        if(bio09_S	.matches("6")){死體守城攻擊增加 = 死體守城攻擊增加 +	6	;}
        if(bio09_S	.matches("7")){死體守城攻擊增加 = 死體守城攻擊增加 +	8	;}
        if(bio09_S	.matches("8")){死體守城攻擊增加 = 死體守城攻擊增加 +	10	;}
        if(bio09_S	.matches("9")){死體守城攻擊增加 = 死體守城攻擊增加 +	12	;}
        if(bio09_S	.matches("10")){死體守城攻擊增加 = 死體守城攻擊增加 +	15	;}

        if(bio10_S	.matches("0")){死體守城防禦增加 = 死體守城防禦增加 +	0	;}
        if(bio10_S	.matches("1")){死體守城防禦增加 = 死體守城防禦增加 +	1	;}
        if(bio10_S	.matches("2")){死體守城防禦增加 = 死體守城防禦增加 +	2	;}
        if(bio10_S	.matches("3")){死體守城防禦增加 = 死體守城防禦增加 +	3	;}
        if(bio10_S	.matches("4")){死體守城防禦增加 = 死體守城防禦增加 +	4	;}
        if(bio10_S	.matches("5")){死體守城防禦增加 = 死體守城防禦增加 +	5	;}
        if(bio10_S	.matches("6")){死體守城防禦增加 = 死體守城防禦增加 +	6	;}
        if(bio10_S	.matches("7")){死體守城防禦增加 = 死體守城防禦增加 +	8	;}
        if(bio10_S	.matches("8")){死體守城防禦增加 = 死體守城防禦增加 +	10	;}
        if(bio10_S	.matches("9")){死體守城防禦增加 = 死體守城防禦增加 +	12	;}
        if(bio10_S	.matches("10")){死體守城防禦增加 = 死體守城防禦增加 +	15	;}

        if(bio11_S	.matches("0")){死體兵生命增加 = 死體兵生命增加 +	0	;}
        if(bio11_S	.matches("1")){死體兵生命增加 = 死體兵生命增加 +	1	;}
        if(bio11_S	.matches("2")){死體兵生命增加 = 死體兵生命增加 +	2	;}
        if(bio11_S	.matches("3")){死體兵生命增加 = 死體兵生命增加 +	3	;}
        if(bio11_S	.matches("4")){死體兵生命增加 = 死體兵生命增加 +	4	;}
        if(bio11_S	.matches("5")){死體兵生命增加 = 死體兵生命增加 +	5	;}
        if(bio11_S	.matches("6")){死體兵生命增加 = 死體兵生命增加 +	6	;}
        if(bio11_S	.matches("7")){死體兵生命增加 = 死體兵生命增加 +	8	;}
        if(bio11_S	.matches("8")){死體兵生命增加 = 死體兵生命增加 +	10	;}
        if(bio11_S	.matches("9")){死體兵生命增加 = 死體兵生命增加 +	12	;}
        if(bio11_S	.matches("10")){死體兵生命增加 = 死體兵生命增加 +	15	;}

        buffed = "" ;

        buffed = buffed+""+(getString(R.string.tech_buff1)+" : " +燃料生產率提高+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff2)+" : "+食物生產率提高+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff3)+" : "+儲藏室保護資源增加);
        buffed = buffed+"\n"+(getString(R.string.tech_buff4)+" : "+燃料採集速度增快+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff5)+" : "+食物採集速度增快+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff6)+" : "+鋼鐵生產率提高+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff7)+" : "+鋼鐵採集速度增快+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff8)+" : "+合金生產率提高+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff9)+" : "+合金採集速度增快+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff10)+" : "+鑽石採集速度增加+"%");

        buffed = buffed+"\n"+(getString(R.string.tech_buff11)+" : "+部隊負重提高+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff12)+" : "+增加打怪行軍速度+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff13)+" : "+體力恢復加速+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff14)+" : "+建築建造速度加快+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff15)+" : "+傷兵數量上限提高);
        buffed = buffed+"\n"+(getString(R.string.tech_buff16)+" : "+傷兵恢復速度加快+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff17)+" : "+部隊消耗食物降低+"%");

        buffed = buffed+"\n"+(getString(R.string.tech_buff18)+" : "+城防值增加);
        buffed = buffed+"\n"+(getString(R.string.tech_buff19)+" : "+守軍攻擊增加+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff20)+" : "+守軍防禦增加+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff21)+" : "+防禦武器攻擊增加+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff22)+" : "+燃燒彈對火力學員傷害提高+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff23)+" : "+防禦武器上限增加+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff24)+" : "+手雷對進擊學員傷害提高);
        buffed = buffed+"\n"+(getString(R.string.tech_buff25)+" : "+地雷對機動小組傷害提高+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff26)+" : "+防禦武器建造速度加快+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff27)+" : "+出征戰鬥中_損失的學員一定比例轉化為傷兵+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff28)+" : "+學員訓練速度增加+"%");

        buffed = buffed+"\n"+(getString(R.string.tech_buff29)+" : "+進擊學員攻擊提高+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff30)+" : "+火力學員攻擊提高+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff31)+" : "+機動小組攻擊提高+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff32)+" : "+行軍速度提高+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff33)+" : "+進擊學員防禦提高+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff34)+" : "+火力學員防禦提高+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff35)+" : "+機動小組防禦提高+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff36)+" : "+出征部隊上限增加1支);
        buffed = buffed+"\n"+(getString(R.string.tech_buff37)+" : "+進擊學員生命提高+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff38)+" : "+火力學員生命提高+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff39)+" : "+機動小組生命提高+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff40)+" : "+單支出兵上限提升);
        buffed = buffed+"\n"+(getString(R.string.tech_buff41)+" : "+部隊攻擊力提升+"%");

        buffed = buffed+"\n"+(getString(R.string.tech_buff42)+" : "+部隊攻城攻擊力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff43)+" : "+野外戰鬥攻擊力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff44)+" : "+火力學員攻城攻擊力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff45)+" : "+機動小組攻城攻擊力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff46)+" : "+火力學員野外攻擊力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff47)+" : "+機動小組野外攻擊力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff48)+" : "+進擊學員攻城攻擊力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff49)+" : "+進擊學員野外攻擊力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff50)+" : "+行軍速度提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff51)+" : "+攻城行軍速度提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff52)+" : "+野外行軍速度提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff53)+" : "+攻城防禦提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff54)+" : "+攻擊指揮官總部攻擊力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff55)+" : "+火力學員攻城防禦力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff56)+" : "+車輛攻城防禦力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff57)+" : "+進擊學員攻城防禦力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff58)+" : "+攻擊巨炮攻擊力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff59)+" : "+單支出兵上限提升);
        buffed = buffed+"\n"+(getString(R.string.tech_buff60)+" : "+部隊防禦力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff61)+" : "+部隊守城攻擊力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff62)+" : "+野外戰鬥防禦力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff63)+" : "+火力學員守城攻擊力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff64)+" : "+車輛守城攻擊力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff65)+" : "+火力學員野外防禦力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff66)+" : "+機動小組野外防禦力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff67)+" : "+進擊學員守城攻擊力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff68)+" : "+進擊學員野外防禦力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff69)+" : "+儲藏室容量提升);
        buffed = buffed+"\n"+(getString(R.string.tech_buff70)+" : "+守軍防禦增加+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff71)+" : "+火力學員守城防禦力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff72)+" : "+車輛守城防禦力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff73)+" : "+部隊佔領指揮官總部防禦力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff74)+" : "+進擊學員守城防禦力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff75)+" : "+部隊佔領巨炮防禦力提升+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff76)+" : "+傷兵上限提升);
        buffed = buffed+"\n"+(getString(R.string.tech_buff77)+" : "+死體部隊行軍速度增加+"%");

        buffed = buffed+"\n"+(getString(R.string.tech_buff78)+" : "+死體兵防禦增加+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff79)+" : "+死體兵攻擊增加+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff80)+" : "+死體野外防禦力增加+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff81)+" : "+死體野外攻擊力增加+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff82)+" : "+死體負重增加+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff83)+" : "+死體兵攻城攻擊增加+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff84)+" : "+死體攻城防禦增加+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff85)+" : "+死體守城攻擊增加+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff86)+" : "+死體守城防禦增加+"%");
        buffed = buffed+"\n"+(getString(R.string.tech_buff87)+" : "+死體兵生命增加+"%");

        androidx.appcompat.app.AlertDialog.Builder builder = new AlertDialog.Builder(
                this);
        builder.setTitle(getString(R.string.buff)+" : ")// 标题
                .setIcon(R.drawable.app_icon_round) // icon
                .setMessage(buffed);//"Happy Birthday"
        builder.show();

    }

    }
