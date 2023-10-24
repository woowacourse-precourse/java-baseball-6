package baseball.util;

public class NumberValidator {
    private static final int NUMBER_LENGTH = 3;
    private final static String WRONG_LENGTH_ERROR_MESSAGE = "세 자리만 입력 가능합니다.";

    public static void validateDigit(String inputNumber) {
        if (inputNumber.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(WRONG_LENGTH_ERROR_MESSAGE);
        }
    }
}
