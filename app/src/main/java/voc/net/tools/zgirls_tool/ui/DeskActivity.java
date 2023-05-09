package voc.net.tools.zgirls_tool.ui;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.app.DownloadManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.PathInterpolator;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.core.os.ConfigurationCompat;

import com.ljoy.chatbot.sdk.ELvaChatServiceSdk;
import com.squareup.picasso.Picasso;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;

import org.apache.http.util.EncodingUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.R;
import voc.net.tools.zgirls_tool.billing.IabHelper;
import voc.net.tools.zgirls_tool.billing.IabResult;
import voc.net.tools.zgirls_tool.billing.Inventory;
import voc.net.tools.zgirls_tool.billing.Purchase;
import voc.net.tools.zgirls_tool.billing.SkuDetails;
import voc.net.tools.zgirls_tool.old_ui.ANIActivity;
import voc.net.tools.zgirls_tool.old_ui.EXPCActivity;
import voc.net.tools.zgirls_tool.old_ui.EnablersLotteryActivity;
import voc.net.tools.zgirls_tool.old_ui.EquipmentLotteryActivity;
import voc.net.tools.zgirls_tool.old_ui.TBActivity;
import voc.net.tools.zgirls_tool.util.FileUtils;
import voc.net.tools.zgirls_tool.util.HttpHandler;
import voc.net.tools.zgirls_tool.util.LoginToApp;
import voc.net.tools.zgirls_tool.util.PackageInfoUtils;
import voc.net.tools.zgirls_tool.util.ScreenSizeUtils;
import voc.net.tools.zgirls_tool.util.StreamTools;
import voc.net.tools.zgirls_tool.util.WindowUtils;

public class DeskActivity extends AppCompatActivity {

    private static final int IMAGE = 2048;
    private final static String TAG = "DeskActivity";
    private static String FileName = "background";
    private static String FROMPATH = "";
    private final static String TOPATH = Environment.getExternalStorageDirectory().getPath () + "/voc/zgt/background/";
    private static String TOPATH_IMAGE = Environment.getExternalStorageDirectory().getPath () + "/voc/zgt/background/";
    private static String PATH_GUIDE = "storage/emulated/0/voc/zgt/guide/";
    private static String PATH_TPS_SAVE = "storage/emulated/0/voc/zgt/troops/";
    private final static String TOPATH_TMP = Environment.getExternalStorageDirectory().getPath () + "/voc/zgt/background_tmp/";
    private final static String BACKUPPATH = Environment.getExternalStorageDirectory().getPath () + "/voc/zgt/backup/";
    private static String BACKUP_IMAGE = Environment.getExternalStorageDirectory().getPath () + "/voc/zgt/backup/";
    private final static String DOWNLOADPATH = Environment.getExternalStorageDirectory().getPath () + "/download/zgt_update.apk";
    private final static String DOWNLOADPATHFILE = Environment.getExternalStorageDirectory().getPath () + "/download";
    private final static String DOWNLOADENABLERSPATH = Environment.getExternalStorageDirectory().getPath () + "/voc/zgt/enablers";
    private String url = "http://vt.25u.com/vt/zgt/info.json";//"http://cmthk.ddns.net:9513/hw/hw_list.json"; //"http://cmt.25u.com:9513/hw/hw_list.json"
    String DataBaseFile = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/database/database.db";
    public static final String CHANNEL_ID = "ZGT_UPDATE";
    static String ITEM_SKU = "donate_hkd_0008";
    public ImageView banner;
    int code_num = 0;
    int file_size = 100 ;
    int zipped_size = 0 ;
    boolean license_ok = false;
    String license_stat = "deny";
    String download_stat = "false";
    int license , tutorial , download = 0 ;
    //private String downloadpath;
    private static final int ERROR = 2;
    private static final int SHOW_UPDATE_DIALOG = 1;
    private static final int SHOW_TEST_DIALOG = 3;
    private String localversion;
    private ProgressDialog pd;
    float progress_final = 0 ;
    String DataBasePath = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/database";
    String path_test , path_final ;
    long uid ;
    String verifyCode ;
    String BASE_VALUE = "#CC1BB495";
    String BASE_PRESS_VALUE = "#3F9D94";
    String DARK_VALUE = "#CC646464";
    String DARK_PRESS_VALUE = "#424242";
    String PINK_VALUE = "#CCC70A50";
    String PINK_PRESS_VALUE = "#A90944";
    String LEEK_VALUE = "#CC2FBC57";
    String LEEK_PRESS_VALUE = "#267A2E";
    String SUMMER_VALUE = "#CC0A90E8";
    String SUMMER_PRESS_VALUE = "#19779F";
    String FINAL_VALUE = "#CC0A90E8";
    String FINAL_PRESS_VALUE = "#19779F";
    ImageView ANI_btn;
    TextView ANI ;


    CardView cal_card , tool_card , lottery_card,know_card ;
    TextView cal_tv , tool_tv , lottery_tv,know_tv ;

    private final static String StyleName = "style.txt";
    private final static String PATH = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt";

    private static final int MX = FrameLayout.LayoutParams.MATCH_PARENT;
    private static final int MY = FrameLayout.LayoutParams.MATCH_PARENT;
    private View decorView;
    Drawable platlogo;
    FrameLayout mLayout , mStick;
    int mTapCount;
    public static final String EGG_MODE = "egg_mode";
    int mKeyCount;
    private DeskActivity mActivity;
    PathInterpolator mInterpolator = new PathInterpolator(0f, 0f, 0.5f, 1f);
    SharedPreferences sharedPreferences;

    String[] enablers = {"saki","fudo","masami","carol","uzuki","sara","sariko","chika","kirine","hiyori","mio","izumi","gin","nana","sumika","kayo","youko","saori","comet","donner","minami","chen","eleanor","zero","ana_o","odelia","zrs_2","liuk","akiyama","esther","alice","yesi","shiori","misaki","risa","mika","mira","raly","celesia","chiyo","kurul","kuroda","catherine","shirley","lois","iris","sylvia","narumi"};

    String[] urls = {"http://vt.25u.com/vt/zgt/enabler_full/saki.png","http://vt.25u.com/vt/zgt/enabler_full/fudo.png","http://vt.25u.com/vt/zgt/enabler_full/masami.png","http://vt.25u.com/vt/zgt/enabler_full/carol.png","http://vt.25u.com/vt/zgt/enabler_full/uzuki.png","http://vt.25u.com/vt/zgt/enabler_full/sara.png","http://vt.25u.com/vt/zgt/enabler_full/sariko.png","http://vt.25u.com/vt/zgt/enabler_full/chika.png","http://vt.25u.com/vt/zgt/enabler_full/kirine.png","http://vt.25u.com/vt/zgt/enabler_full/hiyori.png","http://vt.25u.com/vt/zgt/enabler_full/mio.png","http://vt.25u.com/vt/zgt/enabler_full/izumi.png","http://vt.25u.com/vt/zgt/enabler_full/gin.png","http://vt.25u.com/vt/zgt/enabler_full/nana.png","http://vt.25u.com/vt/zgt/enabler_full/sumika.png","http://vt.25u.com/vt/zgt/enabler_full/kayo.png","http://vt.25u.com/vt/zgt/enabler_full/youko.png","http://vt.25u.com/vt/zgt/enabler_full/saori.png","http://vt.25u.com/vt/zgt/enabler_full/comet.png","http://vt.25u.com/vt/zgt/enabler_full/donner.png","http://vt.25u.com/vt/zgt/enabler_full/minami.png","http://vt.25u.com/vt/zgt/enabler_full/chen.png","http://vt.25u.com/vt/zgt/enabler_full/eleanor.png","http://vt.25u.com/vt/zgt/enabler_full/zero.png","http://vt.25u.com/vt/zgt/enabler_full/ana_o.png","http://vt.25u.com/vt/zgt/enabler_full/odelia.png","http://vt.25u.com/vt/zgt/enabler_full/zrs_2.png","http://vt.25u.com/vt/zgt/enabler_full/liuk.png","http://vt.25u.com/vt/zgt/enabler_full/akiyama.png","http://vt.25u.com/vt/zgt/enabler_full/esther.png","http://vt.25u.com/vt/zgt/enabler_full/alice.png","http://vt.25u.com/vt/zgt/enabler_full/yesi.png","http://vt.25u.com/vt/zgt/enabler_full/shiori.png","http://vt.25u.com/vt/zgt/enabler_full/misaki.png","http://vt.25u.com/vt/zgt/enabler_full/risa.png","http://vt.25u.com/vt/zgt/enabler_full/mika.png","http://vt.25u.com/vt/zgt/enabler_full/mira.png","http://vt.25u.com/vt/zgt/enabler_full/raly.png","http://vt.25u.com/vt/zgt/enabler_full/celesia.png","http://vt.25u.com/vt/zgt/enabler_full/chiyo.png","http://vt.25u.com/vt/zgt/enabler_full/kurul.png","http://vt.25u.com/vt/zgt/enabler_full/kuroda.png","http://vt.25u.com/vt/zgt/enabler_full/catherine.png","http://vt.25u.com/vt/zgt/enabler_full/shirley.png","http://vt.25u.com/vt/zgt/enabler_full/lois.png","http://vt.25u.com/vt/zgt/enabler_full/iris.png","http://vt.25u.com/vt/zgt/enabler_full/sylvia.png","http://vt.25u.com/vt/zgt/enabler_full/narumi.png"};

    //Zgirls UID Store Area
    private static final String fileName = "user_session";
    private static final String fileDir = Environment.getExternalStorageDirectory().getPath() +"/data/data/com.xingjoys.zgirls.app/config/";
    String[] skus = new String[16];
    //Google Play Billing
    String base64EncodedPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArAs5FIxFlqGIOCelXoUTQBzX8pTV+Y2HU5IWNSvQRX8IE4XdgCzs9FPKVbjQIBRJ/EKPjM0cRQ50+QpVTiC0tYloKF9cTZWrmOiaDinWVsT/kvN21E1MVtE7ahv9krH3E2WC2K2GAw+je5LMUxHDBFcnIkZL/hY3EQlekYdYseqDwDDY4AlLkUDJOMtPS9mR0/X1JL4uBuH8AJZLB95p2OHi625iuKlQ0NjAgHU56TPXVD5DJdmEdRsFIO/n6JMz0vUthPj7KuRQ7EXqR1+QQI7pjBSU12fQIhKcFgSVEDgGNHFoxvd2dpnxPlwQuAHrF9GWw0KjTIEvmGZGV/DdrQIDAQAB";
    IabHelper mHelper;
    String Donate_price = "";
    List additionalSkuList = new ArrayList();
    String VersionName ;
    boolean version_c = true ;
    String sku_1 , sku_2 , sku_3 , sku_4 , sku_5 , sku_6 , sku_7 ;

