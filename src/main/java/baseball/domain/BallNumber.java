package baseball.domain;

import java.util.Objects;

public class BallNumber {
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;
    private final int ballNumber;

    public BallNumber(int ballNumber) {
        if (ballNumber < MIN_NUMBER || ballNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("유효하지 않은 값 입력");
        }
        this.ballNumber = ballNumber;
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
}