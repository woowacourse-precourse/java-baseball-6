package baseball.domain;

public final class Number {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    private final Integer value;

    public Number(final Integer value) {
        validate(value);
        this.value = value;
    }

    private void validate(final Integer value) {
        if (isNotProperValue(value)) {
            throw new IllegalStateException();
        }
    }

    private boolean isNotProperValue(final Integer value) {
        return value < MIN_VALUE || value > MAX_VALUE;
    }
}
