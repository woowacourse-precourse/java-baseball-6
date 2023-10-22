package baseball.model;

import java.util.List;

public class BaseballGame {
    private static final int BASEBALL_NUMBERS_LENGTH = 3;

    private final List<BaseballNumber> computerBaseballNumbers;
    private List<BaseballNumber> userBaseballNumbers;

    public BaseballGame(List<BaseballNumber> computerBaseballNumbers, List<BaseballNumber> userBaseballNumbers) {
        this.computerBaseballNumbers = computerBaseballNumbers;
        this.userBaseballNumbers = userBaseballNumbers;
    }

    public void resetUserBaseballNumbers(List<BaseballNumber> userBaseballNumbers) {
        this.userBaseballNumbers = userBaseballNumbers;
    }

    public int getBallCount() {
        int ballCount = 0;
        for (int index = 0; index < BASEBALL_NUMBERS_LENGTH; index++) {
            BaseballNumber userBaseballNumber = userBaseballNumbers.get(index);
            BaseballNumber randomBaseballNumber = computerBaseballNumbers.get(index);
            if (!userBaseballNumber.equals(randomBaseballNumber) && computerBaseballNumbers.contains(
                    userBaseballNumber)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public int getStrikeCount() {
        int strikeCount = 0;
        for (int index = 0; index < BASEBALL_NUMBERS_LENGTH; index++) {
            BaseballNumber userBaseballNumber = userBaseballNumbers.get(index);
            BaseballNumber randomBaseballNumber = computerBaseballNumbers.get(index);
            if (userBaseballNumber.equals(randomBaseballNumber)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public boolean isAnswer() {
        return getStrikeCount() == BASEBALL_NUMBERS_LENGTH;
    }
}
