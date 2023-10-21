package baseball.model;

import java.util.Objects;

public class Number {

    private final int MIN_VALUE = 1;
    private final int MAX_VALUE = 9;

    private final int value;

    public Number(int value) {
        this.value = value;
        validateValueRange(value);
    }

    private void validateValueRange(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException("1 에서 9 사이의 값이 아닙니다.");
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
