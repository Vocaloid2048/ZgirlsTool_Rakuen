package voc.net.tools.zgirls_tool.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;


public class myDbAdapter {
    long food , fuel , steel , alloy , obsidian , kyanite , kyanite_basic , kyanite_cluster , glory_mark , catalyst ;

    String enameT ; int elevelT , epowerT ;

    String mnameT ; int mlevelT , mpowerT , menergyT;

    int exp100 , exp5K , exp10K , exp20K , exp50K , exp80K , exp100K;

    int star01 , star02 , star03 , star04 ;

    String troop;

    StringBuffer bufferENAME= new StringBuffer();
    StringBuffer bufferELEVEL= new StringBuffer();
    StringBuffer bufferEPOWER= new StringBuffer();

    StringBuffer bufferMNAME= new StringBuffer();
    StringBuffer bufferMLEVEL= new StringBuffer();
    StringBuffer bufferMENERGY= new StringBuffer();
    StringBuffer bufferMPOWER= new StringBuffer();

    StringBuffer bufferTROOP= new StringBuffer();

    Context c ;

    myDbHelper myhelper;
    public myDbAdapter(Context context)
    {
        myhelper = new myDbHelper(context);
        c = context;
    }


    public String getDataRSS()
    {
        String DataBasePath = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/database/database.db";
        String DataBaseFile = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/database";

        //try {
        //   // db_url = new URL("http://vt.25u.com/vt/zgt/databse.db");
        //    db_url = new URL("https://github.com/Vocaloid2048/Z-Girls-Tools/blob/master/database.db");
        //} catch (MalformedURLException e) {
        //    e.printStackTrace();
        //}

        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(DataBasePath, null);
        SQLiteDatabase db2 = SQLiteDatabase.openOrCreateDatabase(DataBasePath, null);
        SQLiteDatabase db3 = SQLiteDatabase.openOrCreateDatabase(DataBasePath, null);
        SQLiteDatabase db4 = SQLiteDatabase.openOrCreateDatabase(DataBasePath, null);
        SQLiteDatabase db5 = SQLiteDatabase.openOrCreateDatabase(DataBasePath, null);
        SQLiteDatabase db6 = SQLiteDatabase.openOrCreateDatabase(DataBasePath, null);
        String[] columns1 = {myDbHelper.FOOD,myDbHelper.FUEL,myDbHelper.STEEL,myDbHelper.ALLOY,myDbHelper.OBSIDIAN,myDbHelper.KYANITE,myDbHelper.KYANITE_BASIC,myDbHelper.KYANITE_CLUSTER,myDbHelper.GLORY_MARK,myDbHelper.CATALYST};
        String[] columns2 = {myDbHelper.ENAME,myDbHelper.ELEVEL,myDbHelper.EPOWER};
        String[] columns3 = {myDbHelper.ENAME,myDbHelper.ELEVEL,myDbHelper.EPOWER};
        String[] columns4 = {myDbHelper.EXP100,myDbHelper.EXP5K,myDbHelper.EXP10K,myDbHelper.EXP20K,myDbHelper.EXP50K,myDbHelper.EXP80K,myDbHelper.EXP100K};
        String[] columns5 = {myDbHelper.STAR01,myDbHelper.STAR02,myDbHelper.STAR03,myDbHelper.STAR04};
        String[] columns6 = {myDbHelper.ID,myDbHelper.NAME,myDbHelper.TROOP};

        Cursor cursor = db.query(myDbHelper.TABLE_NAME1,columns1,null,null,null,null,null);
        Cursor cursor2 = db2.query(myDbHelper.TABLE_NAME2,columns2,null,null,null,null,null);
        Cursor cursor3 = db3.query(myDbHelper.TABLE_NAME3,columns3,null,null,null,null,null);
        Cursor cursor4 = db4.query(myDbHelper.TABLE_NAME4,columns4,null,null,null,null,null);
        Cursor cursor5 = db4.query(myDbHelper.TABLE_NAME5,columns5,null,null,null,null,null);
        Cursor cursor6 = db4.query(myDbHelper.TABLE_NAME6,columns6,null,null,null,null,null);
        StringBuffer buffer= new StringBuffer();

        while (cursor.moveToNext()) {
            food = cursor.getLong(cursor.getColumnIndex(myDbHelper.FOOD));
            fuel = cursor.getLong(cursor.getColumnIndex(myDbHelper.FUEL));
            steel = cursor.getLong(cursor.getColumnIndex(myDbHelper.STEEL));
            alloy = cursor.getLong(cursor.getColumnIndex(myDbHelper.ALLOY));
            obsidian = cursor.getLong(cursor.getColumnIndex(myDbHelper.OBSIDIAN));
            kyanite = cursor.getLong(cursor.getColumnIndex(myDbHelper.KYANITE));
            kyanite_basic = cursor.getLong(cursor.getColumnIndex(myDbHelper.KYANITE_BASIC));
            kyanite_cluster = cursor.getLong(cursor.getColumnIndex(myDbHelper.KYANITE_CLUSTER));
            glory_mark = cursor.getLong(cursor.getColumnIndex(myDbHelper.GLORY_MARK));
            catalyst = cursor.getLong(cursor.getColumnIndex(myDbHelper.CATALYST));
            //        String name =cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
            //         String  password =cursor.getString(cursor.getColumnIndex(myDbHelper.MyPASSWORD));
            buffer.append(food + "   " + fuel + "   " + steel + "   " + alloy + "   " + obsidian + "   " + kyanite + "   " + kyanite_basic + "   " + kyanite_cluster + "   " + glory_mark + "   " + catalyst + " \n");
        }
        while (cursor2.moveToNext()) {
            mnameT = cursor2.getString(cursor2.getColumnIndex(myDbHelper.MNAME));
            mlevelT = cursor2.getInt(cursor2.getColumnIndex(myDbHelper.MLEVEL));
            menergyT = cursor2.getInt(cursor2.getColumnIndex(myDbHelper.MLEVEL));
            mpowerT = cursor2.getInt(cursor2.getColumnIndex(myDbHelper.MPOWER));
            buffer.append(mnameT+ "   " + mlevelT + "   " +menergyT+ "   " + mpowerT +" \n");
            bufferMNAME.append(mnameT+" \n");
            bufferMPOWER.append(mpowerT+" \n");
            bufferMLEVEL.append(mlevelT+" \n");
            bufferMENERGY.append(menergyT+" \n");

        }

        while (cursor3.moveToNext()) {
            enameT = cursor3.getString(cursor3.getColumnIndex(myDbHelper.ENAME));
            elevelT = cursor3.getInt(cursor3.getColumnIndex(myDbHelper.ELEVEL));
            epowerT = cursor3.getInt(cursor3.getColumnIndex(myDbHelper.EPOWER));
            buffer.append(enameT+ "   " + elevelT + "   " + epowerT +" \n");
            bufferENAME.append(enameT+" \n");
            bufferEPOWER.append(epowerT+" \n");
            bufferELEVEL.append(elevelT+" \n");
        }
        while (cursor4.moveToNext()) {
            exp100 = cursor4.getInt(cursor4.getColumnIndex(myDbHelper.EXP100));
            exp5K = cursor4.getInt(cursor4.getColumnIndex(myDbHelper.EXP5K));
            exp10K = cursor4.getInt(cursor4.getColumnIndex(myDbHelper.EXP10K));
            exp20K = cursor4.getInt(cursor4.getColumnIndex(myDbHelper.EXP20K));
            exp50K = cursor4.getInt(cursor4.getColumnIndex(myDbHelper.EXP50K));
            exp80K = cursor4.getInt(cursor4.getColumnIndex(myDbHelper.EXP80K));
            exp100K = cursor4.getInt(cursor4.getColumnIndex(myDbHelper.EXP100K));

            buffer.append(exp100+ "   " + exp5K + "   " + exp10K  + "   " +  exp20K + "   " + exp50K + "   " + exp80K + "   " + exp100K + "   " +" \n");
        }
        while (cursor5.moveToNext()) {
            star01 = cursor5.getInt(cursor5.getColumnIndex(myDbHelper.STAR01));
            star02 = cursor5.getInt(cursor5.getColumnIndex(myDbHelper.STAR02));
            star03 = cursor5.getInt(cursor5.getColumnIndex(myDbHelper.STAR03));
            star04 = cursor5.getInt(cursor5.getColumnIndex(myDbHelper.STAR04));
            buffer.append(star01+ "   " + star02 + "   " + star03 + "   " +star04+ " \n");
        }
        while (cursor6.moveToNext()) {
            troop = cursor6.getString(cursor6.getColumnIndex(myDbHelper.TROOP));
            buffer.append(troop+ " \n");
            bufferTROOP.append(troop+" \n");
        }
        cursor.close();
        cursor2.close();
        cursor3.close();
        cursor4.close();
        cursor5.close();
        cursor6.close();
        db.close();
        db2.close();
        db3.close();
        db4.close();
        db5.close();
        db6.close();
        return buffer.toString();

    }

