package voc.net.tools.zgirls_tool.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import voc.net.tools.zgirls_tool.R;
import voc.net.tools.zgirls_tool.ui.DataListActivity;

public class SuspensionTakeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swing);
        View v = new View(this);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            Context context = v.getContext();


            if(!Settings.canDrawOverlays(context)){
                Toast.makeText(context, "can not DrawOverlays", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + SuspensionTakeActivity.this.getPackageName()));
                startActivityForResult(intent, 1);
            } else {
                finish();
                WindowUtils.showPopupWindow(context);
            }
        }else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            Log.i("FF","RR");
            Toast.makeText(this, "Sorry but this function only support > API 25", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, DataListActivity.class);
            startActivity(intent);
        }
    }
    }
