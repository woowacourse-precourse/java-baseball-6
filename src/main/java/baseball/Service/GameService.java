package baseball.Service;

import static baseball.util.Constants.ANSWER_SIZE;
import static baseball.util.Constants.BALL;
import static baseball.util.Constants.CORRECT_ANSWER;
import static baseball.util.Constants.STRIKE;
import static baseball.util.Constants.WRONG_ANSWER;

import baseball.view.TextInterface;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameService {
    private TextInterface textInterface = new TextInterface();

    public void init() {
        textInterface.start();
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

    public int analyze(List<Integer> resultList) {
        int strike = countByKeyword(resultList, STRIKE);
        int ball = countByKeyword(resultList, BALL);

        if (strike == ANSWER_SIZE) {
            return CORRECT_ANSWER;
        }
        printResult(ball, strike);
        return WRONG_ANSWER;

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

    public String success() {
        textInterface.success();
        return Console.readLine();
    }

    public void end() {
        textInterface.endGame();
    }
}