    public long DataFood () {return food ;}
    public long DataFuel () {return fuel ;}
    public long DataSteel () {return steel ;}
    public long DataAlloy() {return alloy ;}
    public long DataObsidian() {return obsidian ;}
    public long DataKyanite () {return kyanite ;}
    public long DataKyanite_basic () {return kyanite_basic ;}
    public long DataKyanite_cluster () {return kyanite_cluster ;}
    public long DataGlory_mark() {return glory_mark ;}
    public long DataCatalyst () {return catalyst ;}

    public String DataMNAME () {return bufferMNAME.toString() ;}
    public String DataMLEVEL () {return bufferMLEVEL.toString() ;}
    public String DataMENERGY () {return bufferMENERGY.toString() ;}
    public String DataMPOWER () {return bufferMPOWER.toString() ;}

    public String DataENAME () {return bufferENAME.toString() ;}
    public String DataELEVEL () {return bufferELEVEL.toString() ;}
    public String DataEPOWER () {return bufferEPOWER.toString() ;}

    public int DataEXP100 () {return exp100;}
    public int DataEXP5K () {return exp5K;}
    public int DataEXP10K () {return exp10K;}
    public int DataEXP20K () {return exp20K;}
    public int DataEXP50K () {return exp50K;}
    public int DataEXP80K () {return exp80K;}
    public int DataEXP100K () {return exp100K;}

