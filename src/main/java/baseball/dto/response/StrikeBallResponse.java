package baseball.dto.response;

public class StrikeBallResponse {
    private int strikeCount;
    private int ballCount;

    public StrikeBallResponse(int strike, int ball) {
        this.strikeCount = strike;
        this.ballCount = ball;
    }

    public void incrementStrike(boolean condition) {
        if (condition) {
            strikeCount++;
        }
    }

    public void incrementBall(boolean condition) {
        if (condition) {
            ballCount++;
        }
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean hasStrike() {
        return strikeCount != 0;
    }

    public boolean hasBall() {
        return ballCount != 0;
    }
}
