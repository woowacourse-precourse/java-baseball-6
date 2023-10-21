package baseball.domain;

public class Result {

    private final int strikeCount;
    private final int ballCount;

    public Result(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean hasClearedGame(int numberCount) {
        return strikeCount == numberCount;
    }

}
