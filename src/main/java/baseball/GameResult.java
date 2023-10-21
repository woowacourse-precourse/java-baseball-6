package baseball;

public class GameResult {
    private final int ballCount;
    private final int strikeCount;

    public GameResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public void result() {
        System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
    }
}