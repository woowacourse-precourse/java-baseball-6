package baseball.model;

import java.util.List;

public class Game {
    private static final int STRIKE_COUNT_PER_OUT = 3;
    private final BaseballNumbers computerBaseballNumbers;
    public boolean isGameOver = false;

    public Game() {
        this.computerBaseballNumbers = BaseballNumbers.createRandomBaseballNumbers();
    }

    public JudgeResult judge(BaseballNumbers userBaseballNumbers) {
        JudgeResult result = new JudgeResult();
        List<BaseballNumber> computerBasballNumberList = computerBaseballNumbers.getBaseballNumbers();
        List<BaseballNumber> userNumberList = userBaseballNumbers.getBaseballNumbers();
        for (int userNumberIdx = 0; userNumberIdx < BaseballNumbers.NUMBERS_LENGTH; userNumberIdx++) {
            BaseballNumber userNumber = userNumberList.get(userNumberIdx);
            if (isStrike(computerBasballNumberList, userNumber, userNumberIdx)) {
                result.strike();
            }
            if (isBall(computerBasballNumberList, userNumber, userNumberIdx)) {
                result.ball();
            }
        }

        if (result.getStrike() == STRIKE_COUNT_PER_OUT) {
            isGameOver = true;
        }
        return result;
    }

    private static boolean isBall(List<BaseballNumber> computerBasballNumberList, BaseballNumber userNumber, int userNumberIdx) {
        return computerBasballNumberList.contains(userNumber) && computerBasballNumberList.indexOf(userNumber) != userNumberIdx;
    }

    private static boolean isStrike(List<BaseballNumber> computerBasballNumberList, BaseballNumber userNumber, int userNumberIdx) {
        return computerBasballNumberList.contains(userNumber) && computerBasballNumberList.indexOf(userNumber) == userNumberIdx;
    }

}
