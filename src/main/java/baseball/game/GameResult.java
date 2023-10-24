package baseball.game;

public class GameResult {
    private final int ball;
    private final int strike;
    public GameResult(final int ball, final int strike) {
        this.ball = ball;
        this.strike = strike;
    }
    public int getBall() {
        return ball;
    }
    public int getStrike() {
        return strike;
    }
}
