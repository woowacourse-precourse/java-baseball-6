package baseball.utils;

import baseball.constants.Constants;
import baseball.constants.Errors;

import java.util.List;

public class Validator {

    public static void validateNotZero(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException(Errors.ERROR_NOT_ZERO);
        }
    }

    public static void validateNumberSize(String input) {
        if (input.length() != Constants.NUMBERS_SIZE) {
            throw new IllegalArgumentException(Errors.ERROR_NUMBER_SIZE);
        }
    }

    public static void validateIsNumber(char input) {
        if (!Character.isDigit(input)) {
            throw new IllegalArgumentException(Errors.ERROR_IS_NUMBER);
        }
    }

    public static void validateDuplicatedNumber(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(Errors.ERROR_DUPLICATED_NUMBER);
        }
    }
}
