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
        isExit = false;
        computer = new Computer();
        player = new Player();
    }

    public void start() {
        OutputView.printGameStartMessage();
        computer.generateRandomNumbers();

        while (!isExit) {
            getPlayerInput();
            computer.calculateResult(player.getNumbers());
            OutputView.printResult(computer.getBallCount(), computer.getStrikeCount());
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

        if (restartOrExitNumber == 1) {
            computer.generateRandomNumbers();
            return false;
        }
        return true;
    }
}
