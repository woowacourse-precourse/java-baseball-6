package baseball;

import java.util.List;

public class BaseballGame {
    private final int computerNumber;

    public BaseballGame(int computerNumber, int computerNumberCount) {
        String computerNumberString = String.valueOf(computerNumber);
        if (!Util.validateInputNumber(computerNumberString, computerNumberCount)) {
            throw new IllegalArgumentException("컴퓨터의 숫자로 올바르지 않습니다.");
        }

        this.computerNumber = computerNumber;
    }

    public BaseballGameResult play(int inputNumber) {
        if (computerNumber == inputNumber) {
            int numberLength = String.valueOf(inputNumber).length();
            return new BaseballGameResult(numberLength, 0);
        }

        return getBaseBallGameResult(inputNumber);
    }

    private BaseballGameResult getBaseBallGameResult(int inputNumber) {
        int[] computerNumberArray = Util.split(computerNumber);
        int[] inputNumberArray = Util.split(inputNumber);

        int ball = 0;
        int strike = 0;

        for (int i = 0; i < inputNumberArray.length; i++) {
            strike += isStrike(computerNumberArray, inputNumberArray, i) ? 1 : 0;
            ball += isBall(computerNumberArray, inputNumberArray, i) ? 1 : 0;
        }

        return new BaseballGameResult(strike, ball);
    }

    private boolean isBall(int[] computerNumberArray, int[] inputNumberArray, int i) {
        List<Integer> removedComputerNumberList = Util.removeByIndex(computerNumberArray, i);
        return removedComputerNumberList.contains(inputNumberArray[i]);
    }

    private boolean isStrike(int[] computerNumberArray, int[] inputNumberArray, int i) {
        return inputNumberArray[i] == computerNumberArray[i];
    }
}
