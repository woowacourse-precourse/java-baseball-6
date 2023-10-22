package baseball;

public class GameResult {
    private int strike;
    private int ball;
    private boolean isGameEnded;

    public GameResult(int strike, int ball, boolean isGameEnded) {
        this.strike = strike;
        this.ball = ball;
        this.isGameEnded = isGameEnded;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isGameEnded() {
        return isGameEnded;
    }
}
