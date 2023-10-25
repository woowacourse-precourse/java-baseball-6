package baseball.utils;

import static baseball.constant.Message.END_MSG;
import static baseball.constant.Message.INPUT_MSG;
import static baseball.constant.Message.RESTART_MSG;
import static baseball.constant.Message.START_MSG;

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
}
