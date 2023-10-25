package baseball.console;

import static baseball.constants.Constants.REQUIRED_NUMBERS_TO_MATCH;
import static baseball.constants.Messages.*;

public class Output {

    public static void print(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            printNothingMessage();
            return;
        }
        if (ball == 0) {
            printStrikeMessage(strike);
            return;
        }
        if (strike == 0) {
            printBallMessage(ball);
            return;
        }
        printBallAndStirkeMessage(ball, strike);
    }

    public static void printBallMessage(int ball) {
        System.out.printf(BALL_MESSAGE.getMessage(), ball);
    }

    public static void printStrikeMessage(int strike) {
        System.out.printf(STRIKE_MESSAGE.getMessage(), strike);
    }

    public static void printBallAndStirkeMessage(int ball, int strike) {
        System.out.printf(BALL_AND_STRIKE_MESSAGE.getMessage(), ball, strike);
    }

    public static void printNothingMessage() {
        System.out.printf(NOTHING_MESSAGE.getMessage());
    }

    public static void printAnswerMessage() {
        System.out.printf(ANSWER_MESSAGE.getMessage(), REQUIRED_NUMBERS_TO_MATCH.getValue());
    }
}