    public int DataSTAR01 () {return star01 ;}
    public int DataSTAR02 () {return star02;}
    public int DataSTAR03 () {return star03;}
    public int DataSTAR04 () {return star04;}

    public String DataTROOP () {return bufferTROOP.toString();}


    static class myDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "database";    // Database Name
        private static final String TABLE_NAME1 = "RSS";   // Table Name
        private static final String TABLE_NAME2 = "MECHA";   // Table Name
        private static final String TABLE_NAME3 = "ENABLER";   // Table Name
        private static final String TABLE_NAME4 = "EXP";   // Table Name
        private static final String TABLE_NAME5 = "STAR_STONE";   // Table Name
        private static final String TABLE_NAME6 = "TROOP";   // Table Name
        private static final int DATABASE_Version = 1;    // Database Version

        //TABLE01
        private static final String FOOD ="Food";
        private static final String FUEL = "Fuel";
        private static final String STEEL = "Steel";
        private static final String ALLOY = "Alloy";
        private static final String OBSIDIAN = "Obsidian";
        private static final String KYANITE = "Kyanite";
        private static final String KYANITE_BASIC = "Kyanite_Basic";
        private static final String KYANITE_CLUSTER = "Kyanite_Cluster";
        private static final String GLORY_MARK = "Glory_Mark";
        private static final String CATALYST = "Catalyst";

        //TABLE02 - 04 MECHA
        private static final String MNAME ="Name";
        private static final String MLEVEL= "Level";
        private static final String MENERGY= "Energy";
        private static final String MPOWER = "Power";


