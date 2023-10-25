package baseball.domain.ball;

import baseball.exception.OutOfRangeException;

import java.util.Objects;

public class Ball {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;

    private final int value;

    public Ball(int value) {
        valid(value);
        this.value = value;
    }

    private void valid(int value) {
        if (value < MIN_RANGE || value > MAX_RANGE) {
            throw new OutOfRangeException("숫자는 " + MIN_RANGE + " ~ " + MAX_RANGE + "까지 사용이 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Ball that = (Ball) obj;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
