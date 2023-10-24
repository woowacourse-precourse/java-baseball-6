package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Stream;

public class BaseballBallFactory {
    private final static int BALL_LENGTH = 3;
    private final static int MIN_BALL_NUMBER = 1;
    private final static int MAX_BALL_NUMBER = 9;

    public static BallArray createRanDomBall() {
        List<Integer> collect = Stream.generate(() -> Randoms.pickNumberInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER))
                .distinct()
                .limit(BALL_LENGTH)
                .toList();
        return new BallArray(collect.toArray(new Integer[0]));
    }

    public static BallArray createManualBall(int number){
        if ((int) (Math.log10(number) + 1) > BALL_LENGTH) {
            throw new IllegalArgumentException();
        }
        return new BallArray(splitToDigitsArray(number));
    }

    private static Integer[] splitToDigitsArray(int number) {
        return Stream.of(String.valueOf(number).split(""))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
    }
}
