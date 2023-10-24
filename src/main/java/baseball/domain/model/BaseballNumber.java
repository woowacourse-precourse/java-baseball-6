package baseball.domain.model;

import java.util.regex.Pattern;

public record BaseballNumber(String value) {

    public BaseballNumber(String value) {
        if (!isValid(value)) {
            throw new IllegalArgumentException("BaseballNumber는 3자리의 숫자여야 합니다.");
        }
        this.value = value;
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
