package baseball.utility;

import baseball.domain.balls.Ball;
import baseball.domain.balls.Balls;
import java.util.List;
import java.util.stream.IntStream;

public class ConvertorUtils {

    public static Balls convertStringToBalls(String string) {
        List<Integer> integers = ConvertorUtils.convertStringToIntegerList(string);
        return convertIntegersToBalls(integers);
    }

    public static List<Integer> convertStringToIntegerList(String string) {
        return string.chars()
                .map(character -> character - '0')
                .boxed()
                .toList();
    }

    public static Balls convertIntegersToBalls(List<Integer> integers) {
        List<Ball> balls = convertIntegersToBallList(integers);
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
