package voc.net.tools.zgirls_tool.old_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.R;

public class TBActivity extends AppCompatActivity {

    /**
     * HOLY DATABASE -- START
     */
//--------------------------------------------------------------------------
    int alloy_m1_fuel	=	200	;	int alloy_m1_time	=	582	;	int alloy_m1_glory_mark	=	0	;	int alloy_m1_kyanite	=	0	;	int alloy_m1_kyanite_basic	=	0	;	int alloy_m1_kyanite_cluster	=	0	;
    int alloy_m2_fuel	=	280	;	int alloy_m2_time	=	584	;	int alloy_m2_glory_mark	=	0	;	int alloy_m2_kyanite	=	0	;	int alloy_m2_kyanite_basic	=	0	;	int alloy_m2_kyanite_cluster	=	0	;
    int alloy_m3_fuel	=	392	;	int alloy_m3_time	=	428	;	int alloy_m3_glory_mark	=	0	;	int alloy_m3_kyanite	=	0	;	int alloy_m3_kyanite_basic	=	0	;	int alloy_m3_kyanite_cluster	=	0	;
    int alloy_m4_fuel	=	588	;	int alloy_m4_time	=	721	;	int alloy_m4_glory_mark	=	0	;	int alloy_m4_kyanite	=	0	;	int alloy_m4_kyanite_basic	=	0	;	int alloy_m4_kyanite_cluster	=	0	;
    int alloy_m5_fuel	=	941	;	int alloy_m5_time	=	890	;	int alloy_m5_glory_mark	=	0	;	int alloy_m5_kyanite	=	0	;	int alloy_m5_kyanite_basic	=	0	;	int alloy_m5_kyanite_cluster	=	0	;
    int alloy_m6_fuel	=	1690	;	int alloy_m6_time	=	1500	;	int alloy_m6_glory_mark	=	0	;	int alloy_m6_kyanite	=	0	;	int alloy_m6_kyanite_basic	=	0	;	int alloy_m6_kyanite_cluster	=	0	;
    int alloy_m7_fuel	=	3220	;	int alloy_m7_time	=	2400	;	int alloy_m7_glory_mark	=	0	;	int alloy_m7_kyanite	=	0	;	int alloy_m7_kyanite_basic	=	0	;	int alloy_m7_kyanite_cluster	=	0	;
    int alloy_m8_fuel	=	6440	;	int alloy_m8_time	=	3600	;	int alloy_m8_glory_mark	=	0	;	int alloy_m8_kyanite	=	0	;	int alloy_m8_kyanite_basic	=	0	;	int alloy_m8_kyanite_cluster	=	0	;
    int alloy_m9_fuel	=	12900	;	int alloy_m9_time	=	4200	;	int alloy_m9_glory_mark	=	0	;	int alloy_m9_kyanite	=	0	;	int alloy_m9_kyanite_basic	=	0	;	int alloy_m9_kyanite_cluster	=	0	;
    int alloy_m10_fuel	=	25700	;	int alloy_m10_time	=	5100	;	int alloy_m10_glory_mark	=	0	;	int alloy_m10_kyanite	=	0	;	int alloy_m10_kyanite_basic	=	0	;	int alloy_m10_kyanite_cluster	=	0	;
    int alloy_m11_fuel	=	51500	;	int alloy_m11_time	=	6000	;	int alloy_m11_glory_mark	=	0	;	int alloy_m11_kyanite	=	0	;	int alloy_m11_kyanite_basic	=	0	;	int alloy_m11_kyanite_cluster	=	0	;
    int alloy_m12_fuel	=	103000	;	int alloy_m12_time	=	7500	;	int alloy_m12_glory_mark	=	0	;	int alloy_m12_kyanite	=	0	;	int alloy_m12_kyanite_basic	=	0	;	int alloy_m12_kyanite_cluster	=	0	;
    int alloy_m13_fuel	=	196000	;	int alloy_m13_time	=	9300	;	int alloy_m13_glory_mark	=	0	;	int alloy_m13_kyanite	=	0	;	int alloy_m13_kyanite_basic	=	0	;	int alloy_m13_kyanite_cluster	=	0	;
    int alloy_m14_fuel	=	352000	;	int alloy_m14_time	=	11700	;	int alloy_m14_glory_mark	=	0	;	int alloy_m14_kyanite	=	0	;	int alloy_m14_kyanite_basic	=	0	;	int alloy_m14_kyanite_cluster	=	0	;
    int alloy_m15_fuel	=	528000	;	int alloy_m15_time	=	14700	;	int alloy_m15_glory_mark	=	0	;	int alloy_m15_kyanite	=	0	;	int alloy_m15_kyanite_basic	=	0	;	int alloy_m15_kyanite_cluster	=	0	;
    int alloy_m16_fuel	=	739000	;	int alloy_m16_time	=	18600	;	int alloy_m16_glory_mark	=	0	;	int alloy_m16_kyanite	=	0	;	int alloy_m16_kyanite_basic	=	0	;	int alloy_m16_kyanite_cluster	=	0	;
    int alloy_m17_fuel	=	1040000	;	int alloy_m17_time	=	23100	;	int alloy_m17_glory_mark	=	0	;	int alloy_m17_kyanite	=	0	;	int alloy_m17_kyanite_basic	=	0	;	int alloy_m17_kyanite_cluster	=	0	;
    int alloy_m18_fuel	=	1350000	;	int alloy_m18_time	=	28800	;	int alloy_m18_glory_mark	=	0	;	int alloy_m18_kyanite	=	0	;	int alloy_m18_kyanite_basic	=	0	;	int alloy_m18_kyanite_cluster	=	0	;
    int alloy_m19_fuel	=	1750000	;	int alloy_m19_time	=	36000	;	int alloy_m19_glory_mark	=	0	;	int alloy_m19_kyanite	=	0	;	int alloy_m19_kyanite_basic	=	0	;	int alloy_m19_kyanite_cluster	=	0	;
    int alloy_m20_fuel	=	2270000	;	int alloy_m20_time	=	45000	;	int alloy_m20_glory_mark	=	0	;	int alloy_m20_kyanite	=	0	;	int alloy_m20_kyanite_basic	=	0	;	int alloy_m20_kyanite_cluster	=	0	;
    int alloy_m21_fuel	=	2960000	;	int alloy_m21_time	=	50400	;	int alloy_m21_glory_mark	=	0	;	int alloy_m21_kyanite	=	0	;	int alloy_m21_kyanite_basic	=	0	;	int alloy_m21_kyanite_cluster	=	0	;
    int alloy_m22_fuel	=	3840000	;	int alloy_m22_time	=	61200	;	int alloy_m22_glory_mark	=	0	;	int alloy_m22_kyanite	=	0	;	int alloy_m22_kyanite_basic	=	0	;	int alloy_m22_kyanite_cluster	=	0	;
    int alloy_m23_fuel	=	5000000	;	int alloy_m23_time	=	68400	;	int alloy_m23_glory_mark	=	0	;	int alloy_m23_kyanite	=	0	;	int alloy_m23_kyanite_basic	=	0	;	int alloy_m23_kyanite_cluster	=	0	;
    int alloy_m24_fuel	=	6500000	;	int alloy_m24_time	=	79200	;	int alloy_m24_glory_mark	=	0	;	int alloy_m24_kyanite	=	0	;	int alloy_m24_kyanite_basic	=	0	;	int alloy_m24_kyanite_cluster	=	0	;
    int alloy_m25_fuel	=	8440000	;	int alloy_m25_time	=	90000	;	int alloy_m25_glory_mark	=	0	;	int alloy_m25_kyanite	=	0	;	int alloy_m25_kyanite_basic	=	0	;	int alloy_m25_kyanite_cluster	=	0	;
    int alloy_m26_fuel	=	11000000	;	int alloy_m26_time	=	104400	;	int alloy_m26_glory_mark	=	0	;	int alloy_m26_kyanite	=	0	;	int alloy_m26_kyanite_basic	=	0	;	int alloy_m26_kyanite_cluster	=	0	;
    int alloy_m27_fuel	=	14300000	;	int alloy_m27_time	=	118800	;	int alloy_m27_glory_mark	=	0	;	int alloy_m27_kyanite	=	0	;	int alloy_m27_kyanite_basic	=	0	;	int alloy_m27_kyanite_cluster	=	0	;
    int alloy_m28_fuel	=	18600000	;	int alloy_m28_time	=	136800	;	int alloy_m28_glory_mark	=	0	;	int alloy_m28_kyanite	=	0	;	int alloy_m28_kyanite_basic	=	0	;	int alloy_m28_kyanite_cluster	=	0	;
    int alloy_m29_fuel	=	24100000	;	int alloy_m29_time	=	158400	;	int alloy_m29_glory_mark	=	0	;	int alloy_m29_kyanite	=	0	;	int alloy_m29_kyanite_basic	=	0	;	int alloy_m29_kyanite_cluster	=	0	;
    int alloy_m30_fuel	=	31400000	;	int alloy_m30_time	=	182400	;	int alloy_m30_glory_mark	=	0	;	int alloy_m30_kyanite	=	0	;	int alloy_m30_kyanite_basic	=	0	;	int alloy_m30_kyanite_cluster	=	0	;
    int alloy_m31_fuel	=	168401886	;	int alloy_m31_time	=	968200	;	int alloy_m31_glory_mark	=	48948	;	int alloy_m31_kyanite	=	56239	;	int alloy_m31_kyanite_basic	=	78109	;	int alloy_m31_kyanite_cluster	=	6249	;
    int alloy_m32_fuel	=	188344752	;	int alloy_m32_time	=	1068970	;	int alloy_m32_glory_mark	=	54745	;	int alloy_m32_kyanite	=	62897	;	int alloy_m32_kyanite_basic	=	87358	;	int alloy_m32_kyanite_cluster	=	6988	;
    int alloy_m33_fuel	=	220717189	;	int alloy_m33_time	=	1180231	;	int alloy_m33_glory_mark	=	64154	;	int alloy_m33_kyanite	=	73709	;	int alloy_m33_kyanite_basic	=	102373	;	int alloy_m33_kyanite_cluster	=	8189	;
    int alloy_m34_fuel	=	293148573	;	int alloy_m34_time	=	1303070	;	int alloy_m34_glory_mark	=	85208	;	int alloy_m34_kyanite	=	97898	;	int alloy_m34_kyanite_basic	=	135969	;	int alloy_m34_kyanite_cluster	=	10878	;
    int alloy_m35_fuel	=	565135338	;	int alloy_m35_time	=	1438695	;	int alloy_m35_glory_mark	=	164263	;	int alloy_m35_kyanite	=	188728	;	int alloy_m35_kyanite_basic	=	262122	;	int alloy_m35_kyanite_cluster	=	20969	;
    //--------------------------------------------------------------------------
    int arm1_fuel	 =	589	;	int arm1_food	 =	0	;	int arm1_steel	 =	0	;	int arm1_alloy	 =	337	;	int arm1_time	 =	99	;	int arm1_glory_mark	=	0	;	int arm1_kyanite	=	0	;	int arm1_kyanite_basic	=	0	;	int arm1_kyanite_cluster	=	0	;
    int arm2_fuel	 =	825	;	int arm2_food	 =	0	;	int arm2_steel	 =	0	;	int arm2_alloy	 =	472	;	int arm2_time	 =	326	;	int arm2_glory_mark	=	0	;	int arm2_kyanite	=	0	;	int arm2_kyanite_basic	=	0	;	int arm2_kyanite_cluster	=	0	;
    int arm3_fuel	 =	1160	;	int arm3_food	 =	0	;	int arm3_steel	 =	0	;	int arm3_alloy	 =	660	;	int arm3_time	 =	428	;	int arm3_glory_mark	=	0	;	int arm3_kyanite	=	0	;	int arm3_kyanite_basic	=	0	;	int arm3_kyanite_cluster	=	0	;
    int arm4_fuel	 =	1730	;	int arm4_food	 =	0	;	int arm4_steel	 =	0	;	int arm4_alloy	 =	990	;	int arm4_time	 =	721	;	int arm4_glory_mark	=	0	;	int arm4_kyanite	=	0	;	int arm4_kyanite_basic	=	0	;	int arm4_kyanite_cluster	=	0	;
    int arm5_fuel	 =	2770	;	int arm5_food	 =	0	;	int arm5_steel	 =	0	;	int arm5_alloy	 =	1580	;	int arm5_time	 =	1163	;	int arm5_glory_mark	=	0	;	int arm5_kyanite	=	0	;	int arm5_kyanite_basic	=	0	;	int arm5_kyanite_cluster	=	0	;
    int arm6_fuel	 =	4990	;	int arm6_food	 =	0	;	int arm6_steel	 =	0	;	int arm6_alloy	 =	2850	;	int arm6_time	 =	2930	;	int arm6_glory_mark	=	0	;	int arm6_kyanite	=	0	;	int arm6_kyanite_basic	=	0	;	int arm6_kyanite_cluster	=	0	;
    int arm7_fuel	 =	9480	;	int arm7_food	 =	0	;	int arm7_steel	 =	0	;	int arm7_alloy	 =	5420	;	int arm7_time	 =	16200	;	int arm7_glory_mark	=	0	;	int arm7_kyanite	=	0	;	int arm7_kyanite_basic	=	0	;	int arm7_kyanite_cluster	=	0	;
    int arm8_fuel	 =	19000	;	int arm8_food	 =	0	;	int arm8_steel	 =	0	;	int arm8_alloy	 =	10800	;	int arm8_time	 =	22800	;	int arm8_glory_mark	=	0	;	int arm8_kyanite	=	0	;	int arm8_kyanite_basic	=	0	;	int arm8_kyanite_cluster	=	0	;
    int arm9_fuel	 =	37900	;	int arm9_food	 =	0	;	int arm9_steel	 =	0	;	int arm9_alloy	 =	21700	;	int arm9_time	 =	27300	;	int arm9_glory_mark	=	0	;	int arm9_kyanite	=	0	;	int arm9_kyanite_basic	=	0	;	int arm9_kyanite_cluster	=	0	;
    int arm10_fuel	 =	75900	;	int arm10_food	 =	0	;	int arm10_steel	 =	0	;	int arm10_alloy	 =	43400	;	int arm10_time	 =	32700	;	int arm10_glory_mark	=	0	;	int arm10_kyanite	=	0	;	int arm10_kyanite_basic	=	0	;	int arm10_kyanite_cluster	=	0	;
    int arm11_fuel	 =	152000	;	int arm11_food	 =	0	;	int arm11_steel	 =	14500	;	int arm11_alloy	 =	86700	;	int arm11_time	 =	39600	;	int arm11_glory_mark	=	0	;	int arm11_kyanite	=	0	;	int arm11_kyanite_basic	=	0	;	int arm11_kyanite_cluster	=	0	;
    int arm12_fuel	 =	303000	;	int arm12_food	 =	0	;	int arm12_steel	 =	28900	;	int arm12_alloy	 =	173000	;	int arm12_time	 =	50400	;	int arm12_glory_mark	=	0	;	int arm12_kyanite	=	0	;	int arm12_kyanite_basic	=	0	;	int arm12_kyanite_cluster	=	0	;
    int arm13_fuel	 =	577000	;	int arm13_food	 =	0	;	int arm13_steel	 =	54900	;	int arm13_alloy	 =	329000	;	int arm13_time	 =	61200	;	int arm13_glory_mark	=	0	;	int arm13_kyanite	=	0	;	int arm13_kyanite_basic	=	0	;	int arm13_kyanite_cluster	=	0	;
    int arm14_fuel	 =	1040000	;	int arm14_food	 =	0	;	int arm14_steel	 =	98800	;	int arm14_alloy	 =	593000	;	int arm14_time	 =	75600	;	int arm14_glory_mark	=	0	;	int arm14_kyanite	=	0	;	int arm14_kyanite_basic	=	0	;	int arm14_kyanite_cluster	=	0	;
    int arm15_fuel	 =	1560000	;	int arm15_food	 =	0	;	int arm15_steel	 =	148000	;	int arm15_alloy	 =	890000	;	int arm15_time	 =	97200	;	int arm15_glory_mark	=	0	;	int arm15_kyanite	=	0	;	int arm15_kyanite_basic	=	0	;	int arm15_kyanite_cluster	=	0	;
    int arm16_fuel	 =	2180000	;	int arm16_food	 =	51900	;	int arm16_steel	 =	208000	;	int arm16_alloy	 =	1250000	;	int arm16_time	 =	118800	;	int arm16_glory_mark	=	0	;	int arm16_kyanite	=	0	;	int arm16_kyanite_basic	=	0	;	int arm16_kyanite_cluster	=	0	;
    int arm17_fuel	 =	3050000	;	int arm17_food	 =	72600	;	int arm17_steel	 =	291000	;	int arm17_alloy	 =	1740000	;	int arm17_time	 =	151200	;	int arm17_glory_mark	=	0	;	int arm17_kyanite	=	0	;	int arm17_kyanite_basic	=	0	;	int arm17_kyanite_cluster	=	0	;
    int arm18_fuel	 =	3970000	;	int arm18_food	 =	94400	;	int arm18_steel	 =	378000	;	int arm18_alloy	 =	2270000	;	int arm18_time	 =	187200	;	int arm18_glory_mark	=	0	;	int arm18_kyanite	=	0	;	int arm18_kyanite_basic	=	0	;	int arm18_kyanite_cluster	=	0	;
    int arm19_fuel	 =	5160000	;	int arm19_food	 =	123000	;	int arm19_steel	 =	491000	;	int arm19_alloy	 =	2950000	;	int arm19_time	 =	234000	;	int arm19_glory_mark	=	0	;	int arm19_kyanite	=	0	;	int arm19_kyanite_basic	=	0	;	int arm19_kyanite_cluster	=	0	;
    int arm20_fuel	 =	6700000	;	int arm20_food	 =	160000	;	int arm20_steel	 =	638000	;	int arm20_alloy	 =	3830000	;	int arm20_time	 =	291600	;	int arm20_glory_mark	=	0	;	int arm20_kyanite	=	0	;	int arm20_kyanite_basic	=	0	;	int arm20_kyanite_cluster	=	0	;
    int arm21_fuel	 =	8710000	;	int arm21_food	 =	207000	;	int arm21_steel	 =	830000	;	int arm21_alloy	 =	4980000	;	int arm21_time	 =	338400	;	int arm21_glory_mark	=	0	;	int arm21_kyanite	=	0	;	int arm21_kyanite_basic	=	0	;	int arm21_kyanite_cluster	=	0	;
    int arm22_fuel	 =	11300000	;	int arm22_food	 =	270000	;	int arm22_steel	 =	1080000	;	int arm22_alloy	 =	6470000	;	int arm22_time	 =	388800	;	int arm22_glory_mark	=	0	;	int arm22_kyanite	=	0	;	int arm22_kyanite_basic	=	0	;	int arm22_kyanite_cluster	=	0	;
    int arm23_fuel	 =	14700000	;	int arm23_food	 =	351000	;	int arm23_steel	 =	1400000	;	int arm23_alloy	 =	8420000	;	int arm23_time	 =	446400	;	int arm23_glory_mark	=	0	;	int arm23_kyanite	=	0	;	int arm23_kyanite_basic	=	0	;	int arm23_kyanite_cluster	=	0	;
    int arm24_fuel	 =	19100000	;	int arm24_food	 =	456000	;	int arm24_steel	 =	1820000	;	int arm24_alloy	 =	10900000	;	int arm24_time	 =	511200	;	int arm24_glory_mark	=	0	;	int arm24_kyanite	=	0	;	int arm24_kyanite_basic	=	0	;	int arm24_kyanite_cluster	=	0	;
    int arm25_fuel	 =	24900000	;	int arm25_food	 =	593000	;	int arm25_steel	 =	2370000	;	int arm25_alloy	 =	14200000	;	int arm25_time	 =	590400	;	int arm25_glory_mark	=	0	;	int arm25_kyanite	=	0	;	int arm25_kyanite_basic	=	0	;	int arm25_kyanite_cluster	=	0	;
    int arm26_fuel	 =	32400000	;	int arm26_food	 =	770000	;	int arm26_steel	 =	3080000	;	int arm26_alloy	 =	18500000	;	int arm26_time	 =	676800	;	int arm26_glory_mark	=	0	;	int arm26_kyanite	=	0	;	int arm26_kyanite_basic	=	0	;	int arm26_kyanite_cluster	=	0	;
    int arm27_fuel	 =	42100000	;	int arm27_food	 =	1000000	;	int arm27_steel	 =	4010000	;	int arm27_alloy	 =	24000000	;	int arm27_time	 =	777600	;	int arm27_glory_mark	=	0	;	int arm27_kyanite	=	0	;	int arm27_kyanite_basic	=	0	;	int arm27_kyanite_cluster	=	0	;
    int arm28_fuel	 =	54700000	;	int arm28_food	 =	1300000	;	int arm28_steel	 =	5210000	;	int arm28_alloy	 =	31200000	;	int arm28_time	 =	896400	;	int arm28_glory_mark	=	0	;	int arm28_kyanite	=	0	;	int arm28_kyanite_basic	=	0	;	int arm28_kyanite_cluster	=	0	;
    int arm29_fuel	 =	71100000	;	int arm29_food	 =	1690000	;	int arm29_steel	 =	6770000	;	int arm29_alloy	 =	40600000	;	int arm29_time	 =	1029600	;	int arm29_glory_mark	=	0	;	int arm29_kyanite	=	0	;	int arm29_kyanite_basic	=	0	;	int arm29_kyanite_cluster	=	0	;
    int arm30_fuel	 =	92400000	;	int arm30_food	 =	2200000	;	int arm30_steel	 =	8800000	;	int arm30_alloy	 =	52800000	;	int arm30_time	 =	1184400	;	int arm30_glory_mark	=	0	;	int arm30_kyanite	=	0	;	int arm30_kyanite_basic	=	0	;	int arm30_kyanite_cluster	=	0	;
    int arm31_fuel	 =	120287062	;	int arm31_food	 =	120287062	;	int arm31_steel	 =	20105122	;	int arm31_alloy	 =	161684	;	int arm31_time	 =	1101706	;	int arm31_glory_mark	=	171318	;	int arm31_kyanite	=	253072	;	int arm31_kyanite_basic	=	351489	;	int arm31_kyanite_cluster	=	28120	;
    int arm32_fuel	 =	134531967	;	int arm32_food	 =	134531967	;	int arm32_steel	 =	22486056	;	int arm32_alloy	 =	180832	;	int arm32_time	 =	1232172	;	int arm32_glory_mark	=	191607	;	int arm32_kyanite	=	283041	;	int arm32_kyanite_basic	=	393112	;	int arm32_kyanite_cluster	=	31449	;
    int arm33_fuel	 =	157655136	;	int arm33_food	 =	157655136	;	int arm33_steel	 =	26350931	;	int arm33_alloy	 =	211913	;	int arm33_time	 =	1443955	;	int arm33_glory_mark	=	224540	;	int arm33_kyanite	=	331691	;	int arm33_kyanite_basic	=	460681	;	int arm33_kyanite_cluster	=	36855	;
    int arm34_fuel	 =	209391839	;	int arm34_food	 =	209391839	;	int arm34_steel	 =	34998349	;	int arm34_alloy	 =	281456	;	int arm34_time	 =	1917811	;	int arm34_glory_mark	=	298226	;	int arm34_kyanite	=	440539	;	int arm34_kyanite_basic	=	611859	;	int arm34_kyanite_cluster	=	48949	;
    int arm35_fuel	 =	403668100	;	int arm35_food	 =	403668100	;	int arm35_steel	 =	67470239	;	int arm35_alloy	 =	542592	;	int arm35_time	 =	3697181	;	int arm35_glory_mark	=	574922	;	int arm35_kyanite	=	849276	;	int arm35_kyanite_basic	=	1179550	;	int arm35_kyanite_cluster	=	94364	;
    //--------------------------------------------------------------------------
    int armory1_fuel	 =	589	;	int armory1_food	 =	337	;	int armory1_steel	 =	0	;	int armory1_alloy	 =	0	;	int armory1_time	 =	99	;	int armory1_glory_mark	=	0	;
    int armory2_fuel	 =	825	;	int armory2_food	 =	471	;	int armory2_steel	 =	0	;	int armory2_alloy	 =	0	;	int armory2_time	 =	605	;	int armory2_glory_mark	=	1	;
    int armory3_fuel	 =	1155	;	int armory3_food	 =	660	;	int armory3_steel	 =	0	;	int armory3_alloy	 =	0	;	int armory3_time	 =	905	;	int armory3_glory_mark	=	2	;
    int armory4_fuel	 =	1733	;	int armory4_food	 =	990	;	int armory4_steel	 =	0	;	int armory4_alloy	 =	0	;	int armory4_time	 =	905	;	int armory4_glory_mark	=	3	;
    int armory5_fuel	 =	2772	;	int armory5_food	 =	1584	;	int armory5_steel	 =	0	;	int armory5_alloy	 =	0	;	int armory5_time	 =	4200	;	int armory5_glory_mark	=	4	;
    int armory6_fuel	 =	4991	;	int armory6_food	 =	2852	;	int armory6_steel	 =	0	;	int armory6_alloy	 =	0	;	int armory6_time	 =	7200	;	int armory6_glory_mark	=	5	;
    int armory7_fuel	 =	9483	;	int armory7_food	 =	5419	;	int armory7_steel	 =	0	;	int armory7_alloy	 =	0	;	int armory7_time	 =	16200	;	int armory7_glory_mark	=	6	;
    int armory8_fuel	 =	18966	;	int armory8_food	 =	10838	;	int armory8_steel	 =	0	;	int armory8_alloy	 =	0	;	int armory8_time	 =	22800	;	int armory8_glory_mark	=	7	;
    int armory9_fuel	 =	37933	;	int armory9_food	 =	21676	;	int armory9_steel	 =	0	;	int armory9_alloy	 =	0	;	int armory9_time	 =	27300	;	int armory9_glory_mark	=	8	;
    int armory10_fuel	 =	75866	;	int armory10_food	 =	43352	;	int armory10_steel	 =	0	;	int armory10_alloy	 =	0	;	int armory10_time	 =	32700	;	int armory10_glory_mark	=	9	;
    int armory11_fuel	 =	151732	;	int armory11_food	 =	86704	;	int armory11_steel	 =	14450	;	int armory11_alloy	 =	0	;	int armory11_time	 =	39600	;	int armory11_glory_mark	=	10	;
    int armory12_fuel	 =	303464	;	int armory12_food	 =	173408	;	int armory12_steel	 =	28901	;	int armory12_alloy	 =	0	;	int armory12_time	 =	50400	;	int armory12_glory_mark	=	11	;
    int armory13_fuel	 =	576582	;	int armory13_food	 =	329475	;	int armory13_steel	 =	54912	;	int armory13_alloy	 =	0	;	int armory13_time	 =	61200	;	int armory13_glory_mark	=	12	;
    int armory14_fuel	 =	1037848	;	int armory14_food	 =	593056	;	int armory14_steel	 =	98842	;	int armory14_alloy	 =	0	;	int armory14_time	 =	75600	;	int armory14_glory_mark	=	13	;
    int armory15_fuel	 =	1556772	;	int armory15_food	 =	889584	;	int armory15_steel	 =	148264	;	int armory15_alloy	 =	0	;	int armory15_time	 =	97200	;	int armory15_glory_mark	=	14	;
    int armory16_fuel	 =	2179481	;	int armory16_food	 =	1245418	;	int armory16_steel	 =	207569	;	int armory16_alloy	 =	51892	;	int armory16_time	 =	118800	;	int armory16_glory_mark	=	15	;
    int armory17_fuel	 =	3051274	;	int armory17_food	 =	1743585	;	int armory17_steel	 =	290597	;	int armory17_alloy	 =	72649	;	int armory17_time	 =	151200	;	int armory17_glory_mark	=	16	;
    int armory18_fuel	 =	3966656	;	int armory18_food	 =	2266660	;	int armory18_steel	 =	377776	;	int armory18_alloy	 =	94444	;	int armory18_time	 =	187200	;	int armory18_glory_mark	=	17	;
    int armory19_fuel	 =	5156653	;	int armory19_food	 =	2946659	;	int armory19_steel	 =	491109	;	int armory19_alloy	 =	122777	;	int armory19_time	 =	234000	;	int armory19_glory_mark	=	18	;
    int armory20_fuel	 =	6703649	;	int armory20_food	 =	3830656	;	int armory20_steel	 =	638442	;	int armory20_alloy	 =	159610	;	int armory20_time	 =	291600	;	int armory20_glory_mark	=	19	;
    int armory21_fuel	 =	8714744	;	int armory21_food	 =	4979854	;	int armory21_steel	 =	829975	;	int armory21_alloy	 =	207493	;	int armory21_time	 =	338400	;	int armory21_glory_mark	=	20	;
    int armory22_fuel	 =	11329168	;	int armory22_food	 =	6473810	;	int armory22_steel	 =	1078968	;	int armory22_alloy	 =	269742	;	int armory22_time	 =	388800	;	int armory22_glory_mark	=	21	;
    int armory23_fuel	 =	14727918	;	int armory23_food	 =	8415953	;	int armory23_steel	 =	1402658	;	int armory23_alloy	 =	350664	;	int armory23_time	 =	446400	;	int armory23_glory_mark	=	22	;
    int armory24_fuel	 =	19146293	;	int armory24_food	 =	10940739	;	int armory24_steel	 =	1823456	;	int armory24_alloy	 =	455864	;	int armory24_time	 =	511200	;	int armory24_glory_mark	=	23	;
    int armory25_fuel	 =	24890182	;	int armory25_food	 =	14222961	;	int armory25_steel	 =	2370493	;	int armory25_alloy	 =	592623	;	int armory25_time	 =	590400	;	int armory25_glory_mark	=	24	;
    int armory26_fuel	 =	32357236	;	int armory26_food	 =	18489849	;	int armory26_steel	 =	3081641	;	int armory26_alloy	 =	770410	;	int armory26_time	 =	676800	;	int armory26_glory_mark	=	25	;
    int armory27_fuel	 =	42064407	;	int armory27_food	 =	24036804	;	int armory27_steel	 =	4006134	;	int armory27_alloy	 =	1001533	;	int armory27_time	 =	777600	;	int armory27_glory_mark	=	26	;
    int armory28_fuel	 =	54683730	;	int armory28_food	 =	31247845	;	int armory28_steel	 =	5207974	;	int armory28_alloy	 =	1301993	;	int armory28_time	 =	896400	;	int armory28_glory_mark	=	27	;
    int armory29_fuel	 =	71088849	;	int armory29_food	 =	40622199	;	int armory29_steel	 =	6770366	;	int armory29_alloy	 =	1692591	;	int armory29_time	 =	1029600	;	int armory29_glory_mark	=	28	;
    int armory30_fuel	 =	92415503	;	int armory30_food	 =	52808859	;	int armory30_steel	 =	8801476	;	int armory30_alloy	 =	2200369	;	int armory30_time	 =	1184400	;	int armory30_glory_mark	=	29	;
    //--------------------------------------------------------------------------
    int cafe1_fuel	 =	589	;	int cafe1_food	 =	336	;	int cafe1_steel	 =	0	;	int cafe1_alloy	 =	0	;	int cafe1_time	 =	2	;
    int cafe2_fuel	 =	825	;	int cafe2_food	 =	471	;	int cafe2_steel	 =	0	;	int cafe2_alloy	 =	0	;	int cafe2_time	 =	285	;
    int cafe3_fuel	 =	1160	;	int cafe3_food	 =	660	;	int cafe3_steel	 =	0	;	int cafe3_alloy	 =	0	;	int cafe3_time	 =	585	;
    int cafe4_fuel	 =	1730	;	int cafe4_food	 =	990	;	int cafe4_steel	 =	0	;	int cafe4_alloy	 =	0	;	int cafe4_time	 =	885	;
    int cafe5_fuel	 =	2770	;	int cafe5_food	 =	1584	;	int cafe5_steel	 =	0	;	int cafe5_alloy	 =	0	;	int cafe5_time	 =	4180	;
    int cafe6_fuel	 =	4990	;	int cafe6_food	 =	2852	;	int cafe6_steel	 =	0	;	int cafe6_alloy	 =	0	;	int cafe6_time	 =	7200	;
    int cafe7_fuel	 =	9480	;	int cafe7_food	 =	5419	;	int cafe7_steel	 =	0	;	int cafe7_alloy	 =	0	;	int cafe7_time	 =	16200	;
    int cafe8_fuel	 =	19000	;	int cafe8_food	 =	10838	;	int cafe8_steel	 =	0	;	int cafe8_alloy	 =	0	;	int cafe8_time	 =	22800	;
    int cafe9_fuel	 =	37900	;	int cafe9_food	 =	21676	;	int cafe9_steel	 =	0	;	int cafe9_alloy	 =	0	;	int cafe9_time	 =	27300	;
    int cafe10_fuel	 =	75900	;	int cafe10_food	 =	43352	;	int cafe10_steel	 =	0	;	int cafe10_alloy	 =	0	;	int cafe10_time	 =	32700	;
    int cafe11_fuel	 =	152000	;	int cafe11_food	 =	86704	;	int cafe11_steel	 =	14500	;	int cafe11_alloy	 =	0	;	int cafe11_time	 =	39600	;
    int cafe12_fuel	 =	303000	;	int cafe12_food	 =	173408	;	int cafe12_steel	 =	28900	;	int cafe12_alloy	 =	0	;	int cafe12_time	 =	50400	;
    int cafe13_fuel	 =	577000	;	int cafe13_food	 =	329475	;	int cafe13_steel	 =	54900	;	int cafe13_alloy	 =	0	;	int cafe13_time	 =	61200	;
    int cafe14_fuel	 =	1040000	;	int cafe14_food	 =	593056	;	int cafe14_steel	 =	98800	;	int cafe14_alloy	 =	0	;	int cafe14_time	 =	75600	;
    int cafe15_fuel	 =	1560000	;	int cafe15_food	 =	889584	;	int cafe15_steel	 =	148000	;	int cafe15_alloy	 =	0	;	int cafe15_time	 =	97200	;
    int cafe16_fuel	 =	2180000	;	int cafe16_food	 =	1245418	;	int cafe16_steel	 =	208000	;	int cafe16_alloy	 =	51900	;	int cafe16_time	 =	118800	;
    int cafe17_fuel	 =	3050000	;	int cafe17_food	 =	1743585	;	int cafe17_steel	 =	291000	;	int cafe17_alloy	 =	72600	;	int cafe17_time	 =	151200	;
    int cafe18_fuel	 =	3970000	;	int cafe18_food	 =	2266660	;	int cafe18_steel	 =	378000	;	int cafe18_alloy	 =	94400	;	int cafe18_time	 =	187200	;
    int cafe19_fuel	 =	5160000	;	int cafe19_food	 =	2946659	;	int cafe19_steel	 =	491000	;	int cafe19_alloy	 =	123000	;	int cafe19_time	 =	234000	;
    int cafe20_fuel	 =	6700000	;	int cafe20_food	 =	3830656	;	int cafe20_steel	 =	638000	;	int cafe20_alloy	 =	160000	;	int cafe20_time	 =	291600	;
    int cafe21_fuel	 =	8710000	;	int cafe21_food	 =	4979854	;	int cafe21_steel	 =	830000	;	int cafe21_alloy	 =	207000	;	int cafe21_time	 =	338400	;
    int cafe22_fuel	 =	11300000	;	int cafe22_food	 =	6473810	;	int cafe22_steel	 =	1080000	;	int cafe22_alloy	 =	270000	;	int cafe22_time	 =	388800	;
    int cafe23_fuel	 =	14700000	;	int cafe23_food	 =	8415953	;	int cafe23_steel	 =	1400000	;	int cafe23_alloy	 =	351000	;	int cafe23_time	 =	446400	;
    int cafe24_fuel	 =	19100000	;	int cafe24_food	 =	10940739	;	int cafe24_steel	 =	1820000	;	int cafe24_alloy	 =	456000	;	int cafe24_time	 =	511200	;
    int cafe25_fuel	 =	24900000	;	int cafe25_food	 =	14222961	;	int cafe25_steel	 =	2370000	;	int cafe25_alloy	 =	593000	;	int cafe25_time	 =	590400	;
    int cafe26_fuel	 =	32400000	;	int cafe26_food	 =	18489849	;	int cafe26_steel	 =	3080000	;	int cafe26_alloy	 =	770000	;	int cafe26_time	 =	676800	;
    int cafe27_fuel	 =	42100000	;	int cafe27_food	 =	24036804	;	int cafe27_steel	 =	4010000	;	int cafe27_alloy	 =	1000000	;	int cafe27_time	 =	777600	;
    int cafe28_fuel	 =	54700000	;	int cafe28_food	 =	31247845	;	int cafe28_steel	 =	5210000	;	int cafe28_alloy	 =	1300000	;	int cafe28_time	 =	896400	;
    int cafe29_fuel	 =	71100000	;	int cafe29_food	 =	40622199	;	int cafe29_steel	 =	6770000	;	int cafe29_alloy	 =	1690000	;	int cafe29_time	 =	1029600	;
    int cafe30_fuel	 =	92400000	;	int cafe30_food	 =	52808859	;	int cafe30_steel	 =	8800000	;	int cafe30_alloy	 =	2200000	;	int cafe30_time	 =	1184400	;

    //--------------------------------------------------------------------------
    int clinic1_fuel	 =	203	;	int clinic1_food	 =	0	;	int clinic1_steel	 =	0	;	int clinic1_alloy	 =	0	;	int clinic1_time	 =	160	;	int clinic1_glory_mark	=	0	;	int clinic1_kyanite	=	0	;	int clinic1_kyanite_basic	=	0	;	int clinic1_kyanite_cluster	=	0	;
    int clinic2_fuel	 =	284	;	int clinic2_food	 =	0	;	int clinic2_steel	 =	0	;	int clinic2_alloy	 =	0	;	int clinic2_time	 =	290	;	int clinic2_glory_mark	=	0	;	int clinic2_kyanite	=	0	;	int clinic2_kyanite_basic	=	0	;	int clinic2_kyanite_cluster	=	0	;
    int clinic3_fuel	 =	398	;	int clinic3_food	 =	0	;	int clinic3_steel	 =	0	;	int clinic3_alloy	 =	0	;	int clinic3_time	 =	428	;	int clinic3_glory_mark	=	0	;	int clinic3_kyanite	=	0	;	int clinic3_kyanite_basic	=	0	;	int clinic3_kyanite_cluster	=	0	;
    int clinic4_fuel	 =	597	;	int clinic4_food	 =	0	;	int clinic4_steel	 =	0	;	int clinic4_alloy	 =	0	;	int clinic4_time	 =	581	;	int clinic4_glory_mark	=	0	;	int clinic4_kyanite	=	0	;	int clinic4_kyanite_basic	=	0	;	int clinic4_kyanite_cluster	=	0	;
    int clinic5_fuel	 =	955	;	int clinic5_food	 =	0	;	int clinic5_steel	 =	0	;	int clinic5_alloy	 =	0	;	int clinic5_time	 =	595	;	int clinic5_glory_mark	=	0	;	int clinic5_kyanite	=	0	;	int clinic5_kyanite_basic	=	0	;	int clinic5_kyanite_cluster	=	0	;
    int clinic6_fuel	 =	1720	;	int clinic6_food	 =	0	;	int clinic6_steel	 =	0	;	int clinic6_alloy	 =	0	;	int clinic6_time	 =	890	;	int clinic6_glory_mark	=	0	;	int clinic6_kyanite	=	0	;	int clinic6_kyanite_basic	=	0	;	int clinic6_kyanite_cluster	=	0	;
    int clinic7_fuel	 =	3270	;	int clinic7_food	 =	0	;	int clinic7_steel	 =	0	;	int clinic7_alloy	 =	0	;	int clinic7_time	 =	3580	;	int clinic7_glory_mark	=	0	;	int clinic7_kyanite	=	0	;	int clinic7_kyanite_basic	=	0	;	int clinic7_kyanite_cluster	=	0	;
    int clinic8_fuel	 =	6530	;	int clinic8_food	 =	0	;	int clinic8_steel	 =	0	;	int clinic8_alloy	 =	0	;	int clinic8_time	 =	4500	;	int clinic8_glory_mark	=	0	;	int clinic8_kyanite	=	0	;	int clinic8_kyanite_basic	=	0	;	int clinic8_kyanite_cluster	=	0	;
    int clinic9_fuel	 =	13100	;	int clinic9_food	 =	0	;	int clinic9_steel	 =	0	;	int clinic9_alloy	 =	0	;	int clinic9_time	 =	5100	;	int clinic9_glory_mark	=	0	;	int clinic9_kyanite	=	0	;	int clinic9_kyanite_basic	=	0	;	int clinic9_kyanite_cluster	=	0	;
    int clinic10_fuel	 =	26100	;	int clinic10_food	 =	0	;	int clinic10_steel	 =	0	;	int clinic10_alloy	 =	0	;	int clinic10_time	 =	6300	;	int clinic10_glory_mark	=	0	;	int clinic10_kyanite	=	0	;	int clinic10_kyanite_basic	=	0	;	int clinic10_kyanite_cluster	=	0	;
    int clinic11_fuel	 =	32200	;	int clinic11_food	 =	0	;	int clinic11_steel	 =	3350	;	int clinic11_alloy	 =	0	;	int clinic11_time	 =	7500	;	int clinic11_glory_mark	=	0	;	int clinic11_kyanite	=	0	;	int clinic11_kyanite_basic	=	0	;	int clinic11_kyanite_cluster	=	0	;
    int clinic12_fuel	 =	64300	;	int clinic12_food	 =	0	;	int clinic12_steel	 =	6700	;	int clinic12_alloy	 =	0	;	int clinic12_time	 =	9300	;	int clinic12_glory_mark	=	0	;	int clinic12_kyanite	=	0	;	int clinic12_kyanite_basic	=	0	;	int clinic12_kyanite_cluster	=	0	;
    int clinic13_fuel	 =	122000	;	int clinic13_food	 =	0	;	int clinic13_steel	 =	12700	;	int clinic13_alloy	 =	0	;	int clinic13_time	 =	11700	;	int clinic13_glory_mark	=	0	;	int clinic13_kyanite	=	0	;	int clinic13_kyanite_basic	=	0	;	int clinic13_kyanite_cluster	=	0	;
    int clinic14_fuel	 =	220000	;	int clinic14_food	 =	0	;	int clinic14_steel	 =	22900	;	int clinic14_alloy	 =	0	;	int clinic14_time	 =	14700	;	int clinic14_glory_mark	=	0	;	int clinic14_kyanite	=	0	;	int clinic14_kyanite_basic	=	0	;	int clinic14_kyanite_cluster	=	0	;
    int clinic15_fuel	 =	330000	;	int clinic15_food	 =	0	;	int clinic15_steel	 =	34400	;	int clinic15_alloy	 =	0	;	int clinic15_time	 =	18300	;	int clinic15_glory_mark	=	0	;	int clinic15_kyanite	=	0	;	int clinic15_kyanite_basic	=	0	;	int clinic15_kyanite_cluster	=	0	;
    int clinic16_fuel	 =	375000	;	int clinic16_food	 =	0	;	int clinic16_steel	 =	39100	;	int clinic16_alloy	 =	5860	;	int clinic16_time	 =	23100	;	int clinic16_glory_mark	=	0	;	int clinic16_kyanite	=	0	;	int clinic16_kyanite_basic	=	0	;	int clinic16_kyanite_cluster	=	0	;
    int clinic17_fuel	 =	525000	;	int clinic17_food	 =	0	;	int clinic17_steel	 =	54700	;	int clinic17_alloy	 =	8210	;	int clinic17_time	 =	28800	;	int clinic17_glory_mark	=	0	;	int clinic17_kyanite	=	0	;	int clinic17_kyanite_basic	=	0	;	int clinic17_kyanite_cluster	=	0	;
    int clinic18_fuel	 =	683000	;	int clinic18_food	 =	0	;	int clinic18_steel	 =	71100	;	int clinic18_alloy	 =	10700	;	int clinic18_time	 =	36000	;	int clinic18_glory_mark	=	0	;	int clinic18_kyanite	=	0	;	int clinic18_kyanite_basic	=	0	;	int clinic18_kyanite_cluster	=	0	;
    int clinic19_fuel	 =	888000	;	int clinic19_food	 =	0	;	int clinic19_steel	 =	92500	;	int clinic19_alloy	 =	13900	;	int clinic19_time	 =	43200	;	int clinic19_glory_mark	=	0	;	int clinic19_kyanite	=	0	;	int clinic19_kyanite_basic	=	0	;	int clinic19_kyanite_cluster	=	0	;
    int clinic20_fuel	 =	1150000	;	int clinic20_food	 =	0	;	int clinic20_steel	 =	120000	;	int clinic20_alloy	 =	18000	;	int clinic20_time	 =	57600	;	int clinic20_glory_mark	=	0	;	int clinic20_kyanite	=	0	;	int clinic20_kyanite_basic	=	0	;	int clinic20_kyanite_cluster	=	0	;
    int clinic21_fuel	 =	1500000	;	int clinic21_food	 =	0	;	int clinic21_steel	 =	156000	;	int clinic21_alloy	 =	23400	;	int clinic21_time	 =	64800	;	int clinic21_glory_mark	=	0	;	int clinic21_kyanite	=	0	;	int clinic21_kyanite_basic	=	0	;	int clinic21_kyanite_cluster	=	0	;
    int clinic22_fuel	 =	1950000	;	int clinic22_food	 =	0	;	int clinic22_steel	 =	203000	;	int clinic22_alloy	 =	30500	;	int clinic22_time	 =	75600	;	int clinic22_glory_mark	=	0	;	int clinic22_kyanite	=	0	;	int clinic22_kyanite_basic	=	0	;	int clinic22_kyanite_cluster	=	0	;
    int clinic23_fuel	 =	2540000	;	int clinic23_food	 =	0	;	int clinic23_steel	 =	264000	;	int clinic23_alloy	 =	39600	;	int clinic23_time	 =	86400	;	int clinic23_glory_mark	=	0	;	int clinic23_kyanite	=	0	;	int clinic23_kyanite_basic	=	0	;	int clinic23_kyanite_cluster	=	0	;
    int clinic24_fuel	 =	3300000	;	int clinic24_food	 =	0	;	int clinic24_steel	 =	343000	;	int clinic24_alloy	 =	51500	;	int clinic24_time	 =	97200	;	int clinic24_glory_mark	=	0	;	int clinic24_kyanite	=	0	;	int clinic24_kyanite_basic	=	0	;	int clinic24_kyanite_cluster	=	0	;
    int clinic25_fuel	 =	4290000	;	int clinic25_food	 =	0	;	int clinic25_steel	 =	446000	;	int clinic25_alloy	 =	67000	;	int clinic25_time	 =	111600	;	int clinic25_glory_mark	=	0	;	int clinic25_kyanite	=	0	;	int clinic25_kyanite_basic	=	0	;	int clinic25_kyanite_cluster	=	0	;
    int clinic26_fuel	 =	5570000	;	int clinic26_food	 =	0	;	int clinic26_steel	 =	580000	;	int clinic26_alloy	 =	87100	;	int clinic26_time	 =	129600	;	int clinic26_glory_mark	=	0	;	int clinic26_kyanite	=	0	;	int clinic26_kyanite_basic	=	0	;	int clinic26_kyanite_cluster	=	0	;
    int clinic27_fuel	 =	7240000	;	int clinic27_food	 =	0	;	int clinic27_steel	 =	754000	;	int clinic27_alloy	 =	113000	;	int clinic27_time	 =	147600	;	int clinic27_glory_mark	=	0	;	int clinic27_kyanite	=	0	;	int clinic27_kyanite_basic	=	0	;	int clinic27_kyanite_cluster	=	0	;
    int clinic28_fuel	 =	9420000	;	int clinic28_food	 =	0	;	int clinic28_steel	 =	981000	;	int clinic28_alloy	 =	147000	;	int clinic28_time	 =	172800	;	int clinic28_glory_mark	=	0	;	int clinic28_kyanite	=	0	;	int clinic28_kyanite_basic	=	0	;	int clinic28_kyanite_cluster	=	0	;
    int clinic29_fuel	 =	12200000	;	int clinic29_food	 =	0	;	int clinic29_steel	 =	1280000	;	int clinic29_alloy	 =	191000	;	int clinic29_time	 =	198000	;	int clinic29_glory_mark	=	0	;	int clinic29_kyanite	=	0	;	int clinic29_kyanite_basic	=	0	;	int clinic29_kyanite_cluster	=	0	;
    int clinic30_fuel	 =	15900000	;	int clinic30_food	 =	0	;	int clinic30_steel	 =	1660000	;	int clinic30_alloy	 =	249000	;	int clinic30_time	 =	226800	;	int clinic30_glory_mark	=	0	;	int clinic30_kyanite	=	0	;	int clinic30_kyanite_basic	=	0	;	int clinic30_kyanite_cluster	=	0	;
    int clinic31_fuel	 =	14434447	;	int clinic31_food	 =	1	;	int clinic31_steel	 =	1202871	;	int clinic31_alloy	 =	194022	;	int clinic31_time	 =	1175151	;	int clinic31_glory_mark	=	210476	;	int clinic31_kyanite	=	241824	;	int clinic31_kyanite_basic	=	335867	;	int clinic31_kyanite_cluster	=	26870	;
    int clinic32_fuel	 =	16143836	;	int clinic32_food	 =	2	;	int clinic32_steel	 =	1345320	;	int clinic32_alloy	 =	216999	;	int clinic32_time	 =	1314317	;	int clinic32_glory_mark	=	235403	;	int clinic32_kyanite	=	270462	;	int clinic32_kyanite_basic	=	375641	;	int clinic32_kyanite_cluster	=	30051	;
    int clinic33_fuel	 =	18918617	;	int clinic33_food	 =	3	;	int clinic33_steel	 =	1576552	;	int clinic33_alloy	 =	254295	;	int clinic33_time	 =	1540218	;	int clinic33_glory_mark	=	275863	;	int clinic33_kyanite	=	316949	;	int clinic33_kyanite_basic	=	440206	;	int clinic33_kyanite_cluster	=	35217	;
    int clinic34_fuel	 =	25127020	;	int clinic34_food	 =	4	;	int clinic34_steel	 =	2093917	;	int clinic34_alloy	 =	337746	;	int clinic34_time	 =	2045665	;	int clinic34_glory_mark	=	366390	;	int clinic34_kyanite	=	420959	;	int clinic34_kyanite_basic	=	584665	;	int clinic34_kyanite_cluster	=	46773	;
    int clinic35_fuel	 =	48440172	;	int clinic35_food	 =	5	;	int clinic35_steel	 =	4036681	;	int clinic35_alloy	 =	651112	;	int clinic35_time	 =	3943660	;	int clinic35_glory_mark	=	706332	;	int clinic35_kyanite	=	811530	;	int clinic35_kyanite_basic	=	1127126	;	int clinic35_kyanite_cluster	=	90170	;

    //--------------------------------------------------------------------------
    int clone1_fuel	 =	589	;	int clone1_food	 =	589	;	int clone1_steel	 =	0	;	int clone1_alloy	 =	0	;	int clone1_time	 =	2	;
    int clone2_fuel	 =	825	;	int clone2_food	 =	825	;	int clone2_steel	 =	0	;	int clone2_alloy	 =	0	;	int clone2_time	 =	605	;
    int clone3_fuel	 =	1160	;	int clone3_food	 =	1160	;	int clone3_steel	 =	0	;	int clone3_alloy	 =	0	;	int clone3_time	 =	905	;
    int clone4_fuel	 =	1730	;	int clone4_food	 =	1730	;	int clone4_steel	 =	0	;	int clone4_alloy	 =	0	;	int clone4_time	 =	905	;
    int clone5_fuel	 =	2770	;	int clone5_food	 =	2770	;	int clone5_steel	 =	0	;	int clone5_alloy	 =	0	;	int clone5_time	 =	4200	;
    int clone6_fuel	 =	4990	;	int clone6_food	 =	4990	;	int clone6_steel	 =	0	;	int clone6_alloy	 =	0	;	int clone6_time	 =	7200	;
    int clone7_fuel	 =	9480	;	int clone7_food	 =	9480	;	int clone7_steel	 =	0	;	int clone7_alloy	 =	0	;	int clone7_time	 =	16200	;
    int clone8_fuel	 =	19000	;	int clone8_food	 =	19000	;	int clone8_steel	 =	0	;	int clone8_alloy	 =	0	;	int clone8_time	 =	22800	;
    int clone9_fuel	 =	37900	;	int clone9_food	 =	37900	;	int clone9_steel	 =	0	;	int clone9_alloy	 =	0	;	int clone9_time	 =	27300	;
    int clone10_fuel	 =	75900	;	int clone10_food	 =	75900	;	int clone10_steel	 =	0	;	int clone10_alloy	 =	0	;	int clone10_time	 =	32700	;
    int clone11_fuel	 =	152000	;	int clone11_food	 =	152000	;	int clone11_steel	 =	14500	;	int clone11_alloy	 =	0	;	int clone11_time	 =	39600	;
    int clone12_fuel	 =	303000	;	int clone12_food	 =	303000	;	int clone12_steel	 =	28900	;	int clone12_alloy	 =	0	;	int clone12_time	 =	50400	;
    int clone13_fuel	 =	577000	;	int clone13_food	 =	577000	;	int clone13_steel	 =	54900	;	int clone13_alloy	 =	0	;	int clone13_time	 =	61200	;
    int clone14_fuel	 =	1040000	;	int clone14_food	 =	1040000	;	int clone14_steel	 =	98800	;	int clone14_alloy	 =	0	;	int clone14_time	 =	75600	;
    int clone15_fuel	 =	1560000	;	int clone15_food	 =	1560000	;	int clone15_steel	 =	148000	;	int clone15_alloy	 =	0	;	int clone15_time	 =	97200	;
    int clone16_fuel	 =	2180000	;	int clone16_food	 =	2180000	;	int clone16_steel	 =	208000	;	int clone16_alloy	 =	51900	;	int clone16_time	 =	118800	;
    int clone17_fuel	 =	3050000	;	int clone17_food	 =	3050000	;	int clone17_steel	 =	291000	;	int clone17_alloy	 =	72600	;	int clone17_time	 =	151200	;
    int clone18_fuel	 =	3970000	;	int clone18_food	 =	3970000	;	int clone18_steel	 =	378000	;	int clone18_alloy	 =	94400	;	int clone18_time	 =	187200	;
    int clone19_fuel	 =	5160000	;	int clone19_food	 =	5160000	;	int clone19_steel	 =	491000	;	int clone19_alloy	 =	123000	;	int clone19_time	 =	234000	;
    int clone20_fuel	 =	6700000	;	int clone20_food	 =	6700000	;	int clone20_steel	 =	638000	;	int clone20_alloy	 =	160000	;	int clone20_time	 =	291600	;
    int clone21_fuel	 =	8710000	;	int clone21_food	 =	8710000	;	int clone21_steel	 =	830000	;	int clone21_alloy	 =	207000	;	int clone21_time	 =	338400	;
    int clone22_fuel	 =	11300000	;	int clone22_food	 =	11300000	;	int clone22_steel	 =	1080000	;	int clone22_alloy	 =	270000	;	int clone22_time	 =	388800	;
    int clone23_fuel	 =	14700000	;	int clone23_food	 =	14700000	;	int clone23_steel	 =	1400000	;	int clone23_alloy	 =	351000	;	int clone23_time	 =	446400	;
    int clone24_fuel	 =	19100000	;	int clone24_food	 =	19100000	;	int clone24_steel	 =	1820000	;	int clone24_alloy	 =	456000	;	int clone24_time	 =	511200	;
    int clone25_fuel	 =	24900000	;	int clone25_food	 =	24900000	;	int clone25_steel	 =	2370000	;	int clone25_alloy	 =	593000	;	int clone25_time	 =	590400	;
    int clone26_fuel	 =	32400000	;	int clone26_food	 =	32400000	;	int clone26_steel	 =	3080000	;	int clone26_alloy	 =	770000	;	int clone26_time	 =	676800	;
    int clone27_fuel	 =	42100000	;	int clone27_food	 =	42100000	;	int clone27_steel	 =	4010000	;	int clone27_alloy	 =	1000000	;	int clone27_time	 =	777600	;
    int clone28_fuel	 =	54700000	;	int clone28_food	 =	54700000	;	int clone28_steel	 =	5210000	;	int clone28_alloy	 =	1300000	;	int clone28_time	 =	896400	;
    int clone29_fuel	 =	71100000	;	int clone29_food	 =	71100000	;	int clone29_steel	 =	6770000	;	int clone29_alloy	 =	1690000	;	int clone29_time	 =	1029600	;
    int clone30_fuel	 =	92400000	;	int clone30_food	 =	92400000	;	int clone30_steel	 =	8800000	;	int clone30_alloy	 =	2200000	;	int clone30_time	 =	1184400	;

    //--------------------------------------------------------------------------
    int comm1_fuel	 =	303	;	int comm1_food	 =	0	;	int comm1_steel	 =	0	;	int comm1_alloy	 =	0	;	int comm1_time	 =	35	;
    int comm2_fuel	 =	424	;	int comm2_food	 =	0	;	int comm2_steel	 =	0	;	int comm2_alloy	 =	0	;	int comm2_time	 =	326	;
    int comm3_fuel	 =	593	;	int comm3_food	 =	0	;	int comm3_steel	 =	0	;	int comm3_alloy	 =	0	;	int comm3_time	 =	269	;
    int comm4_fuel	 =	889	;	int comm4_food	 =	0	;	int comm4_steel	 =	0	;	int comm4_alloy	 =	0	;	int comm4_time	 =	279	;
    int comm5_fuel	 =	1420	;	int comm5_food	 =	0	;	int comm5_steel	 =	0	;	int comm5_alloy	 =	0	;	int comm5_time	 =	590	;
    int comm6_fuel	 =	2560	;	int comm6_food	 =	0	;	int comm6_steel	 =	0	;	int comm6_alloy	 =	0	;	int comm6_time	 =	2930	;
    int comm7_fuel	 =	4870	;	int comm7_food	 =	0	;	int comm7_steel	 =	0	;	int comm7_alloy	 =	0	;	int comm7_time	 =	7180	;
    int comm8_fuel	 =	9730	;	int comm8_food	 =	0	;	int comm8_steel	 =	0	;	int comm8_alloy	 =	0	;	int comm8_time	 =	9300	;
    int comm9_fuel	 =	19500	;	int comm9_food	 =	0	;	int comm9_steel	 =	0	;	int comm9_alloy	 =	0	;	int comm9_time	 =	11400	;
    int comm10_fuel	 =	38900	;	int comm10_food	 =	0	;	int comm10_steel	 =	0	;	int comm10_alloy	 =	0	;	int comm10_time	 =	13500	;
    int comm11_fuel	 =	77900	;	int comm11_food	 =	0	;	int comm11_steel	 =	8110	;	int comm11_alloy	 =	0	;	int comm11_time	 =	16500	;
    int comm12_fuel	 =	156000	;	int comm12_food	 =	0	;	int comm12_steel	 =	16200	;	int comm12_alloy	 =	0	;	int comm12_time	 =	20400	;
    int comm13_fuel	 =	296000	;	int comm13_food	 =	0	;	int comm13_steel	 =	30800	;	int comm13_alloy	 =	0	;	int comm13_time	 =	25500	;
    int comm14_fuel	 =	533000	;	int comm14_food	 =	0	;	int comm14_steel	 =	55500	;	int comm14_alloy	 =	0	;	int comm14_time	 =	32400	;
    int comm15_fuel	 =	799000	;	int comm15_food	 =	0	;	int comm15_steel	 =	83200	;	int comm15_alloy	 =	0	;	int comm15_time	 =	39600	;
    int comm16_fuel	 =	1120000	;	int comm16_food	 =	0	;	int comm16_steel	 =	117000	;	int comm16_alloy	 =	17500	;	int comm16_time	 =	50400	;
    int comm17_fuel	 =	1570000	;	int comm17_food	 =	0	;	int comm17_steel	 =	163000	;	int comm17_alloy	 =	24500	;	int comm17_time	 =	61200	;
    int comm18_fuel	 =	2040000	;	int comm18_food	 =	0	;	int comm18_steel	 =	212000	;	int comm18_alloy	 =	31800	;	int comm18_time	 =	79200	;
    int comm19_fuel	 =	2650000	;	int comm19_food	 =	0	;	int comm19_steel	 =	276000	;	int comm19_alloy	 =	41300	;	int comm19_time	 =	97200	;
    int comm20_fuel	 =	3440000	;	int comm20_food	 =	0	;	int comm20_steel	 =	358000	;	int comm20_alloy	 =	53800	;	int comm20_time	 =	122400	;
    int comm21_fuel	 =	4470000	;	int comm21_food	 =	0	;	int comm21_steel	 =	466000	;	int comm21_alloy	 =	69900	;	int comm21_time	 =	140400	;
    int comm22_fuel	 =	5810000	;	int comm22_food	 =	0	;	int comm22_steel	 =	606000	;	int comm22_alloy	 =	90800	;	int comm22_time	 =	162000	;
    int comm23_fuel	 =	7560000	;	int comm23_food	 =	0	;	int comm23_steel	 =	787000	;	int comm23_alloy	 =	118000	;	int comm23_time	 =	187200	;
    int comm24_fuel	 =	9830000	;	int comm24_food	 =	0	;	int comm24_steel	 =	1020000	;	int comm24_alloy	 =	154000	;	int comm24_time	 =	212400	;
    int comm25_fuel	 =	12800000	;	int comm25_food	 =	0	;	int comm25_steel	 =	1330000	;	int comm25_alloy	 =	200000	;	int comm25_time	 =	244800	;
    int comm26_fuel	 =	16600000	;	int comm26_food	 =	0	;	int comm26_steel	 =	1730000	;	int comm26_alloy	 =	259000	;	int comm26_time	 =	280800	;
    int comm27_fuel	 =	21600000	;	int comm27_food	 =	0	;	int comm27_steel	 =	2250000	;	int comm27_alloy	 =	337000	;	int comm27_time	 =	324000	;
    int comm28_fuel	 =	28100000	;	int comm28_food	 =	0	;	int comm28_steel	 =	2920000	;	int comm28_alloy	 =	438000	;	int comm28_time	 =	374400	;
    int comm29_fuel	 =	36500000	;	int comm29_food	 =	0	;	int comm29_steel	 =	3800000	;	int comm29_alloy	 =	570000	;	int comm29_time	 =	428400	;
    int comm30_fuel	 =	47400000	;	int comm30_food	 =	0	;	int comm30_steel	 =	4940000	;	int comm30_alloy	 =	741000	;	int comm30_time	 =	493500	;

    //--------------------------------------------------------------------------
    int dorm1_fuel	 =	341	;	int dorm1_food	 =	-1	;	int dorm1_steel	 =	0	;	int dorm1_alloy	 =	0	;	int dorm1_time	 =	3	;
    int dorm2_fuel	 =	477	;	int dorm2_food	 =	0	;	int dorm2_steel	 =	0	;	int dorm2_alloy	 =	0	;	int dorm2_time	 =	326	;
    int dorm3_fuel	 =	668	;	int dorm3_food	 =	0	;	int dorm3_steel	 =	0	;	int dorm3_alloy	 =	0	;	int dorm3_time	 =	428	;
    int dorm4_fuel	 =	1000	;	int dorm4_food	 =	0	;	int dorm4_steel	 =	0	;	int dorm4_alloy	 =	0	;	int dorm4_time	 =	721	;
    int dorm5_fuel	 =	1600	;	int dorm5_food	 =	0	;	int dorm5_steel	 =	0	;	int dorm5_alloy	 =	0	;	int dorm5_time	 =	1163	;
    int dorm6_fuel	 =	2880	;	int dorm6_food	 =	0	;	int dorm6_steel	 =	0	;	int dorm6_alloy	 =	0	;	int dorm6_time	 =	2930	;
    int dorm7_fuel	 =	5480	;	int dorm7_food	 =	0	;	int dorm7_steel	 =	0	;	int dorm7_alloy	 =	0	;	int dorm7_time	 =	7200	;
    int dorm8_fuel	 =	11000	;	int dorm8_food	 =	0	;	int dorm8_steel	 =	0	;	int dorm8_alloy	 =	0	;	int dorm8_time	 =	12000	;
    int dorm9_fuel	 =	21900	;	int dorm9_food	 =	0	;	int dorm9_steel	 =	0	;	int dorm9_alloy	 =	0	;	int dorm9_time	 =	14400	;
    int dorm10_fuel	 =	43900	;	int dorm10_food	 =	0	;	int dorm10_steel	 =	0	;	int dorm10_alloy	 =	0	;	int dorm10_time	 =	17400	;
    int dorm11_fuel	 =	87700	;	int dorm11_food	 =	0	;	int dorm11_steel	 =	12200	;	int dorm11_alloy	 =	0	;	int dorm11_time	 =	21000	;
    int dorm12_fuel	 =	175000	;	int dorm12_food	 =	0	;	int dorm12_steel	 =	24400	;	int dorm12_alloy	 =	0	;	int dorm12_time	 =	26100	;
    int dorm13_fuel	 =	333000	;	int dorm13_food	 =	0	;	int dorm13_steel	 =	46300	;	int dorm13_alloy	 =	0	;	int dorm13_time	 =	32400	;
    int dorm14_fuel	 =	600000	;	int dorm14_food	 =	0	;	int dorm14_steel	 =	83300	;	int dorm14_alloy	 =	0	;	int dorm14_time	 =	39600	;
    int dorm15_fuel	 =	900000	;	int dorm15_food	 =	0	;	int dorm15_steel	 =	125000	;	int dorm15_alloy	 =	0	;	int dorm15_time	 =	50400	;
    int dorm16_fuel	 =	1260000	;	int dorm16_food	 =	0	;	int dorm16_steel	 =	175000	;	int dorm16_alloy	 =	26200	;	int dorm16_time	 =	64800	;
    int dorm17_fuel	 =	1760000	;	int dorm17_food	 =	0	;	int dorm17_steel	 =	245000	;	int dorm17_alloy	 =	36700	;	int dorm17_time	 =	79200	;
    int dorm18_fuel	 =	2290000	;	int dorm18_food	 =	0	;	int dorm18_steel	 =	318000	;	int dorm18_alloy	 =	47800	;	int dorm18_time	 =	100800	;
    int dorm19_fuel	 =	2980000	;	int dorm19_food	 =	0	;	int dorm19_steel	 =	414000	;	int dorm19_alloy	 =	62100	;	int dorm19_time	 =	126000	;
    int dorm20_fuel	 =	3870000	;	int dorm20_food	 =	0	;	int dorm20_steel	 =	538000	;	int dorm20_alloy	 =	80700	;	int dorm20_time	 =	154800	;
    int dorm21_fuel	 =	5040000	;	int dorm21_food	 =	0	;	int dorm21_steel	 =	700000	;	int dorm21_alloy	 =	105000	;	int dorm21_time	 =	180000	;
    int dorm22_fuel	 =	6550000	;	int dorm22_food	 =	0	;	int dorm22_steel	 =	909000	;	int dorm22_alloy	 =	136000	;	int dorm22_time	 =	205200	;
    int dorm23_fuel	 =	8510000	;	int dorm23_food	 =	0	;	int dorm23_steel	 =	1180000	;	int dorm23_alloy	 =	177000	;	int dorm23_time	 =	237600	;
    int dorm24_fuel	 =	11100000	;	int dorm24_food	 =	0	;	int dorm24_steel	 =	1540000	;	int dorm24_alloy	 =	231000	;	int dorm24_time	 =	273600	;
    int dorm25_fuel	 =	14400000	;	int dorm25_food	 =	0	;	int dorm25_steel	 =	2000000	;	int dorm25_alloy	 =	300000	;	int dorm25_time	 =	313200	;
    int dorm26_fuel	 =	18700000	;	int dorm26_food	 =	0	;	int dorm26_steel	 =	2600000	;	int dorm26_alloy	 =	390000	;	int dorm26_time	 =	360000	;
    int dorm27_fuel	 =	24300000	;	int dorm27_food	 =	0	;	int dorm27_steel	 =	3380000	;	int dorm27_alloy	 =	507000	;	int dorm27_time	 =	414000	;
    int dorm28_fuel	 =	31600000	;	int dorm28_food	 =	0	;	int dorm28_steel	 =	4390000	;	int dorm28_alloy	 =	658000	;	int dorm28_time	 =	478800	;
    int dorm29_fuel	 =	41100000	;	int dorm29_food	 =	0	;	int dorm29_steel	 =	5710000	;	int dorm29_alloy	 =	856000	;	int dorm29_time	 =	547200	;
    int dorm30_fuel	 =	53400000	;	int dorm30_food	 =	0	;	int dorm30_steel	 =	7420000	;	int dorm30_alloy	 =	1110000	;	int dorm30_time	 =	631200	;

    //--------------------------------------------------------------------------
    int embassy1_fuel	 =	721	;	int embassy1_food	 =	0	;	int embassy1_steel	 =	0	;	int embassy1_alloy	 =	0	;	int embassy1_time	 =	585	;
    int embassy2_fuel	 =	1010	;	int embassy2_food	 =	0	;	int embassy2_steel	 =	0	;	int embassy2_alloy	 =	0	;	int embassy2_time	 =	326	;
    int embassy3_fuel	 =	1410	;	int embassy3_food	 =	0	;	int embassy3_steel	 =	0	;	int embassy3_alloy	 =	0	;	int embassy3_time	 =	428	;
    int embassy4_fuel	 =	2120	;	int embassy4_food	 =	0	;	int embassy4_steel	 =	0	;	int embassy4_alloy	 =	0	;	int embassy4_time	 =	721	;
    int embassy5_fuel	 =	3390	;	int embassy5_food	 =	0	;	int embassy5_steel	 =	0	;	int embassy5_alloy	 =	0	;	int embassy5_time	 =	1163	;
    int embassy6_fuel	 =	6100	;	int embassy6_food	 =	0	;	int embassy6_steel	 =	0	;	int embassy6_alloy	 =	0	;	int embassy6_time	 =	2930	;
    int embassy7_fuel	 =	11600	;	int embassy7_food	 =	0	;	int embassy7_steel	 =	0	;	int embassy7_alloy	 =	0	;	int embassy7_time	 =	6600	;
    int embassy8_fuel	 =	23200	;	int embassy8_food	 =	0	;	int embassy8_steel	 =	0	;	int embassy8_alloy	 =	0	;	int embassy8_time	 =	11100	;
    int embassy9_fuel	 =	46400	;	int embassy9_food	 =	0	;	int embassy9_steel	 =	0	;	int embassy9_alloy	 =	0	;	int embassy9_time	 =	13200	;
    int embassy10_fuel	 =	92800	;	int embassy10_food	 =	0	;	int embassy10_steel	 =	0	;	int embassy10_alloy	 =	0	;	int embassy10_time	 =	15900	;
    int embassy11_fuel	 =	92800	;	int embassy11_food	 =	0	;	int embassy11_steel	 =	15500	;	int embassy11_alloy	 =	0	;	int embassy11_time	 =	19200	;
    int embassy12_fuel	 =	186000	;	int embassy12_food	 =	0	;	int embassy12_steel	 =	30900	;	int embassy12_alloy	 =	0	;	int embassy12_time	 =	24000	;
    int embassy13_fuel	 =	353000	;	int embassy13_food	 =	0	;	int embassy13_steel	 =	58800	;	int embassy13_alloy	 =	0	;	int embassy13_time	 =	28800	;
    int embassy14_fuel	 =	635000	;	int embassy14_food	 =	0	;	int embassy14_steel	 =	106000	;	int embassy14_alloy	 =	0	;	int embassy14_time	 =	36000	;
    int embassy15_fuel	 =	952000	;	int embassy15_food	 =	0	;	int embassy15_steel	 =	159000	;	int embassy15_alloy	 =	0	;	int embassy15_time	 =	46800	;
    int embassy16_fuel	 =	889000	;	int embassy16_food	 =	0	;	int embassy16_steel	 =	148000	;	int embassy16_alloy	 =	37000	;	int embassy16_time	 =	57600	;
    int embassy17_fuel	 =	1240000	;	int embassy17_food	 =	0	;	int embassy17_steel	 =	207000	;	int embassy17_alloy	 =	51800	;	int embassy17_time	 =	72000	;
    int embassy18_fuel	 =	1620000	;	int embassy18_food	 =	0	;	int embassy18_steel	 =	270000	;	int embassy18_alloy	 =	67400	;	int embassy18_time	 =	90000	;
    int embassy19_fuel	 =	2100000	;	int embassy19_food	 =	0	;	int embassy19_steel	 =	350000	;	int embassy19_alloy	 =	87600	;	int embassy19_time	 =	115200	;
    int embassy20_fuel	 =	2730000	;	int embassy20_food	 =	0	;	int embassy20_steel	 =	456000	;	int embassy20_alloy	 =	114000	;	int embassy20_time	 =	144000	;
    int embassy21_fuel	 =	3550000	;	int embassy21_food	 =	0	;	int embassy21_steel	 =	592000	;	int embassy21_alloy	 =	148000	;	int embassy21_time	 =	165600	;
    int embassy22_fuel	 =	4620000	;	int embassy22_food	 =	0	;	int embassy22_steel	 =	770000	;	int embassy22_alloy	 =	192000	;	int embassy22_time	 =	187200	;
    int embassy23_fuel	 =	6000000	;	int embassy23_food	 =	0	;	int embassy23_steel	 =	1000000	;	int embassy23_alloy	 =	250000	;	int embassy23_time	 =	216000	;
    int embassy24_fuel	 =	7810000	;	int embassy24_food	 =	0	;	int embassy24_steel	 =	1300000	;	int embassy24_alloy	 =	325000	;	int embassy24_time	 =	248400	;
    int embassy25_fuel	 =	10100000	;	int embassy25_food	 =	0	;	int embassy25_steel	 =	1690000	;	int embassy25_alloy	 =	423000	;	int embassy25_time	 =	288000	;
    int embassy26_fuel	 =	13200000	;	int embassy26_food	 =	0	;	int embassy26_steel	 =	2200000	;	int embassy26_alloy	 =	550000	;	int embassy26_time	 =	331200	;
    int embassy27_fuel	 =	17200000	;	int embassy27_food	 =	0	;	int embassy27_steel	 =	2860000	;	int embassy27_alloy	 =	715000	;	int embassy27_time	 =	381600	;
    int embassy28_fuel	 =	22300000	;	int embassy28_food	 =	0	;	int embassy28_steel	 =	3720000	;	int embassy28_alloy	 =	929000	;	int embassy28_time	 =	435600	;
    int embassy29_fuel	 =	29000000	;	int embassy29_food	 =	0	;	int embassy29_steel	 =	4830000	;	int embassy29_alloy	 =	1210000	;	int embassy29_time	 =	504000	;
    int embassy30_fuel	 =	37700000	;	int embassy30_food	 =	0	;	int embassy30_steel	 =	6280000	;	int embassy30_alloy	 =	1570000	;	int embassy30_time	 =	578100	;

    //--------------------------------------------------------------------------
    int farm1_fuel	=	100	;	int farm_time1	=	2	;	int farm1_glory_mark	=	0	;	int farm1_kyanite	=	0	;	int farm1_kyanite_basic	=	0	;	int farm1_kyanite_cluster	=	0	;
    int farm2_fuel	=	140	;	int farm_time2	=	150	;	int farm2_glory_mark	=	0	;	int farm2_kyanite	=	0	;	int farm2_kyanite_basic	=	0	;	int farm2_kyanite_cluster	=	0	;
    int farm3_fuel	=	196	;	int farm_time3	=	285	;	int farm3_glory_mark	=	0	;	int farm3_kyanite	=	0	;	int farm3_kyanite_basic	=	0	;	int farm3_kyanite_cluster	=	0	;
    int farm4_fuel	=	294	;	int farm_time4	=	395	;	int farm4_glory_mark	=	0	;	int farm4_kyanite	=	0	;	int farm4_kyanite_basic	=	0	;	int farm4_kyanite_cluster	=	0	;
    int farm5_fuel	=	470	;	int farm_time5	=	585	;	int farm5_glory_mark	=	0	;	int farm5_kyanite	=	0	;	int farm5_kyanite_basic	=	0	;	int farm5_kyanite_cluster	=	0	;
    int farm6_fuel	=	847	;	int farm_time6	=	590	;	int farm6_glory_mark	=	0	;	int farm6_kyanite	=	0	;	int farm6_kyanite_basic	=	0	;	int farm6_kyanite_cluster	=	0	;
    int farm7_fuel	=	1610	;	int farm_time7	=	890	;	int farm7_glory_mark	=	0	;	int farm7_kyanite	=	0	;	int farm7_kyanite_basic	=	0	;	int farm7_kyanite_cluster	=	0	;
    int farm8_fuel	=	3220	;	int farm_time8	=	1500	;	int farm8_glory_mark	=	0	;	int farm8_kyanite	=	0	;	int farm8_kyanite_basic	=	0	;	int farm8_kyanite_cluster	=	0	;
    int farm9_fuel	=	6440	;	int farm_time9	=	1800	;	int farm9_glory_mark	=	0	;	int farm9_kyanite	=	0	;	int farm9_kyanite_basic	=	0	;	int farm9_kyanite_cluster	=	0	;
    int farm10_fuel	=	12900	;	int farm_time10	=	2700	;	int farm10_glory_mark	=	0	;	int farm10_kyanite	=	0	;	int farm10_kyanite_basic	=	0	;	int farm10_kyanite_cluster	=	0	;
    int farm11_fuel	=	25700	;	int farm_time11	=	3300	;	int farm11_glory_mark	=	0	;	int farm11_kyanite	=	0	;	int farm11_kyanite_basic	=	0	;	int farm11_kyanite_cluster	=	0	;
    int farm12_fuel	=	51500	;	int farm_time12	=	4200	;	int farm12_glory_mark	=	0	;	int farm12_kyanite	=	0	;	int farm12_kyanite_basic	=	0	;	int farm12_kyanite_cluster	=	0	;
    int farm13_fuel	=	97800	;	int farm_time13	=	5100	;	int farm13_glory_mark	=	0	;	int farm13_kyanite	=	0	;	int farm13_kyanite_basic	=	0	;	int farm13_kyanite_cluster	=	0	;
    int farm14_fuel	=	176000	;	int farm_time14	=	6300	;	int farm14_glory_mark	=	0	;	int farm14_kyanite	=	0	;	int farm14_kyanite_basic	=	0	;	int farm14_kyanite_cluster	=	0	;
    int farm15_fuel	=	264000	;	int farm_time15	=	7800	;	int farm15_glory_mark	=	0	;	int farm15_kyanite	=	0	;	int farm15_kyanite_basic	=	0	;	int farm15_kyanite_cluster	=	0	;
    int farm16_fuel	=	370000	;	int farm_time16	=	9900	;	int farm16_glory_mark	=	0	;	int farm16_kyanite	=	0	;	int farm16_kyanite_basic	=	0	;	int farm16_kyanite_cluster	=	0	;
    int farm17_fuel	=	518000	;	int farm_time17	=	12300	;	int farm17_glory_mark	=	0	;	int farm17_kyanite	=	0	;	int farm17_kyanite_basic	=	0	;	int farm17_kyanite_cluster	=	0	;
    int farm18_fuel	=	673000	;	int farm_time18	=	15600	;	int farm18_glory_mark	=	0	;	int farm18_kyanite	=	0	;	int farm18_kyanite_basic	=	0	;	int farm18_kyanite_cluster	=	0	;
    int farm19_fuel	=	875000	;	int farm_time19	=	19200	;	int farm19_glory_mark	=	0	;	int farm19_kyanite	=	0	;	int farm19_kyanite_basic	=	0	;	int farm19_kyanite_cluster	=	0	;
    int farm20_fuel	=	1140000	;	int farm_time20	=	24000	;	int farm20_glory_mark	=	0	;	int farm20_kyanite	=	0	;	int farm20_kyanite_basic	=	0	;	int farm20_kyanite_cluster	=	0	;
    int farm21_fuel	=	1480000	;	int farm_time21	=	27900	;	int farm21_glory_mark	=	0	;	int farm21_kyanite	=	0	;	int farm21_kyanite_basic	=	0	;	int farm21_kyanite_cluster	=	0	;
    int farm22_fuel	=	1920000	;	int farm_time22	=	31800	;	int farm22_glory_mark	=	0	;	int farm22_kyanite	=	0	;	int farm22_kyanite_basic	=	0	;	int farm22_kyanite_cluster	=	0	;
    int farm23_fuel	=	2500000	;	int farm_time23	=	36600	;	int farm23_glory_mark	=	0	;	int farm23_kyanite	=	0	;	int farm23_kyanite_basic	=	0	;	int farm23_kyanite_cluster	=	0	;
    int farm24_fuel	=	3250000	;	int farm_time24	=	42300	;	int farm24_glory_mark	=	0	;	int farm24_kyanite	=	0	;	int farm24_kyanite_basic	=	0	;	int farm24_kyanite_cluster	=	0	;
    int farm25_fuel	=	4220000	;	int farm_time25	=	46800	;	int farm25_glory_mark	=	0	;	int farm25_kyanite	=	0	;	int farm25_kyanite_basic	=	0	;	int farm25_kyanite_cluster	=	0	;
    int farm26_fuel	=	5490000	;	int farm_time26	=	57600	;	int farm26_glory_mark	=	0	;	int farm26_kyanite	=	0	;	int farm26_kyanite_basic	=	0	;	int farm26_kyanite_cluster	=	0	;
    int farm27_fuel	=	7140000	;	int farm_time27	=	64800	;	int farm27_glory_mark	=	0	;	int farm27_kyanite	=	0	;	int farm27_kyanite_basic	=	0	;	int farm27_kyanite_cluster	=	0	;
    int farm28_fuel	=	9280000	;	int farm_time28	=	75600	;	int farm28_glory_mark	=	0	;	int farm28_kyanite	=	0	;	int farm28_kyanite_basic	=	0	;	int farm28_kyanite_cluster	=	0	;
    int farm29_fuel	=	12100000	;	int farm_time29	=	86400	;	int farm29_glory_mark	=	0	;	int farm29_kyanite	=	0	;	int farm29_kyanite_basic	=	0	;	int farm29_kyanite_cluster	=	0	;
    int farm30_fuel	=	15700000	;	int farm_time30	=	97800	;	int farm30_glory_mark	=	0	;	int farm30_kyanite	=	0	;	int farm30_kyanite_basic	=	0	;	int farm30_kyanite_cluster	=	0	;
    int farm31_fuel	=	68030942	;	int farm_time31	=	534811	;	int farm31_glory_mark	=	48948	;	int farm31_kyanite	=	56239	;	int farm31_kyanite_basic	=	78109	;	int farm31_kyanite_cluster	=	6249	;
    int farm32_fuel	=	94172376	;	int farm_time32	=	619988	;	int farm32_glory_mark	=	54745	;	int farm32_kyanite	=	62897	;	int farm32_kyanite_basic	=	87358	;	int farm32_kyanite_cluster	=	6988	;
    int farm33_fuel	=	110358595	;	int farm_time33	=	718734	;	int farm33_glory_mark	=	64154	;	int farm33_kyanite	=	73709	;	int farm33_kyanite_basic	=	102373	;	int farm33_kyanite_cluster	=	8189	;
    int farm34_fuel	=	146574286	;	int farm_time34	=	833209	;	int farm34_glory_mark	=	85208	;	int farm34_kyanite	=	97898	;	int farm34_kyanite_basic	=	135969	;	int farm34_kyanite_cluster	=	10878	;
    int farm35_fuel	=	282567670	;	int farm_time35	=	965917	;	int farm35_glory_mark	=	164263	;	int farm35_kyanite	=	188728	;	int farm35_kyanite_basic	=	262122	;	int farm35_kyanite_cluster	=	20969	;

    //--------------------------------------------------------------------------
    int infection1_fuel	 =	74	;	int infection1_food	 =	74	;	int infection1_steel	 =	0	;	int infection1_alloy	 =	0	;	int infection1_virus	 =	1	;	int infection1_time	 =	99	;	int infection1_glory_mark	=	0	;	int infection1_kyanite	=	0	;	int infection1_kyanite_basic	=	0	;	int infection1_kyanite_cluster	=	0	;
    int infection2_fuel	 =	104	;	int infection2_food	 =	104	;	int infection2_steel	 =	0	;	int infection2_alloy	 =	0	;	int infection2_virus	 =	5	;	int infection2_time	 =	326	;	int infection2_glory_mark	=	0	;	int infection2_kyanite	=	0	;	int infection2_kyanite_basic	=	0	;	int infection2_kyanite_cluster	=	0	;
    int infection3_fuel	 =	145	;	int infection3_food	 =	145	;	int infection3_steel	 =	0	;	int infection3_alloy	 =	0	;	int infection3_virus	 =	10	;	int infection3_time	 =	428	;	int infection3_glory_mark	=	0	;	int infection3_kyanite	=	0	;	int infection3_kyanite_basic	=	0	;	int infection3_kyanite_cluster	=	0	;
    int infection4_fuel	 =	218	;	int infection4_food	 =	218	;	int infection4_steel	 =	0	;	int infection4_alloy	 =	0	;	int infection4_virus	 =	30	;	int infection4_time	 =	721	;	int infection4_glory_mark	=	0	;	int infection4_kyanite	=	0	;	int infection4_kyanite_basic	=	0	;	int infection4_kyanite_cluster	=	0	;
    int infection5_fuel	 =	348	;	int infection5_food	 =	348	;	int infection5_steel	 =	0	;	int infection5_alloy	 =	0	;	int infection5_virus	 =	40	;	int infection5_time	 =	1163	;	int infection5_glory_mark	=	0	;	int infection5_kyanite	=	0	;	int infection5_kyanite_basic	=	0	;	int infection5_kyanite_cluster	=	0	;
    int infection6_fuel	 =	627	;	int infection6_food	 =	627	;	int infection6_steel	 =	0	;	int infection6_alloy	 =	0	;	int infection6_virus	 =	50	;	int infection6_time	 =	2930	;	int infection6_glory_mark	=	0	;	int infection6_kyanite	=	0	;	int infection6_kyanite_basic	=	0	;	int infection6_kyanite_cluster	=	0	;
    int infection7_fuel	 =	1190	;	int infection7_food	 =	1190	;	int infection7_steel	 =	0	;	int infection7_alloy	 =	0	;	int infection7_virus	 =	100	;	int infection7_time	 =	16200	;	int infection7_glory_mark	=	0	;	int infection7_kyanite	=	0	;	int infection7_kyanite_basic	=	0	;	int infection7_kyanite_cluster	=	0	;
    int infection8_fuel	 =	2380	;	int infection8_food	 =	2380	;	int infection8_steel	 =	0	;	int infection8_alloy	 =	0	;	int infection8_virus	 =	140	;	int infection8_time	 =	22800	;	int infection8_glory_mark	=	0	;	int infection8_kyanite	=	0	;	int infection8_kyanite_basic	=	0	;	int infection8_kyanite_cluster	=	0	;
    int infection9_fuel	 =	4770	;	int infection9_food	 =	4770	;	int infection9_steel	 =	0	;	int infection9_alloy	 =	0	;	int infection9_virus	 =	180	;	int infection9_time	 =	27300	;	int infection9_glory_mark	=	0	;	int infection9_kyanite	=	0	;	int infection9_kyanite_basic	=	0	;	int infection9_kyanite_cluster	=	0	;
    int infection10_fuel	 =	9530	;	int infection10_food	 =	9530	;	int infection10_steel	 =	0	;	int infection10_alloy	 =	0	;	int infection10_virus	 =	300	;	int infection10_time	 =	32700	;	int infection10_glory_mark	=	0	;	int infection10_kyanite	=	0	;	int infection10_kyanite_basic	=	0	;	int infection10_kyanite_cluster	=	0	;
    int infection11_fuel	 =	19100	;	int infection11_food	 =	19100	;	int infection11_steel	 =	6360	;	int infection11_alloy	 =	0	;	int infection11_virus	 =	360	;	int infection11_time	 =	39600	;	int infection11_glory_mark	=	0	;	int infection11_kyanite	=	0	;	int infection11_kyanite_basic	=	0	;	int infection11_kyanite_cluster	=	0	;
    int infection12_fuel	 =	38100	;	int infection12_food	 =	38100	;	int infection12_steel	 =	12700	;	int infection12_alloy	 =	0	;	int infection12_virus	 =	420	;	int infection12_time	 =	50400	;	int infection12_glory_mark	=	0	;	int infection12_kyanite	=	0	;	int infection12_kyanite_basic	=	0	;	int infection12_kyanite_cluster	=	0	;
    int infection13_fuel	 =	72500	;	int infection13_food	 =	72500	;	int infection13_steel	 =	24200	;	int infection13_alloy	 =	0	;	int infection13_virus	 =	800	;	int infection13_time	 =	61200	;	int infection13_glory_mark	=	0	;	int infection13_kyanite	=	0	;	int infection13_kyanite_basic	=	0	;	int infection13_kyanite_cluster	=	0	;
    int infection14_fuel	 =	130000	;	int infection14_food	 =	130000	;	int infection14_steel	 =	43500	;	int infection14_alloy	 =	0	;	int infection14_virus	 =	900	;	int infection14_time	 =	75600	;	int infection14_glory_mark	=	0	;	int infection14_kyanite	=	0	;	int infection14_kyanite_basic	=	0	;	int infection14_kyanite_cluster	=	0	;
    int infection15_fuel	 =	196000	;	int infection15_food	 =	196000	;	int infection15_steel	 =	65200	;	int infection15_alloy	 =	0	;	int infection15_virus	 =	1000	;	int infection15_time	 =	97200	;	int infection15_glory_mark	=	0	;	int infection15_kyanite	=	0	;	int infection15_kyanite_basic	=	0	;	int infection15_kyanite_cluster	=	0	;
    int infection16_fuel	 =	274000	;	int infection16_food	 =	274000	;	int infection16_steel	 =	91300	;	int infection16_alloy	 =	571	;	int infection16_virus	 =	1500	;	int infection16_time	 =	118800	;	int infection16_glory_mark	=	0	;	int infection16_kyanite	=	0	;	int infection16_kyanite_basic	=	0	;	int infection16_kyanite_cluster	=	0	;
    int infection17_fuel	 =	383000	;	int infection17_food	 =	383000	;	int infection17_steel	 =	128000	;	int infection17_alloy	 =	799	;	int infection17_virus	 =	1650	;	int infection17_time	 =	151200	;	int infection17_glory_mark	=	0	;	int infection17_kyanite	=	0	;	int infection17_kyanite_basic	=	0	;	int infection17_kyanite_cluster	=	0	;
    int infection18_fuel	 =	498000	;	int infection18_food	 =	498000	;	int infection18_steel	 =	166000	;	int infection18_alloy	 =	1040	;	int infection18_virus	 =	1800	;	int infection18_time	 =	187200	;	int infection18_glory_mark	=	0	;	int infection18_kyanite	=	0	;	int infection18_kyanite_basic	=	0	;	int infection18_kyanite_cluster	=	0	;
    int infection19_fuel	 =	648000	;	int infection19_food	 =	648000	;	int infection19_steel	 =	216000	;	int infection19_alloy	 =	1350	;	int infection19_virus	 =	2500	;	int infection19_time	 =	234000	;	int infection19_glory_mark	=	0	;	int infection19_kyanite	=	0	;	int infection19_kyanite_basic	=	0	;	int infection19_kyanite_cluster	=	0	;
    int infection20_fuel	 =	842000	;	int infection20_food	 =	842000	;	int infection20_steel	 =	281000	;	int infection20_alloy	 =	1750	;	int infection20_virus	 =	2750	;	int infection20_time	 =	291600	;	int infection20_glory_mark	=	0	;	int infection20_kyanite	=	0	;	int infection20_kyanite_basic	=	0	;	int infection20_kyanite_cluster	=	0	;
    int infection21_fuel	 =	1100000	;	int infection21_food	 =	1100000	;	int infection21_steel	 =	365000	;	int infection21_alloy	 =	2280	;	int infection21_virus	 =	3000	;	int infection21_time	 =	338400	;	int infection21_glory_mark	=	0	;	int infection21_kyanite	=	0	;	int infection21_kyanite_basic	=	0	;	int infection21_kyanite_cluster	=	0	;
    int infection22_fuel	 =	1420000	;	int infection22_food	 =	1420000	;	int infection22_steel	 =	475000	;	int infection22_alloy	 =	2970	;	int infection22_virus	 =	4000	;	int infection22_time	 =	388800	;	int infection22_glory_mark	=	0	;	int infection22_kyanite	=	0	;	int infection22_kyanite_basic	=	0	;	int infection22_kyanite_cluster	=	0	;
    int infection23_fuel	 =	1850000	;	int infection23_food	 =	1850000	;	int infection23_steel	 =	617000	;	int infection23_alloy	 =	3860	;	int infection23_virus	 =	4300	;	int infection23_time	 =	446400	;	int infection23_glory_mark	=	0	;	int infection23_kyanite	=	0	;	int infection23_kyanite_basic	=	0	;	int infection23_kyanite_cluster	=	0	;
    int infection24_fuel	 =	2410000	;	int infection24_food	 =	2410000	;	int infection24_steel	 =	802000	;	int infection24_alloy	 =	5010	;	int infection24_virus	 =	4600	;	int infection24_time	 =	511200	;	int infection24_glory_mark	=	0	;	int infection24_kyanite	=	0	;	int infection24_kyanite_basic	=	0	;	int infection24_kyanite_cluster	=	0	;
    int infection25_fuel	 =	3130000	;	int infection25_food	 =	3130000	;	int infection25_steel	 =	1040000	;	int infection25_alloy	 =	6520	;	int infection25_virus	 =	5000	;	int infection25_time	 =	590400	;	int infection25_glory_mark	=	0	;	int infection25_kyanite	=	0	;	int infection25_kyanite_basic	=	0	;	int infection25_kyanite_cluster	=	0	;
    int infection26_fuel	 =	4070000	;	int infection26_food	 =	4070000	;	int infection26_steel	 =	1360000	;	int infection26_alloy	 =	8470	;	int infection26_virus	 =	8000	;	int infection26_time	 =	676800	;	int infection26_glory_mark	=	0	;	int infection26_kyanite	=	0	;	int infection26_kyanite_basic	=	0	;	int infection26_kyanite_cluster	=	0	;
    int infection27_fuel	 =	5290000	;	int infection27_food	 =	5290000	;	int infection27_steel	 =	1760000	;	int infection27_alloy	 =	11000	;	int infection27_virus	 =	8500	;	int infection27_time	 =	777600	;	int infection27_glory_mark	=	0	;	int infection27_kyanite	=	0	;	int infection27_kyanite_basic	=	0	;	int infection27_kyanite_cluster	=	0	;
    int infection28_fuel	 =	6870000	;	int infection28_food	 =	6870000	;	int infection28_steel	 =	2290000	;	int infection28_alloy	 =	14300	;	int infection28_virus	 =	9000	;	int infection28_time	 =	896400	;	int infection28_glory_mark	=	0	;	int infection28_kyanite	=	0	;	int infection28_kyanite_basic	=	0	;	int infection28_kyanite_cluster	=	0	;
    int infection29_fuel	 =	8930000	;	int infection29_food	 =	8930000	;	int infection29_steel	 =	2980000	;	int infection29_alloy	 =	18600	;	int infection29_virus	 =	10000	;	int infection29_time	 =	1029600	;	int infection29_glory_mark	=	0	;	int infection29_kyanite	=	0	;	int infection29_kyanite_basic	=	0	;	int infection29_kyanite_cluster	=	0	;
    int infection30_fuel	 =	11600000	;	int infection30_food	 =	11600000	;	int infection30_steel	 =	3870000	;	int infection30_alloy	 =	24200	;	int infection30_virus	 =	20000	;	int infection30_time	 =	1184400	;	int infection30_glory_mark	=	0	;	int infection30_kyanite	=	0	;	int infection30_kyanite_basic	=	0	;	int infection30_kyanite_cluster	=	0	;
    int infection31_fuel	 =	120287062	;	int infection31_food	 =	120287062	;	int infection31_steel	 =	20105122	;	int infection31_alloy	 =	161684	;	int infection31_virus	 =	105000	;	int infection31_time	 =	0	;	int infection31_glory_mark	=	171318	;	int infection31_kyanite	=	253072	;	int infection31_kyanite_basic	=	351489	;	int infection31_kyanite_cluster	=	28120	;
    int infection32_fuel	 =	134531967	;	int infection32_food	 =	134531967	;	int infection32_steel	 =	22486056	;	int infection32_alloy	 =	180832	;	int infection32_virus	 =	125000	;	int infection32_time	 =	0	;	int infection32_glory_mark	=	191607	;	int infection32_kyanite	=	283041	;	int infection32_kyanite_basic	=	393112	;	int infection32_kyanite_cluster	=	31449	;
    int infection33_fuel	 =	157655136	;	int infection33_food	 =	157655136	;	int infection33_steel	 =	26350931	;	int infection33_alloy	 =	211913	;	int infection33_virus	 =	157500	;	int infection33_time	 =	0	;	int infection33_glory_mark	=	224540	;	int infection33_kyanite	=	331691	;	int infection33_kyanite_basic	=	460681	;	int infection33_kyanite_cluster	=	36855	;
    int infection34_fuel	 =	209391839	;	int infection34_food	 =	209391839	;	int infection34_steel	 =	34998349	;	int infection34_alloy	 =	281456	;	int infection34_virus	 =	197000	;	int infection34_time	 =	0	;	int infection34_glory_mark	=	298226	;	int infection34_kyanite	=	440539	;	int infection34_kyanite_basic	=	611859	;	int infection34_kyanite_cluster	=	48949	;
    int infection35_fuel	 =	403668100	;	int infection35_food	 =	403668100	;	int infection35_steel	 =	67470239	;	int infection35_alloy	 =	542592	;	int infection35_virus	 =	245000	;	int infection35_time	 =	0	;	int infection35_glory_mark	=	574922	;	int infection35_kyanite	=	849276	;	int infection35_kyanite_basic	=	1179550	;	int infection35_kyanite_cluster	=	94364	;

    //--------------------------------------------------------------------------
    int lab1_fuel	 =	1000	;	int lab1_food	 =	0	;	int lab1_steel	 =	0	;	int lab1_alloy	 =	0	;	int lab1_time	 =	65	;
    int lab2_fuel	 =	1400	;	int lab2_food	 =	0	;	int lab2_steel	 =	0	;	int lab2_alloy	 =	0	;	int lab2_time	 =	326	;
    int lab3_fuel	 =	1960	;	int lab3_food	 =	0	;	int lab3_steel	 =	0	;	int lab3_alloy	 =	0	;	int lab3_time	 =	428	;
    int lab4_fuel	 =	2940	;	int lab4_food	 =	0	;	int lab4_steel	 =	0	;	int lab4_alloy	 =	0	;	int lab4_time	 =	721	;
    int lab5_fuel	 =	4700	;	int lab5_food	 =	0	;	int lab5_steel	 =	0	;	int lab5_alloy	 =	0	;	int lab5_time	 =	1163	;
    int lab6_fuel	 =	8470	;	int lab6_food	 =	0	;	int lab6_steel	 =	0	;	int lab6_alloy	 =	0	;	int lab6_time	 =	2930	;
    int lab7_fuel	 =	16100	;	int lab7_food	 =	0	;	int lab7_steel	 =	0	;	int lab7_alloy	 =	0	;	int lab7_time	 =	10500	;
    int lab8_fuel	 =	32200	;	int lab8_food	 =	0	;	int lab8_steel	 =	0	;	int lab8_alloy	 =	0	;	int lab8_time	 =	15000	;
    int lab9_fuel	 =	64400	;	int lab9_food	 =	0	;	int lab9_steel	 =	0	;	int lab9_alloy	 =	0	;	int lab9_time	 =	18000	;
    int lab10_fuel	 =	129000	;	int lab10_food	 =	0	;	int lab10_steel	 =	0	;	int lab10_alloy	 =	0	;	int lab10_time	 =	21600	;
    int lab11_fuel	 =	172000	;	int lab11_food	 =	0	;	int lab11_steel	 =	14300	;	int lab11_alloy	 =	0	;	int lab11_time	 =	25800	;
    int lab12_fuel	 =	343000	;	int lab12_food	 =	0	;	int lab12_steel	 =	28600	;	int lab12_alloy	 =	0	;	int lab12_time	 =	32400	;
    int lab13_fuel	 =	652000	;	int lab13_food	 =	0	;	int lab13_steel	 =	54300	;	int lab13_alloy	 =	0	;	int lab13_time	 =	39600	;
    int lab14_fuel	 =	1170000	;	int lab14_food	 =	0	;	int lab14_steel	 =	97800	;	int lab14_alloy	 =	0	;	int lab14_time	 =	50400	;
    int lab15_fuel	 =	1760000	;	int lab15_food	 =	0	;	int lab15_steel	 =	147000	;	int lab15_alloy	 =	0	;	int lab15_time	 =	61200	;
    int lab16_fuel	 =	2110000	;	int lab16_food	 =	0	;	int lab16_steel	 =	176000	;	int lab16_alloy	 =	22000	;	int lab16_time	 =	79200	;
    int lab17_fuel	 =	2960000	;	int lab17_food	 =	0	;	int lab17_steel	 =	246000	;	int lab17_alloy	 =	30800	;	int lab17_time	 =	97200	;
    int lab18_fuel	 =	3850000	;	int lab18_food	 =	0	;	int lab18_steel	 =	320000	;	int lab18_alloy	 =	40100	;	int lab18_time	 =	122400	;
    int lab19_fuel	 =	5000000	;	int lab19_food	 =	0	;	int lab19_steel	 =	417000	;	int lab19_alloy	 =	52100	;	int lab19_time	 =	154800	;
    int lab20_fuel	 =	6500000	;	int lab20_food	 =	0	;	int lab20_steel	 =	542000	;	int lab20_alloy	 =	67700	;	int lab20_time	 =	190800	;
    int lab21_fuel	 =	8450000	;	int lab21_food	 =	0	;	int lab21_steel	 =	704000	;	int lab21_alloy	 =	88000	;	int lab21_time	 =	219600	;
    int lab22_fuel	 =	11000000	;	int lab22_food	 =	0	;	int lab22_steel	 =	915000	;	int lab22_alloy	 =	114000	;	int lab22_time	 =	252000	;
    int lab23_fuel	 =	14300000	;	int lab23_food	 =	0	;	int lab23_steel	 =	1190000	;	int lab23_alloy	 =	149000	;	int lab23_time	 =	291600	;
    int lab24_fuel	 =	18600000	;	int lab24_food	 =	0	;	int lab24_steel	 =	1550000	;	int lab24_alloy	 =	193000	;	int lab24_time	 =	334800	;
    int lab25_fuel	 =	24100000	;	int lab25_food	 =	0	;	int lab25_steel	 =	2010000	;	int lab25_alloy	 =	251000	;	int lab25_time	 =	385200	;
    int lab26_fuel	 =	31400000	;	int lab26_food	 =	0	;	int lab26_steel	 =	2610000	;	int lab26_alloy	 =	327000	;	int lab26_time	 =	442800	;
    int lab27_fuel	 =	40800000	;	int lab27_food	 =	0	;	int lab27_steel	 =	3400000	;	int lab27_alloy	 =	425000	;	int lab27_time	 =	511200	;
    int lab28_fuel	 =	53000000	;	int lab28_food	 =	0	;	int lab28_steel	 =	4420000	;	int lab28_alloy	 =	552000	;	int lab28_time	 =	586800	;
    int lab29_fuel	 =	68900000	;	int lab29_food	 =	0	;	int lab29_steel	 =	5740000	;	int lab29_alloy	 =	718000	;	int lab29_time	 =	673200	;
    int lab30_fuel	 =	89600000	;	int lab30_food	 =	0	;	int lab30_steel	 =	7470000	;	int lab30_alloy	 =	933000	;	int lab30_time	 =	775800	;

    //--------------------------------------------------------------------------
    int logist1_fuel	 =	196	;	int logist1_food	 =	98	;	int logist1_steel	 =	0	;	int logist1_alloy	 =	0	;	int logist1_time	 =	34	;
    int logist2_fuel	 =	275	;	int logist2_food	 =	137	;	int logist2_steel	 =	0	;	int logist2_alloy	 =	0	;	int logist2_time	 =	326	;
    int logist3_fuel	 =	385	;	int logist3_food	 =	192	;	int logist3_steel	 =	0	;	int logist3_alloy	 =	0	;	int logist3_time	 =	428	;
    int logist4_fuel	 =	577	;	int logist4_food	 =	289	;	int logist4_steel	 =	0	;	int logist4_alloy	 =	0	;	int logist4_time	 =	721	;
    int logist5_fuel	 =	924	;	int logist5_food	 =	462	;	int logist5_steel	 =	0	;	int logist5_alloy	 =	0	;	int logist5_time	 =	590	;
    int logist6_fuel	 =	1660	;	int logist6_food	 =	831	;	int logist6_steel	 =	0	;	int logist6_alloy	 =	0	;	int logist6_time	 =	2930	;
    int logist7_fuel	 =	3160	;	int logist7_food	 =	1580	;	int logist7_steel	 =	0	;	int logist7_alloy	 =	0	;	int logist7_time	 =	4180	;
    int logist8_fuel	 =	6320	;	int logist8_food	 =	3160	;	int logist8_steel	 =	0	;	int logist8_alloy	 =	0	;	int logist8_time	 =	9300	;
    int logist9_fuel	 =	12600	;	int logist9_food	 =	6320	;	int logist9_steel	 =	0	;	int logist9_alloy	 =	0	;	int logist9_time	 =	11100	;
    int logist10_fuel	 =	25300	;	int logist10_food	 =	12600	;	int logist10_steel	 =	0	;	int logist10_alloy	 =	0	;	int logist10_time	 =	13200	;
    int logist11_fuel	 =	50500	;	int logist11_food	 =	25300	;	int logist11_steel	 =	6320	;	int logist11_alloy	 =	0	;	int logist11_time	 =	15900	;
    int logist12_fuel	 =	101000	;	int logist12_food	 =	50500	;	int logist12_steel	 =	12600	;	int logist12_alloy	 =	0	;	int logist12_time	 =	20100	;
    int logist13_fuel	 =	192000	;	int logist13_food	 =	96000	;	int logist13_steel	 =	24000	;	int logist13_alloy	 =	0	;	int logist13_time	 =	24900	;
    int logist14_fuel	 =	346000	;	int logist14_food	 =	173000	;	int logist14_steel	 =	43200	;	int logist14_alloy	 =	0	;	int logist14_time	 =	32400	;
    int logist15_fuel	 =	519000	;	int logist15_food	 =	259000	;	int logist15_steel	 =	64800	;	int logist15_alloy	 =	0	;	int logist15_time	 =	39600	;
    int logist16_fuel	 =	726000	;	int logist16_food	 =	363000	;	int logist16_steel	 =	90700	;	int logist16_alloy	 =	22700	;	int logist16_time	 =	50400	;
    int logist17_fuel	 =	1020000	;	int logist17_food	 =	508000	;	int logist17_steel	 =	127000	;	int logist17_alloy	 =	31800	;	int logist17_time	 =	61200	;
    int logist18_fuel	 =	1320000	;	int logist18_food	 =	661000	;	int logist18_steel	 =	165000	;	int logist18_alloy	 =	41300	;	int logist18_time	 =	75600	;
    int logist19_fuel	 =	1720000	;	int logist19_food	 =	859000	;	int logist19_steel	 =	215000	;	int logist19_alloy	 =	53700	;	int logist19_time	 =	93600	;
    int logist20_fuel	 =	2230000	;	int logist20_food	 =	1120000	;	int logist20_steel	 =	279000	;	int logist20_alloy	 =	69800	;	int logist20_time	 =	118800	;
    int logist21_fuel	 =	2900000	;	int logist21_food	 =	1450000	;	int logist21_steel	 =	363000	;	int logist21_alloy	 =	90700	;	int logist21_time	 =	136800	;
    int logist22_fuel	 =	3770000	;	int logist22_food	 =	1890000	;	int logist22_steel	 =	472000	;	int logist22_alloy	 =	118000	;	int logist22_time	 =	158400	;
    int logist23_fuel	 =	4910000	;	int logist23_food	 =	2450000	;	int logist23_steel	 =	613000	;	int logist23_alloy	 =	153000	;	int logist23_time	 =	180000	;
    int logist24_fuel	 =	6380000	;	int logist24_food	 =	3190000	;	int logist24_steel	 =	797000	;	int logist24_alloy	 =	199000	;	int logist24_time	 =	208800	;
    int logist25_fuel	 =	8290000	;	int logist25_food	 =	4150000	;	int logist25_steel	 =	1040000	;	int logist25_alloy	 =	259000	;	int logist25_time	 =	241200	;
    int logist26_fuel	 =	10800000	;	int logist26_food	 =	5390000	;	int logist26_steel	 =	1350000	;	int logist26_alloy	 =	337000	;	int logist26_time	 =	277200	;
    int logist27_fuel	 =	14000000	;	int logist27_food	 =	7010000	;	int logist27_steel	 =	1750000	;	int logist27_alloy	 =	438000	;	int logist27_time	 =	316800	;
    int logist28_fuel	 =	18200000	;	int logist28_food	 =	9110000	;	int logist28_steel	 =	2280000	;	int logist28_alloy	 =	569000	;	int logist28_time	 =	363600	;
    int logist29_fuel	 =	23700000	;	int logist29_food	 =	11800000	;	int logist29_steel	 =	2960000	;	int logist29_alloy	 =	740000	;	int logist29_time	 =	417600	;
    int logist30_fuel	 =	30800000	;	int logist30_food	 =	15400000	;	int logist30_steel	 =	3850000	;	int logist30_alloy	 =	962000	;	int logist30_time	 =	481800	;

    //--------------------------------------------------------------------------
    int military1_fuel	 =	589	;	int military1_food	 =	0	;	int military1_steel	 =	0	;	int military1_alloy	 =	0	;	int military1_time	 =	2	;
    int military2_fuel	 =	825	;	int military2_food	 =	472	;	int military2_steel	 =	0	;	int military2_alloy	 =	0	;	int military2_time	 =	326	;
    int military3_fuel	 =	1160	;	int military3_food	 =	660	;	int military3_steel	 =	0	;	int military3_alloy	 =	0	;	int military3_time	 =	428	;
    int military4_fuel	 =	1730	;	int military4_food	 =	990	;	int military4_steel	 =	0	;	int military4_alloy	 =	0	;	int military4_time	 =	721	;
    int military5_fuel	 =	2770	;	int military5_food	 =	1580	;	int military5_steel	 =	0	;	int military5_alloy	 =	0	;	int military5_time	 =	1163	;
    int military6_fuel	 =	4990	;	int military6_food	 =	2850	;	int military6_steel	 =	0	;	int military6_alloy	 =	0	;	int military6_time	 =	2930	;
    int military7_fuel	 =	9480	;	int military7_food	 =	5420	;	int military7_steel	 =	0	;	int military7_alloy	 =	0	;	int military7_time	 =	16200	;
    int military8_fuel	 =	19000	;	int military8_food	 =	10800	;	int military8_steel	 =	0	;	int military8_alloy	 =	0	;	int military8_time	 =	22800	;
    int military9_fuel	 =	37900	;	int military9_food	 =	21700	;	int military9_steel	 =	0	;	int military9_alloy	 =	0	;	int military9_time	 =	27300	;
    int military10_fuel	 =	75900	;	int military10_food	 =	43400	;	int military10_steel	 =	0	;	int military10_alloy	 =	0	;	int military10_time	 =	32700	;
    int military11_fuel	 =	152000	;	int military11_food	 =	86700	;	int military11_steel	 =	6240	;	int military11_alloy	 =	0	;	int military11_time	 =	39600	;
    int military12_fuel	 =	303000	;	int military12_food	 =	173000	;	int military12_steel	 =	12500	;	int military12_alloy	 =	0	;	int military12_time	 =	50400	;
    int military13_fuel	 =	577000	;	int military13_food	 =	329000	;	int military13_steel	 =	23700	;	int military13_alloy	 =	0	;	int military13_time	 =	61200	;
    int military14_fuel	 =	1040000	;	int military14_food	 =	593000	;	int military14_steel	 =	42700	;	int military14_alloy	 =	0	;	int military14_time	 =	75600	;
    int military15_fuel	 =	1560000	;	int military15_food	 =	890000	;	int military15_steel	 =	64000	;	int military15_alloy	 =	0	;	int military15_time	 =	97200	;
    int military16_fuel	 =	2180000	;	int military16_food	 =	1250000	;	int military16_steel	 =	89600	;	int military16_alloy	 =	51900	;	int military16_time	 =	118800	;
    int military17_fuel	 =	3050000	;	int military17_food	 =	1740000	;	int military17_steel	 =	125000	;	int military17_alloy	 =	72600	;	int military17_time	 =	151200	;
    int military18_fuel	 =	3970000	;	int military18_food	 =	2270000	;	int military18_steel	 =	163000	;	int military18_alloy	 =	94400	;	int military18_time	 =	187200	;
    int military19_fuel	 =	5160000	;	int military19_food	 =	2950000	;	int military19_steel	 =	212000	;	int military19_alloy	 =	123000	;	int military19_time	 =	234000	;
    int military20_fuel	 =	6700000	;	int military20_food	 =	3830000	;	int military20_steel	 =	276000	;	int military20_alloy	 =	160000	;	int military20_time	 =	291600	;
    int military21_fuel	 =	8710000	;	int military21_food	 =	4980000	;	int military21_steel	 =	358000	;	int military21_alloy	 =	207000	;	int military21_time	 =	338400	;
    int military22_fuel	 =	11300000	;	int military22_food	 =	6470000	;	int military22_steel	 =	466000	;	int military22_alloy	 =	270000	;	int military22_time	 =	388800	;
    int military23_fuel	 =	14700000	;	int military23_food	 =	8420000	;	int military23_steel	 =	606000	;	int military23_alloy	 =	351000	;	int military23_time	 =	446400	;
    int military24_fuel	 =	19100000	;	int military24_food	 =	10900000	;	int military24_steel	 =	787000	;	int military24_alloy	 =	456000	;	int military24_time	 =	511200	;
    int military25_fuel	 =	24900000	;	int military25_food	 =	14200000	;	int military25_steel	 =	1020000	;	int military25_alloy	 =	593000	;	int military25_time	 =	590400	;
    int military26_fuel	 =	32400000	;	int military26_food	 =	18500000	;	int military26_steel	 =	1330000	;	int military26_alloy	 =	770000	;	int military26_time	 =	676800	;
    int military27_fuel	 =	42100000	;	int military27_food	 =	24000000	;	int military27_steel	 =	1730000	;	int military27_alloy	 =	1000000	;	int military27_time	 =	777600	;
    int military28_fuel	 =	54700000	;	int military28_food	 =	31200000	;	int military28_steel	 =	2250000	;	int military28_alloy	 =	1300000	;	int military28_time	 =	896400	;
    int military29_fuel	 =	71100000	;	int military29_food	 =	40600000	;	int military29_steel	 =	2920000	;	int military29_alloy	 =	1690000	;	int military29_time	 =	1029600	;
    int military30_fuel	 =	92400000	;	int military30_food	 =	52800000	;	int military30_steel	 =	3800000	;	int military30_alloy	 =	2200000	;	int military30_time	 =	1184400	;
    int military31_fuel	 =	120287062	;	int military31_food	 =	120287062	;	int military31_steel	 =	20105122	;	int military31_alloy	 =	161684	;	int military31_time	 =	1101706	;
    int military32_fuel	 =	134531967	;	int military32_food	 =	134531967	;	int military32_steel	 =	22486056	;	int military32_alloy	 =	180832	;	int military32_time	 =	1232172	;
    int military33_fuel	 =	157655136	;	int military33_food	 =	157655136	;	int military33_steel	 =	26350931	;	int military33_alloy	 =	211913	;	int military33_time	 =	1443955	;
    int military34_fuel	 =	209391839	;	int military34_food	 =	209391839	;	int military34_steel	 =	34998349	;	int military34_alloy	 =	281456	;	int military34_time	 =	1917811	;
    int military35_fuel	 =	403668100	;	int military35_food	 =	403668100	;	int military35_steel	 =	67470239	;	int military35_alloy	 =	542592	;	int military35_time	 =	3697181	;

    //--------------------------------------------------------------------------
    int mobile1_fuel	 =	589	;	int mobile1_food	 =	0	;	int mobile1_steel	 =	0	;	int mobile1_alloy	 =	0	;	int mobile1_time	 =	2	;	int mobile1_glory_mark	=	0	;	int mobile1_kyanite	=	0	;	int mobile1_kyanite_basic	=	0	;	int mobile1_kyanite_cluster	=	0	;
    int mobile2_fuel	 =	825	;	int mobile2_food	 =	472	;	int mobile2_steel	 =	0	;	int mobile2_alloy	 =	0	;	int mobile2_time	 =	326	;	int mobile2_glory_mark	=	0	;	int mobile2_kyanite	=	0	;	int mobile2_kyanite_basic	=	0	;	int mobile2_kyanite_cluster	=	0	;
    int mobile3_fuel	 =	1160	;	int mobile3_food	 =	660	;	int mobile3_steel	 =	0	;	int mobile3_alloy	 =	0	;	int mobile3_time	 =	428	;	int mobile3_glory_mark	=	0	;	int mobile3_kyanite	=	0	;	int mobile3_kyanite_basic	=	0	;	int mobile3_kyanite_cluster	=	0	;
    int mobile4_fuel	 =	1730	;	int mobile4_food	 =	990	;	int mobile4_steel	 =	0	;	int mobile4_alloy	 =	0	;	int mobile4_time	 =	721	;	int mobile4_glory_mark	=	0	;	int mobile4_kyanite	=	0	;	int mobile4_kyanite_basic	=	0	;	int mobile4_kyanite_cluster	=	0	;
    int mobile5_fuel	 =	2770	;	int mobile5_food	 =	1580	;	int mobile5_steel	 =	0	;	int mobile5_alloy	 =	0	;	int mobile5_time	 =	1163	;	int mobile5_glory_mark	=	0	;	int mobile5_kyanite	=	0	;	int mobile5_kyanite_basic	=	0	;	int mobile5_kyanite_cluster	=	0	;
    int mobile6_fuel	 =	4990	;	int mobile6_food	 =	2850	;	int mobile6_steel	 =	0	;	int mobile6_alloy	 =	0	;	int mobile6_time	 =	2930	;	int mobile6_glory_mark	=	0	;	int mobile6_kyanite	=	0	;	int mobile6_kyanite_basic	=	0	;	int mobile6_kyanite_cluster	=	0	;
    int mobile7_fuel	 =	9480	;	int mobile7_food	 =	5420	;	int mobile7_steel	 =	0	;	int mobile7_alloy	 =	0	;	int mobile7_time	 =	16200	;	int mobile7_glory_mark	=	0	;	int mobile7_kyanite	=	0	;	int mobile7_kyanite_basic	=	0	;	int mobile7_kyanite_cluster	=	0	;
    int mobile8_fuel	 =	19000	;	int mobile8_food	 =	10800	;	int mobile8_steel	 =	0	;	int mobile8_alloy	 =	0	;	int mobile8_time	 =	22800	;	int mobile8_glory_mark	=	0	;	int mobile8_kyanite	=	0	;	int mobile8_kyanite_basic	=	0	;	int mobile8_kyanite_cluster	=	0	;
    int mobile9_fuel	 =	37900	;	int mobile9_food	 =	21700	;	int mobile9_steel	 =	0	;	int mobile9_alloy	 =	0	;	int mobile9_time	 =	27300	;	int mobile9_glory_mark	=	0	;	int mobile9_kyanite	=	0	;	int mobile9_kyanite_basic	=	0	;	int mobile9_kyanite_cluster	=	0	;
    int mobile10_fuel	 =	75900	;	int mobile10_food	 =	43400	;	int mobile10_steel	 =	0	;	int mobile10_alloy	 =	0	;	int mobile10_time	 =	32700	;	int mobile10_glory_mark	=	0	;	int mobile10_kyanite	=	0	;	int mobile10_kyanite_basic	=	0	;	int mobile10_kyanite_cluster	=	0	;
    int mobile11_fuel	 =	152000	;	int mobile11_food	 =	86700	;	int mobile11_steel	 =	14500	;	int mobile11_alloy	 =	0	;	int mobile11_time	 =	39600	;	int mobile11_glory_mark	=	0	;	int mobile11_kyanite	=	0	;	int mobile11_kyanite_basic	=	0	;	int mobile11_kyanite_cluster	=	0	;
    int mobile12_fuel	 =	303000	;	int mobile12_food	 =	173000	;	int mobile12_steel	 =	28900	;	int mobile12_alloy	 =	0	;	int mobile12_time	 =	50400	;	int mobile12_glory_mark	=	0	;	int mobile12_kyanite	=	0	;	int mobile12_kyanite_basic	=	0	;	int mobile12_kyanite_cluster	=	0	;
    int mobile13_fuel	 =	577000	;	int mobile13_food	 =	329000	;	int mobile13_steel	 =	54900	;	int mobile13_alloy	 =	0	;	int mobile13_time	 =	61200	;	int mobile13_glory_mark	=	0	;	int mobile13_kyanite	=	0	;	int mobile13_kyanite_basic	=	0	;	int mobile13_kyanite_cluster	=	0	;
    int mobile14_fuel	 =	1040000	;	int mobile14_food	 =	593000	;	int mobile14_steel	 =	98800	;	int mobile14_alloy	 =	0	;	int mobile14_time	 =	75600	;	int mobile14_glory_mark	=	0	;	int mobile14_kyanite	=	0	;	int mobile14_kyanite_basic	=	0	;	int mobile14_kyanite_cluster	=	0	;
    int mobile15_fuel	 =	1560000	;	int mobile15_food	 =	890000	;	int mobile15_steel	 =	148000	;	int mobile15_alloy	 =	0	;	int mobile15_time	 =	97200	;	int mobile15_glory_mark	=	0	;	int mobile15_kyanite	=	0	;	int mobile15_kyanite_basic	=	0	;	int mobile15_kyanite_cluster	=	0	;
    int mobile16_fuel	 =	2180000	;	int mobile16_food	 =	1250000	;	int mobile16_steel	 =	208000	;	int mobile16_alloy	 =	51900	;	int mobile16_time	 =	118800	;	int mobile16_glory_mark	=	0	;	int mobile16_kyanite	=	0	;	int mobile16_kyanite_basic	=	0	;	int mobile16_kyanite_cluster	=	0	;
    int mobile17_fuel	 =	3050000	;	int mobile17_food	 =	1740000	;	int mobile17_steel	 =	291000	;	int mobile17_alloy	 =	72600	;	int mobile17_time	 =	151200	;	int mobile17_glory_mark	=	0	;	int mobile17_kyanite	=	0	;	int mobile17_kyanite_basic	=	0	;	int mobile17_kyanite_cluster	=	0	;
    int mobile18_fuel	 =	3970000	;	int mobile18_food	 =	2270000	;	int mobile18_steel	 =	378000	;	int mobile18_alloy	 =	94400	;	int mobile18_time	 =	187200	;	int mobile18_glory_mark	=	0	;	int mobile18_kyanite	=	0	;	int mobile18_kyanite_basic	=	0	;	int mobile18_kyanite_cluster	=	0	;
    int mobile19_fuel	 =	5160000	;	int mobile19_food	 =	2950000	;	int mobile19_steel	 =	491000	;	int mobile19_alloy	 =	123000	;	int mobile19_time	 =	234000	;	int mobile19_glory_mark	=	0	;	int mobile19_kyanite	=	0	;	int mobile19_kyanite_basic	=	0	;	int mobile19_kyanite_cluster	=	0	;
    int mobile20_fuel	 =	6700000	;	int mobile20_food	 =	3830000	;	int mobile20_steel	 =	638000	;	int mobile20_alloy	 =	160000	;	int mobile20_time	 =	291600	;	int mobile20_glory_mark	=	0	;	int mobile20_kyanite	=	0	;	int mobile20_kyanite_basic	=	0	;	int mobile20_kyanite_cluster	=	0	;
    int mobile21_fuel	 =	8710000	;	int mobile21_food	 =	4980000	;	int mobile21_steel	 =	830000	;	int mobile21_alloy	 =	207000	;	int mobile21_time	 =	338400	;	int mobile21_glory_mark	=	0	;	int mobile21_kyanite	=	0	;	int mobile21_kyanite_basic	=	0	;	int mobile21_kyanite_cluster	=	0	;
    int mobile22_fuel	 =	11300000	;	int mobile22_food	 =	6470000	;	int mobile22_steel	 =	1080000	;	int mobile22_alloy	 =	270000	;	int mobile22_time	 =	388800	;	int mobile22_glory_mark	=	0	;	int mobile22_kyanite	=	0	;	int mobile22_kyanite_basic	=	0	;	int mobile22_kyanite_cluster	=	0	;
    int mobile23_fuel	 =	14700000	;	int mobile23_food	 =	8420000	;	int mobile23_steel	 =	1400000	;	int mobile23_alloy	 =	351000	;	int mobile23_time	 =	446400	;	int mobile23_glory_mark	=	0	;	int mobile23_kyanite	=	0	;	int mobile23_kyanite_basic	=	0	;	int mobile23_kyanite_cluster	=	0	;
    int mobile24_fuel	 =	19100000	;	int mobile24_food	 =	10900000	;	int mobile24_steel	 =	1820000	;	int mobile24_alloy	 =	456000	;	int mobile24_time	 =	511200	;	int mobile24_glory_mark	=	0	;	int mobile24_kyanite	=	0	;	int mobile24_kyanite_basic	=	0	;	int mobile24_kyanite_cluster	=	0	;
    int mobile25_fuel	 =	24900000	;	int mobile25_food	 =	14200000	;	int mobile25_steel	 =	2370000	;	int mobile25_alloy	 =	593000	;	int mobile25_time	 =	590400	;	int mobile25_glory_mark	=	0	;	int mobile25_kyanite	=	0	;	int mobile25_kyanite_basic	=	0	;	int mobile25_kyanite_cluster	=	0	;
    int mobile26_fuel	 =	32400000	;	int mobile26_food	 =	18500000	;	int mobile26_steel	 =	3080000	;	int mobile26_alloy	 =	770000	;	int mobile26_time	 =	676800	;	int mobile26_glory_mark	=	0	;	int mobile26_kyanite	=	0	;	int mobile26_kyanite_basic	=	0	;	int mobile26_kyanite_cluster	=	0	;
    int mobile27_fuel	 =	42100000	;	int mobile27_food	 =	24000000	;	int mobile27_steel	 =	4010000	;	int mobile27_alloy	 =	1000000	;	int mobile27_time	 =	777600	;	int mobile27_glory_mark	=	0	;	int mobile27_kyanite	=	0	;	int mobile27_kyanite_basic	=	0	;	int mobile27_kyanite_cluster	=	0	;
    int mobile28_fuel	 =	54700000	;	int mobile28_food	 =	31200000	;	int mobile28_steel	 =	5210000	;	int mobile28_alloy	 =	1300000	;	int mobile28_time	 =	896400	;	int mobile28_glory_mark	=	0	;	int mobile28_kyanite	=	0	;	int mobile28_kyanite_basic	=	0	;	int mobile28_kyanite_cluster	=	0	;
    int mobile29_fuel	 =	71100000	;	int mobile29_food	 =	40600000	;	int mobile29_steel	 =	6770000	;	int mobile29_alloy	 =	1690000	;	int mobile29_time	 =	1029600	;	int mobile29_glory_mark	=	0	;	int mobile29_kyanite	=	0	;	int mobile29_kyanite_basic	=	0	;	int mobile29_kyanite_cluster	=	0	;
    int mobile30_fuel	 =	92400000	;	int mobile30_food	 =	52800000	;	int mobile30_steel	 =	8800000	;	int mobile30_alloy	 =	2200000	;	int mobile30_time	 =	1184400	;	int mobile30_glory_mark	=	0	;	int mobile30_kyanite	=	0	;	int mobile30_kyanite_basic	=	0	;	int mobile30_kyanite_cluster	=	0	;
    int mobile31_fuel	 =	120287062	;	int mobile31_food	 =	120287062	;	int mobile31_steel	 =	20105122	;	int mobile31_alloy	 =	161684	;	int mobile31_time	 =	1101706	;	int mobile31_glory_mark	=	171318	;	int mobile31_kyanite	=	253072	;	int mobile31_kyanite_basic	=	351489	;	int mobile31_kyanite_cluster	=	28120	;
    int mobile32_fuel	 =	134531967	;	int mobile32_food	 =	134531967	;	int mobile32_steel	 =	22486056	;	int mobile32_alloy	 =	180832	;	int mobile32_time	 =	1232172	;	int mobile32_glory_mark	=	191607	;	int mobile32_kyanite	=	283041	;	int mobile32_kyanite_basic	=	393112	;	int mobile32_kyanite_cluster	=	31449	;
    int mobile33_fuel	 =	157655136	;	int mobile33_food	 =	157655136	;	int mobile33_steel	 =	26350931	;	int mobile33_alloy	 =	211913	;	int mobile33_time	 =	1443955	;	int mobile33_glory_mark	=	224540	;	int mobile33_kyanite	=	331691	;	int mobile33_kyanite_basic	=	460681	;	int mobile33_kyanite_cluster	=	36855	;
    int mobile34_fuel	 =	209391839	;	int mobile34_food	 =	209391839	;	int mobile34_steel	 =	34998349	;	int mobile34_alloy	 =	281456	;	int mobile34_time	 =	1917811	;	int mobile34_glory_mark	=	298226	;	int mobile34_kyanite	=	440539	;	int mobile34_kyanite_basic	=	611859	;	int mobile34_kyanite_cluster	=	48949	;
    int mobile35_fuel	 =	403668100	;	int mobile35_food	 =	403668100	;	int mobile35_steel	 =	67470239	;	int mobile35_alloy	 =	542592	;	int mobile35_time	 =	3697181	;	int mobile35_glory_mark	=	574922	;	int mobile35_kyanite	=	849276	;	int mobile35_kyanite_basic	=	1179550	;	int mobile35_kyanite_cluster	=	94364	;

    //--------------------------------------------------------------------------
    int oil_food1	=	100	;	int oil_time1	=	2	;	int oil1_glory_mark	=	0	;	int oil1_kyanite	=	0	;	int oil1_kyanite_basic	=	0	;	int oil1_kyanite_cluster	=	0	;
    int oil_food2	=	140	;	int oil_time2	=	150	;	int oil2_glory_mark	=	0	;	int oil2_kyanite	=	0	;	int oil2_kyanite_basic	=	0	;	int oil2_kyanite_cluster	=	0	;
    int oil_food3	=	196	;	int oil_time3	=	285	;	int oil3_glory_mark	=	0	;	int oil3_kyanite	=	0	;	int oil3_kyanite_basic	=	0	;	int oil3_kyanite_cluster	=	0	;
    int oil_food4	=	294	;	int oil_time4	=	395	;	int oil4_glory_mark	=	0	;	int oil4_kyanite	=	0	;	int oil4_kyanite_basic	=	0	;	int oil4_kyanite_cluster	=	0	;
    int oil_food5	=	470	;	int oil_time5	=	585	;	int oil5_glory_mark	=	0	;	int oil5_kyanite	=	0	;	int oil5_kyanite_basic	=	0	;	int oil5_kyanite_cluster	=	0	;
    int oil_food6	=	847	;	int oil_time6	=	590	;	int oil6_glory_mark	=	0	;	int oil6_kyanite	=	0	;	int oil6_kyanite_basic	=	0	;	int oil6_kyanite_cluster	=	0	;
    int oil_food7	=	1610	;	int oil_time7	=	890	;	int oil7_glory_mark	=	0	;	int oil7_kyanite	=	0	;	int oil7_kyanite_basic	=	0	;	int oil7_kyanite_cluster	=	0	;
    int oil_food8	=	3220	;	int oil_time8	=	1500	;	int oil8_glory_mark	=	0	;	int oil8_kyanite	=	0	;	int oil8_kyanite_basic	=	0	;	int oil8_kyanite_cluster	=	0	;
    int oil_food9	=	6440	;	int oil_time9	=	1800	;	int oil9_glory_mark	=	0	;	int oil9_kyanite	=	0	;	int oil9_kyanite_basic	=	0	;	int oil9_kyanite_cluster	=	0	;
    int oil_food10	=	12900	;	int oil_time10	=	2700	;	int oil10_glory_mark	=	0	;	int oil10_kyanite	=	0	;	int oil10_kyanite_basic	=	0	;	int oil10_kyanite_cluster	=	0	;
    int oil_food11	=	25700	;	int oil_time11	=	3300	;	int oil11_glory_mark	=	0	;	int oil11_kyanite	=	0	;	int oil11_kyanite_basic	=	0	;	int oil11_kyanite_cluster	=	0	;
    int oil_food12	=	51500	;	int oil_time12	=	4200	;	int oil12_glory_mark	=	0	;	int oil12_kyanite	=	0	;	int oil12_kyanite_basic	=	0	;	int oil12_kyanite_cluster	=	0	;
    int oil_food13	=	97800	;	int oil_time13	=	5100	;	int oil13_glory_mark	=	0	;	int oil13_kyanite	=	0	;	int oil13_kyanite_basic	=	0	;	int oil13_kyanite_cluster	=	0	;
    int oil_food14	=	176000	;	int oil_time14	=	6300	;	int oil14_glory_mark	=	0	;	int oil14_kyanite	=	0	;	int oil14_kyanite_basic	=	0	;	int oil14_kyanite_cluster	=	0	;
    int oil_food15	=	264000	;	int oil_time15	=	7800	;	int oil15_glory_mark	=	0	;	int oil15_kyanite	=	0	;	int oil15_kyanite_basic	=	0	;	int oil15_kyanite_cluster	=	0	;
    int oil_food16	=	370000	;	int oil_time16	=	9900	;	int oil16_glory_mark	=	0	;	int oil16_kyanite	=	0	;	int oil16_kyanite_basic	=	0	;	int oil16_kyanite_cluster	=	0	;
    int oil_food17	=	518000	;	int oil_time17	=	12300	;	int oil17_glory_mark	=	0	;	int oil17_kyanite	=	0	;	int oil17_kyanite_basic	=	0	;	int oil17_kyanite_cluster	=	0	;
    int oil_food18	=	673000	;	int oil_time18	=	15600	;	int oil18_glory_mark	=	0	;	int oil18_kyanite	=	0	;	int oil18_kyanite_basic	=	0	;	int oil18_kyanite_cluster	=	0	;
    int oil_food19	=	875000	;	int oil_time19	=	19200	;	int oil19_glory_mark	=	0	;	int oil19_kyanite	=	0	;	int oil19_kyanite_basic	=	0	;	int oil19_kyanite_cluster	=	0	;
    int oil_food20	=	1140000	;	int oil_time20	=	24000	;	int oil20_glory_mark	=	0	;	int oil20_kyanite	=	0	;	int oil20_kyanite_basic	=	0	;	int oil20_kyanite_cluster	=	0	;
    int oil_food21	=	1480000	;	int oil_time21	=	27900	;	int oil21_glory_mark	=	0	;	int oil21_kyanite	=	0	;	int oil21_kyanite_basic	=	0	;	int oil21_kyanite_cluster	=	0	;
    int oil_food22	=	1920000	;	int oil_time22	=	31800	;	int oil22_glory_mark	=	0	;	int oil22_kyanite	=	0	;	int oil22_kyanite_basic	=	0	;	int oil22_kyanite_cluster	=	0	;
    int oil_food23	=	2500000	;	int oil_time23	=	36600	;	int oil23_glory_mark	=	0	;	int oil23_kyanite	=	0	;	int oil23_kyanite_basic	=	0	;	int oil23_kyanite_cluster	=	0	;
    int oil_food24	=	3250000	;	int oil_time24	=	42300	;	int oil24_glory_mark	=	0	;	int oil24_kyanite	=	0	;	int oil24_kyanite_basic	=	0	;	int oil24_kyanite_cluster	=	0	;
    int oil_food25	=	4220000	;	int oil_time25	=	46800	;	int oil25_glory_mark	=	0	;	int oil25_kyanite	=	0	;	int oil25_kyanite_basic	=	0	;	int oil25_kyanite_cluster	=	0	;
    int oil_food26	=	5490000	;	int oil_time26	=	57600	;	int oil26_glory_mark	=	0	;	int oil26_kyanite	=	0	;	int oil26_kyanite_basic	=	0	;	int oil26_kyanite_cluster	=	0	;
    int oil_food27	=	7140000	;	int oil_time27	=	64800	;	int oil27_glory_mark	=	0	;	int oil27_kyanite	=	0	;	int oil27_kyanite_basic	=	0	;	int oil27_kyanite_cluster	=	0	;
    int oil_food28	=	9280000	;	int oil_time28	=	75600	;	int oil28_glory_mark	=	0	;	int oil28_kyanite	=	0	;	int oil28_kyanite_basic	=	0	;	int oil28_kyanite_cluster	=	0	;
    int oil_food29	=	12100000	;	int oil_time29	=	86400	;	int oil29_glory_mark	=	0	;	int oil29_kyanite	=	0	;	int oil29_kyanite_basic	=	0	;	int oil29_kyanite_cluster	=	0	;
    int oil_food30	=	15700000	;	int oil_time30	=	97800	;	int oil30_glory_mark	=	0	;	int oil30_kyanite	=	0	;	int oil30_kyanite_basic	=	0	;	int oil30_kyanite_cluster	=	0	;
    int oil_food31	 =	84200942	;	int oil_time31	 =	351489	;	int oil31_glory_mark	=	48948	;	int oil31_kyanite	=	253072	;	int oil31_kyanite_basic	=	351489	;	int oil31_kyanite_cluster	=	28120	;
    int oil_food32	 =	94172376	;	int oil_time32	 =	393112	;	int oil32_glory_mark	=	54745	;	int oil32_kyanite	=	283041	;	int oil32_kyanite_basic	=	393112	;	int oil32_kyanite_cluster	=	31449	;
    int oil_food33	 =	110358595	;	int oil_time33	 =	460681	;	int oil33_glory_mark	=	64154	;	int oil33_kyanite	=	331691	;	int oil33_kyanite_basic	=	460681	;	int oil33_kyanite_cluster	=	36855	;
    int oil_food34	 =	146574286	;	int oil_time34	 =	611859	;	int oil34_glory_mark	=	85208	;	int oil34_kyanite	=	440539	;	int oil34_kyanite_basic	=	611859	;	int oil34_kyanite_cluster	=	48949	;
    int oil_food35	 =	282567670	;	int oil_time35	 =	1179550	;	int oil35_glory_mark	=	164263	;	int oil35_kyanite	=	849276	;	int oil35_kyanite_basic	=	1179550	;	int oil35_kyanite_cluster	=	94364	;

    //--------------------------------------------------------------------------
    int prison1_fuel	 =	589	;	int prison1_food	 =	336	;	int prison1_steel	 =	0	;	int prison1_alloy	 =	0	;	int prison1_time	 =	2	;
    int prison2_fuel	 =	825	;	int prison2_food	 =	471	;	int prison2_steel	 =	0	;	int prison2_alloy	 =	0	;	int prison2_time	 =	605	;
    int prison3_fuel	 =	1160	;	int prison3_food	 =	660	;	int prison3_steel	 =	0	;	int prison3_alloy	 =	0	;	int prison3_time	 =	905	;
    int prison4_fuel	 =	1730	;	int prison4_food	 =	990	;	int prison4_steel	 =	0	;	int prison4_alloy	 =	0	;	int prison4_time	 =	905	;
    int prison5_fuel	 =	2770	;	int prison5_food	 =	1584	;	int prison5_steel	 =	0	;	int prison5_alloy	 =	0	;	int prison5_time	 =	4200	;
    int prison6_fuel	 =	4990	;	int prison6_food	 =	2852	;	int prison6_steel	 =	0	;	int prison6_alloy	 =	0	;	int prison6_time	 =	7200	;
    int prison7_fuel	 =	9480	;	int prison7_food	 =	5419	;	int prison7_steel	 =	0	;	int prison7_alloy	 =	0	;	int prison7_time	 =	16200	;
    int prison8_fuel	 =	19000	;	int prison8_food	 =	10838	;	int prison8_steel	 =	0	;	int prison8_alloy	 =	0	;	int prison8_time	 =	22800	;
    int prison9_fuel	 =	37900	;	int prison9_food	 =	21676	;	int prison9_steel	 =	0	;	int prison9_alloy	 =	0	;	int prison9_time	 =	27300	;
    int prison10_fuel	 =	75900	;	int prison10_food	 =	43352	;	int prison10_steel	 =	0	;	int prison10_alloy	 =	0	;	int prison10_time	 =	32700	;
    int prison11_fuel	 =	152000	;	int prison11_food	 =	86704	;	int prison11_steel	 =	14500	;	int prison11_alloy	 =	0	;	int prison11_time	 =	39600	;
    int prison12_fuel	 =	303000	;	int prison12_food	 =	173408	;	int prison12_steel	 =	28900	;	int prison12_alloy	 =	0	;	int prison12_time	 =	50400	;
    int prison13_fuel	 =	577000	;	int prison13_food	 =	329475	;	int prison13_steel	 =	54900	;	int prison13_alloy	 =	0	;	int prison13_time	 =	61200	;
    int prison14_fuel	 =	1040000	;	int prison14_food	 =	593056	;	int prison14_steel	 =	98800	;	int prison14_alloy	 =	0	;	int prison14_time	 =	75600	;
    int prison15_fuel	 =	1560000	;	int prison15_food	 =	889584	;	int prison15_steel	 =	148000	;	int prison15_alloy	 =	0	;	int prison15_time	 =	97200	;
    int prison16_fuel	 =	2180000	;	int prison16_food	 =	1245418	;	int prison16_steel	 =	208000	;	int prison16_alloy	 =	51900	;	int prison16_time	 =	118800	;
    int prison17_fuel	 =	3050000	;	int prison17_food	 =	1743585	;	int prison17_steel	 =	291000	;	int prison17_alloy	 =	72600	;	int prison17_time	 =	151200	;
    int prison18_fuel	 =	3970000	;	int prison18_food	 =	2266660	;	int prison18_steel	 =	378000	;	int prison18_alloy	 =	94400	;	int prison18_time	 =	187200	;
    int prison19_fuel	 =	5160000	;	int prison19_food	 =	2946659	;	int prison19_steel	 =	491000	;	int prison19_alloy	 =	123000	;	int prison19_time	 =	234000	;
    int prison20_fuel	 =	6700000	;	int prison20_food	 =	3830656	;	int prison20_steel	 =	638000	;	int prison20_alloy	 =	160000	;	int prison20_time	 =	291600	;
    int prison21_fuel	 =	8710000	;	int prison21_food	 =	4979854	;	int prison21_steel	 =	830000	;	int prison21_alloy	 =	207000	;	int prison21_time	 =	338400	;
    int prison22_fuel	 =	11300000	;	int prison22_food	 =	6473810	;	int prison22_steel	 =	1080000	;	int prison22_alloy	 =	270000	;	int prison22_time	 =	388800	;
    int prison23_fuel	 =	14700000	;	int prison23_food	 =	8415953	;	int prison23_steel	 =	1400000	;	int prison23_alloy	 =	351000	;	int prison23_time	 =	446400	;
    int prison24_fuel	 =	19100000	;	int prison24_food	 =	10940739	;	int prison24_steel	 =	1820000	;	int prison24_alloy	 =	456000	;	int prison24_time	 =	511200	;
    int prison25_fuel	 =	24900000	;	int prison25_food	 =	14222961	;	int prison25_steel	 =	2370000	;	int prison25_alloy	 =	593000	;	int prison25_time	 =	590400	;
    int prison26_fuel	 =	32400000	;	int prison26_food	 =	18489849	;	int prison26_steel	 =	3080000	;	int prison26_alloy	 =	770000	;	int prison26_time	 =	676800	;
    int prison27_fuel	 =	42100000	;	int prison27_food	 =	24036804	;	int prison27_steel	 =	4010000	;	int prison27_alloy	 =	1000000	;	int prison27_time	 =	777600	;
    int prison28_fuel	 =	54700000	;	int prison28_food	 =	31247845	;	int prison28_steel	 =	5210000	;	int prison28_alloy	 =	1300000	;	int prison28_time	 =	896400	;
    int prison29_fuel	 =	71100000	;	int prison29_food	 =	40622199	;	int prison29_steel	 =	6770000	;	int prison29_alloy	 =	1690000	;	int prison29_time	 =	1029600	;
    int prison30_fuel	 =	92400000	;	int prison30_food	 =	52808859	;	int prison30_steel	 =	8800000	;	int prison30_alloy	 =	2200000	;	int prison30_time	 =	1184400	;

    //--------------------------------------------------------------------------
    int project_origin1_fuel	=	0	;	int project_origin1_food	=	0	;	int project_origin1_steel	=	0	;	int project_origin1_alloy	=	0	;	int project_origin1_time	=	16350	;	int project_origin1_glory_mark	=	0	;	int project_origin1_kyanite	=	0	;	int project_origin1_kyanite_basic	=	0	;	int project_origin1_kyanite_cluster	=	0	;
    int project_origin2_fuel	=	96600	;	int project_origin2_food	=	96600	;	int project_origin2_steel	=	21750	;	int project_origin2_alloy	=	0	;	int project_origin2_time	=	19800	;	int project_origin2_glory_mark	=	0	;	int project_origin2_kyanite	=	0	;	int project_origin2_kyanite_basic	=	0	;	int project_origin2_kyanite_cluster	=	0	;
    int project_origin3_fuel	=	193500	;	int project_origin3_food	=	193500	;	int project_origin3_steel	=	30000	;	int project_origin3_alloy	=	0	;	int project_origin3_time	=	25200	;	int project_origin3_glory_mark	=	0	;	int project_origin3_kyanite	=	0	;	int project_origin3_kyanite_basic	=	0	;	int project_origin3_kyanite_cluster	=	0	;
    int project_origin4_fuel	=	385500	;	int project_origin4_food	=	385500	;	int project_origin4_steel	=	37950	;	int project_origin4_alloy	=	0	;	int project_origin4_time	=	30600	;	int project_origin4_glory_mark	=	0	;	int project_origin4_kyanite	=	0	;	int project_origin4_kyanite_basic	=	0	;	int project_origin4_kyanite_cluster	=	0	;
    int project_origin5_fuel	=	600000	;	int project_origin5_food	=	600000	;	int project_origin5_steel	=	57150	;	int project_origin5_alloy	=	0	;	int project_origin5_time	=	37800	;	int project_origin5_glory_mark	=	0	;	int project_origin5_kyanite	=	0	;	int project_origin5_kyanite_basic	=	0	;	int project_origin5_kyanite_cluster	=	0	;
    int project_origin6_fuel	=	1201500	;	int project_origin6_food	=	1201500	;	int project_origin6_steel	=	114450	;	int project_origin6_alloy	=	0	;	int project_origin6_time	=	48600	;	int project_origin6_glory_mark	=	0	;	int project_origin6_kyanite	=	0	;	int project_origin6_kyanite_basic	=	0	;	int project_origin6_kyanite_cluster	=	0	;
    int project_origin7_fuel	=	2280000	;	int project_origin7_food	=	2280000	;	int project_origin7_steel	=	217500	;	int project_origin7_alloy	=	0	;	int project_origin7_time	=	68400	;	int project_origin7_glory_mark	=	0	;	int project_origin7_kyanite	=	0	;	int project_origin7_kyanite_basic	=	0	;	int project_origin7_kyanite_cluster	=	0	;
    int project_origin8_fuel	=	4110000	;	int project_origin8_food	=	4110000	;	int project_origin8_steel	=	391500	;	int project_origin8_alloy	=	0	;	int project_origin8_time	=	81900	;	int project_origin8_glory_mark	=	0	;	int project_origin8_kyanite	=	0	;	int project_origin8_kyanite_basic	=	0	;	int project_origin8_kyanite_cluster	=	0	;
    int project_origin9_fuel	=	6165000	;	int project_origin9_food	=	6165000	;	int project_origin9_steel	=	586500	;	int project_origin9_alloy	=	0	;	int project_origin9_time	=	98100	;	int project_origin9_glory_mark	=	0	;	int project_origin9_kyanite	=	0	;	int project_origin9_kyanite_basic	=	0	;	int project_origin9_kyanite_cluster	=	0	;
    int project_origin10_fuel	=	8175000	;	int project_origin10_food	=	8175000	;	int project_origin10_steel	=	778500	;	int project_origin10_alloy	=	87480	;	int project_origin10_time	=	118800	;	int project_origin10_glory_mark	=	0	;	int project_origin10_kyanite	=	0	;	int project_origin10_kyanite_basic	=	0	;	int project_origin10_kyanite_cluster	=	0	;
    int project_origin11_fuel	=	8514276	;	int project_origin11_food	=	8514276	;	int project_origin11_steel	=	1089000	;	int project_origin11_alloy	=	122580	;	int project_origin11_time	=	151200	;	int project_origin11_glory_mark	=	0	;	int project_origin11_kyanite	=	0	;	int project_origin11_kyanite_basic	=	0	;	int project_origin11_kyanite_cluster	=	0	;
    int project_origin12_fuel	=	9503560	;	int project_origin12_food	=	9503560	;	int project_origin12_steel	=	1416000	;	int project_origin12_alloy	=	159300	;	int project_origin12_time	=	183600	;	int project_origin12_glory_mark	=	0	;	int project_origin12_kyanite	=	0	;	int project_origin12_kyanite_basic	=	0	;	int project_origin12_kyanite_cluster	=	0	;
    int project_origin13_fuel	=	10492847	;	int project_origin13_food	=	10492847	;	int project_origin13_steel	=	1845000	;	int project_origin13_alloy	=	207090	;	int project_origin13_time	=	226800	;	int project_origin13_glory_mark	=	0	;	int project_origin13_kyanite	=	0	;	int project_origin13_kyanite_basic	=	0	;	int project_origin13_kyanite_cluster	=	0	;
    int project_origin14_fuel	=	11482130	;	int project_origin14_food	=	11482130	;	int project_origin14_steel	=	2400000	;	int project_origin14_alloy	=	269460	;	int project_origin14_time	=	291600	;	int project_origin14_glory_mark	=	0	;	int project_origin14_kyanite	=	0	;	int project_origin14_kyanite_basic	=	0	;	int project_origin14_kyanite_cluster	=	0	;
    int project_origin15_fuel	=	12471341	;	int project_origin15_food	=	12471341	;	int project_origin15_steel	=	3105000	;	int project_origin15_alloy	=	351000	;	int project_origin15_time	=	356400	;	int project_origin15_glory_mark	=	0	;	int project_origin15_kyanite	=	12000	;	int project_origin15_kyanite_basic	=	0	;	int project_origin15_kyanite_cluster	=	0	;
    int project_origin16_fuel	=	0	;	int project_origin16_food	=	0	;	int project_origin16_steel	=	4050000	;	int project_origin16_alloy	=	456300	;	int project_origin16_time	=	453600	;	int project_origin16_glory_mark	=	0	;	int project_origin16_kyanite	=	13350	;	int project_origin16_kyanite_basic	=	0	;	int project_origin16_kyanite_cluster	=	0	;
    int project_origin17_fuel	=	0	;	int project_origin17_food	=	0	;	int project_origin17_steel	=	5265000	;	int project_origin17_alloy	=	591300	;	int project_origin17_time	=	561600	;	int project_origin17_glory_mark	=	0	;	int project_origin17_kyanite	=	15225	;	int project_origin17_kyanite_basic	=	0	;	int project_origin17_kyanite_cluster	=	0	;
    int project_origin18_fuel	=	0	;	int project_origin18_food	=	0	;	int project_origin18_steel	=	6840000	;	int project_origin18_alloy	=	769500	;	int project_origin18_time	=	702000	;	int project_origin18_glory_mark	=	0	;	int project_origin18_kyanite	=	17580	;	int project_origin18_kyanite_basic	=	0	;	int project_origin18_kyanite_cluster	=	0	;
    int project_origin19_fuel	=	0	;	int project_origin19_food	=	0	;	int project_origin19_steel	=	8895000	;	int project_origin19_alloy	=	999000	;	int project_origin19_time	=	874800	;	int project_origin19_glory_mark	=	0	;	int project_origin19_kyanite	=	20400	;	int project_origin19_kyanite_basic	=	6515	;	int project_origin19_kyanite_cluster	=	0	;
    int project_origin20_fuel	=	0	;	int project_origin20_food	=	0	;	int project_origin20_steel	=	11550000	;	int project_origin20_alloy	=	1301400	;	int project_origin20_time	=	1015200	;	int project_origin20_glory_mark	=	0	;	int project_origin20_kyanite	=	23430	;	int project_origin20_kyanite_basic	=	7520	;	int project_origin20_kyanite_cluster	=	0	;
    int project_origin21_fuel	=	0	;	int project_origin21_food	=	0	;	int project_origin21_steel	=	0	;	int project_origin21_alloy	=	1587942	;	int project_origin21_time	=	1166400	;	int project_origin21_glory_mark	=	0	;	int project_origin21_kyanite	=	26775	;	int project_origin21_kyanite_basic	=	8650	;	int project_origin21_kyanite_cluster	=	0	;
    int project_origin22_fuel	=	0	;	int project_origin22_food	=	0	;	int project_origin22_steel	=	0	;	int project_origin22_alloy	=	1775250	;	int project_origin22_time	=	1339200	;	int project_origin22_glory_mark	=	0	;	int project_origin22_kyanite	=	30630	;	int project_origin22_kyanite_basic	=	9960	;	int project_origin22_kyanite_cluster	=	1480	;
    int project_origin23_fuel	=	0	;	int project_origin23_food	=	0	;	int project_origin23_steel	=	0	;	int project_origin23_alloy	=	1962702	;	int project_origin23_time	=	1533600	;	int project_origin23_glory_mark	=	0	;	int project_origin23_kyanite	=	34950	;	int project_origin23_kyanite_basic	=	12138	;	int project_origin23_kyanite_cluster	=	1650	;
    int project_origin24_fuel	=	0	;	int project_origin24_food	=	0	;	int project_origin24_steel	=	0	;	int project_origin24_alloy	=	0	;	int project_origin24_time	=	1658880	;	int project_origin24_glory_mark	=	0	;	int project_origin24_kyanite	=	39900	;	int project_origin24_kyanite_basic	=	14426	;	int project_origin24_kyanite_cluster	=	1800	;
    int project_origin25_fuel	=	0	;	int project_origin25_food	=	0	;	int project_origin25_steel	=	0	;	int project_origin25_alloy	=	0	;	int project_origin25_time	=	1857600	;	int project_origin25_glory_mark	=	0	;	int project_origin25_kyanite	=	45345	;	int project_origin25_kyanite_basic	=	16827	;	int project_origin25_kyanite_cluster	=	2700	;
    int project_origin26_fuel	=	0	;	int project_origin26_food	=	0	;	int project_origin26_steel	=	0	;	int project_origin26_alloy	=	0	;	int project_origin26_time	=	2116800	;	int project_origin26_glory_mark	=	0	;	int project_origin26_kyanite	=	77003	;	int project_origin26_kyanite_basic	=	29024	;	int project_origin26_kyanite_cluster	=	5400	;
    int project_origin27_fuel	=	0	;	int project_origin27_food	=	0	;	int project_origin27_steel	=	0	;	int project_origin27_alloy	=	0	;	int project_origin27_time	=	2332800	;	int project_origin27_glory_mark	=	0	;	int project_origin27_kyanite	=	86885	;	int project_origin27_kyanite_basic	=	32994	;	int project_origin27_kyanite_cluster	=	7200	;
    int project_origin28_fuel	=	0	;	int project_origin28_food	=	0	;	int project_origin28_steel	=	0	;	int project_origin28_alloy	=	0	;	int project_origin28_time	=	2462400	;	int project_origin28_glory_mark	=	0	;	int project_origin28_kyanite	=	97754	;	int project_origin28_kyanite_basic	=	37164	;	int project_origin28_kyanite_cluster	=	9563	;
    int project_origin29_fuel	=	0	;	int project_origin29_food	=	0	;	int project_origin29_steel	=	0	;	int project_origin29_alloy	=	0	;	int project_origin29_time	=	2548800	;	int project_origin29_glory_mark	=	0	;	int project_origin29_kyanite	=	109710	;	int project_origin29_kyanite_basic	=	41543	;	int project_origin29_kyanite_cluster	=	13050	;
    int project_origin30_fuel	=	0	;	int project_origin30_food	=	0	;	int project_origin30_steel	=	0	;	int project_origin30_alloy	=	0	;	int project_origin30_time	=	2592000	;	int project_origin30_glory_mark	=	0	;	int project_origin30_kyanite	=	87480	;	int project_origin30_kyanite_basic	=	87480	;	int project_origin30_kyanite_cluster	=	87480	;
    int project_origin31_fuel	=	240574121	;	int project_origin31_food	=	240574121	;	int project_origin31_steel	=	0	;	int project_origin31_alloy	=	0	;	int project_origin31_time	=	1347138	;	int project_origin31_glory_mark	=	256976	;	int project_origin31_kyanite	=	885750	;	int project_origin31_kyanite_basic	=	463031	;	int project_origin31_kyanite_cluster	=	104005	;
    int project_origin32_fuel	=	0	;	int project_origin32_food	=	0	;	int project_origin32_steel	=	0	;	int project_origin32_alloy	=	0	;	int project_origin32_time	=	1505987	;	int project_origin32_glory_mark	=	287409	;	int project_origin32_kyanite	=	990642	;	int project_origin32_kyanite_basic	=	524149	;	int project_origin32_kyanite_cluster	=	115313	;
    int project_origin33_fuel	=	0	;	int project_origin33_food	=	0	;	int project_origin33_steel	=	22522163	;	int project_origin33_alloy	=	0	;	int project_origin33_time	=	1764832	;	int project_origin33_glory_mark	=	336810	;	int project_origin33_kyanite	=	1160914	;	int project_origin33_kyanite_basic	=	614240	;	int project_origin33_kyanite_cluster	=	135135	;
    int project_origin34_fuel	=	0	;	int project_origin34_food	=	0	;	int project_origin34_steel	=	0	;	int project_origin34_alloy	=	1876368	;	int project_origin34_time	=	2343990	;	int project_origin34_glory_mark	=	447339	;	int project_origin34_kyanite	=	1541882	;	int project_origin34_kyanite_basic	=	815812	;	int project_origin34_kyanite_cluster	=	179480	;
    int project_origin35_fuel	=	0	;	int project_origin35_food	=	0	;	int project_origin35_steel	=	0	;	int project_origin35_alloy	=	0	;	int project_origin35_time	=	4518775	;	int project_origin35_glory_mark	=	862383	;	int project_origin35_kyanite	=	2972463	;	int project_origin35_kyanite_basic	=	1572733	;	int project_origin35_kyanite_cluster	=	345973	;

    //--------------------------------------------------------------------------
    int shelter1_fuel	 =	255	;	int shelter1_food	 =	0	;	int shelter1_steel	 =	0	;	int shelter1_time	 =	160	;	int shelter1_glory_mark	=	0	;	int shelter1_kyanite	=	0	;	int shelter1_kyanite_basic	=	0	;	int shelter1_kyanite_cluster	=	0	;
    int shelter2_fuel	 =	357	;	int shelter2_food	 =	0	;	int shelter2_steel	 =	0	;	int shelter2_time	 =	290	;	int shelter2_glory_mark	=	0	;	int shelter2_kyanite	=	0	;	int shelter2_kyanite_basic	=	0	;	int shelter2_kyanite_cluster	=	0	;
    int shelter3_fuel	 =	500	;	int shelter3_food	 =	0	;	int shelter3_steel	 =	0	;	int shelter3_time	 =	428	;	int shelter3_glory_mark	=	0	;	int shelter3_kyanite	=	0	;	int shelter3_kyanite_basic	=	0	;	int shelter3_kyanite_cluster	=	0	;
    int shelter4_fuel	 =	750	;	int shelter4_food	 =	0	;	int shelter4_steel	 =	0	;	int shelter4_time	 =	581	;	int shelter4_glory_mark	=	0	;	int shelter4_kyanite	=	0	;	int shelter4_kyanite_basic	=	0	;	int shelter4_kyanite_cluster	=	0	;
    int shelter5_fuel	 =	1200	;	int shelter5_food	 =	0	;	int shelter5_steel	 =	0	;	int shelter5_time	 =	595	;	int shelter5_glory_mark	=	0	;	int shelter5_kyanite	=	0	;	int shelter5_kyanite_basic	=	0	;	int shelter5_kyanite_cluster	=	0	;
    int shelter6_fuel	 =	2160	;	int shelter6_food	 =	0	;	int shelter6_steel	 =	0	;	int shelter6_time	 =	890	;	int shelter6_glory_mark	=	0	;	int shelter6_kyanite	=	0	;	int shelter6_kyanite_basic	=	0	;	int shelter6_kyanite_cluster	=	0	;
    int shelter7_fuel	 =	4100	;	int shelter7_food	 =	0	;	int shelter7_steel	 =	0	;	int shelter7_time	 =	3580	;	int shelter7_glory_mark	=	0	;	int shelter7_kyanite	=	0	;	int shelter7_kyanite_basic	=	0	;	int shelter7_kyanite_cluster	=	0	;
    int shelter8_fuel	 =	8200	;	int shelter8_food	 =	0	;	int shelter8_steel	 =	0	;	int shelter8_time	 =	4500	;	int shelter8_glory_mark	=	0	;	int shelter8_kyanite	=	0	;	int shelter8_kyanite_basic	=	0	;	int shelter8_kyanite_cluster	=	0	;
    int shelter9_fuel	 =	16400	;	int shelter9_food	 =	0	;	int shelter9_steel	 =	0	;	int shelter9_time	 =	5100	;	int shelter9_glory_mark	=	0	;	int shelter9_kyanite	=	0	;	int shelter9_kyanite_basic	=	0	;	int shelter9_kyanite_cluster	=	0	;
    int shelter10_fuel	 =	32800	;	int shelter10_food	 =	0	;	int shelter10_steel	 =	0	;	int shelter10_time	 =	6300	;	int shelter10_glory_mark	=	0	;	int shelter10_kyanite	=	0	;	int shelter10_kyanite_basic	=	0	;	int shelter10_kyanite_cluster	=	0	;
    int shelter11_fuel	 =	40400	;	int shelter11_food	 =	4210	;	int shelter11_steel	 =	0	;	int shelter11_time	 =	7500	;	int shelter11_glory_mark	=	0	;	int shelter11_kyanite	=	0	;	int shelter11_kyanite_basic	=	0	;	int shelter11_kyanite_cluster	=	0	;
    int shelter12_fuel	 =	80800	;	int shelter12_food	 =	8420	;	int shelter12_steel	 =	0	;	int shelter12_time	 =	9300	;	int shelter12_glory_mark	=	0	;	int shelter12_kyanite	=	0	;	int shelter12_kyanite_basic	=	0	;	int shelter12_kyanite_cluster	=	0	;
    int shelter13_fuel	 =	153000	;	int shelter13_food	 =	16000	;	int shelter13_steel	 =	0	;	int shelter13_time	 =	11700	;	int shelter13_glory_mark	=	0	;	int shelter13_kyanite	=	0	;	int shelter13_kyanite_basic	=	0	;	int shelter13_kyanite_cluster	=	0	;
    int shelter14_fuel	 =	276000	;	int shelter14_food	 =	28800	;	int shelter14_steel	 =	0	;	int shelter14_time	 =	14700	;	int shelter14_glory_mark	=	0	;	int shelter14_kyanite	=	0	;	int shelter14_kyanite_basic	=	0	;	int shelter14_kyanite_cluster	=	0	;
    int shelter15_fuel	 =	414000	;	int shelter15_food	 =	43200	;	int shelter15_steel	 =	0	;	int shelter15_time	 =	18300	;	int shelter15_glory_mark	=	0	;	int shelter15_kyanite	=	0	;	int shelter15_kyanite_basic	=	0	;	int shelter15_kyanite_cluster	=	0	;
    int shelter16_fuel	 =	471000	;	int shelter16_food	 =	49100	;	int shelter16_steel	 =	7370	;	int shelter16_time	 =	23100	;	int shelter16_glory_mark	=	0	;	int shelter16_kyanite	=	0	;	int shelter16_kyanite_basic	=	0	;	int shelter16_kyanite_cluster	=	0	;
    int shelter17_fuel	 =	660000	;	int shelter17_food	 =	68700	;	int shelter17_steel	 =	10300	;	int shelter17_time	 =	28800	;	int shelter17_glory_mark	=	0	;	int shelter17_kyanite	=	0	;	int shelter17_kyanite_basic	=	0	;	int shelter17_kyanite_cluster	=	0	;
    int shelter18_fuel	 =	858000	;	int shelter18_food	 =	89400	;	int shelter18_steel	 =	13400	;	int shelter18_time	 =	36000	;	int shelter18_glory_mark	=	0	;	int shelter18_kyanite	=	0	;	int shelter18_kyanite_basic	=	0	;	int shelter18_kyanite_cluster	=	0	;
    int shelter19_fuel	 =	1120000	;	int shelter19_food	 =	116000	;	int shelter19_steel	 =	17400	;	int shelter19_time	 =	43200	;	int shelter19_glory_mark	=	0	;	int shelter19_kyanite	=	0	;	int shelter19_kyanite_basic	=	0	;	int shelter19_kyanite_cluster	=	0	;
    int shelter20_fuel	 =	1450000	;	int shelter20_food	 =	151000	;	int shelter20_steel	 =	22700	;	int shelter20_time	 =	57600	;	int shelter20_glory_mark	=	0	;	int shelter20_kyanite	=	0	;	int shelter20_kyanite_basic	=	0	;	int shelter20_kyanite_cluster	=	0	;
    int shelter21_fuel	 =	1880000	;	int shelter21_food	 =	196000	;	int shelter21_steel	 =	29500	;	int shelter21_time	 =	64800	;	int shelter21_glory_mark	=	0	;	int shelter21_kyanite	=	0	;	int shelter21_kyanite_basic	=	0	;	int shelter21_kyanite_cluster	=	0	;
    int shelter22_fuel	 =	2450000	;	int shelter22_food	 =	255000	;	int shelter22_steel	 =	38300	;	int shelter22_time	 =	75600	;	int shelter22_glory_mark	=	0	;	int shelter22_kyanite	=	0	;	int shelter22_kyanite_basic	=	0	;	int shelter22_kyanite_cluster	=	0	;
    int shelter23_fuel	 =	3190000	;	int shelter23_food	 =	332000	;	int shelter23_steel	 =	49800	;	int shelter23_time	 =	86400	;	int shelter23_glory_mark	=	0	;	int shelter23_kyanite	=	0	;	int shelter23_kyanite_basic	=	0	;	int shelter23_kyanite_cluster	=	0	;
    int shelter24_fuel	 =	4140000	;	int shelter24_food	 =	431000	;	int shelter24_steel	 =	64700	;	int shelter24_time	 =	97200	;	int shelter24_glory_mark	=	0	;	int shelter24_kyanite	=	0	;	int shelter24_kyanite_basic	=	0	;	int shelter24_kyanite_cluster	=	0	;
    int shelter25_fuel	 =	5380000	;	int shelter25_food	 =	561000	;	int shelter25_steel	 =	84100	;	int shelter25_time	 =	111600	;	int shelter25_glory_mark	=	0	;	int shelter25_kyanite	=	0	;	int shelter25_kyanite_basic	=	0	;	int shelter25_kyanite_cluster	=	0	;
    int shelter26_fuel	 =	7000000	;	int shelter26_food	 =	729000	;	int shelter26_steel	 =	109000	;	int shelter26_time	 =	129600	;	int shelter26_glory_mark	=	0	;	int shelter26_kyanite	=	0	;	int shelter26_kyanite_basic	=	0	;	int shelter26_kyanite_cluster	=	0	;
    int shelter27_fuel	 =	9100000	;	int shelter27_food	 =	948000	;	int shelter27_steel	 =	142000	;	int shelter27_time	 =	147600	;	int shelter27_glory_mark	=	0	;	int shelter27_kyanite	=	0	;	int shelter27_kyanite_basic	=	0	;	int shelter27_kyanite_cluster	=	0	;
    int shelter28_fuel	 =	11800000	;	int shelter28_food	 =	1230000	;	int shelter28_steel	 =	185000	;	int shelter28_time	 =	172800	;	int shelter28_glory_mark	=	0	;	int shelter28_kyanite	=	0	;	int shelter28_kyanite_basic	=	0	;	int shelter28_kyanite_cluster	=	0	;
    int shelter29_fuel	 =	15400000	;	int shelter29_food	 =	1600000	;	int shelter29_steel	 =	240000	;	int shelter29_time	 =	198000	;	int shelter29_glory_mark	=	0	;	int shelter29_kyanite	=	0	;	int shelter29_kyanite_basic	=	0	;	int shelter29_kyanite_cluster	=	0	;
    int shelter30_fuel	 =	20000000	;	int shelter30_food	 =	2080000	;	int shelter30_steel	 =	312000	;	int shelter30_time	 =	226800	;	int shelter30_glory_mark	=	0	;	int shelter30_kyanite	=	0	;	int shelter30_kyanite_basic	=	0	;	int shelter30_kyanite_cluster	=	0	;
    int shelter31_fuel	 =	103446872	;	int shelter31_food	 =	7389062	;	int shelter31_steel	 =	463495	;	int shelter31_time	 =	105237	;	int shelter31_glory_mark	=	105237	;	int shelter31_kyanite	=	120912	;	int shelter31_kyanite_basic	=	167933	;	int shelter31_kyanite_cluster	=	13435	;
    int shelter32_fuel	 =	115697489	;	int shelter32_food	 =	8264106	;	int shelter32_steel	 =	518385	;	int shelter32_time	 =	117700	;	int shelter32_glory_mark	=	117700	;	int shelter32_kyanite	=	135230	;	int shelter32_kyanite_basic	=	187821	;	int shelter32_kyanite_cluster	=	15025	;
    int shelter33_fuel	 =	135583415	;	int shelter33_food	 =	9684529	;	int shelter33_steel	 =	607484	;	int shelter33_time	 =	137932	;	int shelter33_glory_mark	=	137932	;	int shelter33_kyanite	=	158474	;	int shelter33_kyanite_basic	=	220103	;	int shelter33_kyanite_cluster	=	17608	;
    int shelter34_fuel	 =	180076981	;	int shelter34_food	 =	12862641	;	int shelter34_steel	 =	806838	;	int shelter34_time	 =	183195	;	int shelter34_glory_mark	=	183195	;	int shelter34_kyanite	=	210480	;	int shelter34_kyanite_basic	=	292332	;	int shelter34_kyanite_cluster	=	23388	;
    int shelter35_fuel	 =	347154566	;	int shelter35_food	 =	24796755	;	int shelter35_steel	 =	1555433	;	int shelter35_time	 =	353167	;	int shelter35_glory_mark	=	353167	;	int shelter35_kyanite	=	405767	;	int shelter35_kyanite_basic	=	563562	;	int shelter35_kyanite_cluster	=	45085	;

    //--------------------------------------------------------------------------
    int shrine1_fuel	 =	280	;	int shrine1_food	 =	0	;	int shrine1_steel	 =	0	;	int shrine1_time	 =	0	;	int shrine1_alloy	 =	280	;
    int shrine2_fuel	 =	392	;	int shrine2_food	 =	0	;	int shrine2_steel	 =	0	;	int shrine2_time	 =	0	;	int shrine2_alloy	 =	590	;
    int shrine3_fuel	 =	549	;	int shrine3_food	 =	0	;	int shrine3_steel	 =	0	;	int shrine3_time	 =	0	;	int shrine3_alloy	 =	885	;
    int shrine4_fuel	 =	823	;	int shrine4_food	 =	0	;	int shrine4_steel	 =	0	;	int shrine4_time	 =	0	;	int shrine4_alloy	 =	3580	;
    int shrine5_fuel	 =	1320	;	int shrine5_food	 =	0	;	int shrine5_steel	 =	0	;	int shrine5_time	 =	0	;	int shrine5_alloy	 =	3880	;
    int shrine6_fuel	 =	2370	;	int shrine6_food	 =	0	;	int shrine6_steel	 =	0	;	int shrine6_time	 =	0	;	int shrine6_alloy	 =	4180	;
    int shrine7_fuel	 =	4500	;	int shrine7_food	 =	0	;	int shrine7_steel	 =	0	;	int shrine7_time	 =	0	;	int shrine7_alloy	 =	5700	;
    int shrine8_fuel	 =	9010	;	int shrine8_food	 =	0	;	int shrine8_steel	 =	0	;	int shrine8_time	 =	0	;	int shrine8_alloy	 =	8100	;
    int shrine9_fuel	 =	18000	;	int shrine9_food	 =	0	;	int shrine9_steel	 =	0	;	int shrine9_time	 =	0	;	int shrine9_alloy	 =	9600	;
    int shrine10_fuel	 =	36000	;	int shrine10_food	 =	0	;	int shrine10_steel	 =	0	;	int shrine10_time	 =	0	;	int shrine10_alloy	 =	11700	;
    int shrine11_fuel	 =	36000	;	int shrine11_food	 =	0	;	int shrine11_steel	 =	6010	;	int shrine11_time	 =	0	;	int shrine11_alloy	 =	13800	;
    int shrine12_fuel	 =	72100	;	int shrine12_food	 =	0	;	int shrine12_steel	 =	12000	;	int shrine12_time	 =	0	;	int shrine12_alloy	 =	17400	;
    int shrine13_fuel	 =	137000	;	int shrine13_food	 =	0	;	int shrine13_steel	 =	22800	;	int shrine13_time	 =	0	;	int shrine13_alloy	 =	21900	;
    int shrine14_fuel	 =	246000	;	int shrine14_food	 =	0	;	int shrine14_steel	 =	41100	;	int shrine14_time	 =	0	;	int shrine14_alloy	 =	27300	;
    int shrine15_fuel	 =	370000	;	int shrine15_food	 =	0	;	int shrine15_steel	 =	61600	;	int shrine15_time	 =	0	;	int shrine15_alloy	 =	32400	;
    int shrine16_fuel	 =	345000	;	int shrine16_food	 =	0	;	int shrine16_steel	 =	57500	;	int shrine16_time	 =	14400	;	int shrine16_alloy	 =	43200	;
    int shrine17_fuel	 =	483000	;	int shrine17_food	 =	0	;	int shrine17_steel	 =	80500	;	int shrine17_time	 =	20100	;	int shrine17_alloy	 =	54000	;
    int shrine18_fuel	 =	628000	;	int shrine18_food	 =	0	;	int shrine18_steel	 =	105000	;	int shrine18_time	 =	26200	;	int shrine18_alloy	 =	64800	;
    int shrine19_fuel	 =	816000	;	int shrine19_food	 =	0	;	int shrine19_steel	 =	136000	;	int shrine19_time	 =	34000	;	int shrine19_alloy	 =	82800	;
    int shrine20_fuel	 =	1060000	;	int shrine20_food	 =	0	;	int shrine20_steel	 =	177000	;	int shrine20_time	 =	44200	;	int shrine20_alloy	 =	104400	;
    int shrine21_fuel	 =	1380000	;	int shrine21_food	 =	0	;	int shrine21_steel	 =	230000	;	int shrine21_time	 =	57500	;	int shrine21_alloy	 =	118800	;
    int shrine22_fuel	 =	1790000	;	int shrine22_food	 =	0	;	int shrine22_steel	 =	299000	;	int shrine22_time	 =	74700	;	int shrine22_alloy	 =	136800	;
    int shrine23_fuel	 =	2330000	;	int shrine23_food	 =	0	;	int shrine23_steel	 =	389000	;	int shrine23_time	 =	97200	;	int shrine23_alloy	 =	158400	;
    int shrine24_fuel	 =	3030000	;	int shrine24_food	 =	0	;	int shrine24_steel	 =	505000	;	int shrine24_time	 =	126000	;	int shrine24_alloy	 =	180000	;
    int shrine25_fuel	 =	3940000	;	int shrine25_food	 =	0	;	int shrine25_steel	 =	657000	;	int shrine25_time	 =	164000	;	int shrine25_alloy	 =	208800	;
    int shrine26_fuel	 =	5120000	;	int shrine26_food	 =	0	;	int shrine26_steel	 =	854000	;	int shrine26_time	 =	213000	;	int shrine26_alloy	 =	241200	;
    int shrine27_fuel	 =	6660000	;	int shrine27_food	 =	0	;	int shrine27_steel	 =	1110000	;	int shrine27_time	 =	278000	;	int shrine27_alloy	 =	277200	;
    int shrine28_fuel	 =	8660000	;	int shrine28_food	 =	0	;	int shrine28_steel	 =	1440000	;	int shrine28_time	 =	361000	;	int shrine28_alloy	 =	316800	;
    int shrine29_fuel	 =	11300000	;	int shrine29_food	 =	0	;	int shrine29_steel	 =	1880000	;	int shrine29_time	 =	469000	;	int shrine29_alloy	 =	363600	;
    int shrine30_fuel	 =	14600000	;	int shrine30_food	 =	0	;	int shrine30_steel	 =	2440000	;	int shrine30_time	 =	610000	;	int shrine30_alloy	 =	420000	;

    //--------------------------------------------------------------------------
    int steel_fuel1	 =	160	;	int steel1_time	 =	581	;	int steel1_glory_mark	=	0	;	int steel1_kyanite	=	0	;	int steel1_kyanite_basic	=	0	;	int steel1_kyanite_cluster	=	0	;
    int steel_fuel2	 =	224	;	int steel2_time	 =	582	;	int steel2_glory_mark	=	1	;	int steel2_kyanite	=	1	;	int steel2_kyanite_basic	=	0	;	int steel2_kyanite_cluster	=	0	;
    int steel_fuel3	 =	314	;	int steel3_time	 =	428	;	int steel3_glory_mark	=	2	;	int steel3_kyanite	=	2	;	int steel3_kyanite_basic	=	0	;	int steel3_kyanite_cluster	=	0	;
    int steel_fuel4	 =	470	;	int steel4_time	 =	721	;	int steel4_glory_mark	=	3	;	int steel4_kyanite	=	3	;	int steel4_kyanite_basic	=	0	;	int steel4_kyanite_cluster	=	0	;
    int steel_fuel5	 =	753	;	int steel5_time	 =	885	;	int steel5_glory_mark	=	4	;	int steel5_kyanite	=	4	;	int steel5_kyanite_basic	=	0	;	int steel5_kyanite_cluster	=	0	;
    int steel_fuel6	 =	1350	;	int steel6_time	 =	1200	;	int steel6_glory_mark	=	5	;	int steel6_kyanite	=	5	;	int steel6_kyanite_basic	=	0	;	int steel6_kyanite_cluster	=	0	;
    int steel_fuel7	 =	2570	;	int steel7_time	 =	2100	;	int steel7_glory_mark	=	6	;	int steel7_kyanite	=	6	;	int steel7_kyanite_basic	=	0	;	int steel7_kyanite_cluster	=	0	;
    int steel_fuel8	 =	5150	;	int steel8_time	 =	3000	;	int steel8_glory_mark	=	7	;	int steel8_kyanite	=	7	;	int steel8_kyanite_basic	=	0	;	int steel8_kyanite_cluster	=	0	;
    int steel_fuel9	 =	10300	;	int steel9_time	 =	3300	;	int steel9_glory_mark	=	8	;	int steel9_kyanite	=	8	;	int steel9_kyanite_basic	=	0	;	int steel9_kyanite_cluster	=	0	;
    int steel_fuel10	 =	20600	;	int steel10_time	 =	4200	;	int steel10_glory_mark	=	9	;	int steel10_kyanite	=	9	;	int steel10_kyanite_basic	=	0	;	int steel10_kyanite_cluster	=	0	;
    int steel_fuel11	 =	41200	;	int steel11_time	 =	4800	;	int steel11_glory_mark	=	10	;	int steel11_kyanite	=	10	;	int steel11_kyanite_basic	=	0	;	int steel11_kyanite_cluster	=	0	;
    int steel_fuel12	 =	82400	;	int steel12_time	 =	6300	;	int steel12_glory_mark	=	11	;	int steel12_kyanite	=	11	;	int steel12_kyanite_basic	=	0	;	int steel12_kyanite_cluster	=	0	;
    int steel_fuel13	 =	157000	;	int steel13_time	 =	7800	;	int steel13_glory_mark	=	12	;	int steel13_kyanite	=	12	;	int steel13_kyanite_basic	=	0	;	int steel13_kyanite_cluster	=	0	;
    int steel_fuel14	 =	282000	;	int steel14_time	 =	9600	;	int steel14_glory_mark	=	13	;	int steel14_kyanite	=	13	;	int steel14_kyanite_basic	=	0	;	int steel14_kyanite_cluster	=	0	;
    int steel_fuel15	 =	423000	;	int steel15_time	 =	12000	;	int steel15_glory_mark	=	14	;	int steel15_kyanite	=	14	;	int steel15_kyanite_basic	=	0	;	int steel15_kyanite_cluster	=	0	;
    int steel_fuel16	 =	592000	;	int steel16_time	 =	15000	;	int steel16_glory_mark	=	15	;	int steel16_kyanite	=	15	;	int steel16_kyanite_basic	=	0	;	int steel16_kyanite_cluster	=	0	;
    int steel_fuel17	 =	828000	;	int steel17_time	 =	18900	;	int steel17_glory_mark	=	16	;	int steel17_kyanite	=	16	;	int steel17_kyanite_basic	=	0	;	int steel17_kyanite_cluster	=	0	;
    int steel_fuel18	 =	1080000	;	int steel18_time	 =	23700	;	int steel18_glory_mark	=	17	;	int steel18_kyanite	=	17	;	int steel18_kyanite_basic	=	0	;	int steel18_kyanite_cluster	=	0	;
    int steel_fuel19	 =	1400000	;	int steel19_time	 =	28800	;	int steel19_glory_mark	=	18	;	int steel19_kyanite	=	18	;	int steel19_kyanite_basic	=	0	;	int steel19_kyanite_cluster	=	0	;
    int steel_fuel20	 =	1820000	;	int steel20_time	 =	36900	;	int steel20_glory_mark	=	19	;	int steel20_kyanite	=	19	;	int steel20_kyanite_basic	=	0	;	int steel20_kyanite_cluster	=	0	;
    int steel_fuel21	 =	2370000	;	int steel21_time	 =	42300	;	int steel21_glory_mark	=	20	;	int steel21_kyanite	=	20	;	int steel21_kyanite_basic	=	0	;	int steel21_kyanite_cluster	=	0	;
    int steel_fuel22	 =	3080000	;	int steel22_time	 =	50400	;	int steel22_glory_mark	=	21	;	int steel22_kyanite	=	21	;	int steel22_kyanite_basic	=	0	;	int steel22_kyanite_cluster	=	0	;
    int steel_fuel23	 =	4000000	;	int steel23_time	 =	57600	;	int steel23_glory_mark	=	22	;	int steel23_kyanite	=	22	;	int steel23_kyanite_basic	=	0	;	int steel23_kyanite_cluster	=	0	;
    int steel_fuel24	 =	5200000	;	int steel24_time	 =	64800	;	int steel24_glory_mark	=	23	;	int steel24_kyanite	=	23	;	int steel24_kyanite_basic	=	0	;	int steel24_kyanite_cluster	=	0	;
    int steel_fuel25	 =	6760000	;	int steel25_time	 =	75600	;	int steel25_glory_mark	=	24	;	int steel25_kyanite	=	24	;	int steel25_kyanite_basic	=	0	;	int steel25_kyanite_cluster	=	0	;
    int steel_fuel26	 =	8780000	;	int steel26_time	 =	86400	;	int steel26_glory_mark	=	25	;	int steel26_kyanite	=	25	;	int steel26_kyanite_basic	=	0	;	int steel26_kyanite_cluster	=	0	;
    int steel_fuel27	 =	11400000	;	int steel27_time	 =	97200	;	int steel27_glory_mark	=	26	;	int steel27_kyanite	=	26	;	int steel27_kyanite_basic	=	0	;	int steel27_kyanite_cluster	=	0	;
    int steel_fuel28	 =	14800000	;	int steel28_time	 =	111600	;	int steel28_glory_mark	=	27	;	int steel28_kyanite	=	27	;	int steel28_kyanite_basic	=	0	;	int steel28_kyanite_cluster	=	0	;
    int steel_fuel29	 =	19300000	;	int steel29_time	 =	129600	;	int steel29_glory_mark	=	28	;	int steel29_kyanite	=	28	;	int steel29_kyanite_basic	=	0	;	int steel29_kyanite_cluster	=	0	;
    int steel_fuel30	 =	25100000	;	int steel30_time	 =	149100	;	int steel30_glory_mark	=	29	;	int steel30_kyanite	=	29	;	int steel30_kyanite_basic	=	0	;	int steel30_kyanite_cluster	=	0	;
    int steel_fuel31	 =	129910026	;	int steel31_time	 =	815338	;	int steel31_glory_mark	=	171318	;	int steel31_kyanite	=	253072	;	int steel31_kyanite_basic	=	351489	;	int steel31_kyanite_cluster	=	28120	;
    int steel_fuel32	 =	145294523	;	int steel32_time	 =	945195	;	int steel32_glory_mark	=	191607	;	int steel32_kyanite	=	283041	;	int steel32_kyanite_basic	=	393112	;	int steel32_kyanite_cluster	=	31449	;
    int steel_fuel33	 =	170267545	;	int steel33_time	 =	1095738	;	int steel33_glory_mark	=	224540	;	int steel33_kyanite	=	331691	;	int steel33_kyanite_basic	=	460681	;	int steel33_kyanite_cluster	=	36855	;
    int steel_fuel34	 =	226143184	;	int steel34_time	 =	1270264	;	int steel34_glory_mark	=	298226	;	int steel34_kyanite	=	440539	;	int steel34_kyanite_basic	=	611859	;	int steel34_kyanite_cluster	=	48949	;
    int steel_fuel35	 =	435961547	;	int steel35_time	 =	1472586	;	int steel35_glory_mark	=	574922	;	int steel35_kyanite	=	849276	;	int steel35_kyanite_basic	=	1179550	;	int steel35_kyanite_cluster	=	94364	;

    //--------------------------------------------------------------------------
    int store1_fuel	 =	900	;	int store1_food	 =	0	;	int store1_steel	 =	0	;	int store1_alloy	 =	0	;	int store1_time	 =	50	;
    int store2_fuel	 =	1260	;	int store2_food	 =	0	;	int store2_steel	 =	0	;	int store2_alloy	 =	0	;	int store2_time	 =	326	;
    int store3_fuel	 =	1760	;	int store3_food	 =	0	;	int store3_steel	 =	0	;	int store3_alloy	 =	0	;	int store3_time	 =	428	;
    int store4_fuel	 =	2650	;	int store4_food	 =	0	;	int store4_steel	 =	0	;	int store4_alloy	 =	0	;	int store4_time	 =	721	;
    int store5_fuel	 =	4230	;	int store5_food	 =	0	;	int store5_steel	 =	0	;	int store5_alloy	 =	0	;	int store5_time	 =	1163	;
    int store6_fuel	 =	7620	;	int store6_food	 =	0	;	int store6_steel	 =	0	;	int store6_alloy	 =	0	;	int store6_time	 =	2930	;
    int store7_fuel	 =	14500	;	int store7_food	 =	0	;	int store7_steel	 =	0	;	int store7_alloy	 =	0	;	int store7_time	 =	8100	;
    int store8_fuel	 =	29000	;	int store8_food	 =	0	;	int store8_steel	 =	0	;	int store8_alloy	 =	0	;	int store8_time	 =	13500	;
    int store9_fuel	 =	57900	;	int store9_food	 =	0	;	int store9_steel	 =	0	;	int store9_alloy	 =	0	;	int store9_time	 =	16200	;
    int store10_fuel	 =	116000	;	int store10_food	 =	0	;	int store10_steel	 =	0	;	int store10_alloy	 =	0	;	int store10_time	 =	19500	;
    int store11_fuel	 =	143000	;	int store11_food	 =	0	;	int store11_steel	 =	14900	;	int store11_alloy	 =	0	;	int store11_time	 =	23400	;
    int store12_fuel	 =	285000	;	int store12_food	 =	0	;	int store12_steel	 =	29700	;	int store12_alloy	 =	0	;	int store12_time	 =	28800	;
    int store13_fuel	 =	542000	;	int store13_food	 =	0	;	int store13_steel	 =	56400	;	int store13_alloy	 =	0	;	int store13_time	 =	36000	;
    int store14_fuel	 =	975000	;	int store14_food	 =	0	;	int store14_steel	 =	102000	;	int store14_alloy	 =	0	;	int store14_time	 =	46800	;
    int store15_fuel	 =	1460000	;	int store15_food	 =	0	;	int store15_steel	 =	152000	;	int store15_alloy	 =	0	;	int store15_time	 =	57600	;
    int store16_fuel	 =	1660000	;	int store16_food	 =	0	;	int store16_steel	 =	173000	;	int store16_alloy	 =	26000	;	int store16_time	 =	72000	;
    int store17_fuel	 =	2330000	;	int store17_food	 =	0	;	int store17_steel	 =	243000	;	int store17_alloy	 =	36400	;	int store17_time	 =	90000	;
    int store18_fuel	 =	3030000	;	int store18_food	 =	0	;	int store18_steel	 =	315000	;	int store18_alloy	 =	47300	;	int store18_time	 =	111600	;
    int store19_fuel	 =	3940000	;	int store19_food	 =	0	;	int store19_steel	 =	410000	;	int store19_alloy	 =	61500	;	int store19_time	 =	140400	;
    int store20_fuel	 =	5120000	;	int store20_food	 =	0	;	int store20_steel	 =	533000	;	int store20_alloy	 =	80000	;	int store20_time	 =	172800	;
    int store21_fuel	 =	6650000	;	int store21_food	 =	0	;	int store21_steel	 =	693000	;	int store21_alloy	 =	104000	;	int store21_time	 =	201600	;
    int store22_fuel	 =	8650000	;	int store22_food	 =	0	;	int store22_steel	 =	901000	;	int store22_alloy	 =	135000	;	int store22_time	 =	230400	;
    int store23_fuel	 =	11200000	;	int store23_food	 =	0	;	int store23_steel	 =	1170000	;	int store23_alloy	 =	176000	;	int store23_time	 =	266400	;
    int store24_fuel	 =	14600000	;	int store24_food	 =	0	;	int store24_steel	 =	1520000	;	int store24_alloy	 =	228000	;	int store24_time	 =	306000	;
    int store25_fuel	 =	19000000	;	int store25_food	 =	0	;	int store25_steel	 =	1980000	;	int store25_alloy	 =	297000	;	int store25_time	 =	349200	;
    int store26_fuel	 =	24700000	;	int store26_food	 =	0	;	int store26_steel	 =	2570000	;	int store26_alloy	 =	386000	;	int store26_time	 =	403200	;
    int store27_fuel	 =	32100000	;	int store27_food	 =	0	;	int store27_steel	 =	3340000	;	int store27_alloy	 =	502000	;	int store27_time	 =	464400	;
    int store28_fuel	 =	41700000	;	int store28_food	 =	0	;	int store28_steel	 =	4350000	;	int store28_alloy	 =	652000	;	int store28_time	 =	532800	;
    int store29_fuel	 =	54300000	;	int store29_food	 =	0	;	int store29_steel	 =	5650000	;	int store29_alloy	 =	848000	;	int store29_time	 =	612000	;
    int store30_fuel	 =	70500000	;	int store30_food	 =	0	;	int store30_steel	 =	7350000	;	int store30_alloy	 =	1100000	;	int store30_time	 =	705600	;

    //--------------------------------------------------------------------------
    int tb1_fuel	 = 0 , tb1_food = 0 , tb1_steel = 0 , tb1_alloy = 0 , tb1_time = 0 , tb1_glory_mark = 0 , tb1_kyanite = 0 , tb1_kyanite_basic = 0 , tb1_kyanite_cluster = 0;
    int tb2_fuel	 =	2800	;	int tb2_food	 =	2800	;	int tb2_steel	 =	0	;	int tb2_alloy	 =	0	;	int tb2_time	 =	280	;	int tb2_kyanite	 =	0	;	int tb2_kyanite_basic	 =	0	;	int tb2_kyanite_cluster	 =	0	;	int tb2_glory_mark	 =	0	;
    int tb3_fuel	 =	3920	;	int tb3_food	 =	3920	;	int tb3_steel	 =	0	;	int tb3_alloy	 =	0	;	int tb3_time	 =	326	;	int tb3_kyanite	 =	0	;	int tb3_kyanite_basic	 =	0	;	int tb3_kyanite_cluster	 =	0	;	int tb3_glory_mark	 =	0	;
    int tb4_fuel	 =	5880	;	int tb4_food	 =	5880	;	int tb4_steel	 =	0	;	int tb4_alloy	 =	0	;	int tb4_time	 =	428	;	int tb4_kyanite	 =	0	;	int tb4_kyanite_basic	 =	0	;	int tb4_kyanite_cluster	 =	0	;	int tb4_glory_mark	 =	0	;
    int tb5_fuel	 =	9410	;	int tb5_food	 =	9410	;	int tb5_steel	 =	0	;	int tb5_alloy	 =	0	;	int tb5_time	 =	2209	;	int tb5_kyanite	 =	0	;	int tb5_kyanite_basic	 =	0	;	int tb5_kyanite_cluster	 =	0	;	int tb5_glory_mark	 =	0	;
    int tb6_fuel	 =	16900	;	int tb6_food	 =	16900	;	int tb6_steel	 =	0	;	int tb6_alloy	 =	0	;	int tb6_time	 =	4419	;	int tb6_kyanite	 =	0	;	int tb6_kyanite_basic	 =	0	;	int tb6_kyanite_cluster	 =	0	;	int tb6_glory_mark	 =	0	;
    int tb7_fuel	 =	32200	;	int tb7_food	 =	32200	;	int tb7_steel	 =	0	;	int tb7_alloy	 =	0	;	int tb7_time	 =	15070	;	int tb7_kyanite	 =	0	;	int tb7_kyanite_basic	 =	0	;	int tb7_kyanite_cluster	 =	0	;	int tb7_glory_mark	 =	0	;
    int tb8_fuel	 =	64400	;	int tb8_food	 =	64400	;	int tb8_steel	 =	0	;	int tb8_alloy	 =	0	;	int tb8_time	 =	26791	;	int tb8_kyanite	 =	0	;	int tb8_kyanite_basic	 =	0	;	int tb8_kyanite_cluster	 =	0	;	int tb8_glory_mark	 =	0	;
    int tb9_fuel	 =	129000	;	int tb9_food	 =	129000	;	int tb9_steel	 =	0	;	int tb9_alloy	 =	0	;	int tb9_time	 =	45009	;	int tb9_kyanite	 =	0	;	int tb9_kyanite_basic	 =	0	;	int tb9_kyanite_cluster	 =	0	;	int tb9_glory_mark	 =	0	;
    int tb10_fuel	 =	257000	;	int tb10_food	 =	257000	;	int tb10_steel	 =	0	;	int tb10_alloy	 =	0	;	int tb10_time	 =	61200	;	int tb10_kyanite	 =	0	;	int tb10_kyanite_basic	 =	0	;	int tb10_kyanite_cluster	 =	0	;	int tb10_glory_mark	 =	0	;
    int tb11_fuel	 =	400000	;	int tb11_food	 =	400000	;	int tb11_steel	 =	38100	;	int tb11_alloy	 =	0	;	int tb11_time	 =	75600	;	int tb11_kyanite	 =	0	;	int tb11_kyanite_basic	 =	0	;	int tb11_kyanite_cluster	 =	0	;	int tb11_glory_mark	 =	0	;
    int tb12_fuel	 =	801000	;	int tb12_food	 =	801000	;	int tb12_steel	 =	76300	;	int tb12_alloy	 =	0	;	int tb12_time	 =	90000	;	int tb12_kyanite	 =	0	;	int tb12_kyanite_basic	 =	0	;	int tb12_kyanite_cluster	 =	0	;	int tb12_glory_mark	 =	0	;
    int tb13_fuel	 =	1520000	;	int tb13_food	 =	1520000	;	int tb13_steel	 =	145000	;	int tb13_alloy	 =	0	;	int tb13_time	 =	116000	;	int tb13_kyanite	 =	0	;	int tb13_kyanite_basic	 =	0	;	int tb13_kyanite_cluster	 =	0	;	int tb13_glory_mark	 =	0	;
    int tb14_fuel	 =	2740000	;	int tb14_food	 =	2740000	;	int tb14_steel	 =	261000	;	int tb14_alloy	 =	0	;	int tb14_time	 =	140400	;	int tb14_kyanite	 =	0	;	int tb14_kyanite_basic	 =	0	;	int tb14_kyanite_cluster	 =	0	;	int tb14_glory_mark	 =	0	;
    int tb15_fuel	 =	4110000	;	int tb15_food	 =	4110000	;	int tb15_steel	 =	391000	;	int tb15_alloy	 =	0	;	int tb15_time	 =	176400	;	int tb15_kyanite	 =	0	;	int tb15_kyanite_basic	 =	0	;	int tb15_kyanite_cluster	 =	0	;	int tb15_glory_mark	 =	0	;
    int tb16_fuel	 =	5450000	;	int tb16_food	 =	5450000	;	int tb16_steel	 =	519000	;	int tb16_alloy	 =	32400	;	int tb16_time	 =	183600	;	int tb16_kyanite	 =	0	;	int tb16_kyanite_basic	 =	0	;	int tb16_kyanite_cluster	 =	0	;	int tb16_glory_mark	 =	0	;
    int tb17_fuel	 =	7630000	;	int tb17_food	 =	7630000	;	int tb17_steel	 =	726000	;	int tb17_alloy	 =	45400	;	int tb17_time	 =	273600	;	int tb17_kyanite	 =	0	;	int tb17_kyanite_basic	 =	0	;	int tb17_kyanite_cluster	 =	0	;	int tb17_glory_mark	 =	0	;
    int tb18_fuel	 =	9920000	;	int tb18_food	 =	9920000	;	int tb18_steel	 =	944000	;	int tb18_alloy	 =	59000	;	int tb18_time	 =	342000	;	int tb18_kyanite	 =	0	;	int tb18_kyanite_basic	 =	0	;	int tb18_kyanite_cluster	 =	0	;	int tb18_glory_mark	 =	0	;
    int tb19_fuel	 =	12900000	;	int tb19_food	 =	12900000	;	int tb19_steel	 =	1230000	;	int tb19_alloy	 =	76700	;	int tb19_time	 =	428400	;	int tb19_kyanite	 =	0	;	int tb19_kyanite_basic	 =	0	;	int tb19_kyanite_cluster	 =	0	;	int tb19_glory_mark	 =	0	;
    int tb20_fuel	 =	16800000	;	int tb20_food	 =	16800000	;	int tb20_steel	 =	1600000	;	int tb20_alloy	 =	99800	;	int tb20_time	 =	532800	;	int tb20_kyanite	 =	0	;	int tb20_kyanite_basic	 =	0	;	int tb20_kyanite_cluster	 =	0	;	int tb20_glory_mark	 =	0	;
    int tb21_fuel	 =	21800000	;	int tb21_food	 =	21800000	;	int tb21_steel	 =	2070000	;	int tb21_alloy	 =	130000	;	int tb21_time	 =	0	;	int tb21_kyanite	 =	0	;	int tb21_kyanite_basic	 =	0	;	int tb21_kyanite_cluster	 =	0	;	int tb21_glory_mark	 =	0	;
    int tb22_fuel	 =	28300000	;	int tb22_food	 =	28300000	;	int tb22_steel	 =	2700000	;	int tb22_alloy	 =	169000	;	int tb22_time	 =	644369	;	int tb22_kyanite	 =	0	;	int tb22_kyanite_basic	 =	0	;	int tb22_kyanite_cluster	 =	0	;	int tb22_glory_mark	 =	0	;
    int tb23_fuel	 =	36800000	;	int tb23_food	 =	36800000	;	int tb23_steel	 =	3510000	;	int tb23_alloy	 =	219000	;	int tb23_time	 =	882000	;	int tb23_kyanite	 =	0	;	int tb23_kyanite_basic	 =	0	;	int tb23_kyanite_cluster	 =	0	;	int tb23_glory_mark	 =	0	;
    int tb24_fuel	 =	47900000	;	int tb24_food	 =	47900000	;	int tb24_steel	 =	4560000	;	int tb24_alloy	 =	285000	;	int tb24_time	 =	1015200	;	int tb24_kyanite	 =	0	;	int tb24_kyanite_basic	 =	0	;	int tb24_kyanite_cluster	 =	0	;	int tb24_glory_mark	 =	0	;
    int tb25_fuel	 =	62200000	;	int tb25_food	 =	62200000	;	int tb25_steel	 =	5930000	;	int tb25_alloy	 =	370000	;	int tb25_time	 =	1166400	;	int tb25_kyanite	 =	0	;	int tb25_kyanite_basic	 =	0	;	int tb25_kyanite_cluster	 =	0	;	int tb25_glory_mark	 =	0	;
    int tb26_fuel	 =	80900000	;	int tb26_food	 =	80900000	;	int tb26_steel	 =	7700000	;	int tb26_alloy	 =	482000	;	int tb26_time	 =	973043	;	int tb26_kyanite	 =	0	;	int tb26_kyanite_basic	 =	0	;	int tb26_kyanite_cluster	 =	0	;	int tb26_glory_mark	 =	0	;
    int tb27_fuel	 =	105000000	;	int tb27_food	 =	105000000	;	int tb27_steel	 =	10000000	;	int tb27_alloy	 =	626000	;	int tb27_time	 =	1211294	;	int tb27_kyanite	 =	0	;	int tb27_kyanite_basic	 =	0	;	int tb27_kyanite_cluster	 =	0	;	int tb27_glory_mark	 =	0	;
    int tb28_fuel	 =	137000000	;	int tb28_food	 =	137000000	;	int tb28_steel	 =	12610000	;	int tb28_alloy	 =	814000	;	int tb28_time	 =	1728013	;	int tb28_kyanite	 =	0	;	int tb28_kyanite_basic	 =	0	;	int tb28_kyanite_cluster	 =	0	;	int tb28_glory_mark	 =	0	;
    int tb29_fuel	 =	167320000	;	int tb29_food	 =	167320000	;	int tb29_steel	 =	15886000	;	int tb29_alloy	 =	996400	;	int tb29_time	 =	1225945	;	int tb29_kyanite	 =	0	;	int tb29_kyanite_basic	 =	0	;	int tb29_kyanite_cluster	 =	0	;	int tb29_glory_mark	 =	0	;
    int tb30_fuel	 =	231000000	;	int tb30_food	 =	231000000	;	int tb30_steel	 =	22000000	;	int tb30_alloy	 =	1380000	;	int tb30_time	 =	2350800	;	int tb30_kyanite	 =	0	;	int tb30_kyanite_basic	 =	0	;	int tb30_kyanite_cluster	 =	0	;	int tb30_glory_mark	 =	0	;
    int tb31_fuel	 =	210000000	;	int tb31_food	 =	210000000	;	int tb31_steel	 =	15000000	;	int tb31_alloy	 =	1000000	;	int tb31_time	 =	1224116	;	int tb31_kyanite	 =	240000	;	int tb31_kyanite_basic	 =	330000	;	int tb31_kyanite_cluster	 =	27000	;	int tb31_glory_mark	 =	245000	;
    int tb32_fuel	 =	220000000	;	int tb32_food	 =	220000000	;	int tb32_steel	 =	16000000	;	int tb32_alloy	 =	1100000	;	int tb32_time	 =	1369080	;	int tb32_kyanite	 =	260000	;	int tb32_kyanite_basic	 =	350000	;	int tb32_kyanite_cluster	 =	28000	;	int tb32_glory_mark	 =	270000	;
    int tb33_fuel	 =	260000000	;	int tb33_food	 =	260000000	;	int tb33_steel	 =	19000000	;	int tb33_alloy	 =	1300000	;	int tb33_time	 =	1604395 ;	int tb33_kyanite	 =	300000	;	int tb33_kyanite_basic	 =	415000	;	int tb33_kyanite_cluster	 =	35000	;	int tb33_glory_mark	 =	310000	;
    int tb34_fuel	 =	360000000	;	int tb34_food	 =	360000000	;	int tb34_steel	 =	25000000	;	int tb34_alloy	 =	1600000	;	int tb34_time	 =	2130901 ;	int tb34_kyanite	 =	400000	;	int tb34_kyanite_basic	 =	560000	;	int tb34_kyanite_cluster	 =	45000	;	int tb34_glory_mark	 =	755000	;
    int tb35_fuel	 =	625000000	;	int tb35_food	 =	625000000	;	int tb35_steel	 =	45000000	;	int tb35_alloy	 =	2800000	;	int tb35_time	 =	4280779	;	int tb35_kyanite	 =	725000	;	int tb35_kyanite_basic	 =	1005000	;	int tb35_kyanite_cluster	 =	85000	;	int tb35_glory_mark	 =	395000	;

    //--------------------------------------------------------------------------
    int training_house1_fuel	 =	0	;	int training_house1_food	 =	0	;	int training_house1_steel	 =	0	;	int training_house1_alloy	 =	0	;	int training_house1_time	 =	280	;	int training_house1_kyanite	=	0	;	int training_house1_kyanite_basic	=	0	;	int training_house1_kyanite_cluster	=	0	;
    int training_house2_fuel	 =	64400	;	int training_house2_food	 =	64400	;	int training_house2_steel	 =	14500	;	int training_house2_alloy	 =	0	;	int training_house2_time	 =	590	;	int training_house2_kyanite	=	0	;	int training_house2_kyanite_basic	=	0	;	int training_house2_kyanite_cluster	=	0	;
    int training_house3_fuel	 =	129000	;	int training_house3_food	 =	129000	;	int training_house3_steel	 =	20000	;	int training_house3_alloy	 =	0	;	int training_house3_time	 =	885	;	int training_house3_kyanite	=	0	;	int training_house3_kyanite_basic	=	0	;	int training_house3_kyanite_cluster	=	0	;
    int training_house4_fuel	 =	257000	;	int training_house4_food	 =	257000	;	int training_house4_steel	 =	25300	;	int training_house4_alloy	 =	0	;	int training_house4_time	 =	3580	;	int training_house4_kyanite	=	0	;	int training_house4_kyanite_basic	=	0	;	int training_house4_kyanite_cluster	=	0	;
    int training_house5_fuel	 =	400000	;	int training_house5_food	 =	400000	;	int training_house5_steel	 =	38100	;	int training_house5_alloy	 =	0	;	int training_house5_time	 =	3880	;	int training_house5_kyanite	=	0	;	int training_house5_kyanite_basic	=	0	;	int training_house5_kyanite_cluster	=	0	;
    int training_house6_fuel	 =	801000	;	int training_house6_food	 =	801000	;	int training_house6_steel	 =	76300	;	int training_house6_alloy	 =	0	;	int training_house6_time	 =	4180	;	int training_house6_kyanite	=	0	;	int training_house6_kyanite_basic	=	0	;	int training_house6_kyanite_cluster	=	0	;
    int training_house7_fuel	 =	1520000	;	int training_house7_food	 =	1520000	;	int training_house7_steel	 =	145000	;	int training_house7_alloy	 =	0	;	int training_house7_time	 =	5700	;	int training_house7_kyanite	=	0	;	int training_house7_kyanite_basic	=	0	;	int training_house7_kyanite_cluster	=	0	;
    int training_house8_fuel	 =	2740000	;	int training_house8_food	 =	2740000	;	int training_house8_steel	 =	261000	;	int training_house8_alloy	 =	0	;	int training_house8_time	 =	8100	;	int training_house8_kyanite	=	0	;	int training_house8_kyanite_basic	=	0	;	int training_house8_kyanite_cluster	=	0	;
    int training_house9_fuel	 =	4110000	;	int training_house9_food	 =	4110000	;	int training_house9_steel	 =	391000	;	int training_house9_alloy	 =	0	;	int training_house9_time	 =	9600	;	int training_house9_kyanite	=	0	;	int training_house9_kyanite_basic	=	0	;	int training_house9_kyanite_cluster	=	0	;
    int training_house10_fuel	 =	5450000	;	int training_house10_food	 =	5450000	;	int training_house10_steel	 =	519000	;	int training_house10_alloy	 =	32400	;	int training_house10_time	 =	11700	;	int training_house10_kyanite	=	0	;	int training_house10_kyanite_basic	=	0	;	int training_house10_kyanite_cluster	=	0	;
    int training_house11_fuel	 =	0	;	int training_house11_food	 =	0	;	int training_house11_steel	 =	726000	;	int training_house11_alloy	 =	45400	;	int training_house11_time	 =	13800	;	int training_house11_kyanite	=	8000	;	int training_house11_kyanite_basic	=	0	;	int training_house11_kyanite_cluster	=	0	;
    int training_house12_fuel	 =	0	;	int training_house12_food	 =	0	;	int training_house12_steel	 =	944000	;	int training_house12_alloy	 =	59000	;	int training_house12_time	 =	17400	;	int training_house12_kyanite	=	8900	;	int training_house12_kyanite_basic	=	0	;	int training_house12_kyanite_cluster	=	0	;
    int training_house13_fuel	 =	0	;	int training_house13_food	 =	0	;	int training_house13_steel	 =	1230000	;	int training_house13_alloy	 =	76700	;	int training_house13_time	 =	21900	;	int training_house13_kyanite	=	10150	;	int training_house13_kyanite_basic	=	0	;	int training_house13_kyanite_cluster	=	0	;
    int training_house14_fuel	 =	0	;	int training_house14_food	 =	0	;	int training_house14_steel	 =	1600000	;	int training_house14_alloy	 =	99800	;	int training_house14_time	 =	27300	;	int training_house14_kyanite	=	11720	;	int training_house14_kyanite_basic	=	0	;	int training_house14_kyanite_cluster	=	0	;
    int training_house15_fuel	 =	0	;	int training_house15_food	 =	0	;	int training_house15_steel	 =	2070000	;	int training_house15_alloy	 =	130000	;	int training_house15_time	 =	32400	;	int training_house15_kyanite	=	13600	;	int training_house15_kyanite_basic	=	0	;	int training_house15_kyanite_cluster	=	0	;
    int training_house16_fuel	 =	0	;	int training_house16_food	 =	0	;	int training_house16_steel	 =	2700000	;	int training_house16_alloy	 =	169000	;	int training_house16_time	 =	43200	;	int training_house16_kyanite	=	15620	;	int training_house16_kyanite_basic	=	0	;	int training_house16_kyanite_cluster	=	0	;
    int training_house17_fuel	 =	0	;	int training_house17_food	 =	0	;	int training_house17_steel	 =	3510000	;	int training_house17_alloy	 =	219000	;	int training_house17_time	 =	54000	;	int training_house17_kyanite	=	17850	;	int training_house17_kyanite_basic	=	0	;	int training_house17_kyanite_cluster	=	0	;
    int training_house18_fuel	 =	0	;	int training_house18_food	 =	0	;	int training_house18_steel	 =	4560000	;	int training_house18_alloy	 =	285000	;	int training_house18_time	 =	64800	;	int training_house18_kyanite	=	20420	;	int training_house18_kyanite_basic	=	0	;	int training_house18_kyanite_cluster	=	0	;
    int training_house19_fuel	 =	0	;	int training_house19_food	 =	0	;	int training_house19_steel	 =	5930000	;	int training_house19_alloy	 =	370000	;	int training_house19_time	 =	82800	;	int training_house19_kyanite	=	23300	;	int training_house19_kyanite_basic	=	0	;	int training_house19_kyanite_cluster	=	0	;
    int training_house20_fuel	 =	0	;	int training_house20_food	 =	0	;	int training_house20_steel	 =	7700000	;	int training_house20_alloy	 =	482000	;	int training_house20_time	 =	104400	;	int training_house20_kyanite	=	26600	;	int training_house20_kyanite_basic	=	0	;	int training_house20_kyanite_cluster	=	0	;
    int training_house21_fuel	 =	0	;	int training_house21_food	 =	0	;	int training_house21_steel	 =	0	;	int training_house21_alloy	 =	0	;	int training_house21_time	 =	118800	;	int training_house21_kyanite	=	30230	;	int training_house21_kyanite_basic	=	4120	;	int training_house21_kyanite_cluster	=	0	;
    int training_house22_fuel	 =	0	;	int training_house22_food	 =	0	;	int training_house22_steel	 =	0	;	int training_house22_alloy	 =	0	;	int training_house22_time	 =	136800	;	int training_house22_kyanite	=	34223	;	int training_house22_kyanite_basic	=	5320	;	int training_house22_kyanite_cluster	=	0	;
    int training_house23_fuel	 =	0	;	int training_house23_food	 =	0	;	int training_house23_steel	 =	0	;	int training_house23_alloy	 =	0	;	int training_house23_time	 =	158400	;	int training_house23_kyanite	=	38615	;	int training_house23_kyanite_basic	=	6640	;	int training_house23_kyanite_cluster	=	0	;
    int training_house24_fuel	 =	0	;	int training_house24_food	 =	0	;	int training_house24_steel	 =	0	;	int training_house24_alloy	 =	0	;	int training_house24_time	 =	180000	;	int training_house24_kyanite	=	43446	;	int training_house24_kyanite_basic	=	8092	;	int training_house24_kyanite_cluster	=	0	;
    int training_house25_fuel	 =	0	;	int training_house25_food	 =	0	;	int training_house25_steel	 =	0	;	int training_house25_alloy	 =	0	;	int training_house25_time	 =	208800	;	int training_house25_kyanite	=	48760	;	int training_house25_kyanite_basic	=	9617	;	int training_house25_kyanite_cluster	=	3200	;
    int training_house26_fuel	 =	0	;	int training_house26_food	 =	0	;	int training_house26_steel	 =	0	;	int training_house26_alloy	 =	0	;	int training_house26_time	 =	241200	;	int training_house26_kyanite	=	54605	;	int training_house26_kyanite_basic	=	11218	;	int training_house26_kyanite_cluster	=	5500	;
    int training_house27_fuel	 =	0	;	int training_house27_food	 =	0	;	int training_house27_steel	 =	0	;	int training_house27_alloy	 =	0	;	int training_house27_time	 =	277200	;	int training_house27_kyanite	=	61035	;	int training_house27_kyanite_basic	=	12899	;	int training_house27_kyanite_cluster	=	8300	;
    int training_house28_fuel	 =	0	;	int training_house28_food	 =	0	;	int training_house28_steel	 =	0	;	int training_house28_alloy	 =	0	;	int training_house28_time	 =	316800	;	int training_house28_kyanite	=	68108	;	int training_house28_kyanite_basic	=	14664	;	int training_house28_kyanite_cluster	=	10300	;
    int training_house29_fuel	 =	0	;	int training_house29_food	 =	0	;	int training_house29_steel	 =	0	;	int training_house29_alloy	 =	0	;	int training_house29_time	 =	363600	;	int training_house29_kyanite	=	75888	;	int training_house29_kyanite_basic	=	16517	;	int training_house29_kyanite_cluster	=	11600	;
    int training_house30_fuel	 =	0	;	int training_house30_food	 =	0	;	int training_house30_steel	 =	0	;	int training_house30_alloy	 =	0	;	int training_house30_time	 =	420000	;	int training_house30_kyanite	=	84446	;	int training_house30_kyanite_basic	=	18463	;	int training_house30_kyanite_cluster	=	13800	;

    //--------------------------------------------------------------------------
    int wall1_fuel	 =	1440	;	int wall1_food	 =	0	;	int wall1_steel	 =	0	;	int wall1_alloy	 =	0	;	int wall1_time	 =	128	;	int wall1_glory_mark	=	0	;	int wall1_kyanite	=	0	;	int wall1_kyanite_basic	=	0	;	int wall1_kyanite_cluster	=	0	;
    int wall2_fuel	 =	2020	;	int wall2_food	 =	0	;	int wall2_steel	 =	0	;	int wall2_alloy	 =	0	;	int wall2_time	 =	326	;	int wall2_glory_mark	=	0	;	int wall2_kyanite	=	0	;	int wall2_kyanite_basic	=	0	;	int wall2_kyanite_cluster	=	0	;
    int wall3_fuel	 =	2820	;	int wall3_food	 =	0	;	int wall3_steel	 =	0	;	int wall3_alloy	 =	0	;	int wall3_time	 =	428	;	int wall3_glory_mark	=	0	;	int wall3_kyanite	=	0	;	int wall3_kyanite_basic	=	0	;	int wall3_kyanite_cluster	=	0	;
    int wall4_fuel	 =	4230	;	int wall4_food	 =	0	;	int wall4_steel	 =	0	;	int wall4_alloy	 =	0	;	int wall4_time	 =	721	;	int wall4_glory_mark	=	0	;	int wall4_kyanite	=	0	;	int wall4_kyanite_basic	=	0	;	int wall4_kyanite_cluster	=	0	;
    int wall5_fuel	 =	6770	;	int wall5_food	 =	0	;	int wall5_steel	 =	0	;	int wall5_alloy	 =	0	;	int wall5_time	 =	1395	;	int wall5_glory_mark	=	0	;	int wall5_kyanite	=	0	;	int wall5_kyanite_basic	=	0	;	int wall5_kyanite_cluster	=	0	;
    int wall6_fuel	 =	12200	;	int wall6_food	 =	0	;	int wall6_steel	 =	0	;	int wall6_alloy	 =	0	;	int wall6_time	 =	4186	;	int wall6_glory_mark	=	0	;	int wall6_kyanite	=	0	;	int wall6_kyanite_basic	=	0	;	int wall6_kyanite_cluster	=	0	;
    int wall7_fuel	 =	23200	;	int wall7_food	 =	0	;	int wall7_steel	 =	0	;	int wall7_alloy	 =	0	;	int wall7_time	 =	18000	;	int wall7_glory_mark	=	0	;	int wall7_kyanite	=	0	;	int wall7_kyanite_basic	=	0	;	int wall7_kyanite_cluster	=	0	;
    int wall8_fuel	 =	46300	;	int wall8_food	 =	0	;	int wall8_steel	 =	0	;	int wall8_alloy	 =	0	;	int wall8_time	 =	25200	;	int wall8_glory_mark	=	0	;	int wall8_kyanite	=	0	;	int wall8_kyanite_basic	=	0	;	int wall8_kyanite_cluster	=	0	;
    int wall9_fuel	 =	92700	;	int wall9_food	 =	0	;	int wall9_steel	 =	0	;	int wall9_alloy	 =	0	;	int wall9_time	 =	30300	;	int wall9_glory_mark	=	0	;	int wall9_kyanite	=	0	;	int wall9_kyanite_basic	=	0	;	int wall9_kyanite_cluster	=	0	;
    int wall10_fuel	 =	185000	;	int wall10_food	 =	0	;	int wall10_steel	 =	0	;	int wall10_alloy	 =	0	;	int wall10_time	 =	36000	;	int wall10_glory_mark	=	0	;	int wall10_kyanite	=	0	;	int wall10_kyanite_basic	=	0	;	int wall10_kyanite_cluster	=	0	;
    int wall11_fuel	 =	371000	;	int wall11_food	 =	0	;	int wall11_steel	 =	11600	;	int wall11_alloy	 =	0	;	int wall11_time	 =	43200	;	int wall11_glory_mark	=	0	;	int wall11_kyanite	=	0	;	int wall11_kyanite_basic	=	0	;	int wall11_kyanite_cluster	=	0	;
    int wall12_fuel	 =	741000	;	int wall12_food	 =	0	;	int wall12_steel	 =	23200	;	int wall12_alloy	 =	0	;	int wall12_time	 =	54000	;	int wall12_glory_mark	=	0	;	int wall12_kyanite	=	0	;	int wall12_kyanite_basic	=	0	;	int wall12_kyanite_cluster	=	0	;
    int wall13_fuel	 =	1410000	;	int wall13_food	 =	0	;	int wall13_steel	 =	44000	;	int wall13_alloy	 =	0	;	int wall13_time	 =	68400	;	int wall13_glory_mark	=	0	;	int wall13_kyanite	=	0	;	int wall13_kyanite_basic	=	0	;	int wall13_kyanite_cluster	=	0	;
    int wall14_fuel	 =	2540000	;	int wall14_food	 =	0	;	int wall14_steel	 =	79200	;	int wall14_alloy	 =	0	;	int wall14_time	 =	86400	;	int wall14_glory_mark	=	0	;	int wall14_kyanite	=	0	;	int wall14_kyanite_basic	=	0	;	int wall14_kyanite_cluster	=	0	;
    int wall15_fuel	 =	3800000	;	int wall15_food	 =	0	;	int wall15_steel	 =	119000	;	int wall15_alloy	 =	0	;	int wall15_time	 =	108000	;	int wall15_glory_mark	=	0	;	int wall15_kyanite	=	0	;	int wall15_kyanite_basic	=	0	;	int wall15_kyanite_cluster	=	0	;
    int wall16_fuel	 =	5320000	;	int wall16_food	 =	0	;	int wall16_steel	 =	166000	;	int wall16_alloy	 =	13900	;	int wall16_time	 =	133200	;	int wall16_glory_mark	=	0	;	int wall16_kyanite	=	0	;	int wall16_kyanite_basic	=	0	;	int wall16_kyanite_cluster	=	0	;
    int wall17_fuel	 =	7450000	;	int wall17_food	 =	0	;	int wall17_steel	 =	233000	;	int wall17_alloy	 =	19400	;	int wall17_time	 =	165600	;	int wall17_glory_mark	=	0	;	int wall17_kyanite	=	0	;	int wall17_kyanite_basic	=	0	;	int wall17_kyanite_cluster	=	0	;
    int wall18_fuel	 =	9690000	;	int wall18_food	 =	0	;	int wall18_steel	 =	303000	;	int wall18_alloy	 =	25200	;	int wall18_time	 =	208800	;	int wall18_glory_mark	=	0	;	int wall18_kyanite	=	0	;	int wall18_kyanite_basic	=	0	;	int wall18_kyanite_cluster	=	0	;
    int wall19_fuel	 =	12600000	;	int wall19_food	 =	0	;	int wall19_steel	 =	394000	;	int wall19_alloy	 =	32800	;	int wall19_time	 =	259200	;	int wall19_glory_mark	=	0	;	int wall19_kyanite	=	0	;	int wall19_kyanite_basic	=	0	;	int wall19_kyanite_cluster	=	0	;
    int wall20_fuel	 =	16400000	;	int wall20_food	 =	0	;	int wall20_steel	 =	512000	;	int wall20_alloy	 =	42600	;	int wall20_time	 =	324000	;	int wall20_glory_mark	=	0	;	int wall20_kyanite	=	0	;	int wall20_kyanite_basic	=	0	;	int wall20_kyanite_cluster	=	0	;
    int wall21_fuel	 =	21300000	;	int wall21_food	 =	0	;	int wall21_steel	 =	665000	;	int wall21_alloy	 =	55400	;	int wall21_time	 =	374400	;	int wall21_glory_mark	=	0	;	int wall21_kyanite	=	0	;	int wall21_kyanite_basic	=	0	;	int wall21_kyanite_cluster	=	0	;
    int wall22_fuel	 =	27700000	;	int wall22_food	 =	0	;	int wall22_steel	 =	865000	;	int wall22_alloy	 =	72100	;	int wall22_time	 =	432000	;	int wall22_glory_mark	=	0	;	int wall22_kyanite	=	0	;	int wall22_kyanite_basic	=	0	;	int wall22_kyanite_cluster	=	0	;
    int wall23_fuel	 =	36000000	;	int wall23_food	 =	0	;	int wall23_steel	 =	1120000	;	int wall23_alloy	 =	93700	;	int wall23_time	 =	496800	;	int wall23_glory_mark	=	0	;	int wall23_kyanite	=	0	;	int wall23_kyanite_basic	=	0	;	int wall23_kyanite_cluster	=	0	;
    int wall24_fuel	 =	46800000	;	int wall24_food	 =	0	;	int wall24_steel	 =	1460000	;	int wall24_alloy	 =	122000	;	int wall24_time	 =	568800	;	int wall24_glory_mark	=	0	;	int wall24_kyanite	=	0	;	int wall24_kyanite_basic	=	0	;	int wall24_kyanite_cluster	=	0	;
    int wall25_fuel	 =	60800000	;	int wall25_food	 =	0	;	int wall25_steel	 =	1900000	;	int wall25_alloy	 =	158000	;	int wall25_time	 =	655200	;	int wall25_glory_mark	=	0	;	int wall25_kyanite	=	0	;	int wall25_kyanite_basic	=	0	;	int wall25_kyanite_cluster	=	0	;
    int wall26_fuel	 =	79000000	;	int wall26_food	 =	0	;	int wall26_steel	 =	2470000	;	int wall26_alloy	 =	206000	;	int wall26_time	 =	752400	;	int wall26_glory_mark	=	0	;	int wall26_kyanite	=	0	;	int wall26_kyanite_basic	=	0	;	int wall26_kyanite_cluster	=	0	;
    int wall27_fuel	 =	103000000	;	int wall27_food	 =	0	;	int wall27_steel	 =	3210000	;	int wall27_alloy	 =	268000	;	int wall27_time	 =	867600	;	int wall27_glory_mark	=	0	;	int wall27_kyanite	=	0	;	int wall27_kyanite_basic	=	0	;	int wall27_kyanite_cluster	=	0	;
    int wall28_fuel	 =	134000000	;	int wall28_food	 =	0	;	int wall28_steel	 =	4170000	;	int wall28_alloy	 =	348000	;	int wall28_time	 =	997200	;	int wall28_glory_mark	=	0	;	int wall28_kyanite	=	0	;	int wall28_kyanite_basic	=	0	;	int wall28_kyanite_cluster	=	0	;
    int wall29_fuel	 =	174000000	;	int wall29_food	 =	0	;	int wall29_steel	 =	5430000	;	int wall29_alloy	 =	452000	;	int wall29_time	 =	1144800	;	int wall29_glory_mark	=	0	;	int wall29_kyanite	=	0	;	int wall29_kyanite_basic	=	0	;	int wall29_kyanite_cluster	=	0	;
    int wall30_fuel	 =	226000000	;	int wall30_food	 =	0	;	int wall30_steel	 =	7050000	;	int wall30_alloy	 =	588000	;	int wall30_time	 =	1317000	;	int wall30_glory_mark	=	0	;	int wall30_kyanite	=	0	;	int wall30_kyanite_basic	=	0	;	int wall30_kyanite_cluster	=	0	;
    int wall31_fuel	 =	145066194	;	int wall31_food	 =	151561698	;	int wall31_steel	 =	10825836	;	int wall31_alloy	 =	679075	;	int wall31_time	 =	856882	;	int wall31_glory_mark	=	171318	;	int wall31_kyanite	=	196834	;	int wall31_kyanite_basic	=	273380	;	int wall31_kyanite_cluster	=	21871	;
    int wall32_fuel	 =	162245550	;	int wall32_food	 =	169510277	;	int wall32_steel	 =	12107876	;	int wall32_alloy	 =	759494	;	int wall32_time	 =	958356	;	int wall32_glory_mark	=	191607	;	int wall32_kyanite	=	220143	;	int wall32_kyanite_basic	=	305754	;	int wall32_kyanite_cluster	=	24460	;
    int wall33_fuel	 =	190132091	;	int wall33_food	 =	198645471	;	int wall33_steel	 =	14188964	;	int wall33_alloy	 =	890035	;	int wall33_time	 =	1123076	;	int wall33_glory_mark	=	224540	;	int wall33_kyanite	=	257981	;	int wall33_kyanite_basic	=	358306	;	int wall33_kyanite_cluster	=	28666	;
    int wall34_fuel	 =	252526556	;	int wall34_food	 =	263833717	;	int wall34_steel	 =	18845266	;	int wall34_alloy	 =	1182113	;	int wall34_time	 =	1491630	;	int wall34_glory_mark	=	298226	;	int wall34_kyanite	=	342642	;	int wall34_kyanite_basic	=	475890	;	int wall34_kyanite_cluster	=	38072	;
    int wall35_fuel	 =	486823728	;	int wall35_food	 =	508621805	;	int wall35_steel	 =	36330130	;	int wall35_alloy	 =	2278889	;	int wall35_time	 =	2875586	;	int wall35_glory_mark	=	574922	;	int wall35_kyanite	=	660549	;	int wall35_kyanite_basic	=	917427	;	int wall35_kyanite_cluster	=	73394	;

    //--------------------------------------------------------------------------
    int tower1_fuel	 =	158	;	int tower1_food	 =	0	;	int tower1_steel	 =	0	;	int tower1_alloy	 =	0	;	int tower1_time	 =	192	;	int tower1_barrel	=	0	;
    int tower2_fuel	 =	221	;	int tower2_food	 =	0	;	int tower2_steel	 =	0	;	int tower2_alloy	 =	0	;	int tower2_time	 =	326	;	int tower2_barrel	=	1	;
    int tower3_fuel	 =	309	;	int tower3_food	 =	0	;	int tower3_steel	 =	0	;	int tower3_alloy	 =	0	;	int tower3_time	 =	428	;	int tower3_barrel	=	2	;
    int tower4_fuel	 =	463	;	int tower4_food	 =	0	;	int tower4_steel	 =	0	;	int tower4_alloy	 =	0	;	int tower4_time	 =	581	;	int tower4_barrel	=	7	;
    int tower5_fuel	 =	741	;	int tower5_food	 =	0	;	int tower5_steel	 =	0	;	int tower5_alloy	 =	0	;	int tower5_time	 =	1163	;	int tower5_barrel	=	16	;
    int tower6_fuel	 =	1330	;	int tower6_food	 =	0	;	int tower6_steel	 =	0	;	int tower6_alloy	 =	0	;	int tower6_time	 =	2930	;	int tower6_barrel	=	29	;
    int tower7_fuel	 =	2530	;	int tower7_food	 =	0	;	int tower7_steel	 =	0	;	int tower7_alloy	 =	0	;	int tower7_time	 =	4180	;	int tower7_barrel	=	46	;
    int tower8_fuel	 =	5070	;	int tower8_food	 =	0	;	int tower8_steel	 =	0	;	int tower8_alloy	 =	0	;	int tower8_time	 =	5400	;	int tower8_barrel	=	67	;
    int tower9_fuel	 =	10100	;	int tower9_food	 =	0	;	int tower9_steel	 =	0	;	int tower9_alloy	 =	0	;	int tower9_time	 =	6300	;	int tower9_barrel	=	92	;
    int tower10_fuel	 =	20300	;	int tower10_food	 =	0	;	int tower10_steel	 =	0	;	int tower10_alloy	 =	0	;	int tower10_time	 =	7500	;	int tower10_barrel	=	121	;
    int tower11_fuel	 =	40500	;	int tower11_food	 =	0	;	int tower11_steel	 =	4220	;	int tower11_alloy	 =	0	;	int tower11_time	 =	9000	;	int tower11_barrel	=	155	;
    int tower12_fuel	 =	81100	;	int tower12_food	 =	0	;	int tower12_steel	 =	8450	;	int tower12_alloy	 =	0	;	int tower12_time	 =	11400	;	int tower12_barrel	=	194	;
    int tower13_fuel	 =	154000	;	int tower13_food	 =	0	;	int tower13_steel	 =	16000	;	int tower13_alloy	 =	0	;	int tower13_time	 =	14100	;	int tower13_barrel	=	238	;
    int tower14_fuel	 =	277000	;	int tower14_food	 =	0	;	int tower14_steel	 =	28900	;	int tower14_alloy	 =	0	;	int tower14_time	 =	17700	;	int tower14_barrel	=	287	;
    int tower15_fuel	 =	416000	;	int tower15_food	 =	0	;	int tower15_steel	 =	43300	;	int tower15_alloy	 =	0	;	int tower15_time	 =	22200	;	int tower15_barrel	=	341	;
    int tower16_fuel	 =	582000	;	int tower16_food	 =	0	;	int tower16_steel	 =	60700	;	int tower16_alloy	 =	9100	;	int tower16_time	 =	27900	;	int tower16_barrel	=	400	;
    int tower17_fuel	 =	815000	;	int tower17_food	 =	0	;	int tower17_steel	 =	84900	;	int tower17_alloy	 =	12700	;	int tower17_time	 =	36000	;	int tower17_barrel	=	464	;
    int tower18_fuel	 =	1060000	;	int tower18_food	 =	0	;	int tower18_steel	 =	110000	;	int tower18_alloy	 =	16600	;	int tower18_time	 =	43200	;	int tower18_barrel	=	533	;
    int tower19_fuel	 =	1380000	;	int tower19_food	 =	0	;	int tower19_steel	 =	144000	;	int tower19_alloy	 =	21500	;	int tower19_time	 =	54000	;	int tower19_barrel	=	607	;
    int tower20_fuel	 =	1790000	;	int tower20_food	 =	0	;	int tower20_steel	 =	187000	;	int tower20_alloy	 =	28000	;	int tower20_time	 =	68400	;	int tower20_barrel	=	686	;
    int tower21_fuel	 =	2330000	;	int tower21_food	 =	0	;	int tower21_steel	 =	243000	;	int tower21_alloy	 =	36400	;	int tower21_time	 =	79200	;	int tower21_barrel	=	771	;
    int tower22_fuel	 =	3030000	;	int tower22_food	 =	0	;	int tower22_steel	 =	315000	;	int tower22_alloy	 =	47300	;	int tower22_time	 =	90000	;	int tower22_barrel	=	862	;
    int tower23_fuel	 =	3940000	;	int tower23_food	 =	0	;	int tower23_steel	 =	410000	;	int tower23_alloy	 =	61500	;	int tower23_time	 =	104400	;	int tower23_barrel	=	959	;
    int tower24_fuel	 =	5120000	;	int tower24_food	 =	0	;	int tower24_steel	 =	533000	;	int tower24_alloy	 =	79900	;	int tower24_time	 =	118800	;	int tower24_barrel	=	1062	;
    int tower25_fuel	 =	6650000	;	int tower25_food	 =	0	;	int tower25_steel	 =	693000	;	int tower25_alloy	 =	104000	;	int tower25_time	 =	136800	;	int tower25_barrel	=	1171	;
    int tower26_fuel	 =	8650000	;	int tower26_food	 =	0	;	int tower26_steel	 =	901000	;	int tower26_alloy	 =	135000	;	int tower26_time	 =	158400	;	int tower26_barrel	=	1286	;
    int tower27_fuel	 =	11200000	;	int tower27_food	 =	0	;	int tower27_steel	 =	1170000	;	int tower27_alloy	 =	176000	;	int tower27_time	 =	180000	;	int tower27_barrel	=	1407	;
    int tower28_fuel	 =	14600000	;	int tower28_food	 =	0	;	int tower28_steel	 =	1520000	;	int tower28_alloy	 =	228000	;	int tower28_time	 =	208800	;	int tower28_barrel	=	1534	;
    int tower29_fuel	 =	19000000	;	int tower29_food	 =	0	;	int tower29_steel	 =	1980000	;	int tower29_alloy	 =	297000	;	int tower29_time	 =	237600	;	int tower29_barrel	=	1667	;
    int tower30_fuel	 =	24700000	;	int tower30_food	 =	0	;	int tower30_steel	 =	2570000	;	int tower30_alloy	 =	386000	;	int tower30_time	 =	274500	;	int tower30_barrel	=	1806	;

    //--------------------------------------------------------------------------
    int factory1_fuel	 =	341	;	int factory1_food	 =	0	;	int factory1_steel	 =	0	;	int factory1_alloy	 =	0	;	int factory1_time	 =	2	;
    int factory2_fuel	 =	477	;	int factory2_food	 =	0	;	int factory2_steel	 =	0	;	int factory2_alloy	 =	0	;	int factory2_time	 =	326	;
    int factory3_fuel	 =	668	;	int factory3_food	 =	0	;	int factory3_steel	 =	0	;	int factory3_alloy	 =	0	;	int factory3_time	 =	428	;
    int factory4_fuel	 =	1000	;	int factory4_food	 =	0	;	int factory4_steel	 =	0	;	int factory4_alloy	 =	0	;	int factory4_time	 =	721	;
    int factory5_fuel	 =	1600	;	int factory5_food	 =	0	;	int factory5_steel	 =	0	;	int factory5_alloy	 =	0	;	int factory5_time	 =	1163	;
    int factory6_fuel	 =	2880	;	int factory6_food	 =	0	;	int factory6_steel	 =	0	;	int factory6_alloy	 =	0	;	int factory6_time	 =	2930	;
    int factory7_fuel	 =	5480	;	int factory7_food	 =	0	;	int factory7_steel	 =	0	;	int factory7_alloy	 =	0	;	int factory7_time	 =	7200	;
    int factory8_fuel	 =	11000	;	int factory8_food	 =	0	;	int factory8_steel	 =	0	;	int factory8_alloy	 =	0	;	int factory8_time	 =	12000	;
    int factory9_fuel	 =	21900	;	int factory9_food	 =	0	;	int factory9_steel	 =	0	;	int factory9_alloy	 =	0	;	int factory9_time	 =	14400	;
    int factory10_fuel	 =	43900	;	int factory10_food	 =	0	;	int factory10_steel	 =	0	;	int factory10_alloy	 =	0	;	int factory10_time	 =	17400	;
    int factory11_fuel	 =	87700	;	int factory11_food	 =	0	;	int factory11_steel	 =	12200	;	int factory11_alloy	 =	0	;	int factory11_time	 =	21000	;
    int factory12_fuel	 =	175000	;	int factory12_food	 =	0	;	int factory12_steel	 =	24400	;	int factory12_alloy	 =	0	;	int factory12_time	 =	26100	;
    int factory13_fuel	 =	333000	;	int factory13_food	 =	0	;	int factory13_steel	 =	46300	;	int factory13_alloy	 =	0	;	int factory13_time	 =	32400	;
    int factory14_fuel	 =	600000	;	int factory14_food	 =	0	;	int factory14_steel	 =	83300	;	int factory14_alloy	 =	0	;	int factory14_time	 =	39600	;
    int factory15_fuel	 =	900000	;	int factory15_food	 =	0	;	int factory15_steel	 =	125000	;	int factory15_alloy	 =	0	;	int factory15_time	 =	50400	;
    int factory16_fuel	 =	1260000	;	int factory16_food	 =	0	;	int factory16_steel	 =	175000	;	int factory16_alloy	 =	26200	;	int factory16_time	 =	64800	;
    int factory17_fuel	 =	1760000	;	int factory17_food	 =	0	;	int factory17_steel	 =	245000	;	int factory17_alloy	 =	36700	;	int factory17_time	 =	79200	;
    int factory18_fuel	 =	2290000	;	int factory18_food	 =	0	;	int factory18_steel	 =	318000	;	int factory18_alloy	 =	47800	;	int factory18_time	 =	100800	;
    int factory19_fuel	 =	2980000	;	int factory19_food	 =	0	;	int factory19_steel	 =	414000	;	int factory19_alloy	 =	62100	;	int factory19_time	 =	126000	;
    int factory20_fuel	 =	3870000	;	int factory20_food	 =	0	;	int factory20_steel	 =	538000	;	int factory20_alloy	 =	80700	;	int factory20_time	 =	154800	;
    int factory21_fuel	 =	5040000	;	int factory21_food	 =	0	;	int factory21_steel	 =	700000	;	int factory21_alloy	 =	105000	;	int factory21_time	 =	180000	;
    int factory22_fuel	 =	6550000	;	int factory22_food	 =	0	;	int factory22_steel	 =	909000	;	int factory22_alloy	 =	136000	;	int factory22_time	 =	205200	;
    int factory23_fuel	 =	8510000	;	int factory23_food	 =	0	;	int factory23_steel	 =	1180000	;	int factory23_alloy	 =	177000	;	int factory23_time	 =	237600	;
    int factory24_fuel	 =	11100000	;	int factory24_food	 =	0	;	int factory24_steel	 =	1540000	;	int factory24_alloy	 =	231000	;	int factory24_time	 =	273600	;
    int factory25_fuel	 =	14400000	;	int factory25_food	 =	0	;	int factory25_steel	 =	2000000	;	int factory25_alloy	 =	300000	;	int factory25_time	 =	313200	;
    int factory26_fuel	 =	18700000	;	int factory26_food	 =	0	;	int factory26_steel	 =	2600000	;	int factory26_alloy	 =	390000	;	int factory26_time	 =	360000	;
    int factory27_fuel	 =	24300000	;	int factory27_food	 =	0	;	int factory27_steel	 =	3380000	;	int factory27_alloy	 =	507000	;	int factory27_time	 =	414000	;
    int factory28_fuel	 =	31600000	;	int factory28_food	 =	0	;	int factory28_steel	 =	4390000	;	int factory28_alloy	 =	658000	;	int factory28_time	 =	478800	;
    int factory29_fuel	 =	41100000	;	int factory29_food	 =	0	;	int factory29_steel	 =	5710000	;	int factory29_alloy	 =	856000	;	int factory29_time	 =	547200	;
    int factory30_fuel	 =	53400000	;	int factory30_food	 =	0	;	int factory30_steel	 =	7420000	;	int factory30_alloy	 =	1110000	;	int factory30_time	 =	631200	;

    //--------------------------------------------------------------------------
    int z11_1_fuel	 =	715	;	int z11_1_food	 =	0	;	int z11_1_steel	 =	0	;	int z11_1_alloy	 =	0	;	int z11_1_time	 =	585	;
    int z11_2_fuel	 =	1000	;	int z11_2_food	 =	0	;	int z11_2_steel	 =	0	;	int z11_2_alloy	 =	0	;	int z11_2_time	 =	326	;
    int z11_3_fuel	 =	1400	;	int z11_3_food	 =	0	;	int z11_3_steel	 =	0	;	int z11_3_alloy	 =	0	;	int z11_3_time	 =	428	;
    int z11_4_fuel	 =	2100	;	int z11_4_food	 =	0	;	int z11_4_steel	 =	0	;	int z11_4_alloy	 =	0	;	int z11_4_time	 =	721	;
    int z11_5_fuel	 =	3360	;	int z11_5_food	 =	0	;	int z11_5_steel	 =	0	;	int z11_5_alloy	 =	0	;	int z11_5_time	 =	1163	;
    int z11_6_fuel	 =	6050	;	int z11_6_food	 =	0	;	int z11_6_steel	 =	0	;	int z11_6_alloy	 =	0	;	int z11_6_time	 =	2930	;
    int z11_7_fuel	 =	11500	;	int z11_7_food	 =	0	;	int z11_7_steel	 =	0	;	int z11_7_alloy	 =	0	;	int z11_7_time	 =	6600	;
    int z11_8_fuel	 =	23000	;	int z11_8_food	 =	0	;	int z11_8_steel	 =	0	;	int z11_8_alloy	 =	0	;	int z11_8_time	 =	10800	;
    int z11_9_fuel	 =	46000	;	int z11_9_food	 =	0	;	int z11_9_steel	 =	0	;	int z11_9_alloy	 =	0	;	int z11_9_time	 =	13200	;
    int z11_10_fuel	 =	92000	;	int z11_10_food	 =	0	;	int z11_10_steel	 =	0	;	int z11_10_alloy	 =	0	;	int z11_10_time	 =	15900	;
    int z11_11_fuel	 =	100000	;	int z11_11_food	 =	0	;	int z11_11_steel	 =	13900	;	int z11_11_alloy	 =	0	;	int z11_11_time	 =	18900	;
    int z11_12_fuel	 =	201000	;	int z11_12_food	 =	0	;	int z11_12_steel	 =	27900	;	int z11_12_alloy	 =	0	;	int z11_12_time	 =	23700	;
    int z11_13_fuel	 =	381000	;	int z11_13_food	 =	0	;	int z11_13_steel	 =	53000	;	int z11_13_alloy	 =	0	;	int z11_13_time	 =	28800	;
    int z11_14_fuel	 =	687000	;	int z11_14_food	 =	0	;	int z11_14_steel	 =	95400	;	int z11_14_alloy	 =	0	;	int z11_14_time	 =	36000	;
    int z11_15_fuel	 =	1030000	;	int z11_15_food	 =	0	;	int z11_15_steel	 =	143000	;	int z11_15_alloy	 =	0	;	int z11_15_time	 =	46800	;
    int z11_16_fuel	 =	1130000	;	int z11_16_food	 =	0	;	int z11_16_steel	 =	157000	;	int z11_16_alloy	 =	23600	;	int z11_16_time	 =	57600	;
    int z11_17_fuel	 =	1590000	;	int z11_17_food	 =	0	;	int z11_17_steel	 =	220000	;	int z11_17_alloy	 =	33000	;	int z11_17_time	 =	72000	;
    int z11_18_fuel	 =	2060000	;	int z11_18_food	 =	0	;	int z11_18_steel	 =	286000	;	int z11_18_alloy	 =	43000	;	int z11_18_time	 =	90000	;
    int z11_19_fuel	 =	2680000	;	int z11_19_food	 =	0	;	int z11_19_steel	 =	372000	;	int z11_19_alloy	 =	55800	;	int z11_19_time	 =	115200	;
    int z11_20_fuel	 =	3480000	;	int z11_20_food	 =	0	;	int z11_20_steel	 =	484000	;	int z11_20_alloy	 =	72600	;	int z11_20_time	 =	140400	;
    int z11_21_fuel	 =	4530000	;	int z11_21_food	 =	0	;	int z11_21_steel	 =	629000	;	int z11_21_alloy	 =	94400	;	int z11_21_time	 =	162000	;
    int z11_22_fuel	 =	5890000	;	int z11_22_food	 =	0	;	int z11_22_steel	 =	818000	;	int z11_22_alloy	 =	123000	;	int z11_22_time	 =	187200	;
    int z11_23_fuel	 =	7660000	;	int z11_23_food	 =	0	;	int z11_23_steel	 =	1060000	;	int z11_23_alloy	 =	160000	;	int z11_23_time	 =	216000	;
    int z11_24_fuel	 =	9950000	;	int z11_24_food	 =	0	;	int z11_24_steel	 =	1380000	;	int z11_24_alloy	 =	207000	;	int z11_24_time	 =	248400	;
    int z11_25_fuel	 =	12900000	;	int z11_25_food	 =	0	;	int z11_25_steel	 =	1800000	;	int z11_25_alloy	 =	270000	;	int z11_25_time	 =	284400	;
    int z11_26_fuel	 =	16800000	;	int z11_26_food	 =	0	;	int z11_26_steel	 =	2340000	;	int z11_26_alloy	 =	350000	;	int z11_26_time	 =	327600	;
    int z11_27_fuel	 =	21900000	;	int z11_27_food	 =	0	;	int z11_27_steel	 =	3040000	;	int z11_27_alloy	 =	456000	;	int z11_27_time	 =	378000	;
    int z11_28_fuel	 =	28400000	;	int z11_28_food	 =	0	;	int z11_28_steel	 =	3950000	;	int z11_28_alloy	 =	592000	;	int z11_28_time	 =	432000	;
    int z11_29_fuel	 =	37000000	;	int z11_29_food	 =	0	;	int z11_29_steel	 =	5130000	;	int z11_29_alloy	 =	770000	;	int z11_29_time	 =	500400	;
    int z11_30_fuel	 =	48000000	;	int z11_30_food	 =	0	;	int z11_30_steel	 =	6670000	;	int z11_30_alloy	 =	1000000	;	int z11_30_time	 =	573600	;

    //--------------------------------------------------------------------------
    int obs1_fuel	 =	0	;	int obs1_food	 =	0	;	int obs1_steel	 =	0	;	int obs1_alloy	 =	0	;	int obs1_time	 =	34	;	int obs1_kyanite	=	0	;	int obs1_kyanite_basic	=	0	;	int obs1_kyanite_cluster	=	0	;
    int obs2_fuel	 =	0	;	int obs2_food	 =	1520000	;	int obs2_steel	 =	145000	;	int obs2_alloy	 =	8000	;	int obs2_time	 =	326	;	int obs2_kyanite	=	0	;	int obs2_kyanite_basic	=	0	;	int obs2_kyanite_cluster	=	0	;
    int obs3_fuel	 =	0	;	int obs3_food	 =	2740000	;	int obs3_steel	 =	261000	;	int obs3_alloy	 =	12500	;	int obs3_time	 =	428	;	int obs3_kyanite	=	0	;	int obs3_kyanite_basic	=	0	;	int obs3_kyanite_cluster	=	0	;
    int obs4_fuel	 =	0	;	int obs4_food	 =	4110000	;	int obs4_steel	 =	391000	;	int obs4_alloy	 =	19000	;	int obs4_time	 =	721	;	int obs4_kyanite	=	0	;	int obs4_kyanite_basic	=	0	;	int obs4_kyanite_cluster	=	0	;
    int obs5_fuel	 =	0	;	int obs5_food	 =	5450000	;	int obs5_steel	 =	519000	;	int obs5_alloy	 =	32400	;	int obs5_time	 =	590	;	int obs5_kyanite	=	0	;	int obs5_kyanite_basic	=	0	;	int obs5_kyanite_cluster	=	0	;
    int obs6_fuel	 =	0	;	int obs6_food	 =	7630000	;	int obs6_steel	 =	726000	;	int obs6_alloy	 =	45400	;	int obs6_time	 =	2930	;	int obs6_kyanite	=	0	;	int obs6_kyanite_basic	=	0	;	int obs6_kyanite_cluster	=	0	;
    int obs7_fuel	 =	0	;	int obs7_food	 =	0	;	int obs7_steel	 =	0	;	int obs7_alloy	 =	59000	;	int obs7_time	 =	4180	;	int obs7_kyanite	=	83	;	int obs7_kyanite_basic	=	0	;	int obs7_kyanite_cluster	=	0	;
    int obs8_fuel	 =	0	;	int obs8_food	 =	0	;	int obs8_steel	 =	0	;	int obs8_alloy	 =	76700	;	int obs8_time	 =	9300	;	int obs8_kyanite	=	170	;	int obs8_kyanite_basic	=	0	;	int obs8_kyanite_cluster	=	0	;
    int obs9_fuel	 =	0	;	int obs9_food	 =	0	;	int obs9_steel	 =	0	;	int obs9_alloy	 =	99800	;	int obs9_time	 =	11100	;	int obs9_kyanite	=	347	;	int obs9_kyanite_basic	=	0	;	int obs9_kyanite_cluster	=	0	;
    int obs10_fuel	 =	0	;	int obs10_food	 =	0	;	int obs10_steel	 =	0	;	int obs10_alloy	 =	130000	;	int obs10_time	 =	13200	;	int obs10_kyanite	=	621	;	int obs10_kyanite_basic	=	0	;	int obs10_kyanite_cluster	=	0	;
    int obs11_fuel	 =	0	;	int obs11_food	 =	0	;	int obs11_steel	 =	0	;	int obs11_alloy	 =	169000	;	int obs11_time	 =	15900	;	int obs11_kyanite	=	1087	;	int obs11_kyanite_basic	=	0	;	int obs11_kyanite_cluster	=	0	;
    int obs12_fuel	 =	0	;	int obs12_food	 =	0	;	int obs12_steel	 =	0	;	int obs12_alloy	 =	219000	;	int obs12_time	 =	20100	;	int obs12_kyanite	=	1852	;	int obs12_kyanite_basic	=	0	;	int obs12_kyanite_cluster	=	0	;
    int obs13_fuel	 =	0	;	int obs13_food	 =	0	;	int obs13_steel	 =	0	;	int obs13_alloy	 =	0	;	int obs13_time	 =	24900	;	int obs13_kyanite	=	3125	;	int obs13_kyanite_basic	=	265	;	int obs13_kyanite_cluster	=	0	;
    int obs14_fuel	 =	0	;	int obs14_food	 =	0	;	int obs14_steel	 =	0	;	int obs14_alloy	 =	0	;	int obs14_time	 =	32400	;	int obs14_kyanite	=	5039	;	int obs14_kyanite_basic	=	482	;	int obs14_kyanite_cluster	=	0	;
    int obs15_fuel	 =	0	;	int obs15_food	 =	0	;	int obs15_steel	 =	0	;	int obs15_alloy	 =	0	;	int obs15_time	 =	39600	;	int obs15_kyanite	=	7738	;	int obs15_kyanite_basic	=	657	;	int obs15_kyanite_cluster	=	0	;
    int obs16_fuel	 =	0	;	int obs16_food	 =	0	;	int obs16_steel	 =	0	;	int obs16_alloy	 =	0	;	int obs16_time	 =	50400	;	int obs16_kyanite	=	11280	;	int obs16_kyanite_basic	=	935	;	int obs16_kyanite_cluster	=	0	;
    int obs17_fuel	 =	0	;	int obs17_food	 =	0	;	int obs17_steel	 =	0	;	int obs17_alloy	 =	0	;	int obs17_time	 =	61200	;	int obs17_kyanite	=	15938	;	int obs17_kyanite_basic	=	1287	;	int obs17_kyanite_cluster	=	0	;
    int obs18_fuel	 =	0	;	int obs18_food	 =	0	;	int obs18_steel	 =	0	;	int obs18_alloy	 =	0	;	int obs18_time	 =	75600	;	int obs18_kyanite	=	20940	;	int obs18_kyanite_basic	=	2040	;	int obs18_kyanite_cluster	=	0	;
    int obs19_fuel	 =	0	;	int obs19_food	 =	0	;	int obs19_steel	 =	0	;	int obs19_alloy	 =	0	;	int obs19_time	 =	93600	;	int obs19_kyanite	=	26316	;	int obs19_kyanite_basic	=	2700	;	int obs19_kyanite_cluster	=	4750	;
    int obs20_fuel	 =	0	;	int obs20_food	 =	0	;	int obs20_steel	 =	0	;	int obs20_alloy	 =	0	;	int obs20_time	 =	118800	;	int obs20_kyanite	=	38626	;	int obs20_kyanite_basic	=	3420	;	int obs20_kyanite_cluster	=	9559	;
    int obs21_fuel	 =	0	;	int obs21_food	 =	0	;	int obs21_steel	 =	0	;	int obs21_alloy	 =	0	;	int obs21_time	 =	136800	;	int obs21_kyanite	=	49884	;	int obs21_kyanite_basic	=	4200	;	int obs21_kyanite_cluster	=	12500	;
    int obs22_fuel	 =	0	;	int obs22_food	 =	0	;	int obs22_steel	 =	0	;	int obs22_alloy	 =	0	;	int obs22_time	 =	158400	;	int obs22_kyanite	=	63452	;	int obs22_kyanite_basic	=	5160	;	int obs22_kyanite_cluster	=	16406	;
    int obs23_fuel	 =	0	;	int obs23_food	 =	0	;	int obs23_steel	 =	0	;	int obs23_alloy	 =	0	;	int obs23_time	 =	180000	;	int obs23_kyanite	=	79779	;	int obs23_kyanite_basic	=	6360	;	int obs23_kyanite_cluster	=	20968	;
    int obs24_fuel	 =	0	;	int obs24_food	 =	0	;	int obs24_steel	 =	0	;	int obs24_alloy	 =	0	;	int obs24_time	 =	208800	;	int obs24_kyanite	=	99116	;	int obs24_kyanite_basic	=	7890	;	int obs24_kyanite_cluster	=	26250	;
    int obs25_fuel	 =	0	;	int obs25_food	 =	0	;	int obs25_steel	 =	0	;	int obs25_alloy	 =	0	;	int obs25_time	 =	241200	;	int obs25_kyanite	=	121875	;	int obs25_kyanite_basic	=	9807	;	int obs25_kyanite_cluster	=	32328	;
    int obs26_fuel	 =	0	;	int obs26_food	 =	0	;	int obs26_steel	 =	0	;	int obs26_alloy	 =	0	;	int obs26_time	 =	277200	;	int obs26_kyanite	=	148522	;	int obs26_kyanite_basic	=	11776	;	int obs26_kyanite_cluster	=	39286	;
    int obs27_fuel	 =	0	;	int obs27_food	 =	0	;	int obs27_steel	 =	0	;	int obs27_alloy	 =	0	;	int obs27_time	 =	316800	;	int obs27_kyanite	=	179722	;	int obs27_kyanite_basic	=	14076	;	int obs27_kyanite_cluster	=	47222	;
    int obs28_fuel	 =	0	;	int obs28_food	 =	0	;	int obs28_steel	 =	0	;	int obs28_alloy	 =	0	;	int obs28_time	 =	363600	;	int obs28_kyanite	=	215948	;	int obs28_kyanite_basic	=	16692	;	int obs28_kyanite_cluster	=	56731	;
    int obs29_fuel	 =	0	;	int obs29_food	 =	0	;	int obs29_steel	 =	0	;	int obs29_alloy	 =	0	;	int obs29_time	 =	417600	;	int obs29_kyanite	=	258036	;	int obs29_kyanite_basic	=	19752	;	int obs29_kyanite_cluster	=	67000	;
    int obs30_fuel	 =	0	;	int obs30_food	 =	0	;	int obs30_steel	 =	0	;	int obs30_alloy	 =	0	;	int obs30_time	 =	481800	;	int obs30_kyanite	=	306636	;	int obs30_kyanite_basic	=	23424	;	int obs30_kyanite_cluster	=	78646	;

//--------------------------------------------------------------------------
    /**
     * HOLY DATABASE -- END
     */

    EditText buff_time , buff_rss;
    int now , aim ;
    TextView fuel_tv;
    TextView food_tv;
    TextView steel_tv;
    TextView alloy_tv;
    TextView time_tv ;
    TextView kyanite_tv ;
    TextView kyanite_basic_tv ;
    TextView kyanite_cluster_tv ;
    TextView now_tv , aim_tv ;
    TextView glory_mark_tv ;
    long  steel , alloy , kyanite , kyanite_basic , kyanite_cluster , glory , time;
    long fuel , food ;
    ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;
    SeekBar now_seek , aim_seek ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tb);

        listView = findViewById(R.id.list);
        now_seek = findViewById(R.id.now_seek);
        aim_seek = findViewById(R.id.aim_seek);
        now_tv = findViewById(R.id.now_seek_tv);
        aim_tv = findViewById(R.id.aim_seek_tv);
        buff_time = findViewById(R.id.tb_buff_time_et);
        buff_rss = findViewById(R.id.tb_buff_rss_et);
        fuel_tv = findViewById(R.id.tb_fuel);
        food_tv = findViewById(R.id.tb_food);
        steel_tv = findViewById(R.id.tb_steel);
        alloy_tv = findViewById(R.id.tb_alloy);
        time_tv = findViewById(R.id.tb_time);
        kyanite_tv = findViewById(R.id.tb_kyanite);
        kyanite_basic_tv = findViewById(R.id.tb_kyanite_basic);
        kyanite_cluster_tv = findViewById(R.id.tb_kyanite_cluster);
        glory_mark_tv = findViewById(R.id.tb_glory_mark);
        time_tv.setText("0d , 00:00:00");
        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.list_tv, arrayList);
        listView.setAdapter(adapter);

        //METHOD END
        BackgroundReload();
        now_seek.setMax(35);
        aim_seek.setMax(35);
        now_seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub
                if (now_seek.getProgress() >= aim_seek.getProgress()){aim_seek.setProgress(now_seek.getProgress()+1);}
                now = now_seek.getProgress();
                aim = aim_seek.getProgress();
                now_tv.setText(String.valueOf(now));
                aim_tv.setText(String.valueOf(aim));
                calculate();
            }
        });

        aim_seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub
                if (aim_seek.getProgress() <= now_seek.getProgress()){aim_seek.setProgress(now_seek.getProgress()+1);}

                now = now_seek.getProgress();
                aim = aim_seek.getProgress();
                now_tv.setText(String.valueOf(now));
                aim_tv.setText(String.valueOf(aim));
                calculate();
            }
        });
    }

    public void BackgroundReload (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.tb_bg);

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



    //arrayList.add(editTxt.getText().toString());
    //adapter.notifyDataSetChanged();

    public void calculate () {
        //clear
        fuel = food = time = alloy = steel = kyanite = kyanite_basic = kyanite_cluster = glory = 0;
        adapter.clear();

        if (now == 1 && aim >=2){
            //TB2
            adapter.add(getString(R.string.teaching_building2));
            fuel = fuel+tb2_fuel;
            food = food+tb2_food;
            steel = steel+tb2_steel;
            alloy = alloy+tb2_alloy;
            time = time+tb2_time;
        }

        if (now <3	&& aim >=3){
            //FARM1
            adapter.add(getString(R.string.farm1));
            fuel = fuel+farm1_fuel;
            time = time+farm_time1;
            //FARM2
            adapter.add(getString(R.string.farm2));
            fuel = fuel+farm2_fuel;
            time = time+farm_time2;
            //FARM3
            adapter.add(getString(R.string.farm3));
            fuel = fuel+farm3_fuel;
            time = time+farm_time3;
            //FARM4
            adapter.add(getString(R.string.farm4));
            fuel = fuel+farm4_fuel;
            time = time+farm_time4;
            //FARM5
            adapter.add(getString(R.string.farm5));
            fuel = fuel+farm5_fuel;
            time = time+farm_time5;
            //OIL WELL1
            adapter.add(getString(R.string.oil_well1));
            food = food+oil_food1;
            time = time+oil_time1;
            //OIL WELL2
            adapter.add(getString(R.string.oil_well2));
            food = food+oil_food2;
            time = time+oil_time2;
            //OIL WELL3
            adapter.add(getString(R.string.oil_well3));
            food = food+oil_food3;
            time = time+oil_time3;
            //OIL WELL4
            adapter.add(getString(R.string.oil_well4));
            food = food+oil_food4;
            time = time+oil_time4;
            //OIL WELL5
            adapter.add(getString(R.string.oil_well5));
            food = food+oil_food5;
            time = time+oil_time5;
            //ARMED FORCE1
            adapter.add(getString(R.string.armed_forces1));
            fuel = fuel+arm1_fuel;
            food = food+arm1_food;
            steel = steel+arm1_steel;
            alloy = alloy+arm1_alloy;
            time = time+arm1_time;
            //ARMED FORCE2
            adapter.add(getString(R.string.armed_forces2));
            fuel = fuel+arm2_fuel;
            food = food+arm2_food;
            steel = steel+arm2_steel;
            alloy = alloy+arm2_alloy;
            time = time+arm2_time;
            //CAFE1
            adapter.add(getString(R.string.cafeteria1));
            fuel = fuel+cafe1_fuel;
            food = food+cafe1_food;
            steel = steel+cafe1_steel;
            alloy = alloy+cafe1_alloy;
            time = time+cafe1_time;
            //CAFE2
            adapter.add(getString(R.string.cafeteria2));
            fuel = fuel+cafe2_fuel;
            food = food+cafe2_food;
            steel = steel+cafe2_steel;
            alloy = alloy+cafe2_alloy;
            time = time+cafe2_time;
            //CLONE1
            adapter.add(getString(R.string.clone_lab1));
            fuel = fuel+clone1_fuel;
            food = food+clone1_food;
            steel = steel+clone1_steel;
            alloy = alloy+clone1_alloy;
            time = time+clone1_time;
            //CLONE2
            adapter.add(getString(R.string.clone_lab2));
            fuel = fuel+clone2_fuel;
            food = food+clone2_food;
            steel = steel+clone2_steel;
            alloy = alloy+clone2_alloy;
            time = time+clone2_time;
            //COMM. BUILDING2
            adapter.add(getString(R.string.comm_building2));
            fuel = fuel+comm2_fuel;
            food = food+comm2_food;
            steel = steel+comm2_steel;
            alloy = alloy+comm2_alloy;
            time = time+comm2_time;
            //LOGISTICS CENTER1
            adapter.add(getString(R.string.logistics_center1));
            fuel = fuel+logist1_fuel;
            food = food+logist1_food;
            steel = steel+logist1_steel;
            alloy = alloy+logist1_alloy;
            time = time+logist1_time;
            //LOGISTICS CENTER2
            adapter.add(getString(R.string.logistics_center2));
            fuel = fuel+logist2_fuel;
            food = food+logist2_food;
            steel = steel+logist2_steel;
            alloy = alloy+logist2_alloy;
            time = time+logist2_time;
            //DORM2
            adapter.add(getString(R.string.dorm2));
            fuel = fuel+dorm2_fuel;
            food = food+dorm2_food;
            steel = steel+dorm2_steel;
            alloy = alloy+dorm2_alloy;
            time = time+dorm2_time;
            //EMBASSY2
            adapter.add(getString(R.string.embassy2));
            fuel = fuel+embassy2_fuel;
            food = food+embassy2_food;
            steel = steel+embassy2_steel;
            alloy = alloy+embassy2_alloy;
            time = time+embassy2_time;
            //MILITARY1
            adapter.add(getString(R.string.military_office1));
            fuel = fuel+military1_fuel;
            food = food+military1_food;
            steel = steel+military1_steel;
            alloy = alloy+military1_alloy;
            time = time+military1_time;
            //MILITARY2
            adapter.add(getString(R.string.military_office2));
            fuel = fuel+military2_fuel;
            food = food+military2_food;
            steel = steel+military2_steel;
            alloy = alloy+military2_alloy;
            time = time+military2_time;
            //SHELTER1
            adapter.add(getString(R.string.shelter1));
            fuel = fuel+shelter1_fuel;
            food = food+shelter1_food;
            steel = steel+shelter1_steel;
            time = time+shelter1_time;
            //SHELTER2
            adapter.add(getString(R.string.shelter2));
            fuel = fuel+shelter2_fuel;
            food = food+shelter2_food;
            steel = steel+shelter2_steel;
            time = time+shelter2_time;
            //STOREROOM2
            adapter.add(getString(R.string.storeroom2));
            fuel = fuel+store2_fuel;
            food = food+store2_food;
            steel = steel+store2_steel;
            alloy = alloy+store2_alloy;
            time = time+store2_time;
            //WALL2
            adapter.add(getString(R.string.wall2));
            fuel = fuel+wall2_fuel;
            food = food+wall2_food;
            steel = steel+wall2_steel;
            alloy = alloy+wall2_alloy;
            time = time+wall2_time;
            //TB3
            adapter.add(getString(R.string.teaching_building3));
            fuel = fuel+tb3_fuel;
            food = food+tb3_food;
            steel = steel+tb3_steel;
            alloy = alloy+tb3_alloy;
            time = time+tb3_time;
        }

        if (now <4	&& aim >=4){















































            //ARMED FORCE3
            adapter.add(getString(R.string.armed_forces3));
            fuel = fuel+arm3_fuel;
            food = food+arm3_food;
            steel = steel+arm3_steel;
            alloy = alloy+arm3_alloy;
            time = time+arm3_time;







            //CAFE3
            adapter.add(getString(R.string.cafeteria3));
            fuel = fuel+cafe3_fuel;
            food = food+cafe3_food;
            steel = steel+cafe3_steel;
            alloy = alloy+cafe3_alloy;
            time = time+cafe3_time;







            //CLONE3
            adapter.add(getString(R.string.clone_lab3));
            fuel = fuel+clone3_fuel;
            food = food+clone3_food;
            steel = steel+clone3_steel;
            alloy = alloy+clone3_alloy;
            time = time+clone3_time;
            //COMM. BUILDING3
            adapter.add(getString(R.string.comm_building3));
            fuel = fuel+comm3_fuel;
            food = food+comm3_food;
            steel = steel+comm3_steel;
            alloy = alloy+comm3_alloy;
            time = time+comm3_time;







            //LOGISTICS CENTER3
            adapter.add(getString(R.string.logistics_center3));
            fuel = fuel+logist3_fuel;
            food = food+logist3_food;
            steel = steel+logist3_steel;
            alloy = alloy+logist3_alloy;
            time = time+logist3_time;
            //DORM3
            adapter.add(getString(R.string.dorm3));
            fuel = fuel+dorm3_fuel;
            food = food+dorm3_food;
            steel = steel+dorm3_steel;
            alloy = alloy+dorm3_alloy;
            time = time+dorm3_time;
            //EMBASSY3
            adapter.add(getString(R.string.embassy3));
            fuel = fuel+embassy3_fuel;
            food = food+embassy3_food;
            steel = steel+embassy3_steel;
            alloy = alloy+embassy3_alloy;
            time = time+embassy3_time;







            //MILITARY3
            adapter.add(getString(R.string.military_office3));
            fuel = fuel+military3_fuel;
            food = food+military3_food;
            steel = steel+military3_steel;
            alloy = alloy+military3_alloy;
            time = time+military3_time;







            //SHELTER3
            adapter.add(getString(R.string.shelter3));
            fuel = fuel+shelter3_fuel;
            food = food+shelter3_food;
            steel = steel+shelter3_steel;
            time = time+shelter3_time;
            //STOREROOM3
            adapter.add(getString(R.string.storeroom3));
            fuel = fuel+store3_fuel;
            food = food+store3_food;
            steel = steel+store3_steel;
            alloy = alloy+store3_alloy;
            time = time+store3_time;
            //WALL3
            adapter.add(getString(R.string.wall3));
            fuel = fuel+wall3_fuel;
            food = food+wall3_food;
            steel = steel+wall3_steel;
            alloy = alloy+wall3_alloy;
            time = time+wall3_time;
            //CLINIC1
            adapter.add(getString(R.string.clinic1));
            fuel = fuel+clinic1_fuel;
            food = food+clinic1_food;
            steel = steel+clinic1_steel;
            alloy = alloy+clinic1_alloy;
            time = time+clinic1_time;
            //CLINIC2
            adapter.add(getString(R.string.clinic2));
            fuel = fuel+clinic2_fuel;
            food = food+clinic2_food;
            steel = steel+clinic2_steel;
            alloy = alloy+clinic2_alloy;
            time = time+clinic2_time;
            //CLINIC3
            adapter.add(getString(R.string.clinic3));
            fuel = fuel+clinic3_fuel;
            food = food+clinic3_food;
            steel = steel+clinic3_steel;
            alloy = alloy+clinic3_alloy;
            time = time+clinic3_time;
            //TB4
            adapter.add(getString(R.string.teaching_building4));
            fuel = fuel+tb4_fuel;
            food = food+tb4_food;
            steel = steel+tb4_steel;
            alloy = alloy+tb4_alloy;
            time = time+tb4_time;
        }

        if (now <5	&& aim >=5){
            //LAB1
            adapter.add(getString(R.string.laboratory1));
            fuel = fuel+lab1_fuel;
            food = food+lab1_food;
            steel = steel+lab1_steel;
            alloy = alloy+lab1_alloy;
            time = time+lab1_time;
            //LAB2
            adapter.add(getString(R.string.laboratory2));
            fuel = fuel+lab2_fuel;
            food = food+lab2_food;
            steel = steel+lab2_steel;
            alloy = alloy+lab2_alloy;
            time = time+lab2_time;
            //LAB3
            adapter.add(getString(R.string.laboratory3));
            fuel = fuel+lab3_fuel;
            food = food+lab3_food;
            steel = steel+lab3_steel;
            alloy = alloy+lab3_alloy;
            time = time+lab3_time;
            //LAB4
            adapter.add(getString(R.string.laboratory4));
            fuel = fuel+lab4_fuel;
            food = food+lab4_food;
            steel = steel+lab4_steel;
            alloy = alloy+lab4_alloy;
            time = time+lab4_time;



















            //ARMED FORCE4
            adapter.add(getString(R.string.armed_forces4));
            fuel = fuel+arm4_fuel;
            food = food+arm4_food;
            steel = steel+arm4_steel;
            alloy = alloy+arm4_alloy;
            time = time+arm4_time;







            //CAFE4
            adapter.add(getString(R.string.cafeteria4));
            fuel = fuel+cafe4_fuel;
            food = food+cafe4_food;
            steel = steel+cafe4_steel;
            alloy = alloy+cafe4_alloy;
            time = time+cafe4_time;







            //CLONE4
            adapter.add(getString(R.string.clone_lab4));
            fuel = fuel+clone4_fuel;
            food = food+clone4_food;
            steel = steel+clone4_steel;
            alloy = alloy+clone4_alloy;
            time = time+clone4_time;
            //COMM. BUILDING4
            adapter.add(getString(R.string.comm_building4));
            fuel = fuel+comm4_fuel;
            food = food+comm4_food;
            steel = steel+comm4_steel;
            alloy = alloy+comm4_alloy;
            time = time+comm4_time;







            //LOGISTICS CENTER4
            adapter.add(getString(R.string.logistics_center4));
            fuel = fuel+logist4_fuel;
            food = food+logist4_food;
            steel = steel+logist4_steel;
            alloy = alloy+logist4_alloy;
            time = time+logist4_time;
            //DORM4
            adapter.add(getString(R.string.dorm4));
            fuel = fuel+dorm4_fuel;
            food = food+dorm4_food;
            steel = steel+dorm4_steel;
            alloy = alloy+dorm4_alloy;
            time = time+dorm4_time;
            //EMBASSY4
            adapter.add(getString(R.string.embassy4));
            fuel = fuel+embassy4_fuel;
            food = food+embassy4_food;
            steel = steel+embassy4_steel;
            alloy = alloy+embassy4_alloy;
            time = time+embassy4_time;







            //MILITARY4
            adapter.add(getString(R.string.military_office4));
            fuel = fuel+military4_fuel;
            food = food+military4_food;
            steel = steel+military4_steel;
            alloy = alloy+military4_alloy;
            time = time+military4_time;







            //SHELTER4
            adapter.add(getString(R.string.shelter4));
            fuel = fuel+shelter4_fuel;
            food = food+shelter4_food;
            steel = steel+shelter4_steel;
            time = time+shelter4_time;
            //STOREROOM4
            adapter.add(getString(R.string.storeroom4));
            fuel = fuel+store4_fuel;
            food = food+store4_food;
            steel = steel+store4_steel;
            alloy = alloy+store4_alloy;
            time = time+store4_time;
            //WALL4
            adapter.add(getString(R.string.wall4));
            fuel = fuel+wall4_fuel;
            food = food+wall4_food;
            steel = steel+wall4_steel;
            alloy = alloy+wall4_alloy;
            time = time+wall4_time;














            //CLINIC4
            adapter.add(getString(R.string.clinic4));
            fuel = fuel+clinic4_fuel;
            food = food+clinic4_food;
            steel = steel+clinic4_steel;
            alloy = alloy+clinic4_alloy;
            time = time+clinic4_time;
            //TB5
            adapter.add(getString(R.string.teaching_building5));
            fuel = fuel+tb5_fuel;
            food = food+tb5_food;
            steel = steel+tb5_steel;
            alloy = alloy+tb5_alloy;
            time = time+tb5_time;
        }

        if (now <6	&& aim >=6){














            //LAB5
            adapter.add(getString(R.string.laboratory5));
            fuel = fuel+lab5_fuel;
            food = food+lab5_food;
            steel = steel+lab5_steel;
            alloy = alloy+lab5_alloy;
            time = time+lab5_time;


























            //ARMED FORCE5
            adapter.add(getString(R.string.armed_forces5));
            fuel = fuel+arm5_fuel;
            food = food+arm5_food;
            steel = steel+arm5_steel;
            alloy = alloy+arm5_alloy;
            time = time+arm5_time;







            //CAFE5
            adapter.add(getString(R.string.cafeteria5));
            fuel = fuel+cafe5_fuel;
            food = food+cafe5_food;
            steel = steel+cafe5_steel;
            alloy = alloy+cafe5_alloy;
            time = time+cafe5_time;







            //CLONE5
            adapter.add(getString(R.string.clone_lab5));
            fuel = fuel+clone5_fuel;
            food = food+clone5_food;
            steel = steel+clone5_steel;
            alloy = alloy+clone5_alloy;
            time = time+clone5_time;
            //COMM. BUILDING5
            adapter.add(getString(R.string.comm_building5));
            fuel = fuel+comm5_fuel;
            food = food+comm5_food;
            steel = steel+comm5_steel;
            alloy = alloy+comm5_alloy;
            time = time+comm5_time;







            //LOGISTICS CENTER5
            adapter.add(getString(R.string.logistics_center5));
            fuel = fuel+logist5_fuel;
            food = food+logist5_food;
            steel = steel+logist5_steel;
            alloy = alloy+logist5_alloy;
            time = time+logist5_time;
            //DORM5
            adapter.add(getString(R.string.dorm5));
            fuel = fuel+dorm5_fuel;
            food = food+dorm5_food;
            steel = steel+dorm5_steel;
            alloy = alloy+dorm5_alloy;
            time = time+dorm5_time;
            //EMBASSY5
            adapter.add(getString(R.string.embassy5));
            fuel = fuel+embassy5_fuel;
            food = food+embassy5_food;
            steel = steel+embassy5_steel;
            alloy = alloy+embassy5_alloy;
            time = time+embassy5_time;







            //MILITARY5
            adapter.add(getString(R.string.military_office5));
            fuel = fuel+military5_fuel;
            food = food+military5_food;
            steel = steel+military5_steel;
            alloy = alloy+military5_alloy;
            time = time+military5_time;







            //SHELTER5
            adapter.add(getString(R.string.shelter5));
            fuel = fuel+shelter5_fuel;
            food = food+shelter5_food;
            steel = steel+shelter5_steel;
            time = time+shelter5_time;
            //STOREROOM5
            adapter.add(getString(R.string.storeroom5));
            fuel = fuel+store5_fuel;
            food = food+store5_food;
            steel = steel+store5_steel;
            alloy = alloy+store5_alloy;
            time = time+store5_time;
            //WALL5
            adapter.add(getString(R.string.wall5));
            fuel = fuel+wall5_fuel;
            food = food+wall5_food;
            steel = steel+wall5_steel;
            alloy = alloy+wall5_alloy;
            time = time+wall5_time;














            //CLINIC5
            adapter.add(getString(R.string.clinic5));
            fuel = fuel+clinic5_fuel;
            food = food+clinic5_food;
            steel = steel+clinic5_steel;
            alloy = alloy+clinic5_alloy;
            time = time+clinic5_time;
            //MOBILE1
            adapter.add(getString(R.string.mobile_team_factory1));
            fuel = fuel+mobile1_fuel;
            food = food+mobile1_food;
            steel = steel+mobile1_steel;
            alloy = alloy+mobile1_alloy;
            time = time+mobile1_time;
            //MOBILE2
            adapter.add(getString(R.string.mobile_team_factory2));
            fuel = fuel+mobile2_fuel;
            food = food+mobile2_food;
            steel = steel+mobile2_steel;
            alloy = alloy+mobile2_alloy;
            time = time+mobile2_time;
            //MOBILE3
            adapter.add(getString(R.string.mobile_team_factory3));
            fuel = fuel+mobile3_fuel;
            food = food+mobile3_food;
            steel = steel+mobile3_steel;
            alloy = alloy+mobile3_alloy;
            time = time+mobile3_time;
            //MOBILE4
            adapter.add(getString(R.string.mobile_team_factory4));
            fuel = fuel+mobile4_fuel;
            food = food+mobile4_food;
            steel = steel+mobile4_steel;
            alloy = alloy+mobile4_alloy;
            time = time+mobile4_time;
            //MOBILE5
            adapter.add(getString(R.string.mobile_team_factory5));
            fuel = fuel+mobile5_fuel;
            food = food+mobile5_food;
            steel = steel+mobile5_steel;
            alloy = alloy+mobile5_alloy;
            time = time+mobile5_time;
            //TB6
            adapter.add(getString(R.string.teaching_building6));
            fuel = fuel+tb6_fuel;
            food = food+tb6_food;
            steel = steel+tb6_steel;
            alloy = alloy+tb6_alloy;
            time = time+tb6_time;
        }

        if (now <7	&& aim >=7){
            //FARM6
            adapter.add(getString(R.string.farm6));
            fuel = fuel+farm6_fuel;
            time = time+farm_time6;










            //LAB6
            adapter.add(getString(R.string.laboratory6));
            fuel = fuel+lab6_fuel;
            food = food+lab6_food;
            steel = steel+lab6_steel;
            alloy = alloy+lab6_alloy;
            time = time+lab6_time;
            //OIL WELL6
            adapter.add(getString(R.string.oil_well6));
            food = food+oil_food6;
            time = time+oil_time6;






















            //ARMED FORCE6
            adapter.add(getString(R.string.armed_forces6));
            fuel = fuel+arm6_fuel;
            food = food+arm6_food;
            steel = steel+arm6_steel;
            alloy = alloy+arm6_alloy;
            time = time+arm6_time;







            //CAFE6
            adapter.add(getString(R.string.cafeteria6));
            fuel = fuel+cafe6_fuel;
            food = food+cafe6_food;
            steel = steel+cafe6_steel;
            alloy = alloy+cafe6_alloy;
            time = time+cafe6_time;







            //CLONE6
            adapter.add(getString(R.string.clone_lab6));
            fuel = fuel+clone6_fuel;
            food = food+clone6_food;
            steel = steel+clone6_steel;
            alloy = alloy+clone6_alloy;
            time = time+clone6_time;
            //COMM. BUILDING6
            adapter.add(getString(R.string.comm_building6));
            fuel = fuel+comm6_fuel;
            food = food+comm6_food;
            steel = steel+comm6_steel;
            alloy = alloy+comm6_alloy;
            time = time+comm6_time;







            //LOGISTICS CENTER6
            adapter.add(getString(R.string.logistics_center6));
            fuel = fuel+logist6_fuel;
            food = food+logist6_food;
            steel = steel+logist6_steel;
            alloy = alloy+logist6_alloy;
            time = time+logist6_time;
            //DORM6
            adapter.add(getString(R.string.dorm6));
            fuel = fuel+dorm6_fuel;
            food = food+dorm6_food;
            steel = steel+dorm6_steel;
            alloy = alloy+dorm6_alloy;
            time = time+dorm6_time;
            //EMBASSY6
            adapter.add(getString(R.string.embassy6));
            fuel = fuel+embassy6_fuel;
            food = food+embassy6_food;
            steel = steel+embassy6_steel;
            alloy = alloy+embassy6_alloy;
            time = time+embassy6_time;







            //MILITARY6
            adapter.add(getString(R.string.military_office6));
            fuel = fuel+military6_fuel;
            food = food+military6_food;
            steel = steel+military6_steel;
            alloy = alloy+military6_alloy;
            time = time+military6_time;







            //SHELTER6
            adapter.add(getString(R.string.shelter6));
            fuel = fuel+shelter6_fuel;
            food = food+shelter6_food;
            steel = steel+shelter6_steel;
            time = time+shelter6_time;
            //STOREROOM6
            adapter.add(getString(R.string.storeroom6));
            fuel = fuel+store6_fuel;
            food = food+store6_food;
            steel = steel+store6_steel;
            alloy = alloy+store6_alloy;
            time = time+store6_time;
            //WALL6
            adapter.add(getString(R.string.wall6));
            fuel = fuel+wall6_fuel;
            food = food+wall6_food;
            steel = steel+wall6_steel;
            alloy = alloy+wall6_alloy;
            time = time+wall6_time;














            //CLINIC6
            adapter.add(getString(R.string.clinic6));
            fuel = fuel+clinic6_fuel;
            food = food+clinic6_food;
            steel = steel+clinic6_steel;
            alloy = alloy+clinic6_alloy;
            time = time+clinic6_time;





















            //MOBILE6
            adapter.add(getString(R.string.mobile_team_factory6));
            fuel = fuel+mobile6_fuel;
            food = food+mobile6_food;
            steel = steel+mobile6_steel;
            alloy = alloy+mobile6_alloy;
            time = time+mobile6_time;
            //PRISON1
            adapter.add(getString(R.string.prison1));
            fuel = fuel+prison1_fuel;
            food = food+prison1_food;
            steel = steel+prison1_steel;
            alloy = alloy+prison1_alloy;
            time = time+prison1_time;
            //PRISON2
            adapter.add(getString(R.string.prison2));
            fuel = fuel+prison2_fuel;
            food = food+prison2_food;
            steel = steel+prison2_steel;
            alloy = alloy+prison2_alloy;
            time = time+prison2_time;
            //PRISON3
            adapter.add(getString(R.string.prison3));
            fuel = fuel+prison3_fuel;
            food = food+prison3_food;
            steel = steel+prison3_steel;
            alloy = alloy+prison3_alloy;
            time = time+prison3_time;
            //PRISON4
            adapter.add(getString(R.string.prison4));
            fuel = fuel+prison4_fuel;
            food = food+prison4_food;
            steel = steel+prison4_steel;
            alloy = alloy+prison4_alloy;
            time = time+prison4_time;
            //PRISON5
            adapter.add(getString(R.string.prison5));
            fuel = fuel+prison5_fuel;
            food = food+prison5_food;
            steel = steel+prison5_steel;
            alloy = alloy+prison5_alloy;
            time = time+prison5_time;
            //PRISON6
            adapter.add(getString(R.string.prison6));
            fuel = fuel+prison6_fuel;
            food = food+prison6_food;
            steel = steel+prison6_steel;
            alloy = alloy+prison6_alloy;
            time = time+prison6_time;
            //TB7
            adapter.add(getString(R.string.teaching_building7));
            fuel = fuel+tb7_fuel;
            food = food+tb7_food;
            steel = steel+tb7_steel;
            alloy = alloy+tb7_alloy;
            time = time+tb7_time;
        }

        if (now <8	&& aim >=8){
            //FARM7
            adapter.add(getString(R.string.farm7));
            fuel = fuel+farm7_fuel;
            time = time+farm_time7;










            //LAB7
            adapter.add(getString(R.string.laboratory7));
            fuel = fuel+lab7_fuel;
            food = food+lab7_food;
            steel = steel+lab7_steel;
            alloy = alloy+lab7_alloy;
            time = time+lab7_time;
            //OIL WELL7
            adapter.add(getString(R.string.oil_well7));
            food = food+oil_food7;
            time = time+oil_time7;






















            //ARMED FORCE7
            adapter.add(getString(R.string.armed_forces7));
            fuel = fuel+arm7_fuel;
            food = food+arm7_food;
            steel = steel+arm7_steel;
            alloy = alloy+arm7_alloy;
            time = time+arm7_time;







            //CAFE7
            adapter.add(getString(R.string.cafeteria7));
            fuel = fuel+cafe7_fuel;
            food = food+cafe7_food;
            steel = steel+cafe7_steel;
            alloy = alloy+cafe7_alloy;
            time = time+cafe7_time;







            //CLONE7
            adapter.add(getString(R.string.clone_lab7));
            fuel = fuel+clone7_fuel;
            food = food+clone7_food;
            steel = steel+clone7_steel;
            alloy = alloy+clone7_alloy;
            time = time+clone7_time;
            //COMM. BUILDING7
            adapter.add(getString(R.string.comm_building7));
            fuel = fuel+comm7_fuel;
            food = food+comm7_food;
            steel = steel+comm7_steel;
            alloy = alloy+comm7_alloy;
            time = time+comm7_time;







            //LOGISTICS CENTER7
            adapter.add(getString(R.string.logistics_center7));
            fuel = fuel+logist7_fuel;
            food = food+logist7_food;
            steel = steel+logist7_steel;
            alloy = alloy+logist7_alloy;
            time = time+logist7_time;
            //DORM7
            adapter.add(getString(R.string.dorm7));
            fuel = fuel+dorm7_fuel;
            food = food+dorm7_food;
            steel = steel+dorm7_steel;
            alloy = alloy+dorm7_alloy;
            time = time+dorm7_time;
            //EMBASSY7
            adapter.add(getString(R.string.embassy7));
            fuel = fuel+embassy7_fuel;
            food = food+embassy7_food;
            steel = steel+embassy7_steel;
            alloy = alloy+embassy7_alloy;
            time = time+embassy7_time;







            //MILITARY7
            adapter.add(getString(R.string.military_office7));
            fuel = fuel+military7_fuel;
            food = food+military7_food;
            steel = steel+military7_steel;
            alloy = alloy+military7_alloy;
            time = time+military7_time;







            //SHELTER7
            adapter.add(getString(R.string.shelter7));
            fuel = fuel+shelter7_fuel;
            food = food+shelter7_food;
            steel = steel+shelter7_steel;
            time = time+shelter7_time;
            //STOREROOM7
            adapter.add(getString(R.string.storeroom7));
            fuel = fuel+store7_fuel;
            food = food+store7_food;
            steel = steel+store7_steel;
            alloy = alloy+store7_alloy;
            time = time+store7_time;
            //WALL7
            adapter.add(getString(R.string.wall7));
            fuel = fuel+wall7_fuel;
            food = food+wall7_food;
            steel = steel+wall7_steel;
            alloy = alloy+wall7_alloy;
            time = time+wall7_time;














            //CLINIC7
            adapter.add(getString(R.string.clinic7));
            fuel = fuel+clinic7_fuel;
            food = food+clinic7_food;
            steel = steel+clinic7_steel;
            alloy = alloy+clinic7_alloy;
            time = time+clinic7_time;





















            //MOBILE7
            adapter.add(getString(R.string.mobile_team_factory7));
            fuel = fuel+mobile7_fuel;
            food = food+mobile7_food;
            steel = steel+mobile7_steel;
            alloy = alloy+mobile7_alloy;
            time = time+mobile7_time;



































            //PRISON7
            adapter.add(getString(R.string.prison7));
            fuel = fuel+prison7_fuel;
            food = food+prison7_food;
            steel = steel+prison7_steel;
            alloy = alloy+prison7_alloy;
            time = time+prison7_time;
            //SHRINE1
            adapter.add(getString(R.string.shrine1));
            fuel = fuel+shrine1_fuel;
            food = food+shrine1_food;
            steel = steel+shrine1_steel;
            alloy = alloy+shrine1_alloy;
            time = time+shrine1_time;
            //SHRINE2
            adapter.add(getString(R.string.shrine2));
            fuel = fuel+shrine2_fuel;
            food = food+shrine2_food;
            steel = steel+shrine2_steel;
            alloy = alloy+shrine2_alloy;
            time = time+shrine2_time;
            //SHRINE3
            adapter.add(getString(R.string.shrine3));
            fuel = fuel+shrine3_fuel;
            food = food+shrine3_food;
            steel = steel+shrine3_steel;
            alloy = alloy+shrine3_alloy;
            time = time+shrine3_time;
            //SHRINE4
            adapter.add(getString(R.string.shrine4));
            fuel = fuel+shrine4_fuel;
            food = food+shrine4_food;
            steel = steel+shrine4_steel;
            alloy = alloy+shrine4_alloy;
            time = time+shrine4_time;
            //SHRINE5
            adapter.add(getString(R.string.shrine5));
            fuel = fuel+shrine5_fuel;
            food = food+shrine5_food;
            steel = steel+shrine5_steel;
            alloy = alloy+shrine5_alloy;
            time = time+shrine5_time;
            //SHRINE6
            adapter.add(getString(R.string.shrine6));
            fuel = fuel+shrine6_fuel;
            food = food+shrine6_food;
            steel = steel+shrine6_steel;
            alloy = alloy+shrine6_alloy;
            time = time+shrine6_time;
            //SHRINE7
            adapter.add(getString(R.string.shrine7));
            fuel = fuel+shrine7_fuel;
            food = food+shrine7_food;
            steel = steel+shrine7_steel;
            alloy = alloy+shrine7_alloy;
            time = time+shrine7_time;
            //TB8
            adapter.add(getString(R.string.teaching_building8));
            fuel = fuel+tb8_fuel;
            food = food+tb8_food;
            steel = steel+tb8_steel;
            alloy = alloy+tb8_alloy;
            time = time+tb8_time;
        }

        if (now <9	&& aim >=9){
            //FARM8
            adapter.add(getString(R.string.farm8));
            fuel = fuel+farm8_fuel;
            time = time+farm_time8;










            //LAB8
            adapter.add(getString(R.string.laboratory8));
            fuel = fuel+lab8_fuel;
            food = food+lab8_food;
            steel = steel+lab8_steel;
            alloy = alloy+lab8_alloy;
            time = time+lab8_time;
            //OIL WELL8
            adapter.add(getString(R.string.oil_well8));
            food = food+oil_food8;
            time = time+oil_time8;






















            //ARMED FORCE8
            adapter.add(getString(R.string.armed_forces8));
            fuel = fuel+arm8_fuel;
            food = food+arm8_food;
            steel = steel+arm8_steel;
            alloy = alloy+arm8_alloy;
            time = time+arm8_time;







            //CAFE8
            adapter.add(getString(R.string.cafeteria8));
            fuel = fuel+cafe8_fuel;
            food = food+cafe8_food;
            steel = steel+cafe8_steel;
            alloy = alloy+cafe8_alloy;
            time = time+cafe8_time;







            //CLONE8
            adapter.add(getString(R.string.clone_lab8));
            fuel = fuel+clone8_fuel;
            food = food+clone8_food;
            steel = steel+clone8_steel;
            alloy = alloy+clone8_alloy;
            time = time+clone8_time;
            //COMM. BUILDING8
            adapter.add(getString(R.string.comm_building8));
            fuel = fuel+comm8_fuel;
            food = food+comm8_food;
            steel = steel+comm8_steel;
            alloy = alloy+comm8_alloy;
            time = time+comm8_time;







            //LOGISTICS CENTER8
            adapter.add(getString(R.string.logistics_center8));
            fuel = fuel+logist8_fuel;
            food = food+logist8_food;
            steel = steel+logist8_steel;
            alloy = alloy+logist8_alloy;
            time = time+logist8_time;
            //DORM8
            adapter.add(getString(R.string.dorm8));
            fuel = fuel+dorm8_fuel;
            food = food+dorm8_food;
            steel = steel+dorm8_steel;
            alloy = alloy+dorm8_alloy;
            time = time+dorm8_time;
            //EMBASSY8
            adapter.add(getString(R.string.embassy8));
            fuel = fuel+embassy8_fuel;
            food = food+embassy8_food;
            steel = steel+embassy8_steel;
            alloy = alloy+embassy8_alloy;
            time = time+embassy8_time;







            //MILITARY8
            adapter.add(getString(R.string.military_office8));
            fuel = fuel+military8_fuel;
            food = food+military8_food;
            steel = steel+military8_steel;
            alloy = alloy+military8_alloy;
            time = time+military8_time;







            //SHELTER8
            adapter.add(getString(R.string.shelter8));
            fuel = fuel+shelter8_fuel;
            food = food+shelter8_food;
            steel = steel+shelter8_steel;

            time = time+shelter8_time;
            //STOREROOM8
            adapter.add(getString(R.string.storeroom8));
            fuel = fuel+store8_fuel;
            food = food+store8_food;
            steel = steel+store8_steel;
            alloy = alloy+store8_alloy;
            time = time+store8_time;
            //WALL8
            adapter.add(getString(R.string.wall8));
            fuel = fuel+wall8_fuel;
            food = food+wall8_food;
            steel = steel+wall8_steel;
            alloy = alloy+wall8_alloy;
            time = time+wall8_time;














            //CLINIC8
            adapter.add(getString(R.string.clinic8));
            fuel = fuel+clinic8_fuel;
            food = food+clinic8_food;
            steel = steel+clinic8_steel;
            alloy = alloy+clinic8_alloy;
            time = time+clinic8_time;





















            //MOBILE8
            adapter.add(getString(R.string.mobile_team_factory8));
            fuel = fuel+mobile8_fuel;
            food = food+mobile8_food;
            steel = steel+mobile8_steel;
            alloy = alloy+mobile8_alloy;
            time = time+mobile8_time;



































            //PRISON8
            adapter.add(getString(R.string.prison8));
            fuel = fuel+prison8_fuel;
            food = food+prison8_food;
            steel = steel+prison8_steel;
            alloy = alloy+prison8_alloy;
            time = time+prison8_time;

















































            //ARMORY2
            adapter.add(getString(R.string.armory2));
            fuel = fuel+armory2_fuel;
            food = food+armory2_food;
            steel = steel+armory2_steel;
            alloy = alloy+armory2_alloy;
            time = time+armory2_time;
            //ARMORY3
            adapter.add(getString(R.string.armory3));
            fuel = fuel+armory3_fuel;
            food = food+armory3_food;
            steel = steel+armory3_steel;
            alloy = alloy+armory3_alloy;
            time = time+armory3_time;
            //ARMORY4
            adapter.add(getString(R.string.armory4));
            fuel = fuel+armory4_fuel;
            food = food+armory4_food;
            steel = steel+armory4_steel;
            alloy = alloy+armory4_alloy;
            time = time+armory4_time;
            //ARMORY5
            adapter.add(getString(R.string.armory5));
            fuel = fuel+armory5_fuel;
            food = food+armory5_food;
            steel = steel+armory5_steel;
            alloy = alloy+armory5_alloy;
            time = time+armory5_time;
            //ARMORY6
            adapter.add(getString(R.string.armory6));
            fuel = fuel+armory6_fuel;
            food = food+armory6_food;
            steel = steel+armory6_steel;
            alloy = alloy+armory6_alloy;
            time = time+armory6_time;
            //ARMORY7
            adapter.add(getString(R.string.armory7));
            fuel = fuel+armory7_fuel;
            food = food+armory7_food;
            steel = steel+armory7_steel;
            alloy = alloy+armory7_alloy;
            time = time+armory7_time;
            //ARMORY8
            adapter.add(getString(R.string.armory8));
            fuel = fuel+armory8_fuel;
            food = food+armory8_food;
            steel = steel+armory8_steel;
            alloy = alloy+armory8_alloy;
            time = time+armory8_time;
            //TB9
            adapter.add(getString(R.string.teaching_building9));
            fuel = fuel+tb9_fuel;
            food = food+tb9_food;
            steel = steel+tb9_steel;
            alloy = alloy+tb9_alloy;
            time = time+tb9_time;
        }

        if (now <10	&& aim >=10){
            //FARM9
            adapter.add(getString(R.string.farm9));
            fuel = fuel+farm9_fuel;
            time = time+farm_time9;










            //LAB9
            adapter.add(getString(R.string.laboratory9));
            fuel = fuel+lab9_fuel;
            food = food+lab9_food;
            steel = steel+lab9_steel;
            alloy = alloy+lab9_alloy;
            time = time+lab9_time;
            //OIL WELL9
            adapter.add(getString(R.string.oil_well9));
            food = food+oil_food9;
            time = time+oil_time9;






















            //ARMED FORCE9
            adapter.add(getString(R.string.armed_forces9));
            fuel = fuel+arm9_fuel;
            food = food+arm9_food;
            steel = steel+arm9_steel;
            alloy = alloy+arm9_alloy;
            time = time+arm9_time;







            //CAFE9
            adapter.add(getString(R.string.cafeteria9));
            fuel = fuel+cafe9_fuel;
            food = food+cafe9_food;
            steel = steel+cafe9_steel;
            alloy = alloy+cafe9_alloy;
            time = time+cafe9_time;







            //CLONE9
            adapter.add(getString(R.string.clone_lab9));
            fuel = fuel+clone9_fuel;
            food = food+clone9_food;
            steel = steel+clone9_steel;
            alloy = alloy+clone9_alloy;
            time = time+clone9_time;
            //COMM. BUILDING9
            adapter.add(getString(R.string.comm_building9));
            fuel = fuel+comm9_fuel;
            food = food+comm9_food;
            steel = steel+comm9_steel;
            alloy = alloy+comm9_alloy;
            time = time+comm9_time;







            //LOGISTICS CENTER9
            adapter.add(getString(R.string.logistics_center9));
            fuel = fuel+logist9_fuel;
            food = food+logist9_food;
            steel = steel+logist9_steel;
            alloy = alloy+logist9_alloy;
            time = time+logist9_time;
            //DORM9
            adapter.add(getString(R.string.dorm9));
            fuel = fuel+dorm9_fuel;
            food = food+dorm9_food;
            steel = steel+dorm9_steel;
            alloy = alloy+dorm9_alloy;
            time = time+dorm9_time;
            //EMBASSY9
            adapter.add(getString(R.string.embassy9));
            fuel = fuel+embassy9_fuel;
            food = food+embassy9_food;
            steel = steel+embassy9_steel;
            alloy = alloy+embassy9_alloy;
            time = time+embassy9_time;







            //MILITARY9
            adapter.add(getString(R.string.military_office9));
            fuel = fuel+military9_fuel;
            food = food+military9_food;
            steel = steel+military9_steel;
            alloy = alloy+military9_alloy;
            time = time+military9_time;







            //SHELTER9
            adapter.add(getString(R.string.shelter9));
            fuel = fuel+shelter9_fuel;
            food = food+shelter9_food;
            steel = steel+shelter9_steel;

            time = time+shelter9_time;
            //STOREROOM9
            adapter.add(getString(R.string.storeroom9));
            fuel = fuel+store9_fuel;
            food = food+store9_food;
            steel = steel+store9_steel;
            alloy = alloy+store9_alloy;
            time = time+store9_time;
            //WALL9
            adapter.add(getString(R.string.wall9));
            fuel = fuel+wall9_fuel;
            food = food+wall9_food;
            steel = steel+wall9_steel;
            alloy = alloy+wall9_alloy;
            time = time+wall9_time;














            //CLINIC9
            adapter.add(getString(R.string.clinic9));
            fuel = fuel+clinic9_fuel;
            food = food+clinic9_food;
            steel = steel+clinic9_steel;
            alloy = alloy+clinic9_alloy;
            time = time+clinic9_time;





















            //MOBILE9
            adapter.add(getString(R.string.mobile_team_factory9));
            fuel = fuel+mobile9_fuel;
            food = food+mobile9_food;
            steel = steel+mobile9_steel;
            alloy = alloy+mobile9_alloy;
            time = time+mobile9_time;



































            //PRISON9
            adapter.add(getString(R.string.prison9));
            fuel = fuel+prison9_fuel;
            food = food+prison9_food;
            steel = steel+prison9_steel;
            alloy = alloy+prison9_alloy;
            time = time+prison9_time;



























































































            //ARMORY9
            adapter.add(getString(R.string.armory9));
            fuel = fuel+armory9_fuel;
            food = food+armory9_food;
            steel = steel+armory9_steel;
            alloy = alloy+armory9_alloy;
            time = time+armory9_time;
            //TB10
            adapter.add(getString(R.string.teaching_building10));
            fuel = fuel+tb10_fuel;
            food = food+tb10_food;
            steel = steel+tb10_steel;
            alloy = alloy+tb10_alloy;
            time = time+tb10_time;
        }

        if (now <11	&& aim >=11){
            //FARM10
            adapter.add(getString(R.string.farm10));
            fuel = fuel+farm10_fuel;
            time = time+farm_time10;










            //LAB10
            adapter.add(getString(R.string.laboratory10));
            fuel = fuel+lab10_fuel;
            food = food+lab10_food;
            steel = steel+lab10_steel;
            alloy = alloy+lab10_alloy;
            time = time+lab10_time;
            //OIL WELL10
            adapter.add(getString(R.string.oil_well10));
            food = food+oil_food10;
            time = time+oil_time10;






















            //ARMED FORCE10
            adapter.add(getString(R.string.armed_forces10));
            fuel = fuel+arm10_fuel;
            food = food+arm10_food;
            steel = steel+arm10_steel;
            alloy = alloy+arm10_alloy;
            time = time+arm10_time;







            //CAFE10
            adapter.add(getString(R.string.cafeteria10));
            fuel = fuel+cafe10_fuel;
            food = food+cafe10_food;
            steel = steel+cafe10_steel;
            alloy = alloy+cafe10_alloy;
            time = time+cafe10_time;







            //CLONE10
            adapter.add(getString(R.string.clone_lab10));
            fuel = fuel+clone10_fuel;
            food = food+clone10_food;
            steel = steel+clone10_steel;
            alloy = alloy+clone10_alloy;
            time = time+clone10_time;
            //COMM. BUILDING10
            adapter.add(getString(R.string.comm_building10));
            fuel = fuel+comm10_fuel;
            food = food+comm10_food;
            steel = steel+comm10_steel;
            alloy = alloy+comm10_alloy;
            time = time+comm10_time;







            //LOGISTICS CENTER10
            adapter.add(getString(R.string.logistics_center10));
            fuel = fuel+logist10_fuel;
            food = food+logist10_food;
            steel = steel+logist10_steel;
            alloy = alloy+logist10_alloy;
            time = time+logist10_time;
            //DORM10
            adapter.add(getString(R.string.dorm10));
            fuel = fuel+dorm10_fuel;
            food = food+dorm10_food;
            steel = steel+dorm10_steel;
            alloy = alloy+dorm10_alloy;
            time = time+dorm10_time;
            //EMBASSY10
            adapter.add(getString(R.string.embassy10));
            fuel = fuel+embassy10_fuel;
            food = food+embassy10_food;
            steel = steel+embassy10_steel;
            alloy = alloy+embassy10_alloy;
            time = time+embassy10_time;







            //MILITARY10
            adapter.add(getString(R.string.military_office10));
            fuel = fuel+military10_fuel;
            food = food+military10_food;
            steel = steel+military10_steel;
            alloy = alloy+military10_alloy;
            time = time+military10_time;







            //SHELTER10
            adapter.add(getString(R.string.shelter10));
            fuel = fuel+shelter10_fuel;
            food = food+shelter10_food;
            steel = steel+shelter10_steel;

            time = time+shelter10_time;
            //STOREROOM10
            adapter.add(getString(R.string.storeroom10));
            fuel = fuel+store10_fuel;
            food = food+store10_food;
            steel = steel+store10_steel;
            alloy = alloy+store10_alloy;
            time = time+store10_time;
            //WALL10
            adapter.add(getString(R.string.wall10));
            fuel = fuel+wall10_fuel;
            food = food+wall10_food;
            steel = steel+wall10_steel;
            alloy = alloy+wall10_alloy;
            time = time+wall10_time;














            //CLINIC10
            adapter.add(getString(R.string.clinic10));
            fuel = fuel+clinic10_fuel;
            food = food+clinic10_food;
            steel = steel+clinic10_steel;
            alloy = alloy+clinic10_alloy;
            time = time+clinic10_time;





















            //MOBILE10
            adapter.add(getString(R.string.mobile_team_factory10));
            fuel = fuel+mobile10_fuel;
            food = food+mobile10_food;
            steel = steel+mobile10_steel;
            alloy = alloy+mobile10_alloy;
            time = time+mobile10_time;



































            //PRISON10
            adapter.add(getString(R.string.prison10));
            fuel = fuel+prison10_fuel;
            food = food+prison10_food;
            steel = steel+prison10_steel;
            alloy = alloy+prison10_alloy;
            time = time+prison10_time;



























































































            //ARMORY10
            adapter.add(getString(R.string.armory10));
            fuel = fuel+armory10_fuel;
            food = food+armory10_food;
            steel = steel+armory10_steel;
            alloy = alloy+armory10_alloy;
            time = time+armory10_time;
            //STEEL_MINE1
            adapter.add(getString(R.string.steel_mill1));
            fuel = fuel+steel_fuel1;
            time = time+steel1_time;
            //STEEL_MINE2
            adapter.add(getString(R.string.steel_mill2));
            fuel = fuel+steel_fuel2;
            time = time+steel2_time;
            //STEEL_MINE3
            adapter.add(getString(R.string.steel_mill3));
            fuel = fuel+steel_fuel3;
            time = time+steel3_time;
            //STEEL_MINE4
            adapter.add(getString(R.string.steel_mill4));
            fuel = fuel+steel_fuel4;
            time = time+steel4_time;
            //STEEL_MINE5
            adapter.add(getString(R.string.steel_mill5));
            fuel = fuel+steel_fuel5;
            time = time+steel5_time;
            //STEEL_MINE6
            adapter.add(getString(R.string.steel_mill6));
            fuel = fuel+steel_fuel6;
            time = time+steel6_time;
            //STEEL_MINE7
            adapter.add(getString(R.string.steel_mill7));
            fuel = fuel+steel_fuel7;
            time = time+steel7_time;
            //STEEL_MINE8
            adapter.add(getString(R.string.steel_mill8));
            fuel = fuel+steel_fuel8;
            time = time+steel8_time;
            //STEEL_MINE9
            adapter.add(getString(R.string.steel_mill9));
            fuel = fuel+steel_fuel9;
            time = time+steel9_time;
            //STEEL_MINE10
            adapter.add(getString(R.string.steel_mill10));
            fuel = fuel+steel_fuel10;
            time = time+steel10_time;
            //TB11
            adapter.add(getString(R.string.teaching_building11));
            fuel = fuel+tb11_fuel;
            food = food+tb11_food;
            steel = steel+tb11_steel;
            alloy = alloy+tb11_alloy;
            time = time+tb11_time;
        }

        if (now <12	&& aim >=12){
            //FARM11
            adapter.add(getString(R.string.farm11));
            fuel = fuel+farm11_fuel;
            time = time+farm_time11;










            //LAB11
            adapter.add(getString(R.string.laboratory11));
            fuel = fuel+lab11_fuel;
            food = food+lab11_food;
            steel = steel+lab11_steel;
            alloy = alloy+lab11_alloy;
            time = time+lab11_time;
            //OIL WELL11
            adapter.add(getString(R.string.oil_well11));
            food = food+oil_food11;
            time = time+oil_time11;






















            //ARMED FORCE11
            adapter.add(getString(R.string.armed_forces11));
            fuel = fuel+arm11_fuel;
            food = food+arm11_food;
            steel = steel+arm11_steel;
            alloy = alloy+arm11_alloy;
            time = time+arm11_time;







            //CAFE11
            adapter.add(getString(R.string.cafeteria11));
            fuel = fuel+cafe11_fuel;
            food = food+cafe11_food;
            steel = steel+cafe11_steel;
            alloy = alloy+cafe11_alloy;
            time = time+cafe11_time;







            //CLONE11
            adapter.add(getString(R.string.clone_lab11));
            fuel = fuel+clone11_fuel;
            food = food+clone11_food;
            steel = steel+clone11_steel;
            alloy = alloy+clone11_alloy;
            time = time+clone11_time;
            //COMM. BUILDING11
            adapter.add(getString(R.string.comm_building11));
            fuel = fuel+comm11_fuel;
            food = food+comm11_food;
            steel = steel+comm11_steel;
            alloy = alloy+comm11_alloy;
            time = time+comm11_time;







            //LOGISTICS CENTER11
            adapter.add(getString(R.string.logistics_center11));
            fuel = fuel+logist11_fuel;
            food = food+logist11_food;
            steel = steel+logist11_steel;
            alloy = alloy+logist11_alloy;
            time = time+logist11_time;
            //DORM11
            adapter.add(getString(R.string.dorm11));
            fuel = fuel+dorm11_fuel;
            food = food+dorm11_food;
            steel = steel+dorm11_steel;
            alloy = alloy+dorm11_alloy;
            time = time+dorm11_time;
            //EMBASSY11
            adapter.add(getString(R.string.embassy11));
            fuel = fuel+embassy11_fuel;
            food = food+embassy11_food;
            steel = steel+embassy11_steel;
            alloy = alloy+embassy11_alloy;
            time = time+embassy11_time;







            //MILITARY11
            adapter.add(getString(R.string.military_office11));
            fuel = fuel+military11_fuel;
            food = food+military11_food;
            steel = steel+military11_steel;
            alloy = alloy+military11_alloy;
            time = time+military11_time;







            //SHELTER11
            adapter.add(getString(R.string.shelter11));
            fuel = fuel+shelter11_fuel;
            food = food+shelter11_food;
            steel = steel+shelter11_steel;

            time = time+shelter11_time;
            //STOREROOM11
            adapter.add(getString(R.string.storeroom11));
            fuel = fuel+store11_fuel;
            food = food+store11_food;
            steel = steel+store11_steel;
            alloy = alloy+store11_alloy;
            time = time+store11_time;
            //WALL11
            adapter.add(getString(R.string.wall11));
            fuel = fuel+wall11_fuel;
            food = food+wall11_food;
            steel = steel+wall11_steel;
            alloy = alloy+wall11_alloy;
            time = time+wall11_time;














            //CLINIC11
            adapter.add(getString(R.string.clinic11));
            fuel = fuel+clinic11_fuel;
            food = food+clinic11_food;
            steel = steel+clinic11_steel;
            alloy = alloy+clinic11_alloy;
            time = time+clinic11_time;





















            //MOBILE11
            adapter.add(getString(R.string.mobile_team_factory11));
            fuel = fuel+mobile11_fuel;
            food = food+mobile11_food;
            steel = steel+mobile11_steel;
            alloy = alloy+mobile11_alloy;
            time = time+mobile11_time;



































            //PRISON11
            adapter.add(getString(R.string.prison11));
            fuel = fuel+prison11_fuel;
            food = food+prison11_food;
            steel = steel+prison11_steel;
            alloy = alloy+prison11_alloy;
            time = time+prison11_time;



























































































            //ARMORY11
            adapter.add(getString(R.string.armory11));
            fuel = fuel+armory11_fuel;
            food = food+armory11_food;
            steel = steel+armory11_steel;
            alloy = alloy+armory11_alloy;
            time = time+armory11_time;




































            //STEEL_MINE11
            adapter.add(getString(R.string.steel_mill11));
            fuel = fuel+steel_fuel11;
            time = time+steel11_time;
            //TB12
            adapter.add(getString(R.string.teaching_building12));
            fuel = fuel+tb12_fuel;
            food = food+tb12_food;
            steel = steel+tb12_steel;
            alloy = alloy+tb12_alloy;
            time = time+tb12_time;
        }

        if (now <13	&& aim >=13){
            //FARM12
            adapter.add(getString(R.string.farm12));
            fuel = fuel+farm12_fuel;
            time = time+farm_time12;










            //LAB12
            adapter.add(getString(R.string.laboratory12));
            fuel = fuel+lab12_fuel;
            food = food+lab12_food;
            steel = steel+lab12_steel;
            alloy = alloy+lab12_alloy;
            time = time+lab12_time;
            //OIL WELL12
            adapter.add(getString(R.string.oil_well12));
            food = food+oil_food12;
            time = time+oil_time12;






















            //ARMED FORCE12
            adapter.add(getString(R.string.armed_forces12));
            fuel = fuel+arm12_fuel;
            food = food+arm12_food;
            steel = steel+arm12_steel;
            alloy = alloy+arm12_alloy;
            time = time+arm12_time;







            //CAFE12
            adapter.add(getString(R.string.cafeteria12));
            fuel = fuel+cafe12_fuel;
            food = food+cafe12_food;
            steel = steel+cafe12_steel;
            alloy = alloy+cafe12_alloy;
            time = time+cafe12_time;







            //CLONE12
            adapter.add(getString(R.string.clone_lab12));
            fuel = fuel+clone12_fuel;
            food = food+clone12_food;
            steel = steel+clone12_steel;
            alloy = alloy+clone12_alloy;
            time = time+clone12_time;
            //COMM. BUILDING12
            adapter.add(getString(R.string.comm_building12));
            fuel = fuel+comm12_fuel;
            food = food+comm12_food;
            steel = steel+comm12_steel;
            alloy = alloy+comm12_alloy;
            time = time+comm12_time;







            //LOGISTICS CENTER12
            adapter.add(getString(R.string.logistics_center12));
            fuel = fuel+logist12_fuel;
            food = food+logist12_food;
            steel = steel+logist12_steel;
            alloy = alloy+logist12_alloy;
            time = time+logist12_time;
            //DORM12
            adapter.add(getString(R.string.dorm12));
            fuel = fuel+dorm12_fuel;
            food = food+dorm12_food;
            steel = steel+dorm12_steel;
            alloy = alloy+dorm12_alloy;
            time = time+dorm12_time;
            //EMBASSY12
            adapter.add(getString(R.string.embassy12));
            fuel = fuel+embassy12_fuel;
            food = food+embassy12_food;
            steel = steel+embassy12_steel;
            alloy = alloy+embassy12_alloy;
            time = time+embassy12_time;







            //MILITARY12
            adapter.add(getString(R.string.military_office12));
            fuel = fuel+military12_fuel;
            food = food+military12_food;
            steel = steel+military12_steel;
            alloy = alloy+military12_alloy;
            time = time+military12_time;







            //SHELTER12
            adapter.add(getString(R.string.shelter12));
            fuel = fuel+shelter12_fuel;
            food = food+shelter12_food;
            steel = steel+shelter12_steel;

            time = time+shelter12_time;
            //STOREROOM12
            adapter.add(getString(R.string.storeroom12));
            fuel = fuel+store12_fuel;
            food = food+store12_food;
            steel = steel+store12_steel;
            alloy = alloy+store12_alloy;
            time = time+store12_time;
            //WALL12
            adapter.add(getString(R.string.wall12));
            fuel = fuel+wall12_fuel;
            food = food+wall12_food;
            steel = steel+wall12_steel;
            alloy = alloy+wall12_alloy;
            time = time+wall12_time;














            //CLINIC12
            adapter.add(getString(R.string.clinic12));
            fuel = fuel+clinic12_fuel;
            food = food+clinic12_food;
            steel = steel+clinic12_steel;
            alloy = alloy+clinic12_alloy;
            time = time+clinic12_time;





















            //MOBILE12
            adapter.add(getString(R.string.mobile_team_factory12));
            fuel = fuel+mobile12_fuel;
            food = food+mobile12_food;
            steel = steel+mobile12_steel;
            alloy = alloy+mobile12_alloy;
            time = time+mobile12_time;



































            //PRISON12
            adapter.add(getString(R.string.prison12));
            fuel = fuel+prison12_fuel;
            food = food+prison12_food;
            steel = steel+prison12_steel;
            alloy = alloy+prison12_alloy;
            time = time+prison12_time;



























































































            //ARMORY12
            adapter.add(getString(R.string.armory12));
            fuel = fuel+armory12_fuel;
            food = food+armory12_food;
            steel = steel+armory12_steel;
            alloy = alloy+armory12_alloy;
            time = time+armory12_time;




































            //STEEL_MINE12
            adapter.add(getString(R.string.steel_mill12));
            fuel = fuel+steel_fuel12;
            time = time+steel12_time;
            //TB13
            adapter.add(getString(R.string.teaching_building13));
            fuel = fuel+tb13_fuel;
            food = food+tb13_food;
            steel = steel+tb13_steel;
            alloy = alloy+tb13_alloy;
            time = time+tb13_time;
        }

        if (now <14	&& aim >=14){
            //FARM13
            adapter.add(getString(R.string.farm13));
            fuel = fuel+farm13_fuel;
            time = time+farm_time13;










            //LAB13
            adapter.add(getString(R.string.laboratory13));
            fuel = fuel+lab13_fuel;
            food = food+lab13_food;
            steel = steel+lab13_steel;
            alloy = alloy+lab13_alloy;
            time = time+lab13_time;
            //OIL WELL13
            adapter.add(getString(R.string.oil_well13));
            food = food+oil_food13;
            time = time+oil_time13;






















            //ARMED FORCE13
            adapter.add(getString(R.string.armed_forces13));
            fuel = fuel+arm13_fuel;
            food = food+arm13_food;
            steel = steel+arm13_steel;
            alloy = alloy+arm13_alloy;
            time = time+arm13_time;







            //CAFE13
            adapter.add(getString(R.string.cafeteria13));
            fuel = fuel+cafe13_fuel;
            food = food+cafe13_food;
            steel = steel+cafe13_steel;
            alloy = alloy+cafe13_alloy;
            time = time+cafe13_time;







            //CLONE13
            adapter.add(getString(R.string.clone_lab13));
            fuel = fuel+clone13_fuel;
            food = food+clone13_food;
            steel = steel+clone13_steel;
            alloy = alloy+clone13_alloy;
            time = time+clone13_time;
            //COMM. BUILDING13
            adapter.add(getString(R.string.comm_building13));
            fuel = fuel+comm13_fuel;
            food = food+comm13_food;
            steel = steel+comm13_steel;
            alloy = alloy+comm13_alloy;
            time = time+comm13_time;







            //LOGISTICS CENTER13
            adapter.add(getString(R.string.logistics_center13));
            fuel = fuel+logist13_fuel;
            food = food+logist13_food;
            steel = steel+logist13_steel;
            alloy = alloy+logist13_alloy;
            time = time+logist13_time;
            //DORM13
            adapter.add(getString(R.string.dorm13));
            fuel = fuel+dorm13_fuel;
            food = food+dorm13_food;
            steel = steel+dorm13_steel;
            alloy = alloy+dorm13_alloy;
            time = time+dorm13_time;
            //EMBASSY13
            adapter.add(getString(R.string.embassy13));
            fuel = fuel+embassy13_fuel;
            food = food+embassy13_food;
            steel = steel+embassy13_steel;
            alloy = alloy+embassy13_alloy;
            time = time+embassy13_time;







            //MILITARY13
            adapter.add(getString(R.string.military_office13));
            fuel = fuel+military13_fuel;
            food = food+military13_food;
            steel = steel+military13_steel;
            alloy = alloy+military13_alloy;
            time = time+military13_time;







            //SHELTER13
            adapter.add(getString(R.string.shelter13));
            fuel = fuel+shelter13_fuel;
            food = food+shelter13_food;
            steel = steel+shelter13_steel;

            time = time+shelter13_time;
            //STOREROOM13
            adapter.add(getString(R.string.storeroom13));
            fuel = fuel+store13_fuel;
            food = food+store13_food;
            steel = steel+store13_steel;
            alloy = alloy+store13_alloy;
            time = time+store13_time;
            //WALL13
            adapter.add(getString(R.string.wall13));
            fuel = fuel+wall13_fuel;
            food = food+wall13_food;
            steel = steel+wall13_steel;
            alloy = alloy+wall13_alloy;
            time = time+wall13_time;














            //CLINIC13
            adapter.add(getString(R.string.clinic13));
            fuel = fuel+clinic13_fuel;
            food = food+clinic13_food;
            steel = steel+clinic13_steel;
            alloy = alloy+clinic13_alloy;
            time = time+clinic13_time;





















            //MOBILE13
            adapter.add(getString(R.string.mobile_team_factory13));
            fuel = fuel+mobile13_fuel;
            food = food+mobile13_food;
            steel = steel+mobile13_steel;
            alloy = alloy+mobile13_alloy;
            time = time+mobile13_time;



































            //PRISON13
            adapter.add(getString(R.string.prison13));
            fuel = fuel+prison13_fuel;
            food = food+prison13_food;
            steel = steel+prison13_steel;
            alloy = alloy+prison13_alloy;
            time = time+prison13_time;



























































































            //ARMORY13
            adapter.add(getString(R.string.armory13));
            fuel = fuel+armory13_fuel;
            food = food+armory13_food;
            steel = steel+armory13_steel;
            alloy = alloy+armory13_alloy;
            time = time+armory13_time;




































            //STEEL_MINE13
            adapter.add(getString(R.string.steel_mill13));
            fuel = fuel+steel_fuel13;
            time = time+steel13_time;
            //TB14
            adapter.add(getString(R.string.teaching_building14));
            fuel = fuel+tb14_fuel;
            food = food+tb14_food;
            steel = steel+tb14_steel;
            alloy = alloy+tb14_alloy;
            time = time+tb14_time;
        }

        if (now <15	&& aim >=15){
            //FARM14
            adapter.add(getString(R.string.farm14));
            fuel = fuel+farm14_fuel;
            time = time+farm_time14;










            //LAB14
            adapter.add(getString(R.string.laboratory14));
            fuel = fuel+lab14_fuel;
            food = food+lab14_food;
            steel = steel+lab14_steel;
            alloy = alloy+lab14_alloy;
            time = time+lab14_time;
            //OIL WELL14
            adapter.add(getString(R.string.oil_well14));
            food = food+oil_food14;
            time = time+oil_time14;






















            //ARMED FORCE14
            adapter.add(getString(R.string.armed_forces14));
            fuel = fuel+arm14_fuel;
            food = food+arm14_food;
            steel = steel+arm14_steel;
            alloy = alloy+arm14_alloy;
            time = time+arm14_time;







            //CAFE14
            adapter.add(getString(R.string.cafeteria14));
            fuel = fuel+cafe14_fuel;
            food = food+cafe14_food;
            steel = steel+cafe14_steel;
            alloy = alloy+cafe14_alloy;
            time = time+cafe14_time;







            //CLONE14
            adapter.add(getString(R.string.clone_lab14));
            fuel = fuel+clone14_fuel;
            food = food+clone14_food;
            steel = steel+clone14_steel;
            alloy = alloy+clone14_alloy;
            time = time+clone14_time;
            //COMM. BUILDING14
            adapter.add(getString(R.string.comm_building14));
            fuel = fuel+comm14_fuel;
            food = food+comm14_food;
            steel = steel+comm14_steel;
            alloy = alloy+comm14_alloy;
            time = time+comm14_time;







            //LOGISTICS CENTER14
            adapter.add(getString(R.string.logistics_center14));
            fuel = fuel+logist14_fuel;
            food = food+logist14_food;
            steel = steel+logist14_steel;
            alloy = alloy+logist14_alloy;
            time = time+logist14_time;
            //DORM14
            adapter.add(getString(R.string.dorm14));
            fuel = fuel+dorm14_fuel;
            food = food+dorm14_food;
            steel = steel+dorm14_steel;
            alloy = alloy+dorm14_alloy;
            time = time+dorm14_time;
            //EMBASSY14
            adapter.add(getString(R.string.embassy14));
            fuel = fuel+embassy14_fuel;
            food = food+embassy14_food;
            steel = steel+embassy14_steel;
            alloy = alloy+embassy14_alloy;
            time = time+embassy14_time;







            //MILITARY14
            adapter.add(getString(R.string.military_office14));
            fuel = fuel+military14_fuel;
            food = food+military14_food;
            steel = steel+military14_steel;
            alloy = alloy+military14_alloy;
            time = time+military14_time;







            //SHELTER14
            adapter.add(getString(R.string.shelter14));
            fuel = fuel+shelter14_fuel;
            food = food+shelter14_food;
            steel = steel+shelter14_steel;

            time = time+shelter14_time;
            //STOREROOM14
            adapter.add(getString(R.string.storeroom14));
            fuel = fuel+store14_fuel;
            food = food+store14_food;
            steel = steel+store14_steel;
            alloy = alloy+store14_alloy;
            time = time+store14_time;
            //WALL14
            adapter.add(getString(R.string.wall14));
            fuel = fuel+wall14_fuel;
            food = food+wall14_food;
            steel = steel+wall14_steel;
            alloy = alloy+wall14_alloy;
            time = time+wall14_time;














            //CLINIC14
            adapter.add(getString(R.string.clinic14));
            fuel = fuel+clinic14_fuel;
            food = food+clinic14_food;
            steel = steel+clinic14_steel;
            alloy = alloy+clinic14_alloy;
            time = time+clinic14_time;





















            //MOBILE14
            adapter.add(getString(R.string.mobile_team_factory14));
            fuel = fuel+mobile14_fuel;
            food = food+mobile14_food;
            steel = steel+mobile14_steel;
            alloy = alloy+mobile14_alloy;
            time = time+mobile14_time;



































            //PRISON14
            adapter.add(getString(R.string.prison14));
            fuel = fuel+prison14_fuel;
            food = food+prison14_food;
            steel = steel+prison14_steel;
            alloy = alloy+prison14_alloy;
            time = time+prison14_time;



























































































            //ARMORY14
            adapter.add(getString(R.string.armory14));
            fuel = fuel+armory14_fuel;
            food = food+armory14_food;
            steel = steel+armory14_steel;
            alloy = alloy+armory14_alloy;
            time = time+armory14_time;




































            //STEEL_MINE14
            adapter.add(getString(R.string.steel_mill14));
            fuel = fuel+steel_fuel14;
            time = time+steel14_time;
            //TB15
            adapter.add(getString(R.string.teaching_building15));
            fuel = fuel+tb15_fuel;
            food = food+tb15_food;
            steel = steel+tb15_steel;
            alloy = alloy+tb15_alloy;
            time = time+tb15_time;
        }

        if (now <16	&& aim >=16){
            //FARM15
            adapter.add(getString(R.string.farm15));
            fuel = fuel+farm15_fuel;
            time = time+farm_time15;










            //LAB15
            adapter.add(getString(R.string.laboratory15));
            fuel = fuel+lab15_fuel;
            food = food+lab15_food;
            steel = steel+lab15_steel;
            alloy = alloy+lab15_alloy;
            time = time+lab15_time;
            //OIL WELL15
            adapter.add(getString(R.string.oil_well15));
            food = food+oil_food15;
            time = time+oil_time15;






















            //ARMED FORCE15
            adapter.add(getString(R.string.armed_forces15));
            fuel = fuel+arm15_fuel;
            food = food+arm15_food;
            steel = steel+arm15_steel;
            alloy = alloy+arm15_alloy;
            time = time+arm15_time;







            //CAFE15
            adapter.add(getString(R.string.cafeteria15));
            fuel = fuel+cafe15_fuel;
            food = food+cafe15_food;
            steel = steel+cafe15_steel;
            alloy = alloy+cafe15_alloy;
            time = time+cafe15_time;







            //CLONE15
            adapter.add(getString(R.string.clone_lab15));
            fuel = fuel+clone15_fuel;
            food = food+clone15_food;
            steel = steel+clone15_steel;
            alloy = alloy+clone15_alloy;
            time = time+clone15_time;
            //COMM. BUILDING15
            adapter.add(getString(R.string.comm_building15));
            fuel = fuel+comm15_fuel;
            food = food+comm15_food;
            steel = steel+comm15_steel;
            alloy = alloy+comm15_alloy;
            time = time+comm15_time;







            //LOGISTICS CENTER15
            adapter.add(getString(R.string.logistics_center15));
            fuel = fuel+logist15_fuel;
            food = food+logist15_food;
            steel = steel+logist15_steel;
            alloy = alloy+logist15_alloy;
            time = time+logist15_time;
            //DORM15
            adapter.add(getString(R.string.dorm15));
            fuel = fuel+dorm15_fuel;
            food = food+dorm15_food;
            steel = steel+dorm15_steel;
            alloy = alloy+dorm15_alloy;
            time = time+dorm15_time;
            //EMBASSY15
            adapter.add(getString(R.string.embassy15));
            fuel = fuel+embassy15_fuel;
            food = food+embassy15_food;
            steel = steel+embassy15_steel;
            alloy = alloy+embassy15_alloy;
            time = time+embassy15_time;







            //MILITARY15
            adapter.add(getString(R.string.military_office15));
            fuel = fuel+military15_fuel;
            food = food+military15_food;
            steel = steel+military15_steel;
            alloy = alloy+military15_alloy;
            time = time+military15_time;







            //SHELTER15
            adapter.add(getString(R.string.shelter15));
            fuel = fuel+shelter15_fuel;
            food = food+shelter15_food;
            steel = steel+shelter15_steel;

            time = time+shelter15_time;
            //STOREROOM15
            adapter.add(getString(R.string.storeroom15));
            fuel = fuel+store15_fuel;
            food = food+store15_food;
            steel = steel+store15_steel;
            alloy = alloy+store15_alloy;
            time = time+store15_time;
            //WALL15
            adapter.add(getString(R.string.wall15));
            fuel = fuel+wall15_fuel;
            food = food+wall15_food;
            steel = steel+wall15_steel;
            alloy = alloy+wall15_alloy;
            time = time+wall15_time;














            //CLINIC15
            adapter.add(getString(R.string.clinic15));
            fuel = fuel+clinic15_fuel;
            food = food+clinic15_food;
            steel = steel+clinic15_steel;
            alloy = alloy+clinic15_alloy;
            time = time+clinic15_time;





















            //MOBILE15
            adapter.add(getString(R.string.mobile_team_factory15));
            fuel = fuel+mobile15_fuel;
            food = food+mobile15_food;
            steel = steel+mobile15_steel;
            alloy = alloy+mobile15_alloy;
            time = time+mobile15_time;



































            //PRISON15
            adapter.add(getString(R.string.prison15));
            fuel = fuel+prison15_fuel;
            food = food+prison15_food;
            steel = steel+prison15_steel;
            alloy = alloy+prison15_alloy;
            time = time+prison15_time;



























































































            //ARMORY15
            adapter.add(getString(R.string.armory15));
            fuel = fuel+armory15_fuel;
            food = food+armory15_food;
            steel = steel+armory15_steel;
            alloy = alloy+armory15_alloy;
            time = time+armory15_time;




































            //STEEL_MINE15
            adapter.add(getString(R.string.steel_mill15));
            fuel = fuel+steel_fuel15;
            time = time+steel15_time;
            //ALLOY_MILL1
            adapter.add(getString(R.string.alloy_mine1));
            fuel = fuel+alloy_m1_fuel;
            time = time+alloy_m1_time;
            //ALLOY_MILL2
            adapter.add(getString(R.string.alloy_mine2));
            fuel = fuel+alloy_m2_fuel;
            time = time+alloy_m2_time;
            //ALLOY_MILL3
            adapter.add(getString(R.string.alloy_mine3));
            fuel = fuel+alloy_m3_fuel;
            time = time+alloy_m3_time;
            //ALLOY_MILL4
            adapter.add(getString(R.string.alloy_mine4));
            fuel = fuel+alloy_m4_fuel;
            time = time+alloy_m4_time;
            //ALLOY_MILL5
            adapter.add(getString(R.string.alloy_mine5));
            fuel = fuel+alloy_m5_fuel;
            time = time+alloy_m5_time;
            //ALLOY_MILL6
            adapter.add(getString(R.string.alloy_mine6));
            fuel = fuel+alloy_m6_fuel;
            time = time+alloy_m6_time;
            //ALLOY_MILL7
            adapter.add(getString(R.string.alloy_mine7));
            fuel = fuel+alloy_m7_fuel;
            time = time+alloy_m7_time;
            //ALLOY_MILL8
            adapter.add(getString(R.string.alloy_mine8));
            fuel = fuel+alloy_m8_fuel;
            time = time+alloy_m8_time;
            //ALLOY_MILL9
            adapter.add(getString(R.string.alloy_mine9));
            fuel = fuel+alloy_m9_fuel;
            time = time+alloy_m9_time;
            //ALLOY_MILL10
            adapter.add(getString(R.string.alloy_mine10));
            fuel = fuel+alloy_m10_fuel;
            time = time+alloy_m10_time;
            //ALLOY_MILL11
            adapter.add(getString(R.string.alloy_mine11));
            fuel = fuel+alloy_m11_fuel;
            time = time+alloy_m11_time;
            //ALLOY_MILL12
            adapter.add(getString(R.string.alloy_mine12));
            fuel = fuel+alloy_m12_fuel;
            time = time+alloy_m12_time;
            //ALLOY_MILL13
            adapter.add(getString(R.string.alloy_mine13));
            fuel = fuel+alloy_m13_fuel;
            time = time+alloy_m13_time;
            //ALLOY_MILL14
            adapter.add(getString(R.string.alloy_mine14));
            fuel = fuel+alloy_m14_fuel;
            time = time+alloy_m14_time;
            //ALLOY_MILL15
            adapter.add(getString(R.string.alloy_mine15));
            fuel = fuel+alloy_m15_fuel;
            time = time+alloy_m15_time;
            //TB16
            adapter.add(getString(R.string.teaching_building16));
            fuel = fuel+tb16_fuel;
            food = food+tb16_food;
            steel = steel+tb16_steel;
            alloy = alloy+tb16_alloy;
            time = time+tb16_time;
        }

        if (now <17	&& aim >=17){
            //FARM16
            adapter.add(getString(R.string.farm16));
            fuel = fuel+farm16_fuel;
            time = time+farm_time16;










            //LAB16
            adapter.add(getString(R.string.laboratory16));
            fuel = fuel+lab16_fuel;
            food = food+lab16_food;
            steel = steel+lab16_steel;
            alloy = alloy+lab16_alloy;
            time = time+lab16_time;
            //OIL WELL16
            adapter.add(getString(R.string.oil_well16));
            food = food+oil_food16;
            time = time+oil_time16;






















            //ARMED FORCE16
            adapter.add(getString(R.string.armed_forces16));
            fuel = fuel+arm16_fuel;
            food = food+arm16_food;
            steel = steel+arm16_steel;
            alloy = alloy+arm16_alloy;
            time = time+arm16_time;







            //CAFE16
            adapter.add(getString(R.string.cafeteria16));
            fuel = fuel+cafe16_fuel;
            food = food+cafe16_food;
            steel = steel+cafe16_steel;
            alloy = alloy+cafe16_alloy;
            time = time+cafe16_time;







            //CLONE16
            adapter.add(getString(R.string.clone_lab16));
            fuel = fuel+clone16_fuel;
            food = food+clone16_food;
            steel = steel+clone16_steel;
            alloy = alloy+clone16_alloy;
            time = time+clone16_time;
            //COMM. BUILDING16
            adapter.add(getString(R.string.comm_building16));
            fuel = fuel+comm16_fuel;
            food = food+comm16_food;
            steel = steel+comm16_steel;
            alloy = alloy+comm16_alloy;
            time = time+comm16_time;







            //LOGISTICS CENTER16
            adapter.add(getString(R.string.logistics_center16));
            fuel = fuel+logist16_fuel;
            food = food+logist16_food;
            steel = steel+logist16_steel;
            alloy = alloy+logist16_alloy;
            time = time+logist16_time;
            //DORM16
            adapter.add(getString(R.string.dorm16));
            fuel = fuel+dorm16_fuel;
            food = food+dorm16_food;
            steel = steel+dorm16_steel;
            alloy = alloy+dorm16_alloy;
            time = time+dorm16_time;
            //EMBASSY16
            adapter.add(getString(R.string.embassy16));
            fuel = fuel+embassy16_fuel;
            food = food+embassy16_food;
            steel = steel+embassy16_steel;
            alloy = alloy+embassy16_alloy;
            time = time+embassy16_time;







            //MILITARY16
            adapter.add(getString(R.string.military_office16));
            fuel = fuel+military16_fuel;
            food = food+military16_food;
            steel = steel+military16_steel;
            alloy = alloy+military16_alloy;
            time = time+military16_time;







            //SHELTER16
            adapter.add(getString(R.string.shelter16));
            fuel = fuel+shelter16_fuel;
            food = food+shelter16_food;
            steel = steel+shelter16_steel;

            time = time+shelter16_time;
            //STOREROOM16
            adapter.add(getString(R.string.storeroom16));
            fuel = fuel+store16_fuel;
            food = food+store16_food;
            steel = steel+store16_steel;
            alloy = alloy+store16_alloy;
            time = time+store16_time;
            //WALL16
            adapter.add(getString(R.string.wall16));
            fuel = fuel+wall16_fuel;
            food = food+wall16_food;
            steel = steel+wall16_steel;
            alloy = alloy+wall16_alloy;
            time = time+wall16_time;














            //CLINIC16
            adapter.add(getString(R.string.clinic16));
            fuel = fuel+clinic16_fuel;
            food = food+clinic16_food;
            steel = steel+clinic16_steel;
            alloy = alloy+clinic16_alloy;
            time = time+clinic16_time;





















            //MOBILE16
            adapter.add(getString(R.string.mobile_team_factory16));
            fuel = fuel+mobile16_fuel;
            food = food+mobile16_food;
            steel = steel+mobile16_steel;
            alloy = alloy+mobile16_alloy;
            time = time+mobile16_time;



































            //PRISON16
            adapter.add(getString(R.string.prison16));
            fuel = fuel+prison16_fuel;
            food = food+prison16_food;
            steel = steel+prison16_steel;
            alloy = alloy+prison16_alloy;
            time = time+prison16_time;



























































































            //ARMORY16
            adapter.add(getString(R.string.armory16));
            fuel = fuel+armory16_fuel;
            food = food+armory16_food;
            steel = steel+armory16_steel;
            alloy = alloy+armory16_alloy;
            time = time+armory16_time;




































            //STEEL_MINE16
            adapter.add(getString(R.string.steel_mill16));
            fuel = fuel+steel_fuel16;
            time = time+steel16_time;
            //ALLOY_MILL16
            adapter.add(getString(R.string.alloy_mine16));
            fuel = fuel+alloy_m16_fuel;
            time = time+alloy_m16_time;
            //TB17
            adapter.add(getString(R.string.teaching_building17));
            fuel = fuel+tb17_fuel;
            food = food+tb17_food;
            steel = steel+tb17_steel;
            alloy = alloy+tb17_alloy;
            time = time+tb17_time;
        }

        if (now <18	&& aim >=18){
            //FARM17
            adapter.add(getString(R.string.farm17));
            fuel = fuel+farm17_fuel;
            time = time+farm_time17;










            //LAB17
            adapter.add(getString(R.string.laboratory17));
            fuel = fuel+lab17_fuel;
            food = food+lab17_food;
            steel = steel+lab17_steel;
            alloy = alloy+lab17_alloy;
            time = time+lab17_time;
            //OIL WELL17
            adapter.add(getString(R.string.oil_well17));
            food = food+oil_food17;
            time = time+oil_time17;






















            //ARMED FORCE17
            adapter.add(getString(R.string.armed_forces17));
            fuel = fuel+arm17_fuel;
            food = food+arm17_food;
            steel = steel+arm17_steel;
            alloy = alloy+arm17_alloy;
            time = time+arm17_time;







            //CAFE17
            adapter.add(getString(R.string.cafeteria17));
            fuel = fuel+cafe17_fuel;
            food = food+cafe17_food;
            steel = steel+cafe17_steel;
            alloy = alloy+cafe17_alloy;
            time = time+cafe17_time;







            //CLONE17
            adapter.add(getString(R.string.clone_lab17));
            fuel = fuel+clone17_fuel;
            food = food+clone17_food;
            steel = steel+clone17_steel;
            alloy = alloy+clone17_alloy;
            time = time+clone17_time;
            //COMM. BUILDING17
            adapter.add(getString(R.string.comm_building17));
            fuel = fuel+comm17_fuel;
            food = food+comm17_food;
            steel = steel+comm17_steel;
            alloy = alloy+comm17_alloy;
            time = time+comm17_time;







            //LOGISTICS CENTER17
            adapter.add(getString(R.string.logistics_center17));
            fuel = fuel+logist17_fuel;
            food = food+logist17_food;
            steel = steel+logist17_steel;
            alloy = alloy+logist17_alloy;
            time = time+logist17_time;
            //DORM17
            adapter.add(getString(R.string.dorm17));
            fuel = fuel+dorm17_fuel;
            food = food+dorm17_food;
            steel = steel+dorm17_steel;
            alloy = alloy+dorm17_alloy;
            time = time+dorm17_time;
            //EMBASSY17
            adapter.add(getString(R.string.embassy17));
            fuel = fuel+embassy17_fuel;
            food = food+embassy17_food;
            steel = steel+embassy17_steel;
            alloy = alloy+embassy17_alloy;
            time = time+embassy17_time;







            //MILITARY17
            adapter.add(getString(R.string.military_office17));
            fuel = fuel+military17_fuel;
            food = food+military17_food;
            steel = steel+military17_steel;
            alloy = alloy+military17_alloy;
            time = time+military17_time;







            //SHELTER17
            adapter.add(getString(R.string.shelter17));
            fuel = fuel+shelter17_fuel;
            food = food+shelter17_food;
            steel = steel+shelter17_steel;

            time = time+shelter17_time;
            //STOREROOM17
            adapter.add(getString(R.string.storeroom17));
            fuel = fuel+store17_fuel;
            food = food+store17_food;
            steel = steel+store17_steel;
            alloy = alloy+store17_alloy;
            time = time+store17_time;
            //WALL17
            adapter.add(getString(R.string.wall17));
            fuel = fuel+wall17_fuel;
            food = food+wall17_food;
            steel = steel+wall17_steel;
            alloy = alloy+wall17_alloy;
            time = time+wall17_time;














            //CLINIC17
            adapter.add(getString(R.string.clinic17));
            fuel = fuel+clinic17_fuel;
            food = food+clinic17_food;
            steel = steel+clinic17_steel;
            alloy = alloy+clinic17_alloy;
            time = time+clinic17_time;





















            //MOBILE17
            adapter.add(getString(R.string.mobile_team_factory17));
            fuel = fuel+mobile17_fuel;
            food = food+mobile17_food;
            steel = steel+mobile17_steel;
            alloy = alloy+mobile17_alloy;
            time = time+mobile17_time;



































            //PRISON17
            adapter.add(getString(R.string.prison17));
            fuel = fuel+prison17_fuel;
            food = food+prison17_food;
            steel = steel+prison17_steel;
            alloy = alloy+prison17_alloy;
            time = time+prison17_time;



























































































            //ARMORY17
            adapter.add(getString(R.string.armory17));
            fuel = fuel+armory17_fuel;
            food = food+armory17_food;
            steel = steel+armory17_steel;
            alloy = alloy+armory17_alloy;
            time = time+armory17_time;




































            //STEEL_MINE17
            adapter.add(getString(R.string.steel_mill17));
            fuel = fuel+steel_fuel17;
            time = time+steel17_time;
            //ALLOY_MILL17
            adapter.add(getString(R.string.alloy_mine17));
            fuel = fuel+alloy_m17_fuel;
            time = time+alloy_m17_time;
            //TB18
            adapter.add(getString(R.string.teaching_building18));
            fuel = fuel+tb18_fuel;
            food = food+tb18_food;
            steel = steel+tb18_steel;
            alloy = alloy+tb18_alloy;
            time = time+tb18_time;
        }

        if (now <19	&& aim >=19){
            //FARM18
            adapter.add(getString(R.string.farm18));
            fuel = fuel+farm18_fuel;
            time = time+farm_time18;










            //LAB18
            adapter.add(getString(R.string.laboratory18));
            fuel = fuel+lab18_fuel;
            food = food+lab18_food;
            steel = steel+lab18_steel;
            alloy = alloy+lab18_alloy;
            time = time+lab18_time;
            //OIL WELL18
            adapter.add(getString(R.string.oil_well18));
            food = food+oil_food18;
            time = time+oil_time18;






















            //ARMED FORCE18
            adapter.add(getString(R.string.armed_forces18));
            fuel = fuel+arm18_fuel;
            food = food+arm18_food;
            steel = steel+arm18_steel;
            alloy = alloy+arm18_alloy;
            time = time+arm18_time;







            //CAFE18
            adapter.add(getString(R.string.cafeteria18));
            fuel = fuel+cafe18_fuel;
            food = food+cafe18_food;
            steel = steel+cafe18_steel;
            alloy = alloy+cafe18_alloy;
            time = time+cafe18_time;







            //CLONE18
            adapter.add(getString(R.string.clone_lab18));
            fuel = fuel+clone18_fuel;
            food = food+clone18_food;
            steel = steel+clone18_steel;
            alloy = alloy+clone18_alloy;
            time = time+clone18_time;
            //COMM. BUILDING18
            adapter.add(getString(R.string.comm_building18));
            fuel = fuel+comm18_fuel;
            food = food+comm18_food;
            steel = steel+comm18_steel;
            alloy = alloy+comm18_alloy;
            time = time+comm18_time;







            //LOGISTICS CENTER18
            adapter.add(getString(R.string.logistics_center18));
            fuel = fuel+logist18_fuel;
            food = food+logist18_food;
            steel = steel+logist18_steel;
            alloy = alloy+logist18_alloy;
            time = time+logist18_time;
            //DORM18
            adapter.add(getString(R.string.dorm18));
            fuel = fuel+dorm18_fuel;
            food = food+dorm18_food;
            steel = steel+dorm18_steel;
            alloy = alloy+dorm18_alloy;
            time = time+dorm18_time;
            //EMBASSY18
            adapter.add(getString(R.string.embassy18));
            fuel = fuel+embassy18_fuel;
            food = food+embassy18_food;
            steel = steel+embassy18_steel;
            alloy = alloy+embassy18_alloy;
            time = time+embassy18_time;







            //MILITARY18
            adapter.add(getString(R.string.military_office18));
            fuel = fuel+military18_fuel;
            food = food+military18_food;
            steel = steel+military18_steel;
            alloy = alloy+military18_alloy;
            time = time+military18_time;







            //SHELTER18
            adapter.add(getString(R.string.shelter18));
            fuel = fuel+shelter18_fuel;
            food = food+shelter18_food;
            steel = steel+shelter18_steel;

            time = time+shelter18_time;
            //STOREROOM18
            adapter.add(getString(R.string.storeroom18));
            fuel = fuel+store18_fuel;
            food = food+store18_food;
            steel = steel+store18_steel;
            alloy = alloy+store18_alloy;
            time = time+store18_time;
            //WALL18
            adapter.add(getString(R.string.wall18));
            fuel = fuel+wall18_fuel;
            food = food+wall18_food;
            steel = steel+wall18_steel;
            alloy = alloy+wall18_alloy;
            time = time+wall18_time;














            //CLINIC18
            adapter.add(getString(R.string.clinic18));
            fuel = fuel+clinic18_fuel;
            food = food+clinic18_food;
            steel = steel+clinic18_steel;
            alloy = alloy+clinic18_alloy;
            time = time+clinic18_time;





















            //MOBILE18
            adapter.add(getString(R.string.mobile_team_factory18));
            fuel = fuel+mobile18_fuel;
            food = food+mobile18_food;
            steel = steel+mobile18_steel;
            alloy = alloy+mobile18_alloy;
            time = time+mobile18_time;



































            //PRISON18
            adapter.add(getString(R.string.prison18));
            fuel = fuel+prison18_fuel;
            food = food+prison18_food;
            steel = steel+prison18_steel;
            alloy = alloy+prison18_alloy;
            time = time+prison18_time;



























































































            //ARMORY18
            adapter.add(getString(R.string.armory18));
            fuel = fuel+armory18_fuel;
            food = food+armory18_food;
            steel = steel+armory18_steel;
            alloy = alloy+armory18_alloy;
            time = time+armory18_time;




































            //STEEL_MINE18
            adapter.add(getString(R.string.steel_mill18));
            fuel = fuel+steel_fuel18;
            time = time+steel18_time;
























































            //ALLOY_MILL18
            adapter.add(getString(R.string.alloy_mine18));
            fuel = fuel+alloy_m18_fuel;
            time = time+alloy_m18_time;
            //TB19
            adapter.add(getString(R.string.teaching_building19));
            fuel = fuel+tb19_fuel;
            food = food+tb19_food;
            steel = steel+tb19_steel;
            alloy = alloy+tb19_alloy;
            time = time+tb19_time;
        }

        if (now <20	&& aim >=20){
            //FARM19
            adapter.add(getString(R.string.farm19));
            fuel = fuel+farm19_fuel;
            time = time+farm_time19;










            //LAB19
            adapter.add(getString(R.string.laboratory19));
            fuel = fuel+lab19_fuel;
            food = food+lab19_food;
            steel = steel+lab19_steel;
            alloy = alloy+lab19_alloy;
            time = time+lab19_time;
            //OIL WELL19
            adapter.add(getString(R.string.oil_well19));
            food = food+oil_food19;
            time = time+oil_time19;






















            //ARMED FORCE19
            adapter.add(getString(R.string.armed_forces19));
            fuel = fuel+arm19_fuel;
            food = food+arm19_food;
            steel = steel+arm19_steel;
            alloy = alloy+arm19_alloy;
            time = time+arm19_time;







            //CAFE19
            adapter.add(getString(R.string.cafeteria19));
            fuel = fuel+cafe19_fuel;
            food = food+cafe19_food;
            steel = steel+cafe19_steel;
            alloy = alloy+cafe19_alloy;
            time = time+cafe19_time;







            //CLONE19
            adapter.add(getString(R.string.clone_lab19));
            fuel = fuel+clone19_fuel;
            food = food+clone19_food;
            steel = steel+clone19_steel;
            alloy = alloy+clone19_alloy;
            time = time+clone19_time;
            //COMM. BUILDING19
            adapter.add(getString(R.string.comm_building19));
            fuel = fuel+comm19_fuel;
            food = food+comm19_food;
            steel = steel+comm19_steel;
            alloy = alloy+comm19_alloy;
            time = time+comm19_time;







            //LOGISTICS CENTER19
            adapter.add(getString(R.string.logistics_center19));
            fuel = fuel+logist19_fuel;
            food = food+logist19_food;
            steel = steel+logist19_steel;
            alloy = alloy+logist19_alloy;
            time = time+logist19_time;
            //DORM19
            adapter.add(getString(R.string.dorm19));
            fuel = fuel+dorm19_fuel;
            food = food+dorm19_food;
            steel = steel+dorm19_steel;
            alloy = alloy+dorm19_alloy;
            time = time+dorm19_time;
            //EMBASSY19
            adapter.add(getString(R.string.embassy19));
            fuel = fuel+embassy19_fuel;
            food = food+embassy19_food;
            steel = steel+embassy19_steel;
            alloy = alloy+embassy19_alloy;
            time = time+embassy19_time;







            //MILITARY19
            adapter.add(getString(R.string.military_office19));
            fuel = fuel+military19_fuel;
            food = food+military19_food;
            steel = steel+military19_steel;
            alloy = alloy+military19_alloy;
            time = time+military19_time;







            //SHELTER19
            adapter.add(getString(R.string.shelter19));
            fuel = fuel+shelter19_fuel;
            food = food+shelter19_food;
            steel = steel+shelter19_steel;

            time = time+shelter19_time;
            //STOREROOM19
            adapter.add(getString(R.string.storeroom19));
            fuel = fuel+store19_fuel;
            food = food+store19_food;
            steel = steel+store19_steel;
            alloy = alloy+store19_alloy;
            time = time+store19_time;
            //WALL19
            adapter.add(getString(R.string.wall19));
            fuel = fuel+wall19_fuel;
            food = food+wall19_food;
            steel = steel+wall19_steel;
            alloy = alloy+wall19_alloy;
            time = time+wall19_time;














            //CLINIC19
            adapter.add(getString(R.string.clinic19));
            fuel = fuel+clinic19_fuel;
            food = food+clinic19_food;
            steel = steel+clinic19_steel;
            alloy = alloy+clinic19_alloy;
            time = time+clinic19_time;





















            //MOBILE19
            adapter.add(getString(R.string.mobile_team_factory19));
            fuel = fuel+mobile19_fuel;
            food = food+mobile19_food;
            steel = steel+mobile19_steel;
            alloy = alloy+mobile19_alloy;
            time = time+mobile19_time;



































            //PRISON19
            adapter.add(getString(R.string.prison19));
            fuel = fuel+prison19_fuel;
            food = food+prison19_food;
            steel = steel+prison19_steel;
            alloy = alloy+prison19_alloy;
            time = time+prison19_time;



























































































            //ARMORY19
            adapter.add(getString(R.string.armory19));
            fuel = fuel+armory19_fuel;
            food = food+armory19_food;
            steel = steel+armory19_steel;
            alloy = alloy+armory19_alloy;
            time = time+armory19_time;




































            //STEEL_MINE19
            adapter.add(getString(R.string.steel_mill19));
            fuel = fuel+steel_fuel19;
            time = time+steel19_time;
























































            //ALLOY_MILL19
            adapter.add(getString(R.string.alloy_mine19));
            fuel = fuel+alloy_m19_fuel;
            time = time+alloy_m19_time;
            //TB20
            adapter.add(getString(R.string.teaching_building20));
            fuel = fuel+tb20_fuel;
            food = food+tb20_food;
            steel = steel+tb20_steel;
            alloy = alloy+tb20_alloy;
            time = time+tb20_time;
        }

        if (now <21	&& aim >=21){
            //FARM20
            adapter.add(getString(R.string.farm20));
            fuel = fuel+farm20_fuel;
            time = time+farm_time20;










            //LAB20
            adapter.add(getString(R.string.laboratory20));
            fuel = fuel+lab20_fuel;
            food = food+lab20_food;
            steel = steel+lab20_steel;
            alloy = alloy+lab20_alloy;
            time = time+lab20_time;
            //OIL WELL20
            adapter.add(getString(R.string.oil_well20));
            food = food+oil_food20;
            time = time+oil_time20;






















            //ARMED FORCE20
            adapter.add(getString(R.string.armed_forces20));
            fuel = fuel+arm20_fuel;
            food = food+arm20_food;
            steel = steel+arm20_steel;
            alloy = alloy+arm20_alloy;
            time = time+arm20_time;







            //CAFE20
            adapter.add(getString(R.string.cafeteria20));
            fuel = fuel+cafe20_fuel;
            food = food+cafe20_food;
            steel = steel+cafe20_steel;
            alloy = alloy+cafe20_alloy;
            time = time+cafe20_time;







            //CLONE20
            adapter.add(getString(R.string.clone_lab20));
            fuel = fuel+clone20_fuel;
            food = food+clone20_food;
            steel = steel+clone20_steel;
            alloy = alloy+clone20_alloy;
            time = time+clone20_time;
            //COMM. BUILDING20
            adapter.add(getString(R.string.comm_building20));
            fuel = fuel+comm20_fuel;
            food = food+comm20_food;
            steel = steel+comm20_steel;
            alloy = alloy+comm20_alloy;
            time = time+comm20_time;







            //LOGISTICS CENTER20
            adapter.add(getString(R.string.logistics_center20));
            fuel = fuel+logist20_fuel;
            food = food+logist20_food;
            steel = steel+logist20_steel;
            alloy = alloy+logist20_alloy;
            time = time+logist20_time;
            //DORM20
            adapter.add(getString(R.string.dorm20));
            fuel = fuel+dorm20_fuel;
            food = food+dorm20_food;
            steel = steel+dorm20_steel;
            alloy = alloy+dorm20_alloy;
            time = time+dorm20_time;
            //EMBASSY20
            adapter.add(getString(R.string.embassy20));
            fuel = fuel+embassy20_fuel;
            food = food+embassy20_food;
            steel = steel+embassy20_steel;
            alloy = alloy+embassy20_alloy;
            time = time+embassy20_time;







            //MILITARY20
            adapter.add(getString(R.string.military_office20));
            fuel = fuel+military20_fuel;
            food = food+military20_food;
            steel = steel+military20_steel;
            alloy = alloy+military20_alloy;
            time = time+military20_time;







            //SHELTER20
            adapter.add(getString(R.string.shelter20));
            fuel = fuel+shelter20_fuel;
            food = food+shelter20_food;
            steel = steel+shelter20_steel;

            time = time+shelter20_time;
            //STOREROOM20
            adapter.add(getString(R.string.storeroom20));
            fuel = fuel+store20_fuel;
            food = food+store20_food;
            steel = steel+store20_steel;
            alloy = alloy+store20_alloy;
            time = time+store20_time;
            //WALL20
            adapter.add(getString(R.string.wall20));
            fuel = fuel+wall20_fuel;
            food = food+wall20_food;
            steel = steel+wall20_steel;
            alloy = alloy+wall20_alloy;
            time = time+wall20_time;














            //CLINIC20
            adapter.add(getString(R.string.clinic20));
            fuel = fuel+clinic20_fuel;
            food = food+clinic20_food;
            steel = steel+clinic20_steel;
            alloy = alloy+clinic20_alloy;
            time = time+clinic20_time;





















            //MOBILE20
            adapter.add(getString(R.string.mobile_team_factory20));
            fuel = fuel+mobile20_fuel;
            food = food+mobile20_food;
            steel = steel+mobile20_steel;
            alloy = alloy+mobile20_alloy;
            time = time+mobile20_time;



































            //PRISON20
            adapter.add(getString(R.string.prison20));
            fuel = fuel+prison20_fuel;
            food = food+prison20_food;
            steel = steel+prison20_steel;
            alloy = alloy+prison20_alloy;
            time = time+prison20_time;



























































































            //ARMORY20
            adapter.add(getString(R.string.armory20));
            fuel = fuel+armory20_fuel;
            food = food+armory20_food;
            steel = steel+armory20_steel;
            alloy = alloy+armory20_alloy;
            time = time+armory20_time;




































            //STEEL_MINE20
            adapter.add(getString(R.string.steel_mill20));
            fuel = fuel+steel_fuel20;
            time = time+steel20_time;
























































            //ALLOY_MILL20
            adapter.add(getString(R.string.alloy_mine20));
            fuel = fuel+alloy_m20_fuel;
            time = time+alloy_m20_time;
            //TB21
            adapter.add(getString(R.string.teaching_building21));
            fuel = fuel+tb21_fuel;
            food = food+tb21_food;
            steel = steel+tb21_steel;
            alloy = alloy+tb21_alloy;
            time = time+tb21_time;
        }

        if (now <22	&& aim >=22){
            //FARM21
            adapter.add(getString(R.string.farm21));
            fuel = fuel+farm21_fuel;
            time = time+farm_time21;










            //LAB21
            adapter.add(getString(R.string.laboratory21));
            fuel = fuel+lab21_fuel;
            food = food+lab21_food;
            steel = steel+lab21_steel;
            alloy = alloy+lab21_alloy;
            time = time+lab21_time;
            //OIL WELL21
            adapter.add(getString(R.string.oil_well21));
            food = food+oil_food21;
            time = time+oil_time21;






















            //ARMED FORCE21
            adapter.add(getString(R.string.armed_forces21));
            fuel = fuel+arm21_fuel;
            food = food+arm21_food;
            steel = steel+arm21_steel;
            alloy = alloy+arm21_alloy;
            time = time+arm21_time;







            //CAFE21
            adapter.add(getString(R.string.cafeteria21));
            fuel = fuel+cafe21_fuel;
            food = food+cafe21_food;
            steel = steel+cafe21_steel;
            alloy = alloy+cafe21_alloy;
            time = time+cafe21_time;







            //CLONE21
            adapter.add(getString(R.string.clone_lab21));
            fuel = fuel+clone21_fuel;
            food = food+clone21_food;
            steel = steel+clone21_steel;
            alloy = alloy+clone21_alloy;
            time = time+clone21_time;
            //COMM. BUILDING21
            adapter.add(getString(R.string.comm_building21));
            fuel = fuel+comm21_fuel;
            food = food+comm21_food;
            steel = steel+comm21_steel;
            alloy = alloy+comm21_alloy;
            time = time+comm21_time;







            //LOGISTICS CENTER21
            adapter.add(getString(R.string.logistics_center21));
            fuel = fuel+logist21_fuel;
            food = food+logist21_food;
            steel = steel+logist21_steel;
            alloy = alloy+logist21_alloy;
            time = time+logist21_time;
            //DORM21
            adapter.add(getString(R.string.dorm21));
            fuel = fuel+dorm21_fuel;
            food = food+dorm21_food;
            steel = steel+dorm21_steel;
            alloy = alloy+dorm21_alloy;
            time = time+dorm21_time;
            //EMBASSY21
            adapter.add(getString(R.string.embassy21));
            fuel = fuel+embassy21_fuel;
            food = food+embassy21_food;
            steel = steel+embassy21_steel;
            alloy = alloy+embassy21_alloy;
            time = time+embassy21_time;







            //MILITARY21
            adapter.add(getString(R.string.military_office21));
            fuel = fuel+military21_fuel;
            food = food+military21_food;
            steel = steel+military21_steel;
            alloy = alloy+military21_alloy;
            time = time+military21_time;







            //SHELTER21
            adapter.add(getString(R.string.shelter21));
            fuel = fuel+shelter21_fuel;
            food = food+shelter21_food;
            steel = steel+shelter21_steel;

            time = time+shelter21_time;
            //STOREROOM21
            adapter.add(getString(R.string.storeroom21));
            fuel = fuel+store21_fuel;
            food = food+store21_food;
            steel = steel+store21_steel;
            alloy = alloy+store21_alloy;
            time = time+store21_time;
            //WALL21
            adapter.add(getString(R.string.wall21));
            fuel = fuel+wall21_fuel;
            food = food+wall21_food;
            steel = steel+wall21_steel;
            alloy = alloy+wall21_alloy;
            time = time+wall21_time;














            //CLINIC21
            adapter.add(getString(R.string.clinic21));
            fuel = fuel+clinic21_fuel;
            food = food+clinic21_food;
            steel = steel+clinic21_steel;
            alloy = alloy+clinic21_alloy;
            time = time+clinic21_time;





















            //MOBILE21
            adapter.add(getString(R.string.mobile_team_factory21));
            fuel = fuel+mobile21_fuel;
            food = food+mobile21_food;
            steel = steel+mobile21_steel;
            alloy = alloy+mobile21_alloy;
            time = time+mobile21_time;



































            //PRISON21
            adapter.add(getString(R.string.prison21));
            fuel = fuel+prison21_fuel;
            food = food+prison21_food;
            steel = steel+prison21_steel;
            alloy = alloy+prison21_alloy;
            time = time+prison21_time;



























































































            //ARMORY21
            adapter.add(getString(R.string.armory21));
            fuel = fuel+armory21_fuel;
            food = food+armory21_food;
            steel = steel+armory21_steel;
            alloy = alloy+armory21_alloy;
            time = time+armory21_time;




































            //STEEL_MINE21
            adapter.add(getString(R.string.steel_mill21));
            fuel = fuel+steel_fuel21;
            time = time+steel21_time;
























































            //ALLOY_MILL21
            adapter.add(getString(R.string.alloy_mine21));
            fuel = fuel+alloy_m21_fuel;
            time = time+alloy_m21_time;
            //TB22
            adapter.add(getString(R.string.teaching_building22));
            fuel = fuel+tb22_fuel;
            food = food+tb22_food;
            steel = steel+tb22_steel;
            alloy = alloy+tb22_alloy;
            time = time+tb22_time;
        }

        if (now <23	&& aim >=23){
            //FARM22
            adapter.add(getString(R.string.farm22));
            fuel = fuel+farm22_fuel;
            time = time+farm_time22;










            //LAB22
            adapter.add(getString(R.string.laboratory22));
            fuel = fuel+lab22_fuel;
            food = food+lab22_food;
            steel = steel+lab22_steel;
            alloy = alloy+lab22_alloy;
            time = time+lab22_time;
            //OIL WELL22
            adapter.add(getString(R.string.oil_well22));
            food = food+oil_food22;
            time = time+oil_time22;






















            //ARMED FORCE22
            adapter.add(getString(R.string.armed_forces22));
            fuel = fuel+arm22_fuel;
            food = food+arm22_food;
            steel = steel+arm22_steel;
            alloy = alloy+arm22_alloy;
            time = time+arm22_time;







            //CAFE22
            adapter.add(getString(R.string.cafeteria22));
            fuel = fuel+cafe22_fuel;
            food = food+cafe22_food;
            steel = steel+cafe22_steel;
            alloy = alloy+cafe22_alloy;
            time = time+cafe22_time;







            //CLONE22
            adapter.add(getString(R.string.clone_lab22));
            fuel = fuel+clone22_fuel;
            food = food+clone22_food;
            steel = steel+clone22_steel;
            alloy = alloy+clone22_alloy;
            time = time+clone22_time;
            //COMM. BUILDING22
            adapter.add(getString(R.string.comm_building22));
            fuel = fuel+comm22_fuel;
            food = food+comm22_food;
            steel = steel+comm22_steel;
            alloy = alloy+comm22_alloy;
            time = time+comm22_time;







            //LOGISTICS CENTER22
            adapter.add(getString(R.string.logistics_center22));
            fuel = fuel+logist22_fuel;
            food = food+logist22_food;
            steel = steel+logist22_steel;
            alloy = alloy+logist22_alloy;
            time = time+logist22_time;
            //DORM22
            adapter.add(getString(R.string.dorm22));
            fuel = fuel+dorm22_fuel;
            food = food+dorm22_food;
            steel = steel+dorm22_steel;
            alloy = alloy+dorm22_alloy;
            time = time+dorm22_time;
            //EMBASSY22
            adapter.add(getString(R.string.embassy22));
            fuel = fuel+embassy22_fuel;
            food = food+embassy22_food;
            steel = steel+embassy22_steel;
            alloy = alloy+embassy22_alloy;
            time = time+embassy22_time;







            //MILITARY22
            adapter.add(getString(R.string.military_office22));
            fuel = fuel+military22_fuel;
            food = food+military22_food;
            steel = steel+military22_steel;
            alloy = alloy+military22_alloy;
            time = time+military22_time;







            //SHELTER22
            adapter.add(getString(R.string.shelter22));
            fuel = fuel+shelter22_fuel;
            food = food+shelter22_food;
            steel = steel+shelter22_steel;

            time = time+shelter22_time;
            //STOREROOM22
            adapter.add(getString(R.string.storeroom22));
            fuel = fuel+store22_fuel;
            food = food+store22_food;
            steel = steel+store22_steel;
            alloy = alloy+store22_alloy;
            time = time+store22_time;
            //WALL22
            adapter.add(getString(R.string.wall22));
            fuel = fuel+wall22_fuel;
            food = food+wall22_food;
            steel = steel+wall22_steel;
            alloy = alloy+wall22_alloy;
            time = time+wall22_time;














            //CLINIC22
            adapter.add(getString(R.string.clinic22));
            fuel = fuel+clinic22_fuel;
            food = food+clinic22_food;
            steel = steel+clinic22_steel;
            alloy = alloy+clinic22_alloy;
            time = time+clinic22_time;





















            //MOBILE22
            adapter.add(getString(R.string.mobile_team_factory22));
            fuel = fuel+mobile22_fuel;
            food = food+mobile22_food;
            steel = steel+mobile22_steel;
            alloy = alloy+mobile22_alloy;
            time = time+mobile22_time;



































            //PRISON22
            adapter.add(getString(R.string.prison22));
            fuel = fuel+prison22_fuel;
            food = food+prison22_food;
            steel = steel+prison22_steel;
            alloy = alloy+prison22_alloy;
            time = time+prison22_time;



























































































            //ARMORY22
            adapter.add(getString(R.string.armory22));
            fuel = fuel+armory22_fuel;
            food = food+armory22_food;
            steel = steel+armory22_steel;
            alloy = alloy+armory22_alloy;
            time = time+armory22_time;




































            //STEEL_MINE22
            adapter.add(getString(R.string.steel_mill22));
            fuel = fuel+steel_fuel22;
            time = time+steel22_time;
























































            //ALLOY_MILL22
            adapter.add(getString(R.string.alloy_mine22));
            fuel = fuel+alloy_m22_fuel;
            time = time+alloy_m22_time;
            //TB23
            adapter.add(getString(R.string.teaching_building23));
            fuel = fuel+tb23_fuel;
            food = food+tb23_food;
            steel = steel+tb23_steel;
            alloy = alloy+tb23_alloy;
            time = time+tb23_time;
        }

        if (now <24	&& aim >=24){
            //FARM23
            adapter.add(getString(R.string.farm23));
            fuel = fuel+farm23_fuel;
            time = time+farm_time23;










            //LAB23
            adapter.add(getString(R.string.laboratory23));
            fuel = fuel+lab23_fuel;
            food = food+lab23_food;
            steel = steel+lab23_steel;
            alloy = alloy+lab23_alloy;
            time = time+lab23_time;
            //OIL WELL23
            adapter.add(getString(R.string.oil_well23));
            food = food+oil_food23;
            time = time+oil_time23;






















            //ARMED FORCE23
            adapter.add(getString(R.string.armed_forces23));
            fuel = fuel+arm23_fuel;
            food = food+arm23_food;
            steel = steel+arm23_steel;
            alloy = alloy+arm23_alloy;
            time = time+arm23_time;







            //CAFE23
            adapter.add(getString(R.string.cafeteria23));
            fuel = fuel+cafe23_fuel;
            food = food+cafe23_food;
            steel = steel+cafe23_steel;
            alloy = alloy+cafe23_alloy;
            time = time+cafe23_time;







            //CLONE23
            adapter.add(getString(R.string.clone_lab23));
            fuel = fuel+clone23_fuel;
            food = food+clone23_food;
            steel = steel+clone23_steel;
            alloy = alloy+clone23_alloy;
            time = time+clone23_time;
            //COMM. BUILDING23
            adapter.add(getString(R.string.comm_building23));
            fuel = fuel+comm23_fuel;
            food = food+comm23_food;
            steel = steel+comm23_steel;
            alloy = alloy+comm23_alloy;
            time = time+comm23_time;







            //LOGISTICS CENTER23
            adapter.add(getString(R.string.logistics_center23));
            fuel = fuel+logist23_fuel;
            food = food+logist23_food;
            steel = steel+logist23_steel;
            alloy = alloy+logist23_alloy;
            time = time+logist23_time;
            //DORM23
            adapter.add(getString(R.string.dorm23));
            fuel = fuel+dorm23_fuel;
            food = food+dorm23_food;
            steel = steel+dorm23_steel;
            alloy = alloy+dorm23_alloy;
            time = time+dorm23_time;
            //EMBASSY23
            adapter.add(getString(R.string.embassy23));
            fuel = fuel+embassy23_fuel;
            food = food+embassy23_food;
            steel = steel+embassy23_steel;
            alloy = alloy+embassy23_alloy;
            time = time+embassy23_time;







            //MILITARY23
            adapter.add(getString(R.string.military_office23));
            fuel = fuel+military23_fuel;
            food = food+military23_food;
            steel = steel+military23_steel;
            alloy = alloy+military23_alloy;
            time = time+military23_time;







            //SHELTER23
            adapter.add(getString(R.string.shelter23));
            fuel = fuel+shelter23_fuel;
            food = food+shelter23_food;
            steel = steel+shelter23_steel;

            time = time+shelter23_time;
            //STOREROOM23
            adapter.add(getString(R.string.storeroom23));
            fuel = fuel+store23_fuel;
            food = food+store23_food;
            steel = steel+store23_steel;
            alloy = alloy+store23_alloy;
            time = time+store23_time;
            //WALL23
            adapter.add(getString(R.string.wall23));
            fuel = fuel+wall23_fuel;
            food = food+wall23_food;
            steel = steel+wall23_steel;
            alloy = alloy+wall23_alloy;
            time = time+wall23_time;














            //CLINIC23
            adapter.add(getString(R.string.clinic23));
            fuel = fuel+clinic23_fuel;
            food = food+clinic23_food;
            steel = steel+clinic23_steel;
            alloy = alloy+clinic23_alloy;
            time = time+clinic23_time;





















            //MOBILE23
            adapter.add(getString(R.string.mobile_team_factory23));
            fuel = fuel+mobile23_fuel;
            food = food+mobile23_food;
            steel = steel+mobile23_steel;
            alloy = alloy+mobile23_alloy;
            time = time+mobile23_time;



































            //PRISON23
            adapter.add(getString(R.string.prison23));
            fuel = fuel+prison23_fuel;
            food = food+prison23_food;
            steel = steel+prison23_steel;
            alloy = alloy+prison23_alloy;
            time = time+prison23_time;



























































































            //ARMORY23
            adapter.add(getString(R.string.armory23));
            fuel = fuel+armory23_fuel;
            food = food+armory23_food;
            steel = steel+armory23_steel;
            alloy = alloy+armory23_alloy;
            time = time+armory23_time;




































            //STEEL_MINE23
            adapter.add(getString(R.string.steel_mill23));
            fuel = fuel+steel_fuel23;
            time = time+steel23_time;
























































            //ALLOY_MILL23
            adapter.add(getString(R.string.alloy_mine23));
            fuel = fuel+alloy_m23_fuel;
            time = time+alloy_m23_time;
            //TB24
            adapter.add(getString(R.string.teaching_building24));
            fuel = fuel+tb24_fuel;
            food = food+tb24_food;
            steel = steel+tb24_steel;
            alloy = alloy+tb24_alloy;
            time = time+tb24_time;
        }

        if (now <25	&& aim >=25){
            //FARM24
            adapter.add(getString(R.string.farm24));
            fuel = fuel+farm24_fuel;
            time = time+farm_time24;










            //LAB24
            adapter.add(getString(R.string.laboratory24));
            fuel = fuel+lab24_fuel;
            food = food+lab24_food;
            steel = steel+lab24_steel;
            alloy = alloy+lab24_alloy;
            time = time+lab24_time;
            //OIL WELL24
            adapter.add(getString(R.string.oil_well24));
            food = food+oil_food24;
            time = time+oil_time24;






















            //ARMED FORCE24
            adapter.add(getString(R.string.armed_forces24));
            fuel = fuel+arm24_fuel;
            food = food+arm24_food;
            steel = steel+arm24_steel;
            alloy = alloy+arm24_alloy;
            time = time+arm24_time;







            //CAFE24
            adapter.add(getString(R.string.cafeteria24));
            fuel = fuel+cafe24_fuel;
            food = food+cafe24_food;
            steel = steel+cafe24_steel;
            alloy = alloy+cafe24_alloy;
            time = time+cafe24_time;







            //CLONE24
            adapter.add(getString(R.string.clone_lab24));
            fuel = fuel+clone24_fuel;
            food = food+clone24_food;
            steel = steel+clone24_steel;
            alloy = alloy+clone24_alloy;
            time = time+clone24_time;
            //COMM. BUILDING24
            adapter.add(getString(R.string.comm_building24));
            fuel = fuel+comm24_fuel;
            food = food+comm24_food;
            steel = steel+comm24_steel;
            alloy = alloy+comm24_alloy;
            time = time+comm24_time;







            //LOGISTICS CENTER24
            adapter.add(getString(R.string.logistics_center24));
            fuel = fuel+logist24_fuel;
            food = food+logist24_food;
            steel = steel+logist24_steel;
            alloy = alloy+logist24_alloy;
            time = time+logist24_time;
            //DORM24
            adapter.add(getString(R.string.dorm24));
            fuel = fuel+dorm24_fuel;
            food = food+dorm24_food;
            steel = steel+dorm24_steel;
            alloy = alloy+dorm24_alloy;
            time = time+dorm24_time;
            //EMBASSY24
            adapter.add(getString(R.string.embassy24));
            fuel = fuel+embassy24_fuel;
            food = food+embassy24_food;
            steel = steel+embassy24_steel;
            alloy = alloy+embassy24_alloy;
            time = time+embassy24_time;







            //MILITARY24
            adapter.add(getString(R.string.military_office24));
            fuel = fuel+military24_fuel;
            food = food+military24_food;
            steel = steel+military24_steel;
            alloy = alloy+military24_alloy;
            time = time+military24_time;







            //SHELTER24
            adapter.add(getString(R.string.shelter24));
            fuel = fuel+shelter24_fuel;
            food = food+shelter24_food;
            steel = steel+shelter24_steel;

            time = time+shelter24_time;
            //STOREROOM24
            adapter.add(getString(R.string.storeroom24));
            fuel = fuel+store24_fuel;
            food = food+store24_food;
            steel = steel+store24_steel;
            alloy = alloy+store24_alloy;
            time = time+store24_time;
            //WALL24
            adapter.add(getString(R.string.wall24));
            fuel = fuel+wall24_fuel;
            food = food+wall24_food;
            steel = steel+wall24_steel;
            alloy = alloy+wall24_alloy;
            time = time+wall24_time;














            //CLINIC24
            adapter.add(getString(R.string.clinic24));
            fuel = fuel+clinic24_fuel;
            food = food+clinic24_food;
            steel = steel+clinic24_steel;
            alloy = alloy+clinic24_alloy;
            time = time+clinic24_time;





















            //MOBILE24
            adapter.add(getString(R.string.mobile_team_factory24));
            fuel = fuel+mobile24_fuel;
            food = food+mobile24_food;
            steel = steel+mobile24_steel;
            alloy = alloy+mobile24_alloy;
            time = time+mobile24_time;



































            //PRISON24
            adapter.add(getString(R.string.prison24));
            fuel = fuel+prison24_fuel;
            food = food+prison24_food;
            steel = steel+prison24_steel;
            alloy = alloy+prison24_alloy;
            time = time+prison24_time;



























































































            //ARMORY24
            adapter.add(getString(R.string.armory24));
            fuel = fuel+armory24_fuel;
            food = food+armory24_food;
            steel = steel+armory24_steel;
            alloy = alloy+armory24_alloy;
            time = time+armory24_time;




































            //STEEL_MINE24
            adapter.add(getString(R.string.steel_mill24));
            fuel = fuel+steel_fuel24;
            time = time+steel24_time;
























































            //ALLOY_MILL24
            adapter.add(getString(R.string.alloy_mine24));
            fuel = fuel+alloy_m24_fuel;
            time = time+alloy_m24_time;
            //TB25
            adapter.add(getString(R.string.teaching_building25));
            fuel = fuel+tb25_fuel;
            food = food+tb25_food;
            steel = steel+tb25_steel;
            alloy = alloy+tb25_alloy;
            time = time+tb25_time;
        }

        if (now <26	&& aim >=26){
            //FARM25
            adapter.add(getString(R.string.farm25));
            fuel = fuel+farm25_fuel;
            time = time+farm_time25;










            //LAB25
            adapter.add(getString(R.string.laboratory25));
            fuel = fuel+lab25_fuel;
            food = food+lab25_food;
            steel = steel+lab25_steel;
            alloy = alloy+lab25_alloy;
            time = time+lab25_time;
            //OIL WELL25
            adapter.add(getString(R.string.oil_well25));
            food = food+oil_food25;
            time = time+oil_time25;






















            //ARMED FORCE25
            adapter.add(getString(R.string.armed_forces25));
            fuel = fuel+arm25_fuel;
            food = food+arm25_food;
            steel = steel+arm25_steel;
            alloy = alloy+arm25_alloy;
            time = time+arm25_time;







            //CAFE25
            adapter.add(getString(R.string.cafeteria25));
            fuel = fuel+cafe25_fuel;
            food = food+cafe25_food;
            steel = steel+cafe25_steel;
            alloy = alloy+cafe25_alloy;
            time = time+cafe25_time;







            //CLONE25
            adapter.add(getString(R.string.clone_lab25));
            fuel = fuel+clone25_fuel;
            food = food+clone25_food;
            steel = steel+clone25_steel;
            alloy = alloy+clone25_alloy;
            time = time+clone25_time;
            //COMM. BUILDING25
            adapter.add(getString(R.string.comm_building25));
            fuel = fuel+comm25_fuel;
            food = food+comm25_food;
            steel = steel+comm25_steel;
            alloy = alloy+comm25_alloy;
            time = time+comm25_time;







            //LOGISTICS CENTER25
            adapter.add(getString(R.string.logistics_center25));
            fuel = fuel+logist25_fuel;
            food = food+logist25_food;
            steel = steel+logist25_steel;
            alloy = alloy+logist25_alloy;
            time = time+logist25_time;
            //DORM25
            adapter.add(getString(R.string.dorm25));
            fuel = fuel+dorm25_fuel;
            food = food+dorm25_food;
            steel = steel+dorm25_steel;
            alloy = alloy+dorm25_alloy;
            time = time+dorm25_time;
            //EMBASSY25
            adapter.add(getString(R.string.embassy25));
            fuel = fuel+embassy25_fuel;
            food = food+embassy25_food;
            steel = steel+embassy25_steel;
            alloy = alloy+embassy25_alloy;
            time = time+embassy25_time;







            //MILITARY25
            adapter.add(getString(R.string.military_office25));
            fuel = fuel+military25_fuel;
            food = food+military25_food;
            steel = steel+military25_steel;
            alloy = alloy+military25_alloy;
            time = time+military25_time;







            //SHELTER25
            adapter.add(getString(R.string.shelter25));
            fuel = fuel+shelter25_fuel;
            food = food+shelter25_food;
            steel = steel+shelter25_steel;

            time = time+shelter25_time;
            //STOREROOM25
            adapter.add(getString(R.string.storeroom25));
            fuel = fuel+store25_fuel;
            food = food+store25_food;
            steel = steel+store25_steel;
            alloy = alloy+store25_alloy;
            time = time+store25_time;
            //WALL25
            adapter.add(getString(R.string.wall25));
            fuel = fuel+wall25_fuel;
            food = food+wall25_food;
            steel = steel+wall25_steel;
            alloy = alloy+wall25_alloy;
            time = time+wall25_time;














            //CLINIC25
            adapter.add(getString(R.string.clinic25));
            fuel = fuel+clinic25_fuel;
            food = food+clinic25_food;
            steel = steel+clinic25_steel;
            alloy = alloy+clinic25_alloy;
            time = time+clinic25_time;





















            //MOBILE25
            adapter.add(getString(R.string.mobile_team_factory25));
            fuel = fuel+mobile25_fuel;
            food = food+mobile25_food;
            steel = steel+mobile25_steel;
            alloy = alloy+mobile25_alloy;
            time = time+mobile25_time;



































            //PRISON25
            adapter.add(getString(R.string.prison25));
            fuel = fuel+prison25_fuel;
            food = food+prison25_food;
            steel = steel+prison25_steel;
            alloy = alloy+prison25_alloy;
            time = time+prison25_time;



























































































            //ARMORY25
            adapter.add(getString(R.string.armory25));
            fuel = fuel+armory25_fuel;
            food = food+armory25_food;
            steel = steel+armory25_steel;
            alloy = alloy+armory25_alloy;
            time = time+armory25_time;




































            //STEEL_MINE25
            adapter.add(getString(R.string.steel_mill25));
            fuel = fuel+steel_fuel25;
            time = time+steel25_time;
























































            //ALLOY_MILL25
            adapter.add(getString(R.string.alloy_mine25));
            fuel = fuel+alloy_m25_fuel;
            time = time+alloy_m25_time;
            //TB26
            adapter.add(getString(R.string.teaching_building26));
            fuel = fuel+tb26_fuel;
            food = food+tb26_food;
            steel = steel+tb26_steel;
            alloy = alloy+tb26_alloy;
            time = time+tb26_time;
        }

        if (now <27	&& aim >=27){
            //FARM26
            adapter.add(getString(R.string.farm26));
            fuel = fuel+farm26_fuel;
            time = time+farm_time26;










            //LAB26
            adapter.add(getString(R.string.laboratory26));
            fuel = fuel+lab26_fuel;
            food = food+lab26_food;
            steel = steel+lab26_steel;
            alloy = alloy+lab26_alloy;
            time = time+lab26_time;
            //OIL WELL26
            adapter.add(getString(R.string.oil_well26));
            food = food+oil_food26;
            time = time+oil_time26;






















            //ARMED FORCE26
            adapter.add(getString(R.string.armed_forces26));
            fuel = fuel+arm26_fuel;
            food = food+arm26_food;
            steel = steel+arm26_steel;
            alloy = alloy+arm26_alloy;
            time = time+arm26_time;







            //CAFE26
            adapter.add(getString(R.string.cafeteria26));
            fuel = fuel+cafe26_fuel;
            food = food+cafe26_food;
            steel = steel+cafe26_steel;
            alloy = alloy+cafe26_alloy;
            time = time+cafe26_time;







            //CLONE26
            adapter.add(getString(R.string.clone_lab26));
            fuel = fuel+clone26_fuel;
            food = food+clone26_food;
            steel = steel+clone26_steel;
            alloy = alloy+clone26_alloy;
            time = time+clone26_time;
            //COMM. BUILDING26
            adapter.add(getString(R.string.comm_building26));
            fuel = fuel+comm26_fuel;
            food = food+comm26_food;
            steel = steel+comm26_steel;
            alloy = alloy+comm26_alloy;
            time = time+comm26_time;







            //LOGISTICS CENTER26
            adapter.add(getString(R.string.logistics_center26));
            fuel = fuel+logist26_fuel;
            food = food+logist26_food;
            steel = steel+logist26_steel;
            alloy = alloy+logist26_alloy;
            time = time+logist26_time;
            //DORM26
            adapter.add(getString(R.string.dorm26));
            fuel = fuel+dorm26_fuel;
            food = food+dorm26_food;
            steel = steel+dorm26_steel;
            alloy = alloy+dorm26_alloy;
            time = time+dorm26_time;
            //EMBASSY26
            adapter.add(getString(R.string.embassy26));
            fuel = fuel+embassy26_fuel;
            food = food+embassy26_food;
            steel = steel+embassy26_steel;
            alloy = alloy+embassy26_alloy;
            time = time+embassy26_time;







            //MILITARY26
            adapter.add(getString(R.string.military_office26));
            fuel = fuel+military26_fuel;
            food = food+military26_food;
            steel = steel+military26_steel;
            alloy = alloy+military26_alloy;
            time = time+military26_time;







            //SHELTER26
            adapter.add(getString(R.string.shelter26));
            fuel = fuel+shelter26_fuel;
            food = food+shelter26_food;
            steel = steel+shelter26_steel;

            time = time+shelter26_time;
            //STOREROOM26
            adapter.add(getString(R.string.storeroom26));
            fuel = fuel+store26_fuel;
            food = food+store26_food;
            steel = steel+store26_steel;
            alloy = alloy+store26_alloy;
            time = time+store26_time;
            //WALL26
            adapter.add(getString(R.string.wall26));
            fuel = fuel+wall26_fuel;
            food = food+wall26_food;
            steel = steel+wall26_steel;
            alloy = alloy+wall26_alloy;
            time = time+wall26_time;














            //CLINIC26
            adapter.add(getString(R.string.clinic26));
            fuel = fuel+clinic26_fuel;
            food = food+clinic26_food;
            steel = steel+clinic26_steel;
            alloy = alloy+clinic26_alloy;
            time = time+clinic26_time;





















            //MOBILE26
            adapter.add(getString(R.string.mobile_team_factory26));
            fuel = fuel+mobile26_fuel;
            food = food+mobile26_food;
            steel = steel+mobile26_steel;
            alloy = alloy+mobile26_alloy;
            time = time+mobile26_time;



































            //PRISON26
            adapter.add(getString(R.string.prison26));
            fuel = fuel+prison26_fuel;
            food = food+prison26_food;
            steel = steel+prison26_steel;
            alloy = alloy+prison26_alloy;
            time = time+prison26_time;



























































































            //ARMORY26
            adapter.add(getString(R.string.armory26));
            fuel = fuel+armory26_fuel;
            food = food+armory26_food;
            steel = steel+armory26_steel;
            alloy = alloy+armory26_alloy;
            time = time+armory26_time;




































            //STEEL_MINE26
            adapter.add(getString(R.string.steel_mill26));
            fuel = fuel+steel_fuel26;
            time = time+steel26_time;
























































            //ALLOY_MILL26
            adapter.add(getString(R.string.alloy_mine26));
            fuel = fuel+alloy_m26_fuel;
            time = time+alloy_m26_time;
            //TB27
            adapter.add(getString(R.string.teaching_building27));
            fuel = fuel+tb27_fuel;
            food = food+tb27_food;
            steel = steel+tb27_steel;
            alloy = alloy+tb27_alloy;
            time = time+tb27_time;
        }

        if (now <28	&& aim >=28){
            //FARM27
            adapter.add(getString(R.string.farm27));
            fuel = fuel+farm27_fuel;
            time = time+farm_time27;










            //LAB27
            adapter.add(getString(R.string.laboratory27));
            fuel = fuel+lab27_fuel;
            food = food+lab27_food;
            steel = steel+lab27_steel;
            alloy = alloy+lab27_alloy;
            time = time+lab27_time;
            //OIL WELL27
            adapter.add(getString(R.string.oil_well27));
            food = food+oil_food27;
            time = time+oil_time27;






















            //ARMED FORCE27
            adapter.add(getString(R.string.armed_forces27));
            fuel = fuel+arm27_fuel;
            food = food+arm27_food;
            steel = steel+arm27_steel;
            alloy = alloy+arm27_alloy;
            time = time+arm27_time;







            //CAFE27
            adapter.add(getString(R.string.cafeteria27));
            fuel = fuel+cafe27_fuel;
            food = food+cafe27_food;
            steel = steel+cafe27_steel;
            alloy = alloy+cafe27_alloy;
            time = time+cafe27_time;







            //CLONE27
            adapter.add(getString(R.string.clone_lab27));
            fuel = fuel+clone27_fuel;
            food = food+clone27_food;
            steel = steel+clone27_steel;
            alloy = alloy+clone27_alloy;
            time = time+clone27_time;
            //COMM. BUILDING27
            adapter.add(getString(R.string.comm_building27));
            fuel = fuel+comm27_fuel;
            food = food+comm27_food;
            steel = steel+comm27_steel;
            alloy = alloy+comm27_alloy;
            time = time+comm27_time;







            //LOGISTICS CENTER27
            adapter.add(getString(R.string.logistics_center27));
            fuel = fuel+logist27_fuel;
            food = food+logist27_food;
            steel = steel+logist27_steel;
            alloy = alloy+logist27_alloy;
            time = time+logist27_time;
            //DORM27
            adapter.add(getString(R.string.dorm27));
            fuel = fuel+dorm27_fuel;
            food = food+dorm27_food;
            steel = steel+dorm27_steel;
            alloy = alloy+dorm27_alloy;
            time = time+dorm27_time;
            //EMBASSY27
            adapter.add(getString(R.string.embassy27));
            fuel = fuel+embassy27_fuel;
            food = food+embassy27_food;
            steel = steel+embassy27_steel;
            alloy = alloy+embassy27_alloy;
            time = time+embassy27_time;







            //MILITARY27
            adapter.add(getString(R.string.military_office27));
            fuel = fuel+military27_fuel;
            food = food+military27_food;
            steel = steel+military27_steel;
            alloy = alloy+military27_alloy;
            time = time+military27_time;







            //SHELTER27
            adapter.add(getString(R.string.shelter27));
            fuel = fuel+shelter27_fuel;
            food = food+shelter27_food;
            steel = steel+shelter27_steel;

            time = time+shelter27_time;
            //STOREROOM27
            adapter.add(getString(R.string.storeroom27));
            fuel = fuel+store27_fuel;
            food = food+store27_food;
            steel = steel+store27_steel;
            alloy = alloy+store27_alloy;
            time = time+store27_time;
            //WALL27
            adapter.add(getString(R.string.wall27));
            fuel = fuel+wall27_fuel;
            food = food+wall27_food;
            steel = steel+wall27_steel;
            alloy = alloy+wall27_alloy;
            time = time+wall27_time;














            //CLINIC27
            adapter.add(getString(R.string.clinic27));
            fuel = fuel+clinic27_fuel;
            food = food+clinic27_food;
            steel = steel+clinic27_steel;
            alloy = alloy+clinic27_alloy;
            time = time+clinic27_time;





















            //MOBILE27
            adapter.add(getString(R.string.mobile_team_factory27));
            fuel = fuel+mobile27_fuel;
            food = food+mobile27_food;
            steel = steel+mobile27_steel;
            alloy = alloy+mobile27_alloy;
            time = time+mobile27_time;



































            //PRISON27
            adapter.add(getString(R.string.prison27));
            fuel = fuel+prison27_fuel;
            food = food+prison27_food;
            steel = steel+prison27_steel;
            alloy = alloy+prison27_alloy;
            time = time+prison27_time;



























































































            //ARMORY27
            adapter.add(getString(R.string.armory27));
            fuel = fuel+armory27_fuel;
            food = food+armory27_food;
            steel = steel+armory27_steel;
            alloy = alloy+armory27_alloy;
            time = time+armory27_time;




































            //STEEL_MINE27
            adapter.add(getString(R.string.steel_mill27));
            fuel = fuel+steel_fuel27;
            time = time+steel27_time;
























































            //ALLOY_MILL27
            adapter.add(getString(R.string.alloy_mine27));
            fuel = fuel+alloy_m27_fuel;
            time = time+alloy_m27_time;
            //TB28
            adapter.add(getString(R.string.teaching_building28));
            fuel = fuel+tb28_fuel;
            food = food+tb28_food;
            steel = steel+tb28_steel;
            alloy = alloy+tb28_alloy;
            time = time+tb28_time;
        }

        if (now <29	&& aim >=29){
            //FARM28
            adapter.add(getString(R.string.farm28));
            fuel = fuel+farm28_fuel;
            time = time+farm_time28;










            //LAB28
            adapter.add(getString(R.string.laboratory28));
            fuel = fuel+lab28_fuel;
            food = food+lab28_food;
            steel = steel+lab28_steel;
            alloy = alloy+lab28_alloy;
            time = time+lab28_time;
            //OIL WELL28
            adapter.add(getString(R.string.oil_well28));
            food = food+oil_food28;
            time = time+oil_time28;






















            //ARMED FORCE28
            adapter.add(getString(R.string.armed_forces28));
            fuel = fuel+arm28_fuel;
            food = food+arm28_food;
            steel = steel+arm28_steel;
            alloy = alloy+arm28_alloy;
            time = time+arm28_time;







            //CAFE28
            adapter.add(getString(R.string.cafeteria28));
            fuel = fuel+cafe28_fuel;
            food = food+cafe28_food;
            steel = steel+cafe28_steel;
            alloy = alloy+cafe28_alloy;
            time = time+cafe28_time;







            //CLONE28
            adapter.add(getString(R.string.clone_lab28));
            fuel = fuel+clone28_fuel;
            food = food+clone28_food;
            steel = steel+clone28_steel;
            alloy = alloy+clone28_alloy;
            time = time+clone28_time;
            //COMM. BUILDING28
            adapter.add(getString(R.string.comm_building28));
            fuel = fuel+comm28_fuel;
            food = food+comm28_food;
            steel = steel+comm28_steel;
            alloy = alloy+comm28_alloy;
            time = time+comm28_time;







            //LOGISTICS CENTER28
            adapter.add(getString(R.string.logistics_center28));
            fuel = fuel+logist28_fuel;
            food = food+logist28_food;
            steel = steel+logist28_steel;
            alloy = alloy+logist28_alloy;
            time = time+logist28_time;
            //DORM28
            adapter.add(getString(R.string.dorm28));
            fuel = fuel+dorm28_fuel;
            food = food+dorm28_food;
            steel = steel+dorm28_steel;
            alloy = alloy+dorm28_alloy;
            time = time+dorm28_time;
            //EMBASSY28
            adapter.add(getString(R.string.embassy28));
            fuel = fuel+embassy28_fuel;
            food = food+embassy28_food;
            steel = steel+embassy28_steel;
            alloy = alloy+embassy28_alloy;
            time = time+embassy28_time;







            //MILITARY28
            adapter.add(getString(R.string.military_office28));
            fuel = fuel+military28_fuel;
            food = food+military28_food;
            steel = steel+military28_steel;
            alloy = alloy+military28_alloy;
            time = time+military28_time;







            //SHELTER28
            adapter.add(getString(R.string.shelter28));
            fuel = fuel+shelter28_fuel;
            food = food+shelter28_food;
            steel = steel+shelter28_steel;

            time = time+shelter28_time;
            //STOREROOM28
            adapter.add(getString(R.string.storeroom28));
            fuel = fuel+store28_fuel;
            food = food+store28_food;
            steel = steel+store28_steel;
            alloy = alloy+store28_alloy;
            time = time+store28_time;
            //WALL28
            adapter.add(getString(R.string.wall28));
            fuel = fuel+wall28_fuel;
            food = food+wall28_food;
            steel = steel+wall28_steel;
            alloy = alloy+wall28_alloy;
            time = time+wall28_time;














            //CLINIC28
            adapter.add(getString(R.string.clinic28));
            fuel = fuel+clinic28_fuel;
            food = food+clinic28_food;
            steel = steel+clinic28_steel;
            alloy = alloy+clinic28_alloy;
            time = time+clinic28_time;





















            //MOBILE28
            adapter.add(getString(R.string.mobile_team_factory28));
            fuel = fuel+mobile28_fuel;
            food = food+mobile28_food;
            steel = steel+mobile28_steel;
            alloy = alloy+mobile28_alloy;
            time = time+mobile28_time;



































            //PRISON28
            adapter.add(getString(R.string.prison28));
            fuel = fuel+prison28_fuel;
            food = food+prison28_food;
            steel = steel+prison28_steel;
            alloy = alloy+prison28_alloy;
            time = time+prison28_time;



























































































            //ARMORY28
            adapter.add(getString(R.string.armory28));
            fuel = fuel+armory28_fuel;
            food = food+armory28_food;
            steel = steel+armory28_steel;
            alloy = alloy+armory28_alloy;
            time = time+armory28_time;




































            //STEEL_MINE28
            adapter.add(getString(R.string.steel_mill28));
            fuel = fuel+steel_fuel28;
            time = time+steel28_time;
























































            //ALLOY_MILL28
            adapter.add(getString(R.string.alloy_mine28));
            fuel = fuel+alloy_m28_fuel;
            time = time+alloy_m28_time;
            //TB29
            adapter.add(getString(R.string.teaching_building29));
            fuel = fuel+tb29_fuel;
            food = food+tb29_food;
            steel = steel+tb29_steel;
            alloy = alloy+tb29_alloy;
            time = time+tb29_time;
        }

        if (now <30	&& aim >=30){
            //FARM29
            adapter.add(getString(R.string.farm29));
            fuel = fuel+farm29_fuel;
            time = time+farm_time29;










            //LAB29
            adapter.add(getString(R.string.laboratory29));
            fuel = fuel+lab29_fuel;
            food = food+lab29_food;
            steel = steel+lab29_steel;
            alloy = alloy+lab29_alloy;
            time = time+lab29_time;
            //OIL WELL29
            adapter.add(getString(R.string.oil_well29));
            food = food+oil_food29;
            time = time+oil_time29;






















            //ARMED FORCE29
            adapter.add(getString(R.string.armed_forces29));
            fuel = fuel+arm29_fuel;
            food = food+arm29_food;
            steel = steel+arm29_steel;
            alloy = alloy+arm29_alloy;
            time = time+arm29_time;







            //CAFE29
            adapter.add(getString(R.string.cafeteria29));
            fuel = fuel+cafe29_fuel;
            food = food+cafe29_food;
            steel = steel+cafe29_steel;
            alloy = alloy+cafe29_alloy;
            time = time+cafe29_time;







            //CLONE29
            adapter.add(getString(R.string.clone_lab29));
            fuel = fuel+clone29_fuel;
            food = food+clone29_food;
            steel = steel+clone29_steel;
            alloy = alloy+clone29_alloy;
            time = time+clone29_time;
            //COMM. BUILDING29
            adapter.add(getString(R.string.comm_building29));
            fuel = fuel+comm29_fuel;
            food = food+comm29_food;
            steel = steel+comm29_steel;
            alloy = alloy+comm29_alloy;
            time = time+comm29_time;







            //LOGISTICS CENTER29
            adapter.add(getString(R.string.logistics_center29));
            fuel = fuel+logist29_fuel;
            food = food+logist29_food;
            steel = steel+logist29_steel;
            alloy = alloy+logist29_alloy;
            time = time+logist29_time;
            //DORM29
            adapter.add(getString(R.string.dorm29));
            fuel = fuel+dorm29_fuel;
            food = food+dorm29_food;
            steel = steel+dorm29_steel;
            alloy = alloy+dorm29_alloy;
            time = time+dorm29_time;
            //EMBASSY29
            adapter.add(getString(R.string.embassy29));
            fuel = fuel+embassy29_fuel;
            food = food+embassy29_food;
            steel = steel+embassy29_steel;
            alloy = alloy+embassy29_alloy;
            time = time+embassy29_time;







            //MILITARY29
            adapter.add(getString(R.string.military_office29));
            fuel = fuel+military29_fuel;
            food = food+military29_food;
            steel = steel+military29_steel;
            alloy = alloy+military29_alloy;
            time = time+military29_time;







            //SHELTER29
            adapter.add(getString(R.string.shelter29));
            fuel = fuel+shelter29_fuel;
            food = food+shelter29_food;
            steel = steel+shelter29_steel;

            time = time+shelter29_time;
            //STOREROOM29
            adapter.add(getString(R.string.storeroom29));
            fuel = fuel+store29_fuel;
            food = food+store29_food;
            steel = steel+store29_steel;
            alloy = alloy+store29_alloy;
            time = time+store29_time;
            //WALL29
            adapter.add(getString(R.string.wall29));
            fuel = fuel+wall29_fuel;
            food = food+wall29_food;
            steel = steel+wall29_steel;
            alloy = alloy+wall29_alloy;
            time = time+wall29_time;














            //CLINIC29
            adapter.add(getString(R.string.clinic29));
            fuel = fuel+clinic29_fuel;
            food = food+clinic29_food;
            steel = steel+clinic29_steel;
            alloy = alloy+clinic29_alloy;
            time = time+clinic29_time;





















            //MOBILE29
            adapter.add(getString(R.string.mobile_team_factory29));
            fuel = fuel+mobile29_fuel;
            food = food+mobile29_food;
            steel = steel+mobile29_steel;
            alloy = alloy+mobile29_alloy;
            time = time+mobile29_time;



































            //PRISON29
            adapter.add(getString(R.string.prison29));
            fuel = fuel+prison29_fuel;
            food = food+prison29_food;
            steel = steel+prison29_steel;
            alloy = alloy+prison29_alloy;
            time = time+prison29_time;



























































































            //ARMORY29
            adapter.add(getString(R.string.armory29));
            fuel = fuel+armory29_fuel;
            food = food+armory29_food;
            steel = steel+armory29_steel;
            alloy = alloy+armory29_alloy;
            time = time+armory29_time;




































            //STEEL_MINE29
            adapter.add(getString(R.string.steel_mill29));
            fuel = fuel+steel_fuel29;
            time = time+steel29_time;
























































            //ALLOY_MILL29
            adapter.add(getString(R.string.alloy_mine29));
            fuel = fuel+alloy_m29_fuel;
            time = time+alloy_m29_time;
            //TB30
            adapter.add(getString(R.string.teaching_building30));
            fuel = fuel+tb30_fuel;
            food = food+tb30_food;
            steel = steel+tb30_steel;
            alloy = alloy+tb30_alloy;
            time = time+tb30_time;
        }

        //TB31
        if (now < 31 && aim >= 31){
            //WALL
            adapter.add(getString(R.string.wall30));
            fuel = fuel+wall30_fuel;
            food = food+wall30_food;
            steel = steel+wall30_steel;
            alloy = alloy+wall30_alloy;
            time = time+wall30_time;
            //TB
            adapter.add(getString(R.string.teaching_building31));
            fuel = fuel+tb31_fuel;
            food = food+tb31_food;
            steel = steel+tb31_steel;
            alloy = alloy+tb31_alloy;
            kyanite = kyanite+tb31_kyanite;
            kyanite_basic = kyanite_basic+tb31_kyanite_basic;
            kyanite_cluster = kyanite_cluster+tb31_kyanite_cluster;
            glory = glory+tb31_glory_mark;
            time = time+tb31_time;
        }
        //TB32
        if (now < 32 && aim >= 32){
            //TB
            adapter.add(getString(R.string.teaching_building32));
            fuel = fuel+tb32_fuel;
            food = food+tb32_food;
            steel = steel+tb32_steel;
            alloy = alloy+tb32_alloy;
            kyanite = kyanite+tb32_kyanite;
            kyanite_basic = kyanite_basic+tb32_kyanite_basic;
            kyanite_cluster = kyanite_cluster+tb32_kyanite_cluster;
            glory = glory+tb32_glory_mark;
            time = time+tb32_time;
        }
        //TB33
        if (now < 33 && aim >= 33){

            //Required_31
            adapter.add(getString(R.string.alloy_mine31));	fuel = fuel + alloy_m31_fuel;	time = time + alloy_m31_time;

            //TB
            adapter.add(getString(R.string.teaching_building33));
            fuel = fuel+tb33_fuel;
            food = food+tb33_food;
            steel = steel+tb33_steel;
            alloy = alloy+tb33_alloy;
            time = time+tb33_time;
            kyanite = kyanite+tb33_kyanite;
            kyanite_basic = kyanite_basic+tb33_kyanite_basic;
            kyanite_cluster = kyanite_cluster+tb33_kyanite_cluster;
            glory = glory+tb33_glory_mark;

        }
        //TB34
        if (now < 34 && aim >= 34){
            //Required_31
            adapter.add(getString(R.string.oil_well31));	 food = food + oil_food31;	  time = time + oil_time31;
            //Required_32
            adapter.add(getString(R.string.oil_well32));	 food = food + oil_food32;	  time = time + oil_time32;

            //Required_31
            adapter.add(getString(R.string.military_office31));	fuel = fuel + military31_fuel;	food = food + military31_food;	steel = steel + military31_steel;	alloy = alloy + military31_alloy;	time = time + military31_time;
            //Required_32
            adapter.add(getString(R.string.military_office32));	fuel = fuel + military32_fuel;	food = food + military32_food;	steel = steel + military32_steel;	alloy = alloy + military32_alloy;	time = time + military32_time;

            //TB
            adapter.add(getString(R.string.teaching_building34));
            fuel = fuel+tb34_fuel;
            food = food+tb34_food;
            steel = steel+tb34_steel;
            alloy = alloy+tb34_alloy;
            time = time+tb34_time;
            kyanite = kyanite+tb34_kyanite;
            kyanite_basic = kyanite_basic+tb34_kyanite_basic;
            kyanite_cluster = kyanite_cluster+tb34_kyanite_cluster;
            glory = glory+tb34_glory_mark;

        }
        //TB35
        if (now < 35 && aim == 35){
            //Required_31
            adapter.add(getString(R.string.steel_mill31));	fuel = fuel + steel_fuel31;	time = time + steel31_time;
            //Required_32
            adapter.add(getString(R.string.steel_mill32));	fuel = fuel + steel_fuel32;	time = time + steel32_time;
            //Required_33
            adapter.add(getString(R.string.steel_mill33));	fuel = fuel + steel_fuel33;	time = time + steel33_time;

            //Required_31
            adapter.add(getString(R.string.armed_forces31));	fuel = fuel + arm31_fuel;	food = food + arm31_food;	steel = steel + arm31_steel;	alloy = alloy + arm31_alloy;	time = time + arm31_time;
            //Required_32
            adapter.add(getString(R.string.armed_forces32));	fuel = fuel + arm32_fuel;	food = food + arm32_food;	steel = steel + arm32_steel;	alloy = alloy + arm32_alloy;	time = time + arm32_time;
            //Required_33
            adapter.add(getString(R.string.armed_forces33));	fuel = fuel + arm33_fuel;	food = food + arm33_food;	steel = steel + arm33_steel;	alloy = alloy + arm33_alloy;	time = time + arm33_time;

            //TB
            adapter.add(getString(R.string.teaching_building35));
            fuel = fuel+tb35_fuel;
            food = food+tb35_food;
            steel = steel+tb35_steel;
            alloy = alloy+tb35_alloy;
            time = time+tb35_time;
            kyanite = kyanite+tb35_kyanite;
            kyanite_basic = kyanite_basic+tb35_kyanite_basic;
            kyanite_cluster = kyanite_cluster+tb35_kyanite_cluster;
            glory = glory+tb35_glory_mark;
        }

        /**
         //TB4
         if (now < 4 && aim >= 4){
         //WALL
         adapter.add("[BUILD] Wall lv3");
         fuel = fuel+wall3_fuel;
         food = food+wall3_food;
         steel = steel+wall3_steel;
         alloy = alloy+wall3_alloy;
         time = time+wall3_time;
         //OIL_1
         adapter.add("[BUILD] Oil Well lv1");
         food = food+oil_food1;
         time = time+oil_time1;
         //OIL_2
         adapter.add("[BUILD] Oil Well lv2");
         food = food+oil_food2;
         time = time+oil_time2;
         //OIL_3
         adapter.add("[BUILD] Oil Well lv3");
         food = food+oil_food3;
         time = time+oil_time3;
         //TB
         adapter.add("[BUILD] TB lv4");
         fuel = fuel+tb4_fuel;
         food = food+tb4_food;
         steel = steel+tb4_steel;
         alloy = alloy+tb4_alloy;
         time = time+tb4_time;
         }
         //TB5
         if (now < 5 && aim >= 5){
         //WALL
         adapter.add("[BUILD] Wall lv4");
         fuel = fuel+wall4_fuel;
         food = food+wall4_food;
         steel = steel+wall4_steel;
         alloy = alloy+wall4_alloy;
         time = time+wall4_time;
         //FARM_1
         adapter.add("[BUILD] Farm lv1");
         fuel = fuel+farm1_fuel;
         time = time+oil_time1;
         //FARM_2
         adapter.add("[BUILD] Farm lv2");
         fuel = fuel+farm2_fuel;
         time = time+farm_time2;
         //FARM_3
         adapter.add("[BUILD] Farm lv3");
         fuel = fuel+farm3_fuel;
         time = time+farm_time3;
         //FARM_4
         adapter.add("[BUILD] Farm lv4");
         fuel = fuel+farm4_fuel;
         time = time+farm_time4;
         //TB
         adapter.add("[BUILD] TB lv5");
         fuel = fuel+tb5_fuel;
         food = food+tb5_food;
         steel = steel+tb5_steel;
         alloy = alloy+tb5_alloy;
         time = time+tb5_time;
         }
         //TB6
         if (now < 6 && aim >= 6){
         //WALL
         adapter.add("[BUILD] Wall lv5");
         fuel = fuel+wall5_fuel;
         food = food+wall5_food;
         steel = steel+wall5_steel;
         alloy = alloy+wall5_alloy;
         time = time+wall5_time;
         //Required_1
         adapter.add("[BUILD] Storeroom lv1");
         fuel = fuel+store1_fuel;
         food = food+store1_food;
         time = time+store1_time;
         //Required_2
         adapter.add("[BUILD] Storeroom lv2");
         fuel = fuel+store2_fuel;
         food = food+store2_food;
         time = time+store2_time;
         //Required_3
         adapter.add("[BUILD] Storeroom lv3");
         fuel = fuel+store3_fuel;
         food = food+store3_food;
         time = time+store3_time;
         //Required_4
         adapter.add("[BUILD] Storeroom lv4");
         fuel = fuel+store4_fuel;
         food = food+store4_food;
         time = time+store4_time;
         //Required_5
         adapter.add("[BUILD] Storeroom lv5");
         fuel = fuel+store5_fuel;
         food = food+store5_food;
         time = time+store5_time;
         //TB
         adapter.add("[BUILD] TB lv6");
         fuel = fuel+tb6_fuel;
         food = food+tb6_food;
         steel = steel+tb6_steel;
         alloy = alloy+tb6_alloy;
         time = time+tb6_time;
         }
         //TB7
         if (now < 7 && aim >= 7){
         //WALL
         adapter.add("[BUILD] Wall lv6");
         fuel = fuel+wall6_fuel;
         food = food+wall6_food;
         steel = steel+wall6_steel;
         alloy = alloy+wall6_alloy;
         time = time+wall6_time;
         //TB
         adapter.add("[BUILD] Build TB lv7");
         fuel = fuel+tb7_fuel;
         food = food+tb7_food;
         steel = steel+tb7_steel;
         alloy = alloy+tb7_alloy;
         time = time+tb7_time;
         }
         //TB8
         if (now < 8 && aim >= 8){
         //WALL
         adapter.add("[BUILD] Wall lv7");
         fuel = fuel+wall7_fuel;
         food = food+wall7_food;
         steel = steel+wall7_steel;
         alloy = alloy+wall7_alloy;
         time = time+wall7_time;
         //TB
         adapter.add("[BUILD] Build TB lv8");
         fuel = fuel+tb8_fuel;
         food = food+tb8_food;
         steel = steel+tb8_steel;
         alloy = alloy+tb8_alloy;
         time = time+tb8_time;
         }
         //TB9
         if (now < 9 && aim >= 9){
         //WALL
         adapter.add("[BUILD] Wall lv8");
         fuel = fuel+wall8_fuel;
         food = food+wall8_food;
         steel = steel+wall8_steel;
         alloy = alloy+wall8_alloy;
         time = time+wall8_time;
         //Required_1
         adapter.add("[BUILD] Shelter lv1");
         fuel = fuel+shelter1_fuel;
         food = food+shelter1_food;
         steel = steel+shelter1_steel;
         time = time+shelter1_time;
         //Required_2
         adapter.add("[BUILD] Shelter lv2");
         fuel = fuel+shelter2_fuel;
         food = food+shelter2_food;
         steel = steel+shelter2_steel;
         time = time+shelter2_time;
         //Required_3
         adapter.add("[BUILD] Shelter lv3");
         fuel = fuel+shelter3_fuel;
         food = food+shelter3_food;
         steel = steel+shelter3_steel;
         time = time+shelter3_time;
         //Required_4
         adapter.add("[BUILD] Shelter lv4");
         fuel = fuel+shelter4_fuel;
         food = food+shelter4_food;
         steel = steel+shelter4_steel;
         time = time+shelter4_time;
         //Required_5
         adapter.add("[BUILD] Shelter lv5");
         fuel = fuel+shelter5_fuel;
         food = food+shelter5_food;
         steel = steel+shelter5_steel;
         time = time+shelter5_time;
         //Required_6
         adapter.add("[BUILD] Shelter lv6");
         fuel = fuel+shelter6_fuel;
         food = food+shelter6_food;
         steel = steel+shelter6_steel;
         time = time+shelter6_time;
         //Required_7
         adapter.add("[BUILD] Shelter lv7");
         fuel = fuel+shelter7_fuel;
         food = food+shelter7_food;
         steel = steel+shelter7_steel;
         time = time+shelter7_time;
         //Required_8
         adapter.add("[BUILD] Shelter lv8");
         fuel = fuel+shelter8_fuel;
         food = food+shelter8_food;
         steel = steel+shelter8_steel;
         time = time+shelter8_time;
         //TB
         adapter.add("[BUILD] Build TB lv9");
         fuel = fuel+tb9_fuel;
         food = food+tb9_food;
         steel = steel+tb9_steel;
         alloy = alloy+tb9_alloy;
         time = time+tb9_time;
         }
         //TB10
         if (now < 10 && aim >= 10){
         //WALL
         adapter.add("[BUILD] Wall lv9");
         fuel = fuel+wall9_fuel;
         food = food+wall9_food;
         steel = steel+wall9_steel;
         alloy = alloy+wall9_alloy;
         time = time+wall9_time;
         //Required_6
         adapter.add("[BUILD] Storeroom lv6");
         fuel = fuel+store6_fuel;
         food = food+store6_food;
         time = time+store6_time;
         //Required_7
         adapter.add("[BUILD] Storeroom lv7");
         fuel = fuel+store7_fuel;
         food = food+store7_food;
         time = time+store7_time;
         //Required_8
         adapter.add("[BUILD] Storeroom lv8");
         fuel = fuel+store8_fuel;
         food = food+store8_food;
         time = time+store8_time;
         //Required_9
         adapter.add("[BUILD] Storeroom lv9");
         fuel = fuel+store9_fuel;
         food = food+store9_food;
         time = time+store9_time;
         //TB
         adapter.add("[BUILD] Build TB lv10");
         fuel = fuel+tb10_fuel;
         food = food+tb10_food;
         steel = steel+tb10_steel;
         alloy = alloy+tb10_alloy;
         time = time+tb10_time;
         }
         //TB11
         if (now < 11 && aim >= 11){
         //WALL
         adapter.add("[BUILD] Wall lv10");
         fuel = fuel+wall10_fuel;
         food = food+wall10_food;
         steel = steel+wall10_steel;
         alloy = alloy+wall10_alloy;
         time = time+wall10_time;
         //Required_1
         adapter.add("[BUILD] Clinic lv1");
         fuel = fuel+clinic1_fuel;
         food = food+clinic1_food;
         steel = steel+clinic1_steel;
         time = time+clinic1_time;
         //Required_2
         adapter.add("[BUILD] Clinic lv2");
         fuel = fuel+clinic2_fuel;
         food = food+clinic2_food;
         steel = steel+clinic2_steel;
         time = time+clinic2_time;
         //Required_3
         adapter.add("[BUILD] Clinic lv3");
         fuel = fuel+clinic3_fuel;
         food = food+clinic3_food;
         steel = steel+clinic3_steel;
         time = time+clinic3_time;
         //Required_4
         adapter.add("[BUILD] Clinic lv4");
         fuel = fuel+clinic4_fuel;
         food = food+clinic4_food;
         steel = steel+clinic4_steel;
         time = time+clinic4_time;
         //Required_5
         adapter.add("[BUILD] Clinic lv5");
         fuel = fuel+clinic5_fuel;
         food = food+clinic5_food;
         steel = steel+clinic5_steel;
         time = time+clinic5_time;
         //Required_6
         adapter.add("[BUILD] Clinic lv6");
         fuel = fuel+clinic6_fuel;
         food = food+clinic6_food;
         steel = steel+clinic6_steel;
         time = time+clinic6_time;
         //Required_7
         adapter.add("[BUILD] Clinic lv7");
         fuel = fuel+clinic7_fuel;
         food = food+clinic7_food;
         steel = steel+clinic7_steel;
         time = time+clinic7_time;
         //Required_8
         adapter.add("[BUILD] Clinic lv8");
         fuel = fuel+clinic8_fuel;
         food = food+clinic8_food;
         steel = steel+clinic8_steel;
         time = time+clinic8_time;
         //Required_9
         adapter.add("[BUILD] Clinic lv9");
         fuel = fuel+clinic9_fuel;
         food = food+clinic9_food;
         steel = steel+clinic9_steel;
         time = time+clinic9_time;
         //Required_10
         adapter.add("[BUILD] Clinic lv10");
         fuel = fuel+clinic10_fuel;
         food = food+clinic10_food;
         steel = steel+clinic10_steel;
         time = time+clinic10_time;
         //TB
         adapter.add("[BUILD] Build TB lv11");
         fuel = fuel+tb11_fuel;
         food = food+tb11_food;
         steel = steel+tb11_steel;
         alloy = alloy+tb11_alloy;
         time = time+tb11_time;
         }
         //TB12
         if (now < 12 && aim >= 12){
         //WALL
         adapter.add("[BUILD] Wall lv11");
         fuel = fuel+wall11_fuel;
         food = food+wall11_food;
         steel = steel+wall11_steel;
         alloy = alloy+wall11_alloy;
         time = time+wall11_time;
         //TB
         adapter.add("[BUILD] Build TB lv12");
         fuel = fuel+tb12_fuel;
         food = food+tb12_food;
         steel = steel+tb12_steel;
         alloy = alloy+tb12_alloy;
         time = time+tb12_time;

         }
         //TB13
         if (now < 13 && aim >= 13){
         //WALL
         adapter.add("[BUILD] Wall lv12");
         fuel = fuel+wall12_fuel;
         food = food+wall12_food;
         steel = steel+wall12_steel;
         alloy = alloy+wall12_alloy;
         time = time+wall12_time;
         //TB
         adapter.add("[BUILD] Build TB lv13");
         fuel = fuel+tb13_fuel;
         food = food+tb13_food;
         steel = steel+tb13_steel;
         alloy = alloy+tb13_alloy;
         time = time+tb13_time;
         }
         //TB14
         if (now < 14 && aim >= 14){
         //WALL
         adapter.add("[BUILD] Wall lv13");
         fuel = fuel+wall13_fuel;
         food = food+wall13_food;
         steel = steel+wall13_steel;
         alloy = alloy+wall13_alloy;
         time = time+wall13_time;
         //Required_1
         adapter.add("[BUILD] Armed Forces lv1");
         fuel = fuel+arm1_fuel;
         food = food+arm1_food;
         steel = steel+arm1_steel;
         time = time+arm1_time;
         alloy = alloy+arm1_alloy;
         //Required_2
         adapter.add("[BUILD] Armed Forces lv2");
         fuel = fuel+arm2_fuel;
         food = food+arm2_food;
         steel = steel+arm2_steel;
         time = time+arm2_time;
         alloy = alloy+arm2_alloy;
         //Required_3
         adapter.add("[BUILD] Armed Forces lv3");
         fuel = fuel+arm3_fuel;
         food = food+arm3_food;
         steel = steel+arm3_steel;
         time = time+arm3_time;
         alloy = alloy+arm3_alloy;
         //Required_4
         adapter.add("[BUILD] Armed Forces lv4");
         fuel = fuel+arm4_fuel;
         food = food+arm4_food;
         steel = steel+arm4_steel;
         time = time+arm4_time;
         alloy = alloy+arm4_alloy;
         //Required_5
         adapter.add("[BUILD] Armed Forces lv5");
         fuel = fuel+arm5_fuel;
         food = food+arm5_food;
         steel = steel+arm5_steel;
         time = time+arm5_time;
         alloy = alloy+arm5_alloy;
         //Required_6
         adapter.add("[BUILD] Armed Forces lv6");
         fuel = fuel+arm6_fuel;
         food = food+arm6_food;
         steel = steel+arm6_steel;
         time = time+arm6_time;
         alloy = alloy+arm6_alloy;
         //Required_7
         adapter.add("[BUILD] Armed Forces lv7");
         fuel = fuel+arm7_fuel;
         food = food+arm7_food;
         steel = steel+arm7_steel;
         time = time+arm7_time;
         alloy = alloy+arm7_alloy;
         //Required_8
         adapter.add("[BUILD] Armed Forces lv8");
         fuel = fuel+arm8_fuel;
         food = food+arm8_food;
         steel = steel+arm8_steel;
         time = time+arm8_time;
         alloy = alloy+arm8_alloy;
         //Required_9
         adapter.add("[BUILD] Armed Forces lv9");
         fuel = fuel+arm9_fuel;
         food = food+arm9_food;
         steel = steel+arm9_steel;
         time = time+arm9_time;
         alloy = alloy+arm9_alloy;
         //Required_10
         adapter.add("[BUILD] Armed Forces lv10");
         fuel = fuel+arm10_fuel;
         food = food+arm10_food;
         steel = steel+arm10_steel;
         time = time+arm10_time;
         alloy = alloy+arm10_alloy;
         //Required_11
         adapter.add("[BUILD] Armed Forces lv11");
         fuel = fuel+arm11_fuel;
         food = food+arm11_food;
         steel = steel+arm11_steel;
         time = time+arm11_time;
         alloy = alloy+arm11_alloy;
         //Required_12
         adapter.add("[BUILD] Armed Forces lv12");
         fuel = fuel+arm12_fuel;
         food = food+arm12_food;
         steel = steel+arm12_steel;
         time = time+arm12_time;
         alloy = alloy+arm12_alloy;
         //Required_13
         adapter.add("[BUILD] Armed Forces lv13");
         fuel = fuel+arm13_fuel;
         food = food+arm13_food;
         steel = steel+arm13_steel;
         time = time+arm13_time;
         alloy = alloy+arm13_alloy;
         //TB
         adapter.add("[BUILD] Build TB lv14");
         fuel = fuel+tb14_fuel;
         food = food+tb14_food;
         steel = steel+tb14_steel;
         alloy = alloy+tb14_alloy;
         time = time+tb14_time;
         }
         //TB15
         if (now < 15 && aim >= 15){
         //WALL
         adapter.add("[BUILD] Wall lv14");
         fuel = fuel+wall14_fuel;
         food = food+wall14_food;
         steel = steel+wall14_steel;
         alloy = alloy+wall14_alloy;
         time = time+wall14_time;
         //Required_1
         adapter.add("[BUILD] War Factory lv1");
         fuel = fuel+factory1_fuel;
         food = food+factory1_food;
         steel = steel+factory1_steel;
         time = time+factory1_time;
         alloy = alloy+factory1_alloy;
         //Required_2
         adapter.add("[BUILD] War Factory lv2");
         fuel = fuel+factory2_fuel;
         food = food+factory2_food;
         steel = steel+factory2_steel;
         time = time+factory2_time;
         alloy = alloy+factory2_alloy;
         //Required_3
         adapter.add("[BUILD] War Factory lv3");
         fuel = fuel+factory3_fuel;
         food = food+factory3_food;
         steel = steel+factory3_steel;
         time = time+factory3_time;
         alloy = alloy+factory3_alloy;
         //Required_4
         adapter.add("[BUILD] War Factory lv4");
         fuel = fuel+factory4_fuel;
         food = food+factory4_food;
         steel = steel+factory4_steel;
         time = time+factory4_time;
         alloy = alloy+factory4_alloy;
         //Required_5
         adapter.add("[BUILD] War Factory lv5");
         fuel = fuel+factory5_fuel;
         food = food+factory5_food;
         steel = steel+factory5_steel;
         time = time+factory5_time;
         alloy = alloy+factory5_alloy;
         //Required_6
         adapter.add("[BUILD] War Factory lv6");
         fuel = fuel+factory6_fuel;
         food = food+factory6_food;
         steel = steel+factory6_steel;
         time = time+factory6_time;
         alloy = alloy+factory6_alloy;
         //Required_7
         adapter.add("[BUILD] War Factory lv7");
         fuel = fuel+factory7_fuel;
         food = food+factory7_food;
         steel = steel+factory7_steel;
         time = time+factory7_time;
         alloy = alloy+factory7_alloy;
         //Required_8
         adapter.add("[BUILD] War Factory lv8");
         fuel = fuel+factory8_fuel;
         food = food+factory8_food;
         steel = steel+factory8_steel;
         time = time+factory8_time;
         alloy = alloy+factory8_alloy;
         //Required_9
         adapter.add("[BUILD] War Factory lv9");
         fuel = fuel+factory9_fuel;
         food = food+factory9_food;
         steel = steel+factory9_steel;
         time = time+factory9_time;
         alloy = alloy+factory9_alloy;
         //Required_10
         adapter.add("[BUILD] War Factory lv10");
         fuel = fuel+factory10_fuel;
         food = food+factory10_food;
         steel = steel+factory10_steel;
         time = time+factory10_time;
         alloy = alloy+factory10_alloy;
         //Required_11
         adapter.add("[BUILD] War Factory lv11");
         fuel = fuel+factory11_fuel;
         food = food+factory11_food;
         steel = steel+factory11_steel;
         time = time+factory11_time;
         alloy = alloy+factory11_alloy;
         //Required_12
         adapter.add("[BUILD] War Factory lv12");
         fuel = fuel+factory12_fuel;
         food = food+factory12_food;
         steel = steel+factory12_steel;
         time = time+factory12_time;
         alloy = alloy+factory12_alloy;
         //Required_13
         adapter.add("[BUILD] War Factory lv13");
         fuel = fuel+factory13_fuel;
         food = food+factory13_food;
         steel = steel+factory13_steel;
         time = time+factory13_time;
         alloy = alloy+factory13_alloy;
         //Required_14
         adapter.add("[BUILD] War Factory lv14");
         fuel = fuel+factory14_fuel;
         food = food+factory14_food;
         steel = steel+factory14_steel;
         time = time+factory14_time;
         alloy = alloy+factory14_alloy;
         //TB
         adapter.add("[BUILD] Build TB lv15");
         fuel = fuel+tb15_fuel;
         food = food+tb15_food;
         steel = steel+tb15_steel;
         alloy = alloy+tb15_alloy;
         time = time+tb15_time;
         }
         //TB16
         if (now < 16 && aim >= 16){
         //WALL
         adapter.add("[BUILD] Wall lv15");
         fuel = fuel+wall15_fuel;
         food = food+wall15_food;
         steel = steel+wall15_steel;
         alloy = alloy+wall15_alloy;
         time = time+wall15_time;
         //Required_1
         adapter.add("[BUILD] Alloy Mine lv1");
         fuel = fuel+alloy_m1_fuel;
         time = time+alloy_m1_time;
         //Required_2
         adapter.add("[BUILD] Alloy Mine lv2");
         fuel = fuel+alloy_m2_fuel;
         time = time+alloy_m2_time;
         //Required_3
         adapter.add("[BUILD] Alloy Mine lv3");
         fuel = fuel+alloy_m3_fuel;
         time = time+alloy_m3_time;
         //Required_4
         adapter.add("[BUILD] Alloy Mine lv4");
         fuel = fuel+alloy_m4_fuel;
         time = time+alloy_m4_time;
         //Required_5
         adapter.add("[BUILD] Alloy Mine lv5");
         fuel = fuel+alloy_m5_fuel;
         time = time+alloy_m5_time;
         //Required_6
         adapter.add("[BUILD] Alloy Mine lv6");
         fuel = fuel+alloy_m6_fuel;
         time = time+alloy_m6_time;
         //Required_7
         adapter.add("[BUILD] Alloy Mine lv7");
         fuel = fuel+alloy_m7_fuel;
         time = time+alloy_m7_time;
         //Required_8
         adapter.add("[BUILD] Alloy Mine lv8");
         fuel = fuel+alloy_m8_fuel;
         time = time+alloy_m8_time;
         //Required_9
         adapter.add("[BUILD] Alloy Mine lv9");
         fuel = fuel+alloy_m9_fuel;
         time = time+alloy_m9_time;
         //Required_10
         adapter.add("[BUILD] Alloy Mine lv10");
         fuel = fuel+alloy_m10_fuel;
         time = time+alloy_m10_time;
         //Required_11
         adapter.add("[BUILD] Alloy Mine lv11");
         fuel = fuel+alloy_m11_fuel;
         time = time+alloy_m11_time;
         //Required_12
         adapter.add("[BUILD] Alloy Mine lv12");
         fuel = fuel+alloy_m12_fuel;
         time = time+alloy_m12_time;
         //Required_13
         adapter.add("[BUILD] Alloy Mine lv13");
         fuel = fuel+alloy_m13_fuel;
         time = time+alloy_m13_time;
         //Required_14
         adapter.add("[BUILD] Alloy Mine lv14");
         fuel = fuel+alloy_m14_fuel;
         time = time+alloy_m14_time;
         //Required_15
         adapter.add("[BUILD] Alloy Mine lv15");
         fuel = fuel+alloy_m15_fuel;
         time = time+alloy_m15_time;
         //TB
         adapter.add("[BUILD] Build TB lv16");
         fuel = fuel+tb16_fuel;
         food = food+tb16_food;
         steel = steel+tb16_steel;
         alloy = alloy+tb16_alloy;
         time = time+tb16_time;

         }
         //TB16
         if (now < 17 && aim >= 17){
         //WALL
         adapter.add("[BUILD] Wall lv16");
         fuel = fuel+wall16_fuel;
         food = food+wall16_food;
         steel = steel+wall16_steel;
         alloy = alloy+wall16_alloy;
         time = time+wall16_time;
         //Required_1
         adapter.add("[BUILD] Steel Mill lv1");
         fuel = fuel+steel_fuel1;
         time = time+steel1_time;
         //Required_2
         adapter.add("[BUILD] Steel Mill lv2");
         fuel = fuel+steel_fuel2;
         time = time+steel2_time;
         //Required_3
         adapter.add("[BUILD] Steel Mill lv3");
         fuel = fuel+steel_fuel3;
         time = time+steel3_time;
         //Required_4
         adapter.add("[BUILD] Steel Mill lv4");
         fuel = fuel+steel_fuel4;
         time = time+steel4_time;
         //Required_5
         adapter.add("[BUILD] Steel Mill lv5");
         fuel = fuel+steel_fuel5;
         time = time+steel5_time;
         //Required_6
         adapter.add("[BUILD] Steel Mill lv6");
         fuel = fuel+steel_fuel6;
         time = time+steel6_time;
         //Required_7
         adapter.add("[BUILD] Steel Mill lv7");
         fuel = fuel+steel_fuel7;
         time = time+steel7_time;
         //Required_8
         adapter.add("[BUILD] Steel Mill lv8");
         fuel = fuel+steel_fuel8;
         time = time+steel8_time;
         //Required_9
         adapter.add("[BUILD] Steel Mill lv9");
         fuel = fuel+steel_fuel9;
         time = time+steel9_time;
         //Required_10
         adapter.add("[BUILD] Steel Mill lv10");
         fuel = fuel+steel_fuel10;
         time = time+steel10_time;
         //Required_11
         adapter.add("[BUILD] Steel Mill lv11");
         fuel = fuel+steel_fuel11;
         time = time+steel11_time;
         //Required_12
         adapter.add("[BUILD] Steel Mill lv12");
         fuel = fuel+steel_fuel12;
         time = time+steel12_time;
         //Required_13
         adapter.add("[BUILD] Steel Mill lv13");
         fuel = fuel+steel_fuel13;
         time = time+steel13_time;
         //Required_14
         adapter.add("[BUILD] Steel Mill lv14");
         fuel = fuel+steel_fuel14;
         time = time+steel14_time;
         //Required_15
         adapter.add("[BUILD] Steel Mill lv15");
         fuel = fuel+steel_fuel15;
         time = time+steel15_time;
         //Required_16
         adapter.add("[BUILD] Steel Mill lv16");
         fuel = fuel+steel_fuel16;
         time = time+steel16_time;
         //TB
         adapter.add("[BUILD] Build TB lv17");
         fuel = fuel+tb17_fuel;
         food = food+tb17_food;
         steel = steel+tb17_steel;
         alloy = alloy+tb17_alloy;
         time = time+tb17_time;
         }
         //TB18
         if (now < 18 && aim >= 18){
         //WALL
         adapter.add("[BUILD] Wall lv17");
         fuel = fuel+wall17_fuel;
         food = food+wall17_food;
         steel = steel+wall17_steel;
         alloy = alloy+wall17_alloy;
         time = time+wall17_time;
         //TB
         adapter.add("[BUILD] Build TB lv18");
         fuel = fuel+tb18_fuel;
         food = food+tb18_food;
         steel = steel+tb18_steel;
         alloy = alloy+tb18_alloy;
         time = time+tb18_time;
         }
         //TB19
         if (now < 19 && aim >= 19){
         //WALL
         adapter.add("[BUILD] Wall lv18");
         fuel = fuel+wall18_fuel;
         food = food+wall18_food;
         steel = steel+wall18_steel;
         alloy = alloy+wall18_alloy;
         time = time+wall18_time;
         //Required_2
         adapter.add("[BUILD] Embassy lv2");
         fuel = fuel+embassy2_fuel;
         food = food+embassy2_food;
         steel = steel+embassy2_steel;
         time = time+embassy2_time;
         alloy = alloy+embassy2_alloy;
         //Required_3
         adapter.add("[BUILD] Embassy lv3");
         fuel = fuel+embassy3_fuel;
         food = food+embassy3_food;
         steel = steel+embassy3_steel;
         time = time+embassy3_time;
         alloy = alloy+embassy3_alloy;
         //Required_4
         adapter.add("[BUILD] Embassy lv4");
         fuel = fuel+embassy4_fuel;
         food = food+embassy4_food;
         steel = steel+embassy4_steel;
         time = time+embassy4_time;
         alloy = alloy+embassy4_alloy;
         //Required_5
         adapter.add("[BUILD] Embassy lv5");
         fuel = fuel+embassy5_fuel;
         food = food+embassy5_food;
         steel = steel+embassy5_steel;
         time = time+embassy5_time;
         alloy = alloy+embassy5_alloy;
         //Required_6
         adapter.add("[BUILD] Embassy lv6");
         fuel = fuel+embassy6_fuel;
         food = food+embassy6_food;
         steel = steel+embassy6_steel;
         time = time+embassy6_time;
         alloy = alloy+embassy6_alloy;
         //Required_7
         adapter.add("[BUILD] Embassy lv7");
         fuel = fuel+embassy7_fuel;
         food = food+embassy7_food;
         steel = steel+embassy7_steel;
         time = time+embassy7_time;
         alloy = alloy+embassy7_alloy;
         //Required_8
         adapter.add("[BUILD] Embassy lv8");
         fuel = fuel+embassy8_fuel;
         food = food+embassy8_food;
         steel = steel+embassy8_steel;
         time = time+embassy8_time;
         alloy = alloy+embassy8_alloy;
         //Required_9
         adapter.add("[BUILD] Embassy lv9");
         fuel = fuel+embassy9_fuel;
         food = food+embassy9_food;
         steel = steel+embassy9_steel;
         time = time+embassy9_time;
         alloy = alloy+embassy9_alloy;
         //Required_10
         adapter.add("[BUILD] Embassy lv10");
         fuel = fuel+embassy10_fuel;
         food = food+embassy10_food;
         steel = steel+embassy10_steel;
         time = time+embassy10_time;
         alloy = alloy+embassy10_alloy;
         //Required_11
         adapter.add("[BUILD] Embassy lv11");
         fuel = fuel+embassy11_fuel;
         food = food+embassy11_food;
         steel = steel+embassy11_steel;
         time = time+embassy11_time;
         alloy = alloy+embassy11_alloy;
         //Required_12
         adapter.add("[BUILD] Embassy lv12");
         fuel = fuel+embassy12_fuel;
         food = food+embassy12_food;
         steel = steel+embassy12_steel;
         time = time+embassy12_time;
         alloy = alloy+embassy12_alloy;
         //Required_13
         adapter.add("[BUILD] Embassy lv13");
         fuel = fuel+embassy13_fuel;
         food = food+embassy13_food;
         steel = steel+embassy13_steel;
         time = time+embassy13_time;
         alloy = alloy+embassy13_alloy;
         //Required_14
         adapter.add("[BUILD] Embassy lv14");
         fuel = fuel+embassy14_fuel;
         food = food+embassy14_food;
         steel = steel+embassy14_steel;
         time = time+embassy14_time;
         alloy = alloy+embassy14_alloy;
         //Required_15
         adapter.add("[BUILD] Embassy lv15");
         fuel = fuel+embassy15_fuel;
         food = food+embassy15_food;
         steel = steel+embassy15_steel;
         time = time+embassy15_time;
         alloy = alloy+embassy15_alloy;
         //Required_16
         adapter.add("[BUILD] Embassy lv16");
         fuel = fuel+embassy16_fuel;
         food = food+embassy16_food;
         steel = steel+embassy16_steel;
         time = time+embassy16_time;
         alloy = alloy+embassy16_alloy;
         //Required_17
         adapter.add("[BUILD] Embassy lv17");
         fuel = fuel+embassy17_fuel;
         food = food+embassy17_food;
         steel = steel+embassy17_steel;
         time = time+embassy17_time;
         alloy = alloy+embassy17_alloy;
         //Required_18
         adapter.add("[BUILD] Embassy lv18");
         fuel = fuel+embassy18_fuel;
         food = food+embassy18_food;
         steel = steel+embassy18_steel;
         time = time+embassy18_time;
         alloy = alloy+embassy18_alloy;
         //TB
         adapter.add("[BUILD] Build TB lv19");
         fuel = fuel+tb19_fuel;
         food = food+tb19_food;
         steel = steel+tb19_steel;
         alloy = alloy+tb19_alloy;
         time = time+tb19_time;
         }
         //TB20
         if (now < 20 && aim >= 20){
         //WALL
         adapter.add("[BUILD] Wall lv19");
         fuel = fuel+wall19_fuel;
         food = food+wall19_food;
         steel = steel+wall19_steel;
         alloy = alloy+wall19_alloy;
         time = time+wall19_time;
         //TB
         adapter.add("[BUILD] Build TB lv20");
         fuel = fuel+tb20_fuel;
         food = food+tb20_food;
         steel = steel+tb20_steel;
         alloy = alloy+tb20_alloy;
         time = time+tb20_time;
         }
         //TB21
         if (now < 21 && aim >= 21){
         //WALL
         adapter.add("[BUILD] Wall lv20");
         fuel = fuel+wall20_fuel;
         food = food+wall20_food;
         steel = steel+wall20_steel;
         alloy = alloy+wall20_alloy;
         time = time+wall20_time;
         //TB
         adapter.add("[BUILD] Build TB lv21");
         fuel = fuel+tb21_fuel;
         food = food+tb21_food;
         steel = steel+tb21_steel;
         alloy = alloy+tb21_alloy;
         time = time+tb21_time;
         }
         //TB22
         if (now < 22 && aim >= 22){
         //WALL
         adapter.add("[BUILD] Wall lv21");
         fuel = fuel+wall21_fuel;
         food = food+wall21_food;
         steel = steel+wall21_steel;
         alloy = alloy+wall21_alloy;
         time = time+wall21_time;
         //TB
         adapter.add("[BUILD] Build TB lv22");
         fuel = fuel+tb22_fuel;
         food = food+tb22_food;
         steel = steel+tb22_steel;
         alloy = alloy+tb22_alloy;
         time = time+tb22_time;
         }
         //TB23
         if (now < 23 && aim >= 23){
         //WALL
         adapter.add("[BUILD] Wall lv22");
         fuel = fuel+wall22_fuel;
         food = food+wall22_food;
         steel = steel+wall22_steel;
         alloy = alloy+wall22_alloy;
         time = time+wall22_time;
         //Required_1
         adapter.add("[BUILD] Military Office lv1");
         fuel = fuel+military1_fuel;
         food = food+military1_food;
         steel = steel+military1_steel;
         time = time+military1_time;
         alloy = alloy+military1_alloy;
         //Required_2
         adapter.add("[BUILD] Military Office lv2");
         fuel = fuel+military2_fuel;
         food = food+military2_food;
         steel = steel+military2_steel;
         time = time+military2_time;
         alloy = alloy+military2_alloy;
         //Required_3
         adapter.add("[BUILD] Military Office lv3");
         fuel = fuel+military3_fuel;
         food = food+military3_food;
         steel = steel+military3_steel;
         time = time+military3_time;
         alloy = alloy+military3_alloy;
         //Required_4
         adapter.add("[BUILD] Military Office lv4");
         fuel = fuel+military4_fuel;
         food = food+military4_food;
         steel = steel+military4_steel;
         time = time+military4_time;
         alloy = alloy+military4_alloy;
         //Required_5
         adapter.add("[BUILD] Military Office lv5");
         fuel = fuel+military5_fuel;
         food = food+military5_food;
         steel = steel+military5_steel;
         time = time+military5_time;
         alloy = alloy+military5_alloy;
         //Required_6
         adapter.add("[BUILD] Military Office lv6");
         fuel = fuel+military6_fuel;
         food = food+military6_food;
         steel = steel+military6_steel;
         time = time+military6_time;
         alloy = alloy+military6_alloy;
         //Required_7
         adapter.add("[BUILD] Military Office lv7");
         fuel = fuel+military7_fuel;
         food = food+military7_food;
         steel = steel+military7_steel;
         time = time+military7_time;
         alloy = alloy+military7_alloy;
         //Required_8
         adapter.add("[BUILD] Military Office lv8");
         fuel = fuel+military8_fuel;
         food = food+military8_food;
         steel = steel+military8_steel;
         time = time+military8_time;
         alloy = alloy+military8_alloy;
         //Required_9
         adapter.add("[BUILD] Military Office lv9");
         fuel = fuel+military9_fuel;
         food = food+military9_food;
         steel = steel+military9_steel;
         time = time+military9_time;
         alloy = alloy+military9_alloy;
         //Required_10
         adapter.add("[BUILD] Military Office lv10");
         fuel = fuel+military10_fuel;
         food = food+military10_food;
         steel = steel+military10_steel;
         time = time+military10_time;
         alloy = alloy+military10_alloy;
         //Required_11
         adapter.add("[BUILD] Military Office lv11");
         fuel = fuel+military11_fuel;
         food = food+military11_food;
         steel = steel+military11_steel;
         time = time+military11_time;
         alloy = alloy+military11_alloy;
         //Required_12
         adapter.add("[BUILD] Military Office lv12");
         fuel = fuel+military12_fuel;
         food = food+military12_food;
         steel = steel+military12_steel;
         time = time+military12_time;
         alloy = alloy+military12_alloy;
         //Required_13
         adapter.add("[BUILD] Military Office lv13");
         fuel = fuel+military13_fuel;
         food = food+military13_food;
         steel = steel+military13_steel;
         time = time+military13_time;
         alloy = alloy+military13_alloy;
         //Required_14
         adapter.add("[BUILD] Military Office lv14");
         fuel = fuel+military14_fuel;
         food = food+military14_food;
         steel = steel+military14_steel;
         time = time+military14_time;
         alloy = alloy+military14_alloy;
         //Required_15
         adapter.add("[BUILD] Military Office lv15");
         fuel = fuel+military15_fuel;
         food = food+military15_food;
         steel = steel+military15_steel;
         time = time+military15_time;
         alloy = alloy+military15_alloy;
         //Required_16
         adapter.add("[BUILD] Military Office lv16");
         fuel = fuel+military16_fuel;
         food = food+military16_food;
         steel = steel+military16_steel;
         time = time+military16_time;
         alloy = alloy+military16_alloy;
         //Required_17
         adapter.add("[BUILD] Military Office lv17");
         fuel = fuel+military17_fuel;
         food = food+military17_food;
         steel = steel+military17_steel;
         time = time+military17_time;
         alloy = alloy+military17_alloy;
         //Required_18
         adapter.add("[BUILD] Military Office lv18");
         fuel = fuel+military18_fuel;
         food = food+military18_food;
         steel = steel+military18_steel;
         time = time+military18_time;
         alloy = alloy+military18_alloy;
         //Required_19
         adapter.add("[BUILD] Military Office lv19");
         fuel = fuel+military19_fuel;
         food = food+military19_food;
         steel = steel+military19_steel;
         time = time+military19_time;
         alloy = alloy+military19_alloy;
         //Required_20
         adapter.add("[BUILD] Military Office lv20");
         fuel = fuel+military20_fuel;
         food = food+military20_food;
         steel = steel+military20_steel;
         time = time+military20_time;
         alloy = alloy+military20_alloy;
         //Required_21
         adapter.add("[BUILD] Military Office lv21");
         fuel = fuel+military21_fuel;
         food = food+military21_food;
         steel = steel+military21_steel;
         time = time+military21_time;
         alloy = alloy+military21_alloy;
         //Required_22
         adapter.add("[BUILD] Military Office lv22");
         fuel = fuel+military22_fuel;
         food = food+military22_food;
         steel = steel+military22_steel;
         time = time+military22_time;
         alloy = alloy+military22_alloy;
         //TB
         adapter.add("[BUILD] Build TB lv23");
         fuel = fuel+tb23_fuel;
         food = food+tb23_food;
         steel = steel+tb23_steel;
         alloy = alloy+tb23_alloy;
         time = time+tb23_time;
         }
         //TB24
         if (now < 24 && aim >= 24){
         //WALL
         adapter.add("[BUILD] Wall lv23");
         fuel = fuel+wall23_fuel;
         food = food+wall23_food;
         steel = steel+wall23_steel;
         alloy = alloy+wall23_alloy;
         time = time+wall23_time;
         //TB
         adapter.add("[BUILD] Build TB lv24");
         fuel = fuel+tb24_fuel;
         food = food+tb24_food;
         steel = steel+tb24_steel;
         alloy = alloy+tb24_alloy;
         time = time+tb24_time;
         }
         //TB25
         if (now < 25 && aim >= 25){
         //WALL
         adapter.add("[BUILD] Wall lv24");
         fuel = fuel+wall24_fuel;
         food = food+wall24_food;
         steel = steel+wall24_steel;
         alloy = alloy+wall24_alloy;
         time = time+wall24_time;
         //TB
         adapter.add("[BUILD] Build TB lv25");
         fuel = fuel+tb25_fuel;
         food = food+tb25_food;
         steel = steel+tb25_steel;
         alloy = alloy+tb25_alloy;
         time = time+tb25_time;
         }
         //TB26
         if (now < 26 && aim >= 26){
         //WALL
         adapter.add("[BUILD] Wall lv25");
         fuel = fuel+wall25_fuel;
         food = food+wall25_food;
         steel = steel+wall25_steel;
         alloy = alloy+wall25_alloy;
         time = time+wall25_time;
         //Required_19
         adapter.add("[BUILD] Embassy lv19");
         fuel = fuel+embassy19_fuel;
         food = food+embassy19_food;
         steel = steel+embassy19_steel;
         time = time+embassy19_time;
         alloy = alloy+embassy19_alloy;
         //Required_20
         adapter.add("[BUILD] Embassy lv20");
         fuel = fuel+embassy20_fuel;
         food = food+embassy20_food;
         steel = steel+embassy20_steel;
         time = time+embassy20_time;
         alloy = alloy+embassy20_alloy;
         //Required_21
         adapter.add("[BUILD] Embassy lv21");
         fuel = fuel+embassy21_fuel;
         food = food+embassy21_food;
         steel = steel+embassy21_steel;
         time = time+embassy21_time;
         alloy = alloy+embassy21_alloy;
         //Required_22
         adapter.add("[BUILD] Embassy lv22");
         fuel = fuel+embassy22_fuel;
         food = food+embassy22_food;
         steel = steel+embassy22_steel;
         time = time+embassy22_time;
         alloy = alloy+embassy22_alloy;
         //Required_23
         adapter.add("[BUILD] Embassy lv23");
         fuel = fuel+embassy23_fuel;
         food = food+embassy23_food;
         steel = steel+embassy23_steel;
         time = time+embassy23_time;
         alloy = alloy+embassy23_alloy;
         //Required_24
         adapter.add("[BUILD] Embassy lv24");
         fuel = fuel+embassy24_fuel;
         food = food+embassy24_food;
         steel = steel+embassy24_steel;
         time = time+embassy24_time;
         alloy = alloy+embassy24_alloy;
         //Required_25
         adapter.add("[BUILD] Embassy lv25");
         fuel = fuel+embassy25_fuel;
         food = food+embassy25_food;
         steel = steel+embassy25_steel;
         time = time+embassy25_time;
         alloy = alloy+embassy25_alloy;
         //TB
         adapter.add("[BUILD] Build TB lv26");
         fuel = fuel+tb26_fuel;
         food = food+tb26_food;
         steel = steel+tb26_steel;
         alloy = alloy+tb26_alloy;
         time = time+tb26_time;
         }
         //TB27
         if (now < 27 && aim >= 27){
         //WALL
         adapter.add("[BUILD] Wall lv26");
         fuel = fuel+wall26_fuel;
         food = food+wall26_food;
         steel = steel+wall26_steel;
         alloy = alloy+wall26_alloy;
         time = time+wall26_time;
         //Required_10
         adapter.add("[BUILD] Storeroom lv10");
         fuel = fuel+store10_fuel;
         food = food+store10_food;
         time = time+store10_time;
         alloy = alloy+store10_alloy;
         //Required_11
         adapter.add("[BUILD] Storeroom lv11");
         fuel = fuel+store11_fuel;
         food = food+store11_food;
         time = time+store11_time;
         alloy = alloy+store11_alloy;
         //Required_12
         adapter.add("[BUILD] Storeroom lv12");
         fuel = fuel+store12_fuel;
         food = food+store12_food;
         time = time+store12_time;
         alloy = alloy+store12_alloy;
         //Required_13
         adapter.add("[BUILD] Storeroom lv13");
         fuel = fuel+store13_fuel;
         food = food+store13_food;
         time = time+store13_time;
         alloy = alloy+store13_alloy;
         //Required_14
         adapter.add("[BUILD] Storeroom lv14");
         fuel = fuel+store14_fuel;
         food = food+store14_food;
         time = time+store14_time;
         alloy = alloy+store14_alloy;
         //Required_15
         adapter.add("[BUILD] Storeroom lv15");
         fuel = fuel+store15_fuel;
         food = food+store15_food;
         time = time+store15_time;
         alloy = alloy+store15_alloy;
         //Required_16
         adapter.add("[BUILD] Storeroom lv16");
         fuel = fuel+store16_fuel;
         food = food+store16_food;
         time = time+store16_time;
         alloy = alloy+store16_alloy;
         //Required_17
         adapter.add("[BUILD] Storeroom lv17");
         fuel = fuel+store17_fuel;
         food = food+store17_food;
         time = time+store17_time;
         alloy = alloy+store17_alloy;
         //Required_18
         adapter.add("[BUILD] Storeroom lv18");
         fuel = fuel+store18_fuel;
         food = food+store18_food;
         time = time+store18_time;
         alloy = alloy+store18_alloy;
         //Required_19
         adapter.add("[BUILD] Storeroom lv19");
         fuel = fuel+store19_fuel;
         food = food+store19_food;
         time = time+store19_time;
         alloy = alloy+store19_alloy;
         //Required_20
         adapter.add("[BUILD] Storeroom lv20");
         fuel = fuel+store20_fuel;
         food = food+store20_food;
         time = time+store20_time;
         alloy = alloy+store20_alloy;
         //Required_21
         adapter.add("[BUILD] Storeroom lv21");
         fuel = fuel+store21_fuel;
         food = food+store21_food;
         time = time+store21_time;
         alloy = alloy+store21_alloy;
         //Required_22
         adapter.add("[BUILD] Storeroom lv22");
         fuel = fuel+store22_fuel;
         food = food+store22_food;
         time = time+store22_time;
         alloy = alloy+store22_alloy;
         //Required_23
         adapter.add("[BUILD] Storeroom lv23");
         fuel = fuel+store23_fuel;
         food = food+store23_food;
         time = time+store23_time;
         alloy = alloy+store23_alloy;
         //Required_24
         adapter.add("[BUILD] Storeroom lv24");
         fuel = fuel+store24_fuel;
         food = food+store24_food;
         time = time+store24_time;
         alloy = alloy+store24_alloy;
         //Required_25
         adapter.add("[BUILD] Storeroom lv25");
         fuel = fuel+store25_fuel;
         food = food+store25_food;
         time = time+store25_time;
         alloy = alloy+store25_alloy;
         //Required_26
         adapter.add("[BUILD] Storeroom lv26");
         fuel = fuel+store26_fuel;
         food = food+store26_food;
         time = time+store26_time;
         alloy = alloy+store26_alloy;
         //TB
         adapter.add("[BUILD] Build TB lv27");
         fuel = fuel+tb27_fuel;
         food = food+tb27_food;
         steel = steel+tb27_steel;
         alloy = alloy+tb27_alloy;
         time = time+tb27_time;
         }
         //TB28
         if (now < 28 && aim >= 28){
         //WALL
         adapter.add("[BUILD] Wall lv27");
         fuel = fuel+wall27_fuel;
         food = food+wall27_food;
         steel = steel+wall27_steel;
         alloy = alloy+wall27_alloy;
         time = time+wall27_time;
         //Required_23
         adapter.add("[BUILD] Military Office lv23");
         fuel = fuel+military23_fuel;
         food = food+military23_food;
         steel = steel+military23_steel;
         time = time+military23_time;
         alloy = alloy+military23_alloy;
         //Required_24
         adapter.add("[BUILD] Military Office lv24");
         fuel = fuel+military24_fuel;
         food = food+military24_food;
         steel = steel+military24_steel;
         time = time+military24_time;
         alloy = alloy+military24_alloy;
         //Required_25
         adapter.add("[BUILD] Military Office lv25");
         fuel = fuel+military25_fuel;
         food = food+military25_food;
         steel = steel+military25_steel;
         time = time+military25_time;
         alloy = alloy+military25_alloy;
         //Required_26
         adapter.add("[BUILD] Military Office lv26");
         fuel = fuel+military26_fuel;
         food = food+military26_food;
         steel = steel+military26_steel;
         time = time+military26_time;
         alloy = alloy+military26_alloy;
         //Required_27
         adapter.add("[BUILD] Military Office lv27");
         fuel = fuel+military27_fuel;
         food = food+military27_food;
         steel = steel+military27_steel;
         time = time+military27_time;
         alloy = alloy+military27_alloy;
         //TB
         adapter.add("[BUILD] Build TB lv28");
         fuel = fuel+tb28_fuel;
         food = food+tb28_food;
         steel = steel+tb28_steel;
         alloy = alloy+tb28_alloy;
         time = time+tb28_time;
         }
         //TB29
         if (now < 29 && aim >= 29){
         //WALL
         adapter.add("[BUILD] Wall lv28");
         fuel = fuel+wall28_fuel;
         food = food+wall28_food;
         steel = steel+wall28_steel;
         alloy = alloy+wall28_alloy;
         time = time+wall28_time;
         //Required_1
         adapter.add("[BUILD] Cafeteria lv1");
         fuel = fuel+cafe1_fuel;
         food = food+cafe1_food;
         steel = steel+cafe1_steel;
         time = time+cafe1_time;
         alloy = alloy+cafe1_alloy;
         //Required_2
         adapter.add("[BUILD] Cafeteria lv2");
         fuel = fuel+cafe2_fuel;
         food = food+cafe2_food;
         steel = steel+cafe2_steel;
         time = time+cafe2_time;
         alloy = alloy+cafe2_alloy;
         //Required_3
         adapter.add("[BUILD] Cafeteria lv3");
         fuel = fuel+cafe3_fuel;
         food = food+cafe3_food;
         steel = steel+cafe3_steel;
         time = time+cafe3_time;
         alloy = alloy+cafe3_alloy;
         //Required_4
         adapter.add("[BUILD] Cafeteria lv4");
         fuel = fuel+cafe4_fuel;
         food = food+cafe4_food;
         steel = steel+cafe4_steel;
         time = time+cafe4_time;
         alloy = alloy+cafe4_alloy;
         //Required_5
         adapter.add("[BUILD] Cafeteria lv5");
         fuel = fuel+cafe5_fuel;
         food = food+cafe5_food;
         steel = steel+cafe5_steel;
         time = time+cafe5_time;
         alloy = alloy+cafe5_alloy;
         //Required_6
         adapter.add("[BUILD] Cafeteria lv6");
         fuel = fuel+cafe6_fuel;
         food = food+cafe6_food;
         steel = steel+cafe6_steel;
         time = time+cafe6_time;
         alloy = alloy+cafe6_alloy;
         //Required_7
         adapter.add("[BUILD] Cafeteria lv7");
         fuel = fuel+cafe7_fuel;
         food = food+cafe7_food;
         steel = steel+cafe7_steel;
         time = time+cafe7_time;
         alloy = alloy+cafe7_alloy;
         //Required_8
         adapter.add("[BUILD] Cafeteria lv8");
         fuel = fuel+cafe8_fuel;
         food = food+cafe8_food;
         steel = steel+cafe8_steel;
         time = time+cafe8_time;
         alloy = alloy+cafe8_alloy;
         //Required_9
         adapter.add("[BUILD] Cafeteria lv9");
         fuel = fuel+cafe9_fuel;
         food = food+cafe9_food;
         steel = steel+cafe9_steel;
         time = time+cafe9_time;
         alloy = alloy+cafe9_alloy;
         //Required_10
         adapter.add("[BUILD] Cafeteria lv10");
         fuel = fuel+cafe10_fuel;
         food = food+cafe10_food;
         steel = steel+cafe10_steel;
         time = time+cafe10_time;
         alloy = alloy+cafe10_alloy;
         //Required_11
         adapter.add("[BUILD] Cafeteria lv11");
         fuel = fuel+cafe11_fuel;
         food = food+cafe11_food;
         steel = steel+cafe11_steel;
         time = time+cafe11_time;
         alloy = alloy+cafe11_alloy;
         //Required_12
         adapter.add("[BUILD] Cafeteria lv12");
         fuel = fuel+cafe12_fuel;
         food = food+cafe12_food;
         steel = steel+cafe12_steel;
         time = time+cafe12_time;
         alloy = alloy+cafe12_alloy;
         //Required_13
         adapter.add("[BUILD] Cafeteria lv13");
         fuel = fuel+cafe13_fuel;
         food = food+cafe13_food;
         steel = steel+cafe13_steel;
         time = time+cafe13_time;
         alloy = alloy+cafe13_alloy;
         //Required_14
         adapter.add("[BUILD] Cafeteria lv14");
         fuel = fuel+cafe14_fuel;
         food = food+cafe14_food;
         steel = steel+cafe14_steel;
         time = time+cafe14_time;
         alloy = alloy+cafe14_alloy;
         //Required_15
         adapter.add("[BUILD] Cafeteria lv15");
         fuel = fuel+cafe15_fuel;
         food = food+cafe15_food;
         steel = steel+cafe15_steel;
         time = time+cafe15_time;
         alloy = alloy+cafe15_alloy;
         //Required_16
         adapter.add("[BUILD] Cafeteria lv16");
         fuel = fuel+cafe16_fuel;
         food = food+cafe16_food;
         steel = steel+cafe16_steel;
         time = time+cafe16_time;
         alloy = alloy+cafe16_alloy;
         //Required_17
         adapter.add("[BUILD] Cafeteria lv17");
         fuel = fuel+cafe17_fuel;
         food = food+cafe17_food;
         steel = steel+cafe17_steel;
         time = time+cafe17_time;
         alloy = alloy+cafe17_alloy;
         //Required_18
         adapter.add("[BUILD] Cafeteria lv18");
         fuel = fuel+cafe18_fuel;
         food = food+cafe18_food;
         steel = steel+cafe18_steel;
         time = time+cafe18_time;
         alloy = alloy+cafe18_alloy;
         //Required_19
         adapter.add("[BUILD] Cafeteria lv19");
         fuel = fuel+cafe19_fuel;
         food = food+cafe19_food;
         steel = steel+cafe19_steel;
         time = time+cafe19_time;
         alloy = alloy+cafe19_alloy;
         //Required_20
         adapter.add("[BUILD] Cafeteria lv20");
         fuel = fuel+cafe20_fuel;
         food = food+cafe20_food;
         steel = steel+cafe20_steel;
         time = time+cafe20_time;
         alloy = alloy+cafe20_alloy;
         //Required_21
         adapter.add("[BUILD] Cafeteria lv21");
         fuel = fuel+cafe21_fuel;
         food = food+cafe21_food;
         steel = steel+cafe21_steel;
         time = time+cafe21_time;
         alloy = alloy+cafe21_alloy;
         //Required_22
         adapter.add("[BUILD] Cafeteria lv22");
         fuel = fuel+cafe22_fuel;
         food = food+cafe22_food;
         steel = steel+cafe22_steel;
         time = time+cafe22_time;
         alloy = alloy+cafe22_alloy;
         //Required_23
         adapter.add("[BUILD] Cafeteria lv23");
         fuel = fuel+cafe23_fuel;
         food = food+cafe23_food;
         steel = steel+cafe23_steel;
         time = time+cafe23_time;
         alloy = alloy+cafe23_alloy;
         //Required_24
         adapter.add("[BUILD] Cafeteria lv24");
         fuel = fuel+cafe24_fuel;
         food = food+cafe24_food;
         steel = steel+cafe24_steel;
         time = time+cafe24_time;
         alloy = alloy+cafe24_alloy;
         //Required_25
         adapter.add("[BUILD] Cafeteria lv25");
         fuel = fuel+cafe25_fuel;
         food = food+cafe25_food;
         steel = steel+cafe25_steel;
         time = time+cafe25_time;
         alloy = alloy+cafe25_alloy;
         //Required_26
         adapter.add("[BUILD] Cafeteria lv26");
         fuel = fuel+cafe26_fuel;
         food = food+cafe26_food;
         steel = steel+cafe26_steel;
         time = time+cafe26_time;
         alloy = alloy+cafe26_alloy;
         //Required_27
         adapter.add("[BUILD] Cafeteria lv27");
         fuel = fuel+cafe27_fuel;
         food = food+cafe27_food;
         steel = steel+cafe27_steel;
         time = time+cafe27_time;
         alloy = alloy+cafe27_alloy;
         //Required_28
         adapter.add("[BUILD] Cafeteria lv28");
         fuel = fuel+cafe28_fuel;
         food = food+cafe28_food;
         steel = steel+cafe28_steel;
         time = time+cafe28_time;
         alloy = alloy+cafe28_alloy;
         //TB
         adapter.add("[BUILD] Build TB lv29");
         fuel = fuel+tb29_fuel;
         food = food+tb29_food;
         steel = steel+tb29_steel;
         alloy = alloy+tb29_alloy;
         time = time+tb29_time;
         }
         //TB30
         if (now < 30 && aim >= 30) {
         //WALL
         adapter.add("[BUILD] Wall lv29");
         fuel = fuel + wall29_fuel;
         food = food + wall29_food;
         steel = steel + wall29_steel;
         alloy = alloy + wall29_alloy;
         time = time + wall29_time;
         //Required_14
         adapter.add("[BUILD] Armed Forces lv14");
         fuel = fuel + arm14_fuel;
         food = food + arm14_food;
         steel = steel + arm14_steel;
         time = time + arm14_time;
         alloy = alloy + arm14_alloy;
         //Required_15
         adapter.add("[BUILD] Armed Forces lv15");
         fuel = fuel + arm15_fuel;
         food = food + arm15_food;
         steel = steel + arm15_steel;
         time = time + arm15_time;
         alloy = alloy + arm15_alloy;
         //Required_16
         adapter.add("[BUILD] Armed Forces lv16");
         fuel = fuel + arm16_fuel;
         food = food + arm16_food;
         steel = steel + arm16_steel;
         time = time + arm16_time;
         alloy = alloy + arm16_alloy;
         //Required_17
         adapter.add("[BUILD] Armed Forces lv17");
         fuel = fuel + arm17_fuel;
         food = food + arm17_food;
         steel = steel + arm17_steel;
         time = time + arm17_time;
         alloy = alloy + arm17_alloy;
         //Required_18
         adapter.add("[BUILD] Armed Forces lv18");
         fuel = fuel + arm18_fuel;
         food = food + arm18_food;
         steel = steel + arm18_steel;
         time = time + arm18_time;
         alloy = alloy + arm18_alloy;
         //Required_19
         adapter.add("[BUILD] Armed Forces lv19");
         fuel = fuel + arm19_fuel;
         food = food + arm19_food;
         steel = steel + arm19_steel;
         time = time + arm19_time;
         alloy = alloy + arm19_alloy;
         //Required_20
         adapter.add("[BUILD] Armed Forces lv20");
         fuel = fuel + arm20_fuel;
         food = food + arm20_food;
         steel = steel + arm20_steel;
         time = time + arm20_time;
         alloy = alloy + arm20_alloy;
         //Required_21
         adapter.add("[BUILD] Armed Forces lv21");
         fuel = fuel + arm21_fuel;
         food = food + arm21_food;
         steel = steel + arm21_steel;
         time = time + arm21_time;
         alloy = alloy + arm21_alloy;
         //Required_22
         adapter.add("[BUILD] Armed Forces lv22");
         fuel = fuel + arm22_fuel;
         food = food + arm22_food;
         steel = steel + arm22_steel;
         time = time + arm22_time;
         alloy = alloy + arm22_alloy;
         //Required_23
         adapter.add("[BUILD] Armed Forces lv23");
         fuel = fuel + arm23_fuel;
         food = food + arm23_food;
         steel = steel + arm23_steel;
         time = time + arm23_time;
         alloy = alloy + arm23_alloy;
         //Required_24
         adapter.add("[BUILD] Armed Forces lv24");
         fuel = fuel + arm24_fuel;
         food = food + arm24_food;
         steel = steel + arm24_steel;
         time = time + arm24_time;
         alloy = alloy + arm24_alloy;
         //Required_25
         adapter.add("[BUILD] Armed Forces lv25");
         fuel = fuel + arm25_fuel;
         food = food + arm25_food;
         steel = steel + arm25_steel;
         time = time + arm25_time;
         alloy = alloy + arm25_alloy;
         //Required_26
         adapter.add("[BUILD] Armed Forces lv26");
         fuel = fuel + arm26_fuel;
         food = food + arm26_food;
         steel = steel + arm26_steel;
         time = time + arm26_time;
         alloy = alloy + arm26_alloy;
         //Required_27
         adapter.add("[BUILD] Armed Forces lv27");
         fuel = fuel + arm27_fuel;
         food = food + arm27_food;
         steel = steel + arm27_steel;
         time = time + arm27_time;
         alloy = alloy + arm27_alloy;
         //Required_28
         adapter.add("[BUILD] Armed Forces lv28");
         fuel = fuel + arm28_fuel;
         food = food + arm28_food;
         steel = steel + arm28_steel;
         time = time + arm28_time;
         alloy = alloy + arm28_alloy;
         //Required_29
         adapter.add("[BUILD] Armed Forces lv29");
         fuel = fuel + arm29_fuel;
         food = food + arm29_food;
         steel = steel + arm29_steel;
         time = time + arm29_time;
         alloy = alloy + arm29_alloy;
         //TB
         adapter.add("[BUILD] Build TB lv30");
         fuel = fuel + tb30_fuel;
         food = food + tb30_food;
         steel = steel + tb30_steel;
         alloy = alloy + tb30_alloy;
         time = time + tb30_time;

         }
         //TB31
         if (now < 31 && aim >= 31){
         //WALL
         adapter.add("[BUILD] Wall lv30");
         fuel = fuel+wall30_fuel;
         food = food+wall30_food;
         steel = steel+wall30_steel;
         alloy = alloy+wall30_alloy;
         time = time+wall30_time;

         //Required_1
         adapter.add("[BUILD] Infection Institute lv1");	fuel = fuel + infection1_fuel;	food = food + infection1_food;	steel = steel + infection1_steel;	alloy = alloy + infection1_alloy;	time = time + infection1_time;
         //Required_2
         adapter.add("[BUILD] Infection Institute lv2");	fuel = fuel + infection2_fuel;	food = food + infection2_food;	steel = steel + infection2_steel;	alloy = alloy + infection2_alloy;	time = time + infection2_time;
         //Required_3
         adapter.add("[BUILD] Infection Institute lv3");	fuel = fuel + infection3_fuel;	food = food + infection3_food;	steel = steel + infection3_steel;	alloy = alloy + infection3_alloy;	time = time + infection3_time;
         //Required_4
         adapter.add("[BUILD] Infection Institute lv4");	fuel = fuel + infection4_fuel;	food = food + infection4_food;	steel = steel + infection4_steel;	alloy = alloy + infection4_alloy;	time = time + infection4_time;
         //Required_5
         adapter.add("[BUILD] Infection Institute lv5");	fuel = fuel + infection5_fuel;	food = food + infection5_food;	steel = steel + infection5_steel;	alloy = alloy + infection5_alloy;	time = time + infection5_time;
         //Required_6
         adapter.add("[BUILD] Infection Institute lv6");	fuel = fuel + infection6_fuel;	food = food + infection6_food;	steel = steel + infection6_steel;	alloy = alloy + infection6_alloy;	time = time + infection6_time;
         //Required_7
         adapter.add("[BUILD] Infection Institute lv7");	fuel = fuel + infection7_fuel;	food = food + infection7_food;	steel = steel + infection7_steel;	alloy = alloy + infection7_alloy;	time = time + infection7_time;
         //Required_8
         adapter.add("[BUILD] Infection Institute lv8");	fuel = fuel + infection8_fuel;	food = food + infection8_food;	steel = steel + infection8_steel;	alloy = alloy + infection8_alloy;	time = time + infection8_time;
         //Required_9
         adapter.add("[BUILD] Infection Institute lv9");	fuel = fuel + infection9_fuel;	food = food + infection9_food;	steel = steel + infection9_steel;	alloy = alloy + infection9_alloy;	time = time + infection9_time;
         //Required_10
         adapter.add("[BUILD] Infection Institute lv10");	fuel = fuel + infection10_fuel;	food = food + infection10_food;	steel = steel + infection10_steel;	alloy = alloy + infection10_alloy;	time = time + infection10_time;
         //Required_11
         adapter.add("[BUILD] Infection Institute lv11");	fuel = fuel + infection11_fuel;	food = food + infection11_food;	steel = steel + infection11_steel;	alloy = alloy + infection11_alloy;	time = time + infection11_time;
         //Required_12
         adapter.add("[BUILD] Infection Institute lv12");	fuel = fuel + infection12_fuel;	food = food + infection12_food;	steel = steel + infection12_steel;	alloy = alloy + infection12_alloy;	time = time + infection12_time;
         //Required_13
         adapter.add("[BUILD] Infection Institute lv13");	fuel = fuel + infection13_fuel;	food = food + infection13_food;	steel = steel + infection13_steel;	alloy = alloy + infection13_alloy;	time = time + infection13_time;
         //Required_14
         adapter.add("[BUILD] Infection Institute lv14");	fuel = fuel + infection14_fuel;	food = food + infection14_food;	steel = steel + infection14_steel;	alloy = alloy + infection14_alloy;	time = time + infection14_time;
         //Required_15
         adapter.add("[BUILD] Infection Institute lv15");	fuel = fuel + infection15_fuel;	food = food + infection15_food;	steel = steel + infection15_steel;	alloy = alloy + infection15_alloy;	time = time + infection15_time;
         //Required_16
         adapter.add("[BUILD] Infection Institute lv16");	fuel = fuel + infection16_fuel;	food = food + infection16_food;	steel = steel + infection16_steel;	alloy = alloy + infection16_alloy;	time = time + infection16_time;
         //Required_17
         adapter.add("[BUILD] Infection Institute lv17");	fuel = fuel + infection17_fuel;	food = food + infection17_food;	steel = steel + infection17_steel;	alloy = alloy + infection17_alloy;	time = time + infection17_time;
         //Required_18
         adapter.add("[BUILD] Infection Institute lv18");	fuel = fuel + infection18_fuel;	food = food + infection18_food;	steel = steel + infection18_steel;	alloy = alloy + infection18_alloy;	time = time + infection18_time;
         //Required_19
         adapter.add("[BUILD] Infection Institute lv19");	fuel = fuel + infection19_fuel;	food = food + infection19_food;	steel = steel + infection19_steel;	alloy = alloy + infection19_alloy;	time = time + infection19_time;
         //Required_20
         adapter.add("[BUILD] Infection Institute lv20");	fuel = fuel + infection20_fuel;	food = food + infection20_food;	steel = steel + infection20_steel;	alloy = alloy + infection20_alloy;	time = time + infection20_time;
         //Required_21
         adapter.add("[BUILD] Infection Institute lv21");	fuel = fuel + infection21_fuel;	food = food + infection21_food;	steel = steel + infection21_steel;	alloy = alloy + infection21_alloy;	time = time + infection21_time;
         //Required_22
         adapter.add("[BUILD] Infection Institute lv22");	fuel = fuel + infection22_fuel;	food = food + infection22_food;	steel = steel + infection22_steel;	alloy = alloy + infection22_alloy;	time = time + infection22_time;
         //Required_23
         adapter.add("[BUILD] Infection Institute lv23");	fuel = fuel + infection23_fuel;	food = food + infection23_food;	steel = steel + infection23_steel;	alloy = alloy + infection23_alloy;	time = time + infection23_time;
         //Required_24
         adapter.add("[BUILD] Infection Institute lv24");	fuel = fuel + infection24_fuel;	food = food + infection24_food;	steel = steel + infection24_steel;	alloy = alloy + infection24_alloy;	time = time + infection24_time;
         //Required_25
         adapter.add("[BUILD] Infection Institute lv25");	fuel = fuel + infection25_fuel;	food = food + infection25_food;	steel = steel + infection25_steel;	alloy = alloy + infection25_alloy;	time = time + infection25_time;
         //Required_26
         adapter.add("[BUILD] Infection Institute lv26");	fuel = fuel + infection26_fuel;	food = food + infection26_food;	steel = steel + infection26_steel;	alloy = alloy + infection26_alloy;	time = time + infection26_time;
         //Required_27
         adapter.add("[BUILD] Infection Institute lv27");	fuel = fuel + infection27_fuel;	food = food + infection27_food;	steel = steel + infection27_steel;	alloy = alloy + infection27_alloy;	time = time + infection27_time;
         //Required_28
         adapter.add("[BUILD] Infection Institute lv28");	fuel = fuel + infection28_fuel;	food = food + infection28_food;	steel = steel + infection28_steel;	alloy = alloy + infection28_alloy;	time = time + infection28_time;
         //Required_29
         adapter.add("[BUILD] Infection Institute lv29");	fuel = fuel + infection29_fuel;	food = food + infection29_food;	steel = steel + infection29_steel;	alloy = alloy + infection29_alloy;	time = time + infection29_time;
         //Required_30
         adapter.add("[BUILD] Infection Institute lv30");	fuel = fuel + infection30_fuel;	food = food + infection30_food;	steel = steel + infection30_steel;	alloy = alloy + infection30_alloy;	time = time + infection30_time;
         //TB
         adapter.add("[BUILD] Build TB Glory 1");
         fuel = fuel+tb31_fuel;
         food = food+tb31_food;
         steel = steel+tb31_steel;
         alloy = alloy+tb31_alloy;
         kyanite = kyanite+tb31_kyanite;
         kyanite_basic = kyanite_basic+tb31_kyanite_basic;
         kyanite_cluster = kyanite_cluster+tb31_kyanite_cluster;
         glory = glory+tb31_glory_mark;
         time = time+tb31_time;
         }
         //TB32
         if (now < 32 && aim >= 32){
         //Required_5
         adapter.add("[BUILD] Farm lv5");	fuel = fuel + farm5_fuel;	time = time + farm_time5;
         //Required_6
         adapter.add("[BUILD] Farm lv6");	fuel = fuel + farm6_fuel;	time = time + farm_time6;
         //Required_7
         adapter.add("[BUILD] Farm lv7");	fuel = fuel + farm7_fuel;	time = time + farm_time7;
         //Required_8
         adapter.add("[BUILD] Farm lv8");	fuel = fuel + farm8_fuel;	time = time + farm_time8;
         //Required_9
         adapter.add("[BUILD] Farm lv9");	fuel = fuel + farm9_fuel;	time = time + farm_time9;
         //Required_10
         adapter.add("[BUILD] Farm lv10");	fuel = fuel + farm10_fuel;	time = time + farm_time10;
         //Required_11
         adapter.add("[BUILD] Farm lv11");	fuel = fuel + farm11_fuel;	time = time + farm_time11;
         //Required_12
         adapter.add("[BUILD] Farm lv12");	fuel = fuel + farm12_fuel;	time = time + farm_time12;
         //Required_13
         adapter.add("[BUILD] Farm lv13");	fuel = fuel + farm13_fuel;	time = time + farm_time13;
         //Required_14
         adapter.add("[BUILD] Farm lv14");	fuel = fuel + farm14_fuel;	time = time + farm_time14;
         //Required_15
         adapter.add("[BUILD] Farm lv15");	fuel = fuel + farm15_fuel;	time = time + farm_time15;
         //Required_16
         adapter.add("[BUILD] Farm lv16");	fuel = fuel + farm16_fuel;	time = time + farm_time16;
         //Required_17
         adapter.add("[BUILD] Farm lv17");	fuel = fuel + farm17_fuel;	time = time + farm_time17;
         //Required_18
         adapter.add("[BUILD] Farm lv18");	fuel = fuel + farm18_fuel;	time = time + farm_time18;
         //Required_19
         adapter.add("[BUILD] Farm lv19");	fuel = fuel + farm19_fuel;	time = time + farm_time19;
         //Required_20
         adapter.add("[BUILD] Farm lv20");	fuel = fuel + farm20_fuel;	time = time + farm_time20;
         //Required_21
         adapter.add("[BUILD] Farm lv21");	fuel = fuel + farm21_fuel;	time = time + farm_time21;
         //Required_22
         adapter.add("[BUILD] Farm lv22");	fuel = fuel + farm22_fuel;	time = time + farm_time22;
         //Required_23
         adapter.add("[BUILD] Farm lv23");	fuel = fuel + farm23_fuel;	time = time + farm_time23;
         //Required_24
         adapter.add("[BUILD] Farm lv24");	fuel = fuel + farm24_fuel;	time = time + farm_time24;
         //Required_25
         adapter.add("[BUILD] Farm lv25");	fuel = fuel + farm25_fuel;	time = time + farm_time25;
         //Required_26
         adapter.add("[BUILD] Farm lv26");	fuel = fuel + farm26_fuel;	time = time + farm_time26;
         //Required_27
         adapter.add("[BUILD] Farm lv27");	fuel = fuel + farm27_fuel;	time = time + farm_time27;
         //Required_28
         adapter.add("[BUILD] Farm lv28");	fuel = fuel + farm28_fuel;	time = time + farm_time28;
         //Required_29
         adapter.add("[BUILD] Farm lv29");	fuel = fuel + farm29_fuel;	time = time + farm_time29;
         //Required_30
         adapter.add("[BUILD] Farm lv30");	fuel = fuel + farm30_fuel;	time = time + farm_time30;

         //TB
         adapter.add("[BUILD] Build TB Glory 2");
         fuel = fuel+tb32_fuel;
         food = food+tb32_food;
         steel = steel+tb32_steel;
         alloy = alloy+tb32_alloy;
         kyanite = kyanite+tb32_kyanite;
         kyanite_basic = kyanite_basic+tb32_kyanite_basic;
         kyanite_cluster = kyanite_cluster+tb32_kyanite_cluster;
         glory = glory+tb32_glory_mark;
         time = time+tb32_time;
         }
         //TB33
         if (now < 33 && aim >= 33){
         //Required_1
         adapter.add("[BUILD] Logistics Center lv1");	fuel = fuel + logist1_fuel;	food = food + logist1_food;	steel = steel + logist1_steel;	alloy = alloy + logist1_alloy;	time = time + logist1_time;
         //Required_2
         adapter.add("[BUILD] Logistics Center lv2");	fuel = fuel + logist2_fuel;	food = food + logist2_food;	steel = steel + logist2_steel;	alloy = alloy + logist2_alloy;	time = time + logist2_time;
         //Required_3
         adapter.add("[BUILD] Logistics Center lv3");	fuel = fuel + logist3_fuel;	food = food + logist3_food;	steel = steel + logist3_steel;	alloy = alloy + logist3_alloy;	time = time + logist3_time;
         //Required_4
         adapter.add("[BUILD] Logistics Center lv4");	fuel = fuel + logist4_fuel;	food = food + logist4_food;	steel = steel + logist4_steel;	alloy = alloy + logist4_alloy;	time = time + logist4_time;
         //Required_5
         adapter.add("[BUILD] Logistics Center lv5");	fuel = fuel + logist5_fuel;	food = food + logist5_food;	steel = steel + logist5_steel;	alloy = alloy + logist5_alloy;	time = time + logist5_time;
         //Required_6
         adapter.add("[BUILD] Logistics Center lv6");	fuel = fuel + logist6_fuel;	food = food + logist6_food;	steel = steel + logist6_steel;	alloy = alloy + logist6_alloy;	time = time + logist6_time;
         //Required_7
         adapter.add("[BUILD] Logistics Center lv7");	fuel = fuel + logist7_fuel;	food = food + logist7_food;	steel = steel + logist7_steel;	alloy = alloy + logist7_alloy;	time = time + logist7_time;
         //Required_8
         adapter.add("[BUILD] Logistics Center lv8");	fuel = fuel + logist8_fuel;	food = food + logist8_food;	steel = steel + logist8_steel;	alloy = alloy + logist8_alloy;	time = time + logist8_time;
         //Required_9
         adapter.add("[BUILD] Logistics Center lv9");	fuel = fuel + logist9_fuel;	food = food + logist9_food;	steel = steel + logist9_steel;	alloy = alloy + logist9_alloy;	time = time + logist9_time;
         //Required_10
         adapter.add("[BUILD] Logistics Center lv10");	fuel = fuel + logist10_fuel;	food = food + logist10_food;	steel = steel + logist10_steel;	alloy = alloy + logist10_alloy;	time = time + logist10_time;
         //Required_11
         adapter.add("[BUILD] Logistics Center lv11");	fuel = fuel + logist11_fuel;	food = food + logist11_food;	steel = steel + logist11_steel;	alloy = alloy + logist11_alloy;	time = time + logist11_time;
         //Required_12
         adapter.add("[BUILD] Logistics Center lv12");	fuel = fuel + logist12_fuel;	food = food + logist12_food;	steel = steel + logist12_steel;	alloy = alloy + logist12_alloy;	time = time + logist12_time;
         //Required_13
         adapter.add("[BUILD] Logistics Center lv13");	fuel = fuel + logist13_fuel;	food = food + logist13_food;	steel = steel + logist13_steel;	alloy = alloy + logist13_alloy;	time = time + logist13_time;
         //Required_14
         adapter.add("[BUILD] Logistics Center lv14");	fuel = fuel + logist14_fuel;	food = food + logist14_food;	steel = steel + logist14_steel;	alloy = alloy + logist14_alloy;	time = time + logist14_time;
         //Required_15
         adapter.add("[BUILD] Logistics Center lv15");	fuel = fuel + logist15_fuel;	food = food + logist15_food;	steel = steel + logist15_steel;	alloy = alloy + logist15_alloy;	time = time + logist15_time;
         //Required_16
         adapter.add("[BUILD] Logistics Center lv16");	fuel = fuel + logist16_fuel;	food = food + logist16_food;	steel = steel + logist16_steel;	alloy = alloy + logist16_alloy;	time = time + logist16_time;
         //Required_17
         adapter.add("[BUILD] Logistics Center lv17");	fuel = fuel + logist17_fuel;	food = food + logist17_food;	steel = steel + logist17_steel;	alloy = alloy + logist17_alloy;	time = time + logist17_time;
         //Required_18
         adapter.add("[BUILD] Logistics Center lv18");	fuel = fuel + logist18_fuel;	food = food + logist18_food;	steel = steel + logist18_steel;	alloy = alloy + logist18_alloy;	time = time + logist18_time;
         //Required_19
         adapter.add("[BUILD] Logistics Center lv19");	fuel = fuel + logist19_fuel;	food = food + logist19_food;	steel = steel + logist19_steel;	alloy = alloy + logist19_alloy;	time = time + logist19_time;
         //Required_20
         adapter.add("[BUILD] Logistics Center lv20");	fuel = fuel + logist20_fuel;	food = food + logist20_food;	steel = steel + logist20_steel;	alloy = alloy + logist20_alloy;	time = time + logist20_time;
         //Required_21
         adapter.add("[BUILD] Logistics Center lv21");	fuel = fuel + logist21_fuel;	food = food + logist21_food;	steel = steel + logist21_steel;	alloy = alloy + logist21_alloy;	time = time + logist21_time;
         //Required_22
         adapter.add("[BUILD] Logistics Center lv22");	fuel = fuel + logist22_fuel;	food = food + logist22_food;	steel = steel + logist22_steel;	alloy = alloy + logist22_alloy;	time = time + logist22_time;
         //Required_23
         adapter.add("[BUILD] Logistics Center lv23");	fuel = fuel + logist23_fuel;	food = food + logist23_food;	steel = steel + logist23_steel;	alloy = alloy + logist23_alloy;	time = time + logist23_time;
         //Required_24
         adapter.add("[BUILD] Logistics Center lv24");	fuel = fuel + logist24_fuel;	food = food + logist24_food;	steel = steel + logist24_steel;	alloy = alloy + logist24_alloy;	time = time + logist24_time;
         //Required_25
         adapter.add("[BUILD] Logistics Center lv25");	fuel = fuel + logist25_fuel;	food = food + logist25_food;	steel = steel + logist25_steel;	alloy = alloy + logist25_alloy;	time = time + logist25_time;
         //Required_26
         adapter.add("[BUILD] Logistics Center lv26");	fuel = fuel + logist26_fuel;	food = food + logist26_food;	steel = steel + logist26_steel;	alloy = alloy + logist26_alloy;	time = time + logist26_time;
         //Required_27
         adapter.add("[BUILD] Logistics Center lv27");	fuel = fuel + logist27_fuel;	food = food + logist27_food;	steel = steel + logist27_steel;	alloy = alloy + logist27_alloy;	time = time + logist27_time;
         //Required_28
         adapter.add("[BUILD] Logistics Center lv28");	fuel = fuel + logist28_fuel;	food = food + logist28_food;	steel = steel + logist28_steel;	alloy = alloy + logist28_alloy;	time = time + logist28_time;
         //Required_29
         adapter.add("[BUILD] Logistics Center lv29");	fuel = fuel + logist29_fuel;	food = food + logist29_food;	steel = steel + logist29_steel;	alloy = alloy + logist29_alloy;	time = time + logist29_time;
         //Required_30
         adapter.add("[BUILD] Logistics Center lv30");	fuel = fuel + logist30_fuel;	food = food + logist30_food;	steel = steel + logist30_steel;	alloy = alloy + logist30_alloy;	time = time + logist30_time;
         //Required_31
         adapter.add("[BUILD] Logistics Center Glory 1");	fuel = fuel + logist31_fuel;	food = food + logist31_food;	steel = steel + logist31_steel;	alloy = alloy + logist31_alloy;	time = time + logist31_time;

         //Required_16
         adapter.add("[BUILD] Alloy Mine lv16");	fuel = fuel + alloy_m16_fuel;	time = time + alloy_m16_time;
         //Required_17
         adapter.add("[BUILD] Alloy Mine lv17");	fuel = fuel + alloy_m17_fuel;	time = time + alloy_m17_time;
         //Required_18
         adapter.add("[BUILD] Alloy Mine lv18");	fuel = fuel + alloy_m18_fuel;	time = time + alloy_m18_time;
         //Required_19
         adapter.add("[BUILD] Alloy Mine lv19");	fuel = fuel + alloy_m19_fuel;	time = time + alloy_m19_time;
         //Required_20
         adapter.add("[BUILD] Alloy Mine lv20");	fuel = fuel + alloy_m20_fuel;	time = time + alloy_m20_time;
         //Required_21
         adapter.add("[BUILD] Alloy Mine lv21");	fuel = fuel + alloy_m21_fuel;	time = time + alloy_m21_time;
         //Required_22
         adapter.add("[BUILD] Alloy Mine lv22");	fuel = fuel + alloy_m22_fuel;	time = time + alloy_m22_time;
         //Required_23
         adapter.add("[BUILD] Alloy Mine lv23");	fuel = fuel + alloy_m23_fuel;	time = time + alloy_m23_time;
         //Required_24
         adapter.add("[BUILD] Alloy Mine lv24");	fuel = fuel + alloy_m24_fuel;	time = time + alloy_m24_time;
         //Required_25
         adapter.add("[BUILD] Alloy Mine lv25");	fuel = fuel + alloy_m25_fuel;	time = time + alloy_m25_time;
         //Required_26
         adapter.add("[BUILD] Alloy Mine lv26");	fuel = fuel + alloy_m26_fuel;	time = time + alloy_m26_time;
         //Required_27
         adapter.add("[BUILD] Alloy Mine lv27");	fuel = fuel + alloy_m27_fuel;	time = time + alloy_m27_time;
         //Required_28
         adapter.add("[BUILD] Alloy Mine lv28");	fuel = fuel + alloy_m28_fuel;	time = time + alloy_m28_time;
         //Required_29
         adapter.add("[BUILD] Alloy Mine lv29");	fuel = fuel + alloy_m29_fuel;	time = time + alloy_m29_time;
         //Required_30
         adapter.add("[BUILD] Alloy Mine lv30");	fuel = fuel + alloy_m30_fuel;	time = time + alloy_m30_time;
         //Required_31
         adapter.add("[BUILD] Alloy Mine Glory 1");	fuel = fuel + alloy_m31_fuel;	time = time + alloy_m31_time;

         //TB
         adapter.add("[BUILD] Build TB Glory 3");
         fuel = fuel+tb33_fuel;
         food = food+tb33_food;
         steel = steel+tb33_steel;
         alloy = alloy+tb33_alloy;
         time = time+tb33_time;
         kyanite = kyanite+tb33_kyanite;
         kyanite_basic = kyanite_basic+tb33_kyanite_basic;
         kyanite_cluster = kyanite_cluster+tb33_kyanite_cluster;
         glory = glory+tb33_glory_mark;

         }
         //TB34
         if (now < 34 && aim >= 34){

         //Required_4
         adapter.add("[BUILD] Oil Well lv4"); 	 food = food + oil_food4; 	  time = time + oil_time4;
         //Required_5
         adapter.add("[BUILD] Oil Well lv5");	 food = food + oil_food5;	  time = time + oil_time5;
         //Required_6
         adapter.add("[BUILD] Oil Well lv6");	 food = food + oil_food6;	  time = time + oil_time6;
         //Required_7
         adapter.add("[BUILD] Oil Well lv7");	 food = food + oil_food7;	  time = time + oil_time7;
         //Required_8
         adapter.add("[BUILD] Oil Well lv8");	 food = food + oil_food8;	  time = time + oil_time8;
         //Required_9
         adapter.add("[BUILD] Oil Well lv9");	 food = food + oil_food9;	  time = time + oil_time9;
         //Required_10
         adapter.add("[BUILD] Oil Well lv10");	 food = food + oil_food10;	  time = time + oil_time10;
         //Required_11
         adapter.add("[BUILD] Oil Well lv11");	 food = food + oil_food11;	  time = time + oil_time11;
         //Required_12
         adapter.add("[BUILD] Oil Well lv12");	 food = food + oil_food12;	  time = time + oil_time12;
         //Required_13
         adapter.add("[BUILD] Oil Well lv13");	 food = food + oil_food13;	  time = time + oil_time13;
         //Required_14
         adapter.add("[BUILD] Oil Well lv14");	 food = food + oil_food14;	  time = time + oil_time14;
         //Required_15
         adapter.add("[BUILD] Oil Well lv15");	 food = food + oil_food15;	  time = time + oil_time15;
         //Required_16
         adapter.add("[BUILD] Oil Well lv16");	 food = food + oil_food16;	  time = time + oil_time16;
         //Required_17
         adapter.add("[BUILD] Oil Well lv17");	 food = food + oil_food17;	  time = time + oil_time17;
         //Required_18
         adapter.add("[BUILD] Oil Well lv18");	 food = food + oil_food18;	  time = time + oil_time18;
         //Required_19
         adapter.add("[BUILD] Oil Well lv19");	 food = food + oil_food19;	  time = time + oil_time19;
         //Required_20
         adapter.add("[BUILD] Oil Well lv20");	 food = food + oil_food20;	  time = time + oil_time20;
         //Required_21
         adapter.add("[BUILD] Oil Well lv21");	 food = food + oil_food21;	  time = time + oil_time21;
         //Required_22
         adapter.add("[BUILD] Oil Well lv22");	 food = food + oil_food22;	  time = time + oil_time22;
         //Required_23
         adapter.add("[BUILD] Oil Well lv23");	 food = food + oil_food23;	  time = time + oil_time23;
         //Required_24
         adapter.add("[BUILD] Oil Well lv24");	 food = food + oil_food24;	  time = time + oil_time24;
         //Required_25
         adapter.add("[BUILD] Oil Well lv25");	 food = food + oil_food25;	  time = time + oil_time25;
         //Required_26
         adapter.add("[BUILD] Oil Well lv26");	 food = food + oil_food26;	  time = time + oil_time26;
         //Required_27
         adapter.add("[BUILD] Oil Well lv27");	 food = food + oil_food27;	  time = time + oil_time27;
         //Required_28
         adapter.add("[BUILD] Oil Well lv28");	 food = food + oil_food28;	  time = time + oil_time28;
         //Required_29
         adapter.add("[BUILD] Oil Well lv29");	 food = food + oil_food29;	  time = time + oil_time29;
         //Required_30
         adapter.add("[BUILD] Oil Well lv30");	 food = food + oil_food30;	  time = time + oil_time30;
         //Required_31
         adapter.add("[BUILD] Oil Well Glory 1");	 food = food + oil_food31;	  time = time + oil_time31;
         //Required_32
         adapter.add("[BUILD] Oil Well Glory 2");	 food = food + oil_food32;	  time = time + oil_time32;

         //Required_28
         adapter.add("[BUILD] Military Office lv28");	fuel = fuel + military28_fuel;	food = food + military28_food;	steel = steel + military28_steel;	alloy = alloy + military28_alloy;	time = time + military28_time;
         //Required_29
         adapter.add("[BUILD] Military Office lv29");	fuel = fuel + military29_fuel;	food = food + military29_food;	steel = steel + military29_steel;	alloy = alloy + military29_alloy;	time = time + military29_time;
         //Required_30
         adapter.add("[BUILD] Military Office lv30");	fuel = fuel + military30_fuel;	food = food + military30_food;	steel = steel + military30_steel;	alloy = alloy + military30_alloy;	time = time + military30_time;
         //Required_31
         adapter.add("[BUILD] Military Office Glory 1");	fuel = fuel + military31_fuel;	food = food + military31_food;	steel = steel + military31_steel;	alloy = alloy + military31_alloy;	time = time + military31_time;
         //Required_32
         adapter.add("[BUILD] Military Office Glory 2");	fuel = fuel + military32_fuel;	food = food + military32_food;	steel = steel + military32_steel;	alloy = alloy + military32_alloy;	time = time + military32_time;

         //TB
         adapter.add("[BUILD] Build TB Glory 4");
         fuel = fuel+tb34_fuel;
         food = food+tb34_food;
         steel = steel+tb34_steel;
         alloy = alloy+tb34_alloy;
         time = time+tb34_time;
         kyanite = kyanite+tb34_kyanite;
         kyanite_basic = kyanite_basic+tb34_kyanite_basic;
         kyanite_cluster = kyanite_cluster+tb34_kyanite_cluster;
         glory = glory+tb34_glory_mark;

         }
         //TB35
         if (now < 35 && aim == 35){

         //Required_1
         adapter.add("[BUILD] Steel Mine lv1");	fuel = fuel + steel_fuel1;	time = time + steel1_time;
         //Required_2
         adapter.add("[BUILD] Steel Mine lv2");	fuel = fuel + steel_fuel2;	time = time + steel2_time;
         //Required_3
         adapter.add("[BUILD] Steel Mine lv3");	fuel = fuel + steel_fuel3;	time = time + steel3_time;
         //Required_4
         adapter.add("[BUILD] Steel Mine lv4");	fuel = fuel + steel_fuel4;	time = time + steel4_time;
         //Required_5
         adapter.add("[BUILD] Steel Mine lv5");	fuel = fuel + steel_fuel5;	time = time + steel5_time;
         //Required_6
         adapter.add("[BUILD] Steel Mine lv6");	fuel = fuel + steel_fuel6;	time = time + steel6_time;
         //Required_7
         adapter.add("[BUILD] Steel Mine lv7");	fuel = fuel + steel_fuel7;	time = time + steel7_time;
         //Required_8
         adapter.add("[BUILD] Steel Mine lv8");	fuel = fuel + steel_fuel8;	time = time + steel8_time;
         //Required_9
         adapter.add("[BUILD] Steel Mine lv9");	fuel = fuel + steel_fuel9;	time = time + steel9_time;
         //Required_10
         adapter.add("[BUILD] Steel Mine lv10");	fuel = fuel + steel_fuel10;	time = time + steel10_time;
         //Required_11
         adapter.add("[BUILD] Steel Mine lv11");	fuel = fuel + steel_fuel11;	time = time + steel11_time;
         //Required_12
         adapter.add("[BUILD] Steel Mine lv12");	fuel = fuel + steel_fuel12;	time = time + steel12_time;
         //Required_13
         adapter.add("[BUILD] Steel Mine lv13");	fuel = fuel + steel_fuel13;	time = time + steel13_time;
         //Required_14
         adapter.add("[BUILD] Steel Mine lv14");	fuel = fuel + steel_fuel14;	time = time + steel14_time;
         //Required_15
         adapter.add("[BUILD] Steel Mine lv15");	fuel = fuel + steel_fuel15;	time = time + steel15_time;
         //Required_16
         adapter.add("[BUILD] Steel Mine lv16");	fuel = fuel + steel_fuel16;	time = time + steel16_time;
         //Required_17
         adapter.add("[BUILD] Steel Mine lv17");	fuel = fuel + steel_fuel17;	time = time + steel17_time;
         //Required_18
         adapter.add("[BUILD] Steel Mine lv18");	fuel = fuel + steel_fuel18;	time = time + steel18_time;
         //Required_19
         adapter.add("[BUILD] Steel Mine lv19");	fuel = fuel + steel_fuel19;	time = time + steel19_time;
         //Required_20
         adapter.add("[BUILD] Steel Mine lv20");	fuel = fuel + steel_fuel20;	time = time + steel20_time;
         //Required_21
         adapter.add("[BUILD] Steel Mine lv21");	fuel = fuel + steel_fuel21;	time = time + steel21_time;
         //Required_22
         adapter.add("[BUILD] Steel Mine lv22");	fuel = fuel + steel_fuel22;	time = time + steel22_time;
         //Required_23
         adapter.add("[BUILD] Steel Mine lv23");	fuel = fuel + steel_fuel23;	time = time + steel23_time;
         //Required_24
         adapter.add("[BUILD] Steel Mine lv24");	fuel = fuel + steel_fuel24;	time = time + steel24_time;
         //Required_25
         adapter.add("[BUILD] Steel Mine lv25");	fuel = fuel + steel_fuel25;	time = time + steel25_time;
         //Required_26
         adapter.add("[BUILD] Steel Mine lv26");	fuel = fuel + steel_fuel26;	time = time + steel26_time;
         //Required_27
         adapter.add("[BUILD] Steel Mine lv27");	fuel = fuel + steel_fuel27;	time = time + steel27_time;
         //Required_28
         adapter.add("[BUILD] Steel Mine lv28");	fuel = fuel + steel_fuel28;	time = time + steel28_time;
         //Required_29
         adapter.add("[BUILD] Steel Mine lv29");	fuel = fuel + steel_fuel29;	time = time + steel29_time;
         //Required_30
         adapter.add("[BUILD] Steel Mine lv30");	fuel = fuel + steel_fuel30;	time = time + steel30_time;
         //Required_31
         adapter.add("[BUILD] Steel Mine Glory 1");	fuel = fuel + steel_fuel31;	time = time + steel31_time;
         //Required_32
         adapter.add("[BUILD] Steel Mine Glory 2");	fuel = fuel + steel_fuel32;	time = time + steel32_time;
         //Required_33
         adapter.add("[BUILD] Steel Mine Glory 3");	fuel = fuel + steel_fuel33;	time = time + steel33_time;

         //Required_30
         adapter.add("[BUILD] Armed Forces lv30");	fuel = fuel + arm30_fuel;	food = food + arm30_food;	steel = steel + arm30_steel;	alloy = alloy + arm30_alloy;	time = time + arm30_time;
         //Required_31
         adapter.add("[BUILD] Armed Forces Glory 1");	fuel = fuel + arm31_fuel;	food = food + arm31_food;	steel = steel + arm31_steel;	alloy = alloy + arm31_alloy;	time = time + arm31_time;
         //Required_32
         adapter.add("[BUILD] Armed Forces Glory 2");	fuel = fuel + arm32_fuel;	food = food + arm32_food;	steel = steel + arm32_steel;	alloy = alloy + arm32_alloy;	time = time + arm32_time;
         //Required_33
         adapter.add("[BUILD] Armed Forces Glory 3");	fuel = fuel + arm33_fuel;	food = food + arm33_food;	steel = steel + arm33_steel;	alloy = alloy + arm33_alloy;	time = time + arm33_time;

         //TB
         adapter.add("[BUILD] Build TB Glory 5");
         fuel = fuel+tb35_fuel;
         food = food+tb35_food;
         steel = steel+tb35_steel;
         alloy = alloy+tb35_alloy;
         time = time+tb35_time;
         kyanite = kyanite+tb35_kyanite;
         kyanite_basic = kyanite_basic+tb35_kyanite_basic;
         kyanite_cluster = kyanite_cluster+tb35_kyanite_cluster;
         glory = glory+tb35_glory_mark;
         }

         */

        Log.i("DATA_FINAL FUELC", String.valueOf(fuel));
        Log.i("DATA_FINAL FOODC", String.valueOf(food));
        Log.i("DATA_FINAL STEELC", String.valueOf(steel));
        Log.i("DATA_FINAL ALLOYC", String.valueOf(alloy));
        Log.i("DATA_FINAL TIMEC", String.valueOf(time));
        /**
         * Calcalate Buff (DONE)
         */
        String alpha = String.valueOf(buff_time.getText());
        String beta = String.valueOf(buff_rss.getText());
        if (!alpha.equals("")){
            int time_b = Integer.parseInt(alpha);
            time = time/time_b*100;
            Log.i("DATA_FINAL TIMEB", String.valueOf(time_b)); }
        if (!beta.equals("")){
            int rss_b = Integer.parseInt(beta);
            fuel = fuel/100;
            food = food/100;
            steel = steel/100;
            alloy = alloy/100;
            fuel = fuel*(100-rss_b);
            food = food*(100-rss_b);
            steel = steel*(100-rss_b);
            alloy = alloy*(100-rss_b);

        }


        Log.i("DATA_FINAL FUEL", String.valueOf(fuel));
        Log.i("DATA_FINAL FOOD", String.valueOf(food));
        Log.i("DATA_FINAL STEEL", String.valueOf(steel));
        Log.i("DATA_FINAL ALLOY", String.valueOf(alloy));
        Log.i("DATA_FINAL TIME", String.valueOf(time));





        /**
         * Method INT TO TXT (DONE)
         */
        String Fuel_String = null, Food_String= null , Steel_String = null, Alloy_String= null , Time_String = null , Kyanite_String = null , Kyanite_basic_String = null , Kyanite_cluster_String = null , Glory_Mark_String = null;

        //FUEL
        if (fuel >=1000 && fuel <1000000){
            DecimalFormat formatter = new DecimalFormat("###,###");
            Fuel_String = formatter.format(fuel);
        }
        else if (fuel >=1000000 && fuel <1000000000){
            DecimalFormat formatter = new DecimalFormat("###,###,###");
            Fuel_String = formatter.format(fuel);
        }
        else if (fuel >=1000000000){
            DecimalFormat formatter = new DecimalFormat("###,###,###,###");
            Fuel_String = formatter.format(fuel);
        }else {Fuel_String = String.valueOf(fuel);}
        //FOOD
        if (food >=1000 && food <1000000){
            DecimalFormat formatter = new DecimalFormat("###,###");
            Food_String = formatter.format(food);
        }
        else if (food >=1000000 && food <1000000000){
            DecimalFormat formatter = new DecimalFormat("###,###,###");
            Food_String = formatter.format(food);
        }
        else if (food >=1000000000){
            DecimalFormat formatter = new DecimalFormat("###,###,###,###");
            Food_String = formatter.format(food);
        } else {Food_String = String.valueOf(food);}
        //STEEL
        if (steel >=1000 && steel <1000000){
            DecimalFormat formatter = new DecimalFormat("###,###");
            Steel_String = formatter.format(steel);
        }
        else if (steel >=1000000 && steel <1000000000){
            DecimalFormat formatter = new DecimalFormat("###,###,###");
            Steel_String = formatter.format(steel);
        }
        else if (steel >=1000000000){
            DecimalFormat formatter = new DecimalFormat("###,###,###,###");
            Steel_String = formatter.format(steel);
        }else if (steel <0){
            steel = (steel+2147483647)/1000+2147484;
            DecimalFormat formatter = new DecimalFormat("###,###,###,###");
            Steel_String = formatter.format(steel) + ",000";
        } else {Steel_String = String.valueOf(steel);}
        //ALLOY
        if (alloy >=1000 && alloy <1000000){
            DecimalFormat formatter = new DecimalFormat("###,###");
            Alloy_String = formatter.format(alloy);
        }
        else if (alloy >=1000000 && alloy <1000000000){
            DecimalFormat formatter = new DecimalFormat("###,###,###");
            Alloy_String = formatter.format(alloy);
        }
        else if (alloy >=1000000000){
            DecimalFormat formatter = new DecimalFormat("###,###,###,###");
            Alloy_String = formatter.format(alloy);
        }else if (alloy <0){
            alloy = (alloy+2147483647)/1000+2147484;
            DecimalFormat formatter = new DecimalFormat("###,###,###,###");
            Alloy_String = formatter.format(alloy) + ",000";
        }else {Alloy_String = String.valueOf(alloy);}

        //KYANITE
        if (kyanite >=1000 && kyanite <1000000){
            DecimalFormat formatter = new DecimalFormat("###,###");
            Kyanite_String = formatter.format(kyanite);
        }
        else if (kyanite >=1000000 && kyanite <1000000000){
            DecimalFormat formatter = new DecimalFormat("###,###,###");
            Kyanite_String = formatter.format(kyanite);
        }
        else if (kyanite >=1000000000){
            DecimalFormat formatter = new DecimalFormat("###,###,###,###");
            Kyanite_String = formatter.format(kyanite);

        }else {Kyanite_String = String.valueOf(kyanite);}

        //KYANITE_BASIC
        if (kyanite_basic >=1000 && kyanite_basic <1000000){
            DecimalFormat formatter = new DecimalFormat("###,###");
            Kyanite_basic_String = formatter.format(kyanite_basic);
        }
        else if (kyanite_basic >=1000000 && kyanite_basic <1000000000){
            DecimalFormat formatter = new DecimalFormat("###,###,###");
            Kyanite_basic_String = formatter.format(kyanite_basic);
        }
        else if (kyanite_basic >=1000000000){
            DecimalFormat formatter = new DecimalFormat("###,###,###,###");
            Kyanite_basic_String = formatter.format(kyanite_basic);
        }else {Kyanite_basic_String = String.valueOf(kyanite_basic);}

        //KYANITE_CLUSTER
        if (kyanite_cluster >=1000 && kyanite_cluster <1000000){
            DecimalFormat formatter = new DecimalFormat("###,###");
            Kyanite_cluster_String = formatter.format(kyanite_cluster);
        }
        else if (kyanite_cluster >=1000000 && kyanite_cluster <1000000000){
            DecimalFormat formatter = new DecimalFormat("###,###,###");
            Kyanite_cluster_String = formatter.format(kyanite_cluster);
        }
        else if (kyanite >=1000000000){
            DecimalFormat formatter = new DecimalFormat("###,###,###,###");
            Kyanite_cluster_String = formatter.format(kyanite_cluster);
        }else {Kyanite_cluster_String = String.valueOf(kyanite_cluster);}

        //GLORY MARK
        if (glory >=1000 && glory <1000000){
            DecimalFormat formatter = new DecimalFormat("###,###");
            Glory_Mark_String = formatter.format(glory);
        }
        else if (glory >=1000000 && glory <1000000000){
            DecimalFormat formatter = new DecimalFormat("###,###,###");
            Glory_Mark_String = formatter.format(glory);
        }
        else if (glory >=1000000000){
            DecimalFormat formatter = new DecimalFormat("###,###,###,###");
            Glory_Mark_String = formatter.format(glory);
        }else {Glory_Mark_String = String.valueOf(glory);}

        //TIME
        if (time >0){
            long days = time / 86400;
            long hours = time / 3600;
            long minutes = (time % 3600) / 60;
            long seconds = time % 60;

            if(days<1){Time_String = String.format("%02d:%02d:%02d", hours, minutes, seconds);}else {Time_String = String.format("%02dd , %02d:%02d:%02d", days , hours, minutes, seconds);}
        }
        fuel_tv.setText(prettyCount(fuel));
        food_tv.setText(prettyCount(food));
        steel_tv.setText(prettyCount(steel));
        alloy_tv.setText(prettyCount(alloy));
        time_tv.setText(Time_String);
        kyanite_tv.setText(prettyCount(kyanite));
        kyanite_basic_tv.setText(prettyCount(kyanite_basic));
        kyanite_cluster_tv.setText(prettyCount(kyanite_cluster));
        glory_mark_tv.setText(prettyCount(glory));



        /**
         * Method INT TO TXT (DONE)
         */


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