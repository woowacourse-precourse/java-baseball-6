package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.NumberGenerator;
import baseball.domain.RoundResult;

import static baseball.view.InputView.RestartOrEnd;
import static baseball.view.InputView.userInputNumber;
import static baseball.view.OutputView.printRoundResult;
import static baseball.view.OutputView.startMessage;

public class BaseballGameController {

    private static final NumberGenerator numberGenerator = new NumberGenerator();

    private static final int RESTART = 1;
    private static final int END = 2;

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
        int restartResponse = RestartOrEnd();

        if (restartResponse == END) {
            return false;
        }
        if (restartResponse == RESTART) {
            return true;
        }
        throw new IllegalArgumentException();
    }
}
