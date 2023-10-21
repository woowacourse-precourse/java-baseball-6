package baseball.util;

public class InputValidator {

    private static final String SHORT_OR_LONG = "입력값의 길이가 짧거나 깁니다.";
    private static final String NOT_NUMBER = "입력값이 숫자가 아닙니다.";
    private static final String ZERO_INCLUDED = "0은 사용되면 안됩니다. 수의 범위는 1~9 입니다.";
    private static final String DUPLICATE_DIGITS = "서로 다른 수로 이루어지지 않았습니다.";
    private static final int NUMBER_LENGTH = 3;

    public static void validateUserNumber(String userNumber) {

        if (userNumber.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(SHORT_OR_LONG);
        }

        if (!isNumeric(userNumber)) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }

        if (userNumber.contains("0")) {
            throw new IllegalArgumentException(ZERO_INCLUDED);
        }

        if (hasDuplicateDigits(userNumber)) {
            throw new IllegalArgumentException(DUPLICATE_DIGITS);
        }
    }

    private static boolean isNumeric(String userNumber) {
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (!Character.isDigit(userNumber.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasDuplicateDigits(String userNumber) {
        for (int i = 0; i < NUMBER_LENGTH - 1; i++) {
            for (int j = i + 1; j < NUMBER_LENGTH; j++) {
                if (userNumber.charAt(i) == userNumber.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
