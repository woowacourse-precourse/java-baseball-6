package baseball.domain.baseballnumber;

import java.util.Objects;

public class BaseballNumber {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    private static final String ERROR_MESSAGE_INVALID_RANGE = "1에서 9 사이의 수만 입력할 수 있습니다.";

    private final int value;

    public BaseballNumber(int value) {
        validateIsInRange(value);
        this.value = value;
    }

    private void validateIsInRange(int value) {
        if (!isInRange(value)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_RANGE);
        }
    }

    private boolean isInRange(int value) {
        return value >= MIN_VALUE && value <= MAX_VALUE;
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof BaseballNumber)) {
            return false;
        }

        BaseballNumber baseballNumber = (BaseballNumber) object;
        return value == baseballNumber.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
