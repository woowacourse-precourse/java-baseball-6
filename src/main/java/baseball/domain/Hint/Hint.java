package baseball.domain.Hint;

public class Hint {

    private Ball ball;
    private Strike strike;
    private Nothing nothing;

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Strike getStrike() {
        return strike;
    }

    public void setStrike(Strike strike) {
        this.strike = strike;
    }

    public Nothing isNothing() {
        return nothing;
    }

    public void setNothing(Nothing nothing) {
        this.nothing = nothing;
    }
}
