package baseball.constants;

import java.util.regex.Pattern;

public enum InputPattern {

    BASEBALL(Pattern.compile("^(?!.*(.).*\\1)[1-9]{3}$"), "1 이상 9 이하 값을 가진 서로 다른 세 자리 숫자여야 합니다.");

    private final Pattern pattern;
    private final String errorMessage;

    InputPattern(Pattern pattern, String errorMessage) {
        this.pattern = pattern;
        this.errorMessage = errorMessage;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}