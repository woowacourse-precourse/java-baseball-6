package baseball.controller;

import baseball.domain.ComputerNumber;
import baseball.domain.PlayerNumber;
import baseball.dto.CountResultDto;
import baseball.service.CountService;
import baseball.view.ErrorMessage;
import baseball.view.GameCommand;
import baseball.view.GameValue;
import baseball.view.InputView;
import baseball.view.GameMessage;
import baseball.view.OutputView;

public class BaseBallController {
    private final CountService countService;

    public BaseBallController(CountService countService) {
        this.countService = countService;
    }

    public void startGame() {
        System.out.println(GameMessage.START_GAME.getMessage());
        do {
            ComputerNumber computerNumber = ComputerNumber.getInstance();
            runGame(computerNumber);
        } while (restartGame());
    }

    public boolean restartGame() {
        System.out.println(GameMessage.ASK_RETRY.getMessage());
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
            System.out.print(GameMessage.INPUT_NUMBER.getMessage());
            String input = InputView.inputPlayerNumber();
            PlayerNumber playerNumber = PlayerNumber.from(input);
            CountResultDto countResultDto = countService.getCountResult(computerNumber, playerNumber);
            System.out.println(OutputView.printResult(countResultDto));
            gameStatus = isWinGame(countResultDto.getStrikeCount());
        }
    }

    private boolean isWinGame(int strikeCount) {
        if (strikeCount == GameValue.THREE_STRIKE.getValue()) {
            System.out.println(GameMessage.SUCCESS.getMessage());
            return false;
        }
        return true;
    }
}
