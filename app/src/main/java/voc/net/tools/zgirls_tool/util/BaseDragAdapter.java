package voc.net.tools.zgirls_tool.util;


import android.widget.BaseAdapter;

import java.util.Collections;
import java.util.List;

public abstract class BaseDragAdapter extends BaseAdapter {

    /**
     * 调用者需实现该方法，返回列表的所有数据集合
     *
     * @return
     */
    public abstract List getDataList();

    /**
     * 调用者可实现该方法自定义某一项是否可被拖动
     *
     * @param position
     * @return
     */
    public abstract boolean isDragAvailable(int position);

    /**
     * 实现数据交换方法
     *
     * @param oldPosition
     * @param newPosition
     */
    public void exchangeData(int oldPosition, int newPosition) {

        List list = getDataList();
        if (list == null) {
            return;
        }
        Object temp = list.get(oldPosition);
        if (oldPosition < newPosition) {
            for (int i = oldPosition; i < newPosition; i++) {
                Collections.swap(list, i, i + 1);
            }
        } else if (oldPosition > newPosition) {
            for (int i = oldPosition; i > newPosition; i--) {
                Collections.swap(list, i, i - 1);
            }
        }
        list.set(newPosition, temp);
    }
}