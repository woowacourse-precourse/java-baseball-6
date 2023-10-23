package baseball.model;

import java.util.Objects;

public class BallNumber {
    private final int value;

    public BallNumber(int value) {
        if (value < 0 || value > 9) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
