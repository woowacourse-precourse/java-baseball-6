package baseball.domain;

import java.util.Objects;

public class Ball {
    private final BallNum ballNum;
    private final Position position;
    public Ball(Position position, BallNum ballNum) {
        this.position = position;
        this.ballNum = ballNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Objects.equals(ballNum, ball.ballNum) && Objects.equals(position, ball.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNum, position);
    }

    public BallStatus match(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        if ((this.ballNum.equals(ball.ballNum))) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }
}
