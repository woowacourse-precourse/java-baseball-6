package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {
    private static final int STRIKE_THRESHOLD = 3;
    private static final int RESTART = 1;
    private Computer computer;
    private Player player;
    private boolean isExit;

    public BaseballGame(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
        isExit = false;
    }

    public void start() {
        OutputView.printGameStartMessage();
        computer.generateRandomNumbers();

        while (!isExit) {
            getPlayerInput();
            computer.calculateHint(player.getNumbers());
            OutputView.printResult(computer.makeResult());

            if (isGameExited()) {
                isExit = restartOrExit();
            }
        }
    }

    private void getPlayerInput() {
        player.setNumbers(InputView.inputPlayerNumbers());
    }

    private boolean isGameExited() {
        return computer.getStrikeCount() == STRIKE_THRESHOLD;
    }

    private boolean restartOrExit() {
        OutputView.printGameExitMessage();
        int restartOrExitNumber = InputView.inputRestartOrExitNumber();

        if (restartOrExitNumber == RESTART) {
            computer.generateRandomNumbers();
            return false;
        }
        return true;
    }
}
