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
            computer.countScore(player.getNumbers());
            OutputView.printResult(computer);

            if (computer.getStrikeCount() == STRIKE_THRESHOLD) {
                restartOrExitGame();
            }
        }
    }

    public void restartOrExitGame() {
        OutputView.printGameExitMessage();
        int restartOrExitNumber = InputView.inputRestartOrExitNumber();

        if (restartOrExitNumber == 2) {
            isExit = true;
        } else if (restartOrExitNumber == 1) {
            isExit = false;
            computer.generateRandomNumbers();
        }
    }
}
