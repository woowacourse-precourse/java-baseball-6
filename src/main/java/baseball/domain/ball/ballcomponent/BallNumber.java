package baseball.domain.ball.ballcomponent;

import static baseball.domain.util.RandomBallGenerator.LARGEST_NUMBER;
import static baseball.domain.util.RandomBallGenerator.SMALLEST_NUMBER;

import java.util.Objects;

public class BallNumber {
    private static final String BALL_GENERATION_ERROR = "숫자는 " + SMALLEST_NUMBER + "~9 만 입력 가능합니다.";

    private final int ballNumber;

    public BallNumber(int ballNumber) {
        validator(ballNumber);
        this.ballNumber = ballNumber;
    }

    public boolean isSameNumber(BallNumber ballNumber2) {
        return Objects.equals(this.ballNumber, ballNumber2.ballNumber);
    }

    private void validator(int ballNumber) {
        if (ballNumber < SMALLEST_NUMBER || ballNumber > LARGEST_NUMBER) {
            throw new IllegalArgumentException(BALL_GENERATION_ERROR);
        }
    }
}
