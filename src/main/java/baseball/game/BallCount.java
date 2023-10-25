package baseball.game;

public class BallCount {
    private int ballCount = 0;
    private int strikeCount = 0;

    public void addBall() {
        ballCount++;
    }

    public void addStrike() {
        strikeCount++;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void reset() {
        ballCount = 0;
        strikeCount = 0;
    }

    public boolean isAllStrikes(int totalNumbers) {
        return strikeCount == totalNumbers;
    }
}