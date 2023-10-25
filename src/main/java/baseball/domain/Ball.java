package baseball.domain;

import java.util.Objects;

public class Ball {

    private final Integer ball;

    public Ball(Integer givenNumber) {
        this.ball = Objects.requireNonNull(givenNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Ball other = (Ball) obj;
        return ball.equals(other.ball);
    }

    @Override
    public int hashCode() {
        return ball.hashCode();
    }
}
