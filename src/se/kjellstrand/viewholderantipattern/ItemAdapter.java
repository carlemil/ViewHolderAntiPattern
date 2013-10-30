package se.kjellstrand.viewholderantipattern;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by Carl-Emil Kjellstrand on 10/25/13.
 */
public class ItemAdapter extends BaseAdapter {

    private final Context mContext;

    private int count = 256;

    public ItemAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        HolderView holderView;
        if (convertView instanceof HolderView) {
            holderView = (HolderView) convertView;
        } else {
            holderView = new HolderView(mContext);
            holderView.initlialize(viewGroup);
        }
        holderView.setValues(i);

        return holderView;
    }
}
