package baseball.domain.ball;

import baseball.domain.status.BallStatus;

import java.util.Objects;

public class Ball {
    private final BallNumber ballNumber;
    private final Position position;

    public Ball(int ballNumber, int position) {
        this.ballNumber = new BallNumber(ballNumber);
        this.position = new Position(position);
    }

    public BallStatus compare(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        if (ball.isMatchBallNumber(ballNumber)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean isMatchBallNumber(BallNumber ballNumber) {
        return this.ballNumber.equals(ballNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Objects.equals(ballNumber, ball.ballNumber) && Objects.equals(position, ball.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumber, position);
    }
}
