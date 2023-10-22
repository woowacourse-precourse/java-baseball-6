package baseball.model;

import java.util.List;

public class Game {
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
            if (isNothing(computerBasballNumberList, userNumber)) continue;
            if (isStrike(computerBasballNumberList, userNumber, userNumberIdx)) {
                result.strike();
                continue;
            }
            if (isBall(computerBasballNumberList, userNumber, userNumberIdx)) {
                result.ball();
            }
        }
        return result;
    }

    private static boolean isBall(List<BaseballNumber> computerBasballNumberList, BaseballNumber userNumber, int userNumberIdx) {
        return computerBasballNumberList.contains(userNumber) && computerBasballNumberList.indexOf(userNumber) != userNumberIdx;
    }

    private static boolean isStrike(List<BaseballNumber> computerBasballNumberList, BaseballNumber userNumber, int userNumberIdx) {
        return computerBasballNumberList.contains(userNumber) && computerBasballNumberList.indexOf(userNumber) == userNumberIdx;
    }

    private static boolean isNothing(List<BaseballNumber> computerBasballNumberList, BaseballNumber userNumber) {
        return !computerBasballNumberList.contains(userNumber);
    }

}
