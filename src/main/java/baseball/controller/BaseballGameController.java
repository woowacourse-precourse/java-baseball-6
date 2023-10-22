package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.NumberGenerator;
import baseball.domain.ResponseStatus;
import baseball.domain.RoundResult;

import static baseball.view.InputView.*;
import static baseball.view.OutputView.printRoundResult;
import static baseball.view.OutputView.startMessage;

public class BaseballGameController {

    private static final NumberGenerator numberGenerator = new NumberGenerator();

    private Balls targetNumber;

    public void run() {
        startMessage();
        do {
            createTargetNumber();
            playRound();
        }while(checkRestart());
    }

    private void createTargetNumber() {
        targetNumber = numberGenerator.generate();
    }

    private void playRound() {
        RoundResult roundResult;
        do {
            roundResult = RoundResult.of(targetNumber, userInputNumber());
            printRoundResult(roundResult);
        }while(roundResult.isLose());
    }

    private boolean checkRestart() {
        ResponseStatus restartResponse = inputRestartOrEnd();

        if (restartResponse == ResponseStatus.RESTART) {
            return true;
        }

        return false;
    }
}
