package baseball;

import static baseball.Constant.BALL_MESSAGE;
import static baseball.Constant.CORRECT_MESSAGE;
import static baseball.Constant.INPUT_MESSAGE;
import static baseball.Constant.NOTHING_MESSAGE;
import static baseball.Constant.RESTART_MESSAGE;
import static baseball.Constant.START_MESSAGE;
import static baseball.Constant.STRIKE_MESSAGE;

import java.util.List;

public class GameManager {

    Validator validator = new Validator();

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printCorrectMessage() {
        System.out.println(CORRECT_MESSAGE);
    }

    public List<Integer> askGuess(Player player) {
        System.out.println(INPUT_MESSAGE);
        String[] input = camp.nextstep.edu.missionutils.Console.readLine().split("");
        validator.validateGuess(input);
        return player.makeGuess(input);
    }

    public boolean askRestart() {
        System.out.println(RESTART_MESSAGE);
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        validator.validateOption(input);
        return input.equals("1");
    }

    public void printResult(Result result) {
        int strike = result.getStrike();
        int ball = result.getBall();

        if (strike == 0 && ball == 0) {
            System.out.println(NOTHING_MESSAGE);
        } else if (strike == 0) {
            System.out.println(ball + BALL_MESSAGE);
        } else if (ball == 0) {
            System.out.println(strike + STRIKE_MESSAGE);
        } else {
            System.out.println(ball + BALL_MESSAGE + " " + strike + STRIKE_MESSAGE);
        }
    }
}
