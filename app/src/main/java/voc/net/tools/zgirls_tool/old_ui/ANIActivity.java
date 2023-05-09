package voc.net.tools.zgirls_tool.old_ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.ui.DataListActivity;
import voc.net.tools.zgirls_tool.util.FileUtils;
import voc.net.tools.zgirls_tool.R;

public class ANIActivity extends AppCompatActivity {
    private static final int IMAGE = 1;
    private final static String TAG = "MainActivity";
    private final static String FileName = "background.png";
    private static String FROMPATH = "";
    CardView tool_card , aim_card;
    TextView tool_tv , aim_tv ;
    long uid ;
    SharedPreferences sharedPreferences;
    private ProgressDialog pd;
    int file_size = 100 ;
    int zipped_size = 0 ;
    private String downloadpath;
    private String localversion;
    float progress_final = 0 ;
    String VersionName ;
    long UID ;
    private final static String PATH = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt";
    private final static String TOPATH = Environment.getExternalStorageDirectory().getPath () + "/voc/zgt/background/";
    private final static String TOPATH_IMAGE = Environment.getExternalStorageDirectory().getPath () + "/voc/zgt/background/background.png";
    private final static String BACKUPPATH = Environment.getExternalStorageDirectory().getPath () + "/voc/zgt/backup/";
    private final static String DOWNLOADPATH = Environment.getExternalStorageDirectory().getPath () + "/download/zgt_update.apk";
    private final static String DOWNLOADPATHFILE = Environment.getExternalStorageDirectory().getPath () + "/download";
    private final static String DOWNLOADENABLERSPATH = Environment.getExternalStorageDirectory().getPath () + "/voc/zgt/enablers";
    private String url = "http://vt.25u.com/vt/zgt/info.json";//"http://cmthk.ddns.net:9513/hw/hw_list.json"; //"http://cmt.25u.com:9513/hw/hw_list.json"
    String DataBaseFile = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/database/database.db";
    //Zgirls UID Store Area
    private static final String fileName = "user_session";
    private static final String fileDir = Environment.getExternalStorageDirectory().getPath() +"/data/data/com.xingjoys.zgirls.app/config/";
    private static final int ERROR = 2;
    private static final int SHOW_UPDATE_DIALOG = 1;
    private static final int SHOW_TEST_DIALOG = 3;
    RadioButton lumi , awoken , kristin , Bk , Inno, cosmodnc, yuria, seven, marce, you , custom;
    String ppl ;
    EditText color1_et ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ani);
        tool_card = findViewById(R.id.tool_card);
        aim_card = findViewById(R.id.aim_card);
        tool_tv = findViewById(R.id.tool_tv);
        aim_tv = findViewById(R.id.aim_tv);

        sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);

        String path = Environment.getExternalStorageDirectory().getAbsolutePath();

        lumi = findViewById(R.id.radioButtonA);
        awoken = findViewById(R.id.radioButtonB);
        kristin = findViewById(R.id.radioButtonC);
        Bk = findViewById(R.id.radioButtonD);
        Inno = findViewById(R.id.radioButtonE);
        cosmodnc = findViewById(R.id.radioCustomF);
        yuria = findViewById(R.id.radioCustomG);
        seven = findViewById(R.id.radioCustomH);
        marce = findViewById(R.id.radioCustomI);
        you = findViewById(R.id.radioCustomJ);
        custom = findViewById(R.id.radioCustomK);

        color1_et = findViewById(R.id.color1_et);
        cbg();

        //TEST

        try {
            String fileName = "background.png";
            //SD
            // String path3 = Environment.getExternalStorageDirectory().getAbsolutePath();
            InputStream inputStream = getAssets().open(fileName);
            //getFilesDir() 获得当前APP的安装路径 /data/data/包名/files 目录
            File file = new File(path + "/voc/zgt/background/"+ fileName);
            if(!file.exists() || file.length()==0) {
                FileOutputStream fos =new FileOutputStream(file);//如果文件不存在，FileOutputStream会自动创建文件
                int len=-1;
                byte[] buffer = new byte[1024];
                while ((len=inputStream.read(buffer))!=-1){
                    fos.write(buffer,0,len);
                }
                fos.flush();//刷新缓存区
                inputStream.close();
                fos.close();
                Log.i ("File","background.png備份复制完毕");

            } else {
                Log.i ("File","background.png備份已存在，无需复制");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        BackgroundReload();

        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        //取出数据（注意这里直接用实例取就行了，不用获取编辑器editor）
        String ppl = sharedPreferences.getString("ppl", "루미너스 - LUMI");
        UID = sharedPreferences.getLong("uid2", 0);

        if (ppl.equals("루미너스 - LUMI")){ lumi.setChecked(true); }
        if (ppl.equals("Awoken mommaker")){ awoken.setChecked(true); }
        if (ppl.equals("Kristineee")){ kristin.setChecked(true); }
        if (ppl.equals("BkParade")){ Bk.setChecked(true); }
        if (ppl.equals("《Innocent》")){ Inno.setChecked(true); }
        if (ppl.equals("꧁cosmodnc꧂")){ cosmodnc.setChecked(true); }
        if (ppl.equals("Golden_Yúrishima")){ yuria.setChecked(true); }
        if (ppl.equals("7@rgaryen")){ seven.setChecked(true); }
        if (ppl.equals("MARCELO ALEXIS")){ marce.setChecked(true); }
        if (ppl.equals("Yourself")){ you.setChecked(true); }
        if (ppl.equals("Custom")){ custom.setChecked(true); }

        color1_et.setText(String.valueOf(UID));

        uid = UID ;

    }
    public void BackgroundReload (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.ani_bg);

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
    public void ingame_tool (View view){
        save();
        String Zgirls_Low_Ver = "";
        PackageInfo pinfo = null;
        try {
            pinfo = this.getPackageManager().getPackageInfo( "com.xingjoys.zgirls.gp", 0 );
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String verName = ""; int verCode ;
        if (pinfo == null ){verCode = 1;}else {
            verName = pinfo.versionName;
            verCode = pinfo.versionCode;
        }
        if (verCode < 31460) {
            Zgirls_Low_Ver = "\n"+getString(R.string.zgirls_ver_error01)+verCode+ "\n"+getString(R.string.zgirls_ver_error02);

            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setTitle(getString(R.string.zgirls_ver_error03));
            builder1.setMessage(getString(R.string.zgirls_ver_error04)+"\n"+getString(R.string.zgirls_ver_error05)+"\n"+getString(R.string.zgirls_ver_error06_2));
            builder1.setIcon(R.drawable.app_icon_round);

            builder1.setPositiveButton(
                    getString(R.string.install_now),
                    new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                            i.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.xingjoys.zgirls.gp"));
                            startActivity(i);
                        }
                    });

            builder1.setNegativeButton(
                    getString(R.string.continue_btn),
                    new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            Intent i = new Intent(ANIActivity.this, DataListActivity.class);
                            i.putExtra("UID",UID);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("ppl", ppl);
                            editor.apply();
                            startActivity(i);
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
        }


        else{
            Intent intent1 = new Intent(ANIActivity.this,DataListActivity.class);
            intent1.putExtra("UID",UID);
            intent1.putExtra("ppl",ppl);
            startActivity(intent1);}
    }

    public String prettyCount(Number number) {
        String[] suffix = {"B", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"};
        long numValue = number.longValue();
        int value = (int) Math.floor(Math.log10(numValue));
        int base = value / 3;
        boolean decimal = true;
        int decimal_num = 2;
        return new DecimalFormat("##.##").format(numValue / Math.pow(10, base * 3)) + suffix[(int) base];
        // Muility

    }

    private void showResult(int result) {
        switch (result) {
            case FileUtils.FLAG_SUCCESS:
                Log.i("File", "Create success");
                break;
            case FileUtils.FLAG_EXISTS:
                Log.i("File", "Already exist");
                break;
            case FileUtils.FLAG_FAILED:
                Log.i("File", "Create failed");
                break;
        }
    }
    public void save (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        //获取操作SharedPreferences实例的编辑器（必须通过此种方式添加数据）
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //添加数据
        ppl = "";
        UID = Long.parseLong(color1_et.getText().toString());
        if (lumi.isChecked()){ ppl = "루미너스 - LUMI"; }
        if (awoken.isChecked()){ ppl ="Awoken mommaker"; }
        if (kristin.isChecked()){ ppl = "Kristineee"; }
        if (Bk.isChecked()){ ppl ="BkParade"; }
        if (Inno.isChecked()){ ppl = "《Innocent》"; }
        if (cosmodnc.isChecked()){ ppl = "꧁cosmodnc꧂"; }
        if (yuria.isChecked()){ ppl = "Golden_Yúrishima"; }
        if (seven.isChecked()){ ppl = "7@rgaryen"; }
        if (marce.isChecked()){ ppl = "MARCELO ALEXIS"; }
        if (you.isChecked()){ ppl = "Yourself"; }
        if (custom.isChecked()){ ppl = "Custom"; }

        editor.putLong("uid2", UID);
        editor.putString("ppl", ppl);
        editor.apply();
    }
    public void custom_show (View view){
        LinearLayout custom = findViewById(R.id.custom);
        custom.setVisibility(View.VISIBLE);
    }
    public void cbg() {
        //取出数据（注意这里直接用实例取就行了，不用获取编辑器editor）
        String theme = sharedPreferences.getString("theme", "dark");
        String color1 = sharedPreferences.getString("color1", "F1870F");
        String color2 = sharedPreferences.getString("color2", "C56E0D");
        if (theme.equals("base")) {
            aim_card.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            aim_tv.setBackgroundColor(getResources().getColor(R.color.background_base_press));
            tool_card.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            tool_tv.setBackgroundColor(getResources().getColor(R.color.background_base_press));
        }

        if (theme.equals("dark")) {
            aim_card.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            aim_tv.setBackgroundColor(getResources().getColor(R.color.background_dark_press));
            tool_card.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            tool_tv.setBackgroundColor(getResources().getColor(R.color.background_dark_press));
        }

        if (theme.equals("pink")) {
            aim_card.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            aim_tv.setBackgroundColor(getResources().getColor(R.color.background_pink_press));
            tool_card.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            tool_tv.setBackgroundColor(getResources().getColor(R.color.background_pink_press));
        }

        if (theme.equals("leek")) {
            aim_card.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            aim_tv.setBackgroundColor(getResources().getColor(R.color.background_leek_press));
            tool_card.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            tool_tv.setBackgroundColor(getResources().getColor(R.color.background_leek_press));
        }

        if (theme.equals("summer")) {
            aim_card.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            aim_tv.setBackgroundColor(getResources().getColor(R.color.background_summer_press));
            tool_card.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            tool_tv.setBackgroundColor(getResources().getColor(R.color.background_summer_press));
        }

        if (theme.equals("custom")) {
            aim_card.setCardBackgroundColor(Color.parseColor("#99"+color1));
            aim_tv.setBackgroundColor(Color.parseColor("#"+color2));
            tool_card.setCardBackgroundColor(Color.parseColor("#99"+color1));
            tool_tv.setBackgroundColor(Color.parseColor("#"+color2));
        }
    }
}