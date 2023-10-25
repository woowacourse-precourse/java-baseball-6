package baseball.calculator;

import baseball.result.BaseballGameResult;

/**
 * @author 민경수
 * @description result calculator
 * @since 2023.10.23
 **********************************************************************************************************************/
public class ResultCalculator {

    public BaseballGameResult calculate(int[] userInputNumber, int[] randomNumber) {
        int strike = countStrike(userInputNumber, randomNumber);
        if (isThreeStrike(strike)) {
            return new BaseballGameResult(3, 0, true);
        }

        int ball = countBall(userInputNumber, randomNumber);

        return new BaseballGameResult(strike, ball, false);
    }

    private int countBall(int[] userInputNumber, int[] randomNumber) {
        int count = 0;

        for (int i = 0; i < userInputNumber.length; i++) {
            count += findBallCount(i, userInputNumber, randomNumber);
        }

        return count;
    }

    private int findBallCount(int index, int[] userInputNumber, int[] randomNumber) {
        int count = 0;

        for (int j = 0; j < randomNumber.length; j++) {
            if (index != j && userInputNumber[index] == randomNumber[j]) {
                count += 1;
            }
        }

        return count;
    }

    private int countStrike(int[] userInputNumber, int[] randomNumber) {
        int count = 0;

        for (int i = 0; i < userInputNumber.length; i++) {
            if (userInputNumber[i] == randomNumber[i]) {
                count += 1;
            }
        }

        return count;
    }

    private boolean isThreeStrike(int strike) {
        return strike == 3;
    }

}