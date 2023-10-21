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

//            아 아무리봐도 이건아닌데 어떻게 처리해야하지????
//            if (ballStrikeCount.get(BALL) != 0)
//                g
//            if (listBS.get(STRIKE) != 0)
//                returnString += listBS.get(STRIKE) + "스트라이크";
//            if (listBS.get(BALL) == 0 && listBS.get(STRIKE) == 0)
//                returnString = "낫싱";

            gameView.printGameOverMessage();
        }
    }

}
