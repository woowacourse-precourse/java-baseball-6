package baseball.controller;

import baseball.service.GameService;
import baseball.service.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;
    private final RandomNumberGenerator randomNumberGenerator;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.gameService = new GameService();
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public void runGame() {
        boolean playOption = true;

        outputView.printGameStart();
        List<Integer> randomNumbers = randomNumberGenerator.generateRandomNumbers();
        System.out.println(randomNumbers);
        while (playOption) {
            outputView.printForInputThreeDigitNumbers();
            int[] playersNumbers = inputView.inputThreeDigitNumber();
            int[] gameResult = gameService.getGameResult(randomNumbers, playersNumbers);
            if (!gameService.isThreeStrike(gameResult)) {
                outputView.printGameFailResult(gameResult);
                continue;
            }
            outputView.printGameSuccessResult(gameResult);
            if (inputView.inputRestartOrExit() == 1) {
                randomNumbers = randomNumberGenerator.generateRandomNumbers();
                continue;
            }

            playOption = false;
        }
    }
}
