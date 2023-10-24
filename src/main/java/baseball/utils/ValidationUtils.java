package baseball.utils;

public class ValidationUtils {
    public static boolean isValidGuess(String input) {
        return containsOnlyDigits(input) && hasNoDuplicateDigits(input) && isNonZeroWithinRange(input);
    }

    public static boolean isValidChoice(String input) {
        int number = Integer.parseInt(input);
        return isWithinRange(number, 1, 2);
    }

    private static boolean containsOnlyDigits(String input) {
        return input.matches("^\\d+$");
    }

    private static boolean hasNoDuplicateDigits(String input) {
        return input.chars().distinct().count() == input.length();
    }

    private static boolean isNonZeroWithinRange(String input) {
        int number = Integer.parseInt(input);
        return isWithinRange(number, 111, 999) && !input.contains("0");
    }

    private static boolean isWithinRange(int number, int min, int max) {
        return number >= min && number <= max;
    }
}
