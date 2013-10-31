package se.kjellstrand.viewholderantipattern;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

/**
 * Created by Carl-Emil Kjellstrand on 10/30/13.
 */
public class HolderView extends GridLayout {

    private Context mContext;
    private TextView mDigitDigit;
    private TextView mDigitEven;
    private TextView mDigitPrime;
    private TextView mDigitHex;

    private String mDigitText;
    private String mDigitEvenText;
    private String mDigitPrimtText;
    private String mDigitHexText;

    public HolderView(Context context) {
        super(context);
        mContext = context;
        initlialize();
    }

    public HolderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initlialize();
    }

    public HolderView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        initlialize();
    }

    public void initlialize() {
        View v = LayoutInflater.from(mContext).inflate(R.layout.list_detail, this);
        mDigitDigit = (TextView) v.findViewById(R.id.list_detail_digit);
        mDigitEven = (TextView) v.findViewById(R.id.list_detail_digit_even);
        mDigitPrime = (TextView) v.findViewById(R.id.list_detail_digit_prime);
        mDigitHex = (TextView) v.findViewById(R.id.list_detail_digit_hex);

        mDigitText = mContext.getResources().getString(R.string.list_detail_digit);
        mDigitEvenText = mContext.getResources().getString(R.string.list_detail_digit_even);
        mDigitPrimtText = mContext.getResources().getString(R.string.list_detail_digit_prime);
        mDigitHexText = mContext.getResources().getString(R.string.list_detail_digit_hex);
    }

    public void bind(int digit) {
        Log.d("TAG", "bind");
        mDigitDigit.setText(String.format(mDigitText, digit));
        mDigitEven.setText(String.format(mDigitEvenText, digit % 2 == 0 ? "true" : "false"));
        mDigitPrime.setText(String.format(mDigitPrimtText, !new String(new char[digit]).matches(".?|(..+?)\\1+")));
        mDigitHex.setText(String.format(mDigitHexText, Integer.toHexString(digit)));
    }

}
