package baseball.game.dto;

public class BallCount {
    private int strike;
    private int ball;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void putStrike() {
        this.strike += 1;
    }

    public void putBall() {
        this.ball += 1;
    }

    public boolean isNothing() {
        return this.strike == 0 && this.ball == 0;
    }
}
