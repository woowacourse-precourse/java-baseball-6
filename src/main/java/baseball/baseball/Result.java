package baseball.baseball;

import static baseball.common.Constant.BALL_AMOUNT;

public class Result {

    private int strikeCount;
    private int ballCount;

    public Result() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }

    public int getBallCount() {
        return this.ballCount;
    }

    public Boolean isAllStrikes() {
        return this.strikeCount == BALL_AMOUNT;
    }

    public void increaseStrikeCount() {
        this.strikeCount++;
    }

    public void increaseBallCount() {
        this.ballCount++;
    }

}
