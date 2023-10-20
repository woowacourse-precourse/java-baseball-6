package baseball.domain;

import java.util.HashSet;
import java.util.List;

public class Number {

    private static final int NUMBER_LENGTH = 3;

    private final List<Digit> digits;

    private Number(List<Digit> digits) {
        validate(digits);
        this.digits = digits;
    }

    private void validate(List<Digit> digits) {
        validateSize(digits);
        validateDuplication(digits);
    }

    private void validateSize(List<Digit> digits) {
        if (digits.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(String.format("숫자의 길이는 %d이어야 합니다", NUMBER_LENGTH));
        }
    }

    private void validateDuplication(List<Digit> digits) {
        if (countDistinctDigit(digits) != digits.size()) {
            throw new IllegalArgumentException("각 자릿수는 중복되어서는 안됩니다");
        }
    }

    private int countDistinctDigit(List<Digit> digits) {
        return new HashSet<>(digits).size();
    }

    public static Number from(int value) {
        return new Number(toDigits(value));
    }

    private static List<Digit> toDigits(int value) {
        return Integer.toString(value).chars()
                .mapToObj(Number::unicodeToInt)
                .map(Digit::from).toList();
    }

    private static int unicodeToInt(int unicode) {
        return unicode - '0';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Number number = (Number) o;
        return digits.equals(number.digits);
    }

    @Override
    public int hashCode() {
        return digits.hashCode();
    }
}
