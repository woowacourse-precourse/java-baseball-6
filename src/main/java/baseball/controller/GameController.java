package baseball.controller;

import baseball.domain.RoundResult;
import baseball.domain.GameSet;
import baseball.service.GameService;
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
        GameSet gameset = GameService.startGameSet();
        while (!gameset.isSetEnd()) {
            playRound(gameset);
        }

        OutputView.printSetEndMessage();
    }

    private static void playRound(GameSet gameSet) {
        OutputView.printGameNumbersInputMessage();
        String userNumbersInput = InputView.readUserInput();
        RoundResult roundResult = gameSet.playRound(userNumbersInput);

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
