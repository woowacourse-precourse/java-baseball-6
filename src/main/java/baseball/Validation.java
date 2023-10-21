package baseball;

public class Validation {

    private static final int THREE_DIGIT_NUMBER = 3;
    private static final String STRING_REGEX = "^[0-9]+$";
    private static final String OUT_OF_NUMBER_RANGE = "[ERROR] 3자리 숫자를 입력하셔야 합니다.";
    private static final String NOT_AVAILABLE_STRING ="[ERROR] 숫자만 입력해주세요.";

    public static void checkLengthThree(String number) {
        if (number.length() != THREE_DIGIT_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_NUMBER_RANGE);
        }
    }

    public static void checkStringRegex(String number) {
        if (!number.matches(STRING_REGEX)) {
            throw new IllegalArgumentException(NOT_AVAILABLE_STRING);
        }
    }
}
