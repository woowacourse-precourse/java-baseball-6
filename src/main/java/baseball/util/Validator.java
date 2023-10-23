package baseball.util;

public class Validator {
    private static final int MAX_SIZE = 3;

    public static void validateInputNumbers(String numbers) {
        isValidNumbersLength(numbers);
        isValidNumbersType(numbers);
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

    public static void isDuplicate(String numbers) {
        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean hasDuplicateNumber(String numbers) {
        return numbers.charAt(0) == numbers.charAt(1) || numbers.charAt(1) == numbers.charAt(2)
                || numbers.charAt(0) == numbers.charAt(2);
    }
}
