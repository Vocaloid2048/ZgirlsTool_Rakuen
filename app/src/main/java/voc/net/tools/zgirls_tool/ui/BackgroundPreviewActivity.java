package voc.net.tools.zgirls_tool.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
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
import java.io.InputStream;
import java.nio.channels.FileChannel;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.util.FileUtils;
import voc.net.tools.zgirls_tool.R;

public class BackgroundPreviewActivity extends AppCompatActivity {
    private static final int IMAGE = 1;
    private static String FileName = "background.png";
    private static String FROMPATH = "";
    private final static String TOPATH = Environment.getExternalStorageDirectory().getPath () + "/voc/zgt/background/";
    private final static String TOPATH_TMP = Environment.getExternalStorageDirectory().getPath () + "/voc/zgt/background_tmp/";
    private final static String BACKUPPATH_IMAGE = Environment.getExternalStorageDirectory().getPath () + "/voc/zgt/backup/background.png";
    private final static String BACKUPPATH = Environment.getExternalStorageDirectory().getPath () + "/voc/zgt/backup/";

    TextView rss_tv , element_tv ,ok , redo ;

    CardView rss_card , element_card ;

    Toolbar toolbar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_background_preview );
        toolbar = (Toolbar) findViewById (R.id.bgpv_toolbar);

        //build file
        String path = Environment.getExternalStorageDirectory ().getAbsolutePath ();
        int result = FileUtils.createDir(path + "/voc/zgt/background");
        showResult(result);

        //background
        String path2 = Environment.getExternalStorageDirectory ().getAbsolutePath ();
        int result2 = FileUtils.CreateFile(path2 + "/voc/zgt/background/background.png");
        showResult(result2);

        String path3 = Environment.getExternalStorageDirectory ().getAbsolutePath ();
        int result3 = FileUtils.createDir(path3 + "/voc/zgt/background_tmp/");
        showResult(result3);

        String path4 = Environment.getExternalStorageDirectory ().getAbsolutePath ();
        int result4 = FileUtils.CreateFile(path4 + "/voc/zgt/background_tmp/background.png");
        showResult(result4);

        String path5 = Environment.getExternalStorageDirectory ().getAbsolutePath ();
        int result5 = FileUtils.createDir(path5 + "/voc/zgt/backup");
        showResult(result5);

        cbg();

        try {
            String fileName = "background.png";
            SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
            String gif_png = sharedPreferences.getString("gif/png", "png");
            if (gif_png.matches("gif")){fileName = "background.gif";}
            if (gif_png.matches("png")){fileName = "background.png";}
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
        //Read
        //String fileName = "background.png";
        //        Resources res = getResources();
        //        String pathName = Environment.getExternalStorageDirectory().getPath () + "/voc/pubggamer/tmp/bg/"+ fileName;
        //        Bitmap bitmap = BitmapFactory.decodeFile(pathName);
        //        BitmapDrawable bd = new BitmapDrawable(res, bitmap);
        //        LinearLayout view = findViewById(R.id.background_line);
        //        view.setBackground (bd);

        //String fileName = "background.png";
        //        Resources res = getResources();
        //        String pathName = Environment.getExternalStorageDirectory().getPath () + "/voc/pubggamer/tmp/bg/"+ fileName;
        //        Bitmap bitmap = BitmapFactory.decodeFile(pathName);
        //        BitmapDrawable bd = new BitmapDrawable(res, bitmap);
        //        View view = findViewById(R.id.main_container);
        //        view.setBackground (bd);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.backup:
                        finish ();
                        Intent intent = new Intent(BackgroundPreviewActivity.this,BackupBackgroundPreviewActivity.class);
                        startActivity (intent);
                        return true;
                }

                return true;
            }

        });
        BackgroundReload();

    }
    /**
     * 显示结果
     * @param result 结果码
     */
    private void showResult (int result) {
        switch (result) {
            case FileUtils.FLAG_SUCCESS:
                Log.i ("File","Create success");
                break;
            case FileUtils.FLAG_EXISTS:
                Log.i ("File","Already exist");
                break;
            case FileUtils.FLAG_FAILED:
                Log.i ("File","Create failed");
                break;
        }
    }

    public void ok(View view) {
        Log.i ( "BKPV","OK");
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        if (gif_png.matches("gif")){FileName = "background.gif";}
        if (gif_png.matches("png")){FileName = "background.png";}
        if (gif_png.matches("jpg")){FileName = "background.jpg";}
        if (gif_png.matches("jpeg")){FileName = "background.jpeg";}
        File fileX = new File(Environment.getExternalStorageDirectory().getPath () + "/voc/zgt/background_tmp/"+FileName);
        copyFile(fileX, TOPATH);
        finish ();
    }

    public void cancel(View view) {
        Log.i ("BKPV","Choose again");
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //获取图片路径
        if (requestCode == IMAGE && resultCode == Activity.RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            String[] filePathColumns = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePathColumns[0]);
            String imagePath = c.getString(columnIndex);
            // FROMPATH = imagePath;
          //  File file = new File(TOPATH_IMAGE);
           // copyFile (file,BACKUPPATH);
          //  Log.e ("BACKPATH","CHECK");
            File file2 = new File(imagePath); // 此处为伪代码，实际为一个真实存在的文件，即你想复制的文件。/
            String fileExt = getFileExtension(file2);
            fileExt = fileExt.toLowerCase();
            SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("gif/png", fileExt);
            editor.apply();
            Log.i("gif/png", fileExt);
            copyFile(file2, TOPATH_TMP);
            //File file2 = new File(imagePath); // 此处为伪代码，实际为一个真实存在的文件，即你想复制的文件。
            //copyFile(file2, BACKUPPATH);
            finish ();
            Intent intent = new Intent(BackgroundPreviewActivity.this,BackgroundPreviewActivity.class);
            startActivity (intent);
            BackgroundReload();
            c.close();
        }}
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
    public boolean copyFile(File src, String destPath) {
        boolean result = false;
        if ((src == null) || (destPath== null)) {

            return result;
        }
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        if (gif_png.matches("gif")){FileName = "background.gif";}
        if (gif_png.matches("png")){FileName = "background.png";}
        if (gif_png.matches("jpg")){FileName = "background.jpg";}
        if (gif_png.matches("jpeg")){FileName = "background.jpeg";}
        File dest= new File(destPath + FileName);
        if (dest!= null && dest.exists()) {
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
    public void BackgroundReload (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.background_preview_background);

        Resources res = getResources();
        String fileNamePNG = "background.png";
        String fileNameGIF = "background.gif";
        String fileNameJPG = "background.jpg";
        String fileNameJPEG = "background.jpeg";
        String pathName = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/background_tmp/";

        Bitmap bitmap = BitmapFactory.decodeFile(pathName+fileNamePNG);
        BitmapDrawable bd = new BitmapDrawable(res, bitmap);

        Bitmap bitmap2 = BitmapFactory.decodeFile(pathName+fileNameJPG);
        BitmapDrawable bd2 = new BitmapDrawable(res, bitmap2);

        Bitmap bitmap3 = BitmapFactory.decodeFile(pathName+fileNameJPEG);
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