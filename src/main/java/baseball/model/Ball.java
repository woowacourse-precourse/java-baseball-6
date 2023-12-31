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

    public int checkStrike(Ball player) {
        int strike = 0;
        for (int i = 0; i < BALL_SIZE; i++) {
            if (isStrike(player, i)) {
                ++strike;
            }
        }
        return strike;
    }

    public int checkBall(Ball player) {
        int ball = 0;
        for (int i = 0; i < BALL_SIZE; i++) {
            if (isBall(player, i)) {
                ++ball;
            }
        }
        return ball;
    }

    private boolean isStrike(Ball ball, int index) {
        return this.digits.get(index).equals(ball.digits.get(index));
    }

    private boolean isBall(Ball ball, int index) {
        return !isStrike(ball, index) && this.digits.contains(ball.digits.get(index));
    }
}
