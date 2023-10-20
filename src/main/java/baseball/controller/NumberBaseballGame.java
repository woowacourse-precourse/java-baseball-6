package baseball.controller;

import baseball.domain.ComputerNumbers;
import baseball.domain.Round;
import baseball.domain.RoundResult;
import baseball.domain.UserNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class NumberBaseballGame {

    static void gameStart() {
        ComputerNumbers computerNumbers = new ComputerNumbers();
        boolean isGameProceed = true;
        while (isGameProceed) {
            UserNumbers userNumbers = InputView.readUserNumber();
            Round round = new Round(computerNumbers, userNumbers);
            RoundResult roundResult = round.calculateRoundResult();
            OutputView.printRoundResult(roundResult);
            if (roundResult.isWin()) {
                isGameProceed = false;
            }
        }
    }

    public void play() {
        OutputView.printStartMessage();
        boolean shouldPlay = true;
        while (shouldPlay) {
            gameStart();
            OutputView.printEndMessage();
            shouldPlay = InputView.readShouldReplay();
        }
    }

}
