package baseball.view;

import static baseball.constant.InfoMessage.*;

public class Printer {

    public static void printStartMessage() {
        System.out.println(GAME_START);
    }

    public static void printPlayMessage() {
        System.out.print(NUMBER_INPUT);
    }

    public static void printNothingMessage() {
        System.out.println(NOTHING);
    }

    public static void printBallMessageWithoutStrike(int countOfBall) {
        System.out.println(countOfBall + BALL);
    }

    public static void printBallMessageWithStrike(int countOfBall) {
        System.out.print(countOfBall + BALL + " ");
    }

    public static void printStrikeMessage(int countOfStrike) {
        System.out.println(countOfStrike + STRIKE);
    }

    public static void printGameClearMessage() {
        System.out.println(GAME_CLEAR);
    }

    public static void printContinueMessage() {
        System.out.println(CONTINUE_OR_STOP);
    }

}
