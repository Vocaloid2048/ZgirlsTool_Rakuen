package voc.net.tools.zgirls_tool.old_ui;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import org.apache.http.util.EncodingUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;

import voc.net.tools.zgirls_tool.R;
import voc.net.tools.zgirls_tool.ui.DataListActivity;
import voc.net.tools.zgirls_tool.util.HttpHandler;

public class DataEnablerActivity extends AppCompatActivity {

    CardView enabler_card;
    TextView enabler_tv;

    ImageView	enabler_img_01,	enabler_img_02,	enabler_img_03,	enabler_img_04,	enabler_img_05,	enabler_img_06,	enabler_img_07,	enabler_img_08,	enabler_img_09,	enabler_img_10,	enabler_img_11,	enabler_img_12,	enabler_img_13,	enabler_img_14,	enabler_img_15,	enabler_img_16,	enabler_img_17,	enabler_img_18,	enabler_img_19,	enabler_img_20,	enabler_img_21,	enabler_img_22,	enabler_img_23,	enabler_img_24,	enabler_img_25,	enabler_img_26,	enabler_img_27,	enabler_img_28,	enabler_img_29,	enabler_img_30,	enabler_img_31,	enabler_img_32,	enabler_img_33,	enabler_img_34,	enabler_img_35,	enabler_img_36,	enabler_img_37,	enabler_img_38,	enabler_img_39,	enabler_img_40,	enabler_img_41,	enabler_img_42,	enabler_img_43,	enabler_img_44,	enabler_img_45,	enabler_img_46,	enabler_img_47,	enabler_img_48,	enabler_img_49,	enabler_img_50;

    String DataBasePath = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/database/database.db";
    String DataBaseFile = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/database";
    int code_num = 0;
    // myDbAdapter helper;
    String DataBasePath2 = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/database";
    String path_test , path_final ;
    long uid ;
    String downloadpath ;
    private static final int ERROR = 2;
    private static final int SHOW_UPDATE_DIALOG = 1;
    private final static String TAG = "DataEnablerActivity";
    ProgressDialog pd ;
    long UID;
    long UID2;
    String ppl ;
    boolean sleep = false ;
    private static final String fileName = "user_session";
    private static final String fileDir = Environment.getExternalStorageDirectory().getPath() +"/data/data/com.xingjoys.zgirls.app/config/";

    String  enablerName ;
    long  enablerLv ;

    String[] enablerNameArray = new String[48];
    long[] enablerLvArray = new long[48];

