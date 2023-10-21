package baseball;

public class GameResult {
    private final int ballCount;
    private final int strikeCount;

    public GameResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public void result() {
        if (isNothing()) {
            System.out.println("낫싱");
        }
        if (!isNothing()) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }

    private boolean isNothing() {
        return ballCount == 0 && strikeCount == 0;
    }
}