package voc.net.tools.zgirls_tool.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import voc.net.tools.zgirls_tool.R;

/**
 * Created by Voc on 27/10/17.
 */


public class TroopAdapter extends RecyclerView.Adapter<TroopAdapter.ViewHolder> {
    public int[] troopIMG = {R.drawable.hs_mili01,	R.drawable.hs_mili02,	R.drawable.hs_mili03,	R.drawable.hs_mili04,	R.drawable.hs_mili05,	R.drawable.hs_mili06,	R.drawable.hs_mili07,	R.drawable.hs_mili08,	R.drawable.hs_mili09,	R.drawable.hs_mili10,	R.drawable.hs_mobile01,	R.drawable.hs_mobile02,	R.drawable.hs_mobile03,	R.drawable.hs_mobile04,	R.drawable.hs_mobile05,	R.drawable.hs_mobile06,	R.drawable.hs_mobile07,	R.drawable.hs_mobile08,	R.drawable.hs_mobile09,	R.drawable.hs_mobile10,	R.drawable.hs_arm01,	R.drawable.hs_arm02,	R.drawable.hs_arm03,	R.drawable.hs_arm04,	R.drawable.hs_arm05,	R.drawable.hs_arm06,	R.drawable.hs_arm07,	R.drawable.hs_arm08,	R.drawable.hs_arm09,	R.drawable.hs_arm10,	R.drawable.hs_infect01,	R.drawable.hs_infect02,	R.drawable.hs_infect03,	R.drawable.hs_infect04,	R.drawable.hs_infect05,	R.drawable.hs_infect06,	R.drawable.hs_infect07,	R.drawable.hs_infect08,	R.drawable.hs_infect09,	R.drawable.hs_infect10,	R.drawable.hs_project01,	R.drawable.hs_project02,	R.drawable.hs_project03,	R.drawable.hs_project04,	R.drawable.hs_project05,	R.drawable.hs_project06,	R.drawable.hs_project07,	R.drawable.hs_project08,	R.drawable.hs_project09,	R.drawable.hs_project10};
    public int[] troopName = {R.string.mili_1,	R.string.mili_2,	R.string.mili_3,	R.string.mili_4,	R.string.mili_5,	R.string.mili_6,	R.string.mili_7,	R.string.mili_8,	R.string.mili_9,	R.string.mili_10,	R.string.mobile_1,	R.string.mobile_2,	R.string.mobile_3,	R.string.mobile_4,	R.string.mobile_5,	R.string.mobile_6,	R.string.mobile_7,	R.string.mobile_8,	R.string.mobile_9,	R.string.mobile_10,	R.string.arm_1,	R.string.arm_2,	R.string.arm_3,	R.string.arm_4,	R.string.arm_5,	R.string.arm_6,	R.string.arm_7,	R.string.arm_8,	R.string.arm_9,	R.string.arm_10,	R.string.infect_1,	R.string.infect_2,	R.string.infect_3,	R.string.infect_4,	R.string.infect_5,	R.string.infect_6,	R.string.infect_7,	R.string.infect_8,	R.string.infect_9,	R.string.infect_10,	R.string.proj_1,	R.string.proj_2,	R.string.proj_3,	R.string.proj_4,	R.string.proj_5,	R.string.proj_6,	R.string.proj_7,	R.string.proj_8,	R.string.proj_9,	R.string.proj_10};

    private Context context;
    private List<Troops> TroopList;
    private AdapterView.OnItemClickListener mListener;

    long total , in_sch , out_sch;
    int Id;
    String name;

    public TroopAdapter(Context context, List<Troops> TroopList) {
        this.context = context;
        this.TroopList = TroopList;

    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.troop_item, parent, false);
        ViewHolder evh = new ViewHolder(v, (OnItemClickListener) mListener);

        return evh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        prettyCount prettyCount = new prettyCount();
        Troops troops = TroopList.get(position);
        total = 0;
        Id = troops.getId();
        in_sch = 0;
        out_sch = 0;

        holder.Name_TV.setText(context.getString(troopName[Id]));
        holder.IN_TV.setText(prettyCount.pretty(troops.getIn_sch(),context));
        holder.OUT_TV.setText(prettyCount.pretty(troops.getOut_sch(),context));
        holder.Total_TV.setText(prettyCount.pretty(troops.getTotal(),context));
        holder.Id_IMG.setImageResource(troopIMG[Id]);
    }

    @Override
    public int getItemCount() {
        return TroopList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Name_TV;
        public TextView Total_TV;
        public TextView IN_TV;
        public TextView OUT_TV;
        public ImageView Id_IMG;
        public LinearLayout bg;

        public ListView listView;
        public ArrayAdapter<String> adapter;
        public ArrayList<String> arrayList;


        public ViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);


            Name_TV = itemView.findViewById(R.id.troop_name_full);
            Id_IMG = itemView.findViewById(R.id.troop_ico);
            Total_TV = itemView.findViewById(R.id.troop_tv1);
            IN_TV = itemView.findViewById(R.id.troop_tv2);
            OUT_TV = itemView.findViewById(R.id.troop_tv3);

    }
    }
    public void filterList(List<Troops> filteredList) {
        TroopList = filteredList;
        notifyDataSetChanged();
    }
}