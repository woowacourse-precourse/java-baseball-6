package baseball.view;

import static baseball.utils.GameMessage.*;

import baseball.domain.wrapped.Strike;

public class OutputView {
    public static void printAskRestartOrExitMessage() {
        System.out.println(ASK_RESTART_OR_EXIT_MESSAGE);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMessageWithoutNewLine(String message) {
        System.out.print(message);
    }
}
