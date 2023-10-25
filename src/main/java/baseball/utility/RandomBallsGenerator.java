package baseball.utility;

import baseball.domain.balls.Balls;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Stream;

public final class RandomBallsGenerator {

    public static Balls generateRandomBalls(int minValue, int maxValue, int ballCount) {
        List<Integer> randomIntegers = Stream.generate(() -> Randoms.pickNumberInRange(minValue, maxValue))
                .distinct()
                .limit(ballCount)
                .toList();
        return ConvertorUtils.convertIntegersToBalls(randomIntegers);
    }
    
}
