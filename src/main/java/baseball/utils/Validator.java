package baseball.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final int GAME_NUMBER_SIZE = 3;
    private static final int MIN_GAME_NUMBER_RANGE = 1;
    private static final int MAX_GAME_NUMBER_RANGE = 9;

    private static final String GAME_RETRY_NUMBER = "1";
    private static final String GAME_END_NUMBER = "2";

    public static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != GAME_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_SIZE_ERROR_MESSAGE);
        }
    }

    public static void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_GAME_NUMBER_RANGE || number > MAX_GAME_NUMBER_RANGE) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE_ERROR_MESSAGE);
            }
        }
    }

    public static void validateIsContainDuplicateNumber(List<Integer> numbers) {
        Set<Integer> target = new HashSet<>(numbers);

        if (target.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static void validateIsDigit(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    public static void validateRetryNumber(String userInput) {
        if (!userInput.equals(GAME_RETRY_NUMBER) && !userInput.equals(GAME_END_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.RETRY_FORMAT_ERROR_MESSAGE);
        }
    }
}
