package baseball.domain;

import java.util.Objects;

public class Ball {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final int number;
    private final int position;

    public Ball(int number, int position) {
        validateRange(number);
        this.number = number;
        this.position = position;
    }

    private static void validateRange(int digit) {
        if (digit < MIN_NUMBER || MAX_NUMBER < digit) {
            throw new IllegalArgumentException("Ball의 숫자가 1~9 범위여야 합니다.");
        }
    }

    public boolean isStrike(Ball ball) {
        return isSameNumber(ball) && isSamePosition(ball);
    }

    public boolean isBall(Ball ball) {
        return isSameNumber(ball) && isDifferentPosition(ball);
    }

    private boolean isSameNumber(Ball ball) {
        return this.number == ball.number;
    }

    private boolean isSamePosition(Ball ball) {
        return this.position == ball.position;
    }

    private boolean isDifferentPosition(Ball ball) {
        return this.position != ball.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
