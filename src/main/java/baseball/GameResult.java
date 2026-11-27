package baseball;

public class GameResult {
    private final int ballCount;
    private final int strikeCount;

    public GameResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int ballCount() {
        return ballCount;
    }

    public int strikeCount() {
        return strikeCount;
    }

    public boolean isCorrect() {
        return strikeCount == 3;
    }
}
