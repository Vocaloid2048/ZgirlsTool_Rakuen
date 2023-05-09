package voc.net.tools.zgirls_tool.old_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.util.LotteryDbAdapter;
import voc.net.tools.zgirls_tool.R;

public class EquipmentLotteryActivity extends AppCompatActivity {

    Button lottery ;
    ImageView lottery_final ;
    LotteryDbAdapter helper;
    int item_id = 8 , item_rare = 13 ;
    int item_rare1_num =0   , item_rare2_num=0	, item_rare3_num=0	, item_rare4_num=0	, item_rare5_num=0	, item_rare6_num=0	, item_rare7_num=0;

    boolean visible = true ;

    TextView item01_tr1,item01_tr2,item01_tr3,item01_tr4,item01_tr5,item01_tr6,item01_tr7;
    TextView item02_tr1,item02_tr2,item02_tr3,item02_tr4,item02_tr5,item02_tr6,item02_tr7;
    TextView item03_tr1,item03_tr2,item03_tr3,item03_tr4,item03_tr5,item03_tr6,item03_tr7;
    TextView item04_tr1,item04_tr2,item04_tr3,item04_tr4,item04_tr5,item04_tr6,item04_tr7;
    TextView item05_tr1,item05_tr2,item05_tr3,item05_tr4,item05_tr5,item05_tr6,item05_tr7;
    TextView item06_tr1,item06_tr2,item06_tr3,item06_tr4,item06_tr5,item06_tr6,item06_tr7;
    TextView item07_tr1,item07_tr2,item07_tr3,item07_tr4,item07_tr5,item07_tr6,item07_tr7;
    TextView item08_tr1,item08_tr2,item08_tr3,item08_tr4,item08_tr5,item08_tr6,item08_tr7;
    TextView item09_tr1,item09_tr2,item09_tr3,item09_tr4,item09_tr5,item09_tr6,item09_tr7;
    TextView item10_tr1,item10_tr2,item10_tr3,item10_tr4,item10_tr5,item10_tr6,item10_tr7;
    TextView item11_tr1,item11_tr2,item11_tr3,item11_tr4,item11_tr5,item11_tr6,item11_tr7;
    TextView item12_tr1,item12_tr2,item12_tr3,item12_tr4,item12_tr5,item12_tr6,item12_tr7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_equipment_lottery);

        lottery = findViewById(R.id.lottery_btn);
        lottery_final = findViewById(R.id.lottery_final);

        item01_tr1 = findViewById(R.id.item01_tr1);
        item02_tr1 = findViewById(R.id.item02_tr1);
        item03_tr1 = findViewById(R.id.item03_tr1);
        item04_tr1 = findViewById(R.id.item04_tr1);
        item05_tr1 = findViewById(R.id.item05_tr1);
        item06_tr1 = findViewById(R.id.item06_tr1);
        item07_tr1 = findViewById(R.id.item07_tr1);
        item08_tr1 = findViewById(R.id.item08_tr1);
        item09_tr1 = findViewById(R.id.item09_tr1);
        item10_tr1 = findViewById(R.id.item10_tr1);
        item11_tr1 = findViewById(R.id.item11_tr1);
        item12_tr1 = findViewById(R.id.item12_tr1);
        item01_tr2 = findViewById(R.id.item01_tr2);
        item02_tr2 = findViewById(R.id.item02_tr2);
        item03_tr2 = findViewById(R.id.item03_tr2);
        item04_tr2 = findViewById(R.id.item04_tr2);
        item05_tr2 = findViewById(R.id.item05_tr2);
        item06_tr2 = findViewById(R.id.item06_tr2);
        item07_tr2 = findViewById(R.id.item07_tr2);
        item08_tr2 = findViewById(R.id.item08_tr2);
        item09_tr2 = findViewById(R.id.item09_tr2);
        item10_tr2 = findViewById(R.id.item10_tr2);
        item11_tr2 = findViewById(R.id.item11_tr2);
        item12_tr2 = findViewById(R.id.item12_tr2);
        item01_tr3 = findViewById(R.id.item01_tr3);
        item02_tr3 = findViewById(R.id.item02_tr3);
        item03_tr3 = findViewById(R.id.item03_tr3);
        item04_tr3 = findViewById(R.id.item04_tr3);
        item05_tr3 = findViewById(R.id.item05_tr3);
        item06_tr3 = findViewById(R.id.item06_tr3);
        item07_tr3 = findViewById(R.id.item07_tr3);
        item08_tr3 = findViewById(R.id.item08_tr3);
        item09_tr3 = findViewById(R.id.item09_tr3);
        item10_tr3 = findViewById(R.id.item10_tr3);
        item11_tr3 = findViewById(R.id.item11_tr3);
        item12_tr3 = findViewById(R.id.item12_tr3);
        item01_tr4 = findViewById(R.id.item01_tr4);
        item02_tr4 = findViewById(R.id.item02_tr4);
        item03_tr4 = findViewById(R.id.item03_tr4);
        item04_tr4 = findViewById(R.id.item04_tr4);
        item05_tr4 = findViewById(R.id.item05_tr4);
        item06_tr4 = findViewById(R.id.item06_tr4);
        item07_tr4 = findViewById(R.id.item07_tr4);
        item08_tr4 = findViewById(R.id.item08_tr4);
        item09_tr4 = findViewById(R.id.item09_tr4);
        item10_tr4 = findViewById(R.id.item10_tr4);
        item11_tr4 = findViewById(R.id.item11_tr4);
        item12_tr4 = findViewById(R.id.item12_tr4);
        item01_tr5 = findViewById(R.id.item01_tr5);
        item02_tr5 = findViewById(R.id.item02_tr5);
        item03_tr5 = findViewById(R.id.item03_tr5);
        item04_tr5 = findViewById(R.id.item04_tr5);
        item05_tr5 = findViewById(R.id.item05_tr5);
        item06_tr5 = findViewById(R.id.item06_tr5);
        item07_tr5 = findViewById(R.id.item07_tr5);
        item08_tr5 = findViewById(R.id.item08_tr5);
        item09_tr5 = findViewById(R.id.item09_tr5);
        item10_tr5 = findViewById(R.id.item10_tr5);
        item11_tr5 = findViewById(R.id.item11_tr5);
        item12_tr5 = findViewById(R.id.item12_tr5);
        item01_tr6 = findViewById(R.id.item01_tr6);
        item02_tr6 = findViewById(R.id.item02_tr6);
        item03_tr6 = findViewById(R.id.item03_tr6);
        item04_tr6 = findViewById(R.id.item04_tr6);
        item05_tr6 = findViewById(R.id.item05_tr6);
        item06_tr6 = findViewById(R.id.item06_tr6);
        item07_tr6 = findViewById(R.id.item07_tr6);
        item08_tr6 = findViewById(R.id.item08_tr6);
        item09_tr6 = findViewById(R.id.item09_tr6);
        item10_tr6 = findViewById(R.id.item10_tr6);
        item11_tr6 = findViewById(R.id.item11_tr6);
        item12_tr6 = findViewById(R.id.item12_tr6);
        item01_tr7 = findViewById(R.id.item01_tr7);
        item02_tr7 = findViewById(R.id.item02_tr7);
        item03_tr7 = findViewById(R.id.item03_tr7);
        item04_tr7 = findViewById(R.id.item04_tr7);
        item05_tr7 = findViewById(R.id.item05_tr7);
        item06_tr7 = findViewById(R.id.item06_tr7);
        item07_tr7 = findViewById(R.id.item07_tr7);
        item08_tr7 = findViewById(R.id.item08_tr7);
        item09_tr7 = findViewById(R.id.item09_tr7);
        item10_tr7 = findViewById(R.id.item10_tr7);
        item11_tr7 = findViewById(R.id.item11_tr7);
        item12_tr7 = findViewById(R.id.item12_tr7);

        BackgroundReload();

        //view.setImageDrawable(bd);
        dataRefresh();
        tv();
    }
    public void BackgroundReload (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.lottery_bg);

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

    public void lottery (View view) {
        helper = new LotteryDbAdapter(this);
        helper.getItem();
        lottery.setVisibility(View.GONE);
        int item = (int) (Math.random() * 11);
        int rare = (int) (Math.random() * 6);

        if(item == 0 ){	lottery_final.setImageResource(R.drawable.lottery010);item_id=0;}
        if(item == 1 ){	lottery_final.setImageResource(R.drawable.lottery020);item_id=1;}
        if(item == 2 ){	lottery_final.setImageResource(R.drawable.lottery030);item_id=2;}
        if(item == 3 ){	lottery_final.setImageResource(R.drawable.lottery040);item_id=3;}
        if(item == 4 ){	lottery_final.setImageResource(R.drawable.lottery050);item_id=4;}
        if(item == 5 ){	lottery_final.setImageResource(R.drawable.lottery060);item_id=5;}
        if(item == 6 ){	lottery_final.setImageResource(R.drawable.lottery070);item_id=6;}
        if(item == 7 ){	lottery_final.setImageResource(R.drawable.lottery080);item_id=7;}
        if(item == 8 ){	lottery_final.setImageResource(R.drawable.lottery090);item_id=8;}
        if(item == 9 ){	lottery_final.setImageResource(R.drawable.lottery100);item_id=9;}
        if(item == 10 ){	lottery_final.setImageResource(R.drawable.lottery110);item_id=10;}
        if(item == 11 ){	lottery_final.setImageResource(R.drawable.lottery120);item_id=11;}

        if (rare == 0){	lottery_final.setBackgroundResource(R.drawable.rare1); item_rare = 0;}
        if (rare == 1){	lottery_final.setBackgroundResource(R.drawable.rare2); item_rare = 1;}
        if (rare == 2){	lottery_final.setBackgroundResource(R.drawable.rare3); item_rare = 2;}
        if (rare == 3){	lottery_final.setBackgroundResource(R.drawable.rare4); item_rare = 3;}
        if (rare == 4){	lottery_final.setBackgroundResource(R.drawable.rare5); item_rare = 4;}
        if (rare == 5){	lottery_final.setBackgroundResource(R.drawable.rare6); item_rare = 5;}
        if (rare == 6){	lottery_final.setBackgroundResource(R.drawable.rare7); item_rare = 6;}
        lottery.setVisibility(View.VISIBLE);

        Log.i("ITEM", String.valueOf(item_id));
        Log.i("RARE", String.valueOf(item_rare));

            if (item_id == 0){	item_rare1_num =	Integer.parseInt(helper.DataItemRare1()	.split(" \n")[0]);	item_rare2_num =	Integer.parseInt(helper.DataItemRare2()	.split(" \n")[0]);	item_rare3_num =	Integer.parseInt(helper.DataItemRare3()	.split(" \n")[0]);	item_rare4_num =	Integer.parseInt(helper.DataItemRare4()	.split(" \n")[0]);	item_rare5_num =	Integer.parseInt(helper.DataItemRare5()	.split(" \n")[0]);	item_rare6_num =	Integer.parseInt(helper.DataItemRare6()	.split(" \n")[0]);	item_rare7_num =	Integer.parseInt(helper.DataItemRare7()	.split(" \n")[0]);	}
            if (item_id == 1){	item_rare1_num =	Integer.parseInt(helper.DataItemRare1()	.split(" \n")[1]);	item_rare2_num =	Integer.parseInt(helper.DataItemRare2()	.split(" \n")[1]);	item_rare3_num =	Integer.parseInt(helper.DataItemRare3()	.split(" \n")[1]);	item_rare4_num =	Integer.parseInt(helper.DataItemRare4()	.split(" \n")[1]);	item_rare5_num =	Integer.parseInt(helper.DataItemRare5()	.split(" \n")[1]);	item_rare6_num =	Integer.parseInt(helper.DataItemRare6()	.split(" \n")[1]);	item_rare7_num =	Integer.parseInt(helper.DataItemRare7()	.split(" \n")[1]);	}
            if (item_id == 2){	item_rare1_num =	Integer.parseInt(helper.DataItemRare1()	.split(" \n")[2]);	item_rare2_num =	Integer.parseInt(helper.DataItemRare2()	.split(" \n")[2]);	item_rare3_num =	Integer.parseInt(helper.DataItemRare3()	.split(" \n")[2]);	item_rare4_num =	Integer.parseInt(helper.DataItemRare4()	.split(" \n")[2]);	item_rare5_num =	Integer.parseInt(helper.DataItemRare5()	.split(" \n")[2]);	item_rare6_num =	Integer.parseInt(helper.DataItemRare6()	.split(" \n")[2]);	item_rare7_num =	Integer.parseInt(helper.DataItemRare7()	.split(" \n")[2]);	}
            if (item_id == 3){	item_rare1_num =	Integer.parseInt(helper.DataItemRare1()	.split(" \n")[3]);	item_rare2_num =	Integer.parseInt(helper.DataItemRare2()	.split(" \n")[3]);	item_rare3_num =	Integer.parseInt(helper.DataItemRare3()	.split(" \n")[3]);	item_rare4_num =	Integer.parseInt(helper.DataItemRare4()	.split(" \n")[3]);	item_rare5_num =	Integer.parseInt(helper.DataItemRare5()	.split(" \n")[3]);	item_rare6_num =	Integer.parseInt(helper.DataItemRare6()	.split(" \n")[3]);	item_rare7_num =	Integer.parseInt(helper.DataItemRare7()	.split(" \n")[3]);	}
            if (item_id == 4){	item_rare1_num =	Integer.parseInt(helper.DataItemRare1()	.split(" \n")[4]);	item_rare2_num =	Integer.parseInt(helper.DataItemRare2()	.split(" \n")[4]);	item_rare3_num =	Integer.parseInt(helper.DataItemRare3()	.split(" \n")[4]);	item_rare4_num =	Integer.parseInt(helper.DataItemRare4()	.split(" \n")[4]);	item_rare5_num =	Integer.parseInt(helper.DataItemRare5()	.split(" \n")[4]);	item_rare6_num =	Integer.parseInt(helper.DataItemRare6()	.split(" \n")[4]);	item_rare7_num =	Integer.parseInt(helper.DataItemRare7()	.split(" \n")[4]);	}
            if (item_id == 5){	item_rare1_num =	Integer.parseInt(helper.DataItemRare1()	.split(" \n")[5]);	item_rare2_num =	Integer.parseInt(helper.DataItemRare2()	.split(" \n")[5]);	item_rare3_num =	Integer.parseInt(helper.DataItemRare3()	.split(" \n")[5]);	item_rare4_num =	Integer.parseInt(helper.DataItemRare4()	.split(" \n")[5]);	item_rare5_num =	Integer.parseInt(helper.DataItemRare5()	.split(" \n")[5]);	item_rare6_num =	Integer.parseInt(helper.DataItemRare6()	.split(" \n")[5]);	item_rare7_num =	Integer.parseInt(helper.DataItemRare7()	.split(" \n")[5]);	}
            if (item_id == 6){	item_rare1_num =	Integer.parseInt(helper.DataItemRare1()	.split(" \n")[6]);	item_rare2_num =	Integer.parseInt(helper.DataItemRare2()	.split(" \n")[6]);	item_rare3_num =	Integer.parseInt(helper.DataItemRare3()	.split(" \n")[6]);	item_rare4_num =	Integer.parseInt(helper.DataItemRare4()	.split(" \n")[6]);	item_rare5_num =	Integer.parseInt(helper.DataItemRare5()	.split(" \n")[6]);	item_rare6_num =	Integer.parseInt(helper.DataItemRare6()	.split(" \n")[6]);	item_rare7_num =	Integer.parseInt(helper.DataItemRare7()	.split(" \n")[6]);	}
            if (item_id == 7){	item_rare1_num =	Integer.parseInt(helper.DataItemRare1()	.split(" \n")[7]);	item_rare2_num =	Integer.parseInt(helper.DataItemRare2()	.split(" \n")[7]);	item_rare3_num =	Integer.parseInt(helper.DataItemRare3()	.split(" \n")[7]);	item_rare4_num =	Integer.parseInt(helper.DataItemRare4()	.split(" \n")[7]);	item_rare5_num =	Integer.parseInt(helper.DataItemRare5()	.split(" \n")[7]);	item_rare6_num =	Integer.parseInt(helper.DataItemRare6()	.split(" \n")[7]);	item_rare7_num =	Integer.parseInt(helper.DataItemRare7()	.split(" \n")[7]);	}
            if (item_id == 8){	item_rare1_num =	Integer.parseInt(helper.DataItemRare1()	.split(" \n")[8]);	item_rare2_num =	Integer.parseInt(helper.DataItemRare2()	.split(" \n")[8]);	item_rare3_num =	Integer.parseInt(helper.DataItemRare3()	.split(" \n")[8]);	item_rare4_num =	Integer.parseInt(helper.DataItemRare4()	.split(" \n")[8]);	item_rare5_num =	Integer.parseInt(helper.DataItemRare5()	.split(" \n")[8]);	item_rare6_num =	Integer.parseInt(helper.DataItemRare6()	.split(" \n")[8]);	item_rare7_num =	Integer.parseInt(helper.DataItemRare7()	.split(" \n")[8]);	}
            if (item_id == 9){	item_rare1_num =	Integer.parseInt(helper.DataItemRare1()	.split(" \n")[9]);	item_rare2_num =	Integer.parseInt(helper.DataItemRare2()	.split(" \n")[9]);	item_rare3_num =	Integer.parseInt(helper.DataItemRare3()	.split(" \n")[9]);	item_rare4_num =	Integer.parseInt(helper.DataItemRare4()	.split(" \n")[9]);	item_rare5_num =	Integer.parseInt(helper.DataItemRare5()	.split(" \n")[9]);	item_rare6_num =	Integer.parseInt(helper.DataItemRare6()	.split(" \n")[9]);	item_rare7_num =	Integer.parseInt(helper.DataItemRare7()	.split(" \n")[9]);	}
            if (item_id == 10){	item_rare1_num =	Integer.parseInt(helper.DataItemRare1()	.split(" \n")[10]);	item_rare2_num =	Integer.parseInt(helper.DataItemRare2()	.split(" \n")[10]);	item_rare3_num =	Integer.parseInt(helper.DataItemRare3()	.split(" \n")[10]);	item_rare4_num =	Integer.parseInt(helper.DataItemRare4()	.split(" \n")[10]);	item_rare5_num =	Integer.parseInt(helper.DataItemRare5()	.split(" \n")[10]);	item_rare6_num =	Integer.parseInt(helper.DataItemRare6()	.split(" \n")[10]);	item_rare7_num =	Integer.parseInt(helper.DataItemRare7()	.split(" \n")[10]);	}
            if (item_id == 11){	item_rare1_num =	Integer.parseInt(helper.DataItemRare1()	.split(" \n")[11]);	item_rare2_num =	Integer.parseInt(helper.DataItemRare2()	.split(" \n")[11]);	item_rare3_num =	Integer.parseInt(helper.DataItemRare3()	.split(" \n")[11]);	item_rare4_num =	Integer.parseInt(helper.DataItemRare4()	.split(" \n")[11]);	item_rare5_num =	Integer.parseInt(helper.DataItemRare5()	.split(" \n")[11]);	item_rare6_num =	Integer.parseInt(helper.DataItemRare6()	.split(" \n")[11]);	item_rare7_num =	Integer.parseInt(helper.DataItemRare7()	.split(" \n")[11]);	}

            if (item_rare == 0 ){	item_rare1_num = 	item_rare1_num 	 +1 ;}
            if (item_rare == 1 ){	item_rare2_num =	item_rare2_num	 +1 ;}
            if (item_rare == 2 ){	item_rare3_num =	item_rare3_num	 +1 ;}
            if (item_rare == 3 ){	item_rare4_num =	item_rare4_num	 +1 ;}
            if (item_rare == 4 ){	item_rare5_num =	item_rare5_num	 +1 ;}
            if (item_rare == 5 ){	item_rare6_num =	item_rare6_num	 +1 ;}
            if (item_rare == 6 ){	item_rare7_num =	item_rare7_num	 +1 ;}
        dataRefresh();
        tv();
        }
        public void dataRefresh (){
        helper = new LotteryDbAdapter(this);
        helper.getItem();
           String item_id2 = String.valueOf((item_id+1));
            String item_rare1_num_S = String.valueOf(item_rare1_num);
            String item_rare2_num_S = String.valueOf(item_rare2_num);
            String item_rare3_num_S = String.valueOf(item_rare3_num);
            String item_rare4_num_S = String.valueOf(item_rare4_num);
            String item_rare5_num_S = String.valueOf(item_rare5_num);
            String item_rare6_num_S = String.valueOf(item_rare6_num);
            String item_rare7_num_S = String.valueOf(item_rare7_num);
            ContentValues cv = new ContentValues();
            cv.put("id", item_id2); //These Fields should be your String values of actual column names
            cv.put("Rare1", item_rare1_num_S);
            cv.put("Rare2", item_rare2_num_S);
            cv.put("Rare3", item_rare3_num_S);
            cv.put("Rare4", item_rare4_num_S);
            cv.put("Rare5", item_rare5_num_S);
            cv.put("Rare6", item_rare6_num_S);
            cv.put("Rare7", item_rare7_num_S);
            String DataBasePath = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/lottery/lottery.db";
            SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(DataBasePath, null);
            db.update("EQUIPMENT", cv, "id="+item_id2, null);

        }
        public void tv (){
            item01_tr1.setText(helper.DataItemRare1().split(" \n")[0]);
            item02_tr1.setText(helper.DataItemRare1().split(" \n")[1]);
            item03_tr1.setText(helper.DataItemRare1().split(" \n")[2]);
            item04_tr1.setText(helper.DataItemRare1().split(" \n")[3]);
            item05_tr1.setText(helper.DataItemRare1().split(" \n")[4]);
            item06_tr1.setText(helper.DataItemRare1().split(" \n")[5]);
            item07_tr1.setText(helper.DataItemRare1().split(" \n")[6]);
            item08_tr1.setText(helper.DataItemRare1().split(" \n")[7]);
            item09_tr1.setText(helper.DataItemRare1().split(" \n")[8]);
            item10_tr1.setText(helper.DataItemRare1().split(" \n")[9]);
            item11_tr1.setText(helper.DataItemRare1().split(" \n")[10]);
            item12_tr1.setText(helper.DataItemRare1().split(" \n")[11]);
            item01_tr2.setText(helper.DataItemRare2().split(" \n")[0]);
            item02_tr2.setText(helper.DataItemRare2().split(" \n")[1]);
            item03_tr2.setText(helper.DataItemRare2().split(" \n")[2]);
            item04_tr2.setText(helper.DataItemRare2().split(" \n")[3]);
            item05_tr2.setText(helper.DataItemRare2().split(" \n")[4]);
            item06_tr2.setText(helper.DataItemRare2().split(" \n")[5]);
            item07_tr2.setText(helper.DataItemRare2().split(" \n")[6]);
            item08_tr2.setText(helper.DataItemRare2().split(" \n")[7]);
            item09_tr2.setText(helper.DataItemRare2().split(" \n")[8]);
            item10_tr2.setText(helper.DataItemRare2().split(" \n")[9]);
            item11_tr2.setText(helper.DataItemRare2().split(" \n")[10]);
            item12_tr2.setText(helper.DataItemRare2().split(" \n")[11]);
            item01_tr3.setText(helper.DataItemRare3().split(" \n")[0]);
            item02_tr3.setText(helper.DataItemRare3().split(" \n")[1]);
            item03_tr3.setText(helper.DataItemRare3().split(" \n")[2]);
            item04_tr3.setText(helper.DataItemRare3().split(" \n")[3]);
            item05_tr3.setText(helper.DataItemRare3().split(" \n")[4]);
            item06_tr3.setText(helper.DataItemRare3().split(" \n")[5]);
            item07_tr3.setText(helper.DataItemRare3().split(" \n")[6]);
            item08_tr3.setText(helper.DataItemRare3().split(" \n")[7]);
            item09_tr3.setText(helper.DataItemRare3().split(" \n")[8]);
            item10_tr3.setText(helper.DataItemRare3().split(" \n")[9]);
            item11_tr3.setText(helper.DataItemRare3().split(" \n")[10]);
            item12_tr3.setText(helper.DataItemRare3().split(" \n")[11]);
            item01_tr4.setText(helper.DataItemRare4().split(" \n")[0]);
            item02_tr4.setText(helper.DataItemRare4().split(" \n")[1]);
            item03_tr4.setText(helper.DataItemRare4().split(" \n")[2]);
            item04_tr4.setText(helper.DataItemRare4().split(" \n")[3]);
            item05_tr4.setText(helper.DataItemRare4().split(" \n")[4]);
            item06_tr4.setText(helper.DataItemRare4().split(" \n")[5]);
            item07_tr4.setText(helper.DataItemRare4().split(" \n")[6]);
            item08_tr4.setText(helper.DataItemRare4().split(" \n")[7]);
            item09_tr4.setText(helper.DataItemRare4().split(" \n")[8]);
            item10_tr4.setText(helper.DataItemRare4().split(" \n")[9]);
            item11_tr4.setText(helper.DataItemRare4().split(" \n")[10]);
            item12_tr4.setText(helper.DataItemRare4().split(" \n")[11]);
            item01_tr5.setText(helper.DataItemRare5().split(" \n")[0]);
            item02_tr5.setText(helper.DataItemRare5().split(" \n")[1]);
            item03_tr5.setText(helper.DataItemRare5().split(" \n")[2]);
            item04_tr5.setText(helper.DataItemRare5().split(" \n")[3]);
            item05_tr5.setText(helper.DataItemRare5().split(" \n")[4]);
            item06_tr5.setText(helper.DataItemRare5().split(" \n")[5]);
            item07_tr5.setText(helper.DataItemRare5().split(" \n")[6]);
            item08_tr5.setText(helper.DataItemRare5().split(" \n")[7]);
            item09_tr5.setText(helper.DataItemRare5().split(" \n")[8]);
            item10_tr5.setText(helper.DataItemRare5().split(" \n")[9]);
            item11_tr5.setText(helper.DataItemRare5().split(" \n")[10]);
            item12_tr5.setText(helper.DataItemRare5().split(" \n")[11]);
            item01_tr6.setText(helper.DataItemRare6().split(" \n")[0]);
            item02_tr6.setText(helper.DataItemRare6().split(" \n")[1]);
            item03_tr6.setText(helper.DataItemRare6().split(" \n")[2]);
            item04_tr6.setText(helper.DataItemRare6().split(" \n")[3]);
            item05_tr6.setText(helper.DataItemRare6().split(" \n")[4]);
            item06_tr6.setText(helper.DataItemRare6().split(" \n")[5]);
            item07_tr6.setText(helper.DataItemRare6().split(" \n")[6]);
            item08_tr6.setText(helper.DataItemRare6().split(" \n")[7]);
            item09_tr6.setText(helper.DataItemRare6().split(" \n")[8]);
            item10_tr6.setText(helper.DataItemRare6().split(" \n")[9]);
            item11_tr6.setText(helper.DataItemRare6().split(" \n")[10]);
            item12_tr6.setText(helper.DataItemRare6().split(" \n")[11]);
            item01_tr7.setText(helper.DataItemRare7().split(" \n")[0]);
            item02_tr7.setText(helper.DataItemRare7().split(" \n")[1]);
            item03_tr7.setText(helper.DataItemRare7().split(" \n")[2]);
            item04_tr7.setText(helper.DataItemRare7().split(" \n")[3]);
            item05_tr7.setText(helper.DataItemRare7().split(" \n")[4]);
            item06_tr7.setText(helper.DataItemRare7().split(" \n")[5]);
            item07_tr7.setText(helper.DataItemRare7().split(" \n")[6]);
            item08_tr7.setText(helper.DataItemRare7().split(" \n")[7]);
            item09_tr7.setText(helper.DataItemRare7().split(" \n")[8]);
            item10_tr7.setText(helper.DataItemRare7().split(" \n")[9]);
            item11_tr7.setText(helper.DataItemRare7().split(" \n")[10]);
            item12_tr7.setText(helper.DataItemRare7().split(" \n")[11]);
        }
        public void invisible (View view) {
            ScrollView ll4 = findViewById(R.id.sc);
            if (visible == true) {
                ll4.setVisibility(View.GONE);
            visible = false ;
        }
        else {
                ll4.setVisibility(View.VISIBLE);
            visible = true ;}
        }
}