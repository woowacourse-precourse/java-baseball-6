package baseball.domain.results;

import baseball.utility.ResultsUtils;

public class Results {

    private final int BALL_COUNT = 3;

    private int strikeCount = 0;
    private int ballCount = 0;

    public Results() {}

    public Results(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    @Override
    public String toString() {
        return ResultsUtils.getStringValueOfResults(strikeCount, ballCount);
    }

    public void addResultStatus(ResultStatus resultStatus) {
        if (resultStatus == ResultStatus.STRIKE) {
            strikeCount++;
        }
        if (resultStatus == ResultStatus.BALL) {
            ballCount++;
        }
    }

    public boolean isAnswer() {
        return strikeCount == BALL_COUNT;
    }

}
