package voc.net.tools.zgirls_tool.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import voc.net.tools.zgirls_tool.R;

public class BuildingInfoActivity extends AppCompatActivity {

    EditText build_01,	build_02,	build_03,	build_04,	build_05,	build_06,	build_07,	build_08,	build_09,	build_10,	build_11,	build_12,	build_13,	build_14,	build_15,	build_16,	build_17,	build_18,	build_19,	build_20,	build_21,	build_22,	build_23,	build_24,	build_25,	build_26,	build_27,	build_28,	build_29;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_info);

        build_01= findViewById(R.id.building_et1);
        build_02= findViewById(R.id.building_et2);
        build_03= findViewById(R.id.building_et3);
        build_04= findViewById(R.id.building_et4);
        build_05= findViewById(R.id.building_et5);
        build_06= findViewById(R.id.building_et6);
        build_07= findViewById(R.id.building_et7);
        build_08= findViewById(R.id.building_et8);
        build_09= findViewById(R.id.building_et9);
        build_10= findViewById(R.id.building_et10);
        build_11= findViewById(R.id.building_et11);
        build_12= findViewById(R.id.building_et12);
        build_13= findViewById(R.id.building_et13);
        build_14= findViewById(R.id.building_et14);
        build_15= findViewById(R.id.building_et15);
        build_16= findViewById(R.id.building_et16);
        build_17= findViewById(R.id.building_et17);
        build_18= findViewById(R.id.building_et18);
        build_19= findViewById(R.id.building_et19);
        build_20= findViewById(R.id.building_et20);
        build_21= findViewById(R.id.building_et21);
        build_22= findViewById(R.id.building_et22);
        build_23= findViewById(R.id.building_et23);
        build_24= findViewById(R.id.building_et24);
        build_25= findViewById(R.id.building_et25);
        build_26= findViewById(R.id.building_et26);
        build_27= findViewById(R.id.building_et27);
        build_28= findViewById(R.id.building_et28);
        build_29= findViewById(R.id.building_et29);


        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);

        //取出数据（注意这里直接用实例取就行了，不用获取编辑器editor）

        String alloy_mine= sharedPreferences.getString ("alloy_mine","0");
        String armed_forces= sharedPreferences.getString ("armed_forces","0");
        String armory= sharedPreferences.getString ("armory","0");
        String cafeteria= sharedPreferences.getString ("cafeteria","0");
        String clinic= sharedPreferences.getString ("clinic","0");
        String clone_lab= sharedPreferences.getString ("clone_lab","0");
        String comm_building= sharedPreferences.getString ("comm_building","0");
        String dorm= sharedPreferences.getString ("dorm","0");
        String embassy= sharedPreferences.getString ("embassy","0");
        String farm= sharedPreferences.getString ("farm","0");
        String infection_institute= sharedPreferences.getString ("infection_institute","0");
        String laboratory= sharedPreferences.getString ("laboratory","0");
        String logistics_center= sharedPreferences.getString ("logistics_center","0");
        String military_office= sharedPreferences.getString ("military_office","0");
        String mobile_team_factory= sharedPreferences.getString ("mobile_team_factory","0");
        String obsidian_refine_building= sharedPreferences.getString ("obsidian_refine_building","0");
        String oil_well= sharedPreferences.getString ("oil_well","0");
        String prison= sharedPreferences.getString ("prison","0");
        String project_origin_institute= sharedPreferences.getString ("project_origin_institute","0");
        String shelter= sharedPreferences.getString ("shelter","0");
        String shrine= sharedPreferences.getString ("shrine","0");
        String steel_mill= sharedPreferences.getString ("steel_mill","0");
        String storeroom= sharedPreferences.getString ("storeroom","0");
        String teaching_building= sharedPreferences.getString ("teaching_building","0");
        String tower= sharedPreferences.getString ("tower","0");
        String training_house= sharedPreferences.getString ("training_house","0");
        String wall= sharedPreferences.getString ("wall","0");
        String war_factory= sharedPreferences.getString ("war_factory","0");
        String z_11= sharedPreferences.getString ("z_11","0");

        build_01.setText(	alloy_mine	);
        build_02.setText(	armed_forces	);
        build_03.setText(	armory	);
        build_04.setText(	cafeteria	);
        build_05.setText(	clinic	);
        build_06.setText(	clone_lab	);
        build_07.setText(	comm_building	);
        build_08.setText(	dorm	);
        build_09.setText(	embassy	);
        build_10.setText(	farm	);
        build_11.setText(	infection_institute	);
        build_12.setText(	laboratory	);
        build_13.setText(	logistics_center	);
        build_14.setText(	military_office	);
        build_15.setText(	mobile_team_factory	);
        build_16.setText(	obsidian_refine_building	);
        build_17.setText(	oil_well	);
        build_18.setText(	prison	);
        build_19.setText(	project_origin_institute	);
        build_20.setText(	shelter	);
        build_21.setText(	shrine	);
        build_22.setText(	steel_mill	);
        build_23.setText(	storeroom	);
        build_24.setText(	teaching_building	);
        build_25.setText(	tower	);
        build_26.setText(	training_house	);
        build_27.setText(	wall	);
        build_28.setText(	war_factory	);
        build_29.setText(	z_11	);


    }
    @Override
    public void onBackPressed() {
        save();
        super.onBackPressed();
    }
    public void save () {
        String alloy_mine_final = String .valueOf(build_01.getText());
        String armed_forces_final = String .valueOf(build_02.getText());
        String armory_final = String .valueOf(build_03.getText());
        String cafeteria_final = String .valueOf(build_04.getText());
        String clinic_final = String .valueOf(build_05.getText());
        String clone_lab_final = String .valueOf(build_06.getText());
        String comm_building_final = String .valueOf(build_07.getText());
        String dorm_final = String .valueOf(build_08.getText());
        String embassy_final = String .valueOf(build_09.getText());
        String farm_final = String .valueOf(build_10.getText());
        String infection_institute_final = String .valueOf(build_11.getText());
        String laboratory_final = String .valueOf(build_12.getText());
        String logistics_center_final = String .valueOf(build_13.getText());
        String military_office_final = String .valueOf(build_14.getText());
        String mobile_team_factory_final = String .valueOf(build_15.getText());
        String obsidian_refine_building_final = String .valueOf(build_16.getText());
        String oil_well_final = String .valueOf(build_17.getText());
        String prison_final = String .valueOf(build_18.getText());
        String project_origin_institute_final = String .valueOf(build_19.getText());
        String shelter_final = String .valueOf(build_20.getText());
        String shrine_final = String .valueOf(build_21.getText());
        String steel_mill_final = String .valueOf(build_22.getText());
        String storeroom_final = String .valueOf(build_23.getText());
        String teaching_building_final = String .valueOf(build_24.getText());
        String tower_final = String .valueOf(build_25.getText());
        String training_house_final = String .valueOf(build_26.getText());
        String wall_final = String .valueOf(build_27.getText());
        String war_factory_final = String .valueOf(build_28.getText());
        String z_11_final = String .valueOf(build_29.getText());



        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        //获取操作SharedPreferences实例的编辑器（必须通过此种方式添加数据）
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //添加数据
        editor.putString("alloy_mine",alloy_mine_final);
        editor.putString("armed_forces",armed_forces_final);
        editor.putString("armory",armory_final);
        editor.putString("cafeteria",cafeteria_final);
        editor.putString("clinic",clinic_final);
        editor.putString("clone_lab",clone_lab_final);
        editor.putString("comm_building",comm_building_final);
        editor.putString("dorm",dorm_final);
        editor.putString("embassy",embassy_final);
        editor.putString("farm",farm_final);
        editor.putString("infection_institute",infection_institute_final);
        editor.putString("laboratory",laboratory_final);
        editor.putString("logistics_center",logistics_center_final);
        editor.putString("military_office",military_office_final);
        editor.putString("mobile_team_factory",mobile_team_factory_final);
        editor.putString("obsidian_refine_building",obsidian_refine_building_final);
        editor.putString("oil_well",oil_well_final);
        editor.putString("prison",prison_final);
        editor.putString("project_origin_institute",project_origin_institute_final);
        editor.putString("shelter",shelter_final);
        editor.putString("shrine",shrine_final);
        editor.putString("steel_mill",steel_mill_final);
        editor.putString("storeroom",storeroom_final);
        editor.putString("teaching_building",teaching_building_final);
        editor.putString("tower",tower_final);
        editor.putString("training_house",training_house_final);
        editor.putString("wall",wall_final);
        editor.putString("war_factory",war_factory_final);
        editor.putString("z_11",z_11_final);

        //提交
        editor.apply();
    }
}