package baseball.domain;

public class GameResult {

    private final int ballCount;
    private final int strikeCount;

    private GameResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public static GameResult allStrike() {
        return new GameResult(0, 3);
    }

    public static GameResult nothing() {
        return new GameResult(0, 0);
    }

    public static GameResult ballsAndStrikes(int ballCount, int strikeCount) {
        return new GameResult(ballCount, strikeCount);
    }
}
