package baseball;

import java.util.Objects;

public class Ball {
    public static final int MAX_VALUE = 9;
    public static final int MIN_VALUE = 1;
    private final int value;

    Ball(int value) {
        validation(value);
        this.value = value;
    }

    private void validation(int value) {
        if (value > MAX_VALUE || value < MIN_VALUE) {
            throw new IllegalArgumentException("1~9까지 숫자만 입력 가능합니다.");
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
