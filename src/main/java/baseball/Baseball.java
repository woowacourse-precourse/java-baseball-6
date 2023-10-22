package baseball;

public class Baseball {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final String RANGE_EXCEPTION_MESSAGE = "1 ~ 9 사이 숫자가 아닙니다.";

    private final int number;

    public Baseball(final int number) {
        validate(number);
        this.number = number;
    }

    private void validate(final int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(RANGE_EXCEPTION_MESSAGE);
        }
    }
}
