package baseball.domain;

import java.util.Objects;

public class Ball {

    private final int number;
    private final int position;

    private Ball(int number, int position) {
        validateNumber(number);
        this.number = number;
        this.position = position;
    }

    public static Ball of(int number, int position) {
        return new Ball(number, position);
    }

    private void validateNumber(int number) {
        if (number > 9 || number < 1) {
            throw new IllegalArgumentException("숫자는 1~9 사이의 숫자만 가능합니다.");
        }
    }

    public BallType match(Ball randomBall) {
        if (this.equals(randomBall)) {
            return BallType.STRIKE;
        }
        if (this.number == randomBall.number) {
            return BallType.BALL;
        }
        return BallType.NOTHING;
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
        return number == ball.number && position == ball.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }
}
