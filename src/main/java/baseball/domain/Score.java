package baseball.domain;


import java.util.Objects;

public class Score {
    private static final String NO_BALL_NO_STRIKE_MESSAGE = "낫싱";
    private static final String SPACE = " ";
    private Ball ball;
    private Strike strike;

    public Score(int ball, int strike) {
        this.ball = new Ball(ball);
        this.strike = new Strike(strike);
    }

    public boolean isStrikeOut() {
        return this.strike.isFullCount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Score score)) {
            return false;
        }
        return Objects.equals(ball, score.ball) && Objects.equals(strike, score.strike);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball, strike);
    }

    @Override
    public String toString() {
        if (this.ball.isEmpty() && this.strike.isEmpty()) {
            return NO_BALL_NO_STRIKE_MESSAGE;
        }
        if (this.ball.isEmpty()) {
            return this.strike.toString();
        }
        if (this.strike.isEmpty()) {
            return this.ball.toString();
        }
        if (this.strike.isFullCount()) {
            return this.strike.toString();
        }
        return this.ball.toString() + SPACE + this.strike.toString();
    }
}
