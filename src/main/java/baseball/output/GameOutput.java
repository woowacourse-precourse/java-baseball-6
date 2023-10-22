package baseball.output;

import static baseball.constant.MessageConstants.NOTHING;
import static baseball.constant.MessageConstants.REQUEST;
import static baseball.constant.MessageConstants.START;

public class GameOutput {

    public static void printlnNothing() {
        System.out.println(NOTHING);
    }

    public static void printRequestMessage() {
        System.out.print(REQUEST);
    }

    public static void printlnStartMessage() {
        System.out.println(START);
    }

}
