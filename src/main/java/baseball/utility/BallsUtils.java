package baseball.utility;

import baseball.domain.balls.Ball;
import baseball.domain.balls.Balls;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class BallsUtils {

    public static Balls generateRandomBalls(int minValue, int maxValue, int ballCount) {
        List<Integer> randomIntegers = Stream.generate(() -> Randoms.pickNumberInRange(minValue, maxValue))
                .limit(ballCount)
                .toList();
        return convertIntegersToBalls(randomIntegers);
    }

    public static Balls convertStringToBalls(String string) {
        List<Integer> integers = StringUtils.convertStringToIntegerList(string);
        return convertIntegersToBalls(integers);
    }

    private static Balls convertIntegersToBalls(List<Integer> integers) {
        List<Ball> balls = BallsUtils.convertIntegersToBallList(integers);
        return new Balls(balls);
    }

    private static List<Ball> convertIntegersToBallList(List<Integer> integers) {
        return IntStream.range(0, integers.size())
                .mapToObj(i -> {
                    int value = integers.get(i);
                    int index = i;
                    return new Ball(value, index);
                })
                .toList();
    }

}
