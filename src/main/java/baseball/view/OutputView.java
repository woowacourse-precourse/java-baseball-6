package baseball.view;

import baseball.utils.Message;

import static baseball.utils.Message.*;

public abstract class OutputView {

    private OutputView() {}

    public static void printGameStartView() {
        System.out.println(START_GAME_MESSAGE.getMessage());
    }

    public static void printBallCount(int value) {
        if (value == 0) {
            return;
        }
        System.out.print(value + BALL.getMessage());
    }

    public static void printStrikeCount(int value) {
        if (value == 0) {
            return;
        }
        System.out.println(value + STRIKE.getMessage());
    }

    public static void printNothing() {
        System.out.println(NOTHING.getMessage());
    }

    public static void printEndGame() {
        System.out.println(END_GAME_MESSAGE.getMessage());
    }

    public static void printRestartGame() {
        System.out.println(RESTART_GAME_MESSAGE.getMessage());
    }

    public static void printPerfect() {
        System.out.println(PERFECT_MESSAGE.getMessage());
    }
}
