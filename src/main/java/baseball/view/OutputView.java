package baseball.view;

import baseball.constants.OutputMessage;

public class OutputView {
    public static void printGameStartMessage() {
        System.out.println(OutputMessage.GAME_START);
    }

    public static void printInputMessage() {
        System.out.print(OutputMessage.INPUT_PLAYER_NUMBERS);
    }

    public static void printResult(String result) {
        System.out.println(result);
    }

    public static void printAskRestartOrExit() {
        System.out.println(OutputMessage.RESTART_OR_EXIT);
    }

    public static void printGameExitMessage() {
        System.out.println(OutputMessage.GAME_EXIT);
    }
}