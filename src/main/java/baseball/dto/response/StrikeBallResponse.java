package baseball.dto.response;

public class StrikeBallResponse {
    private final int strikeCount;
    private final int ballCount;

    public StrikeBallResponse(int strike, int ball) {
        this.strikeCount = strike;
        this.ballCount = ball;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean hasBallStrike() {
        return strikeCount != 0 && ballCount != 0;
    }

    public boolean hasStrike() {
        return strikeCount != 0;
    }

    public boolean hasBall() {
        return ballCount != 0;
    }
}
