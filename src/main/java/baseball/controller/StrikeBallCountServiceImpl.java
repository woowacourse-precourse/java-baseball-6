package baseball.controller;

import baseball.member.ComputerNumbers;
import baseball.member.PlayerNumbers;
import baseball.view.OutputView;

public class StrikeBallCountServiceImpl implements StrikeBallCountService {
    private int strike;
    private int ball;

    public void countStrikeAndBall(PlayerNumbers playerNumbers, ComputerNumbers computerNumbers) {
        resetStrikeAndBall();
        countStrike(playerNumbers, computerNumbers);
        countBall(playerNumbers, computerNumbers);
        OutputView.printStrikeBallMessage(strike, ball);
    }

    private void resetStrikeAndBall() {
        strike = 0;
        ball = 0;
    }

    private void countStrike(PlayerNumbers playerNumbers, ComputerNumbers computerNumbers) {
        for(int numbersIndex = 0; numbersIndex< BaseballGameController.GAME_NUMBER_DIGIT; numbersIndex++) {
            if(isStrike(playerNumbers, computerNumbers, numbersIndex)) {
                strike++;
            }
        }
    }

    private void countBall(PlayerNumbers playerNumbers, ComputerNumbers computerNumbers) {
        for(int numbersIndex = 0; numbersIndex< BaseballGameController.GAME_NUMBER_DIGIT; numbersIndex++) {
            if(isBall(playerNumbers, computerNumbers, numbersIndex)) {
                ball++;
            }
        }
    }

    private boolean isStrike(PlayerNumbers playerNumbers, ComputerNumbers computerNumbers, int index) {
        return playerNumbers.getPlayerNumberAtIndex(index).equals(computerNumbers.getComputerNumberAtIndex(index));
    }

    private boolean isBall(PlayerNumbers playerNumbers, ComputerNumbers computerNumbers, int index) {
        return computerNumbers.getComputerNumbers().contains(playerNumbers.getPlayerNumberAtIndex(index)) &&
                !isStrike(playerNumbers, computerNumbers, index);
    }

    public boolean isGameClear() {
        return strike == BaseballGameController.GAME_NUMBER_DIGIT;
    }
}
