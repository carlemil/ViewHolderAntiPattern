package se.kjellstrand.viewholderantipattern;

public class Digit {

    private final int mDigit;

    public Digit(int digit) {
        this.mDigit = digit;
    }

    public boolean isEven() {
        return mDigit % 2 == 0 ? true : false;
    }

    public boolean isPrime() {
        return !new String(new char[mDigit]).matches(".?|(..+?)\\1+");
    }

    public boolean isFibonacci() {
        return ((Math.sqrt(5 * Math.pow((mDigit), 2) + 4) -
                Math.round(Math.sqrt(5 * Math.pow((mDigit), 2) + 4)) == 0) || (Math.sqrt(5 * Math.pow((mDigit), 2) - 4)
                -
                Math.round(Math.sqrt(5 * Math.pow((mDigit), 2) - 4)) == 0));
    }

    public String toString() {
        return Integer.toString(mDigit);
    }

    public String toHexString() {
        return Integer.toHexString(mDigit);
    }

    public String toOctalString() {
        return Integer.toOctalString(mDigit);
    }

}
