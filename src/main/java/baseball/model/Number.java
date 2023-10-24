package baseball.model;

import java.util.Objects;

public class Number {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final String WRONG_VALUE_ERROR_MESSAGE = "1부터 9사이의 값이 아닙니다.";

    private final int value;

    public Number(final int value) {
        validateValueRange(value);
        this.value = value;
    }

    private void validateValueRange(final int value) {
        if (!isBetweenOneAndNine(value)) {
            throw new IllegalArgumentException(WRONG_VALUE_ERROR_MESSAGE);
        }
    }

    private boolean isBetweenOneAndNine(final int value) {
        return MIN_NUMBER <= value && value <= MAX_NUMBER;
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
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
