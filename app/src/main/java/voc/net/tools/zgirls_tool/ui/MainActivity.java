package voc.net.tools.zgirls_tool.ui;

import android.app.Activity;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import voc.net.tools.zgirls_tool.old_ui.EXPCActivity;
import voc.net.tools.zgirls_tool.old_ui.TBActivity;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.old_ui.TechActivity;
import voc.net.tools.zgirls_tool.old_ui.TroopsActivity;
import voc.net.tools.zgirls_tool.util.FileUtils;
import voc.net.tools.zgirls_tool.util.Information;
import voc.net.tools.zgirls_tool.util.InformationAdapter;
import voc.net.tools.zgirls_tool.R;
import voc.net.tools.zgirls_tool.util.ScreenSizeUtils;
import voc.net.tools.zgirls_tool.util.WindowUtils;

public class MainActivity extends AppCompatActivity {
    private static final int IMAGE = 1;
    private final static String TAG = "MainActivity";
    String TYPE;
    private final static String FileName = "background.png";
    private static String FROMPATH = "";
    private final static String TOPATH = Environment.getExternalStorageDirectory().getPath () + "/voc/zgt/background/";
    private final static String TOPATH_IMAGE = Environment.getExternalStorageDirectory().getPath () + "/voc/zgt/background/background.png";
    private final static String BACKUPPATH = Environment.getExternalStorageDirectory().getPath () + "/voc/zgt/backup/";
    private String url = "http://vt.25u.com/vt/zgt/info.json";//"http://cmthk.ddns.net:9513/hw/hw_list.json"; //"http://cmt.25u.com:9513/hw/hw_list.json"

    private RecyclerView mList;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<Information> informationList;
    private RecyclerView.Adapter adapter;
    private InformationAdapter mAdapter;
    ProgressDialog progressDialog;
    public String Name, Type, Date, Author, Link;
    public String date;
    //public LinearLayout building, deads, enabler, events, mecha, other, rss, rush_up, tech, troops;
    public LinearLayout school, enabler, events, mecha, troops, facilities;
    public Button reset_btn;
    public Button type_btn;
    public ImageView banner;
    public ImageView tutorial_char;
    public TableRow tb1, tb2;
    public LinearLayout lla, ll1, ll2;
    public TextView pause;
    public TextView tutorial_tv;

    public ImageView cir01,cir02,cir03,cir04,cir05,cir06,cir07,cir08,cir09;
    //  public TextView status, subjecy_TV;
    String DATE_SUB;
    boolean open_sub = false;
    boolean open_date = false;
    int banner_id = 1;

    String choose_code;

    // Defend Color
    String BASE_VALUE = "#1BB495";
    String BASE_PRESS_VALUE = "#3F9D94";
    String DARK_VALUE = "#424242";
    String DARK_PRESS_VALUE = "#202020";
    String PINK_VALUE = "#C70A50";
    String PINK_PRESS_VALUE = "#A90944";
    String LEEK_VALUE = "#2FBC57";
    String LEEK_PRESS_VALUE = "#267A2E";
    String SUMMER_VALUE = "#0A90E8";
    String SUMMER_PRESS_VALUE = "#19779F";
    String FINAL_VALUE = "#03DAC5";
    String FINAL_PRESS_VALUE = "#03DAC5";
    int code_num = 0;
    boolean license_ok = false;
    String license_stat = "deny";
    int license , tutorial = 0 ;

    String PRESSED = "";
    int touch = 0;

    private final static String StyleName = "style.txt";
    private final static String PATH = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mList = findViewById(R.id.main_list);

