package baseball.domain;

import java.util.List;

public class NumericString {

    private final String numeric;

    public NumericString(String numeric) {
        this.numeric = numeric;
        validate();
    }

    public List<Integer> toList() {
        return this.numeric
                .chars()
                .mapToObj(Character::getNumericValue)
                .toList();
    }

    private void validate() {
        if (isNull() || isEmpty() || isNotNumeric()) {
            throw new IllegalArgumentException("숫자만을 입력하셔야 합니다.");
        }
    }

    private boolean isNotNumeric() {
        return !this.numeric.chars().allMatch(Character::isDigit);
    }

    private boolean isEmpty() {
        return numeric.isEmpty();
    }

    private boolean isNull() {
        return numeric == null;
    }
}
