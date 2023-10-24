package baseball.domain;

import java.util.Objects;

public class BaseballNumber {
    private final int value;

    public BaseballNumber(int value) {
        this.value = value;
    }

    public boolean isSameValue(BaseballNumber anotherNumber) {
        return this.value == anotherNumber.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BaseballNumber that)) {
            return false;
        }
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
