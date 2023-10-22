package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.NumberGenerator;
import baseball.domain.ResponseStatus;
import baseball.domain.RoundResult;

import static baseball.view.InputView.*;
import static baseball.view.OutputView.printRoundResult;
import static baseball.view.OutputView.startMessage;

public class BaseballGameController {

    private final NumberGenerator numberGenerator;

    private Balls targetNumber;

    public BaseballGameController() {
        this.numberGenerator = new NumberGenerator();
        this.targetNumber = null;
    }

    public void run() {
        startMessage();
        do {
            createTargetNumber();
            playRound();
        }while(checkRestart());
    }

    private void createTargetNumber() {
        this.targetNumber = numberGenerator.generate();
    }

    private Balls getTargetNumber() {
        return this.targetNumber;
    }

    private void playRound() {
        RoundResult roundResult;
        do {
            roundResult = RoundResult.of(getTargetNumber(), userInputNumber());
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
