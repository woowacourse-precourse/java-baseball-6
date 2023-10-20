package baseball.domain.ball.ballcomponent;

import java.util.Objects;

public class BallNumber {
    private final int ballNumber;

    public BallNumber(int ballNumber) {
        this.ballNumber = ballNumber;
    }

    public boolean isSameNumber(BallNumber ballNumber2) {
        return Objects.equals(this.ballNumber, ballNumber2.ballNumber);
    }
}
