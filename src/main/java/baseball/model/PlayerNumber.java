package baseball.model;

import java.util.HashSet;
import java.util.Set;

public class PlayerNumber {

    private final String value;

    public PlayerNumber(String value) {
        validateLength(value);
        validateType(value);
        validateDuplication(value);
        this.value = value;
    }

    private void validateLength(String value) {
        if (value.length() != 3) {
            throw new IllegalArgumentException("입력의 길이가 3이 아닙니다.");
        }
    }

    private void validateType(String value) {
        value.chars().forEach(c -> {
            if (!Character.isDigit(c) || c == '0') {
                throw new IllegalArgumentException("입력이 1부터 9까지의 자연수로 이루어진 3자리 수가 아닙니다.");
            }
        });
    }

    private void validateDuplication(String value) {
        Set<Integer> set = new HashSet<>();
        value.chars().forEach(c -> {
            if (set.contains(c)) {
                throw new IllegalArgumentException("입력에 중복으로 사용된 수가 있습니다.");
            }
            set.add(c);
        });
    }

    public String getValue() {
        return value;
    }
}
