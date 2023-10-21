package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class NumberGenerator {
    public static final String TO_SMALL_RANGE = "자릿수보다 범위가 더 커야 합니다";

    private NumberGenerator() {}

    public static List<Integer> generateUniqueNumbers(int startInclusive, int endInclusive, int digit) {
        validate(startInclusive, endInclusive, digit);
        Set<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < digit) {
            int generatedRandomNumber = generateRandomNumber(startInclusive, endInclusive);
            numbers.add(generatedRandomNumber);
        }
        return List.copyOf(numbers);
    }

    private static void validate(int startInclusive, int endInclusive, int digit) {
        if (endInclusive - startInclusive + 1 < digit) {
            throw new IllegalArgumentException(TO_SMALL_RANGE);
        }
    }

    private static int generateRandomNumber(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
