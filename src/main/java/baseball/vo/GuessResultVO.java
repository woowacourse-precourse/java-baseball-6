package baseball.vo;

import static baseball.constant.GameConstant.SUCCESS_STRIKE_COUNT;

public class GuessResultVO {

    private int strikeCount;
    private int ballCount;
    private boolean isCorrectAnswer;

    public GuessResultVO(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        this.isCorrectAnswer = (strikeCount == SUCCESS_STRIKE_COUNT);
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isCorrectAnswer() {
        return isCorrectAnswer;
    }
}
