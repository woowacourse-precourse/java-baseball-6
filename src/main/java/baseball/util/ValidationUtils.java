package baseball.util;

import baseball.constant.StringPattern;
import java.util.regex.Matcher;

public class ValidationUtils {
    private ValidationUtils() {
    }

    public static void validateInput(String inputValue) {
        Matcher matcher = StringPattern.INPUT_PATTERN.matcher(inputValue);
        if (!(matcher.matches())) {
            throw new IllegalArgumentException("1~9 사이의 세 개의 숫자를 입력해주세요.");
        }

        if (inputValue.charAt(0) == inputValue.charAt(1)
                || (inputValue.charAt(1) == inputValue.charAt(2))
                || (inputValue.charAt(0) == inputValue.charAt(2))) {
            throw new IllegalArgumentException("서로 다른 3개의 숫자를 입력해주세요.");
        }
    }
}
