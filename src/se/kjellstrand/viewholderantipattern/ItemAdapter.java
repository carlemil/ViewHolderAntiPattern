package se.kjellstrand.viewholderantipattern;

import se.kjellstrand.viewholderantipattern.data.Digit;

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
        // Important to not just null check, but rather to a instanceof
        // since we might get any subclass of view here.
        if (convertView instanceof HolderView) {
            holderView = (HolderView) convertView;
        } else {
            holderView = new HolderView(mContext);
        }
        holderView.bind(new Digit(i));

        return holderView;
    }
}
