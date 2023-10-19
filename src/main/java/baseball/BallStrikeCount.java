package baseball;

public class BallStrikeCount {
    private int ballCount;
    private int strikeCount;

    public BallStrikeCount() {
        ballCount = 0;
        strikeCount = 0;
    }

    public void increaseBall() {
        ballCount++;
    }

    public void increaseStrike() {
        strikeCount++;
    }

    public void clean() {
        ballCount = 0;
        strikeCount = 0;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
