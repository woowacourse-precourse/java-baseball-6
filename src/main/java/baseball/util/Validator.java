package baseball.util;

import baseball.constants.ErrorMessage;

public class Validator {
    private static final int MAX_SIZE = 3;
    private static final String RESTART = "1";
    private static final String EXIT = "2";

    public static void validateInputNumbers(String numbers) {
        validateNumbersLength(numbers);
        validateNumbersType(numbers);
        validateNumbersRange(numbers);
        validateNoDuplicate(numbers);
    }

    public static void validateNumbersLength(String numbers) {
        if (numbers.length() != MAX_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LENGTH);
        }
    }

    public static void validateNumbersType(String numbers) {
        try {
            Integer.parseInt(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TYPE);
        }
    }

    public static void validateNumbersRange(String numbers) {
        if (!hasValidNumberRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE);
        }
    }

    public static boolean hasValidNumberRange(String numbers) {
        return numbers.chars().allMatch(number -> number >= '1' && number <= '9');
    }

    public static void validateNoDuplicate(String numbers) {
        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_DIGITS);
        }
    }

    public static boolean hasDuplicateNumber(String numbers) {
        return numbers.chars().distinct().count() < numbers.length();
    }

    public static void validateRestartOrExitNumber(String number) {
        validateRestartOrExitNumberType(number);
        validateRestartOrExitNumberValue(number);
    }

    public static void validateRestartOrExitNumberType(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TYPE);
        }
    }

    public static void validateRestartOrExitNumberValue(String number) {
        if (!isRestartOrExitNumber(number)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RESTART_OR_EXIT);
        }
    }

    public static boolean isRestartOrExitNumber(String number) {
        return number.equals(RESTART) || number.equals(EXIT);
    }
}
