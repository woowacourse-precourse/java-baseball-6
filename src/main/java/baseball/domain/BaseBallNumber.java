package baseball.domain;

import static baseball.domain.ExceptionMessage.NUMBER_RANGE_EXCEPTION_MESSAGE;

public class BaseBallNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final int number;

    private BaseBallNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (isNotRightRange(number)) {
            throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private boolean isNotRightRange(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    public static BaseBallNumber from(int number) {
        return new BaseBallNumber(number);
    }

}
