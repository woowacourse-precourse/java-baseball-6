package baseball.domain;

import java.util.Objects;

public class BaseBall {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;
    private static final String INVALID_BASEBALL_VALUE_MESSAGE = "1 ~ 9 만 입력해주세요";

    private final int value;

    public BaseBall(int value) {
        validateBallRange(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void validateBallRange(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException(INVALID_BASEBALL_VALUE_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseBall baseBall = (BaseBall) o;
        return this.value == baseBall.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
