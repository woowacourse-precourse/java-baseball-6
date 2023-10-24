package baseball.Controller;

import baseball.Model.BaseBallGame;
import baseball.Model.Helper;
import baseball.Model.Valid;
import baseball.View.GameView;
import java.util.List;

public class GameController {
    private static final int BALL = 0;
    private static final int STRIKE = 1;

    private Helper helper = new Helper();
    private BaseBallGame baseBallGame = new BaseBallGame(helper);
    private GameView gameView = new GameView();

    public void startGame() {
        gameView.printStartMessage();
        while (!baseBallGame.isGameOver()) {
            String input = Valid.checkValid(gameView.printInputMessage());
            List<Integer> userInput = helper.parseUserInput(input);
            List<Integer> ballStrikeCount = baseBallGame.checkBallCount(userInput);
            int balls = ballStrikeCount.get(BALL);
            int strikes = ballStrikeCount.get(STRIKE);

            baseBallGame.gameOverCheck(strikes);

            if (baseBallGame.isGameOver()) {
                String inputRestart = gameView.printGameOverMessage();
                baseBallGame.restartGame(inputRestart);
            }
        }
    }
}
