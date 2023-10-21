package baseball.Controller;

import baseball.Model.BaseBallGame;
import baseball.Model.NumberGenerator;
import baseball.View.GameView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    NumberGenerator numberGenerator = new NumberGenerator();
    BaseBallGame baseBallGame = new BaseBallGame(numberGenerator);
    GameView gameView = new GameView();

    public GameController() {

    }

    public void startGame() {
        gameView.printStartMessage();
        while (!baseBallGame.isGameOver()) {
            String input = gameView.printInputMessage();
            List<Integer> userInput = baseBallGame.parseUserInput(input);

            baseBallGame.playingGame(userInput);

            gameView.printGameOverMessage();
        }
    }

}
