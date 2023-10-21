package baseball.domain;

import java.util.Objects;

public class Baseball {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final int number;

    public Baseball(int number) {
        verifyBaseballNumber(number);
        this.number = number;
    }

    private void verifyBaseballNumber(int number) throws IllegalArgumentException {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException();
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
        Baseball baseball = (Baseball) o;
        return number == baseball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
