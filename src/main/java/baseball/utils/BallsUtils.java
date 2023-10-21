package baseball.utils;

import baseball.balls.Ball;
import baseball.balls.Balls;
import java.util.List;
import java.util.stream.IntStream;

public final class BallsUtils {

    public static List<Ball> convertIntegersToBallList(List<Integer> integers) {
        return IntStream.range(0, Balls.BALL_COUNT)
                .mapToObj(i -> {
                    int value = integers.get(i);
                    int index = i;
                    return new Ball(value, index);
                })
                .toList();
    }

}
