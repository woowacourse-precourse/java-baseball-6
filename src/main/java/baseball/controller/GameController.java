package baseball.controller;

import baseball.domain.GameSet;
import baseball.domain.RoundResult;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private GameController() {}

    public static void startGame() {
        OutputView.printStartMessage();
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
