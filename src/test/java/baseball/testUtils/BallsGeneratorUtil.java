package baseball.testUtils;

import baseball.balls.Ball;
import baseball.balls.BallValue;
import baseball.balls.Balls;
import java.util.List;
import java.util.stream.IntStream;

public final class BallsGeneratorUtil {

    private static final int BALL_MIN_VALUE = 1;
    private static final int BALL_COUNT = 3;

    // 요구사항에 맞는 Balls를 생성
    public static Balls generateBalls() {
        return generateBalls(BALL_COUNT, BALL_MIN_VALUE, false, false);
    }

    public static Balls generateBalls(int ballCount, int minValue, boolean willDuplicateValue,
            boolean willDuplicateIndex) {
        List<Ball> balls = generateBallList(ballCount, minValue, willDuplicateValue, willDuplicateIndex);
        return new Balls(balls);
    }

    public static List<Ball> generateBallList(int ballCount, int minValue, boolean willDuplicateValue,
            boolean willDuplicateIndex) {
        return IntStream.range(0, ballCount)
                .mapToObj(i -> {
                    int value = makeValue(willDuplicateValue, minValue, i);
                    int index = makeIndex(willDuplicateIndex, i);
                    return new Ball(value, index);
                })
                .toList();
    }

    private static int makeValue(boolean willDuplicate, int minValue, int index) {
        if (willDuplicate) {
            return minValue;
        }
        return minValue + index;
    }

    private static int makeIndex(boolean willDuplicate, int index) {
        if (willDuplicate) {
            return 0;
        }
        return index;
    }

}
