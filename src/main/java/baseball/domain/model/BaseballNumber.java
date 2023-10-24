package baseball.domain.model;

import baseball.domain.util.BaseballInputPatterns;
import java.util.regex.Pattern;

public record BaseballNumber(String value) {

    public BaseballNumber {
        BaseballInputPatterns.THREE_DIGIT_PATTERN.validate(value);
    }

    public char charAt(int index) {
        return value.charAt(index);
    }

    public int length() {
        return value.length();
    }

    public int indexOf(char ch) {
        return value.indexOf(ch);
    }

    private boolean isValid(String str) {
        return Pattern.matches("[0-9]{3}", str);
    }

}
