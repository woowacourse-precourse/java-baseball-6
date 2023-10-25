package baseball.domain;

import baseball.generator.NumberGenerator;

import java.util.Objects;

public class BaseballNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final String ERROR_NUMBER_OUT_OF_RANGE = "숫자는 %d부터 %d까지만 가능합니다.";
    private final int number;

    public BaseballNumber(int number) {
        validateIsNumberInRange(number);
        this.number = number;
    }

    public BaseballNumber(NumberGenerator generator) {
        this(generator.generate(MIN_NUMBER, MAX_NUMBER));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballNumber that = (BaseballNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    private void validateIsNumberInRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_NUMBER_OUT_OF_RANGE.formatted(MIN_NUMBER, MAX_NUMBER));
        }
    }

}