        /*

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //权限不足就需要去申请，上下文，需要申请的权限，请求码（唯一就行）
            ActivityCompat.requestPermissions(MainActivity.this
                    , new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            Toast.makeText(this, "Please restart Zgirls Tools", Toast.LENGTH_LONG).show();
            finish();
        } else {
            Log.i("Permission", "abled");
        }



        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        int result = FileUtils.createDir(path + "/voc/zgt");
        showResult(result);


        String path_final = Environment.getExternalStorageDirectory().getAbsolutePath();

        try {
            String fileName = "style.txt";
            //SD
            // String path3 = Environment.getExternalStorageDirectory().getAbsolutePath();
            InputStream inputStream = getAssets().open(fileName);
            //getFilesDir() 获得当前APP的安装路径 /data/data/包名/files 目录
            File file = new File(path + "/voc/zgt/" + fileName);
            if (!file.exists() || file.length() == 0) {
                FileOutputStream fos = new FileOutputStream(file);//如果文件不存在，FileOutputStream会自动创建文件
                int len = -1;
                byte[] buffer = new byte[1024];
                while ((len = inputStream.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
                fos.flush();//刷新缓存区
                inputStream.close();
                fos.close();
                Log.i("File", "style.txt copied");

            } else {
                Log.i("File", "style.txt have already");
            }
        } catch (IOException e) {
            e.printStackTrace();

        }

        try {
            String fileName = "license.txt";
            //SD
            // String path3 = Environment.getExternalStorageDirectory().getAbsolutePath();
            InputStream inputStream = getAssets().open(fileName);
            //getFilesDir() 获得当前APP的安装路径 /data/data/包名/files 目录
            File file = new File(path + "/voc/zgt/" + fileName);
            if (!file.exists() || file.length() == 0) {
                FileOutputStream fos = new FileOutputStream(file);//如果文件不存在，FileOutputStream会自动创建文件
                int len = -1;
                byte[] buffer = new byte[1024];
                while ((len = inputStream.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
                fos.flush();//刷新缓存区
                inputStream.close();
                fos.close();
                Log.i("File", "license.txt copied");

            } else {
                Log.i("File", "license.txt have already");
            }
        } catch (IOException e) {
            e.printStackTrace();

        }

        try {
            String fileName = "tutorial.txt";
            //SD
            // String path3 = Environment.getExternalStorageDirectory().getAbsolutePath();
            InputStream inputStream = getAssets().open(fileName);
            //getFilesDir() 获得当前APP的安装路径 /data/data/包名/files 目录
            File file = new File(path + "/voc/zgt/" + fileName);
            if (!file.exists() || file.length() == 0) {
                FileOutputStream fos = new FileOutputStream(file);//如果文件不存在，FileOutputStream会自动创建文件
                int len = -1;
                byte[] buffer = new byte[1024];
                while ((len = inputStream.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
                fos.flush();//刷新缓存区
                inputStream.close();
                fos.close();
                Log.i("File", "tutorial.txt copied");

            } else {
                Log.i("File", "tutorial.txt have already");
            }
        } catch (IOException e) {
            e.printStackTrace();

        }


        //build file
        int result10 = FileUtils.createDir(path + "/voc/zgt/database");
        showResult(result10);

        //db
        int result11 = FileUtils.CreateFile(path + "/voc/zgt/database/database.db");
        showResult(result11);

        try {
            String fileName = "database.db";
            //SD
            // String path3 = Environment.getExternalStorageDirectory().getAbsolutePath();
            InputStream inputStream = getAssets().open(fileName);
            //getFilesDir() 获得当前APP的安装路径 /data/data/包名/files 目录
            File file = new File(path + "/voc/zgt/database/" + fileName);
            if (!file.exists() || file.length() == 0) {
                FileOutputStream fos = new FileOutputStream(file);//如果文件不存在，FileOutputStream会自动创建文件
                int len = -1;
                byte[] buffer = new byte[1024];
                while ((len = inputStream.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
                fos.flush();//刷新缓存区
                inputStream.close();
                fos.close();
                Log.i("File", "database.db copied");

            } else {
                Log.i("File", "database.db have already");
            }
        } catch (IOException e) {
            e.printStackTrace();

        }

        //build file
        int result7 = FileUtils.createDir(path + "/voc/zgt/background");
        showResult(result7);

        //background
        int result5 = FileUtils.CreateFile(path + "/voc/zgt/background/background.png");
        showResult(result5);

        //backup
        //String path3 = Environment.getExternalStorageDirectory ().getAbsolutePath ();
        //int result3 = FileUtils.CreateFile(path3 + "/voc/pubggamer/tmp/backup/background.png");
        //showResult(result3);

        String path4 = Environment.getExternalStorageDirectory ().getAbsolutePath ();
        int result6 = FileUtils.createDir(path4 + "/voc/zgt/backup");
        showResult(result6);

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

        String style = readStyle();
        if (style == ""){code_num = 1;}else{
        code_num = Integer.parseInt(style.trim());
        Log.i("STYLE", String.valueOf(code_num));}

        String licenses = readStyle();
        if (licenses == ""){license = 0;}else{
        license = Integer.parseInt(readLicense().trim());
        Log.i("LICENSE", String.valueOf(license));}

        String tutorials = readStyle();
        if (tutorials == ""){tutorial = 0;}else{
        tutorial = Integer.parseInt(readTutorial().trim());
        Log.i("TUTORIAL", String.valueOf(tutorial));}

         */

