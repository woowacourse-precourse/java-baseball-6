package baseball.model;

import java.util.List;

public class Game {
    private static final int STRIKE_COUNT_PER_OUT = 3;
    private BaseballNumbers computerBaseballNumbers;
    private boolean isGameOver = false;

    public Game() {
    }

    public void init() {
        computerBaseballNumbers = BaseballNumbers.createRandomBaseballNumbers();
        isGameOver = false;
    }

    public JudgeResult judge(BaseballNumbers userBaseballNumbers) {
        JudgeResult result = new JudgeResult();
        List<BaseballNumber> computerBaseballNumberList = computerBaseballNumbers.getBaseballNumbers();
        List<BaseballNumber> userNumberList = userBaseballNumbers.getBaseballNumbers();
        for (int userNumberIdx = 0; userNumberIdx < BaseballNumbers.NUMBERS_LENGTH; userNumberIdx++) {
            BaseballNumber userNumber = userNumberList.get(userNumberIdx);
            int indexOfUserNumberInComputerNumbers = computerBaseballNumberList.indexOf(userNumber);
            if (isStrike(indexOfUserNumberInComputerNumbers, userNumberIdx)) {
                result.strike();
            }
            if (isBall(indexOfUserNumberInComputerNumbers, userNumberIdx)) {
                result.ball();
            }
        }

        checkGameOver(result);
        return result;
    }

    private void checkGameOver(JudgeResult result) {
        if (result.getStrike() == STRIKE_COUNT_PER_OUT) {
            isGameOver = true;
        }
    }

    private static boolean isBall(int indexOfUserNumberInComputerNumbers, int userNumberIdx) {
        return indexOfUserNumberInComputerNumbers != -1 && indexOfUserNumberInComputerNumbers != userNumberIdx;
    }

    private static boolean isStrike(int indexOfUserNumberInComputerNumbers, int userNumberIdx) {
        return indexOfUserNumberInComputerNumbers == userNumberIdx;
    }

    public boolean isGameOver() {
        return isGameOver;
    }
}
