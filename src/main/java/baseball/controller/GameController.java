package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.Game;
import baseball.domain.GameResult;
import baseball.service.BallGeneratorService;
import baseball.service.GameService;
import baseball.view.OutputView;

public class GameController {

    private final InputController inputController;
    private final OutputView outputView;
    private final GameService gameService;
    private final BallGeneratorService ballGeneratorService;

    public GameController(InputController inputController,
                          OutputView outputView,
                          GameService gameService,
                          BallGeneratorService ballGeneratorService) {
        this.inputController = inputController;
        this.outputView = outputView;
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
            outputView.resultMessage(gameService.createGameResult(gameResult));
            gameService.updateGameState(game, gameResult);
        }
    }

    private Balls getPlayerBalls() {
        return ballGeneratorService.generatePlayerBalls(inputController.requestPlayerGuess());
    }

    private boolean restartGame() {
        outputView.inputGameRestartMessage();
        return gameService.restartGame(inputController.requestRestartChoice());
    }
}
