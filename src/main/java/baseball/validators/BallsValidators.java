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

    public static void validateValueDuplication(List<Ball> balls) {
        balls.forEach(ball -> {
            int sameValueCount = (int) balls.stream()
                    .filter(anotherBall -> anotherBall.hasSameValue(ball))
                    .count();
            if (sameValueCount > 1) {
                throw new IllegalArgumentException("값이 중복된 공이 존재합니다");
            }
        });
    }

    public static void validateIndexDuplication(List<Ball> balls) {
        balls.forEach(ball -> {
            int sameIndexCount = (int) balls.stream()
                    .filter(anotherBall -> anotherBall.hasSameIndex(ball))
                    .count();
            if (sameIndexCount > 1) {
                throw new IllegalArgumentException("인덱스가 중복된 공이 존재합니다");
            }
        });
    }

}
