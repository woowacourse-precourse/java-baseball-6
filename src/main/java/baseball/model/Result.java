package baseball.model;

public class Result {
    private final ResultCase resultCase;
    private final int strikeCount;
    private final int ballCount;

    private Result(ResultCase resultCase, int strikeCount, int ballCount) {
        this.resultCase = resultCase;
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static Result of(ResultCase resultCase, int strikeCount, int ballCount) {
        return new Result(resultCase, strikeCount, ballCount);
    }

    public ResultCase getResultCase() {
        return resultCase;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
