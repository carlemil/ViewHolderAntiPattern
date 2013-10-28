package se.kjellstrand.viewholderantipattern;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_detail, viewGroup, false);
        }

        int digit = i;

        Holder h = Holder.get(convertView);
        String digit_text = mContext.getResources().getString(R.string.list_detail_digit);
        h.digit.setText(String.format(digit_text, digit));

        String digit_even_text = mContext.getResources().getString(R.string.list_detail_digit_even);
        String digit_even = digit % 2 == 0 ? "true" : "false";
        h.digit_even.setText(String.format(digit_even_text, digit_even));

        String digit_primt_text = mContext.getResources().getString(R.string.list_detail_digit_prime);
        h.digit_prime.setText(String.format(digit_primt_text, !new String(new char[digit]).matches(".?|(..+?)\\1+")));

        String digit_hex_text = mContext.getResources().getString(R.string.list_detail_digit_hex);
        h.digit_hex.setText(String.format(digit_hex_text, Integer.toHexString(digit)));

        return convertView;
    }

    private static final class Holder {
        public TextView digit;
        public TextView digit_even;
        public TextView digit_prime;
        public TextView digit_hex;

        private Holder(View v) {
            digit = (TextView) v.findViewById(R.id.list_detail_digit);
            digit_even = (TextView) v.findViewById(R.id.list_detail_digit_even);
            digit_prime = (TextView) v.findViewById(R.id.list_detail_digit_prime);
            digit_hex = (TextView) v.findViewById(R.id.list_detail_digit_hex);

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