        /**
         * New :
         * Troops , Event , School , Buildings , Enablers , Mecha
         */


        enabler = findViewById(R.id.enabler_ll);
        events = findViewById(R.id.events_ll);
        mecha = findViewById(R.id.mecha_ll);
        troops = findViewById(R.id.troop_ll);
        school = findViewById(R.id.school_ll);
        troops = findViewById(R.id.troop_ll);
        facilities = findViewById(R.id.facilities_ll);
        pause = findViewById(R.id.pause);

        cir01 = findViewById(R.id.cir01);

        tutorial_char = findViewById(R.id.tutorial);
        tutorial_tv = findViewById(R.id.tutorial_tv);

        reset_btn = findViewById(R.id.reset_btn);
        type_btn = findViewById(R.id.type_more);

        banner = findViewById(R.id.banner);

        tb1 = findViewById(R.id.tb1);
        tb2 = findViewById(R.id.tb2);

        lla = findViewById(R.id.lla);
        ll1 = findViewById(R.id.ll1);
        ll2 = findViewById(R.id.ll2);
        Log.i("Defind", "RLK");

        Random rng = new Random();
        int banner_id = (int) (Math.random() * 4);

        if (banner_id == 1) {
            banner.setImageResource(R.drawable.zg_banner_1);
        } else if (banner_id == 2) {
            banner.setImageResource(R.drawable.zg_banner_2);
        } else if (banner_id == 3) {
            banner.setImageResource(R.drawable.zg_banner_3);
        } else if (banner_id == 4) {
            banner.setImageResource(R.drawable.zg_banner_4);
        } else if (banner_id == 5) {
            banner.setImageResource(R.drawable.zg_banner_5);
        } else if (banner_id == 6) {
            banner.setImageResource(R.drawable.zg_banner_6);
        } else if (banner_id == 7) {
            banner.setImageResource(R.drawable.zg_banner_7);
        } else if (banner_id == 0) {
            banner.setImageResource(R.drawable.zg_banner_0);
        }

