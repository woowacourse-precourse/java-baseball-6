package baseball.controller;

public class Validator {

    public static boolean validateInputIsNumber(String input) {
        for (char i : input.toCharArray()) {
            if (!Character.isDigit(i) || Character.getNumericValue(i) == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateInputLength(String input) {
        if (input.length() != 3) {
            return false;
        }
        return true;
    }

    public static boolean validateInputWithDifferentDigit(String input) {
        if (input.charAt(0) == input.charAt(1) || input.charAt(1) == input.charAt(2) || input.charAt(0) == input.charAt(
                2)) {
            return false;
        }
        return true;
    }

    public static boolean validateUserInput(String input) {
        if (!validateInputIsNumber(input) || !validateInputLength(input) || !validateInputWithDifferentDigit(input)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return true;
    }

    public static String validateRestartInput(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return input;
    }
}
