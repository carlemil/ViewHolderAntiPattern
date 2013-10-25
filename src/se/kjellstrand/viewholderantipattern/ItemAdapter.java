package se.kjellstrand.viewholderantipattern;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by erbsman on 7/25/13.
 */
public class ItemAdapter extends BaseAdapter {

    private final Context mContext;

    private String data[];

    public ItemAdapter(Context context) {
        mContext = context;
        data = mContext.getResources().getStringArray(R.array.string_array);
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int i) {
        if (i > getCount()) {
            return data[i];
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_detail, viewGroup, false);
        }

        Holder h = Holder.get(convertView);
        h.title.setText(data[i]);

        return convertView;
    }

    private static final class Holder {
        public TextView title;

        private Holder(View v) {
            title = (TextView) v.findViewById(R.id.list_detail_title);
            v.setTag(this);
        }

        public static Holder get(View v) {
            if (v.getTag() instanceof Holder) {
                return (Holder) v.getTag();
            }
            return new Holder(v);
        }
    }

}
