package voc.net.tools.zgirls_tool.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import voc.net.tools.zgirls_tool.R;
import voc.net.tools.zgirls_tool.building.BuildingLib;

/**
 * Created by Voc on 27/10/17.
 */


public class BuildingAdapter extends RecyclerView.Adapter<BuildingAdapter.ViewHolder> {


    private Context context;
    private List<Building> buildingList;
    private AdapterView.OnItemClickListener mListener;
    private WebView webView ;
    BuildingLib buildingLib;

    long fuel , food , steel , alloy , obsidian , kyanite  ,kyanite_basic  , kyanite_cluster , glory_mark ,item;

    public BuildingAdapter(Context context, List<Building> buildingList) {
        this.context = context;
        this.buildingList = buildingList;

    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.building_item, parent, false);
        ViewHolder evh = new ViewHolder(v, (OnItemClickListener) mListener);

        return evh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.adapter.clear();
      //  if(holder.adapter == null) {
      //  Toast.makeText(context, "Bye" , Toast.LENGTH_SHORT).show();
       // Log.wtf("OK" , "YOU FK");}else{Log.wtf("OK" , "YOU DIDN't FK");Toast.makeText(context, "YEAH" , Toast.LENGTH_SHORT).show();}
        Building building = buildingList.get(position);
        holder.upgrade.setVisibility(View.INVISIBLE);
        fuel = 0 ;
        food = 0 ;
        steel = 0 ;
        alloy = 0 ;
        obsidian = 0 ;
        kyanite = 0 ;
        kyanite_basic = 0 ;
        kyanite_cluster = 0 ;
        glory_mark = 0 ;
        item = 0 ;
        buildingLib = new BuildingLib();
        buildingLib.setContext(context); //Dumb Voc use 30 mins to think this ... Damn
        /**
         * Plan RSS
         */
        holder.Name_TV.setText(building.getName());
        if (building.getLvl() <= 30 ) {
            holder.Name_TV.setText(building.getName() + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
        }
        if (building.getLvl() == 30 && building.getGlory() > 0) {
            holder.Name_TV.setText(building.getName() + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
        }

        int now = (int) (building.getLvl()+building.getGlory());
        int aim = now+1 ;


        holder.upgrade.setVisibility(View.INVISIBLE);
        if ((building.getLvl()+building.getGlory()/5) > 35){
            holder.upgrade.setVisibility(View.INVISIBLE);
        } else {
            holder.upgrade.setVisibility(View.VISIBLE);}

        String type = String.valueOf(building.getName());
        if (type.equals("Teaching Building")) {

            holder.Name_TV.setText(context.getString(R.string.teaching_building)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.teaching_building) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.teaching_building) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            holder.Type_IMG.setImageResource(R.drawable.build_tb);
            building.setType(4);

            buildingLib.reset();
            buildingLib.teaching_building(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("teaching_building",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;
        }
        else if (type.equals("Z-11")) {
            holder.Type_IMG.setImageResource(R.drawable.build_z11);
            building.setType(4);
            holder.Name_TV.setText(context.getString(R.string.z_11)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.z_11) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.z_11) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.z_11(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("z_11",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;
        }
        else if (type.equals("Embassy")) {
            holder.Type_IMG.setImageResource(R.drawable.build_embassy);
            building.setType(4);
            holder.Name_TV.setText(context.getString(R.string.embassy)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.embassy) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.embassy) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.embassy(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("embassy",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;
        }
        else if (type.equals("Laboratory")) {
            holder.Type_IMG.setImageResource(R.drawable.build_laboratory);
            building.setType(1);
            holder.Name_TV.setText(context.getString(R.string.laboratory)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.laboratory) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.laboratory) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.laboratory(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("laboratory",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;

        }
        else if (type.equals("Storeroom")) {
            holder.Type_IMG.setImageResource(R.drawable.build_storeroom);
            building.setType(4);
            holder.Name_TV.setText(context.getString(R.string.storeroom)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.storeroom) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.storeroom) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.storeroom(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("storeroom",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;

        }
        else if (type.equals("Student Union")) {
            holder.Type_IMG.setImageResource(R.drawable.build_union);
            building.setType(4);
            holder.Name_TV.setText(context.getString(R.string.build_student_union)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.build_student_union) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.build_student_union) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));}
            buildingLib.reset();
            buildingLib.student_union(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("student_union",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;

        }
        else if (type.equals("Shelter")) {
            holder.Type_IMG.setImageResource(R.drawable.build_shelter);
            building.setType(3);
            holder.Name_TV.setText(context.getString(R.string.shelter)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.shelter) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.shelter) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.shelter(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("shelter",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;

        }
        else if (type.equals("Clinic")) {
            holder.Type_IMG.setImageResource(R.drawable.build_clinic);
            building.setType(3);
            holder.Name_TV.setText(context.getString(R.string.clinic)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.clinic) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.clinic) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.clinic(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("clinic",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;
        }
        else if (type.equals("Alloy Mine")) {
            holder.Type_IMG.setImageResource(R.drawable.build_alloy);
            building.setType(2);
            holder.Name_TV.setText(context.getString(R.string.alloy_mine)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.alloy_mine) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.alloy_mine) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.alloy_mine(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("alloy_mine",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;
        }
        else if (type.equals("Oil Well")) {
            holder.Type_IMG.setImageResource(R.drawable.build_fuel);
            building.setType(2);
            holder.Name_TV.setText(context.getString(R.string.oil_well)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.oil_well) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.oil_well) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));}
            buildingLib.reset();
            buildingLib.oil_well(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("oil_well",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;
        }
        else if (type.equals("Steel Mill")) {
            holder.Type_IMG.setImageResource(R.drawable.build_steel);
            building.setType(2);
            holder.Name_TV.setText(context.getString(R.string.steel_mill)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.steel_mill) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.steel_mill) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.steel_mill(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("steel_mill",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;
        }
        else if (type.equals("Farm")) {
            holder.Type_IMG.setImageResource(R.drawable.build_farm);
            building.setType(2);
            holder.Name_TV.setText(context.getString(R.string.farm)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.farm) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.farm) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.farm(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("farm",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;
        }
        else if (type.equals("War Factory")) {
            holder.Type_IMG.setImageResource(R.drawable.build_war_factory);
            building.setType(4);
            holder.Name_TV.setText(context.getString(R.string.war_factory)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.war_factory) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.war_factory) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.war_factory(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("war_factory",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;
        }
        else if (type.equals("Comm. Building")) {
            holder.Type_IMG.setImageResource(R.drawable.build_comm);
            building.setType(4);
            holder.Name_TV.setText(context.getString(R.string.comm_building)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.comm_building) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.comm_building) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.comm_building(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("comm_building",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;
        }
        else if (type.equals("Tower")) {
            holder.Type_IMG.setImageResource(R.drawable.build_tower);
            building.setType(4);
            holder.Name_TV.setText(context.getString(R.string.tower)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.tower) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.tower) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.tower(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("tower",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;

        }
        else if (type.equals("Wall")) {
            holder.Type_IMG.setImageResource(R.drawable.build_wall);
            building.setType(4);
            holder.Name_TV.setText(context.getString(R.string.wall)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));

            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.wall) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.wall) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.wall(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("wall",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;
        }
        else if (type.equals("Military Office")) {
            holder.Type_IMG.setImageResource(R.drawable.build_military);
            building.setType(1);
            holder.Name_TV.setText(context.getString(R.string.military_office)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.military_office) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.teaching_building) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.military_office(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("military_office",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;
        }
        else if (type.equals("Mobile Team Factory")) {
            holder.Type_IMG.setImageResource(R.drawable.build_mobile);
            building.setType(1);
            holder.Name_TV.setText(context.getString(R.string.mobile_team_factory)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));

            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.mobile_team_factory) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.mobile_team_factory) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.mobile_team_factory(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("mobile_team_factory",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;
        }
        else if (type.equals("Armed Forces")) {
            holder.Type_IMG.setImageResource(R.drawable.build_armed);
            building.setType(1);
            holder.Name_TV.setText(context.getString(R.string.armed_forces)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));

            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.armed_forces) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.armed_forces) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.armed_forces(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("armed_forces",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;
        }
        else if (type.equals("Infection Institute")) {
            holder.Type_IMG.setImageResource(R.drawable.build_infection);
            building.setType(1);
            holder.Name_TV.setText(context.getString(R.string.infection_institute)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.infection_institute) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.infection_institute) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.infection_institute(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("infection_institute",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;
        }
        else if (type.equals("Logistics Center")) {
            holder.Type_IMG.setImageResource(R.drawable.build_logist);
            building.setType(4);
            holder.Name_TV.setText(context.getString(R.string.logistics_center)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.logistics_center) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.logistics_center) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.logistics_center(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("logistics_center",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;

        }
        else if (type.equals("Shrine")) {
            holder.Type_IMG.setImageResource(R.drawable.build_shrine);
            building.setType(4);
            holder.Name_TV.setText(context.getString(R.string.shrine)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));

            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.shrine) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.shrine) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.shrine(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("shrine",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;

        }
        else if (type.equals("Armory")) {
            holder.Type_IMG.setImageResource(R.drawable.build_armory);
            building.setType(4);
            holder.Name_TV.setText(context.getString(R.string.armory)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.armory) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.armory) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.armory(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("armory",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;
        }
        else if (type.equals("Cafeteria")) {
            holder.Type_IMG.setImageResource(R.drawable.build_cafe);
            building.setType(4);
            holder.Name_TV.setText(context.getString(R.string.cafeteria)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.cafeteria) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.cafeteria) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.cafeteria(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("cafeteria",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;


        }
        else if (type.equals("Prison")) {
            holder.Type_IMG.setImageResource(R.drawable.build_prison);
            building.setType(4);
            holder.Name_TV.setText(context.getString(R.string.prison)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.prison) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.prison) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.prison(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("prison",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;

        }
        else if (type.equals("Clone Lab")) {
            holder.Type_IMG.setImageResource(R.drawable.build_clone);
            building.setType(4);
            buildingLib.reset();
            buildingLib.clone_lab(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("clone_lab",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;

        }
        else if (type.equals("Dorm")) {
            holder.Type_IMG.setImageResource(R.drawable.build_dorm);
            building.setType(4);
            holder.Name_TV.setText(context.getString(R.string.dorm)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.dorm) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.dorm) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.dorm(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("dorm",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;


        }
        else if (type.equals("Star Stone Institute")) {
            holder.Type_IMG.setImageResource(R.drawable.build_star_stone);
            building.setType(4);
            // holder.Name_TV.setText(context.getString(R.string.clinic)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.build_star_institute) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.build_star_institute) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.star_stone_institute(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("star_stone_institute",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;
            holder.upgrade.setVisibility(View.INVISIBLE);
        }
        else if (type.equals("Smelting Workshop")) {
            holder.Type_IMG.setImageResource(R.drawable.build_smelt);
            building.setType(4);

            // holder.Name_TV.setText(context.getString(R.string.clinic)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.build_smelting_workshop) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.build_smelting_workshop) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.smelting_workshop(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("smelting_workshop",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;
            holder.upgrade.setVisibility(View.INVISIBLE);

        }
        else if (type.equals("Arena")) {
            holder.Type_IMG.setImageResource(R.drawable.build_arena);
            building.setType(4);

            // holder.Name_TV.setText(context.getString(R.string.clinic)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.build_arena) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.build_arena) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.arena(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("arena",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;
            holder.upgrade.setVisibility(View.INVISIBLE);

        }
        else if (type.equals("Mystical Building")) {
            holder.Type_IMG.setImageResource(R.drawable.build_mystical);
            building.setType(4);

            //  holder.Name_TV.setText(context.getString(R.string.clinic)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.build_mystical) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.build_mystical) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.mystical_building(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("mystical_building",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;
            holder.upgrade.setVisibility(View.INVISIBLE);
        }
        else if (type.equals("Obsidian Refine Building")) {
            holder.Type_IMG.setImageResource(R.drawable.build_obsidians);
            building.setType(2);
            holder.Name_TV.setText(context.getString(R.string.obsidian_refine_building)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.obsidian_refine_building) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.obsidian_refine_building) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.obsidian_refine_building(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("obsidian_refine_building",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;

        }
        else if (type.equals("Training House")) {
            holder.Type_IMG.setImageResource(R.drawable.build_training);
            building.setType(1);
            holder.Name_TV.setText(context.getString(R.string.training_house)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.training_house) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.training_house) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.training_house(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("training_house",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;

        }
        else if (type.equals("Tech. Institute")) {
            holder.Type_IMG.setImageResource(R.drawable.build_mecha);
            building.setType(1);

            //holder.Name_TV.setText(context.getString(R.string.clinic)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.build_tech_institute) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.build_tech_institute) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }

            buildingLib.reset();
            buildingLib.tech_institute(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("tech_institute",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;

            holder.upgrade.setVisibility(View.INVISIBLE);
        }
        else if (type.equals("Project Origin Institute")) {
            holder.Type_IMG.setImageResource(R.drawable.build_project_origin);
            building.setType(1);
            holder.Name_TV.setText(context.getString(R.string.project_origin_institute)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.project_origin_institute) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.project_origin_institute) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.project_origin_institute(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("project_origin_institute",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;

        }
        else if (type.equals("Vehicle Institute")) {
            holder.Type_IMG.setImageResource(R.drawable.build_vehicle);
            building.setType(1);

            holder.Name_TV.setText(context.getString(R.string.build_vehicle)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.build_vehicle) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.build_vehicle) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.vehicle_institute(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("vehicle_institute",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;
            holder.upgrade.setVisibility(View.INVISIBLE);
        }
        else if (type.equals("Tech. Research Lab.")) {
            holder.Type_IMG.setImageResource(R.drawable.build_project_lab);
            building.setType(1);
            holder.Name_TV.setText(context.getString(R.string.build_tech_lab)+ " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));

            if (building.getLvl() <= 30 ) {
                holder.Name_TV.setText(context.getString(R.string.build_tech_lab) + " -- "+context.getString(R.string.level) + String.valueOf(building.getLvl()));
            }
            if (building.getLvl() == 30 && building.getGlory() > 0) {
                holder.Name_TV.setText(context.getString(R.string.build_tech_lab) + " -- "+context.getString(R.string.glory) + String.valueOf((int)building.getGlory()/5));
            }
            buildingLib.reset();
            buildingLib.tech_research_lab(now, aim, holder.adapter);
            holder.rss1.setText(prettyCount(buildingLib.getFuel())) ; holder.rss_img1.setImageResource(R.drawable.fuel);
            holder.rss2.setText(prettyCount(buildingLib.getFood())) ; holder.rss_img2.setImageResource(R.drawable.food);
            holder.rss3.setText(prettyCount(buildingLib.getSteel())) ; holder.rss_img3.setImageResource(R.drawable.steel);
            holder.rss4.setText(prettyCount(buildingLib.getAlloy())) ; holder.rss_img4.setImageResource(R.drawable.alloy);
            holder.rss5.setText(prettyCount(buildingLib.getKyanite())) ; holder.rss_img5.setImageResource(R.drawable.kyanite);
            holder.rss6.setText(prettyCount(buildingLib.getKyaniteBasic())) ; holder.rss_img6.setImageResource(R.drawable.kyanite_basic);
            holder.rss7.setText(prettyCount(buildingLib.getKyaniteCluster())) ; holder.rss_img7.setImageResource(R.drawable.kyanite_cluster);
            holder.rss8.setText(prettyCount(buildingLib.getGloryMark())) ; holder.rss_img8.setImageResource(R.drawable.glory_mark);
            buildingLib.getItemImg("tech_research_lab",holder.rss_img9,holder.rss9);
            holder.rss9.setText(prettyCount(buildingLib.getItem())) ;
            holder.upgrade.setVisibility(View.INVISIBLE);
        }
        //Log.wtf("JSON" , building.getName()+"\t"+holder.Name_TV.getText());


        /**

         SetText(holder , fuel , R.drawable.fuel);

         SetText(holder , food , R.drawable.food);
         SetText(holder , steel , R.drawable.steel);
         SetText(holder , alloy , R.drawable.alloy);
         SetText(holder , kyanite , R.drawable.kyanite);
         SetText(holder , kyanite_basic , R.drawable.kyanite_basic);
         SetText(holder , kyanite_cluster , R.drawable.kyanite_cluster);
         SetText(holder , glory_mark , R.drawable.glory_mark);
         SetText(holder , obsidian , R.drawable.rss_obsidian);


         Log.wtf(type , prettyCount(fuel) + " | " +prettyCount(food) + " | " +prettyCount(steel) + " | " +prettyCount(alloy) + " | " +prettyCount(kyanite) + " | " +prettyCount(kyanite_basic) + " | " +prettyCount(kyanite_cluster) + " | " +prettyCount(glory_mark) + " | " +prettyCount(obsidian) + " | "  );

         // if (Information.getSubject().equals("CH")){holder.Subject_TV.setTextColor(Color.parseColor("#FF0000"));}
         **/

        // if (Information.getSubject().equals("CH")){holder.bg.setBackgroundResource(R.drawable.img_kayaking_ch);}
    }

    @Override
    public int getItemCount() {
        return buildingList.size();
    }

    public void SetText (ViewHolder holder , long s , int img) {
        if (holder.rss1.getText().equals("") && s!= 0){holder.rss1.setText(prettyCount(s)) ; holder.rss_img1.setImageResource(img); holder.rss_img1.setVisibility(View.VISIBLE);}
        else if (holder.rss2.getText().equals("") && s!= 0){holder.rss2.setText(prettyCount(s)) ; holder.rss_img2.setImageResource(img); holder.rss_img2.setVisibility(View.VISIBLE);}
        else if (holder.rss3.getText().equals("") && s!= 0){holder.rss3.setText(prettyCount(s)) ; holder.rss_img3.setImageResource(img); holder.rss_img3.setVisibility(View.VISIBLE);}
        else if (holder.rss4.getText().equals("") && s!= 0){holder.rss4.setText(prettyCount(s)) ; holder.rss_img4.setImageResource(img); holder.rss_img4.setVisibility(View.VISIBLE);}
        else if (holder.rss5.getText().equals("") && s!= 0){holder.rss5.setText(prettyCount(s)) ; holder.rss_img5.setImageResource(img); holder.rss_img5.setVisibility(View.VISIBLE);}
        else if (holder.rss6.getText().equals("") && s!= 0){holder.rss6.setText(prettyCount(s)) ; holder.rss_img6.setImageResource(img); holder.rss_img6.setVisibility(View.VISIBLE);}
        else if (holder.rss7.getText().equals("") && s!= 0){holder.rss7.setText(prettyCount(s)) ; holder.rss_img7.setImageResource(img); holder.rss_img7.setVisibility(View.VISIBLE);}
        else if (holder.rss8.getText().equals("") && s!= 0){holder.rss8.setText(prettyCount(s)) ; holder.rss_img8.setImageResource(img); holder.rss_img8.setVisibility(View.VISIBLE);}
        else if (holder.rss9.getText().equals("") && s!= 0){holder.rss9.setText(prettyCount(s)) ; holder.rss_img9.setImageResource(img); holder.rss_img9.setVisibility(View.VISIBLE);}
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Name_TV;
        public ImageView Type_IMG;
        public LinearLayout bg;

        public TextView rss1;
        public TextView rss2;
        public TextView rss3;
        public TextView rss4;
        public TextView rss5;
        public TextView rss6;
        public TextView rss7;
        public TextView rss8;
        public TextView rss9;

        public ImageView rss_img1;
        public ImageView rss_img2;
        public ImageView rss_img3;
        public ImageView rss_img4;
        public ImageView rss_img5;
        public ImageView rss_img6;
        public ImageView rss_img7;
        public ImageView rss_img8;
        public ImageView rss_img9;

        public ListView listView;
        public ArrayAdapter<String> adapter;
        public ArrayList<String> arrayList;

        public ImageView upgrade;


        public ViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);


            Name_TV = itemView.findViewById(R.id.troop_name_full);
            // Lvl_TV = itemView.findViewById(R.id.building_lvl);
            Type_IMG = itemView.findViewById(R.id.troop_ico);
            rss1	 = itemView.findViewById(R.id.	rss_tv1	);
            rss2	 = itemView.findViewById(R.id.	rss_tv2	);
            rss3	 = itemView.findViewById(R.id.troop_tv1);
            rss4	 = itemView.findViewById(R.id.troop_tv2);
            rss5	 = itemView.findViewById(R.id.troop_tv3);
            rss6	 = itemView.findViewById(R.id.	rss_tv6	);
            rss7	 = itemView.findViewById(R.id.	rss_tv7	);
            rss8	 = itemView.findViewById(R.id.	rss_tv8	);
            rss9	 = itemView.findViewById(R.id.	rss_tv9	);
            rss_img1	 = itemView.findViewById(R.id.	rss_ic1	);
            rss_img2	 = itemView.findViewById(R.id.	rss_ic2	);
            rss_img3	 = itemView.findViewById(R.id.troop_ic1);
            rss_img4	 = itemView.findViewById(R.id.troop_ic2);
            rss_img5	 = itemView.findViewById(R.id.troop_ic3);
            rss_img6	 = itemView.findViewById(R.id.	rss_ic6	);
            rss_img7	 = itemView.findViewById(R.id.	rss_ic7	);
            rss_img8	 = itemView.findViewById(R.id.	rss_ic8	);
            rss_img9	 = itemView.findViewById(R.id.	rss_ic9	);
            upgrade	 = itemView.findViewById(R.id.	upgrade_ico	);
            listView = itemView.findViewById(R.id.listView);
            arrayList = new ArrayList<String>();
            adapter = new ArrayAdapter<String>(context.getApplicationContext(), R.layout.list_tv, arrayList);
            listView.setAdapter(adapter);
            /*
            itemView.setOnClickListener(new View.OnClickListener() {
                Intent intent = new Intent();
                Information hw = new Information();
                String url = hw.getLink();
                @Override
                public void onClick(View view) {

                    String link = String.valueOf(Link_TV.getText());
                    String name = String.valueOf(Name_TV.getText());
                    Intent intent = new Intent(context, ReadActivity.class);
                    intent.putExtra("Link", link);
                    intent.putExtra("Name", name);
                    intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                    Log.i("LINK", link);
                    Log.i("NAME", name);
                      });
             */


        }
    }
    public String prettyCount(Number number) {
        char[] suffix = {' ', 'K', 'M', 'G', 'T', 'P', 'E', 'Z', 'Y'};
        long numValue = number.longValue();
        int value = (int) Math.floor(Math.log10(numValue));
        int base = value / 3;
        SharedPreferences sharedPreferences = context.getSharedPreferences("user_info", Context.MODE_PRIVATE);
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
    public void filterList(List<Building> filteredList) {
        buildingList = filteredList;
        notifyDataSetChanged();
    }
}