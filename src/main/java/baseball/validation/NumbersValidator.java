package baseball.validation;

import baseball.Constants;

public class NumbersValidator {
    public static void validation(String input) {
        if (input.length() != Constants.NUMBER_SIZE ||
                !input.matches("\\d+") ||
                input.contains("0") ||
                hasDuplicateCharacter(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean hasDuplicateCharacter(final String input) {
        for (int i = 0; i < input.length(); ++i) {
            char currentChar = input.charAt(i);
            for (int j = i + 1; j < input.length(); ++j) {
                if (currentChar == input.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
