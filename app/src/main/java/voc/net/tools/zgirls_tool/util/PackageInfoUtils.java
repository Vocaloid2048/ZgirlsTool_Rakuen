package voc.net.tools.zgirls_tool.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class PackageInfoUtils {
    /**
     * 獲取本地應用程式包的版本信息
     *
     * @param context
     * @return
     */

    public static String getLocalVersionNumber(Context context) {

        try {

            PackageInfo packinfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);

            String version = String.valueOf(packinfo.versionCode);

            return version;

        } catch (PackageManager.NameNotFoundException e) {

            e.printStackTrace();

            return "解析版本號失敗";

        }

    }

}