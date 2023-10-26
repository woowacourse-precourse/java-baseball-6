package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {
    private static final int RESTART = 1;
    private Computer computer;
    private Player player;

    public BaseballGame(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public void start() {
        OutputView.printGameStartMessage();
        computer.generateRandomNumbers();

        while (!computer.isGameExited()) {
            OutputView.printInputMessage();
            getPlayerInput();

            computer.resetHint();
            computer.calculateHint(player.getNumbers());
            OutputView.printResult(computer.makeResult());

            if (computer.isGameExited()) {
                restartOrExit();
            }
        }
    }

    private void getPlayerInput() {
        player.setNumbers(InputView.inputPlayerNumbers());
    }

    private void restartOrExit() {
        OutputView.printGameExitMessage();
        OutputView.printAskRestartOrExit();
        int restartOrExitNumber = InputView.inputRestartOrExitNumber();

        if (restartOrExitNumber == RESTART) {
            computer.resetHint();
            computer.generateRandomNumbers();
        }
    }
}
