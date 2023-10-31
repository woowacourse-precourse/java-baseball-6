package baseball.model;

public class Count {
    private int strike;
    private int ball;

    public Count(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
