package baseball.model;

public class BallAndStrikeCount {
    private int ballCount;
    private int strikeCount;

    public BallAndStrikeCount(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
