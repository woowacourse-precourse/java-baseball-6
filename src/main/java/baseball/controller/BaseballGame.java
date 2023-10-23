package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {
    private static final int STRIKE_THRESHOLD = 3;
    private Computer computer;
    private Player player;
    private boolean isExit;

    public BaseballGame() {
        this.isExit = false;
        computer = new Computer();
        player = new Player();
    }

    public void startGame() {
        OutputView.printGameStartMessage();
        computer.generateRandomNumbers();

        while (!isExit) {
            player.setNumbers(InputView.inputPlayerNumbers());

            computer.resetCount();
            computer.calculateResult(player.getNumbers());
            OutputView.printResult(computer);

            if (computer.getStrikeCount() == STRIKE_THRESHOLD) {
                isExit = restartOrExitGame();
            }
        }
    }

    private boolean restartOrExitGame() {
        OutputView.printGameExitMessage();
        int restartOrExitNumber = InputView.inputRestartOrExitNumber();

        if (restartOrExitNumber == 1) {
            computer.generateRandomNumbers();
            return false;
        }
        return true;
    }
}
