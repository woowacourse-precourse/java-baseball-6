package baseball;

public class Validation {

    private static final int THREE_DIGIT_NUMBER = 3;
    private static final int ONE_DIGIT_NUMBER = 1;
    private static final String STRING_REGEX = "^[0-9]+$";
    private static final String OUT_OF_NUMBER_RANGE = "[ERROR] %d자리 숫자를 입력하셔야 합니다.";
    private static final String NOT_AVAILABLE_STRING ="[ERROR] 숫자만 입력해주세요.";

    public static void checkLengthThree(String number) {
        if (number.length() != THREE_DIGIT_NUMBER) {
            String errorMessage = String.format(OUT_OF_NUMBER_RANGE, 3);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void checkLengthOne(String number) {
        if (number.length() != ONE_DIGIT_NUMBER) {
            String errorMessage = String.format(OUT_OF_NUMBER_RANGE, 1);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void checkStringRegex(String number) {
        if (!number.matches(STRING_REGEX)) {
            throw new IllegalArgumentException(NOT_AVAILABLE_STRING);
        }
    }
}
