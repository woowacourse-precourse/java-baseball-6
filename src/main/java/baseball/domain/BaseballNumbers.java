package baseball.domain;

import java.util.List;

public class BaseballNumbers {
    private static final int ZERO_COUNT = 0;
    private static final int ONE_COUNT = 1;
    private final List<BaseballNumber> baseballNumbers;

    public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    protected Score calculateScore(BaseballNumbers inputBaseballNumbers) {
        int ball = ZERO_COUNT;
        int strike = ZERO_COUNT;
        for (int i = 0; i < baseballNumbers.size(); i++) {
            BaseballNumber currentAnswerBaseballNumber = baseballNumbers.get(i);
            BaseballNumber currentInputBaseballNumber = inputBaseballNumbers.baseballNumbers.get(i);
            boolean isSameValue = currentAnswerBaseballNumber.isSameValue(currentInputBaseballNumber);
            boolean isContainedIn = currentInputBaseballNumber.isContainedIn(baseballNumbers);
            ball += countBall(isSameValue, isContainedIn);
            strike += countStrike(isSameValue);
        }
        return new Score(new Ball(ball), new Strike(strike));
    }

    private int countBall(boolean isSameValue, boolean isContainedIn) {
        if (!isSameValue && isContainedIn) {
            return ONE_COUNT;
        }
        return ZERO_COUNT;
    }

    private int countStrike(boolean isSameValue) {
        if (isSameValue) {
            return ONE_COUNT;
        }
        return ZERO_COUNT;
    }
}
