package baseball.model;

import baseball.util.BaseballNumberConstant;
import java.util.Objects;

public class Number {

    private final int value;

    public Number(int value) {
        this.value = value;
        validateValueRange(value);
    }

    private void validateValueRange(int value) {
        if (valueNotBetweenOneAndNine(value)) {
            throw new IllegalArgumentException("1에서 9사이의 값이 아닙니다.");
        }
    }

    private boolean valueNotBetweenOneAndNine(int value) {
        return value < BaseballNumberConstant.MIN_VALUE || value > BaseballNumberConstant.MAX_VALUE;
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
