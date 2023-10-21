package baseball.model;

public class GameResult {
    private int ballCount;
    private int strikeCount;

    public GameResult(){
        ballCount = 0;
        strikeCount = 0;
    }

    public void incrementBall() {
        ballCount++;
    }

    public void incrementStrike() {
        strikeCount++;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

}
