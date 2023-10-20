package baseball.balls;

import java.util.Objects;

public class Ball {

    private final BallValue value;
    private final BallIndex index;

    public Ball(int value, int index) {
        this.value = new BallValue(value);
        this.index = new BallIndex(index);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Ball anotherBall = (Ball) obj;
        boolean hasSameBallValue = hasSameValue(anotherBall);
        boolean hasSameBallIndex = hasSameIndex(anotherBall);
        return hasSameBallValue && hasSameBallIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, index);
    }

    public boolean hasSameValue(Ball anotherBall) {
        BallValue anotherBallValue = anotherBall.value;
        return value.equals(anotherBallValue);
    }

    public boolean hasSameIndex(Ball anotherBall) {
        BallIndex anotherBallIndex = anotherBall.index;
        return index.equals(anotherBallIndex);
    }

}
