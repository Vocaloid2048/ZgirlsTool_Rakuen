package voc.net.tools.zgirls_tool.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.egg.Christmas2020;
import voc.net.tools.zgirls_tool.util.ColorPicker;
import voc.net.tools.zgirls_tool.util.DragListView;
import voc.net.tools.zgirls_tool.R;
import voc.net.tools.zgirls_tool.util.TestGridViewAdapter;

public class SettingActivity extends AppCompatActivity {

    RadioButton base, dark, pink, leek, summer, custom;

    CheckBox cb1, cb2, cb3, cb4, cb5, cb8, cb9, cb10, cb11,cb12,cb13,cb14,cb15,cb16,cb17,cb18,cb19;
    RadioButton cb6, cb7;

    TextView color1_et, color2_et ;
    EditText decimal_et;

    ImageView Choose_img;
    TextView Hex;
    View Color_result;
    String color1, color2;
    Bitmap bitmap;

    LinearLayout decimal_ll;

    Context SettingActivity;

    CardView version_card, theme_card, troop_card, data_card, more_cal_card;
    TextView version_tv, theme_tv, troop_tv, data_tv, more_cal_tv;

    private static final int SECOND_REQUEST_CODE = 1;
    private static final int FIRST_REQUEST_CODE = 0;


    private DragListView dragGridView;

    private TestGridViewAdapter adapter;

    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        version_card = findViewById(R.id.version_card);
        version_tv = findViewById(R.id.version_tv);
        theme_card = findViewById(R.id.theme_card);
        theme_tv = findViewById(R.id.theme_tv);
        troop_card = findViewById(R.id.troop_card);
        troop_tv = findViewById(R.id.troop_tv);
        data_card = findViewById(R.id.data_card);
        data_tv = findViewById(R.id.data_tv);
        more_cal_card = findViewById(R.id.more_cal_card);
        more_cal_tv = findViewById(R.id.more_cal_tv);

        base = findViewById(R.id.radioButton5);
        dark = findViewById(R.id.radioButton4);
        pink = findViewById(R.id.radioButton3);
        leek = findViewById(R.id.radioButton2);
        summer = findViewById(R.id.radioButton);
        custom = findViewById(R.id.radioCustom);

        cb1 = findViewById(R.id.cb_1);
        cb2 = findViewById(R.id.cb_2);
        cb3 = findViewById(R.id.cb_3);
        cb4 = findViewById(R.id.cb_4);
        cb5 = findViewById(R.id.cb_5);

        cb6 = findViewById(R.id.cb_6);
        cb7 = findViewById(R.id.cb_7);

        cb8 = findViewById(R.id.cb_8);
        cb9 = findViewById(R.id.cb_9);
        cb10 = findViewById(R.id.cb_10);
        cb11 = findViewById(R.id.cb_11);
        cb12 = findViewById(R.id.cb_12);
        cb13 = findViewById(R.id.cb_13);
        cb14 = findViewById(R.id.cb_14);
        cb15 = findViewById(R.id.cb_15);
        cb16 = findViewById(R.id.cb_16);
        cb17 = findViewById(R.id.cb_17);
        cb18 = findViewById(R.id.cb_18);
        cb19 = findViewById(R.id.cb_19);

        color1_et = findViewById(R.id.color1_et);
        color2_et = findViewById(R.id.color2_et);
        decimal_et = findViewById(R.id.decimal_et);
        decimal_ll = findViewById(R.id.decimal);

        cbg();

       // Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
      //  Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
      //  Spinner spinner3 = (Spinner)findViewById(R.id.spinner3);
      //  Spinner spinner4 = (Spinner)findViewById(R.id.spinner4);
      //  String[] lunch = {getString(R.string.tb_rss), getString(R.string.tb_mechas), getString(R.string.tb_troops), getString(R.string.tb_enabler)};
      //  ArrayAdapter<String> lunchList = new ArrayAdapter<>(SettingActivity.this,R.layout.spinner, lunch);
      //  spinner1.setAdapter(lunchList);
      //  spinner2.setAdapter(lunchList);
      //  spinner3.setAdapter(lunchList);
      //  spinner4.setAdapter(lunchList);

       // spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
       //     @Override
       //     public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       //         lunch[0].
        //    }
        //    @Override
        //    public void onNothingSelected(AdapterView<?> parent) {}
        //});

