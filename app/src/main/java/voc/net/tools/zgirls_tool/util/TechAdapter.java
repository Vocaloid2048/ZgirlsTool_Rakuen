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


public class TechAdapter extends RecyclerView.Adapter<TechAdapter.ViewHolder> {
    public int[] techBuff = {R.string.tech_buff1,	R.string.tech_buff2,	R.string.tech_buff3,	R.string.tech_buff4,	R.string.tech_buff5,	R.string.tech_buff6,	R.string.tech_buff7,	R.string.tech_buff8,	R.string.tech_buff9,	R.string.tech_buff10,	R.string.tech_buff11,	R.string.tech_buff12,	R.string.tech_buff13,	R.string.tech_buff14,	R.string.tech_buff15,	R.string.tech_buff16,	R.string.tech_buff17,	R.string.tech_buff18,	R.string.tech_buff19,	R.string.tech_buff20,	R.string.tech_buff21,	R.string.tech_buff22,	R.string.tech_buff23,	R.string.tech_buff24,	R.string.tech_buff25,	R.string.tech_buff26,	R.string.tech_buff27,	R.string.tech_buff28,	R.string.tech_buff29,	R.string.tech_buff30,	R.string.tech_buff31,	R.string.tech_buff32,	R.string.tech_buff33,	R.string.tech_buff34,	R.string.tech_buff35,	R.string.tech_buff36,	R.string.tech_buff37,	R.string.tech_buff38,	R.string.tech_buff39,	R.string.tech_buff40,	R.string.tech_buff41,	R.string.tech_buff42,	R.string.tech_buff43,	R.string.tech_buff44,	R.string.tech_buff45,	R.string.tech_buff46,	R.string.tech_buff47,	R.string.tech_buff48,	R.string.tech_buff49,	R.string.tech_buff50,	R.string.tech_buff51,	R.string.tech_buff52,	R.string.tech_buff53,	R.string.tech_buff54,	R.string.tech_buff55,	R.string.tech_buff56,	R.string.tech_buff57,	R.string.tech_buff58,	R.string.tech_buff59,	R.string.tech_buff60,	R.string.tech_buff61,	R.string.tech_buff62,	R.string.tech_buff63,	R.string.tech_buff64,	R.string.tech_buff65,	R.string.tech_buff66,	R.string.tech_buff67,	R.string.tech_buff68,	R.string.tech_buff69,	R.string.tech_buff70,	R.string.tech_buff71,	R.string.tech_buff72,	R.string.tech_buff73,	R.string.tech_buff74,	R.string.tech_buff75,	R.string.tech_buff76,	R.string.tech_buff77,	R.string.tech_buff78,	R.string.tech_buff79,	R.string.tech_buff80,	R.string.tech_buff81,	R.string.tech_buff82,	R.string.tech_buff83,	R.string.tech_buff84,	R.string.tech_buff85,	R.string.tech_buff86,	R.string.tech_buff87};
    public int[] techIMG = {R.drawable.science_res_a_2,R.drawable.science_res_a_3,R.drawable.science_res_a_4,R.drawable.science_res_a_5,R.drawable.science_res_a_6,R.drawable.science_res_a_7,R.drawable.science_res_a_8,R.drawable.science_res_a_9,R.drawable.science_res_a_10,R.drawable.science_res_a_11,R.drawable.science_res_a_2,R.drawable.science_res_a_3,R.drawable.science_res_a_4,R.drawable.science_res_a_5,R.drawable.science_res_a_6,R.drawable.science_res_a_7,R.drawable.science_res_a_8,R.drawable.science_res_a_9,R.drawable.science_res_a_10,R.drawable.science_res_a_11,R.drawable.science_dev_a_1,R.drawable.science_dev_a_6,R.drawable.science_dev_a_7,R.drawable.science_dev_a_2,R.drawable.science_dev_a_4,R.drawable.science_dev_a_5,R.drawable.science_dev_a_3,R.drawable.science_dev_a_6,R.drawable.science_dev_a_7,R.drawable.science_dev_a_1,R.drawable.science_dev_a_2,R.drawable.science_dev_a_4,R.drawable.science_dev_a_5,R.drawable.science_dev_a_3,R.drawable.science_def_a_1,R.drawable.science_def_a_2,R.drawable.science_def_a_3,R.drawable.science_def_a_4,R.drawable.science_def_a_7,R.drawable.science_def_a_5,R.drawable.science_def_a_6,R.drawable.science_def_a_8,R.drawable.science_def_a_9,R.drawable.science_def_a_10,R.drawable.science_def_a_1,R.drawable.science_def_a_2,R.drawable.science_def_a_3,R.drawable.science_def_a_5,R.drawable.science_def_a_6,R.drawable.science_def_a_7,R.drawable.science_def_a_8,R.drawable.science_def_a_9,R.drawable.science_mil_a_1,R.drawable.science_mil_a_2,R.drawable.science_mil_a_3,R.drawable.science_mil_a_4,R.drawable.science_mil_a_6,R.drawable.science_mil_a_7,R.drawable.science_mil_a_8,R.drawable.science_mil_a_9,R.drawable.science_mil_a_11,R.drawable.science_mil_a_12,R.drawable.science_mil_a_13,R.drawable.science_mil_a_14,R.drawable.science_mil_a_16,R.drawable.science_mil_a_11,R.drawable.science_mil_a_2,R.drawable.science_mil_a_3,R.drawable.science_mil_a_4,R.drawable.science_mil_a_1,R.drawable.science_mil_a_7,R.drawable.science_mil_a_8,R.drawable.science_mil_a_9,R.drawable.science_mil_a_6,R.drawable.science_mil_a_12,R.drawable.science_mil_a_13,R.drawable.science_mil_a_14,R.drawable.science_mil_a_16,R.drawable.science_mil_a_11,R.drawable.science_mil_a_2,R.drawable.science_mil_a_3,R.drawable.science_mil_a_4,R.drawable.science_mil_a_1,R.drawable.science_mil_a_7,R.drawable.science_mil_a_8,R.drawable.science_mil_a_9,R.drawable.science_mil_a_6,R.drawable.science_mil_a_12,R.drawable.science_mil_a_13,R.drawable.science_mil_a_14,R.drawable.science_mil_a_16,R.drawable.science_fit_a_1,R.drawable.science_fit_a_2,R.drawable.science_fit_a_6,R.drawable.science_fit_a_3,R.drawable.science_fit_a_4,R.drawable.science_fit_a_7,R.drawable.science_fit_a_8,R.drawable.science_fit_a_5,R.drawable.science_fit_a_9,R.drawable.science_fit_a_10,R.drawable.science_fit_a_11,R.drawable.science_fit_a_12,R.drawable.science_fit_a_13,R.drawable.science_fit_a_17,R.drawable.science_fit_a_14,R.drawable.science_fit_a_15,R.drawable.science_fit_a_16,R.drawable.science_fit_a_17,R.drawable.science_fit_a_18,R.drawable.science_deaf_a_1,R.drawable.science_deaf_a_2,R.drawable.science_deaf_a_11,R.drawable.science_deaf_a_3,R.drawable.science_deaf_a_4,R.drawable.science_deaf_a_12,R.drawable.science_deaf_a_13,R.drawable.science_deaf_a_9,R.drawable.science_deaf_a_14,R.drawable.science_deaf_a_10,R.drawable.science_deaf_a_14,R.drawable.science_deaf_a_7,R.drawable.science_deaf_a_8,R.drawable.science_deaf_a_15,R.drawable.science_deaf_a_9,R.drawable.science_deaf_a_16,R.drawable.science_deaf_a_17,R.drawable.science_zombie_9,R.drawable.science_zombie_2,R.drawable.science_zombie_1,R.drawable.science_zombie_11,R.drawable.science_zombie_10,R.drawable.science_zombie_8,R.drawable.science_zombie_4,R.drawable.science_zombie_5,R.drawable.science_zombie_6,R.drawable.science_zombie_7,R.drawable.science_zombie_3};
    public int[] techName = {R.string.tech_r1,	R.string.tech_r2,	R.string.tech_r3,	R.string.tech_r4,	R.string.tech_r5,	R.string.tech_r6,	R.string.tech_r7,	R.string.tech_r8,	R.string.tech_r9,	R.string.tech_r10,	R.string.tech_r11,	R.string.tech_r12,	R.string.tech_r13,	R.string.tech_r14,	R.string.tech_r15,	R.string.tech_r16,	R.string.tech_r17,	R.string.tech_r18,	R.string.tech_r19,	R.string.tech_r20,	R.string.tech_r21,	R.string.tech_r22,	R.string.tech_r23,	R.string.tech_r24,	R.string.tech_r25,	R.string.tech_r26,	R.string.tech_r27,	R.string.tech_r28,	R.string.tech_r29,	R.string.tech_r30,	R.string.tech_r31,	R.string.tech_r32,	R.string.tech_r33,	R.string.tech_r34,	R.string.tech_r35,	R.string.tech_r36,	R.string.tech_r37,	R.string.tech_r38,	R.string.tech_r39,	R.string.tech_r40,	R.string.tech_r41,	R.string.tech_r42,	R.string.tech_r43,	R.string.tech_r44,	R.string.tech_r45,	R.string.tech_r46,	R.string.tech_r47,	R.string.tech_r48,	R.string.tech_r49,	R.string.tech_r50,	R.string.tech_r51,	R.string.tech_r52,	R.string.tech_r53,	R.string.tech_r54,	R.string.tech_r55,	R.string.tech_r56,	R.string.tech_r57,	R.string.tech_r58,	R.string.tech_r59,	R.string.tech_r60,	R.string.tech_r61,	R.string.tech_r62,	R.string.tech_r63,	R.string.tech_r64,	R.string.tech_r65,	R.string.tech_r66,	R.string.tech_r67,	R.string.tech_r68,	R.string.tech_r69,	R.string.tech_r70,	R.string.tech_r71,	R.string.tech_r72,	R.string.tech_r73,	R.string.tech_r74,	R.string.tech_r75,	R.string.tech_r76,	R.string.tech_r77,	R.string.tech_r78,	R.string.tech_r79,	R.string.tech_r80,	R.string.tech_r81,	R.string.tech_r82,	R.string.tech_r83,	R.string.tech_r84,	R.string.tech_r85,	R.string.tech_r86,	R.string.tech_r87,	R.string.tech_r88,	R.string.tech_r89,	R.string.tech_r90,	R.string.tech_r91,	R.string.tech_r92,	R.string.tech_r93,	R.string.tech_r94,	R.string.tech_r95,	R.string.tech_r96,	R.string.tech_r97,	R.string.tech_r98,	R.string.tech_r99,	R.string.tech_r100,	R.string.tech_r101,	R.string.tech_r102,	R.string.tech_r103,	R.string.tech_r104,	R.string.tech_r105,	R.string.tech_r106,	R.string.tech_r107,	R.string.tech_r108,	R.string.tech_r109,	R.string.tech_r110,	R.string.tech_r111,	R.string.tech_r112,	R.string.tech_r113,	R.string.tech_r114,	R.string.tech_r115,	R.string.tech_r116,	R.string.tech_r117,	R.string.tech_r118,	R.string.tech_r119,	R.string.tech_r120,	R.string.tech_r121,	R.string.tech_r122,	R.string.tech_r123,	R.string.tech_r124,	R.string.tech_r125,	R.string.tech_r126,	R.string.tech_r127,	R.string.tech_r128,	R.string.tech_r129,	R.string.tech_r130,	R.string.tech_r131,	R.string.tech_r132,	R.string.tech_r133,	R.string.tech_r134,	R.string.tech_r135,	R.string.tech_r136,	R.string.tech_r137,	R.string.tech_r138};
    private Context context;
    private List<Tech> TechList;
    private AdapterView.OnItemClickListener mListener;
    long buff = 0;
    int buffId = 0;
    int Id;
    String name;

