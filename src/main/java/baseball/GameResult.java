package baseball;

public class GameResult {
    private int ballCount;
    private int strikeCount;

    public GameResult() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

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

    public boolean isWin() {
        return strikeCount == 3;
    }
}