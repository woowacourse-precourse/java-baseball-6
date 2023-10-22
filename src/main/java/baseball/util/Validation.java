package baseball.util;

import java.util.regex.Pattern;

public class Validation {
    private static final String REGEXP_PATTERN_NUMBER = "^[\\d]*$";

    public static boolean checkUserInput(String userInput) {
        String target = userInput.trim();
        if (target.length() != 3) {
            return false;
        }

        if (target.contains("0")) {
            return false;
        }

        if (!checkDuplicatedNumber(target)) {
            return false;
        }

        return Pattern.matches(REGEXP_PATTERN_NUMBER, target);
    }

    public static boolean checkDuplicatedNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            char target = input.charAt(i);
            if (input.indexOf(target) != i) {
                return false;
            }
        }

        return true;
    }

}
