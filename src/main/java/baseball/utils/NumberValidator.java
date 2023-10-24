package baseball.utils;

import java.util.regex.Pattern;

public class NumberValidator {

    private static final int VALID_SIZE = 3;
    private static final String DIGIT_REGEX = "^[1-9]+$";
    private static final String NOT_DIGIT_ERROR_MESSAGE = "입력은 1부터 9 까지의 숫자로만 이루어져 있어야 합니다.";
    private static final String NOT_VALID_LENGTH_ERROR_MESSAGE = "입력된 수의 자리 수는 3이어야 합니다.";
    private static final String DUPLICATE_DIGIT_ERROR_MESSAGE = "입력된 수는 서로 다른 수로 구성되어야 합니다.";

    public static void validateThreeDistinctDigitsInRange(String number) {
        isDigit(number);
        isValidSize(number);
        isDuplicateDigitContain(number);
    }

    private static void isDigit(String number) {
        if (!Pattern.matches(DIGIT_REGEX, number)) {
            throw new IllegalArgumentException(NOT_DIGIT_ERROR_MESSAGE);
        }
    }

    private static void isValidSize(String number) {
        if (number.length() != VALID_SIZE) {
            throw new IllegalArgumentException(NOT_VALID_LENGTH_ERROR_MESSAGE);
        }
    }

    private static void isDuplicateDigitContain(String number) {
        if(number.charAt(0) == number.charAt(1) || number.charAt(1) == number.charAt(2) || number.charAt(0) == number.charAt(2)){
            throw new IllegalArgumentException(DUPLICATE_DIGIT_ERROR_MESSAGE);
        }
    }
}
