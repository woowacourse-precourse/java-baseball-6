package baseball.model;

public class GameResult {
    private final int ballCount;
    private final int strikeCount;

    public GameResult(int ball, int strike) {
        this.ballCount = ball;
        this.strikeCount = strike;
    }

    public boolean isSuccess() {
        return strikeCount == 3;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
