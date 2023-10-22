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

        startGameSet();
    }

    private static void startGameSet() {
        GameSet gameset = GameService.startGameSet();
        while (!gameset.isSetEnd()) {
            playRound(gameset);
        }
    }

    private static void playRound(GameSet gameSet) {
        String userNumbersInput = InputView.readUserInput();
        RoundResult roundResult = gameSet.playRound(userNumbersInput);

        if (roundResult.isNothing()) {
            OutputView.printNothingResult();
            return;
        }

        OutputView.printBallAndStrikeResult(roundResult);
    }
}
