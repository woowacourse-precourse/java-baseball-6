package baseball;

import java.util.Objects;

public class Ball {
    private final int number;
    private final int location;

    public Ball(int number, int location) {
        this.number = number;
        this.location = location;
    }

    public boolean isStrike(Ball other) {
        return this.equals(other);
    }

    public boolean isBall(Ball other) {
        return number == other.getNumber() &&
                location != other.getLocation();
    }

    public int getNumber() {
        return number;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return getNumber() == ball.getNumber() && getLocation() == ball.getLocation();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getLocation());
    }
}
