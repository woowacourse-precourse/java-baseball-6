package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class NumberGenerator {
    public static final String TO_SMALL_RANGE = "자릿수보다 범위가 더 커야 합니다";

    private NumberGenerator() {}

    public static List<Integer> generateUniqueNumbers(int startInclusive, int endInclusive, int digit) {
        validate(startInclusive, endInclusive, digit);

        return IntStream.generate(() -> generateRandomNumber(startInclusive, endInclusive))
                .distinct()
                .limit(digit)
                .boxed()
                .toList();
    }

    private static void validate(int startInclusive, int endInclusive, int digit) {
        if (getRange(startInclusive, endInclusive) < digit) {
            throw new IllegalArgumentException(TO_SMALL_RANGE);
        }
    }

    private static int getRange(int startInclusive, int endInclusive) {
        return endInclusive - startInclusive + 1;
    }

    private static int generateRandomNumber(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
