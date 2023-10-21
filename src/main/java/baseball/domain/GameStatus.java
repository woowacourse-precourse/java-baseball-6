package baseball.domain;

public class GameStatus {

    private int ballCount;
    private int strikeCount;

    public GameStatus() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public void updateCount(Judgement judgement) {
        if (judgement == Judgement.STRIKE) {
            this.strikeCount++;
        }
        if (judgement == Judgement.BALL) {
            this.ballCount++;
        }
    }

    public boolean isThreeStrike() {
        return this.strikeCount == 3;
    }

    public boolean isNotThreeStrike() {
        return strikeCount != 3;
    }

    public void reset() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
