package baseball.domain;

public class GameResult {

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
        return strike == GameRuleConstant.STRIKE_OUT.getNumber();
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean hasBall() {
        return 0 < ball;
    }

    public int getBall() {
        return ball;
    }

    public boolean hasStrike() {
        return 0 < strike;
    }

    public int getStrike() {
        return strike;
    }
}
