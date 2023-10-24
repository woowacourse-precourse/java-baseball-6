package baseball;

public class GameResult {
    private final int ball;
    private final int strike;

    public GameResult(int ballCount, int strikeCount) {
        this.ball = ballCount;
        this.strike = strikeCount;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
