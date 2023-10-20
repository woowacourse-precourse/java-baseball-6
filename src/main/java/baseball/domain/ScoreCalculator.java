package baseball.domain;

import baseball.constant.BaseballConstant;

import java.util.List;

public class ScoreCalculator {
    private int strike  = 0;
    private int ball = 0;
    private int nothing = 0;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public int getNothing() {
        return nothing;
    }

    public void calculate(List<Integer> randomNumbers, List<Integer> playerNumbers){

        for (int tempSize = 0; tempSize < BaseballConstant.NUMBER_SIZE; tempSize ++) {
            int randomNumber = randomNumbers.get(tempSize);
            int playerNumber = playerNumbers.get(tempSize);

            calculateStrike(randomNumber, playerNumber);
            calculateBall(randomNumbers, randomNumber, playerNumber);
        }
        calculateNothing();
    }

    private void calculateNothing() {
        if (strike == 0 && ball == 0) {
            nothing++;
        }
    }

    private void calculateBall(List<Integer> randomNumbers, int randomNumber, int playerNumber) {
        if (randomNumbers.contains(playerNumber) && randomNumber != playerNumber) {
            ball++;
        }
    }

    private void calculateStrike(int randomNumber, int playerNumber) {
        if (randomNumber == playerNumber) {
            strike++;
        }
    }
}
