package baseball.domain.number;

import baseball.exception.number.NumberOutOfRangeException;

import java.util.Objects;

public class Number {
    public final static int MIN_NUMBER = 1;
    public final static int MAX_NUMBER = 9;
    private int number;

    private Number(int number) {
        this.number = number;
    }


    public static Number from(int number) {
        checkNumberRange(number);
        return new Number(number);
    }

    private static void checkNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new NumberOutOfRangeException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number that = (Number) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
