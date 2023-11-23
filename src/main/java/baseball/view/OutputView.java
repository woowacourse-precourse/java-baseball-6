package baseball.view;

import static baseball.utils.GameMessage.*;

public class OutputView {
    public static void printStartGameMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public static void printAskRestartOrExitMessage() {
        System.out.println(ASK_RESTART_OR_EXIT_MESSAGE);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
