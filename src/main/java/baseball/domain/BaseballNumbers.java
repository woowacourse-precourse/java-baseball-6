package baseball.domain;

import java.util.List;
import java.util.Objects;

public class BaseballNumbers {
    private static final int ZERO_COUNT = 0;
    private static final int ONE_COUNT = 1;
    private final List<BaseballNumber> baseballNumbers;

    public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public static BaseballNumbers convertToBaseballNumbers(String input) {
        List<BaseballNumber> baseballNumbers = input.chars()
                .mapToObj(Character::getNumericValue)
                .map(BaseballNumber::new)
                .toList();
        return new BaseballNumbers(baseballNumbers);
    }

    public Score calculateScore(BaseballNumbers inputBaseballNumbers) {
        int ball = calculateBallCount(inputBaseballNumbers);
        int strike = calculateStrikeCount(inputBaseballNumbers);
        return Score.from(Ball.from(ball), Strike.from(strike));
    }

    private int calculateBallCount(BaseballNumbers inputBaseballNumbers) {
        int ball = ZERO_COUNT;
        for (int i = 0; i < baseballNumbers.size(); i++) {
            BaseballNumber currentAnswerBaseballNumber = baseballNumbers.get(i);
            BaseballNumber currentInputBaseballNumber = inputBaseballNumbers.baseballNumbers.get(i);
            boolean isSameValue = currentAnswerBaseballNumber.isSameValue(currentInputBaseballNumber);
            boolean isContainedIn = contains(currentInputBaseballNumber);
            ball += countBall(isSameValue, isContainedIn);
        }
        return ball;
    }

    private int calculateStrikeCount(BaseballNumbers inputBaseballNumbers) {
        int strike = ZERO_COUNT;
        for (int i = 0; i < baseballNumbers.size(); i++) {
            BaseballNumber currentAnswerBaseballNumber = baseballNumbers.get(i);
            BaseballNumber currentInputBaseballNumber = inputBaseballNumbers.baseballNumbers.get(i);
            boolean isSameValue = currentAnswerBaseballNumber.isSameValue(currentInputBaseballNumber);
            strike += countStrike(isSameValue);
        }
        return strike;
    }

    private boolean contains(BaseballNumber inputBaseballNumber) {
        return this.baseballNumbers.stream()
                .anyMatch(baseballNumber -> baseballNumber.isSameValue(inputBaseballNumber));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BaseballNumbers that)) {
            return false;
        }
        return Objects.equals(baseballNumbers, that.baseballNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseballNumbers);
    }
}
