package baseball.model;

import java.util.Objects;

public class BaseBallNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private final int number;

    private BaseBallNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (isNotRightRange(number)) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private boolean isNotRightRange(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    public static BaseBallNumber createRandomNumber(NumberGenerator numberGenerator) {
        int randomNumber = numberGenerator.generate(MIN_NUMBER, MAX_NUMBER);
        return new BaseBallNumber(randomNumber);
    }

    public static BaseBallNumber from(int number) {
        return new BaseBallNumber(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseBallNumber that = (BaseBallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
