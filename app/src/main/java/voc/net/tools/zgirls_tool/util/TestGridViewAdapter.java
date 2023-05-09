package voc.net.tools.zgirls_tool.util;

import android.content.Context;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import voc.net.tools.zgirls_tool.R;

public class TestGridViewAdapter extends BaseDragAdapter {

    private Context context;
    private int resourceId;
    private ArrayList<String> list;

    private Vibrator vibrator;

    private OnItemLongClickListener listener;

    public TestGridViewAdapter(Context context, int resourceId, ArrayList<String> list) {
        this.context = context;
        this.resourceId = resourceId;
        this.list = list;
        this.vibrator = (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);
    }

    @Override
    public List getDataList() {
        return list;
    }

    @Override
    public boolean isDragAvailable(int position) {
        return true;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.itemLayout = view.findViewById(R.id.item_layout);
            viewHolder.contentTextView = view.findViewById(R.id.content_textview);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.contentTextView.setText(list.get(position));

        viewHolder.itemLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                vibrator.vibrate(100);

                if (listener != null) {
                    listener.onItemLongClick(position);
                }

                return false;
            }
        });

        return view;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemLongClickListener {

        void onItemLongClick(int position);

    }

    class ViewHolder {
        LinearLayout itemLayout;
        TextView contentTextView;
    }
}