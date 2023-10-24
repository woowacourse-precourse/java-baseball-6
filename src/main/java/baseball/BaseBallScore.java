package baseball;

public class BaseBallScore {
    private final int strike;
    private final int ball;

    public BaseBallScore(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    int getStrike() {
        return strike;
    }

    int getBall() {
        return ball;
    }
}

