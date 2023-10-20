package baseball.domain;

public class Result {
    private int ballCount;
    private int strikeCount;

    public void initResult() {
        ballCount = 0;
        strikeCount = 0;
    }

    public void addBall() {
        ballCount++;
    }

    public void addStrike() {
        strikeCount++;
    }

    public boolean isNothing() {
        return ballCount == 0 && strikeCount == 0;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isAllStrike() {
        return strikeCount == 3;
    }
}
