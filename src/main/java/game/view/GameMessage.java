package game.view;

import static constant.MessageConst.*;

public class GameMessage {

    public void printInitMsg() {
        System.out.println(START_GAME_MSG);
    }

    public void printInputMsg() {
        System.out.print(INPUT_MSG);
    }

    public void printResultMsg(int ball, int strike) {
        StringBuilder result = new StringBuilder("");

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

    public void printSuccessMsg() {
        System.out.println(SUCCESS_MSG);
        System.out.println(GAME_CONTROL_MSG);
    }
}

