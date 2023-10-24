package baseball.utils;

import java.util.Arrays;
import java.util.List;

public class NumberValidator {

    private NumberValidator() {
    }

    public static void validateContainsOnlyDigits(String source) {
        if (!containsOnlyDigits(source)) {
            throw new IllegalArgumentException("%s has non-digit character.".formatted(source));
        }
    }

    private static boolean containsOnlyDigits(String source) {
        try {
            Integer.parseInt(source);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void validateNumbersInRange(List<Integer> numbers, int startInclusive, int endInclusive) {
        if (!isNumbersInRange(numbers, startInclusive, endInclusive)) {
            throw new IllegalArgumentException("Some elements in %s is not in range [%d, %d].".formatted(
                    Arrays.toString(numbers.toArray()), startInclusive, endInclusive)
            );
        }
    }

    private static boolean isNumbersInRange(List<Integer> numbers, int startInclusive, int endInclusive) {
        return numbers.stream()
                .allMatch(number -> number >= startInclusive && number <= endInclusive);
    }

    public static void validateNotDuplicated(List<Integer> numbers) {
        if (duplicatedNumberExists(numbers)) {
            throw new IllegalArgumentException("Some elements of %s are duplicated".formatted(
                    Arrays.toString(numbers.toArray()))
            );
        }
    }

    private static boolean duplicatedNumberExists(List<Integer> numbers) {
        long nonDuplicatedSize = numbers.stream()
                .distinct()
                .count();

        return numbers.size() != nonDuplicatedSize;
    }

}
