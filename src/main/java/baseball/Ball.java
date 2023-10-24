package baseball;

import java.util.Objects;

public class Ball {
    private final int position;
    private final int value;
    public Ball(int position, int value) {
        this.position = position;
        this.value = value;
    }

    public BallStatus match(Ball targetBall) {
        if(this.equals(targetBall)){
            return BallStatus.STRIKE;
        }
        if(this.isSameValue(targetBall)){
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }
    public boolean isSameValue(Ball targetBall) {
        return this.value == targetBall.value;
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
        return position == ball.position && value == ball.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, value);
    }
}
