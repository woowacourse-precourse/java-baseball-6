package baseball.model;

import java.util.Objects;

public class Ball {
    private final int position;
    private final BallNo ballNo;

    public Ball(int position, BallNo ballNo) {
        this.position = position;
        this.ballNo = ballNo;
    }

    public BallStatus play(Ball ball) {
        if (this.equals(ball)) return BallStatus.STRIKE;

        if (ball.matchBallNo(this.ballNo)) return BallStatus.BALL;

        return BallStatus.NOTHING;
    }

    private boolean matchBallNo(BallNo number) {
        return this.ballNo.equals(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && Objects.equals(ballNo, ball.ballNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNo);
    }
}
