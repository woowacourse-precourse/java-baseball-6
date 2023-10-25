package baseball.view;

import baseball.constants.Message;
import baseball.model.Result;

public class OutputView {
    public void printStart() {
        System.out.println(Message.GAME_START);
    }

    public void printUserGuess() {
        System.out.println(Message.USER_PROMPT);
    }

    public void printResult(Result result) {
        int strikes = result.getStrikes();
        int balls = result.getBalls();
        StringBuilder message = new StringBuilder();

        if (strikes == 0 && balls == 0) {
            message.append(Message.NOTHING);
        }

        if (balls > 0) {
            message.append(balls).append(Message.BALL);
        }

        if (strikes > 0) {
            message.append(strikes).append(Message.STRIKE);
        }

        System.out.println(message.toString().trim());
    }

    public void printSuccessGuess() {
        System.out.println(Message.GAME_END);
    }

    public void printRestart() {
        System.out.println(Message.RESTART);
    }
}
