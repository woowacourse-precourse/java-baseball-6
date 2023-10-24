package baseball.dto;

public class StrikeBallCount {

    int strikeCount;
    int ballCount;

    public StrikeBallCount() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public void increaseStrikeCount(){
        this.strikeCount++;
    }

    public void increaseBallCount(){
        this.ballCount++;
    }

    @Override
    public String toString() {
        return "StrikeBallCount{" +
                "strikeCount=" + strikeCount +
                ", ballCount=" + ballCount +
                '}';
    }
}
