package baseball.controller;

import baseball.dto.GameResult;
import baseball.model.Game;
import baseball.model.GameImpl;
import baseball.view.View;

import java.util.List;

public class GameController {

    private Game game;
    private final View view;

    public GameController(View view) {
        this.view = view;
    }

    public void run() {
        while (true) {
            playGame();
            if (!view.restartQuestion())    break;
        }
    }

    private void playGame() {
        game = new GameImpl();
        boolean isLoop = true;

        view.start();
        while (isLoop) {
            List<Integer> userInput = view.input();
            GameResult gameResult = game.compare(userInput);
            view.result(gameResult.strike(), gameResult.ball());
            isLoop = gameResult.isLoop();
        }
        view.end();
    }
}
