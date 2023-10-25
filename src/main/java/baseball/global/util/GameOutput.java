package baseball.global.util;

import static baseball.global.enums.GuideMessage.FINISH_GUIDE;
import static baseball.global.enums.GuideMessage.INPUT_COMMAND;

public final class GameOutput {

    public static void printResult(String result) {
        System.out.println(result);
    }

    public static void printFinish() {
        System.out.println(FINISH_GUIDE.message);
    }

    public static void printRestart() {
        System.out.println();
    }

    public static void inputCommand() {
        System.out.println(INPUT_COMMAND.message);
    }

    public static void errorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
