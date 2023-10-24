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

    @Override
    public String toString() {
        if ((strikeCount > 0) && (ballCount > 0)) {
            return ballCount + "볼 " + strikeCount + "스트라이크";
        }

        if (ballCount > 0) {
            return ballCount + "볼";
        }

        if (strikeCount > 0) {
            return strikeCount + "스트라이크";
        }

        return "낫싱";
    }
}
