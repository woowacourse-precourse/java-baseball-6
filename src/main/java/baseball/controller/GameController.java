package baseball.controller;

import baseball.domain.RoundResult;
import baseball.service.GameService;
import baseball.service.GameSetService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private GameController() {}

    public static void startGame() {
        OutputView.printStartMessage();

        do {
            startGameSet();
        } while (determineGameRestart());
    }

    private static void startGameSet() {
        GameSetService gameSetService = GameService.startGameSet();
        while (!gameSetService.isSetEnd()) {
            playRound(gameSetService);
        }

        OutputView.printSetEndMessage();
    }

    private static void playRound(GameSetService gameSetService) {
        OutputView.printGameNumbersInputMessage();
        String userNumbersInput = InputView.readUserInput();
        RoundResult roundResult = gameSetService.playRound(userNumbersInput);

        printRoundResult(roundResult);
    }
    
    private static void printRoundResult(RoundResult roundResult) {
        if (roundResult.isNothing()) {
            OutputView.printNothingResult();
            return;
        }

        OutputView.printBallAndStrikeResult(roundResult);
    }

    private static boolean determineGameRestart() {
        OutputView.printGameRestartMessage();
        String restartOption = InputView.readUserInput();

        return GameService.isRestart(restartOption);
    }
}
