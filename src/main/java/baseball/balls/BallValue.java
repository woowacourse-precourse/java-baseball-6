package baseball.balls;

import java.util.Objects;

public class BallValue {

    public static final int BALL_MIN_VALUE = 1;
    public static final int BALL_MAX_VALUE = 9;

    private final int value;

    public BallValue(int value) {
        validateValueRange(value);
        this.value = value;
    }

    private void validateValueRange(int value) {
        if (value < BALL_MIN_VALUE || value > BALL_MAX_VALUE) {
            throw new IllegalArgumentException("공의 값이 유효하지 않은 값입니다.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        BallValue otherBallValue = (BallValue) obj;
        return value == otherBallValue.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
