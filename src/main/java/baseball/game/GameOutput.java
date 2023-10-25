package baseball.game;

import static baseball.constant.MessageConstants.ASK_ONE_OR_TWO;
import static baseball.constant.MessageConstants.BALL;
import static baseball.constant.MessageConstants.BLANK;
import static baseball.constant.MessageConstants.CANNOT_INSTANTIATE;
import static baseball.constant.MessageConstants.END;
import static baseball.constant.MessageConstants.NOTHING;
import static baseball.constant.MessageConstants.REQUEST;
import static baseball.constant.MessageConstants.START;
import static baseball.constant.MessageConstants.STRIKE;
import static baseball.constant.MessageConstants.THREE_STRIKE;

public class GameOutput {

    private GameOutput() {
        throw new AssertionError(CANNOT_INSTANTIATE);
    }

    public static void printlnNothing() {
        System.out.println(NOTHING);
    }

    public static void printRequestMessage() {
        System.out.print(REQUEST);
    }

    public static void printlnStartMessage() {
        System.out.println(START);
    }

    public static void printlnEndMessage() {
        System.out.println(END);
    }

    public static void printCorrectBallCount(int ballCount) {
        System.out.print(ballCount + BALL + BLANK);
    }

    public static void printCorrectStrikeCount(int strikeCount) {
        System.out.print(strikeCount + STRIKE);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printStrikeThree(int strikeCount) {
        System.out.println(strikeCount + STRIKE);
        System.out.println(THREE_STRIKE);
        System.out.println(ASK_ONE_OR_TWO);
    }

}
