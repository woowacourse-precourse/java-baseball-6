package baseball.dto;

public class ResultDTO {
    private final int strikeCount;
    private final int ballCount;

    public ResultDTO(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
