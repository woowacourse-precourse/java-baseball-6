package baseball.controller;

import baseball.model.GameModel;
import baseball.view.GameView;

public class GameController {
    private static final GameModel gameModel = new GameModel();
    private static final GameView gameView = new GameView();


    public void guessInputController() {
        String s = gameView.guessInputView();
        gameModel.setGuess(s);
    }

    public boolean retryInputController() {
        String s = gameView.restartInputView();
        return switch (s) {
            case "1" -> true;
            case "2" -> false;
            default -> throw new IllegalArgumentException();
        };
    }

    public void hintController() {
        StringBuilder s = gameModel.getHint();
        gameView.hintView(s);
    }

    public void gameStart() {
        do {

            gameView.gameStartView();
            gameModel.generateAnswer();

            do {
                gameModel.resetCount();
                guessInputController();

                gameModel.checkAnswer();

                hintController();
            } while (gameModel.getStrike() != 3);

        } while (retryInputController());
    }
}
