package baseball.dto;

public class StrikeBallCount {

    int strikeCount;
    int ballCount;

    public StrikeBallCount() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void increaseStrikeCount() {
        this.strikeCount++;
    }

    public void increaseBallCount() {
        this.ballCount++;
    }

    @Override
    public String toString() {
        return ballCount + "볼 " + strikeCount + "스트라이크";
    }
}
