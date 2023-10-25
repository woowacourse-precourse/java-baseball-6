package baseball.controller;

import baseball.service.GameResultHandler;
import baseball.service.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final GameResultHandler gameResultHandler;
    private final RandomNumberGenerator randomNumberGenerator;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.gameResultHandler = new GameResultHandler();
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public void runGame() {
        boolean playOption = true;
        final int restartNumber = 1;

        outputView.printGameStart();
        List<Integer> randomNumbers = randomNumberGenerator.generateRandomNumbers();

        while (playOption) {
            outputView.printForInputThreeDigitNumbers();
            int[] playersNumbers = inputView.inputThreeDigitNumber();
            int[] gameResult = gameResultHandler.getGameResult(randomNumbers, playersNumbers);
            if (!gameResultHandler.isThreeStrike(gameResult)) {
                outputView.printGameFailResult(gameResult);
                continue;
            }
            outputView.printGameSuccessResult(gameResult);
            if (inputView.inputRestartOrExit() == restartNumber) {
                randomNumbers = randomNumberGenerator.generateRandomNumbers();
                continue;
            }

            playOption = false;
        }
    }
}
