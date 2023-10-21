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
            Balls playerBalls = getPlayerBalls();
            GameResult gameResult = getGameResult(game, playerBalls);
            outputView.resultMessage(gameResultService.showResult(gameResult)); // 비교 결과 출력
            game = updateGameState(game, gameResult); // 직관적으로 알 수 있게 game 리턴 (참조형이라 안해도 되긴 함)
        }
    }

    private boolean restartGame() {
        outputView.inputGameRestartMessage();
        return gameResultService.restartGame(inputView.requestRestartChoice());
    }

    private Balls getPlayerBalls() {
        return gameSetupService.generatePlayerBalls(inputView.requestPlayerGuess());
    }

    private GameResult getGameResult(Game game, Balls playerBalls) {
        return gameLogicService.compareBalls(game, playerBalls);
    }

    private Game updateGameState(Game game, GameResult gameResult) {
        return gameLogicService.updateGameStatusOnThreeStrike(game, gameResult); // 플레이어가 맞췄으면 게임 종료;
    }

}
