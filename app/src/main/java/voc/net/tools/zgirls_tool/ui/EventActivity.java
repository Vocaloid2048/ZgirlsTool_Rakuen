package voc.net.tools.zgirls_tool.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.R;

public class EventActivity extends AppCompatActivity {

    int 	rss01_lv1_price = 	30	;		int 	rss02_lv1_price = 	2	;		int 	rss03_lv1_price = 	2	;
    int 	rss01_lv2_price =	100	;		int 	rss02_lv2_price =	5	;		int 	rss03_lv2_price =	5	;
    int 	rss01_lv3_price =	200	;		int 	rss02_lv3_price =	8	;		int 	rss03_lv3_price =	8	;
    int 	rss01_lv4_price =	300	;		int 	rss02_lv4_price =	10	;		int 	rss03_lv4_price =	10	;
    int 	rss01_lv5_price =	350	;		int 	rss02_lv5_price =	12	;		int 	rss03_lv5_price =	12	;
    int 	rss01_lv6_price =	400	;		int 	rss02_lv6_price =	15	;		int 	rss03_lv6_price =	15	;

    int 	rss01_lv1_count = 	10	;		int 	rss02_lv1_count = 	300	;		int 	rss03_lv1_count = 	300	;
    int 	rss01_lv2_count =	30	;		int 	rss02_lv2_count =	900	;		int 	rss03_lv2_count =	900	;
    int 	rss01_lv3_count =	60	;		int 	rss02_lv3_count =	1800	;		int 	rss03_lv3_count =	1800	;
    int 	rss01_lv4_count =	100	;		int 	rss02_lv4_count =	3000	;		int 	rss03_lv4_count =	3000	;
    int 	rss01_lv5_count =	150	;		int 	rss02_lv5_count =	4500	;		int 	rss03_lv5_count =	4500	;
    int 	rss01_lv6_count =	210	;		int 	rss02_lv6_count =	6300	;		int 	rss03_lv6_count =	6300	;

    int 	rss04_lv1_price = 	2	;		int 	rss05_lv1_price = 	2	;		int 	rss06_lv1_price = 	5	;
    int 	rss04_lv2_price =	5	;		int 	rss05_lv2_price =	5	;		int 	rss06_lv2_price =	15	;
    int 	rss04_lv3_price =	8	;		int 	rss05_lv3_price =	8	;		int 	rss06_lv3_price =	25	;
    int 	rss04_lv4_price =	10	;		int 	rss05_lv4_price =	10	;		int 	rss06_lv4_price =	30	;
    int 	rss04_lv5_price =	12	;		int 	rss05_lv5_price =	12	;		int 	rss06_lv5_price =	35	;
    int 	rss04_lv6_price =	15	;		int 	rss05_lv6_price =	15	;		int 	rss06_lv6_price =	40	;

    int 	rss04_lv1_count = 	250	;		int 	rss05_lv1_count = 	225	;		int 	rss06_lv1_count = 	100	;
    int 	rss04_lv2_count =	750	;		int 	rss05_lv2_count =	675	;		int 	rss06_lv2_count =	300	;
    int 	rss04_lv3_count =	1500	;		int 	rss05_lv3_count =	1350	;		int 	rss06_lv3_count =	600	;
    int 	rss04_lv4_count =	2500	;		int 	rss05_lv4_count =	2250	;		int 	rss06_lv4_count =	1000	;
    int 	rss04_lv5_count =	3750	;		int 	rss05_lv5_count =	3375	;		int 	rss06_lv5_count =	1500	;
    int 	rss04_lv6_count =	5250	;		int 	rss05_lv6_count =	4725	;		int 	rss06_lv6_count =	2100	;

    int 	rss07_lv1_price = 	2	;		int 	rss08_lv1_price = 	10	;		int 	rss09_lv1_price = 	10	;
    int 	rss07_lv2_price =	3	;		int 	rss08_lv2_price =	15	;		int 	rss09_lv2_price =	15	;
    int 	rss07_lv3_price =	4	;		int 	rss08_lv3_price =	20	;		int 	rss09_lv3_price =	20	;
    int 	rss07_lv4_price =	5	;		int 	rss08_lv4_price =	30	;		int 	rss09_lv4_price =	25	;
    int 	rss07_lv5_price =	6	;		int 	rss08_lv5_price =	35	;		int 	rss09_lv5_price =	30	;
    int 	rss07_lv6_price =	7	;		int 	rss08_lv6_price =	400	;		int 	rss09_lv6_price =	40	;

    int 	rss07_lv1_count = 	600	;		int 	rss08_lv1_count = 	80	;		int 	rss09_lv1_count = 	100	;
    int 	rss07_lv2_count =	1800	;		int 	rss08_lv2_count =	240	;		int 	rss09_lv2_count =	300	;
    int 	rss07_lv3_count =	3600	;		int 	rss08_lv3_count =	480	;		int 	rss09_lv3_count =	600	;
    int 	rss07_lv4_count =	6000	;		int 	rss08_lv4_count =	800	;		int 	rss09_lv4_count =	1000	;
    int 	rss07_lv5_count =	9000	;		int 	rss08_lv5_count =	1200	;		int 	rss09_lv5_count =	1500	;
    int 	rss07_lv6_count =	12600	;		int 	rss08_lv6_count =	1680	;		int 	rss09_lv6_count =	2100	;

    int 	enabler01_lv1_price = 	10	;		int 	enabler02_lv1_price = 	15	;		int 	enabler03_lv1_price = 	10	;
    int 	enabler01_lv2_price =	20	;		int 	enabler02_lv2_price =	45	;		int 	enabler03_lv2_price =	20	;
                                                int 	enabler02_lv3_price =	90	;		int 	enabler03_lv3_price =	30	;
                                                int 	enabler02_lv4_price =	150	;		int 	enabler03_lv4_price =	50	;
                                                int 	enabler02_lv5_price =	225	;		int 	enabler03_lv5_price =	75	;
                                                int 	enabler02_lv6_price =	315	;		int 	enabler03_lv6_price =	105	;

    int 	enabler01_lv1_count = 	2000	;	int 	enabler02_lv1_count = 	50	;		int 	enabler03_lv1_count = 	150	;
    int 	enabler01_lv2_count =	5000	;	int 	enabler02_lv2_count =	100	;		int 	enabler03_lv2_count =	300	;
                                                int 	enabler02_lv3_count =	150	;		int 	enabler03_lv3_count =	450	;
                                                int 	enabler02_lv4_count =	200	;		int 	enabler03_lv4_count =	650	;
                                                int 	enabler02_lv5_count =	250	;		int 	enabler03_lv5_count =	800	;
                                                int 	enabler02_lv6_count =	300	;		int 	enabler03_lv6_count =	1000	;

    int 	enabler04_lv1_price = 	4	;		int 	enabler05_lv1_price = 	50	;		int 	enabler06_lv1_price = 	30	;
    int 	enabler04_lv2_price =	7	;		int 	enabler05_lv2_price =	75	;		int 	enabler06_lv2_price =	35	;
    int 	enabler04_lv3_price =	10	;		int 	enabler05_lv3_price =	100	;		int 	enabler06_lv3_price =	40	;
    int 	enabler04_lv4_price =	14	;		int 	enabler05_lv4_price =	125	;		int 	enabler06_lv4_price =	45	;
    int 	enabler04_lv5_price =	17	;		int 	enabler05_lv5_price =	150	;		int 	enabler06_lv5_price =	50	;
    int 	enabler04_lv6_price =	20	;		int 	enabler05_lv6_price =	175	;		int 	enabler06_lv6_price =	100	;

    int 	enabler04_lv1_count = 	250	;		int 	enabler05_lv1_count = 	20	;		int 	enabler06_lv1_count = 	40	;
    int 	enabler04_lv2_count =	750	;		int 	enabler05_lv2_count =	60	;		int 	enabler06_lv2_count =	120	;
    int 	enabler04_lv3_count =	1500	;	int 	enabler05_lv3_count =	120	;		int 	enabler06_lv3_count =	240	;
    int 	enabler04_lv4_count =	2500	;	int 	enabler05_lv4_count =	200	;		int 	enabler06_lv4_count =	400	;
    int 	enabler04_lv5_count =	3750	;	int 	enabler05_lv5_count =	300	;		int 	enabler06_lv5_count =	600	;
    int 	enabler04_lv6_count =	5250	;	int 	enabler05_lv6_count =	420	;		int 	enabler06_lv6_count =	840	;
    // 20201219 Added
    int 	enabler07_lv1_count = 	1000	;
    int 	enabler07_lv2_count =	2000	;
    int 	enabler07_lv3_count =	3000	;
    int 	enabler07_lv4_count =	4000	;

    int 	enabler07_lv1_price = 	15	;
    int 	enabler07_lv2_price =	20	;
    int 	enabler07_lv3_price =	30	;
    int 	enabler07_lv4_price =	40	;

    int 	mecha01_lv1_price = 	1	;		int 	mecha02_lv1_price = 	5	;
    int 	mecha01_lv2_price =	2	;		int 	mecha02_lv2_price =	15	;
    int 	mecha01_lv3_price =	3	;		int 	mecha02_lv3_price =	30	;
    int 	mecha01_lv4_price =	4	;		int 	mecha02_lv4_price =	50	;
    int 	mecha01_lv5_price =	5	;		int 	mecha02_lv5_price =	75	;
    int 	mecha01_lv6_price =	6	;		int 	mecha02_lv6_price =	105	;

    int 	mecha01_lv1_count = 1000	;		int 	mecha02_lv1_count = 	200	;
    int 	mecha01_lv2_count =	3000	;		int 	mecha02_lv2_count =	600	;
    int 	mecha01_lv3_count =	6000	;		int 	mecha02_lv3_count =	1200	;
    int 	mecha01_lv4_count =	10000	;		int 	mecha02_lv4_count =	2000	;
    int 	mecha01_lv5_count =	15000	;		int 	mecha02_lv5_count =	3000	;
    int 	mecha01_lv6_count =	21000	;		int 	mecha02_lv6_count =	4200	;

    int 	mecha03_lv1_price = 50	;		int 	mecha04_lv1_price = 	30	;
    int 	mecha03_lv2_price =	75	;		int 	mecha04_lv2_price =	35	;
    int 	mecha03_lv3_price =	100	;		int 	mecha04_lv3_price =	40	;
    int 	mecha03_lv4_price =	125	;		int 	mecha04_lv4_price =	45	;
    int 	mecha03_lv5_price =	150	;		int 	mecha04_lv5_price =	50	;
    int 	mecha03_lv6_price =	175	;		int 	mecha04_lv6_price =	100	;

    int 	mecha03_lv1_count = 20	;		int 	mecha04_lv1_count = 40	;
    int 	mecha03_lv2_count =	60	;		int 	mecha04_lv2_count =	120	;
    int 	mecha03_lv3_count =	120	;		int 	mecha04_lv3_count =	240	;
    int 	mecha03_lv4_count =	200	;		int 	mecha04_lv4_count =	400	;
    int 	mecha03_lv5_count =	300	;		int 	mecha04_lv5_count =	600	;
    int 	mecha03_lv6_count =	420	;		int 	mecha04_lv6_count =	840	;
    // 20201219 Added
    int 	mecha05_lv1_count = 2000	;
    int 	mecha05_lv2_count =	4000	;
    int 	mecha05_lv3_count =	6000	;
    int 	mecha05_lv4_count =	8000	;

    int 	mecha05_lv1_price = 10	;
    int 	mecha05_lv2_price =	20	;
    int 	mecha05_lv3_price =	30	;
    int 	mecha05_lv4_price =	40	;

    int 	arena01_lv1_price = 60	;		int 	arena02_lv1_price = 5	;		int 	arena03_lv1_price = 5	;
    int 	arena01_lv2_price =	90	;		int 	arena02_lv2_price =	7	;		int 	arena03_lv2_price =	20	;
    int 	arena01_lv3_price =	120	;		int 	arena02_lv3_price =	9	;		int 	arena03_lv3_price =	35	;
    int 	arena01_lv4_price =	150	;		int 	arena02_lv4_price =	11	;		int 	arena03_lv4_price =	50	;
    int 	arena01_lv5_price =	180	;		int 	arena02_lv5_price =	13	;		int 	arena03_lv5_price =	65	;
    int 	arena01_lv6_price =	210	;		int 	arena02_lv6_price =	15	;		int 	arena03_lv6_price =	80	;

    int 	arena01_lv1_count = 20	;		int 	arena02_lv1_count = 250	;		int 	arena03_lv1_count = 45	;
    int 	arena01_lv2_count =	60	;		int 	arena02_lv2_count =	750	;		int 	arena03_lv2_count =	135	;
    int 	arena01_lv3_count =	120	;		int 	arena02_lv3_count =	1500	;	int 	arena03_lv3_count =	270	;
    int 	arena01_lv4_count =	200	;		int 	arena02_lv4_count =	2500	;	int 	arena03_lv4_count =	450	;
    int 	arena01_lv5_count =	300	;		int 	arena02_lv5_count =	3750	;	int 	arena03_lv5_count =	675	;
    int 	arena01_lv6_count =	420	;		int 	arena02_lv6_count =	5250	;	int 	arena03_lv6_count =	945	;

    int 	arena04_lv1_price = 20	;		int 	arena05_lv1_price = 250	;		int 	arena06_lv1_price = 250	;
    int 	arena04_lv2_price =	60	;		int 	arena05_lv2_price =	400	;		int 	arena06_lv2_price =	400	;
    int 	arena04_lv3_price =	100	;		int 	arena05_lv3_price =	550	;		int 	arena06_lv3_price =	550	;
    int 	arena04_lv4_price =	140	;		int 	arena05_lv4_price =	700	;		int 	arena06_lv4_price =	700	;
    int 	arena04_lv5_price =	180	;		int 	arena05_lv5_price =	850	;		int 	arena06_lv5_price =	850	;
    int 	arena04_lv6_price =	220	;		int 	arena05_lv6_price =	1000	;	int 	arena06_lv6_price =	1000	;

    int 	arena04_lv1_count = 20	;		int 	arena05_lv1_count = 1	;		int 	arena06_lv1_count = 1	;
    int 	arena04_lv2_count =	60	;		int 	arena05_lv2_count =	3	;		int 	arena06_lv2_count =	3	;
    int 	arena04_lv3_count =	120	;		int 	arena05_lv3_count =	6	;		int 	arena06_lv3_count =	6	;
    int 	arena04_lv4_count =	200	;		int 	arena05_lv4_count =	10	;		int 	arena06_lv4_count =	10	;
    int 	arena04_lv5_count =	300	;		int 	arena05_lv5_count =	15	;		int 	arena06_lv5_count =	15	;
    int 	arena04_lv6_count =	420	;		int 	arena05_lv6_count =	50	;		int 	arena06_lv6_count =	50	;
    // 20201219 Added
    int 	arena07_lv1_price = 250	;		int 	arena08_lv1_price = 800	;		int 	arena09_lv1_price = 1600;
    int 	arena07_lv2_price =	400	;		int 	arena08_lv2_price =	1000;		int 	arena09_lv2_price =	2000;
    int 	arena07_lv3_price =	550	;		int 	arena08_lv3_price =	1200;		int 	arena09_lv3_price =	2500;
    int 	arena07_lv4_price =	700	;
    int 	arena07_lv5_price =	850	;
    int 	arena07_lv6_price =	1000;

    int 	arena07_lv1_count = 1	;		int 	arena08_lv1_count = 20	;		int 	arena09_lv1_count = 20	;
    int 	arena07_lv2_count =	3	;		int 	arena08_lv2_count =	50	;		int 	arena09_lv2_count =	50	;
    int 	arena07_lv3_count =	6	;		int 	arena08_lv3_count =	100	;		int 	arena09_lv3_count =	100	;
    int 	arena07_lv4_count =	10	;
    int 	arena07_lv5_count =	15	;
    int 	arena07_lv6_count =	50  ;

    int 	arena10_lv1_price = 3000	;	int 	arena11_lv1_price = 100	;
    int 	arena10_lv2_price =	4000	;	int 	arena11_lv2_price =	200	;
    int 	arena10_lv3_price =	6000	;	int 	arena11_lv3_price =	300	;

    int 	arena10_lv1_count = 10	;		int 	arena11_lv1_count = 100	;
    int 	arena10_lv2_count =	30	;		int 	arena11_lv2_count =	500	;
    int 	arena10_lv3_count =	50	;		int 	arena11_lv3_count =	1000;




    LinearLayout rss , enabler , transform , arena;

    EditText obs , food , fuel , steel , alloy , kyan , kyanb , kyanc , speed ;
    EditText shard , nors , advs , mexp , exp , pict;
    EditText cc , ac , pbt , tbt;
    EditText rune , runep , box , starstone , lucky , azbag;
    EditText aa , et , arsb , ab , pmc , porb , crystal;

    TextView ticket_tv ;

    ListView listView , listView1 , listView2 , listView3;
    private ArrayAdapter<String> adapter;
    private ArrayAdapter<String> adapter1;
    private ArrayAdapter<String> adapter2;
    private ArrayAdapter<String> adapter3;
    private ArrayList<String> arrayList;
    private ArrayList<String> arrayList1;
    private ArrayList<String> arrayList2;
    private ArrayList<String> arrayList3;

    int tickets , tickets_final;

    int	rss01_S ,	rss02_S ,	rss03_S ,	rss04_S ,	rss05_S ,	rss06_S ,	rss07_S ,	rss08_S ,	rss09_S ;
    int	enabler01_S ,	enabler02_S ,	enabler03_S ,	enabler04_S ,	enabler05_S ,	enabler06_S ;
    int	mecha01_S ,	mecha02_S ,	mecha03_S ,	mecha04_S ;
    int	arena01_S ,	arena02_S ,	arena03_S ,	arena04_S ,	arena05_S ,	arena06_S ;
    int	enabler07_S ,	mecha05_S ,	arena07_S ,	arena08_S ,	arena09_S ,	arena10_S ,	arena11_S ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        BackgroundReload();

        rss = findViewById(R.id.rss_part);
        enabler = findViewById(R.id.enabler_part);
        transform = findViewById(R.id.transform_part);
        arena = findViewById(R.id.arena_part);

        listView = findViewById(R.id.list_event);
        listView1 = findViewById(R.id.type_list);
        listView2 = findViewById(R.id.count_list);
        listView3 = findViewById(R.id.tickets_list);

        ticket_tv = findViewById(R.id.ticket_tv);

        obs = findViewById(R.id.rss_obs_et);
        food = findViewById(R.id.rss_food_et);
        fuel = findViewById(R.id.rss_fuel_et);
        steel = findViewById(R.id.rss_steel_et);
        alloy = findViewById(R.id.rss_alloy_et);
        kyan = findViewById(R.id.rss_kyan_et);
        kyanb = findViewById(R.id.rss_kyan_basic_et);
        kyanc = findViewById(R.id.rss_kyan_clu_et);
        speed = findViewById(R.id.rss_speed_et);

        shard = findViewById(R.id.enabler_spe_shard_et);
        nors = findViewById(R.id.enabler_nor_shard_et);
        advs = findViewById(R.id.enabler_adv_shard_et);
        mexp = findViewById(R.id.enabler_mexp_et);
        exp = findViewById(R.id.enabler_exp_et);
        pict = findViewById(R.id.enabler_pict_et);

        cc = findViewById(R.id.transform_cc_et);
        ac = findViewById(R.id.transform_ac_et);
        tbt = findViewById(R.id.transform_battery_normal_et);
        pbt = findViewById(R.id.transform_battery_proj_et);

        rune = findViewById(R.id.arena_rune_et);
        runep = findViewById(R.id.arena_rune_pts_et);
        box = findViewById(R.id.arena_box_et);
        starstone = findViewById(R.id.arena_starstone_et);
        lucky = findViewById(R.id.arena_lucky_et);
        azbag = findViewById(R.id.arena_a_zbag_et);

