package baseball.core.rule;

public class ScoreResult {

    private int strikeCount;
    private int ballCount;

    void addStrike() {
        strikeCount++;
    }

    void addBall() {
        ballCount++;
    }

    public boolean isNothing() {
        return strikeCount <= 0 && ballCount <= 0;
    }

    protected ScoreResult() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public static ScoreResult makeScoreResult() {
        return new ScoreResult();
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

}
