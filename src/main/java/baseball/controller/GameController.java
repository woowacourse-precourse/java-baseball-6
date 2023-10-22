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

        while (playOption) {
            outputView.printForInputThreeDigitNumbers();
            List<Integer> randomNumbers = randomNumberGenerator.generateRandomNumbers();
            System.out.println(randomNumbers);

            String inputNumbers = inputView.inputThreeDigitNumber();

            int[] gameResult = gameService.getGameResult(randomNumbers, inputNumbers);

            if (!gameService.isThreeStrike(gameResult)) {
                outputView.printGameFailResult(gameResult);
                continue;
            }
            outputView.printGameSuccessResult(gameResult);
            if (inputView.inputRestartOrExit().equals("2")) {
                playOption = false;
            }
        }
    }
}
