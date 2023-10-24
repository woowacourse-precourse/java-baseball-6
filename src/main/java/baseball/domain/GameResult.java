package baseball.domain;

public class GameResult {
    private int strikeCount = 0;
    private int ballCount = 0;
    
    public void increaseStrikeCount() {
        strikeCount++;
    }

    public void increaseBallCount() {
        ballCount++;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
