package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.Game;
import baseball.domain.GameResult;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final OutputView outputView;
    private final InputView inputView;
    private final GameService gameService;

    public GameController(OutputView outputView,
                          InputView inputView,
                          GameService gameService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.gameService = gameService;
    }

    public void run() {
        outputView.gameStartMessage();
        do {
            playGame();
            outputView.gameEndMessage();
        } while (restartGame());
    }

    private void playGame() {
        Game game = gameService.createGame();
        while (!game.isGameFinished()) {
            outputView.inputBallsMessage();
            GameResult gameResult = game.compareAndResult(getPlayerBalls());
            outputView.resultMessage(gameResult.createGameResult());
            game.updateGameState(gameResult);
        }
    }

    private Balls getPlayerBalls() {
        return gameService.generatePlayerBalls(inputView.requestPlayerGuess());
    }

    private boolean restartGame() {
        outputView.inputGameRestartMessage();
        return gameService.restartGame(inputView.requestRestartChoice());
    }

}
