package baseball.domain;

public class GameResult {
    public static final int THREE_STRIKE = 3;
    public static final int ZERO = 0;
    private final int strike;
    private final int ball;

    private GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static GameResult from(int strike, int ball) {
        return new GameResult(strike, ball);
    }

    public boolean isGameOver() {
        return strike == THREE_STRIKE;
    }

    public boolean isNothing() {
        return strike == ZERO && ball == ZERO;
    }

    public boolean hasBall() {
        return ZERO < ball;
    }

    public int getBall() {
        return ball;
    }

    public boolean hasStrike() {
        return ZERO < strike;
    }

    public int getStrike() {
        return strike;
    }
}
