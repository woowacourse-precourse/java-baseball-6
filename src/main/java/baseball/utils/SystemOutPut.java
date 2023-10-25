package baseball.utils;

import static baseball.constant.Message.BALL;
import static baseball.constant.Message.END_MSG;
import static baseball.constant.Message.INPUT_MSG;
import static baseball.constant.Message.NOTHING;
import static baseball.constant.Message.RESTART_MSG;
import static baseball.constant.Message.START_MSG;
import static baseball.constant.Message.STRIKE;


public class SystemOutPut {
    public static void printStartMsg() {
        System.out.println(START_MSG);
    }

    public static void printInputMsg() {
        System.out.print(INPUT_MSG);
    }

    public static void printEndMsg() {
        System.out.println(END_MSG);
    }

    public static void printRestartMsg() {
        System.out.println(RESTART_MSG);
    }


    private static void printBallMsg(int[] count) {
        System.out.println(count[1] + BALL);
    }

    private static void printStrikeMsg(int[] count) {
        System.out.println(count[0] + STRIKE);
    }

    private static void printBallAndStrikeMsg(int[] count) {
        System.out.println(count[1] + BALL + " " + count[0] + STRIKE);
    }

    private static void printNothingMsg() {
        System.out.println(NOTHING);
    }

    public static void printScoreMsg(int[] count) {
        if (count[0] == 0 && count[1] == 0) {
            printNothingMsg();
            return;
        }
        if (count[0] > 0 && count[1] > 0) {
            printBallAndStrikeMsg(count);
            return;
        }
        if (count[1] > 0) {
            printBallMsg(count);
        }
        if (count[0] > 0) {
            printStrikeMsg(count);
        }
        if (count[0] == 3) {
            printEndMsg();
            printRestartMsg();
        }
    }

}
