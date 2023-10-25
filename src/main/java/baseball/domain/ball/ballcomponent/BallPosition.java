package baseball.domain.ball.ballcomponent;

import java.util.Objects;

public class BallPosition {
    private final int ballPosition;

    public BallPosition(int ballPosition) {
        this.ballPosition = ballPosition;
    }

    public boolean isSamePosition(BallPosition ballPosition) {
        return Objects.equals(this.ballPosition, ballPosition.ballPosition);
    }
}
