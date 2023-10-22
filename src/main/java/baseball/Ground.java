package baseball;

import java.util.Objects;
import java.util.StringJoiner;

public class Ground {
    private final int strike;
    private final int ball;

    private Ground(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static Ground of(int strike, int ball) {
        return new Ground(strike, ball);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ground ground = (Ground) o;
        return strike == ground.strike && ball == ground.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Ground.class.getSimpleName() + "[", "]")
                .add("strike=" + strike)
                .add("ball=" + ball)
                .toString();
    }
}