    private View decorView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_enabler);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                UID2 = 0;
            } else {
                UID2 = extras.getLong("UID");
            }
        } else {
            UID2 = (Long) savedInstanceState.getSerializable("UID");
        }
        getSavedLoginDataJson();
       // pd = new ProgressDialog(DataEnablerActivity.this);
       // pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
       // pd.setTitle(R.string.update_title);
       // pd.show();
        //mHandler.sendEmptyMessageDelayed(WAIT_REFRESH, 3000);
       // progress_pd();

        new TakeData().execute();


        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String color1 = sharedPreferences.getString("color1", "F1870F");
        String theme = sharedPreferences.getString("theme", "dark");

        init();
        // 建立SQLiteOpenHelper物件
        //METHOD END
        String fileName = "background.png";
        Resources res = getResources();
        String pathName = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/background/" + fileName;
        Bitmap bitmap = BitmapFactory.decodeFile(pathName);
        BitmapDrawable bd = new BitmapDrawable(res, bitmap);
        ImageView view = findViewById(R.id.data_enabler_bg);
        view.setImageDrawable(bd);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }
    //private void progress_pd() {
    //    mHandler.sendEmptyMessageDelayed(WAIT_PROCESS_REFRESH, 30);
    //}
    private int hideSystemBars(){
        return //View.SYSTEM_UI_FLAG_LAYOUT_STABLE|
                //    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|
                        // View.SYSTEM_UI_FLAG_FULLSCREEN|
                        View.SYSTEM_UI_FLAG_FULLSCREEN;
    }
    public void init (){
        enabler_card = findViewById(R.id.enabler_card);
        enabler_tv = findViewById(R.id.enabler);

        enabler_img_01	 = findViewById (R.id.	enabler_img_01);
        enabler_img_02	 = findViewById (R.id.	enabler_img_02);
        enabler_img_03	 = findViewById (R.id.	enabler_img_03);
        enabler_img_04	 = findViewById (R.id.	enabler_img_04);
        enabler_img_05	 = findViewById (R.id.	enabler_img_05);
        enabler_img_06	 = findViewById (R.id.	enabler_img_06);
        enabler_img_07	 = findViewById (R.id.	enabler_img_07);
        enabler_img_08	 = findViewById (R.id.	enabler_img_08);
        enabler_img_09	 = findViewById (R.id.	enabler_img_09);
        enabler_img_10	 = findViewById (R.id.	enabler_img_10);
        enabler_img_11	 = findViewById (R.id.	enabler_img_11);
        enabler_img_12	 = findViewById (R.id.	enabler_img_12);
        enabler_img_13	 = findViewById (R.id.	enabler_img_13);
        enabler_img_14	 = findViewById (R.id.	enabler_img_14);
        enabler_img_15	 = findViewById (R.id.	enabler_img_15);
        enabler_img_16	 = findViewById (R.id.	enabler_img_16);
        enabler_img_17	 = findViewById (R.id.	enabler_img_17);
        enabler_img_18	 = findViewById (R.id.	enabler_img_18);
        enabler_img_19	 = findViewById (R.id.	enabler_img_19);
        enabler_img_20	 = findViewById (R.id.	enabler_img_20);
        enabler_img_21	 = findViewById (R.id.	enabler_img_21);
        enabler_img_22	 = findViewById (R.id.	enabler_img_22);
        enabler_img_23	 = findViewById (R.id.	enabler_img_23);
        enabler_img_24	 = findViewById (R.id.	enabler_img_24);
        enabler_img_25	 = findViewById (R.id.	enabler_img_25);
        enabler_img_26	 = findViewById (R.id.	enabler_img_26);
        enabler_img_27	 = findViewById (R.id.	enabler_img_27);
        enabler_img_28	 = findViewById (R.id.	enabler_img_28);
        enabler_img_29	 = findViewById (R.id.	enabler_img_29);
        enabler_img_30	 = findViewById (R.id.	enabler_img_30);
        enabler_img_31	 = findViewById (R.id.	enabler_img_31);
        enabler_img_32	 = findViewById (R.id.	enabler_img_32);
        enabler_img_33	 = findViewById (R.id.	enabler_img_33);
        enabler_img_34	 = findViewById (R.id.	enabler_img_34);
        enabler_img_35	 = findViewById (R.id.	enabler_img_35);
        enabler_img_36	 = findViewById (R.id.	enabler_img_36);
        enabler_img_37	 = findViewById (R.id.	enabler_img_37);
        enabler_img_38	 = findViewById (R.id.	enabler_img_38);
        enabler_img_39	 = findViewById (R.id.	enabler_img_39);
        enabler_img_40	 = findViewById (R.id.	enabler_img_40);
        enabler_img_41	 = findViewById (R.id.	enabler_img_41);
        enabler_img_42	 = findViewById (R.id.	enabler_img_42);
        enabler_img_43	 = findViewById (R.id.	enabler_img_43);
        enabler_img_44	 = findViewById (R.id.	enabler_img_44);
        enabler_img_45	 = findViewById (R.id.	enabler_img_45);
        enabler_img_46	 = findViewById (R.id.	enabler_img_46);
        enabler_img_47	 = findViewById (R.id.	enabler_img_47);
        enabler_img_48	 = findViewById (R.id.	enabler_img_48);

    }
    public void cbg() {
        //取出数据（注意这里直接用实例取就行了，不用获取编辑器editor）
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String theme = sharedPreferences.getString("theme", "dark");
        String color1 = sharedPreferences.getString("color1", "F1870F");
        String color2 = sharedPreferences.getString("color2", "C56E0D");
        if (theme.equals("base")) {
            enabler_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_base_alpha	));
            enabler_tv	.setBackgroundColor(getResources().getColor(R.color.	background_base_press	));
        }

        if (theme.equals("dark")) {
            enabler_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_dark_alpha	));
            enabler_tv	.setBackgroundColor(getResources().getColor(R.color.	background_dark_press	));


        }

        if (theme.equals("pink")) {
            enabler_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_pink_alpha	));
            enabler_tv	.setBackgroundColor(getResources().getColor(R.color.	background_pink_press	));

        }

        if (theme.equals("leek")) {
            enabler_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_leek_alpha	));
            enabler_tv	.setBackgroundColor(getResources().getColor(R.color.	background_leek_press	));

        }

        if (theme.equals("summer")) {
            enabler_card	.setCardBackgroundColor(getResources().getColor(R.color.	background_summer_alpha	));
            enabler_tv	.setBackgroundColor(getResources().getColor(R.color.	background_summer_press	));

        }
        if (theme.equals("custom")) {
            enabler_card	.setCardBackgroundColor(Color.parseColor("#99"+color1));
            enabler_tv	.setBackgroundColor(Color.parseColor("#"+color2));
        }
    }
    public void dataRefresh (){
        getSavedLoginDataJson();
        mHandler.sendEmptyMessageDelayed(DATA_REFRESH, 3000);
        //Toast.makeText(this, "Star : "+starArray[0]+" "+starArray[1]+" "+starArray[2]+" "+starArray[3], Toast.LENGTH_SHORT).show();

        String lv = getResources().getString((R.string.lv));
        String atk = getResources().getString((R.string.atk));
        String energy = getResources().getString((R.string.atk));

        TextView	ename01	 = findViewById(R.id.	enabler_name01);	TextView	epower01	 = findViewById(R.id.	enabler_power01);	TextView	elevel01	 = findViewById(R.id.	enabler_level01);
        TextView	ename02	 = findViewById(R.id.	enabler_name02);	TextView	epower02	 = findViewById(R.id.	enabler_power02);	TextView	elevel02	 = findViewById(R.id.	enabler_level02);
        TextView	ename03	 = findViewById(R.id.	enabler_name03);	TextView	epower03	 = findViewById(R.id.	enabler_power03);	TextView	elevel03	 = findViewById(R.id.	enabler_level03);
        TextView	ename04	 = findViewById(R.id.	enabler_name04);	TextView	epower04	 = findViewById(R.id.	enabler_power04);	TextView	elevel04	 = findViewById(R.id.	enabler_level04);
        TextView	ename05	 = findViewById(R.id.	enabler_name05);	TextView	epower05	 = findViewById(R.id.	enabler_power05);	TextView	elevel05	 = findViewById(R.id.	enabler_level05);
        TextView	ename06	 = findViewById(R.id.	enabler_name06);	TextView	epower06	 = findViewById(R.id.	enabler_power06);	TextView	elevel06	 = findViewById(R.id.	enabler_level06);
        TextView	ename07	 = findViewById(R.id.	enabler_name07);	TextView	epower07	 = findViewById(R.id.	enabler_power07);	TextView	elevel07	 = findViewById(R.id.	enabler_level07);
        TextView	ename08	 = findViewById(R.id.	enabler_name08);	TextView	epower08	 = findViewById(R.id.	enabler_power08);	TextView	elevel08	 = findViewById(R.id.	enabler_level08);
        TextView	ename09	 = findViewById(R.id.	enabler_name09);	TextView	epower09	 = findViewById(R.id.	enabler_power09);	TextView	elevel09	 = findViewById(R.id.	enabler_level09);
        TextView	ename10	 = findViewById(R.id.	enabler_name10);	TextView	epower10	 = findViewById(R.id.	enabler_power10);	TextView	elevel10	 = findViewById(R.id.	enabler_level10);
        TextView	ename11	 = findViewById(R.id.	enabler_name11);	TextView	epower11	 = findViewById(R.id.	enabler_power11);	TextView	elevel11	 = findViewById(R.id.	enabler_level11);
        TextView	ename12	 = findViewById(R.id.	enabler_name12);	TextView	epower12	 = findViewById(R.id.	enabler_power12);	TextView	elevel12	 = findViewById(R.id.	enabler_level12);
        TextView	ename13	 = findViewById(R.id.	enabler_name13);	TextView	epower13	 = findViewById(R.id.	enabler_power13);	TextView	elevel13	 = findViewById(R.id.	enabler_level13);
        TextView	ename14	 = findViewById(R.id.	enabler_name14);	TextView	epower14	 = findViewById(R.id.	enabler_power14);	TextView	elevel14	 = findViewById(R.id.	enabler_level14);
        TextView	ename15	 = findViewById(R.id.	enabler_name15);	TextView	epower15	 = findViewById(R.id.	enabler_power15);	TextView	elevel15	 = findViewById(R.id.	enabler_level15);
        TextView	ename16	 = findViewById(R.id.	enabler_name16);	TextView	epower16	 = findViewById(R.id.	enabler_power16);	TextView	elevel16	 = findViewById(R.id.	enabler_level16);
        TextView	ename17	 = findViewById(R.id.	enabler_name17);	TextView	epower17	 = findViewById(R.id.	enabler_power17);	TextView	elevel17	 = findViewById(R.id.	enabler_level17);
        TextView	ename18	 = findViewById(R.id.	enabler_name18);	TextView	epower18	 = findViewById(R.id.	enabler_power18);	TextView	elevel18	 = findViewById(R.id.	enabler_level18);
        TextView	ename19	 = findViewById(R.id.	enabler_name19);	TextView	epower19	 = findViewById(R.id.	enabler_power19);	TextView	elevel19	 = findViewById(R.id.	enabler_level19);
        TextView	ename20	 = findViewById(R.id.	enabler_name20);	TextView	epower20	 = findViewById(R.id.	enabler_power20);	TextView	elevel20	 = findViewById(R.id.	enabler_level20);
        TextView	ename21	 = findViewById(R.id.	enabler_name21);	TextView	epower21	 = findViewById(R.id.	enabler_power21);	TextView	elevel21	 = findViewById(R.id.	enabler_level21);
        TextView	ename22	 = findViewById(R.id.	enabler_name22);	TextView	epower22	 = findViewById(R.id.	enabler_power22);	TextView	elevel22	 = findViewById(R.id.	enabler_level22);
        TextView	ename23	 = findViewById(R.id.	enabler_name23);	TextView	epower23	 = findViewById(R.id.	enabler_power23);	TextView	elevel23	 = findViewById(R.id.	enabler_level23);
        TextView	ename24	 = findViewById(R.id.	enabler_name24);	TextView	epower24	 = findViewById(R.id.	enabler_power24);	TextView	elevel24	 = findViewById(R.id.	enabler_level24);
        TextView	ename25	 = findViewById(R.id.	enabler_name25);	TextView	epower25	 = findViewById(R.id.	enabler_power25);	TextView	elevel25	 = findViewById(R.id.	enabler_level25);
        TextView	ename26	 = findViewById(R.id.	enabler_name26);	TextView	epower26	 = findViewById(R.id.	enabler_power26);	TextView	elevel26	 = findViewById(R.id.	enabler_level26);
        TextView	ename27	 = findViewById(R.id.	enabler_name27);	TextView	epower27	 = findViewById(R.id.	enabler_power27);	TextView	elevel27	 = findViewById(R.id.	enabler_level27);
        TextView	ename28	 = findViewById(R.id.	enabler_name28);	TextView	epower28	 = findViewById(R.id.	enabler_power28);	TextView	elevel28	 = findViewById(R.id.	enabler_level28);
        TextView	ename29	 = findViewById(R.id.	enabler_name29);	TextView	epower29	 = findViewById(R.id.	enabler_power29);	TextView	elevel29	 = findViewById(R.id.	enabler_level29);
        TextView	ename30	 = findViewById(R.id.	enabler_name30);	TextView	epower30	 = findViewById(R.id.	enabler_power30);	TextView	elevel30	 = findViewById(R.id.	enabler_level30);
        TextView	ename31	 = findViewById(R.id.	enabler_name31);	TextView	epower31	 = findViewById(R.id.	enabler_power31);	TextView	elevel31	 = findViewById(R.id.	enabler_level31);
        TextView	ename32	 = findViewById(R.id.	enabler_name32);	TextView	epower32	 = findViewById(R.id.	enabler_power32);	TextView	elevel32	 = findViewById(R.id.	enabler_level32);
        TextView	ename33	 = findViewById(R.id.	enabler_name33);	TextView	epower33	 = findViewById(R.id.	enabler_power33);	TextView	elevel33	 = findViewById(R.id.	enabler_level33);
        TextView	ename34	 = findViewById(R.id.	enabler_name34);	TextView	epower34	 = findViewById(R.id.	enabler_power34);	TextView	elevel34	 = findViewById(R.id.	enabler_level34);
        TextView	ename35	 = findViewById(R.id.	enabler_name35);	TextView	epower35	 = findViewById(R.id.	enabler_power35);	TextView	elevel35	 = findViewById(R.id.	enabler_level35);
        TextView	ename36	 = findViewById(R.id.	enabler_name36);	TextView	epower36	 = findViewById(R.id.	enabler_power36);	TextView	elevel36	 = findViewById(R.id.	enabler_level36);
        TextView	ename37	 = findViewById(R.id.	enabler_name37);	TextView	epower37	 = findViewById(R.id.	enabler_power37);	TextView	elevel37	 = findViewById(R.id.	enabler_level37);
        TextView	ename38	 = findViewById(R.id.	enabler_name38);	TextView	epower38	 = findViewById(R.id.	enabler_power38);	TextView	elevel38	 = findViewById(R.id.	enabler_level38);
        TextView	ename39	 = findViewById(R.id.	enabler_name39);	TextView	epower39	 = findViewById(R.id.	enabler_power39);	TextView	elevel39	 = findViewById(R.id.	enabler_level39);
        TextView	ename40	 = findViewById(R.id.	enabler_name40);	TextView	epower40	 = findViewById(R.id.	enabler_power40);	TextView	elevel40	 = findViewById(R.id.	enabler_level40);
        TextView	ename41	 = findViewById(R.id.	enabler_name41);	TextView	epower41	 = findViewById(R.id.	enabler_power41);	TextView	elevel41	 = findViewById(R.id.	enabler_level41);
        TextView	ename42	 = findViewById(R.id.	enabler_name42);	TextView	epower42	 = findViewById(R.id.	enabler_power42);	TextView	elevel42	 = findViewById(R.id.	enabler_level42);
        TextView	ename43	 = findViewById(R.id.	enabler_name43);	TextView	epower43	 = findViewById(R.id.	enabler_power43);	TextView	elevel43	 = findViewById(R.id.	enabler_level43);
        TextView	ename44	 = findViewById(R.id.	enabler_name44);	TextView	epower44	 = findViewById(R.id.	enabler_power44);	TextView	elevel44	 = findViewById(R.id.	enabler_level44);
        TextView	ename45	 = findViewById(R.id.	enabler_name45);	TextView	epower45	 = findViewById(R.id.	enabler_power45);	TextView	elevel45	 = findViewById(R.id.	enabler_level45);
        TextView	ename46	 = findViewById(R.id.	enabler_name46);	TextView	epower46	 = findViewById(R.id.	enabler_power46);	TextView	elevel46	 = findViewById(R.id.	enabler_level46);
        TextView	ename47	 = findViewById(R.id.	enabler_name47);	TextView	epower47	 = findViewById(R.id.	enabler_power47);	TextView	elevel47	 = findViewById(R.id.	enabler_level47);
        TextView	ename48	 = findViewById(R.id.	enabler_name48);	TextView	epower48	 = findViewById(R.id.	enabler_power48);	TextView	elevel48	 = findViewById(R.id.	enabler_level48);

        ename38	.setText(enablerNameArray[0]);	elevel38	.setText(lv+enablerLvArray[0]);	epower38	.setText("");
        ename37	.setText(enablerNameArray[1]);	elevel37	.setText(lv+enablerLvArray[1]);	epower37	.setText("");
        ename36	.setText(enablerNameArray[2]);	elevel36	.setText(lv+enablerLvArray[2]);	epower36	.setText("");
        ename35	.setText(enablerNameArray[3]);	elevel35	.setText(lv+enablerLvArray[3]);	epower35	.setText("");
        ename42	.setText(enablerNameArray[4]);	elevel42	.setText(lv+enablerLvArray[4]);	epower42	.setText("");
        ename41	.setText(enablerNameArray[5]);	elevel41	.setText(lv+enablerLvArray[5]);	epower41	.setText("");
        ename40	.setText(enablerNameArray[6]);	elevel40	.setText(lv+enablerLvArray[6]);	epower40	.setText("");
        ename39	.setText(enablerNameArray[7]);	elevel39	.setText(lv+enablerLvArray[7]);	epower39	.setText("");
        ename46	.setText(enablerNameArray[8]);	elevel46	.setText(lv+enablerLvArray[8]);	epower46	.setText("");
        ename45	.setText(enablerNameArray[9]);	elevel45	.setText(lv+enablerLvArray[9]);	epower45	.setText("");
        ename44	.setText(enablerNameArray[10]);	elevel44	.setText(lv+enablerLvArray[10]);	epower44	.setText("");
        ename43	.setText(enablerNameArray[11]);	elevel43	.setText(lv+enablerLvArray[11]);	epower43	.setText("");
        ename48	.setText(enablerNameArray[12]);	elevel48	.setText(lv+enablerLvArray[12]);	epower48	.setText("");
        ename47	.setText(enablerNameArray[13]);	elevel47	.setText(lv+enablerLvArray[13]);	epower47	.setText("");
        ename02	.setText(enablerNameArray[14]);	elevel02	.setText(lv+enablerLvArray[14]);	epower02	.setText("");
        ename01	.setText(enablerNameArray[15]);	elevel01	.setText(lv+enablerLvArray[15]);	epower01	.setText("");
        ename06	.setText(enablerNameArray[16]);	elevel06	.setText(lv+enablerLvArray[16]);	epower06	.setText("");
        ename05	.setText(enablerNameArray[17]);	elevel05	.setText(lv+enablerLvArray[17]);	epower05	.setText("");
        ename04	.setText(enablerNameArray[18]);	elevel04	.setText(lv+enablerLvArray[18]);	epower04	.setText("");
        ename03	.setText(enablerNameArray[19]);	elevel03	.setText(lv+enablerLvArray[19]);	epower03	.setText("");
        ename10	.setText(enablerNameArray[20]);	elevel10	.setText(lv+enablerLvArray[20]);	epower10	.setText("");
        ename09	.setText(enablerNameArray[21]);	elevel09	.setText(lv+enablerLvArray[21]);	epower09	.setText("");
        ename08	.setText(enablerNameArray[22]);	elevel08	.setText(lv+enablerLvArray[22]);	epower08	.setText("");
        ename07	.setText(enablerNameArray[23]);	elevel07	.setText(lv+enablerLvArray[23]);	epower07	.setText("");
        ename17	.setText(enablerNameArray[24]);	elevel17	.setText(lv+enablerLvArray[24]);	epower17	.setText("");
        ename14	.setText(enablerNameArray[25]);	elevel14	.setText(lv+enablerLvArray[25]);	epower14	.setText("");
        ename21	.setText(enablerNameArray[26]);	elevel21	.setText(lv+enablerLvArray[26]);	epower21	.setText("");
        ename11	.setText(enablerNameArray[27]);	elevel11	.setText(lv+enablerLvArray[27]);	epower11	.setText("");
        ename23	.setText(enablerNameArray[28]);	elevel23	.setText(lv+enablerLvArray[28]);	epower23	.setText("");
        ename15	.setText(enablerNameArray[29]);	elevel15	.setText(lv+enablerLvArray[29]);	epower15	.setText("");
        ename13	.setText(enablerNameArray[30]);	elevel13	.setText(lv+enablerLvArray[30]);	epower13	.setText("");
        ename12	.setText(enablerNameArray[31]);	elevel12	.setText(lv+enablerLvArray[31]);	epower12	.setText("");
        ename20	.setText(enablerNameArray[32]);	elevel20	.setText(lv+enablerLvArray[32]);	epower20	.setText("");
        ename19	.setText(enablerNameArray[33]);	elevel19	.setText(lv+enablerLvArray[33]);	epower19	.setText("");
        ename16	.setText(enablerNameArray[34]);	elevel16	.setText(lv+enablerLvArray[34]);	epower16	.setText("");
        ename22	.setText(enablerNameArray[35]);	elevel22	.setText(lv+enablerLvArray[35]);	epower22	.setText("");
        ename28	.setText(enablerNameArray[36]);	elevel28	.setText(lv+enablerLvArray[36]);	epower28	.setText("");
        ename24	.setText(enablerNameArray[37]);	elevel24	.setText(lv+enablerLvArray[37]);	epower24	.setText("");
        ename25	.setText(enablerNameArray[38]);	elevel25	.setText(lv+enablerLvArray[38]);	epower25	.setText("");
        ename18	.setText(enablerNameArray[39]);	elevel18	.setText(lv+enablerLvArray[39]);	epower18	.setText("");
        ename30	.setText(enablerNameArray[40]);	elevel30	.setText(lv+enablerLvArray[40]);	epower30	.setText("");
        ename29	.setText(enablerNameArray[41]);	elevel29	.setText(lv+enablerLvArray[41]);	epower29	.setText("");
        ename27	.setText(enablerNameArray[42]);	elevel27	.setText(lv+enablerLvArray[42]);	epower27	.setText("");
        ename26	.setText(enablerNameArray[43]);	elevel26	.setText(lv+enablerLvArray[43]);	epower26	.setText("");
        ename34	.setText(enablerNameArray[44]);	elevel34	.setText(lv+enablerLvArray[44]);	epower34	.setText("");
        ename33	.setText(enablerNameArray[45]);	elevel33	.setText(lv+enablerLvArray[45]);	epower33	.setText("");
        ename32	.setText(enablerNameArray[46]);	elevel32	.setText(lv+enablerLvArray[46]);	epower32	.setText("");
        ename31	.setText(enablerNameArray[47]);	elevel31	.setText(lv+enablerLvArray[47]);	epower31	.setText("");


        if (enablerLvArray[0] 	 == 0 ) {	elevel38	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[0] 	 == 1 ) {	elevel38	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[0] 	 == 2 ) {	elevel38	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[0] 	 == 3 ) {	elevel38	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[0] 	 == 4 ) {	elevel38	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[1]	 == 0 ) {	elevel37	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[1]	 == 1 ) {	elevel37	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[1]	 == 2 ) {	elevel37	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[1]	 == 3 ) {	elevel37	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[1]	 == 4 ) {	elevel37	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[2]	 == 0 ) {	elevel36	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[2]	 == 1 ) {	elevel36	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[2]	 == 2 ) {	elevel36	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[2]	 == 3 ) {	elevel36	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[2]	 == 4 ) {	elevel36	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[3]	 == 0 ) {	elevel35	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[3]	 == 1 ) {	elevel35	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[3]	 == 2 ) {	elevel35	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[3]	 == 3 ) {	elevel35	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[3]	 == 4 ) {	elevel35	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[4]	 == 0 ) {	elevel42	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[4]	 == 1 ) {	elevel42	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[4]	 == 2 ) {	elevel42	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[4]	 == 3 ) {	elevel42	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[4]	 == 4 ) {	elevel42	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[5]	 == 0 ) {	elevel41	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[5]	 == 1 ) {	elevel41	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[5]	 == 2 ) {	elevel41	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[5]	 == 3 ) {	elevel41	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[5]	 == 4 ) {	elevel41	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[6]	 == 0 ) {	elevel40	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[6]	 == 1 ) {	elevel40	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[6]	 == 2 ) {	elevel40	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[6]	 == 3 ) {	elevel40	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[6]	 == 4 ) {	elevel40	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[7]	 == 0 ) {	elevel39	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[7]	 == 1 ) {	elevel39	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[7]	 == 2 ) {	elevel39	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[7]	 == 3 ) {	elevel39	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[7]	 == 4 ) {	elevel39	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[8]	 == 0 ) {	elevel46	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[8]	 == 1 ) {	elevel46	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[8]	 == 2 ) {	elevel46	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[8]	 == 3 ) {	elevel46	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[8]	 == 4 ) {	elevel46	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[9]	 == 0 ) {	elevel45	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[9]	 == 1 ) {	elevel45	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[9]	 == 2 ) {	elevel45	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[9]	 == 3 ) {	elevel45	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[9]	 == 4 ) {	elevel45	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[10]	 == 0 ) {	elevel44	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[10]	 == 1 ) {	elevel44	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[10]	 == 2 ) {	elevel44	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[10]	 == 3 ) {	elevel44	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[10]	 == 4 ) {	elevel44	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[11]	 == 0 ) {	elevel43	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[11]	 == 1 ) {	elevel43	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[11]	 == 2 ) {	elevel43	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[11]	 == 3 ) {	elevel43	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[11]	 == 4 ) {	elevel43	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[12]	 == 0 ) {	elevel48	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[12]	 == 1 ) {	elevel48	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[12]	 == 2 ) {	elevel48	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[12]	 == 3 ) {	elevel48	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[12]	 == 4 ) {	elevel48	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[13]	 == 0 ) {	elevel47	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[13]	 == 1 ) {	elevel47	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[13]	 == 2 ) {	elevel47	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[13]	 == 3 ) {	elevel47	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[13]	 == 4 ) {	elevel47	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[14]	 == 0 ) {	elevel02	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[14]	 == 1 ) {	elevel02	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[14]	 == 2 ) {	elevel02	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[14]	 == 3 ) {	elevel02	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[14]	 == 4 ) {	elevel02	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[15]	 == 0 ) {	elevel01	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[15]	 == 1 ) {	elevel01	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[15]	 == 2 ) {	elevel01	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[15]	 == 3 ) {	elevel01	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[15]	 == 4 ) {	elevel01	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[16]	 == 0 ) {	elevel06	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[16]	 == 1 ) {	elevel06	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[16]	 == 2 ) {	elevel06	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[16]	 == 3 ) {	elevel06	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[16]	 == 4 ) {	elevel06	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[17]	 == 0 ) {	elevel05	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[17]	 == 1 ) {	elevel05	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[17]	 == 2 ) {	elevel05	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[17]	 == 3 ) {	elevel05	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[17]	 == 4 ) {	elevel05	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[18]	 == 0 ) {	elevel04	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[18]	 == 1 ) {	elevel04	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[18]	 == 2 ) {	elevel04	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[18]	 == 3 ) {	elevel04	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[18]	 == 4 ) {	elevel04	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[19]	 == 0 ) {	elevel03	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[19]	 == 1 ) {	elevel03	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[19]	 == 2 ) {	elevel03	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[19]	 == 3 ) {	elevel03	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[19]	 == 4 ) {	elevel03	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[20]	 == 0 ) {	elevel10	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[20]	 == 1 ) {	elevel10	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[20]	 == 2 ) {	elevel10	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[20]	 == 3 ) {	elevel10	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[20]	 == 4 ) {	elevel10	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[21]	 == 0 ) {	elevel09	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[21]	 == 1 ) {	elevel09	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[21]	 == 2 ) {	elevel09	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[21]	 == 3 ) {	elevel09	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[21]	 == 4 ) {	elevel09	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[22]	 == 0 ) {	elevel08	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[22]	 == 1 ) {	elevel08	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[22]	 == 2 ) {	elevel08	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[22]	 == 3 ) {	elevel08	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[22]	 == 4 ) {	elevel08	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[23]	 == 0 ) {	elevel07	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[23]	 == 1 ) {	elevel07	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[23]	 == 2 ) {	elevel07	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[23]	 == 3 ) {	elevel07	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[23]	 == 4 ) {	elevel07	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[24]	 == 0 ) {	elevel17	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[24]	 == 1 ) {	elevel17	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[24]	 == 2 ) {	elevel17	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[24]	 == 3 ) {	elevel17	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[24]	 == 4 ) {	elevel17	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[25]	 == 0 ) {	elevel14	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[25]	 == 1 ) {	elevel14	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[25]	 == 2 ) {	elevel14	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[25]	 == 3 ) {	elevel14	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[25]	 == 4 ) {	elevel14	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[26]	 == 0 ) {	elevel21	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[26]	 == 1 ) {	elevel21	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[26]	 == 2 ) {	elevel21	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[26]	 == 3 ) {	elevel21	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[26]	 == 4 ) {	elevel21	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[27]	 == 0 ) {	elevel11	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[27]	 == 1 ) {	elevel11	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[27]	 == 2 ) {	elevel11	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[27]	 == 3 ) {	elevel11	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[27]	 == 4 ) {	elevel11	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[28]	 == 0 ) {	elevel23	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[28]	 == 1 ) {	elevel23	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[28]	 == 2 ) {	elevel23	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[28]	 == 3 ) {	elevel23	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[28]	 == 4 ) {	elevel23	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[29]	 == 0 ) {	elevel15	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[29]	 == 1 ) {	elevel15	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[29]	 == 2 ) {	elevel15	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[29]	 == 3 ) {	elevel15	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[29]	 == 4 ) {	elevel15	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[30]	 == 0 ) {	elevel13	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[30]	 == 1 ) {	elevel13	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[30]	 == 2 ) {	elevel13	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[30]	 == 3 ) {	elevel13	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[30]	 == 4 ) {	elevel13	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[31]	 == 0 ) {	elevel12	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[31]	 == 1 ) {	elevel12	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[31]	 == 2 ) {	elevel12	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[31]	 == 3 ) {	elevel12	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[31]	 == 4 ) {	elevel12	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[32]	 == 0 ) {	elevel20	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[32]	 == 1 ) {	elevel20	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[32]	 == 2 ) {	elevel20	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[32]	 == 3 ) {	elevel20	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[32]	 == 4 ) {	elevel20	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[33]	 == 0 ) {	elevel19	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[33]	 == 1 ) {	elevel19	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[33]	 == 2 ) {	elevel19	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[33]	 == 3 ) {	elevel19	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[33]	 == 4 ) {	elevel19	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[34]	 == 0 ) {	elevel16	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[34]	 == 1 ) {	elevel16	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[34]	 == 2 ) {	elevel16	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[34]	 == 3 ) {	elevel16	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[34]	 == 4 ) {	elevel16	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[35]	 == 0 ) {	elevel22	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[35]	 == 1 ) {	elevel22	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[35]	 == 2 ) {	elevel22	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[35]	 == 3 ) {	elevel22	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[35]	 == 4 ) {	elevel22	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[36]	 == 0 ) {	elevel28	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[36]	 == 1 ) {	elevel28	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[36]	 == 2 ) {	elevel28	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[36]	 == 3 ) {	elevel28	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[36]	 == 4 ) {	elevel28	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[37]	 == 0 ) {	elevel24	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[37]	 == 1 ) {	elevel24	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[37]	 == 2 ) {	elevel24	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[37]	 == 3 ) {	elevel24	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[37]	 == 4 ) {	elevel24	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[38]	 == 0 ) {	elevel25	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[38]	 == 1 ) {	elevel25	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[38]	 == 2 ) {	elevel25	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[38]	 == 3 ) {	elevel25	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[38]	 == 4 ) {	elevel25	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[39]	 == 0 ) {	elevel18	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[39]	 == 1 ) {	elevel18	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[39]	 == 2 ) {	elevel18	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[39]	 == 3 ) {	elevel18	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[39]	 == 4 ) {	elevel18	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[40]	 == 0 ) {	elevel30	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[40]	 == 1 ) {	elevel30	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[40]	 == 2 ) {	elevel30	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[40]	 == 3 ) {	elevel30	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[40]	 == 4 ) {	elevel30	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[41]	 == 0 ) {	elevel29	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[41]	 == 1 ) {	elevel29	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[41]	 == 2 ) {	elevel29	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[41]	 == 3 ) {	elevel29	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[41]	 == 4 ) {	elevel29	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[42]	 == 0 ) {	elevel27	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[42]	 == 1 ) {	elevel27	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[42]	 == 2 ) {	elevel27	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[42]	 == 3 ) {	elevel27	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[42]	 == 4 ) {	elevel27	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[43]	 == 0 ) {	elevel26	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[43]	 == 1 ) {	elevel26	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[43]	 == 2 ) {	elevel26	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[43]	 == 3 ) {	elevel26	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[43]	 == 4 ) {	elevel26	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[44]	 == 0 ) {	elevel34	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[44]	 == 1 ) {	elevel34	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[44]	 == 2 ) {	elevel34	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[44]	 == 3 ) {	elevel34	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[44]	 == 4 ) {	elevel34	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[45]	 == 0 ) {	elevel33	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[45]	 == 1 ) {	elevel33	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[45]	 == 2 ) {	elevel33	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[45]	 == 3 ) {	elevel33	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[45]	 == 4 ) {	elevel33	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[46]	 == 0 ) {	elevel32	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[46]	 == 1 ) {	elevel32	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[46]	 == 2 ) {	elevel32	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[46]	 == 3 ) {	elevel32	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[46]	 == 4 ) {	elevel32	.setText(getString(R.string.enabler_s05));}
        if (enablerLvArray[47]	 == 0 ) {	elevel31	.setText(getString(R.string.enabler_s01));}	if (enablerLvArray[47]	 == 1 ) {	elevel31	.setText(getString(R.string.enabler_s02));}	if (enablerLvArray[47]	 == 2 ) {	elevel31	.setText(getString(R.string.enabler_s03));}	if (enablerLvArray[47]	 == 3 ) {	elevel31	.setText(getString(R.string.enabler_s04));}	if (enablerLvArray[47]	 == 4 ) {	elevel31	.setText(getString(R.string.enabler_s05));}

        //Toast.makeText(this, helper.DataName(), Toast.LENGTH_SHORT).show();
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener(){
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if (visibility == 0)
                    decorView.setSystemUiVisibility(hideSystemBars());

            }
        });
        cbg();
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

    public String prettyCount2(Number number) {
        char[] suffix = {' ', 'K', 'M', 'G', 'T', 'P', 'E', 'Z', 'Y'};
        long numValue = number.longValue();
        int value = (int) Math.floor(Math.log10(numValue));
        int base = value / 3;
        String plus = "";
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        int decimal_num = sharedPreferences.getInt("decimal_num", 0);
        boolean decimal  = sharedPreferences.getBoolean("decimal", false);
        if (numValue>0){plus = "+";}
        if (decimal == true){
            if (value >= 3 && base < suffix.length) {
                if (decimal_num == 0){
                    return plus+new DecimalFormat("##").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                if (decimal_num == 1){
                    return plus+new DecimalFormat("##.#").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                if (decimal_num == 2){
                    return plus+new DecimalFormat("##.##").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                if (decimal_num == 3){
                    return plus+new DecimalFormat("##.###").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                if (decimal_num == 4){
                    return plus+new DecimalFormat("##.####").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                if (decimal_num == 5){
                    return plus+new DecimalFormat("##.#####").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                // Muility
            } else {
                return plus+new DecimalFormat("#,###").format(numValue);
            }}
        return plus+new DecimalFormat("###,###,###,###,###").format(numValue);
    }

    public boolean isPermissionsAvaiable(String[] permissions)
    {
        for (String permission : permissions)
        {
            if (ActivityCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED)
            {
                return false;
            }
        }
        return true;
    }

    public boolean isExternalStoragePermissionsAvaiable()
    {
        String[] p = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        return isPermissionsAvaiable(p);
    }

    public boolean isSDCardWritable()
    {
        return isSDcardAvaiable() && isExternalStoragePermissionsAvaiable();
    }

    private boolean isSDcardAvaiable()
    {
        String sdCardState = Environment.getExternalStorageState();
        return sdCardState.equals(Environment.MEDIA_MOUNTED);
    }

    private boolean prepareDirectory(String path)
    {
        try {
            File file = new File(path);
            if (file.exists() && file.isDirectory())
            {
                return true;
            }
            else
            {
                boolean result = file.mkdirs();
                return result;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private String getDBDirectoryPath()
    {
        if (isSDCardWritable())
        {
            String directory =  fileDir;
            if (prepareDirectory(directory))
            {
                return directory;
            }
        }

        return null;
    }

    private JSONObject getSavedLoginDataJson()
    {
        String pathName = getDBDirectoryPath();
        if (pathName == null)
        {
            return null;
        }

        File path = new File(pathName);
        File file = new File(pathName + fileName);
        if (!path.exists() || !file.exists())
        {
            return null;
        }

        FileInputStream fin = null;
        try
        {
            fin = new FileInputStream(file);
            int length = fin.available();
            byte[] buffer = new byte[length];
            fin.read(buffer);
            String text = EncodingUtils.getString(buffer, "UTF-8");
            fin.close();

            JSONObject result = new JSONObject(text);
            UID = result.getLong("uid");
            //Log.i("UID_DATALIST", String.valueOf(UID));
            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent i = new Intent(DataEnablerActivity.this , DataListActivity.class);
            i.putExtra("UID",uid);
            SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("ppl", ppl);
            editor.apply();
            sleep = true ;
            finishAndRemoveTask();
            startActivity(i);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    private class TakeData extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Toast.makeText(DataListActivity.this,"Json Data is downloading",Toast.LENGTH_LONG).show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            String url = "http://vt.25u.com/vt/zgt/user.json";
            //Set URL from Zgirls Server
            url = "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid="; //未完成適配,2020.09.02-0912
            //http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=350893843000164 完成RSS , TROOPS適配,2020.09.08
            // UID
            url = url+UID;
            // Depends URL
            SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
            boolean input_json_list = sharedPreferences.getBoolean("input_json_list", true);


            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=311325387000015" lumi
            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=422204583000015" Awoken
            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=423362547000009" BULLET
            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=326125136000029" 寂靜夜影
            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=385084201000018" 时钟狂三
            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=610026094000009" Moonphilia
            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=350294313000015" Kristineee
            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=15261753000019" BkParade
            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=998621791000046" 《Innocent》
            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=9213185000015" ꧁cosmodnc꧂
            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=459643483000042" M16A1
            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=92903777000015" Golden~Yuria
            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=365391265000043" Golden_Yúrishima
            //  "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid=525907835000046" 7@rgaryen

            ppl = sharedPreferences.getString("ppl", "루미너스 - LUMI");

            String aa = "311325387000015" ;
            String b= "422204583000015" ;
            String cc = "350294313000015" ;
            String d = "15261753000019" ;
            String ee = "998621791000046" ;
            String f = "9213185000015" ;
            String g = "365391265000043" ;
            String h = "525907835000046" ;
            String ii = "24892075000008" ;

            if (ppl.matches("루미너스 - LUMI")) { uid = Long.parseLong(aa);}
            if (ppl.matches("Awoken mommaker")) { uid = Long.parseLong(b);}
            if (ppl.matches("Kristineee")) { uid = Long.parseLong(cc);}
            if (ppl.matches("BkParade")) { uid = Long.parseLong(d);}
            if (ppl.matches("《Innocent》")) { uid = Long.parseLong(ee);}
            if (ppl.matches("꧁cosmodnc꧂")) { uid = Long.parseLong(f);}
            if (ppl.matches("Golden_Yúrishima")) { uid = Long.parseLong(g);}
            if (ppl.matches("7@rgaryen")) { uid = Long.parseLong(h);}
            if (ppl.matches("MARCELO ALEXIS")) { uid = Long.parseLong(ii);}
            if (ppl.matches("Yourself")) { uid = UID;}
            if (ppl.matches("Custom")) { uid = UID2;}

            if (input_json_list == true){url = "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid="+uid;}
            else {
                url = "http://vt.25u.com/vt/zgt/user.json";
                sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("ppl", "DEMO");
                editor.apply();
            }if (ppl.matches("DEMO")) { url = "http://vt.25u.com/vt/zgt/user.json";}
            String jsonStr = sh.makeServiceCall(url);

            // Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray enablers = jsonObj.getJSONArray("heros");
                    // looping through All Contacts

                    for (int i = 0; i < enablers.length(); i++) {
                        JSONObject c = enablers.getJSONObject(i);
                        enablerName = c.getString("heroName");
                        enablerNameArray [i] = enablerName;
                        enablerLv = c.getInt("heroLv");
                        enablerLvArray [i] = enablerLv;
                    }
                    //     starArray[0] = Integer.parseInt(star_final.split(",")[0]);
                    //   starArray[1] = Integer.parseInt(star_final.split(",")[1]);
                    //    starArray[2] = Integer.parseInt(star_final.split(",")[2]);
                    //   starArray[3] = Integer.parseInt(star_final.split(",")[3]);




                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String url = "http://vt.25u.com/vt/zgt/user.json";
                            SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("ppl", "DEMO");
                            editor.apply();
                            //             Toast.makeText(getApplicationContext(),
                            //                    "Json parsing error: " + e.getMessage(),
                            //                    Toast.LENGTH_LONG).show();
                        }
                    });

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String url = "http://vt.25u.com/vt/zgt/user.json";
                        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("ppl", "DEMO");
                        editor.apply();
                        //    Toast.makeText(getApplicationContext(),
                        //            "Couldn't get json from server. Check LogCat for possible errors!",
                        //           Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Log.i("ENABLER_Grab","ok");
            dataRefresh();

        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        sleep = true ;
        finishAndRemoveTask();

    }

    private static final int DATA_REFRESH = 0;
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {

            switch (msg.what) {
                case DATA_REFRESH:
                    if (!sleep){
                        new TakeData().execute();
                    }
                    break;

                default:
                    break;
            }
        }

    };

}
