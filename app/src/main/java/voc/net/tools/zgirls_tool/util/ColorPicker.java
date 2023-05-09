package voc.net.tools.zgirls_tool.util;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import voc.net.tools.zgirls_tool.R;


public class ColorPicker extends AppCompatActivity {

    ImageView Choose_img ;
    TextView Hex ;
    View Color_result ;
String pixel2 ;
    Bitmap bitmap ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);

        Choose_img = findViewById(R.id.color_choose_img);
        Hex = findViewById(R.id.color_hex);
        Color_result = findViewById(R.id.colorView);

        String fileName = "background.png";
        Resources res = getResources();
        String pathName = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/background/" + fileName;
        Bitmap bitmap2 = BitmapFactory.decodeFile(pathName);
        BitmapDrawable bd = new BitmapDrawable(res, bitmap2);
      //  ImageView view = findViewById(R.id.color_bg);
      //  view.setImageDrawable(bd);

        Choose_img.setDrawingCacheEnabled(true);
        Choose_img.buildDrawingCache(true);

        Choose_img.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN || motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
                    bitmap = Choose_img.getDrawingCache();

                    if (bitmap.getHeight() > motionEvent.getY() && motionEvent.getY() >= 0 && motionEvent.getX() >= 0 && bitmap.getWidth() > motionEvent.getX() ) {
                        int pixel = bitmap.getPixel((int) motionEvent.getX() , (int) motionEvent.getY());
                        String hex = Integer.toHexString(pixel);

                        int r = Color.red(pixel);
                        int g = Color.green(pixel);
                        int b = Color.blue(pixel);

                        Color_result.setBackgroundColor(Color.rgb(r,g,b));

                        Hex.setText("Color : "+Integer.toHexString(pixel));

                        pixel2 = Integer.toHexString(pixel).substring(2, 8);
                    }else {
                        Log.i("BITMAP","Over layout");
                    }

                }
                return true;
            }
        });


    }
    public void color01(View view) {
        Intent intent = new Intent();
        intent.putExtra("color01", pixel2);
        setResult(RESULT_OK, intent);
        finish();
    }
    public void color02(View view) {
        Intent intent = new Intent();
        intent.putExtra("color02", pixel2);
        setResult(RESULT_OK, intent);
        finish();
    }
}