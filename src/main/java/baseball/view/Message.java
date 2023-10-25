package baseball.view;

import baseball.model.Hint;

import static baseball.constant.Const.*;

public class Message {

    public static void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printInputMessage() {
        System.out.println(INPUT_NUMBER_MESSAGE);
    }

    public static void printGameEnd() {
        System.out.println(GAME_OVER_MESSAGE);
        System.out.println(GAME_RESET_MESSAGE);
    }

    public static void printHint() {
        System.out.println(Hint.getHintByCount());
    }


}
