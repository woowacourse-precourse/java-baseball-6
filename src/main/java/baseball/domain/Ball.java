package baseball.domain;

public class Ball {

    private final int number;
    private final int position;

    public Ball(int number, int position) {
        this.number = number;
        this.position = position;
    }

    public boolean isStrike(Ball ball) {
        return isSameNumber(ball) && isSamePosition(ball);
    }

    public boolean isBall(Ball ball) {
        return isSameNumber(ball) && isDifferentPosition(ball);
    }

    private boolean isSameNumber(Ball ball) {
        return this.number == ball.number;
    }

    private boolean isSamePosition(Ball ball) {
        return this.position == ball.position;
    }

    private boolean isDifferentPosition(Ball ball) {
        return this.position != ball.position;
    }
}
