package baseball;

public class Score {

    private int strikeCount;
    private int ballCount;
    private boolean isCompleted;

    Score(int strikeCount, int ballCount, boolean isCompleted) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        this.isCompleted = isCompleted;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }
}
