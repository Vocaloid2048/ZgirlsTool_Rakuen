package voc.net.tools.zgirls_tool.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import voc.net.tools.zgirls_tool.R;

public class ReadActivity extends AppCompatActivity {
    String link,name;
    TextView name_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        Intent intent = getIntent();
        link = intent.getStringExtra("Link");
        name = intent.getStringExtra("Name");

        name_tv = findViewById(R.id.name_tv2);
        name_tv.setText("  "+name);
        cbg();

        if (link.toLowerCase().contains("https://drive.google.com/file")){

            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.chrome");
            launchIntent.setData(Uri.parse(link));
            if (launchIntent != null) {
                finish();
                startActivity(launchIntent);//null pointer check in case package name was not found
            }

        }else{

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl(link);

        }
    }

    public void cbg() {
        //取出数据（注意这里直接用实例取就行了，不用获取编辑器editor）
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String theme = sharedPreferences.getString("theme", "dark");
        String color1 = sharedPreferences.getString("color1", "F1870F");
        String color2 = sharedPreferences.getString("color2", "C56E0D");
        if (theme.equals("base")) {
            name_tv.setBackgroundColor(getResources().getColor(R.color.background_base_alpha));
        }

        if (theme.equals("dark")) {
            name_tv.setBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
        }

        if (theme.equals("pink")) {
            name_tv.setBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
        }

        if (theme.equals("leek")) {
            name_tv.setBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
        }

        if (theme.equals("summer")) {
            name_tv.setBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
        }

        if (theme.equals("custom")) {
            name_tv.setBackgroundColor(Color.parseColor(color1));
        }
    }
}