        BackgroundReload();


//获取SharedPreference实例
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        //取出数据（注意这里直接用实例取就行了，不用获取编辑器editor）
        String theme = sharedPreferences.getString("theme", "dark");
        String color1 = sharedPreferences.getString("color1", "FFFFFF");
        String color2 = sharedPreferences.getString("color2", "FFFFFF");
        Boolean auto_show = sharedPreferences.getBoolean("auto_show", true);
        Boolean download_beta = sharedPreferences.getBoolean("download_beta", false);
        String troop_tv_size = sharedPreferences.getString("troop_tv_size", "small");
        Boolean troop_show_0 = sharedPreferences.getBoolean("troop_show_0", true);
        Boolean input_json_list = sharedPreferences.getBoolean("input_json_list", true);
        Boolean input_json_cal = sharedPreferences.getBoolean("input_json_cal", true);
        int decimal_num = sharedPreferences.getInt("decimal_num", 0);
        boolean decimal = sharedPreferences.getBoolean("decimal", false);
        boolean ANI_SHOW = sharedPreferences.getBoolean("ANI_SHOW", false);
        boolean transform_show = sharedPreferences.getBoolean("transform_show", true);

        boolean rss_card_show = sharedPreferences.getBoolean("rss_card_show", true);
        boolean mecha_card_show = sharedPreferences.getBoolean("mecha_card_show", true);
        boolean troop_card_show = sharedPreferences.getBoolean("troop_card_show", true);
        boolean enabler_card_show = sharedPreferences.getBoolean("enabler_card_show", true);
        boolean progress_card_show = sharedPreferences.getBoolean("progress_card_show", false);
        boolean star_card_show = sharedPreferences.getBoolean("star_card_show", false);
        boolean exp_card_show = sharedPreferences.getBoolean("exp_card_show", false);
        boolean land_card_show = sharedPreferences.getBoolean("land_card_show", false);

        boolean always_show_post = sharedPreferences.getBoolean("always_show_post", true);

        if (theme.equals("base")) {
            base.setChecked(true);
        }
        if (theme.equals("dark")) {
            dark.setChecked(true);
        }
        if (theme.equals("pink")) {
            pink.setChecked(true);
        }
        if (theme.equals("leek")) {
            leek.setChecked(true);
        }
        if (theme.equals("summer")) {
            summer.setChecked(true);
        }
        if (theme.equals("custom")) {
            custom.setChecked(true);
        }

        if (troop_tv_size.equals("big")) {
            cb6.setChecked(true);
        }
        if (troop_tv_size.equals("small")) {
            cb7.setChecked(true);
        }

        if (troop_show_0 == true) {
            cb8.setChecked(true);
        } else {
            cb8.setChecked(false);
        }

        if (auto_show == true) {
            cb2.setChecked(true);
        } else {
            cb2.setChecked(false);
        }
        if (download_beta == true) {
            cb1.setChecked(true);
        } else {
            cb1.setChecked(false);
        }

        if (input_json_list == true) {
            cb4.setChecked(true);
        } else {
            cb4.setChecked(false);
        }
        if (input_json_cal == true) {
            cb5.setChecked(true);
        } else {
            cb5.setChecked(false);
        }

