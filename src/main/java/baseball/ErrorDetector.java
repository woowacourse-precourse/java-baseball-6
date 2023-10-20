package baseball;

import constants.MessageConstants;
import constants.NumberConstants;
import constants.StringConstants;

public class ErrorDetector {

    public static void throwIfNumbersInputInvalid(String numbers) {
        throwIfContainsNonNumber(numbers);
        if (numbers.length() != NumberConstants.MAX_BALL_SIZE) {
            Output.printErrorMessage(MessageConstants.INVALID_NUMBERS_INPUT_LENGTH_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public static void throwIfOptionInputInvalid(String option) {
        throwIfContainsNonNumber(option);
        if (!option.equals(StringConstants.CONTINUE) && !option.equals(StringConstants.FINISH)) {
            Output.printErrorMessage(MessageConstants.INVALID_OPTION_INPUT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private static void throwIfContainsNonNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            Output.printErrorMessage(MessageConstants.INVALID_INPUT_ONLY_INTEGER_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
