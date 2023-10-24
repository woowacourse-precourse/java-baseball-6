package baseball.controller;

import baseball.dto.GameResult;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private static GameController gameController;

    private static final String RESTART = "1";

    private final GameService gameService;

    public static GameController getInstance() {
        if (gameController == null) {
            gameController = new GameController();
        }
        return gameController;
    }

    private GameController() {
        gameService = GameService.getInstance();
    }

    public void start() {
        OutputView.start();
        do {
            play();
        } while (shouldRestart());
    }

    private void play() {
        gameService.initGame();
        GameResult gameResult;
        do {
            gameResult  = gameService.compare(InputView.number());
            OutputView.result(gameResult);
        } while (!gameResult.isClear());
    }

    private boolean shouldRestart() {
        return InputView.restart().equals(RESTART);
    }
}
