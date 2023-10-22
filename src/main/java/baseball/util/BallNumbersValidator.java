package baseball.util;

import java.util.List;

public class BallNumbersValidator {
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;
    public static final int GAME_NUMBERS_SIZE = 3;

    public static void validateInputSize(List<Integer> numbers) {
        if (numbers.size() != GAME_NUMBERS_SIZE) {
            throw new IllegalArgumentException(Err.ERROR_NOT_THREE_SIZE_MESSAGE.getMessage());
        }
    }

    public static void validateInputRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < START_INCLUSIVE || number > END_INCLUSIVE) {
                throw new IllegalArgumentException(Err.ERROR_INPUT_SCOPE_MESSAGE.getMessage());
            }
        }
    }

    public static void validateInputUniqueness(List<Integer> numbers) {
        int uniqueCount = (int) numbers.stream()
                .distinct()
                .count();

        if (uniqueCount != numbers.size()) {
            throw new IllegalArgumentException(Err.ERROR_NUMBERS_DUPLICATION_MESSAGE.getMessage());
        }
    }
}