    /**
     *  1.0.10 Update's new Poster System
     *  Will add more layout if necessary
     */
    long version = 0 ;
    long post_date_unix = 0 ; // Accoding to https://www.unixtimestamp.com/index.php , Device must divide 1000
    String pressed_url = "";
    String image_url = "";
    String image_name = "";
    long layout_num = 0 ;

    private IabHelper.QueryInventoryFinishedListener mGotInventoryListener = new IabHelper.QueryInventoryFinishedListener() {
        @Override
        public void onQueryInventoryFinished(IabResult result, Inventory inv) {
            //have we been disposed of in the meantime? if so, quit
            if (mHelper == null) return;

            //is it a failure?
            if(result.isFailure()) {
                Log.i("ERROR","Failed to query Inventory: " + result);
                return;
            }


            //  if (inv.getSkuDetails("donate_8").getPrice() != null){sku_1 = inv.getSkuDetails("donate_8").getPrice();}
              /*
            if (inv.getSkuDetails("donate_hkd_0008").getPrice() != null){sku_1 = inv.getSkuDetails("donate_hkd_0008").getPrice();}
            if (inv.getSkuDetails("donate_hkd_0010").getPrice() != null){sku_2 = inv.getSkuDetails("donate_hkd_0010").getPrice();}
            if (inv.getSkuDetails("donate_hkd_0020").getPrice() != null){sku_3 = inv.getSkuDetails("donate_hkd_0020").getPrice();}
            if (inv.getSkuDetails("donate_hkd_0050").getPrice() != null){sku_4 = inv.getSkuDetails("donate_hkd_0050").getPrice();}
            if (inv.getSkuDetails("donate_hkd_0100").getPrice() != null){sku_5 = inv.getSkuDetails("donate_hkd_0100").getPrice();}
            if (inv.getSkuDetails("donate_hkd_0150").getPrice() != null){sku_6 = inv.getSkuDetails("donate_hkd_0150").getPrice();}
            if (inv.getSkuDetails("donate_hkd_0200").getPrice() != null){sku_7 = inv.getSkuDetails("donate_hkd_0200").getPrice();}


             */
            SkuDetails details1 = inv.getSkuDetails("donate_hkd_0008");if (details1 == null) { return; };
            SkuDetails details2 = inv.getSkuDetails("donate_hkd_0010");if (details2 == null) { return; };
            SkuDetails details3 = inv.getSkuDetails("donate_hkd_0020");if (details3 == null) { return; };
            SkuDetails details4 = inv.getSkuDetails("donate_hkd_0050");if (details4 == null) { return; };
            SkuDetails details5 = inv.getSkuDetails("donate_hkd_0100");if (details5 == null) { return; };
            SkuDetails details6 = inv.getSkuDetails("donate_hkd_0150");if (details6 == null) { return; };
            SkuDetails details7 = inv.getSkuDetails("donate_hkd_0200");if (details7 == null) { return; };
            sku_1 = details1.getPrice();
            sku_2 = details2.getPrice();
            sku_3 = details3.getPrice();
            sku_4 = details4.getPrice();
            sku_5 = details5.getPrice();
            sku_6 = details6.getPrice();
            sku_7 = details7.getPrice();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_desk);
        sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        boolean auto_show = sharedPreferences.getBoolean("auto_show", true);

        getSavedLoginDataJson();

        cal_card = findViewById(R.id.cal_card);
        tool_card = findViewById(R.id.tool_card);
        lottery_card = findViewById(R.id.lottery_card);
        cal_tv = findViewById(R.id.cal_tv);
        tool_tv = findViewById(R.id.tool_tv);
        lottery_tv = findViewById(R.id.lottery_tv);
        know_tv = findViewById(R.id.know_tv);
        know_card = findViewById(R.id.team_card1);

        ANI = findViewById(R.id.tool_ani_tv);
        ANI_btn = findViewById(R.id.tool_ani_img);

        ELvaChatServiceSdk.init(this,
                "XECTORDAHK_app_0084f09adc3345c4b816cfa938eda692",
                "XectordaHK.aihelp.net",
                "XectordaHK_platform_05056a2b-45e4-4d60-9dbb-b955a5ca6b2f");

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();

        StrictMode.setVmPolicy(builder.build());
        StrictMode.setVmPolicy(builder.build());

        builder.detectFileUriExposure();
        rnd();
        String mProductId;
        String mPurchaseToken;
        String mDeveloperPayload;
        String code = "4/4wGcnQzi-VlUrmTUQ0L3AGVaKWaS0kSwFY39J-6-Qui4ZjTS1jwakQQ";//9.9号生成
        String accessToken;
        String refreshToken = "1//0ekM1lPy73Q1rCgYIARAAGA4SNwF-L9Ir8jNl4VLaO0f4W8hNVPSdCb5Vfe-Cx4MZas04NeuWm9Q__K7OPD5WbbskwPzGPUYECXs  ";//9.9号生成
        String client_secret = "7GT2qOgf9qmTqQTdt4G6Ymqp";
        String client_id = "934892266055-mrcj8nmdr15fmmg5h35bv4b02925601f.apps.googleusercontent.com";
        String redirect_uris = "urn:ietf:wg:oauth:2.0:oob";
        String purchaseId;

        boolean ani_2 = sharedPreferences.getBoolean("ANI_SHOW",false);
        if (ani_2){ANI.setVisibility(View.VISIBLE);ANI_btn.setVisibility(View.VISIBLE);}else{ANI.setVisibility(View.GONE);ANI_btn.setVisibility(View.GONE);}
        //Toast.makeText(this, "uid : "+String.valueOf(uid), Toast.LENGTH_SHORT).show();

        String pathX = Environment.getExternalStorageDirectory ().getAbsolutePath ();
        int resultX = FileUtils.createDir(pathX + "/voc/zgt/background_tmp/");
        showResult(resultX);

        String pathG = Environment.getExternalStorageDirectory ().getAbsolutePath ();
        int resultG = FileUtils.createDir(pathG + "/voc/zgt/guide/");
        showResult(resultG);

        String pathH = Environment.getExternalStorageDirectory ().getAbsolutePath ();
        int resultH = FileUtils.createDir(pathH + "/voc/zgt/troops/");
        showResult(resultH);

        String pathI = Environment.getExternalStorageDirectory ().getAbsolutePath ();
        int resultI = FileUtils.createDir(pathI + "/voc/zgt/tech/");
        showResult(resultI);

        String pathY = Environment.getExternalStorageDirectory ().getAbsolutePath ();
        int resultY = FileUtils.CreateFile(pathY + "/voc/zgt/background_tmp/background.png");
        showResult(resultY);

        String path_lotteryE = Environment.getExternalStorageDirectory().getAbsolutePath();
        int resultE = FileUtils.createDir(path_lotteryE + "/voc/zgt/enablers");
        showResult(resultE);

        String path_lotteryF = Environment.getExternalStorageDirectory().getAbsolutePath();
        int resultF = FileUtils.createDir(path_lotteryF + "/voc/zgt/lottery");
        showResult(resultF);

        String path_lottery = Environment.getExternalStorageDirectory().getAbsolutePath();
        int result = FileUtils.CreateFile(path_lottery + "/voc/zgt/lottery/lottery.db");
        showResult(result);

        String path_guide = Environment.getExternalStorageDirectory().getAbsolutePath();
        int resultHK = FileUtils.CreateFile(path_lottery + "/voc/zgt/guide/guide_hk.html");
        showResult(resultHK);

        int resultCN = FileUtils.CreateFile(path_lottery + "/voc/zgt/guide/guide_cn.html");
        showResult(resultCN);

        int resultEN = FileUtils.CreateFile(path_lottery + "/voc/zgt/guide/guide_en.html");
        showResult(resultEN);

        try {
            String fileName = "lottery.db";
            //SD
            // String path3 = Environment.getExternalStorageDirectory().getAbsolutePath();
            InputStream inputStream = getAssets().open(fileName);
            //getFilesDir() 获得当前APP的安装路径 /data/data/包名/files 目录
            File file = new File(path_lottery + "/voc/zgt/lottery/" + fileName);
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
                Log.i("File", "lottery.db copied");

            } else {
                Log.i("File", "lottery.db have already");
            }
        } catch (IOException e) {
            e.printStackTrace();

        }

