package baseball.domain;

import java.util.Objects;

public class Ball {

    private static final int UNDER_RANGE = 1;
    private static final String RANGE_EXCEPTION_MESSAGE = "[ERROR] 입력은 0을 포함할 수 없슴니다.";
    private final int number;
    private final int position;

    public Ball(int position, int number) {
        validateRange(number);
        this.number = number;
        this.position = position;
    }

    public void validateRange(int number) {
        if (!isInRange(number)) {
            throw new IllegalArgumentException(RANGE_EXCEPTION_MESSAGE);
        }
    }

    public TryResult getTryResult(Ball answerBall) {
        if (this.equals(answerBall)) {
            return TryResult.STRIKE;
        }
        if (isSameNumber(answerBall)) {
            return TryResult.BALL;
        }
        return TryResult.NOTHING;
    }

    private boolean isInRange(int number) {
        return number >= UNDER_RANGE;
    }

    public boolean isSameNumber(Ball answerBall) {
        return answerBall.isNumber(number);
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
