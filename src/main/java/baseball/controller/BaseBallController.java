package baseball.controller;

import baseball.domain.ComputerNumber;
import baseball.domain.PlayerNumber;
import baseball.dto.CountResultDto;
import baseball.service.CountService;
import baseball.validation.ErrorMessage;
import baseball.common.GameValue;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallController {
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

    public boolean restartGame() {
        OutputView.printRetryMessage();
        String command = InputView.inputRetryCommand();
        if (command.equals(GameCommand.RESTART.getString())) {
            return true;
        }
        if (command.equals(GameCommand.END.getString())) {
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
