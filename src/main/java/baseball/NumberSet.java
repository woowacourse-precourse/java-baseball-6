package baseball;

public class NumberSet {
    private int digit1;
    private int digit2;
    private int digit3;

    public NumberSet(int digit1, int digit2, int digit3) {
        this.digit1 = digit1;
        this.digit2 = digit2;
        this.digit3 = digit3;
    }

    public int getDigit1() {
        return digit1;
    }

    public int getDigit2() {
        return digit2;
    }

    public int getDigit3() {
        return digit3;
    }

    public void setDigit1(int digit1) {
        this.digit1 = digit1;
    }

    public void setDigit2(int digit2) {
        this.digit2 = digit2;
    }

    public void setDigit3(int digit3) {
        this.digit3 = digit3;
    }

    public boolean isUnique() {
        return (
                this.digit1 != this.digit2
                        && this.digit2 != this.digit3
                        && this.digit1 != this.digit3
        );
    }

    public static NumberSet parseFrom(int number) throws IllegalArgumentException {
        if (number < 100 || number > 999)
            throw new IllegalArgumentException();
        return new NumberSet(
                number / 100,
                (number / 10) % 10,
                number % 10
        );
    }

    public static NumberSet parseFrom(String string) throws IllegalArgumentException {
        if (string.length() != 3)
            throw new IllegalArgumentException();
        int number;
        try {
            number = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return NumberSet.parseFrom(number);
    }
}
