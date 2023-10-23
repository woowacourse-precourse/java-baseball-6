package baseball.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Stream;

public class RandomNumberGenerator {

    public static List<Integer> generateRandomNumbers(final int countToGenerate) {
        return Stream.generate(() -> Randoms.pickNumberInRange(1, 9))
                .distinct()
                .limit(countToGenerate)
                .toList();
    }
}
