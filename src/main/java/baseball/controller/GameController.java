package baseball.controller;

import baseball.domain.*;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;
    private GameStatus gameStatus = new GameStatus();

    public GameController(InputView inputView, OutputView outputView, GameService gameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameService;
    }

    public void playGame() {
        RandomNumber randomNumber = generateRandomNumber();

        while (!gameStatus.isEnd()) {
            GameNumber gameNumber = createGameNumber(randomNumber);
            gameStatus = compareGameNumbers(gameNumber);
            displayGameResult(gameStatus);

            if (gameStatus.isEnd()) {
                handleGameEnd(randomNumber, gameStatus);
            }
        }
    }

    private RandomNumber generateRandomNumber() {
        return new RandomNumber();
    }

    private GameNumber createGameNumber(RandomNumber randomNumber) {
        return new GameNumber(randomNumber, inputView.getInputNumber());
    }

    private GameStatus compareGameNumbers(GameNumber gameNumber) {
        return gameService.compareNumber(gameNumber, gameStatus);
    }

    private void displayGameResult(GameStatus gameStatus) {
        outputView.printGameResult(gameStatus);
    }

    private void handleGameEnd(RandomNumber randomNumber, GameStatus gameStatus) {
        outputView.printGameEndMessage();
        RetryCommand command = inputView.getCommand();

        if (command.isRetry()) {
            resetForRetry(randomNumber, gameStatus);
        }
    }

    private void resetForRetry(RandomNumber randomNumber, GameStatus gameStatus) {
        randomNumber.reset();
        gameStatus.reset();
    }

}
