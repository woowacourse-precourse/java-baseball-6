package baseball.domain.ball;

import baseball.domain.ball.ballcomponent.BallNumber;
import baseball.domain.ball.ballcomponent.BallPosition;
import baseball.domain.result.BallResult;

public class Ball {
    private final BallNumber ballNumber;
    private final BallPosition ballPosition;

    public Ball(int ballNumber, int ballPosition) {
        this.ballNumber = new BallNumber(ballNumber);
        this.ballPosition = new BallPosition(ballPosition);
    }

    public BallResult compareBall(Ball ball) {
        if (this.equals(ball)) {
            return BallResult.STRIKE;
        }
        if (this.checkNumberSame(ball)) {
            return BallResult.BALL;
        }
        return BallResult.NOTHING;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ball ball) {
            return checkNumberSame(ball) && checkPositionSame(ball);
        }
        return false;
    }

    private boolean checkNumberSame(Ball ball) {
        return this.ballNumber.isSameNumber(ball.ballNumber);
    }

    private boolean checkPositionSame(Ball ball) {
        return this.ballPosition.isSamePosition(ball.ballPosition);
    }
}