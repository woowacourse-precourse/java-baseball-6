package baseball.model;

import static constants.BallDetails.BALL_SIZE;

import java.util.List;

public class Ball {

    private final List<Integer> numbers;

    public Ball(List<Integer> numbers) {
        validateBallSize(numbers);
        this.numbers = numbers;
    }

    private void validateBallSize(List<Integer> numbers) {
        if (numbers.size() != BALL_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public int checkStrike(Ball ball) {
        int strikeCount = 0;
        for (int i = 0; i < BALL_SIZE; i++) {
            if (isStrike(ball, i)) {
                ++strikeCount;
            }
        }
        return strikeCount;
    }

    public int checkBall(Ball ball) {
        int ballCount = 0;
        for (int i = 0; i < BALL_SIZE; i++) {
            if (isBall(ball, i)) {
                ++ballCount;
            }
        }
        return ballCount;
    }

    private boolean isStrike(Ball ball, int index) {
        return this.numbers.get(index).equals(ball.numbers.get(index));
    }

    private boolean isBall(Ball ball, int index) {
        return !isStrike(ball, index) && this.numbers.contains(ball.numbers.get(index));
    }
}
