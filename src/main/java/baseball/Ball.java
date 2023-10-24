package baseball;

import java.util.Objects;

public class Ball {
    private final int value;

    Ball(int value) {
        checkOneDigit(value);
        this.value = value;
    }

    private void checkOneDigit(int value) {
        if (value > 9 || value < 1) {
            throw new IllegalArgumentException("한자리 수만 가능합니다.");
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
        Ball ball = (Ball) o;
        return value == ball.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
