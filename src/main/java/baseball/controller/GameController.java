package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.Game;
import baseball.domain.GameResult;
import baseball.service.BallGeneratorService;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final OutputView outputView;
    private final InputView inputView;
    private final GameService gameService;
    private final BallGeneratorService ballGeneratorService;

    public GameController(OutputView outputView,
                          InputView inputView,
                          GameService gameService,
                          BallGeneratorService ballGeneratorService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.gameService = gameService;
        this.ballGeneratorService = ballGeneratorService;
    }

    public void run() {
        outputView.gameStartMessage();
        do {
            playGame();
            outputView.gameEndMessage();
        } while (restartGame());
    }

    private void playGame() {
        Game game = gameService.createGame(ballGeneratorService);
        Balls computerBalls = game.getComputerBalls();
        while (!game.isGameOver()) {
            outputView.inputBallsMessage();
            GameResult gameResult = gameService.compareAndResult(computerBalls, getPlayerBalls());
            outputView.resultMessage(gameResult.createGameResult());
            gameService.updateGameState(game, gameResult);
        }
    }

    private Balls getPlayerBalls() {
        return ballGeneratorService.generatePlayerBalls(inputView.requestPlayerGuess());
    }

    private boolean restartGame() {
        outputView.inputGameRestartMessage();
        return gameService.restartGame(inputView.requestRestartChoice());
    }

}
