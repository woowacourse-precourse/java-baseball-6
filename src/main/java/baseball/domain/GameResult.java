package baseball.domain;

import static baseball.service.NumberGenerator.NUMBER_COUNT;

public class GameResult {

    private int ballCount;
    private int strikeCount;

    public GameResult() {
        initCount();
    }

    public void initCount() {
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
        return this.strikeCount == NUMBER_COUNT;
    }

    public boolean isNotThreeStrike() {
        return strikeCount != NUMBER_COUNT;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
