package baseball.utils;

import baseball.balls.Ball;
import baseball.balls.BallValue;
import baseball.balls.Balls;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class BallsUtils {

    public static Balls convertStringToBalls(String string) {
        List<Integer> integers = StringUtils.convertStringToIntegerList(string);
        return convertIntegersToBalls(integers);
    }

    public static Balls convertIntegersToBalls(List<Integer> integers) {
        List<Ball> balls = BallsUtils.convertIntegersToBallList(integers);
        return new Balls(balls);
    }

    public static List<Ball> convertIntegersToBallList(List<Integer> integers) {
        return IntStream.range(0, Balls.BALL_COUNT)
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
        int ballMinValue = BallValue.MIN_VALUE;
        int ballMaxValue = BallValue.MAX_VALUE;
        int ballCount = Balls.BALL_COUNT;

        return Stream.generate(() -> Randoms.pickNumberInRange(ballMinValue, ballMaxValue))
                .limit(ballCount)
                .toList();
    }

}