        try {
            String fileName = "guide_en.html";
            //SD
            // String path3 = Environment.getExternalStorageDirectory().getAbsolutePath();
            InputStream inputStream = getAssets().open(fileName);
            //getFilesDir() 获得当前APP的安装路径 /data/data/包名/files 目录
            File file = new File(PATH_GUIDE + fileName);
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
                Log.i("File", fileName+" copied");

            } else {
                Log.i("File", fileName+" have already");
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        try {
            String fileName = "guide_hk.html";
            //SD
            // String path3 = Environment.getExternalStorageDirectory().getAbsolutePath();
            InputStream inputStream = getAssets().open(fileName);
            //getFilesDir() 获得当前APP的安装路径 /data/data/包名/files 目录
            File file = new File(PATH_GUIDE + fileName);
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
                Log.i("File", fileName+" copied");

            } else {
                Log.i("File", fileName+" have already");
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        try {
            String fileName = "guide_cn.html";
            //SD
            // String path3 = Environment.getExternalStorageDirectory().getAbsolutePath();
            InputStream inputStream = getAssets().open(fileName);
            //getFilesDir() 获得当前APP的安装路径 /data/data/包名/files 目录
            File file = new File(PATH_GUIDE + fileName);
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
                Log.i("File", fileName+" copied");

            } else {
                Log.i("File", fileName+" have already");
            }
        } catch (IOException e) {
            e.printStackTrace();

        }

        deleteFiles(DataBasePath);
        //build file
        String path_db = Environment.getExternalStorageDirectory().getAbsolutePath();
        int result10 = FileUtils.createDir(path_db + "/voc/zgt/database");
        showResult(result10);
        // new Thread(new DownladDBFromServer()).start();

        // CookieJarImpl cookieJar = new CookieJarImpl(new PersistentCookieStore(getApplicationContext()));
        // OkHttpClient okHttpClient = new OkHttpClient.Builder()
        //         .cookieJar(cookieJar)
//其他配置
        //          .build();
        //   OkHttpUtils.initClient(okHttpClient);
        localversion = PackageInfoUtils.getLocalVersionNumber(this);
        if (auto_show == true){
            mHandler.sendEmptyMessageDelayed(UPDATE_CHECK, 100);}
        else {Log.i("Auto","Nothing");}

        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        int resultL = FileUtils.createDir(path + "/voc/zgt");
        showResult(resultL);


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
            String fileName = "download.txt";
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
                Log.i("File", "download.txt copied");

            } else {
                Log.i("File", "download.txt have already");
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
        int result3 = FileUtils.createDir(path + "/voc/zgt/background_tmp/");
        showResult(result3);

        int result4 = FileUtils.CreateFile(path + "/voc/zgt/background_tmp/background.png");
        showResult(result4);

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

        try {
            String fileName = "background.png";
            //SD
            // String path3 = Environment.getExternalStorageDirectory().getAbsolutePath();
            InputStream inputStream = getAssets().open(fileName);
            //getFilesDir() 获得当前APP的安装路径 /data/data/包名/files 目录
            File file = new File(path + "/voc/zgt/background_tmp/"+ fileName);
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

        //String style = readStyle();
        // if (style == ""){code_num = 1;}else{
        //    code_num = Integer.parseInt(style.trim());
        //    Log.i("STYLE", String.valueOf(code_num));}

        String licenses = readStyle();
        if (licenses == ""){license = 0;}else{
            license = Integer.parseInt(readLicense().trim());
            Log.i("LICENSE", String.valueOf(license));}

        String tutorials = readTutorial();
        if (tutorials == ""){tutorial = 0;}else{
            tutorial = Integer.parseInt(readTutorial().trim());
            Log.i("TUTORIAL", String.valueOf(tutorial));}

        banner = findViewById(R.id.banner);

        java.util.Random rng = new Random();
        int banner_id = (int) (Math.random() * 25);

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
        } else if (banner_id == 8) {
            banner.setImageResource(R.drawable.zg_banner_8);
        } else if (banner_id == 9) {
            banner.setImageResource(R.drawable.zg_banner_9);
        } else if (banner_id == 10) {
            banner.setImageResource(R.drawable.zg_banner_10);
        } else if (banner_id == 11) {
            banner.setImageResource(R.drawable.zg_banner_11);
        } else if (banner_id == 12) {
            banner.setImageResource(R.drawable.zg_banner_12);
        } else if (banner_id == 13) {
            banner.setImageResource(R.drawable.zg_banner_13);
        } else if (banner_id == 14) {
            banner.setImageResource(R.drawable.zg_banner_14);
        } else if (banner_id == 15) {
            banner.setImageResource(R.drawable.zg_banner_15);
        } else if (banner_id == 16) {
            banner.setImageResource(R.drawable.zg_banner_16);
        } else if (banner_id == 17) {
            banner.setImageResource(R.drawable.zg_banner_17);
        } else if (banner_id == 18) {
            banner.setImageResource(R.drawable.zg_banner_18);
        } else if (banner_id == 19) {
            banner.setImageResource(R.drawable.zg_banner_19);
        } else if (banner_id == 20) {
            banner.setImageResource(R.drawable.zg_banner_20);
        } else if (banner_id == 21) {
            banner.setImageResource(R.drawable.zg_banner_21);
        } else if (banner_id == 22) {
            banner.setImageResource(R.drawable.zg_banner_22);
        } else if (banner_id == 23) {
            banner.setImageResource(R.drawable.zg_banner_23);
        } else if (banner_id == 24) {
            banner.setImageResource(R.drawable.zg_banner_24);
        } else if (banner_id == 25) {
            banner.setImageResource(R.drawable.zg_banner_25);
        } else if (banner_id == 0) {
            banner.setImageResource(R.drawable.zg_banner_0);
        }
        Date Festival = new Date();
        // getMonth -> 0 - 11
        // December
        if (Festival.getMonth() == 11){
            if (Festival.getDate() == 25) {
                //Merry Christmas
                banner.setImageResource(R.drawable.zg_banner_24);
            }
        }
        license();

        BackgroundReload();

        //EATSER EGG
        ImageView easter = findViewById(R.id.tool_egg_img);
        TextView easter_tv = findViewById(R.id.tool_egg_tv);
        int easter_id = 1 ;//(int) (Math.random() * 4);
        if (easter_id == 1) {
            easter.setVisibility(View.VISIBLE);
            easter_tv.setVisibility(View.VISIBLE);
        } else if (easter_id == 2) {
            easter.setVisibility(View.INVISIBLE);
            easter_tv.setVisibility(View.INVISIBLE);
        } else if (easter_id == 3) {
            easter.setVisibility(View.INVISIBLE);
            easter_tv.setVisibility(View.INVISIBLE);
        } else if (easter_id == 4) {
            easter.setVisibility(View.INVISIBLE);
            easter_tv.setVisibility(View.INVISIBLE);
        }else if (easter_id == 0) {
            easter.setVisibility(View.VISIBLE);
            easter_tv.setVisibility(View.VISIBLE);
        }
        mLayout = findViewById(R.id.easter_egg );
        mActivity = this;
        //  mLayout.setBackground(bd);
        cbg();

        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        //取出数据（注意这里直接用实例取就行了，不用获取编辑器editor）
        int start_time_count = sharedPreferences.getInt("start_time", 0);
        if (start_time_count == 0){thanks();}
        start_time_count = start_time_count+1;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //添加数据
        editor.putInt("start_time", start_time_count);
        editor.apply();

        /**
        try {
            isConnected();
            if (!isConnected()){Log.i("Network" , "Can't go to vt.25u.com");
                Toast.makeText(this, "Error Code 1001", Toast.LENGTH_SHORT).show();}
            if (isConnected()){
               // Toast.makeText(this, "ping ok", Toast.LENGTH_SHORT).show();
                Locale locale;
                locale = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration()).get(0);
                locale.getDisplayCountry();
                if (locale != Locale.CHINA){
                mHandler.sendEmptyMessageDelayed(POSTER_CHECK, 100);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
         */
    }
    public boolean isConnected() throws InterruptedException, IOException {
        String command = "ping -c 1 vt.25u.com";
        return Runtime.getRuntime().exec(command).waitFor() == 0;
    }


    public void BackgroundReload (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.bg);
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

