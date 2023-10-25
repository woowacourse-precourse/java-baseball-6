package baseball;

import static baseball.BaseballConstants.*;
public abstract class GameMessagesPrinter {
    private static void printer(String message) {
        System.out.println(message);
    }
    public static void inputNumberMessage() {
        printer(INPUT_MESSAGE);
    }
    public static void startGameMessage() {
        printer(GAME_START_MESSAGE);
    }
    public static void endGameMessage() {
        printer(GAME_END_MESSAGE);
    }
    public static void restartMessage() {
        printer(RESTART_CHOICE_MESSAGE);
    }
    public static void successMessage() {
        printer(SUCCESS_MESSAGE);
    }
}
