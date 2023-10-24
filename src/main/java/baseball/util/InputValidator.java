package baseball.util;

import baseball.domain.Constants;

public class InputValidator {

    public static void validateUserNumber(String userNumber) {

        if (userNumber.length() != Constants.NUMBER_LENGTH) {
            throw new IllegalArgumentException(Constants.SHORT_OR_LONG);
        }

        if (!isNumeric(userNumber)) {
            throw new IllegalArgumentException(Constants.NOT_NUMBER);
        }

        if (userNumber.contains(Constants.ZERO)) {
            throw new IllegalArgumentException(Constants.ZERO_INCLUDED);
        }

        if (hasDuplicateDigits(userNumber)) {
            throw new IllegalArgumentException(Constants.DUPLICATE_DIGITS);
        }
    }

    public static void validateRestartCommand(String restartCommand) {
        if (!restartCommand.equals(Constants.RESTART_COMMAND) && !restartCommand.equals(Constants.END_COMMAND)) {
            throw new IllegalArgumentException(Constants.ONE_OR_TWO);
        }
    }

    private static boolean isNumeric(String userNumber) {
        for (int i = 0; i < Constants.NUMBER_LENGTH; i++) {
            if (!Character.isDigit(userNumber.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasDuplicateDigits(String userNumber) {
        for (int i = 0; i < Constants.NUMBER_LENGTH - 1; i++) {
            for (int j = i + 1; j < Constants.NUMBER_LENGTH; j++) {
                if (userNumber.charAt(i) == userNumber.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
