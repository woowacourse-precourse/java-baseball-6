package baseball.util;

import baseball.constant.ConsoleMessage;

import static baseball.constant.ConsoleMessage.*;
import static baseball.constant.ConsoleNumber.*;

public class Message {

    public void printSTART() {
        System.out.println(START_GAME);
    }

    public void printInput() {
        System.out.print(INPUT_NUM);
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
        System.out.println(SUCCESS);
        System.out.println(REGAME);
    }
}