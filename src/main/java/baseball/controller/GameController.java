package baseball.controller;

import baseball.model.GameModel;
import baseball.view.GameView;

public class GameController {

    private static final GameController GAME_CONTROLLER = new GameController();
    private static final GameModel gameModel = GameModel.getGameModel();
    private static final GameView gameView = GameView.getGameView();

    public static GameController getGameController() {
        return GAME_CONTROLLER;
    }

    public void guessHandler() {
        String s = gameView.guessInputView();
        gameModel.setGuess(s);
    }

    public void restartHandler() {
        String s = gameView.restartInputView();
        gameModel.setRetry(s);
    }

    public void gameStart() {
        do {
            gameView.gameStartView();
            gameModel.generateAnswer();
            do {
                gameModel.resetCount();
                guessHandler();
                gameModel.checkAnswer();
                gameView.hintView(gameModel.getHint());
            } while (gameModel.getStrike() != 3);
            restartHandler();
        } while (gameModel.getRetry());
    }
}
