package baseball.util;

import java.util.regex.Pattern;

public class ValidationUtils {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[1-9]+$");

    public static String validUserNumber(String userInput) {
        if (!parseInt(userInput)) {
            throw new IllegalArgumentException("입력은 숫자만 가능합니다.");
        }
        if (!validLength(userInput)) {
            throw new IllegalArgumentException("숫자는 세자리만 입력 가능합니다.");
        }
        if (!validNumber(userInput)) {
            throw new IllegalArgumentException("숫자는 1부터 9까지만 입력이 가능합니다.");
        }
        return userInput;
    }

    private static boolean validNumber(String userInput) {
        return NUMBER_REGEX.matcher(userInput).matches();
    }

    private static boolean validLength(String userInput) {
        return userInput.length() == 3;
    }

    private static boolean parseInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
