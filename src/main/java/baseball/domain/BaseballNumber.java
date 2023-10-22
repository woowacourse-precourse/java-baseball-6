package baseball.domain;

import java.util.Objects;

public class BaseballNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private final int number;

    public BaseballNumber(final int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(final int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("숫자는 " + MIN_NUMBER + "부터 " + MAX_NUMBER + "까지만 가능합니다. 입력한 숫자: " + number);
        }
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BaseballNumber that = (BaseballNumber) obj;
        return this.number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
