package voc.net.tools.zgirls_tool.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.R;
import voc.net.tools.zgirls_tool.util.ScreenSizeUtils;

public class SuitActivity extends AppCompatActivity {

    int[] tamamoe_part01_buff = 	 {	1	,	120	,	2	,	40	,	3	,	40	,	4	,	3	};
    int[] tamamoe_part02_buff =	 {	1	,	85	,	2	,	85	,	3	,	50	,	4	,	3	};
    int[] tamamoe_part03_buff =	 {	1	,	85	,	2	,	60	,	3	,	55	,	4	,	3	};
    int[] tamamoe_part04_buff =	 {	1	,	90	,	2	,	55	,	3	,	45	,	4	,	3	};
    int[] tamamoe_part05_buff =	 {	1	,	90	,	2	,	50	,	3	,	50	,	4	,	3	};
    int[] tamamoe_part06_buff =	 {	1	,	105	,	2	,	50	,	3	,	50	,	4	,	3	};
    int[] tamamoe_set_buff = 	 {	5	,	15	,	6	,	50	,	4	,	12	};

    int[] maid_part01_buff = 	 {	1	,	70	,	2	,	45	,	3	,	30	,	8	,	5	};
    int[] maid_part02_buff =	 {	1	,	65	,	2	,	45	,	3	,	45	,	8	,	5	};
    int[] maid_part03_buff =	 {	1	,	65	,	2	,	50	,	3	,	40	,	8	,	5	};
    int[] maid_part04_buff =	 {	1	,	70	,	2	,	50	,	3	,	35	,	8	,	5	};
    int[] maid_part05_buff =	 {	1	,	65	,	2	,	55	,	3	,	35	,	8	,	5	};
    int[] maid_part06_buff =	 {	1	,	80	,	2	,	35	,	3	,	40	,	8	,	5	};
    int[] maid_set_buff =	 {	9	,	50	,	10	,	50	,	11	,	20	};

    int[] falling_sakura_part01_buff = 	 {	1	,	45	,	2	,	30	,	3	,	30	,	8	,	5	};
    int[] falling_sakura_part02_buff =	 {	1	,	40	,	2	,	30	,	3	,	35	,	8	,	5	};
    int[] falling_sakura_part03_buff =	 {	1	,	40	,	2	,	35	,	3	,	30	,	8	,	5	};
    int[] falling_sakura_part04_buff =	 {	1	,	40	,	2	,	35	,	3	,	25	,	8	,	5	};
    int[] falling_sakura_part05_buff =	 {	1	,	40	,	2	,	40	,	3	,	25	,	8	,	5	};
    int[] falling_sakura_part06_buff =	 {	1	,	55	,	2	,	20	,	3	,	30	,	8	,	5	};
    int[] falling_sakura_set_buff =	 {	9	,	30	,	10	,	40	,	17	,	60	};

    int[] x_mas_part01_buff = 	 {	1	,	30	,	2	,	30	,	3	,	30	,	18	,	20	};
    int[] x_mas_part02_buff =	 {	1	,	30	,	19	,	40	,	20	,	40	,	21	,	5	};
    int[] x_mas_part03_buff =	 {	19	,	40	,	20	,	40	,	22	,	40	,	23	,	20	};
    int[] x_mas_part04_buff =	 {	1	,	40	,	2	,	20	,	3	,	20	,	24	,	5	};
    int[] x_mas_part05_buff =	 {	1	,	40	,	2	,	20	,	3	,	20	,	25	,	5	};
    int[] x_mas_part06_buff =	 {	1	,	20	,	23	,	20	,	18	,	20	,	17	,	5	};
    int[] x_mas_set_buff =	 {	9	,	30	,	10	,	40	,	17	,	60	};

    int[] miral_part01_buff = 	 {	1	,	30	,	2	,	30	,	3	,	30	,	21	,	5	};
    int[] miral_part02_buff =	 {	26	,	60	,	22	,	55	,	20	,	55	,	19	,	55	};
    int[] miral_part03_buff =	 {	27	,	60	,	22	,	55	,	20	,	55	,	19	,	55	};
    int[] miral_part04_buff =	 {	1	,	50	,	2	,	20	,	3	,	20	,	24	,	5	};
    int[] miral_part05_buff =	 {	1	,	40	,	2	,	25	,	3	,	25	,	25	,	5	};
    int[] miral_part06_buff =	 {	25	,	5	,	25	,	5	,	24	,	5	,	28	,	5	};
    int[] miral_set_buff =	 {	29	,	10	,	10	,	40	,	17	,	60	};

    int[] firework_part01_buff = 	 {	1	,	30	,	27	,	20	,	3	,	40	,	0	,	0	};
    int[] firework_part02_buff =	 {	1	,	40	,	19	,	50	,	20	,	30	,	0	,	0	};
    int[] firework_part03_buff =	 {	1	,	45	,	19	,	50	,	20	,	60	,	0	,	0	};
    int[] firework_part04_buff =	 {	2	,	20	,	2	,	20	,	3	,	20	,	0	,	0	};
    int[] firework_part05_buff =	 {	19	,	60	,	20	,	20	,	3	,	30	,	0	,	0	};
    int[] firework_part06_buff =	 {	1	,	35	,	26	,	20	,	24	,	40	,	0	,	0	};
    int[] firework_set_buff =	 {	30	,	10000	,	10	,	10	,	17	,	60	};

    int[] scv_part01_buff = 	 {	2	,	20	,	3	,	20	,	20	,	40	,	0	,	0	};
    int[] scv_part02_buff =	 {	27	,	20	,	26	,	20	,	19	,	60	,	0	,	0	};
    int[] scv_part03_buff =	 {	1	,	35	,	26	,	20	,	22	,	50	,	0	,	0	};
    int[] scv_part04_buff =	 {	1	,	30	,	27	,	20	,	19	,	50	,	0	,	0	};
    int[] scv_part05_buff =	 {	19	,	40	,	31	,	40	,	19	,	60	,	0	,	0	};
    int[] scv_part06_buff =	 {	31	,	35	,	2	,	20	,	3	,	20	,	0	,	0	};
    int[] scv_set_buff =	 {	30	,	0	,	10	,	10	,	17	,	50	};

    int[] valkyrie_part01_buff = 	 {	33	,	105	,	34	,	90	,	35	,	90	,	36	,	5	};
    int[] valkyrie_part02_buff =	 {	33	,	100	,	34	,	90	,	35	,	95	,	36	,	5	};
    int[] valkyrie_part03_buff =	 {	33	,	100	,	34	,	95	,	35	,	90	,	36	,	5	};
    int[] valkyrie_part04_buff =	 {	33	,	105	,	34	,	95	,	35	,	85	,	36	,	5	};
    int[] valkyrie_part05_buff =	 {	33	,	100	,	34	,	100	,	35	,	85	,	36	,	5	};
    int[] valkyrie_part06_buff =	 {	33	,	115	,	34	,	80	,	35	,	90	,	36	,	5	};
    int[] valkyrie_set_buff =	 {	37	,	150	,	36	,	20	,	38	,	25	};

    int[] hope_part01_buff = 	 {	40	,	60	,	43	,	120	,	45	,	120	,	46	,	1500	};
    int[] hope_part02_buff =	 {	41	,	100	,	42	,	100	,	44	,	100	,	46	,	1500	};
    int[] hope_part03_buff =	 {	41	,	100	,	40	,	60	,	45	,	120	,	43	,	120	};
    int[] hope_part04_buff =	 {	42	,	80	,	44	,	80	,	45	,	120	,	43	,	120	};
    int[] hope_part05_buff =	 {	41	,	100	,	42	,	80	,	44	,	80	,	46	,	2000	};
    int[] hope_part06_buff =	 {	41	,	100	,	42	,	100	,	44	,	100	,	40	,	60	};
    int[] hope_set_buff =	 {	47	,	50	,	46	,	3000	,	40	,	260	};

    int[] daybreak_part01_buff = 	 {	1	,	20	,	3	,	20	,	20	,	40	,	49	,	1	};
    int[] daybreak_part02_buff =	 {	2	,	30	,	26	,	20	,	19	,	40	,	49	,	1	};
    int[] daybreak_part03_buff =	 {	3	,	30	,	19	,	40	,	22	,	40	,	49	,	1	};
    int[] daybreak_part04_buff =	 {	1	,	30	,	27	,	40	,	19	,	40	,	49	,	1	};
    int[] daybreak_part05_buff =	 {	20	,	60	,	15	,	40	,	16	,	40	,	49	,	1	};
    int[] daybreak_part06_buff =	 {	1	,	30	,	2	,	20	,	3	,	20	,	49	,	1	};
    int[] daybreak_set_buff =	 {	47	,	10000	,	46	,	30	,	40	,	30	};

    int[] conqueror_part01_buff = 	 {	1	,	60	,	13	,	20	,	48	,	10	,	51	,	1	};
    int[] conqueror_part02_buff =	 {	2	,	100	,	19	,	30	,	40	,	30	,	51	,	1	};
    int[] conqueror_part03_buff =	 {	3	,	100	,	20	,	40	,	46	,	500	,	51	,	1	};
    int[] conqueror_part04_buff =	 {	1	,	80	,	19	,	30	,	50	,	10	,	51	,	1	};
    int[] conqueror_part05_buff =	 {	1	,	100	,	26	,	20	,	46	,	1000	,	51	,	1	};
    int[] conqueror_part06_buff =	 {	13	,	100	,	40	,	30	,	46	,	500	,	51	,	1	};
    int[] conqueror_set_buff =	 {	40	,	50	,	50	,	20	,	52	,	20	};

    int[] gentleman_part01_buff = 	 {	53	,	30	,	59	,	50	,	56	,	30	,	63	,	1	};
    int[] gentleman_part02_buff =	 {	54	,	40	,	57	,	50	,	58	,	50	,	63	,	1	};
    int[] gentleman_part03_buff =	 {	53	,	30	,	60	,	30	,	59	,	50	,	63	,	1	};
    int[] gentleman_part04_buff =	 {	54	,	50	,	61	,	50	,	62	,	40	,	63	,	1	};
    int[] gentleman_part05_buff =	 {	54	,	30	,	58	,	40	,	57	,	60	,	63	,	1	};
    int[] gentleman_part06_buff =	 {	57	,	70	,	59	,	50	,	56	,	70	,	63	,	1	};
    int[] gentleman_set_buff =	 {	54	,	50	,	56	,	50	,	64	,	10	};

    /**
     * Add at 1.0.10 , 20201206
     * Fairy Suit won't add since it have too much effect rates
     */

    int[] origin_part01_buff = 	 {	1	,	135	,	2	,	45	,	3	,	45	,	9	,	5	};
    int[] origin_part02_buff =	 {	1	,	90	,	2	,	75	,	3	,	50	,	9	,	5	};
    int[] origin_part03_buff =	 {	1	,	90	,	2	,	55	,	3	,	70	,	9	,	5	};
    int[] origin_part04_buff =	 {	1	,	100	,	2	,	65	,	3	,	55	,	9	,	5	};
    int[] origin_part05_buff =	 {	1	,	100	,	2	,	55	,	3	,	65	,	9	,	5	};
    int[] origin_part06_buff =	 {	1	,	115	,	2	,	55	,	3	,	55	,	9	,	5	};
    int[] origin_set_buff =	 {	18	,	25	,	17	,	60	,	65	,	50	};

    ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;

    ImageView suit_img01;
    ImageView suit_img02;
    ImageView suit_img03;
    ImageView suit_img04;
    ImageView suit_img05;
    ImageView suit_img06;
    ImageView suit_img07;
    ImageView suit08_ic;

    int[] suit_id = new int[10];

    boolean	suit1_matchA = false ;	boolean	suit1_matchB = false ;	boolean	suit1_matchC = false ;
    boolean	suit2_matchA = false ;	boolean	suit2_matchB = false ;	boolean	suit2_matchC = false ;
    boolean	suit3_matchA = false ;	boolean	suit3_matchB = false ;	boolean	suit3_matchC = false ;
    boolean	suit4_matchA = false ;	boolean	suit4_matchB = false ;	boolean	suit4_matchC = false ;
    boolean	suit5_matchA = false ;	boolean	suit5_matchB = false ;	boolean	suit5_matchC = false ;
    boolean	suit6_matchA = false ;	boolean	suit6_matchB = false ;	boolean	suit6_matchC = false ;
    boolean	suit7_matchA = false ;	boolean	suit7_matchB = false ;	boolean	suit7_matchC = false ;
    boolean	suit8_matchA = false ;	boolean	suit8_matchB = false ;	boolean	suit8_matchC = false ;
    boolean	suit9_matchA = false ;	boolean	suit9_matchB = false ;	boolean	suit9_matchC = false ;
    boolean	suit10_matchA = false ;	boolean	suit10_matchB = false ;	boolean	suit10_matchC = false ;
    boolean	suit11_matchA = false ;	boolean	suit11_matchB = false ;	boolean	suit11_matchC = false ;
    boolean	suit12_matchA = false ;	boolean	suit12_matchB = false ;	boolean	suit12_matchC = false ;
    boolean	suit13_matchA = false ;	boolean	suit13_matchB = false ;	boolean	suit13_matchC = false ;
    boolean	suit14_matchA = false ;	boolean	suit14_matchB = false ;	boolean	suit14_matchC = false ;
    boolean	suit15_matchA = false ;	boolean	suit15_matchB = false ;	boolean	suit15_matchC = false ;
    boolean	suit16_matchA = false ;	boolean	suit16_matchB = false ;	boolean	suit16_matchC = false ;

    int	N_A	 = 0 ;
    int	Troop_ATK	 = 0 ;
    int	Troop_DEF	 = 0 ;
    int	Troop_HP	 = 0 ;
    int	Weakness_Capture	 = 0 ;
    int	Damage_Bonus	 = 0 ;
    int	March_Max	 = 0 ;
    int	Transform_Skills_rate	 = 0 ;
    int	Project_Origin_March_Amt_Bonus	 = 0 ;
    int	March_size_increase_	 = 0 ;
    int	Reduce_basic_life_of_enemytroop	 = 0 ;
    int	March_Amt_of_Project_Origen_increase	 = 0 ;
    int	Heal_Speed	 = 0 ;
    int	Shooter_DEF	 = 0 ;
    int	Shooter_HP	 = 0 ;
    int	Increase_arena_battle_ATK	 = 0 ;
    int	Project_Zero_ATK	 = 0 ;
    int	Dead_ATK	 = 0 ;
    int	Shooter_ATK	 = 0 ;
    int	Arena_Dead_DMG	 = 0 ;
    int	Mobile_ATK	 = 0 ;
    int	Project_One_HP_	 = 0 ;
    int	Arena_Mobile_DMG_	 = 0 ;
    int	Arena_Shooter_DMG	 = 0 ;
    int	Attacker_DEF	 = 0 ;
    int	Attacker_HP	 = 0 ;
    int	Arena_Attacker_DMG	 = 0 ;
    int	All_troops_DMG_reduction	 = 0 ;
    int	Expand_arena_expedition_limit	 = 0 ;
    int	Dead_HP	 = 0 ;
    int	Dead_DEF	 = 0 ;
    int	PVE_ATK	 = 0 ;
    int	PVE_DEF	 = 0 ;
    int	PVE_HP	 = 0 ;
    int	PVE_DMP	 = 0 ;
    int	March_Speed_increase	 = 0 ;
    int	Increase_damage_by_enviroment	 = 0 ;
    int	Reduce_damage_by_enviroment	 = 0 ;
    int	Troops_Train_SPD	 = 0 ;
    int	Attacker_Train_SPD	 = 0 ;
    int	Mobile_Train_SPD	 = 0 ;
    int	Dead_Train_SPD	 = 0 ;
    int	Shooter_Train_SPD	 = 0 ;
    int	Project_Train_SPD	 = 0 ;
    int	Troops_Train_Amount	 = 0 ;
    int	Clinic_Capacity	 = 0 ;
    int	Fewer_Tech_Research_rss	 = 0 ;
    int	Random_Buff_to_ATK_Shooter_Dead_Or_Mobile	 = 0 ;
    int	Tech_Research_SPD	 = 0 ;
    int	Random_Development_Buffs	 = 0 ;
    int	Building_SPD	 = 0 ;
    int	Defensive_DEF	 = 0 ;
    int	Defensive_ATK	 = 0 ;
    int	Defensive_HP	 = 0 ;
    int	Dead_Defensive_DEF	 = 0 ;
    int	Dead_Defensive_ATK	 = 0 ;
    int	Dead_Defensive_HP	 = 0 ;
    int	Shooter_Defensive_ATK	 = 0 ;
    int	Attacker_Defensive_HP	 = 0 ;
    int	Mobile_Defensive_HP	 = 0 ;
    int	Attacker_Defensive_DEF	 = 0 ;
    int	Random_Defense_Siege_Buffs	 = 0 ;
    int	Decrease_rate_of_enabler_being_arrest	 = 0 ;
    int	Ace_Killer	 = 0 ;

    String 	suit_buff_name_1 = "";
    String 	suit_buff_name_2;
    String 	suit_buff_name_3;
    String 	suit_buff_name_4;
    String 	suit_buff_name_5;
    String 	suit_buff_name_6;
    String 	suit_buff_name_7;
    String 	suit_buff_name_8;
    String 	suit_buff_name_9;
    String 	suit_buff_name_10;
    String 	suit_buff_name_11;
    String 	suit_buff_name_12;
    String 	suit_buff_name_13;
    String 	suit_buff_name_14;
    String 	suit_buff_name_15;
    String 	suit_buff_name_16;
    String 	suit_buff_name_17;
    String 	suit_buff_name_18;
    String 	suit_buff_name_19;
    String 	suit_buff_name_20;
    String 	suit_buff_name_21;
    String 	suit_buff_name_22;
    String 	suit_buff_name_23;
    String 	suit_buff_name_24;
    String 	suit_buff_name_25;
    String 	suit_buff_name_26;
    String 	suit_buff_name_27;

    TextView suit01_tv1;
    TextView suit01_tv2;
    TextView suit01_tv3;
    TextView suit01_tv4;
    TextView suit02_tv1;
    TextView suit02_tv2;
    TextView suit02_tv3;
    TextView suit02_tv4;
    TextView suit03_tv1;
    TextView suit03_tv2;
    TextView suit03_tv3;
    TextView suit03_tv4;
    TextView suit04_tv1;
    TextView suit04_tv2;
    TextView suit04_tv3;
    TextView suit04_tv4;
    TextView suit05_tv1;
    TextView suit05_tv2;
    TextView suit05_tv3;
    TextView suit05_tv4;
    TextView suit06_tv1;
    TextView suit06_tv2;
    TextView suit06_tv3;
    TextView suit06_tv4;

    ImageView suit01_ic;
    ImageView suit02_ic;
    ImageView suit03_ic;
    ImageView suit04_ic;
    ImageView suit05_ic;
    ImageView suit06_ic;

    TextView suit01_name;
    TextView suit02_name;
    TextView suit03_name;
    TextView suit04_name;
    TextView suit05_name;
    TextView suit06_name;

