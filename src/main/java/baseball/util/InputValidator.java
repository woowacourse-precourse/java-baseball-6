package baseball.util;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public InputValidator() {
    }

    public static void checkPlayerInputFormat(String input) {
        checkNumeric(input);
        checkDigitSize(input);
        checkDuplicate(input);
    }

    private static void checkNumeric(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void checkDigitSize(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkDuplicate(String input) {
        Set<Character> set = new HashSet<>();
        for (char ch : input.toCharArray()) {
            if (!set.add(ch)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void checkRestartInputFormat(String input) {
        checkNumeric(input);
        checkOneOrTwo(input);
    }

    private static void checkOneOrTwo(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }
}
