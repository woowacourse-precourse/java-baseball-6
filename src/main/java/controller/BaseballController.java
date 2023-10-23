package controller;

import domain.ComputerNumber;
import domain.PlayerNumber;
import view.InputView;
import view.OutputView;

public class BaseballController {
    ComputerNumber computerNumber = new ComputerNumber();
    PlayerNumber playerNumber = new PlayerNumber();

    public void startGame() {
        OutputView.printGameStartMessage();
        do {
            computerNumber.createComputerNumbers();
            playRound();
            OutputView.printWinMessage();
        } while (InputView.inputRestart());

    }

    private void playRound() {
        do {
            playerNumber.setPlayerNumbers(InputView.inputPlayerNumbers());
            OutputView.printResult(computerNumber.countAndGetResult(playerNumber));
        } while (!playerNumber.isWin);
    }
}