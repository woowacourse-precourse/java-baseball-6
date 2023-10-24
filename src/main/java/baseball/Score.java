package baseball;

public class Score {

    private int strikeCount;
    private int ballCount;

    public Score() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public boolean isOut() {
        if (strikeCount == 3) {
            return false;
        }
        return true;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setScore(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }


}
