package baseball.domain;

public class BallCounter {

    private int strikeCount;
    private int ballCount;

    public BallCounter(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public void increaseStrikeCount() {
        this.strikeCount++;
    }

    public void increaseBallCount() {
        this.ballCount++;
    }

    public boolean isNothing() {
        return this.strikeCount == 0 && this.ballCount == 0;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
