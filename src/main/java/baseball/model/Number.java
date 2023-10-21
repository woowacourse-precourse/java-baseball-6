package baseball.model;

import java.util.Objects;

public class Number {

    private final int MIN_NUMERIC_VALUE = 1;
    private final int MAX_NUMERIC_VALUE = 9;

    private final int value;

    public Number(int value) {
        this.value = value;
        validateValueRange(value);
    }

    private void validateValueRange(int value) {
        if (value < MIN_NUMERIC_VALUE || value > MAX_NUMERIC_VALUE) {
            throw new IllegalArgumentException("1에서 9사이의 값이 아닙니다.");
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
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
