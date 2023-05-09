package voc.net.tools.zgirls_tool.old_ui;

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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import voc.net.tools.zgirls_tool.R;
import voc.net.tools.zgirls_tool.util.ScreenSizeUtils;

public class TroopsActivity extends AppCompatActivity {

    int t1_infect_fuel	=	29	;	int t1_infect_food	=	0	;	int t1_infect_steel	=	5	;	int t1_infect_alloy	=	0	;	int t1_infect_time	=	16	;	int t1_infect_damage	=	17 	;	int t1_infect_range	=	11 	;
    int t2_infect_fuel	=	43	;	int t2_infect_food	=	0	;	int t2_infect_steel	=	10	;	int t2_infect_alloy	=	0	;	int t2_infect_time	=	20	;	int t2_infect_damage	=	23 	;	int t2_infect_range	=	11 	;
    int t3_infect_fuel	=	64	;	int t3_infect_food	=	0	;	int t3_infect_steel	=	14	;	int t3_infect_alloy	=	0	;	int t3_infect_time	=	28	;	int t3_infect_damage	=	22 	;	int t3_infect_range	=	1 	;
    int t4_infect_fuel	=	88	;	int t4_infect_food	=	0	;	int t4_infect_steel	=	20	;	int t4_infect_alloy	=	0	;	int t4_infect_time	=	44	;	int t4_infect_damage	=	42 	;	int t4_infect_range	=	11 	;
    int t5_infect_fuel	=	116	;	int t5_infect_food	=	0	;	int t5_infect_steel	=	27	;	int t5_infect_alloy	=	0	;	int t5_infect_time	=	58	;	int t5_infect_damage	=	38 	;	int t5_infect_range	=	1 	;
    int t6_infect_fuel	=	151	;	int t6_infect_food	=	0	;	int t6_infect_steel	=	34	;	int t6_infect_alloy	=	0	;	int t6_infect_time	=	75	;	int t6_infect_damage	=	68 	;	int t6_infect_range	=	11 	;
    int t7_infect_fuel	=	173	;	int t7_infect_food	=	0	;	int t7_infect_steel	=	37	;	int t7_infect_alloy	=	2	;	int t7_infect_time	=	95	;	int t7_infect_damage	=	83 	;	int t7_infect_range	=	11 	;
    int t8_infect_fuel	=	212	;	int t8_infect_food	=	0	;	int t8_infect_steel	=	41	;	int t8_infect_alloy	=	3	;	int t8_infect_time	=	118	;	int t8_infect_damage	=	70 	;	int t8_infect_range	=	1 	;
    int t9_infect_fuel	=	255	;	int t9_infect_food	=	0	;	int t9_infect_steel	=	52	;	int t9_infect_alloy	=	4	;	int t9_infect_time	=	144	;	int t9_infect_damage	=	84 	;	int t9_infect_range	=	1 	;
    int t10_infect_fuel	=	330	;	int t10_infect_food	=	0	;	int t10_infect_steel	=	60	;	int t10_infect_alloy	=	5	;	int t10_infect_time	=	173	;	int t10_infect_damage	=	139 	;	int t10_infect_range	=	11 	;

    int t1_infect_defense	=	1 	;	int t1_infect_hp	=	5 	;	int t1_infect_speed	=	13 	;	int t1_infect_load	=	22 	;	double t1_infect_cost	=	0.04 	;	double t1_infect_power	=	1.0 	;
    int t2_infect_defense	=	1 	;	int t2_infect_hp	=	6 	;	int t2_infect_speed	=	13 	;	int t2_infect_load	=	22 	;	double t2_infect_cost	=	0.04 	;	double t2_infect_power	=	1.4 	;
    int t3_infect_defense	=	19 	;	int t3_infect_hp	=	15 	;	int t3_infect_speed	=	5 	;	int t3_infect_load	=	25 	;	double t3_infect_cost	=	0.08 	;	double t3_infect_power	=	1.9 	;
    int t4_infect_defense	=	2 	;	int t4_infect_hp	=	9 	;	int t4_infect_speed	=	13 	;	int t4_infect_load	=	25 	;	double t4_infect_cost	=	0.08 	;	double t4_infect_power	=	2.5 	;
    int t5_infect_defense	=	32 	;	int t5_infect_hp	=	23 	;	int t5_infect_speed	=	5 	;	int t5_infect_load	=	27 	;	double t5_infect_cost	=	0.12 	;	double t5_infect_power	=	3.2 	;
    int t6_infect_defense	=	4 	;	int t6_infect_hp	=	14 	;	int t6_infect_speed	=	13 	;	int t6_infect_load	=	27 	;	double t6_infect_cost	=	0.12 	;	double t6_infect_power	=	4.0 	;
    int t7_infect_defense	=	4 	;	int t7_infect_hp	=	16 	;	int t7_infect_speed	=	13 	;	int t7_infect_load	=	30 	;	double t7_infect_cost	=	0.17 	;	double t7_infect_power	=	4.9 	;
    int t8_infect_defense	=	59 	;	int t8_infect_hp	=	39 	;	int t8_infect_speed	=	5 	;	int t8_infect_load	=	30 	;	double t8_infect_cost	=	0.17 	;	double t8_infect_power	=	5.9 	;
    int t9_infect_defense	=	70 	;	int t9_infect_hp	=	46 	;	int t9_infect_speed	=	5 	;	int t9_infect_load	=	33 	;	double t9_infect_cost	=	0.21 	;	double t9_infect_power	=	7.0 	;
    int t10_infect_defense	=	8 	;	int t10_infect_hp	=	26 	;	int t10_infect_speed	=	13 	;	int t10_infect_load	=	33 	;	double t10_infect_cost	=	0.21 	;	double t10_infect_power	=	8.2 	;

    int t1_proj_kyanite	=	1	;	int t1_proj_kyanite_basic	=	0	;	int t1_proj_kyanite_cluster	=	0	;	int t1_proj_steel	=	2	;	int t1_proj_alloy	=	6	;	int t1_proj_time	=	80	;	int t1_proj_damage	=	166 	;
    int t2_proj_kyanite	=	2	;	int t2_proj_kyanite_basic	=	0	;	int t2_proj_kyanite_cluster	=	0	;	int t2_proj_steel	=	3	;	int t2_proj_alloy	=	12	;	int t2_proj_time	=	100	;	int t2_proj_damage	=	38 	;
    int t3_proj_kyanite	=	3	;	int t3_proj_kyanite_basic	=	0	;	int t3_proj_kyanite_cluster	=	0	;	int t3_proj_steel	=	5	;	int t3_proj_alloy	=	17	;	int t3_proj_time	=	140	;	int t3_proj_damage	=	78 	;
    int t4_proj_kyanite	=	4	;	int t4_proj_kyanite_basic	=	0	;	int t4_proj_kyanite_cluster	=	0	;	int t4_proj_steel	=	7	;	int t4_proj_alloy	=	24	;	int t4_proj_time	=	220	;	int t4_proj_damage	=	278 	;
    int t5_proj_kyanite	=	5	;	int t5_proj_kyanite_basic	=	1	;	int t5_proj_kyanite_cluster	=	1	;	int t5_proj_steel	=	0	;	int t5_proj_alloy	=	0	;	int t5_proj_time	=	290	;	int t5_proj_damage	=	394 	;
    int t6_proj_kyanite	=	7	;	int t6_proj_kyanite_basic	=	2	;	int t6_proj_kyanite_cluster	=	1	;	int t6_proj_steel	=	0	;	int t6_proj_alloy	=	0	;	int t6_proj_time	=	375	;	int t6_proj_damage	=	118 	;
    int t7_proj_kyanite	=	7	;	int t7_proj_kyanite_basic	=	3	;	int t7_proj_kyanite_cluster	=	1	;	int t7_proj_steel	=	0	;	int t7_proj_alloy	=	0	;	int t7_proj_time	=	475	;	int t7_proj_damage	=	514 	;
    int t8_proj_kyanite	=	8	;	int t8_proj_kyanite_basic	=	4	;	int t8_proj_kyanite_cluster	=	1	;	int t8_proj_steel	=	0	;	int t8_proj_alloy	=	0	;	int t8_proj_time	=	590	;	int t8_proj_damage	=	158 	;
    int t9_proj_kyanite	=	10	;	int t9_proj_kyanite_basic	=	5	;	int t9_proj_kyanite_cluster	=	1	;	int t9_proj_steel	=	0	;	int t9_proj_alloy	=	0	;	int t9_proj_time	=	720	;	int t9_proj_damage	=	640 	;
    int t10_proj_kyanite	=	12	;	int t10_proj_kyanite_basic	=	6	;	int t10_proj_kyanite_cluster	=	1	;	int t10_proj_steel	=	0	;	int t10_proj_alloy	=	0	;	int t10_proj_time	=	865	;	int t10_proj_damage	=	200 	;

    int t1_proj_defense	=	8 	;	int t1_proj_hp	=	26 	;	int t1_proj_speed	=	8 	;	int t1_proj_load	=	22 	;	double t1_proj_cost	=	1.25 	;	double t1_proj_power	=	6.4 	;	int t1_proj_range	=	13 	;
    int t2_proj_defense	=	136 	;	int t2_proj_hp	=	104 	;	int t2_proj_speed	=	8 	;	int t2_proj_load	=	22 	;	double t2_proj_cost	=	2.50 	;	double t2_proj_power	=	8.0 	;	int t2_proj_range	=	1 	;
    int t3_proj_defense	=	228 	;	int t3_proj_hp	=	168 	;	int t3_proj_speed	=	9 	;	int t3_proj_load	=	25 	;	double t3_proj_cost	=	3.75 	;	double t3_proj_power	=	9.8 	;	int t3_proj_range	=	1 	;
    int t4_proj_defense	=	16 	;	int t4_proj_hp	=	42 	;	int t4_proj_speed	=	8 	;	int t4_proj_load	=	25 	;	double t4_proj_cost	=	5.00 	;	double t4_proj_power	=	11.8 	;	int t4_proj_range	=	13 	;
    int t5_proj_defense	=	20 	;	int t5_proj_hp	=	58 	;	int t5_proj_speed	=	9 	;	int t5_proj_load	=	27 	;	double t5_proj_cost	=	6.25 	;	double t5_proj_power	=	14.0 	;	int t5_proj_range	=	13 	;
    int t6_proj_defense	=	324 	;	int t6_proj_hp	=	236 	;	int t6_proj_speed	=	8 	;	int t6_proj_load	=	27 	;	double t6_proj_cost	=	7.50 	;	double t6_proj_power	=	16.4 	;	int t6_proj_range	=	1 	;
    int t7_proj_defense	=	24 	;	int t7_proj_hp	=	74 	;	int t7_proj_speed	=	8 	;	int t7_proj_load	=	30 	;	double t7_proj_cost	=	8.75 	;	double t7_proj_power	=	19.0 	;	int t7_proj_range	=	13 	;
    int t8_proj_defense	=	424 	;	int t8_proj_hp	=	304 	;	int t8_proj_speed	=	9 	;	int t8_proj_load	=	30 	;	double t8_proj_cost	=	10.00 	;	double t8_proj_power	=	21.8 	;	int t8_proj_range	=	1 	;
    int t9_proj_defense	=	28 	;	int t9_proj_hp	=	90 	;	int t9_proj_speed	=	9 	;	int t9_proj_load	=	33 	;	double t9_proj_cost	=	11.25 	;	double t9_proj_power	=	24.8 	;	int t9_proj_range	=	13 	;
    int t10_proj_defense	=	530 	;	int t10_proj_hp	=	376 	;	int t10_proj_speed	=	8 	;	int t10_proj_load	=	33 	;	double t10_proj_cost	=	12.50 	;	double t10_proj_power	=	28.0 	;	int t10_proj_range	=	1 	;

    int t1_arm_fuel	=	57	;	int t1_arm_food	=	0	;	int t1_arm_steel	=	0	;	int t1_arm_alloy	=	0	;	int t1_arm_time	=	16	;	int t1_arm_damage	=	8 	;	int t1_arm_range	=	5 	;
    int t2_arm_fuel	=	10	;	int t2_arm_food	=	90	;	int t2_arm_steel	=	0	;	int t2_arm_alloy	=	0	;	int t2_arm_time	=	20	;	int t2_arm_damage	=	11 	;	int t2_arm_range	=	5 	;
    int t3_arm_fuel	=	14	;	int t3_arm_food	=	130	;	int t3_arm_steel	=	0	;	int t3_arm_alloy	=	0	;	int t3_arm_time	=	28	;	int t3_arm_damage	=	26 	;	int t3_arm_range	=	8 	;
    int t4_arm_fuel	=	20	;	int t4_arm_food	=	185	;	int t4_arm_steel	=	2	;	int t4_arm_alloy	=	0	;	int t4_arm_time	=	44	;	int t4_arm_damage	=	35 	;	int t4_arm_range	=	8 	;
    int t5_arm_fuel	=	27	;	int t5_arm_food	=	241	;	int t5_arm_steel	=	3	;	int t5_arm_alloy	=	0	;	int t5_arm_time	=	58	;	int t5_arm_damage	=	28 	;	int t5_arm_range	=	5 	;
    int t6_arm_fuel	=	35	;	int t6_arm_food	=	296	;	int t6_arm_steel	=	4	;	int t6_arm_alloy	=	0	;	int t6_arm_time	=	75	;	int t6_arm_damage	=	32 	;	int t6_arm_range	=	5 	;
    int t7_arm_fuel	=	46	;	int t7_arm_food	=	254	;	int t7_arm_steel	=	5	;	int t7_arm_alloy	=	5	;	int t7_arm_time	=	95	;	int t7_arm_damage	=	68 	;	int t7_arm_range	=	8 	;
    int t8_arm_fuel	=	53	;	int t8_arm_food	=	217	;	int t8_arm_steel	=	7	;	int t8_arm_alloy	=	9	;	int t8_arm_time	=	118	;	int t8_arm_damage	=	47 	;	int t8_arm_range	=	5 	;
    int t9_arm_fuel	=	68	;	int t9_arm_food	=	181	;	int t9_arm_steel	=	10	;	int t9_arm_alloy	=	15	;	int t9_arm_time	=	144	;	int t9_arm_damage	=	98 	;	int t9_arm_range	=	8 	;
    int t10_arm_fuel	=	77	;	int t10_arm_food	=	155	;	int t10_arm_steel	=	13	;	int t10_arm_alloy	=	19	;	int t10_arm_time	=	173	;	int t10_arm_damage	=	65 	;	int t10_arm_range	=	5 	;

    int t1_arm_defense	=	6 	;	int t1_arm_hp	=	3 	;	int t1_arm_speed	=	8 	;	int t1_arm_load	=	22 	;	double t1_arm_cost	=	0.21 	;	double t1_arm_power	=	1.0 	;
    int t2_arm_defense	=	8 	;	int t2_arm_hp	=	3 	;	int t2_arm_speed	=	8 	;	int t2_arm_load	=	22 	;	double t2_arm_cost	=	0.42 	;	double t2_arm_power	=	1.4 	;
    int t3_arm_defense	=	13 	;	int t3_arm_hp	=	4 	;	int t3_arm_speed	=	8 	;	int t3_arm_load	=	22 	;	double t3_arm_cost	=	0.62 	;	double t3_arm_power	=	1.9 	;
    int t4_arm_defense	=	17 	;	int t4_arm_hp	=	5 	;	int t4_arm_speed	=	8 	;	int t4_arm_load	=	22 	;	double t4_arm_cost	=	0.83 	;	double t4_arm_power	=	2.5 	;
    int t5_arm_defense	=	19 	;	int t5_arm_hp	=	6 	;	int t5_arm_speed	=	8 	;	int t5_arm_load	=	27 	;	double t5_arm_cost	=	1.04 	;	double t5_arm_power	=	3.2 	;
    int t6_arm_defense	=	24 	;	int t6_arm_hp	=	8 	;	int t6_arm_speed	=	8 	;	int t6_arm_load	=	27 	;	double t6_arm_cost	=	1.25 	;	double t6_arm_power	=	4.0 	;
    int t7_arm_defense	=	34 	;	int t7_arm_hp	=	10 	;	int t7_arm_speed	=	8 	;	int t7_arm_load	=	27 	;	double t7_arm_cost	=	1.46 	;	double t7_arm_power	=	4.9 	;
    int t8_arm_defense	=	35 	;	int t8_arm_hp	=	11 	;	int t8_arm_speed	=	8 	;	int t8_arm_load	=	30 	;	double t8_arm_cost	=	1.67 	;	double t8_arm_power	=	5.9 	;
    int t9_arm_defense	=	49 	;	int t9_arm_hp	=	13 	;	int t9_arm_speed	=	8 	;	int t9_arm_load	=	30 	;	double t9_arm_cost	=	1.88 	;	double t9_arm_power	=	7.0 	;
    int t10_arm_defense	=	49 	;	int t10_arm_hp	=	15 	;	int t10_arm_speed	=	8 	;	int t10_arm_load	=	33 	;	double t10_arm_cost	=	2.08 	;	double t10_arm_power	=	8.2 	;

