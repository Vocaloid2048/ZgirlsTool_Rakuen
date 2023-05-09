package voc.net.tools.zgirls_tool.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Locale;

import voc.net.tools.zgirls_tool.R;

class Question {

    String infomation ;

    String q_datalist_zh_HK = "實時為玩家提供其個人Zgirls帳戶內部分數據:\n\n" +
            " · 資源類(燃料，糧食，鋼鐵，合金，黑耀石，晶石，晶石脈，晶石族，榮耀印記，催化劑，鑽石)\n\n" +
            " · 四種機甲的等級\n\n" +
            " · 三類武器(手雷，地雷，燃燒彈)的數量\n\n" +
            " · 部隊數量(僅顯示首10種數目最多的兵種)\n\n" +
            " · ^進度(顯示兵種名稱，訓練數目，訓練剩餘時間，訓練總共的時間)\n\n" +
            " · ^啟用中的星語(顯示啟用中星語名稱及所需星石組合)\n\n" +
            " · 能力者(僅顯示能力者等級)\n\n"+
            "備註:\n\n" +
            " · 帶有\"^\"項的數據項目仍於Zgirls開發部協商，未投入服務，敬請留意 · \n\n" +
            " · 基於減低ZGT耗用的數據流量，此功能的\"實時\"更新部分將定於每三秒自動更新 · \n\n" +
            " · 你可以透過設定頁面(主頁面的齒輪按鈕)調校所需的額外功能(允許讀取玩家在Zgirls帳戶內的數據，顯示資源類數據轉變，顯示/隱藏指定類別展示，數據取值等)\n\n" +
            " · 請在使用實時數據列表前確保裝置已經連接有效的Wi-Fi/開啟流動數據\n\n" +
            " · 實時數據列表僅能在已安裝Zgirls 版本1.2.21 (或更新版本)正常運作,否則將會閃退等問題";

    String q_datalist_zh_CN = "实时为玩家提供其个人Zgirls帐户内部分数据:\n\n" +
            " · 资源类(燃料，粮食，钢铁，合金，黑耀石，晶石，晶石脉，晶石族，荣耀印记，催化剂，钻石)\n\n" +
            " · 四种机甲的等级\n\n" +
            " · 三类武器(手雷，地雷，燃烧弹)的数量\n\n" +
            " · 部队数量(仅显示首10种数目最多的兵种)\n\n" +
            " · ^进度(显示兵种名称，训练数目，训练剩余时间，训练总共的时间)\n\n" +
            " · ^启用中的星语(显示启用中星语名称及所需星石组合)\n\n" +
            " · 能力者(仅显示能力者等级)\n\n"+
            "备注:\n\n" +
            " · 带有\"^\"项的数据项目仍于Zgirls开发部协商，未投入服务，敬请留意 · \n\n" +
            " · 基于减低ZGT耗用的数据流量，此功能的\"实时\"更新部分将定于每三秒自动更新 · \n\n" +
            " · 你可以透过设定页面(主页面的齿轮按钮)调校所需的额外功能(允许读取玩家在Zgirls帐户内的数据，显示资源类数据转变，显示/隐藏指定类别展示，数据取值等)\n\n" +
            " · 请在使用实时数据列表前确保装置已经连接有效的Wi-Fi/开启流动数据\n\n" +
            " · 实时数据列表仅能在已安装Zgirls 版本1.2.21 (或更新版本)正常运作,否则将会闪退等问题";

    String q_datalist_en_US = "Provide players with some data in their personal Zgirls account in real time:\n\n" +
            " · Resources (Fuel, Food, Steel, Alloy, Obisidian, Kyanite, Kyanite basic, Kyanite Cluster, Glory Mark, Catalyst, Diamond)\n\n" +
            " · The levels of the four mechas\n\n" +
            " · The number of three types' landmine (grenades, mines, incendiary)\n\n" +
            " · Number of troops (only the first 10 types of troops with the largest number are displayed)\n\n" +
            " · ^Progress (display unit name, number of training, remaining training time, total training time)\n\n" +
            " · ^Activated Star Language (display the active Star Language name and required Star Stone's combine)\n\n" +
            " · Enablers (only display Enablers' level)\n\n"+
            "Remarks:\n\n" +
            " · The data items with \"^\" are still negotiated by Zgirls development department and have not been put into service, please pay attention. \n\n" +
            " · In order to reducing the data traffic consumed by ZGT, the \"real-time\" update part of this function will be automatically updated every three seconds.\n\n" +
            " · You can adjust the required additional functions through the settings page (the gear button on the main page) (allows to read the player's data in the Zgirls account, display the resource type data transition, show/hide the specified category display, data value, etc. )\n\n" +
            " · Please make sure that the device is connected to valid Wi-Fi /open mobile data before using the real-time data list.\n\n" +
            " · The real-time data list can only work normally when Zgirls version 1.2.21 (or later) is installed, otherwise it will crash.";



    public Question(View view ,Context context, Activity activity, int id){
        final Dialog dialog = new Dialog(activity, R.style.NormalDialogStyle_N);
        view = View.inflate(activity, R.layout.question_datalist, null);
        //TextView dc_server = view.findViewById(R.id.dc_server);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        //view.setMinimumHeight((int) (ScreenSizeUtils.getInstance(this).getScreenHeight()));
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int) (ScreenSizeUtils.getInstance(activity).getScreenWidth());
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        lp.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);
        TextView title = view.findViewById(R.id.q_title);
        TextView info = view.findViewById(R.id.q_info);
        ScrollView scrollView = view.findViewById(R.id.scrollView);
        String language = Locale.getDefault().toString();

        if (id == 0){
            if (language.contains("zh")&&language.contains("#Hant")){
                infomation = q_datalist_zh_HK;
            } else if (language.contains("zh")&&language.contains("#Hans")){
                infomation = q_datalist_zh_CN;
            } else {
                infomation = q_datalist_en_US;
            }
            title.setText(R.string.data_reader);
            info.setText(infomation);
        }

        dialog.show();

    }
}
