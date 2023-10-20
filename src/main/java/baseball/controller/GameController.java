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

    private boolean restartGame() {
        outputView.inputGameRestartMessage();
        return gameResultService.restartGame(inputView.requestRestartChoice());
    }

    private void playGame() {
        Game game = gameSetupService.gameCreate();
        while (!game.isGameFinished()) {
            outputView.inputBallsMessage();
            Balls playerBalls = getPlayerBalls(); // 플레이어 입력
            GameResult gameResult = compareBalls(game, playerBalls); // 컴퓨터와 플레이어 공 비교
            outputView.resultMessage(gameResultService.showResult(gameResult)); // 비교 결과 출력
            game = gameLogicService.updateGameStatusOnThreeStrike(game, gameResult); // 플레이어가 맞췄으면 게임 종료
        }
    }

    private Balls getPlayerBalls() {
        return gameSetupService.generatePlayerBalls(inputView.requestPlayerGuess());
    }

    private GameResult compareBalls(Game game, Balls playerBalls) {
        return gameLogicService.compareBalls(game, playerBalls);
    }
}
