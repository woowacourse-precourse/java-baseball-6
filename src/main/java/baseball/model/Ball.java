package baseball.model;

import static constants.BallDetails.BALL_SIZE;

import java.util.List;

public class Ball {

    private final List<Integer> digits;

    public Ball(List<Integer> digits) {
        validateBallSize(digits);
        this.digits = digits;
    }

    private void validateBallSize(List<Integer> digits) {
        if (digits.size() != BALL_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isStrike(Ball ball, int index) {
        return this.digits.get(index).equals(ball.digits.get(index));
    }

    public boolean isBall(Ball ball, int index) {
        return !isStrike(ball, index) && this.digits.contains(ball.digits.get(index));
    }
}
