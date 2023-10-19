package baseball;

import java.util.Objects;

public class BallNumber {

    public static final int MIN_BALL_NUMBER = 1;

    public static final int MAX_BALL_NUMBER = 9;

    private final int number;

    private final int position;

    public BallNumber(final int number, final int position) {
        validate(number);
        this.number = number;
        this.position = position;
    }

    private void validate(final int number) {
        if (isOutOfBound(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isOutOfBound(final int number) {
        return number < MIN_BALL_NUMBER || number > MAX_BALL_NUMBER;
    }

    public CompareResult compare(final BallNumber player) {
        if (this.equals(player)) {
            return CompareResult.STRIKE;
        }
        return CompareResult.NOTHING;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BallNumber other = (BallNumber) o;
        return matchNumber(other) && matchPosition(other);
    }

    private boolean matchNumber(final BallNumber other) {
        return this.number == other.number;
    }

    private boolean matchPosition(final BallNumber other) {
        return this.position == other.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }
}
