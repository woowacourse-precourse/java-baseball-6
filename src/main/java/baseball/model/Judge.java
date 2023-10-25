package baseball.model;

import baseball.Result;

import java.util.List;


public class Judge {
    public boolean checkGameOver(Result result) {
        return result.isAllStrike();
    }

    public Result makeResult(List<Integer> answer, List<Integer> playerNumbers) {
        int duplicate = countDuplicateIntegers(answer, playerNumbers);
        int strike = countStrike(answer, playerNumbers);
        int ball = calculateBall(duplicate, strike);

        return new Result(ball, strike);
    }

    private int countDuplicateIntegers(List<Integer> answer, List<Integer> playerNumbers) {
        int duplicate = 0;
        for (int i = 0; i < playerNumbers.size(); i++) {
            if (answer.contains(playerNumbers.get(i))) {
                duplicate++;
            }
        }
        return duplicate;
    }

    private int countStrike(List<Integer> answer, List<Integer> playerNumbers) {
        int strike = 0;
        for (int i = 0; i < playerNumbers.size(); i++) {
            if (answer.get(i).equals(playerNumbers.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private int calculateBall(int duplicate, int strike) {
        return duplicate - strike;
    }
}
