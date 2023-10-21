package baseball.utils;

import baseball.balls.Ball;
import baseball.balls.Balls;
import baseball.results.ResultStatus;

public final class ResultsUtils {

    public static ResultStatus determineResultStatus(Balls balls, Ball ball) {
        if (balls.hasSameBall(ball)) {
            return ResultStatus.STRIKE;
        }

        if (balls.hasSameValueBall(ball)) {
            return ResultStatus.BALL;
        }

        return ResultStatus.OUT;
    }

}