        private static final String ENAME ="Name";
        private static final String ELEVEL = "Level";
        private static final String EPOWER = "Power";

        private  static  final  String EXP100 = "EXPA";
        private  static  final  String EXP5K= "EXPB";
        private  static  final  String EXP10K = "EXPC";
        private  static  final  String EXP20K = "EXPD";
        private  static  final  String EXP50K= "EXPE";
        private  static  final  String EXP80K = "EXPF";
        private  static  final  String EXP100K = "EXPG";

        private static final String STAR01 ="star01";
        private static final String STAR02= "star02";
        private static final String STAR03= "star03";
        private static final String STAR04 = "star04";

        private static final String ID = "id";
        private static final String NAME = "name";
        private static final String TROOP = "troop";



        private static final String CREATE_TABLE1 = "CREATE TABLE "+TABLE_NAME1+
                " ("+FOOD+" INTEGER , "+FUEL+" INTEGER ,"+ STEEL+" INTEGER,"+ ALLOY+" INTEGER,"+ OBSIDIAN+" INTEGER,"+ KYANITE+" INTEGER,"+ KYANITE_BASIC+" INTEGER,"+ KYANITE_CLUSTER+" INTEGER,"+ GLORY_MARK+" INTEGER,"+ CATALYST+" INTEGER)";
        private static final String DROP_TABLE1 ="DROP TABLE IF EXISTS "+TABLE_NAME1;

        private static final String CREATE_TABLE2 = "CREATE TABLE "+TABLE_NAME2+
                " ("+MNAME+" TEXT , "+MLEVEL+" INTEGER ,"+ MENERGY+" INTEGER,"+ MPOWER+" INTEGER)";
        private static final String DROP_TABLE2 ="DROP TABLE IF EXISTS "+TABLE_NAME2;

        private static final String CREATE_TABLE3= "CREATE TABLE "+TABLE_NAME3+
                " ("+ENAME+" TEXT , "+ELEVEL+" INTEGER,"+ EPOWER+" INTEGER)";
        private static final String DROP_TABLE3 ="DROP TABLE IF EXISTS "+TABLE_NAME3;

        private static final String CREATE_TABLE4= "CREATE TABLE "+TABLE_NAME4+
                "("+EXP100+"INTEGER , "+EXP5K+" INTEGER,"+ EXP10K+" INTEGER,"+ EXP20K+" INTEGER,"+ EXP20K+" INTEGER,"+ EXP80K+" INTEGER,"+ EXP100K+" INTEGER)";
        private static final String DROP_TABLE4 ="DROP TABLE IF EXISTS "+TABLE_NAME4;

        private static final String CREATE_TABLE5= "CREATE TABLE "+TABLE_NAME5+
                "("+STAR01+"INTEGER , "+STAR02+" INTEGER,"+ STAR03+" INTEGER,"+ STAR04+" INTEGER)";
        private static final String DROP_TABLE5 ="DROP TABLE IF EXISTS "+TABLE_NAME5;

        private static final String CREATE_TABLE6= "CREATE TABLE "+TABLE_NAME6+
                "("+ID+"TEXT , "+NAME+" TEXT,"+ TROOP+" INTEGER)";
        private static final String DROP_TABLE6 ="DROP TABLE IF EXISTS "+TABLE_NAME6;

        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE1);
                db.execSQL(CREATE_TABLE2);
                db.execSQL(CREATE_TABLE3);
                db.execSQL(CREATE_TABLE4);
                db.execSQL(CREATE_TABLE5);
                db.execSQL(CREATE_TABLE6);
            } catch (Exception e) {
                Message.message(context,""+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Message.message(context,"OnUpgrade");
                db.execSQL(DROP_TABLE1);
                db.execSQL(DROP_TABLE2);
                db.execSQL(DROP_TABLE3);
                db.execSQL(DROP_TABLE4);
                db.execSQL(DROP_TABLE5);
                db.execSQL(DROP_TABLE6);
                onCreate(db);
            }catch (Exception e) {
                Message.message(context,""+e);
            }
        }
    }
}