package baseball;

public class GameResult {
    private int ball;
    private int strike;

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
