package baseball;

public class GameResult {
    private final int ballConunt;
    private final int strikeCount;

    public GameResult(int ballConunt, int strikeCount) {
        this.ballConunt = ballConunt;
        this.strikeCount = strikeCount;
    }

    public int ballCount() {
        return ballConunt;
    }

    public int strikeCount() {
        return strikeCount;
    }

    public boolean isCorrect() {
        return strikeCount == 3;
    }
}
