package baseball.game.model.dto;

public class RoundResult {
    private int ballCount;

    private int strikeCount;

    public RoundResult(int ballCount, int strikeCount) {
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
