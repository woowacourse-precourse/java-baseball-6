package baseball.domain;

public class GameResult {

    private static final int STRIKE_OUT_COUNT = 3;
    int strikeCount = 0;

    int ballCount = 0;

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void strike() {
        this.strikeCount++;
    }

    public void ball() {
        this.ballCount++;
    }

    public boolean isStrikeOut() {
        return strikeCount == STRIKE_OUT_COUNT;
    }

    public boolean hasBall() {
        return ballCount != 0;
    }

    public boolean hasStrike() {
        return strikeCount != 0;
    }
}