        reset_btn.setVisibility(View.GONE);
        progressDialog = new ProgressDialog(this);
        informationList = new ArrayList<>();
        mAdapter = new InformationAdapter(getApplicationContext(), informationList);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(), linearLayoutManager.getOrientation());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_all);
        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(mAdapter);
        okhttpDate();
        SharedPreferences sharedPreferences = this.getSharedPreferences("share", MODE_PRIVATE);


        EditText editText = findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
                TYPE = s.toString();
            }
        });
        cbg();
        BackgroundReload();
        //tut();
        //license();

    }
    public void BackgroundReload (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.bg2);
        Resources res = getResources();
        String fileNamePNG = "background.png";
        String fileNameGIF = "background.gif";
        String fileNameJPG = "background.jpg";
        String fileNameJPEG = "background.jpeg";
        String pathName = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/background/";

        /**
         * Way by https://codertw.com/android-%E9%96%8B%E7%99%BC/337488/
         */
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        newOpts.inSampleSize = 1;
        Bitmap bitmap = BitmapFactory.decodeFile(pathName+fileNamePNG,newOpts);
        BitmapDrawable bd = new BitmapDrawable(res, bitmap);

        Bitmap bitmap2 = BitmapFactory.decodeFile(pathName+fileNameJPG,newOpts);
        BitmapDrawable bd2 = new BitmapDrawable(res, bitmap2);

        Bitmap bitmap3 = BitmapFactory.decodeFile(pathName+fileNameJPEG,newOpts);
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

    public void cbg() {
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        //取出数据（注意这里直接用实例取就行了，不用获取编辑器editor）
        String theme = sharedPreferences.getString("theme", "dark");
        String color1 = sharedPreferences.getString("color1", "F1870F");
        String color2 = sharedPreferences.getString("color2", "C56E0D");
        if (theme.equals("base")) {
            //lla.setBackgroundColor(getResources().getColor(R.color.background_base));
            //ll1.setBackgroundColor(getResources().getColor(R.color.background_base));
            //ll2.setBackgroundColor(getResources().getColor(R.color.background_base));
          //  pause.setBackgroundColor(getResources().getColor(R.color.background_base_press));
            FINAL_VALUE = BASE_VALUE;
            FINAL_PRESS_VALUE = BASE_PRESS_VALUE;
        }

        if (theme.equals("dark")) {
           // lla.setBackgroundColor(getResources().getColor(R.color.background_dark));
           // ll1.setBackgroundColor(getResources().getColor(R.color.background_dark));
           // ll2.setBackgroundColor(getResources().getColor(R.color.background_dark));
         //   pause.setBackgroundColor(getResources().getColor(R.color.background_dark_press));
            FINAL_VALUE = DARK_VALUE;
            FINAL_PRESS_VALUE = DARK_PRESS_VALUE;
        }

        if (theme.equals("pink")) {
           // lla.setBackgroundColor(getResources().getColor(R.color.background_pink));
           // ll1.setBackgroundColor(getResources().getColor(R.color.background_pink));
           // ll2.setBackgroundColor(getResources().getColor(R.color.background_pink));
          //  pause.setBackgroundColor(getResources().getColor(R.color.background_pink_press));
            FINAL_VALUE = PINK_VALUE;
            FINAL_PRESS_VALUE = PINK_PRESS_VALUE;
        }

        if (theme.equals("leek")) {
          //  lla.setBackgroundColor(getResources().getColor(R.color.background_leek));
          //  ll1.setBackgroundColor(getResources().getColor(R.color.background_leek));
          //  ll2.setBackgroundColor(getResources().getColor(R.color.background_leek));
         //   pause.setBackgroundColor(getResources().getColor(R.color.background_leek_press));
            FINAL_VALUE = LEEK_VALUE;
            FINAL_PRESS_VALUE = LEEK_PRESS_VALUE;
        }

        if (theme.equals("summer")) {
          //  lla.setBackgroundColor(getResources().getColor(R.color.background_summer));
          //  ll1.setBackgroundColor(getResources().getColor(R.color.background_summer));
          //  ll2.setBackgroundColor(getResources().getColor(R.color.background_summer));
           // pause.setBackgroundColor(getResources().getColor(R.color.background_summer_press));
            FINAL_VALUE = SUMMER_VALUE;
            FINAL_PRESS_VALUE = SUMMER_PRESS_VALUE;
        }
        if (theme.equals("custom")) {
         //   lla.setBackgroundColor(Color.parseColor("#"+color1));
         //   ll1.setBackgroundColor(Color.parseColor("#"+color1));
          //  ll2.setBackgroundColor(Color.parseColor("#"+color1));
         //   pause.setBackgroundColor(Color.parseColor("#"+color2));
            FINAL_VALUE = SUMMER_VALUE;
            FINAL_PRESS_VALUE = SUMMER_PRESS_VALUE;
        }
    }

    public void tut (){
        // TUTORIAL START
        if (tutorial == 0){
            tutorial_char.setVisibility(View.VISIBLE);
            tutorial_tv.setVisibility(View.VISIBLE);
            tutorial_tv.setText(R.string.tut_1);
        }
        else {
            LinearLayout tut_ll = findViewById(R.id.tutorial_ll);
            tut_ll.setVisibility(View.GONE);
            tutorial_char.setVisibility(View.GONE);
            tutorial_tv.setVisibility(View.GONE);
        }

    }


    public void windowButton(View view) {
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void notifyButton(View view) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(2);
        Notification.Builder builder = new Notification.Builder(this);
        Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, mIntent, 0);
        builder.setContentIntent(pendingIntent);
        builder.setWhen(System.currentTimeMillis());
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        builder.setAutoCancel(true);
        builder.setContentTitle("悬挂式通知");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //设置点击跳转
            Intent hangIntent = new Intent();
            hangIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            hangIntent.setClass(this, MainActivity.class);
            //如果描述的PendingIntent已经存在，则在产生新的Intent之前会先取消掉当前的
            PendingIntent hangPendingIntent = PendingIntent.getActivity(this, 0, hangIntent, PendingIntent.FLAG_CANCEL_CURRENT);
            builder.setFullScreenIntent(hangPendingIntent, true);
        }
        notificationManager.notify(2, builder.build());
    }

    private void filter(String text) {
        ArrayList<Information> filteredList = new ArrayList<>();

        for (Information item : informationList) {
            if (item.getName().toLowerCase().contains(text.toLowerCase()) | item.getDate().toLowerCase().contains(text.toLowerCase()) | item.getType().toLowerCase().contains(text.toLowerCase()) | item.getAuthor().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        mAdapter.filterList(filteredList);
    }

    /**
     * 回调的权限请求结果，是否同意都会调用
     *
     * @param requestCode  请求码
     * @param permissions  申请的权限
     * @param grantResults 结果
     */
    @Override
    public void onRequestPermissionsResult(int requestCode
            , @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.i("Permission", "abled");
            } else {
                Log.i("Permission", "failed");
            }
        }
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

    private void okhttpDate() {
        progressDialog.setMessage("載入中......");
        progressDialog.show();
        // version = android.os.Build.VERSION.SDK_INT;
        Log.i("TAG", "--ok-");
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url(url).build();
                try {
                    Response sponse = client.newCall(request).execute();
                    date = sponse.body().string();
                    //解析
                    jsonJXDate(date);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }

    private void jsonJXDate(String date) {
        if (date != null) {
            try {
                JSONArray array = new JSONArray(date);
                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);
                    Name = object.getString("name");
                    Type = object.getString("type");
                    Date = object.getString("date");
                    Author = object.getString("author");
                    Link = object.getString("link");


                    Information Information = new Information();
                    Information.setName(object.getString("name"));
                    Information.setType(object.getString("type"));
                    Information.setDate(object.getString("date"));
                    Information.setAuthor(object.getString("author"));
                    Information.setLink(object.getString("link"));
                    informationList.add(Information);

                }
                //    progressDialog.dismiss();

                Message msg = new Message();
                msg.what = 1;
                handler.sendMessage(msg);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    //添加分割线
                    mList.addItemDecoration(new DividerItemDecoration(
                            MainActivity.this, DividerItemDecoration.VERTICAL));
                    //设置布局显示格式
                    mList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    mList.setAdapter(mAdapter);
                    progressDialog.dismiss();
                    String ITEM_SIZE = String.valueOf(informationList.size());
                    //Toast.makeText(MainActivity.this, "共有" + ITEM_SIZE + "條", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    public void school(View view) {
        ArrayList<Information> filteredList = new ArrayList<>();
        for (Information item : informationList) {
            if (item.getType().toLowerCase().equals("school")) {
                filteredList.add(item);
            }
        }
        PRESSED = "school";
        /*
        school.setBackgroundColor(Color.parseColor(FINAL_PRESS_VALUE));
        enabler.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        mecha.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        events.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        troops.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        facilities.setBackgroundColor(Color.parseColor(FINAL_VALUE));

         */

        reset_btn.setVisibility(View.VISIBLE);
        mAdapter.filterList(filteredList);
    }

    public void enabler(View view) {
        ArrayList<Information> filteredList = new ArrayList<>();
        for (Information item : informationList) {
            if (item.getType().toLowerCase().equals("enabler")) {
                filteredList.add(item);
            }
        }
        PRESSED = "enabler";
        /*
        enabler.setBackgroundColor(Color.parseColor(FINAL_PRESS_VALUE));
        school.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        mecha.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        events.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        troops.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        facilities.setBackgroundColor(Color.parseColor(FINAL_VALUE));
         */

        reset_btn.setVisibility(View.VISIBLE);
        mAdapter.filterList(filteredList);
    }

    public void mecha(View view) {
        ArrayList<Information> filteredList = new ArrayList<>();
        for (Information item : informationList) {
            if (item.getType().toLowerCase().equals("mecha")) {
                filteredList.add(item);
            }
        }
        PRESSED = "mecha";
        /*
        mecha.setBackgroundColor(Color.parseColor(FINAL_PRESS_VALUE));
        enabler.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        school.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        events.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        troops.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        facilities.setBackgroundColor(Color.parseColor(FINAL_VALUE));

         */

        reset_btn.setVisibility(View.VISIBLE);
        mAdapter.filterList(filteredList);
    }

    public void events(View view) {
        ArrayList<Information> filteredList = new ArrayList<>();
        for (Information item : informationList) {
            if (item.getType().toLowerCase().equals("events")) {
                filteredList.add(item);
            }
        }
        PRESSED = "events";
        /*
        events.setBackgroundColor(Color.parseColor(FINAL_PRESS_VALUE));
        enabler.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        mecha.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        school.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        troops.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        facilities.setBackgroundColor(Color.parseColor(FINAL_VALUE));

         */


        reset_btn.setVisibility(View.VISIBLE);
        mAdapter.filterList(filteredList);
    }

    public void troops(View view) {
        ArrayList<Information> filteredList = new ArrayList<>();
        for (Information item : informationList) {
            if (item.getType().toLowerCase().equals("troops")) {
                filteredList.add(item);
            }
        }
        PRESSED = "troops";
        /*
        troops.setBackgroundColor(Color.parseColor(FINAL_PRESS_VALUE));
        enabler.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        mecha.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        events.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        facilities.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        school.setBackgroundColor(Color.parseColor(FINAL_VALUE));

         */


        reset_btn.setVisibility(View.VISIBLE);
        mAdapter.filterList(filteredList);
    }

    public void facilities(View view) {
        ArrayList<Information> filteredList = new ArrayList<>();
        for (Information item : informationList) {
            if (item.getType().toLowerCase().equals("facilities")) {
                filteredList.add(item);
            }
        }
        PRESSED = "facilities";
        /*
        troops.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        enabler.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        mecha.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        events.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        facilities.setBackgroundColor(Color.parseColor(FINAL_PRESS_VALUE));
        school.setBackgroundColor(Color.parseColor(FINAL_VALUE));

         */
        reset_btn.setVisibility(View.VISIBLE);
        mAdapter.filterList(filteredList);
    }

    public void reset(View view) {
        ArrayList<Information> filteredList = new ArrayList<>();
        for (Information item : informationList) {
            item.getType().toLowerCase();
            filteredList.add(item);
        }
        PRESSED = "";

        /*
        enabler.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        mecha.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        events.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        troops.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        facilities.setBackgroundColor(Color.parseColor(FINAL_VALUE));
        school.setBackgroundColor(Color.parseColor(FINAL_VALUE));

         */

        reset_btn.setVisibility(View.GONE);
        mAdapter.filterList(filteredList);

    }

    public void sub_more(View view) {
        if (!open_sub) {
            open_date = false;
            /*
            building.setVisibility(View.VISIBLE);
            enabler.setVisibility(View.VISIBLE);
            mecha.setVisibility(View.VISIBLE);
            events.setVisibility(View.VISIBLE);
            other.setVisibility(View.VISIBLE);
            rss.setVisibility(View.VISIBLE);
            rush_up.setVisibility(View.VISIBLE);
            tech.setVisibility(View.VISIBLE);
            troops.setVisibility(View.VISIBLE);
            */
            tb1.setVisibility(View.VISIBLE);
            tb2.setVisibility(View.VISIBLE);
            type_btn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_unfold_less_black_24dp, 0, 0, 0);
            open_sub = true;
        } else {
            open_date = false;
            /*
            building.setVisibility(View.GONE);
            enabler.setVisibility(View.GONE);
            mecha.setVisibility(View.GONE);
            events.setVisibility(View.GONE);
            other.setVisibility(View.GONE);
            rss.setVisibility(View.GONE);
            rush_up.setVisibility(View.GONE);
            tech.setVisibility(View.GONE);
            troops.setVisibility(View.GONE);

             */
            tb1.setVisibility(View.GONE);
            tb2.setVisibility(View.GONE);

            type_btn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_unfold_more_black_24dp, 0, 0, 0);
            open_sub = false;
        }
    }

    private String generateNameString(int lenght) {
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-+~".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < lenght; i++) {
            char c = chars[random.nextInt(chars.length)];
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public void license() {
        if (license == 0) {
            license_ok = false;
            Log.i("LICENSE_STAT", "REALLY DENY");
            AlertDialog.Builder builder = new AlertDialog.Builder(
                    MainActivity.this);
            builder.setTitle("License") // 标题
                    .setIcon(R.drawable.app_icon_round)
                    .setCancelable(false)
                    .setMessage("This work is licensed under the Creative Commons Attribution 4.0 International License.\nTo view a copy of this license, visit\n http://creativecommons.org/licenses/by/4.0/");
            builder.setPositiveButton(
                    "Accept",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            license_ok = true;
                            license_stat = "1";
                            File file = new File(MainActivity.this.getFilesDir(), "text");
                            Log.i("File", "Gotted");
                            if (!file.exists()) {
                                file.mkdir();
                            }
                            try {
                                FileOutputStream overWrite = new FileOutputStream(PATH + "/license.txt", false);
                                overWrite.write(license_stat.getBytes());
                                Log.i("File", license_stat);
                                overWrite.flush();
                                overWrite.close();
                            } catch (Exception e) {
                            }
                        }
                    });

            builder.setNegativeButton(
                    "Deny",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            license_ok = false;
                            license_stat = "0";
                            finish();
                        }
                    });
            builder.setNeutralButton("Read Full license",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.chrome");
                            launchIntent.setData(Uri.parse("http://creativecommons.org/licenses/by/4.0/"));
                            startActivity(launchIntent);//null pointer check in case package name was not found

                        }
                    });
            AlertDialog alert11 = builder.create();
            alert11.show();
        } else {
            Log.i("LICENSE", "CHECKED");
        }
    }

    private String readStyle() {
        String style = "";
        File myExternalFile = new File(PATH, "style.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;
            while ((strLine = br.readLine()) != null) {
                style = style + strLine + "\n";
            }
            br.close();
            in.close();
            fis.close();
            Log.i("style", style);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return style;

    }

    private String readLicense() {
        String license = "";
        File myExternalFile = new File(PATH, "license.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;
            while ((strLine = br.readLine()) != null) {
                license = license + strLine + "\n";
            }
            br.close();
            in.close();
            fis.close();
            Log.i("license", license);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return license;

    }

    private String readTutorial() {
        String tutorial = "";
        File myExternalFile = new File(PATH, "tutorial.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;
            while ((strLine = br.readLine()) != null) {
                tutorial = tutorial + strLine + "\n";
            }
            br.close();
            in.close();
            fis.close();
            Log.i("tutorial", tutorial);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tutorial;

    }

    public void tut_next(View view) {
        if (touch == 0) {
            tutorial_tv.setText(R.string.tut_2);
            touch ++ ;
        }
        else if (touch == 1) {
            tutorial_tv.setText(R.string.tut_3);
            touch ++ ;
        }
        else if (touch == 2) {
            tutorial_tv.setText(R.string.tut_4);
            touch ++ ;
        }
        else if (touch == 3) {
            tutorial_tv.setText(R.string.tut_5);
            touch ++ ;
        }
        else if (touch == 4) {
            tutorial_tv.setText(R.string.tut_6);
            touch ++ ;
        }
        else if (touch == 5) {
            tutorial_tv.setText(R.string.tut_7);
            touch ++ ;
        }
        else if (touch == 6) {
            tutorial_tv.setText(R.string.tut_8);
            touch ++ ;
        }
        else if (touch == 7) {
            tutorial_tv.setText(R.string.tut_9);
            touch ++ ;
        }
        else if (touch == 8) {
            tutorial_tv.setText(R.string.tut_10);
            touch ++ ;
        }
        else if (touch == 9) {
            tutorial_tv.setText(R.string.tut_11);
            touch ++ ;
        }
        else if (touch == 10) {
            tutorial_tv.setText(R.string.tut_12);
            touch ++ ;
        }
        else if (touch == 11) {
            tutorial_tv.setText(R.string.tut_13);
            tutorial = 1;
            Button nxt = findViewById(R.id.tut_btn);
            nxt.setText("End");
            LinearLayout tut_ll = findViewById(R.id.tutorial_ll);
            tut_ll.setVisibility(View.GONE);
            String charlie = String.valueOf(tutorial);
            File file = new File(MainActivity.this.getFilesDir(), "text");
            Log.i("File", "Gotted");
            if (!file.exists()) {
                file.mkdir();
            }
            try {
                FileOutputStream overWrite = new FileOutputStream(PATH + "/tutorial.txt", false);
                overWrite.write(charlie.getBytes());
                Log.i("File", charlie);
                overWrite.flush();
                overWrite.close();
            } catch (Exception e) {
            }
            touch ++ ;
        }else if (touch == 13) {
            LinearLayout tut_ll = findViewById(R.id.tutorial_ll);
            tut_ll.setVisibility(View.GONE);
        }
    }

    public void navi(View view) {
        final Dialog dialog = new Dialog(this, R.style.NormalDialogStyle_D);
        view = View.inflate(this, R.layout.navi_down, null);
        //TextView dc_server = view.findViewById(R.id.dc_server);
        TextView a = view.findViewById(R.id.a);
        TextView b = view.findViewById(R.id.b);
        TextView c = view.findViewById(R.id.c);
        TextView d = view.findViewById(R.id.d);
        TextView e = view.findViewById(R.id.e);
        TextView f = view.findViewById(R.id.f);
        TextView g = view.findViewById(R.id.g);
        TextView h = view.findViewById(R.id.h);
        TextView i = view.findViewById(R.id.i);
        TextView j = view.findViewById(R.id.j);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        //view.setMinimumHeight((int) (ScreenSizeUtils.getInstance(this).getScreenHeight()));
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int) (ScreenSizeUtils.getInstance(this).getScreenWidth());
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.BOTTOM;
        dialogWindow.setAttributes(lp);
        dialog.show();
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent();
                //將原本Activity的換成MainActivity
                intent.setClass(MainActivity.this, TBActivity.class);
                startActivity(intent);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent();
                //將原本Activity的換成MainActivity
                intent.setClass(MainActivity.this, TroopsActivity.class);
                startActivity(intent);
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent();
                //將原本Activity的換成MainActivity
                intent.setClass(MainActivity.this, EXPActivity.class);
                startActivity(intent);
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent();
                //將原本Activity的換成MainActivity
                intent.setClass(MainActivity.this, MechaActivity.class);
                startActivity(intent);
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent();
                //將原本Activity的換成MainActivity
                intent.setClass(MainActivity.this, EventActivity.class);
                startActivity(intent);
            }
        });
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent();
                //將原本Activity的換成MainActivity
                intent.setClass(MainActivity.this, EXPCActivity.class);
                startActivity(intent);
            }
        });
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent();
                //將原本Activity的換成MainActivity
                intent.setClass(MainActivity.this, TechActivity.class);
                startActivity(intent);

            }
        });
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, IMAGE);
            }
        });
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    Context context = v.getContext();
                    if(!Settings.canDrawOverlays(context)){
                        Toast.makeText(context, "can not DrawOverlays", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + MainActivity.this.getPackageName()));
                        startActivityForResult(intent, 1);
                    } else {
                        WindowUtils.showPopupWindow(context);
                    }
                }else{
                    Log.i("FF","RR");
                }
            }
        });
        j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent();
                //將原本Activity的換成MainActivity
                intent.setClass(MainActivity.this, DataListActivity.class);
                startActivity(intent);
            }
        });
       // dc_server.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View v) {
        //                Toast.makeText(MainActivity.this, "Link Copied !", Toast.LENGTH_SHORT).show();
        //                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        //                ClipData clipData = ClipData.newPlainText(null, "https://discord.gg/mB8AbbG");
        //                clipboard.setPrimaryClip(clipData);
            //}
        //});
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 16384){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!Settings.canDrawOverlays(this)) {
                    Toast.makeText(this, "Permission Denieddd by user.Please Check it in Settings", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permission Allowed", Toast.LENGTH_SHORT).show();
                    WindowUtils.showPopupWindow(this);
                }
            }
        }

        //获取图片路径
        if (requestCode == IMAGE && resultCode == Activity.RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            String[] filePathColumns = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePathColumns[0]);
            String imagePath = c.getString(columnIndex);
            // FROMPATH = imagePath;

            File file = new File(TOPATH_IMAGE);
            copyFile(file, BACKUPPATH);
            Log.e("BACKPATH", "CHECK");
            File file2 = new File(imagePath); // 此处为伪代码，实际为一个真实存在的文件，即你想复制的文件。/
            copyFile(file2, TOPATH);
            Intent intent = new Intent(MainActivity.this, BackgroundPreviewActivity.class);
            startActivity(intent);
            c.close();
        }
    }

    public boolean copyFile(File src, String destPath) {
        boolean result = false;
        if ((src == null) || (destPath == null)) {
            return result;
        }
        File dest = new File(destPath + FileName);
        if (dest != null && dest.exists()) {
            dest.delete(); // delete file
        }
        try {
            dest.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileChannel srcChannel = null;
        FileChannel dstChannel = null;

        try {
            srcChannel = new FileInputStream(src).getChannel();
            dstChannel = new FileOutputStream(dest).getChannel();
            srcChannel.transferTo(0, srcChannel.size(), dstChannel);
            result = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return result;
        }
        try {
            srcChannel.close();
            dstChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}