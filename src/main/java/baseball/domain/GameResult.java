package baseball.domain;

public class GameResult {
    private int strikeCount = 0;

    private int ballCount = 0;

    public void strike() {
        this.strikeCount++;
    }

    public void ball() {
        this.ballCount++;
    }
}
