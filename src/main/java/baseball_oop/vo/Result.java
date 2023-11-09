package baseball_oop.vo;

public class Result {
    private int strikeCount;
    private int ballCount;

    private final int LENGTH_LIMIT = 3;


    public Result(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public boolean isWin() {
        return this.strikeCount == LENGTH_LIMIT;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