    int t1_mili_fuel	=	61	;	int t1_mili_food	=	61	;	int t1_mili_steel	=	0	;	int t1_mili_alloy	=	0	;	int t1_mili_time	=	16	;	int t1_mili_damage	=	6 	;	int t1_mili_range	=	1 	;
    int t2_mili_fuel	=	0	;	int t2_mili_food	=	100	;	int t2_mili_steel	=	0	;	int t2_mili_alloy	=	0	;	int t2_mili_time	=	20	;	int t2_mili_damage	=	8 	;	int t2_mili_range	=	1 	;
    int t3_mili_fuel	=	31	;	int t3_mili_food	=	119	;	int t3_mili_steel	=	0	;	int t3_mili_alloy	=	0	;	int t3_mili_time	=	28	;	int t3_mili_damage	=	22 	;	int t3_mili_range	=	1 	;
    int t4_mili_fuel	=	0	;	int t4_mili_food	=	169	;	int t4_mili_steel	=	7	;	int t4_mili_alloy	=	0	;	int t4_mili_time	=	44	;	int t4_mili_damage	=	15 	;	int t4_mili_range	=	1 	;
    int t5_mili_fuel	=	57	;	int t5_mili_food	=	164	;	int t5_mili_steel	=	9	;	int t5_mili_alloy	=	0	;	int t5_mili_time	=	58	;	int t5_mili_damage	=	38 	;	int t5_mili_range	=	1 	;
    int t6_mili_fuel	=	0	;	int t6_mili_food	=	245	;	int t6_mili_steel	=	18	;	int t6_mili_alloy	=	0	;	int t6_mili_time	=	75	;	int t6_mili_damage	=	24 	;	int t6_mili_range	=	1 	;
    int t7_mili_fuel	=	0	;	int t7_mili_food	=	253	;	int t7_mili_steel	=	22	;	int t7_mili_alloy	=	3	;	int t7_mili_time	=	95	;	int t7_mili_damage	=	29 	;	int t7_mili_range	=	1 	;
    int t8_mili_fuel	=	108	;	int t8_mili_food	=	203	;	int t8_mili_steel	=	25	;	int t8_mili_alloy	=	4	;	int t8_mili_time	=	118	;	int t8_mili_damage	=	70 	;	int t8_mili_range	=	1 	;
    int t9_mili_fuel	=	133	;	int t9_mili_food	=	206	;	int t9_mili_steel	=	30	;	int t9_mili_alloy	=	6	;	int t9_mili_time	=	144	;	int t9_mili_damage	=	84 	;	int t9_mili_range	=	1 	;
    int t10_mili_fuel	=	0	;	int t10_mili_food	=	323	;	int t10_mili_steel	=	39	;	int t10_mili_alloy	=	9	;	int t10_mili_time	=	173	;	int t10_mili_damage	=	49 	;	int t10_mili_range	=	1 	;

    int t1_mili_defense	=	14 	;	int t1_mili_hp	=	8 	;	int t1_mili_speed	=	8 	;	int t1_mili_load	=	22	;	double t1_mili_cost	=	0.24 	;	double t1_mili_power	=	1.0 	;
    int t2_mili_defense	=	19 	;	int t2_mili_hp	=	9 	;	int t2_mili_speed	=	8 	;	int t2_mili_load	=	22	;	double t2_mili_cost	=	0.42 	;	double t2_mili_power	=	1.4 	;
    int t3_mili_defense	=	13 	;	int t3_mili_hp	=	6 	;	int t3_mili_speed	=	9 	;	int t3_mili_load	=	25	;	double t3_mili_cost	=	0.62 	;	double t3_mili_power	=	1.9 	;
    int t4_mili_defense	=	35 	;	int t4_mili_hp	=	15 	;	int t4_mili_speed	=	8 	;	int t4_mili_load	=	25	;	double t4_mili_cost	=	0.83 	;	double t4_mili_power	=	2.5 	;
    int t5_mili_defense	=	22 	;	int t5_mili_hp	=	9 	;	int t5_mili_speed	=	9 	;	int t5_mili_load	=	27	;	double t5_mili_cost	=	1.04 	;	double t5_mili_power	=	3.2 	;
    int t6_mili_defense	=	56 	;	int t6_mili_hp	=	22 	;	int t6_mili_speed	=	8 	;	int t6_mili_load	=	27	;	double t6_mili_cost	=	1.25 	;	double t6_mili_power	=	4.0 	;
    int t7_mili_defense	=	68 	;	int t7_mili_hp	=	26 	;	int t7_mili_speed	=	8 	;	int t7_mili_load	=	30	;	double t7_mili_cost	=	1.46 	;	double t7_mili_power	=	4.9 	;
    int t8_mili_defense	=	41 	;	int t8_mili_hp	=	15 	;	int t8_mili_speed	=	9 	;	int t8_mili_load	=	30	;	double t8_mili_cost	=	1.67 	;	double t8_mili_power	=	5.9 	;
    int t9_mili_defense	=	49 	;	int t9_mili_hp	=	18 	;	int t9_mili_speed	=	9 	;	int t9_mili_load	=	33	;	double t9_mili_cost	=	1.88 	;	double t9_mili_power	=	7.0 	;
    int t10_mili_defense	=	114 	;	int t10_mili_hp	=	42 	;	int t10_mili_speed	=	8 	;	int t10_mili_load	=	33	;	double t10_mili_cost	=	2.08 	;	double t10_mili_power	=	8.2 	;

    int t1_mobile_fuel	=	0	;	int t1_mobile_food	=	57	;	int t1_mobile_steel	=	0	;	int t1_mobile_alloy	=	0	;	int t1_mobile_time	=	16	;	int t1_mobile_damage	=	11 	;	int t1_mobile_range	=	1 	;
    int t2_mobile_fuel	=	0	;	int t2_mobile_food	=	100	;	int t2_mobile_steel	=	0	;	int t2_mobile_alloy	=	0	;	int t2_mobile_time	=	20	;	int t2_mobile_damage	=	15 	;	int t2_mobile_range	=	1 	;
    int t3_mobile_fuel	=	0	;	int t3_mobile_food	=	155	;	int t3_mobile_steel	=	0	;	int t3_mobile_alloy	=	0	;	int t3_mobile_time	=	28	;	int t3_mobile_damage	=	20 	;	int t3_mobile_range	=	1 	;
    int t4_mobile_fuel	=	20	;	int t4_mobile_food	=	175	;	int t4_mobile_steel	=	2	;	int t4_mobile_alloy	=	0	;	int t4_mobile_time	=	44	;	int t4_mobile_damage	=	32 	;	int t4_mobile_range	=	4 	;
    int t5_mobile_fuel	=	27	;	int t5_mobile_food	=	228	;	int t5_mobile_steel	=	5	;	int t5_mobile_alloy	=	0	;	int t5_mobile_time	=	58	;	int t5_mobile_damage	=	41 	;	int t5_mobile_range	=	4 	;
    int t6_mobile_fuel	=	0	;	int t6_mobile_food	=	271	;	int t6_mobile_steel	=	15	;	int t6_mobile_alloy	=	0	;	int t6_mobile_time	=	75	;	int t6_mobile_damage	=	44 	;	int t6_mobile_range	=	1 	;
    int t7_mobile_fuel	=	56	;	int t7_mobile_food	=	269	;	int t7_mobile_steel	=	9	;	int t7_mobile_alloy	=	3	;	int t7_mobile_time	=	95	;	int t7_mobile_damage	=	63 	;	int t7_mobile_range	=	4 	;
    int t8_mobile_fuel	=	0	;	int t8_mobile_food	=	253	;	int t8_mobile_steel	=	27	;	int t8_mobile_alloy	=	5	;	int t8_mobile_time	=	118	;	int t8_mobile_damage	=	64 	;	int t8_mobile_range	=	1 	;
    int t9_mobile_fuel	=	104	;	int t9_mobile_food	=	276	;	int t9_mobile_steel	=	15	;	int t9_mobile_alloy	=	8	;	int t9_mobile_time	=	144	;	int t9_mobile_damage	=	91 	;	int t9_mobile_range	=	4 	;
    int t10_mobile_fuel	=	0	;	int t10_mobile_food	=	189	;	int t10_mobile_steel	=	52	;	int t10_mobile_alloy	=	11	;	int t10_mobile_time	=	173	;	int t10_mobile_damage	=	90 	;	int t10_mobile_range	=	1 	;

    int t1_mobile_defense	=	8 	;	int t1_mobile_hp	=	4 	;	int t1_mobile_speed	=	14 	;	int t1_mobile_load	=	50 	;	double t1_mobile_cost	=	0.21 	;	double t1_mobile_power	=	1.0 	;
    int t2_mobile_defense	=	11 	;	int t2_mobile_hp	=	4 	;	int t2_mobile_speed	=	14 	;	int t2_mobile_load	=	50 	;	double t2_mobile_cost	=	0.42 	;	double t2_mobile_power	=	1.4 	;
    int t3_mobile_defense	=	15 	;	int t3_mobile_hp	=	6 	;	int t3_mobile_speed	=	14 	;	int t3_mobile_load	=	52 	;	double t3_mobile_cost	=	0.62 	;	double t3_mobile_power	=	1.9 	;
    int t4_mobile_defense	=	17 	;	int t4_mobile_hp	=	7 	;	int t4_mobile_speed	=	13 	;	int t4_mobile_load	=	38 	;	double t4_mobile_cost	=	0.83 	;	double t4_mobile_power	=	2.5 	;
    int t5_mobile_defense	=	22 	;	int t5_mobile_hp	=	9 	;	int t5_mobile_speed	=	13 	;	int t5_mobile_load	=	41 	;	double t5_mobile_cost	=	1.04 	;	double t5_mobile_power	=	3.2 	;
    int t6_mobile_defense	=	32 	;	int t6_mobile_hp	=	11 	;	int t6_mobile_speed	=	14 	;	int t6_mobile_load	=	55 	;	double t6_mobile_cost	=	1.25 	;	double t6_mobile_power	=	4.0 	;
    int t7_mobile_defense	=	344 	;	int t7_mobile_hp	=	13 	;	int t7_mobile_speed	=	13 	;	int t7_mobile_load	=	44 	;	double t7_mobile_cost	=	1.46 	;	double t7_mobile_power	=	4.9 	;
    int t8_mobile_defense	=	47 	;	int t8_mobile_hp	=	15 	;	int t8_mobile_speed	=	14 	;	int t8_mobile_load	=	58 	;	double t8_mobile_cost	=	1.67 	;	double t8_mobile_power	=	5.9 	;
    int t9_mobile_defense	=	49 	;	int t9_mobile_hp	=	18 	;	int t9_mobile_speed	=	13 	;	int t9_mobile_load	=	47 	;	double t9_mobile_cost	=	1.88 	;	double t9_mobile_power	=	7.0 	;
    int t10_mobile_defense	=	65 	;	int t10_mobile_hp	=	21 	;	int t10_mobile_speed	=	14 	;	int t10_mobile_load	=	61 	;	double t10_mobile_cost	=	2.08 	;	double t10_mobile_power	=	8.2 	;


    EditText proj_1;	EditText proj_2;	EditText proj_3;	EditText proj_4;	EditText proj_5;	EditText proj_6;	EditText proj_7;	EditText proj_8;	EditText proj_9;	EditText proj_10;
    EditText arm_1;	EditText arm_2;	EditText arm_3;	EditText arm_4;	EditText arm_5;	EditText arm_6;	EditText arm_7;	EditText arm_8;	EditText arm_9;	EditText arm_10;
    EditText mili_1;	EditText mili_2;	EditText mili_3;	EditText mili_4;	EditText mili_5;	EditText mili_6;	EditText mili_7;	EditText mili_8;	EditText mili_9;	EditText mili_10;
    EditText mobile_1;	EditText mobile_2;	EditText mobile_3;	EditText mobile_4;	EditText mobile_5;	EditText mobile_6;	EditText mobile_7;	EditText mobile_8;	EditText mobile_9;	EditText mobile_10;
    EditText infect_1;	EditText infect_2;	EditText infect_3;	EditText infect_4;	EditText infect_5;	EditText infect_6;	EditText infect_7;	EditText infect_8;	EditText infect_9;	EditText infect_10;

    EditText buff01 , buff02 , buff03;

    LinearLayout proj , arm , mili , mobile , infect , buff;
    long fuel , food , steel , alloy , kyanite , kyanite_basic , kyanite_cluster , damage ,  defense , hp , speed , load ;
    TextView fuel_tv , food_tv , steel_tv , alloy_tv , time_tv , kyanite_tv , kyanite_basic_tv , kyanite_cluster_tv , damage_tv , defense_tv , hp_tv , speed_tv , load_tv , cost_tv , power_tv , total_tv;
    double cost , power ;
    long temp , total ,time;