    public void license() {
        if (license == 0) {
            license_ok = false;
            Log.i("LICENSE_STAT", "REALLY DENY");
            AlertDialog.Builder builder = new AlertDialog.Builder(
                    DeskActivity.this);
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
                            File file = new File(DeskActivity.this.getFilesDir(), "text");
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

    private String readDownload() {
        String download = "";
        File myExternalFile = new File(PATH, "download.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;
            while ((strLine = br.readLine()) != null) {
                download = download + strLine + "\n";
            }
            br.close();
            in.close();
            fis.close();
            Log.i("download", download);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return download;

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


        IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener
                = new IabHelper.OnIabPurchaseFinishedListener() {
            public void onIabPurchaseFinished(IabResult result,
                                              Purchase purchase)
            {
                if (result.isFailure()) {
                    // 에러 처리 코드
                    return;
                }
                else if (purchase.getSku().equals(ITEM_SKU)) {
                    consumeItem();
                }

            }

        };

        //获取图片路径
        if (requestCode == IMAGE && resultCode == Activity.RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            String[] filePathColumns = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePathColumns[0]);
            String imagePath = c.getString(columnIndex);
            // FROMPATH = imagePath;
            SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
            String gif_png = sharedPreferences.getString("gif/png", "png");
            SharedPreferences.Editor editor3 = sharedPreferences.edit();
            editor3.putString("last_gif/png", gif_png);
            editor3.apply();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            if (gif_png.matches("gif")){FileName = "background.gif";}
            if (gif_png.matches("png")){FileName = "background.png";}
            if (gif_png.matches("jpg")){FileName = "background.jpg";}
            if (gif_png.matches("jpeg")){FileName = "background.jpeg";}
            File file = new File(TOPATH_IMAGE+FileName);
            String fileExt2 = getFileExtension(file);
            fileExt2 =  fileExt2.toLowerCase();
            if (fileExt2.matches("gif")){FileName = "background.gif";}
            if (fileExt2.matches("png")){FileName = "background.png";}
            if (fileExt2.matches("jpg")){FileName = "background.jpg";}
            if (fileExt2.matches("jpeg")){FileName = "background.jpeg";}
            Log.i("gif/png", fileExt2);
            File fileX = new File(BACKUP_IMAGE+FileName);
            if (file.length() != fileX.length()){
                copyFile(file, BACKUPPATH+FileName);
                Log.e("BACKPATH", "CHECK");
            }else {Log.e("BACKPATH", "SAME !");}
            File file2 = new File(imagePath); // 此处为伪代码，实际为一个真实存在的文件，即你想复制的文件。/
            String fileExt = getFileExtension(file2);
            editor.putString("gif/png", fileExt);
            editor.apply();
            Log.i("gif/png", fileExt);
            String gif_png2 = sharedPreferences.getString("gif/png", "png");
            if (gif_png2.matches("gif")){FileName = "background.gif";}
            if (gif_png2.matches("png")){FileName = "background.png";}
            if (gif_png2.matches("jpg")){FileName = "background.jpg";}
            if (gif_png2.matches("jpeg")){FileName = "background.jpeg";}
            copyFile(file2, TOPATH_TMP+FileName);
            Intent intent = new Intent(DeskActivity.this, BackgroundPreviewActivity.class);
            startActivity(intent);
            c.close();
        }
        cbg();
    }

    public void consumeItem() {
        mHelper.queryInventoryAsync(mReceivedInventoryListener);
        AlertDialog.Builder builder = new AlertDialog.Builder(
                DeskActivity.this);
        builder.setTitle(getString(R.string.donate_you_have)+Donate_price) // 标题
                .setIcon(R.drawable.app_icon_round)
                .setCancelable(false)
                .setMessage(getString(R.string.donate_thx));
        builder.setPositiveButton(
                "😄",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert11 = builder.create();
        alert11.show();
    }
    IabHelper.QueryInventoryFinishedListener mReceivedInventoryListener
            = new IabHelper.QueryInventoryFinishedListener() {
        public void onQueryInventoryFinished(IabResult result,
                                             Inventory inventory) {

            if (result.isFailure()) {
                // 에러 처리 코드
            } else {
                mHelper.consumeAsync(inventory.getPurchase(ITEM_SKU),
                        mConsumeFinishedListener);
            }
        }
    };

    IabHelper.OnConsumeFinishedListener mConsumeFinishedListener =
            new IabHelper.OnConsumeFinishedListener() {
                public void onConsumeFinished(Purchase purchase,
                                              IabResult result) {

                    if (result.isSuccess()) {
                        Log.i("AK","OK");
                    } else {
                        // 에러 처리 코드
                        Log.i("AK","NOPE");
                    }
                }
            };


    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }

    public boolean copyFile(File src, String destPath) {
        boolean result = false;
        if ((src == null) || (destPath == null)) {
            return result;
        }
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        if (gif_png.matches("gif")){FileName = "background.gif";}
        if (gif_png.matches("png")){FileName = "background.png";}
        if (gif_png.matches("jpg")){FileName = "background.jpg";}
        if (gif_png.matches("jpeg")){FileName = "background.jpeg";}
        File dest = new File(destPath);
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
    public void tb_cal (View view){
        Intent intent = new Intent(this, TBActivity.class);
        startActivity(intent);
    }
    public void troop_cal (View view){
        Intent intent = new Intent(this, NewTroopsActivity.class);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        startActivity(intent);
    }
    public void exp_cal (View view){
        Intent intent = new Intent(this, EXPActivity.class);
        startActivity(intent);
    }
    public void mecha_cal (View view){
        Intent intent = new Intent(this, MechaActivity.class);
        startActivity(intent);
    }
    public void event_cal (View view){
        Intent intent = new Intent(this, EventActivity.class);
        startActivity(intent);
    }
    public void expc_cal (View view){
        Intent intent = new Intent(this, EXPCActivity.class);
        startActivity(intent);
    }
    public void tech_cal (View view){
        Intent intent = new Intent(this, NewTechActivity.class);
        startActivity(intent);
    }
    public void kizuna_cal (View view){
        Intent intent = new Intent(this, KizunaActivity.class);
        startActivity(intent);
    }

    public void star_cal (View view){
        Intent intent = new Intent(this, StarActivity.class);
        startActivity(intent);
    }

    public void building_cal (View view){
        Intent intent = new Intent(this, BuildingActivity.class);
        startActivity(intent);
    }
    public void mecha_e_cal (View view){
        Intent intent = new Intent(this, MechaEquipmentActivity.class);
        startActivity(intent);
    }
    public void legendary_cal (View view){
        Intent intent = new Intent(this, LegendaryActivity.class);
        startActivity(intent);
    }
    public void suit_cal (View view){
        Intent intent = new Intent(this, SuitActivity.class);
        startActivity(intent);
    }
    public void battery_cal (View view){
        Intent intent = new Intent(this, BatteryActivity.class);
        startActivity(intent);
    }

    public void blood_stone (View view){
        Toast.makeText(mActivity, "下一個測試版加入,等下哈", Toast.LENGTH_SHORT).show();
        /**
        Intent intent = new Intent(this, Blood_Stone.class);
        startActivity(intent);
         */
    }

    public void cal_building_lvl (View view){
        wifi(4);
    }

    //-------------------

    public void bg_tool (View view){
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, IMAGE);
    }
    public void float_tool (View view){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(!Settings.canDrawOverlays(this)){
                Toast.makeText(this, "can not DrawOverlays", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + DeskActivity.this.getPackageName()));
                startActivityForResult(intent, 1);
            } else {
                WindowUtils.showPopupWindow(this);
            }
        }else{
            Log.i("FF","RR");
        }
    }
    public void ingame_tool (View view){
        String Zgirls_Low_Ver = "";
        PackageInfo pinfo_gp = null;
        PackageInfo pinfo_gm = null;

        Log.i("UID+PASSWORD", "UID : "+String.valueOf(uid)+" , PSW : "+verifyCode);
        try {
            pinfo_gp = this.getPackageManager().getPackageInfo( "com.xingjoys.zgirls.gp", 0 );
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        try {
            pinfo_gm = this.getPackageManager().getPackageInfo( "com.xingjoys.zgirls.gm", 0 );
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String verName = ""; int verCode ;
        if (pinfo_gp == null ){
            if (pinfo_gm == null){
                verCode = 1;
            }else{
                verName = pinfo_gm.versionName;
                verCode = pinfo_gm.versionCode;}
        }else {
            verName = pinfo_gp.versionName;
            verCode = pinfo_gp.versionCode;
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
                            wifi(1);
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
        }


        else{
            wifi(1);
        }
    }
    public  void  wifi (int code){
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        if (!isConnected) {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setTitle(getString(R.string.network_lost_title));
            builder1.setMessage(getString(R.string.network_lost));
            builder1.setIcon(R.drawable.app_icon_round);

            builder1.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            startActivity(new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
        }


        else {
            new TakeData(code).execute();
        }
    }

    private class TakeData extends AsyncTask<Void, Void, Void> {
        int code = -1;
        String jsonStr = "";
        public TakeData(int code) {
            this.code = code;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Toast.makeText(.. stActivity.this,"Json Data is downloading",Toast.LENGTH_LONG).show();

        }


        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            String url = "http://vt.25u.com/vt/zgt/user.json";
            //Set URL from Zgirls Server
            url = "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid="; //未完成適配,2020.09.02-0912
            // Depends URL
            SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
            if (sharedPreferences.getLong("UID",0) == 0){getSavedLoginDataJson();}
            if (sharedPreferences.getString("verifyCode","0") == "0"){getSavedLoginDataJson();}
            uid = sharedPreferences.getLong("UID",0);
            verifyCode = sharedPreferences.getString("verifyCode","0");
            boolean input_json_list = sharedPreferences.getBoolean("input_json_list", true);
            url = "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid="+uid+"&psw="+verifyCode;
            Log.wtf("URL",url);
            jsonStr = sh.makeServiceCall(url);

            Log.w("STR","AX"+jsonStr);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Log.i("TOTAL_GrabX","ok");
            Log.w("STR2","AX"+jsonStr);
            if ( jsonStr.contains("{")) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if (code ==1) {
                    Intent intent1 = new Intent(DeskActivity.this, DataListActivity.class);
                    intent1.putExtra("UID", uid);
                    intent1.putExtra("verifyCode", verifyCode);
                    editor.putString("ppl", "Yourself");
                    editor.apply();
                    startActivity(intent1);
                }
                if (code ==4){
                    Intent intent = new Intent(DeskActivity.this, BuildingLvlActivity.class);
                    startActivity(intent);
                }

            } else {
                datalist_tips();

            }
        }
    }

    private void datalist_tips() {
        final Dialog dialog = new Dialog(this, R.style.NormalDialogStyle_N);
        View view = View.inflate(this, R.layout.datalist_post, null);

        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        //view.setMinimumHeight((int) (ScreenSizeUtils.getInstance(this).getScreenHeight()));
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int) (ScreenSizeUtils.getInstance(this).getScreenWidth()*0.8);
        lp.height = (int) (ScreenSizeUtils.getInstance(this).getScreenHeight()*0.8);
        lp.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);
        dialog.show();


    }

    public void tips_tool (View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void setting_tool (View view){
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }
    public void update_tool (View view){
        mHandler.sendEmptyMessageDelayed(UPDATE_CHECK, 200);
    }

    public void buildset_tool (View view){
        Intent intent = new Intent(this, BuildingInfoActivity.class);
        startActivity(intent);
    }

    public void anti_tool (View view){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        boolean done = sharedPreferences.getBoolean("ani_pw", false);
        if (done){
            Intent intent = new Intent(this, ANIActivity.class);
            startActivity(intent);
        }else{
            LoginToApp loginToApp = LoginToApp.newInstance();
            loginToApp.show(getSupportFragmentManager(),LoginToApp.TAG);}
    }
    public void theme_tool (View view){
        final CharSequence[] items = {"Normal Theme", "Dark Theme", "Pinky Theme", "Leek Theme","Summer Theme"};
        // 创建builder
        AlertDialog.Builder builder = new AlertDialog.Builder(
                DeskActivity.this);
        builder.setTitle("Cheange your Theme") // 标题
                .setIcon(R.drawable.app_icon_round) // icon
                .setCancelable(false) // 不响应back按钮
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String choose_code = "1";
                        if (items[which] == "Normal Theme") {
                            choose_code = "0";
                            cal_card.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
                            cal_tv.setBackgroundColor(getResources().getColor(R.color.background_base_press));
                            tool_card.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
                            tool_tv.setBackgroundColor(getResources().getColor(R.color.background_base_press));
                            lottery_card.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
                            lottery_tv.setBackgroundColor(getResources().getColor(R.color.background_base_press));
                            lottery_card.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
                            lottery_tv.setBackgroundColor(getResources().getColor(R.color.background_base_press));
                            FINAL_VALUE = BASE_VALUE;
                            FINAL_PRESS_VALUE = BASE_PRESS_VALUE;
                            Toast.makeText(DeskActivity.this, items[which], Toast.LENGTH_SHORT).show();
                        } else if (items[which] == "Dark Theme") {
                            choose_code = "1";
                            cal_card.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
                            cal_tv.setBackgroundColor(getResources().getColor(R.color.background_dark_press));
                            tool_card.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
                            tool_tv.setBackgroundColor(getResources().getColor(R.color.background_dark_press));
                            lottery_card.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
                            lottery_tv.setBackgroundColor(getResources().getColor(R.color.background_dark_press));
                            FINAL_VALUE = DARK_VALUE;
                            FINAL_PRESS_VALUE = DARK_PRESS_VALUE;
                            Toast.makeText(DeskActivity.this, items[which], Toast.LENGTH_SHORT).show();
                        } else if (items[which] == "Pinky Theme") {
                            choose_code = "2";
                            Toast.makeText(DeskActivity.this, items[which], Toast.LENGTH_SHORT).show();
                            cal_card.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
                            cal_tv.setBackgroundColor(getResources().getColor(R.color.background_pink_press));
                            tool_card.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
                            tool_tv.setBackgroundColor(getResources().getColor(R.color.background_pink_press));
                            lottery_card.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
                            lottery_tv.setBackgroundColor(getResources().getColor(R.color.background_pink_press));
                            FINAL_VALUE = PINK_VALUE;
                            FINAL_PRESS_VALUE = PINK_PRESS_VALUE;
                        }else if (items[which] == "Leek Theme") {
                            choose_code = "3";
                            Toast.makeText(DeskActivity.this, items[which], Toast.LENGTH_SHORT).show();
                            cal_card.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
                            cal_tv.setBackgroundColor(getResources().getColor(R.color.background_leek_press));
                            tool_card.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
                            tool_tv.setBackgroundColor(getResources().getColor(R.color.background_leek_press));
                            lottery_card.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
                            lottery_tv.setBackgroundColor(getResources().getColor(R.color.background_leek_press));
                            FINAL_VALUE = LEEK_VALUE;
                            FINAL_PRESS_VALUE = LEEK_PRESS_VALUE;

                        }else if (items[which] == "Summer Theme") {
                            choose_code = "4";
                            Toast.makeText(DeskActivity.this, items[which], Toast.LENGTH_SHORT).show();
                            cal_card.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
                            cal_tv.setBackgroundColor(getResources().getColor(R.color.background_summer_press));
                            tool_card.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
                            tool_tv.setBackgroundColor(getResources().getColor(R.color.background_summer_press));
                            lottery_card.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
                            lottery_tv.setBackgroundColor(getResources().getColor(R.color.background_summer_press));
                            FINAL_VALUE = SUMMER_VALUE;
                            FINAL_PRESS_VALUE = SUMMER_PRESS_VALUE;
                        }

                        File file = new File(DeskActivity.this.getFilesDir(), "text");
                        Log.i("File", "Gotted");
                        if (!file.exists()) {
                            file.mkdir();
                        }
                        try {
                            FileOutputStream overWrite = new FileOutputStream(PATH + "/style.txt", false);
                            overWrite.write(choose_code.getBytes());
                            Log.i("File", choose_code);
                            overWrite.flush();
                            overWrite.close();
                        } catch (Exception e) {
                        }
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public void about_tool (View view){
        Intent i = new Intent(this, AboutActivity.class);
        startActivity(i);
    }
    public void donate_tool (View view) {

        final Dialog dialog = new Dialog(this, R.style.NormalDialogStyle_N);
        Locale locale;
        locale = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration()).get(0);
        locale.getDisplayCountry();
        if (locale != Locale.CHINA){

        view = View.inflate(this, R.layout.donate_view, null);

        mHelper = new IabHelper(this, base64EncodedPublicKey);

        mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
            public void onIabSetupFinished(IabResult result) {
                if (!result.isSuccess()) {
                    Log.d(TAG, "In-app Billing setup failed: " +
                            result);
                } else {
                    Log.d(TAG, "In-app Billing is set up OK");
                    mHelper.queryInventoryAsync(true , additionalSkuList , mGotInventoryListener);

                }
            }
        });

        additionalSkuList.add("donate_hkd_0008");
        additionalSkuList.add("donate_hkd_0010");
        additionalSkuList.add("donate_hkd_0020");
        additionalSkuList.add("donate_hkd_0050");
        additionalSkuList.add("donate_hkd_0100");
        additionalSkuList.add("donate_hkd_0150");
        additionalSkuList.add("donate_hkd_0200");

        if(mHelper.isSetupDone() && !mHelper.isAsyncInProgress()) {
            mHelper.queryInventoryAsync(true , additionalSkuList , mGotInventoryListener);
        }

        CardView 	pay_card =	view.findViewById(R.id.	donate_card		);
        TextView 	pay_tv   =	view.findViewById(R.id.	donate_tv		);
        ImageView	payA	=	view.findViewById(R.id.	donate_img_1	);
        ImageView	payB	=	view.findViewById(R.id.	donate_img_2	);
        ImageView	payC	=	view.findViewById(R.id.	donate_img_3	);
        ImageView	payD	=	view.findViewById(R.id.	donate_img_4	);
        ImageView	payE	=	view.findViewById(R.id.	donate_img_5	);
        ImageView	payF	=	view.findViewById(R.id.	donate_img_6	);
        ImageView	payG	=	view.findViewById(R.id.	donate_img_7	);
        TextView	payA_TV	=	view.findViewById(R.id.	donate_tv_1	);
        TextView	payB_TV	=	view.findViewById(R.id.	donate_tv_2	);
        TextView	payC_TV	=	view.findViewById(R.id.	donate_tv_3	);
        TextView	payD_TV	=	view.findViewById(R.id.	donate_tv_4	);
        TextView	payE_TV	=	view.findViewById(R.id.	donate_tv_5	);
        TextView	payF_TV	=	view.findViewById(R.id.	donate_tv_6	);
        TextView	payG_TV	=	view.findViewById(R.id.	donate_tv_7	);

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

        payA_TV.setText(sku_1);
        payB_TV.setText(sku_2);
        payC_TV.setText(sku_3);
        payD_TV.setText(sku_4);
        payE_TV.setText(sku_5);
        payF_TV.setText(sku_6);
        payG_TV.setText(sku_7);

        String theme = sharedPreferences.getString("theme", "dark");
        String color1 = sharedPreferences.getString("color1", "F1870F");
        String color2 = sharedPreferences.getString("color2", "C56E0D");
        if (theme.equals("base")) {
            pay_card.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            pay_tv.setBackgroundColor(getResources().getColor(R.color.background_base_press));
        }

        if (theme.equals("dark")) {
            pay_card.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            pay_tv.setBackgroundColor(getResources().getColor(R.color.background_dark_press));
        }

        if (theme.equals("pink")) {
            pay_card.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            pay_tv.setBackgroundColor(getResources().getColor(R.color.background_pink_press));
        }

        if (theme.equals("leek")) {
            pay_card.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            pay_tv.setBackgroundColor(getResources().getColor(R.color.background_leek_press));
        }

        if (theme.equals("summer")) {
            pay_card.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            pay_tv.setBackgroundColor(getResources().getColor(R.color.background_summer_press));
        }

        if (theme.equals("custom")) {
            pay_card.setCardBackgroundColor(Color.parseColor("#99"+color1));
            pay_tv.setBackgroundColor(Color.parseColor("#"+color2));
        }

        payA.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { item001("donate_hkd_0008");Donate_price = " HKD $8"; dialog.dismiss();}});
        payB.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { item001("donate_hkd_0010");Donate_price = " HKD $10";dialog.dismiss();}});
        payC.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { item001("donate_hkd_0020");Donate_price = " HKD $20"; dialog.dismiss();}});
        payD.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { item001("donate_hkd_0050");Donate_price = " HKD $50"; dialog.dismiss();}});
        payE.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { item001("donate_hkd_0100");Donate_price = " HKD $100"; dialog.dismiss();}});
        payF.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { item001("donate_hkd_0150");Donate_price = " HKD $150"; dialog.dismiss();}});
        payG.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { item001("donate_hkd_0200");Donate_price = " HKD $200"; dialog.dismiss();}});
}
        else {
            Toast.makeText(mActivity, "未設立國內捐款的方法", Toast.LENGTH_SHORT).show();
        }
    }

    private void item001(String item_id) {
        ITEM_SKU = item_id;
        IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener
                = new IabHelper.OnIabPurchaseFinishedListener() {
            public void onIabPurchaseFinished(IabResult result,
                                              Purchase purchase)
            {
                if (result.isFailure()) {
                    // 에러 처리 코드
                    return;
                }
                else if (purchase.getSku().equals(ITEM_SKU)) {
                    consumeItem();
                }

            }
        };
        if (mHelper != null) {
            try {
                mHelper.launchPurchaseFlow(this, ITEM_SKU, 10001, mPurchaseFinishedListener, "mypurchasetoken");
            }
            catch(IllegalStateException ex){
                Toast.makeText(this, getString(R.string.please_try_again), Toast.LENGTH_SHORT).show();
                mHelper.flagEndAsync();
            }
        }
    }

    public void equipment_lottery (View view){
        Intent intent = new Intent(this, EquipmentLotteryActivity.class);
        startActivity(intent);
    }
    public void enablers_lottery (View view){
        String download_check = readDownload();
        if (download_check == ""){download = 0;}else{
            download = Integer.parseInt(readDownload().trim());
            Log.i("download_check", String.valueOf(download));}

        if (download == 0){
            pd = new ProgressDialog(DeskActivity.this);
            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pd.setTitle(R.string.update_title);
            pd.show();
            for (int i = 0; i < 48; i++) {
                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    OkHttpUtils
                            .get()
                            .url(urls[i])
                            .build()
                            .execute(new FileCallBack(DOWNLOADENABLERSPATH, enablers[i]+".png") {
                                @Override
                                public void onError(okhttp3.Call call, Exception e, int id) {
                                    pd.dismiss();
                                }

                                @Override
                                public void onResponse(File response, int id) {
                                    pd.dismiss();
                                    download_stat = "1";
                                    File file = new File(DeskActivity.this.getFilesDir(), "text");
                                    Log.i("File", "Gotted");
                                    if (!file.exists()) {
                                        file.mkdir();
                                    }
                                    try {
                                        FileOutputStream overWrite = new FileOutputStream(PATH + "/download.txt", false);
                                        overWrite.write(download_stat.getBytes());
                                        Log.i("File", download_stat);
                                        overWrite.flush();
                                        overWrite.close();
                                    } catch (Exception e) {
                                    }
                                }
                                @Override
                                public void inProgress(float progress, long total, int id) {
                                    pd.setMax(48);
                                    pd.setProgress((int) (48 * progress));
                                    super.inProgress(progress, total, id);
                                }
                            });
                } else {
                    //    Toast.makeText(DeskActivity.this, "sd卡不可用,無法自動更新", Toast.LENGTH_SHORT).show();
                    Log.i("ERROR","sd卡不可用,無法自動更新");
                }
            }
            Intent intent = new Intent(DeskActivity.this, EnablersLotteryActivity.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, EnablersLotteryActivity.class);
            startActivity(intent);}
    }


    /**

     * 獲取服務器的最新版本號

     */

    private class CheckVersionTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Toast.makeText(DataListActivity.this,"Json Data is downloading",Toast.LENGTH_LONG).show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            try {
                boolean download_beta = sharedPreferences.getBoolean("download_beta", false);

                //String 1.0.6_path = "http://vt.25u.com/vt/zgt/updateinfo.json";
                String path = "http://vt.25u.com/vt/zgt/server_update_info.json";
                URL url = new URL(path);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                int code = connection.getResponseCode();
                if (code == 200) {
                    InputStream is = connection.getInputStream();
                    String result = StreamTools.readStream(is);
                    JSONObject json = new JSONObject(result);
                    String serverVersion = json.getString("version");
                    String description = json.getString("description");
                    VersionName = json.getString("verName");
                    String status = json.getString("status");
                    /*
                    downloadpath = json.getString("downloadpath");
                    Log.e(TAG, "新版本下載路徑：" + downloadpath);

                    try {
                        URL myUrl = new URL(downloadpath);
                        URLConnection urlConnection = myUrl.openConnection();
                        urlConnection.connect();
                        file_size = urlConnection.getContentLength();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                     */

                    if (download_beta  && status.equals("beta")){
                        Log.e("STATUS","DEV");
                        int DownV = Integer.parseInt(serverVersion);
                        int NowV = Integer.parseInt(localversion);
                        if (NowV == DownV| NowV > DownV) {
                            Log.e(TAG,"Local Version = Server Version");
                            loadMainUI();
                        } else if (NowV < DownV) {
                            Log.e(TAG, "Local Version > Server Version");
                            Log.e(TAG, "版本號不一致，提示用戶升級");
                            android.os.Message msg = android.os.Message.obtain();
                            msg.what = SHOW_UPDATE_DIALOG;
                            msg.obj = description;
                            handler.sendMessage(msg);
                        }
                        else {
                            int DownV2 = Integer.parseInt(serverVersion);
                            int NowV2 = Integer.parseInt(localversion);
                            if (NowV2 == DownV2) {
                                Log.e(TAG,"Local Version = Server Version");
                                loadMainUI();
                            } else if (NowV2 < DownV2) {
                                Log.e(TAG, "Local Version > Server Version");
                                Log.e(TAG, "版本號不一致，提示用戶升級");
                                loadMainUI();
                            }
                        }
                    }
                    if (status.equals("release")){
                        int DownV2 = Integer.parseInt(serverVersion);
                        int NowV2 = Integer.parseInt(localversion);
                        if (NowV2 == DownV2) {
                            Log.e(TAG,"Local Version = Server Version");
                            loadMainUI();
                        } else if (NowV2 < DownV2) {
                            Log.e(TAG, "版本號不一致，提示用戶升級");
                            android.os.Message msg = android.os.Message.obtain();
                            msg.what = SHOW_UPDATE_DIALOG;
                            msg.obj = description;
                            handler.sendMessage(msg);
                        }
                    }
                } else {
                    android.os.Message msg = android.os.Message.obtain();
                    msg.what = ERROR;
                    msg.obj = "410 Gone";
                    handler.sendMessage(msg);
                }
            } catch (Resources.NotFoundException e) {
                android.os.Message msg = android.os.Message.obtain();
                msg.what = ERROR;
                msg.obj = "404 Not Found";
                handler.sendMessage(msg);
                e.printStackTrace();
            } catch (MalformedURLException e) {
                android.os.Message msg = android.os.Message.obtain();
                msg.what = ERROR;
                msg.obj = "405 Method Not Allowed";
                handler.sendMessage(msg);
                e.printStackTrace();
            } catch (IOException e) {
                android.os.Message msg = android.os.Message.obtain();
                msg.what = ERROR;
                msg.obj = "408 Request Timeout";
                handler.sendMessage(msg);
                e.printStackTrace();
            } catch (JSONException e) {
                android.os.Message msg = android.os.Message.obtain();
                msg.what = ERROR;
                msg.obj = "409 Conflict";
                handler.sendMessage(msg);
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Log.i("DESK_UPDATE_Grab","ok");
        }
    }

    private Handler handler = new Handler() {

        @Override

        public void handleMessage(android.os.Message msg) {

            switch (msg.what) {

                case SHOW_UPDATE_DIALOG://顯示應用更新對話框
                    String desc = (String) msg.obj;

                    showUpdateDialog(desc);
                    break;
                case SHOW_TEST_DIALOG:
                    String desc2 = (String) msg.obj;
                    showUpdateDialog(desc2);
                    Log.i("HI","TEST");
                    break;
                case ERROR:
                    //Toast.makeText(DeskActivity.this, "錯誤碼:" + msg.obj, Toast.LENGTH_SHORT).show();
                    Toast.makeText(DeskActivity.this, getString(R.string.network_lost), Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }

        }

    };



    /**
     * 自動更新的對話框
     */
    private void showUpdateDialog(String desc) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.update_tip);
        builder.setMessage("Version : "+VersionName+"\n"+desc);
        /*
        builder.setPositiveButton(R.string.update_pos, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                pd = new ProgressDialog(DeskActivity.this);
                pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pd.setTitle(R.string.update_title);
                zipped_size = file_size ;
                pd.setMessage("\nVersion : "+VersionName+"\n"+(zipped_size*progress_final)+"MB / "+zipped_size+"MB");
                pd.setIcon(R.drawable.app_icon_round);
                pd.show();
                /*
                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    OkHttpUtils
                            .get()
                            .url(downloadpath)
                            .build()
                            .execute(new FileCallBack(DOWNLOADPATHFILE, "zgt_update.apk") {
                                @Override
                                public void onError(okhttp3.Call call, Exception e, int id) {
                                 //   Toast.makeText(DeskActivity.this, "Download failed", Toast.LENGTH_SHORT).show();
                                    loadMainUI();
                                    pd.dismiss();
                                }

                                @Override
                                public void onResponse(File response, int id) {
                                    //Toast.makeText(DeskActivity.this, "Download Sucessed", Toast.LENGTH_SHORT).show();
                                    pd.dismiss();
                                    installApk();
                                    Log.i("OK","OK");

                                }
                                @Override
                                public void inProgress(float progress, long total, int id) {
                                    progress_final = progress ;
                                    pd.setMessage("Version : "+VersionName+"\n"+prettyCount(zipped_size*progress_final)+" / "+prettyCount(zipped_size));
                                    pd.setMax((int) 100);
                                    pd.setProgress((int) (100 * progress));
                                    super.inProgress(progress, total, id);
                                }
                            });
                } else {
                  //
                    //  Toast.makeText(DeskActivity.this, "sd卡不可用,無法自動更新", Toast.LENGTH_SHORT).show();
                    loadMainUI();
                }


            }
        });
        builder.setNegativeButton(R.string.update_neg, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                loadMainUI();
            }
        });

         */
        builder.show();
    }
    private void loadMainUI() {
        Log.i("load","ok");
        version_c = false ;
    }
    public void cbg() {
        //取出数据（注意这里直接用实例取就行了，不用获取编辑器editor）
        String theme = sharedPreferences.getString("theme", "dark");
        String color1 = sharedPreferences.getString("color1", "F1870F");
        String color2 = sharedPreferences.getString("color2", "C56E0D");
        if (theme.equals("base")) {
            cal_card.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            cal_tv.setBackgroundColor(getResources().getColor(R.color.background_base_press));
            tool_card.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            tool_tv.setBackgroundColor(getResources().getColor(R.color.background_base_press));
            lottery_card.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            lottery_tv.setBackgroundColor(getResources().getColor(R.color.background_base_press));
            know_card.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            know_tv.setBackgroundColor(getResources().getColor(R.color.background_base_press));
            FINAL_VALUE = BASE_VALUE;
            FINAL_PRESS_VALUE = BASE_PRESS_VALUE;
        }

        if (theme.equals("dark")) {
            cal_card.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            cal_tv.setBackgroundColor(getResources().getColor(R.color.background_dark_press));
            tool_card.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            tool_tv.setBackgroundColor(getResources().getColor(R.color.background_dark_press));
            lottery_card.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            lottery_tv.setBackgroundColor(getResources().getColor(R.color.background_dark_press));
            know_card.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            know_tv.setBackgroundColor(getResources().getColor(R.color.background_dark_press));
            FINAL_VALUE = DARK_VALUE;
            FINAL_PRESS_VALUE = DARK_PRESS_VALUE;
        }

        if (theme.equals("pink")) {
            cal_card.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            cal_tv.setBackgroundColor(getResources().getColor(R.color.background_pink_press));
            tool_card.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            tool_tv.setBackgroundColor(getResources().getColor(R.color.background_pink_press));
            lottery_card.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            lottery_tv.setBackgroundColor(getResources().getColor(R.color.background_pink_press));
            know_card.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            know_tv.setBackgroundColor(getResources().getColor(R.color.background_pink_press));
            FINAL_VALUE = PINK_VALUE;
            FINAL_PRESS_VALUE = PINK_PRESS_VALUE;
        }

        if (theme.equals("leek")) {
            cal_card.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            cal_tv.setBackgroundColor(getResources().getColor(R.color.background_leek_press));
            tool_card.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            tool_tv.setBackgroundColor(getResources().getColor(R.color.background_leek_press));
            lottery_card.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            lottery_tv.setBackgroundColor(getResources().getColor(R.color.background_leek_press));
            know_card.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            know_tv.setBackgroundColor(getResources().getColor(R.color.background_leek_press));
            FINAL_VALUE = LEEK_VALUE;
            FINAL_PRESS_VALUE = LEEK_PRESS_VALUE;
        }

        if (theme.equals("summer")) {
            cal_card.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            cal_tv.setBackgroundColor(getResources().getColor(R.color.background_summer_press));
            tool_card.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            tool_tv.setBackgroundColor(getResources().getColor(R.color.background_summer_press));
            lottery_card.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            lottery_tv.setBackgroundColor(getResources().getColor(R.color.background_summer_press));
            know_card.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            know_tv.setBackgroundColor(getResources().getColor(R.color.background_summer_press));
            FINAL_VALUE = SUMMER_VALUE;
            FINAL_PRESS_VALUE = SUMMER_PRESS_VALUE;
        }

        if (theme.equals("custom")) {
            cal_card.setCardBackgroundColor(Color.parseColor("#99"+color1));
            cal_tv.setBackgroundColor(Color.parseColor("#"+color2));
            tool_card.setCardBackgroundColor(Color.parseColor("#99"+color1));
            tool_tv.setBackgroundColor(Color.parseColor("#"+color2));
            lottery_card.setCardBackgroundColor(Color.parseColor("#99"+color1));
            lottery_tv.setBackgroundColor(Color.parseColor("#"+color2));
            know_card.setCardBackgroundColor(Color.parseColor("#99"+color1));
            know_tv.setBackgroundColor(Color.parseColor("#"+color2));
            FINAL_VALUE = SUMMER_VALUE;
            FINAL_PRESS_VALUE = SUMMER_PRESS_VALUE;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        cbg();
        BackgroundReload();
        boolean ani_2 = sharedPreferences.getBoolean("ANI_SHOW",false);
        if (ani_2){ANI.setVisibility(View.VISIBLE);ANI_btn.setVisibility(View.VISIBLE);}else{ANI.setVisibility(View.GONE);ANI_btn.setVisibility(View.GONE);}
        //把保存的資料拿回來使用
    }

    private void rnd() {
        int rnd = (int) (Math.random() * 15);
        TextView know = findViewById(R.id.team_name1);
        if (rnd == 0){know.setText(getString(R.string.do_you_know_01));}
        if (rnd == 1){know.setText(getString(R.string.do_you_know_02));}
        if (rnd == 2){know.setText(getString(R.string.do_you_know_03));}
        if (rnd == 3){know.setText(getString(R.string.do_you_know_04));}
        if (rnd == 4){know.setText(getString(R.string.do_you_know_05));}
        if (rnd == 5){know.setText(getString(R.string.do_you_know_06));}
        if (rnd == 6){know.setText(getString(R.string.do_you_know_07));}
        if (rnd == 7){know.setText(getString(R.string.do_you_know_08));}
        if (rnd == 8){know.setText(getString(R.string.do_you_know_09));}
        if (rnd == 9){know.setText(getString(R.string.do_you_know_10));}
        if (rnd == 10){know.setText(getString(R.string.do_you_know_11));}
        if (rnd == 11){know.setText(getString(R.string.do_you_know_12));}
        if (rnd == 12){know.setText(getString(R.string.do_you_know_13));}
        if (rnd == 13){know.setText(getString(R.string.do_you_know_14));}
        if (rnd == 14){know.setText(getString(R.string.do_you_know_15));}
        if (rnd == 15){know.setText(getString(R.string.do_you_know_16));}
        mHandler.sendEmptyMessageDelayed(INS_CHANGE, 3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        cbg();
        BackgroundReload();
        boolean ani_2 = sharedPreferences.getBoolean("ANI_SHOW",false);
        if (ani_2){ANI.setVisibility(View.VISIBLE);ANI_btn.setVisibility(View.VISIBLE);}else{ANI.setVisibility(View.GONE);ANI_btn.setVisibility(View.GONE);}

        //時把需要保存的資料保存
    }
    private void installApk() {
        try {
            String PATH = Environment.getExternalStorageDirectory().getPath () + "/download";
            File file = new File(PATH + "/zgt_update.apk");
            Intent intent = new Intent(Intent.ACTION_VIEW);
            if (Build.VERSION.SDK_INT >= 24) {
                Uri downloaded_apk = FileProvider.getUriForFile(this, "voc.net.tools.zgirls_tool.provider", file);
                intent.setDataAndType(downloaded_apk, "application/vnd.android.package-archive");
                List<ResolveInfo> resInfoList = this.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                for (ResolveInfo resolveInfo : resInfoList) {
                    this.grantUriPermission(this.getApplicationContext().getPackageName() + ".provider",  downloaded_apk, Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
                }
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivity(intent);
            } else {
                intent.setAction(Intent.ACTION_VIEW);
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent.putExtra(Intent.EXTRA_NOT_UNKNOWN_SOURCE, true);
                intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            }
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class DownladDBFromServer implements Runnable {
        @Override
        public void run() {
            try {
                //  path_test = "https://github.com/Vocaloid2048/Z-Girls-Tools/blob/master/database.db?raw=true";
                path_test = "http://vt.25u.com/vt/zgt/database.db";
                String path_final = "http://vt.25u.com/vt/zgt/"+uid;
                URL url = new URL(path_test);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000);
                int code = connection.getResponseCode();
                android.os.Message msg = android.os.Message.obtain();
                if (code == 200) {
                    InputStream is = connection.getInputStream();
                    String result = StreamTools.readStream(is);
                    Log.e(TAG, "新版本下載路徑：" + path_test);
                    msg.what = SHOW_UPDATE_DIALOG;
                    msg.obj = "DB_DOWNLOAD";
                    handler2.sendMessage(msg);
                } else {
                    msg.what = ERROR;
                    msg.obj = "code:410";
                    handler2.sendMessage(msg);
                }
            } catch (Resources.NotFoundException e) {
                android.os.Message msg = android.os.Message.obtain();
                msg.what = ERROR;
                msg.obj = "code:404";
                handler2.sendMessage(msg);
                e.printStackTrace();
            } catch (MalformedURLException e) {
                android.os.Message msg = android.os.Message.obtain();
                msg.what = ERROR;
                msg.obj = "code:405";
                handler2.sendMessage(msg);
                e.printStackTrace();
            } catch (IOException e) {
                android.os.Message msg = android.os.Message.obtain();
                msg.what = ERROR;
                msg.obj = "code:408";
                handler2.sendMessage(msg);
                e.printStackTrace();
            }
        }

    }private Handler handler2 = new Handler() {

        @Override

        public void handleMessage(android.os.Message msg) {

            switch (msg.what) {

                case SHOW_UPDATE_DIALOG://顯示應用更新對話框
                    String desc = (String) msg.obj;
                    showUpdateDialog2(desc);
                    break;
                case ERROR:
                    Toast.makeText(DeskActivity.this, "錯誤碼:" + msg.obj, Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }

        }

    };
    /**
     * 自動更新的對話框
     */
    private void showUpdateDialog2(String desc) {
        pd = new ProgressDialog(DeskActivity.this);
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setTitle(R.string.update_title);
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            OkHttpUtils
                    .get()
                    .url(path_test)
                    .build()
                    .execute(new FileCallBack(DataBasePath, "database.db") {
                        @Override
                        public void onError(okhttp3.Call call, Exception e, int id) {
                            //  Toast.makeText(DeskActivity.this, "Download failed", Toast.LENGTH_SHORT).show();
                            pd.dismiss();
                            Log.i("Database download","ERROR");
                        }

                        @Override
                        public void onResponse(File response, int id) {
                            //   Toast.makeText(DeskActivity.this, "Database Download Sucessed", Toast.LENGTH_SHORT).show();
                            pd.dismiss();
                            Log.i("Database download","OK");

                        }
                        @Override
                        public void inProgress(float progress, long total, int id) {
                            pd.setMax(100);
                            pd.setProgress((int) (100 * progress));
                            super.inProgress(progress, total, id);
                        }
                    });
        } else {
            // Toast.makeText(DeskActivity.this, "sd卡不可用,無法自動更新", Toast.LENGTH_SHORT).show();
            Log.i("Database download","sd卡不可用,無法自動更新");
        }

    }
    public static void deleteFiles(String path) {

        File file = new File(path);

        if (file.exists()) {
            String deleteCmd = "rm -r " + path;
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec(deleteCmd);
            } catch (IOException e) { }
        }
    }
    public static void downloadFile(String uRl, Context context) {

        File myDir = new File(Environment.getExternalStorageDirectory().getPath (), "/voc/zgt/enablers/");
        if (!myDir.exists()) {
            myDir.mkdirs();
        }

        DownloadManager mgr = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);

        Uri downloadUri = Uri.parse(uRl);
        DownloadManager.Request request = new DownloadManager.Request(
                downloadUri);

        request.setAllowedNetworkTypes(
                DownloadManager.Request.NETWORK_WIFI
                        | DownloadManager.Request.NETWORK_MOBILE).setAllowedOverMetered(true)
                .setAllowedOverRoaming(true)
                .setVisibleInDownloadsUi(true)
                .setDestinationInExternalPublicDir("MyApp" + "/", uRl);

        mgr.enqueue(request);

    }

    //

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
            uid = result.getLong("uid");
            verifyCode = result.getString("verifyCode");
            SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putLong("UID",uid);
            editor.putString("verifyCode",verifyCode);
            editor.apply();
            Log.i("UID", String.valueOf(uid));
            Log.i("verifyCode", String.valueOf(verifyCode));
            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }
    public void thanks(){
        AlertDialog.Builder builder = new AlertDialog.Builder(
                DeskActivity.this);
        builder.setTitle("Welcome to use Zgirls Tool ~") // 标题
                .setIcon(R.drawable.app_icon_round)
                .setCancelable(false)
                .setMessage("First , pls let me say Thx to @Ferthel @Red @Freya @Ryuk @飘\n"+
                        "I'm really glad to get help from you ~"+"\n"+
                        "----------------------------"+"\n"+
                        "Zgirls Tool (ZGT) , is an app which focus at helping Zgirls player to calculate and plan how many items (RSS) they need**"+"\n"+
                        "\n~ Function Introduce ~"+"\n"+
                        "1.Calculators\n"+
                        " Teach Building :\n"+
                        "   Count how many RSS you need for upgrade your TB\n"+
                        " Troops :\n"+
                        "   Count how many RSS you need for training troops\n"+
                        "   Count how many power , load that your troops have\n"+
                        " Enabler EXP :\n"+
                        "   Count how many EXP you need for upgrade your Enablers to your aim level\n"+
                        " Mecha :\n"+
                        "   Count how many RSS / Diamonds you need for upgrade your Mecha\n"+
                        " Event Store (Near done) :\n"+
                        "   Count how many event tickets / coins you need to get by choosing things \n"+
                        " EXP to Lvl :\n"+
                        "   Count how many EXP , Lvl you can upgrade your enablers\n"+
                        " Technology :\n"+
                        "   Count your buff which add from Lab\n"+
                        " Kizuna :\n"+
                        "   Count how many Shards and Pictures you need for upgrade your enablers' kizuna\n"+
                        " Star Stone :\n"+
                        "   Count how many Star Stone I you need for start up your Star Language\n"+
                        " Building :\n"+
                        "   Count how many RSS you need for upgrade your aim building\n"+
                        "\n"+
                        "2.Ingame Data Reader :\n"+
                        "There have a nice Real-Time Ingame DataList , you may :\n"+
                        " A.check how many RSS in your storeroom\n"+
                        " B.Which Star language your are using\n"+
                        " C.Your Mechas' Lvl\n"+
                        " D.Your Enablers' Lvl\n"+
                        " E.How many troops you have\n\n"+
                        "Hope they are useful to you ~ If you have anymore idea , you may send a email / pm Voc at Discord\n"+
                        "Email : voc.app.programmer@gmail.com\n"+
                        "Discord : Voc-夜芷冰#2512\n"+
                        "Wish you have a nice journey with ZGT ~");
        builder.setPositiveButton(
                getString(R.string.continue_btn),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert11 = builder.create();
        alert11.show();
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
    private final int UPDATE_CHECK = 0 ;
    private final int INS_CHANGE = 1 ;
    private final int POSTER_CHECK = 2 ;
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {

            switch (msg.what) {
                case UPDATE_CHECK:
                    new CheckVersionTask().execute();
                    break;
                case INS_CHANGE:
                    rnd();
                    break;
                case POSTER_CHECK:
                    new TakePosterData().execute();
                    break;

                default:
                    break;
            }
        }

    };

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "Example Service Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mHelper != null) {
            mHelper.dispose();
        }
        mHelper = null;
    }
    public void question (View view) {
        HashMap<String, Object> config2 = new HashMap();
        HashMap<String, Object> map2 = new HashMap();
        ArrayList<String> tags2 = new ArrayList();
        tags2.add("vip1");//第一种方式自定义 需要和后台保持一致(针对key形式)

        // "elva-tags" 是key值 不可以变
        map2.put("elva-tags", tags2);

        map2.put("udid", "123456789");//第二种方式自定义 不需要去后台配置(针对key-value形式)

        // "elva-custom-metadata" 是key值 不可以变
        config2.put("elva-custom-metadata", map2);

        // 加入此参数,其中key是不可变的 优先级最高 加上后faq右上角则永不显示
        // (如果想显示 需要删除此参数 并加入 config.put("showContactButtonFlag", "1");
        config2.put("hideContactButtonFlag", "1");

        // 显示可以从FAQ列表右上角进入机器人客服(如果不想显示 需要删除此参数)
        config2.put("showContactButtonFlag", "1");

        // 点击FAQ右上角后 进入机器人界面右上角是否显示 (如果不想显示 需要删除此参数)
        config2.put("showConversationFlag", "1");

        // 点击FAQ右上角后 直接会进入到人工客服页面(不加默认进入机器人界面 如果不需要则删除此参数)
        config2.put("directConversation", "1");

        // 设置用户名 如果拿不到username，就传入空字符串""，会使用默认昵称"anonymous"
        ELvaChatServiceSdk.setUserName("user_name");

        // 设置用户ID 如果拿不到userid，就传入空字符串""，系统会生成一个唯一设备id
        ELvaChatServiceSdk.setUserId("user_id");

        // 设置服务ID
        ELvaChatServiceSdk.setServerId("server_id");

        ELvaChatServiceSdk.showFAQs(config2);
    }
    public void backup (View view){
        String strDate = String.valueOf(new Date().getTime());
        exportSH("user_info.xml", strDate);
    }
    private void exportSH(String sh_name, String strDate){

        File sd = new File(Environment.getExternalStorageDirectory().getPath () + "/voc/zgt/backup/");

        boolean success = true;
        if (!sd.exists()) {
            success = sd.mkdir();
        }
        if (success) {

            File data = Environment.getDataDirectory();
            FileChannel source=null;
            FileChannel destination=null;
            String currentDBPath = "/data/"+ getPackageName() +"/shared_prefs/"+ sh_name;
            String backupDBPath = sh_name;
            File currentDB = new File(data, currentDBPath);
            File backupDB = new File(sd, backupDBPath);
            try {
                source = new FileInputStream(currentDB).getChannel();
                destination = new FileOutputStream(backupDB).getChannel();
                destination.transferFrom(source, 0, source.size());
                source.close();
                destination.close();
                Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
            } catch(IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            }
        }}
    public void system_post (){
        /**
         * System Post is used to show some announcement , such as ask to do a survey , next update time , etc ...
         */
        final Dialog dialog = new Dialog(this, R.style.NormalDialogStyle_N);
        View view = View.inflate(this, R.layout.system_post, null);
        ImageView cancel = view.findViewById(R.id.cancel_btn);
        ImageView main = view.findViewById(R.id.main_img);
        Button update = view.findViewById(R.id.update_btn);
        WebView web = view.findViewById(R.id.webview_poster);

        main.setVisibility(View.GONE);
        web.setVisibility(View.GONE);

        if (layout_num == 0){main.setVisibility(View.VISIBLE);}
        if (layout_num == 1){web.setVisibility(View.VISIBLE);}

        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        //view.setMinimumHeight((int) (ScreenSizeUtils.getInstance(this).getScreenHeight()));
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int) (ScreenSizeUtils.getInstance(this).getScreenWidth()*0.9);
        lp.height = (int) (ScreenSizeUtils.getInstance(this).getScreenHeight()*0.9);
        lp.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);

        Log.i("SHOW3","SHOW");
        if (sharedPreferences.getBoolean("always_show_post" , true) == true){
            Log.i("SHOW2","SHOW");
            Picasso.with(this).load(image_url).into(main);
            dialog.show();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putLong("last_post_time", post_date_unix);
            editor.apply();
        }

        if (sharedPreferences.getBoolean("always_show_post" , true) == false){
            // 20201215 DO IT ! CHECK THE FILE AT /vt/zgt/poster_info.json !!! POSTER NEED 1080*1920
            update.setVisibility(View.GONE);
            if (sharedPreferences.getLong("last_post_time" , 0 )< post_date_unix) {
                Picasso.with(this).load(image_url).into(main);
                dialog.show();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putLong("last_post_time", post_date_unix);
                editor.apply();
            }
        }

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("always_show_post", false);
                editor.apply();
                /**
                 * always_show_post :
                 * num = 0 : TRUE
                 * num = 1 : Only update
                 * num = 2 : Never show thx
                 */
            }
        });
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (!pressed_url.equals("")){
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(pressed_url));
                    startActivity(intent);
                }
            }
        });


    }
    private class TakePosterData extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Toast.makeText(DataListActivity.this,"Json Data is downloading",Toast.LENGTH_LONG).show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            String url = "http://vt.25u.com/vt/zgt/poster/poster_info.json";
            String jsonStr = "http://vt.25u.com/vt/zgt/poster_info.json" ;
            jsonStr = sh.makeServiceCall(url);

            // Log.e(TAG, "Response from url: " + jsonStr);
            if (!jsonStr.equals("")) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    if(jsonObj.has("version")){ version = jsonObj.getLong("version");}else{ version = 0;}
                    if(jsonObj.has("post_date_unix")){ post_date_unix = jsonObj.getLong("post_date_unix");}else{ post_date_unix = 0;}
                    if(jsonObj.has("layout_num")){ layout_num = jsonObj.getLong("layout_num");}else{ layout_num = 0;}
                    if(jsonObj.has("pressed_url")){ pressed_url = jsonObj.getString("pressed_url");}else{ pressed_url = "";}
                    if(jsonObj.has("image_url")){ image_url = jsonObj.getString("image_url");}else{ image_url = "";}
                    if(jsonObj.has("image_name")){ image_name = jsonObj.getString("image_name");}else{ image_name = "";}

