package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.service.GameResultService;
import baseball.model.PlayerChoice;
import baseball.model.PlayerNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    public static boolean run() {
        ComputerNumber computerNumber = createComputerNumber();

        boolean needNextRound = true;
        while (needNextRound) {
            needNextRound = play(computerNumber);
        }
        return doRestart();
    }

    private static ComputerNumber createComputerNumber() {
        return ComputerNumber.create();
    }

    private static boolean play(ComputerNumber computerNumber) {

        OutputView.printGetInput();
        String input = InputView.readInput();
        PlayerNumber playerNumber = PlayerNumber.create(input);

        GameResultService gameResultService = new GameResultService(computerNumber, playerNumber);

        OutputView.printResult(gameResultService.isNothing(), gameResultService.getBallCount(), gameResultService.getStrikeCount());

        return !gameResultService.isThreeStrike();
    }

    private static boolean doRestart() {
        OutputView.printEnd();
        String input = InputView.readInput();
        PlayerChoice playerChoice = new PlayerChoice(input);
        return playerChoice.getValue() == 1;
    }
}
