package baseball.util;

import jdk.swing.interop.SwingInterOpUtils;

import static baseball.constant.MessageConst.*;

/**
 * 메시지 출력 관리 클래스
 */
public class MessageUtil {

    public void printInitMessage() {

        System.out.println(START_GAME_MESSAGE);
    }

    public void printInputMessage() {

        System.out.println(INPUT_MESSAGE);
    }

    public void printResultMessage(int strike, int ball) {

        StringBuilder result = new StringBuilder();

        if (strike == 0 && ball == 0) {

            System.out.println(NOTHING);
            return;
        }

        if (ball != 0) {
            result.append(ball).append(BALL).append(" ");
        }

        if (strike != 0) {
            result.append(strike).append(STRIKE);
        }

        System.out.println(result.toString());

    }

    public void printSuccessMessage(){

        System.out.println(SUCCESS_MESSAGE);
        System.out.println(GAME_CONTROL_MESSAGE);
    }
}
