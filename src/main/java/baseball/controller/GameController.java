package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.Game;
import baseball.domain.GameResult;
import baseball.service.GameLogicService;
import baseball.service.GameResultService;
import baseball.service.GameSetupService;
import baseball.view.console.InputView;
import baseball.view.console.OutputView;

public class GameController {
    private final OutputView outputView;
    private final InputView inputView;
    private final GameSetupService gameSetupService;
    private final GameLogicService gameLogicService;
    private final GameResultService gameResultService;

    public GameController(OutputView outputView,
                          InputView inputView,
                          GameSetupService gameSetupService,
                          GameLogicService gameLogicService,
                          GameResultService gameResultService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.gameSetupService = gameSetupService;
        this.gameLogicService = gameLogicService;
        this.gameResultService = gameResultService;
    }

    public void run() {
        outputView.gameStartMessage();
        do {
            playGame();
            outputView.gameEndMessage();
        } while (restartGame());
    }

    private void playGame() {
        Game game = gameSetupService.gameCreate();
        while (!game.isGameFinished()) {
            outputView.inputBallsMessage();
            GameResult gameResult = gameLogicService.compareBalls(game, getPlayerBalls());
            outputView.resultMessage(gameResultService.showResult(gameResult));
            gameLogicService.updateGameState(game, gameResult);
        }
    }

    private Balls getPlayerBalls() {
        return gameSetupService.generatePlayerBalls(inputView.requestPlayerGuess());
    }

    private boolean restartGame() {
        outputView.inputGameRestartMessage();
        return gameResultService.restartGame(inputView.requestRestartChoice());
    }

}
