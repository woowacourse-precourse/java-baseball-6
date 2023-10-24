package baseball.view;

import static baseball.view.message.GameMessage.EXIT_MESSAGE;
import static baseball.view.message.GameMessage.GAME_OVER_MESSAGE;
import static baseball.view.message.GameMessage.START_MESSAGE;

public class OutputView {
    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printGameOverMessage() {
        System.out.println(GAME_OVER_MESSAGE);
    }

    public static void printExitMessage() {
        System.out.println(EXIT_MESSAGE);
    }
}
