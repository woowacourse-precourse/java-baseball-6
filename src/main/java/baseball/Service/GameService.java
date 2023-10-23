package baseball.Service;

import static baseball.util.Constants.CORRECT_ANSWER;
import static baseball.util.Constants.WRONG_ANSWER;

import baseball.model.Game;
import baseball.view.TextInterface;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;

public class GameService {
    private TextInterface textInterface = new TextInterface();
    private Game game = new Game();


    public void init() {
        textInterface.start();
        game.newGame();
    }

    public int determine(HashMap<Integer, Integer> resultMap) {
        game.setScore(resultMap);
        int strike = game.getStrike();
        int ball = game.getBall();

        if (strike == 3) {
            textInterface.succeed();
            return CORRECT_ANSWER;
        } else if (ball == 0 && strike != 0) {
            textInterface.onlyStrike(strike);
        } else if (ball == 0 && strike != 0) {
            textInterface.onlyBall(ball);
        } else if (ball != 0 && strike != 0) {
            textInterface.bothStrikeAndBall(ball, strike);
        } else if (ball == 0 && strike == 0) {
            textInterface.nothing();
        }
        return WRONG_ANSWER;
    }

    public String end() {
        textInterface.endGame();
        return Console.readLine();
    }
}
