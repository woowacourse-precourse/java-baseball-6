package baseball.domain;

public class BaseballCount {
    private int ball;
    private int strike;

    public BaseballCount(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
