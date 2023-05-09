package voc.net.tools.zgirls_tool.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import voc.net.tools.zgirls_tool.R;
import voc.net.tools.zgirls_tool.ui.DeskActivity;

import static voc.net.tools.zgirls_tool.ui.SplashActivity.CHANNEL_ID;

public class UpdateService extends Service {
    private static final String TAG = "UpdateService";
    private Timer timer;
    Context mContext;
    private boolean hasStarted = false;
    long t  ;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this ;


        Date date = Calendar.getInstance().getTime();
        DateFormat formatter = new SimpleDateFormat("dd");
        String DTE = formatter.format(date);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        t = c.get(Calendar.HOUR_OF_DAY) * 10000000 + c.get(Calendar.MINUTE)*100000+c.get(Calendar.SECOND)*1000+c.get(Calendar.MILLISECOND);

    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String input = intent.getStringExtra("inputExtra");
        mHandler.sendEmptyMessageDelayed(GOTO_MAIN_ACTIVITY, 2500);
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
    public void NOTHING(){if (t<130000000){mHandler.sendEmptyMessageDelayed(GOTO_MAIN_ACTIVITY, (130000000-t));}else if (t>130000000){mHandler.sendEmptyMessageDelayed(GOTO_MAIN_ACTIVITY, (t-130000000));}}
    private static final int GOTO_MAIN_ACTIVITY = 0;
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {

            switch (msg.what) {
                case GOTO_MAIN_ACTIVITY:
                    new CheckUpdate().execute();
                    break;

                default:
                    break;
            }
        }

    };
    private final class CheckUpdate extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            for (int i = 1; i < 2; i++) {
                try {
                    String VersionName ;
                    String downloadpath;
                    int file_size = 100 ;
                    int zipped_size = 0 ;
                    int localversion = Integer.parseInt(PackageInfoUtils.getLocalVersionNumber(mContext));
                    SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
                    boolean download_beta = sharedPreferences.getBoolean("download_beta", false);
                    String path = "http://vt.25u.com/vt/zgt/server_update_info.json";
                    URL url = new URL(path);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    int code = 0 ;
                    code =  connection.getResponseCode();
                    if (code == 200) {
                        InputStream is = connection.getInputStream();
                        String result = StreamTools.readStream(is);
                        JSONObject json = new JSONObject(result);
                        String serverVersion = json.getString("version");
                        String description = json.getString("description");
                        VersionName = json.getString("verName");
                        downloadpath = json.getString("downloadpath");
                        String status = json.getString("status");
                        Log.e(TAG , "新版本下載路徑：" + downloadpath);
                        int serverversion = Integer.parseInt(serverVersion);

                        if (serverversion > localversion){
                            if (download_beta && status.equals("beta")){
                                Log.e(TAG, "版本號不一致，提示用戶升級");
                                NotificationManager notificationManager = (NotificationManager)
                                        UpdateService.this.getSystemService(NOTIFICATION_SERVICE);
                                Intent notificationIntent = new Intent(UpdateService.this, DeskActivity.class);
                                PendingIntent pendingIntent = PendingIntent.getActivity(UpdateService.this, 0, notificationIntent, 0);
                                Notification notification = null;

                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {//判断API
                                    String name = getString(R.string.app_name);
                                    NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_LOW);
                                    notificationManager.createNotificationChannel(mChannel);
                                    Notification notification2 = new NotificationCompat.Builder(UpdateService.this)
                                            .setChannelId(CHANNEL_ID)
                                            .setContentTitle(VersionName+" "+getString(R.string.update))
                                            .setContentText(description)
                                            .setContentIntent(pendingIntent)
                                            .setStyle(new NotificationCompat.BigTextStyle().bigText(description))
                                            .setSmallIcon(R.drawable.app_icon_round)
                                            .build();
                                    startForeground(1,notification2);

                                }else{
                                    NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(UpdateService.this)
                                            .setContentTitle(VersionName+" "+getString(R.string.update))
                                            .setContentText(description)
                                            .setSmallIcon(R.drawable.app_icon_round)
                                            .setOngoing(true)
                                            .setChannelId(CHANNEL_ID)//无效
                                            .setStyle(new NotificationCompat.BigTextStyle().bigText(description))
                                            .setContentIntent(pendingIntent);
                                    notification = notificationBuilder.build();
                                    startForeground(1,notification);
                                }
                            }
                            else if (status.equals("release")){
                                Log.e(TAG, "版本號不一致，提示用戶升級");
                                NotificationManager notificationManager = (NotificationManager)
                                        UpdateService.this.getSystemService(NOTIFICATION_SERVICE);
                                Intent notificationIntent = new Intent(UpdateService.this, DeskActivity.class);
                                PendingIntent pendingIntent = PendingIntent.getActivity(UpdateService.this, 0, notificationIntent, 0);
                                Notification notification = null;

                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {//判断API
                                    String name = getString(R.string.app_name);
                                    NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_LOW);
                                    notificationManager.createNotificationChannel(mChannel);
                                    Notification notification2 = new NotificationCompat.Builder(UpdateService.this)
                                            .setChannelId(CHANNEL_ID)
                                            .setContentTitle(VersionName+" "+getString(R.string.update))
                                            .setContentText(description)
                                            .setContentIntent(pendingIntent)
                                            .setStyle(new NotificationCompat.BigTextStyle().bigText(description))
                                            .setSmallIcon(R.drawable.app_icon_round)
                                            .build();
                                    startForeground(1,notification2);

                                }else{
                                    NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(UpdateService.this)
                                            .setContentTitle(VersionName+" "+getString(R.string.update))
                                            .setContentText(description)
                                            .setSmallIcon(R.drawable.app_icon_round)
                                            .setOngoing(true)
                                            .setChannelId(CHANNEL_ID)//无效
                                            .setStyle(new NotificationCompat.BigTextStyle().bigText(description))
                                            .setContentIntent(pendingIntent);
                                    notification = notificationBuilder.build();
                                    startForeground(1,notification);
                                }
                            }
                            else {Log.e(TAG, "版本號不一致，BETA用戶不升級");
                                NotificationManager notificationManager = (NotificationManager) UpdateService.this.getSystemService(NOTIFICATION_SERVICE);
                                Intent notificationIntent = new Intent(UpdateService.this, DeskActivity.class);
                                PendingIntent pendingIntent = PendingIntent.getActivity(UpdateService.this, 0, notificationIntent, 0);
                                Notification notification = null;

                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {//判断API
                                    String name = getString(R.string.app_name);
                                    NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_LOW);
                                    notificationManager.createNotificationChannel(mChannel);
                                    notification = new Notification.Builder(UpdateService.this)
                                            .setChannelId(CHANNEL_ID)
                                            .setContentTitle(getString(R.string.update_checking))
                                            .setSmallIcon(R.drawable.app_icon_round)
                                            .build();
                                    startForeground(1,notification);

                                }else{
                                    NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(UpdateService.this)
                                            .setContentTitle(getString(R.string.update_checking))
                                            .setSmallIcon(R.drawable.app_icon_round)
                                            .setOngoing(true)
                                            .setChannelId(CHANNEL_ID);//无效

                                    notification = notificationBuilder.build();
                                    startForeground(1,notification);
                                }}


                        }
                        if (serverversion <= localversion){
                            Log.e(TAG, "版本號一致");
                            NotificationManager notificationManager = (NotificationManager) UpdateService.this.getSystemService(NOTIFICATION_SERVICE);
                            Intent notificationIntent = new Intent(UpdateService.this, DeskActivity.class);
                            PendingIntent pendingIntent = PendingIntent.getActivity(UpdateService.this, 0, notificationIntent, 0);
                            Notification notification = null;

                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {//判断API
                                String name = getString(R.string.app_name);
                                NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_LOW);
                                notificationManager.createNotificationChannel(mChannel);
                                notification = new Notification.Builder(UpdateService.this)
                                        .setChannelId(CHANNEL_ID)
                                        .setContentTitle(getString(R.string.update_checking))
                                        .setSmallIcon(R.drawable.app_icon_round)
                                        .build();
                                startForeground(1,notification);

                            }else{
                                NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(UpdateService.this)
                                        .setContentTitle(getString(R.string.update_checking))
                                        .setSmallIcon(R.drawable.app_icon_round)
                                        .setOngoing(true)
                                        .setChannelId(CHANNEL_ID);//无效

                                notification = notificationBuilder.build();
                                startForeground(1,notification);
                            }
                        }

                        try {
                            URL myUrl = new URL(downloadpath);
                            URLConnection urlConnection = myUrl.openConnection();
                            urlConnection.connect();
                            file_size = urlConnection.getContentLength();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Log.e("ERROR" , "410 Gone");
                    }
                } catch (Resources.NotFoundException e) {
                    Log.e("ERROR" , "404 Not Found");
                    e.printStackTrace();
                } catch (MalformedURLException e) {
                    Log.e("ERROR" , "405 Method Not Allowed");
                    e.printStackTrace();
                } catch (IOException e) {
                    Log.e("ERROR" , "408 Request Timeout");
                    e.printStackTrace();
                } catch (JSONException e) {
                    Log.e("ERROR" , "409 Conflict");
                    e.printStackTrace();
                }
                NOTHING();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void v) {
        }
    }


}
