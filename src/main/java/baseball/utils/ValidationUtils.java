package baseball.utils;

public class ValidationUtils {
    private static boolean containsOnlyDigits(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isThreeDigitNumber(String input) {
        return input.matches("\\d{3}");
    }

    private static boolean hasNoDuplicateDigits(String input) {
        for (int i = 0; i < input.length(); i++) {
            char digit = input.charAt(i);
            for (int j = i + 1; j < input.length(); j++) {
                if (digit == input.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isWithinRange(String input) {
        int num = Integer.parseInt(input);
        return num >= 111 && num <= 999;
    }

    public static boolean isValidChoice(String input) {
        int num = Integer.parseInt(input);
        return num == 1 || num == 2;
    }

    public static boolean isValidGuess(String input) {
        return containsOnlyDigits(input)
                && isThreeDigitNumber(input)
                && hasNoDuplicateDigits(input)
                && isWithinRange(input);
    }
}
