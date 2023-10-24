package baseball;

import java.util.Objects;

public class Baseball {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    private final int ballNumber;

    public Baseball(int ballNumber) {
        validateBallNumber(ballNumber);
        this.ballNumber = ballNumber;
    }

    private void validateBallNumber(int ballNumber) {
        if (ballNumber < MIN_NUMBER || ballNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 숫자의 범위가 유효하지 않습니다.(1-9까지의 숫자만 입력 가능합니다.)");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baseball baseball = (Baseball) o;
        return ballNumber == baseball.ballNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumber);
    }

}
