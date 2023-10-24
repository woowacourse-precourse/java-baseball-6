package baseball;

public class Score {
    private int strike;
    private int ball;

    protected void setBall(int ball) {
        this.ball = ball;
    }

    protected void setStrike(int strike) {
        this.strike = strike;
    }

    protected int getBall() {
        return ball;
    }

    protected int getStrike() {
        return strike;
    }
}
