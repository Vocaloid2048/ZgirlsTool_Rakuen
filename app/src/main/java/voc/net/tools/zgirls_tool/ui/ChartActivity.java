package voc.net.tools.zgirls_tool.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.SeekBar;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.R;

public class ChartActivity extends AppCompatActivity implements OnChartValueSelectedListener {

    long proj_1_all;	long proj_2_all;	long proj_3_all;	long proj_4_all;	long proj_5_all;	long proj_6_all;	long proj_7_all;	long proj_8_all;	long proj_9_all;	long proj_10_all;
    long arm_1_all;		long arm_2_all;		long arm_3_all;		long arm_4_all;		long arm_5_all;		long arm_6_all;		long arm_7_all;		long arm_8_all;		long arm_9_all;		long arm_10_all;
    long mili_1_all;	long mili_2_all;	long mili_3_all;	long mili_4_all;	long mili_5_all;	long mili_6_all;	long mili_7_all;	long mili_8_all;	long mili_9_all;	long mili_10_all;
    long mobile_1_all;	long mobile_2_all;	long mobile_3_all;	long mobile_4_all;	long mobile_5_all;	long mobile_6_all;	long mobile_7_all;	long mobile_8_all;	long mobile_9_all;	long mobile_10_all;
    long infect_1_all;	long infect_2_all;	long infect_3_all;	long infect_4_all;	long infect_5_all;	long infect_6_all;	long infect_7_all;	long infect_8_all;	long infect_9_all;	long infect_10_all;

    long proj_1_march;	long proj_2_march;	long proj_3_march;	long proj_4_march;	long proj_5_march;	long proj_6_march;	long proj_7_march;	long proj_8_march;	long proj_9_march;	long proj_10_march;
    long arm_1_march;		long arm_2_march;		long arm_3_march;		long arm_4_march;		long arm_5_march;		long arm_6_march;		long arm_7_march;		long arm_8_march;		long arm_9_march;		long arm_10_march;
    long mili_1_march;	long mili_2_march;	long mili_3_march;	long mili_4_march;	long mili_5_march;	long mili_6_march;	long mili_7_march;	long mili_8_march;	long mili_9_march;	long mili_10_march;
    long mobile_1_march;	long mobile_2_march;	long mobile_3_march;	long mobile_4_march;	long mobile_5_march;	long mobile_6_march;	long mobile_7_march;	long mobile_8_march;	long mobile_9_march;	long mobile_10_march;
    long infect_1_march;	long infect_2_march;	long infect_3_march;	long infect_4_march;	long infect_5_march;	long infect_6_march;	long infect_7_march;	long infect_8_march;	long infect_9_march;	long infect_10_march;

    long proj_1_free;	long proj_2_free;	long proj_3_free;	long proj_4_free;	long proj_5_free;	long proj_6_free;	long proj_7_free;	long proj_8_free;	long proj_9_free;	long proj_10_free;
    long arm_1_free;		long arm_2_free;		long arm_3_free;		long arm_4_free;		long arm_5_free;		long arm_6_free;		long arm_7_free;		long arm_8_free;		long arm_9_free;		long arm_10_free;
    long mili_1_free;	long mili_2_free;	long mili_3_free;	long mili_4_free;	long mili_5_free;	long mili_6_free;	long mili_7_free;	long mili_8_free;	long mili_9_free;	long mili_10_free;
    long mobile_1_free;	long mobile_2_free;	long mobile_3_free;	long mobile_4_free;	long mobile_5_free;	long mobile_6_free;	long mobile_7_free;	long mobile_8_free;	long mobile_9_free;	long mobile_10_free;
    long infect_1_free;	long infect_2_free;	long infect_3_free;	long infect_4_free;	long infect_5_free;	long infect_6_free;	long infect_7_free;	long infect_8_free;	long infect_9_free;	long infect_10_free;

