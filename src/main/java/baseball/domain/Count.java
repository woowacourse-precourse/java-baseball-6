package baseball.domain;

public class Count {

    public int strike;
    public int ball;

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
