package baseball.controller;

import baseball.domain.GameRestartOption;
import baseball.domain.RoundResult;
import baseball.domain.GameSet;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private GameController() {}

    public static void startGame() {
        OutputView.printStartMessage();
        GameRestartOption gameRestartOption;

        do {
            startGameSet();
            OutputView.printGameRestartMessage();
            gameRestartOption = GameRestartOption.from(InputView.readUserInput());
        } while (gameRestartOption.isRestart());
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
}
