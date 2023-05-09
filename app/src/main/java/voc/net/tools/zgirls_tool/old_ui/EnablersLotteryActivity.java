package voc.net.tools.zgirls_tool.old_ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.R;

public class EnablersLotteryActivity extends AppCompatActivity {
    ImageView img , bg;
    String URL ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enablers_lottery);
        img = findViewById(R.id.lottery_bg3);
        BackgroundReload();
    }
    public void BackgroundReload (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.lottery_bg2);

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

    public void lt2 (View view){
        int enabler = (int) (Math.random() * 47);

        if(enabler == 0){URL = "/voc/zgt/enablers/saki.png";}
        if(enabler == 1){URL = "/voc/zgt/enablers/fudo.png";}
        if(enabler == 2){URL = "/voc/zgt/enablers/masami.png";}
        if(enabler == 3){URL = "/voc/zgt/enablers/carol.png";}
        if(enabler == 4){URL = "/voc/zgt/enablers/uzuki.png";}
        if(enabler == 5){URL = "/voc/zgt/enablers/sara.png";}
        if(enabler == 6){URL = "/voc/zgt/enablers/sariko.png";}
        if(enabler == 7){URL = "/voc/zgt/enablers/chika.png";}
        if(enabler == 8){URL = "/voc/zgt/enablers/kirine.png";}
        if(enabler == 9){URL = "/voc/zgt/enablers/hiyori.png";}
        if(enabler == 10){URL = "/voc/zgt/enablers/mio.png";}
        if(enabler == 11){URL = "/voc/zgt/enablers/izumi.png";}
        if(enabler == 12){URL = "/voc/zgt/enablers/gin.png";}
        if(enabler == 13){URL = "/voc/zgt/enablers/nana.png";}
        if(enabler == 14){URL = "/voc/zgt/enablers/sumika.png";}
        if(enabler == 15){URL = "/voc/zgt/enablers/kayo.png";}
        if(enabler == 16){URL = "/voc/zgt/enablers/youko.png";}
        if(enabler == 17){URL = "/voc/zgt/enablers/saori.png";}
        if(enabler == 18){URL = "/voc/zgt/enablers/comet.png";}
        if(enabler == 19){URL = "/voc/zgt/enablers/donner.png";}
        if(enabler == 20){URL = "/voc/zgt/enablers/minami.png";}
        if(enabler == 21){URL = "/voc/zgt/enablers/chen.png";}
        if(enabler == 22){URL = "/voc/zgt/enablers/eleanor.png";}
        if(enabler == 23){URL = "/voc/zgt/enablers/zero.png";}
        if(enabler == 24){URL = "/voc/zgt/enablers/ana_o.png";}
        if(enabler == 25){URL = "/voc/zgt/enablers/odelia.png";}
        if(enabler == 26){URL = "/voc/zgt/enablers/zrs_2.png";}
        if(enabler == 27){URL = "/voc/zgt/enablers/liuk.png";}
        if(enabler == 28){URL = "/voc/zgt/enablers/akiyama.png";}
        if(enabler == 29){URL = "/voc/zgt/enablers/esther.png";}
        if(enabler == 30){URL = "/voc/zgt/enablers/alice.png";}
        if(enabler == 31){URL = "/voc/zgt/enablers/yesi.png";}
        if(enabler == 32){URL = "/voc/zgt/enablers/shiori.png";}
        if(enabler == 33){URL = "/voc/zgt/enablers/misaki.png";}
        if(enabler == 34){URL = "/voc/zgt/enablers/risa.png";}
        if(enabler == 35){URL = "/voc/zgt/enablers/mika.png";}
        if(enabler == 36){URL = "/voc/zgt/enablers/mira.png";}
        if(enabler == 37){URL = "/voc/zgt/enablers/raly.png";}
        if(enabler == 38){URL = "/voc/zgt/enablers/celesia.png";}
        if(enabler == 39){URL = "/voc/zgt/enablers/chiyo.png";}
        if(enabler == 40){URL = "/voc/zgt/enablers/kurul.png";}
        if(enabler == 41){URL = "/voc/zgt/enablers/kuroda.png";}
        if(enabler == 42){URL = "/voc/zgt/enablers/catherine.png";}
        if(enabler == 43){URL = "/voc/zgt/enablers/shirley.png";}
        if(enabler == 44){URL = "/voc/zgt/enablers/lois.png";}
        if(enabler == 45){URL = "/voc/zgt/enablers/iris.png";}
        if(enabler == 46){URL = "/voc/zgt/enablers/sylvia.png";}
        if(enabler == 47){URL = "/voc/zgt/enablers/narumi.png";}


        ReadImageTask(URL);
    }

        public void ReadImageTask (String url){
        Resources res = getResources();
        String pathName = Environment.getExternalStorageDirectory().getPath() + url;
        Bitmap bitmap = BitmapFactory.decodeFile(pathName);
        BitmapDrawable bd = new BitmapDrawable(res, bitmap);
        ImageView view2 = findViewById(R.id.lottery_bg3);
        view2.setImageDrawable(bd);

    }

}