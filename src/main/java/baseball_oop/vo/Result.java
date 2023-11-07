package baseball_oop.vo;

public class Result {
    private int ballCount;
    private int strikeCount;

    private final int LENGTH_LIMIT = 3;


    public Result(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public boolean isWin() {
        return this.strikeCount == LENGTH_LIMIT;
    }

}
