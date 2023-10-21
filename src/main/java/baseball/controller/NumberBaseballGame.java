package baseball.controller;

import baseball.domain.ComputerNumbers;
import baseball.domain.ReplayType;
import baseball.domain.Round;
import baseball.domain.UserNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class NumberBaseballGame {

    static void gameStart() {
        ComputerNumbers computerNumbers = new ComputerNumbers();
        boolean isGameEnd = false;
        while (!isGameEnd) {
            UserNumbers userNumbers = InputView.readUserNumber();
            Round round = new Round(computerNumbers, userNumbers);
            OutputView.printRoundResult(round);
            isGameEnd = round.isGameEnd();
        }
    }

    public void play() {
        OutputView.printStartMessage();
        boolean shouldPlay = true;
        while (shouldPlay) {
            gameStart();
            OutputView.printEndMessage();
            ReplayType replayType = InputView.readShouldReplay();
            shouldPlay = replayType.isReplay();
        }
    }

}
