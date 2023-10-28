package baseball.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {
    private static final Pattern pattern = Pattern.compile("^[1-9]{3}$");

    private ValidationUtils() {
    }

    public static void validateInput(String inputValue) {
        Matcher matcher = pattern.matcher(inputValue);
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
