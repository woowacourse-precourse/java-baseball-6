package baseball.model;

public class GameResult {
    private Integer ballCount;
    private Integer strikeCount;

    public GameResult(Integer ballCount, Integer strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public Integer getBallCount() {
        return ballCount;
    }

    public Integer getStrikeCount() {
        return strikeCount;
    }
}
