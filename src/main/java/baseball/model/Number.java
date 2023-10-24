package baseball.model;

import java.util.Objects;

public class Number {
    public static final int MINIMUM = 1;
    public static final int MAXIMUM = 9;
    private final int number;

    public Number(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < MINIMUM || number > MAXIMUM) {
            throw new IllegalArgumentException();
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
        Number number = (Number) o;
        return this.number == number.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
