package baseball.Controller;

import baseball.Model.BaseBallGame;
import baseball.Model.NumberGenerator;
import baseball.View.GameView;
import java.util.List;

public class GameController {
    NumberGenerator numberGenerator = new NumberGenerator();
    BaseBallGame baseBallGame = new BaseBallGame(numberGenerator);
    GameView gameView = new GameView();

    private static final int BALL = 0;
    private static final int STRIKE = 1;


    public GameController() {

    }

    public void startGame() {
        gameView.printStartMessage();
        while (!baseBallGame.isGameOver()) {
            String input = gameView.printInputMessage();
            List<Integer> userInput = baseBallGame.parseUserInput(input);

            List<Integer> ballStrikeCount = baseBallGame.checkBallCount(userInput);

            if (ballStrikeCount.get(BALL) != 0 && ballStrikeCount.get(STRIKE) == 0) {
                gameView.printBallMessage(ballStrikeCount.get(BALL));
            }
            if (ballStrikeCount.get(BALL) != 0 && ballStrikeCount.get(STRIKE) != 0) {
                gameView.printBallStrikeMessage(ballStrikeCount.get(BALL));
            }
            if (ballStrikeCount.get(STRIKE) != 0) {
                gameView.printStrikeMessage(ballStrikeCount.get(STRIKE));
            }
            if (ballStrikeCount.get(BALL) == 0 && ballStrikeCount.get(STRIKE) == 0) {
                gameView.printNothingMessage();
            }

            if (baseBallGame.isGameOver()) {
                gameView.printGameOverMessage();
                baseBallGame.restartGame();
            }
        }
    }

}
