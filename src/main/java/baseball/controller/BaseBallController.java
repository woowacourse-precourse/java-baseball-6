package baseball.controller;

import baseball.domain.ComputerNumber;
import baseball.dto.CountResultDto;
import baseball.domain.PlayerNumber;
import baseball.service.ComputerNumberService;
import baseball.service.CountService;
import baseball.view.GameValue;
import baseball.view.InputView;
import baseball.view.GameMessage;
import baseball.view.OutputView;

public class BaseBallController {

    public void startGame() {
        System.out.println(GameMessage.START_GAME.getMessage());
        ComputerNumber computerNumber = ComputerNumberService.generateComputerNumber();
        runGame(computerNumber);
    }

    public void runGame(ComputerNumber computerNumber) {
        boolean gameStatus = true;

        while (gameStatus) {
            System.out.print(GameMessage.INPUT_NUMBER.getMessage());
            PlayerNumber playerNumber = InputView.inputPlayerNumber();
            CountResultDto countResultDto = CountService.calculateCount(computerNumber.getNumber(), playerNumber.getNumber());
            System.out.println(OutputView.printResult(countResultDto));
            System.out.println(computerNumber);
            gameStatus = isWinGame(countResultDto.getStrikeCount());
        }
    }

    public boolean isWinGame(int strikeCount) {
        if (strikeCount == GameValue.THREE_STRIKE.getValue()) {
            System.out.println(GameMessage.SUCCESS.getMessage());
            return false;
        }
        return true;
    }
}
