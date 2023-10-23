package baseball.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final int GAME_NUMBER_SIZE = 3;
    private static final int MIN_GAME_NUMBER_RANGE = 1;
    private static final int MAX_GAME_NUMBER_RANGE = 9;

    public static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != GAME_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_GAME_NUMBER_RANGE || number > MAX_GAME_NUMBER_RANGE) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateIsContainDuplicateNumber(List<Integer> numbers) {
        Set<Integer> target = new HashSet<>(numbers);

        if (target.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateIsDigit(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateRetryNumber(String userInput) {
        if (!userInput.equals("1") && !userInput.equals("2")) {
            throw new IllegalArgumentException();
        }
    }
}
