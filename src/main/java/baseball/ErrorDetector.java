package baseball;

public class ErrorDetector {

    public static void throwIfNumbersInputInvalid(String numbers) {
        throwIfContainsNonNumber(numbers);
        if (numbers.length() != 3) {
            Output.printErrorMessage(Constants.INVALID_NUMBERS_INPUT_LENGTH_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public static void throwIfOptionInputInvalid(String option) {
        throwIfContainsNonNumber(option);
        int op = Integer.parseInt(option);
        if (op != 1 && op != 2) {
            Output.printErrorMessage(Constants.INVALID_OPTION_INPUT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private static void throwIfContainsNonNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            Output.printErrorMessage(Constants.INVALID_INPUT_ONLY_INTEGER_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
