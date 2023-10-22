package baseball.utils;

public class ValidationUtils {
    private static boolean containsOnlyDigits(String input) {
        return input.matches("^\\d+$");
    }

    private static boolean isThreeDigitNumber(String input) {
        return input.length() == 3;
    }

    private static boolean hasNoDuplicateDigits(String input) {
        return input.chars().distinct().count() == input.length();
    }

    private static boolean isWithinRange(String input) {
        int number = Integer.parseInt(input);
        return number >= 111 && number <= 999 && !input.contains("0");
    }

    private static boolean isChoiceOneOrTwo(String input) {
        int number = Integer.parseInt(input);
        return number == 1 || number == 2;
    }

    public static boolean isValidChoice(String input) {
        return containsOnlyDigits(input) && isChoiceOneOrTwo(input);
    }

    public static boolean isValidGuess(String input) {
        return containsOnlyDigits(input)
                && isThreeDigitNumber(input)
                && hasNoDuplicateDigits(input)
                && isWithinRange(input);
    }
}
