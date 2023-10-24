package baseball.domain.number;

import baseball.exception.number.NumberOutOfRangeException;

public class Number {
    public final static int MIN_NUMBER = 1;
    public final static int MAX_NUMBER = 9;
    private int number;

    private Number(int number) {
        this.number = number;
    }


    public static Number from(int number){
        checkNumberRange(number);
        return new Number(number);
    }

    private static void checkNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new NumberOutOfRangeException();
        }
    }

    @Override
    public String toString() {
        return "Number{" +
                "number=" + number +
                '}';
    }

    public int getNumber() {
        return number;
    }
}
