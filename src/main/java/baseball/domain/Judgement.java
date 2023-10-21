package baseball.domain;

public class Judgement {

    private final int strike;

    private final int ball;

    public Judgement(final int strike, final int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean hasWon() {
        return strike == 3;
    }

    public boolean isNothing() {
        return ball == 0 && strike == 0;
    }

    public boolean hasBall() {
        return ball > 0;
    }

    public boolean hasStrike() {
        return strike > 0;
    }
}
