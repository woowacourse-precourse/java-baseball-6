package baseball.domain.player.number;

import baseball.exception.number.NumberOutOfRangeException;

public class Number {
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 9;
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
}
