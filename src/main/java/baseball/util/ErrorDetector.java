package baseball.util;

import baseball.constants.MessageConstants;
import baseball.constants.NumberConstants;
import baseball.constants.StringConstants;
import baseball.view.Output;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ErrorDetector {

    public static void throwIfNumbersInputInvalid(String numbers) {
        throwIfContainsNonNumber(numbers);
        throwIfInvalidInputLength(numbers);
        throwIfContainsDuplicateNumbers(numbers);
    }

    private static void throwIfContainsDuplicateNumbers(String numbers) {
        Set<String> set = new HashSet<>(List.of(numbers.split("")));
        if (set.size() != NumberConstants.MAX_BALL_SIZE) {
            Output.printErrorMessage(MessageConstants.INVALID_NUMBERS_CONTAINS_DUPLICATE_NUMBER);
            throw new IllegalArgumentException();
        }
    }

    public static void throwIfOptionInputInvalid(String option) {
        throwIfContainsNonNumber(option);
        throwIfInvalidOptionInput(option);
    }

    private static void throwIfContainsNonNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            Output.printErrorMessage(MessageConstants.INVALID_INPUT_ONLY_INTEGER_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private static void throwIfInvalidInputLength(String numbers) {
        if (numbers.length() != NumberConstants.MAX_BALL_SIZE) {
            Output.printErrorMessage(MessageConstants.INVALID_NUMBERS_INPUT_LENGTH_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private static void throwIfInvalidOptionInput(String option) {
        if (!option.equals(StringConstants.CONTINUE) && !option.equals(StringConstants.FINISH)) {
            Output.printErrorMessage(MessageConstants.INVALID_OPTION_INPUT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
