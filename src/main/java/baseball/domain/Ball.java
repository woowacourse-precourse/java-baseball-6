package baseball.domain;

import static baseball.domain.Constant.MAXIMUM_BALL_NUMBER;
import static baseball.domain.Constant.MININUM_BALL_NUMBER;
import static baseball.domain.ErrorMessage.BALL_NUMBER_IS_NOT_IN_RANGE;

import java.util.Objects;

public class Ball {


    private final int number;
    private final int position;

    private Ball(int position, int number) {
        validateRange(number);
        this.number = number;
        this.position = position;
    }

    private void validateRange(int number) {
        if (!isInRange(number)) {
            throw new IllegalArgumentException(BALL_NUMBER_IS_NOT_IN_RANGE);
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
        return MININUM_BALL_NUMBER <= number  && number <= MAXIMUM_BALL_NUMBER;
    }

    public boolean isSameNumber(Ball answerBall) {
        return answerBall.isNumber(number);
    }

    private boolean isNumber(int inputNumber) {
        return inputNumber == number;
    }

    public static Ball from(int position, int number) {
        return new Ball(position, number);
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
