package voc.net.tools.zgirls_tool.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import voc.net.tools.zgirls_tool.R;

import static voc.net.tools.zgirls_tool.ui.DeskActivity.CHANNEL_ID;

public class WIFI_Warning extends Service {

    private static final String TAG = "WIFI_Warning";
    Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this ;

    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String input = intent.getStringExtra("inputExtra");
        wifi();
        return START_NOT_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public void wifi(){

        NotificationManager notificationManager = (NotificationManager)
                WIFI_Warning.this.getSystemService(NOTIFICATION_SERVICE);
        Intent notificationIntent = new Intent(Settings.ACTION_WIFI_SETTINGS);
        PendingIntent pendingIntent = PendingIntent.getActivity(WIFI_Warning.this, 0, notificationIntent, 0);
        Notification notification = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {//判断API
            String name = getString(R.string.app_name);
            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_LOW);
            notificationManager.createNotificationChannel(mChannel);
            Notification notification2 = new NotificationCompat.Builder(WIFI_Warning.this)
                    .setChannelId(CHANNEL_ID)
                    .setContentTitle("NETWORK WARNING")
                    .setContentText("You must turn on your WIFI / Mobile Data !")
                    .setContentIntent(pendingIntent)
                    .setSmallIcon(R.drawable.app_icon_round)
                    .setAutoCancel(true)
                    .setOngoing(false)
                    .build();
            startForeground(1,notification2);

        }else{
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(WIFI_Warning.this)
                    .setContentTitle("NETWORK WARNING")
                    .setContentText("You must turn on your WIFI / Mobile Data !")
                    .setSmallIcon(R.drawable.app_icon_round)
                    .setOngoing(false)
                    .setAutoCancel(true)
                    .setChannelId(CHANNEL_ID)//无效
                    .setContentIntent(pendingIntent);
            notification = notificationBuilder.build();
            startForeground(1,notification);
        }
    }
}
