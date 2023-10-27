package baseball.util;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import baseball.domain.Ball;
import baseball.domain.Balls;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputConvertor {

    private static final String BLANK = "";

    public static List<Integer> convertStringToList(String rawBalls) {
        String[] rawBallStrings = rawBalls.split(BLANK);
        return Arrays.stream(rawBallStrings)
            .map(Integer::parseInt)
            .collect(toList());
    }

    public static Balls convertBalls(String rawBalls) {
        List<Integer> ballList = convertStringToList(rawBalls);
        return IntStream.range(0, ballList.size())
            .mapToObj(index -> {
                int position = index + 1;
                int ballNumber = ballList.get(index);
                return Ball.from(position, ballNumber);
            }).collect(collectingAndThen(toList(), Balls::from));
    }
}
