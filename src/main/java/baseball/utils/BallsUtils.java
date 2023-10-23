package baseball.utils;

import baseball.balls.Ball;
import baseball.balls.Balls;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class BallsUtils {

    private static final int BALL_MIN_VALUE = 1;
    private static final int BALL_MAX_VALUE = 9;
    private static final int BALL_COUNT = 3;

    public static Balls convertStringToBalls(String string) {
        List<Integer> integers = StringUtils.convertStringToIntegerList(string);
        return convertIntegersToBalls(integers);
    }

    public static Balls convertIntegersToBalls(List<Integer> integers) {
        List<Ball> balls = BallsUtils.convertIntegersToBallList(integers);
        return new Balls(balls);
    }

    public static List<Ball> convertIntegersToBallList(List<Integer> integers) {
        return IntStream.range(0, integers.size())
                .mapToObj(i -> {
                    int value = integers.get(i);
                    int index = i;
                    return new Ball(value, index);
                })
                .toList();
    }

    public static Balls generateRandomBalls() {
        List<Integer> randomIntegers = generateRandomIntegers();
        List<Ball> randomBalls = convertIntegersToBallList(randomIntegers);
        return new Balls(randomBalls);
    }

    private static List<Integer> generateRandomIntegers() {
        return Stream.generate(() -> Randoms.pickNumberInRange(BALL_MIN_VALUE, BALL_MAX_VALUE))
                .limit(BALL_COUNT)
                .toList();
    }

}
