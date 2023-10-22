package baseball;

import java.util.List;

public class StrikeBallCounter {
    private int strike;
    private int ball;

    public void countStrikeAndBall(List<Integer> userNumbers, List<Integer> computerNumbers) {
        resetStrikeAndBall();
        countStrike(userNumbers, computerNumbers);
        countBall(userNumbers, computerNumbers);
        Output.printStrikeBallMessage(strike, ball);
    }

    private void resetStrikeAndBall() {
        strike = 0;
        ball = 0;
    }

    private void countStrike(List<Integer> userNumbers, List<Integer> computerNumbers) {
        for(int numbersIndex = 0; numbersIndex< BaseballGame.GAME_NUMBER_DIGIT; numbersIndex++) {
            if(userNumbers.get(numbersIndex).equals(computerNumbers.get(numbersIndex))) {
                strike++;
            }
        }
    }

    private void countBall(List<Integer> userNumbers, List<Integer> computerNumbers) {
        for(int numbersIndex = 0; numbersIndex< BaseballGame.GAME_NUMBER_DIGIT; numbersIndex++) {
            if(computerNumbers.contains(userNumbers.get(numbersIndex)) &&
                    !computerNumbers.get(numbersIndex).equals(userNumbers.get(numbersIndex))) {
                ball++;
            }
        }
    }

    public boolean isGameClear() {
        return strike==BaseballGame.GAME_NUMBER_DIGIT;
    }
}
