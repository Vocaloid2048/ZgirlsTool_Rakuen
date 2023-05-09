package voc.net.tools.zgirls_tool.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.R;
import voc.net.tools.zgirls_tool.util.Version;
import voc.net.tools.zgirls_tool.util.VersionAdapter;

public class AboutActivity extends AppCompatActivity {

    private RecyclerView mList;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<voc.net.tools.zgirls_tool.util.Version> versionList;
    private RecyclerView.Adapter adapter;
    private VersionAdapter mAdapter;

    public String date , IconId , Version , VerName , Desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        versionList = new ArrayList<>();
        mList = findViewById(R.id.version_list);
        mAdapter = new VersionAdapter(getApplicationContext(), versionList);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(), linearLayoutManager.getOrientation());
        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(mAdapter);
        okhttpDate();
        BackgroundReload();
    }
    public void copy01 (View view){
        String info1 = "Device Model : " + android.os.Build.MODEL;
        String info2 = "Device SDK : " + android.os.Build.VERSION.SDK_INT;
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","voc.app.programmer@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "#Zgirls Tool");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Advices to ZGT Dev : "+"\n"+"----------------\n"+info1+"\n"+info2);
        startActivity(Intent.createChooser(emailIntent, "Advice"));
        //voc.app.programmer@gmail.com
    }
    public void copy02 (View view){
        //Voc-夜芷冰#2512
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Discord ID", "Voc-夜芷冰#2512");
        clipboard.setPrimaryClip(clip);
        Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show();
    }
    public void copy03 (View view){
        Intent i = new Intent(android.content.Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://play.google.com/store/apps/details?id=voc.net.tools.zgirls_tool"));
        startActivity(i);
    }

    public void BackgroundReload (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.about_bg);

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
    private void okhttpDate() {
        // version = android.os.Build.VERSION.SDK_INT;
        Log.i("TAG", "--ok-");
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                String url = "http://vt.25u.com/vt/zgt/about.json";
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
                    Version = object.getString("version");
                    VerName = object.getString("verName");
                    Desc = object.getString("description");
                    IconId = object.getString("ic_code");


                    Version version = new Version();
                    version.setVerName(object.getString("verName"));
                    version.setVersion(object.getString("version"));
                    version.setDescription(object.getString("description"));
                    version.setIconId(object.getString("ic_code"));
                    versionList.add(version);

                }
                //    progressDialog.dismiss();

                android.os.Message msg = new Message();
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
                            AboutActivity.this, DividerItemDecoration.VERTICAL));
                    //设置布局显示格式
                    mList.setLayoutManager(new LinearLayoutManager(AboutActivity.this));
                    mList.setAdapter(mAdapter);
                    String ITEM_SIZE = String.valueOf(versionList.size());
                    break;
            }
        }
    };

    public void zgt (View view){
        String url = "https://discord.gg/kuJrQ4NHBD";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    public void wlz (View view){
        String url = "https://discord.gg/UztYHEE";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}