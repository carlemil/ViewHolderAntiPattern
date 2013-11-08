package se.kjellstrand.viewholderantipattern;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

/**
 * Created by Carl-Emil Kjellstrand on 10/30/13.
 */
public class HolderView extends GridLayout {

    private TextView mDigitDigit;
    private TextView mDigitHex;
    private TextView mDigitOct;

    private TextView mDigitEven;
    private TextView mDigitPrime;
    private TextView mDigitFibonacci;

    private String mDigitText;
    private String mDigitHexText;
    private String mDigitOctText;

    private String mDigitEvenText;
    private String mDigitPrimtText;
    private String mDigitFibonacciText;

    public HolderView(Context context) {
        super(context);
        initlialize(context);
    }

    public HolderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initlialize(context);
    }

    public HolderView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initlialize(context);
    }

    public void initlialize(Context context) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_detail, this);
        mDigitDigit = (TextView) v.findViewById(R.id.list_detail_digit);
        mDigitHex = (TextView) v.findViewById(R.id.list_detail_digit_hex);
        mDigitOct = (TextView) v.findViewById(R.id.list_detail_digit_oct);
        mDigitEven = (TextView) v.findViewById(R.id.list_detail_digit_even);
        mDigitPrime = (TextView) v.findViewById(R.id.list_detail_digit_prime);
        mDigitFibonacci = (TextView) v.findViewById(R.id.list_detail_digit_fibonacci);

        mDigitText = context.getResources().getString(R.string.list_detail_digit);
        mDigitHexText = context.getResources().getString(R.string.list_detail_digit_hex);
        mDigitOctText = context.getResources().getString(R.string.list_detail_digit_oct);
        mDigitEvenText = context.getResources().getString(R.string.list_detail_digit_even);
        mDigitPrimtText = context.getResources().getString(R.string.list_detail_digit_prime);
        mDigitFibonacciText = context.getResources().getString(R.string.list_detail_digit_fibonacci);
    }

    public void bind(Digit digit) {
        mDigitDigit.setText(String.format(mDigitText, digit));
        mDigitOct.setText(String.format(mDigitOctText, digit.toOctalString()));
        mDigitHex.setText(String.format(mDigitHexText, digit.toHexString()));

        mDigitEven.setText(String.format(mDigitEvenText, digit.isEven()));
        mDigitPrime.setText(String.format(mDigitPrimtText, digit.isPrime()));
        mDigitFibonacci.setText(String.format(mDigitFibonacciText, digit.isFibonacci()));
    }

}
