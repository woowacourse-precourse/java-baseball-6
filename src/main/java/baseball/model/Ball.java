package baseball.model;

import java.util.Objects;

public class Ball {
    private final int digit;
    private final int value;

    public Ball(int digit, int value) {
        this.digit = digit;
        this.value = value;
    }

    public GameResult compare(Ball computerBall) {
        if (isSameDigit(computerBall) && isSameValue(computerBall)) {
            return GameResult.STRIKE;
        }

        if (isSameValue(computerBall)) {
            return GameResult.BALL;
        }

        return GameResult.NOTHING;
    }

    private boolean isSameValue(Ball computerBall) {
        return value == computerBall.value;
    }

    private boolean isSameDigit(Ball computerBall) {
        return digit == computerBall.digit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return digit == ball.digit && value == ball.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(digit, value);
    }
}
