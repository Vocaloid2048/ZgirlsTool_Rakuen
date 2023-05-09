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
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.R;

public class BackupBackgroundPreviewActivity extends AppCompatActivity {
    private final static String TOPATH = Environment.getExternalStorageDirectory().getPath () + "/voc/zgt/background/";
    private final static String BACKUPPATH_IMAGE = Environment.getExternalStorageDirectory().getPath () + "/voc/zgt/backup/";
    private static String FileName = "background.png";

    TextView rss_tv , element_tv ,ok , redo ;

    CardView rss_card , element_card ;

    Toolbar toolbar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backup_background_preview);
        toolbar = findViewById(R.id.bubgpv_toolbar);
        BackgroundReload();
        cbg();
    }



    public void set(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("last_gif/png", "png");
        if (gif_png.matches("gif")){FileName = "background.gif";}
        if (gif_png.matches("png")){FileName = "background.png";}
        if (gif_png.matches("jpg")){FileName = "background.jpg";}
        if (gif_png.matches("jpeg")){FileName = "background.jpeg";}
        File file = new File(BACKUPPATH_IMAGE+FileName); // 此处为伪代码，实际为一个真实存在的文件，即你想复制的文件。/
        copyFile(file, TOPATH);
        SharedPreferences.Editor editor3 = sharedPreferences.edit();
        editor3.putString("gif/png", gif_png);
        editor3.apply();
        finish ();
    }

    public void back(View view) {
        finish ();
        Intent intent = new Intent(BackupBackgroundPreviewActivity.this,BackgroundPreviewActivity.class);
        startActivity (intent);
    }
    public boolean copyFile(File src, String destPath) {
        boolean result = false;
        if ((src == null) || (destPath == null)) {
            return result;
        }
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("last_gif/png", "png");
        if (gif_png.matches("gif")){FileName = "background.gif";}
        if (gif_png.matches("png")){FileName = "background.png";}
        if (gif_png.matches("jpg")){FileName = "background.jpg";}
        if (gif_png.matches("jpeg")){FileName = "background.jpeg";}
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
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            Log.i("BACK","BAN");
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    public void BackgroundReload (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("last_gif/png", "png");
        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.bubgpv);

        Resources res = getResources();
        String fileNamePNG = "background.png";
        String fileNameGIF = "background.gif";
        String fileNameJPG = "background.jpg";
        String pathName = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/backup/";

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
    public void cbg() {
        //取出数据（注意这里直接用实例取就行了，不用获取编辑器editor）
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String theme = sharedPreferences.getString("theme", "dark");
        String color1 = sharedPreferences.getString("color1", "F1870F");
        String color2 = sharedPreferences.getString("color2", "C56E0D");
        rss_card = findViewById(R.id.rss_card);
        element_card = findViewById(R.id.element_card);
        rss_tv = findViewById(R.id.rss);
        element_tv = findViewById(R.id.element);
        ok = findViewById(R.id.ok_bubkpv);
        redo = findViewById(R.id.cancel_bubkpv);

        if (theme.equals("base")) {
            rss_card.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            rss_tv.setBackgroundColor(getResources().getColor(R.color.background_base_press));
            element_card.setCardBackgroundColor(getResources().getColor(R.color.background_base_alpha));
            element_tv.setBackgroundColor(getResources().getColor(R.color.background_base_press));
            toolbar.setBackgroundColor(getResources().getColor(R.color.background_base_press));
            ok.setBackgroundColor(getResources().getColor(R.color.background_base_press));
            redo.setBackgroundColor(getResources().getColor(R.color.background_base_press));
        }

        if (theme.equals("dark")) {
            rss_card.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            rss_tv.setBackgroundColor(getResources().getColor(R.color.background_dark_press));
            element_card.setCardBackgroundColor(getResources().getColor(R.color.background_dark_alpha));
            element_tv.setBackgroundColor(getResources().getColor(R.color.background_dark_press));
            toolbar.setBackgroundColor(getResources().getColor(R.color.background_dark_press));
            ok.setBackgroundColor(getResources().getColor(R.color.background_dark_press));
            redo.setBackgroundColor(getResources().getColor(R.color.background_dark_press));
        }

        if (theme.equals("pink")) {
            rss_card.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            rss_tv.setBackgroundColor(getResources().getColor(R.color.background_pink_press));
            element_card.setCardBackgroundColor(getResources().getColor(R.color.background_pink_alpha));
            element_tv.setBackgroundColor(getResources().getColor(R.color.background_pink_press));
            toolbar.setBackgroundColor(getResources().getColor(R.color.background_pink_press));
            ok.setBackgroundColor(getResources().getColor(R.color.background_pink_press));
            redo.setBackgroundColor(getResources().getColor(R.color.background_pink_press));
        }

        if (theme.equals("leek")) {
            rss_card.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            rss_tv.setBackgroundColor(getResources().getColor(R.color.background_leek_press));
            element_card.setCardBackgroundColor(getResources().getColor(R.color.background_leek_alpha));
            element_tv.setBackgroundColor(getResources().getColor(R.color.background_leek_press));
            toolbar.setBackgroundColor(getResources().getColor(R.color.background_leek_press));
            ok.setBackgroundColor(getResources().getColor(R.color.background_leek_press));
            redo.setBackgroundColor(getResources().getColor(R.color.background_leek_press));
        }

        if (theme.equals("summer")) {
            rss_card.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            rss_tv.setBackgroundColor(getResources().getColor(R.color.background_summer_press));
            element_card.setCardBackgroundColor(getResources().getColor(R.color.background_summer_alpha));
            element_tv.setBackgroundColor(getResources().getColor(R.color.background_summer_press));
            toolbar.setBackgroundColor(getResources().getColor(R.color.background_summer_press));
            ok.setBackgroundColor(getResources().getColor(R.color.background_summer_press));
            redo.setBackgroundColor(getResources().getColor(R.color.background_summer_press));
        }

        if (theme.equals("custom")) {
            rss_card.setCardBackgroundColor(Color.parseColor("#CC" + color1));
            rss_tv.setBackgroundColor(Color.parseColor("#" + color2));
            element_card.setCardBackgroundColor(Color.parseColor("#CC" + color1));
            element_tv.setBackgroundColor(Color.parseColor("#" + color2));
            toolbar.setBackgroundColor(Color.parseColor("#" + color2));
            ok.setBackgroundColor(Color.parseColor("#" + color2));
            redo.setBackgroundColor(Color.parseColor("#" + color2));
        }
    }
}
