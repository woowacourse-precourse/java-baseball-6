package baseball;

import java.util.Objects;

public class Ball {

    private final Number number;

    private final int position;

    public Ball(final int number, final int position) {
        this.number = Number.of(number);
        this.position = position;
    }

    public CompareResult compare(final Ball other) {
        if (this.equals(other)) {
            return CompareResult.STRIKE;
        }
        if (matchNumber(other)) {
            return CompareResult.BALL;
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
        final Ball other = (Ball) o;
        return matchNumber(other) && matchPosition(other);
    }

    private boolean matchNumber(final Ball other) {
        return this.number.equals(other.number);
    }

    private boolean matchPosition(final Ball other) {
        return this.position == other.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }
}
