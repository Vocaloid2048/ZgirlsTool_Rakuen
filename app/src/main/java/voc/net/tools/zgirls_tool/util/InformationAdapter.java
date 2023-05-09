package voc.net.tools.zgirls_tool.util;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import voc.net.tools.zgirls_tool.R;
import voc.net.tools.zgirls_tool.ui.ReadActivity;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * Created by ankit on 27/10/17.
 */

public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.ViewHolder> {

    private Context context;
    private List<Information> informationList;
    private AdapterView.OnItemClickListener mListener;
    private WebView webView ;


    public InformationAdapter(Context context, List<Information> informationList) {
        this.context = context;
        this.informationList = informationList;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent, false);
        ViewHolder evh = new ViewHolder(v, (OnItemClickListener) mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Information Information = informationList.get(position);

        holder.Name_TV.setText(Information.getName());
        holder.Type_TV.setText(Information.getType());
        holder.Date_TV.setText(Information.getDate());
        holder.Author_TV.setText(context.getString(R.string.author)+ Information.getAuthor());
        holder.Link_TV.setText(Information.getLink());

        String type = String.valueOf(holder.Type_TV.getText());
        if (type.equals("Facilities")){
            holder.Type_IMG.setBackgroundResource(R.drawable.tb_canon);
    //        holder.bg.setBackgroundResource(R.drawable.building_banner);
            holder.Type_TV.setText(R.string.tb_facilities);
        }else if (type.equals("School")){
            holder.Type_IMG.setBackgroundResource(R.drawable.build_tb);
      //      holder.bg.setBackgroundResource(R.drawable.deads_banner);
            holder.Type_TV.setText(R.string.tb_school);
        }else if (type.equals("Enabler")) {
            holder.Type_IMG.setBackgroundResource(R.drawable.app_icon_round);
    //        holder.bg.setBackgroundResource(R.drawable.enable_banner);
            holder.Type_TV.setText(R.string.tb_enabler);
        }else if (type.equals("Events")){
            holder.Type_IMG.setBackgroundResource(R.drawable.events);
   //         holder.bg.setBackgroundResource(R.drawable.events_banner);
            holder.Type_TV.setText(R.string.tb_events);
        }else if (type.equals("Mecha")){
            holder.Type_IMG.setBackgroundResource(R.drawable.mecha);
   //         holder.bg.setBackgroundResource(R.drawable.mecha_banner);
            holder.Type_TV.setText(R.string.tb_mechas);
        }else if (type.equals("Troops")){
            holder.Type_IMG.setBackgroundResource(R.drawable.troops);
  //          holder.bg.setBackgroundResource(R.drawable.troops_banner);
            holder.Type_TV.setText(R.string.tb_troops);
        }


       // if (Information.getSubject().equals("CH")){holder.Subject_TV.setTextColor(Color.parseColor("#FF0000"));}


       // if (Information.getSubject().equals("CH")){holder.bg.setBackgroundResource(R.drawable.img_kayaking_ch);}
    }

    @Override
    public int getItemCount() {
        return informationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Name_TV, Type_TV, Date_TV,Author_TV,Link_TV;
        public ImageView Type_IMG;
        public LinearLayout bg;


        public ViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);


            Name_TV = itemView.findViewById(R.id.name_tv);
            Type_TV = itemView.findViewById(R.id.type_tv);
            Date_TV = itemView.findViewById(R.id.date_tv);
            Author_TV = itemView.findViewById(R.id.author_tv);
            Link_TV = itemView.findViewById(R.id.link_tv);
            Type_IMG = itemView.findViewById(R.id.type_img);
            bg = itemView.findViewById(R.id.bg);

            itemView.setOnClickListener(new View.OnClickListener() {
                Intent intent = new Intent();
                Information hw = new Information();
                String url = hw.getLink();
                @Override
                public void onClick(View view) {

                    String link = String.valueOf(Link_TV.getText());
                    String name = String.valueOf(Name_TV.getText());
                    Intent intent = new Intent(context, ReadActivity.class);
                    intent.putExtra("Link",link);
                    intent.putExtra("Name",name);
                    intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                    Log.i("LINK",link);
                    Log.i("NAME",name);

                /*    SharedPreferences sharedPreferences= context.getSharedPreferences("HW", Activity.MODE_PRIVATE);
// 使用getString方法获得value，注意第2个参数是value的默认值
                    HW_Click_Num =sharedPreferences.getInt("click_hw", 0);
                    HW_Click_Num = HW_Click_Num+1;
                    SharedPreferences sharedPreferences2 = context.getSharedPreferences("HW", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences2.edit();//获取编辑器
                    editor.putInt("click_hw", HW_Click_Num);
                    editor.commit();//提交修改
                    Log.i("HW_Click", String.valueOf(HW_Click_Num));

                    String format = String.valueOf(Format_TV.getText());
                    if (format.equals("DOCX")){
                        Intent intent = new Intent(context, DocxReader.class);
                        String link = String.valueOf(Down_link_TV.getText());
                        String size_s = String.valueOf(Size_TV_N.getText());
                        String name_s = String.valueOf(Name_TV.getText());
                        String format_s = String.valueOf(Format_TV.getText());
                        String give_date_s = String.valueOf(Give_date_TV.getText());
                        String sub_date_s = String.valueOf(Sub_date_TV.getText());
                        String subject_s = String.valueOf(Subject_TV.getText());
                        intent.putExtra("Link",link);
                        intent.putExtra("Size",size_s);
                        intent.putExtra("Name",name_s);
                        intent.putExtra("Format",format_s);
                        intent.putExtra("Sub_date",sub_date_s);
                        intent.putExtra("Subject",subject_s);
                        intent.putExtra("Give_date",give_date_s);
                        intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        Log.i("LINK",link);
                    }
                    else if (format.equals("PNG")){
                        Intent intent = new Intent(context, PNGReader.class);
                        String link = String.valueOf(Down_link_TV.getText());
                        String size_s = String.valueOf(Size_TV_N.getText());
                        String name_s = String.valueOf(Name_TV.getText());
                        String format_s = String.valueOf(Format_TV.getText());
                        String give_date_s = String.valueOf(Give_date_TV.getText());
                        String sub_date_s = String.valueOf(Sub_date_TV.getText());
                        String subject_s = String.valueOf(Subject_TV.getText());
                        intent.putExtra("Link",link);
                        intent.putExtra("Size",size_s);
                        intent.putExtra("Name",name_s);
                        intent.putExtra("Format",format_s);
                        intent.putExtra("Sub_date",sub_date_s);
                        intent.putExtra("Subject",subject_s);
                        intent.putExtra("Give_date",give_date_s);
                        intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        Log.i("LINK",link);
                    }
                    else if (format.equals("PDF")){
                        Intent intent = new Intent(context, PDFReader.class);
                        String link = String.valueOf(Down_link_TV.getText());
                        String size_s = String.valueOf(Size_TV_N.getText());
                        String name_s = String.valueOf(Name_TV.getText());
                        String format_s = String.valueOf(Format_TV.getText());
                        String give_date_s = String.valueOf(Give_date_TV.getText());
                        String sub_date_s = String.valueOf(Sub_date_TV.getText());
                        String subject_s = String.valueOf(Subject_TV.getText());
                        intent.putExtra("Link",link);
                        intent.putExtra("Size",size_s);
                        intent.putExtra("Name",name_s);
                        intent.putExtra("Format",format_s);
                        intent.putExtra("Sub_date",sub_date_s);
                        intent.putExtra("Subject",subject_s);
                        intent.putExtra("Give_date",give_date_s);
                        intent.putExtra("Link",link);
                        intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        Log.i("LINK",link);
                    }
                    else if (format.equals("TXT")){
                        Toast.makeText(context, "沒有可查閱的檔案", Toast.LENGTH_SHORT).show();
                    }
                    */
                    //link = intent.getStringExtra("Link");
                }

        });
        }
    }
    public void filterList(List<Information> filteredList) {
        informationList = filteredList;
        notifyDataSetChanged();
    }
}