package baseball.model;

public class GameResult {

    private final int ballCount;
    private final int strikeCount;

    public GameResult() {
        ballCount = 0;
        strikeCount = 0;
    }

    public GameResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public GameResult incrementBall() {
        return new GameResult(ballCount + 1, strikeCount);
    }

    public GameResult incrementStrike() {
        return new GameResult(ballCount, strikeCount + 1);
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isSuccess() {
        return strikeCount == 3;
    }

}
