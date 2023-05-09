package voc.net.tools.zgirls_tool.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.R;
import voc.net.tools.zgirls_tool.util.Building;
import voc.net.tools.zgirls_tool.util.BuildingAdapter;

public class BatteryActivity extends AppCompatActivity {
    /**
     * @Param bt : 一般兵種蓄電池
     * @Param bt2 : 源計劃蓄電池
     */
    TextView bt , bt2 , now_seek_tv , aim_seek_tv ;
    int now = 0 , aim = 0 ;
    SeekBar now_seek , aim_seek ;
    long cost = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);
        bt = findViewById(R.id.battery_bt);
        bt2 = findViewById(R.id.battery_bt2);
        now_seek = findViewById(R.id.now_seek);
        aim_seek = findViewById(R.id.aim_seek);
        now_seek_tv = findViewById(R.id.now_seek_tv);
        aim_seek_tv = findViewById(R.id.aim_seek_tv);
        now_seek.setMax(80);
        aim_seek.setMax(80);
        BackgroundReload();
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
                now_seek_tv.setText(String.valueOf(now));
                aim_seek_tv.setText(String.valueOf(aim));
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
                now_seek_tv.setText(String.valueOf(now));
                aim_seek_tv.setText(String.valueOf(aim));
                calculate();
            }
        });
    }

    private void calculate() {
        cost = 0 ;
        if (now <= 0	&& aim >= 1){	cost = cost + 	44	;}
        if (now <= 1	&& aim >= 2){	cost = cost + 	56	;}
        if (now <= 2	&& aim >= 3){	cost = cost + 	80	;}
        if (now <= 3	&& aim >= 4){	cost = cost + 	112	;}
        if (now <= 4	&& aim >= 5){	cost = cost + 	156	;}
        if (now <= 5	&& aim >= 6){	cost = cost + 	200	;}
        if (now <= 6	&& aim >= 7){	cost = cost + 	264	;}
        if (now <= 7	&& aim >= 8){	cost = cost + 	332	;}
        if (now <= 8	&& aim >= 9){	cost = cost + 	408	;}
        if (now <= 9	&& aim >= 10){	cost = cost + 	492	;}
        if (now <= 10	&& aim >= 11){	cost = cost + 	592	;}
        if (now <= 11	&& aim >= 12){	cost = cost + 	696	;}
        if (now <= 12	&& aim >= 13){	cost = cost + 	808	;}
        if (now <= 13	&& aim >= 14){	cost = cost + 	928	;}
        if (now <= 14	&& aim >= 15){	cost = cost + 	1064	;}
        if (now <= 15	&& aim >= 16){	cost = cost + 	1204	;}
        if (now <= 16	&& aim >= 17){	cost = cost + 	1356	;}
        if (now <= 17	&& aim >= 18){	cost = cost + 	1512	;}
        if (now <= 18	&& aim >= 19){	cost = cost + 	1684	;}
        if (now <= 19	&& aim >= 20){	cost = cost + 	1860	;}
        if (now <= 20	&& aim >= 21){	cost = cost + 	2048	;}
        if (now <= 21	&& aim >= 22){	cost = cost + 	2240	;}
        if (now <= 22	&& aim >= 23){	cost = cost + 	2448	;}
        if (now <= 23	&& aim >= 24){	cost = cost + 	2660	;}
        if (now <= 24	&& aim >= 25){	cost = cost + 	2884	;}
        if (now <= 25	&& aim >= 26){	cost = cost + 	3112	;}
        if (now <= 26	&& aim >= 27){	cost = cost + 	3356	;}
        if (now <= 27	&& aim >= 28){	cost = cost + 	3608	;}
        if (now <= 28	&& aim >= 29){	cost = cost + 	3868	;}
        if (now <= 29	&& aim >= 30){	cost = cost + 	4132	;}
        if (now <= 30	&& aim >= 31){	cost = cost + 	4412	;}
        if (now <= 31	&& aim >= 32){	cost = cost + 	4700	;}
        if (now <= 32	&& aim >= 33){	cost = cost + 	4996	;}
        if (now <= 33	&& aim >= 34){	cost = cost + 	5296	;}
        if (now <= 34	&& aim >= 35){	cost = cost + 	5616	;}
        if (now <= 35	&& aim >= 36){	cost = cost + 	5936	;}
        if (now <= 36	&& aim >= 37){	cost = cost + 	6268	;}
        if (now <= 37	&& aim >= 38){	cost = cost + 	6608	;}
        if (now <= 38	&& aim >= 39){	cost = cost + 	6960	;}
        if (now <= 39	&& aim >= 40){	cost = cost + 	7320	;}
        if (now <= 40	&& aim >= 41){	cost = cost + 	7688	;}
        if (now <= 41	&& aim >= 42){	cost = cost + 	8064	;}
        if (now <= 42	&& aim >= 43){	cost = cost + 	8452	;}
        if (now <= 43	&& aim >= 44){	cost = cost + 	8848	;}
        if (now <= 44	&& aim >= 45){	cost = cost + 	9256	;}
        if (now <= 45	&& aim >= 46){	cost = cost + 	9664	;}
        if (now <= 46	&& aim >= 47){	cost = cost + 	10092	;}
        if (now <= 47	&& aim >= 48){	cost = cost + 	10524	;}
        if (now <= 48	&& aim >= 49){	cost = cost + 	10964	;}
        if (now <= 49	&& aim >= 50){	cost = cost + 	11412	;}
        if (now <= 50	&& aim >= 51){	cost = cost + 	11876	;}
        if (now <= 51	&& aim >= 52){	cost = cost + 	14084	;}
        if (now <= 52	&& aim >= 53){	cost = cost + 	15384	;}
        if (now <= 53	&& aim >= 54){	cost = cost + 	16440	;}
        if (now <= 54	&& aim >= 55){	cost = cost + 	17812	;}
        if (now <= 55	&& aim >= 56){	cost = cost + 	18940	;}
        if (now <= 56	&& aim >= 57){	cost = cost + 	20104	;}
        if (now <= 57	&& aim >= 58){	cost = cost + 	21304	;}
        if (now <= 58	&& aim >= 59){	cost = cost + 	22544	;}
        if (now <= 59	&& aim >= 60){	cost = cost + 	23816	;}
        if (now <= 60	&& aim >= 61){	cost = cost + 	31152	;}
        if (now <= 61	&& aim >= 62){	cost = cost + 	37796	;}
        if (now <= 62	&& aim >= 63){	cost = cost + 	45504	;}
        if (now <= 63	&& aim >= 64){	cost = cost + 	54524	;}
        if (now <= 64	&& aim >= 65){	cost = cost + 	65168	;}
        if (now <= 65	&& aim >= 66){	cost = cost + 	77836	;}
        if (now <= 66	&& aim >= 67){	cost = cost + 	93032	;}
        if (now <= 67	&& aim >= 68){	cost = cost + 	111424	;}
        if (now <= 68	&& aim >= 69){	cost = cost + 	135148	;}
        if (now <= 69	&& aim >= 70){	cost = cost + 	166228	;}
        if (now <= 70	&& aim >= 71){	cost = cost + 	172832	;}
        if (now <= 71	&& aim >= 72){	cost = cost + 	171104	;}
        if (now <= 72	&& aim >= 73){	cost = cost + 	171104	;}
        if (now <= 73	&& aim >= 74){	cost = cost + 	171104	;}
        if (now <= 74	&& aim >= 75){	cost = cost + 	171104	;}
        if (now <= 75	&& aim >= 76){	cost = cost + 	171104	;}
        if (now <= 76	&& aim >= 77){	cost = cost + 	171104	;}
        if (now <= 77	&& aim >= 78){	cost = cost + 	171104	;}
        if (now <= 78	&& aim >= 79){	cost = cost + 	171104	;}
        if (now <= 79	&& aim >= 80){	cost = cost + 	171104	;}

        bt.setText(prettyCount(cost));
        bt2.setText(prettyCount(cost));

    }
    public void BackgroundReload (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.battery_bg);

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
}