    String hero_a = "" ;
    ImageView HEROA ;
    ImageView HEROA_FINAL ;

    LinearLayout each_ll ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suit);
        suit_img01 = findViewById(R.id.suit_part1);
        suit_img02 = findViewById(R.id.suit_part2);
        suit_img03 = findViewById(R.id.suit_part3);
        suit_img04 = findViewById(R.id.suit_part4);
        suit_img05 = findViewById(R.id.suit_part5);
        suit_img06 = findViewById(R.id.suit_part6);
        suit_img07 = findViewById(R.id.suit_part7);

        suit08_ic = findViewById(R.id.suit_part8);

        suit01_ic = findViewById(R.id.icon_suit01);
        suit02_ic = findViewById(R.id.icon_suit02);
        suit03_ic = findViewById(R.id.icon_suit03);
        suit04_ic = findViewById(R.id.icon_suit04);
        suit05_ic = findViewById(R.id.icon_suit05);
        suit06_ic = findViewById(R.id.icon_suit06);

        suit01_name = findViewById(R.id.name_suit01);
        suit02_name = findViewById(R.id.name_suit02);
        suit03_name = findViewById(R.id.name_suit03);
        suit04_name = findViewById(R.id.name_suit04);
        suit05_name = findViewById(R.id.name_suit05);
        suit06_name = findViewById(R.id.name_suit06);

        suit01_tv1 = findViewById(R.id.buffA_suit01);
        suit01_tv2 = findViewById(R.id.buffB_suit01);
        suit01_tv3 = findViewById(R.id.buffC_suit01);
        suit01_tv4 = findViewById(R.id.buffD_suit01);
        suit02_tv1 = findViewById(R.id.buffA_suit02);
        suit02_tv2 = findViewById(R.id.buffB_suit02);
        suit02_tv3 = findViewById(R.id.buffC_suit02);
        suit02_tv4 = findViewById(R.id.buffD_suit02);
        suit03_tv1 = findViewById(R.id.buffA_suit03);
        suit03_tv2 = findViewById(R.id.buffB_suit03);
        suit03_tv3 = findViewById(R.id.buffC_suit03);
        suit03_tv4 = findViewById(R.id.buffD_suit03);
        suit04_tv1 = findViewById(R.id.buffA_suit04);
        suit04_tv2 = findViewById(R.id.buffB_suit04);
        suit04_tv3 = findViewById(R.id.buffC_suit04);
        suit04_tv4 = findViewById(R.id.buffD_suit04);
        suit05_tv1 = findViewById(R.id.buffA_suit05);
        suit05_tv2 = findViewById(R.id.buffB_suit05);
        suit05_tv3 = findViewById(R.id.buffC_suit05);
        suit05_tv4 = findViewById(R.id.buffD_suit05);
        suit06_tv1 = findViewById(R.id.buffA_suit06);
        suit06_tv2 = findViewById(R.id.buffB_suit06);
        suit06_tv3 = findViewById(R.id.buffC_suit06);
        suit06_tv4 = findViewById(R.id.buffD_suit06);

        HEROA = findViewById(R.id.enabler_suit);
        HEROA_FINAL = findViewById(R.id.enabler_suit);
        listView = findViewById(R.id.suit_list);
        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.suit_list_tv, arrayList);
        listView.setAdapter(adapter);
        each_ll = findViewById(R.id.each_ll);

        BackgroundReload();

        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        suit_id[0] = sharedPreferences.getInt("suit01", 0);
        suit_id[1] = sharedPreferences.getInt("suit02", 0);
        suit_id[2] = sharedPreferences.getInt("suit03", 0);
        suit_id[3] = sharedPreferences.getInt("suit04", 0);
        suit_id[4] = sharedPreferences.getInt("suit05", 0);
        suit_id[5] = sharedPreferences.getInt("suit06", 0);
        hero_a = sharedPreferences.getString("suit_enabler", "saki");
        hero_back();
        Calculate();
    }

    private void hero_back2() {
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor3 = sharedPreferences.edit();
        editor3.putString("suit_enabler", hero_a);
        editor3.apply();
        sum();
    }
    private void hero_back() {
        if (hero_a.matches("akiyama")){HEROA.setImageResource(R.drawable.akiyama);suit08_ic.setImageResource(R.drawable.enabler_akiyama);}
        if (hero_a.matches("alice")){HEROA.setImageResource(R.drawable.alice);suit08_ic.setImageResource(R.drawable.enabler_alice);}
        if (hero_a.matches("ana_o")){HEROA.setImageResource(R.drawable.ana_o);suit08_ic.setImageResource(R.drawable.enabler_ana_o);}
        if (hero_a.matches("carol")){HEROA.setImageResource(R.drawable.carol);suit08_ic.setImageResource(R.drawable.enabler_carol);}
        if (hero_a.matches("catherine")){HEROA.setImageResource(R.drawable.catherine);suit08_ic.setImageResource(R.drawable.enabler_catherine);}
        if (hero_a.matches("celesia")){HEROA.setImageResource(R.drawable.celesia);suit08_ic.setImageResource(R.drawable.enabler_celesia);}
        if (hero_a.matches("chen")){HEROA.setImageResource(R.drawable.chen);suit08_ic.setImageResource(R.drawable.enabler_chen);}
        if (hero_a.matches("chika")){HEROA.setImageResource(R.drawable.chika);suit08_ic.setImageResource(R.drawable.enabler_chika);}
        if (hero_a.matches("chiyo")){HEROA.setImageResource(R.drawable.chiyo);suit08_ic.setImageResource(R.drawable.enabler_chiyo);}
        if (hero_a.matches("comet")){HEROA.setImageResource(R.drawable.comet);suit08_ic.setImageResource(R.drawable.enabler_comet);}
        if (hero_a.matches("donner")){HEROA.setImageResource(R.drawable.donner);suit08_ic.setImageResource(R.drawable.enabler_donner);}
        if (hero_a.matches("eleanor")){HEROA.setImageResource(R.drawable.eleanor);suit08_ic.setImageResource(R.drawable.enabler_eleanor);}
        if (hero_a.matches("esther")){HEROA.setImageResource(R.drawable.esther);suit08_ic.setImageResource(R.drawable.enabler_esther);}
        if (hero_a.matches("fudo")){HEROA.setImageResource(R.drawable.fudo);suit08_ic.setImageResource(R.drawable.enabler_fudo);}
        if (hero_a.matches("gin")){HEROA.setImageResource(R.drawable.gin);suit08_ic.setImageResource(R.drawable.enabler_gin);}
        if (hero_a.matches("hiyori")){HEROA.setImageResource(R.drawable.hiyori);suit08_ic.setImageResource(R.drawable.enabler_hiyori);}
        if (hero_a.matches("iris")){HEROA.setImageResource(R.drawable.iris);suit08_ic.setImageResource(R.drawable.enabler_iris);}
        if (hero_a.matches("kayo")){HEROA.setImageResource(R.drawable.kayo);suit08_ic.setImageResource(R.drawable.enabler_kayo);}
        if (hero_a.matches("kirine")){HEROA.setImageResource(R.drawable.kirine);suit08_ic.setImageResource(R.drawable.enabler_kirine);}
        if (hero_a.matches("kuroda")){HEROA.setImageResource(R.drawable.kuroda);suit08_ic.setImageResource(R.drawable.enabler_kuroda);}
        if (hero_a.matches("kurul")){HEROA.setImageResource(R.drawable.kurul);suit08_ic.setImageResource(R.drawable.enabler_kurul);}
        if (hero_a.matches("lois")){HEROA.setImageResource(R.drawable.lois);suit08_ic.setImageResource(R.drawable.enabler_lois);}
        if (hero_a.matches("izumi")){HEROA.setImageResource(R.drawable.izumi);suit08_ic.setImageResource(R.drawable.enabler_izumi);}
        if (hero_a.matches("liuk")){HEROA.setImageResource(R.drawable.liuk);suit08_ic.setImageResource(R.drawable.enabler_liuk);}
        if (hero_a.matches("masami")){HEROA.setImageResource(R.drawable.masami);suit08_ic.setImageResource(R.drawable.enabler_masami);}
        if (hero_a.matches("mika")){HEROA.setImageResource(R.drawable.mika);suit08_ic.setImageResource(R.drawable.enabler_mika);}
        if (hero_a.matches("minami")){HEROA.setImageResource(R.drawable.minami);suit08_ic.setImageResource(R.drawable.enabler_minami);}
        if (hero_a.matches("mio")){HEROA.setImageResource(R.drawable.mio);suit08_ic.setImageResource(R.drawable.enabler_mio);}
        if (hero_a.matches("mira")){HEROA.setImageResource(R.drawable.mira);suit08_ic.setImageResource(R.drawable.enabler_mira);}
        if (hero_a.matches("misaki")){HEROA.setImageResource(R.drawable.misaki);suit08_ic.setImageResource(R.drawable.enabler_misaki);}
        if (hero_a.matches("nana")){HEROA.setImageResource(R.drawable.nana);suit08_ic.setImageResource(R.drawable.enabler_nana);}
        if (hero_a.matches("narumi")){HEROA.setImageResource(R.drawable.narumi);suit08_ic.setImageResource(R.drawable.enabler_narumi);}
        if (hero_a.matches("odelia")){HEROA.setImageResource(R.drawable.odelia);suit08_ic.setImageResource(R.drawable.enabler_odelia);}
        if (hero_a.matches("raly")){HEROA.setImageResource(R.drawable.raly);suit08_ic.setImageResource(R.drawable.enabler_raly);}
        if (hero_a.matches("risa")){HEROA.setImageResource(R.drawable.risa);suit08_ic.setImageResource(R.drawable.enabler_risa);}
        if (hero_a.matches("saki")){HEROA.setImageResource(R.drawable.saki);suit08_ic.setImageResource(R.drawable.enabler_saki);}
        if (hero_a.matches("saori")){HEROA.setImageResource(R.drawable.saori);suit08_ic.setImageResource(R.drawable.enabler_saori);}
        if (hero_a.matches("sara")){HEROA.setImageResource(R.drawable.sara);suit08_ic.setImageResource(R.drawable.enabler_sara);}
        if (hero_a.matches("sariko")){HEROA.setImageResource(R.drawable.sariko);suit08_ic.setImageResource(R.drawable.enabler_sariko);}
        if (hero_a.matches("shiori")){HEROA.setImageResource(R.drawable.shiori);suit08_ic.setImageResource(R.drawable.enabler_shiori);}
        if (hero_a.matches("shirley")){HEROA.setImageResource(R.drawable.shirley);suit08_ic.setImageResource(R.drawable.enabler_shirley);}
        if (hero_a.matches("sumika")){HEROA.setImageResource(R.drawable.sumika);suit08_ic.setImageResource(R.drawable.enabler_sumika);}
        if (hero_a.matches("sylvia")){HEROA.setImageResource(R.drawable.sylvia);suit08_ic.setImageResource(R.drawable.enabler_sylvia);}
        if (hero_a.matches("uzuki")){HEROA.setImageResource(R.drawable.uzuki);suit08_ic.setImageResource(R.drawable.enabler_uzuki);}
        if (hero_a.matches("yesi")){HEROA.setImageResource(R.drawable.yesi);suit08_ic.setImageResource(R.drawable.enabler_yesi);}
        if (hero_a.matches("youko")){HEROA.setImageResource(R.drawable.youko);suit08_ic.setImageResource(R.drawable.enabler_youko);}
        if (hero_a.matches("zero")){HEROA.setImageResource(R.drawable.zero);suit08_ic.setImageResource(R.drawable.enabler_zero);}
        if (hero_a.matches("zrs2")){HEROA.setImageResource(R.drawable.zrs_2);suit08_ic.setImageResource(R.drawable.enabler_zrs2);}

        if (hero_a.matches("sp_sara")){HEROA.setImageResource(R.drawable.sp_sara);suit08_ic.setImageResource(R.drawable.enabler_sp_sara);}
        if (hero_a.matches("yui")){HEROA.setImageResource(R.drawable.yui);suit08_ic.setImageResource(R.drawable.enabler_yui);}
    }

    public void each_part(View v){
        N_A	 = 0 ;
        Troop_ATK	 = 0 ;
        Troop_DEF	 = 0 ;
        Troop_HP	 = 0 ;
        Weakness_Capture	 = 0 ;
        Damage_Bonus	 = 0 ;
        March_Max	 = 0 ;
        Transform_Skills_rate	 = 0 ;
        Project_Origin_March_Amt_Bonus	 = 0 ;
        March_size_increase_	 = 0 ;
        Reduce_basic_life_of_enemytroop	 = 0 ;
        March_Amt_of_Project_Origen_increase	 = 0 ;
        Heal_Speed	 = 0 ;
        Shooter_DEF	 = 0 ;
        Shooter_HP	 = 0 ;
        Increase_arena_battle_ATK	 = 0 ;
        Project_Zero_ATK	 = 0 ;
        Dead_ATK	 = 0 ;
        Shooter_ATK	 = 0 ;
        Arena_Dead_DMG	 = 0 ;
        Mobile_ATK	 = 0 ;
        Project_One_HP_	 = 0 ;
        Arena_Mobile_DMG_	 = 0 ;
        Arena_Shooter_DMG	 = 0 ;
        Attacker_DEF	 = 0 ;
        Attacker_HP	 = 0 ;
        Arena_Attacker_DMG	 = 0 ;
        All_troops_DMG_reduction	 = 0 ;
        Expand_arena_expedition_limit	 = 0 ;
        Dead_HP	 = 0 ;
        Dead_DEF	 = 0 ;
        PVE_ATK	 = 0 ;
        PVE_DEF	 = 0 ;
        PVE_HP	 = 0 ;
        PVE_DMP	 = 0 ;
        March_Speed_increase	 = 0 ;
        Increase_damage_by_enviroment	 = 0 ;
        Reduce_damage_by_enviroment	 = 0 ;
        Troops_Train_SPD	 = 0 ;
        Attacker_Train_SPD	 = 0 ;
        Mobile_Train_SPD	 = 0 ;
        Dead_Train_SPD	 = 0 ;
        Shooter_Train_SPD	 = 0 ;
        Project_Train_SPD	 = 0 ;
        Troops_Train_Amount	 = 0 ;
        Clinic_Capacity	 = 0 ;
        Fewer_Tech_Research_rss	 = 0 ;
        Random_Buff_to_ATK_Shooter_Dead_Or_Mobile	 = 0 ;
        Tech_Research_SPD	 = 0 ;
        Random_Development_Buffs	 = 0 ;
        Building_SPD	 = 0 ;
        Defensive_DEF	 = 0 ;
        Defensive_ATK	 = 0 ;
        Defensive_HP	 = 0 ;
        Dead_Defensive_DEF	 = 0 ;
        Dead_Defensive_ATK	 = 0 ;
        Dead_Defensive_HP	 = 0 ;
        Shooter_Defensive_ATK	 = 0 ;
        Attacker_Defensive_HP	 = 0 ;
        Mobile_Defensive_HP	 = 0 ;
        Attacker_Defensive_DEF	 = 0 ;
        Random_Defense_Siege_Buffs	 = 0 ;
        Decrease_rate_of_enabler_being_arrest	 = 0 ;
        Ace_Killer	 = 0 ;
        listView.setVisibility(View.GONE);
        each_ll.setVisibility(View.VISIBLE);
        sum();
    }
    public void summary(View v){
        listView.setVisibility(View.VISIBLE);
        each_ll.setVisibility(View.GONE);
        sum();
    }

    private void sum() {
        N_A	 = 0 ;
        Troop_ATK	 = 0 ;
        Troop_DEF	 = 0 ;
        Troop_HP	 = 0 ;
        Weakness_Capture	 = 0 ;
        Damage_Bonus	 = 0 ;
        March_Max	 = 0 ;
        Transform_Skills_rate	 = 0 ;
        Project_Origin_March_Amt_Bonus	 = 0 ;
        March_size_increase_	 = 0 ;
        Reduce_basic_life_of_enemytroop	 = 0 ;
        March_Amt_of_Project_Origen_increase	 = 0 ;
        Heal_Speed	 = 0 ;
        Shooter_DEF	 = 0 ;
        Shooter_HP	 = 0 ;
        Increase_arena_battle_ATK	 = 0 ;
        Project_Zero_ATK	 = 0 ;
        Dead_ATK	 = 0 ;
        Shooter_ATK	 = 0 ;
        Arena_Dead_DMG	 = 0 ;
        Mobile_ATK	 = 0 ;
        Project_One_HP_	 = 0 ;
        Arena_Mobile_DMG_	 = 0 ;
        Arena_Shooter_DMG	 = 0 ;
        Attacker_DEF	 = 0 ;
        Attacker_HP	 = 0 ;
        Arena_Attacker_DMG	 = 0 ;
        All_troops_DMG_reduction	 = 0 ;
        Expand_arena_expedition_limit	 = 0 ;
        Dead_HP	 = 0 ;
        Dead_DEF	 = 0 ;
        PVE_ATK	 = 0 ;
        PVE_DEF	 = 0 ;
        PVE_HP	 = 0 ;
        PVE_DMP	 = 0 ;
        March_Speed_increase	 = 0 ;
        Increase_damage_by_enviroment	 = 0 ;
        Reduce_damage_by_enviroment	 = 0 ;
        Troops_Train_SPD	 = 0 ;
        Attacker_Train_SPD	 = 0 ;
        Mobile_Train_SPD	 = 0 ;
        Dead_Train_SPD	 = 0 ;
        Shooter_Train_SPD	 = 0 ;
        Project_Train_SPD	 = 0 ;
        Troops_Train_Amount	 = 0 ;
        Clinic_Capacity	 = 0 ;
        Fewer_Tech_Research_rss	 = 0 ;
        Random_Buff_to_ATK_Shooter_Dead_Or_Mobile	 = 0 ;
        Tech_Research_SPD	 = 0 ;
        Random_Development_Buffs	 = 0 ;
        Building_SPD	 = 0 ;
        Defensive_DEF	 = 0 ;
        Defensive_ATK	 = 0 ;
        Defensive_HP	 = 0 ;
        Dead_Defensive_DEF	 = 0 ;
        Dead_Defensive_ATK	 = 0 ;
        Dead_Defensive_HP	 = 0 ;
        Shooter_Defensive_ATK	 = 0 ;
        Attacker_Defensive_HP	 = 0 ;
        Mobile_Defensive_HP	 = 0 ;
        Attacker_Defensive_DEF	 = 0 ;
        Random_Defense_Siege_Buffs	 = 0 ;
        Decrease_rate_of_enabler_being_arrest	 = 0 ;
        Ace_Killer	 = 0 ;
        Calculate();
        buff_list();
    }

    public void suit1(View v){
        final Dialog dialog = new Dialog(this, R.style.NormalDialogStyle_N);
        View view = View.inflate(this, R.layout.suit1_choose, null);

        ImageView suit_part1_1	 = view.findViewById(R.id.suit_part1_1);
        ImageView suit_part1_2	 = view.findViewById(R.id.suit_part1_2);
        ImageView suit_part1_3	 = view.findViewById(R.id.suit_part1_3);
        ImageView suit_part1_4	 = view.findViewById(R.id.suit_part1_4);
        ImageView suit_part1_5	 = view.findViewById(R.id.suit_part1_5);
        ImageView suit_part1_6	 = view.findViewById(R.id.suit_part1_6);
        ImageView suit_part1_7	 = view.findViewById(R.id.suit_part1_7);
        ImageView suit_part1_8	 = view.findViewById(R.id.suit_part1_8);
        ImageView suit_part1_9	 = view.findViewById(R.id.suit_part1_9);
        ImageView suit_part1_10	 = view.findViewById(R.id.suit_part1_10);
        ImageView suit_part1_11	 = view.findViewById(R.id.suit_part1_11);
        ImageView suit_part1_12	 = view.findViewById(R.id.suit_part1_12);
        ImageView suit_part1_13	 = view.findViewById(R.id.suit_part1_13);
        ImageView suit_part1_14	 = view.findViewById(R.id.suit_part1_14);
        //ImageView suit_part1_15	 = view.findViewById(R.id.suit_part1_15);
        //ImageView suit_part1_16	 = view.findViewById(R.id.suit_part1_16);

        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        //view.setMinimumHeight((int) (ScreenSizeUtils.getInstance(this).getScreenHeight()));
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int) (ScreenSizeUtils.getInstance(this).getScreenWidth()*0.8);
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);
        dialog.setCancelable(false);
        dialog.show();

        suit_part1_1.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[0] = 1 ; suit_img01.setImageResource(R.drawable.tamamoe_part1);suit_img01.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part1_2.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[0] = 2 ; suit_img01.setImageResource(R.drawable.fighter_maid_part1);suit_img01.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part1_3.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[0] = 3 ; suit_img01.setImageResource(R.drawable.sakura_fall_part1);suit_img01.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part1_4.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[0] = 4 ; suit_img01.setImageResource(R.drawable.xmas_part1);suit_img01.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part1_5.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[0] = 5 ; suit_img01.setImageResource(R.drawable.mirai_part1);suit_img01.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part1_6.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[0] = 6 ; suit_img01.setImageResource(R.drawable.hanabit_part1);suit_img01.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part1_7.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[0] = 7 ; suit_img01.setImageResource(R.drawable.scv_part1);suit_img01.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part1_8.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[0] = 8 ; suit_img01.setImageResource(R.drawable.battlefield_part1);suit_img01.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part1_9.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[0] = 9 ; suit_img01.setImageResource(R.drawable.hope_part1);suit_img01.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part1_10.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[0] = 10 ; suit_img01.setImageResource(R.drawable.daybreak_part1);suit_img01.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part1_11.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[0] = 11 ; suit_img01.setImageResource(R.drawable.conqueror_part1);suit_img01.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part1_12.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[0] = 12; suit_img01.setImageResource(R.drawable.gentleman_part1);suit_img01.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part1_13.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[0] = 13; suit_img01.setImageResource(R.drawable.iron_part1);suit_img01.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part1_14.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[0] = 14; suit_img01.setImageResource(R.drawable.fairy_part1);suit_img01.setBackgroundResource(R.drawable.rare6);sum();}});
        //suit_part1_15.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[0] = 12; suit_img01.setImageResource(R.drawable.gentleman_part1);suit_img01.setBackgroundResource(R.drawable.rare6);sum();}});
        //suit_part1_16.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[0] = 12; suit_img01.setImageResource(R.drawable.gentleman_part1);suit_img01.setBackgroundResource(R.drawable.rare6);sum();}});
    }
    public void suit2(View v){final Dialog dialog = new Dialog(this, R.style.NormalDialogStyle_N);
        View view = View.inflate(this, R.layout.suit2_choose, null);

        ImageView suit_part2_1	 = view.findViewById(R.id.suit_part2_1);
        ImageView suit_part2_2	 = view.findViewById(R.id.suit_part2_2);
        ImageView suit_part2_3	 = view.findViewById(R.id.suit_part2_3);
        ImageView suit_part2_4	 = view.findViewById(R.id.suit_part2_4);
        ImageView suit_part2_5	 = view.findViewById(R.id.suit_part2_5);
        ImageView suit_part2_6	 = view.findViewById(R.id.suit_part2_6);
        ImageView suit_part2_7	 = view.findViewById(R.id.suit_part2_7);
        ImageView suit_part2_8	 = view.findViewById(R.id.suit_part2_8);
        ImageView suit_part2_9	 = view.findViewById(R.id.suit_part2_9);
        ImageView suit_part2_10	 = view.findViewById(R.id.suit_part2_10);
        ImageView suit_part2_11	 = view.findViewById(R.id.suit_part2_11);
        ImageView suit_part2_12	 = view.findViewById(R.id.suit_part2_12);
        ImageView suit_part2_13	 = view.findViewById(R.id.suit_part2_13);
        ImageView suit_part2_14	 = view.findViewById(R.id.suit_part2_14);
        //ImageView suit_part2_15	 = view.findViewById(R.id.suit_part2_15);
        //ImageView suit_part2_16	 = view.findViewById(R.id.suit_part2_16);

        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        //view.setMinimumHeight((int) (ScreenSizeUtils.getInstance(this).getScreenHeight()));
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int) (ScreenSizeUtils.getInstance(this).getScreenWidth()*0.8);
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);
        dialog.setCancelable(false);
        dialog.show();

        suit_part2_1.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[1] = 1 ; suit_img02.setImageResource(R.drawable.tamamoe_part2);suit_img02.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part2_2.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[1] = 2 ; suit_img02.setImageResource(R.drawable.fighter_maid_part2);suit_img02.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part2_3.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[1] = 3 ; suit_img02.setImageResource(R.drawable.sakura_fall_part2);suit_img02.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part2_4.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[1] = 4 ; suit_img02.setImageResource(R.drawable.xmas_part2);suit_img02.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part2_5.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[1] = 5 ; suit_img02.setImageResource(R.drawable.mirai_part2);suit_img02.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part2_6.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[1] = 6 ; suit_img02.setImageResource(R.drawable.hanabit_part2);suit_img02.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part2_7.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[1] = 7 ; suit_img02.setImageResource(R.drawable.scv_part2);suit_img02.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part2_8.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[1] = 8 ; suit_img02.setImageResource(R.drawable.battlefield_part2);suit_img02.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part2_9.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[1] = 9 ; suit_img02.setImageResource(R.drawable.hope_part2);suit_img02.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part2_10.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[1] = 10 ; suit_img02.setImageResource(R.drawable.daybreak_part2);suit_img02.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part2_11.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[1] = 11 ; suit_img02.setImageResource(R.drawable.conqueror_part2);suit_img02.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part2_12.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[1] = 12; suit_img02.setImageResource(R.drawable.gentleman_part2);suit_img02.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part2_13.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[1] = 13; suit_img02.setImageResource(R.drawable.iron_part2);suit_img02.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part2_14.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[1] = 14; suit_img02.setImageResource(R.drawable.fairy_part2);suit_img02.setBackgroundResource(R.drawable.rare6);sum();}});
        //suit_part2_15.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[1] = 15; suit_part2_15.setImageResource(R.drawable.tamamoe_part2);suit_img02.setBackgroundResource(R.drawable.rare6);sum();}});
        //suit_part2_16.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[1] = 16; suit_part2_16.setImageResource(R.drawable.tamamoe_part2);suit_img02.setBackgroundResource(R.drawable.rare6);sum();}});
    }
    public void suit3(View v){
        final Dialog dialog = new Dialog(this, R.style.NormalDialogStyle_N);
        View view = View.inflate(this, R.layout.suit3_choose, null);

        ImageView suit_part3_1	 = view.findViewById(R.id.suit_part3_1);
        ImageView suit_part3_2	 = view.findViewById(R.id.suit_part3_2);
        ImageView suit_part3_3	 = view.findViewById(R.id.suit_part3_3);
        ImageView suit_part3_4	 = view.findViewById(R.id.suit_part3_4);
        ImageView suit_part3_5	 = view.findViewById(R.id.suit_part3_5);
        ImageView suit_part3_6	 = view.findViewById(R.id.suit_part3_6);
        ImageView suit_part3_7	 = view.findViewById(R.id.suit_part3_7);
        ImageView suit_part3_8	 = view.findViewById(R.id.suit_part3_8);
        ImageView suit_part3_9	 = view.findViewById(R.id.suit_part3_9);
        ImageView suit_part3_10	 = view.findViewById(R.id.suit_part3_10);
        ImageView suit_part3_11	 = view.findViewById(R.id.suit_part3_11);
        ImageView suit_part3_12	 = view.findViewById(R.id.suit_part3_12);
        ImageView suit_part3_13	 = view.findViewById(R.id.suit_part3_13);
        ImageView suit_part3_14	 = view.findViewById(R.id.suit_part3_14);
        ImageView suit_part3_15	 = view.findViewById(R.id.suit_part3_15);
        ImageView suit_part3_16	 = view.findViewById(R.id.suit_part3_16);

        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        //view.setMinimumHeight((int) (ScreenSizeUtils.getInstance(this).getScreenHeight()));
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int) (ScreenSizeUtils.getInstance(this).getScreenWidth()*0.8);
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);
        dialog.setCancelable(false);
        dialog.show();

        suit_part3_1.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[2] = 1 ; suit_img03.setImageResource(R.drawable.tamamoe_part3);suit_img03.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part3_2.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[2] = 2 ; suit_img03.setImageResource(R.drawable.fighter_maid_part3);suit_img03.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part3_3.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[2] = 3 ; suit_img03.setImageResource(R.drawable.sakura_fall_part3);suit_img03.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part3_4.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[2] = 4 ; suit_img03.setImageResource(R.drawable.xmas_part3);suit_img03.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part3_5.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[2] = 5 ; suit_img03.setImageResource(R.drawable.mirai_part3);suit_img03.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part3_6.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[2] = 6 ; suit_img03.setImageResource(R.drawable.hanabit_part3);suit_img03.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part3_7.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[2] = 7 ; suit_img03.setImageResource(R.drawable.scv_part3);suit_img03.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part3_8.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[2] = 8 ; suit_img03.setImageResource(R.drawable.battlefield_part3);suit_img03.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part3_9.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[2] = 9 ; suit_img03.setImageResource(R.drawable.hope_part3);suit_img03.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part3_10.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[2] = 10 ; suit_img03.setImageResource(R.drawable.daybreak_part3);suit_img03.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part3_11.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[2] = 11 ; suit_img03.setImageResource(R.drawable.conqueror_part3);suit_img03.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part3_12.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[2] = 12; suit_img03.setImageResource(R.drawable.gentleman_part3);suit_img03.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part3_13.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[2] = 13; suit_img03.setImageResource(R.drawable.iron_part3);suit_img03.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part3_14.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[2] = 14; suit_img03.setImageResource(R.drawable.fairy_part3);suit_img03.setBackgroundResource(R.drawable.rare6);sum();}});
        //suit_part3_15.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[2] = 15; suit_img03.setImageResource(R.drawable.gentleman_part3);suit_img03.setBackgroundResource(R.drawable.rare6);sum();}});
        //suit_part3_16.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[2] = 16; suit_img03.setImageResource(R.drawable.gentleman_part3);suit_img03.setBackgroundResource(R.drawable.rare6);sum();}});
    }
    public void suit4(View v){
        final Dialog dialog = new Dialog(this, R.style.NormalDialogStyle_N);
        View view = View.inflate(this, R.layout.suit4_choose, null);

        ImageView suit_part4_1	 = view.findViewById(R.id.suit_part4_1);
        ImageView suit_part4_2	 = view.findViewById(R.id.suit_part4_2);
        ImageView suit_part4_3	 = view.findViewById(R.id.suit_part4_3);
        ImageView suit_part4_4	 = view.findViewById(R.id.suit_part4_4);
        ImageView suit_part4_5	 = view.findViewById(R.id.suit_part4_5);
        ImageView suit_part4_6	 = view.findViewById(R.id.suit_part4_6);
        ImageView suit_part4_7	 = view.findViewById(R.id.suit_part4_7);
        ImageView suit_part4_8	 = view.findViewById(R.id.suit_part4_8);
        ImageView suit_part4_9	 = view.findViewById(R.id.suit_part4_9);
        ImageView suit_part4_10	 = view.findViewById(R.id.suit_part4_10);
        ImageView suit_part4_11	 = view.findViewById(R.id.suit_part4_11);
        ImageView suit_part4_12	 = view.findViewById(R.id.suit_part4_12);
        ImageView suit_part4_13	 = view.findViewById(R.id.suit_part4_13);
        ImageView suit_part4_14	 = view.findViewById(R.id.suit_part4_14);
        //ImageView suit_part4_15	 = view.findViewById(R.id.suit_part4_15);
        //ImageView suit_part4_16	 = view.findViewById(R.id.suit_part4_16);

        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        //view.setMinimumHeight((int) (ScreenSizeUtils.getInstance(this).getScreenHeight()));
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int) (ScreenSizeUtils.getInstance(this).getScreenWidth()*0.8);
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);
        dialog.setCancelable(false);
        dialog.show();

        suit_part4_1.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[3] = 1 ; suit_img04.setImageResource(R.drawable.tamamoe_part4);suit_img04.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part4_2.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[3] = 2 ; suit_img04.setImageResource(R.drawable.fighter_maid_part4);suit_img04.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part4_3.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[3] = 3 ; suit_img04.setImageResource(R.drawable.sakura_fall_part4);suit_img04.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part4_4.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[3] = 4 ; suit_img04.setImageResource(R.drawable.xmas_part4);suit_img04.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part4_5.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[3] = 5 ; suit_img04.setImageResource(R.drawable.mirai_part4);suit_img04.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part4_6.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[3] = 6 ; suit_img04.setImageResource(R.drawable.hanabit_part4);suit_img04.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part4_7.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[3] = 7 ; suit_img04.setImageResource(R.drawable.scv_part4);suit_img04.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part4_8.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[3] = 8 ; suit_img04.setImageResource(R.drawable.battlefield_part4);suit_img04.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part4_9.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[3] = 9 ; suit_img04.setImageResource(R.drawable.hope_part4);suit_img04.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part4_10.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[3] = 10 ; suit_img04.setImageResource(R.drawable.daybreak_part4);suit_img04.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part4_11.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[3] = 11 ; suit_img04.setImageResource(R.drawable.conqueror_part4);suit_img04.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part4_12.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[3] = 12; suit_img04.setImageResource(R.drawable.gentleman_part4);suit_img04.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part4_13.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[3] = 13; suit_img04.setImageResource(R.drawable.iron_part4);suit_img04.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part4_14.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[3] = 14; suit_img04.setImageResource(R.drawable.fairy_part4);suit_img04.setBackgroundResource(R.drawable.rare6);sum();}});
        //suit_part4_15.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[3] = 15; suit_img04.setImageResource(R.drawable.gentleman_part4);suit_img04.setBackgroundResource(R.drawable.rare6);sum();}});
        //suit_part4_16.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[3] = 16; suit_img04.setImageResource(R.drawable.gentleman_part4);suit_img04.setBackgroundResource(R.drawable.rare6);sum();}});

    }
    public void suit5(View v){
        final Dialog dialog = new Dialog(this, R.style.NormalDialogStyle_N);
        View view = View.inflate(this, R.layout.suit5_choose, null);

        ImageView suit_part5_1	 = view.findViewById(R.id.suit_part5_1);
        ImageView suit_part5_2	 = view.findViewById(R.id.suit_part5_2);
        ImageView suit_part5_3	 = view.findViewById(R.id.suit_part5_3);
        ImageView suit_part5_4	 = view.findViewById(R.id.suit_part5_4);
        ImageView suit_part5_5	 = view.findViewById(R.id.suit_part5_5);
        ImageView suit_part5_6	 = view.findViewById(R.id.suit_part5_6);
        ImageView suit_part5_7	 = view.findViewById(R.id.suit_part5_7);
        ImageView suit_part5_8	 = view.findViewById(R.id.suit_part5_8);
        ImageView suit_part5_9	 = view.findViewById(R.id.suit_part5_9);
        ImageView suit_part5_10	 = view.findViewById(R.id.suit_part5_10);
        ImageView suit_part5_11	 = view.findViewById(R.id.suit_part5_11);
        ImageView suit_part5_12	 = view.findViewById(R.id.suit_part5_12);
        ImageView suit_part5_13	 = view.findViewById(R.id.suit_part5_13);
        ImageView suit_part5_14	 = view.findViewById(R.id.suit_part5_14);
        ImageView suit_part5_15	 = view.findViewById(R.id.suit_part5_15);
        ImageView suit_part5_16	 = view.findViewById(R.id.suit_part5_16);

        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        //view.setMinimumHeight((int) (ScreenSizeUtils.getInstance(this).getScreenHeight()));
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int) (ScreenSizeUtils.getInstance(this).getScreenWidth()*0.8);
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);
        dialog.setCancelable(false);
        dialog.show();

        suit_part5_1.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[4] = 1 ; suit_img05.setImageResource(R.drawable.tamamoe_part5);suit_img05.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part5_2.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[4] = 2 ; suit_img05.setImageResource(R.drawable.fighter_maid_part5);suit_img05.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part5_3.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[4] = 3 ; suit_img05.setImageResource(R.drawable.sakura_fall_part5);suit_img05.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part5_4.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[4] = 4 ; suit_img05.setImageResource(R.drawable.xmas_part5);suit_img05.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part5_5.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[4] = 5 ; suit_img05.setImageResource(R.drawable.mirai_part5);suit_img05.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part5_6.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[4] = 6 ; suit_img05.setImageResource(R.drawable.hanabit_part5);suit_img05.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part5_7.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[4] = 7 ; suit_img05.setImageResource(R.drawable.scv_part5);suit_img05.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part5_8.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[4] = 8 ; suit_img05.setImageResource(R.drawable.battlefield_part5);suit_img05.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part5_9.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[4] = 9 ; suit_img05.setImageResource(R.drawable.hope_part5);suit_img05.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part5_10.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[4] = 10 ; suit_img05.setImageResource(R.drawable.daybreak_part5);suit_img05.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part5_11.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[4] = 11 ; suit_img05.setImageResource(R.drawable.conqueror_part5);suit_img05.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part5_12.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[4] = 12; suit_img05.setImageResource(R.drawable.gentleman_part5);suit_img05.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part5_13.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[4] = 13; suit_img05.setImageResource(R.drawable.iron_part5);suit_img05.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part5_14.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[4] = 14; suit_img05.setImageResource(R.drawable.fairy_part5);suit_img05.setBackgroundResource(R.drawable.rare6);sum();}});
        //suit_part5_15.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[4] = 15; suit_img05.setImageResource(R.drawable.gentleman_part5);suit_img05.setBackgroundResource(R.drawable.rare6);sum();}});
        //suit_part5_16.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[4] = 16; suit_img05.setImageResource(R.drawable.gentleman_part5);suit_img05.setBackgroundResource(R.drawable.rare6);sum();}});
    }
    public void suit6(View v){
        final Dialog dialog = new Dialog(this, R.style.NormalDialogStyle_N);
        View view = View.inflate(this, R.layout.suit6_choose, null);

        ImageView suit_part6_1	 = view.findViewById(R.id.suit_part6_1);
        ImageView suit_part6_2	 = view.findViewById(R.id.suit_part6_2);
        ImageView suit_part6_3	 = view.findViewById(R.id.suit_part6_3);
        ImageView suit_part6_4	 = view.findViewById(R.id.suit_part6_4);
        ImageView suit_part6_5	 = view.findViewById(R.id.suit_part6_5);
        ImageView suit_part6_6	 = view.findViewById(R.id.suit_part6_6);
        ImageView suit_part6_7	 = view.findViewById(R.id.suit_part6_7);
        ImageView suit_part6_8	 = view.findViewById(R.id.suit_part6_8);
        ImageView suit_part6_9	 = view.findViewById(R.id.suit_part6_9);
        ImageView suit_part6_10	 = view.findViewById(R.id.suit_part6_10);
        ImageView suit_part6_11	 = view.findViewById(R.id.suit_part6_11);
        ImageView suit_part6_12	 = view.findViewById(R.id.suit_part6_12);
        ImageView suit_part6_13	 = view.findViewById(R.id.suit_part6_13);
        ImageView suit_part6_14	 = view.findViewById(R.id.suit_part6_14);
        ImageView suit_part6_15	 = view.findViewById(R.id.suit_part6_15);
        ImageView suit_part6_16	 = view.findViewById(R.id.suit_part6_16);

        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        //view.setMinimumHeight((int) (ScreenSizeUtils.getInstance(this).getScreenHeight()));
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int) (ScreenSizeUtils.getInstance(this).getScreenWidth()*0.8);
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);
        dialog.setCancelable(false);
        dialog.show();

        suit_part6_1.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[5] = 1 ; suit_img06.setImageResource(R.drawable.tamamoe_part6);suit_img06.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part6_2.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[5] = 2 ; suit_img06.setImageResource(R.drawable.fighter_maid_part6);suit_img06.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part6_3.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[5] = 3 ; suit_img06.setImageResource(R.drawable.sakura_fall_part6);suit_img06.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part6_4.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[5] = 4 ; suit_img06.setImageResource(R.drawable.xmas_part6);suit_img06.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part6_5.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[5] = 5 ; suit_img06.setImageResource(R.drawable.mirai_part6);suit_img06.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part6_6.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[5] = 6 ; suit_img06.setImageResource(R.drawable.hanabit_part6);suit_img06.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part6_7.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[5] = 7 ; suit_img06.setImageResource(R.drawable.scv_part6);suit_img06.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part6_8.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[5] = 8 ; suit_img06.setImageResource(R.drawable.battlefield_part6);suit_img06.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part6_9.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[5] = 9 ; suit_img06.setImageResource(R.drawable.hope_part6);suit_img06.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part6_10.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[5] = 10 ; suit_img06.setImageResource(R.drawable.daybreak_part6);suit_img06.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part6_11.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[5] = 11 ; suit_img06.setImageResource(R.drawable.conqueror_part6);suit_img06.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part6_12.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[5] = 12; suit_img06.setImageResource(R.drawable.gentleman_part6);suit_img06.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part6_13.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[5] = 13; suit_img06.setImageResource(R.drawable.iron_part6);suit_img06.setBackgroundResource(R.drawable.rare6);sum();}});
        suit_part6_14.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[5] = 14; suit_img06.setImageResource(R.drawable.fairy_part6);suit_img06.setBackgroundResource(R.drawable.rare6);sum();}});
        //suit_part6_15.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[5] = 15; suit_img06.setImageResource(R.drawable.gentleman_part6);suit_img06.setBackgroundResource(R.drawable.rare6);sum();}});
        //suit_part6_16.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {dialog.dismiss();suit_id[5] = 16; suit_img06.setImageResource(R.drawable.gentleman_part6);suit_img06.setBackgroundResource(R.drawable.rare6);sum();}});

    }
    public void suit_part8(View v) {
        final Dialog dialog = new Dialog(this, R.style.NormalDialogStyle_N);
        View view = View.inflate(this, R.layout.enabler_choose, null);
        ImageView akiyama = view.findViewById(R.id.akiyama);
        ImageView alice = view.findViewById(R.id.alice);
        ImageView ana_o = view.findViewById(R.id.ana_o);
        ImageView carol = view.findViewById(R.id.carol);
        ImageView catherine = view.findViewById(R.id.catherine);
        ImageView celesia = view.findViewById(R.id.celesia);
        ImageView chen = view.findViewById(R.id.chen);
        ImageView chika = view.findViewById(R.id.chika);
        ImageView chiyo = view.findViewById(R.id.chiyo);
        ImageView comet = view.findViewById(R.id.comet);
        ImageView donner = view.findViewById(R.id.donner);
        ImageView eleanor = view.findViewById(R.id.eleanor);
        ImageView esther = view.findViewById(R.id.esther);
        ImageView fudo = view.findViewById(R.id.fudo);
        ImageView gin = view.findViewById(R.id.gin);
        ImageView hiyori = view.findViewById(R.id.hiyori);
        ImageView iris = view.findViewById(R.id.iris);
        ImageView kayo = view.findViewById(R.id.kayo);
        ImageView kirine = view.findViewById(R.id.kirine);
        ImageView kuroda = view.findViewById(R.id.kuroda);
        ImageView kurul = view.findViewById(R.id.kurul);
        ImageView lois = view.findViewById(R.id.lois);
        ImageView izumi = view.findViewById(R.id.lzumi);
        ImageView liuk = view.findViewById(R.id.liuk);
        ImageView masami = view.findViewById(R.id.masami);
        ImageView mika = view.findViewById(R.id.mika);
        ImageView minami = view.findViewById(R.id.minami);
        ImageView mio = view.findViewById(R.id.mio);
        ImageView mira = view.findViewById(R.id.mira);
        ImageView misaki = view.findViewById(R.id.misaki);
        ImageView nana = view.findViewById(R.id.nana);
        ImageView narumi = view.findViewById(R.id.narumi);
        ImageView odelia = view.findViewById(R.id.odelia);
        ImageView raly = view.findViewById(R.id.raly);
        ImageView risa = view.findViewById(R.id.risa);
        ImageView saki = view.findViewById(R.id.saki);
        ImageView saori = view.findViewById(R.id.saori);
        ImageView sara = view.findViewById(R.id.sara);
        ImageView sariko = view.findViewById(R.id.sariko);
        ImageView shiori = view.findViewById(R.id.shiori);
        ImageView shirley = view.findViewById(R.id.shirley);
        ImageView sumika = view.findViewById(R.id.sumika);
        ImageView sylvia = view.findViewById(R.id.sylvia);
        ImageView uzuki = view.findViewById(R.id.uzuki);
        ImageView yesi = view.findViewById(R.id.yesi);
        ImageView youko = view.findViewById(R.id.youko);
        ImageView zero = view.findViewById(R.id.zero);
        ImageView zrs2 = view.findViewById(R.id.zrs2);

        ImageView sp_sara = view.findViewById(R.id.sp_sara);
        ImageView yui = view.findViewById(R.id.yui);
        ImageView demoZ = view.findViewById(R.id.demoZ);

        akiyama.setVisibility(View.VISIBLE);
        alice.setVisibility(View.VISIBLE);
        ana_o.setVisibility(View.VISIBLE);
        carol.setVisibility(View.VISIBLE);
        catherine.setVisibility(View.VISIBLE);
        celesia.setVisibility(View.VISIBLE);
        chen.setVisibility(View.VISIBLE);
        chika.setVisibility(View.VISIBLE);
        chiyo.setVisibility(View.VISIBLE);
        comet.setVisibility(View.VISIBLE);
        donner.setVisibility(View.VISIBLE);
        eleanor.setVisibility(View.VISIBLE);
        esther.setVisibility(View.VISIBLE);
        fudo.setVisibility(View.VISIBLE);
        gin.setVisibility(View.VISIBLE);
        hiyori.setVisibility(View.VISIBLE);
        iris.setVisibility(View.VISIBLE);
        kayo.setVisibility(View.VISIBLE);
        kirine.setVisibility(View.VISIBLE);
        kuroda.setVisibility(View.VISIBLE);
        kurul.setVisibility(View.VISIBLE);
        lois.setVisibility(View.VISIBLE);
        liuk.setVisibility(View.VISIBLE);
        izumi.setVisibility(View.VISIBLE);
        masami.setVisibility(View.VISIBLE);
        mika.setVisibility(View.VISIBLE);
        minami.setVisibility(View.VISIBLE);
        mio.setVisibility(View.VISIBLE);
        mira.setVisibility(View.VISIBLE);
        misaki.setVisibility(View.VISIBLE);
        nana.setVisibility(View.VISIBLE);
        narumi.setVisibility(View.VISIBLE);
        odelia.setVisibility(View.VISIBLE);
        raly.setVisibility(View.VISIBLE);
        risa.setVisibility(View.VISIBLE);
        saki.setVisibility(View.VISIBLE);
        saori.setVisibility(View.VISIBLE);
        sara.setVisibility(View.VISIBLE);
        sariko.setVisibility(View.VISIBLE);
        shiori.setVisibility(View.VISIBLE);
        shirley.setVisibility(View.VISIBLE);
        sumika.setVisibility(View.VISIBLE);
        sylvia.setVisibility(View.VISIBLE);
        uzuki.setVisibility(View.VISIBLE);
        yesi.setVisibility(View.VISIBLE);
        youko.setVisibility(View.VISIBLE);
        zero.setVisibility(View.VISIBLE);
        zrs2.setVisibility(View.VISIBLE);

        sp_sara.setVisibility(View.VISIBLE);
        yui.setVisibility(View.VISIBLE);
        demoZ.setVisibility(View.VISIBLE);

        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        //view.setMinimumHeight((int) (ScreenSizeUtils.getInstance(this).getScreenHeight()));
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int) (ScreenSizeUtils.getInstance(this).getScreenWidth() * 0.8);
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);
        dialog.show();

        sum();

        akiyama.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="akiyama";HEROA.setImageResource(R.drawable.akiyama);suit08_ic.setImageResource(R.drawable.enabler_akiyama);hero_back2();}});
        alice.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="alice";HEROA.setImageResource(R.drawable.alice);suit08_ic.setImageResource(R.drawable.enabler_alice);hero_back2();}});
        ana_o.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="ana_o";HEROA.setImageResource(R.drawable.ana_o);suit08_ic.setImageResource(R.drawable.enabler_ana_o);hero_back2();}});
        carol.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="carol";HEROA.setImageResource(R.drawable.carol);suit08_ic.setImageResource(R.drawable.enabler_carol);hero_back2();}});
        catherine.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="catherine";HEROA.setImageResource(R.drawable.catherine);suit08_ic.setImageResource(R.drawable.enabler_catherine);hero_back2();}});
        celesia.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="celesia";HEROA.setImageResource(R.drawable.celesia);suit08_ic.setImageResource(R.drawable.enabler_celesia);hero_back2();}});
        chen.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="chen";HEROA.setImageResource(R.drawable.chen);suit08_ic.setImageResource(R.drawable.enabler_chen);hero_back2();}});
        chika.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="chika";HEROA.setImageResource(R.drawable.chika);suit08_ic.setImageResource(R.drawable.enabler_chika);hero_back2();}});
        chiyo.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="chiyo";HEROA.setImageResource(R.drawable.chiyo);suit08_ic.setImageResource(R.drawable.enabler_chiyo);hero_back2();}});
        comet.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="comet";HEROA.setImageResource(R.drawable.comet);suit08_ic.setImageResource(R.drawable.enabler_comet);hero_back2();}});
        donner.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="donner";HEROA.setImageResource(R.drawable.donner);suit08_ic.setImageResource(R.drawable.enabler_donner);hero_back2();}});
        eleanor.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="eleanor";HEROA.setImageResource(R.drawable.eleanor);suit08_ic.setImageResource(R.drawable.enabler_eleanor);hero_back2();}});
        esther.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="esther";HEROA.setImageResource(R.drawable.esther);suit08_ic.setImageResource(R.drawable.enabler_esther);hero_back2();}});
        fudo.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="fudo";HEROA.setImageResource(R.drawable.fudo);suit08_ic.setImageResource(R.drawable.enabler_fudo);hero_back2();}});
        gin.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="gin";HEROA.setImageResource(R.drawable.gin);suit08_ic.setImageResource(R.drawable.enabler_gin);hero_back2();}});
        hiyori.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="hiyori";HEROA.setImageResource(R.drawable.hiyori);suit08_ic.setImageResource(R.drawable.enabler_hiyori);hero_back2();}});
        iris.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="iris";HEROA.setImageResource(R.drawable.iris);suit08_ic.setImageResource(R.drawable.enabler_iris);hero_back2();}});
        izumi.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="izumi";HEROA.setImageResource(R.drawable.izumi);suit08_ic.setImageResource(R.drawable.enabler_izumi);hero_back2();}});
        kayo.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="kayo";HEROA.setImageResource(R.drawable.kayo);suit08_ic.setImageResource(R.drawable.enabler_kayo);hero_back2();}});
        kirine.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="kirine";HEROA.setImageResource(R.drawable.kirine);suit08_ic.setImageResource(R.drawable.enabler_kirine);hero_back2();}});
        kuroda.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="kuroda";HEROA.setImageResource(R.drawable.kuroda);suit08_ic.setImageResource(R.drawable.enabler_kuroda);hero_back2();}});
        kurul.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="kurul";HEROA.setImageResource(R.drawable.kurul);suit08_ic.setImageResource(R.drawable.enabler_kurul);hero_back2();}});
        liuk.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="liuk";HEROA.setImageResource(R.drawable.liuk);suit08_ic.setImageResource(R.drawable.enabler_liuk);hero_back2();}});
        lois.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="lois";HEROA.setImageResource(R.drawable.lois);suit08_ic.setImageResource(R.drawable.enabler_lois);hero_back2();}});
        masami.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="masami";HEROA.setImageResource(R.drawable.masami);suit08_ic.setImageResource(R.drawable.enabler_masami);hero_back2();}});
        mika.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="mika";HEROA.setImageResource(R.drawable.mika);suit08_ic.setImageResource(R.drawable.enabler_mika);hero_back2();}});
        minami.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="minami";HEROA.setImageResource(R.drawable.minami);suit08_ic.setImageResource(R.drawable.enabler_minami);hero_back2();}});
        mio.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="mio";HEROA.setImageResource(R.drawable.mio);suit08_ic.setImageResource(R.drawable.enabler_mio);hero_back2();}});
        mira.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="mira";HEROA.setImageResource(R.drawable.mira);suit08_ic.setImageResource(R.drawable.enabler_mira);hero_back2();}});
        misaki.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="misaki";HEROA.setImageResource(R.drawable.misaki);suit08_ic.setImageResource(R.drawable.enabler_misaki);hero_back2();}});
        nana.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="nana";HEROA.setImageResource(R.drawable.nana);suit08_ic.setImageResource(R.drawable.enabler_nana);hero_back2();}});
        narumi.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="narumi";HEROA.setImageResource(R.drawable.narumi);suit08_ic.setImageResource(R.drawable.enabler_narumi);hero_back2();}});
        odelia.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="odelia";HEROA.setImageResource(R.drawable.odelia);suit08_ic.setImageResource(R.drawable.enabler_odelia);hero_back2();}});
        raly.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="raly";HEROA.setImageResource(R.drawable.raly);suit08_ic.setImageResource(R.drawable.enabler_raly);hero_back2();}});
        risa.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="risa";HEROA.setImageResource(R.drawable.risa);suit08_ic.setImageResource(R.drawable.enabler_risa);hero_back2();}});
        saki.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="saki";HEROA.setImageResource(R.drawable.saki);suit08_ic.setImageResource(R.drawable.enabler_saki);hero_back2();}});
        saori.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="saori";HEROA.setImageResource(R.drawable.saori);suit08_ic.setImageResource(R.drawable.enabler_saori);hero_back2();}});
        sara.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="sara";HEROA.setImageResource(R.drawable.sara);suit08_ic.setImageResource(R.drawable.enabler_sara);hero_back2();}});
        sariko.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="sariko";HEROA.setImageResource(R.drawable.sariko);suit08_ic.setImageResource(R.drawable.enabler_sariko);hero_back2();}});
        shiori.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="shiori";HEROA.setImageResource(R.drawable.shiori);suit08_ic.setImageResource(R.drawable.enabler_shiori);hero_back2();}});
        shirley.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="shirley";HEROA.setImageResource(R.drawable.shirley);suit08_ic.setImageResource(R.drawable.enabler_shirley);hero_back2();}});
        sp_sara.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="sp_sara";HEROA.setImageResource(R.drawable.sp_sara);suit08_ic.setImageResource(R.drawable.enabler_sp_sara);hero_back2();}});
        sumika.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="sumika";HEROA.setImageResource(R.drawable.sumika);suit08_ic.setImageResource(R.drawable.enabler_sumika);hero_back2();}});
        sylvia.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="sylvia";HEROA.setImageResource(R.drawable.sylvia);suit08_ic.setImageResource(R.drawable.enabler_sylvia);hero_back2();}});
        uzuki.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="uzuki";HEROA.setImageResource(R.drawable.uzuki);suit08_ic.setImageResource(R.drawable.enabler_uzuki);hero_back2();}});
        yesi.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="yesi";HEROA.setImageResource(R.drawable.yesi);suit08_ic.setImageResource(R.drawable.enabler_yesi);hero_back2();}});
        youko.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="youko";HEROA.setImageResource(R.drawable.youko);suit08_ic.setImageResource(R.drawable.enabler_youko);hero_back2();}});
        yui.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="yui";HEROA.setImageResource(R.drawable.yui);suit08_ic.setImageResource(R.drawable.enabler_yui);hero_back2();}});
        zero.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="zero";HEROA.setImageResource(R.drawable.zero);suit08_ic.setImageResource(R.drawable.enabler_zero);hero_back2();}});
        zrs2.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();hero_a ="zrs2";HEROA.setImageResource(R.drawable.zrs_2);suit08_ic.setImageResource(R.drawable.enabler_zrs2);hero_back2();}});

    }
    public void Calculate() {
        adapter.clear();
        if (suit_id[0] == 1){suit01_ic.setImageResource(R.drawable.tamamoe_part1);suit_img01.setImageResource(R.drawable.tamamoe_part1);suit01_name.setText(getString(R.string.tamamoe_part1));suit_img01.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[0] == 2){suit01_ic.setImageResource(R.drawable.fighter_maid_part1);suit_img01.setImageResource(R.drawable.fighter_maid_part1);suit01_name.setText(getString(R.string.maid_part1));suit_img01.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[0] == 3){suit01_ic.setImageResource(R.drawable.sakura_fall_part1);suit_img01.setImageResource(R.drawable.sakura_fall_part1);suit01_name.setText(getString(R.string.sakura_part1));suit_img01.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[0] == 4){suit01_ic.setImageResource(R.drawable.xmas_part1);suit_img01.setImageResource(R.drawable.xmas_part1);suit01_name.setText(getString(R.string.xmas_part1));suit_img01.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[0] == 5){suit01_ic.setImageResource(R.drawable.mirai_part1);suit_img01.setImageResource(R.drawable.mirai_part1);suit01_name.setText(getString(R.string.mirai_part1));suit_img01.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[0] == 6){suit01_ic.setImageResource(R.drawable.hanabit_part1);suit_img01.setImageResource(R.drawable.hanabit_part1);suit01_name.setText(getString(R.string.firework_part1));suit_img01.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[0] == 7){suit01_ic.setImageResource(R.drawable.scv_part1);suit_img01.setImageResource(R.drawable.scv_part1);suit01_name.setText(getString(R.string.scv_part1));suit_img01.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[0] == 8){suit01_ic.setImageResource(R.drawable.battlefield_part1);suit_img01.setImageResource(R.drawable.battlefield_part1);suit01_name.setText(getString(R.string.valkyrie_part1));suit_img01.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[0] == 9){suit01_ic.setImageResource(R.drawable.hope_part1);suit_img01.setImageResource(R.drawable.hope_part1);suit01_name.setText(getString(R.string.hope_part1));suit_img01.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[0] == 10){suit01_ic.setImageResource(R.drawable.daybreak_part1);suit_img01.setImageResource(R.drawable.daybreak_part1);suit01_name.setText(getString(R.string.daybreak_part1));suit_img01.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[0] == 11){suit01_ic.setImageResource(R.drawable.conqueror_part1);suit_img01.setImageResource(R.drawable.conqueror_part1);suit01_name.setText(getString(R.string.conqueror_part1));suit_img01.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[0] == 12){suit01_ic.setImageResource(R.drawable.gentleman_part1);suit_img01.setImageResource(R.drawable.gentleman_part1);suit01_name.setText(getString(R.string.gentleman_part1));suit_img01.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[0] == 13){suit01_ic.setImageResource(R.drawable.iron_part1);suit_img01.setImageResource(R.drawable.iron_part1);suit01_name.setText(getString(R.string.origin_part1));suit_img01.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[0] == 14){suit01_ic.setImageResource(R.drawable.fairy_part1);suit_img01.setImageResource(R.drawable.fairy_part1);suit01_name.setText(getString(R.string.fairy_part1));suit_img01.setBackgroundResource(R.drawable.rare6);}

        if (suit_id[1] == 1){suit02_ic.setImageResource(R.drawable.tamamoe_part2);suit_img02.setImageResource(R.drawable.tamamoe_part2);suit02_name.setText(getString(R.string.tamamoe_part2));suit_img02.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[1] == 2){suit02_ic.setImageResource(R.drawable.fighter_maid_part2);suit_img02.setImageResource(R.drawable.fighter_maid_part2);suit02_name.setText(getString(R.string.maid_part2));suit_img02.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[1] == 3){suit02_ic.setImageResource(R.drawable.sakura_fall_part2);suit_img02.setImageResource(R.drawable.sakura_fall_part2);suit02_name.setText(getString(R.string.sakura_part2));suit_img02.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[1] == 4){suit02_ic.setImageResource(R.drawable.xmas_part2);suit_img02.setImageResource(R.drawable.xmas_part2);suit02_name.setText(getString(R.string.xmas_part2));suit_img02.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[1] == 5){suit02_ic.setImageResource(R.drawable.mirai_part2);suit_img02.setImageResource(R.drawable.mirai_part2);suit02_name.setText(getString(R.string.mirai_part2));suit_img02.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[1] == 6){suit02_ic.setImageResource(R.drawable.hanabit_part2);suit_img02.setImageResource(R.drawable.hanabit_part2);suit02_name.setText(getString(R.string.firework_part2));suit_img02.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[1] == 7){suit02_ic.setImageResource(R.drawable.scv_part2);suit_img02.setImageResource(R.drawable.scv_part2);suit02_name.setText(getString(R.string.scv_part2));suit_img02.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[1] == 8){suit02_ic.setImageResource(R.drawable.battlefield_part2);suit_img02.setImageResource(R.drawable.battlefield_part2);suit02_name.setText(getString(R.string.valkyrie_part2));suit_img02.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[1] == 9){suit02_ic.setImageResource(R.drawable.hope_part2);suit_img02.setImageResource(R.drawable.hope_part2);suit02_name.setText(getString(R.string.hope_part2));suit_img02.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[1] == 10){suit02_ic.setImageResource(R.drawable.daybreak_part2);suit_img02.setImageResource(R.drawable.daybreak_part2);suit02_name.setText(getString(R.string.daybreak_part2));suit_img02.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[1] == 11){suit02_ic.setImageResource(R.drawable.conqueror_part2);suit_img02.setImageResource(R.drawable.conqueror_part2);suit02_name.setText(getString(R.string.conqueror_part2));suit_img02.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[1] == 12){suit02_ic.setImageResource(R.drawable.gentleman_part2);suit_img02.setImageResource(R.drawable.gentleman_part2);suit02_name.setText(getString(R.string.gentleman_part2));suit_img02.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[1] == 13){suit02_ic.setImageResource(R.drawable.iron_part2);suit_img02.setImageResource(R.drawable.iron_part2);suit02_name.setText(getString(R.string.origin_part2));suit_img02.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[1] == 14){suit02_ic.setImageResource(R.drawable.fairy_part2);suit_img02.setImageResource(R.drawable.fairy_part2);suit02_name.setText(getString(R.string.fairy_part2));suit_img02.setBackgroundResource(R.drawable.rare6);}

        if (suit_id[2] == 1){suit03_ic.setImageResource(R.drawable.tamamoe_part3);suit_img03.setImageResource(R.drawable.tamamoe_part3);suit03_name.setText(getString(R.string.tamamoe_part3));suit_img03.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[2] == 2){suit03_ic.setImageResource(R.drawable.fighter_maid_part3);suit_img03.setImageResource(R.drawable.fighter_maid_part3);suit03_name.setText(getString(R.string.maid_part3));suit_img03.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[2] == 3){suit03_ic.setImageResource(R.drawable.sakura_fall_part3);suit_img03.setImageResource(R.drawable.sakura_fall_part3);suit03_name.setText(getString(R.string.sakura_part3));suit_img03.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[2] == 4){suit03_ic.setImageResource(R.drawable.xmas_part3);suit_img03.setImageResource(R.drawable.xmas_part3);suit03_name.setText(getString(R.string.xmas_part3));suit_img03.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[2] == 5){suit03_ic.setImageResource(R.drawable.mirai_part3);suit_img03.setImageResource(R.drawable.mirai_part3);suit03_name.setText(getString(R.string.mirai_part3));suit_img03.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[2] == 6){suit03_ic.setImageResource(R.drawable.hanabit_part3);suit_img03.setImageResource(R.drawable.hanabit_part3);suit03_name.setText(getString(R.string.firework_part3));suit_img03.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[2] == 7){suit03_ic.setImageResource(R.drawable.scv_part3);suit_img03.setImageResource(R.drawable.scv_part3);suit03_name.setText(getString(R.string.scv_part3));suit_img03.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[2] == 8){suit03_ic.setImageResource(R.drawable.battlefield_part3);suit_img03.setImageResource(R.drawable.battlefield_part3);suit03_name.setText(getString(R.string.valkyrie_part3));suit_img03.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[2] == 9){suit03_ic.setImageResource(R.drawable.hope_part3);suit_img03.setImageResource(R.drawable.hope_part3);suit03_name.setText(getString(R.string.hope_part3));suit_img03.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[2] == 10){suit03_ic.setImageResource(R.drawable.daybreak_part3);suit_img03.setImageResource(R.drawable.daybreak_part3);suit03_name.setText(getString(R.string.daybreak_part3));suit_img03.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[2] == 11){suit03_ic.setImageResource(R.drawable.conqueror_part3);suit_img03.setImageResource(R.drawable.conqueror_part3);suit03_name.setText(getString(R.string.conqueror_part3));suit_img03.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[2] == 12){suit03_ic.setImageResource(R.drawable.gentleman_part3);suit_img03.setImageResource(R.drawable.gentleman_part3);suit03_name.setText(getString(R.string.gentleman_part3));suit_img03.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[2] == 13){suit03_ic.setImageResource(R.drawable.iron_part3);suit_img03.setImageResource(R.drawable.iron_part3);suit03_name.setText(getString(R.string.origin_part3));suit_img03.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[2] == 14){suit03_ic.setImageResource(R.drawable.fairy_part3);suit_img03.setImageResource(R.drawable.fairy_part3);suit03_name.setText(getString(R.string.fairy_part3));suit_img03.setBackgroundResource(R.drawable.rare6);}

        if (suit_id[3] == 1){suit04_ic.setImageResource(R.drawable.tamamoe_part4);suit_img04.setImageResource(R.drawable.tamamoe_part4);suit04_name.setText(getString(R.string.tamamoe_part4));suit_img04.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[3] == 2){suit04_ic.setImageResource(R.drawable.fighter_maid_part4);suit_img04.setImageResource(R.drawable.fighter_maid_part4);suit04_name.setText(getString(R.string.maid_part4));suit_img04.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[3] == 3){suit04_ic.setImageResource(R.drawable.sakura_fall_part4);suit_img04.setImageResource(R.drawable.sakura_fall_part4);suit04_name.setText(getString(R.string.sakura_part4));suit_img04.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[3] == 4){suit04_ic.setImageResource(R.drawable.xmas_part4);suit_img04.setImageResource(R.drawable.xmas_part4);suit04_name.setText(getString(R.string.xmas_part4));suit_img04.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[3] == 5){suit04_ic.setImageResource(R.drawable.mirai_part4);suit_img04.setImageResource(R.drawable.mirai_part4);suit04_name.setText(getString(R.string.mirai_part4));suit_img04.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[3] == 6){suit04_ic.setImageResource(R.drawable.hanabit_part4);suit_img04.setImageResource(R.drawable.hanabit_part4);suit04_name.setText(getString(R.string.firework_part4));suit_img04.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[3] == 7){suit04_ic.setImageResource(R.drawable.scv_part4);suit_img04.setImageResource(R.drawable.scv_part4);suit04_name.setText(getString(R.string.scv_part4));suit_img04.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[3] == 8){suit04_ic.setImageResource(R.drawable.battlefield_part4);suit_img04.setImageResource(R.drawable.battlefield_part4);suit04_name.setText(getString(R.string.valkyrie_part4));suit_img04.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[3] == 9){suit04_ic.setImageResource(R.drawable.hope_part4);suit_img04.setImageResource(R.drawable.hope_part4);suit04_name.setText(getString(R.string.hope_part4));suit_img04.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[3] == 10){suit04_ic.setImageResource(R.drawable.daybreak_part4);suit_img04.setImageResource(R.drawable.daybreak_part4);suit04_name.setText(getString(R.string.daybreak_part4));suit_img04.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[3] == 11){suit04_ic.setImageResource(R.drawable.conqueror_part4);suit_img04.setImageResource(R.drawable.conqueror_part4);suit04_name.setText(getString(R.string.conqueror_part4));suit_img04.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[3] == 12){suit04_ic.setImageResource(R.drawable.gentleman_part4);suit_img04.setImageResource(R.drawable.gentleman_part4);suit04_name.setText(getString(R.string.gentleman_part4));suit_img04.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[3] == 13){suit04_ic.setImageResource(R.drawable.iron_part4);suit_img04.setImageResource(R.drawable.iron_part4);suit04_name.setText(getString(R.string.origin_part4));suit_img04.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[3] == 14){suit04_ic.setImageResource(R.drawable.fairy_part4);suit_img04.setImageResource(R.drawable.fairy_part4);suit04_name.setText(getString(R.string.fairy_part4));suit_img04.setBackgroundResource(R.drawable.rare6);}

        if (suit_id[4] == 1){suit05_ic.setImageResource(R.drawable.tamamoe_part5);suit_img05.setImageResource(R.drawable.tamamoe_part5);suit05_name.setText(getString(R.string.tamamoe_part5));suit_img05.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[4] == 2){suit05_ic.setImageResource(R.drawable.fighter_maid_part5);suit_img05.setImageResource(R.drawable.fighter_maid_part5);suit05_name.setText(getString(R.string.maid_part5));suit_img05.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[4] == 3){suit05_ic.setImageResource(R.drawable.sakura_fall_part5);suit_img05.setImageResource(R.drawable.sakura_fall_part5);suit05_name.setText(getString(R.string.sakura_part5));suit_img05.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[4] == 4){suit05_ic.setImageResource(R.drawable.xmas_part5);suit_img05.setImageResource(R.drawable.xmas_part5);suit05_name.setText(getString(R.string.xmas_part5));suit_img05.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[4] == 5){suit05_ic.setImageResource(R.drawable.mirai_part5);suit_img05.setImageResource(R.drawable.mirai_part5);suit05_name.setText(getString(R.string.mirai_part5));suit_img05.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[4] == 6){suit05_ic.setImageResource(R.drawable.hanabit_part5);suit_img05.setImageResource(R.drawable.hanabit_part5);suit05_name.setText(getString(R.string.firework_part5));suit_img05.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[4] == 7){suit05_ic.setImageResource(R.drawable.scv_part5);suit_img05.setImageResource(R.drawable.scv_part5);suit05_name.setText(getString(R.string.scv_part5));suit_img05.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[4] == 8){suit05_ic.setImageResource(R.drawable.battlefield_part5);suit_img05.setImageResource(R.drawable.battlefield_part5);suit05_name.setText(getString(R.string.valkyrie_part5));suit_img05.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[4] == 9){suit05_ic.setImageResource(R.drawable.hope_part5);suit_img05.setImageResource(R.drawable.hope_part5);suit05_name.setText(getString(R.string.hope_part5));suit_img05.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[4] == 10){suit05_ic.setImageResource(R.drawable.daybreak_part5);suit_img05.setImageResource(R.drawable.daybreak_part5);suit05_name.setText(getString(R.string.daybreak_part5));suit_img05.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[4] == 11){suit05_ic.setImageResource(R.drawable.conqueror_part5);suit_img05.setImageResource(R.drawable.conqueror_part5);suit05_name.setText(getString(R.string.conqueror_part5));suit_img05.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[4] == 12){suit05_ic.setImageResource(R.drawable.gentleman_part5);suit_img05.setImageResource(R.drawable.gentleman_part5);suit05_name.setText(getString(R.string.gentleman_part5));suit_img05.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[4] == 13){suit05_ic.setImageResource(R.drawable.iron_part5);suit_img05.setImageResource(R.drawable.iron_part5);suit05_name.setText(getString(R.string.origin_part5));suit_img05.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[4] == 14){suit05_ic.setImageResource(R.drawable.fairy_part5);suit_img05.setImageResource(R.drawable.fairy_part5);suit05_name.setText(getString(R.string.fairy_part5));suit_img05.setBackgroundResource(R.drawable.rare6);}

        if (suit_id[5] == 1){suit06_ic.setImageResource(R.drawable.tamamoe_part6);suit_img06.setImageResource(R.drawable.tamamoe_part6);suit06_name.setText(getString(R.string.tamamoe_part6));suit_img06.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[5] == 2){suit06_ic.setImageResource(R.drawable.fighter_maid_part6);suit_img06.setImageResource(R.drawable.fighter_maid_part6);suit06_name.setText(getString(R.string.maid_part6));suit_img06.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[5] == 3){suit06_ic.setImageResource(R.drawable.sakura_fall_part6);suit_img06.setImageResource(R.drawable.sakura_fall_part6);suit06_name.setText(getString(R.string.sakura_part6));suit_img06.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[5] == 4){suit06_ic.setImageResource(R.drawable.xmas_part6);suit_img06.setImageResource(R.drawable.xmas_part6);suit06_name.setText(getString(R.string.xmas_part6));suit_img06.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[5] == 5){suit06_ic.setImageResource(R.drawable.mirai_part6);suit_img06.setImageResource(R.drawable.mirai_part6);suit06_name.setText(getString(R.string.mirai_part6));suit_img06.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[5] == 6){suit06_ic.setImageResource(R.drawable.hanabit_part6);suit_img06.setImageResource(R.drawable.hanabit_part6);suit06_name.setText(getString(R.string.firework_part6));suit_img06.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[5] == 7){suit06_ic.setImageResource(R.drawable.scv_part6);suit_img06.setImageResource(R.drawable.scv_part6);suit06_name.setText(getString(R.string.scv_part6));suit_img06.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[5] == 8){suit06_ic.setImageResource(R.drawable.battlefield_part6);suit_img06.setImageResource(R.drawable.battlefield_part6);suit06_name.setText(getString(R.string.valkyrie_part6));suit_img06.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[5] == 9){suit06_ic.setImageResource(R.drawable.hope_part6);suit_img06.setImageResource(R.drawable.hope_part6);suit06_name.setText(getString(R.string.hope_part6));suit_img06.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[5] == 10){suit06_ic.setImageResource(R.drawable.daybreak_part6);suit_img06.setImageResource(R.drawable.daybreak_part6);suit06_name.setText(getString(R.string.daybreak_part6));suit_img06.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[5] == 11){suit06_ic.setImageResource(R.drawable.conqueror_part6);suit_img06.setImageResource(R.drawable.conqueror_part6);suit06_name.setText(getString(R.string.conqueror_part6));suit_img06.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[5] == 12){suit06_ic.setImageResource(R.drawable.gentleman_part6);suit_img06.setImageResource(R.drawable.gentleman_part6);suit06_name.setText(getString(R.string.gentleman_part6));suit_img06.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[5] == 13){suit06_ic.setImageResource(R.drawable.iron_part6);suit_img06.setImageResource(R.drawable.iron_part6);suit06_name.setText(getString(R.string.origin_part6));suit_img06.setBackgroundResource(R.drawable.rare6);}
        if (suit_id[5] == 14){suit06_ic.setImageResource(R.drawable.fairy_part6);suit_img06.setImageResource(R.drawable.fairy_part6);suit06_name.setText(getString(R.string.fairy_part6));suit_img06.setBackgroundResource(R.drawable.rare6);}

        long buff_base ;
        double buff_final ;
        int[] suit_part1 = new int[10], suit_part2= new int[10] , suit_part3= new int[10] , suit_part4= new int[10] , suit_part5 = new int[10], suit_part6= new int[10] ;

        if (suit_id[0] == 1){suit_part1 = tamamoe_part02_buff;}
        if (suit_id[0] == 2){suit_part1 = maid_part02_buff;}
        if (suit_id[0] == 3){suit_part1 = falling_sakura_part02_buff;}
        if (suit_id[0] == 4){suit_part1 = x_mas_part02_buff;}
        if (suit_id[0] == 5){suit_part1 = miral_part02_buff;}
        if (suit_id[0] == 6){suit_part1 = firework_part02_buff;}
        if (suit_id[0] == 7){suit_part1 = scv_part02_buff;}
        if (suit_id[0] == 8){suit_part1 = valkyrie_part02_buff;}
        if (suit_id[0] == 9){suit_part1 = hope_part02_buff;}
        if (suit_id[0] == 10){suit_part1 = daybreak_part02_buff;}
        if (suit_id[0] == 11){suit_part1 = conqueror_part02_buff;}
        if (suit_id[0] == 12){suit_part1 = gentleman_part02_buff;}
        if (suit_id[0] == 13){suit_part1 = origin_part02_buff;}

        if (suit_id[1] == 1){suit_part2 = tamamoe_part03_buff;}
        if (suit_id[1] == 2){suit_part2 = maid_part03_buff;}
        if (suit_id[1] == 3){suit_part2 = falling_sakura_part03_buff;}
        if (suit_id[1] == 4){suit_part2 = x_mas_part03_buff;}
        if (suit_id[1] == 5){suit_part2 = miral_part03_buff;}
        if (suit_id[1] == 6){suit_part2 = firework_part03_buff;}
        if (suit_id[1] == 7){suit_part2 = scv_part03_buff;}
        if (suit_id[1] == 8){suit_part2 = valkyrie_part03_buff;}
        if (suit_id[1] == 9){suit_part2 = hope_part03_buff;}
        if (suit_id[1] == 10){suit_part2 = daybreak_part03_buff;}
        if (suit_id[1] == 11){suit_part2 = conqueror_part03_buff;}
        if (suit_id[1] == 12){suit_part2 = gentleman_part03_buff;}
        if (suit_id[1] == 13){suit_part2 = origin_part03_buff;}

        if (suit_id[2] == 1){suit_part3 = tamamoe_part04_buff;}
        if (suit_id[2] == 2){suit_part3 = maid_part04_buff;}
        if (suit_id[2] == 3){suit_part3 = falling_sakura_part04_buff;}
        if (suit_id[2] == 4){suit_part3 = x_mas_part04_buff;}
        if (suit_id[2] == 5){suit_part3 = miral_part04_buff;}
        if (suit_id[2] == 6){suit_part3 = firework_part04_buff;}
        if (suit_id[2] == 7){suit_part3 = scv_part04_buff;}
        if (suit_id[2] == 8){suit_part3 = valkyrie_part04_buff;}
        if (suit_id[2] == 9){suit_part3 = hope_part04_buff;}
        if (suit_id[2] == 10){suit_part3 = daybreak_part04_buff;}
        if (suit_id[2] == 11){suit_part3 = conqueror_part04_buff;}
        if (suit_id[2] == 12){suit_part3 = gentleman_part04_buff;}
        if (suit_id[2] == 13){suit_part3 = origin_part04_buff;}

        if (suit_id[3] == 1){suit_part4 = tamamoe_part01_buff;}
        if (suit_id[3] == 2){suit_part4 = maid_part01_buff;}
        if (suit_id[3] == 3){suit_part4 = falling_sakura_part01_buff;}
        if (suit_id[3] == 4){suit_part4 = x_mas_part01_buff;}
        if (suit_id[3] == 5){suit_part4 = miral_part01_buff;}
        if (suit_id[3] == 6){suit_part4 = firework_part01_buff;}
        if (suit_id[3] == 7){suit_part4 = scv_part01_buff;}
        if (suit_id[3] == 8){suit_part4 = valkyrie_part01_buff;}
        if (suit_id[3] == 9){suit_part4 = hope_part01_buff;}
        if (suit_id[3] == 10){suit_part4 = daybreak_part01_buff;}
        if (suit_id[3] == 11){suit_part4 = conqueror_part01_buff;}
        if (suit_id[3] == 12){suit_part4 = gentleman_part01_buff;}
        if (suit_id[3] == 13){suit_part4 = origin_part01_buff;}

        if (suit_id[4] == 1){suit_part5 = tamamoe_part05_buff;}
        if (suit_id[4] == 2){suit_part5 = maid_part05_buff;}
        if (suit_id[4] == 3){suit_part5 = falling_sakura_part05_buff;}
        if (suit_id[4] == 4){suit_part5 = x_mas_part05_buff;}
        if (suit_id[4] == 5){suit_part5 = miral_part05_buff;}
        if (suit_id[4] == 6){suit_part5 = firework_part05_buff;}
        if (suit_id[4] == 7){suit_part5 = scv_part05_buff;}
        if (suit_id[4] == 8){suit_part5 = valkyrie_part05_buff;}
        if (suit_id[4] == 9){suit_part5 = hope_part05_buff;}
        if (suit_id[4] == 10){suit_part5 = daybreak_part05_buff;}
        if (suit_id[4] == 11){suit_part5 = conqueror_part05_buff;}
        if (suit_id[4] == 12){suit_part5 = gentleman_part05_buff;}
        if (suit_id[4] == 13){suit_part5 = origin_part05_buff;}

        if (suit_id[5] == 1){suit_part6 = tamamoe_part06_buff;}
        if (suit_id[5] == 2){suit_part6 = maid_part06_buff;}
        if (suit_id[5] == 3){suit_part6 = falling_sakura_part06_buff;}
        if (suit_id[5] == 4){suit_part6 = x_mas_part06_buff;}
        if (suit_id[5] == 5){suit_part6 = miral_part06_buff;}
        if (suit_id[5] == 6){suit_part6 = firework_part06_buff;}
        if (suit_id[5] == 7){suit_part6 = scv_part06_buff;}
        if (suit_id[5] == 8){suit_part6 = valkyrie_part06_buff;}
        if (suit_id[5] == 9){suit_part6 = hope_part06_buff;}
        if (suit_id[5] == 10){suit_part6 = daybreak_part06_buff;}
        if (suit_id[5] == 11){suit_part6 = conqueror_part06_buff;}
        if (suit_id[5] == 12){suit_part6 = gentleman_part06_buff;}
        if (suit_id[5] == 13){suit_part6 = origin_part06_buff;}

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer integer : suit_id) {
            Integer num = map.get(integer);
            map.put(integer, num == null ? 1 : num + 1);
        }
        Set set = map.entrySet();
        Iterator it01 = map.keySet().iterator();
        while (it01.hasNext()) {
            Object key2 = it01.next();
            System.out.println("ID " + key2 + " 出现" + map.get(key2)+" 次");

            int key = (int) key2;
            int key3 = map.get(key2);

            Log.i("key2-3",key+" --- "+String.valueOf(key3));


            if (key == 1 	&& key3 == 1  ){	suit1_matchA = 	 false;	suit1_matchB = 	 false;	suit1_matchC = 	 false;	}
            if (key == 1 	&& key3 == 2  ){	suit1_matchA = 	 true;	suit1_matchB = 	 false;	suit1_matchC = 	 false;	}
            if (key == 1 	&& key3 == 3  ){	suit1_matchA = 	 true;	suit1_matchB = 	 false;	suit1_matchC = 	 false;	}
            if (key == 1 	&& key3 == 4  ){	suit1_matchA = 	 true;	suit1_matchB = 	 true;	suit1_matchC = 	 false;	}
            if (key == 1 	&& key3 == 5  ){	suit1_matchA = 	 true;	suit1_matchB = 	 true;	suit1_matchC = 	 false;	}
            if (key == 1 	&& key3 == 6  ){	suit1_matchA = 	 true;	suit1_matchB = 	 true;	suit1_matchC = 	 true;	}
            if (key == 2	&& key3 == 1  ){	suit2_matchA = 	 false;	suit2_matchB = 	 false;	suit2_matchC = 	 false;	}
            if (key == 2	&& key3 == 2  ){	suit2_matchA = 	 true;	suit2_matchB = 	 false;	suit2_matchC = 	 false;	}
            if (key == 2	&& key3 == 3  ){	suit2_matchA = 	 true;	suit2_matchB = 	 false;	suit2_matchC = 	 false;	}
            if (key == 2	&& key3 == 4  ){	suit2_matchA = 	 true;	suit2_matchB = 	 true;	suit2_matchC = 	 false;	}
            if (key == 2	&& key3 == 5  ){	suit2_matchA = 	 true;	suit2_matchB = 	 true;	suit2_matchC = 	 false;	}
            if (key == 2	&& key3 == 6  ){	suit2_matchA = 	 true;	suit2_matchB = 	 true;	suit2_matchC = 	 true;	}
            if (key == 3	&& key3 == 1  ){	suit3_matchA = 	 false;	suit3_matchB = 	 false;	suit3_matchC = 	 false;	}
            if (key == 3	&& key3 == 2  ){	suit3_matchA = 	 true;	suit3_matchB = 	 false;	suit3_matchC = 	 false;	}
            if (key == 3	&& key3 == 3  ){	suit3_matchA = 	 true;	suit3_matchB = 	 false;	suit3_matchC = 	 false;	}
            if (key == 3	&& key3 == 4  ){	suit3_matchA = 	 true;	suit3_matchB = 	 true;	suit3_matchC = 	 false;	}
            if (key == 3	&& key3 == 5  ){	suit3_matchA = 	 true;	suit3_matchB = 	 true;	suit3_matchC = 	 false;	}
            if (key == 3	&& key3 == 6  ){	suit3_matchA = 	 true;	suit3_matchB = 	 true;	suit3_matchC = 	 true;	}
            if (key == 4	&& key3 == 1  ){	suit4_matchA = 	 false;	suit4_matchB = 	 false;	suit4_matchC = 	 false;	}
            if (key == 4	&& key3 == 2  ){	suit4_matchA = 	 true;	suit4_matchB = 	 false;	suit4_matchC = 	 false;	}
            if (key == 4	&& key3 == 3  ){	suit4_matchA = 	 true;	suit4_matchB = 	 false;	suit4_matchC = 	 false;	}
            if (key == 4	&& key3 == 4  ){	suit4_matchA = 	 true;	suit4_matchB = 	 true;	suit4_matchC = 	 false;	}
            if (key == 4	&& key3 == 5  ){	suit4_matchA = 	 true;	suit4_matchB = 	 true;	suit4_matchC = 	 false;	}
            if (key == 4	&& key3 == 6  ){	suit4_matchA = 	 true;	suit4_matchB = 	 true;	suit4_matchC = 	 true;	}
            if (key == 5	&& key3 == 1  ){	suit5_matchA = 	 false;	suit5_matchB = 	 false;	suit5_matchC = 	 false;	}
            if (key == 5	&& key3 == 2  ){	suit5_matchA = 	 true;	suit5_matchB = 	 false;	suit5_matchC = 	 false;	}
            if (key == 5	&& key3 == 3  ){	suit5_matchA = 	 true;	suit5_matchB = 	 false;	suit5_matchC = 	 false;	}
            if (key == 5	&& key3 == 4  ){	suit5_matchA = 	 true;	suit5_matchB = 	 true;	suit5_matchC = 	 false;	}
            if (key == 5	&& key3 == 5  ){	suit5_matchA = 	 true;	suit5_matchB = 	 true;	suit5_matchC = 	 false;	}
            if (key == 5	&& key3 == 6  ){	suit5_matchA = 	 true;	suit5_matchB = 	 true;	suit5_matchC = 	 true;	}
            if (key == 6	&& key3 == 1  ){	suit6_matchA = 	 false;	suit6_matchB = 	 false;	suit6_matchC = 	 false;	}
            if (key == 6	&& key3 == 2  ){	suit6_matchA = 	 true;	suit6_matchB = 	 false;	suit6_matchC = 	 false;	}
            if (key == 6	&& key3 == 3  ){	suit6_matchA = 	 true;	suit6_matchB = 	 false;	suit6_matchC = 	 false;	}
            if (key == 6	&& key3 == 4  ){	suit6_matchA = 	 true;	suit6_matchB = 	 true;	suit6_matchC = 	 false;	}
            if (key == 6	&& key3 == 5  ){	suit6_matchA = 	 true;	suit6_matchB = 	 true;	suit6_matchC = 	 false;	}
            if (key == 6	&& key3 == 6  ){	suit6_matchA = 	 true;	suit6_matchB = 	 true;	suit6_matchC = 	 true;	}
            if (key == 7	&& key3 == 1  ){	suit7_matchA = 	 false;	suit7_matchB = 	 false;	suit7_matchC = 	 false;	}
            if (key == 7	&& key3 == 2  ){	suit7_matchA = 	 true;	suit7_matchB = 	 false;	suit7_matchC = 	 false;	}
            if (key == 7	&& key3 == 3  ){	suit7_matchA = 	 true;	suit7_matchB = 	 false;	suit7_matchC = 	 false;	}
            if (key == 7	&& key3 == 4  ){	suit7_matchA = 	 true;	suit7_matchB = 	 true;	suit7_matchC = 	 false;	}
            if (key == 7	&& key3 == 5  ){	suit7_matchA = 	 true;	suit7_matchB = 	 true;	suit7_matchC = 	 false;	}
            if (key == 7	&& key3 == 6  ){	suit7_matchA = 	 true;	suit7_matchB = 	 true;	suit7_matchC = 	 true;	}
            if (key == 8	&& key3 == 1  ){	suit8_matchA = 	 false;	suit8_matchB = 	 false;	suit8_matchC = 	 false;	}
            if (key == 8	&& key3 == 2  ){	suit8_matchA = 	 true;	suit8_matchB = 	 false;	suit8_matchC = 	 false;	}
            if (key == 8	&& key3 == 3  ){	suit8_matchA = 	 true;	suit8_matchB = 	 false;	suit8_matchC = 	 false;	}
            if (key == 8	&& key3 == 4  ){	suit8_matchA = 	 true;	suit8_matchB = 	 true;	suit8_matchC = 	 false;	}
            if (key == 8	&& key3 == 5  ){	suit8_matchA = 	 true;	suit8_matchB = 	 true;	suit8_matchC = 	 false;	}
            if (key == 8	&& key3 == 6  ){	suit8_matchA = 	 true;	suit8_matchB = 	 true;	suit8_matchC = 	 true;	}
            if (key == 9	&& key3 == 1  ){	suit9_matchA = 	 false;	suit9_matchB = 	 false;	suit9_matchC = 	 false;	}
            if (key == 9	&& key3 == 2  ){	suit9_matchA = 	 true;	suit9_matchB = 	 false;	suit9_matchC = 	 false;	}
            if (key == 9	&& key3 == 3  ){	suit9_matchA = 	 true;	suit9_matchB = 	 false;	suit9_matchC = 	 false;	}
            if (key == 9	&& key3 == 4  ){	suit9_matchA = 	 true;	suit9_matchB = 	 true;	suit9_matchC = 	 false;	}
            if (key == 9	&& key3 == 5  ){	suit9_matchA = 	 true;	suit9_matchB = 	 true;	suit9_matchC = 	 false;	}
            if (key == 9	&& key3 == 6  ){	suit9_matchA = 	 true;	suit9_matchB = 	 true;	suit9_matchC = 	 true;	}
            if (key == 10	&& key3 == 1  ){	suit10_matchA = 	 false;	suit10_matchB = 	 false;	suit10_matchC = 	 false;	}
            if (key == 10	&& key3 == 2  ){	suit10_matchA = 	 true;	suit10_matchB = 	 false;	suit10_matchC = 	 false;	}
            if (key == 10	&& key3 == 3  ){	suit10_matchA = 	 true;	suit10_matchB = 	 false;	suit10_matchC = 	 false;	}
            if (key == 10	&& key3 == 4  ){	suit10_matchA = 	 true;	suit10_matchB = 	 true;	suit10_matchC = 	 false;	}
            if (key == 10	&& key3 == 5  ){	suit10_matchA = 	 true;	suit10_matchB = 	 true;	suit10_matchC = 	 false;	}
            if (key == 10	&& key3 == 6  ){	suit10_matchA = 	 true;	suit10_matchB = 	 true;	suit10_matchC = 	 true;	}
            if (key == 11	&& key3 == 1  ){	suit11_matchA = 	 false;	suit11_matchB = 	 false;	suit11_matchC = 	 false;	}
            if (key == 11	&& key3 == 2  ){	suit11_matchA = 	 true;	suit11_matchB = 	 false;	suit11_matchC = 	 false;	}
            if (key == 11	&& key3 == 3  ){	suit11_matchA = 	 true;	suit11_matchB = 	 false;	suit11_matchC = 	 false;	}
            if (key == 11	&& key3 == 4  ){	suit11_matchA = 	 true;	suit11_matchB = 	 true;	suit11_matchC = 	 false;	}
            if (key == 11	&& key3 == 5  ){	suit11_matchA = 	 true;	suit11_matchB = 	 true;	suit11_matchC = 	 false;	}
            if (key == 11	&& key3 == 6  ){	suit11_matchA = 	 true;	suit11_matchB = 	 true;	suit11_matchC = 	 true;	}
            if (key == 12	&& key3 == 1  ){	suit12_matchA = 	 false;	suit12_matchB = 	 false;	suit12_matchC = 	 false;	}
            if (key == 12	&& key3 == 2  ){	suit12_matchA = 	 true;	suit12_matchB = 	 false;	suit12_matchC = 	 false;	}
            if (key == 12	&& key3 == 3  ){	suit12_matchA = 	 true;	suit12_matchB = 	 false;	suit12_matchC = 	 false;	}
            if (key == 12	&& key3 == 4  ){	suit12_matchA = 	 true;	suit12_matchB = 	 true;	suit12_matchC = 	 false;	}
            if (key == 12	&& key3 == 5  ){	suit12_matchA = 	 true;	suit12_matchB = 	 true;	suit12_matchC = 	 false;	}
            if (key == 12	&& key3 == 6  ){	suit12_matchA = 	 true;	suit12_matchB = 	 true;	suit12_matchC = 	 true;	}

            if (key == 13	&& key3 == 1  ){	suit13_matchA = 	 false;	suit13_matchB = 	 false;	suit13_matchC = 	 false;	}
            if (key == 13	&& key3 == 2  ){	suit13_matchA = 	 true;	suit13_matchB = 	 false;	suit13_matchC = 	 false;	}
            if (key == 13	&& key3 == 3  ){	suit13_matchA = 	 true;	suit13_matchB = 	 false;	suit13_matchC = 	 false;	}
            if (key == 13	&& key3 == 4  ){	suit13_matchA = 	 true;	suit13_matchB = 	 true;	suit13_matchC = 	 false;	}
            if (key == 13	&& key3 == 5  ){	suit13_matchA = 	 true;	suit13_matchB = 	 true;	suit13_matchC = 	 false;	}
            if (key == 13	&& key3 == 6  ){	suit13_matchA = 	 true;	suit13_matchB = 	 true;	suit13_matchC = 	 true;	}




            Log.i("T/F", String.valueOf(suit1_matchA));
        }

        //--------------------------------------------------------------------

        cal2(suit_part1[0]	,suit_part1[1]	,suit01_tv1);
        cal2(suit_part1[2]	,suit_part1[3]	,suit01_tv2);
        cal2(suit_part1[4]	,suit_part1[5]	,suit01_tv3);
        cal2(suit_part1[6]	,suit_part1[7]	,suit01_tv4);
        cal2(suit_part2[0]	,suit_part2[1]	,suit02_tv1);
        cal2(suit_part2[2]	,suit_part2[3]	,suit02_tv2);
        cal2(suit_part2[4]	,suit_part2[5]	,suit02_tv3);
        cal2(suit_part2[6]	,suit_part2[7]	,suit02_tv4);
        cal2(suit_part3[0]	,suit_part3[1]	,suit03_tv1);
        cal2(suit_part3[2]	,suit_part3[3]	,suit03_tv2);
        cal2(suit_part3[4]	,suit_part3[5]	,suit03_tv3);
        cal2(suit_part3[6]	,suit_part3[7]	,suit03_tv4);
        cal2(suit_part4[0]	,suit_part4[1]	,suit04_tv1);
        cal2(suit_part4[2]	,suit_part4[3]	,suit04_tv2);
        cal2(suit_part4[4]	,suit_part4[5]	,suit04_tv3);
        cal2(suit_part4[6]	,suit_part4[7]	,suit04_tv4);
        cal2(suit_part5[0]	,suit_part5[1]	,suit05_tv1);
        cal2(suit_part5[2]	,suit_part5[3]	,suit05_tv2);
        cal2(suit_part5[4]	,suit_part5[5]	,suit05_tv3);
        cal2(suit_part5[6]	,suit_part5[7]	,suit05_tv4);
        cal2(suit_part6[0]	,suit_part6[1]	,suit06_tv1);
        cal2(suit_part6[2]	,suit_part6[3]	,suit06_tv2);
        cal2(suit_part6[4]	,suit_part6[5]	,suit06_tv3);
        cal2(suit_part6[6]	,suit_part6[7]	,suit06_tv4);

        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor3 = sharedPreferences.edit();
        editor3.putInt("suit01", suit_id[0]);
        editor3.putInt("suit02", suit_id[1]);
        editor3.putInt("suit03", suit_id[2]);
        editor3.putInt("suit04", suit_id[3]);
        editor3.putInt("suit05", suit_id[4]);
        editor3.putInt("suit06", suit_id[5]);
        editor3.apply();
        cal3();
    }

    private void cal3() {
        String[] tamamoe_set_buff =  {getString(R.string.effect_5),"15",getString(R.string.effect_6),"50",getString(R.string.effect_4),"12"};
        String[] maid_set_buff =  {getString(R.string.effect_9),"50",getString(R.string.effect_10),"50",getString(R.string.effect_11),"20"};
        String[] falling_sakura_set_buff =  {getString(R.string.effect_9),"30",getString(R.string.effect_10),"40",getString(R.string.effect_17),"60"};
        String[] x_mas_set_buff =  {getString(R.string.effect_9),"30",getString(R.string.effect_10),"40",getString(R.string.effect_17),"60"};
        String[] miral_set_buff =  {getString(R.string.effect_29),"10",getString(R.string.effect_10),"40",getString(R.string.effect_17),"60"};
        String[] firework_set_buff =  {getString(R.string.effect_30),"10000",getString(R.string.effect_10),"10",getString(R.string.effect_17),"60"};
        String[] scv_set_buff =  {getString(R.string.effect_30),"0",getString(R.string.effect_10),"10",getString(R.string.effect_17),"50"};
        String[] valkyrie_set_buff =   {getString(R.string.effect_37),"150",getString(R.string.effect_36),"20",getString(R.string.effect_38),"25"};
        String[] hope_set_buff =  {getString(R.string.effect_47),"50",getString(R.string.effect_46),"3000",getString(R.string.effect_40),"260"};
        String[] daybreak_set_buff =  {getString(R.string.effect_47),"10000",getString(R.string.effect_46),"30",getString(R.string.effect_40),"30"};
        String[] conqueror_set_buff =  {getString(R.string.effect_40),"50",getString(R.string.effect_50),"20",getString(R.string.effect_52),"20"};
        String[] gentleman_set_buff =  {getString(R.string.effect_54),"50",getString(R.string.effect_56),"50",getString(R.string.effect_64),"10"};
        String[] origin_set_buff =  {getString(R.string.effect_18),"25",getString(R.string.effect_17),"60",getString(R.string.effect_65),"50"};

        adapter.add("----SET----");
        if (suit1_matchA == true ){adapter.add(getString(R.string.suit_01_set)+" Lvl 1"+"\n"+tamamoe_set_buff[0]+" +"+tamamoe_set_buff[1]+"%");}
        if (suit1_matchB == true){adapter.add(getString(R.string.suit_01_set)+" Lvl 2"+"\n"+tamamoe_set_buff[2]+" +"+tamamoe_set_buff[3]+"%");}
        if (suit1_matchC == true){adapter.add(getString(R.string.suit_01_set)+" Lvl 3"+"\n"+tamamoe_set_buff[4]+" +"+tamamoe_set_buff[5]+"%");}
        if (suit2_matchA == true ){adapter.add(getString(R.string.suit_02_set)+" Lvl 1"+"\n"+maid_set_buff[0]+" +"+maid_set_buff[1]+"%");}
        if (suit2_matchB == true){adapter.add(getString(R.string.suit_02_set)+" Lvl 2"+"\n"+maid_set_buff[2]+" +"+maid_set_buff[3]+"%");}
        if (suit2_matchC == true){adapter.add(getString(R.string.suit_02_set)+" Lvl 3"+"\n"+maid_set_buff[4]+" +"+maid_set_buff[5]+"%");}
        if (suit3_matchA == true ){adapter.add(getString(R.string.suit_03_set)+" Lvl 1"+"\n"+falling_sakura_set_buff[0]+" +"+falling_sakura_set_buff[1]+"%");}
        if (suit3_matchB == true){adapter.add(getString(R.string.suit_03_set)+" Lvl 2"+"\n"+falling_sakura_set_buff[2]+" +"+falling_sakura_set_buff[3]+"%");}
        if (suit3_matchC == true){adapter.add(getString(R.string.suit_03_set)+" Lvl 3"+"\n"+falling_sakura_set_buff[4]+" +"+falling_sakura_set_buff[5]+"%");}
        if (suit4_matchA == true ){adapter.add(getString(R.string.suit_04_set)+" Lvl 1"+"\n"+x_mas_set_buff[0]+" +"+x_mas_set_buff[1]+"%");}
        if (suit4_matchB == true){adapter.add(getString(R.string.suit_04_set)+" Lvl 2"+"\n"+x_mas_set_buff[2]+" +"+x_mas_set_buff[3]+"%");}
        if (suit4_matchC == true){adapter.add(getString(R.string.suit_04_set)+" Lvl 3"+"\n"+x_mas_set_buff[4]+" +"+x_mas_set_buff[5]+"%");}
        if (suit5_matchA == true ){adapter.add(getString(R.string.suit_05_set)+" Lvl 1"+"\n"+miral_set_buff[0]+" +"+miral_set_buff[1]+"%");}
        if (suit5_matchB == true){adapter.add(getString(R.string.suit_05_set)+" Lvl 2"+"\n"+miral_set_buff[2]+" +"+miral_set_buff[3]+"%");}
        if (suit5_matchC == true){adapter.add(getString(R.string.suit_05_set)+" Lvl 3"+"\n"+miral_set_buff[4]+" +"+miral_set_buff[5]+"%");}
        if (suit6_matchA == true ){adapter.add(getString(R.string.suit_06_set)+" Lvl 1"+"\n"+firework_set_buff[0]+" +"+firework_set_buff[1]+"%");}
        if (suit6_matchB == true){adapter.add(getString(R.string.suit_06_set)+" Lvl 2"+"\n"+firework_set_buff[2]+" +"+firework_set_buff[3]+"%");}
        if (suit6_matchC == true){adapter.add(getString(R.string.suit_06_set)+" Lvl 3"+"\n"+firework_set_buff[4]+" +"+firework_set_buff[5]+"%");}
        if (suit7_matchA == true ){adapter.add(getString(R.string.suit_07_set)+" Lvl 1"+"\n"+scv_set_buff[0]+" +"+scv_set_buff[1]+"%");}
        if (suit7_matchB == true){adapter.add(getString(R.string.suit_07_set)+" Lvl 2"+"\n"+scv_set_buff[2]+" +"+scv_set_buff[3]+"%");}
        if (suit7_matchC == true){adapter.add(getString(R.string.suit_07_set)+" Lvl 3"+"\n"+scv_set_buff[4]+" +"+scv_set_buff[5]+"%");}
        if (suit8_matchA == true ){adapter.add(getString(R.string.suit_08_set)+" Lvl 1"+"\n"+valkyrie_set_buff[0]+" +"+valkyrie_set_buff[1]+"%");}
        if (suit8_matchB == true){adapter.add(getString(R.string.suit_08_set)+" Lvl 2"+"\n"+valkyrie_set_buff[2]+" +"+valkyrie_set_buff[3]+"%");}
        if (suit8_matchC == true){adapter.add(getString(R.string.suit_08_set)+" Lvl 3"+"\n"+valkyrie_set_buff[4]+" +"+valkyrie_set_buff[5]+"%");}
        if (suit9_matchA == true ){adapter.add(getString(R.string.suit_09_set)+" Lvl 1"+"\n"+hope_set_buff[0]+" +"+hope_set_buff[1]+"%");}
        if (suit9_matchB == true){adapter.add(getString(R.string.suit_09_set)+" Lvl 2"+"\n"+hope_set_buff[2]+" +"+hope_set_buff[3]+"%");}
        if (suit9_matchC == true){adapter.add(getString(R.string.suit_09_set)+" Lvl 3"+"\n"+hope_set_buff[4]+" +"+hope_set_buff[5]+"%");}
        if (suit10_matchA == true ){adapter.add(getString(R.string.suit_10_set)+" Lvl 1"+"\n"+daybreak_set_buff[0]+" +"+daybreak_set_buff[1]+"%");}
        if (suit10_matchB == true){adapter.add(getString(R.string.suit_10_set)+" Lvl 2"+"\n"+daybreak_set_buff[2]+" +"+daybreak_set_buff[3]+"%");}
        if (suit10_matchC == true){adapter.add(getString(R.string.suit_10_set)+" Lvl 3"+"\n"+daybreak_set_buff[4]+" +"+daybreak_set_buff[5]+"%");}
        if (suit11_matchA == true ){adapter.add(getString(R.string.suit_11_set)+" Lvl 1"+"\n"+conqueror_set_buff[0]+" +"+conqueror_set_buff[1]+"%");}
        if (suit11_matchB == true){adapter.add(getString(R.string.suit_11_set)+" Lvl 2"+"\n"+conqueror_set_buff[2]+" +"+conqueror_set_buff[3]+"%");}
        if (suit11_matchC == true){adapter.add(getString(R.string.suit_11_set)+" Lvl 3"+"\n"+conqueror_set_buff[4]+" +"+conqueror_set_buff[5]+"%");}
        if (suit12_matchA == true ){adapter.add(getString(R.string.suit_12_set)+" Lvl 1"+"\n"+gentleman_set_buff[0]+" +"+gentleman_set_buff[1]+"%");}
        if (suit12_matchB == true){adapter.add(getString(R.string.suit_12_set)+" Lvl 2"+"\n"+gentleman_set_buff[2]+" +"+gentleman_set_buff[3]+"%");}
        if (suit12_matchC == true){adapter.add(getString(R.string.suit_12_set)+" Lvl 3"+"\n"+gentleman_set_buff[4]+" +"+gentleman_set_buff[5]+"%");}

        if (suit13_matchA == true ){adapter.add(getString(R.string.suit_13_set)+" Lvl 1"+"\n"+origin_set_buff[0]+" +"+origin_set_buff[1]+"%");}
        if (suit13_matchB == true){adapter.add(getString(R.string.suit_13_set)+" Lvl 2"+"\n"+origin_set_buff[2]+" +"+origin_set_buff[3]+"%");}
        if (suit13_matchC == true){adapter.add(getString(R.string.suit_13_set)+" Lvl 3"+"\n"+origin_set_buff[4]+" +"+origin_set_buff[5]+"%");}


        adapter.add("\n----BUFF----");

        boolean	suit1_matchA = false ;	boolean	suit1_matchB = false ;	boolean	suit1_matchC = false ;
        boolean	suit2_matchA = false ;	boolean	suit2_matchB = false ;	boolean	suit2_matchC = false ;
        boolean	suit3_matchA = false ;	boolean	suit3_matchB = false ;	boolean	suit3_matchC = false ;
        boolean	suit4_matchA = false ;	boolean	suit4_matchB = false ;	boolean	suit4_matchC = false ;
        boolean	suit5_matchA = false ;	boolean	suit5_matchB = false ;	boolean	suit5_matchC = false ;
        boolean	suit6_matchA = false ;	boolean	suit6_matchB = false ;	boolean	suit6_matchC = false ;
        boolean	suit7_matchA = false ;	boolean	suit7_matchB = false ;	boolean	suit7_matchC = false ;
        boolean	suit8_matchA = false ;	boolean	suit8_matchB = false ;	boolean	suit8_matchC = false ;
        boolean	suit9_matchA = false ;	boolean	suit9_matchB = false ;	boolean	suit9_matchC = false ;
        boolean	suit10_matchA = false ;	boolean	suit10_matchB = false ;	boolean	suit10_matchC = false ;
        boolean	suit11_matchA = false ;	boolean	suit11_matchB = false ;	boolean	suit11_matchC = false ;
        boolean	suit12_matchA = false ;	boolean	suit12_matchB = false ;	boolean	suit12_matchC = false ;
        boolean	suit13_matchA = false ;	boolean	suit13_matchB = false ;	boolean	suit13_matchC = false ;
    }

    private void cal2(int id2 , int buff2 , TextView textView) {
        int id = Integer.valueOf(id2);
        int buff = Integer.valueOf(buff2);
        String temp_name = "";
        if ( id == 1 ){temp_name = 	getString(R.string.effect_1) + " + " +prettyCount(buff)+"%";	Troop_ATK	 = 	Troop_ATK	 + buff;}
        if ( id == 2 ){temp_name =	getString(R.string.effect_2) + " + " +prettyCount(buff)+"%";	Troop_DEF	 = 	Troop_DEF	 + buff;}
        if ( id == 3 ){temp_name =	getString(R.string.effect_3) + " + " +prettyCount(buff)+"%";	Troop_HP	 = 	Troop_HP	 + buff;}
        if ( id == 4 ){temp_name =	getString(R.string.effect_4) + " + " +prettyCount(buff)+"%";	Weakness_Capture	 = 	Weakness_Capture	 + buff;}
        if ( id == 5 ){temp_name =	getString(R.string.effect_5) + " + " +prettyCount(buff)+"%";	Damage_Bonus	 = 	Damage_Bonus	 + buff;}
        if ( id == 6 ){temp_name =	getString(R.string.effect_6) + " + " +prettyCount(buff)+"%";	March_Max	 = 	March_Max	 + buff;}

        if ( id == 8 ){temp_name =	getString(R.string.effect_8) + " + " +prettyCount(buff)+"%";	Transform_Skills_rate	 = 	Transform_Skills_rate	 + buff;}
        if ( id == 9 ){temp_name =	getString(R.string.effect_9) + " + " +prettyCount(buff)+"";	Project_Origin_March_Amt_Bonus	 = 	Project_Origin_March_Amt_Bonus	 + buff;}
        if ( id == 10 ){temp_name =	getString(R.string.effect_10) + " + " +prettyCount(buff)+"%";	March_size_increase_	 = 	March_size_increase_	 + buff;}
        if ( id == 11 ){temp_name =	getString(R.string.effect_11) + " + " +prettyCount(buff)+"%";	Reduce_basic_life_of_enemytroop	 = 	Reduce_basic_life_of_enemytroop	 + buff;}

        if ( id == 13 ){temp_name =	getString(R.string.effect_13) + " + " +prettyCount(buff)+"%";	Heal_Speed	 = 	Heal_Speed	 + buff;}

        if ( id == 15 ){temp_name =	getString(R.string.effect_15) + " + " +prettyCount(buff)+"%";	Shooter_DEF	 = 	Shooter_DEF	 + buff;}
        if ( id == 16 ){temp_name =	getString(R.string.effect_16) + " + " +prettyCount(buff)+"%";	Shooter_HP	 = 	Shooter_HP	 + buff;}
        if ( id == 17 ){temp_name =	getString(R.string.effect_17) + " + " +prettyCount(buff)+"%";	Increase_arena_battle_ATK	 = 	Increase_arena_battle_ATK	 + buff;}
        if ( id == 18 ){temp_name =	getString(R.string.effect_18) + " + " +prettyCount(buff)+"%";	Project_Zero_ATK	 = 	Project_Zero_ATK	 + buff;}
        if ( id == 19 ){temp_name =	getString(R.string.effect_19) + " + " +prettyCount(buff)+"%";	Dead_ATK	 = 	Dead_ATK	 + buff;}
        if ( id == 20 ){temp_name =	getString(R.string.effect_20) + " + " +prettyCount(buff)+"%";	Shooter_ATK	 = 	Shooter_ATK	 + buff;}
        if ( id == 21 ){temp_name =	getString(R.string.effect_21) + " + " +prettyCount(buff)+"%";	Arena_Dead_DMG	 = 	Arena_Dead_DMG	 + buff;}
        if ( id == 22 ){temp_name =	getString(R.string.effect_22) + " + " +prettyCount(buff)+"%";	Mobile_ATK	 = 	Mobile_ATK	 + buff;}
        if ( id == 23 ){temp_name =	getString(R.string.effect_23) + " + " +prettyCount(buff)+"%";	Project_One_HP_	 = 	Project_One_HP_	 + buff;}
        if ( id == 24 ){temp_name =	getString(R.string.effect_24) + " + " +prettyCount(buff)+"%";	Arena_Mobile_DMG_	 = 	Arena_Mobile_DMG_	 + buff;}
        if ( id == 25 ){temp_name =	getString(R.string.effect_25) + " + " +prettyCount(buff)+"%";	Arena_Shooter_DMG	 = 	Arena_Shooter_DMG	 + buff;}
        if ( id == 26 ){temp_name =	getString(R.string.effect_26) + " + " +prettyCount(buff)+"%";	Attacker_DEF	 = 	Attacker_DEF	 + buff;}
        if ( id == 27 ){temp_name =	getString(R.string.effect_27) + " + " +prettyCount(buff)+"%";	Attacker_HP	 = 	Attacker_HP	 + buff;}
        if ( id == 28 ){temp_name =	getString(R.string.effect_28) + " + " +prettyCount(buff)+"%";	Arena_Attacker_DMG	 = 	Arena_Attacker_DMG	 + buff;}
        if ( id == 29 ){temp_name =	getString(R.string.effect_29) + " + " +prettyCount(buff)+"%";	All_troops_DMG_reduction	 = 	All_troops_DMG_reduction	 + buff;}
        if ( id == 30 ){temp_name =	getString(R.string.effect_30) + " + " +prettyCount(buff)+"";	Expand_arena_expedition_limit	 = 	Expand_arena_expedition_limit	 + buff;}
        if ( id == 31 ){temp_name =	getString(R.string.effect_31) + " + " +prettyCount(buff)+"%";	Dead_HP	 = 	Dead_HP	 + buff;}
        if ( id == 32 ){temp_name =	getString(R.string.effect_32) + " + " +prettyCount(buff)+"%";	Dead_DEF	 = 	Dead_DEF	 + buff;}
        if ( id == 33 ){temp_name =	getString(R.string.effect_33) + " + " +prettyCount(buff)+"%";	PVE_ATK	 = 	PVE_ATK	 + buff;}
        if ( id == 34 ){temp_name =	getString(R.string.effect_34) + " + " +prettyCount(buff)+"%";	PVE_DEF	 = 	PVE_DEF	 + buff;}
        if ( id == 35 ){temp_name =	getString(R.string.effect_35) + " + " +prettyCount(buff)+"%";	PVE_HP	 = 	PVE_HP	 + buff;}
        if ( id == 36 ){temp_name =	getString(R.string.effect_36) + " + " +prettyCount(buff)+"%";	PVE_DMP	 = 	PVE_DMP	 + buff;}
        if ( id == 37 ){temp_name =	getString(R.string.effect_37) + " + " +prettyCount(buff)+"%";	March_Speed_increase	 = 	March_Speed_increase	 + buff;}
        if ( id == 38 ){temp_name =	getString(R.string.effect_38) + " + " +prettyCount(buff)+"%";	Increase_damage_by_enviroment	 = 	Increase_damage_by_enviroment	 + buff;}

        if ( id == 40 ){temp_name =	getString(R.string.effect_40) + " + " +prettyCount(buff)+"%";	Troops_Train_SPD	 = 	Troops_Train_SPD	 + buff;}
        if ( id == 41 ){temp_name =	getString(R.string.effect_41) + " + " +prettyCount(buff)+"%";	Attacker_Train_SPD	 = 	Attacker_Train_SPD	 + buff;}
        if ( id == 42 ){temp_name =	getString(R.string.effect_42) + " + " +prettyCount(buff)+"%";	Mobile_Train_SPD	 = 	Mobile_Train_SPD	 + buff;}
        if ( id == 43 ){temp_name =	getString(R.string.effect_43) + " + " +prettyCount(buff)+"%";	Dead_Train_SPD	 = 	Dead_Train_SPD	 + buff;}
        if ( id == 44 ){temp_name =	getString(R.string.effect_44) + " + " +prettyCount(buff)+"%";	Shooter_Train_SPD	 = 	Shooter_Train_SPD	 + buff;}
        if ( id == 45 ){temp_name =	getString(R.string.effect_45) + " + " +prettyCount(buff)+"%";	Project_Train_SPD	 = 	Project_Train_SPD	 + buff;}
        if ( id == 46 ){temp_name =	getString(R.string.effect_46) + " + " +prettyCount(buff)+"";	Troops_Train_Amount	 = 	Troops_Train_Amount	 + buff;}
        if ( id == 47 ){temp_name =	getString(R.string.effect_47) + " + " +prettyCount(buff)+"";	Clinic_Capacity	 = 	Clinic_Capacity	 + buff;}
        if ( id == 48 ){temp_name =	getString(R.string.effect_48) + " + " +prettyCount(buff)+"%";	Fewer_Tech_Research_rss	 = 	Fewer_Tech_Research_rss	 + buff;}
        if ( id == 49 ){temp_name =	getString(R.string.effect_49) + " + " +prettyCount(buff)+"";	Random_Buff_to_ATK_Shooter_Dead_Or_Mobile	 = 	Random_Buff_to_ATK_Shooter_Dead_Or_Mobile	 + buff;}
        if ( id == 50 ){temp_name =	getString(R.string.effect_50) + " + " +prettyCount(buff)+"%";	Tech_Research_SPD	 = 	Tech_Research_SPD	 + buff;}
        if ( id == 51 ){temp_name =	getString(R.string.effect_51) + " + " +prettyCount(buff)+"%";	Random_Development_Buffs	 = 	Random_Development_Buffs	 + buff;}
        if ( id == 52 ){temp_name =	getString(R.string.effect_52) + " + " +prettyCount(buff)+"%";	Building_SPD	 = 	Building_SPD	 + buff;}
        if ( id == 53 ){temp_name =	getString(R.string.effect_53) + " + " +prettyCount(buff)+"%";	Defensive_DEF	 = 	Defensive_DEF	 + buff;}
        if ( id == 54 ){temp_name =	getString(R.string.effect_54) + " + " +prettyCount(buff)+"%";	Defensive_ATK	 = 	Defensive_ATK	 + buff;}
        if ( id == 55 ){temp_name =	getString(R.string.effect_55) + " + " +prettyCount(buff)+"%";	Defensive_HP	 = 	Defensive_HP	 + buff;}
        if ( id == 56 ){temp_name =	getString(R.string.effect_56) + " + " +prettyCount(buff)+"%";	Dead_Defensive_DEF	 = 	Dead_Defensive_DEF	 + buff;}
        if ( id == 57 ){temp_name =	getString(R.string.effect_57) + " + " +prettyCount(buff)+"%";	Dead_Defensive_ATK	 = 	Dead_Defensive_ATK	 + buff;}
        if ( id == 58 ){temp_name =	getString(R.string.effect_58) + " + " +prettyCount(buff)+"%";	Dead_Defensive_HP	 = 	Dead_Defensive_HP	 + buff;}
        if ( id == 59 ){temp_name =	getString(R.string.effect_59) + " + " +prettyCount(buff)+"%";	Shooter_Defensive_ATK	 = 	Shooter_Defensive_ATK	 + buff;}
        if ( id == 60 ){temp_name =	getString(R.string.effect_60) + " + " +prettyCount(buff)+"%";	Attacker_Defensive_HP	 = 	Attacker_Defensive_HP	 + buff;}
        if ( id == 61 ){temp_name =	getString(R.string.effect_61) + " + " +prettyCount(buff)+"%";	Mobile_Defensive_HP	 = 	Mobile_Defensive_HP	 + buff;}
        if ( id == 62 ){temp_name =	getString(R.string.effect_62) + " + " +prettyCount(buff)+"%";	Attacker_Defensive_DEF	 = 	Attacker_Defensive_DEF	 + buff;}
        if ( id == 63 ){temp_name =	getString(R.string.effect_63) + " + " +prettyCount(buff)+"%";	Random_Defense_Siege_Buffs	 = 	Random_Defense_Siege_Buffs	 + buff;}
        if ( id == 64 ){temp_name =	getString(R.string.effect_64) + " + " +prettyCount(buff)+"%";	Decrease_rate_of_enabler_being_arrest	 = 	Decrease_rate_of_enabler_being_arrest	 + buff;}
        if ( id == 65 ){temp_name =	getString(R.string.effect_65) + " + " +prettyCount(buff)+"%";	Ace_Killer	 = 	Ace_Killer	 + buff;}

        textView.setText(temp_name);

    }

    public void buff_list(){
        if (	Troop_ATK	!= 0){adapter.add(	getString(R.string.effect_1)	 + " + " +	Troop_ATK	 +"%");}
        if (	Troop_DEF	!= 0){adapter.add(	getString(R.string.effect_2)	 + " + " +	Troop_DEF	 +"%");}
        if (	Troop_HP	!= 0){adapter.add(	getString(R.string.effect_3)	 + " + " +	Troop_HP	 +"%");}
        if (	Weakness_Capture	!= 0){adapter.add(	getString(R.string.effect_4)	 + " + " +	Weakness_Capture	 +"%");}
        if (	Damage_Bonus	!= 0){adapter.add(	getString(R.string.effect_5)	 + " + " +	Damage_Bonus	 +"%");}
        if (	March_Max	!= 0){adapter.add(	getString(R.string.effect_6)	 + " + " +	March_Max	 +"%");}
        if (	Transform_Skills_rate	!= 0){adapter.add(	getString(R.string.effect_8)	 + " + " +	Transform_Skills_rate	 +"%");}
        if (	Project_Origin_March_Amt_Bonus	!= 0){adapter.add(	getString(R.string.effect_9)	 + " + " +	Project_Origin_March_Amt_Bonus	 +"%");}
        if (	March_size_increase_	!= 0){adapter.add(	getString(R.string.effect_10)	 + " + " +	March_size_increase_	 +"");}
        if (	Reduce_basic_life_of_enemytroop	!= 0){adapter.add(	getString(R.string.effect_11)	 + " + " +	Reduce_basic_life_of_enemytroop	 +"%");}
        if (	Heal_Speed	!= 0){adapter.add(	getString(R.string.effect_13)	 + " + " +	Heal_Speed	 +"%");}
        if (	Shooter_DEF	!= 0){adapter.add(	getString(R.string.effect_15)	 + " + " +	Shooter_DEF	 +"%");}
        if (	Shooter_HP	!= 0){adapter.add(	getString(R.string.effect_16)	 + " + " +	Shooter_HP	 +"%");}
        if (	Increase_arena_battle_ATK	!= 0){adapter.add(	getString(R.string.effect_17)	 + " + " +	Increase_arena_battle_ATK	 +"%");}
        if (	Project_Zero_ATK	!= 0){adapter.add(	getString(R.string.effect_18)	 + " + " +	Project_Zero_ATK	 +"%");}
        if (	Dead_ATK	!= 0){adapter.add(	getString(R.string.effect_19)	 + " + " +	Dead_ATK	 +"%");}
        if (	Shooter_ATK	!= 0){adapter.add(	getString(R.string.effect_20)	 + " + " +	Shooter_ATK	 +"%");}
        if (	Arena_Dead_DMG	!= 0){adapter.add(	getString(R.string.effect_21)	 + " + " +	Arena_Dead_DMG	 +"%");}
        if (	Mobile_ATK	!= 0){adapter.add(	getString(R.string.effect_22)	 + " + " +	Mobile_ATK	 +"%");}
        if (	Project_One_HP_	!= 0){adapter.add(	getString(R.string.effect_23)	 + " + " +	Project_One_HP_	 +"%");}
        if (	Arena_Mobile_DMG_	!= 0){adapter.add(	getString(R.string.effect_24)	 + " + " +	Arena_Mobile_DMG_	 +"%");}
        if (	Arena_Shooter_DMG	!= 0){adapter.add(	getString(R.string.effect_25)	 + " + " +	Arena_Shooter_DMG	 +"%");}
        if (	Attacker_DEF	!= 0){adapter.add(	getString(R.string.effect_26)	 + " + " +	Attacker_DEF	 +"%");}
        if (	Attacker_HP	!= 0){adapter.add(	getString(R.string.effect_27)	 + " + " +	Attacker_HP	 +"%");}
        if (	Arena_Attacker_DMG	!= 0){adapter.add(	getString(R.string.effect_28)	 + " + " +	Arena_Attacker_DMG	 +"%");}
        if (	All_troops_DMG_reduction	!= 0){adapter.add(	getString(R.string.effect_29)	 + " + " +	All_troops_DMG_reduction	 +"%");}
        if (	Expand_arena_expedition_limit	!= 0){adapter.add(	getString(R.string.effect_30)	 + " + " +	Expand_arena_expedition_limit	 +"");}
        if (	Dead_HP	!= 0){adapter.add(	getString(R.string.effect_31)	 + " + " +	Dead_HP	 +"%");}
        if (	Dead_DEF	!= 0){adapter.add(	getString(R.string.effect_32)	 + " + " +	Dead_DEF	 +"%");}
        if (	PVE_ATK	!= 0){adapter.add(	getString(R.string.effect_33)	 + " + " +	PVE_ATK	 +"%");}
        if (	PVE_DEF	!= 0){adapter.add(	getString(R.string.effect_34)	 + " + " +	PVE_DEF	 +"%");}
        if (	PVE_HP	!= 0){adapter.add(	getString(R.string.effect_35)	 + " + " +	PVE_HP	 +"%");}
        if (	PVE_DMP	!= 0){adapter.add(	getString(R.string.effect_36)	 + " + " +	PVE_DMP	 +"%");}
        if (	March_Speed_increase	!= 0){adapter.add(	getString(R.string.effect_37)	 + " + " +	March_Speed_increase	 +"%");}
        if (	Increase_damage_by_enviroment	!= 0){adapter.add(	getString(R.string.effect_38)	 + " + " +	Increase_damage_by_enviroment	 +"%");}
        if (	Troops_Train_SPD	!= 0){adapter.add(	getString(R.string.effect_40)	 + " + " +	Troops_Train_SPD	 +"%");}
        if (	Attacker_Train_SPD	!= 0){adapter.add(	getString(R.string.effect_41)	 + " + " +	Attacker_Train_SPD	 +"%");}
        if (	Mobile_Train_SPD	!= 0){adapter.add(	getString(R.string.effect_42)	 + " + " +	Mobile_Train_SPD	 +"%");}
        if (	Dead_Train_SPD	!= 0){adapter.add(	getString(R.string.effect_43)	 + " + " +	Dead_Train_SPD	 +"%");}
        if (	Shooter_Train_SPD	!= 0){adapter.add(	getString(R.string.effect_44)	 + " + " +	Shooter_Train_SPD	 +"%");}
        if (	Project_Train_SPD	!= 0){adapter.add(	getString(R.string.effect_45)	 + " + " +	Project_Train_SPD	 +"%");}
        if (	Troops_Train_Amount	!= 0){adapter.add(	getString(R.string.effect_46)	 + " + " +	Troops_Train_Amount	 +"");}
        if (	Clinic_Capacity	!= 0){adapter.add(	getString(R.string.effect_47)	 + " + " +	Clinic_Capacity	 +"");}
        if (	Fewer_Tech_Research_rss	!= 0){adapter.add(	getString(R.string.effect_48)	 + " + " +	Fewer_Tech_Research_rss	 +"%");}
        if (	Random_Buff_to_ATK_Shooter_Dead_Or_Mobile	!= 0){adapter.add(	getString(R.string.effect_49)	 + " + " +	Random_Buff_to_ATK_Shooter_Dead_Or_Mobile	 +"");}
        if (	Tech_Research_SPD	!= 0){adapter.add(	getString(R.string.effect_50)	 + " + " +	Tech_Research_SPD	 +"%");}
        if (	Random_Development_Buffs	!= 0){adapter.add(	getString(R.string.effect_51)	 + " + " +	Random_Development_Buffs	 +"%");}
        if (	Building_SPD	!= 0){adapter.add(	getString(R.string.effect_52)	 + " + " +	Building_SPD	 +"%");}
        if (	Defensive_DEF	!= 0){adapter.add(	getString(R.string.effect_53)	 + " + " +	Defensive_DEF	 +"%");}
        if (	Defensive_ATK	!= 0){adapter.add(	getString(R.string.effect_54)	 + " + " +	Defensive_ATK	 +"%");}
        if (	Defensive_HP	!= 0){adapter.add(	getString(R.string.effect_55)	 + " + " +	Defensive_HP	 +"%");}
        if (	Dead_Defensive_DEF	!= 0){adapter.add(	getString(R.string.effect_56)	 + " + " +	Dead_Defensive_DEF	 +"%");}
        if (	Dead_Defensive_ATK	!= 0){adapter.add(	getString(R.string.effect_57)	 + " + " +	Dead_Defensive_ATK	 +"%");}
        if (	Dead_Defensive_HP	!= 0){adapter.add(	getString(R.string.effect_58)	 + " + " +	Dead_Defensive_HP	 +"%");}
        if (	Shooter_Defensive_ATK	!= 0){adapter.add(	getString(R.string.effect_59)	 + " + " +	Shooter_Defensive_ATK	 +"%");}
        if (	Attacker_Defensive_HP	!= 0){adapter.add(	getString(R.string.effect_60)	 + " + " +	Attacker_Defensive_HP	 +"%");}
        if (	Mobile_Defensive_HP	!= 0){adapter.add(	getString(R.string.effect_61)	 + " + " +	Mobile_Defensive_HP	 +"%");}
        if (	Attacker_Defensive_DEF	!= 0){adapter.add(	getString(R.string.effect_62)	 + " + " +	Attacker_Defensive_DEF	 +"%");}
        if (	Random_Defense_Siege_Buffs	!= 0){adapter.add(	getString(R.string.effect_63)	 + " + " +	Random_Defense_Siege_Buffs	 +"%");}
        if (	Decrease_rate_of_enabler_being_arrest	!= 0){adapter.add(	getString(R.string.effect_64)	 + " + " +	Decrease_rate_of_enabler_being_arrest	 +"%");}
        if (	Ace_Killer	!= 0){adapter.add(	getString(R.string.effect_65)	 + " + " +	Ace_Killer	 +"%");}
    }

    public String prettyCount(Number number) {
        char[] suffix = {' ', 'K', 'M', 'G', 'T', 'P', 'E', 'Z', 'Y'};
        long numValue = number.longValue();
        int value = (int) Math.floor(Math.log10(numValue));
        int base = value / 3;
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        int decimal_num = sharedPreferences.getInt("decimal_num", 0);
        boolean decimal  = sharedPreferences.getBoolean("decimal", false);
        if (decimal == true){
            if (value >= 3 && base < suffix.length) {
                if (decimal_num == 0){
                    return new DecimalFormat("##").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                if (decimal_num == 1){
                    return new DecimalFormat("##.#").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                if (decimal_num == 2){
                    return new DecimalFormat("##.##").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                if (decimal_num == 3){
                    return new DecimalFormat("##.###").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                if (decimal_num == 4){
                    return new DecimalFormat("##.####").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                if (decimal_num == 5){
                    return new DecimalFormat("##.#####").format(numValue / Math.pow(10, base * 3)) + suffix[base];
                }
                // Muility
            } else {
                return new DecimalFormat("#,###").format(numValue);
            }}
        return new DecimalFormat("###,###,###,###,###").format(numValue);
    }


    public void BackgroundReload (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.suit_bg);

        Resources res = getResources();
        String fileNamePNG = "background.png";
        String fileNameGIF = "background.gif";
        String fileNameJPG = "background.jpg";
        String fileNameJPEG = "background.jpeg";
        String pathName = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/background/";

        Bitmap bitmap = BitmapFactory.decodeFile(pathName+fileNamePNG);
        BitmapDrawable bd = new BitmapDrawable(res, bitmap);

        Bitmap bitmap2 = BitmapFactory.decodeFile(pathName+fileNameJPG);
        BitmapDrawable bd2 = new BitmapDrawable(res, bitmap2);

        Bitmap bitmap3 = BitmapFactory.decodeFile(pathName+fileNameJPEG);
        BitmapDrawable bd3 = new BitmapDrawable(res, bitmap3);

        File gifFile = new File(pathName,fileNameGIF);
        GifDrawable gifFromFile = null;
        try { gifFromFile = new GifDrawable(gifFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (gif_png.matches("gif")){gifImageView1.setImageDrawable(gifFromFile);}
        if (gif_png.matches("png")){gifImageView1.setImageDrawable(bd);}
        if (gif_png.matches("jpg")){gifImageView1.setImageDrawable(bd2);}
        if (gif_png.matches("jpeg")){gifImageView1.setImageDrawable(bd3);}
    }
}