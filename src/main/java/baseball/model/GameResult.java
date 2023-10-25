package baseball.model;

public class GameResult {
    private static final int SUCCESS_STRIKE = 3;
    private static final int SUCCESS_BALL = 0;
    private int strike;
    private int ball;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isSuccess() {
        if (strike == SUCCESS_STRIKE && ball == SUCCESS_BALL) {
            return true;
        }

        return false;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
