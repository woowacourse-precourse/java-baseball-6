package baseball.domain.ball;

import java.util.Objects;

public class Ball {
    private final int value;

    public Ball(int value, int minRange, int maxRange) {
        valid(value, minRange, maxRange);
        this.value = value;
    }

    private void valid(int value, int minRange, int maxRange) {
        if (value < minRange || value > maxRange) {
            throw new IllegalArgumentException("숫자는 " + minRange + " ~ " + maxRange + "까지 사용이 가능합니다.");
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
