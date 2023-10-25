package baseball.controller;

import baseball.common.GameValue;
import baseball.domain.ComputerNumber;
import baseball.domain.PlayerNumber;
import baseball.dto.CountResultDto;
import baseball.service.CountService;
import baseball.validation.ErrorMessage;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallController {
    private static final String RESTART = "1";
    private static final String END = "2";
    private final CountService countService;

    public BaseBallController(CountService countService) {
        this.countService = countService;
    }

    public void startGame() {
        OutputView.printGameStartMessage();
        do {
            ComputerNumber computerNumber = ComputerNumber.getInstance();
            runGame(computerNumber);
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

    private void runGame(ComputerNumber computerNumber) {
        boolean gameStatus = true;
        while (gameStatus) {
            OutputView.printInputMessage();
            String input = InputView.inputPlayerNumber();
            PlayerNumber playerNumber = PlayerNumber.from(input);
            CountResultDto countResultDto = countService.getCountResult(computerNumber, playerNumber);
            OutputView.printResult(countResultDto);
            gameStatus = isWinGame(countResultDto.getStrikeCount());
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
