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
        h.mDigit.setText(String.format(digit_text, digit));

        String digit_oct_text = mContext.getResources().getString(R.string.list_detail_digit_oct);
        h.mDigitOct.setText(String.format(digit_oct_text, Integer.toOctalString(digit)));

        String digit_hex_text = mContext.getResources().getString(R.string.list_detail_digit_hex);
        h.mDigitHex.setText(String.format(digit_hex_text, Integer.toHexString(digit)));

        String digit_even_text = mContext.getResources().getString(R.string.list_detail_digit_even);
        String digit_even = digit % 2 == 0 ? "true" : "false";
        h.mDigitEven.setText(String.format(digit_even_text, digit_even));

        String digit_primt_text = mContext.getResources().getString(R.string.list_detail_digit_prime);
        h.mDigitPrime.setText(String.format(digit_primt_text, !new String(new char[digit]).matches(".?|(..+?)\\1+")));

        String mDigitFibonacciText = mContext.getResources().getString(R.string.list_detail_digit_fibonacci);
        h.mDigitFibonacci.setText(String.format(mDigitFibonacciText,
                ((Math.sqrt(5 * Math.pow((digit), 2) + 4) - Math.round(Math.sqrt(5 * Math.pow((digit), 2) + 4)) == 0) ||
                (Math.sqrt(5 * Math.pow((digit), 2) - 4) - Math.round(Math.sqrt(5 * Math.pow((digit), 2) - 4)) == 0))));

        return convertView;
    }

    private static final class Holder {
        public TextView mDigit;
        public TextView mDigitOct;
        public TextView mDigitHex;
        public TextView mDigitEven;
        public TextView mDigitPrime;
        public TextView mDigitFibonacci;

        private Holder(View v) {
            mDigit = (TextView) v.findViewById(R.id.list_detail_digit);
            mDigitOct = (TextView) v.findViewById(R.id.list_detail_digit_oct);
            mDigitHex = (TextView) v.findViewById(R.id.list_detail_digit_hex);
            mDigitEven = (TextView) v.findViewById(R.id.list_detail_digit_even);
            mDigitPrime = (TextView) v.findViewById(R.id.list_detail_digit_prime);
            mDigitFibonacci = (TextView) v.findViewById(R.id.list_detail_digit_fibonacci);

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
