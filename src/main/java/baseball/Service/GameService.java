package baseball.Service;

import static baseball.util.Constants.ANSWER_SIZE;
import static baseball.util.Constants.BALL;
import static baseball.util.Constants.CORRECT;
import static baseball.util.Constants.STRIKE;
import static baseball.util.Constants.WRONG;

import baseball.view.TextInterface;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameService {
    private TextInterface textInterface = new TextInterface();

    public void init() {
        textInterface.start();
    }

    public int analyze(List<Integer> resultList) {
        int strike = countByKeyword(resultList, STRIKE);
        int ball = countByKeyword(resultList, BALL);

        if (strike == ANSWER_SIZE) {
            return CORRECT;
        }
        printResult(ball, strike);
        return WRONG;

    }

    public int countByKeyword(List<Integer> resultList, int keyword) {
        int count = 0;
        for (int number : resultList) {
            if (number == keyword) {
                count++;
            }
        }
        return count;
    }

    public void printResult(int ball, int strike) {
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
