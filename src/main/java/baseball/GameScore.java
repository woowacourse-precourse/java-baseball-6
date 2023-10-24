package baseball;

public class GameScore {
    private int ball;
    private int strike;

    public GameScore(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public void reset() {
        this.ball = 0;
        this.strike = 0;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }
}