/**
 *                      if(jsonObj.has("info")) {
 *                         JSONObject rss = jsonObj.getJSONObject("info");
 *                         for (int i = 0; i < rss.length(); i++) {
 *
 *                             if(rss.has("version")){ version = rss.getLong("version");}else{ version = 0;}
 *                             if(rss.has("post_date_unix")){ post_date_unix = rss.getLong("post_date_unix");}else{ post_date_unix = 0;}
 *                             if(rss.has("layout_num")){ layout_num = rss.getLong("layout_num");}else{ layout_num = 0;}
 *                             if(rss.has("pressed_url")){ pressed_url = rss.getString("pressed_url");}else{ pressed_url = "";}
 *                             if(rss.has("image_url")){ image_url = rss.getString("image_url");}else{ image_url = "";}
 *
 *                         }
 *                     }
 */
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                                         Toast.makeText(getApplicationContext(),
                                                "Json parsing error: " + e.getMessage(),
                                                Toast.LENGTH_LONG).show();
                        }
                    });

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                        "Couldn't get json from server. Check LogCat for possible errors!",
                        Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Log.i("Poster_Grap","ok");
            if (!image_url.equals("")){
            system_post();

        }
    }
}public class HttpGetRequest extends AsyncTask<String, Void, String> {
        public static final String REQUEST_METHOD = "GET";
        public static final int READ_TIMEOUT = 500;
        public static final int CONNECTION_TIMEOUT = 500;
        @Override
        protected String doInBackground(String... params){
            String stringUrl = params[0];
            String result;
            int var;
            String inputLine;
            try {
                //Create a URL object holding our url
                URL myUrl = new URL(stringUrl);
                //Create a connection
                HttpURLConnection connection =(HttpURLConnection)
                        myUrl.openConnection();
                //Set methods and timeouts
                connection.setRequestMethod(REQUEST_METHOD);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setConnectTimeout(CONNECTION_TIMEOUT);

                //Connect to our url
                connection.connect();
                //Create a new InputStreamReader
                InputStreamReader streamReader = new
                        InputStreamReader(connection.getInputStream());
                //Create a new buffered reader and String Builder
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuilder stringBuilder = new StringBuilder();
                //Check if the line we are reading is not null
                while((inputLine = reader.readLine()) != null){
                    stringBuilder.append(inputLine);
                }
                //Close our InputStream and Buffered reader
                reader.close();
                streamReader.close();
                //Set our result equal to our stringBuilder
                result = stringBuilder.toString();

                String tempWord = "<html>" ;
                result = result.replaceAll(tempWord, "");
                tempWord = "<body>" ;
                result = result.replaceAll(tempWord, "");
                tempWord = "\n";
                result = result.replaceAll(tempWord, "");
                tempWord = "<!DOCTYPE html>";
                result = result.replaceAll(tempWord, "");
                tempWord = "</body>";
                result = result.replaceAll(tempWord, "");
                tempWord = "</html>";
                result = result.replaceAll(tempWord, "");
                tempWord = "<br/>";
                result = result.replaceAll(tempWord, "");
                tempWord = "\"";
                result = result.replaceAll(tempWord, "");
            }
            catch(IOException e){
                e.printStackTrace();
                result = null;
            }
            return result;
        }
        protected void onPostExecute(String result){
            super.onPostExecute(result);
        }
    }
    public void tips (View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}


