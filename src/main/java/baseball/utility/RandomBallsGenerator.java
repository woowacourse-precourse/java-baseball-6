package baseball.utility;

import baseball.domain.balls.Balls;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Stream;

public final class RandomBallsGenerator {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    private static final int BALL_COUNT = 3;

    public static Balls generate() {
        List<Integer> randomIntegers = Stream.generate(() -> generateRandomNumber())
                .distinct()
                .limit(BALL_COUNT)
                .toList();
        return ConvertorUtils.convertIntegersToBalls(randomIntegers);
    }

    private static int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }
    
}
