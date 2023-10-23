package baseball.validator;


import baseball.global.exception.BaseballException;

import static baseball.global.GameConfig.*;
import static baseball.global.exception.ErrorMessage.*;

public class InputValidator {
    protected InputValidator() {
    }

    public static boolean isValidRestartFlag(String flag) {
        validateGameFlag(flag);
        return flag.equals(RESTART_FLAG.toString());
    }

    private static void validateGameFlag(final String flag) {
        if (!isExitFlag(flag) && !isRestartFlag(flag)) {
            throw BaseballException.of(INVALID_FLAG);
        }
    }

    private static boolean isExitFlag(String flag) {
        return flag.equals(EXIT_FLAG.toString());
    }

    private static boolean isRestartFlag(String flag) {
        return flag.equals(RESTART_FLAG.toString());
    }


    public static void validateNumberLength(final String number) {
        if (!isValidLength(number)) {
            throw BaseballException.of(INVALID_LENGTH);
        }
    }

    public static void validateContainDuplicatedNumber(final String number) {
        if (!isUniqueNumber(number)) {
            throw BaseballException.of(DUPLICATED_NUMBER);
        }
    }

    public static void validateContainOnlyNumber(final String number) {
        if (!isValidNumber(number)) {
            throw BaseballException.of(CONTAIN_LETTER);
        }
    }

    public static void validateEmpty(final String number) {
        if (isEmpty(number)) {
            throw BaseballException.of(EMPTY_NUMBER);
        }
    }

    private static boolean isEmpty(String number) {
        return number.isEmpty();
    }

    private static boolean isValidLength(final String number) {
        return number.length() == NUMBER_LENGTH.getValue();
    }

    private static boolean isValidNumber(final String number) {
        return number
                .chars()
                .allMatch(c -> Character.isDigit(c) && c >= '1' && c <= '9');
    }

    private static boolean isUniqueNumber(final String number) {
        return number.chars()
                .distinct()
                .count() == number.length();
    }
}