        aa = findViewById(R.id.enabler_aa_et);
        et = findViewById(R.id.transform_et_et);
        arsb = findViewById(R.id.arena_arsb_et);
        ab = findViewById(R.id.arena_ab_et);
        pmc = findViewById(R.id.arena_pmc_et);
        porb = findViewById(R.id.arena_porb_et);
        crystal = findViewById(R.id.arena_crystal_et);

        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.list_tv, arrayList);
        listView.setAdapter(adapter);

        arrayList1 = new ArrayList<String>();
        adapter1 = new ArrayAdapter<String>(getApplicationContext(), R.layout.list_tv, arrayList1);
        listView1.setAdapter(adapter1);

        arrayList2 = new ArrayList<String>();
        adapter2 = new ArrayAdapter<String>(getApplicationContext(), R.layout.list_num_tv, arrayList2);
        listView2.setAdapter(adapter2);

        arrayList3 = new ArrayList<String>();
        adapter3 = new ArrayAdapter<String>(getApplicationContext(), R.layout.list_num_tv, arrayList3);
        listView3.setAdapter(adapter3);

        SharedPreferences sharedPreferences = getSharedPreferences("event_shop", Context.MODE_PRIVATE);
        rss01_S = sharedPreferences.getInt("rss01", 0);
        rss02_S = sharedPreferences.getInt("rss02", 0);
        rss03_S = sharedPreferences.getInt("rss03", 0);
        rss04_S = sharedPreferences.getInt("rss04", 0);
        rss05_S = sharedPreferences.getInt("rss05", 0);
        rss06_S = sharedPreferences.getInt("rss06", 0);
        rss07_S = sharedPreferences.getInt("rss07", 0);
        rss08_S = sharedPreferences.getInt("rss08", 0);
        rss09_S = sharedPreferences.getInt("rss09", 0);
        enabler01_S = sharedPreferences.getInt("enabler01",0);
        enabler02_S = sharedPreferences.getInt("enabler02",0);
        enabler03_S = sharedPreferences.getInt("enabler03",0);
        enabler04_S = sharedPreferences.getInt("enabler04",0);
        enabler05_S = sharedPreferences.getInt("enabler05",0);
        enabler06_S = sharedPreferences.getInt("enabler06",0);
        enabler07_S = sharedPreferences.getInt("enabler07",0);
        mecha01_S = sharedPreferences.getInt("mecha01",0);
        mecha02_S = sharedPreferences.getInt("mecha02",0);
        mecha03_S = sharedPreferences.getInt("mecha03",0);
        mecha04_S = sharedPreferences.getInt("mecha04",0);
        mecha05_S = sharedPreferences.getInt("mecha05",0);
        arena01_S = sharedPreferences.getInt("arena01",0);
        arena02_S = sharedPreferences.getInt("arena02",0);
        arena03_S = sharedPreferences.getInt("arena03",0);
        arena04_S = sharedPreferences.getInt("arena04",0);
        arena05_S = sharedPreferences.getInt("arena05",0);
        arena06_S = sharedPreferences.getInt("arena06",0);
        arena07_S = sharedPreferences.getInt("arena07",0);
        arena08_S = sharedPreferences.getInt("arena08",0);
        arena09_S = sharedPreferences.getInt("arena09",0);
        arena10_S = sharedPreferences.getInt("arena10",0);
        arena11_S = sharedPreferences.getInt("arena11",0);

        if (rss01_S>rss01_lv6_count){rss01_S = rss01_lv6_count;}
        if (rss02_S>rss02_lv6_count){rss02_S = rss02_lv6_count;}
        if (rss03_S>rss03_lv6_count){rss03_S = rss03_lv6_count;}
        if (rss04_S>rss04_lv6_count){rss04_S = rss04_lv6_count;}
        if (rss05_S>rss05_lv6_count){rss05_S = rss05_lv6_count;}
        if (rss06_S>rss06_lv6_count){rss06_S = rss06_lv6_count;}
        if (rss07_S>rss07_lv6_count){rss07_S = rss07_lv6_count;}
        if (rss08_S>rss08_lv6_count){rss08_S = rss08_lv6_count;}
        if (rss09_S>rss09_lv6_count){rss09_S = rss09_lv6_count;}
        if (enabler01_S>enabler01_lv2_count){enabler01_S = enabler01_lv2_count;}
        if (enabler02_S>enabler02_lv6_count){enabler02_S = enabler02_lv6_count;}
        if (enabler03_S>enabler03_lv6_count){enabler03_S = enabler03_lv6_count;}
        if (enabler04_S>enabler04_lv6_count){enabler04_S = enabler04_lv6_count;}
        if (enabler05_S>enabler05_lv6_count){enabler05_S = enabler05_lv6_count;}
        if (enabler06_S>enabler06_lv6_count){enabler06_S = enabler06_lv6_count;}
        if (enabler07_S>enabler07_lv4_count){enabler07_S = enabler07_lv4_count;}
        if (mecha01_S>mecha01_lv6_count){mecha01_S  = mecha01_lv6_count;}
        if (mecha02_S>mecha02_lv6_count){mecha02_S = mecha02_lv6_count;}
        if (mecha03_S>mecha03_lv6_count){mecha03_S = mecha03_lv6_count;}
        if (mecha04_S>mecha04_lv6_count){mecha04_S = mecha04_lv6_count;}
        if (mecha05_S>mecha05_lv4_count){mecha04_S = mecha05_lv4_count;}
        if (arena01_S>arena01_lv6_count){arena01_S  = arena01_lv6_count;}
        if (arena02_S>arena02_lv6_count){arena02_S = arena02_lv6_count;}
        if (arena03_S>arena03_lv6_count){arena03_S = arena03_lv6_count;}
        if (arena04_S>arena04_lv6_count){arena04_S = arena04_lv6_count;}
        if (arena05_S>arena05_lv6_count){arena05_S = arena05_lv6_count;}
        if (arena06_S>arena06_lv6_count){arena06_S = arena06_lv6_count;}
        if (arena07_S>arena07_lv6_count){arena07_S = arena07_lv6_count;}
        if (arena08_S>arena08_lv3_count){arena08_S = arena08_lv3_count;}
        if (arena09_S>arena09_lv3_count){arena09_S = arena09_lv3_count;}
        if (arena10_S>arena10_lv3_count){arena10_S = arena10_lv3_count;}
        if (arena11_S>arena11_lv3_count){arena11_S = arena11_lv3_count;}


        obs.setText(String.valueOf(rss01_S));
        food.setText(String.valueOf(rss02_S));
        fuel.setText(String.valueOf(rss03_S));
        steel.setText(String.valueOf(rss04_S));
        alloy.setText(String.valueOf(rss05_S));
        kyan.setText(String.valueOf(rss06_S));
        kyanb.setText(String.valueOf(rss07_S));
        kyanc.setText(String.valueOf(rss08_S));
        speed.setText(String.valueOf(rss09_S));
        shard.setText(String.valueOf(enabler01_S));
        nors.setText(String.valueOf(enabler02_S));
        advs.setText(String.valueOf(enabler03_S));
        mexp.setText(String.valueOf(enabler04_S));
        exp.setText(String.valueOf(enabler05_S));
        pict.setText(String.valueOf(enabler06_S));
        cc.setText(String.valueOf(mecha01_S));
        ac.setText(String.valueOf(mecha02_S));
        pbt.setText(String.valueOf(mecha03_S));
        tbt.setText(String.valueOf(mecha04_S));
        rune.setText(String.valueOf(arena01_S));
        runep.setText(String.valueOf(arena02_S));
        box.setText(String.valueOf(arena03_S));
        starstone.setText(String.valueOf(arena04_S));
        lucky.setText(String.valueOf(arena05_S));
        azbag.setText(String.valueOf(arena06_S));

        aa.setText(String.valueOf(enabler07_S));
        et.setText(String.valueOf(mecha05_S));
        arsb.setText(String.valueOf(arena07_S));
        ab.setText(String.valueOf(arena08_S));
        pmc.setText(String.valueOf(arena09_S));
        porb.setText(String.valueOf(arena10_S));
        crystal.setText(String.valueOf(arena11_S));

    }
    public void BackgroundReload (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.event_bg);

        Resources res = getResources();
        String fileNamePNG = "background.png";
        String fileNameGIF = "background.gif";
        String fileNameJPG = "background.jpg";
        String pathName = Environment.getExternalStorageDirectory().getPath() + "/voc/zgt/background/";

        Bitmap bitmap = BitmapFactory.decodeFile(pathName+fileNamePNG);
        BitmapDrawable bd = new BitmapDrawable(res, bitmap);

        Bitmap bitmap2 = BitmapFactory.decodeFile(pathName+fileNameJPG);
        BitmapDrawable bd2 = new BitmapDrawable(res, bitmap2);

        File gifFile = new File(pathName,fileNameGIF);
        GifDrawable gifFromFile = null;
        try { gifFromFile = new GifDrawable(gifFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (gif_png.matches("gif")){gifImageView1.setImageDrawable(gifFromFile);}
        if (gif_png.matches("png")){gifImageView1.setImageDrawable(bd);}
        if (gif_png.matches("jpg")){gifImageView1.setImageDrawable(bd2);}
    }

    public void rss (View view){
        rss.setVisibility(View.VISIBLE);
        enabler.setVisibility(View.GONE);
        transform.setVisibility(View.GONE);
        arena.setVisibility(View.GONE);
    }
    public void enabler (View view){
        enabler.setVisibility(View.VISIBLE);
        rss.setVisibility(View.GONE);
        transform.setVisibility(View.GONE);
        arena.setVisibility(View.GONE);
    }
    public void transform (View view){
        transform.setVisibility(View.VISIBLE);
        enabler.setVisibility(View.GONE);
        rss.setVisibility(View.GONE);
        arena.setVisibility(View.GONE);
    }
    public void arena (View view){
        arena.setVisibility(View.VISIBLE);
        enabler.setVisibility(View.GONE);
        transform.setVisibility(View.GONE);
        rss.setVisibility(View.GONE);
    }

    public void calculate (View view){
        tickets = tickets_final = 0 ;
        adapter.clear();
        adapter1.clear();
        adapter3.clear();
        adapter2.clear();
        if(obs.getText().toString().matches(""))	{obs.setText(	"0");}
        if(food.getText().toString().matches(""))	{food.setText(	"0");}
        if(fuel.getText().toString().matches(""))	{fuel.setText(	"0");}
        if(steel.getText().toString().matches(""))	{steel.setText(	"0");}
        if(alloy.getText().toString().matches(""))	{alloy.setText(	"0");}
        if(kyan.getText().toString().matches(""))	{kyan.setText(	"0");}
        if(kyanb.getText().toString().matches(""))	{kyanb.setText(	"0");}
        if(kyanc.getText().toString().matches(""))	{kyanc.setText(	"0");}
        if(speed.getText().toString().matches(""))	{speed.setText(	"0");}

        if(shard.getText().toString().matches(""))	{shard.setText(	"0");}
        if(nors.getText().toString().matches(""))	{nors.setText(	"0");}
        if(advs.getText().toString().matches(""))	{advs.setText(	"0");}
        if(mexp.getText().toString().matches(""))	{mexp.setText(	"0");}
        if(exp.getText().toString().matches(""))	{exp.setText(	"0");}
        if(pict.getText().toString().matches(""))	{pict.setText(	"0");}

        if(cc.getText().toString().matches(""))	{cc.setText(	"0");}
        if(ac.getText().toString().matches(""))	{ac.setText(	"0");}
        if(pbt.getText().toString().matches(""))	{pbt.setText(	"0");}
        if(tbt.getText().toString().matches(""))	{tbt.setText(	"0");}

        if(rune.getText().toString().matches(""))	{rune.setText(	"0");}
        if(runep.getText().toString().matches(""))	{runep.setText(	"0");}
        if(box.getText().toString().matches(""))	{box.setText(	"0");}
        if(starstone.getText().toString().matches(""))	{starstone.setText(	"0");}
        if(lucky.getText().toString().matches(""))	{lucky.setText(	"0");}
        if(azbag.getText().toString().matches(""))	{azbag.setText(	"0");}

        if(aa.getText().toString().matches(""))	{aa.setText(	"0");}
        if(et.getText().toString().matches(""))	{et.setText(	"0");}
        if(arsb.getText().toString().matches(""))	{arsb.setText(	"0");}
        if(ab.getText().toString().matches(""))	{ab.setText(	"0");}
        if(pmc.getText().toString().matches(""))	{pmc.setText(	"0");}
        if(porb.getText().toString().matches(""))	{porb.setText(	"0");}
        if(crystal.getText().toString().matches(""))	{crystal.setText(	"0");}

        //METHOD--START

        int rss01_int = Integer.parseInt(obs.getText().toString());
        int rss01_int_base = Integer.parseInt(obs.getText().toString());
        if (rss01_int > rss01_lv6_count){rss01_int = rss01_int_base = rss01_lv6_count; obs.setText(String.valueOf(rss01_lv6_count));}
        int rss01_rlv1_count 	 =	rss01_lv1_count 	;
        int rss01_rlv2_count	 =	rss01_lv2_count	-	rss01_lv1_count	;
        int rss01_rlv3_count	 =	rss01_lv3_count	-	rss01_lv2_count	;
        int rss01_rlv4_count	 =	rss01_lv4_count	-	rss01_lv3_count	;
        int rss01_rlv5_count	 =	rss01_lv5_count	-	rss01_lv4_count ;
        int rss01_rlv6_count	 =	rss01_lv6_count	-	rss01_lv5_count ;
        if(	rss01_int	>=	0	&&	rss01_int	<	rss01_lv1_count )	{rss01_int =	rss01_int													; tickets = tickets +	rss01_int	*	rss01_lv1_price	;	}
        if(	rss01_int	>=	rss01_lv1_count 	&&	rss01_int	<	rss01_lv2_count )	{rss01_int =	rss01_int	-	rss01_rlv1_count 											; tickets = tickets +	rss01_lv1_count	*	rss01_lv1_price	+	rss01_int	*	rss01_lv2_price	;	}
        if(	rss01_int	>=	rss01_lv2_count	&&	rss01_int	<	rss01_lv3_count )	{rss01_int =	rss01_int	-	rss01_rlv1_count 	-	rss01_rlv2_count 									; tickets = tickets +	rss01_lv1_count	*	rss01_lv1_price	+	rss01_rlv2_count	*	rss01_lv2_price	+	rss01_int	*	rss01_lv3_price	;	}
        if(	rss01_int	>=	rss01_lv3_count	&&	rss01_int	<	rss01_lv4_count )	{rss01_int =	rss01_int	-	rss01_rlv1_count 	-	rss01_rlv2_count 	-	rss01_rlv3_count 							; tickets = tickets +	rss01_lv1_count	*	rss01_lv1_price	+	rss01_rlv2_count	*	rss01_lv2_price	+	rss01_rlv3_count	*	rss01_lv3_price	+	rss01_int	*	rss01_lv4_price	;	}
        if(	rss01_int	>=	rss01_lv4_count	&&	rss01_int	<	rss01_lv5_count )	{rss01_int =	rss01_int	-	rss01_rlv1_count 	-	rss01_rlv2_count 	-	rss01_rlv3_count 	-	rss01_rlv4_count 					; tickets = tickets +	rss01_lv1_count	*	rss01_lv1_price	+	rss01_rlv2_count	*	rss01_lv2_price	+	rss01_rlv3_count	*	rss01_lv3_price	+	rss01_rlv4_count	*	rss01_lv4_price	+	rss01_int	*	rss01_lv5_price	;	}
        if(	rss01_int	>=	rss01_lv5_count	&&	rss01_int	<	rss01_lv6_count )	{rss01_int =	rss01_int	-	rss01_rlv1_count 	-	rss01_rlv2_count 	-	rss01_rlv3_count 	-	rss01_rlv4_count 	-	rss01_rlv5_count 			; tickets = tickets +	rss01_lv1_count	*	rss01_lv1_price	+	rss01_rlv2_count	*	rss01_lv2_price	+	rss01_rlv3_count	*	rss01_lv3_price	+	rss01_rlv4_count	*	rss01_lv4_price	+	rss01_rlv5_count	*	rss01_lv5_price	+	rss01_int	*	rss01_lv6_price	;	}
        if(	rss01_int	>=	rss01_lv6_count	|	rss01_int	 ==	rss01_lv6_count )	{rss01_int =	rss01_int	-	rss01_rlv1_count 	-	rss01_rlv2_count 	-	rss01_rlv3_count 	-	rss01_rlv4_count 	-	rss01_rlv5_count 	 	; tickets = tickets +	rss01_lv1_count	*	rss01_lv1_price	+	rss01_rlv2_count	*	rss01_lv2_price	+	rss01_rlv3_count	*	rss01_lv3_price	+	rss01_rlv4_count	*	rss01_lv4_price	+	rss01_rlv5_count	*	rss01_lv5_price	+	rss01_int	*	rss01_lv6_price	;	}
        adapter.add("[RSS] Obsidians 100K x"+prettyCount(rss01_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_rss01));adapter2.add(prettyCount(rss01_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;


        int rss02_int = Integer.parseInt(food.getText().toString());
        int rss02_int_base = Integer.parseInt(food.getText().toString());
        if (rss02_int > rss02_lv6_count){rss02_int = rss02_int_base = rss02_lv6_count; food.setText(String.valueOf(rss02_lv6_count));}
        int rss02_rlv1_count 	 =	rss02_lv1_count 	;
        int rss02_rlv2_count	 =	rss02_lv2_count	-	rss02_lv1_count	;
        int rss02_rlv3_count	 =	rss02_lv3_count	-	rss02_lv2_count	;
        int rss02_rlv4_count	 =	rss02_lv4_count	-	rss02_lv3_count ;
        int rss02_rlv5_count	 =	rss02_lv5_count	-	rss02_lv4_count	;
        int rss02_rlv6_count	 =	rss02_lv6_count	-	rss02_lv5_count	;
        if(	rss02_int	>=	0	&&	rss02_int	<	rss02_lv1_count )	{rss02_int =	rss02_int													; tickets = tickets +	rss02_int	*	rss02_lv1_price	;	}
        if(	rss02_int	>=	rss02_lv1_count 	&&	rss02_int	<	rss02_lv2_count )	{rss02_int =	rss02_int	-	rss02_rlv1_count 											; tickets = tickets +	rss02_lv1_count	*	rss02_lv1_price	+	rss02_int	*	rss02_lv2_price	;	}
        if(	rss02_int	>=	rss02_lv2_count	&&	rss02_int	<	rss02_lv3_count )	{rss02_int =	rss02_int	-	rss02_rlv1_count 	-	rss02_rlv2_count 									; tickets = tickets +	rss02_lv1_count	*	rss02_lv1_price	+	rss02_rlv2_count	*	rss02_lv2_price	+	rss02_int	*	rss02_lv3_price	;	}
        if(	rss02_int	>=	rss02_lv3_count	&&	rss02_int	<	rss02_lv4_count )	{rss02_int =	rss02_int	-	rss02_rlv1_count 	-	rss02_rlv2_count 	-	rss02_rlv3_count 							; tickets = tickets +	rss02_lv1_count	*	rss02_lv1_price	+	rss02_rlv2_count	*	rss02_lv2_price	+	rss02_rlv3_count	*	rss02_lv3_price	+	rss02_int	*	rss02_lv4_price	;	}
        if(	rss02_int	>=	rss02_lv4_count	&&	rss02_int	<	rss02_lv5_count )	{rss02_int =	rss02_int	-	rss02_rlv1_count 	-	rss02_rlv2_count 	-	rss02_rlv3_count 	-	rss02_rlv4_count 					; tickets = tickets +	rss02_lv1_count	*	rss02_lv1_price	+	rss02_rlv2_count	*	rss02_lv2_price	+	rss02_rlv3_count	*	rss02_lv3_price	+	rss02_rlv4_count	*	rss02_lv4_price	+	rss02_int	*	rss02_lv5_price	;	}
        if(	rss02_int	>=	rss02_lv5_count	&&	rss02_int	<	rss02_lv6_count )	{rss02_int =	rss02_int	-	rss02_rlv1_count 	-	rss02_rlv2_count 	-	rss02_rlv3_count 	-	rss02_rlv4_count 	-	rss02_rlv5_count 			; tickets = tickets +	rss02_lv1_count	*	rss02_lv1_price	+	rss02_rlv2_count	*	rss02_lv2_price	+	rss02_rlv3_count	*	rss02_lv3_price	+	rss02_rlv4_count	*	rss02_lv4_price	+	rss02_rlv5_count	*	rss02_lv5_price	+	rss02_int	*	rss02_lv6_price	;	}
        if(	rss02_int	>=	rss02_lv6_count	|	rss02_int	 ==	rss02_lv6_count )	{rss02_int =	rss02_int	-	rss02_rlv1_count 	-	rss02_rlv2_count 	-	rss02_rlv3_count 	-	rss02_rlv4_count 	-	rss02_rlv5_count 	 	; tickets = tickets +	rss02_lv1_count	*	rss02_lv1_price	+	rss02_rlv2_count	*	rss02_lv2_price	+	rss02_rlv3_count	*	rss02_lv3_price	+	rss02_rlv4_count	*	rss02_lv4_price	+	rss02_rlv5_count	*	rss02_lv5_price	+	rss02_int	*	rss02_lv6_price	;	}
        adapter.add("[RSS] Food 100K x"+prettyCount(rss02_int_base)+" cost "+prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        adapter1.add(getString(R.string.event_rss02));adapter2.add(prettyCount(rss02_int_base));adapter3.add(prettyCount(tickets));
        tickets = 0 ;

        int rss03_int = Integer.parseInt(fuel.getText().toString());
        int rss03_int_base = Integer.parseInt(fuel.getText().toString());
        if (rss03_int > rss03_lv6_count){rss03_int = rss03_int_base = rss03_lv6_count; fuel.setText(String.valueOf(rss03_lv6_count));}
        int rss03_rlv1_count 	 =	rss03_lv1_count 	;
        int rss03_rlv2_count	 =	rss03_lv2_count	-	rss03_lv1_count	;
        int rss03_rlv3_count	 =	rss03_lv3_count	-	rss03_lv2_count	;
        int rss03_rlv4_count	 =	rss03_lv4_count	-	rss03_lv3_count	;
        int rss03_rlv5_count	 =	rss03_lv5_count	-	rss03_lv4_count	;
        int rss03_rlv6_count	 =	rss03_lv6_count	-	rss03_lv5_count ;
        if(	rss03_int	>=	0	&&	rss03_int	<	rss03_lv1_count )	{rss03_int =	rss03_int													; tickets = tickets +	rss03_int	*	rss03_lv1_price	;	}
        if(	rss03_int	>=	rss03_lv1_count 	&&	rss03_int	<	rss03_lv2_count )	{rss03_int =	rss03_int	-	rss03_rlv1_count 											; tickets = tickets +	rss03_lv1_count	*	rss03_lv1_price	+	rss03_int	*	rss03_lv2_price	;	}
        if(	rss03_int	>=	rss03_lv2_count	&&	rss03_int	<	rss03_lv3_count )	{rss03_int =	rss03_int	-	rss03_rlv1_count 	-	rss03_rlv2_count 									; tickets = tickets +	rss03_lv1_count	*	rss03_lv1_price	+	rss03_rlv2_count	*	rss03_lv2_price	+	rss03_int	*	rss03_lv3_price	;	}
        if(	rss03_int	>=	rss03_lv3_count	&&	rss03_int	<	rss03_lv4_count )	{rss03_int =	rss03_int	-	rss03_rlv1_count 	-	rss03_rlv2_count 	-	rss03_rlv3_count 							; tickets = tickets +	rss03_lv1_count	*	rss03_lv1_price	+	rss03_rlv2_count	*	rss03_lv2_price	+	rss03_rlv3_count	*	rss03_lv3_price	+	rss03_int	*	rss03_lv4_price	;	}
        if(	rss03_int	>=	rss03_lv4_count	&&	rss03_int	<	rss03_lv5_count )	{rss03_int =	rss03_int	-	rss03_rlv1_count 	-	rss03_rlv2_count 	-	rss03_rlv3_count 	-	rss03_rlv4_count 					; tickets = tickets +	rss03_lv1_count	*	rss03_lv1_price	+	rss03_rlv2_count	*	rss03_lv2_price	+	rss03_rlv3_count	*	rss03_lv3_price	+	rss03_rlv4_count	*	rss03_lv4_price	+	rss03_int	*	rss03_lv5_price	;	}
        if(	rss03_int	>=	rss03_lv5_count	&&	rss03_int	<	rss03_lv6_count )	{rss03_int =	rss03_int	-	rss03_rlv1_count 	-	rss03_rlv2_count 	-	rss03_rlv3_count 	-	rss03_rlv4_count 	-	rss03_rlv5_count 			; tickets = tickets +	rss03_lv1_count	*	rss03_lv1_price	+	rss03_rlv2_count	*	rss03_lv2_price	+	rss03_rlv3_count	*	rss03_lv3_price	+	rss03_rlv4_count	*	rss03_lv4_price	+	rss03_rlv5_count	*	rss03_lv5_price	+	rss03_int	*	rss03_lv6_price	;	}
        if(	rss03_int	>=	rss03_lv6_count	|	rss03_int	 ==	rss03_lv6_count )	{rss03_int =	rss03_int	-	rss03_rlv1_count 	-	rss03_rlv2_count 	-	rss03_rlv3_count 	-	rss03_rlv4_count 	-	rss03_rlv5_count 	 	; tickets = tickets +	rss03_lv1_count	*	rss03_lv1_price	+	rss03_rlv2_count	*	rss03_lv2_price	+	rss03_rlv3_count	*	rss03_lv3_price	+	rss03_rlv4_count	*	rss03_lv4_price	+	rss03_rlv5_count	*	rss03_lv5_price	+	rss03_int	*	rss03_lv6_price	;	}
        adapter.add("[RSS] Fuel 100K x"+prettyCount(rss03_int_base)+" cost "+prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        adapter1.add(getString(R.string.event_rss03));adapter2.add(prettyCount(rss03_int_base));adapter3.add(prettyCount(tickets));
        tickets = 0 ;

        int rss04_int = Integer.parseInt(steel.getText().toString());
        int rss04_int_base = Integer.parseInt(steel.getText().toString());
        if (rss04_int > rss04_lv6_count){rss04_int = rss04_int_base = rss04_lv6_count; steel.setText(String.valueOf(rss04_lv6_count));}
        int rss04_rlv1_count 	 =	rss04_lv1_count 	;
        int rss04_rlv2_count	 =	rss04_lv2_count	-	rss04_lv1_count	;
        int rss04_rlv3_count	 =	rss04_lv3_count	-	rss04_lv2_count	;
        int rss04_rlv4_count	 =	rss04_lv4_count	-	rss04_lv3_count	;
        int rss04_rlv5_count	 =	rss04_lv5_count	-	rss04_lv4_count	;
        int rss04_rlv6_count	 =	rss04_lv6_count	-	rss04_lv5_count ;
        if(	rss04_int	>=	0	&&	rss04_int	<	rss04_lv1_count )	{rss04_int =	rss04_int													; tickets = tickets +	rss04_int	*	rss04_lv1_price	;	}
        if(	rss04_int	>=	rss04_lv1_count 	&&	rss04_int	<	rss04_lv2_count )	{rss04_int =	rss04_int	-	rss04_rlv1_count 											; tickets = tickets +	rss04_lv1_count	*	rss04_lv1_price	+	rss04_int	*	rss04_lv2_price	;	}
        if(	rss04_int	>=	rss04_lv2_count	&&	rss04_int	<	rss04_lv3_count )	{rss04_int =	rss04_int	-	rss04_rlv1_count 	-	rss04_rlv2_count 									; tickets = tickets +	rss04_lv1_count	*	rss04_lv1_price	+	rss04_rlv2_count	*	rss04_lv2_price	+	rss04_int	*	rss04_lv3_price	;	}
        if(	rss04_int	>=	rss04_lv3_count	&&	rss04_int	<	rss04_lv4_count )	{rss04_int =	rss04_int	-	rss04_rlv1_count 	-	rss04_rlv2_count 	-	rss04_rlv3_count 							; tickets = tickets +	rss04_lv1_count	*	rss04_lv1_price	+	rss04_rlv2_count	*	rss04_lv2_price	+	rss04_rlv3_count	*	rss04_lv3_price	+	rss04_int	*	rss04_lv4_price	;	}
        if(	rss04_int	>=	rss04_lv4_count	&&	rss04_int	<	rss04_lv5_count )	{rss04_int =	rss04_int	-	rss04_rlv1_count 	-	rss04_rlv2_count 	-	rss04_rlv3_count 	-	rss04_rlv4_count 					; tickets = tickets +	rss04_lv1_count	*	rss04_lv1_price	+	rss04_rlv2_count	*	rss04_lv2_price	+	rss04_rlv3_count	*	rss04_lv3_price	+	rss04_rlv4_count	*	rss04_lv4_price	+	rss04_int	*	rss04_lv5_price	;	}
        if(	rss04_int	>=	rss04_lv5_count	&&	rss04_int	<	rss04_lv6_count )	{rss04_int =	rss04_int	-	rss04_rlv1_count 	-	rss04_rlv2_count 	-	rss04_rlv3_count 	-	rss04_rlv4_count 	-	rss04_rlv5_count 			; tickets = tickets +	rss04_lv1_count	*	rss04_lv1_price	+	rss04_rlv2_count	*	rss04_lv2_price	+	rss04_rlv3_count	*	rss04_lv3_price	+	rss04_rlv4_count	*	rss04_lv4_price	+	rss04_rlv5_count	*	rss04_lv5_price	+	rss04_int	*	rss04_lv6_price	;	}
        if(	rss04_int	>=	rss04_lv6_count	|	rss04_int	 ==	rss04_lv6_count )	{rss04_int =	rss04_int	-	rss04_rlv1_count 	-	rss04_rlv2_count 	-	rss04_rlv3_count 	-	rss04_rlv4_count 	-	rss04_rlv5_count 	 	; tickets = tickets +	rss04_lv1_count	*	rss04_lv1_price	+	rss04_rlv2_count	*	rss04_lv2_price	+	rss04_rlv3_count	*	rss04_lv3_price	+	rss04_rlv4_count	*	rss04_lv4_price	+	rss04_rlv5_count	*	rss04_lv5_price	+	rss04_int	*	rss04_lv6_price	;	}
        adapter.add("[RSS] Steel 16K x"+prettyCount(rss04_int_base)+" cost "+prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        adapter1.add(getString(R.string.event_rss04));adapter2.add(prettyCount(rss01_int_base));adapter3.add(prettyCount(tickets));
        tickets = 0 ;

        int rss05_int = Integer.parseInt(alloy.getText().toString());
        int rss05_int_base = Integer.parseInt(alloy.getText().toString());
        if (rss05_int > rss05_lv6_count){rss05_int = rss05_int_base = rss05_lv6_count; alloy.setText(String.valueOf(rss05_lv6_count));}
        int rss05_rlv1_count 	 =	rss05_lv1_count 	;
        int rss05_rlv2_count	 =	rss05_lv2_count	-	rss05_lv1_count	;
        int rss05_rlv3_count	 =	rss05_lv3_count	-	rss05_lv2_count	;
        int rss05_rlv4_count	 =	rss05_lv4_count	-	rss05_lv3_count	;
        int rss05_rlv5_count	 =	rss05_lv5_count	-	rss05_lv4_count	;
        int rss05_rlv6_count	 =	rss05_lv6_count	-	rss05_lv5_count	;
        if(	rss05_int	>=	0	&&	rss05_int	<	rss05_lv1_count )	{rss05_int =	rss05_int													; tickets = tickets +	rss05_int	*	rss05_lv1_price	;	}
        if(	rss05_int	>=	rss05_lv1_count 	&&	rss05_int	<	rss05_lv2_count )	{rss05_int =	rss05_int	-	rss05_rlv1_count 											; tickets = tickets +	rss05_lv1_count	*	rss05_lv1_price	+	rss05_int	*	rss05_lv2_price	;	}
        if(	rss05_int	>=	rss05_lv2_count	&&	rss05_int	<	rss05_lv3_count )	{rss05_int =	rss05_int	-	rss05_rlv1_count 	-	rss05_rlv2_count 									; tickets = tickets +	rss05_lv1_count	*	rss05_lv1_price	+	rss05_rlv2_count	*	rss05_lv2_price	+	rss05_int	*	rss05_lv3_price	;	}
        if(	rss05_int	>=	rss05_lv3_count	&&	rss05_int	<	rss05_lv4_count )	{rss05_int =	rss05_int	-	rss05_rlv1_count 	-	rss05_rlv2_count 	-	rss05_rlv3_count 							; tickets = tickets +	rss05_lv1_count	*	rss05_lv1_price	+	rss05_rlv2_count	*	rss05_lv2_price	+	rss05_rlv3_count	*	rss05_lv3_price	+	rss05_int	*	rss05_lv4_price	;	}
        if(	rss05_int	>=	rss05_lv4_count	&&	rss05_int	<	rss05_lv5_count )	{rss05_int =	rss05_int	-	rss05_rlv1_count 	-	rss05_rlv2_count 	-	rss05_rlv3_count 	-	rss05_rlv4_count 					; tickets = tickets +	rss05_lv1_count	*	rss05_lv1_price	+	rss05_rlv2_count	*	rss05_lv2_price	+	rss05_rlv3_count	*	rss05_lv3_price	+	rss05_rlv4_count	*	rss05_lv4_price	+	rss05_int	*	rss05_lv5_price	;	}
        if(	rss05_int	>=	rss05_lv5_count	&&	rss05_int	<	rss05_lv6_count )	{rss05_int =	rss05_int	-	rss05_rlv1_count 	-	rss05_rlv2_count 	-	rss05_rlv3_count 	-	rss05_rlv4_count 	-	rss05_rlv5_count 			; tickets = tickets +	rss05_lv1_count	*	rss05_lv1_price	+	rss05_rlv2_count	*	rss05_lv2_price	+	rss05_rlv3_count	*	rss05_lv3_price	+	rss05_rlv4_count	*	rss05_lv4_price	+	rss05_rlv5_count	*	rss05_lv5_price	+	rss05_int	*	rss05_lv6_price	;	}
        if(	rss05_int	>=	rss05_lv6_count	|	rss05_int	 ==	rss05_lv6_count )	{rss05_int =	rss05_int	-	rss05_rlv1_count 	-	rss05_rlv2_count 	-	rss05_rlv3_count 	-	rss05_rlv4_count 	-	rss05_rlv5_count 	 	; tickets = tickets +	rss05_lv1_count	*	rss05_lv1_price	+	rss05_rlv2_count	*	rss05_lv2_price	+	rss05_rlv3_count	*	rss05_lv3_price	+	rss05_rlv4_count	*	rss05_lv4_price	+	rss05_rlv5_count	*	rss05_lv5_price	+	rss05_int	*	rss05_lv6_price	;	}
        adapter.add("[RSS] Alloy 4K x"+prettyCount(rss05_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_rss05));adapter2.add(prettyCount(rss05_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;

        int rss06_int = Integer.parseInt(kyan.getText().toString());
        int rss06_int_base = Integer.parseInt(kyan.getText().toString());
        if (rss06_int > rss06_lv6_count){rss06_int = rss06_int_base = rss06_lv6_count; kyan.setText(String.valueOf(rss06_lv6_count));}
        int rss06_rlv1_count 	 =	rss06_lv1_count 	;
        int rss06_rlv2_count	 =	rss06_lv2_count	-	rss06_lv1_count	;
        int rss06_rlv3_count	 =	rss06_lv3_count	-	rss06_lv2_count	;
        int rss06_rlv4_count	 =	rss06_lv4_count	-	rss06_lv3_count	;
        int rss06_rlv5_count	 =	rss06_lv5_count	-	rss06_lv4_count	;
        int rss06_rlv6_count	 =	rss06_lv6_count	-	rss06_lv5_count	;
        if(	rss06_int	>=	0	&&	rss06_int	<	rss06_lv1_count )	{rss06_int =	rss06_int													; tickets = tickets +	rss06_int	*	rss06_lv1_price	;	}
        if(	rss06_int	>=	rss06_lv1_count 	&&	rss06_int	<	rss06_lv2_count )	{rss06_int =	rss06_int	-	rss06_rlv1_count 											; tickets = tickets +	rss06_lv1_count	*	rss06_lv1_price	+	rss06_int	*	rss06_lv2_price	;	}
        if(	rss06_int	>=	rss06_lv2_count	&&	rss06_int	<	rss06_lv3_count )	{rss06_int =	rss06_int	-	rss06_rlv1_count 	-	rss06_rlv2_count 									; tickets = tickets +	rss06_lv1_count	*	rss06_lv1_price	+	rss06_rlv2_count	*	rss06_lv2_price	+	rss06_int	*	rss06_lv3_price	;	}
        if(	rss06_int	>=	rss06_lv3_count	&&	rss06_int	<	rss06_lv4_count )	{rss06_int =	rss06_int	-	rss06_rlv1_count 	-	rss06_rlv2_count 	-	rss06_rlv3_count 							; tickets = tickets +	rss06_lv1_count	*	rss06_lv1_price	+	rss06_rlv2_count	*	rss06_lv2_price	+	rss06_rlv3_count	*	rss06_lv3_price	+	rss06_int	*	rss06_lv4_price	;	}
        if(	rss06_int	>=	rss06_lv4_count	&&	rss06_int	<	rss06_lv5_count )	{rss06_int =	rss06_int	-	rss06_rlv1_count 	-	rss06_rlv2_count 	-	rss06_rlv3_count 	-	rss06_rlv4_count 					; tickets = tickets +	rss06_lv1_count	*	rss06_lv1_price	+	rss06_rlv2_count	*	rss06_lv2_price	+	rss06_rlv3_count	*	rss06_lv3_price	+	rss06_rlv4_count	*	rss06_lv4_price	+	rss06_int	*	rss06_lv5_price	;	}
        if(	rss06_int	>=	rss06_lv5_count	&&	rss06_int	<	rss06_lv6_count )	{rss06_int =	rss06_int	-	rss06_rlv1_count 	-	rss06_rlv2_count 	-	rss06_rlv3_count 	-	rss06_rlv4_count 	-	rss06_rlv5_count 			; tickets = tickets +	rss06_lv1_count	*	rss06_lv1_price	+	rss06_rlv2_count	*	rss06_lv2_price	+	rss06_rlv3_count	*	rss06_lv3_price	+	rss06_rlv4_count	*	rss06_lv4_price	+	rss06_rlv5_count	*	rss06_lv5_price	+	rss06_int	*	rss06_lv6_price	;	}
        if(	rss06_int	>=	rss06_lv6_count	|	rss06_int	 ==	rss06_lv6_count )	{rss06_int =	rss06_int	-	rss06_rlv1_count 	-	rss06_rlv2_count 	-	rss06_rlv3_count 	-	rss06_rlv4_count 	-	rss06_rlv5_count 	 	; tickets = tickets +	rss06_lv1_count	*	rss06_lv1_price	+	rss06_rlv2_count	*	rss06_lv2_price	+	rss06_rlv3_count	*	rss06_lv3_price	+	rss06_rlv4_count	*	rss06_lv4_price	+	rss06_rlv5_count	*	rss06_lv5_price	+	rss06_int	*	rss06_lv6_price	;	}
        adapter.add("[RSS] Kyanite 1K x"+prettyCount(rss06_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_rss06));adapter2.add(prettyCount(rss06_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;

        int rss07_int = Integer.parseInt(kyanb.getText().toString());
        int rss07_int_base = Integer.parseInt(kyanb.getText().toString());
        if (rss07_int > rss07_lv6_count){rss07_int = rss07_int_base = rss07_lv6_count; kyanb.setText(String.valueOf(rss07_lv6_count));}
        int rss07_rlv1_count 	 =	rss07_lv1_count 	;
        int rss07_rlv2_count	 =	rss07_lv2_count	-	rss07_lv1_count	;
        int rss07_rlv3_count	 =	rss07_lv3_count	-	rss07_lv2_count	;
        int rss07_rlv4_count	 =	rss07_lv4_count	-	rss07_lv3_count	;
        int rss07_rlv5_count	 =	rss07_lv5_count	-	rss07_lv4_count	;
        int rss07_rlv6_count	 =	rss07_lv6_count	-	rss07_lv5_count	;
        if(	rss07_int	>=	0	&&	rss07_int	<	rss07_lv1_count )	{rss07_int =	rss07_int													; tickets = tickets +	rss07_int	*	rss07_lv1_price	;	}
        if(	rss07_int	>=	rss07_lv1_count 	&&	rss07_int	<	rss07_lv2_count )	{rss07_int =	rss07_int	-	rss07_rlv1_count 											; tickets = tickets +	rss07_lv1_count	*	rss07_lv1_price	+	rss07_int	*	rss07_lv2_price	;	}
        if(	rss07_int	>=	rss07_lv2_count	&&	rss07_int	<	rss07_lv3_count )	{rss07_int =	rss07_int	-	rss07_rlv1_count 	-	rss07_rlv2_count 									; tickets = tickets +	rss07_lv1_count	*	rss07_lv1_price	+	rss07_rlv2_count	*	rss07_lv2_price	+	rss07_int	*	rss07_lv3_price	;	}
        if(	rss07_int	>=	rss07_lv3_count	&&	rss07_int	<	rss07_lv4_count )	{rss07_int =	rss07_int	-	rss07_rlv1_count 	-	rss07_rlv2_count 	-	rss07_rlv3_count 							; tickets = tickets +	rss07_lv1_count	*	rss07_lv1_price	+	rss07_rlv2_count	*	rss07_lv2_price	+	rss07_rlv3_count	*	rss07_lv3_price	+	rss07_int	*	rss07_lv4_price	;	}
        if(	rss07_int	>=	rss07_lv4_count	&&	rss07_int	<	rss07_lv5_count )	{rss07_int =	rss07_int	-	rss07_rlv1_count 	-	rss07_rlv2_count 	-	rss07_rlv3_count 	-	rss07_rlv4_count 					; tickets = tickets +	rss07_lv1_count	*	rss07_lv1_price	+	rss07_rlv2_count	*	rss07_lv2_price	+	rss07_rlv3_count	*	rss07_lv3_price	+	rss07_rlv4_count	*	rss07_lv4_price	+	rss07_int	*	rss07_lv5_price	;	}
        if(	rss07_int	>=	rss07_lv5_count	&&	rss07_int	<	rss07_lv6_count )	{rss07_int =	rss07_int	-	rss07_rlv1_count 	-	rss07_rlv2_count 	-	rss07_rlv3_count 	-	rss07_rlv4_count 	-	rss07_rlv5_count 			; tickets = tickets +	rss07_lv1_count	*	rss07_lv1_price	+	rss07_rlv2_count	*	rss07_lv2_price	+	rss07_rlv3_count	*	rss07_lv3_price	+	rss07_rlv4_count	*	rss07_lv4_price	+	rss07_rlv5_count	*	rss07_lv5_price	+	rss07_int	*	rss07_lv6_price	;	}
        if(	rss07_int	>=	rss07_lv6_count	|	rss07_int	 ==	rss07_lv6_count )	{rss07_int =	rss07_int	-	rss07_rlv1_count 	-	rss07_rlv2_count 	-	rss07_rlv3_count 	-	rss07_rlv4_count 	-	rss07_rlv5_count 	 	; tickets = tickets +	rss07_lv1_count	*	rss07_lv1_price	+	rss07_rlv2_count	*	rss07_lv2_price	+	rss07_rlv3_count	*	rss07_lv3_price	+	rss07_rlv4_count	*	rss07_lv4_price	+	rss07_rlv5_count	*	rss07_lv5_price	+	rss07_int	*	rss07_lv6_price	;	}
        adapter.add("[RSS] Kyanite Basic 100 x"+prettyCount(rss07_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_rss07));adapter2.add(prettyCount(rss07_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;

        int rss08_int = Integer.parseInt(kyanc.getText().toString());
        int rss08_int_base = Integer.parseInt(kyanc.getText().toString());
        if (rss08_int > rss08_lv6_count){rss08_int = rss08_int_base = rss08_lv6_count; kyanc.setText(String.valueOf(rss08_lv6_count));}
        int rss08_rlv1_count 	 =	rss08_lv1_count 	;
        int rss08_rlv2_count	 =	rss08_lv2_count	-	rss08_lv1_count	;
        int rss08_rlv3_count	 =	rss08_lv3_count	-	rss08_lv2_count	;
        int rss08_rlv4_count	 =	rss08_lv4_count	-	rss08_lv3_count	;
        int rss08_rlv5_count	 =	rss08_lv5_count	-	rss08_lv4_count	;
        int rss08_rlv6_count	 =	rss08_lv6_count	-	rss08_lv5_count	;
        if(	rss08_int	>=	0	&&	rss08_int	<	rss08_lv1_count )	{rss08_int =	rss08_int													; tickets = tickets +	rss08_int	*	rss08_lv1_price	;	}
        if(	rss08_int	>=	rss08_lv1_count 	&&	rss08_int	<	rss08_lv2_count )	{rss08_int =	rss08_int	-	rss08_rlv1_count 											; tickets = tickets +	rss08_lv1_count	*	rss08_lv1_price	+	rss08_int	*	rss08_lv2_price	;	}
        if(	rss08_int	>=	rss08_lv2_count	&&	rss08_int	<	rss08_lv3_count )	{rss08_int =	rss08_int	-	rss08_rlv1_count 	-	rss08_rlv2_count 									; tickets = tickets +	rss08_lv1_count	*	rss08_lv1_price	+	rss08_rlv2_count	*	rss08_lv2_price	+	rss08_int	*	rss08_lv3_price	;	}
        if(	rss08_int	>=	rss08_lv3_count	&&	rss08_int	<	rss08_lv4_count )	{rss08_int =	rss08_int	-	rss08_rlv1_count 	-	rss08_rlv2_count 	-	rss08_rlv3_count 							; tickets = tickets +	rss08_lv1_count	*	rss08_lv1_price	+	rss08_rlv2_count	*	rss08_lv2_price	+	rss08_rlv3_count	*	rss08_lv3_price	+	rss08_int	*	rss08_lv4_price	;	}
        if(	rss08_int	>=	rss08_lv4_count	&&	rss08_int	<	rss08_lv5_count )	{rss08_int =	rss08_int	-	rss08_rlv1_count 	-	rss08_rlv2_count 	-	rss08_rlv3_count 	-	rss08_rlv4_count 					; tickets = tickets +	rss08_lv1_count	*	rss08_lv1_price	+	rss08_rlv2_count	*	rss08_lv2_price	+	rss08_rlv3_count	*	rss08_lv3_price	+	rss08_rlv4_count	*	rss08_lv4_price	+	rss08_int	*	rss08_lv5_price	;	}
        if(	rss08_int	>=	rss08_lv5_count	&&	rss08_int	<	rss08_lv6_count )	{rss08_int =	rss08_int	-	rss08_rlv1_count 	-	rss08_rlv2_count 	-	rss08_rlv3_count 	-	rss08_rlv4_count 	-	rss08_rlv5_count 			; tickets = tickets +	rss08_lv1_count	*	rss08_lv1_price	+	rss08_rlv2_count	*	rss08_lv2_price	+	rss08_rlv3_count	*	rss08_lv3_price	+	rss08_rlv4_count	*	rss08_lv4_price	+	rss08_rlv5_count	*	rss08_lv5_price	+	rss08_int	*	rss08_lv6_price	;	}
        if(	rss08_int	>=	rss08_lv6_count	|	rss08_int	 ==	rss08_lv6_count )	{rss08_int =	rss08_int	-	rss08_rlv1_count 	-	rss08_rlv2_count 	-	rss08_rlv3_count 	-	rss08_rlv4_count 	-	rss08_rlv5_count 	 	; tickets = tickets +	rss08_lv1_count	*	rss08_lv1_price	+	rss08_rlv2_count	*	rss08_lv2_price	+	rss08_rlv3_count	*	rss08_lv3_price	+	rss08_rlv4_count	*	rss08_lv4_price	+	rss08_rlv5_count	*	rss08_lv5_price	+	rss08_int	*	rss08_lv6_price	;	}
        adapter.add("[RSS] Kyanite Cluster 100 x"+prettyCount(rss08_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_rss08));adapter2.add(prettyCount(rss08_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;

        int rss09_int = Integer.parseInt(speed.getText().toString());
        int rss09_int_base = Integer.parseInt(speed.getText().toString());
        if (rss09_int > rss09_lv6_count){rss09_int = rss09_int_base = rss09_lv6_count; speed.setText(String.valueOf(rss09_lv6_count));}
        int rss09_rlv1_count 	 =	rss09_lv1_count 	;
        int rss09_rlv2_count	 =	rss09_lv2_count	-	rss09_lv1_count	;
        int rss09_rlv3_count	 =	rss09_lv3_count	-	rss09_lv2_count	;
        int rss09_rlv4_count	 =	rss09_lv4_count	-	rss09_lv3_count	;
        int rss09_rlv5_count	 =	rss09_lv5_count	-	rss09_lv4_count	;
        int rss09_rlv6_count	 =	rss09_lv6_count	-	rss09_lv5_count	;
        if(	rss09_int	>=	0	&&	rss09_int	<	rss09_lv1_count )	{rss09_int =	rss09_int													; tickets = tickets +	rss09_int	*	rss09_lv1_price	;	}
        if(	rss09_int	>=	rss09_lv1_count 	&&	rss09_int	<	rss09_lv2_count )	{rss09_int =	rss09_int	-	rss09_rlv1_count 											; tickets = tickets +	rss09_lv1_count	*	rss09_lv1_price	+	rss09_int	*	rss09_lv2_price	;	}
        if(	rss09_int	>=	rss09_lv2_count	&&	rss09_int	<	rss09_lv3_count )	{rss09_int =	rss09_int	-	rss09_rlv1_count 	-	rss09_rlv2_count 									; tickets = tickets +	rss09_lv1_count	*	rss09_lv1_price	+	rss09_rlv2_count	*	rss09_lv2_price	+	rss09_int	*	rss09_lv3_price	;	}
        if(	rss09_int	>=	rss09_lv3_count	&&	rss09_int	<	rss09_lv4_count )	{rss09_int =	rss09_int	-	rss09_rlv1_count 	-	rss09_rlv2_count 	-	rss09_rlv3_count 							; tickets = tickets +	rss09_lv1_count	*	rss09_lv1_price	+	rss09_rlv2_count	*	rss09_lv2_price	+	rss09_rlv3_count	*	rss09_lv3_price	+	rss09_int	*	rss09_lv4_price	;	}
        if(	rss09_int	>=	rss09_lv4_count	&&	rss09_int	<	rss09_lv5_count )	{rss09_int =	rss09_int	-	rss09_rlv1_count 	-	rss09_rlv2_count 	-	rss09_rlv3_count 	-	rss09_rlv4_count 					; tickets = tickets +	rss09_lv1_count	*	rss09_lv1_price	+	rss09_rlv2_count	*	rss09_lv2_price	+	rss09_rlv3_count	*	rss09_lv3_price	+	rss09_rlv4_count	*	rss09_lv4_price	+	rss09_int	*	rss09_lv5_price	;	}
        if(	rss09_int	>=	rss09_lv5_count	&&	rss09_int	<	rss09_lv6_count )	{rss09_int =	rss09_int	-	rss09_rlv1_count 	-	rss09_rlv2_count 	-	rss09_rlv3_count 	-	rss09_rlv4_count 	-	rss09_rlv5_count 			; tickets = tickets +	rss09_lv1_count	*	rss09_lv1_price	+	rss09_rlv2_count	*	rss09_lv2_price	+	rss09_rlv3_count	*	rss09_lv3_price	+	rss09_rlv4_count	*	rss09_lv4_price	+	rss09_rlv5_count	*	rss09_lv5_price	+	rss09_int	*	rss09_lv6_price	;	}
        if(	rss09_int	>=	rss09_lv6_count	|	rss09_int	 ==	rss09_lv6_count )	{rss09_int =	rss09_int	-	rss09_rlv1_count 	-	rss09_rlv2_count 	-	rss09_rlv3_count 	-	rss09_rlv4_count 	-	rss09_rlv5_count 	 	; tickets = tickets +	rss09_lv1_count	*	rss09_lv1_price	+	rss09_rlv2_count	*	rss09_lv2_price	+	rss09_rlv3_count	*	rss09_lv3_price	+	rss09_rlv4_count	*	rss09_lv4_price	+	rss09_rlv5_count	*	rss09_lv5_price	+	rss09_int	*	rss09_lv6_price	;	}
        adapter.add("[RSS] Speed Up 1h x"+prettyCount(rss09_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_rss09));adapter2.add(prettyCount(rss09_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;

        //ENABLER

        int enabler01_int = Integer.parseInt(shard.getText().toString());
        int enabler01_int_base = Integer.parseInt(shard.getText().toString());
        if (enabler01_int > enabler01_lv2_count){enabler01_int = enabler01_int_base = enabler01_lv2_count; shard.setText(String.valueOf(enabler01_lv2_count));}
        int enabler01_rlv1_count 	 =	enabler01_lv1_count 	;
        int enabler01_rlv2_count	 =	enabler01_lv2_count	-	enabler01_lv1_count	;
       if(	enabler01_int	>=	0	&&	enabler01_int	<	enabler01_lv1_count )	{enabler01_int =	enabler01_int													; tickets = tickets +	enabler01_int	*	enabler01_lv1_price	;	}
        if(	enabler01_int	>=	enabler01_lv1_count 	&&	enabler01_int	<	enabler01_lv2_count )	{enabler01_int =	enabler01_int	-	enabler01_rlv1_count 											; tickets = tickets +	enabler01_lv1_count	*	enabler01_lv1_price	+	enabler01_int	*	enabler01_lv2_price	;	}
        if(	enabler01_int	>=	enabler01_lv2_count	|	enabler01_int	==	rss09_lv6_count )	{enabler01_int =	enabler01_int	-	enabler01_rlv1_count 	-	enabler01_rlv2_count 									; tickets = tickets +	enabler01_lv1_count	*	enabler01_lv1_price	+	enabler01_rlv2_count	*	enabler01_lv2_price		;	}
        adapter.add("[ENABLER] Lois Shard x"+prettyCount(enabler01_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_enabler01));adapter2.add(prettyCount(enabler01_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;

        int enabler02_int = Integer.parseInt(nors.getText().toString());
        int enabler02_int_base = Integer.parseInt(nors.getText().toString());
        if (enabler02_int > enabler02_lv6_count){enabler02_int = enabler02_int_base = enabler02_lv6_count; nors.setText(String.valueOf(enabler02_lv6_count));}
        int enabler02_rlv1_count 	 =	enabler02_lv1_count 	;
        int enabler02_rlv2_count	 =	enabler02_lv2_count	-	enabler02_lv1_count	;
        int enabler02_rlv3_count	 =	enabler02_lv3_count	-	enabler02_lv2_count	;
        int enabler02_rlv4_count	 =	enabler02_lv4_count	-	enabler02_lv3_count	;
        int enabler02_rlv5_count	 =	enabler02_lv5_count	-	enabler02_lv4_count	;
        int enabler02_rlv6_count	 =	enabler02_lv6_count	-	enabler02_lv5_count	;
        if(	enabler02_int	>=	0	&&	enabler02_int	<	enabler02_lv1_count )	{enabler02_int =	enabler02_int													; tickets = tickets +	enabler02_int	*	enabler02_lv1_price	;	}
        if(	enabler02_int	>=	enabler02_lv1_count 	&&	enabler02_int	<	enabler02_lv2_count )	{enabler02_int =	enabler02_int	-	enabler02_rlv1_count 											; tickets = tickets +	enabler02_lv1_count	*	enabler02_lv1_price	+	enabler02_int	*	enabler02_lv2_price	;	}
        if(	enabler02_int	>=	enabler02_lv2_count	&&	enabler02_int	<	enabler02_lv3_count )	{enabler02_int =	enabler02_int	-	enabler02_rlv1_count 	-	enabler02_rlv2_count 									; tickets = tickets +	enabler02_lv1_count	*	enabler02_lv1_price	+	enabler02_rlv2_count	*	enabler02_lv2_price	+	enabler02_int	*	enabler02_lv3_price	;	}
        if(	enabler02_int	>=	enabler02_lv3_count	&&	enabler02_int	<	enabler02_lv4_count )	{enabler02_int =	enabler02_int	-	enabler02_rlv1_count 	-	enabler02_rlv2_count 	-	enabler02_rlv3_count 							; tickets = tickets +	enabler02_lv1_count	*	enabler02_lv1_price	+	enabler02_rlv2_count	*	enabler02_lv2_price	+	enabler02_rlv3_count	*	enabler02_lv3_price	+	enabler02_int	*	enabler02_lv4_price	;	}
        if(	enabler02_int	>=	enabler02_lv4_count	&&	enabler02_int	<	enabler02_lv5_count )	{enabler02_int =	enabler02_int	-	enabler02_rlv1_count 	-	enabler02_rlv2_count 	-	enabler02_rlv3_count 	-	enabler02_rlv4_count 					; tickets = tickets +	enabler02_lv1_count	*	enabler02_lv1_price	+	enabler02_rlv2_count	*	enabler02_lv2_price	+	enabler02_rlv3_count	*	enabler02_lv3_price	+	enabler02_rlv4_count	*	enabler02_lv4_price	+	enabler02_int	*	enabler02_lv5_price	;	}
        if(	enabler02_int	>=	enabler02_lv5_count	&&	enabler02_int	<	enabler02_lv6_count )	{enabler02_int =	enabler02_int	-	enabler02_rlv1_count 	-	enabler02_rlv2_count 	-	enabler02_rlv3_count 	-	enabler02_rlv4_count 	-	enabler02_rlv5_count 			; tickets = tickets +	enabler02_lv1_count	*	enabler02_lv1_price	+	enabler02_rlv2_count	*	enabler02_lv2_price	+	enabler02_rlv3_count	*	enabler02_lv3_price	+	enabler02_rlv4_count	*	enabler02_lv4_price	+	enabler02_rlv5_count	*	enabler02_lv5_price	+	enabler02_int	*	enabler02_lv6_price	;	}
        if(	enabler02_int	>=	enabler02_lv6_count	|	enabler02_int	 ==	enabler02_lv6_count )	{enabler02_int =	enabler02_int	-	enabler02_rlv1_count 	-	enabler02_rlv2_count 	-	enabler02_rlv3_count 	-	enabler02_rlv4_count 	-	enabler02_rlv5_count 	 	; tickets = tickets +	enabler02_lv1_count	*	enabler02_lv1_price	+	enabler02_rlv2_count	*	enabler02_lv2_price	+	enabler02_rlv3_count	*	enabler02_lv3_price	+	enabler02_rlv4_count	*	enabler02_lv4_price	+	enabler02_rlv5_count	*	enabler02_lv5_price	+	enabler02_int	*	enabler02_lv6_price	;	}
        adapter.add("[ENABLER] Common Shard 100 x"+prettyCount(enabler02_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_enabler02));adapter2.add(prettyCount(enabler02_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;

        int enabler03_int = Integer.parseInt(advs.getText().toString());
        int enabler03_int_base = Integer.parseInt(advs.getText().toString());
        if (enabler03_int > enabler03_lv6_count){enabler03_int = enabler03_int_base = enabler03_lv6_count; advs.setText(String.valueOf(enabler03_lv6_count));}
        int enabler03_rlv1_count 	 =	enabler03_lv1_count 	;
        int enabler03_rlv2_count	 =	enabler03_lv2_count	-	enabler03_lv1_count	;
        int enabler03_rlv3_count	 =	enabler03_lv3_count	-	enabler03_lv2_count	;
        int enabler03_rlv4_count	 =	enabler03_lv4_count	-	enabler03_lv3_count ;
        int enabler03_rlv5_count	 =	enabler03_lv5_count	-	enabler03_lv4_count	;
        int enabler03_rlv6_count	 =	enabler03_lv6_count	-	enabler03_lv5_count	;
        if(	enabler03_int	>=	0	&&	enabler03_int	<	enabler03_lv1_count )	{enabler03_int =	enabler03_int													; tickets = tickets +	enabler03_int	*	enabler03_lv1_price	;	}
        if(	enabler03_int	>=	enabler03_lv1_count 	&&	enabler03_int	<	enabler03_lv2_count )	{enabler03_int =	enabler03_int	-	enabler03_rlv1_count 											; tickets = tickets +	enabler03_lv1_count	*	enabler03_lv1_price	+	enabler03_int	*	enabler03_lv2_price	;	}
        if(	enabler03_int	>=	enabler03_lv2_count	&&	enabler03_int	<	enabler03_lv3_count )	{enabler03_int =	enabler03_int	-	enabler03_rlv1_count 	-	enabler03_rlv2_count 									; tickets = tickets +	enabler03_lv1_count	*	enabler03_lv1_price	+	enabler03_rlv2_count	*	enabler03_lv2_price	+	enabler03_int	*	enabler03_lv3_price	;	}
        if(	enabler03_int	>=	enabler03_lv3_count	&&	enabler03_int	<	enabler03_lv4_count )	{enabler03_int =	enabler03_int	-	enabler03_rlv1_count 	-	enabler03_rlv2_count 	-	enabler03_rlv3_count 							; tickets = tickets +	enabler03_lv1_count	*	enabler03_lv1_price	+	enabler03_rlv2_count	*	enabler03_lv2_price	+	enabler03_rlv3_count	*	enabler03_lv3_price	+	enabler03_int	*	enabler03_lv4_price	;	}
        if(	enabler03_int	>=	enabler03_lv4_count	&&	enabler03_int	<	enabler03_lv5_count )	{enabler03_int =	enabler03_int	-	enabler03_rlv1_count 	-	enabler03_rlv2_count 	-	enabler03_rlv3_count 	-	enabler03_rlv4_count 					; tickets = tickets +	enabler03_lv1_count	*	enabler03_lv1_price	+	enabler03_rlv2_count	*	enabler03_lv2_price	+	enabler03_rlv3_count	*	enabler03_lv3_price	+	enabler03_rlv4_count	*	enabler03_lv4_price	+	enabler03_int	*	enabler03_lv5_price	;	}
        if(	enabler03_int	>=	enabler03_lv5_count	&&	enabler03_int	<	enabler03_lv6_count )	{enabler03_int =	enabler03_int	-	enabler03_rlv1_count 	-	enabler03_rlv2_count 	-	enabler03_rlv3_count 	-	enabler03_rlv4_count 	-	enabler03_rlv5_count 			; tickets = tickets +	enabler03_lv1_count	*	enabler03_lv1_price	+	enabler03_rlv2_count	*	enabler03_lv2_price	+	enabler03_rlv3_count	*	enabler03_lv3_price	+	enabler03_rlv4_count	*	enabler03_lv4_price	+	enabler03_rlv5_count	*	enabler03_lv5_price	+	enabler03_int	*	enabler03_lv6_price	;	}
        if(	enabler03_int	>=	enabler03_lv6_count	|	enabler03_int	 ==	enabler03_lv6_count )	{enabler03_int =	enabler03_int	-	enabler03_rlv1_count 	-	enabler03_rlv2_count 	-	enabler03_rlv3_count 	-	enabler03_rlv4_count 	-	enabler03_rlv5_count 	 	; tickets = tickets +	enabler03_lv1_count	*	enabler03_lv1_price	+	enabler03_rlv2_count	*	enabler03_lv2_price	+	enabler03_rlv3_count	*	enabler03_lv3_price	+	enabler03_rlv4_count	*	enabler03_lv4_price	+	enabler03_rlv5_count	*	enabler03_lv5_price	+	enabler03_int	*	enabler03_lv6_price	;	}
        adapter.add("[ENABLER] Advance Shard 100 x"+prettyCount(enabler03_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_enabler03));adapter2.add(prettyCount(enabler03_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;

        int enabler04_int = Integer.parseInt(mexp.getText().toString());
        int enabler04_int_base = Integer.parseInt(mexp.getText().toString());
        if (enabler04_int > enabler04_lv6_count){enabler04_int = enabler04_int_base = enabler04_lv6_count; mexp.setText(String.valueOf(enabler04_lv6_count));}
        int enabler04_rlv1_count 	 =	enabler04_lv1_count 	;
        int enabler04_rlv2_count	 =	enabler04_lv2_count	-	enabler04_lv1_count	;
        int enabler04_rlv3_count	 =	enabler04_lv3_count	-	enabler04_lv2_count	;
        int enabler04_rlv4_count	 =	enabler04_lv4_count	-	enabler04_lv3_count	;
        int enabler04_rlv5_count	 =	enabler04_lv5_count	-	enabler04_lv4_count	;
        int enabler04_rlv6_count	 =	enabler04_lv6_count	-	enabler04_lv5_count	;
        if(	enabler04_int	>=	0	&&	enabler04_int	<	enabler04_lv1_count )	{enabler04_int =	enabler04_int													; tickets = tickets +	enabler04_int	*	enabler04_lv1_price	;	}
        if(	enabler04_int	>=	enabler04_lv1_count 	&&	enabler04_int	<	enabler04_lv2_count )	{enabler04_int =	enabler04_int	-	enabler04_rlv1_count 											; tickets = tickets +	enabler04_lv1_count	*	enabler04_lv1_price	+	enabler04_int	*	enabler04_lv2_price	;	}
        if(	enabler04_int	>=	enabler04_lv2_count	&&	enabler04_int	<	enabler04_lv3_count )	{enabler04_int =	enabler04_int	-	enabler04_rlv1_count 	-	enabler04_rlv2_count 									; tickets = tickets +	enabler04_lv1_count	*	enabler04_lv1_price	+	enabler04_rlv2_count	*	enabler04_lv2_price	+	enabler04_int	*	enabler04_lv3_price	;	}
        if(	enabler04_int	>=	enabler04_lv3_count	&&	enabler04_int	<	enabler04_lv4_count )	{enabler04_int =	enabler04_int	-	enabler04_rlv1_count 	-	enabler04_rlv2_count 	-	enabler04_rlv3_count 							; tickets = tickets +	enabler04_lv1_count	*	enabler04_lv1_price	+	enabler04_rlv2_count	*	enabler04_lv2_price	+	enabler04_rlv3_count	*	enabler04_lv3_price	+	enabler04_int	*	enabler04_lv4_price	;	}
        if(	enabler04_int	>=	enabler04_lv4_count	&&	enabler04_int	<	enabler04_lv5_count )	{enabler04_int =	enabler04_int	-	enabler04_rlv1_count 	-	enabler04_rlv2_count 	-	enabler04_rlv3_count 	-	enabler04_rlv4_count 					; tickets = tickets +	enabler04_lv1_count	*	enabler04_lv1_price	+	enabler04_rlv2_count	*	enabler04_lv2_price	+	enabler04_rlv3_count	*	enabler04_lv3_price	+	enabler04_rlv4_count	*	enabler04_lv4_price	+	enabler04_int	*	enabler04_lv5_price	;	}
        if(	enabler04_int	>=	enabler04_lv5_count	&&	enabler04_int	<	enabler04_lv6_count )	{enabler04_int =	enabler04_int	-	enabler04_rlv1_count 	-	enabler04_rlv2_count 	-	enabler04_rlv3_count 	-	enabler04_rlv4_count 	-	enabler04_rlv5_count 			; tickets = tickets +	enabler04_lv1_count	*	enabler04_lv1_price	+	enabler04_rlv2_count	*	enabler04_lv2_price	+	enabler04_rlv3_count	*	enabler04_lv3_price	+	enabler04_rlv4_count	*	enabler04_lv4_price	+	enabler04_rlv5_count	*	enabler04_lv5_price	+	enabler04_int	*	enabler04_lv6_price	;	}
        if(	enabler04_int	>=	enabler04_lv6_count	|	enabler04_int	 ==	enabler04_lv6_count )	{enabler04_int =	enabler04_int	-	enabler04_rlv1_count 	-	enabler04_rlv2_count 	-	enabler04_rlv3_count 	-	enabler04_rlv4_count 	-	enabler04_rlv5_count 	 	;  tickets = tickets +	enabler04_lv1_count	*	enabler04_lv1_price	+	enabler04_rlv2_count	*	enabler04_lv2_price	+	enabler04_rlv3_count	*	enabler04_lv3_price	+	enabler04_rlv4_count	*	enabler04_lv4_price	+	enabler04_rlv5_count	*	enabler04_lv5_price	+	enabler04_int	*	enabler04_lv6_price	;	}
        adapter.add("[ENABLER] Mecha EXP 100 x"+prettyCount(enabler04_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_enabler04));adapter2.add(prettyCount(enabler04_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;

        int enabler05_int = Integer.parseInt(exp.getText().toString());
        int enabler05_int_base = Integer.parseInt(exp.getText().toString());
        if (enabler05_int > enabler05_lv6_count){enabler05_int = enabler05_int_base = enabler05_lv6_count; exp.setText(String.valueOf(enabler05_lv6_count));}
        int enabler05_rlv1_count 	 =	enabler05_lv1_count 	;
        int enabler05_rlv2_count	 =	enabler05_lv2_count	-	enabler05_lv1_count	;
        int enabler05_rlv3_count	 =	enabler05_lv3_count	-	enabler05_lv2_count	;
        int enabler05_rlv4_count	 =	enabler05_lv4_count	-	enabler05_lv3_count	;
        int enabler05_rlv5_count	 =	enabler05_lv5_count	-	enabler05_lv4_count ;
        int enabler05_rlv6_count	 =	enabler05_lv6_count	-	enabler05_lv5_count	;
        if(	enabler05_int	>=	0	&&	enabler05_int	<	enabler05_lv1_count )	{enabler05_int =	enabler05_int													; tickets = tickets +	enabler05_int	*	enabler05_lv1_price	;	}
        if(	enabler05_int	>=	enabler05_lv1_count 	&&	enabler05_int	<	enabler05_lv2_count )	{enabler05_int =	enabler05_int	-	enabler05_rlv1_count 											; tickets = tickets +	enabler05_lv1_count	*	enabler05_lv1_price	+	enabler05_int	*	enabler05_lv2_price	;	}
        if(	enabler05_int	>=	enabler05_lv2_count	&&	enabler05_int	<	enabler05_lv3_count )	{enabler05_int =	enabler05_int	-	enabler05_rlv1_count 	-	enabler05_rlv2_count 									; tickets = tickets +	enabler05_lv1_count	*	enabler05_lv1_price	+	enabler05_rlv2_count	*	enabler05_lv2_price	+	enabler05_int	*	enabler05_lv3_price	;	}
        if(	enabler05_int	>=	enabler05_lv3_count	&&	enabler05_int	<	enabler05_lv4_count )	{enabler05_int =	enabler05_int	-	enabler05_rlv1_count 	-	enabler05_rlv2_count 	-	enabler05_rlv3_count 							; tickets = tickets +	enabler05_lv1_count	*	enabler05_lv1_price	+	enabler05_rlv2_count	*	enabler05_lv2_price	+	enabler05_rlv3_count	*	enabler05_lv3_price	+	enabler05_int	*	enabler05_lv4_price	;	}
        if(	enabler05_int	>=	enabler05_lv4_count	&&	enabler05_int	<	enabler05_lv5_count )	{enabler05_int =	enabler05_int	-	enabler05_rlv1_count 	-	enabler05_rlv2_count 	-	enabler05_rlv3_count 	-	enabler05_rlv4_count 					; tickets = tickets +	enabler05_lv1_count	*	enabler05_lv1_price	+	enabler05_rlv2_count	*	enabler05_lv2_price	+	enabler05_rlv3_count	*	enabler05_lv3_price	+	enabler05_rlv4_count	*	enabler05_lv4_price	+	enabler05_int	*	enabler05_lv5_price	;	}
        if(	enabler05_int	>=	enabler05_lv5_count	&&	enabler05_int	<	enabler05_lv6_count )	{enabler05_int =	enabler05_int	-	enabler05_rlv1_count 	-	enabler05_rlv2_count 	-	enabler05_rlv3_count 	-	enabler05_rlv4_count 	-	enabler05_rlv5_count 			; tickets = tickets +	enabler05_lv1_count	*	enabler05_lv1_price	+	enabler05_rlv2_count	*	enabler05_lv2_price	+	enabler05_rlv3_count	*	enabler05_lv3_price	+	enabler05_rlv4_count	*	enabler05_lv4_price	+	enabler05_rlv5_count	*	enabler05_lv5_price	+	enabler05_int	*	enabler05_lv6_price	;	}
        if(	enabler05_int	>=	enabler05_lv6_count	|	enabler05_int	 ==	enabler05_lv6_count )	{enabler05_int =	enabler05_int	-	enabler05_rlv1_count 	-	enabler05_rlv2_count 	-	enabler05_rlv3_count 	-	enabler05_rlv4_count 	-	enabler05_rlv5_count 	 	; tickets = tickets +	enabler05_lv1_count	*	enabler05_lv1_price	+	enabler05_rlv2_count	*	enabler05_lv2_price	+	enabler05_rlv3_count	*	enabler05_lv3_price	+	enabler05_rlv4_count	*	enabler05_lv4_price	+	enabler05_rlv5_count	*	enabler05_lv5_price	+	enabler05_int	*	enabler05_lv6_price	;	}
        adapter.add("[ENABLER] Picture 100 x"+prettyCount(enabler05_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_enabler05));adapter2.add(prettyCount(enabler05_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;

        int enabler06_int = Integer.parseInt(pict.getText().toString());
        int enabler06_int_base = Integer.parseInt(pict.getText().toString());
        if (enabler06_int > enabler06_lv6_count){enabler06_int = enabler06_int_base = enabler06_lv6_count; pict.setText(String.valueOf(enabler06_lv6_count));}
        int enabler06_rlv1_count 	 =	enabler06_lv1_count 	;
        int enabler06_rlv2_count	 =	enabler06_lv2_count	-	enabler06_lv1_count	;
        int enabler06_rlv3_count	 =	enabler06_lv3_count	-	enabler06_lv2_count	;
        int enabler06_rlv4_count	 =	enabler06_lv4_count	-	enabler06_lv3_count		;
        int enabler06_rlv5_count	 =	enabler06_lv5_count	-	enabler06_lv4_count		;
        int enabler06_rlv6_count	 =	enabler06_lv6_count	-	enabler06_lv5_count	;
        if(	enabler06_int	>=	0	&&	enabler06_int	<	enabler06_lv1_count )	{enabler06_int =	enabler06_int													; tickets = tickets +	enabler06_int	*	enabler06_lv1_price	;	}
        if(	enabler06_int	>=	enabler06_lv1_count 	&&	enabler06_int	<	enabler06_lv2_count )	{enabler06_int =	enabler06_int	-	enabler06_rlv1_count 											; tickets = tickets +	enabler06_lv1_count	*	enabler06_lv1_price	+	enabler06_int	*	enabler06_lv2_price	;	}
        if(	enabler06_int	>=	enabler06_lv2_count	&&	enabler06_int	<	enabler06_lv3_count )	{enabler06_int =	enabler06_int	-	enabler06_rlv1_count 	-	enabler06_rlv2_count 									; tickets = tickets +	enabler06_lv1_count	*	enabler06_lv1_price	+	enabler06_rlv2_count	*	enabler06_lv2_price	+	enabler06_int	*	enabler06_lv3_price	;	}
        if(	enabler06_int	>=	enabler06_lv3_count	&&	enabler06_int	<	enabler06_lv4_count )	{enabler06_int =	enabler06_int	-	enabler06_rlv1_count 	-	enabler06_rlv2_count 	-	enabler06_rlv3_count 							; tickets = tickets +	enabler06_lv1_count	*	enabler06_lv1_price	+	enabler06_rlv2_count	*	enabler06_lv2_price	+	enabler06_rlv3_count	*	enabler06_lv3_price	+	enabler06_int	*	enabler06_lv4_price	;	}
        if(	enabler06_int	>=	enabler06_lv4_count	&&	enabler06_int	<	enabler06_lv5_count )	{enabler06_int =	enabler06_int	-	enabler06_rlv1_count 	-	enabler06_rlv2_count 	-	enabler06_rlv3_count 	-	enabler06_rlv4_count 					; tickets = tickets +	enabler06_lv1_count	*	enabler06_lv1_price	+	enabler06_rlv2_count	*	enabler06_lv2_price	+	enabler06_rlv3_count	*	enabler06_lv3_price	+	enabler06_rlv4_count	*	enabler06_lv4_price	+	enabler06_int	*	enabler06_lv5_price	;	}
        if(	enabler06_int	>=	enabler06_lv5_count	&&	enabler06_int	<	enabler06_lv6_count )	{enabler06_int =	enabler06_int	-	enabler06_rlv1_count 	-	enabler06_rlv2_count 	-	enabler06_rlv3_count 	-	enabler06_rlv4_count 	-	enabler06_rlv5_count 			; tickets = tickets +	enabler06_lv1_count	*	enabler06_lv1_price	+	enabler06_rlv2_count	*	enabler06_lv2_price	+	enabler06_rlv3_count	*	enabler06_lv3_price	+	enabler06_rlv4_count	*	enabler06_lv4_price	+	enabler06_rlv5_count	*	enabler06_lv5_price	+	enabler06_int	*	enabler06_lv6_price	;	}
        if(	enabler06_int	>=	enabler06_lv6_count	|	enabler06_int	 ==	enabler06_lv6_count )	{enabler06_int =	enabler06_int	-	enabler06_rlv1_count 	-	enabler06_rlv2_count 	-	enabler06_rlv3_count 	-	enabler06_rlv4_count 	-	enabler06_rlv5_count 	 	; tickets = tickets +	enabler06_lv1_count	*	enabler06_lv1_price	+	enabler06_rlv2_count	*	enabler06_lv2_price	+	enabler06_rlv3_count	*	enabler06_lv3_price	+	enabler06_rlv4_count	*	enabler06_lv4_price	+	enabler06_rlv5_count	*	enabler06_lv5_price	+	enabler06_int	*	enabler06_lv6_price	;	}
        adapter.add("[ENABLER] Enabler EXP 100K x"+prettyCount(enabler06_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_enabler06));adapter2.add(prettyCount(enabler06_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;
        // 20201219 Added
        int enabler07_int = Integer.parseInt(aa.getText().toString());
        int enabler07_int_base = Integer.parseInt(aa.getText().toString());
        if (enabler07_int > enabler07_lv4_count){enabler07_int = enabler07_int_base = enabler07_lv4_count; aa.setText(String.valueOf(enabler07_lv4_count));}
        int enabler07_rlv1_count 	 =	enabler07_lv1_count 	;
        int enabler07_rlv2_count	 =	enabler07_lv2_count	-	enabler07_lv1_count	;
        int enabler07_rlv3_count	 =	enabler07_lv3_count	-	enabler07_lv2_count	;
        int enabler07_rlv4_count	 =	enabler07_lv4_count	-	enabler07_lv3_count		;
        if(	enabler07_int	>=	0	&&	enabler07_int	<	enabler07_lv1_count )	{enabler07_int =	enabler07_int													; tickets = tickets +	enabler07_int	*	enabler07_lv1_price	;	}
        if(	enabler07_int	>=	enabler07_lv1_count 	&&	enabler07_int	<	enabler07_lv2_count )	{enabler07_int =	enabler07_int	-	enabler07_rlv1_count 											; tickets = tickets +	enabler07_lv1_count	*	enabler07_lv1_price	+	enabler07_int	*	enabler07_lv2_price	;	}
        if(	enabler07_int	>=	enabler07_lv2_count	&&	enabler07_int	<	enabler07_lv3_count )	{enabler07_int =	enabler07_int	-	enabler07_rlv1_count 	-	enabler07_rlv2_count 									; tickets = tickets +	enabler07_lv1_count	*	enabler07_lv1_price	+	enabler07_rlv2_count	*	enabler07_lv2_price	+	enabler07_int	*	enabler07_lv3_price	;	}
        if(	enabler07_int	>=	enabler07_lv3_count	&&	enabler07_int	<	enabler07_lv4_count )	{enabler07_int =	enabler07_int	-	enabler07_rlv1_count 	-	enabler07_rlv2_count 	-	enabler07_rlv3_count 							; tickets = tickets +	enabler07_lv1_count	*	enabler07_lv1_price	+	enabler07_rlv2_count	*	enabler07_lv2_price	+	enabler07_rlv3_count	*	enabler07_lv3_price	+	enabler07_int	*	enabler07_lv4_price	;	}
        if(	enabler07_int	>=	enabler07_lv4_count	|	enabler07_int	 ==	enabler07_lv4_count )	{enabler07_int =	enabler07_int	-	enabler07_rlv1_count 	-	enabler07_rlv2_count 	-	enabler07_rlv3_count 	 		 	; tickets = tickets +	enabler07_lv1_count	*	enabler07_lv1_price	+	enabler07_rlv2_count	*	enabler07_lv2_price	+	enabler07_rlv3_count	*	enabler07_lv3_price	+	enabler07_rlv4_count	*	enabler07_lv4_price	;	}
        adapter.add("[ENABLER] Enabler EXP 100K x"+prettyCount(enabler07_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_enabler07));adapter2.add(prettyCount(enabler07_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;

        //MECHA

        int mecha01_int = Integer.parseInt(cc.getText().toString());
        int mecha01_int_base = Integer.parseInt(cc.getText().toString());
        if (mecha01_int > mecha01_lv6_count){mecha01_int = mecha01_int_base = mecha01_lv6_count; cc.setText(String.valueOf(mecha01_lv6_count));}
        int mecha01_rlv1_count 	 =	mecha01_lv1_count 	;
        int mecha01_rlv2_count	 =	mecha01_lv2_count	-	mecha01_lv1_count	;
        int mecha01_rlv3_count	 =	mecha01_lv3_count	-	mecha01_lv2_count	;
        int mecha01_rlv4_count	 =	mecha01_lv4_count	-	mecha01_lv3_count	;
        int mecha01_rlv5_count	 =	mecha01_lv5_count	-	mecha01_lv4_count	;
        int mecha01_rlv6_count	 =	mecha01_lv6_count	-	mecha01_lv5_count	;
        if(	mecha01_int	>=	0	&&	mecha01_int	<	mecha01_lv1_count )	{mecha01_int =	mecha01_int													; tickets = tickets +	mecha01_int	*	mecha01_lv1_price	;	}
        if(	mecha01_int	>=	mecha01_lv1_count 	&&	mecha01_int	<	mecha01_lv2_count )	{mecha01_int =	mecha01_int	-	mecha01_rlv1_count 											; tickets = tickets +	mecha01_lv1_count	*	mecha01_lv1_price	+	mecha01_int	*	mecha01_lv2_price	;	}
        if(	mecha01_int	>=	mecha01_lv2_count	&&	mecha01_int	<	mecha01_lv3_count )	{mecha01_int =	mecha01_int	-	mecha01_rlv1_count 	-	mecha01_rlv2_count 									; tickets = tickets +	mecha01_lv1_count	*	mecha01_lv1_price	+	mecha01_rlv2_count	*	mecha01_lv2_price	+	mecha01_int	*	mecha01_lv3_price	;	}
        if(	mecha01_int	>=	mecha01_lv3_count	&&	mecha01_int	<	mecha01_lv4_count )	{mecha01_int =	mecha01_int	-	mecha01_rlv1_count 	-	mecha01_rlv2_count 	-	mecha01_rlv3_count 							; tickets = tickets +	mecha01_lv1_count	*	mecha01_lv1_price	+	mecha01_rlv2_count	*	mecha01_lv2_price	+	mecha01_rlv3_count	*	mecha01_lv3_price	+	mecha01_int	*	mecha01_lv4_price	;	}
        if(	mecha01_int	>=	mecha01_lv4_count	&&	mecha01_int	<	mecha01_lv5_count )	{mecha01_int =	mecha01_int	-	mecha01_rlv1_count 	-	mecha01_rlv2_count 	-	mecha01_rlv3_count 	-	mecha01_rlv4_count 					; tickets = tickets +	mecha01_lv1_count	*	mecha01_lv1_price	+	mecha01_rlv2_count	*	mecha01_lv2_price	+	mecha01_rlv3_count	*	mecha01_lv3_price	+	mecha01_rlv4_count	*	mecha01_lv4_price	+	mecha01_int	*	mecha01_lv5_price	;	}
        if(	mecha01_int	>=	mecha01_lv5_count	&&	mecha01_int	<	mecha01_lv6_count )	{mecha01_int =	mecha01_int	-	mecha01_rlv1_count 	-	mecha01_rlv2_count 	-	mecha01_rlv3_count 	-	mecha01_rlv4_count 	-	mecha01_rlv5_count 			; tickets = tickets +	mecha01_lv1_count	*	mecha01_lv1_price	+	mecha01_rlv2_count	*	mecha01_lv2_price	+	mecha01_rlv3_count	*	mecha01_lv3_price	+	mecha01_rlv4_count	*	mecha01_lv4_price	+	mecha01_rlv5_count	*	mecha01_lv5_price	+	mecha01_int	*	mecha01_lv6_price	;	}
        if(	mecha01_int	>=	mecha01_lv6_count	|	mecha01_int	 ==	mecha01_lv6_count )	{mecha01_int =	mecha01_int	-	mecha01_rlv1_count 	-	mecha01_rlv2_count 	-	mecha01_rlv3_count 	-	mecha01_rlv4_count 	-	mecha01_rlv5_count 	 	; tickets = tickets +	mecha01_lv1_count	*	mecha01_lv1_price	+	mecha01_rlv2_count	*	mecha01_lv2_price	+	mecha01_rlv3_count	*	mecha01_lv3_price	+	mecha01_rlv4_count	*	mecha01_lv4_price	+	mecha01_rlv5_count	*	mecha01_lv5_price	+	mecha01_int	*	mecha01_lv6_price	;	}
        adapter.add("[MECHA] Construct Core x"+prettyCount(mecha01_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_mecha01));adapter2.add(prettyCount(mecha01_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;

        int mecha02_int = Integer.parseInt(ac.getText().toString());
        int mecha02_int_base = Integer.parseInt(ac.getText().toString());
        if (mecha02_int > mecha02_lv6_count){mecha02_int = mecha02_int_base = mecha02_lv6_count; ac.setText(String.valueOf(mecha02_lv6_count));}
        int mecha02_rlv1_count 	 =	mecha02_lv1_count 	;
        int mecha02_rlv2_count	 =	mecha02_lv2_count	-	mecha02_lv1_count	;
        int mecha02_rlv3_count	 =	mecha02_lv3_count	-	mecha02_lv2_count	;
        int mecha02_rlv4_count	 =	mecha02_lv4_count	-	mecha02_lv3_count	;
        int mecha02_rlv5_count	 =	mecha02_lv5_count	-	mecha02_lv4_count	;
        int mecha02_rlv6_count	 =	mecha02_lv6_count	-	mecha02_lv5_count	;
        if(	mecha02_int	>=	0	&&	mecha02_int	<	mecha02_lv1_count )	{mecha02_int =	mecha02_int													; tickets = tickets +	mecha02_int	*	mecha02_lv1_price	;	}
        if(	mecha02_int	>=	mecha02_lv1_count 	&&	mecha02_int	<	mecha02_lv2_count )	{mecha02_int =	mecha02_int	-	mecha02_rlv1_count 											; tickets = tickets +	mecha02_lv1_count	*	mecha02_lv1_price	+	mecha02_int	*	mecha02_lv2_price	;	}
        if(	mecha02_int	>=	mecha02_lv2_count	&&	mecha02_int	<	mecha02_lv3_count )	{mecha02_int =	mecha02_int	-	mecha02_rlv1_count 	-	mecha02_rlv2_count 									; tickets = tickets +	mecha02_lv1_count	*	mecha02_lv1_price	+	mecha02_rlv2_count	*	mecha02_lv2_price	+	mecha02_int	*	mecha02_lv3_price	;	}
        if(	mecha02_int	>=	mecha02_lv3_count	&&	mecha02_int	<	mecha02_lv4_count )	{mecha02_int =	mecha02_int	-	mecha02_rlv1_count 	-	mecha02_rlv2_count 	-	mecha02_rlv3_count 							; tickets = tickets +	mecha02_lv1_count	*	mecha02_lv1_price	+	mecha02_rlv2_count	*	mecha02_lv2_price	+	mecha02_rlv3_count	*	mecha02_lv3_price	+	mecha02_int	*	mecha02_lv4_price	;	}
        if(	mecha02_int	>=	mecha02_lv4_count	&&	mecha02_int	<	mecha02_lv5_count )	{mecha02_int =	mecha02_int	-	mecha02_rlv1_count 	-	mecha02_rlv2_count 	-	mecha02_rlv3_count 	-	mecha02_rlv4_count 					; tickets = tickets +	mecha02_lv1_count	*	mecha02_lv1_price	+	mecha02_rlv2_count	*	mecha02_lv2_price	+	mecha02_rlv3_count	*	mecha02_lv3_price	+	mecha02_rlv4_count	*	mecha02_lv4_price	+	mecha02_int	*	mecha02_lv5_price	;	}
        if(	mecha02_int	>=	mecha02_lv5_count	&&	mecha02_int	<	mecha02_lv6_count )	{mecha02_int =	mecha02_int	-	mecha02_rlv1_count 	-	mecha02_rlv2_count 	-	mecha02_rlv3_count 	-	mecha02_rlv4_count 	-	mecha02_rlv5_count 			; tickets = tickets +	mecha02_lv1_count	*	mecha02_lv1_price	+	mecha02_rlv2_count	*	mecha02_lv2_price	+	mecha02_rlv3_count	*	mecha02_lv3_price	+	mecha02_rlv4_count	*	mecha02_lv4_price	+	mecha02_rlv5_count	*	mecha02_lv5_price	+	mecha02_int	*	mecha02_lv6_price	;	}
        if(	mecha02_int	>=	mecha02_lv6_count	|	mecha02_int	 ==	mecha02_lv6_count )	{mecha02_int =	mecha02_int	-	mecha02_rlv1_count 	-	mecha02_rlv2_count 	-	mecha02_rlv3_count 	-	mecha02_rlv4_count 	-	mecha02_rlv5_count 	 	; tickets = tickets +	mecha02_lv1_count	*	mecha02_lv1_price	+	mecha02_rlv2_count	*	mecha02_lv2_price	+	mecha02_rlv3_count	*	mecha02_lv3_price	+	mecha02_rlv4_count	*	mecha02_lv4_price	+	mecha02_rlv5_count	*	mecha02_lv5_price	+	mecha02_int	*	mecha02_lv6_price	;	}
        adapter.add("[MECHA] Advanced Construct Core x"+prettyCount(mecha02_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_mecha02));adapter2.add(prettyCount(mecha02_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;

        int mecha03_int = Integer.parseInt(pbt.getText().toString());
        int mecha03_int_base = Integer.parseInt(pbt.getText().toString());
        if (mecha03_int > mecha03_lv6_count){mecha03_int = mecha03_int_base = mecha03_lv6_count; pbt.setText(String.valueOf(mecha03_lv6_count));}
        int mecha03_rlv1_count 	 =	mecha03_lv1_count 	;
        int mecha03_rlv2_count	 =	mecha03_lv2_count	-	mecha03_lv1_count	;
        int mecha03_rlv3_count	 =	mecha03_lv3_count	-	mecha03_lv2_count	;
        int mecha03_rlv4_count	 =	mecha03_lv4_count	-	mecha03_lv3_count	;
        int mecha03_rlv5_count	 =	mecha03_lv5_count	-	mecha03_lv4_count	;
        int mecha03_rlv6_count	 =	mecha03_lv6_count	-	mecha03_lv5_count	;
        if(	mecha03_int	>=	0	&&	mecha03_int	<	mecha03_lv1_count )	{mecha03_int =	mecha03_int													; tickets = tickets +	mecha03_int	*	mecha03_lv1_price	;	}
        if(	mecha03_int	>=	mecha03_lv1_count 	&&	mecha03_int	<	mecha03_lv2_count )	{mecha03_int =	mecha03_int	-	mecha03_rlv1_count 											; tickets = tickets +	mecha03_lv1_count	*	mecha03_lv1_price	+	mecha03_int	*	mecha03_lv2_price	;	}
        if(	mecha03_int	>=	mecha03_lv2_count	&&	mecha03_int	<	mecha03_lv3_count )	{mecha03_int =	mecha03_int	-	mecha03_rlv1_count 	-	mecha03_rlv2_count 									; tickets = tickets +	mecha03_lv1_count	*	mecha03_lv1_price	+	mecha03_rlv2_count	*	mecha03_lv2_price	+	mecha03_int	*	mecha03_lv3_price	;	}
        if(	mecha03_int	>=	mecha03_lv3_count	&&	mecha03_int	<	mecha03_lv4_count )	{mecha03_int =	mecha03_int	-	mecha03_rlv1_count 	-	mecha03_rlv2_count 	-	mecha03_rlv3_count 							; tickets = tickets +	mecha03_lv1_count	*	mecha03_lv1_price	+	mecha03_rlv2_count	*	mecha03_lv2_price	+	mecha03_rlv3_count	*	mecha03_lv3_price	+	mecha03_int	*	mecha03_lv4_price	;	}
        if(	mecha03_int	>=	mecha03_lv4_count	&&	mecha03_int	<	mecha03_lv5_count )	{mecha03_int =	mecha03_int	-	mecha03_rlv1_count 	-	mecha03_rlv2_count 	-	mecha03_rlv3_count 	-	mecha03_rlv4_count 					; tickets = tickets +	mecha03_lv1_count	*	mecha03_lv1_price	+	mecha03_rlv2_count	*	mecha03_lv2_price	+	mecha03_rlv3_count	*	mecha03_lv3_price	+	mecha03_rlv4_count	*	mecha03_lv4_price	+	mecha03_int	*	mecha03_lv5_price	;	}
        if(	mecha03_int	>=	mecha03_lv5_count	&&	mecha03_int	<	mecha03_lv6_count )	{mecha03_int =	mecha03_int	-	mecha03_rlv1_count 	-	mecha03_rlv2_count 	-	mecha03_rlv3_count 	-	mecha03_rlv4_count 	-	mecha03_rlv5_count 			; tickets = tickets +	mecha03_lv1_count	*	mecha03_lv1_price	+	mecha03_rlv2_count	*	mecha03_lv2_price	+	mecha03_rlv3_count	*	mecha03_lv3_price	+	mecha03_rlv4_count	*	mecha03_lv4_price	+	mecha03_rlv5_count	*	mecha03_lv5_price	+	mecha03_int	*	mecha03_lv6_price	;	}
        if(	mecha03_int	>=	mecha03_lv6_count	|	mecha03_int	 ==	mecha03_lv6_count )	{mecha03_int =	mecha03_int	-	mecha03_rlv1_count 	-	mecha03_rlv2_count 	-	mecha03_rlv3_count 	-	mecha03_rlv4_count 	-	mecha03_rlv5_count 	 	; tickets = tickets +	mecha03_lv1_count	*	mecha03_lv1_price	+	mecha03_rlv2_count	*	mecha03_lv2_price	+	mecha03_rlv3_count	*	mecha03_lv3_price	+	mecha03_rlv4_count	*	mecha03_lv4_price	+	mecha03_rlv5_count	*	mecha03_lv5_price	+	mecha03_int	*	mecha03_lv6_price	;	}
        adapter.add("[MECHA] Project Battery 10 x"+prettyCount(mecha03_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_mecha03));adapter2.add(prettyCount(mecha03_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;

        int mecha04_int = Integer.parseInt(tbt.getText().toString());
        int mecha04_int_base = Integer.parseInt(tbt.getText().toString());
        if (mecha04_int > mecha04_lv6_count){mecha04_int = mecha04_int_base = mecha04_lv6_count; tbt.setText(String.valueOf(mecha04_lv6_count));}
        int mecha04_rlv1_count 	 =	mecha04_lv1_count 	;
        int mecha04_rlv2_count	 =	mecha04_lv2_count	-	mecha04_lv1_count	;
        int mecha04_rlv3_count	 =	mecha04_lv3_count	-	mecha04_lv2_count	;
        int mecha04_rlv4_count	 =	mecha04_lv4_count	-	mecha04_lv3_count	;
        int mecha04_rlv5_count	 =	mecha04_lv5_count	-	mecha04_lv4_count	;
        int mecha04_rlv6_count	 =	mecha04_lv6_count	-	mecha04_lv5_count	;
        if(	mecha04_int	>=	0	&&	mecha04_int	<	mecha04_lv1_count )	{mecha04_int =	mecha04_int													; tickets = tickets +	mecha04_int	*	mecha04_lv1_price	;	}
        if(	mecha04_int	>=	mecha04_lv1_count 	&&	mecha04_int	<	mecha04_lv2_count )	{mecha04_int =	mecha04_int	-	mecha04_rlv1_count 											; tickets = tickets +	mecha04_lv1_count	*	mecha04_lv1_price	+	mecha04_int	*	mecha04_lv2_price	;	}
        if(	mecha04_int	>=	mecha04_lv2_count	&&	mecha04_int	<	mecha04_lv3_count )	{mecha04_int =	mecha04_int	-	mecha04_rlv1_count 	-	mecha04_rlv2_count 									; tickets = tickets +	mecha04_lv1_count	*	mecha04_lv1_price	+	mecha04_rlv2_count	*	mecha04_lv2_price	+	mecha04_int	*	mecha04_lv3_price	;	}
        if(	mecha04_int	>=	mecha04_lv3_count	&&	mecha04_int	<	mecha04_lv4_count )	{mecha04_int =	mecha04_int	-	mecha04_rlv1_count 	-	mecha04_rlv2_count 	-	mecha04_rlv3_count 							; tickets = tickets +	mecha04_lv1_count	*	mecha04_lv1_price	+	mecha04_rlv2_count	*	mecha04_lv2_price	+	mecha04_rlv3_count	*	mecha04_lv3_price	+	mecha04_int	*	mecha04_lv4_price	;	}
        if(	mecha04_int	>=	mecha04_lv4_count	&&	mecha04_int	<	mecha04_lv5_count )	{mecha04_int =	mecha04_int	-	mecha04_rlv1_count 	-	mecha04_rlv2_count 	-	mecha04_rlv3_count 	-	mecha04_rlv4_count 					; tickets = tickets +	mecha04_lv1_count	*	mecha04_lv1_price	+	mecha04_rlv2_count	*	mecha04_lv2_price	+	mecha04_rlv3_count	*	mecha04_lv3_price	+	mecha04_rlv4_count	*	mecha04_lv4_price	+	mecha04_int	*	mecha04_lv5_price	;	}
        if(	mecha04_int	>=	mecha04_lv5_count	&&	mecha04_int	<	mecha04_lv6_count )	{mecha04_int =	mecha04_int	-	mecha04_rlv1_count 	-	mecha04_rlv2_count 	-	mecha04_rlv3_count 	-	mecha04_rlv4_count 	-	mecha04_rlv5_count 			; tickets = tickets +	mecha04_lv1_count	*	mecha04_lv1_price	+	mecha04_rlv2_count	*	mecha04_lv2_price	+	mecha04_rlv3_count	*	mecha04_lv3_price	+	mecha04_rlv4_count	*	mecha04_lv4_price	+	mecha04_rlv5_count	*	mecha04_lv5_price	+	mecha04_int	*	mecha04_lv6_price	;	}
        if(	mecha04_int	>=	mecha04_lv6_count	|	mecha04_int	 ==	mecha04_lv6_count )	{mecha04_int =	mecha04_int	-	mecha04_rlv1_count 	-	mecha04_rlv2_count 	-	mecha04_rlv3_count 	-	mecha04_rlv4_count 	-	mecha04_rlv5_count 	 	; tickets = tickets +	mecha04_lv1_count	*	mecha04_lv1_price	+	mecha04_rlv2_count	*	mecha04_lv2_price	+	mecha04_rlv3_count	*	mecha04_lv3_price	+	mecha04_rlv4_count	*	mecha04_lv4_price	+	mecha04_rlv5_count	*	mecha04_lv5_price	+	mecha04_int	*	mecha04_lv6_price	;	}
        adapter.add("[MECHA] Battery 100 x"+prettyCount(mecha04_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_mecha04));adapter2.add(prettyCount(mecha04_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;
        // 20201219 Added
        int mecha05_int = Integer.parseInt(et.getText().toString());
        int mecha05_int_base = Integer.parseInt(et.getText().toString());
        if (mecha05_int > mecha05_lv4_count){mecha05_int = mecha05_int_base = mecha05_lv4_count; et.setText(String.valueOf(mecha05_lv4_count));}
        int mecha05_rlv1_count 	 =	mecha05_lv1_count 	;
        int mecha05_rlv2_count	 =	mecha05_lv2_count	-	mecha05_lv1_count	;
        int mecha05_rlv3_count	 =	mecha05_lv3_count	-	mecha05_lv2_count	;
        int mecha05_rlv4_count	 =	mecha05_lv4_count	-	mecha05_lv3_count	;
        if(	mecha05_int	>=	0	&&	mecha05_int	<	mecha05_lv1_count )	{mecha05_int =	mecha05_int													; tickets = tickets +	mecha05_int	*	mecha05_lv1_price	;	}
        if(	mecha05_int	>=	mecha05_lv1_count 	&&	mecha05_int	<	mecha05_lv2_count )	{mecha05_int =	mecha05_int	-	mecha05_rlv1_count 											; tickets = tickets +	mecha05_lv1_count	*	mecha05_lv1_price	+	mecha05_int	*	mecha05_lv2_price	;	}
        if(	mecha05_int	>=	mecha05_lv2_count	&&	mecha05_int	<	mecha05_lv3_count )	{mecha05_int =	mecha05_int	-	mecha05_rlv1_count 	-	mecha05_rlv2_count 									; tickets = tickets +	mecha05_lv1_count	*	mecha05_lv1_price	+	mecha05_rlv2_count	*	mecha05_lv2_price	+	mecha05_int	*	mecha05_lv3_price	;	}
        if(	mecha05_int	>=	mecha05_lv3_count	&&	mecha05_int	<	mecha05_lv4_count )	{mecha05_int =	mecha05_int	-	mecha05_rlv1_count 	-	mecha05_rlv2_count 	-	mecha05_rlv3_count 							; tickets = tickets +	mecha05_lv1_count	*	mecha05_lv1_price	+	mecha05_rlv2_count	*	mecha05_lv2_price	+	mecha05_rlv3_count	*	mecha05_lv3_price	+	mecha05_int	*	mecha05_lv4_price	;	}
        // ADD THIS INTO ALL NEW ITEMS !!!!!!! 20201220 LAST DUTY OF UPDATE
        if(	mecha05_int	>=	mecha05_lv4_count	|	mecha05_int	 ==	mecha05_lv4_count )	{mecha05_int =	mecha05_int	-	mecha05_rlv1_count 	-	mecha05_rlv2_count 	-	mecha05_rlv3_count 	 	; tickets = tickets +	mecha05_lv1_count	*	mecha05_lv1_price	+	mecha05_rlv2_count	*	mecha05_lv2_price	+	mecha05_rlv3_count	*	mecha05_lv3_price	+	mecha05_int	*	mecha05_lv4_price	;	}
        adapter.add("[MECHA] Battery 100 x"+prettyCount(mecha05_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_mecha05));adapter2.add(prettyCount(mecha05_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;

        //ARENA

        int arena01_int = Integer.parseInt(rune.getText().toString());
        int arena01_int_base = Integer.parseInt(rune.getText().toString());
        if (arena01_int > arena01_lv6_count){arena01_int = arena01_int_base = arena01_lv6_count; rune.setText(String.valueOf(arena01_lv6_count));}
        int arena01_rlv1_count 	 =	arena01_lv1_count 	;
        int arena01_rlv2_count	 =	arena01_lv2_count	-	arena01_lv1_count	;
        int arena01_rlv3_count	 =	arena01_lv3_count	-	arena01_lv2_count	;
        int arena01_rlv4_count	 =	arena01_lv4_count	-	arena01_lv3_count	;
        int arena01_rlv5_count	 =	arena01_lv5_count	-	arena01_lv4_count	;
        int arena01_rlv6_count	 =	arena01_lv6_count	-	arena01_lv5_count	;
        if(	arena01_int	>=	0	&&	arena01_int	<	arena01_lv1_count )	{arena01_int =	arena01_int													; tickets = tickets +	arena01_int	*	arena01_lv1_price	;	}
        if(	arena01_int	>=	arena01_lv1_count 	&&	arena01_int	<	arena01_lv2_count )	{arena01_int =	arena01_int	-	arena01_rlv1_count 											; tickets = tickets +	arena01_lv1_count	*	arena01_lv1_price	+	arena01_int	*	arena01_lv2_price	;	}
        if(	arena01_int	>=	arena01_lv2_count	&&	arena01_int	<	arena01_lv3_count )	{arena01_int =	arena01_int	-	arena01_rlv1_count 	-	arena01_rlv2_count 									; tickets = tickets +	arena01_lv1_count	*	arena01_lv1_price	+	arena01_rlv2_count	*	arena01_lv2_price	+	arena01_int	*	arena01_lv3_price	;	}
        if(	arena01_int	>=	arena01_lv3_count	&&	arena01_int	<	arena01_lv4_count )	{arena01_int =	arena01_int	-	arena01_rlv1_count 	-	arena01_rlv2_count 	-	arena01_rlv3_count 							; tickets = tickets +	arena01_lv1_count	*	arena01_lv1_price	+	arena01_rlv2_count	*	arena01_lv2_price	+	arena01_rlv3_count	*	arena01_lv3_price	+	arena01_int	*	arena01_lv4_price	;	}
        if(	arena01_int	>=	arena01_lv4_count	&&	arena01_int	<	arena01_lv5_count )	{arena01_int =	arena01_int	-	arena01_rlv1_count 	-	arena01_rlv2_count 	-	arena01_rlv3_count 	-	arena01_rlv4_count 					; tickets = tickets +	arena01_lv1_count	*	arena01_lv1_price	+	arena01_rlv2_count	*	arena01_lv2_price	+	arena01_rlv3_count	*	arena01_lv3_price	+	arena01_rlv4_count	*	arena01_lv4_price	+	arena01_int	*	arena01_lv5_price	;	}
        if(	arena01_int	>=	arena01_lv5_count	&&	arena01_int	<	arena01_lv6_count )	{arena01_int =	arena01_int	-	arena01_rlv1_count 	-	arena01_rlv2_count 	-	arena01_rlv3_count 	-	arena01_rlv4_count 	-	arena01_rlv5_count 			; tickets = tickets +	arena01_lv1_count	*	arena01_lv1_price	+	arena01_rlv2_count	*	arena01_lv2_price	+	arena01_rlv3_count	*	arena01_lv3_price	+	arena01_rlv4_count	*	arena01_lv4_price	+	arena01_rlv5_count	*	arena01_lv5_price	+	arena01_int	*	arena01_lv6_price	;	}
        if(	arena01_int	>=	arena01_lv6_count	|	arena01_int	 ==	arena01_lv6_count )	{arena01_int =	arena01_int	-	arena01_rlv1_count 	-	arena01_rlv2_count 	-	arena01_rlv3_count 	-	arena01_rlv4_count 	-	arena01_rlv5_count 	 	; tickets = tickets +	arena01_lv1_count	*	arena01_lv1_price	+	arena01_rlv2_count	*	arena01_lv2_price	+	arena01_rlv3_count	*	arena01_lv3_price	+	arena01_rlv4_count	*	arena01_lv4_price	+	arena01_rlv5_count	*	arena01_lv5_price	+	arena01_int	*	arena01_lv6_price	;	}
        adapter.add("[ARENA] Rune Box x"+prettyCount(arena01_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_arena01));adapter2.add(prettyCount(arena01_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;

        int arena02_int = Integer.parseInt(runep.getText().toString());
        int arena02_int_base = Integer.parseInt(runep.getText().toString());
        if (arena02_int > arena02_lv6_count){arena02_int = arena02_int_base = arena02_lv6_count; runep.setText(String.valueOf(arena02_lv6_count));}
        int arena02_rlv1_count 	 =	arena02_lv1_count 	;
        int arena02_rlv2_count	 =	arena02_lv2_count	-	arena02_lv1_count	;
        int arena02_rlv3_count	 =	arena02_lv3_count	-	arena02_lv2_count	;
        int arena02_rlv4_count	 =	arena02_lv4_count	-	arena02_lv3_count	;
        int arena02_rlv5_count	 =	arena02_lv5_count	-	arena02_lv4_count	;
        int arena02_rlv6_count	 =	arena02_lv6_count	-	arena02_lv5_count	;
        if(	arena02_int	>=	0	&&	arena02_int	<	arena02_lv1_count )	{arena02_int =	arena02_int													; tickets = tickets +	arena02_int	*	arena02_lv1_price	;	}
        if(	arena02_int	>=	arena02_lv1_count 	&&	arena02_int	<	arena02_lv2_count )	{arena02_int =	arena02_int	-	arena02_rlv1_count 											; tickets = tickets +	arena02_lv1_count	*	arena02_lv1_price	+	arena02_int	*	arena02_lv2_price	;	}
        if(	arena02_int	>=	arena02_lv2_count	&&	arena02_int	<	arena02_lv3_count )	{arena02_int =	arena02_int	-	arena02_rlv1_count 	-	arena02_rlv2_count 									; tickets = tickets +	arena02_lv1_count	*	arena02_lv1_price	+	arena02_rlv2_count	*	arena02_lv2_price	+	arena02_int	*	arena02_lv3_price	;	}
        if(	arena02_int	>=	arena02_lv3_count	&&	arena02_int	<	arena02_lv4_count )	{arena02_int =	arena02_int	-	arena02_rlv1_count 	-	arena02_rlv2_count 	-	arena02_rlv3_count 							; tickets = tickets +	arena02_lv1_count	*	arena02_lv1_price	+	arena02_rlv2_count	*	arena02_lv2_price	+	arena02_rlv3_count	*	arena02_lv3_price	+	arena02_int	*	arena02_lv4_price	;	}
        if(	arena02_int	>=	arena02_lv4_count	&&	arena02_int	<	arena02_lv5_count )	{arena02_int =	arena02_int	-	arena02_rlv1_count 	-	arena02_rlv2_count 	-	arena02_rlv3_count 	-	arena02_rlv4_count 					; tickets = tickets +	arena02_lv1_count	*	arena02_lv1_price	+	arena02_rlv2_count	*	arena02_lv2_price	+	arena02_rlv3_count	*	arena02_lv3_price	+	arena02_rlv4_count	*	arena02_lv4_price	+	arena02_int	*	arena02_lv5_price	;	}
        if(	arena02_int	>=	arena02_lv5_count	&&	arena02_int	<	arena02_lv6_count )	{arena02_int =	arena02_int	-	arena02_rlv1_count 	-	arena02_rlv2_count 	-	arena02_rlv3_count 	-	arena02_rlv4_count 	-	arena02_rlv5_count 			; tickets = tickets +	arena02_lv1_count	*	arena02_lv1_price	+	arena02_rlv2_count	*	arena02_lv2_price	+	arena02_rlv3_count	*	arena02_lv3_price	+	arena02_rlv4_count	*	arena02_lv4_price	+	arena02_rlv5_count	*	arena02_lv5_price	+	arena02_int	*	arena02_lv6_price	;	}
        if(	arena02_int	>=	arena02_lv6_count	|	arena02_int	 ==	arena02_lv6_count )	{arena02_int =	arena02_int	-	arena02_rlv1_count 	-	arena02_rlv2_count 	-	arena02_rlv3_count 	-	arena02_rlv4_count 	-	arena02_rlv5_count 	 	; tickets = tickets +	arena02_lv1_count	*	arena02_lv1_price	+	arena02_rlv2_count	*	arena02_lv2_price	+	arena02_rlv3_count	*	arena02_lv3_price	+	arena02_rlv4_count	*	arena02_lv4_price	+	arena02_rlv5_count	*	arena02_lv5_price	+	arena02_int	*	arena02_lv6_price	;	}
        adapter.add("[ARENA] Rune Point 100 x"+prettyCount(arena02_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_arena02));adapter2.add(prettyCount(arena02_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;

        int arena03_int = Integer.parseInt(box.getText().toString());
        int arena03_int_base = Integer.parseInt(box.getText().toString());
        if (arena03_int > arena03_lv6_count){arena03_int = arena03_int_base = arena03_lv6_count; box.setText(String.valueOf(arena03_lv6_count));}
        int arena03_rlv1_count 	 =	arena03_lv1_count 	;
        int arena03_rlv2_count	 =	arena03_lv2_count	-	arena03_lv1_count	;
        int arena03_rlv3_count	 =	arena03_lv3_count	-	arena03_lv2_count	;
        int arena03_rlv4_count	 =	arena03_lv4_count	-	arena03_lv3_count	;
        int arena03_rlv5_count	 =	arena03_lv5_count	-	arena03_lv4_count	;
        int arena03_rlv6_count	 =	arena03_lv6_count	-	arena03_lv5_count	;
        if(	arena03_int	>=	0	&&	arena03_int	<	arena03_lv1_count )	{arena03_int =	arena03_int													; tickets = tickets +	arena03_int	*	arena03_lv1_price	;	}
        if(	arena03_int	>=	arena03_lv1_count 	&&	arena03_int	<	arena03_lv2_count )	{arena03_int =	arena03_int	-	arena03_rlv1_count 											; tickets = tickets +	arena03_lv1_count	*	arena03_lv1_price	+	arena03_int	*	arena03_lv2_price	;	}
        if(	arena03_int	>=	arena03_lv2_count	&&	arena03_int	<	arena03_lv3_count )	{arena03_int =	arena03_int	-	arena03_rlv1_count 	-	arena03_rlv2_count 									; tickets = tickets +	arena03_lv1_count	*	arena03_lv1_price	+	arena03_rlv2_count	*	arena03_lv2_price	+	arena03_int	*	arena03_lv3_price	;	}
        if(	arena03_int	>=	arena03_lv3_count	&&	arena03_int	<	arena03_lv4_count )	{arena03_int =	arena03_int	-	arena03_rlv1_count 	-	arena03_rlv2_count 	-	arena03_rlv3_count 							; tickets = tickets +	arena03_lv1_count	*	arena03_lv1_price	+	arena03_rlv2_count	*	arena03_lv2_price	+	arena03_rlv3_count	*	arena03_lv3_price	+	arena03_int	*	arena03_lv4_price	;	}
        if(	arena03_int	>=	arena03_lv4_count	&&	arena03_int	<	arena03_lv5_count )	{arena03_int =	arena03_int	-	arena03_rlv1_count 	-	arena03_rlv2_count 	-	arena03_rlv3_count 	-	arena03_rlv4_count 					; tickets = tickets +	arena03_lv1_count	*	arena03_lv1_price	+	arena03_rlv2_count	*	arena03_lv2_price	+	arena03_rlv3_count	*	arena03_lv3_price	+	arena03_rlv4_count	*	arena03_lv4_price	+	arena03_int	*	arena03_lv5_price	;	}
        if(	arena03_int	>=	arena03_lv5_count	&&	arena03_int	<	arena03_lv6_count )	{arena03_int =	arena03_int	-	arena03_rlv1_count 	-	arena03_rlv2_count 	-	arena03_rlv3_count 	-	arena03_rlv4_count 	-	arena03_rlv5_count 			; tickets = tickets +	arena03_lv1_count	*	arena03_lv1_price	+	arena03_rlv2_count	*	arena03_lv2_price	+	arena03_rlv3_count	*	arena03_lv3_price	+	arena03_rlv4_count	*	arena03_lv4_price	+	arena03_rlv5_count	*	arena03_lv5_price	+	arena03_int	*	arena03_lv6_price	;	}
        if(	arena03_int	>=	arena03_lv6_count	|	arena03_int	 ==	arena03_lv6_count )	{arena03_int =	arena03_int	-	arena03_rlv1_count 	-	arena03_rlv2_count 	-	arena03_rlv3_count 	-	arena03_rlv4_count 	-	arena03_rlv5_count 	 	; tickets = tickets +	arena03_lv1_count	*	arena03_lv1_price	+	arena03_rlv2_count	*	arena03_lv2_price	+	arena03_rlv3_count	*	arena03_lv3_price	+	arena03_rlv4_count	*	arena03_lv4_price	+	arena03_rlv5_count	*	arena03_lv5_price	+	arena03_int	*	arena03_lv6_price	;	}
        adapter.add("[ARENA] Equipment Box x"+prettyCount(arena03_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_arena03));adapter2.add(prettyCount(arena03_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;

        int arena04_int = Integer.parseInt(starstone.getText().toString());
        int arena04_int_base = Integer.parseInt(starstone.getText().toString());
        if (arena04_int > arena04_lv6_count){arena04_int = arena04_int_base = arena04_lv6_count; starstone.setText(String.valueOf(arena04_lv6_count));}
        int arena04_rlv1_count 	 =	arena04_lv1_count 	;
        int arena04_rlv2_count	 =	arena04_lv2_count	-	arena04_lv1_count	;
        int arena04_rlv3_count	 =	arena04_lv3_count	-	arena04_lv2_count	;
        int arena04_rlv4_count	 =	arena04_lv4_count	-	arena04_lv3_count	;
        int arena04_rlv5_count	 =	arena04_lv5_count	-	arena04_lv4_count	;
        int arena04_rlv6_count	 =	arena04_lv6_count	-	arena04_lv5_count	;
        if(	arena04_int	>=	0	&&	arena04_int	<	arena04_lv1_count )	{arena04_int =	arena04_int													; tickets = tickets +	arena04_int	*	arena04_lv1_price	;	}
        if(	arena04_int	>=	arena04_lv1_count 	&&	arena04_int	<	arena04_lv2_count )	{arena04_int =	arena04_int	-	arena04_rlv1_count 											; tickets = tickets +	arena04_lv1_count	*	arena04_lv1_price	+	arena04_int	*	arena04_lv2_price	;	}
        if(	arena04_int	>=	arena04_lv2_count	&&	arena04_int	<	arena04_lv3_count )	{arena04_int =	arena04_int	-	arena04_rlv1_count 	-	arena04_rlv2_count 									; tickets = tickets +	arena04_lv1_count	*	arena04_lv1_price	+	arena04_rlv2_count	*	arena04_lv2_price	+	arena04_int	*	arena04_lv3_price	;	}
        if(	arena04_int	>=	arena04_lv3_count	&&	arena04_int	<	arena04_lv4_count )	{arena04_int =	arena04_int	-	arena04_rlv1_count 	-	arena04_rlv2_count 	-	arena04_rlv3_count 							; tickets = tickets +	arena04_lv1_count	*	arena04_lv1_price	+	arena04_rlv2_count	*	arena04_lv2_price	+	arena04_rlv3_count	*	arena04_lv3_price	+	arena04_int	*	arena04_lv4_price	;	}
        if(	arena04_int	>=	arena04_lv4_count	&&	arena04_int	<	arena04_lv5_count )	{arena04_int =	arena04_int	-	arena04_rlv1_count 	-	arena04_rlv2_count 	-	arena04_rlv3_count 	-	arena04_rlv4_count 					; tickets = tickets +	arena04_lv1_count	*	arena04_lv1_price	+	arena04_rlv2_count	*	arena04_lv2_price	+	arena04_rlv3_count	*	arena04_lv3_price	+	arena04_rlv4_count	*	arena04_lv4_price	+	arena04_int	*	arena04_lv5_price	;	}
        if(	arena04_int	>=	arena04_lv5_count	&&	arena04_int	<	arena04_lv6_count )	{arena04_int =	arena04_int	-	arena04_rlv1_count 	-	arena04_rlv2_count 	-	arena04_rlv3_count 	-	arena04_rlv4_count 	-	arena04_rlv5_count 			; tickets = tickets +	arena04_lv1_count	*	arena04_lv1_price	+	arena04_rlv2_count	*	arena04_lv2_price	+	arena04_rlv3_count	*	arena04_lv3_price	+	arena04_rlv4_count	*	arena04_lv4_price	+	arena04_rlv5_count	*	arena04_lv5_price	+	arena04_int	*	arena04_lv6_price	;	}
        if(	arena04_int	>=	arena04_lv6_count	|	arena04_int	 ==	arena04_lv6_count )	{arena04_int =	arena04_int	-	arena04_rlv1_count 	-	arena04_rlv2_count 	-	arena04_rlv3_count 	-	arena04_rlv4_count 	-	arena04_rlv5_count 	 	; tickets = tickets +	arena04_lv1_count	*	arena04_lv1_price	+	arena04_rlv2_count	*	arena04_lv2_price	+	arena04_rlv3_count	*	arena04_lv3_price	+	arena04_rlv4_count	*	arena04_lv4_price	+	arena04_rlv5_count	*	arena04_lv5_price	+	arena04_int	*	arena04_lv6_price	;	}
        adapter.add("[ARENA] Star Stone I 100 x"+prettyCount(arena04_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_arena04));adapter2.add(prettyCount(arena04_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;

        int arena05_int = Integer.parseInt(lucky.getText().toString());
        int arena05_int_base = Integer.parseInt(lucky.getText().toString());
        if (arena05_int > arena05_lv6_count){arena05_int = arena05_int_base = arena05_lv6_count; lucky.setText(String.valueOf(arena05_lv6_count));}
        int arena05_rlv1_count 	 =	arena05_lv1_count 	;
        int arena05_rlv2_count	 =	arena05_lv2_count	-	arena05_lv1_count	;
        int arena05_rlv3_count	 =	arena05_lv3_count	-	arena05_lv2_count	;
        int arena05_rlv4_count	 =	arena05_lv4_count	-	arena05_lv3_count	;
        int arena05_rlv5_count	 =	arena05_lv5_count	-	arena05_lv4_count	;
        int arena05_rlv6_count	 =	arena05_lv6_count	-	arena05_lv5_count	;
        if(	arena05_int	>=	0	&&	arena05_int	<	arena05_lv1_count )	{arena05_int =	arena05_int													; tickets = tickets +	arena05_int	*	arena05_lv1_price	;	}
        if(	arena05_int	>=	arena05_lv1_count 	&&	arena05_int	<	arena05_lv2_count )	{arena05_int =	arena05_int	-	arena05_rlv1_count 											; tickets = tickets +	arena05_lv1_count	*	arena05_lv1_price	+	arena05_int	*	arena05_lv2_price	;	}
        if(	arena05_int	>=	arena05_lv2_count	&&	arena05_int	<	arena05_lv3_count )	{arena05_int =	arena05_int	-	arena05_rlv1_count 	-	arena05_rlv2_count 									; tickets = tickets +	arena05_lv1_count	*	arena05_lv1_price	+	arena05_rlv2_count	*	arena05_lv2_price	+	arena05_int	*	arena05_lv3_price	;	}
        if(	arena05_int	>=	arena05_lv3_count	&&	arena05_int	<	arena05_lv4_count )	{arena05_int =	arena05_int	-	arena05_rlv1_count 	-	arena05_rlv2_count 	-	arena05_rlv3_count 							; tickets = tickets +	arena05_lv1_count	*	arena05_lv1_price	+	arena05_rlv2_count	*	arena05_lv2_price	+	arena05_rlv3_count	*	arena05_lv3_price	+	arena05_int	*	arena05_lv4_price	;	}
        if(	arena05_int	>=	arena05_lv4_count	&&	arena05_int	<	arena05_lv5_count )	{arena05_int =	arena05_int	-	arena05_rlv1_count 	-	arena05_rlv2_count 	-	arena05_rlv3_count 	-	arena05_rlv4_count 					; tickets = tickets +	arena05_lv1_count	*	arena05_lv1_price	+	arena05_rlv2_count	*	arena05_lv2_price	+	arena05_rlv3_count	*	arena05_lv3_price	+	arena05_rlv4_count	*	arena05_lv4_price	+	arena05_int	*	arena05_lv5_price	;	}
        if(	arena05_int	>=	arena05_lv5_count	&&	arena05_int	<	arena05_lv6_count )	{arena05_int =	arena05_int	-	arena05_rlv1_count 	-	arena05_rlv2_count 	-	arena05_rlv3_count 	-	arena05_rlv4_count 	-	arena05_rlv5_count 			; tickets = tickets +	arena05_lv1_count	*	arena05_lv1_price	+	arena05_rlv2_count	*	arena05_lv2_price	+	arena05_rlv3_count	*	arena05_lv3_price	+	arena05_rlv4_count	*	arena05_lv4_price	+	arena05_rlv5_count	*	arena05_lv5_price	+	arena05_int	*	arena05_lv6_price	;	}
        if(	arena05_int	>=	arena05_lv6_count	|	arena05_int	 ==	arena05_lv6_count )	{arena05_int =	arena05_int	-	arena05_rlv1_count 	-	arena05_rlv2_count 	-	arena05_rlv3_count 	-	arena05_rlv4_count 	-	arena05_rlv5_count 	 	; tickets = tickets +	arena05_lv1_count	*	arena05_lv1_price	+	arena05_rlv2_count	*	arena05_lv2_price	+	arena05_rlv3_count	*	arena05_lv3_price	+	arena05_rlv4_count	*	arena05_lv4_price	+	arena05_rlv5_count	*	arena05_lv5_price	+	arena05_int	*	arena05_lv6_price	;	}
        adapter.add("[ARENA] Lucky Ticket x"+prettyCount(arena05_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_arena05));adapter2.add(prettyCount(arena05_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;

        int arena06_int = Integer.parseInt(azbag.getText().toString());
        int arena06_int_base = Integer.parseInt(azbag.getText().toString());
        if (arena06_int > arena06_lv6_count){arena06_int = arena06_int_base = arena06_lv6_count; azbag.setText(String.valueOf(arena06_lv6_count));}
        int arena06_rlv1_count 	 =	arena06_lv1_count 	;
        int arena06_rlv2_count	 =	arena06_lv2_count	-	arena06_lv1_count	;
        int arena06_rlv3_count	 =	arena06_lv3_count	-	arena06_lv2_count	;
        int arena06_rlv4_count	 =	arena06_lv4_count	-	arena06_lv3_count	;
        int arena06_rlv5_count	 =	arena06_lv5_count	-	arena06_lv4_count	;
        int arena06_rlv6_count	 =	arena06_lv6_count	-	arena06_lv5_count	;
        if(	arena06_int	>=	0	&&	arena06_int	<	arena06_lv1_count )	{arena06_int =	arena06_int													; tickets = tickets +	arena06_int	*	arena06_lv1_price	;	}
        if(	arena06_int	>=	arena06_lv1_count 	&&	arena06_int	<	arena06_lv2_count )	{arena06_int =	arena06_int	-	arena06_rlv1_count 											; tickets = tickets +	arena06_lv1_count	*	arena06_lv1_price	+	arena06_int	*	arena06_lv2_price	;	}
        if(	arena06_int	>=	arena06_lv2_count	&&	arena06_int	<	arena06_lv3_count )	{arena06_int =	arena06_int	-	arena06_rlv1_count 	-	arena06_rlv2_count 									; tickets = tickets +	arena06_lv1_count	*	arena06_lv1_price	+	arena06_rlv2_count	*	arena06_lv2_price	+	arena06_int	*	arena06_lv3_price	;	}
        if(	arena06_int	>=	arena06_lv3_count	&&	arena06_int	<	arena06_lv4_count )	{arena06_int =	arena06_int	-	arena06_rlv1_count 	-	arena06_rlv2_count 	-	arena06_rlv3_count 							; tickets = tickets +	arena06_lv1_count	*	arena06_lv1_price	+	arena06_rlv2_count	*	arena06_lv2_price	+	arena06_rlv3_count	*	arena06_lv3_price	+	arena06_int	*	arena06_lv4_price	;	}
        if(	arena06_int	>=	arena06_lv4_count	&&	arena06_int	<	arena06_lv5_count )	{arena06_int =	arena06_int	-	arena06_rlv1_count 	-	arena06_rlv2_count 	-	arena06_rlv3_count 	-	arena06_rlv4_count 					; tickets = tickets +	arena06_lv1_count	*	arena06_lv1_price	+	arena06_rlv2_count	*	arena06_lv2_price	+	arena06_rlv3_count	*	arena06_lv3_price	+	arena06_rlv4_count	*	arena06_lv4_price	+	arena06_int	*	arena06_lv5_price	;	}
        if(	arena06_int	>=	arena06_lv5_count	&&	arena06_int	<	arena06_lv6_count )	{arena06_int =	arena06_int	-	arena06_rlv1_count 	-	arena06_rlv2_count 	-	arena06_rlv3_count 	-	arena06_rlv4_count 	-	arena06_rlv5_count 			; tickets = tickets +	arena06_lv1_count	*	arena06_lv1_price	+	arena06_rlv2_count	*	arena06_lv2_price	+	arena06_rlv3_count	*	arena06_lv3_price	+	arena06_rlv4_count	*	arena06_lv4_price	+	arena06_rlv5_count	*	arena06_lv5_price	+	arena06_int	*	arena06_lv6_price	;	}
        if(	arena06_int	>=	arena06_lv6_count	|	arena06_int	 ==	arena06_lv6_count )	{arena06_int =	arena06_int	-	arena06_rlv1_count 	-	arena06_rlv2_count 	-	arena06_rlv3_count 	-	arena06_rlv4_count 	-	arena06_rlv5_count 	 	; tickets = tickets +	arena06_lv1_count	*	arena06_lv1_price	+	arena06_rlv2_count	*	arena06_lv2_price	+	arena06_rlv3_count	*	arena06_lv3_price	+	arena06_rlv4_count	*	arena06_lv4_price	+	arena06_rlv5_count	*	arena06_lv5_price	+	arena06_int	*	arena06_lv6_price	;	}
        adapter.add("[ARENA] Advanced Zbag x"+prettyCount(arena06_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_arena06));adapter2.add(prettyCount(arena06_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;
        // 20201219 Added
        int arena07_int = Integer.parseInt(arsb.getText().toString());
        int arena07_int_base = Integer.parseInt(arsb.getText().toString());
        if (arena07_int > arena07_lv6_count){arena07_int = arena07_int_base = arena07_lv6_count; arsb.setText(String.valueOf(arena07_lv6_count));}
        int arena07_rlv1_count 	 =	arena07_lv1_count 	;
        int arena07_rlv2_count	 =	arena07_lv2_count	-	arena07_lv1_count	;
        int arena07_rlv3_count	 =	arena07_lv3_count	-	arena07_lv2_count	;
        int arena07_rlv4_count	 =	arena07_lv4_count	-	arena07_lv3_count	;
        int arena07_rlv5_count	 =	arena07_lv5_count	-	arena07_lv4_count	;
        int arena07_rlv6_count	 =	arena07_lv6_count	-	arena07_lv5_count	;
        if(	arena07_int	>=	0	&&	arena07_int	<	arena07_lv1_count )	{arena07_int =	arena07_int													; tickets = tickets +	arena07_int	*	arena07_lv1_price	;	}
        if(	arena07_int	>=	arena07_lv1_count 	&&	arena07_int	<	arena07_lv2_count )	{arena07_int =	arena07_int	-	arena07_rlv1_count 											; tickets = tickets +	arena07_lv1_count	*	arena07_lv1_price	+	arena07_int	*	arena07_lv2_price	;	}
        if(	arena07_int	>=	arena07_lv2_count	&&	arena07_int	<	arena07_lv3_count )	{arena07_int =	arena07_int	-	arena07_rlv1_count 	-	arena07_rlv2_count 									; tickets = tickets +	arena07_lv1_count	*	arena07_lv1_price	+	arena07_rlv2_count	*	arena07_lv2_price	+	arena07_int	*	arena07_lv3_price	;	}
        if(	arena07_int	>=	arena07_lv3_count	&&	arena07_int	<	arena07_lv4_count )	{arena07_int =	arena07_int	-	arena07_rlv1_count 	-	arena07_rlv2_count 	-	arena07_rlv3_count 							; tickets = tickets +	arena07_lv1_count	*	arena07_lv1_price	+	arena07_rlv2_count	*	arena07_lv2_price	+	arena07_rlv3_count	*	arena07_lv3_price	+	arena07_int	*	arena07_lv4_price	;	}
        if(	arena07_int	>=	arena07_lv4_count	&&	arena07_int	<	arena07_lv5_count )	{arena07_int =	arena07_int	-	arena07_rlv1_count 	-	arena07_rlv2_count 	-	arena07_rlv3_count 	-	arena07_rlv4_count 					; tickets = tickets +	arena07_lv1_count	*	arena07_lv1_price	+	arena07_rlv2_count	*	arena07_lv2_price	+	arena07_rlv3_count	*	arena07_lv3_price	+	arena07_rlv4_count	*	arena07_lv4_price	+	arena07_int	*	arena07_lv5_price	;	}
        if(	arena07_int	>=	arena07_lv5_count	&&	arena07_int	<	arena07_lv6_count )	{arena07_int =	arena07_int	-	arena07_rlv1_count 	-	arena07_rlv2_count 	-	arena07_rlv3_count 	-	arena07_rlv4_count 	-	arena07_rlv5_count 			; tickets = tickets +	arena07_lv1_count	*	arena07_lv1_price	+	arena07_rlv2_count	*	arena07_lv2_price	+	arena07_rlv3_count	*	arena07_lv3_price	+	arena07_rlv4_count	*	arena07_lv4_price	+	arena07_rlv5_count	*	arena07_lv5_price	+	arena07_int	*	arena07_lv6_price	;	}
        if(	arena07_int	>=	arena07_lv6_count	|	arena07_int	 ==	arena07_lv6_count )	{arena07_int =	arena07_int	-	arena07_rlv1_count 	-	arena07_rlv2_count 	-	arena07_rlv3_count 	-	arena07_rlv4_count 	-	arena07_rlv5_count 	 	; tickets = tickets +	arena07_lv1_count	*	arena07_lv1_price	+	arena07_rlv2_count	*	arena07_lv2_price	+	arena07_rlv3_count	*	arena07_lv3_price	+	arena07_rlv4_count	*	arena07_lv4_price	+	arena07_rlv5_count	*	arena07_lv5_price	+	arena07_int	*	arena07_lv6_price	;	}
        adapter.add("[ARENA] Star Stone I 100 x"+prettyCount(arena07_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_arena07));adapter2.add(prettyCount(arena07_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;

        int arena08_int = Integer.parseInt(ab.getText().toString());
        int arena08_int_base = Integer.parseInt(ab.getText().toString());
        if (arena08_int > arena08_lv3_count){arena08_int = arena08_int_base = arena08_lv3_count; ab.setText(String.valueOf(arena08_lv3_count));}
        int arena08_rlv1_count 	 =	arena08_lv1_count 	;
        int arena08_rlv2_count	 =	arena08_lv2_count	-	arena08_lv1_count	;
        int arena08_rlv3_count	 =	arena08_lv3_count	-	arena08_lv2_count	;
        if(	arena08_int	>=	0	&&	arena08_int	<	arena08_lv1_count )	{arena08_int =	arena08_int													; tickets = tickets +	arena08_int	*	arena08_lv1_price	;	}
        if(	arena08_int	>=	arena08_lv1_count 	&&	arena08_int	<	arena08_lv2_count )	{arena08_int =	arena08_int	-	arena08_rlv1_count 											; tickets = tickets +	arena08_lv1_count	*	arena08_lv1_price	+	arena08_int	*	arena08_lv2_price	;	}
        if(	arena08_int	>=	arena08_lv2_count	&&	arena08_int	<	arena08_lv3_count )	{arena08_int =	arena08_int	-	arena08_rlv1_count 	-	arena08_rlv2_count 									; tickets = tickets +	arena08_lv1_count	*	arena08_lv1_price	+	arena08_rlv2_count	*	arena08_lv2_price	+	arena08_int	*	arena08_lv3_price	;	}
        if(	arena08_int	>=	arena08_lv3_count	|	arena08_int	 ==	arena08_lv3_count )	{arena08_int =	arena08_int	-	arena08_rlv1_count 	-	arena08_rlv2_count 	-	arena08_rlv3_count 	 		 	; tickets = tickets +	arena08_lv1_count	*	arena08_lv1_price	+	arena08_rlv2_count	*	arena08_lv2_price	+	arena08_int	*	arena08_lv3_price	;	}
        adapter.add("[ARENA] Lucky Ticket x"+prettyCount(arena08_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_arena08));adapter2.add(prettyCount(arena08_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;

        int arena09_int = Integer.parseInt(pmc.getText().toString());
        int arena09_int_base = Integer.parseInt(pmc.getText().toString());
        if (arena09_int > arena09_lv3_count){arena09_int = arena09_int_base = arena09_lv3_count; pmc.setText(String.valueOf(arena09_lv3_count));}
        int arena09_rlv1_count 	 =	arena09_lv1_count 	;
        int arena09_rlv2_count	 =	arena09_lv2_count	-	arena09_lv1_count	;
        int arena09_rlv3_count	 =	arena09_lv3_count	-	arena09_lv2_count	;
        if(	arena09_int	>=	0	&&	arena09_int	<	arena09_lv1_count )	{arena09_int =	arena09_int													; tickets = tickets +	arena09_int	*	arena09_lv1_price	;	}
        if(	arena09_int	>=	arena09_lv1_count 	&&	arena09_int	<	arena09_lv2_count )	{arena09_int =	arena09_int	-	arena09_rlv1_count 											; tickets = tickets +	arena09_lv1_count	*	arena09_lv1_price	+	arena09_int	*	arena09_lv2_price	;	}
        if(	arena09_int	>=	arena09_lv2_count	&&	arena09_int	<	arena09_lv3_count )	{arena09_int =	arena09_int	-	arena09_rlv1_count 	-	arena09_rlv2_count 									; tickets = tickets +	arena09_lv1_count	*	arena09_lv1_price	+	arena09_rlv2_count	*	arena09_lv2_price	+	arena09_int	*	arena09_lv3_price	;	}
        if(	arena09_int	>=	arena09_lv3_count	|	arena09_int	 ==	arena09_lv3_count )	{arena09_int =	arena09_int	-	arena09_rlv1_count 	-	arena09_rlv2_count 	-	arena09_rlv3_count 	 		 	; tickets = tickets +	arena09_lv1_count	*	arena09_lv1_price	+	arena09_rlv2_count	*	arena09_lv2_price	+	arena09_int	*	arena09_lv3_price	;	}
        adapter.add("[ARENA] Advanced Zbag x"+prettyCount(arena09_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_arena09));adapter2.add(prettyCount(arena09_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;

        int arena10_int = Integer.parseInt(porb.getText().toString());
        int arena10_int_base = Integer.parseInt(porb.getText().toString());
        if (arena10_int > arena10_lv3_count){arena10_int = arena10_int_base = arena10_lv3_count; porb.setText(String.valueOf(arena10_lv3_count));}
        int arena10_rlv1_count 	 =	arena10_lv1_count 	;
        int arena10_rlv2_count	 =	arena10_lv2_count	-	arena10_lv1_count	;
        int arena10_rlv3_count	 =	arena10_lv3_count	-	arena10_lv2_count	;
        if(	arena10_int	>=	0	&&	arena10_int	<	arena10_lv1_count )	{arena10_int =	arena10_int													; tickets = tickets +	arena10_int	*	arena10_lv1_price	;	}
        if(	arena10_int	>=	arena10_lv1_count 	&&	arena10_int	<	arena10_lv2_count )	{arena10_int =	arena10_int	-	arena10_rlv1_count 											; tickets = tickets +	arena10_lv1_count	*	arena10_lv1_price	+	arena10_int	*	arena10_lv2_price	;	}
        if(	arena10_int	>=	arena10_lv2_count	&&	arena10_int	<	arena10_lv3_count )	{arena10_int =	arena10_int	-	arena10_rlv1_count 	-	arena10_rlv2_count 									; tickets = tickets +	arena10_lv1_count	*	arena10_lv1_price	+	arena10_rlv2_count	*	arena10_lv2_price	+	arena10_int	*	arena10_lv3_price	;	}
        if(	arena10_int	>=	arena10_lv3_count	|	arena10_int	 ==	arena10_lv3_count )	{arena10_int =	arena10_int	-	arena10_rlv1_count 	-	arena10_rlv2_count 	-	arena10_rlv3_count 	 		 	; tickets = tickets +	arena10_lv1_count	*	arena10_lv1_price	+	arena10_rlv2_count	*	arena10_lv2_price	+	arena10_int	*	arena10_lv3_price	;	}
        adapter.add("[ARENA] Star Stone I 100 x"+prettyCount(arena10_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_arena10));adapter2.add(prettyCount(arena10_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;

        int arena11_int = Integer.parseInt(crystal.getText().toString());
        int arena11_int_base = Integer.parseInt(crystal.getText().toString());
        if (arena11_int > arena11_lv3_count){arena11_int = arena11_int_base = arena11_lv3_count; crystal.setText(String.valueOf(arena11_lv3_count));}
        int arena11_rlv1_count 	 =	arena11_lv1_count 	;
        int arena11_rlv2_count	 =	arena11_lv2_count	-	arena11_lv1_count	;
        int arena11_rlv3_count	 =	arena11_lv3_count	-	arena11_lv2_count	;
        if(	arena11_int	>=	0	&&	arena11_int	<	arena11_lv1_count )	{arena11_int =	arena11_int													; tickets = tickets +	arena11_int	*	arena11_lv1_price	;	}
        if(	arena11_int	>=	arena11_lv1_count 	&&	arena11_int	<	arena11_lv2_count )	{arena11_int =	arena11_int	-	arena11_rlv1_count 											; tickets = tickets +	arena11_lv1_count	*	arena11_lv1_price	+	arena11_int	*	arena11_lv2_price	;	}
        if(	arena11_int	>=	arena11_lv2_count	&&	arena11_int	<	arena11_lv3_count )	{arena11_int =	arena11_int	-	arena11_rlv1_count 	-	arena11_rlv2_count 									; tickets = tickets +	arena11_lv1_count	*	arena11_lv1_price	+	arena11_rlv2_count	*	arena11_lv2_price	+	arena11_int	*	arena11_lv3_price	;	}
        if(	arena11_int	>=	arena11_lv3_count	|	arena11_int	 ==	arena11_lv3_count )	{arena11_int =	arena11_int	-	arena11_rlv1_count 	-	arena11_rlv2_count 	-	arena11_rlv3_count 	 		 	; tickets = tickets +	arena11_lv1_count	*	arena11_lv1_price	+	arena11_rlv2_count	*	arena11_lv2_price	+	arena11_int	*	arena11_lv3_price	;	}
        adapter.add("[ARENA] Lucky Ticket x"+prettyCount(arena11_int_base)+" cost "+prettyCount(tickets));
        adapter1.add(getString(R.string.event_arena11));adapter2.add(prettyCount(arena11_int_base));adapter3.add(prettyCount(tickets));
        tickets_final = tickets_final + tickets ;
        tickets = 0 ;


        //METHOD--END
        ticket_tv.setText(getString(R.string.tickets)+" : "+prettyCount(tickets_final));

        //获取操作SharedPreferences实例的编辑器（必须通过此种方式添加数据）
        SharedPreferences sharedPreferences = getSharedPreferences("event_shop", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("rss01", rss01_int_base);
        editor.putInt("rss02", rss02_int_base);
        editor.putInt("rss03", rss03_int_base);
        editor.putInt("rss04", rss04_int_base);
        editor.putInt("rss05", rss05_int_base);
        editor.putInt("rss06", rss06_int_base);
        editor.putInt("rss07", rss07_int_base);
        editor.putInt("rss08", rss08_int_base);
        editor.putInt("rss09", rss09_int_base);
        editor.putInt("enabler01",enabler01_int_base);
        editor.putInt("enabler02",enabler02_int_base);
        editor.putInt("enabler03",enabler03_int_base);
        editor.putInt("enabler04",enabler04_int_base);
        editor.putInt("enabler05",enabler05_int_base);
        editor.putInt("enabler06",enabler06_int_base);
        editor.putInt("enabler07",enabler07_int_base);
        editor.putInt("mecha01",mecha01_int_base);
        editor.putInt("mecha02",mecha02_int_base);
        editor.putInt("mecha03",mecha03_int_base);
        editor.putInt("mecha04",mecha04_int_base);
        editor.putInt("mecha05",mecha05_int_base);
        editor.putInt("arena01",arena01_int_base);
        editor.putInt("arena02",arena02_int_base);
        editor.putInt("arena03",arena03_int_base);
        editor.putInt("arena04",arena04_int_base);
        editor.putInt("arena05",arena05_int_base);
        editor.putInt("arena06",arena06_int_base);
        editor.putInt("arena07",arena07_int_base);
        editor.putInt("arena08",arena08_int_base);
        editor.putInt("arena09",arena09_int_base);
        editor.putInt("arena10",arena10_int_base);
        editor.putInt("arena11",arena11_int_base);

        editor.apply();
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

}