    PieChart TroopPie ;
    private View decorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        TroopPie = findViewById(R.id.troop_sum_pie);
        data();
        BackgroundReload();
        TroopSUMPie();
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener(){
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if (visibility == 0)
                    decorView.setSystemUiVisibility(hideSystemBars());

            }
        });
    }
    public void BackgroundReload (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.data_bg3);

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

    @Override
    public void onWindowFocusChanged(boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }
    private int hideSystemBars(){
        return //View.SYSTEM_UI_FLAG_LAYOUT_STABLE|
                //    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|
                        // View.SYSTEM_UI_FLAG_FULLSCREEN|
                        View.SYSTEM_UI_FLAG_FULLSCREEN;
    }

    private void data() {

        SharedPreferences sharedPreferences = getSharedPreferences("json_data", Context.MODE_PRIVATE);
        mili_1_all = sharedPreferences.getLong("army01TotalNum",0);
        mili_2_all = sharedPreferences.getLong("army02TotalNum",0);
        mili_3_all = sharedPreferences.getLong("army03TotalNum",0);
        mili_4_all = sharedPreferences.getLong("army04TotalNum",0);
        mili_5_all = sharedPreferences.getLong("army05TotalNum",0);
        mili_6_all = sharedPreferences.getLong("army06TotalNum",0);
        mili_7_all = sharedPreferences.getLong("army07TotalNum",0);
        mili_8_all = sharedPreferences.getLong("army08TotalNum",0);
        mili_9_all = sharedPreferences.getLong("army09TotalNum",0);
        mili_10_all = sharedPreferences.getLong("army10TotalNum",0);
        mobile_1_all = sharedPreferences.getLong("army11TotalNum",0);
        mobile_2_all = sharedPreferences.getLong("army12TotalNum",0);
        mobile_3_all = sharedPreferences.getLong("army13TotalNum",0);
        mobile_4_all = sharedPreferences.getLong("army14TotalNum",0);
        mobile_5_all = sharedPreferences.getLong("army15TotalNum",0);
        mobile_6_all = sharedPreferences.getLong("army16TotalNum",0);
        mobile_7_all = sharedPreferences.getLong("army17TotalNum",0);
        mobile_8_all = sharedPreferences.getLong("army18TotalNum",0);
        mobile_9_all = sharedPreferences.getLong("army19TotalNum",0);
        mobile_10_all = sharedPreferences.getLong("army20TotalNum",0);
        arm_1_all = sharedPreferences.getLong("army21TotalNum",0);
        arm_2_all = sharedPreferences.getLong("army22TotalNum",0);
        arm_3_all = sharedPreferences.getLong("army23TotalNum",0);
        arm_4_all = sharedPreferences.getLong("army24TotalNum",0);
        arm_5_all = sharedPreferences.getLong("army25TotalNum",0);
        arm_6_all = sharedPreferences.getLong("army26TotalNum",0);
        arm_7_all = sharedPreferences.getLong("army27TotalNum",0);
        arm_8_all = sharedPreferences.getLong("army28TotalNum",0);
        arm_9_all = sharedPreferences.getLong("army29TotalNum",0);
        arm_10_all = sharedPreferences.getLong("army30TotalNum",0);
        infect_1_all = sharedPreferences.getLong("army31TotalNum",0);
        infect_2_all = sharedPreferences.getLong("army32TotalNum",0);
        infect_3_all = sharedPreferences.getLong("army33TotalNum",0);
        infect_4_all = sharedPreferences.getLong("army34TotalNum",0);
        infect_5_all = sharedPreferences.getLong("army35TotalNum",0);
        infect_6_all = sharedPreferences.getLong("army36TotalNum",0);
        infect_7_all = sharedPreferences.getLong("army37TotalNum",0);
        infect_8_all = sharedPreferences.getLong("army38TotalNum",0);
        infect_9_all = sharedPreferences.getLong("army39TotalNum",0);
        infect_10_all = sharedPreferences.getLong("army40TotalNum",0);
        proj_1_all = sharedPreferences.getLong("army41TotalNum",0);
        proj_2_all = sharedPreferences.getLong("army42TotalNum",0);
        proj_3_all = sharedPreferences.getLong("army43TotalNum",0);
        proj_4_all = sharedPreferences.getLong("army44TotalNum",0);
        proj_5_all = sharedPreferences.getLong("army45TotalNum",0);
        proj_6_all = sharedPreferences.getLong("army46TotalNum",0);
        proj_7_all = sharedPreferences.getLong("army47TotalNum",0);
        proj_8_all = sharedPreferences.getLong("army48TotalNum",0);
        proj_9_all = sharedPreferences.getLong("army49TotalNum",0);
        proj_10_all = sharedPreferences.getLong("army50TotalNum",0);

        mili_1_march = sharedPreferences.getLong("army01MarchNum",0);
        mili_2_march = sharedPreferences.getLong("army02MarchNum",0);
        mili_3_march = sharedPreferences.getLong("army03MarchNum",0);
        mili_4_march = sharedPreferences.getLong("army04MarchNum",0);
        mili_5_march = sharedPreferences.getLong("army05MarchNum",0);
        mili_6_march = sharedPreferences.getLong("army06MarchNum",0);
        mili_7_march = sharedPreferences.getLong("army07MarchNum",0);
        mili_8_march = sharedPreferences.getLong("army08MarchNum",0);
        mili_9_march = sharedPreferences.getLong("army09MarchNum",0);
        mili_10_march = sharedPreferences.getLong("army10MarchNum",0);
        mobile_1_march = sharedPreferences.getLong("army11MarchNum",0);
        mobile_2_march = sharedPreferences.getLong("army12MarchNum",0);
        mobile_3_march = sharedPreferences.getLong("army13MarchNum",0);
        mobile_4_march = sharedPreferences.getLong("army14MarchNum",0);
        mobile_5_march = sharedPreferences.getLong("army15MarchNum",0);
        mobile_6_march = sharedPreferences.getLong("army16MarchNum",0);
        mobile_7_march = sharedPreferences.getLong("army17MarchNum",0);
        mobile_8_march = sharedPreferences.getLong("army18MarchNum",0);
        mobile_9_march = sharedPreferences.getLong("army19MarchNum",0);
        mobile_10_march = sharedPreferences.getLong("army20MarchNum",0);
        arm_1_march = sharedPreferences.getLong("army21MarchNum",0);
        arm_2_march = sharedPreferences.getLong("army22MarchNum",0);
        arm_3_march = sharedPreferences.getLong("army23MarchNum",0);
        arm_4_march = sharedPreferences.getLong("army24MarchNum",0);
        arm_5_march = sharedPreferences.getLong("army25MarchNum",0);
        arm_6_march = sharedPreferences.getLong("army26MarchNum",0);
        arm_7_march = sharedPreferences.getLong("army27MarchNum",0);
        arm_8_march = sharedPreferences.getLong("army28MarchNum",0);
        arm_9_march = sharedPreferences.getLong("army29MarchNum",0);
        arm_10_march = sharedPreferences.getLong("army30MarchNum",0);
        infect_1_march = sharedPreferences.getLong("army31MarchNum",0);
        infect_2_march = sharedPreferences.getLong("army32MarchNum",0);
        infect_3_march = sharedPreferences.getLong("army33MarchNum",0);
        infect_4_march = sharedPreferences.getLong("army34MarchNum",0);
        infect_5_march = sharedPreferences.getLong("army35MarchNum",0);
        infect_6_march = sharedPreferences.getLong("army36MarchNum",0);
        infect_7_march = sharedPreferences.getLong("army37MarchNum",0);
        infect_8_march = sharedPreferences.getLong("army38MarchNum",0);
        infect_9_march = sharedPreferences.getLong("army39MarchNum",0);
        infect_10_march = sharedPreferences.getLong("army40MarchNum",0);
        proj_1_march = sharedPreferences.getLong("army41MarchNum",0);
        proj_2_march = sharedPreferences.getLong("army42MarchNum",0);
        proj_3_march = sharedPreferences.getLong("army43MarchNum",0);
        proj_4_march = sharedPreferences.getLong("army44MarchNum",0);
        proj_5_march = sharedPreferences.getLong("army45MarchNum",0);
        proj_6_march = sharedPreferences.getLong("army46MarchNum",0);
        proj_7_march = sharedPreferences.getLong("army47MarchNum",0);
        proj_8_march = sharedPreferences.getLong("army48MarchNum",0);
        proj_9_march = sharedPreferences.getLong("army49MarchNum",0);
        proj_10_march = sharedPreferences.getLong("army50MarchNum",0);

        mili_1_free = sharedPreferences.getLong("army01FreeNum",0);
        mili_2_free = sharedPreferences.getLong("army02FreeNum",0);
        mili_3_free = sharedPreferences.getLong("army03FreeNum",0);
        mili_4_free = sharedPreferences.getLong("army04FreeNum",0);
        mili_5_free = sharedPreferences.getLong("army05FreeNum",0);
        mili_6_free = sharedPreferences.getLong("army06FreeNum",0);
        mili_7_free = sharedPreferences.getLong("army07FreeNum",0);
        mili_8_free = sharedPreferences.getLong("army08FreeNum",0);
        mili_9_free = sharedPreferences.getLong("army09FreeNum",0);
        mili_10_free = sharedPreferences.getLong("army10FreeNum",0);
        mobile_1_free = sharedPreferences.getLong("army11FreeNum",0);
        mobile_2_free = sharedPreferences.getLong("army12FreeNum",0);
        mobile_3_free = sharedPreferences.getLong("army13FreeNum",0);
        mobile_4_free = sharedPreferences.getLong("army14FreeNum",0);
        mobile_5_free = sharedPreferences.getLong("army15FreeNum",0);
        mobile_6_free = sharedPreferences.getLong("army16FreeNum",0);
        mobile_7_free = sharedPreferences.getLong("army17FreeNum",0);
        mobile_8_free = sharedPreferences.getLong("army18FreeNum",0);
        mobile_9_free = sharedPreferences.getLong("army19FreeNum",0);
        mobile_10_free = sharedPreferences.getLong("army20FreeNum",0);
        arm_1_free = sharedPreferences.getLong("army21FreeNum",0);
        arm_2_free = sharedPreferences.getLong("army22FreeNum",0);
        arm_3_free = sharedPreferences.getLong("army23FreeNum",0);
        arm_4_free = sharedPreferences.getLong("army24FreeNum",0);
        arm_5_free = sharedPreferences.getLong("army25FreeNum",0);
        arm_6_free = sharedPreferences.getLong("army26FreeNum",0);
        arm_7_free = sharedPreferences.getLong("army27FreeNum",0);
        arm_8_free = sharedPreferences.getLong("army28FreeNum",0);
        arm_9_free = sharedPreferences.getLong("army29FreeNum",0);
        arm_10_free = sharedPreferences.getLong("army30FreeNum",0);
        infect_1_free = sharedPreferences.getLong("army31FreeNum",0);
        infect_2_free = sharedPreferences.getLong("army32FreeNum",0);
        infect_3_free = sharedPreferences.getLong("army33FreeNum",0);
        infect_4_free = sharedPreferences.getLong("army34FreeNum",0);
        infect_5_free = sharedPreferences.getLong("army35FreeNum",0);
        infect_6_free = sharedPreferences.getLong("army36FreeNum",0);
        infect_7_free = sharedPreferences.getLong("army37FreeNum",0);
        infect_8_free = sharedPreferences.getLong("army38FreeNum",0);
        infect_9_free = sharedPreferences.getLong("army39FreeNum",0);
        infect_10_free = sharedPreferences.getLong("army40FreeNum",0);
        proj_1_free = sharedPreferences.getLong("army41FreeNum",0);
        proj_2_free = sharedPreferences.getLong("army42FreeNum",0);
        proj_3_free = sharedPreferences.getLong("army43FreeNum",0);
        proj_4_free = sharedPreferences.getLong("army44FreeNum",0);
        proj_5_free = sharedPreferences.getLong("army45FreeNum",0);
        proj_6_free = sharedPreferences.getLong("army46FreeNum",0);
        proj_7_free = sharedPreferences.getLong("army47FreeNum",0);
        proj_8_free = sharedPreferences.getLong("army48FreeNum",0);
        proj_9_free = sharedPreferences.getLong("army49FreeNum",0);
        proj_10_free = sharedPreferences.getLong("army50FreeNum",0);
    }
    @SuppressLint("ResourceType")
    public void TroopSUMPie(){
        long arm = arm_1_all +	arm_2_all +	arm_3_all +	arm_4_all +	arm_5_all +	arm_6_all +	arm_7_all +	arm_8_all +	arm_9_all +	arm_10_all ;
        long mili = mili_1_all +	mili_2_all +	mili_3_all +	mili_4_all +	mili_5_all +	mili_6_all +	mili_7_all +	mili_8_all +	mili_9_all +	mili_10_all ;
        long mobile = mobile_1_all +	mobile_2_all +	mobile_3_all +	mobile_4_all +	mobile_5_all +	mobile_6_all +	mobile_7_all +	mobile_8_all +	mobile_9_all +	mobile_10_all ;
        long infect = infect_1_all +	infect_2_all +	infect_3_all +	infect_4_all +	infect_5_all +	infect_6_all +	infect_7_all +	infect_8_all +	infect_9_all +	infect_10_all ;
        long proj = proj_1_all +	proj_2_all +	proj_3_all +	proj_4_all +	proj_5_all +	proj_6_all +	proj_7_all +	proj_8_all +	proj_9_all +	proj_10_all ;
        long all = arm + mili + mobile + infect + proj;
        //TroopPie.setCenterTextTypeface(Typeface.createFromAsset(getAssets(), "OpenSans-Light.ttf"));
        TroopPie.setCenterText(getString(R.string.troop_sum_chart_title));

        TroopPie.setExtraOffsets(20.f, 0.f, 20.f, 0.f);

        TroopPie.setDrawHoleEnabled(true);
        TroopPie.setHoleColor(0x33000000);

        TroopPie.setTransparentCircleColor(Color.WHITE);
        TroopPie.setTransparentCircleAlpha(110);

        TroopPie.setHoleRadius(58f);
        TroopPie.setTransparentCircleRadius(61f);

        TroopPie.setDrawCenterText(true);

        TroopPie.setRotationAngle(0);
        // enable rotation of the TroopPie by touch
        TroopPie.setRotationEnabled(true);
        TroopPie.setHighlightPerTapEnabled(true);
        TroopPie.setDescription(" ");

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        ArrayList<PieEntry> pieEntries = new ArrayList<PieEntry>();
        pieEntries.add(new PieEntry(arm, getString(R.string.armed)));
        pieEntries.add(new PieEntry(mili, getString(R.string.mili)));
        pieEntries.add(new PieEntry(mobile, getString(R.string.mobile)));
        pieEntries.add(new PieEntry(infect, getString(R.string.infecion)));
        pieEntries.add(new PieEntry(proj, getString(R.string.project)));

        //String centerText = "时间分配";
        //pieChart1.setCenterText(centerText);//设置圆环中间的文字
        PieDataSet pieDataSet = new PieDataSet(pieEntries, "");
        ArrayList<Integer> colors = new ArrayList<>();

// 饼图颜色\

        colors.add(Color.rgb(186, 95, 95));
        colors.add(Color.rgb(78, 97, 187));
        colors.add(Color.rgb(97, 171, 138));
        colors.add(Color.rgb(123, 90, 173));
        colors.add(Color.rgb(174, 91, 135));

        pieDataSet.setColors(colors);
        //dataSet.setSelectionShift(0f);


        pieDataSet.setValueLinePart1OffsetPercentage(80.f);
        pieDataSet.setValueLinePart1Length(0.2f);
        pieDataSet.setValueLinePart2Length(0.4f);

        //dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        pieDataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        PieData data = new PieData(pieDataSet);
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.BLACK);
        data.setDataSet(pieDataSet);

//各个饼状图所占比例数字的设置
        TroopPie.setData(data);
        TroopPie.highlightValues(null);
        TroopPie.invalidate();

        // TroopPie.setUnit(" €");
        // TroopPie.setDrawUnitsInChart(true);

        // add a selection listener
        TroopPie.setOnChartValueSelectedListener(this);
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
}