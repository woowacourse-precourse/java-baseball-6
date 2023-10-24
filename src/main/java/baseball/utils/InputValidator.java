package baseball.utils;

public class InputValidator {
    private static final String INVALID_INPUT_MESSAGE = "잘못된 값을 입력하셨습니다.";
    private static final int VALID_INPUT_LENGTH = 3;

    public static void validateUserInput(String input) {
        if (!isValidInput(input)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    private static boolean isValidInput(String input) {
        return hasValidLength(input) && isNumeric(input) && isUnique(input);
    }

    private static boolean hasValidLength(String input) {
        return input.length() == VALID_INPUT_LENGTH;
    }

    private static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isUnique(String input) {
        char[] chars = input.toCharArray();
        return chars[0] != chars[1] && chars[1] != chars[2] && chars[0] != chars[2];
    }
}
