package baseball;

import java.util.Objects;

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

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Baseball baseball = (Baseball) o;
        return number == baseball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
