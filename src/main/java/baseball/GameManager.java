package baseball;

import static baseball.GameStatus.START;
import static baseball.Message.BALL_MESSAGE;
import static baseball.Message.CORRECT_MESSAGE;
import static baseball.Message.INPUT_MESSAGE;
import static baseball.Message.NOTHING_MESSAGE;
import static baseball.Message.RESTART_MESSAGE;
import static baseball.Message.START_MESSAGE;
import static baseball.Message.STRIKE_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameManager {
    private final Validator validator = new Validator();

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printCorrectMessage() {
        System.out.println(CORRECT_MESSAGE);
    }

    public List<Integer> askGuess(Player player) {
        System.out.println(INPUT_MESSAGE);
        String[] input = Console.readLine().split("");
        validator.validateGuess(input);
        return player.makeGuess(input);
    }

    public boolean askRestart() {
        System.out.println(RESTART_MESSAGE);
        String input = Console.readLine();
        validator.validateOption(input);
        return input.equals(START);
    }

    public void printResult(Result result) {
        int strike = result.strike();
        int ball = result.ball();

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
