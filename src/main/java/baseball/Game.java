package baseball;

import static baseball.Application.MAX_NUMBER_SIZE;

public class Game {
    private ComputerNumber computerNumber;
    private PlayerNumber playerNumber;
    private RestartNumber restartNumber;
    private CalculateResult calculator;
    public void run() {
        InputOutput.printGameStart();
        do {
            startGame();
        } while (checkRestart());
    }
    private void startGame() {
        setComputerNumber();
        int[] result;
        do {
            setPlayerNumber();
            result = calculateResult();
            printResult(result);
        } while (!isAnswer(result));
    }
    private void setComputerNumber() {
        computerNumber = new ComputerNumber();
    }
    private void setPlayerNumber() {
        playerNumber = new PlayerNumber(InputOutput.inputPlayerNumber());
    }
    private int[] calculateResult() {
        calculator = new CalculateResult(computerNumber, playerNumber);
        return calculator.getResult();
    }

    private void printResult(int[] gameResult) {
        int strike = gameResult[0];
        int ball = gameResult[1];
        InputOutput.printResult(strike, ball);
    }
    private boolean isAnswer(int[] gameResult) {
        int strike = gameResult[0];
        if (strike == MAX_NUMBER_SIZE) {
            InputOutput.printGameEnd();
            return true;
        }
        return false;
    }
    private boolean checkRestart() {
        restartNumber = new RestartNumber(InputOutput.inputRestartNumber());
        return restartNumber.isRestart();
    }
}
