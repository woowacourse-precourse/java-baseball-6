package baseball.model;

public class Hint {
    int ballCount;
    int strikeCount;

    public Hint(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public String toString() {
        if (ballCount == 0 && strikeCount == 0) {
            return "낫싱";
        } else if (ballCount == 0) {
            return strikeCount + "스트라이크";
        } else if (strikeCount == 0) {
            return ballCount + "볼";
        }
        return ballCount + "볼 " + strikeCount + "스트라이크";
    }
}
