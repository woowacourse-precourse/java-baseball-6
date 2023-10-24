package baseball.domain.ball;

import java.util.Objects;

import static baseball.utils.Constants.*;

public class BallNumber {
    private final int ballNumber;

    public BallNumber(int ballNumber) {
        validateBallNumber(ballNumber);
        this.ballNumber = ballNumber;
    }

    private void validateBallNumber(int ballNumber) {
        if (ballNumber < MIN_BALL_NUMBER || ballNumber > MAX_BALL_NUMBER) {
            throw new IllegalArgumentException(
                    String.format("공의 숫자는 %d에서 %d사이의 값이어야 합니다.", MIN_BALL_NUMBER, MAX_BALL_NUMBER)
            );
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return ballNumber == that.ballNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(ballNumber);
    }
}
