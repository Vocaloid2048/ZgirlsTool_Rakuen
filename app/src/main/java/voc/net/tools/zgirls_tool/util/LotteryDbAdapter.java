package voc.net.tools.zgirls_tool.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;


public class LotteryDbAdapter {

    String  equip_id , equip_rare1, equip_rare2, equip_rare3, equip_rare4, equip_rare5, equip_rare6, equip_rare7;

    StringBuffer bufferITEM_ID= new StringBuffer();
    StringBuffer bufferITEM_RARE1= new StringBuffer();
    StringBuffer bufferITEM_RARE2= new StringBuffer();
    StringBuffer bufferITEM_RARE3= new StringBuffer();
    StringBuffer bufferITEM_RARE4= new StringBuffer();
    StringBuffer bufferITEM_RARE5= new StringBuffer();
    StringBuffer bufferITEM_RARE6= new StringBuffer();
    StringBuffer bufferITEM_RARE7= new StringBuffer();

    LotteryDbHelper myhelper;
    public LotteryDbAdapter(Context context)
    {
        myhelper = new LotteryDbHelper(context);
    }


    public String getItem()
    {
        String DataBasePath = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/lottery/lottery.db";

        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(DataBasePath, null);

        String[] columns1 = {LotteryDbHelper.ITEM_ID, LotteryDbHelper.ITEM_RARE1, LotteryDbHelper.ITEM_RARE2, LotteryDbHelper.ITEM_RARE3, LotteryDbHelper.ITEM_RARE4, LotteryDbHelper.ITEM_RARE5, LotteryDbHelper.ITEM_RARE6, LotteryDbHelper.ITEM_RARE7};

        Cursor cursor = db.query(LotteryDbHelper.TABLE_NAME1,columns1,null,null,null,null,null);

        StringBuffer buffer= new StringBuffer();

        while (cursor.moveToNext()) {
            equip_id = cursor.getString(cursor.getColumnIndex(LotteryDbHelper.ITEM_ID));
            equip_rare1 = cursor.getString(cursor.getColumnIndex(LotteryDbHelper.ITEM_RARE1));
            equip_rare2 = cursor.getString(cursor.getColumnIndex(LotteryDbHelper.ITEM_RARE2));
            equip_rare3 = cursor.getString(cursor.getColumnIndex(LotteryDbHelper.ITEM_RARE3));
            equip_rare4 = cursor.getString(cursor.getColumnIndex(LotteryDbHelper.ITEM_RARE4));
            equip_rare5 = cursor.getString(cursor.getColumnIndex(LotteryDbHelper.ITEM_RARE5));
            equip_rare6 = cursor.getString(cursor.getColumnIndex(LotteryDbHelper.ITEM_RARE6));
            equip_rare7 = cursor.getString(cursor.getColumnIndex(LotteryDbHelper.ITEM_RARE7));
            buffer.append(equip_id + "   " + equip_rare1 + "   " + equip_rare2 + "   "+ equip_rare3 + "   "+ equip_rare4 + "   "+ equip_rare5 + "   "+ equip_rare6 + "   "+ equip_rare7+ " \n");
            bufferITEM_ID.append(equip_id+" \n");
            bufferITEM_RARE1.append(equip_rare1+" \n");
            bufferITEM_RARE2.append(equip_rare2+" \n");
            bufferITEM_RARE3.append(equip_rare3+" \n");
            bufferITEM_RARE4.append(equip_rare4+" \n");
            bufferITEM_RARE5.append(equip_rare5+" \n");
            bufferITEM_RARE6.append(equip_rare6+" \n");
            bufferITEM_RARE7.append(equip_rare7+" \n");
        }
        cursor.close();
        db.close();
        return buffer.toString();

    }

    public String DataItemRare1 () {return bufferITEM_RARE1.toString() ;}
    public String DataItemRare2 () {return bufferITEM_RARE2.toString() ;}
    public String DataItemRare3 () {return bufferITEM_RARE3.toString() ;}
    public String DataItemRare4 () {return bufferITEM_RARE4.toString() ;}
    public String DataItemRare5 () {return bufferITEM_RARE5.toString() ;}
    public String DataItemRare6 () {return bufferITEM_RARE6.toString() ;}
    public String DataItemRare7 () {return bufferITEM_RARE7.toString() ;}

    static class LotteryDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "lottery";    // Database Name
        private static final String TABLE_NAME1 = "EQUIPMENT";   // Table Name
        private static final int DATABASE_Version = 1;    // Database Version

        //TABLE01
        private static final String ITEM_ID ="id";
        private static final String ITEM_RARE1 ="Rare1";
        private static final String ITEM_RARE2 ="Rare2";
        private static final String ITEM_RARE3 ="Rare3";
        private static final String ITEM_RARE4 ="Rare4";
        private static final String ITEM_RARE5 ="Rare5";
        private static final String ITEM_RARE6 ="Rare6";
        private static final String ITEM_RARE7 ="Rare7";

        private static final String CREATE_TABLE1 = "CREATE TABLE "+TABLE_NAME1+
                " ("+ITEM_ID+" INTEGER , "+ITEM_RARE1+" INTEGER ,"+ITEM_RARE2+" INTEGER ,"+ITEM_RARE3+" INTEGER ,"+ITEM_RARE4+" INTEGER ,"+ITEM_RARE5+" INTEGER ,"+ITEM_RARE6+" INTEGER ,"+ ITEM_RARE7+" INTEGER)";
        private static final String DROP_TABLE1 ="DROP TABLE IF EXISTS "+TABLE_NAME1;

        private Context context;

        public LotteryDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE1);
            } catch (Exception e) {
                Message.message(context,""+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Message.message(context,"OnUpgrade");
                db.execSQL(DROP_TABLE1);
                onCreate(db);
            }catch (Exception e) {
                Message.message(context,""+e);
            }
        }
    }
}