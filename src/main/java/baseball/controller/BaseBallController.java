package baseball.controller;

import baseball.domain.ComputerNumber;
import baseball.dto.CountResultDto;
import baseball.domain.PlayerNumber;
import baseball.service.ComputerNumberService;
import baseball.service.CountService;
import baseball.view.ErrorMessage;
import baseball.view.GameValue;
import baseball.view.InputView;
import baseball.view.GameMessage;
import baseball.view.OutputView;

public class BaseBallController {
    private final static String RESTART = "1";
    private final static String END = "2";

    public void startGame() {
        System.out.println(GameMessage.START_GAME.getMessage());
        ComputerNumber computerNumber = ComputerNumberService.generateComputerNumber();
        runGame(computerNumber);
    }

    private void runGame(ComputerNumber computerNumber) {
        boolean gameStatus = true;

        while (gameStatus) {
            System.out.print(GameMessage.INPUT_NUMBER.getMessage());
            PlayerNumber playerNumber = InputView.inputPlayerNumber();
            CountResultDto countResultDto = CountService.calculateCount(computerNumber.getNumber(), playerNumber.getNumber());
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

    public boolean restartGame() {
        System.out.println(GameMessage.ASK_RETRY.getMessage());
        String command = InputView.inputRetryCommand();

        if (command.equals(RESTART)) {
            return true;
        }
        if (command.equals(END)) {
            System.out.println(GameMessage.END_GAME.getMessage());
            return false;
        }

        throw new IllegalArgumentException(ErrorMessage.RESTART_COMMAND.getMessage());
    }
}
