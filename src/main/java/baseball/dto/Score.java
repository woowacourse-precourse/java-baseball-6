package baseball.dto;

public class Score {

    private int strike;
    private int ball;

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

    public boolean isNothing() {
        if (strike == 0 && ball == 0) {
            return true;
        }
        return false;
    }
}
