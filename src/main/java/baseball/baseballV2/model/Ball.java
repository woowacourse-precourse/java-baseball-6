package baseball.baseballV2.model;

import java.util.Objects;

public class Ball {
    private final int digit;
    private final int value;

    public Ball(int digit, int value) {
        this.digit = digit;
        this.value = value;
    }

    public Result compareBallCondition(Ball otherBall) {
        if (isStrike(otherBall)) {
            return Result.STRIKE;
        }

        if (isBall(otherBall)) {
            return Result.BALL;
        }

        return Result.NOTHING;
    }

    private boolean isBall(Ball otherBall) {
        return hasSameValue(otherBall) && !hasSameDigit(otherBall);
    }

    private boolean isStrike(Ball otherBall) {
        return hasSameValue(otherBall) && hasSameDigit(otherBall);
    }

    private boolean hasSameValue(Ball otherBall) {
        return value == otherBall.getValue();
    }

    private boolean hasSameDigit(Ball otherBall) {
        return digit == otherBall.getDigit();
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
        return getDigit() == ball.getDigit() && getValue() == ball.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDigit(), getValue());
    }

    public int getDigit() {
        return digit;
    }

    public int getValue() {
        return value;
    }
}
