package baseball.model;

import java.util.Objects;

public class BallNumber {
    private final int value;

    public BallNumber(int value) {
        if (value < 1 || value > 9) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return value == ((BallNumber) obj).value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
