package baseball.domain;

public class GameResult {

    private int strike;
    private int ball;

    public boolean verifyEnd() {
        return this.strike == 3;
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
