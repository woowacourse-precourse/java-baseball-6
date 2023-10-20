package baseball;

import java.util.Objects;

public class Number {

    private static final int MIN_NUMBER = 1;

    private static final int MAX_NUMBER = 9;

    private final int number;

    private Number(final int number) {
        validate(number);
        this.number = number;
    }

    private void validate(final int number) {
        if (isOutOfBound(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isOutOfBound(final int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    public static Number of(final int number) {
        return new Number(number);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Number other = (Number) o;
        return number == other.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
