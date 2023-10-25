package baseball.domain;

import java.util.Objects;

public class BaseBall {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;

    private final int value;

    public BaseBall(int value) {
        validateBallRange(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void validateBallRange(int value) {
        if (value < 1 || value > 9) {
            throw new IllegalArgumentException("1 ~ 9 만 입력해주세요");
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
