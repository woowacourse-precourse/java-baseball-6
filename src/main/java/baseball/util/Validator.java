package baseball.util;

import java.util.Objects;

public class Validator {
    private static final int MAX_SIZE = 3;
    private static final String RESTART = "1";
    private static final String EXIT = "2";

    public static void validateInputNumbers(String numbers) {
        isValidNumbersLength(numbers);
        isValidNumbersType(numbers);
        isValidNumbersRange(numbers);
        isDuplicate(numbers);
    }

    public static void isValidNumbersLength(String numbers) {
        if (numbers.length() != MAX_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static void isValidNumbersType(String numbers) {
        try {
            Integer.parseInt(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void isValidNumbersRange(String numbers) {
        if (!hasValidNumberRange(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean hasValidNumberRange(String numbers) {
        for (char digit : numbers.toCharArray()) {
            int number = Character.getNumericValue(digit);
            if (number < 1) {
                return false;
            }
        }
        return true;
    }

    public static void isDuplicate(String numbers) {
        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean hasDuplicateNumber(String numbers) {
        return numbers.charAt(0) == numbers.charAt(1) || numbers.charAt(1) == numbers.charAt(2)
                || numbers.charAt(0) == numbers.charAt(2);
    }

    public static void validateRestartOrExitNumber(String number) {
        isValidRestartOrExitNumberType(number);
        isValidRestartOrExitNumber(number);
    }

    public static void isValidRestartOrExitNumberType(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void isValidRestartOrExitNumber(String number) {
        if (!isRestartOrExitNumber(number)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isRestartOrExitNumber(String number) {
        return Objects.equals(number, RESTART) || Objects.equals(number, EXIT);
    }
}
