package baseball;

public class Validation {

    private static final int THREE_DIGIT_NUMBER = 3;
    private static final int ONE_DIGIT_NUMBER = 1;
    private static final String STRING_REGEX = "^[0-9]+$";

    public static void checkLengthThree(String number) {
        if (number.length() != THREE_DIGIT_NUMBER) {
            String errorMessage = String.format(ExceptionMessage.OUT_OF_NUMBER_RANGE.getMessage(), 3);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void checkLengthOne(String number) {
        if (number.length() != ONE_DIGIT_NUMBER) {
            String errorMessage = String.format(ExceptionMessage.OUT_OF_NUMBER_RANGE.getMessage(), 1);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void checkStringRegex(String number) {
        if (!number.matches(STRING_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_AVAILABLE_STRING.getMessage());
        }
    }
}
