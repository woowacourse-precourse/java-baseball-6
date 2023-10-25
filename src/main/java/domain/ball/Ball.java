package domain.ball;

import java.util.Objects;

public class Ball {

    private final BallNumber ballNumber;
    private final BallIndex ballIndex;

    public Ball(int number, int index) {
        this.ballNumber = new BallNumber(number);
        this.ballIndex = new BallIndex(index);
    }


    public BallNumber getBallNumber() {
        return ballNumber;
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
        return checkSameBall(ball);
    }

    private boolean checkSameBall(Ball ball) {
        return ballIndex.equals(ball.ballIndex) &&
                ballNumber.equals(ball.ballNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballIndex, ballNumber);
    }

}
