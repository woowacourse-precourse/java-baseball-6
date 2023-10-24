package baseball.domain;

public class RoundResult {
    private Integer ballCount;
    private Integer strikeCount;
    private static final int MAX_COUNT = 3;
    private static final int NO_COUNT = 0;

    public RoundResult(int strikeCount, int ballCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public boolean isOnlyStrike() {
        if (!strikeCount.equals(NO_COUNT) && ballCount.equals(NO_COUNT)) {
            return true;
        }
        return false;
    }

    public boolean isOnlyBall() {
        if (strikeCount.equals(NO_COUNT) && !ballCount.equals(MAX_COUNT)) {
            return true;
        }
        return false;
    }

    public boolean isNothing() {
        if (strikeCount.equals(NO_COUNT) && ballCount.equals(NO_COUNT)) {
            return true;
        }
        return false;
    }

    public boolean isBothOccured() {
        if (!strikeCount.equals(NO_COUNT) && !ballCount.equals(NO_COUNT)) {
            return true;
        }
        return false;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isWin() {
        return strikeCount == 3;
    }
}
