package baseball.domain;

import baseball.console.Constant;
import java.util.Objects;

public class BaseballNumber {
    private static final int NUMBER_MIN_VALUE = 1;
    private static final int NUMBER_MAX_VALUE = 9;
    private final int number;

    public BaseballNumber(int number) {
        isValidFormat(number);
        this.number = number;
    }

    private static void isValidFormat(int number) {
        if (number < NUMBER_MIN_VALUE || number > NUMBER_MAX_VALUE) {
            throw new IllegalArgumentException(Constant.EXCEPTION_BASEBALL_NUMBER_FORMAT_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        BaseballNumber that = (BaseballNumber) other;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
