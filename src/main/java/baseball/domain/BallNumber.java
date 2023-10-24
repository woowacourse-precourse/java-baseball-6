package baseball.domain;

import java.util.Objects;

public class BallNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final int number;

    public BallNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    private void validateNumber(int number) {
        if (!isSingleNumber(number)) {
            throw new IllegalArgumentException(ErrorCode.NOT_SINGLE_NUMBER.getMessage());
        }
    }

    private boolean isSingleNumber(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }
}
