package baseball.dto;

public class Result {
    private final int ballCount;
    private final int strikeCount;

    public Result(final int ballCount, final int strikeCount) {
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