    public TechAdapter(Context context, List<Tech> TechList) {
        this.context = context;
        this.TechList = TechList;

    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tech_item, parent, false);
        ViewHolder evh = new ViewHolder(v, (OnItemClickListener) mListener);

        return evh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        prettyCount prettyCount = new prettyCount();
        Tech troops = TechList.get(position);
        Id = troops.getId();
        buff = troops.getBuff();
        buffId = troops.getBuffId();

        holder.Name_TV.setText(context.getString(techName[Id]));
        holder.Lvl_TV.setText(context.getString(R.string.level)+" "+String.valueOf(troops.getLvl()));
        holder.Buff_TV.setText(context.getString(techBuff[buffId])+" : "+prettyCount.pretty(buff,context));
        holder.Id_IMG.setImageResource(techIMG[Id]);
    }

    @Override
    public int getItemCount() {
        return TechList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Name_TV;
        public TextView Lvl_TV;
        public TextView Buff_TV;
        public ImageView Id_IMG;
        public LinearLayout bg;

        public ListView listView;
        public ArrayAdapter<String> adapter;
        public ArrayList<String> arrayList;


        public ViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);


            Name_TV = itemView.findViewById(R.id.troop_name_full);
            Lvl_TV = itemView.findViewById(R.id.troop_tv1);
            Buff_TV = itemView.findViewById(R.id.troop_tv2);
            Id_IMG = itemView.findViewById(R.id.troop_ico);

    }
    }
    public void filterList(List<Tech> filteredList) {
        TechList = filteredList;
        notifyDataSetChanged();
    }
}