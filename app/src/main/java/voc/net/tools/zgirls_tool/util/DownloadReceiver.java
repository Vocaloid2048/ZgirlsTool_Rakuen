package voc.net.tools.zgirls_tool.util;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.File;

public class DownloadReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(action)) {
            Intent intent1 = new Intent(Intent.ACTION_INSTALL_PACKAGE);
            intent1.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent1.setDataAndType(Uri.fromFile(new File(Environment.getExternalStorageDirectory() + "/download/" +"zgt_update.apk")), "application/vnd.android.package-archive");
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
            Log.i("OK","OK");
        }
    }
}