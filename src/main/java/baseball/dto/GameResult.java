package baseball.dto;

public class GameResult {

    private int strike;
    private int ball;

    public GameResult(final int strike, final int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isZeroStrike() {
        return strike == 0;
    }

    public boolean isZeroBall() {
        return ball == 0;
    }

    public boolean isNothing() {
        return isZeroStrike() && isZeroBall();
    }

    public boolean isWin() {
        return strike == 3;
    }
}
