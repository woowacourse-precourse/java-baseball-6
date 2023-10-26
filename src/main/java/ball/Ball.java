package ball;

import java.util.Objects;

public class Ball {
    private final int location;
    private final int digit;

    public Ball(int location, int digit) {
        this.location = location;
        this.digit = digit;
    }

    public int getLocation() {
        return this.location;
    }

    public int getDigit() {
        return this.digit;
    }
    public BallStatus check(Ball ball){
        if (this.equals(ball)) return BallStatus.STRIKE;
        if (this.digit == ball.digit) return BallStatus.BALL;
        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return location == ball.location && digit == ball.digit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, digit);
    }
}