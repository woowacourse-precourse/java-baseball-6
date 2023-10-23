package baseball.model;

public class Score {
    private final int strike;
    private final int ball;

    public Score(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }
}
