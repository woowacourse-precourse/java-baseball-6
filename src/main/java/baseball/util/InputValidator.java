package baseball.util;

public class InputValidator {

    private static final String SHORT_OR_LONG = "입력값의 길이가 짧거나 깁니다.";
    private static final String NOT_NUMBER = "입력값이 숫자가 아닙니다.";
    private static final String ZERO_INCLUDED = "0은 사용되면 안됩니다. 수의 범위는 1~9 입니다.";
    private static final String DUPLICATE_DIGITS = "서로 다른 수로 이루어지지 않았습니다.";
    private static final String ONE_OR_TWO = "1 또는 2만 입력해야 합니다.";
    private static final int NUMBER_LENGTH = 3;
    private static final String ZERO = "0";
    private static final String RESTART_COMMAND = "1";
    private static final String END_COMMAND = "2";

    public static void validateUserNumber(String userNumber) {

        if (userNumber.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(SHORT_OR_LONG);
        }

        if (!isNumeric(userNumber)) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }

        if (userNumber.contains(ZERO)) {
            throw new IllegalArgumentException(ZERO_INCLUDED);
        }

        if (hasDuplicateDigits(userNumber)) {
            throw new IllegalArgumentException(DUPLICATE_DIGITS);
        }
    }

    public static void validateRestartCommand(String restartCommand) {
        if (!restartCommand.equals(RESTART_COMMAND) && !restartCommand.equals(END_COMMAND)) {
            throw new IllegalArgumentException(ONE_OR_TWO);
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
