package baseball.tdd;

import java.util.Objects;

public class Ball {
    private final int position;
    private final int ballNo;

    public Ball(final int position, final int ballNo) {
        this.position = position;
        this.ballNo = ballNo;
    }

    public BallStatus play(final Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }

        if (ball.matchBallNo(ballNo)){
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean matchBallNo(final int ballNo) {
        return this.ballNo == ballNo;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return position == ball.position && ballNo == ball.ballNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNo);
    }
}
