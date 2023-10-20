package baseball.view;

import baseball.resource.GameMessage;

public class OutPutView {

    public static void printStartMessage() {
        System.out.println(GameMessage.START_MESSAGE);
    }
    public static void printInputMessage() {
        System.out.print(GameMessage.INPUT_NUMBER_MESSAGE);
    }

    public static void printEndMessage() {
        System.out.println(GameMessage.END_MESSAGE);
    }

    public static void printReStartMessage() {
        System.out.println(GameMessage.RESTART_QUESTION_MESSAGE);
    }
}
