package baseball;

import java.util.Objects;

public class Ball {

    private static final int UNDER_RANGE = 1;
    private final int number;
    private final int position;

    public Ball(int position, int number) {
        this.number = number;
        this.position = position;

    }

    public void validateRange(int number) {
        if (!isInRange(number)) {
            throw new IllegalArgumentException("입력은 0을 포함할 수 없슴니다.");
        }
    }

    private boolean isInRange(int number) {
        return number >= UNDER_RANGE;
    }

    public boolean isSameNumber(Ball playerBall) {
        return playerBall.isNumber(number);
    }

    private boolean isNumber(int inputNumber) {
        return inputNumber == number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return number == ball.number && position == ball.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }
}
