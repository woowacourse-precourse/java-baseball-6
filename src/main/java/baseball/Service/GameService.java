package baseball.Service;

import static baseball.util.Constants.BALL;
import static baseball.util.Constants.CORRECT;
import static baseball.util.Constants.STRIKE;
import static baseball.util.Constants.WRONG;

import baseball.model.Game;
import baseball.model.Player;
import baseball.view.TextInterface;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameService {
    private TextInterface textInterface = new TextInterface();
    private Game game = new Game();

    public void init() {
        textInterface.start();
        game.init();
    }

    public int compute(Player computer, List<Integer> answer) {
        if (computer.isEqual(answer)) {
            return CORRECT;
        }
        for (int i = 0; i < answer.size(); i++) {
            int num = answer.get(i);
            int result = computer.isBallOrStrike(num, i);
            if (result == STRIKE) {
                game.increaseStrike();
            }
            if (result == BALL) {
                game.increaseBall();
            }
        }
        printResult();
        return WRONG;
    }

    private void printResult() {
        int strike = game.getStrike();
        int ball = game.getBall();
        
        if (ball == 0 && strike == 0) {
            textInterface.nothing();
        }
        if (ball != 0 && strike != 0) {
            textInterface.bothStrikeAndBall(ball, strike);
        }
        if (ball == 0 && strike != 0) {
            textInterface.onlyStrike(strike);
        }
        if (ball != 0 && strike == 0) {
            textInterface.onlyBall(ball);
        }
    }

    public String end() {
        textInterface.success();
        return Console.readLine();
    }

    public void exit() {
        textInterface.endGame();
    }
}
