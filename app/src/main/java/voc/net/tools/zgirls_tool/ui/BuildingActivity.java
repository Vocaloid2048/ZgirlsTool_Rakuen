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
import voc.net.tools.zgirls_tool.util.ScreenSizeUtils;
import voc.net.tools.zgirls_tool.building.BuildingLib;

public class BuildingActivity extends AppCompatActivity {

    String building_choosed ="";
    ImageView building_choose ;
    TextView building_tv;
    TextView fuel_tv;
    TextView food_tv;
    TextView steel_tv;
    TextView alloy_tv;
    TextView time_tv ;
    TextView kyanite_tv ;
    TextView kyanite_basic_tv ;
    TextView kyanite_cluster_tv ;
    TextView glory_mark_tv ;
    TextView item_tv ;
    ImageView item_img ;
    ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;
    long  steel , alloy , kyanite , kyanite_basic , kyanite_cluster , glory , time , fuel , food , item;
    int now = 0 , aim = 0 ;
    BuildingLib buildingLib ;
    SeekBar now_seek , aim_seek ;
    TextView now_tv , aim_tv ;
    int dummy = 1 ;
    Context context ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building);
        building_choose = findViewById(R.id.building_choose);
        building_tv = findViewById(R.id.building_tv);

        buildingLib = new BuildingLib();
        buildingLib.setContext(this);
        fuel_tv = findViewById(R.id.building_fuel);
        food_tv = findViewById(R.id.building_food);
        steel_tv = findViewById(R.id.building_steel);
        alloy_tv = findViewById(R.id.building_alloy);
        time_tv = findViewById(R.id.building_time);
        kyanite_tv = findViewById(R.id.building_kyanite);
        kyanite_basic_tv = findViewById(R.id.building_kyanite_basic);
        kyanite_cluster_tv = findViewById(R.id.building_kyanite_cluster);
        glory_mark_tv = findViewById(R.id.building_glory_mark);
        item_tv = findViewById(R.id.building_items);
        item_img = findViewById(R.id.item_img);
        time_tv.setText("0d , 00:00:00");
        listView = findViewById(R.id.building_list);

        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.list_tv, arrayList);
        listView.setAdapter(adapter);

        BackgroundReload();
        buildingLib.getItemImg("" , item_img , item_tv);
        context = this ;

        now_seek = findViewById(R.id.now_seek);
        aim_seek = findViewById(R.id.aim_seek);
        now_tv = findViewById(R.id.now_seek_tv);
        aim_tv = findViewById(R.id.aim_seek_tv);
        now_seek.setMax(0);
        aim_seek.setMax(0);
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
                now_tv.setText(buildingLib.getTvName(now , dummy , context ));
                aim_tv.setText(buildingLib.getTvName(aim , dummy , context ));
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
                now_tv.setText(buildingLib.getTvName(now , dummy , context ));
                aim_tv.setText(buildingLib.getTvName(aim , dummy , context ));
                calculate();
            }
        });
    }
    public void BackgroundReload (){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String gif_png = sharedPreferences.getString("gif/png", "png");
        GifImageView gifImageView1 = (GifImageView) findViewById(R.id.building_bg);

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
    public void building (View view) {
        final Dialog dialog = new Dialog(this, R.style.NormalDialogStyle_N);
        view = View.inflate(this, R.layout.building_choose, null);

        ImageView 	alloy_mine	 = view.findViewById(R.id.	alloy_mine	);
        ImageView 	arena	 = view.findViewById(R.id.	arena	);
        ImageView 	armed_forces	 = view.findViewById(R.id.	armed_forces	);
        ImageView 	armory	 = view.findViewById(R.id.	armory	);
        ImageView 	cafeteria	 = view.findViewById(R.id.	cafeteria	);
        ImageView 	clinic	 = view.findViewById(R.id.	clinic	);
        ImageView 	clone_lab	 = view.findViewById(R.id.	clone_lab	);
        ImageView 	comm_building	 = view.findViewById(R.id.	comm_building	);
        ImageView 	dorm	 = view.findViewById(R.id.	dorm	);
        ImageView 	embassy	 = view.findViewById(R.id.	embassy	);
        ImageView 	farm	 = view.findViewById(R.id.	farm	);
        ImageView 	infection_institute	 = view.findViewById(R.id.	infection_institute	);
        ImageView 	laboratory	 = view.findViewById(R.id.	laboratory	);
        ImageView 	logistics_center	 = view.findViewById(R.id.	logistics_center	);
        ImageView 	military_office	 = view.findViewById(R.id.	military_office	);
        ImageView 	mobile_team_factory	 = view.findViewById(R.id.	mobile_team_factory	);
        ImageView 	monument	 = view.findViewById(R.id.	monument	);
        ImageView 	mystical_building	 = view.findViewById(R.id.	mystical_building	);
        ImageView 	obsidian_refine_building	 = view.findViewById(R.id.	obsidian_refine_building	);
        ImageView 	oil_well	 = view.findViewById(R.id.	oil_well	);
        ImageView 	prison	 = view.findViewById(R.id.	prison	);
        ImageView 	project_origin_institute	 = view.findViewById(R.id.	project_origin_institute	);
        ImageView 	shelter	 = view.findViewById(R.id.	shelter	);
        ImageView 	shrine	 = view.findViewById(R.id.	shrine	);
        ImageView 	smelting_workshop	 = view.findViewById(R.id.	smelting_workshop	);
        ImageView 	star_stone_institute	 = view.findViewById(R.id.	star_stone_institute	);
        ImageView 	steel_mill	 = view.findViewById(R.id.	steel_mill	);
        ImageView 	storeroom	 = view.findViewById(R.id.	storeroom	);
        ImageView 	student_union	 = view.findViewById(R.id.	student_union	);
        ImageView 	teaching_building	 = view.findViewById(R.id.	teaching_building	);
        ImageView 	tech_institute	 = view.findViewById(R.id.	tech_institute	);
        ImageView 	tech_research_lab	 = view.findViewById(R.id.	tech_research_lab	);
        ImageView 	tower	 = view.findViewById(R.id.	tower	);
        ImageView 	training_house	 = view.findViewById(R.id.	training_house	);
        ImageView 	vehicle_institute	 = view.findViewById(R.id.	vehicle_institute	);
        ImageView 	wall	 = view.findViewById(R.id.	wall	);
        ImageView 	war_factory	 = view.findViewById(R.id.	war_factory	);
        ImageView 	z_11	 = view.findViewById(R.id.	z_11	);


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
        alloy_mine.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "alloy_mine";building_choose.setImageResource(R.drawable.build_alloy);building_tv.setText(R.string.alloy_mine);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        arena.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "arena";building_choose.setImageResource(R.drawable.build_arena);building_tv.setText(R.string.build_arena);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        armed_forces.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "armed_forces";building_choose.setImageResource(R.drawable.build_armed);building_tv.setText(R.string.armed_forces);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        armory.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "armory";building_choose.setImageResource(R.drawable.build_armory);building_tv.setText(R.string.armory);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        cafeteria.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "cafeteria";building_choose.setImageResource(R.drawable.build_cafe);building_tv.setText(R.string.cafeteria);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        clinic.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "clinic";building_choose.setImageResource(R.drawable.build_clinic);building_tv.setText(R.string.clinic);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        clone_lab.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "clone_lab";building_choose.setImageResource(R.drawable.build_clone);building_tv.setText(R.string.clone_lab);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        comm_building.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "comm_building";building_choose.setImageResource(R.drawable.build_comm);building_tv.setText(R.string.comm_building);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        dorm.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "dorm";building_choose.setImageResource(R.drawable.build_dorm);building_tv.setText(R.string.dorm);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        embassy.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "embassy";building_choose.setImageResource(R.drawable.build_embassy);building_tv.setText(R.string.embassy);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        farm.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "farm";building_choose.setImageResource(R.drawable.build_farm);building_tv.setText(R.string.farm);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        infection_institute.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "infection_institute";building_choose.setImageResource(R.drawable.build_infection);building_tv.setText(R.string.infection_institute);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        laboratory.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "laboratory";building_choose.setImageResource(R.drawable.build_laboratory);building_tv.setText(R.string.laboratory);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        logistics_center.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "logistics_center";building_choose.setImageResource(R.drawable.build_logist);building_tv.setText(R.string.logistics_center);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        military_office.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "military_office";building_choose.setImageResource(R.drawable.build_military);building_tv.setText(R.string.military_office);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        mobile_team_factory.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "mobile_team_factory";building_choose.setImageResource(R.drawable.build_mobile);building_tv.setText(R.string.mobile_team_factory);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        monument.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "monument";building_choose.setImageResource(R.drawable.build_sculpture);building_tv.setText(R.string.build_monument);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        mystical_building.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "mystical_building";building_choose.setImageResource(R.drawable.build_mystical);building_tv.setText(R.string.build_mystical);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        obsidian_refine_building.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "obsidian_refine_building";building_choose.setImageResource(R.drawable.build_obsidians);building_tv.setText(R.string.obsidian_refine_building);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        oil_well.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "oil_well";building_choose.setImageResource(R.drawable.build_fuel);building_tv.setText(R.string.oil_well);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        prison.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "prison";building_choose.setImageResource(R.drawable.build_prison);building_tv.setText(R.string.prison);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        project_origin_institute.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "project_origin_institute";building_choose.setImageResource(R.drawable.build_project_origin);building_tv.setText(R.string.project_origin_institute);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        shelter.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "shelter";building_choose.setImageResource(R.drawable.build_shelter);building_tv.setText(R.string.shelter);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        shrine.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "shrine";building_choose.setImageResource(R.drawable.build_shrine);building_tv.setText(R.string.shrine);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        smelting_workshop.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "smelting_workshop";building_choose.setImageResource(R.drawable.build_smelt);building_tv.setText(R.string.build_smelting_workshop);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        star_stone_institute.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "star_stone_institute";building_choose.setImageResource(R.drawable.build_star_stone);building_tv.setText(R.string.build_star_institute);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        steel_mill.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "steel_mill";building_choose.setImageResource(R.drawable.build_steel);building_tv.setText(R.string.steel_mill);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        storeroom.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "storeroom";building_choose.setImageResource(R.drawable.build_storeroom);building_tv.setText(R.string.storeroom);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        student_union.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "student_union";building_choose.setImageResource(R.drawable.build_union);building_tv.setText(R.string.build_student_union);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        teaching_building.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "teaching_building";building_choose.setImageResource(R.drawable.build_tb);building_tv.setText(R.string.teaching_building);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        tech_institute.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "tech_institute";building_choose.setImageResource(R.drawable.build_mecha);building_tv.setText(R.string.build_tech_institute);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        tech_research_lab.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "tech_research_lab";building_choose.setImageResource(R.drawable.build_project_lab);building_tv.setText(R.string.build_tech_lab);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        tower.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "tower";building_choose.setImageResource(R.drawable.build_tower);building_tv.setText(R.string.tower);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        training_house.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "training_house";building_choose.setImageResource(R.drawable.build_training);building_tv.setText(R.string.training_house);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        vehicle_institute.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "vehicle_institute";building_choose.setImageResource(R.drawable.build_vehicle);building_tv.setText(R.string.build_vehicle);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        wall.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "wall";building_choose.setImageResource(R.drawable.build_wall);building_tv.setText(R.string.wall);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        war_factory.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "war_factory";building_choose.setImageResource(R.drawable.build_war_factory);building_tv.setText(R.string.war_factory);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
        z_11.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { dialog.dismiss();building_choosed = "z_11";building_choose.setImageResource(R.drawable.build_z11);building_tv.setText(R.string.z_11);now_seek.setMax(buildingLib.getAim(building_choosed)-1);aim_seek.setMax(buildingLib.getAim(building_choosed));dummy = buildingLib.getAim(building_choosed);buildingLib.getItemImg(building_choosed , item_img , item_tv);}});
    }
    public void cal1 (View view) {calculate();}

    private void calculate() {
        adapter.clear();
        steel = alloy = kyanite = kyanite_basic = kyanite_cluster = glory = time = fuel = food = item =0;

            if (building_choosed.matches("alloy_mine")){
                buildingLib.reset();
                buildingLib.alloy_mine(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("arena")){
                buildingLib.reset();
                buildingLib.arena(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("armed_forces")){
                buildingLib.reset();
                buildingLib.armed_forces(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("armory")){
                buildingLib.reset();
                buildingLib.armory(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("cafeteria")){
                buildingLib.reset();
                buildingLib.cafeteria(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("clinic")){
                buildingLib.reset();
                buildingLib.clinic(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("clone_lab")){
                buildingLib.reset();
                buildingLib.clone_lab(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("comm_building")){
                buildingLib.reset();
                buildingLib.comm_building(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("dorm")){
                buildingLib.reset();
                buildingLib.dorm(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("embassy")){
                buildingLib.reset();
                buildingLib.embassy(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("farm")){
                buildingLib.reset();
                buildingLib.farm(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("infection_institute")){
                buildingLib.reset();
                buildingLib.infection_institute(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("laboratory")){
                buildingLib.reset();
                buildingLib.laboratory(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("logistics_center")){
                buildingLib.reset();
                buildingLib.logistics_center(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("military_office")){
                buildingLib.reset();
                buildingLib.military_office(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("mobile_team_factory")){
                buildingLib.reset();
                buildingLib.mobile_team_factory(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("monument")){
                buildingLib.reset();
                buildingLib.monument(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("mystical_building")){
                buildingLib.reset();
                buildingLib.mystical_building(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("obsidian_refine_building")){
                buildingLib.reset();
                buildingLib.obsidian_refine_building(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("oil_well")){
                buildingLib.reset();
                buildingLib.oil_well(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("prison")){
                buildingLib.reset();
                buildingLib.prison(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("project_origin_institute")){
                buildingLib.reset();
                buildingLib.project_origin_institute(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("shelter")){
                buildingLib.reset();
                buildingLib.shelter(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("shrine")){
                buildingLib.reset();
                buildingLib.shrine(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("smelting_workshop")){
                buildingLib.reset();
                buildingLib.smelting_workshop(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("star_stone_institute")){
                buildingLib.reset();
                buildingLib.star_stone_institute(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("steel_mill")){
                buildingLib.reset();
                buildingLib.steel_mill(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("storeroom")){
                buildingLib.reset();
                buildingLib.storeroom(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("student_union")){
                buildingLib.reset();
                buildingLib.student_union(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("teaching_building")){
                buildingLib.reset();
                buildingLib.teaching_building(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("tech_institute")){
                buildingLib.reset();
                buildingLib.tech_institute(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("tech_research_lab")){
                buildingLib.reset();
                buildingLib.tech_research_lab(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("tower")){
                buildingLib.reset();
                buildingLib.tower(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("training_house")){
                buildingLib.reset();
                buildingLib.training_house(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("vehicle_institute")){
                buildingLib.reset();
                buildingLib.vehicle_institute(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("wall")){
                buildingLib.reset();
                buildingLib.wall(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("war_factory")){
                buildingLib.reset();
                buildingLib.war_factory(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }
            if (building_choosed.matches("z_11")){
                buildingLib.reset();
                buildingLib.z_11(now, aim, adapter);
                fuel = buildingLib.getFuel();
                food = buildingLib.getFood();
                steel = buildingLib.getSteel();
                alloy = buildingLib.getAlloy();
                time = buildingLib.getTime();
                kyanite = buildingLib.getKyanite();
                kyanite_basic = buildingLib.getKyaniteBasic();
                kyanite_cluster = buildingLib.getKyaniteCluster();
                glory = buildingLib.getGloryMark();
                item = buildingLib.getItem();
                Log.wtf("FUEL" , String.valueOf(fuel));
                Log.wtf("FUEL" , String.valueOf(buildingLib.getFuel()));
            }


        String Fuel_String = null, Food_String= null , Steel_String = null, Alloy_String= null , Time_String = null , Kyanite_String = null , Kyanite_basic_String = null , Kyanite_cluster_String = null , Glory_Mark_String = null;


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
        Glory_Mark_String = formatter8.format(glory);

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
        item_tv.setText(prettyCount(item));
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
