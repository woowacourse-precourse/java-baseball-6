package baseball;

import java.util.List;

public class Judge {

    public Result calculateResult(List<Integer> playerNumbers, List<Integer> answer) {
        int duplicateCount = countDuplicateIntegers(playerNumbers, answer);
        int strike = countStrike(playerNumbers, answer);
        int ball = countBall(duplicateCount, strike);

        return new Result(strike, ball);
    }

    private int countDuplicateIntegers(List<Integer> playerNumbers, List<Integer> answer) {
        int ball = 0;
        for (int i = 0; i < playerNumbers.size(); i++) {
            if (answer.contains(playerNumbers.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    private int countStrike(List<Integer> playerNumbers, List<Integer> answer) {
        int strike = 0;
        for (int i = 0; i < playerNumbers.size(); i++) {
            if (answer.get(i) == playerNumbers.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    private int countBall(int duplicateCount, int strike) {
        return duplicateCount - strike;
    }

    public boolean checkGameIsFinish(Result result) {
        return result.isAllStrike();
    }
}
