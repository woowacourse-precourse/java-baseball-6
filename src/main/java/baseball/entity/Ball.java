package baseball.entity;

import java.util.Objects;

class Ball {

    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 9;
    private static final String INVALID_NUMBER_RANGE_MESSAGE =
            "공이 가질 수 있는 숫자는 " + MIN_NUMBER_RANGE + "~" + MAX_NUMBER_RANGE + " 중 하나입니다.";

    private final int number;

    private Ball(int number) {
        this.number = number;
    }

    public static Ball from(int number) {
        checkNumberInRange(number);

        return new Ball(number);
    }

    private static void checkNumberInRange(int number) {
        if (number < MIN_NUMBER_RANGE || number > MAX_NUMBER_RANGE) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
