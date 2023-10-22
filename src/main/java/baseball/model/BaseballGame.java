package baseball.model;

public class BaseballGame {
    private static final int BASEBALL_NUMBERS_LENGTH = 3;

    private final BaseballNumbers computerBaseballNumbers;
    private BaseballNumbers userBaseballNumbers;

    public BaseballGame(BaseballNumbers computerBaseballNumbers, BaseballNumbers userBaseballNumbers) {
        this.computerBaseballNumbers = computerBaseballNumbers;
        this.userBaseballNumbers = userBaseballNumbers;
    }

    public void resetUserBaseballNumbers(BaseballNumbers userBaseballNumbers) {
        this.userBaseballNumbers = userBaseballNumbers;
    }

    public int getBallCount() {
        int ballCount = 0;
        for (int index = 0; index < BASEBALL_NUMBERS_LENGTH; index++) {
            BaseballNumber userBaseballNumber = userBaseballNumbers.getBaseballNumber(index);
            BaseballNumber randomBaseballNumber = computerBaseballNumbers.getBaseballNumber(index);
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
            BaseballNumber userBaseballNumber = userBaseballNumbers.getBaseballNumber(index);
            BaseballNumber randomBaseballNumber = computerBaseballNumbers.getBaseballNumber(index);
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
