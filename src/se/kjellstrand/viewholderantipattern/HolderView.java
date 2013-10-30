package se.kjellstrand.viewholderantipattern;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Carl-Emil Kjellstrand on 10/30/13.
 */
public class HolderView extends View {

    private Context mContext;
    private TextView mDigitDigit;
    private TextView mDigitEven;
    private TextView mDigitPrime;
    private TextView mDigitHex;

    public HolderView(Context context) {
        super(context);
        mContext = context;
    }

    public HolderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public HolderView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
    }

    public void initlialize(ViewGroup viewGroup) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.list_detail, viewGroup, false);
        mDigitDigit = (TextView) v.findViewById(R.id.list_detail_digit);
        mDigitEven = (TextView) v.findViewById(R.id.list_detail_digit_even);
        mDigitPrime = (TextView) v.findViewById(R.id.list_detail_digit_prime);
        mDigitHex = (TextView) v.findViewById(R.id.list_detail_digit_hex);
    }

    public void setValues(int digit) {
        String digit_text = mContext.getResources().getString(R.string.list_detail_digit);
        mDigitDigit.setText(String.format(digit_text, digit));

        String digit_even_text = mContext.getResources().getString(R.string.list_detail_digit_even);
        String digit_even = digit % 2 == 0 ? "true" : "false";
        mDigitEven.setText(String.format(digit_even_text, digit_even));

        String digit_primt_text = mContext.getResources().getString(R.string.list_detail_digit_prime);
        mDigitPrime.setText(String.format(digit_primt_text, !new String(new char[digit]).matches(".?|(..+?)\\1+")));

        String digit_hex_text = mContext.getResources().getString(R.string.list_detail_digit_hex);
        mDigitHex.setText(String.format(digit_hex_text, Integer.toHexString(digit)));
    }

}
