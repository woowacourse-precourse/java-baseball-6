package baseball.model;

public class Ball {
    private final int position;
    private final int ballNumber;

    public Ball(int position, int ballNumber) {
        this.position = position;
        this.ballNumber = ballNumber;
    }

    public int getPosition() {
        return position;
    }

    public int getBallNumber() {
        return ballNumber;
    }

    public BallStatus compareBall(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        if (this.ballNumber == ball.getBallNumber()) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
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

        if (getPosition() != ball.getPosition()) {
            return false;
        }
        return getBallNumber() == ball.getBallNumber();
    }

    @Override
    public int hashCode() {
        int result = getPosition();
        result = 31 * result + getBallNumber();
        return result;
    }
}
