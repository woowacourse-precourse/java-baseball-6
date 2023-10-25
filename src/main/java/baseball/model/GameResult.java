package baseball.model;

public class GameResult {

    public static int MAX_STRIKE_COUNT = 3;

    private int ballCount;
    private int strikeCount;

    public GameResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isStrikeOut() {
        if (strikeCount== MAX_STRIKE_COUNT) {
            return true;
        } else {
            return false;
        }
    }
}
