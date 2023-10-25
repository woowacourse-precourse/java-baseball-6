package baseball.domain;

import java.util.Objects;

public class Ball {
    private final int position;
    private final int number;

    public Ball(int position, int ballNum) {
        this.position = position;
        this.number = ballNum;
    }

    public BallHint play(Ball computerBall) {
        if (this.equals(computerBall)) {
            return BallHint.STRIKE;
        }
        if (matchBallNum(computerBall)) {
            return BallHint.BALL;
        }
        return BallHint.NOTHING;
    }

    public boolean matchBallNum(Ball ball) {
        return this.number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && number == ball.number;
    }
}
