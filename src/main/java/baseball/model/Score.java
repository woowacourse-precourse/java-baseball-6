package baseball.model;

public class Score {
    private int strike;
    private int ball;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public Score() {
        this.strike = 0;
        this.ball = 0;
    }

    public void setScore(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }
}
