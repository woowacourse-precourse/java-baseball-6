package controller;

import domain.ComputerNumber;
import domain.PlayerNumber;
import view.InputView;
import view.OutputView;

public class BaseballController {
    ComputerNumber computerNumber = new ComputerNumber();
    PlayerNumber playerNumber = new PlayerNumber();

    public void gameStart() {
        OutputView.printGameStartMessage();
        do {
            computerNumber.createComputerNumbers();
            round();
            OutputView.printWinMessage();
        } while (InputView.inputRestart());

    }

    private void round() {
        do {
            playerNumber.setPlayerNumbers(InputView.inputPlayerNumbers());
            OutputView.printResult(computerNumber.countAndGetResult(playerNumber));
        } while (!playerNumber.isWin);
    }
}