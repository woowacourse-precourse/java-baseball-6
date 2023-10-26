package baseball.controller;

import baseball.common.GameValue;
import baseball.domain.Computer;
import baseball.domain.NumberGenerator;
import baseball.domain.Player;
import baseball.dto.CountResultDto;
import baseball.validation.ErrorMessage;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallController {
    private static final String RESTART = "1";
    private static final String END = "2";

    public void startGame() {
        OutputView.printGameStartMessage();
        do {
            Computer computer = new Computer(NumberGenerator.createComputerNumber());
            runGame(computer);
        } while (restartGame());
    }

    private boolean restartGame() {
        OutputView.printRetryMessage();
        String command = InputView.inputRetryCommand();
        if (command.equals(RESTART)) {
            return true;
        }
        if (command.equals(END)) {
            return false;
        }
        throw new IllegalArgumentException(ErrorMessage.RESTART_COMMAND.getMessage());
    }

    private void runGame(Computer computer) {
        boolean gameStatus = true;
        while (gameStatus) {
            OutputView.printInputMessage();
            String input = InputView.inputPlayerNumber();
            Player player = new Player(NumberGenerator.createPlayerNumber(input));
            CountResultDto countResult = computer.match(player);
            OutputView.printResult(countResult);
            gameStatus = isWinGame(countResult.getStrikeCount());
        }
    }

    private boolean isWinGame(int strikeCount) {
        if (strikeCount == GameValue.THREE_STRIKE.getValue()) {
            OutputView.printWinGameMessage();
            return false;
        }
        return true;
    }
}
