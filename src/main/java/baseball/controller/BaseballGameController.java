package baseball.controller;

import baseball.model.TargetNumber;
import baseball.model.StopGameDecisionHelper;
import baseball.model.GameResult;
import baseball.view.ConsoleInputView;
import baseball.view.ConsoleOutputView;

public class BaseballGameController {
    private static final int BASEBALL_NUMBER_SIZE = 3;
    private final ConsoleInputView consoleInputView;
    private final ConsoleOutputView consoleOutputView;

    public BaseballGameController(ConsoleInputView consoleInputView, ConsoleOutputView consoleOutputView) {
        this.consoleInputView = consoleInputView;
        this.consoleOutputView = consoleOutputView;
    }

    public void play() {
        consoleOutputView.gameStart();

        while (true) {
            matchingNumber(TargetNumber.randomInstance(BASEBALL_NUMBER_SIZE));

            if (isWantStopGame()) {
                break;
            }
        }
    }

    private void matchingNumber(TargetNumber computerNumber) {
        while (true) {
            String inputNumber = requestNumber();
            verifyInputNumber(inputNumber);
            GameResult gameResult = computerNumber.calculateGameResult(inputNumber);

            consoleOutputView.writeMessage(gameResult.toString());

            if (gameResult.isPerfectGame(BASEBALL_NUMBER_SIZE)) {
                consoleOutputView.goodGame(BASEBALL_NUMBER_SIZE);
                break;
            }
        }
    }

    private String requestNumber() {
        consoleOutputView.requestNumber();
        return consoleInputView.request();
    }

    private void verifyInputNumber(String inputNumberText) {
        if (inputNumberText.length() != BASEBALL_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isWantStopGame() {
        consoleOutputView.moreGame(StopGameDecisionHelper.MORE_NUMBER, StopGameDecisionHelper.END_NUMBER);
        int inputMoreGameNumber = Integer.parseInt(consoleInputView.request());
        return StopGameDecisionHelper.getDecision(inputMoreGameNumber);
    }
}
