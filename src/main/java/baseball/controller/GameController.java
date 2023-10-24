package baseball.controller;

import baseball.domain.*;
import baseball.service.GameService;
import baseball.util.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;
    private GameStatus gameStatus;

    public GameController(InputView inputView, OutputView outputView, GameService gameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameService;
        this.gameStatus = new GameStatus();
    }

    public void playGame() {
        RandomNumber randomNumber = generateRandomNumber();

        while (gameStatus.isNotEnd()) {
            GameNumberSet gameNumberSet = createGameNumberSet(randomNumber);
            gameStatus = compareGameNumbers(gameNumberSet);
            displayGameResult(gameStatus);

            if (gameStatus.isEnd()) {
                handleGameEnd(randomNumber, gameStatus);
            }
        }
    }

    private static RandomNumber generateRandomNumber() {
        return RandomNumber.create(RandomNumberGenerator.generate());
    }

    private GameNumberSet createGameNumberSet(RandomNumber randomNumber) {
        return new GameNumberSet(randomNumber, inputView.getInputNumber());
    }

    private GameStatus compareGameNumbers(GameNumberSet gameNumberSet) {
        return gameService.compareNumber(gameNumberSet, gameStatus);
    }

    private void displayGameResult(GameStatus gameStatus) {
        outputView.printGameResult(gameStatus);
    }

    private void handleGameEnd(RandomNumber randomNumber, GameStatus gameStatus) {
        outputView.printGameEndMessage();
        RetryCommand command = inputView.getCommand();

        if (command.isRetry()) {
            randomNumber.reset(RandomNumberGenerator.generate());
            gameStatus.reset();
        }
    }
}
