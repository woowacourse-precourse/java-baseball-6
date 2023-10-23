package baseball;

public class Score {
    private int strike;
    private int ball;

    public Score() {
        this.strike = 0;
        this.ball = 0;
    }

    public void addStrike() {
        strike += 1;
    }

    public void addBall() {
        ball += 1;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }
}
