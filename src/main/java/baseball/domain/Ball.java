package baseball.domain;

import java.util.Objects;

public class Ball {
    private static final int ZERO_COUNT = 0;
    public static final String NO_BALL_MESSAGE = "";
    public static final String BALL_MESSAGE = "볼";
    private int ball;

    public Ball(int ball) {
        this.ball = ball;
    }

    public boolean isEmpty() {
        return ball == ZERO_COUNT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ball ball1)) {
            return false;
        }
        return ball == ball1.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball);
    }

    @Override
    public String toString() {
        if (this.ball == ZERO_COUNT) {
            return NO_BALL_MESSAGE;
        }
        return ball + BALL_MESSAGE;
    }
}
