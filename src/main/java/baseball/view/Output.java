package baseball.view;

import static baseball.util.Message.*;

public class Output {
    public void printStartGame() {
        System.out.println(START_GAME_MSG);
    }

    public void printResult(int ball, int strike) {
        StringBuilder result = new StringBuilder();

        if (ball == 0 && strike == 0) {
            System.out.println(NOTHING);
            return;
        }
        if (ball != 0) {
            result.append(ball).append(BALL).append(" ");
        }
        if (strike != 0) {
            result.append(strike).append(STRIKE);
        }

        System.out.println(result.toString().trim());
    }

    public void printSuccessGame() {
        System.out.println(SUCCESS_MSG);
        System.out.println(INPUT_ASK_RESTART_MESSAGE);
    }

}
