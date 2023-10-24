package baseball.dto.response;

public class GameResultResponse {
    private final int ballCount;
    private final int strikeCount;

    public GameResultResponse(final int ballCount, final int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
