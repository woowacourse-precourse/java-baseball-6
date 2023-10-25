package baseball.game;

import java.util.Objects;

public class Ball {
    private final int number;

    public Ball(int number) {
        this.number = number;
        // System.out.println(">>>" + this.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
