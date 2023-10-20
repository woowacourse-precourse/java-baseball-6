package baseball.domain;

public class GameStatus {

    private int ballCount;
    private int strikeCount;

    public GameStatus() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public boolean isNotThreeStrike() {
        return strikeCount != 3;
    }

    public void updateCount(Judgement judgement) {
        if (judgement == Judgement.STRIKE) {
            this.strikeCount++;
        }
        if (judgement == Judgement.BALL) {
            this.ballCount++;
        }
    }
}
