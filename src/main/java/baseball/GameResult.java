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
        String result = "";
        if (isNothing()) {
            result += "낫싱";
        }
        if (ballCount > 0) {
            result += ballCount + "볼 ";
        }
        if (strikeCount > 0) {
            result += strikeCount + "스트라이크";
        }
        System.out.println(result);
    }

    private boolean isNothing() {
        return ballCount == 0 && strikeCount == 0;
    }

    public boolean isWin() {
        return strikeCount == 3;
    }
}