package baseball.model;

import java.util.Objects;

public final class BallNumber {
    private static final int MIN_NO = 1;
    private static final int MAX_NO = 9;

    private final int number;

    private BallNumber(int number) {
        this.number = number;
    }


    public static BallNumber of(int value) {
        validationRange(value);
        return new BallNumber(value);
    }

    private static void validationRange(int value) {
        if (value < MIN_NO || value > MAX_NO) {
            throw new IllegalArgumentException("숫자 범위는 1부터 9까지만 허용");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
