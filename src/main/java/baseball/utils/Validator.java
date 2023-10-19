package baseball.utils;

import java.util.regex.Pattern;

public class Validator {

    public static void validateBallNumbers(String input) {
        if (isNotDigit(input)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private static boolean isNotDigit(String input) {
        return !Pattern.matches("-?[0-9]+", input);
    }
}
