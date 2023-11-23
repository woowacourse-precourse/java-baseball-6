package baseball.view;

import static baseball.utils.GameMessage.*;

public class OutputView {
    public static void printAskRestartOrExitMessage() {
        System.out.println(ASK_RESTART_OR_EXIT_MESSAGE.getMessage());
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMessageWithoutNewLine(String message) {
        System.out.print(message);
    }
}
