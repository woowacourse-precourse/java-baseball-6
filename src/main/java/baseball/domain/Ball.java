package baseball.domain;

import java.util.Objects;

public class Ball {
    private static final int MIN_POSITION = 1;
    private static final int MAX_POSITION = 3;

    private final int ballNumber;
    private final int position;

    public Ball(int ballNumber, int position) {
        validateBall(ballNumber, position);
        this.ballNumber = ballNumber;
        this.position = position;
    }

    private void validateBall(int ballNumber, int position) {
        validatePosition(position);
    }

    private void validatePosition(int position) {
        if (position < MIN_POSITION || position > MAX_POSITION) {
            throw new IllegalArgumentException("공의 위치는 1에서 3사이의 값이어야 합니다.");
        }
    }

    public BallStatus compare(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        if (this.ballNumber == ball.ballNumber) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return ballNumber == ball.ballNumber && position == ball.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumber, position);
    }
}