    EditText day , hour , min , sec ;
    long count_l = 1 ;
    long count_t = 1 ;
    int troop_id = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_troops);

        proj = findViewById(R.id.proj_list);
        arm = findViewById(R.id.arm_list);
        mili = findViewById(R.id.mili_list);
        mobile = findViewById(R.id.mobile_list);
        infect = findViewById(R.id.infect_list);
        buff = findViewById(R.id.buff_list);

        proj_1 	= findViewById(R.id.proj_1_et);
        proj_2	= findViewById(R.id.proj_2_et);
        proj_3	= findViewById(R.id.proj_3_et);
        proj_4	= findViewById(R.id.proj_4_et);
        proj_5	= findViewById(R.id.proj_5_et);
        proj_6	= findViewById(R.id.proj_6_et);
        proj_7	= findViewById(R.id.proj_7_et);
        proj_8	= findViewById(R.id.proj_8_et);
        proj_9	= findViewById(R.id.proj_9_et);
        proj_10	= findViewById(R.id.proj_10_et);

        arm_1 	= findViewById(R.id.arm_1_et);
        arm_2	= findViewById(R.id.arm_2_et);
        arm_3	= findViewById(R.id.arm_3_et);
        arm_4	= findViewById(R.id.arm_4_et);
        arm_5	= findViewById(R.id.arm_5_et);
        arm_6	= findViewById(R.id.arm_6_et);
        arm_7	= findViewById(R.id.arm_7_et);
        arm_8	= findViewById(R.id.arm_8_et);
        arm_9	= findViewById(R.id.arm_9_et);
        arm_10	= findViewById(R.id.arm_10_et);

        mili_1 	= findViewById(R.id.mili_1_et);
        mili_2	= findViewById(R.id.mili_2_et);
        mili_3	= findViewById(R.id.mili_3_et);
        mili_4	= findViewById(R.id.mili_4_et);
        mili_5	= findViewById(R.id.mili_5_et);
        mili_6	= findViewById(R.id.mili_6_et);
        mili_7	= findViewById(R.id.mili_7_et);
        mili_8	= findViewById(R.id.mili_8_et);
        mili_9	= findViewById(R.id.mili_9_et);
        mili_10	= findViewById(R.id.mili_10_et);

        mobile_1 	= findViewById(R.id.mobile_1_et);
        mobile_2	= findViewById(R.id.mobile_2_et);
        mobile_3	= findViewById(R.id.mobile_3_et);
        mobile_4	= findViewById(R.id.mobile_4_et);
        mobile_5	= findViewById(R.id.mobile_5_et);
        mobile_6	= findViewById(R.id.mobile_6_et);
        mobile_7	= findViewById(R.id.mobile_7_et);
        mobile_8	= findViewById(R.id.mobile_8_et);
        mobile_9	= findViewById(R.id.mobile_9_et);
        mobile_10	= findViewById(R.id.mobile_10_et);

        infect_1 	= findViewById(R.id.infect_1_et);
        infect_2	= findViewById(R.id.infect_2_et);
        infect_3	= findViewById(R.id.infect_3_et);
        infect_4	= findViewById(R.id.infect_4_et);
        infect_5	= findViewById(R.id.infect_5_et);
        infect_6	= findViewById(R.id.infect_6_et);
        infect_7	= findViewById(R.id.infect_7_et);
        infect_8	= findViewById(R.id.infect_8_et);
        infect_9	= findViewById(R.id.infect_9_et);
        infect_10	= findViewById(R.id.infect_10_et);

        buff01	= findViewById(R.id.buff01c_et);
        buff02	= findViewById(R.id.buff02_et);
        buff03	= findViewById(R.id.buff03_et);

        day	= findViewById(R.id.buff01_et1);
        hour	= findViewById(R.id.buff01_et2);
        min	= findViewById(R.id.buff01_et3);
        sec	= findViewById(R.id.buff01_et4);

        fuel_tv = findViewById(R.id.troop_fuel);
        food_tv = findViewById(R.id.troop_food);
        steel_tv = findViewById(R.id.troop_steel);
        alloy_tv = findViewById(R.id.troop_alloy);
        kyanite_tv = findViewById(R.id.troop_kyanite);
        kyanite_basic_tv = findViewById(R.id.troop_kyanite_basic);
        kyanite_cluster_tv = findViewById(R.id.troop_kyanite_cluster);
        load_tv = findViewById(R.id.troop_load);
        cost_tv = findViewById(R.id.troop_cost);
        power_tv = findViewById(R.id.troop_power);
        time_tv = findViewById(R.id.troop_time);
        total_tv = findViewById(R.id.troop_total);

        ImageView troop_choose = findViewById(R.id.troop_choose);

        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);

        sharedPreferences.getString("troop_tv_size", "small");

        long buff1 = sharedPreferences.getLong("buff01", 10);
        long buff2 = sharedPreferences.getLong("buff02", 0);
        long buff3 = sharedPreferences.getLong("buff03", 0);
        long da = sharedPreferences.getLong("D", 0);
        long ho = sharedPreferences.getLong("H", 0);
        long mi = sharedPreferences.getLong("M", 2);
        long se = sharedPreferences.getLong("S", 40);
        long c_t = sharedPreferences.getLong("count_t", 10);
        long c_l = sharedPreferences.getLong("count_l", 10);
        troop_id = sharedPreferences.getInt("troop_id_act", 1);
        buff01.setText(String.valueOf(buff1));
        buff02.setText(String.valueOf(buff2));
        buff03.setText(String.valueOf(buff3));
        day.setText(String.valueOf(da));
        hour.setText(String.valueOf(ho));
        min.setText(String.valueOf(mi));
        sec.setText(String.valueOf(se));
        count_t = c_t;
        count_l = c_l;

        if(	troop_id ==	1)	{	troop_choose.setImageResource(R.drawable.	h_arm01	);}
        if(	troop_id ==	2)	{	troop_choose.setImageResource(R.drawable.	h_arm02	);}
        if(	troop_id ==	3)	{	troop_choose.setImageResource(R.drawable.	h_arm03	);}
        if(	troop_id ==	4)	{	troop_choose.setImageResource(R.drawable.	h_arm04	);}
        if(	troop_id ==	5)	{	troop_choose.setImageResource(R.drawable.	h_arm05	);}
        if(	troop_id ==	6)	{	troop_choose.setImageResource(R.drawable.	h_arm06	);}
        if(	troop_id ==	7)	{	troop_choose.setImageResource(R.drawable.	h_arm07	);}
        if(	troop_id ==	8)	{	troop_choose.setImageResource(R.drawable.	h_arm08	);}
        if(	troop_id ==	9)	{	troop_choose.setImageResource(R.drawable.	h_arm09	);}
        if(	troop_id ==	10)	{	troop_choose.setImageResource(R.drawable.	h_arm10	);}
        if(	troop_id ==	11)	{	troop_choose.setImageResource(R.drawable.	h_mili01	);}
        if(	troop_id ==	12)	{	troop_choose.setImageResource(R.drawable.	h_mili02	);}
        if(	troop_id ==	13)	{	troop_choose.setImageResource(R.drawable.	h_mili03	);}
        if(	troop_id ==	14)	{	troop_choose.setImageResource(R.drawable.	h_mili04	);}
        if(	troop_id ==	15)	{	troop_choose.setImageResource(R.drawable.	h_mili05	);}
        if(	troop_id ==	16)	{	troop_choose.setImageResource(R.drawable.	h_mili06	);}
        if(	troop_id ==	17)	{	troop_choose.setImageResource(R.drawable.	h_mili07	);}
        if(	troop_id ==	18)	{	troop_choose.setImageResource(R.drawable.	h_mili08	);}
        if(	troop_id ==	19)	{	troop_choose.setImageResource(R.drawable.	h_mili09	);}
        if(	troop_id ==	20)	{	troop_choose.setImageResource(R.drawable.	h_mili10	);}
        if(	troop_id ==	21)	{	troop_choose.setImageResource(R.drawable.	h_mobile01	);}
        if(	troop_id ==	22)	{	troop_choose.setImageResource(R.drawable.	h_mobile02	);}
        if(	troop_id ==	23)	{	troop_choose.setImageResource(R.drawable.	h_mobile03	);}
        if(	troop_id ==	24)	{	troop_choose.setImageResource(R.drawable.	h_mobile04	);}
        if(	troop_id ==	25)	{	troop_choose.setImageResource(R.drawable.	h_mobile05	);}
        if(	troop_id ==	26)	{	troop_choose.setImageResource(R.drawable.	h_mobile06	);}
        if(	troop_id ==	27)	{	troop_choose.setImageResource(R.drawable.	h_mobile07	);}
        if(	troop_id ==	28)	{	troop_choose.setImageResource(R.drawable.	h_mobile08	);}
        if(	troop_id ==	29)	{	troop_choose.setImageResource(R.drawable.	h_mobile09	);}
        if(	troop_id ==	30)	{	troop_choose.setImageResource(R.drawable.	h_mobile10	);}
        if(	troop_id ==	31)	{	troop_choose.setImageResource(R.drawable.	h_infect01	);}
        if(	troop_id ==	32)	{	troop_choose.setImageResource(R.drawable.	h_infect02	);}
        if(	troop_id ==	33)	{	troop_choose.setImageResource(R.drawable.	h_infect03	);}
        if(	troop_id ==	34)	{	troop_choose.setImageResource(R.drawable.	h_infect04	);}
        if(	troop_id ==	35)	{	troop_choose.setImageResource(R.drawable.	h_infect05	);}
        if(	troop_id ==	36)	{	troop_choose.setImageResource(R.drawable.	h_infect06	);}
        if(	troop_id ==	37)	{	troop_choose.setImageResource(R.drawable.	h_infect07	);}
        if(	troop_id ==	38)	{	troop_choose.setImageResource(R.drawable.	h_infect08	);}
        if(	troop_id ==	39)	{	troop_choose.setImageResource(R.drawable.	h_infect09	);}
        if(	troop_id ==	40)	{	troop_choose.setImageResource(R.drawable.	h_infect10	);}
        if(	troop_id ==	41)	{	troop_choose.setImageResource(R.drawable.	h_project01	);}
        if(	troop_id ==	42)	{	troop_choose.setImageResource(R.drawable.	h_project02	);}
        if(	troop_id ==	43)	{	troop_choose.setImageResource(R.drawable.	h_project03	);}
        if(	troop_id ==	44)	{	troop_choose.setImageResource(R.drawable.	h_project04	);}
        if(	troop_id ==	45)	{	troop_choose.setImageResource(R.drawable.	h_project05	);}
        if(	troop_id ==	46)	{	troop_choose.setImageResource(R.drawable.	h_project06	);}
        if(	troop_id ==	47)	{	troop_choose.setImageResource(R.drawable.	h_project07	);}
        if(	troop_id ==	48)	{	troop_choose.setImageResource(R.drawable.	h_project08	);}
        if(	troop_id ==	49)	{	troop_choose.setImageResource(R.drawable.	h_project09	);}
        if(	troop_id ==	50)	{	troop_choose.setImageResource(R.drawable.	h_project10	);}


        BackgroundReload();

        String troops_tv_size = sharedPreferences.getString("troop_tv_size", "small");
        if (troops_tv_size == "small"){
            fuel_tv.setTextSize(16);
            food_tv.setTextSize(16);
            steel_tv.setTextSize(16);
            alloy_tv.setTextSize(16);
            kyanite_tv.setTextSize(16);
            kyanite_basic_tv.setTextSize(16);
            kyanite_cluster_tv.setTextSize(16);
            load_tv.setTextSize(16);
            cost_tv.setTextSize(16);
            power_tv.setTextSize(16);
            time_tv.setTextSize(16);
        }
        if (troops_tv_size == "big"){
            fuel_tv.setTextSize(18);
            food_tv.setTextSize(18);
            steel_tv.setTextSize(18);
            alloy_tv.setTextSize(18);
            kyanite_tv.setTextSize(18);
            kyanite_basic_tv.setTextSize(18);
            kyanite_cluster_tv.setTextSize(18);
            load_tv.setTextSize(18);
            cost_tv.setTextSize(18);
            power_tv.setTextSize(18);
            time_tv.setTextSize(18);
        }
        input_data();
    }
    public void BackgroundReload (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.troop_bg);

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

    public void input_data() {
        SharedPreferences sharedPreferences = getSharedPreferences("json_data", Context.MODE_PRIVATE);
        mili_1.setText(String.valueOf((sharedPreferences.getLong("army01TotalNum",0))));
        mili_2.setText(String.valueOf((sharedPreferences.getLong("army02TotalNum",0))));
        mili_3.setText(String.valueOf((sharedPreferences.getLong("army03TotalNum",0))));
        mili_4.setText(String.valueOf((sharedPreferences.getLong("army04TotalNum",0))));
        mili_5.setText(String.valueOf((sharedPreferences.getLong("army05TotalNum",0))));
        mili_6.setText(String.valueOf((sharedPreferences.getLong("army06TotalNum",0))));
        mili_7.setText(String.valueOf((sharedPreferences.getLong("army07TotalNum",0))));
        mili_8.setText(String.valueOf((sharedPreferences.getLong("army08TotalNum",0))));
        mili_9.setText(String.valueOf((sharedPreferences.getLong("army09TotalNum",0))));
        mili_10.setText(String.valueOf((sharedPreferences.getLong("army10TotalNum",0))));
        mobile_1.setText(String.valueOf((sharedPreferences.getLong("army11TotalNum",0))));
        mobile_2.setText(String.valueOf((sharedPreferences.getLong("army12TotalNum",0))));
        mobile_3.setText(String.valueOf((sharedPreferences.getLong("army13TotalNum",0))));
        mobile_4.setText(String.valueOf((sharedPreferences.getLong("army14TotalNum",0))));
        mobile_5.setText(String.valueOf((sharedPreferences.getLong("army15TotalNum",0))));
        mobile_6.setText(String.valueOf((sharedPreferences.getLong("army16TotalNum",0))));
        mobile_7.setText(String.valueOf((sharedPreferences.getLong("army17TotalNum",0))));
        mobile_8.setText(String.valueOf((sharedPreferences.getLong("army18TotalNum",0))));
        mobile_9.setText(String.valueOf((sharedPreferences.getLong("army19TotalNum",0))));
        mobile_10.setText(String.valueOf((sharedPreferences.getLong("army20TotalNum",0))));
        arm_1.setText(String.valueOf((sharedPreferences.getLong("army21TotalNum",0))));
        arm_2.setText(String.valueOf((sharedPreferences.getLong("army22TotalNum",0))));
        arm_3.setText(String.valueOf((sharedPreferences.getLong("army23TotalNum",0))));
        arm_4.setText(String.valueOf((sharedPreferences.getLong("army24TotalNum",0))));
        arm_5.setText(String.valueOf((sharedPreferences.getLong("army25TotalNum",0))));
        arm_6.setText(String.valueOf((sharedPreferences.getLong("army26TotalNum",0))));
        arm_7.setText(String.valueOf((sharedPreferences.getLong("army27TotalNum",0))));
        arm_8.setText(String.valueOf((sharedPreferences.getLong("army28TotalNum",0))));
        arm_9.setText(String.valueOf((sharedPreferences.getLong("army29TotalNum",0))));
        arm_10.setText(String.valueOf((sharedPreferences.getLong("army30TotalNum",0))));
        infect_1.setText(String.valueOf((sharedPreferences.getLong("army31TotalNum",0))));
        infect_2.setText(String.valueOf((sharedPreferences.getLong("army32TotalNum",0))));
        infect_3.setText(String.valueOf((sharedPreferences.getLong("army33TotalNum",0))));
        infect_4.setText(String.valueOf((sharedPreferences.getLong("army34TotalNum",0))));
        infect_5.setText(String.valueOf((sharedPreferences.getLong("army35TotalNum",0))));
        infect_6.setText(String.valueOf((sharedPreferences.getLong("army36TotalNum",0))));
        infect_7.setText(String.valueOf((sharedPreferences.getLong("army37TotalNum",0))));
        infect_8.setText(String.valueOf((sharedPreferences.getLong("army38TotalNum",0))));
        infect_9.setText(String.valueOf((sharedPreferences.getLong("army39TotalNum",0))));
        infect_10.setText(String.valueOf((sharedPreferences.getLong("army40TotalNum",0))));
        proj_1.setText(String.valueOf((sharedPreferences.getLong("army41TotalNum",0))));
        proj_2.setText(String.valueOf((sharedPreferences.getLong("army42TotalNum",0))));
        proj_3.setText(String.valueOf((sharedPreferences.getLong("army43TotalNum",0))));
        proj_4.setText(String.valueOf((sharedPreferences.getLong("army44TotalNum",0))));
        proj_5.setText(String.valueOf((sharedPreferences.getLong("army45TotalNum",0))));
        proj_6.setText(String.valueOf((sharedPreferences.getLong("army46TotalNum",0))));
        proj_7.setText(String.valueOf((sharedPreferences.getLong("army47TotalNum",0))));
        proj_8.setText(String.valueOf((sharedPreferences.getLong("army48TotalNum",0))));
        proj_9.setText(String.valueOf((sharedPreferences.getLong("army49TotalNum",0))));
        proj_10.setText(String.valueOf((sharedPreferences.getLong("army50TotalNum",0))));

    }

    public void project (View view){
        proj.setVisibility(View.VISIBLE);
        arm.setVisibility(View.GONE);
        mili.setVisibility(View.GONE);
        mobile.setVisibility(View.GONE);
        infect.setVisibility(View.GONE);
        buff.setVisibility(View.GONE);
    }
    public void armed (View view){
        arm.setVisibility(View.VISIBLE);
        proj.setVisibility(View.GONE);
        mili.setVisibility(View.GONE);
        mobile.setVisibility(View.GONE);
        infect.setVisibility(View.GONE);
        buff.setVisibility(View.GONE);
    }
    public void mility (View view){
        mili.setVisibility(View.VISIBLE);
        arm.setVisibility(View.GONE);
        proj.setVisibility(View.GONE);
        mobile.setVisibility(View.GONE);
        infect.setVisibility(View.GONE);
        buff.setVisibility(View.GONE);
    }
    public void mobile (View view){
        mobile.setVisibility(View.VISIBLE);
        arm.setVisibility(View.GONE);
        mili.setVisibility(View.GONE);
        proj.setVisibility(View.GONE);
        infect.setVisibility(View.GONE);
        buff.setVisibility(View.GONE);
    }
    public void infection (View view){
        infect.setVisibility(View.VISIBLE);
        arm.setVisibility(View.GONE);
        mili.setVisibility(View.GONE);
        mobile.setVisibility(View.GONE);
        proj.setVisibility(View.GONE);
        buff.setVisibility(View.GONE);
    }
    public void buff (View view){
        buff.setVisibility(View.VISIBLE);
        arm.setVisibility(View.GONE);
        mili.setVisibility(View.GONE);
        mobile.setVisibility(View.GONE);
        proj.setVisibility(View.GONE);
        infect.setVisibility(View.GONE);
    }
    public void troop_calcalate (View view){
        fuel = food  = alloy = steel = kyanite = kyanite_basic = kyanite_cluster = load = 0;
        power = cost = 0;
        total = time= 0 ;

        long d = 0;
        long h = 0;
        long m = 2;
        long s = 40;

        if (String.valueOf(buff01.getText()) != null && !String.valueOf(buff01.getText()).equals("") && String.valueOf(buff01.getText()) != "0"){count_t = Long.parseLong(String.valueOf(buff01.getText()));}else{buff01.setText("10");count_t = Long.parseLong(String.valueOf(buff01.getText()));}
        if (String.valueOf(day.getText()) != null && !String.valueOf(day.getText()).equals("")){d = Long.parseLong(String.valueOf(day.getText()));}else{day.setText("0");d = Long.parseLong(String.valueOf(day.getText()));}
        if (String.valueOf(hour.getText()) != null && !String.valueOf(hour.getText()).equals("")){h = Long.parseLong(String.valueOf(hour.getText()));}else{hour.setText("0");h = Long.parseLong(String.valueOf(hour.getText()));}
        if (String.valueOf(min.getText()) != null && !String.valueOf(min.getText()).equals("")){m = Long.parseLong(String.valueOf(min.getText()));}else{min.setText("0");m = Long.parseLong(String.valueOf(min.getText()));}
        if (String.valueOf(sec.getText()) != null && !String.valueOf(sec.getText()).equals("")){s = Long.parseLong(String.valueOf(sec.getText()));}else{sec.setText("0");s = Long.parseLong(String.valueOf(sec.getText()));}


        if(proj_1.getText().toString().matches(""))	{proj_1.setText(	"0");}
        if(proj_2.getText().toString().matches(""))	{proj_2.setText(	"0");}
        if(proj_3.getText().toString().matches(""))	{proj_3.setText(	"0");}
        if(proj_4.getText().toString().matches(""))	{proj_4.setText(	"0");}
        if(proj_5.getText().toString().matches(""))	{proj_5.setText(	"0");}
        if(proj_6.getText().toString().matches(""))	{proj_6.setText(	"0");}
        if(proj_7.getText().toString().matches(""))	{proj_7.setText(	"0");}
        if(proj_8.getText().toString().matches(""))	{proj_8.setText(	"0");}
        if(proj_9.getText().toString().matches(""))	{proj_9.setText(	"0");}
        if(proj_10.getText().toString().matches(""))	{proj_10.setText(	"0");}

        if(arm_1.getText().toString().matches(""))	{arm_1.setText(	"0");}
        if(arm_2.getText().toString().matches(""))	{arm_2.setText(	"0");}
        if(arm_3.getText().toString().matches(""))	{arm_3.setText(	"0");}
        if(arm_4.getText().toString().matches(""))	{arm_4.setText(	"0");}
        if(arm_5.getText().toString().matches(""))	{arm_5.setText(	"0");}
        if(arm_6.getText().toString().matches(""))	{arm_6.setText(	"0");}
        if(arm_7.getText().toString().matches(""))	{arm_7.setText(	"0");}
        if(arm_8.getText().toString().matches(""))	{arm_8.setText(	"0");}
        if(arm_9.getText().toString().matches(""))	{arm_9.setText(	"0");}
        if(arm_10.getText().toString().matches(""))	{arm_10.setText(	"0");}

        if(mili_1.getText().toString().matches(""))	{mili_1.setText(	"0");}
        if(mili_2.getText().toString().matches(""))	{mili_2.setText(	"0");}
        if(mili_3.getText().toString().matches(""))	{mili_3.setText(	"0");}
        if(mili_4.getText().toString().matches(""))	{mili_4.setText(	"0");}
        if(mili_5.getText().toString().matches(""))	{mili_5.setText(	"0");}
        if(mili_6.getText().toString().matches(""))	{mili_6.setText(	"0");}
        if(mili_7.getText().toString().matches(""))	{mili_7.setText(	"0");}
        if(mili_8.getText().toString().matches(""))	{mili_8.setText(	"0");}
        if(mili_9.getText().toString().matches(""))	{mili_9.setText(	"0");}
        if(mili_10.getText().toString().matches(""))	{mili_10.setText(	"0");}

        if(mobile_1.getText().toString().matches(""))	{mobile_1.setText(	"0");}
        if(mobile_2.getText().toString().matches(""))	{mobile_2.setText(	"0");}
        if(mobile_3.getText().toString().matches(""))	{mobile_3.setText(	"0");}
        if(mobile_4.getText().toString().matches(""))	{mobile_4.setText(	"0");}
        if(mobile_5.getText().toString().matches(""))	{mobile_5.setText(	"0");}
        if(mobile_6.getText().toString().matches(""))	{mobile_6.setText(	"0");}
        if(mobile_7.getText().toString().matches(""))	{mobile_7.setText(	"0");}
        if(mobile_8.getText().toString().matches(""))	{mobile_8.setText(	"0");}
        if(mobile_9.getText().toString().matches(""))	{mobile_9.setText(	"0");}
        if(mobile_10.getText().toString().matches(""))	{mobile_10.setText(	"0");}

        if(infect_1.getText().toString().matches(""))	{infect_1.setText(	"0");}
        if(infect_2.getText().toString().matches(""))	{infect_2.setText(	"0");}
        if(infect_3.getText().toString().matches(""))	{infect_3.setText(	"0");}
        if(infect_4.getText().toString().matches(""))	{infect_4.setText(	"0");}
        if(infect_5.getText().toString().matches(""))	{infect_5.setText(	"0");}
        if(infect_6.getText().toString().matches(""))	{infect_6.setText(	"0");}
        if(infect_7.getText().toString().matches(""))	{infect_7.setText(	"0");}
        if(infect_8.getText().toString().matches(""))	{infect_8.setText(	"0");}
        if(infect_9.getText().toString().matches(""))	{infect_9.setText(	"0");}
        if(infect_10.getText().toString().matches(""))	{infect_10.setText(	"0");}

        String temp1 = 	String.valueOf(proj_1.getText());	temp = Long.parseLong(temp1);	kyanite = kyanite+t1_proj_kyanite*temp;	kyanite_basic = kyanite_basic+t1_proj_kyanite_basic*temp;	kyanite_cluster = kyanite_cluster+t1_proj_kyanite_cluster*temp;	steel = steel+t1_proj_steel*temp;	alloy = alloy+t1_proj_alloy*temp;	time =  time+t1_proj_time*temp;	damage = damage+ t1_proj_damage*temp;	defense = defense+t1_proj_defense*temp;	hp = hp+t1_proj_hp*temp;	speed = speed+t1_proj_speed*temp;	load = load+t1_proj_load*temp;	power = power+t1_proj_power*temp;	damage = damage+t1_proj_damage*temp;	defense = defense+t1_proj_defense*temp;	hp = hp+t1_proj_hp*temp;	speed = speed+t1_proj_speed*temp;	cost = cost+t1_proj_cost*temp;	cost = cost+t1_proj_cost*temp;
        String temp2 =	String.valueOf(proj_2.getText());	temp = Long.parseLong(temp2);	kyanite = kyanite+t2_proj_kyanite*temp;	kyanite_basic = kyanite_basic+t2_proj_kyanite_basic*temp;	kyanite_cluster = kyanite_cluster+t2_proj_kyanite_cluster*temp;	steel = steel+t2_proj_steel*temp;	alloy = alloy+t2_proj_alloy*temp;	time =  time+t2_proj_time*temp;	damage = damage+ t2_proj_damage*temp;	defense = defense+t2_proj_defense*temp;	hp = hp+t2_proj_hp*temp;	speed = speed+t2_proj_speed*temp;	load = load+t2_proj_load*temp;	power = power+t2_proj_power*temp;	damage = damage+t2_proj_damage*temp;	defense = defense+t2_proj_defense*temp;	hp = hp+t2_proj_hp*temp;	speed = speed+t2_proj_speed*temp;	cost = cost+t2_proj_cost*temp;	cost = cost+t2_proj_cost*temp;
        String temp3 =	String.valueOf(proj_3.getText());	temp = Long.parseLong(temp3);	kyanite = kyanite+t3_proj_kyanite*temp;	kyanite_basic = kyanite_basic+t3_proj_kyanite_basic*temp;	kyanite_cluster = kyanite_cluster+t3_proj_kyanite_cluster*temp;	steel = steel+t3_proj_steel*temp;	alloy = alloy+t3_proj_alloy*temp;	time =  time+t3_proj_time*temp;	damage = damage+ t3_proj_damage*temp;	defense = defense+t3_proj_defense*temp;	hp = hp+t3_proj_hp*temp;	speed = speed+t3_proj_speed*temp;	load = load+t3_proj_load*temp;	power = power+t3_proj_power*temp;	damage = damage+t3_proj_damage*temp;	defense = defense+t3_proj_defense*temp;	hp = hp+t3_proj_hp*temp;	speed = speed+t3_proj_speed*temp;	cost = cost+t3_proj_cost*temp;	cost = cost+t3_proj_cost*temp;
        String temp4 =	String.valueOf(proj_4.getText());	temp = Long.parseLong(temp4);	kyanite = kyanite+t4_proj_kyanite*temp;	kyanite_basic = kyanite_basic+t4_proj_kyanite_basic*temp;	kyanite_cluster = kyanite_cluster+t4_proj_kyanite_cluster*temp;	steel = steel+t4_proj_steel*temp;	alloy = alloy+t4_proj_alloy*temp;	time =  time+t4_proj_time*temp;	damage = damage+ t4_proj_damage*temp;	defense = defense+t4_proj_defense*temp;	hp = hp+t4_proj_hp*temp;	speed = speed+t4_proj_speed*temp;	load = load+t4_proj_load*temp;	power = power+t4_proj_power*temp;	damage = damage+t4_proj_damage*temp;	defense = defense+t4_proj_defense*temp;	hp = hp+t4_proj_hp*temp;	speed = speed+t4_proj_speed*temp;	cost = cost+t4_proj_cost*temp;	cost = cost+t4_proj_cost*temp;
        String temp5 =	String.valueOf(proj_5.getText());	temp = Long.parseLong(temp5);	kyanite = kyanite+t5_proj_kyanite*temp;	kyanite_basic = kyanite_basic+t5_proj_kyanite_basic*temp;	kyanite_cluster = kyanite_cluster+t5_proj_kyanite_cluster*temp;	steel = steel+t5_proj_steel*temp;	alloy = alloy+t5_proj_alloy*temp;	time =  time+t5_proj_time*temp;	damage = damage+ t5_proj_damage*temp;	defense = defense+t5_proj_defense*temp;	hp = hp+t5_proj_hp*temp;	speed = speed+t5_proj_speed*temp;	load = load+t5_proj_load*temp;	power = power+t5_proj_power*temp;	damage = damage+t5_proj_damage*temp;	defense = defense+t5_proj_defense*temp;	hp = hp+t5_proj_hp*temp;	speed = speed+t5_proj_speed*temp;	cost = cost+t5_proj_cost*temp;	cost = cost+t5_proj_cost*temp;
        String temp6 =	String.valueOf(proj_6.getText());	temp = Long.parseLong(temp6);	kyanite = kyanite+t6_proj_kyanite*temp;	kyanite_basic = kyanite_basic+t6_proj_kyanite_basic*temp;	kyanite_cluster = kyanite_cluster+t6_proj_kyanite_cluster*temp;	steel = steel+t6_proj_steel*temp;	alloy = alloy+t6_proj_alloy*temp;	time =  time+t6_proj_time*temp;	damage = damage+ t6_proj_damage*temp;	defense = defense+t6_proj_defense*temp;	hp = hp+t6_proj_hp*temp;	speed = speed+t6_proj_speed*temp;	load = load+t6_proj_load*temp;	power = power+t6_proj_power*temp;	damage = damage+t6_proj_damage*temp;	defense = defense+t6_proj_defense*temp;	hp = hp+t6_proj_hp*temp;	speed = speed+t6_proj_speed*temp;	cost = cost+t6_proj_cost*temp;	cost = cost+t6_proj_cost*temp;
        String temp7 =	String.valueOf(proj_7.getText());	temp = Long.parseLong(temp7);	kyanite = kyanite+t7_proj_kyanite*temp;	kyanite_basic = kyanite_basic+t7_proj_kyanite_basic*temp;	kyanite_cluster = kyanite_cluster+t7_proj_kyanite_cluster*temp;	steel = steel+t7_proj_steel*temp;	alloy = alloy+t7_proj_alloy*temp;	time =  time+t7_proj_time*temp;	damage = damage+ t7_proj_damage*temp;	defense = defense+t7_proj_defense*temp;	hp = hp+t7_proj_hp*temp;	speed = speed+t7_proj_speed*temp;	load = load+t7_proj_load*temp;	power = power+t7_proj_power*temp;	damage = damage+t7_proj_damage*temp;	defense = defense+t7_proj_defense*temp;	hp = hp+t7_proj_hp*temp;	speed = speed+t7_proj_speed*temp;	cost = cost+t7_proj_cost*temp;	cost = cost+t7_proj_cost*temp;
        String temp8 =	String.valueOf(proj_8.getText());	temp = Long.parseLong(temp8);	kyanite = kyanite+t8_proj_kyanite*temp;	kyanite_basic = kyanite_basic+t8_proj_kyanite_basic*temp;	kyanite_cluster = kyanite_cluster+t8_proj_kyanite_cluster*temp;	steel = steel+t8_proj_steel*temp;	alloy = alloy+t8_proj_alloy*temp;	time =  time+t8_proj_time*temp;	damage = damage+ t8_proj_damage*temp;	defense = defense+t8_proj_defense*temp;	hp = hp+t8_proj_hp*temp;	speed = speed+t8_proj_speed*temp;	load = load+t8_proj_load*temp;	power = power+t8_proj_power*temp;	damage = damage+t8_proj_damage*temp;	defense = defense+t8_proj_defense*temp;	hp = hp+t8_proj_hp*temp;	speed = speed+t8_proj_speed*temp;	cost = cost+t8_proj_cost*temp;	cost = cost+t8_proj_cost*temp;
        String temp9 =	String.valueOf(proj_9.getText());	temp = Long.parseLong(temp9);	kyanite = kyanite+t9_proj_kyanite*temp;	kyanite_basic = kyanite_basic+t9_proj_kyanite_basic*temp;	kyanite_cluster = kyanite_cluster+t9_proj_kyanite_cluster*temp;	steel = steel+t9_proj_steel*temp;	alloy = alloy+t9_proj_alloy*temp;	time =  time+t9_proj_time*temp;	damage = damage+ t9_proj_damage*temp;	defense = defense+t9_proj_defense*temp;	hp = hp+t9_proj_hp*temp;	speed = speed+t9_proj_speed*temp;	load = load+t9_proj_load*temp;	power = power+t9_proj_power*temp;	damage = damage+t9_proj_damage*temp;	defense = defense+t9_proj_defense*temp;	hp = hp+t9_proj_hp*temp;	speed = speed+t9_proj_speed*temp;	cost = cost+t9_proj_cost*temp;	cost = cost+t9_proj_cost*temp;
        String temp10 =	String.valueOf(proj_10.getText());	temp = Long.parseLong(temp10);	kyanite = kyanite+t10_proj_kyanite*temp;	kyanite_basic = kyanite_basic+t10_proj_kyanite_basic*temp;	kyanite_cluster = kyanite_cluster+t10_proj_kyanite_cluster*temp;	steel = steel+t10_proj_steel*temp;	alloy = alloy+t10_proj_alloy*temp;	time =  time+t10_proj_time*temp;	damage = damage+ t10_proj_damage*temp;	defense = defense+t10_proj_defense*temp;	hp = hp+t10_proj_hp*temp;	speed = speed+t10_proj_speed*temp;	load = load+t10_proj_load*temp;	power = power+t10_proj_power*temp;	damage = damage+t10_proj_damage*temp;	defense = defense+t10_proj_defense*temp;	hp = hp+t10_proj_hp*temp;	speed = speed+t10_proj_speed*temp;	cost = cost+t10_proj_cost*temp;	cost = cost+t10_proj_cost*temp;
        String temp11 =	String.valueOf(arm_1.getText());	temp = Long.parseLong(temp11);	food = food+t1_arm_food*temp;	fuel = fuel+t1_arm_fuel*temp;	steel = steel+t1_arm_steel*temp;	alloy = alloy+t1_arm_alloy*temp;	time =  time+t1_arm_time*temp;	damage = damage+ t1_arm_damage*temp;	defense = defense+t1_arm_defense*temp;	hp = hp+t1_arm_hp*temp;	speed = speed+t1_arm_speed*temp;	load = load+t1_arm_load*temp;	power = power+t1_arm_power*temp;	damage = damage+t1_arm_damage*temp;	defense = defense+t1_arm_defense*temp;	hp = hp+t1_arm_hp*temp;	speed = speed+t1_arm_speed*temp;	cost = cost+t1_arm_cost*temp;
        String temp12 =	String.valueOf(arm_2.getText());	temp = Long.parseLong(temp12);	food = food+t2_arm_food*temp;	fuel = fuel+t2_arm_fuel*temp;	steel = steel+t2_arm_steel*temp;	alloy = alloy+t2_arm_alloy*temp;	time =  time+t2_arm_time*temp;	damage = damage+ t2_arm_damage*temp;	defense = defense+t2_arm_defense*temp;	hp = hp+t2_arm_hp*temp;	speed = speed+t2_arm_speed*temp;	load = load+t2_arm_load*temp;	power = power+t2_arm_power*temp;	damage = damage+t2_arm_damage*temp;	defense = defense+t2_arm_defense*temp;	hp = hp+t2_arm_hp*temp;	speed = speed+t2_arm_speed*temp;	cost = cost+t2_arm_cost*temp;
        String temp13 =	String.valueOf(arm_3.getText());	temp = Long.parseLong(temp13);	food = food+t3_arm_food*temp;	fuel = fuel+t3_arm_fuel*temp;	steel = steel+t3_arm_steel*temp;	alloy = alloy+t3_arm_alloy*temp;	time =  time+t3_arm_time*temp;	damage = damage+ t3_arm_damage*temp;	defense = defense+t3_arm_defense*temp;	hp = hp+t3_arm_hp*temp;	speed = speed+t3_arm_speed*temp;	load = load+t3_arm_load*temp;	power = power+t3_arm_power*temp;	damage = damage+t3_arm_damage*temp;	defense = defense+t3_arm_defense*temp;	hp = hp+t3_arm_hp*temp;	speed = speed+t3_arm_speed*temp;	cost = cost+t3_arm_cost*temp;
        String temp14 =	String.valueOf(arm_4.getText());	temp = Long.parseLong(temp14);	food = food+t4_arm_food*temp;	fuel = fuel+t4_arm_fuel*temp;	steel = steel+t4_arm_steel*temp;	alloy = alloy+t4_arm_alloy*temp;	time =  time+t4_arm_time*temp;	damage = damage+ t4_arm_damage*temp;	defense = defense+t4_arm_defense*temp;	hp = hp+t4_arm_hp*temp;	speed = speed+t4_arm_speed*temp;	load = load+t4_arm_load*temp;	power = power+t4_arm_power*temp;	damage = damage+t4_arm_damage*temp;	defense = defense+t4_arm_defense*temp;	hp = hp+t4_arm_hp*temp;	speed = speed+t4_arm_speed*temp;	cost = cost+t4_arm_cost*temp;
        String temp15 =	String.valueOf(arm_5.getText());	temp = Long.parseLong(temp15);	food = food+t5_arm_food*temp;	fuel = fuel+t5_arm_fuel*temp;	steel = steel+t5_arm_steel*temp;	alloy = alloy+t5_arm_alloy*temp;	time =  time+t5_arm_time*temp;	damage = damage+ t5_arm_damage*temp;	defense = defense+t5_arm_defense*temp;	hp = hp+t5_arm_hp*temp;	speed = speed+t5_arm_speed*temp;	load = load+t5_arm_load*temp;	power = power+t5_arm_power*temp;	damage = damage+t5_arm_damage*temp;	defense = defense+t5_arm_defense*temp;	hp = hp+t5_arm_hp*temp;	speed = speed+t5_arm_speed*temp;	cost = cost+t5_arm_cost*temp;
        String temp16 =	String.valueOf(arm_6.getText());	temp = Long.parseLong(temp16);	food = food+t6_arm_food*temp;	fuel = fuel+t6_arm_fuel*temp;	steel = steel+t6_arm_steel*temp;	alloy = alloy+t6_arm_alloy*temp;	time =  time+t6_arm_time*temp;	damage = damage+ t6_arm_damage*temp;	defense = defense+t6_arm_defense*temp;	hp = hp+t6_arm_hp*temp;	speed = speed+t6_arm_speed*temp;	load = load+t6_arm_load*temp;	power = power+t6_arm_power*temp;	damage = damage+t6_arm_damage*temp;	defense = defense+t6_arm_defense*temp;	hp = hp+t6_arm_hp*temp;	speed = speed+t6_arm_speed*temp;	cost = cost+t6_arm_cost*temp;
        String temp17 =	String.valueOf(arm_7.getText());	temp = Long.parseLong(temp17);	food = food+t7_arm_food*temp;	fuel = fuel+t7_arm_fuel*temp;	steel = steel+t7_arm_steel*temp;	alloy = alloy+t7_arm_alloy*temp;	time =  time+t7_arm_time*temp;	damage = damage+ t7_arm_damage*temp;	defense = defense+t7_arm_defense*temp;	hp = hp+t7_arm_hp*temp;	speed = speed+t7_arm_speed*temp;	load = load+t7_arm_load*temp;	power = power+t7_arm_power*temp;	damage = damage+t7_arm_damage*temp;	defense = defense+t7_arm_defense*temp;	hp = hp+t7_arm_hp*temp;	speed = speed+t7_arm_speed*temp;	cost = cost+t7_arm_cost*temp;
        String temp18 =	String.valueOf(arm_8.getText());	temp = Long.parseLong(temp18);	food = food+t8_arm_food*temp;	fuel = fuel+t8_arm_fuel*temp;	steel = steel+t8_arm_steel*temp;	alloy = alloy+t8_arm_alloy*temp;	time =  time+t8_arm_time*temp;	damage = damage+ t8_arm_damage*temp;	defense = defense+t8_arm_defense*temp;	hp = hp+t8_arm_hp*temp;	speed = speed+t8_arm_speed*temp;	load = load+t8_arm_load*temp;	power = power+t8_arm_power*temp;	damage = damage+t8_arm_damage*temp;	defense = defense+t8_arm_defense*temp;	hp = hp+t8_arm_hp*temp;	speed = speed+t8_arm_speed*temp;	cost = cost+t8_arm_cost*temp;
        String temp19 =	String.valueOf(arm_9.getText());	temp = Long.parseLong(temp19);	food = food+t9_arm_food*temp;	fuel = fuel+t9_arm_fuel*temp;	steel = steel+t9_arm_steel*temp;	alloy = alloy+t9_arm_alloy*temp;	time =  time+t9_arm_time*temp;	damage = damage+ t9_arm_damage*temp;	defense = defense+t9_arm_defense*temp;	hp = hp+t9_arm_hp*temp;	speed = speed+t9_arm_speed*temp;	load = load+t9_arm_load*temp;	power = power+t9_arm_power*temp;	damage = damage+t9_arm_damage*temp;	defense = defense+t9_arm_defense*temp;	hp = hp+t9_arm_hp*temp;	speed = speed+t9_arm_speed*temp;	cost = cost+t9_arm_cost*temp;
        String temp20 =	String.valueOf(arm_10.getText());	temp = Long.parseLong(temp20);	food = food+t10_arm_food*temp;	fuel = fuel+t10_arm_fuel*temp;	steel = steel+t10_arm_steel*temp;	alloy = alloy+t10_arm_alloy*temp;	time =  time+t10_arm_time*temp;	damage = damage+ t10_arm_damage*temp;	defense = defense+t10_arm_defense*temp;	hp = hp+t10_arm_hp*temp;	speed = speed+t10_arm_speed*temp;	load = load+t10_arm_load*temp;	power = power+t10_arm_power*temp;	damage = damage+t10_arm_damage*temp;	defense = defense+t10_arm_defense*temp;	hp = hp+t10_arm_hp*temp;	speed = speed+t10_arm_speed*temp;	cost = cost+t10_arm_cost*temp;
        String temp21 =	String.valueOf(mili_1.getText());	temp = Long.parseLong(temp21);	food = food+t1_mili_food*temp;	fuel = fuel+t1_mili_fuel*temp;	steel = steel+t1_mili_steel*temp;	alloy = alloy+t1_mili_alloy*temp;	time =  time+t1_mili_time*temp;	damage = damage+ t1_mili_damage*temp;	defense = defense+t1_mili_defense*temp;	hp = hp+t1_mili_hp*temp;	speed = speed+t1_mili_speed*temp;	load = load+t1_mili_load*temp;	power = power+t1_mili_power*temp;	damage = damage+t1_mili_damage*temp;	defense = defense+t1_mili_defense*temp;	hp = hp+t1_mili_hp*temp;	speed = speed+t1_mili_speed*temp;	cost = cost+t1_mili_cost*temp;
        String temp22 =	String.valueOf(mili_2.getText());	temp = Long.parseLong(temp22);	food = food+t2_mili_food*temp;	fuel = fuel+t2_mili_fuel*temp;	steel = steel+t2_mili_steel*temp;	alloy = alloy+t2_mili_alloy*temp;	time =  time+t2_mili_time*temp;	damage = damage+ t2_mili_damage*temp;	defense = defense+t2_mili_defense*temp;	hp = hp+t2_mili_hp*temp;	speed = speed+t2_mili_speed*temp;	load = load+t2_mili_load*temp;	power = power+t2_mili_power*temp;	damage = damage+t2_mili_damage*temp;	defense = defense+t2_mili_defense*temp;	hp = hp+t2_mili_hp*temp;	speed = speed+t2_mili_speed*temp;	cost = cost+t2_mili_cost*temp;
        String temp23 =	String.valueOf(mili_3.getText());	temp = Long.parseLong(temp23);	food = food+t3_mili_food*temp;	fuel = fuel+t3_mili_fuel*temp;	steel = steel+t3_mili_steel*temp;	alloy = alloy+t3_mili_alloy*temp;	time =  time+t3_mili_time*temp;	damage = damage+ t3_mili_damage*temp;	defense = defense+t3_mili_defense*temp;	hp = hp+t3_mili_hp*temp;	speed = speed+t3_mili_speed*temp;	load = load+t3_mili_load*temp;	power = power+t3_mili_power*temp;	damage = damage+t3_mili_damage*temp;	defense = defense+t3_mili_defense*temp;	hp = hp+t3_mili_hp*temp;	speed = speed+t3_mili_speed*temp;	cost = cost+t3_mili_cost*temp;
        String temp24 =	String.valueOf(mili_4.getText());	temp = Long.parseLong(temp24);	food = food+t4_mili_food*temp;	fuel = fuel+t4_mili_fuel*temp;	steel = steel+t4_mili_steel*temp;	alloy = alloy+t4_mili_alloy*temp;	time =  time+t4_mili_time*temp;	damage = damage+ t4_mili_damage*temp;	defense = defense+t4_mili_defense*temp;	hp = hp+t4_mili_hp*temp;	speed = speed+t4_mili_speed*temp;	load = load+t4_mili_load*temp;	power = power+t4_mili_power*temp;	damage = damage+t4_mili_damage*temp;	defense = defense+t4_mili_defense*temp;	hp = hp+t4_mili_hp*temp;	speed = speed+t4_mili_speed*temp;	cost = cost+t4_mili_cost*temp;
        String temp25 =	String.valueOf(mili_5.getText());	temp = Long.parseLong(temp25);	food = food+t5_mili_food*temp;	fuel = fuel+t5_mili_fuel*temp;	steel = steel+t5_mili_steel*temp;	alloy = alloy+t5_mili_alloy*temp;	time =  time+t5_mili_time*temp;	damage = damage+ t5_mili_damage*temp;	defense = defense+t5_mili_defense*temp;	hp = hp+t5_mili_hp*temp;	speed = speed+t5_mili_speed*temp;	load = load+t5_mili_load*temp;	power = power+t5_mili_power*temp;	damage = damage+t5_mili_damage*temp;	defense = defense+t5_mili_defense*temp;	hp = hp+t5_mili_hp*temp;	speed = speed+t5_mili_speed*temp;	cost = cost+t5_mili_cost*temp;
        String temp26 =	String.valueOf(mili_6.getText());	temp = Long.parseLong(temp26);	food = food+t6_mili_food*temp;	fuel = fuel+t6_mili_fuel*temp;	steel = steel+t6_mili_steel*temp;	alloy = alloy+t6_mili_alloy*temp;	time =  time+t6_mili_time*temp;	damage = damage+ t6_mili_damage*temp;	defense = defense+t6_mili_defense*temp;	hp = hp+t6_mili_hp*temp;	speed = speed+t6_mili_speed*temp;	load = load+t6_mili_load*temp;	power = power+t6_mili_power*temp;	damage = damage+t6_mili_damage*temp;	defense = defense+t6_mili_defense*temp;	hp = hp+t6_mili_hp*temp;	speed = speed+t6_mili_speed*temp;	cost = cost+t6_mili_cost*temp;
        String temp27 =	String.valueOf(mili_7.getText());	temp = Long.parseLong(temp27);	food = food+t7_mili_food*temp;	fuel = fuel+t7_mili_fuel*temp;	steel = steel+t7_mili_steel*temp;	alloy = alloy+t7_mili_alloy*temp;	time =  time+t7_mili_time*temp;	damage = damage+ t7_mili_damage*temp;	defense = defense+t7_mili_defense*temp;	hp = hp+t7_mili_hp*temp;	speed = speed+t7_mili_speed*temp;	load = load+t7_mili_load*temp;	power = power+t7_mili_power*temp;	damage = damage+t7_mili_damage*temp;	defense = defense+t7_mili_defense*temp;	hp = hp+t7_mili_hp*temp;	speed = speed+t7_mili_speed*temp;	cost = cost+t7_mili_cost*temp;
        String temp28 =	String.valueOf(mili_8.getText());	temp = Long.parseLong(temp28);	food = food+t8_mili_food*temp;	fuel = fuel+t8_mili_fuel*temp;	steel = steel+t8_mili_steel*temp;	alloy = alloy+t8_mili_alloy*temp;	time =  time+t8_mili_time*temp;	damage = damage+ t8_mili_damage*temp;	defense = defense+t8_mili_defense*temp;	hp = hp+t8_mili_hp*temp;	speed = speed+t8_mili_speed*temp;	load = load+t8_mili_load*temp;	power = power+t8_mili_power*temp;	damage = damage+t8_mili_damage*temp;	defense = defense+t8_mili_defense*temp;	hp = hp+t8_mili_hp*temp;	speed = speed+t8_mili_speed*temp;	cost = cost+t8_mili_cost*temp;
        String temp29 =	String.valueOf(mili_9.getText());	temp = Long.parseLong(temp29);	food = food+t9_mili_food*temp;	fuel = fuel+t9_mili_fuel*temp;	steel = steel+t9_mili_steel*temp;	alloy = alloy+t9_mili_alloy*temp;	time =  time+t9_mili_time*temp;	damage = damage+ t9_mili_damage*temp;	defense = defense+t9_mili_defense*temp;	hp = hp+t9_mili_hp*temp;	speed = speed+t9_mili_speed*temp;	load = load+t9_mili_load*temp;	power = power+t9_mili_power*temp;	damage = damage+t9_mili_damage*temp;	defense = defense+t9_mili_defense*temp;	hp = hp+t9_mili_hp*temp;	speed = speed+t9_mili_speed*temp;	cost = cost+t9_mili_cost*temp;
        String temp30 =	String.valueOf(mili_10.getText());	temp = Long.parseLong(temp30);	food = food+t10_mili_food*temp;	fuel = fuel+t10_mili_fuel*temp;	steel = steel+t10_mili_steel*temp;	alloy = alloy+t10_mili_alloy*temp;	time =  time+t10_mili_time*temp;	damage = damage+ t10_mili_damage*temp;	defense = defense+t10_mili_defense*temp;	hp = hp+t10_mili_hp*temp;	speed = speed+t10_mili_speed*temp;	load = load+t10_mili_load*temp;	power = power+t10_mili_power*temp;	damage = damage+t10_mili_damage*temp;	defense = defense+t10_mili_defense*temp;	hp = hp+t10_mili_hp*temp;	speed = speed+t10_mili_speed*temp;	cost = cost+t10_mili_cost*temp;
        String temp31 =	String.valueOf(mobile_1.getText());	temp = Long.parseLong(temp31);	food = food+t1_mobile_food*temp;	fuel = fuel+t1_mobile_fuel*temp;	steel = steel+t1_mobile_steel*temp;	alloy = alloy+t1_mobile_alloy*temp;	time =  time+t1_mobile_time*temp;	damage = damage+ t1_mobile_damage*temp;	defense = defense+t1_mobile_defense*temp;	hp = hp+t1_mobile_hp*temp;	speed = speed+t1_mobile_speed*temp;	load = load+t1_mobile_load*temp;	power = power+t1_mobile_power*temp;	damage = damage+t1_mobile_damage*temp;	defense = defense+t1_mobile_defense*temp;	hp = hp+t1_mobile_hp*temp;	speed = speed+t1_mobile_speed*temp;	cost = cost+t1_mobile_cost*temp;
        String temp32 =	String.valueOf(mobile_2.getText());	temp = Long.parseLong(temp32);	food = food+t2_mobile_food*temp;	fuel = fuel+t2_mobile_fuel*temp;	steel = steel+t2_mobile_steel*temp;	alloy = alloy+t2_mobile_alloy*temp;	time =  time+t2_mobile_time*temp;	damage = damage+ t2_mobile_damage*temp;	defense = defense+t2_mobile_defense*temp;	hp = hp+t2_mobile_hp*temp;	speed = speed+t2_mobile_speed*temp;	load = load+t2_mobile_load*temp;	power = power+t2_mobile_power*temp;	damage = damage+t2_mobile_damage*temp;	defense = defense+t2_mobile_defense*temp;	hp = hp+t2_mobile_hp*temp;	speed = speed+t2_mobile_speed*temp;	cost = cost+t2_mobile_cost*temp;
        String temp33 =	String.valueOf(mobile_3.getText());	temp = Long.parseLong(temp33);	food = food+t3_mobile_food*temp;	fuel = fuel+t3_mobile_fuel*temp;	steel = steel+t3_mobile_steel*temp;	alloy = alloy+t3_mobile_alloy*temp;	time =  time+t3_mobile_time*temp;	damage = damage+ t3_mobile_damage*temp;	defense = defense+t3_mobile_defense*temp;	hp = hp+t3_mobile_hp*temp;	speed = speed+t3_mobile_speed*temp;	load = load+t3_mobile_load*temp;	power = power+t3_mobile_power*temp;	damage = damage+t3_mobile_damage*temp;	defense = defense+t3_mobile_defense*temp;	hp = hp+t3_mobile_hp*temp;	speed = speed+t3_mobile_speed*temp;	cost = cost+t3_mobile_cost*temp;
        String temp34 =	String.valueOf(mobile_4.getText());	temp = Long.parseLong(temp34);	food = food+t4_mobile_food*temp;	fuel = fuel+t4_mobile_fuel*temp;	steel = steel+t4_mobile_steel*temp;	alloy = alloy+t4_mobile_alloy*temp;	time =  time+t4_mobile_time*temp;	damage = damage+ t4_mobile_damage*temp;	defense = defense+t4_mobile_defense*temp;	hp = hp+t4_mobile_hp*temp;	speed = speed+t4_mobile_speed*temp;	load = load+t4_mobile_load*temp;	power = power+t4_mobile_power*temp;	damage = damage+t4_mobile_damage*temp;	defense = defense+t4_mobile_defense*temp;	hp = hp+t4_mobile_hp*temp;	speed = speed+t4_mobile_speed*temp;	cost = cost+t4_mobile_cost*temp;
        String temp35 =	String.valueOf(mobile_5.getText());	temp = Long.parseLong(temp35);	food = food+t5_mobile_food*temp;	fuel = fuel+t5_mobile_fuel*temp;	steel = steel+t5_mobile_steel*temp;	alloy = alloy+t5_mobile_alloy*temp;	time =  time+t5_mobile_time*temp;	damage = damage+ t5_mobile_damage*temp;	defense = defense+t5_mobile_defense*temp;	hp = hp+t5_mobile_hp*temp;	speed = speed+t5_mobile_speed*temp;	load = load+t5_mobile_load*temp;	power = power+t5_mobile_power*temp;	damage = damage+t5_mobile_damage*temp;	defense = defense+t5_mobile_defense*temp;	hp = hp+t5_mobile_hp*temp;	speed = speed+t5_mobile_speed*temp;	cost = cost+t5_mobile_cost*temp;
        String temp36 =	String.valueOf(mobile_6.getText());	temp = Long.parseLong(temp36);	food = food+t6_mobile_food*temp;	fuel = fuel+t6_mobile_fuel*temp;	steel = steel+t6_mobile_steel*temp;	alloy = alloy+t6_mobile_alloy*temp;	time =  time+t6_mobile_time*temp;	damage = damage+ t6_mobile_damage*temp;	defense = defense+t6_mobile_defense*temp;	hp = hp+t6_mobile_hp*temp;	speed = speed+t6_mobile_speed*temp;	load = load+t6_mobile_load*temp;	power = power+t6_mobile_power*temp;	damage = damage+t6_mobile_damage*temp;	defense = defense+t6_mobile_defense*temp;	hp = hp+t6_mobile_hp*temp;	speed = speed+t6_mobile_speed*temp;	cost = cost+t6_mobile_cost*temp;
        String temp37 =	String.valueOf(mobile_7.getText());	temp = Long.parseLong(temp37);	food = food+t7_mobile_food*temp;	fuel = fuel+t7_mobile_fuel*temp;	steel = steel+t7_mobile_steel*temp;	alloy = alloy+t7_mobile_alloy*temp;	time =  time+t7_mobile_time*temp;	damage = damage+ t7_mobile_damage*temp;	defense = defense+t7_mobile_defense*temp;	hp = hp+t7_mobile_hp*temp;	speed = speed+t7_mobile_speed*temp;	load = load+t7_mobile_load*temp;	power = power+t7_mobile_power*temp;	damage = damage+t7_mobile_damage*temp;	defense = defense+t7_mobile_defense*temp;	hp = hp+t7_mobile_hp*temp;	speed = speed+t7_mobile_speed*temp;	cost = cost+t7_mobile_cost*temp;
        String temp38 =	String.valueOf(mobile_8.getText());	temp = Long.parseLong(temp38);	food = food+t8_mobile_food*temp;	fuel = fuel+t8_mobile_fuel*temp;	steel = steel+t8_mobile_steel*temp;	alloy = alloy+t8_mobile_alloy*temp;	time =  time+t8_mobile_time*temp;	damage = damage+ t8_mobile_damage*temp;	defense = defense+t8_mobile_defense*temp;	hp = hp+t8_mobile_hp*temp;	speed = speed+t8_mobile_speed*temp;	load = load+t8_mobile_load*temp;	power = power+t8_mobile_power*temp;	damage = damage+t8_mobile_damage*temp;	defense = defense+t8_mobile_defense*temp;	hp = hp+t8_mobile_hp*temp;	speed = speed+t8_mobile_speed*temp;	cost = cost+t8_mobile_cost*temp;
        String temp39 =	String.valueOf(mobile_9.getText());	temp = Long.parseLong(temp39);	food = food+t9_mobile_food*temp;	fuel = fuel+t9_mobile_fuel*temp;	steel = steel+t9_mobile_steel*temp;	alloy = alloy+t9_mobile_alloy*temp;	time =  time+t9_mobile_time*temp;	damage = damage+ t9_mobile_damage*temp;	defense = defense+t9_mobile_defense*temp;	hp = hp+t9_mobile_hp*temp;	speed = speed+t9_mobile_speed*temp;	load = load+t9_mobile_load*temp;	power = power+t9_mobile_power*temp;	damage = damage+t9_mobile_damage*temp;	defense = defense+t9_mobile_defense*temp;	hp = hp+t9_mobile_hp*temp;	speed = speed+t9_mobile_speed*temp;	cost = cost+t9_mobile_cost*temp;
        String temp40 =	String.valueOf(mobile_10.getText());	temp = Long.parseLong(temp40);	food = food+t10_mobile_food*temp;	fuel = fuel+t10_mobile_fuel*temp;	steel = steel+t10_mobile_steel*temp;	alloy = alloy+t10_mobile_alloy*temp;	time =  time+t10_mobile_time*temp;	damage = damage+ t10_mobile_damage*temp;	defense = defense+t10_mobile_defense*temp;	hp = hp+t10_mobile_hp*temp;	speed = speed+t10_mobile_speed*temp;	load = load+t10_mobile_load*temp;	power = power+t10_mobile_power*temp;	damage = damage+t10_mobile_damage*temp;	defense = defense+t10_mobile_defense*temp;	hp = hp+t10_mobile_hp*temp;	speed = speed+t10_mobile_speed*temp;	cost = cost+t10_mobile_cost*temp;
        String temp41 =	String.valueOf(infect_1.getText());	temp = Long.parseLong(temp41);	food = food+t1_infect_food*temp;	fuel = fuel+t1_infect_fuel*temp;	steel = steel+t1_infect_steel*temp;	alloy = alloy+t1_infect_alloy*temp;	time =  time+t1_infect_time*temp;	damage = damage+ t1_infect_damage*temp;	defense = defense+t1_infect_defense*temp;	hp = hp+t1_infect_hp*temp;	speed = speed+t1_infect_speed*temp;	load = load+t1_infect_load*temp;	power = power+t1_infect_power*temp;	damage = damage+t1_infect_damage*temp;	defense = defense+t1_infect_defense*temp;	hp = hp+t1_infect_hp*temp;	speed = speed+t1_infect_speed*temp;	cost = cost+t1_infect_cost*temp;
        String temp42 =	String.valueOf(infect_2.getText());	temp = Long.parseLong(temp42);	food = food+t2_infect_food*temp;	fuel = fuel+t2_infect_fuel*temp;	steel = steel+t2_infect_steel*temp;	alloy = alloy+t2_infect_alloy*temp;	time =  time+t2_infect_time*temp;	damage = damage+ t2_infect_damage*temp;	defense = defense+t2_infect_defense*temp;	hp = hp+t2_infect_hp*temp;	speed = speed+t2_infect_speed*temp;	load = load+t2_infect_load*temp;	power = power+t2_infect_power*temp;	damage = damage+t2_infect_damage*temp;	defense = defense+t2_infect_defense*temp;	hp = hp+t2_infect_hp*temp;	speed = speed+t2_infect_speed*temp;	cost = cost+t2_infect_cost*temp;
        String temp43 =	String.valueOf(infect_3.getText());	temp = Long.parseLong(temp43);	food = food+t3_infect_food*temp;	fuel = fuel+t3_infect_fuel*temp;	steel = steel+t3_infect_steel*temp;	alloy = alloy+t3_infect_alloy*temp;	time =  time+t3_infect_time*temp;	damage = damage+ t3_infect_damage*temp;	defense = defense+t3_infect_defense*temp;	hp = hp+t3_infect_hp*temp;	speed = speed+t3_infect_speed*temp;	load = load+t3_infect_load*temp;	power = power+t3_infect_power*temp;	damage = damage+t3_infect_damage*temp;	defense = defense+t3_infect_defense*temp;	hp = hp+t3_infect_hp*temp;	speed = speed+t3_infect_speed*temp;	cost = cost+t3_infect_cost*temp;
        String temp44 =	String.valueOf(infect_4.getText());	temp = Long.parseLong(temp44);	food = food+t4_infect_food*temp;	fuel = fuel+t4_infect_fuel*temp;	steel = steel+t4_infect_steel*temp;	alloy = alloy+t4_infect_alloy*temp;	time =  time+t4_infect_time*temp;	damage = damage+ t4_infect_damage*temp;	defense = defense+t4_infect_defense*temp;	hp = hp+t4_infect_hp*temp;	speed = speed+t4_infect_speed*temp;	load = load+t4_infect_load*temp;	power = power+t4_infect_power*temp;	damage = damage+t4_infect_damage*temp;	defense = defense+t4_infect_defense*temp;	hp = hp+t4_infect_hp*temp;	speed = speed+t4_infect_speed*temp;	cost = cost+t4_infect_cost*temp;
        String temp45 =	String.valueOf(infect_5.getText());	temp = Long.parseLong(temp45);	food = food+t5_infect_food*temp;	fuel = fuel+t5_infect_fuel*temp;	steel = steel+t5_infect_steel*temp;	alloy = alloy+t5_infect_alloy*temp;	time =  time+t5_infect_time*temp;	damage = damage+ t5_infect_damage*temp;	defense = defense+t5_infect_defense*temp;	hp = hp+t5_infect_hp*temp;	speed = speed+t5_infect_speed*temp;	load = load+t5_infect_load*temp;	power = power+t5_infect_power*temp;	damage = damage+t5_infect_damage*temp;	defense = defense+t5_infect_defense*temp;	hp = hp+t5_infect_hp*temp;	speed = speed+t5_infect_speed*temp;	cost = cost+t5_infect_cost*temp;
        String temp46 =	String.valueOf(infect_6.getText());	temp = Long.parseLong(temp46);	food = food+t6_infect_food*temp;	fuel = fuel+t6_infect_fuel*temp;	steel = steel+t6_infect_steel*temp;	alloy = alloy+t6_infect_alloy*temp;	time =  time+t6_infect_time*temp;	damage = damage+ t6_infect_damage*temp;	defense = defense+t6_infect_defense*temp;	hp = hp+t6_infect_hp*temp;	speed = speed+t6_infect_speed*temp;	load = load+t6_infect_load*temp;	power = power+t6_infect_power*temp;	damage = damage+t6_infect_damage*temp;	defense = defense+t6_infect_defense*temp;	hp = hp+t6_infect_hp*temp;	speed = speed+t6_infect_speed*temp;	cost = cost+t6_infect_cost*temp;
        String temp47 =	String.valueOf(infect_7.getText());	temp = Long.parseLong(temp47);	food = food+t7_infect_food*temp;	fuel = fuel+t7_infect_fuel*temp;	steel = steel+t7_infect_steel*temp;	alloy = alloy+t7_infect_alloy*temp;	time =  time+t7_infect_time*temp;	damage = damage+ t7_infect_damage*temp;	defense = defense+t7_infect_defense*temp;	hp = hp+t7_infect_hp*temp;	speed = speed+t7_infect_speed*temp;	load = load+t7_infect_load*temp;	power = power+t7_infect_power*temp;	damage = damage+t7_infect_damage*temp;	defense = defense+t7_infect_defense*temp;	hp = hp+t7_infect_hp*temp;	speed = speed+t7_infect_speed*temp;	cost = cost+t7_infect_cost*temp;
        String temp48 =	String.valueOf(infect_8.getText());	temp = Long.parseLong(temp48);	food = food+t8_infect_food*temp;	fuel = fuel+t8_infect_fuel*temp;	steel = steel+t8_infect_steel*temp;	alloy = alloy+t8_infect_alloy*temp;	time =  time+t8_infect_time*temp;	damage = damage+ t8_infect_damage*temp;	defense = defense+t8_infect_defense*temp;	hp = hp+t8_infect_hp*temp;	speed = speed+t8_infect_speed*temp;	load = load+t8_infect_load*temp;	power = power+t8_infect_power*temp;	damage = damage+t8_infect_damage*temp;	defense = defense+t8_infect_defense*temp;	hp = hp+t8_infect_hp*temp;	speed = speed+t8_infect_speed*temp;	cost = cost+t8_infect_cost*temp;
        String temp49 =	String.valueOf(infect_9.getText());	temp = Long.parseLong(temp49);	food = food+t9_infect_food*temp;	fuel = fuel+t9_infect_fuel*temp;	steel = steel+t9_infect_steel*temp;	alloy = alloy+t9_infect_alloy*temp;	time =  time+t9_infect_time*temp;	damage = damage+ t9_infect_damage*temp;	defense = defense+t9_infect_defense*temp;	hp = hp+t9_infect_hp*temp;	speed = speed+t9_infect_speed*temp;	load = load+t9_infect_load*temp;	power = power+t9_infect_power*temp;	damage = damage+t9_infect_damage*temp;	defense = defense+t9_infect_defense*temp;	hp = hp+t9_infect_hp*temp;	speed = speed+t9_infect_speed*temp;	cost = cost+t9_infect_cost*temp;
        String temp50 =	String.valueOf(infect_10.getText());	temp = Long.parseLong(temp50);	food = food+t10_infect_food*temp;	fuel = fuel+t10_infect_fuel*temp;	steel = steel+t10_infect_steel*temp;	alloy = alloy+t10_infect_alloy*temp;	time =  time+t10_infect_time*temp;	damage = damage+ t10_infect_damage*temp;	defense = defense+t10_infect_defense*temp;	hp = hp+t10_infect_hp*temp;	speed = speed+t10_infect_speed*temp;	load = load+t10_infect_load*temp;	power = power+t10_infect_power*temp;	damage = damage+t10_infect_damage*temp;	defense = defense+t10_infect_defense*temp;	hp = hp+t10_infect_hp*temp;	speed = speed+t10_infect_speed*temp;	cost = cost+t10_infect_cost*temp;

        total = Long.parseLong(temp1)+	Long.parseLong(temp2)+	Long.parseLong(temp3)+	Long.parseLong(temp4)+	Long.parseLong(temp5)+	Long.parseLong(temp6)+	Long.parseLong(temp7)+	Long.parseLong(temp8)+	Long.parseLong(temp9)+	Long.parseLong(temp10)+	Long.parseLong(temp11)+	Long.parseLong(temp12)+	Long.parseLong(temp13)+	Long.parseLong(temp14)+	Long.parseLong(temp15)+	Long.parseLong(temp16)+	Long.parseLong(temp17)+	Long.parseLong(temp18)+	Long.parseLong(temp19)+	Long.parseLong(temp20)+	Long.parseLong(temp21)+	Long.parseLong(temp22)+	Long.parseLong(temp23)+	Long.parseLong(temp24)+	Long.parseLong(temp25)+	Long.parseLong(temp26)+	Long.parseLong(temp27)+	Long.parseLong(temp28)+	Long.parseLong(temp29)+	Long.parseLong(temp30)+	Long.parseLong(temp31)+	Long.parseLong(temp32)+	Long.parseLong(temp33)+	Long.parseLong(temp34)+	Long.parseLong(temp35)+	Long.parseLong(temp36)+	Long.parseLong(temp37)+	Long.parseLong(temp38)+	Long.parseLong(temp39)+	Long.parseLong(temp40)+	Long.parseLong(temp41)+	Long.parseLong(temp42)+	Long.parseLong(temp43)+	Long.parseLong(temp44)+	Long.parseLong(temp45)+	Long.parseLong(temp46)+	Long.parseLong(temp47)+	Long.parseLong(temp48)+	Long.parseLong(temp49)+	Long.parseLong(temp50);
        /**
         *
         * Method INT TO TXT (DONE)
         */

        String Fuel_String = null, Food_String= null , Steel_String = null, Alloy_String= null , Time_String = null, Kyanite_String = null, Kyanite_basic_String = null, Kyanite_cluster_String = null, Cost_String = null, Power_String = null, Load_String = null, Total_String = null;
        String beta = String.valueOf(buff02.getText());
        String chalie = String.valueOf(buff03.getText());

        long time2 = (d * 86400) + (h * 3600) + m * 60 + s;

        DecimalFormat df = new DecimalFormat("#.#####");
        long final_buff = time2*1000000000/(count_l*count_t);

        Log.i("count_l", String.valueOf(count_l));
        Log.i("count_t", String.valueOf(count_t));
        Log.i("time2", String.valueOf(time2));
        Log.i("FINAL_BUFF", String.valueOf(final_buff));

        /*String alpha = String.valueOf(buff01.getText());
        if (!alpha.equals("")){
            int time_b = Integer.parseInt(alpha);
            time = time/(100-time_b)*100;
            Log.i("DATA_FINAL TIMEB", String.valueOf(time_b)); }
         */
        if (!beta.equals("")){
            int load_b = Integer.parseInt(beta)+100;
            load = load*load_b/100;
        }else {buff02.setText("0");}

        if (!chalie.equals("")){
            int rss_b = Integer.parseInt(chalie);
            if (rss_b > 99){buff03.setText("99");chalie = String.valueOf(buff03.getText());rss_b = Integer.parseInt(chalie);}
            fuel = fuel/100;
            food = food/100;
            steel = steel/100;
            alloy = alloy/100;
            kyanite = kyanite/100;
            kyanite_basic = kyanite_basic/100;
            kyanite_cluster = kyanite_cluster/100;
            fuel = fuel*(100-rss_b);
            food = food*(100-rss_b);
            steel = steel*(100-rss_b);
            alloy = alloy*(100-rss_b);
            kyanite = kyanite*(100-rss_b);
            kyanite_basic = kyanite_basic*(100-rss_b);
            kyanite_cluster = kyanite_cluster*(100-rss_b);

        }else {buff03.setText("0");}
        DecimalFormat formatter1 = new DecimalFormat("###,###,###,###,###,###");
        Fuel_String = formatter1.format(fuel);


        DecimalFormat formatter2 = new DecimalFormat("###,###,###,###,###,###");
        Food_String = formatter2.format(food);

        DecimalFormat formatter3 = new DecimalFormat("###,###,###,###,###,###");
        Steel_String = formatter3.format(steel);

        DecimalFormat formatter4 = new DecimalFormat("###,###,###,###,###,###");
        Alloy_String = formatter4.format(alloy);

        DecimalFormat formatter5 = new DecimalFormat("###,###,###,###,###,###");
        Kyanite_String = formatter5.format(kyanite);

        DecimalFormat formatter6 = new DecimalFormat("###,###,###,###,###,###");
        Kyanite_basic_String = formatter6.format(kyanite_basic);

        DecimalFormat formatter7 = new DecimalFormat("###,###,###,###,###,###");
        Kyanite_cluster_String = formatter7.format(kyanite_cluster);

        DecimalFormat formatter8 = new DecimalFormat("###,###,###,###,###,###");
        int power2 = (int) power;
        Power_String = formatter8.format(power2);

        DecimalFormat formatter9 = new DecimalFormat("###,###,###,###,###,###");
        Cost_String = formatter9.format(cost);

        DecimalFormat formatterA = new DecimalFormat("###,###,###,###,###,###");
        Load_String = formatterA.format(load);

        DecimalFormat formatterB = new DecimalFormat("###,###,###,###,###,###");
        Total_String = formatterB.format(total);

        long time3 = (long) (time*final_buff)/1000000000;
        if (time3>0 ){time3 = time3+1;}
        Log.i("time3", String.valueOf(time3));
        time = time3;
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
        power_tv.setText(prettyCount(power));
        load_tv.setText(prettyCount(load));
        cost_tv.setText(prettyCount(cost) + " /h");
        total_tv.setText(getString(R.string.troop_total)+" "+prettyCount(total));

        if (time_tv.getText() == ""){time_tv.setText("00:00:00");}


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
    public void troop_choose (View view){
            final Dialog dialog = new Dialog(this, R.style.NormalDialogStyle_N);
            view = View.inflate(this, R.layout.troop_choose, null);

        ImageView	arm01	 = view.findViewById(R.id.	h_arm01)	;
        ImageView	arm02	 = view.findViewById(R.id.	h_arm02)	;
        ImageView	arm03	 = view.findViewById(R.id.	h_arm03)	;
        ImageView	arm04	 = view.findViewById(R.id.	h_arm04)	;
        ImageView	arm05	 = view.findViewById(R.id.	h_arm05)	;
        ImageView	arm06	 = view.findViewById(R.id.	h_arm06)	;
        ImageView	arm07	 = view.findViewById(R.id.	h_arm07)	;
        ImageView	arm08	 = view.findViewById(R.id.	h_arm08)	;
        ImageView	arm09	 = view.findViewById(R.id.	h_arm09)	;
        ImageView	arm10	 = view.findViewById(R.id.	h_arm10)	;
        ImageView	mili01	 = view.findViewById(R.id.	h_mili01)	;
        ImageView	mili02	 = view.findViewById(R.id.	h_mili02)	;
        ImageView	mili03	 = view.findViewById(R.id.	h_mili03)	;
        ImageView	mili04	 = view.findViewById(R.id.	h_mili04)	;
        ImageView	mili05	 = view.findViewById(R.id.	h_mili05)	;
        ImageView	mili06	 = view.findViewById(R.id.	h_mili06)	;
        ImageView	mili07	 = view.findViewById(R.id.	h_mili07)	;
        ImageView	mili08	 = view.findViewById(R.id.	h_mili08)	;
        ImageView	mili09	 = view.findViewById(R.id.	h_mili09)	;
        ImageView	mili10	 = view.findViewById(R.id.	h_mili10)	;
        ImageView	mobile01	 = view.findViewById(R.id.	h_mobile01)	;
        ImageView	mobile02	 = view.findViewById(R.id.	h_mobile02)	;
        ImageView	mobile03	 = view.findViewById(R.id.	h_mobile03)	;
        ImageView	mobile04	 = view.findViewById(R.id.	h_mobile04)	;
        ImageView	mobile05	 = view.findViewById(R.id.	h_mobile05)	;
        ImageView	mobile06	 = view.findViewById(R.id.	h_mobile06)	;
        ImageView	mobile07	 = view.findViewById(R.id.	h_mobile07)	;
        ImageView	mobile08	 = view.findViewById(R.id.	h_mobile08)	;
        ImageView	mobile09	 = view.findViewById(R.id.	h_mobile09)	;
        ImageView	mobile10	 = view.findViewById(R.id.	h_mobile10)	;
        ImageView	infect01	 = view.findViewById(R.id.	h_infect01)	;
        ImageView	infect02	 = view.findViewById(R.id.	h_infect02)	;
        ImageView	infect03	 = view.findViewById(R.id.	h_infect03)	;
        ImageView	infect04	 = view.findViewById(R.id.	h_infect04)	;
        ImageView	infect05	 = view.findViewById(R.id.	h_infect05)	;
        ImageView	infect06	 = view.findViewById(R.id.	h_infect06)	;
        ImageView	infect07	 = view.findViewById(R.id.	h_infect07)	;
        ImageView	infect08	 = view.findViewById(R.id.	h_infect08)	;
        ImageView	infect09	 = view.findViewById(R.id.	h_infect09)	;
        ImageView	infect10	 = view.findViewById(R.id.	h_infect10)	;
        ImageView	project01	 = view.findViewById(R.id.	h_project01)	;
        ImageView	project02	 = view.findViewById(R.id.	h_project02)	;
        ImageView	project03	 = view.findViewById(R.id.	h_project03)	;
        ImageView	project04	 = view.findViewById(R.id.	h_project04)	;
        ImageView	project05	 = view.findViewById(R.id.	h_project05)	;
        ImageView	project06	 = view.findViewById(R.id.	h_project06)	;
        ImageView	project07	 = view.findViewById(R.id.	h_project07)	;
        ImageView	project08	 = view.findViewById(R.id.	h_project08)	;
        ImageView	project09	 = view.findViewById(R.id.	h_project09)	;
        ImageView	project10	 = view.findViewById(R.id.	h_project10)	;
        ImageView troop_choose = findViewById(R.id.troop_choose);
        dialog.setContentView(view);
            dialog.setCanceledOnTouchOutside(true);
            //view.setMinimumHeight((int) (ScreenSizeUtils.getInstance(this).getScreenHeight()));
            Window dialogWindow = dialog.getWindow();
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width = (int) (ScreenSizeUtils.getInstance(this).getScreenWidth()*0.8);
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            lp.gravity = Gravity.CENTER;
            dialogWindow.setAttributes(lp);
            dialog.show();

        arm01	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t1_arm_time;	troop_choose.setImageResource(R.drawable.	h_arm01	);	troop_id = 1;	}});
        arm02	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t2_arm_time;	troop_choose.setImageResource(R.drawable.	h_arm02	);	troop_id = 2;	}});
        arm03	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t3_arm_time;	troop_choose.setImageResource(R.drawable.	h_arm03	);	troop_id = 3;	}});
        arm04	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t4_arm_time;	troop_choose.setImageResource(R.drawable.	h_arm04	);	troop_id = 4;	}});
        arm05	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t5_arm_time;	troop_choose.setImageResource(R.drawable.	h_arm05	);	troop_id = 5;	}});
        arm06	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t6_arm_time;	troop_choose.setImageResource(R.drawable.	h_arm06	);	troop_id = 6;	}});
        arm07	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t7_arm_time;	troop_choose.setImageResource(R.drawable.	h_arm07	);	troop_id = 7;	}});
        arm08	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t8_arm_time;	troop_choose.setImageResource(R.drawable.	h_arm08	);	troop_id = 8;	}});
        arm09	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t9_arm_time;	troop_choose.setImageResource(R.drawable.	h_arm09	);	troop_id = 9;	}});
        arm10	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t10_arm_time;	troop_choose.setImageResource(R.drawable.	h_arm10	);	troop_id = 10;	}});
        mili01	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t1_mili_time;	troop_choose.setImageResource(R.drawable.	h_mili01	);	troop_id = 11;	}});
        mili02	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t2_mili_time;	troop_choose.setImageResource(R.drawable.	h_mili02	);	troop_id = 12;	}});
        mili03	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t3_mili_time;	troop_choose.setImageResource(R.drawable.	h_mili03	);	troop_id = 13;	}});
        mili04	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t4_mili_time;	troop_choose.setImageResource(R.drawable.	h_mili04	);	troop_id = 14;	}});
        mili05	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t5_mili_time;	troop_choose.setImageResource(R.drawable.	h_mili05	);	troop_id = 15;	}});
        mili06	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t6_mili_time;	troop_choose.setImageResource(R.drawable.	h_mili06	);	troop_id = 16;	}});
        mili07	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t7_mili_time;	troop_choose.setImageResource(R.drawable.	h_mili07	);	troop_id = 17;	}});
        mili08	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t8_mili_time;	troop_choose.setImageResource(R.drawable.	h_mili08	);	troop_id = 18;	}});
        mili09	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t9_mili_time;	troop_choose.setImageResource(R.drawable.	h_mili09	);	troop_id = 19;	}});
        mili10	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t10_mili_time;	troop_choose.setImageResource(R.drawable.	h_mili10	);	troop_id = 20;	}});
        mobile01	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t1_mobile_time;	troop_choose.setImageResource(R.drawable.	h_mobile01	);	troop_id = 21;	}});
        mobile02	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t2_mobile_time;	troop_choose.setImageResource(R.drawable.	h_mobile02	);	troop_id = 22;	}});
        mobile03	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t3_mobile_time;	troop_choose.setImageResource(R.drawable.	h_mobile03	);	troop_id = 23;	}});
        mobile04	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t4_mobile_time;	troop_choose.setImageResource(R.drawable.	h_mobile04	);	troop_id = 24;	}});
        mobile05	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t5_mobile_time;	troop_choose.setImageResource(R.drawable.	h_mobile05	);	troop_id = 25;	}});
        mobile06	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t6_mobile_time;	troop_choose.setImageResource(R.drawable.	h_mobile06	);	troop_id = 26;	}});
        mobile07	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t7_mobile_time;	troop_choose.setImageResource(R.drawable.	h_mobile07	);	troop_id = 27;	}});
        mobile08	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t8_mobile_time;	troop_choose.setImageResource(R.drawable.	h_mobile08	);	troop_id = 28;	}});
        mobile09	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t9_mobile_time;	troop_choose.setImageResource(R.drawable.	h_mobile09	);	troop_id = 29;	}});
        mobile10	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t10_mobile_time;	troop_choose.setImageResource(R.drawable.	h_mobile10	);	troop_id = 30;	}});
        infect01	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t1_infect_time;	troop_choose.setImageResource(R.drawable.	h_infect01	);	troop_id = 31;	}});
        infect02	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t2_infect_time;	troop_choose.setImageResource(R.drawable.	h_infect02	);	troop_id = 32;	}});
        infect03	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t3_infect_time;	troop_choose.setImageResource(R.drawable.	h_infect03	);	troop_id = 33;	}});
        infect04	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t4_infect_time;	troop_choose.setImageResource(R.drawable.	h_infect04	);	troop_id = 34;	}});
        infect05	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t5_infect_time;	troop_choose.setImageResource(R.drawable.	h_infect05	);	troop_id = 35;	}});
        infect06	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t6_infect_time;	troop_choose.setImageResource(R.drawable.	h_infect06	);	troop_id = 36;	}});
        infect07	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t7_infect_time;	troop_choose.setImageResource(R.drawable.	h_infect07	);	troop_id = 37;	}});
        infect08	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t8_infect_time;	troop_choose.setImageResource(R.drawable.	h_infect08	);	troop_id = 38;	}});
        infect09	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t9_infect_time;	troop_choose.setImageResource(R.drawable.	h_infect09	);	troop_id = 39;	}});
        infect10	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t10_infect_time;	troop_choose.setImageResource(R.drawable.	h_infect10	);	troop_id = 40;	}});
        project01	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t1_proj_time;	troop_choose.setImageResource(R.drawable.	h_project01	);	troop_id = 41;	}});
        project02	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t2_proj_time;	troop_choose.setImageResource(R.drawable.	h_project02	);	troop_id = 42;	}});
        project03	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t3_proj_time;	troop_choose.setImageResource(R.drawable.	h_project03	);	troop_id = 43;	}});
        project04	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t4_proj_time;	troop_choose.setImageResource(R.drawable.	h_project04	);	troop_id = 44;	}});
        project05	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t5_proj_time;	troop_choose.setImageResource(R.drawable.	h_project05	);	troop_id = 45;	}});
        project06	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t6_proj_time;	troop_choose.setImageResource(R.drawable.	h_project06	);	troop_id = 46;	}});
        project07	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t7_proj_time;	troop_choose.setImageResource(R.drawable.	h_project07	);	troop_id = 47;	}});
        project08	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t8_proj_time;	troop_choose.setImageResource(R.drawable.	h_project08	);	troop_id = 48;	}});
        project09	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t9_proj_time;	troop_choose.setImageResource(R.drawable.	h_project09	);	troop_id = 49;	}});
        project10	.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {dialog.dismiss();	count_l	 = t10_proj_time;	troop_choose.setImageResource(R.drawable.	h_project10	);	troop_id = 50;	}});


    }
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //添加数据
        editor.putLong("buff01", Long.parseLong(String.valueOf(buff01.getText())));
        editor.putLong("buff02", Long.parseLong(String.valueOf(buff02.getText())));
        editor.putLong("buff03", Long.parseLong(String.valueOf(buff03.getText())));
        editor.putLong("D", Long.parseLong(String.valueOf(day.getText())));
        editor.putLong("H", Long.parseLong(String.valueOf(hour.getText())));
        editor.putLong("M", Long.parseLong(String.valueOf(min.getText())));
        editor.putLong("S", Long.parseLong(String.valueOf(sec.getText())));
        editor.putLong("count_l", count_l);
        editor.putLong("count_t", count_t);
        editor.putInt("troop_id_act", troop_id);
        editor.apply();
        preferencesRefresh();

    }
    public void preferencesRefresh() {

        if(proj_1.getText().toString().matches(""))	{proj_1.setText(	"0");}
        if(proj_2.getText().toString().matches(""))	{proj_2.setText(	"0");}
        if(proj_3.getText().toString().matches(""))	{proj_3.setText(	"0");}
        if(proj_4.getText().toString().matches(""))	{proj_4.setText(	"0");}
        if(proj_5.getText().toString().matches(""))	{proj_5.setText(	"0");}
        if(proj_6.getText().toString().matches(""))	{proj_6.setText(	"0");}
        if(proj_7.getText().toString().matches(""))	{proj_7.setText(	"0");}
        if(proj_8.getText().toString().matches(""))	{proj_8.setText(	"0");}
        if(proj_9.getText().toString().matches(""))	{proj_9.setText(	"0");}
        if(proj_10.getText().toString().matches(""))	{proj_10.setText(	"0");}

        if(arm_1.getText().toString().matches(""))	{arm_1.setText(	"0");}
        if(arm_2.getText().toString().matches(""))	{arm_2.setText(	"0");}
        if(arm_3.getText().toString().matches(""))	{arm_3.setText(	"0");}
        if(arm_4.getText().toString().matches(""))	{arm_4.setText(	"0");}
        if(arm_5.getText().toString().matches(""))	{arm_5.setText(	"0");}
        if(arm_6.getText().toString().matches(""))	{arm_6.setText(	"0");}
        if(arm_7.getText().toString().matches(""))	{arm_7.setText(	"0");}
        if(arm_8.getText().toString().matches(""))	{arm_8.setText(	"0");}
        if(arm_9.getText().toString().matches(""))	{arm_9.setText(	"0");}
        if(arm_10.getText().toString().matches(""))	{arm_10.setText(	"0");}

        if(mili_1.getText().toString().matches(""))	{mili_1.setText(	"0");}
        if(mili_2.getText().toString().matches(""))	{mili_2.setText(	"0");}
        if(mili_3.getText().toString().matches(""))	{mili_3.setText(	"0");}
        if(mili_4.getText().toString().matches(""))	{mili_4.setText(	"0");}
        if(mili_5.getText().toString().matches(""))	{mili_5.setText(	"0");}
        if(mili_6.getText().toString().matches(""))	{mili_6.setText(	"0");}
        if(mili_7.getText().toString().matches(""))	{mili_7.setText(	"0");}
        if(mili_8.getText().toString().matches(""))	{mili_8.setText(	"0");}
        if(mili_9.getText().toString().matches(""))	{mili_9.setText(	"0");}
        if(mili_10.getText().toString().matches(""))	{mili_10.setText(	"0");}

        if(mobile_1.getText().toString().matches(""))	{mobile_1.setText(	"0");}
        if(mobile_2.getText().toString().matches(""))	{mobile_2.setText(	"0");}
        if(mobile_3.getText().toString().matches(""))	{mobile_3.setText(	"0");}
        if(mobile_4.getText().toString().matches(""))	{mobile_4.setText(	"0");}
        if(mobile_5.getText().toString().matches(""))	{mobile_5.setText(	"0");}
        if(mobile_6.getText().toString().matches(""))	{mobile_6.setText(	"0");}
        if(mobile_7.getText().toString().matches(""))	{mobile_7.setText(	"0");}
        if(mobile_8.getText().toString().matches(""))	{mobile_8.setText(	"0");}
        if(mobile_9.getText().toString().matches(""))	{mobile_9.setText(	"0");}
        if(mobile_10.getText().toString().matches(""))	{mobile_10.setText(	"0");}

        if(infect_1.getText().toString().matches(""))	{infect_1.setText(	"0");}
        if(infect_2.getText().toString().matches(""))	{infect_2.setText(	"0");}
        if(infect_3.getText().toString().matches(""))	{infect_3.setText(	"0");}
        if(infect_4.getText().toString().matches(""))	{infect_4.setText(	"0");}
        if(infect_5.getText().toString().matches(""))	{infect_5.setText(	"0");}
        if(infect_6.getText().toString().matches(""))	{infect_6.setText(	"0");}
        if(infect_7.getText().toString().matches(""))	{infect_7.setText(	"0");}
        if(infect_8.getText().toString().matches(""))	{infect_8.setText(	"0");}
        if(infect_9.getText().toString().matches(""))	{infect_9.setText(	"0");}
        if(infect_10.getText().toString().matches(""))	{infect_10.setText(	"0");}

        SharedPreferences sharedPreferences = getSharedPreferences("json_data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        /** Storage data grab from Zgirls Server */
        editor.putLong("army01TotalNum",    Long.parseLong(String.valueOf(	mili_1	.getText())));
        editor.putLong("army02TotalNum",    Long.parseLong(String.valueOf(	mili_2	.getText())));
        editor.putLong("army03TotalNum",    Long.parseLong(String.valueOf(	mili_3	.getText())));
        editor.putLong("army04TotalNum",    Long.parseLong(String.valueOf(	mili_4	.getText())));
        editor.putLong("army05TotalNum",    Long.parseLong(String.valueOf(	mili_5	.getText())));
        editor.putLong("army06TotalNum",    Long.parseLong(String.valueOf(	mili_6	.getText())));
        editor.putLong("army07TotalNum",    Long.parseLong(String.valueOf(	mili_7	.getText())));
        editor.putLong("army08TotalNum",    Long.parseLong(String.valueOf(	mili_8	.getText())));
        editor.putLong("army09TotalNum",    Long.parseLong(String.valueOf(	mili_9	.getText())));
        editor.putLong("army10TotalNum",    Long.parseLong(String.valueOf(	mili_10	.getText())));
        editor.putLong("army11TotalNum",    Long.parseLong(String.valueOf(	mobile_1	.getText())));
        editor.putLong("army12TotalNum",    Long.parseLong(String.valueOf(	mobile_2	.getText())));
        editor.putLong("army13TotalNum",    Long.parseLong(String.valueOf(	mobile_3	.getText())));
        editor.putLong("army14TotalNum",    Long.parseLong(String.valueOf(	mobile_4	.getText())));
        editor.putLong("army15TotalNum",    Long.parseLong(String.valueOf(	mobile_5	.getText())));
        editor.putLong("army16TotalNum",    Long.parseLong(String.valueOf(	mobile_6	.getText())));
        editor.putLong("army17TotalNum",    Long.parseLong(String.valueOf(	mobile_7	.getText())));
        editor.putLong("army18TotalNum",    Long.parseLong(String.valueOf(	mobile_8	.getText())));
        editor.putLong("army19TotalNum",    Long.parseLong(String.valueOf(	mobile_9	.getText())));
        editor.putLong("army20TotalNum",    Long.parseLong(String.valueOf(	mobile_10	.getText())));
        editor.putLong("army21TotalNum",    Long.parseLong(String.valueOf(	arm_1	.getText())));
        editor.putLong("army22TotalNum",    Long.parseLong(String.valueOf(	arm_2	.getText())));
        editor.putLong("army23TotalNum",    Long.parseLong(String.valueOf(	arm_3	.getText())));
        editor.putLong("army24TotalNum",    Long.parseLong(String.valueOf(	arm_4	.getText())));
        editor.putLong("army25TotalNum",    Long.parseLong(String.valueOf(	arm_5	.getText())));
        editor.putLong("army26TotalNum",    Long.parseLong(String.valueOf(	arm_6	.getText())));
        editor.putLong("army27TotalNum",    Long.parseLong(String.valueOf(	arm_7	.getText())));
        editor.putLong("army28TotalNum",    Long.parseLong(String.valueOf(	arm_8	.getText())));
        editor.putLong("army29TotalNum",    Long.parseLong(String.valueOf(	arm_9	.getText())));
        editor.putLong("army30TotalNum",    Long.parseLong(String.valueOf(	arm_10	.getText())));
        editor.putLong("army31TotalNum",    Long.parseLong(String.valueOf(	infect_1	.getText())));
        editor.putLong("army32TotalNum",    Long.parseLong(String.valueOf(	infect_2	.getText())));
        editor.putLong("army33TotalNum",    Long.parseLong(String.valueOf(	infect_3	.getText())));
        editor.putLong("army34TotalNum",    Long.parseLong(String.valueOf(	infect_4	.getText())));
        editor.putLong("army35TotalNum",    Long.parseLong(String.valueOf(	infect_5	.getText())));
        editor.putLong("army36TotalNum",    Long.parseLong(String.valueOf(	infect_6	.getText())));
        editor.putLong("army37TotalNum",    Long.parseLong(String.valueOf(	infect_7	.getText())));
        editor.putLong("army38TotalNum",    Long.parseLong(String.valueOf(	infect_8	.getText())));
        editor.putLong("army39TotalNum",    Long.parseLong(String.valueOf(	infect_9	.getText())));
        editor.putLong("army40TotalNum",    Long.parseLong(String.valueOf(	infect_10	.getText())));
        editor.putLong("army41TotalNum",    Long.parseLong(String.valueOf(	proj_1	.getText())));
        editor.putLong("army42TotalNum",    Long.parseLong(String.valueOf(	proj_2	.getText())));
        editor.putLong("army43TotalNum",    Long.parseLong(String.valueOf(	proj_3	.getText())));
        editor.putLong("army44TotalNum",    Long.parseLong(String.valueOf(	proj_4	.getText())));
        editor.putLong("army45TotalNum",    Long.parseLong(String.valueOf(	proj_5	.getText())));
        editor.putLong("army46TotalNum",    Long.parseLong(String.valueOf(	proj_6	.getText())));
        editor.putLong("army47TotalNum",    Long.parseLong(String.valueOf(	proj_7	.getText())));
        editor.putLong("army48TotalNum",    Long.parseLong(String.valueOf(	proj_8	.getText())));
        editor.putLong("army49TotalNum",    Long.parseLong(String.valueOf(	proj_9	.getText())));
        editor.putLong("army50TotalNum",    Long.parseLong(String.valueOf(	proj_10	.getText())));
        editor.apply();
    }

    public void  clean (View view){
        mili_1	.setText( "0");
        mili_2	.setText( "0");
        mili_3	.setText( "0");
        mili_4	.setText( "0");
        mili_5	.setText( "0");
        mili_6	.setText( "0");
        mili_7	.setText( "0");
        mili_8	.setText( "0");
        mili_9	.setText( "0");
        mili_10	.setText( "0");
        mobile_1	.setText( "0");
        mobile_2	.setText( "0");
        mobile_3	.setText( "0");
        mobile_4	.setText( "0");
        mobile_5	.setText( "0");
        mobile_6	.setText( "0");
        mobile_7	.setText( "0");
        mobile_8	.setText( "0");
        mobile_9	.setText( "0");
        mobile_10	.setText( "0");
        arm_1	.setText( "0");
        arm_2	.setText( "0");
        arm_3	.setText( "0");
        arm_4	.setText( "0");
        arm_5	.setText( "0");
        arm_6	.setText( "0");
        arm_7	.setText( "0");
        arm_8	.setText( "0");
        arm_9	.setText( "0");
        arm_10	.setText( "0");
        infect_1	.setText( "0");
        infect_2	.setText( "0");
        infect_3	.setText( "0");
        infect_4	.setText( "0");
        infect_5	.setText( "0");
        infect_6	.setText( "0");
        infect_7	.setText( "0");
        infect_8	.setText( "0");
        infect_9	.setText( "0");
        infect_10	.setText( "0");
        proj_1	.setText( "0");
        proj_2	.setText( "0");
        proj_3	.setText( "0");
        proj_4	.setText( "0");
        proj_5	.setText( "0");
        proj_6	.setText( "0");
        proj_7	.setText( "0");
        proj_8	.setText( "0");
        proj_9	.setText( "0");
        proj_10	.setText( "0");
        troop_calcalate(view);
    }

}


