package baseball.utils;

import baseball.constants.Constants;
import baseball.constants.Messages;
import java.util.HashSet;
import java.util.Set;

public class Validator {
    public static void validateGuessInput(String input) {
        checkNotNull(input);
        checkValidLength(input, Constants.CORRECT_ANSWER_LENGTH);
        checkValidRange(input, Constants.START_GUESS_INPUT_RANGE, Constants.END_GUESS_INPUT_RANGE);
        checkNonDuplicate(input);
    }

    public static void validateRestartInput(String input) {
        checkNotNull(input);
        checkValidLength(input, Constants.RESTART_INPUT_LENGTH);
        checkValidRange(input, Constants.START_RESTART_INPUT_RANGE, Constants.END_RESTART_INPUT_RANGE);
    }

    private static void checkNotNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(Messages.ERROR_MESSAGE_CONTAINS_NULL);
        }
    }

    private static void checkValidLength(String input, int length) {
        if (input.length() != length) {
            throw new IllegalArgumentException(Messages.ERROR_MESSAGE_NOT_VALID_LENGTH);
        }
    }

    private static void checkValidRange(String input, char start, char end) {
        boolean isValid = input.chars().allMatch(
                cur -> (start <= cur && cur <= end)
        );

        if (!isValid) {
            throw new IllegalArgumentException(Messages.ERROR_MESSAGE_NOT_VALID_RANGE);
        }
    }

    private static void checkNonDuplicate(String input) {
        Set<Integer> seen = new HashSet<>();

        boolean isValid = input.chars().allMatch(
                cur -> seen.add(cur)
        );

        if (!isValid) {
            throw new IllegalArgumentException(Messages.ERROR_MESSAGE_DUPLICATE_INPUT);
        }
    }
}
