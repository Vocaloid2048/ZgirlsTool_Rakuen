package voc.net.tools.zgirls_tool.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import org.apache.http.util.EncodingUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.util.Building;
import voc.net.tools.zgirls_tool.util.BuildingAdapter;
import voc.net.tools.zgirls_tool.util.HttpHandler;
import voc.net.tools.zgirls_tool.R;

public class BuildingLvlActivity extends AppCompatActivity {

    private static final String TAG = "BuildingLvlActivity";
    Set<String> demo;
    long uid;
    String UID;
    String verifyCode ;

    String boomName , buildingName  ;
    long buildingId , buildingLvl , buildingGlory ;

    private List<Building> buildingList = new ArrayList<>();
    private RecyclerView.Adapter adapter;
    private BuildingAdapter mAdapter;
    RecyclerView mList ;

    ProgressDialog pd ;

    long[] buildingLvlArray = new long[72];
    String[] buildingNameArray = new String[72];
    ArrayList buildings = new ArrayList();
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;

    String jsonStr;
    private static final String fileName = "user_session";
    private static final String fileDir = Environment.getExternalStorageDirectory().getPath() +"/data/data/com.xingjoys.zgirls.app/config/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_lvl);

        mAdapter = new BuildingAdapter(getApplicationContext(), buildingList);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        //Set<String> buildingName = sharedPreferences.getStringSet("buildingName", demo );
        //Set<String> buildingLvl = sharedPreferences.getStringSet("buildingLvl", demo );
        mList = findViewById(R.id.train_list);
        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.setAdapter(mAdapter);
        getSavedLoginDataJson();
        BackgroundReload();
        new TakeData().execute();
        pd = new ProgressDialog(this);
        pd.setMessage(getString(R.string.update_title));
        pd.show();
    }

    private void dataRefresh() {
        ArrayList<Building> filteredList = new ArrayList<>();
        for (Building item : buildingList) {
            item.getType();
            filteredList.add(item);
        }
        mAdapter.filterList(filteredList);
    }

    public void btn1 (View view){
        ArrayList<Building> filteredList = new ArrayList<>();
        for (Building item : buildingList) {
            if (item.getType() == 1) {
                filteredList.add(item);
            }

        }
        mAdapter.filterList(filteredList);
    }
    public void btn2 (View view){
        ArrayList<Building> filteredList = new ArrayList<>();
        for (Building item : buildingList) {
            if (item.getType() == 2) {
                filteredList.add(item);
            }
        }
        mAdapter.filterList(filteredList);
    }
    public void btn3 (View view){
        ArrayList<Building> filteredList = new ArrayList<>();
        for (Building item : buildingList) {
            if (item.getType() == 3) {
                filteredList.add(item);
            }
        }
        mAdapter.filterList(filteredList);
    }
    public void btn4 (View view){
        ArrayList<Building> filteredList = new ArrayList<>();
        for (Building item : buildingList) {
            if (item.getType() == 4) {
                filteredList.add(item);
            }
        }
        mAdapter.filterList(filteredList);
    }

    public void BackgroundReload (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.lvl_bg);

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
            uid = result.getLong("uid");
            verifyCode = result.getString("verifyCode");
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

            if (input_json_list == true){url = "http://p1.xingjoys.net:8081/gameservice/externalAccessData.php?uid="+uid+"&psw="+verifyCode;jsonStr = sh.makeServiceCall(url);}
            else {
                url = "http://vt.25u.com/vt/zgt/user.json";
                sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("ppl", "DEMO");
                editor.apply();
                jsonStr = sh.makeServiceCall(url);
            }
            if (jsonStr.equals("{}")|jsonStr.equals("")){
                jsonStr = "{\"activityShop\":[{\"needCount\":\"150000|300000\",\"price\":\"150000|300000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"120000|300000\",\"price\":\"120000|300000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"150000|300000\",\"price\":\"150000|300000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"100000|100000\",\"price\":\"100000|100000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"150000|150000\",\"price\":\"150000|150000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"200000|200000\",\"price\":\"200000|200000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"20000|20000\",\"price\":\"20000|20000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"60000|60000\",\"price\":\"60000|60000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"30000|30000\",\"price\":\"30000|30000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"100000|140000|200000|270000|350000|450000\",\"price\":\"100000|140000|200000|270000|350000|450000\",\"name\":\"Festival limit\",\"count\":\"1|2|3|4|5|6\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"300|300\",\"price\":\"300|300\",\"name\":\"Festival limit\",\"count\":\"1000|2000\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"100|100\",\"price\":\"100|100\",\"name\":\"Festival limit\",\"count\":\"1000|2000\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"600|720|850\",\"price\":\"600|720|850\",\"name\":\"Festival limit\",\"count\":\"150|300|450\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"1800|2100|2500\",\"price\":\"1800|2100|2500\",\"name\":\"Festival limit\",\"count\":\"50|100|150\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"3600|4300|5100\",\"price\":\"3600|4300|5100\",\"name\":\"Festival limit\",\"count\":\"25|50|100\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"90000|130000|180000|240000|310000|400000\",\"price\":\"90000|130000|180000|240000|310000|400000\",\"name\":\"Festival limit\",\"count\":\"1|2|3|4|5|6\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"800|1000|1200\",\"price\":\"800|1000|1200\",\"name\":\"Festival limit\",\"count\":\"20|50|100\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"50000|80000|110000|130000|170000|220000\",\"price\":\"50000|80000|110000|130000|170000|220000\",\"name\":\"Festival limit\",\"count\":\"1|2|3|4|5|6\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"4|5\",\"price\":\"4|5\",\"name\":\"Festival limit\",\"count\":\"5000|10000\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"60000|90000|120000|160000|220000|300000\",\"price\":\"60000|90000|120000|160000|220000|300000\",\"name\":\"Festival limit\",\"count\":\"1|2|3|4|5|6\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"5|6\",\"price\":\"5|6\",\"name\":\"Festival limit\",\"count\":\"5000|10000\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"1000|1000\",\"price\":\"1000|1000\",\"name\":\"Festival limit\",\"count\":\"300|600\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"1000|1000\",\"price\":\"1000|1000\",\"name\":\"Festival limit\",\"count\":\"300|600\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"150000|300000\",\"price\":\"150000|300000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"150000|300000\",\"price\":\"150000|300000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"50000|100000\",\"price\":\"50000|100000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"100000|100000\",\"price\":\"100000|100000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"50000|100000\",\"price\":\"50000|100000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"50000|100000\",\"price\":\"50000|100000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"20000|30000\",\"price\":\"20000|30000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"20000|30000\",\"price\":\"20000|30000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"20000|30000\",\"price\":\"20000|30000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"20000|30000\",\"price\":\"20000|30000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"200000|300000\",\"price\":\"200000|300000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"200000|300000\",\"price\":\"200000|300000\",\"name\":\"Festival limit\",\"count\":\"1|1\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"200000|300000\",\"price\":\"200000|300000\",\"name\":\"Festival limit\",\"count\":\"1|2\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"30|100|200|300|350|400\",\"price\":\"30|100|200|300|350|400\",\"name\":\"RSS Set\",\"count\":\"10|30|60|100|150|210\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"2|5|8|10|12|15\",\"price\":\"2|5|8|10|12|15\",\"name\":\"RSS Set\",\"count\":\"300|900|1800|3000|4500|6300\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"2|5|8|10|12|15\",\"price\":\"2|5|8|10|12|15\",\"name\":\"RSS Set\",\"count\":\"300|900|1800|3000|4500|6300\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"2|5|8|10|12|15\",\"price\":\"2|5|8|10|12|15\",\"name\":\"RSS Set\",\"count\":\"250|750|1500|2500|3750|5250\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"2|5|8|10|12|15\",\"price\":\"2|5|8|10|12|15\",\"name\":\"RSS Set\",\"count\":\"225|675|1350|2250|3375|4725\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"5|15|25|30|35|40\",\"price\":\"5|15|25|30|35|40\",\"name\":\"RSS Set\",\"count\":\"100|300|600|1000|1500|2100\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"10|15|20|30|35|40\",\"price\":\"10|15|20|30|35|40\",\"name\":\"RSS Set\",\"count\":\"80|240|480|800|1200|1680\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"2|3|4|5|6|7\",\"price\":\"2|3|4|5|6|7\",\"name\":\"RSS Set\",\"count\":\"600|1800|3600|6000|9000|12600\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"10|15|20|25|30|40\",\"price\":\"10|15|20|25|30|40\",\"name\":\"RSS Set\",\"count\":\"100|300|600|1000|1500|2100\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"10|20\",\"price\":\"10|20\",\"name\":\"Enabler Set\",\"count\":\"100|200\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"50|100|150|200|250|300\",\"price\":\"50|100|150|200|250|300\",\"name\":\"Enabler Set\",\"count\":\"15|45|90|150|225|315\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"150|300|450|650|800|1000\",\"price\":\"150|300|450|650|800|1000\",\"name\":\"Enabler Set\",\"count\":\"5|15|30|50|75|105\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"4|7|10|14|17|20\",\"price\":\"4|7|10|14|17|20\",\"name\":\"Enabler Set\",\"count\":\"250|750|1500|2500|3750|5250\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"50|75|100|125|150|175\",\"price\":\"50|75|100|125|150|175\",\"name\":\"Enabler Set\",\"count\":\"20|60|120|200|300|420\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"30|35|40|45|50|100\",\"price\":\"30|35|40|45|50|100\",\"name\":\"Enabler Set\",\"count\":\"40|120|240|400|600|840\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"1|2|3|4|5|6\",\"price\":\"1|2|3|4|5|6\",\"name\":\"Transform Set\",\"count\":\"1000|3000|6000|10000|15000|21000\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"2|5|8|11|13|12\",\"price\":\"2|5|8|11|13|12\",\"name\":\"Transform Set\",\"count\":\"200|600|1200|2000|3000|4200\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"5|7|9|12|15|18\",\"price\":\"5|7|9|12|15|18\",\"name\":\"Transform Set\",\"count\":\"200|600|1200|2000|3000|4200\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"20|35|50|65|80|95\",\"price\":\"20|35|50|65|80|95\",\"name\":\"Transform Set\",\"count\":\"50|150|300|500|750|1050\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"60|90|120|150|180|210\",\"price\":\"60|90|120|150|180|210\",\"name\":\"Arena Set\",\"count\":\"20|60|120|200|300|420\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"5|7|9|11|13|15\",\"price\":\"5|7|9|11|13|15\",\"name\":\"Arena Set\",\"count\":\"250|750|1500|2500|3750|5250\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"5|20|35|50|65|80\",\"price\":\"5|20|35|50|65|80\",\"name\":\"Arena Set\",\"count\":\"45|135|270|450|675|945\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"20|60|100|140|180|220\",\"price\":\"20|60|100|140|180|220\",\"name\":\"Arena Set\",\"count\":\"20|60|120|200|300|420\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"250|400|550|700|850|1000\",\"price\":\"250|400|550|700|850|1000\",\"name\":\"Arena Set\",\"count\":\"1|3|6|10|15|21\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"250|400|550|700|850|1000\",\"price\":\"250|400|550|700|850|1000\",\"name\":\"Arena Set\",\"count\":\"1|3|6|10|15|21\",\"needItem\":\"Pumpkin coin\"},{\"needCount\":\"30000|40000|50000\",\"price\":\"30000|40000|50000\",\"name\":\"Arena Set\",\"count\":\"1|3|5\",\"needItem\":\"Pumpkin coin\"}],\"heros\":[{\"heroLv\":0,\"heroId\":240067,\"heroName\":\"Raly Rothfield\"},{\"heroLv\":0,\"heroId\":240066,\"heroName\":\"Mira Mulls\"},{\"heroLv\":0,\"heroId\":240065,\"heroName\":\"Mika Uehara\"},{\"heroLv\":0,\"heroId\":240064,\"heroName\":\"Risa Terada\"},{\"heroLv\":0,\"heroId\":240071,\"heroName\":\"Kuroda Namida\"},{\"heroLv\":0,\"heroId\":240070,\"heroName\":\"Kurul Egheim\"},{\"heroLv\":0,\"heroId\":240069,\"heroName\":\"Chiyo taku\"},{\"heroLv\":0,\"heroId\":240068,\"heroName\":\"Celesia·Klim\"},{\"heroLv\":0,\"heroId\":240075,\"heroName\":\"Iris\"},{\"heroLv\":0,\"heroId\":240074,\"heroName\":\"Lois Elum\"},{\"heroLv\":0,\"heroId\":240073,\"heroName\":\"Shirley Foster\"},{\"heroLv\":15,\"heroId\":240072,\"heroName\":\"Catherine Edward\"},{\"heroLv\":0,\"heroId\":240077,\"heroName\":\"Narumi Ruri\"},{\"heroLv\":22,\"heroId\":240076,\"heroName\":\"Sylvia Landon\"},{\"heroLv\":31,\"heroId\":240031,\"heroName\":\"Fudo\"},{\"heroLv\":15,\"heroId\":240030,\"heroName\":\"Saki\"},{\"heroLv\":0,\"heroId\":240035,\"heroName\":\"Sara\"},{\"heroLv\":0,\"heroId\":240034,\"heroName\":\"Uzuki\"},{\"heroLv\":0,\"heroId\":240033,\"heroName\":\"Carol\"},{\"heroLv\":0,\"heroId\":240032,\"heroName\":\"Masami\"},{\"heroLv\":0,\"heroId\":240039,\"heroName\":\"Hiyori\"},{\"heroLv\":0,\"heroId\":240038,\"heroName\":\"Kirine\"},{\"heroLv\":0,\"heroId\":240037,\"heroName\":\"Chika\"},{\"heroLv\":0,\"heroId\":240036,\"heroName\":\"Sariko\"},{\"heroLv\":0,\"heroId\":240043,\"heroName\":\"Youko\"},{\"heroLv\":15,\"heroId\":240042,\"heroName\":\"Nana\"},{\"heroLv\":0,\"heroId\":240041,\"heroName\":\"Minami\"},{\"heroLv\":0,\"heroId\":240040,\"heroName\":\"Mio\"},{\"heroLv\":10,\"heroId\":240047,\"heroName\":\"Eleanor\"},{\"heroLv\":0,\"heroId\":240046,\"heroName\":\"Sumika\"},{\"heroLv\":0,\"heroId\":240045,\"heroName\":\"Gin\"},{\"heroLv\":0,\"heroId\":240044,\"heroName\":\"Izumi\"},{\"heroLv\":0,\"heroId\":240051,\"heroName\":\"Donner\"},{\"heroLv\":0,\"heroId\":240050,\"heroName\":\"Comet\"},{\"heroLv\":15,\"heroId\":240049,\"heroName\":\"Kayo\"},{\"heroLv\":10,\"heroId\":240048,\"heroName\":\"Chen\"},{\"heroLv\":0,\"heroId\":240055,\"heroName\":\"Liuk\"},{\"heroLv\":0,\"heroId\":240054,\"heroName\":\"Zero\"},{\"heroLv\":0,\"heroId\":240053,\"heroName\":\"Ana O'\"},{\"heroLv\":0,\"heroId\":240052,\"heroName\":\"Saori\"},{\"heroLv\":0,\"heroId\":240059,\"heroName\":\"Esther\"},{\"heroLv\":0,\"heroId\":240058,\"heroName\":\"Akiyama\"},{\"heroLv\":0,\"heroId\":240057,\"heroName\":\"Zrs-2\"},{\"heroLv\":0,\"heroId\":240056,\"heroName\":\"Odelia\"},{\"heroLv\":0,\"heroId\":240063,\"heroName\":\"MisakiTouhyo\"},{\"heroLv\":0,\"heroId\":240062,\"heroName\":\"Shiori Kushima\"},{\"heroLv\":0,\"heroId\":240061,\"heroName\":\"Yesi Cheng\"},{\"heroLv\":0,\"heroId\":240060,\"heroName\":\"Alice\"}],\"mechas\":[{\"mechaName\":\"Mecha\",\"mechaLv\":5},{\"mechaName\":\"Mana Mecha\",\"mechaLv\":5}],\"resource\":{\"chip\":0,\"crystal3\":24000,\"crystal2\":180000,\"crystal1\":597990,\"crystal\":1590000,\"glory_mark\":321220,\"food\":606941,\"stone\":179170,\"diamond\":19745,\"iron\":1001773,\"scientificStone\":0,\"wood\":1123523,\"silver\":500},\"StarStone\":[{\"name\":\"Polaris\",\"stars\":\"Star Stone I|Star Stone IV\"},{\"name\":\"Al Nair\",\"stars\":\"Star Stone II|Star Stone VII\"},{\"name\":\"Alnilam\",\"stars\":\"Star Stone II|Star Stone IV|Star Stone VIII\"},{\"name\":\"Miaplacidus\",\"stars\":\"Star Stone IV|Star Stone VI|Star Stone IX\"},{\"name\":\"Elnath\",\"stars\":\"Star Stone III|Star Stone VI|Star Stone X\"},{\"name\":\"Bellatrix\",\"stars\":\"Star Stone VI|Star Stone IX|Star Stone XI\"},{\"name\":\"Shaula\",\"stars\":\"Star Stone III|Star Stone X|Star Stone XII\"},{\"name\":\"Gacrux\",\"stars\":\"Star Stone VIII|Star Stone XI|Star Stone XII\"},{\"name\":\"Castor\",\"stars\":\"Star Stone IX|Star Stone XI|Star Stone XIII\"},{\"name\":\"Adhara\",\"stars\":\"Star Stone VI|Star Stone X|Star Stone XIV\"},{\"name\":\"Regulus\",\"stars\":\"Star Stone VIII|Star Stone XIII|Star Stone XIV\"},{\"name\":\"Mimosa\",\"stars\":\"Star Stone IX|Star Stone XII|Star Stone XIV\"},{\"name\":\"Deneb\",\"stars\":\"Star Stone III|Star Stone IV|Star Stone XV\"},{\"name\":\"Fomalhaut\",\"stars\":\"Star Stone IV|Star Stone XIV|Star Stone XV\"},{\"name\":\"Pollux\",\"stars\":\"Star Stone II|Star Stone V|Star Stone VIII|Star Stone XVI\"},{\"name\":\"Spica\",\"stars\":\"Star Stone IV|Star Stone VIII|Star Stone XIV|Star Stone XVI\"},{\"name\":\"Antares\",\"stars\":\"Star Stone II|Star Stone VIII|Star Stone XIII|Star Stone XV\"},{\"name\":\"CruxAustralis\",\"stars\":\"Star Stone III|Star Stone V|Star Stone IX|Star Stone XVII\"},{\"name\":\"Aldebaran\",\"stars\":\"Star Stone VI|Star Stone X|Star Stone XV|Star Stone XVII\"},{\"name\":\"Altair\",\"stars\":\"Star Stone IX|Star Stone XIV|Star Stone XVI|Star Stone XVII\"},{\"name\":\"Agena\",\"stars\":\"Star Stone III|Star Stone XIII|Star Stone XV|Star Stone XVI\"},{\"name\":\"Betelgeux\",\"stars\":\"Star Stone IV|Star Stone VIII|Star Stone XV|Star Stone XVIII\"},{\"name\":\"Achernar\",\"stars\":\"Star Stone III|Star Stone VI|Star Stone XVII|Star Stone XVIII\"},{\"name\":\"Procyon\",\"stars\":\"Star Stone II|Star Stone IV|Star Stone VII|Star Stone XVIII\"},{\"name\":\"Rigel\",\"stars\":\"Star Stone V|Star Stone VI|Star Stone X|Star Stone XIX\"},{\"name\":\"Capella\",\"stars\":\"Star Stone V|Star Stone XV|Star Stone XVII|Star Stone XIX\"},{\"name\":\"Vega Lyra\",\"stars\":\"Star Stone V|Star Stone XIV|Star Stone XVIII|Star Stone XIX\"},{\"name\":\"Arcturus\",\"stars\":\"Star Stone XV|Star Stone XVII|Star Stone XVIII|Star Stone XIX\"},{\"name\":\"Rigil Kent\",\"stars\":\"Star Stone IV|Star Stone V|Star Stone XVII|Star Stone XX\"},{\"name\":\"Canopus\",\"stars\":\"Star Stone XIV|Star Stone XVII|Star Stone XVIII|Star Stone XX\"},{\"name\":\"Sirius\",\"stars\":\"Star Stone XII|Star Stone XIV|Star Stone XVII|Star Stone XX\"}],\"armys\":[{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Sports Freshman\"},{\"armyFreeNum\":1570,\"armyMarchNum\":0,\"armyName\":\"Execution Freshman\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Sports Sophomore\"},{\"armyTrain\":710,\"armyFreeNum\":6318,\"armyMarchNum\":0,\"armyName\":\"Execution Sophomore\",\"armyFinishTime\":1603898945},{\"armyFreeNum\":469,\"armyMarchNum\":0,\"armyName\":\"Sophomore Attacker\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Junior Attacker\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Budo Senior\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Chunibyo Striker\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Karate Striker\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Strategy Master\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Extreme Sports Team\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Defensive Aids Team\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"High-speed Guard Team\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Heavy Ranged Team\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"School Armoured Team\"},{\"armyTrain\":710,\"armyFreeNum\":4535,\"armyMarchNum\":0,\"armyName\":\"Combat Comm. Team\",\"armyFinishTime\":1603904068},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Heavy Armed Team\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Combat Assaulter Team\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Ranged Aids Team\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Dead Reaper Team\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Shooter Freshman\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Assaulter Freshman\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Shooter Sophomore\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Assaulter Sophomore\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Fire Support Sophomore\"},{\"armyTrain\":710,\"armyFreeNum\":5450,\"armyMarchNum\":0,\"armyName\":\"Fire Support Junior\",\"armyFinishTime\":1603909695},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Kyudo Senior\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Holy Sister\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Shinto Miko\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Dead Hunter\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Tainted Girl\"},{\"armyTrain\":710,\"armyFreeNum\":6685,\"armyMarchNum\":0,\"armyName\":\"Viral Girl\",\"armyFinishTime\":1603892975},{\"armyFreeNum\":3455,\"armyMarchNum\":0,\"armyName\":\"Destructive Girl\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Transformed Girl\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Melanized Girl\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Combat Girl\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Fevered Girl\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Evolved Girl\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Dark Killer\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Dark Valkyria\"},{\"armyTrain\":710,\"armyFreeNum\":2080,\"armyMarchNum\":0,\"armyName\":\"Project Zero · Annihilate\",\"armyFinishTime\":1603918087},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Project One · Freedom\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Project One · Barrier\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Project Zero · Support\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Project Zero · Hunt\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Project One · Ambition\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Project Zero · Cleanse\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Project One · Fortress\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Project Zero · Adjudicate\"},{\"armyFreeNum\":0,\"armyMarchNum\":0,\"armyName\":\"Project One · Unyielding\"}],\"fort\":[{\"fortNum\":1620,\"fortName\":\"Lv1 Grenade\"},{\"fortNum\":0,\"fortName\":\"Lv2 Grenade\"},{\"fortNum\":0,\"fortName\":\"Lv3 Grenade\"},{\"fortNum\":0,\"fortName\":\"Lv4 Grenade\"},{\"fortNum\":0,\"fortName\":\"Lv5 Grenade\"},{\"fortNum\":0,\"fortName\":\"Lv1 Mine\"},{\"fortNum\":0,\"fortName\":\"Lv2 Mine\"},{\"fortFinishTime\":1603893275,\"fortNum\":1200,\"fortBuild\":200,\"fortName\":\"Lv3 Mine\"},{\"fortNum\":0,\"fortName\":\"Lv4 Mine\"},{\"fortNum\":0,\"fortName\":\"Lv5 Mine\"},{\"fortNum\":0,\"fortName\":\"Lv1 Firebomb\"},{\"fortNum\":0,\"fortName\":\"Lv2 Firebomb\"},{\"fortNum\":0,\"fortName\":\"Lv3 Firebomb\"},{\"fortNum\":0,\"fortName\":\"Lv4 Firebomb\"},{\"fortNum\":0,\"fortName\":\"Lv5 Firebomb\"}],\"building\":[{\"buildName\":\"Teaching Building\",\"lvl\":19,\"glory\":0},{\"buildName\":\"Z-11\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Embassy\",\"lvl\":18,\"glory\":0},{\"buildName\":\"Laboratory\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Storeroom\",\"lvl\":9,\"glory\":0},{\"buildName\":\"Student Union\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Shelter\",\"lvl\":9,\"glory\":0},{\"buildName\":\"Shelter\",\"lvl\":7,\"glory\":0},{\"buildName\":\"Shelter\",\"lvl\":11,\"glory\":0},{\"buildName\":\"Shelter\",\"lvl\":11,\"glory\":0},{\"buildName\":\"Shelter\",\"lvl\":7,\"glory\":0},{\"buildName\":\"Shelter\",\"lvl\":9,\"glory\":0},{\"buildName\":\"Shelter\",\"lvl\":9,\"glory\":0},{\"buildName\":\"Shelter\",\"lvl\":9,\"glory\":0},{\"buildName\":\"Clinic\",\"lvl\":5,\"glory\":0},{\"buildName\":\"Clinic\",\"lvl\":10,\"glory\":0},{\"buildName\":\"Alloy Mine\",\"lvl\":15,\"glory\":0},{\"buildName\":\"Oil Well\",\"lvl\":14,\"glory\":0},{\"buildName\":\"Oil Well\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Oil Well\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Oil Well\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Oil Well\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Steel Mill\",\"lvl\":16,\"glory\":0},{\"buildName\":\"Farm\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Farm\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Farm\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Farm\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Farm\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Farm\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Farm\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Farm\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Farm\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Farm\",\"lvl\":6,\"glory\":0},{\"buildName\":\"War Factory\",\"lvl\":14,\"glory\":0},{\"buildName\":\"Comm. Building\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Tower\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Tower\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Wall\",\"lvl\":18,\"glory\":0},{\"buildName\":\"Military Office\",\"lvl\":11,\"glory\":0},{\"buildName\":\"Mobile Team Factory\",\"lvl\":16,\"glory\":0},{\"buildName\":\"Armed Forces\",\"lvl\":16,\"glory\":0},{\"buildName\":\"Infection Institute\",\"lvl\":8,\"glory\":0},{\"buildName\":\"Logistics Center\",\"lvl\":6,\"glory\":0},{\"buildName\":\"Shrine\",\"lvl\":2,\"glory\":0},{\"buildName\":\"Armory\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Cafeteria\",\"lvl\":5,\"glory\":0},{\"buildName\":\"Prison\",\"lvl\":2,\"glory\":0},{\"buildName\":\"Clone Lab\",\"lvl\":4,\"glory\":0},{\"buildName\":\"Dorm\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Star Stone Institute\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Smelting Workshop\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Arena\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Mystical Building\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Obsidian Refine Building\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Training House\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Tech. Institute\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Project Origin Institute\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Vehicle Institute\",\"lvl\":1,\"glory\":0},{\"buildName\":\"Tech. Research Lab.\",\"lvl\":1,\"glory\":0}]}";
                sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("ppl", "DEMO");
                editor.apply();
                jsonStr = sh.makeServiceCall(url);
            }

            // Log.e(TAG, "Response from url: " + jsonStr);
            if (!jsonStr.equals("")) {
                Log.wtf("JSON",jsonStr);
                Log.wtf("-URL",url);
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);


                    // Getting JSON Array node
                    if(jsonObj.has("building")){
                        JSONArray building = jsonObj.getJSONArray("building");
                        for (int i = 0; i < building.length(); i++) {
                            JSONObject c = building.getJSONObject(i);
                            buildingName = c.getString("buildName");
                            buildingLvl = c.getInt("lvl");
                            buildingGlory = c.getInt("glory");

                            Building building1 = new Building();
                            building1.setName(c.getString("buildName"));
                            building1.setLvl(c.getInt("lvl"));
                            building1.setGlory(c.getInt("glory"));
                            buildingList.add(building1);
                        }
                    }


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
            Log.i("TOTAL_Grab","ok");
            dataRefresh();

            if (pd.isShowing()){pd.dismiss();}
        }
    }

}