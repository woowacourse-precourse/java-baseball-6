package baseball.Controller;

import baseball.Model.BaseBallGame;
import baseball.Model.Helper;
import baseball.Model.Valid;
import baseball.View.GameView;
import java.util.List;

public class GameController {
    private Helper helper = new Helper();
    private BaseBallGame baseBallGame = new BaseBallGame(helper);
    private GameView gameView = new GameView();

    public void startGame() {
        gameView.printStartMessage();
        while (!baseBallGame.isGameOver()) {
            String input = Valid.checkValid(gameView.printInputMessage());
            List<Integer> userInput = helper.parseUserInput(input);
            List<Integer> ballStrikeCount = baseBallGame.checkBallCount(userInput);

            gameView.printBallStrikeMessage(ballStrikeCount);

            baseBallGame.gameOverCheck(ballStrikeCount.get(1));

            if (baseBallGame.isGameOver()) {
                String inputRestart = gameView.printGameOverMessage();
                baseBallGame.restartGame(inputRestart);
            }
        }
    }
}
