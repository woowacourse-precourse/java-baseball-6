package baseball;

public class BaseballCount {
    private final int strike;
    private final int ball;

    public BaseballCount(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
