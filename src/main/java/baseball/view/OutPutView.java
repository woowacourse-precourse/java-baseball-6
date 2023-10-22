package baseball.view;

import baseball.resource.GameMessage;

import java.util.ArrayList;
import java.util.List;

public class OutPutView {

    public static void printStartMessage() {
        System.out.println(GameMessage.START_MESSAGE);
    }
    public static void printInputMessage() {
        System.out.print(GameMessage.INPUT_NUMBER_MESSAGE);
    }

    public static void printEndMessage() {
        System.out.println(GameMessage.END_MESSAGE);
    }

    public static void printReStartMessage() {
        System.out.println(GameMessage.RESTART_QUESTION_MESSAGE);
    }

    public static void printBallAndStrike(int strike, int ball) {
        List<String> resultMessageList = new ArrayList<>();
        if (ball == 0 && strike == 0) {
            resultMessageList.add(GameMessage.NOTHING_MESSAGE);
        }
        if (ball != 0) {
            resultMessageList.add(ball + GameMessage.BALL_MESSAGE);
        }
        if (strike != 0) {
            resultMessageList.add(strike + GameMessage.STRIKE_MESSAGE);
        }
        System.out.println(String.join(" ", resultMessageList));
    }
}
