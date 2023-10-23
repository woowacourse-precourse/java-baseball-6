package baseball;

public class BaseballCount {
    private final int ball;
    private final int strike;

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
