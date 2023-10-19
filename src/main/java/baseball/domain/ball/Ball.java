package baseball.domain.ball;

import baseball.domain.result.BallResult;

public class Ball {
    private final BallNumber ballNumber;
    private final BallPosition ballPosition;

    public Ball(int ballNumber, int ballPosition) {
        this.ballNumber = new BallNumber(ballNumber);
        this.ballPosition = new BallPosition(ballPosition);
    }

    public BallResult compareBall(Ball ball) {
        boolean numResult = ballNumber.isSame(ball.ballNumber);
        boolean positionResult = ballPosition.isSamePosition(ball.ballPosition);
        if (numResult && positionResult) {
            return BallResult.STRIKE;
        }
        if (numResult) {
            return BallResult.BALL;
        }
        return BallResult.NOTHING;
    }
}
