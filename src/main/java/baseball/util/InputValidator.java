package baseball.util;

public class InputValidator {

    public static boolean isValidUserInput(String input) {
        if(isNotNumeric(input)) return false;
        if(isInvalidLength(input)) return false;
        if(isDuplicated(input)) return false;
        return true;
    }

    public static boolean isValidUserRetryGameInput(String input) {
        return input.equals("1") || input.equals("2");
    }

    private static boolean isDuplicated(String input) {
        for(int i = 0; i < input.length() - 1; i++) {
            for(int j = i + 1; j < input.length(); j++) {
                if(input.charAt(i) == input.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isInvalidLength(String input) {
        return input.length() != 3;
    }

    private static boolean isNotNumeric(String s) {
        return !s.chars().allMatch(Character::isDigit);
    }
}
