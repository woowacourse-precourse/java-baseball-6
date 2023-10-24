package baseball.game;

public class Score {

    private int strikeCount = 0;
    private int ballCount = 0;
    private boolean homerunCount = false;
    private boolean nothingCount = false;

    public void setAll(int strikeCount, int ballCount, boolean homerunCount, boolean nothingCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        this.homerunCount = homerunCount;
        this.nothingCount = nothingCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public boolean isHomerunCount() {
        return homerunCount;
    }

    public void setHomerunCount(boolean homerunCount) {
        this.homerunCount = homerunCount;
    }

    public boolean isNothingCount() {
        return nothingCount;
    }

    public void setNothingCount(boolean nothingCount) {
        this.nothingCount = nothingCount;
    }
}
