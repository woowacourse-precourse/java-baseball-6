package baseball.domain;

import java.util.Objects;

public class Ball {
    private final Position position;
    private final BallNumber ballNumber;

    public Ball(Position position, BallNumber ballNumber) {
        this.position = position;
        this.ballNumber = ballNumber;
    }

    public BallStatus play(Ball playerBall) {
        if (this.equals(playerBall)) {
            return BallStatus.STRIKE;
        }
        if (this.ballNumber.equals(playerBall.getBallNumber())) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    public BallNumber getBallNumber() {
        return ballNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Objects.equals(position, ball.position) && Objects.equals(ballNumber, ball.ballNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNumber);
    }
}