package baseball.domain;

import baseball.constant.ErrorMessage;

import java.util.Objects;

public final class Number {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    private final Integer value;

    public Number(final Integer value) {
        validate(value);
        this.value = value;
    }

    public Number(final Number number) {
        this.value = number.value;
    }

    private void validate(final Integer value) {
        if (isInvalidValue(value)) {
            throw new IllegalStateException(ErrorMessage.INVALID_NUMBER_RANGE.toValue());
        }
    }

    private boolean isInvalidValue(final Integer value) {
        return value < MIN_VALUE || value > MAX_VALUE;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Number number = (Number) o;
        return Objects.equals(value, number.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