        if (decimal == true) {
            cb9.setChecked(true);
            decimal_ll.setVisibility(View.VISIBLE);
        } else {
            cb9.setChecked(false);
        }
        if (ANI_SHOW == true) {
            cb10.setChecked(true);
        } else {
            cb10.setChecked(false);
        }
        if (transform_show == true) {
            cb11.setChecked(true);
        } else {
            cb11.setChecked(false);
        }
        if (rss_card_show == true) {
            cb12.setChecked(true);
        } else {
            cb12.setChecked(false);
        }
        if (mecha_card_show == true) {
            cb13.setChecked(true);
        } else {
            cb13.setChecked(false);
        }
        if (troop_card_show == true) {
            cb14.setChecked(true);
        } else {
            cb14.setChecked(false);
        }
        if (enabler_card_show == true) {
            cb15.setChecked(true);
        } else {
            cb15.setChecked(false);
        }
        if (progress_card_show == true) {
            cb16.setChecked(true);
        } else {
            cb16.setChecked(false);
        }
        if (star_card_show == true) {
            cb17.setChecked(true);
        } else {
            cb17.setChecked(false);
        }
        if (exp_card_show == true) {
            cb18.setChecked(true);
        } else {
            cb18.setChecked(false);
        }
        if (land_card_show == true) {
            cb19.setChecked(true);
        } else {
            cb19.setChecked(false);
        }
        if (always_show_post == true) {
            cb3.setChecked(true);
        } else {
            cb3.setChecked(false);
        }
        decimal_et.setText(String.valueOf(decimal_num));
        if (color1 == null | color1 == ""){color1 = "00c9ac";}
        if (color2 == null | color2 == ""){color2 = "cf3c60";}
        color1_et.setText(color1);
        color2_et.setText(color2);

    }
    public void BackgroundReload (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.setting_bg);

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


    public void okay(View view) {
        save();
    }

    @Override
    public void onBackPressed() {
        save();
        cbg();
        super.onBackPressed();
    }


    public void save() {
        String theme_re = "";
        String troop_tv_size_re = "";
        boolean troop_show_0;
        boolean input_json_list;
        boolean input_json_cal;
        boolean decimal;
        boolean ANI_SHOW;
        boolean transform_show;

        boolean rss_card_show;
        boolean mecha_card_show ;
        boolean troop_card_show;
        boolean enabler_card_show ;
        boolean progress_card_show ;
        boolean star_card_show ;
        boolean exp_card_show  ;
        boolean land_card_show  ;

        boolean always_show_post  ;

        int decimal_num = 0;
        if (base.isChecked()) {
            theme_re = "base";
        }
        if (dark.isChecked()) {
            theme_re = "dark";
        }
        if (pink.isChecked()) {
            theme_re = "pink";
        }
        if (leek.isChecked()) {
            theme_re = "leek";
        }
        if (summer.isChecked()) {
            theme_re = "summer";
        }
        if (custom.isChecked()) {
            theme_re = "custom";
        }

        if (cb6.isChecked()) {
            troop_tv_size_re = "big";
        }
        if (cb7.isChecked()) {
            troop_tv_size_re = "small";
        }

        if (cb8.isChecked()) {
            troop_show_0 = true;
        } else {
            troop_show_0 = false;
        }
        if (cb9.isChecked()) {
            decimal = true;
            String dcet = String.valueOf(decimal_et.getText());
            if (dcet.equals("") | Integer.parseInt(dcet) > 6) {
                decimal_et.setText("1");
            }
            decimal_num = Integer.parseInt(dcet);
        } else {
            decimal = false;
        }
        if (cb4.isChecked()) {
            input_json_list = true;
        } else {
            input_json_list = false;
        }
        if (cb5.isChecked()) {
            input_json_cal = true;
        } else {
            input_json_cal = false;
        }
        color1 = String.valueOf(color1_et.getText());
        color2 = String.valueOf(color2_et.getText());

        Boolean auto_show;
        Boolean download_beta;
        if (cb2.isChecked()) {
            auto_show = true;
        } else {
            auto_show = false;
        }
        if (cb1.isChecked()) {
            download_beta = true;
        } else {
            download_beta = false;
        }
        if (cb10.isChecked()) {
            ANI_SHOW = true;
        } else {
            ANI_SHOW = false;
        }
        if (cb11.isChecked()) {
            transform_show = true;
        } else {
            transform_show = false;
        }
        if (cb12.isChecked()) {
            rss_card_show = true;
        } else {
            rss_card_show = false;
        }
        if (cb13.isChecked()) {
            mecha_card_show = true;
        } else {
            mecha_card_show = false;
        }
        if (cb14.isChecked()) {
            troop_card_show = true;
        } else {
            troop_card_show = false;
        }
        if (cb15.isChecked()) {
            enabler_card_show = true;
        } else {
            enabler_card_show = false;
        }
        if (cb16.isChecked()) {
            progress_card_show = true;
        } else {
            progress_card_show = false;
        }
        if (cb17.isChecked()) {
            star_card_show = true;
        } else {
            star_card_show = false;
        }
        if (cb18.isChecked()) {
            exp_card_show = true;
        } else {
            exp_card_show = false;
        }
        if (cb19.isChecked()) {
            land_card_show = true;
        } else {
            land_card_show = false;
        }
        if (cb3.isChecked()) {
            always_show_post = true;
        } else {
            always_show_post = false;
        }


        //Context.MODE_PRIVATE：为默认操作模式，代表该文件是私有数据，只能被应用本身访问，在该模式下，写入的内容会覆盖原文件的内容，如果想把新写入的内容追加到原文件中。可以使用Context.MODE_APPEND
        //Context.MODE_APPEND：模式会检查文件是否存在，存在就往文件追加内容，否则就创建新文件。
        //Context.MODE_PRIVATE和Context.MODE_WORLD_WRITEABLE用来控制其他应用是否有权限读写该文件。
        //MODE_PRIVATE：表示当前文件可以被其他应用读取；
        //MODE_WORLD_WRITEABLE：表示当前文件可以被其他应用写入。
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        //获取操作SharedPreferences实例的编辑器（必须通过此种方式添加数据）
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //添加数据
        editor.putString("theme", theme_re);
        editor.putString("color1", color1);
        editor.putString("color2", color2);
        editor.putBoolean("auto_show", auto_show);
        editor.putBoolean("download_beta", download_beta);
        editor.putString("troop_tv_size", troop_tv_size_re);
        editor.putBoolean("troop_show_0", troop_show_0);
        editor.putBoolean("decimal", decimal);
        editor.putInt("decimal_num", decimal_num);
        editor.putBoolean("input_json_list", input_json_list);
        editor.putBoolean("input_json_cal", input_json_cal);
        editor.putBoolean("ANI_SHOW", ANI_SHOW);
        editor.putBoolean("transform_show", transform_show);
        editor.putBoolean("rss_card_show", rss_card_show);
        editor.putBoolean("mecha_card_show", mecha_card_show);
        editor.putBoolean("troop_card_show", troop_card_show);
        editor.putBoolean("enabler_card_show", enabler_card_show);
        editor.putBoolean("progress_card_show", progress_card_show);
        editor.putBoolean("star_card_show", star_card_show);
        editor.putBoolean("exp_card_show", exp_card_show);
        editor.putBoolean("land_card_show", land_card_show);
        editor.putBoolean("always_show_post", always_show_post);
        //提交
        editor.apply();
    }

    public void color1(View view) {
        Intent intent = new Intent(this, ColorPicker.class);
        startActivityForResult(intent, FIRST_REQUEST_CODE);
    }

    public void color2(View view) {
        Intent intent = new Intent(this, ColorPicker.class);
        startActivityForResult(intent, SECOND_REQUEST_CODE);
    }

    public void custom_show(View view) {
        LinearLayout custom = findViewById(R.id.custom);
        save();
        cbg_all();
        custom.setVisibility(View.VISIBLE);
    }

    public void decimal_show(View view) {
        LinearLayout decimal = findViewById(R.id.decimal);
        decimal.setVisibility(View.VISIBLE);
    }


    // This method is called when the second activity finishes
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check that it is the SecondActivity with an OK result
        if (requestCode == FIRST_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // Get String data from Intent
                color1 = data.getStringExtra("color01");
                color1_et.setText(color1);
                SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
                //获取操作SharedPreferences实例的编辑器（必须通过此种方式添加数据）
                SharedPreferences.Editor editor = sharedPreferences.edit();
                //添加数据
                editor.putString("color1", color1);
            }
        }
        if (requestCode == SECOND_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // Get String data from Intent
                color2 = data.getStringExtra("color02");
                color2_et.setText(color2);
                SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
                //获取操作SharedPreferences实例的编辑器（必须通过此种方式添加数据）
                SharedPreferences.Editor editor = sharedPreferences.edit();
                //添加数据
                editor.putString("color2", color2);
            }
        }

    }

    public void cbg() {

        //取出数据（注意这里直接用实例取就行了，不用获取编辑器editor）
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String theme = sharedPreferences.getString("theme", "dark");
        String color1 = sharedPreferences.getString("color1", "F1870F");
        String color2 = sharedPreferences.getString("color2", "C56E0D");

        version_card = findViewById(R.id.version_card);
        version_tv = findViewById(R.id.ver_tv);
        theme_card = findViewById(R.id.theme_card);
        theme_tv = findViewById(R.id.theme_tv);
        troop_card = findViewById(R.id.troop_card);
        troop_tv = findViewById(R.id.troop_tv);
        data_card = findViewById(R.id.data_card);
        data_tv = findViewById(R.id.data_tv);
        more_cal_card = findViewById(R.id.more_cal_card);
        more_cal_tv = findViewById(R.id.more_cal_tv);

        if (theme.equals("base")) {
            version_card.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            version_tv.setBackgroundColor(getResources().getColor(R.color.background_base_press));
            theme_card.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            theme_tv.setBackgroundColor(getResources().getColor(R.color.background_base_press));
            troop_card.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            troop_tv.setBackgroundColor(getResources().getColor(R.color.background_base_press));
            data_card.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            data_tv.setBackgroundColor(getResources().getColor(R.color.background_base_press));
            more_cal_card.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            more_cal_tv.setBackgroundColor(getResources().getColor(R.color.background_base_press));
        }

        if (theme.equals("dark")) {
            version_card.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            version_tv.setBackgroundColor(getResources().getColor(R.color.background_dark_press));
            theme_card.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            theme_tv.setBackgroundColor(getResources().getColor(R.color.background_dark_press));
            troop_card.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            troop_tv.setBackgroundColor(getResources().getColor(R.color.background_dark_press));
            data_card.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            data_tv.setBackgroundColor(getResources().getColor(R.color.background_dark_press));
            more_cal_card.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            more_cal_tv.setBackgroundColor(getResources().getColor(R.color.background_dark_press));
        }

        if (theme.equals("pink")) {
            version_card.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            version_tv.setBackgroundColor(getResources().getColor(R.color.background_pink_press));
            theme_card.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            theme_tv.setBackgroundColor(getResources().getColor(R.color.background_pink_press));
            troop_card.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            troop_tv.setBackgroundColor(getResources().getColor(R.color.background_pink_press));
            data_card.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            data_tv.setBackgroundColor(getResources().getColor(R.color.background_pink_press));
            more_cal_card.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            more_cal_tv.setBackgroundColor(getResources().getColor(R.color.background_pink_press));
        }

        if (theme.equals("leek")) {
            version_card.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            version_tv.setBackgroundColor(getResources().getColor(R.color.background_leek_press));
            theme_card.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            theme_tv.setBackgroundColor(getResources().getColor(R.color.background_leek_press));
            troop_card.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            troop_tv.setBackgroundColor(getResources().getColor(R.color.background_leek_press));
            data_card.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            data_tv.setBackgroundColor(getResources().getColor(R.color.background_leek_press));
            more_cal_card.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            more_cal_tv.setBackgroundColor(getResources().getColor(R.color.background_leek_press));
        }

        if (theme.equals("summer")) {
            version_card.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            version_tv.setBackgroundColor(getResources().getColor(R.color.background_summer_press));
            theme_card.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            theme_tv.setBackgroundColor(getResources().getColor(R.color.background_summer_press));
            troop_card.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            troop_tv.setBackgroundColor(getResources().getColor(R.color.background_summer_press));
            data_card.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            data_tv.setBackgroundColor(getResources().getColor(R.color.background_summer_press));
            more_cal_card.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            more_cal_tv.setBackgroundColor(getResources().getColor(R.color.background_summer_press));
        }

        if (theme.equals("custom")) {
            version_card.setCardBackgroundColor(Color.parseColor("#CC" + color1));
            version_tv.setBackgroundColor(Color.parseColor("#" + color2));
            theme_card.setCardBackgroundColor(Color.parseColor("#CC" + color1));
            theme_tv.setBackgroundColor(Color.parseColor("#" + color2));
            troop_card.setCardBackgroundColor(Color.parseColor("#CC" + color1));
            troop_tv.setBackgroundColor(Color.parseColor("#" + color2));
            data_card.setCardBackgroundColor(Color.parseColor("#CC" + color1));
            data_tv.setBackgroundColor(Color.parseColor("#" + color2));
            more_cal_card.setCardBackgroundColor(Color.parseColor("#CC" + color1));
            more_cal_tv.setBackgroundColor(Color.parseColor("#" + color2));
        }
    }

    public void cbg2(View view) {
        save();
        //取出数据（注意这里直接用实例取就行了，不用获取编辑器editor）
        cbg_all();
    }

    public void cbg_all() {
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String theme = sharedPreferences.getString("theme", "dark");
        String color1 = sharedPreferences.getString("color1", "F1870F");
        String color2 = sharedPreferences.getString("color2", "C56E0D");

        version_card = findViewById(R.id.version_card);
        version_tv = findViewById(R.id.ver_tv);
        theme_card = findViewById(R.id.theme_card);
        theme_tv = findViewById(R.id.theme_tv);
        troop_card = findViewById(R.id.troop_card);
        troop_tv = findViewById(R.id.troop_tv);
        data_card = findViewById(R.id.data_card);
        data_tv = findViewById(R.id.data_tv);
        more_cal_card = findViewById(R.id.more_cal_card);
        more_cal_tv = findViewById(R.id.more_cal_tv);

        if (theme.equals("base")) {
            version_card.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            version_tv.setBackgroundColor(getResources().getColor(R.color.background_base_press));
            theme_card.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            theme_tv.setBackgroundColor(getResources().getColor(R.color.background_base_press));
            troop_card.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            troop_tv.setBackgroundColor(getResources().getColor(R.color.background_base_press));
            data_card.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            data_tv.setBackgroundColor(getResources().getColor(R.color.background_base_press));
            more_cal_card.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            more_cal_tv.setBackgroundColor(getResources().getColor(R.color.background_base_press));
        }

        if (theme.equals("dark")) {
            version_card.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            version_tv.setBackgroundColor(getResources().getColor(R.color.background_dark_press));
            theme_card.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            theme_tv.setBackgroundColor(getResources().getColor(R.color.background_dark_press));
            troop_card.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            troop_tv.setBackgroundColor(getResources().getColor(R.color.background_dark_press));
            data_card.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            data_tv.setBackgroundColor(getResources().getColor(R.color.background_dark_press));
            more_cal_card.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            more_cal_tv.setBackgroundColor(getResources().getColor(R.color.background_dark_press));
        }

        if (theme.equals("pink")) {
            version_card.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            version_tv.setBackgroundColor(getResources().getColor(R.color.background_pink_press));
            theme_card.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            theme_tv.setBackgroundColor(getResources().getColor(R.color.background_pink_press));
            troop_card.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            troop_tv.setBackgroundColor(getResources().getColor(R.color.background_pink_press));
            data_card.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            data_tv.setBackgroundColor(getResources().getColor(R.color.background_pink_press));
            more_cal_card.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            more_cal_tv.setBackgroundColor(getResources().getColor(R.color.background_pink_press));
        }

        if (theme.equals("leek")) {
            version_card.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            version_tv.setBackgroundColor(getResources().getColor(R.color.background_leek_press));
            theme_card.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            theme_tv.setBackgroundColor(getResources().getColor(R.color.background_leek_press));
            troop_card.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            troop_tv.setBackgroundColor(getResources().getColor(R.color.background_leek_press));
            data_card.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            data_tv.setBackgroundColor(getResources().getColor(R.color.background_leek_press));
            more_cal_card.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            more_cal_tv.setBackgroundColor(getResources().getColor(R.color.background_leek_press));
        }

        if (theme.equals("summer")) {
            version_card.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            version_tv.setBackgroundColor(getResources().getColor(R.color.background_summer_press));
            theme_card.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            theme_tv.setBackgroundColor(getResources().getColor(R.color.background_summer_press));
            troop_card.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            troop_tv.setBackgroundColor(getResources().getColor(R.color.background_summer_press));
            data_card.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            data_tv.setBackgroundColor(getResources().getColor(R.color.background_summer_press));
            more_cal_card.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            more_cal_tv.setBackgroundColor(getResources().getColor(R.color.background_summer_press));
        }

        if (theme.equals("custom")) {
            version_card.setCardBackgroundColor(Color.parseColor("#CC" + color1));
            version_tv.setBackgroundColor(Color.parseColor("#" + color2));
            theme_card.setCardBackgroundColor(Color.parseColor("#CC" + color1));
            theme_tv.setBackgroundColor(Color.parseColor("#" + color2));
            troop_card.setCardBackgroundColor(Color.parseColor("#CC" + color1));
            troop_tv.setBackgroundColor(Color.parseColor("#" + color2));
            data_card.setCardBackgroundColor(Color.parseColor("#CC" + color1));
            data_tv.setBackgroundColor(Color.parseColor("#" + color2));
            more_cal_card.setCardBackgroundColor(Color.parseColor("#CC" + color1));
            more_cal_tv.setBackgroundColor(Color.parseColor("#" + color2));
        }
    }

    public void christmas_2020 (View view){
        Intent i = new Intent(this , Christmas2020.class);
        startActivity(i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        cbg();
        //把保存的資料拿回來使用
    }

    @Override
    protected void onPause() {
        super.onPause();
        cbg();

        //時把需要保存的資料保存
    }

}