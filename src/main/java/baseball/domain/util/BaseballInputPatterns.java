package baseball.domain.util;

import java.util.Arrays;
import java.util.regex.Pattern;

public enum BaseballInputPatterns {
    THREE_DIGIT_PATTERN("[0-9]{3}", "입력값은 1~9사이의 3자리 수 입니다."),
    RESTART_PATTERN("[1-2]", "입력값은 1또는 2입니다.");

    private final Pattern pattern;
    private final String exceptionMessage;

    BaseballInputPatterns(String regex, String exceptionMessage) {
        this.pattern = Pattern.compile(regex);
        this.exceptionMessage = exceptionMessage;
    }

    private boolean matches(String input) {
        return pattern.matcher(input).matches();
    }

    public void validate(String input) {
        if (!matches(input)) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

}
