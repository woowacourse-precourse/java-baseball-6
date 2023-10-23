package baseball;

public class StrikeBallCounter {
    private int strike;
    private int ball;

    public void countStrikeAndBall(PlayerNumbers playerNumbers, ComputerNumbers computerNumbers) {
        resetStrikeAndBall();
        countStrike(playerNumbers, computerNumbers);
        countBall(playerNumbers, computerNumbers);
        Output.printStrikeBallMessage(strike, ball);
    }

    private void resetStrikeAndBall() {
        strike = 0;
        ball = 0;
    }

    private void countStrike(PlayerNumbers playerNumbers, ComputerNumbers computerNumbers) {
        for(int numbersIndex = 0; numbersIndex< BaseballGame.GAME_NUMBER_DIGIT; numbersIndex++) {
            if(isStrike(playerNumbers, computerNumbers, numbersIndex)) {
                strike++;
            }
        }
    }

    private void countBall(PlayerNumbers playerNumbers, ComputerNumbers computerNumbers) {
        for(int numbersIndex = 0; numbersIndex< BaseballGame.GAME_NUMBER_DIGIT; numbersIndex++) {
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
        return strike==BaseballGame.GAME_NUMBER_DIGIT;
    }
}
