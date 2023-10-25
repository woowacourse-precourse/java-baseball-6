package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Stream;

public class RandomGeneratorUtils {
    private RandomGeneratorUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static List<Integer> createUniqueNumbers(int digit, int minimum, int maximum) {
        return Stream.generate(() -> Randoms.pickNumberInRange(minimum, maximum))
                .distinct()
                .limit(digit)
                .toList();
    }
}
