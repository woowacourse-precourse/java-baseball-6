package baseball.util;

import java.util.regex.Pattern;

public class SingleDigitValidator {
    private static final Pattern SINGLE_DIGIT_ONLY = Pattern.compile("[0-9]{1}");
    private static final String FORMAT_EXCEPTION_MESSAGE = "한 자리 숫자만 입력 가능합니다.";

    public static void validate(String input) {
        if (!matchesPattern(input, SINGLE_DIGIT_ONLY)) {
            throw new IllegalArgumentException(FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private static boolean matchesPattern(String input, Pattern pattern) {
        return pattern.matcher(input).matches();
    }
}
