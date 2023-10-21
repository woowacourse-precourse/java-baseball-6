package baseball.domain;

import baseball.dto.ComparisonResult;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Number {

    static final int NUMBER_LENGTH = 3;

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

    public static Number from(List<Digit> digits) {
        Objects.requireNonNull(digits);
        return new Number(List.copyOf(digits));
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

    public ComparisonResult compare(Number target) {
        int strike = countStrike(target);
        int ball = countBall(target);
        boolean isRight = strike == NUMBER_LENGTH;

        return new ComparisonResult(strike, ball, isRight);
    }

    private int countStrike(Number target) {
        return (int) IntStream.range(0, NUMBER_LENGTH)
                .filter(index -> target.getDigit(index).equals(getDigit(index)))
                .count();
    }

    private int countBall(Number target) {
        return (int) IntStream.range(0, NUMBER_LENGTH)
                .filter(targetIndex -> isBallCount(target.getDigit(targetIndex), targetIndex))
                .count();
    }

    private boolean isBallCount(Digit target, int exclusiveIndex) {
        return IntStream.range(0, NUMBER_LENGTH)
                .filter(index -> index != exclusiveIndex)
                .anyMatch(index -> getDigit(index).equals(target));
    }

    private Digit getDigit(int index) {
        return digits.get(index);
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
