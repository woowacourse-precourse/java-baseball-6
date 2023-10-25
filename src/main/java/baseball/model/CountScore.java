package baseball.model;

import static baseball.view.OutputView.MessageConst.*;

public class CountScore {

    public void printStart() {
        System.out.println(START_GAME_MSG);
    }
    public void printInput() {
        System.out.print(INPUT_MSG);
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

    public void printSuccess() {
        System.out.println(SUCCESS_MSG);
        System.out.println(RESTART_MSG);
    }
}
