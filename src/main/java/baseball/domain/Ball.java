package baseball.domain;

public record Ball(int position, int number) {
    public BallStatus play(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        if (ball.matchBallNumber(number)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean matchBallNumber(int number) {
        return this.number == number;
    }
}
