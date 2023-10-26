package baseball.view;

import baseball.constants.Message;

public class OutputView {
    public static void printGameStartMessage() {
        System.out.println(Message.GAME_START);
    }

    public static void printInputMessage() {
        System.out.print(Message.INPUT_PLAYER_NUMBERS);
    }

    public static void printResult(String result) {
        System.out.println(result);
    }

    public static void printAskRestartOrExit() {
        System.out.println(Message.RESTART_OR_EXIT);
    }

    public static void printGameExitMessage() {
        System.out.println(Message.GAME_EXIT);
    }
}