package baseball.controller;

import baseball.common.GameStatus;
import baseball.view.impl.game.GameView;
import baseball.view.impl.gameEnd.GameEndView;
import baseball.view.impl.gameStart.GameStartView;

public class BaseballController {
    private final GameStartView gameStartView = new GameStartView();
    private final GameView gameView = new GameView();
    private final GameEndView gameEndView = new GameEndView();

    public void run() {
        gameStartView.gameStart();
        gameView.game();

        GameStatus status = gameEndView.afterGameEnd();

        if (status.equals(GameStatus.CONTINUE)) {
            run();
        } else if (status.equals(GameStatus.EXIT)) {
            gameEndView.exit();
        }
    }
}