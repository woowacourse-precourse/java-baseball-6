package baseball.model;

public class StrikeBallCount {
    private int strikeCount;
    private int ballCount;

    public StrikeBallCount(final int strikeCount, final int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
