package baseball.model;

public class GameResult {
    private int ballCount;
    private int strikeCount;

    public GameResult() {
    }

    public Integer getBallCount() {
        return ballCount;
    }

    public Integer getStrikeCount() {
        return strikeCount;
    }

    public boolean isNothing() {
        return ballCount == 0 && strikeCount == 0;
    }

    public boolean isAnswer(int gameSize) {
        return strikeCount == gameSize;
    }

    public void updateResult(BallStatus ballStatus) {
        if (ballStatus.equals(BallStatus.BALL)) {
            ballCount += 1;
        }
        if (ballStatus.equals(BallStatus.STRIKE)) {
            strikeCount += 1;
        }
    }
}
