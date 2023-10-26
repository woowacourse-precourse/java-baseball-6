package baseball.view;

import static baseball.message.Message.BALL_MSG;
import static baseball.message.Message.NON_MSG;
import static baseball.message.Message.STRIKE_MSG;

public class PrintMessage {

    public static void println(String s) {
        System.out.println(s);
    }

    public static void print(String s) {
        System.out.print(s);
    }

    public static void outputMessage(int ball, int strike) {
        StringBuilder sb = new StringBuilder();
        if (ball != 0) {
            sb.append(ball + BALL_MSG + " ");
        }
        if (strike != 0) {
            sb.append(strike + STRIKE_MSG);
        }
        if (sb.isEmpty()) {
            println(NON_MSG);
        } else {
            println(sb.toString());
        }
    }
}
