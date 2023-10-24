package baseball.domain;

import static baseball.console.Constant.EXCEPTION_BASEBALL_NUMBER_FORMAT_MESSAGE;

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
            throw new IllegalArgumentException(EXCEPTION_BASEBALL_NUMBER_FORMAT_MESSAGE);
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
        BaseballNumber that = (BaseballNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
