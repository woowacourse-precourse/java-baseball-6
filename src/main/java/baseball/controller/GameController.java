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
        RandomNumber randomNumber = new RandomNumber();
        while (!gameStatus.isEnd()) {
            GameNumber gameNumber = new GameNumber(randomNumber, inputView.getInputNumber());
            GameStatus gamestatus = gameService.compareNumber(gameNumber, gameStatus);
            outputView.printGameResult(gamestatus);
            if (gamestatus.isEnd()) {
                outputView.printGameEndMessage();
                RetryCommand command = inputView.getCommand();
                if (command.isRetry()) {
                    randomNumber = new RandomNumber();
                    gamestatus.reset();
                }
            }
        }
    }
}
