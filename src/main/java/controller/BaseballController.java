package controller;

import domain.Computer;
import domain.Player;
import view.InputView;
import view.OutputView;

public class BaseballController {
    Computer computer = new Computer();
    Player player = new Player();

    public void startGame() {
        OutputView.printGameStartMessage();
        do {
            computer.createComputerNumbers();
            playRound();
            OutputView.printWinMessage();
        } while (InputView.inputRestart());
    }

    private void playRound() {
        do {
            player.setPlayerNumbers(InputView.inputPlayerNumbers());
            OutputView.printResult(computer.getResult(player.playerNumbers));
        } while (!computer.isPlayerWin);
    }
}