package baseball.entity;

import java.util.Objects;

class Ball {

    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 9;
    private static final int MIN_POSITION_RANGE = 1;
    private static final int MAX_POSITION_RANGE = 3;

    private static final String INVALID_NUMBER_RANGE_MESSAGE =
            "공이 가질 수 있는 숫자는 " + MIN_NUMBER_RANGE + "~" + MAX_NUMBER_RANGE + " 중 하나입니다.";
    private static final String INVALID_POSITION_RANGE_MESSAGE =
            "공이 가질 수 있는 위치는 " + MIN_POSITION_RANGE + "~" + MAX_POSITION_RANGE + " 중 하나입니다.";

    private final int number;
    private final int position;

    private Ball(int number, int position) {
        this.number = number;
        this.position = position;
    }

    public static Ball of(int number, int position) {
        checkNumberInRange(number);
        checkPositionInRange(position);

        return new Ball(number, position);
    }

    private static void checkNumberInRange(int number) {
        if (number < MIN_NUMBER_RANGE || number > MAX_NUMBER_RANGE) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE_MESSAGE);
        }
    }

    private static void checkPositionInRange(int position) {
        if (position < MIN_POSITION_RANGE || position > MAX_POSITION_RANGE) {
            throw new IllegalArgumentException(INVALID_POSITION_RANGE_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number && position == ball.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }
}
