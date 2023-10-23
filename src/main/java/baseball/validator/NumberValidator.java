package baseball.validator;


import baseball.domain.exception.BaseballException;

import static baseball.domain.exception.ErrorMessage.*;

public class NumberValidator {
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
        return number.length() == 3;
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
