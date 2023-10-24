package baseball.Controller;

import baseball.Model.BaseBallGame;
import baseball.Model.Helper;
import baseball.Model.Valid;
import baseball.View.GameView;
import java.util.List;

public class GameController {
    private GameView gameView = new GameView();

    public void startGame() {
        Helper helper = new Helper();
        BaseBallGame baseBallGame = new BaseBallGame(helper);
        gameView.printStartMessage();
        while (!baseBallGame.isGameOver()) {
            playGame(helper, baseBallGame);
            String inputRestart = gameView.printGameOverMessage();
            baseBallGame.restartGame(inputRestart);
        }
    }

    public void playGame(Helper helper, BaseBallGame baseBallGame) {
        while (true) {
            String input = Valid.startValid(gameView.printInputMessage());
            List<Integer> userInput = helper.parseUserInput(input);
            List<Integer> ballStrikeCount = baseBallGame.checkBallCount(userInput);

            gameView.printBallStrikeMessage(ballStrikeCount);

            baseBallGame.gameOverCheck(ballStrikeCount.get(1));
        }

    }
}
