package baseball;

public class Score {
    private int ball;
    private int strike;

    public Score() {
        this.ball = 0;
        this.strike = 0;
    }

    public int getBall() {
        return this.ball;
    }

    public int getStrike() {
        return this.strike;
    }

    public void setScore(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }
}
