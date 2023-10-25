package baseball.controller;

import baseball.invalid.InvalidContinueMessageFormatException;
import baseball.number.BaseBallNumbers;
import baseball.number.RandomNumbers;
import baseball.view.InputView;
import baseball.view.ResultView;


public class BaseballGameController {

    private static final String CONTINUE = "1";
    private static final String GAME_END = "2";
    private static final Integer THREE_STRIKE = 3;

    public static void run() {
        runBaseBallGame();
        checkContinue();
    }

    private static void runBaseBallGame() {
        int strikeCount = 0;
        int ballCount = 0;

        RandomNumbers randomNumbers = new RandomNumbers();
        while (strikeCount != THREE_STRIKE) {
            BaseBallNumbers baseBallNumbers = new BaseBallNumbers(InputView.requireBASEBALLNUMBER());
            ballCount = baseBallNumbers.calculateBallCount(randomNumbers.randomNumbers());
            strikeCount = baseBallNumbers.calculateStrikeCount(randomNumbers.randomNumbers());
            ResultView.printResult(ballCount, strikeCount);
        }
        ResultView.printResultInfoMessage();
    }

    private static void checkContinue() {
        String continueMessage = InputView.askContinue();

        if (continueMessage.equals(CONTINUE)) {
            runBaseBallGame();
            return;
        }

        if (continueMessage.equals(GAME_END)) {
            ResultView.printGameEnd();
            return;
        }

        throw new InvalidContinueMessageFormatException();
    }
}
