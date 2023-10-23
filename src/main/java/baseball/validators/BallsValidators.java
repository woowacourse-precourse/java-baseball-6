package baseball.validators;

import baseball.balls.Ball;
import baseball.balls.Balls;
import java.util.List;

public final class BallsValidators {

    public static void validateBallCount(List<Ball> balls) {
        int ballCount = balls.size();
        int targetBallCount = Balls.BALL_COUNT;
        if (ballCount != targetBallCount) {
            throw new IllegalArgumentException("공의 개수가 유효하지 않습니다");
        }
    }

}
