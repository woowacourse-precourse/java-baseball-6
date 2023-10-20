package message;

import static constant.StringConstant.*;

import score.Score;
import utils.BaseballRules;

public class Message {

    public static void printIntegerInputFromUserMessage() {
        System.out.print(INTEGER_INPUT_FROM_USER);
    }

    public static void printContinueOrFinishMessage() {
        System.out.println(CONTINUE_OR_FINISH);
    }

    public static void printThreeStrikeMessage() {
        System.out.print(THREE_STRIKE);
        System.out.println(END_GAME);
    }

    public static void printEndGameMessage() {
        System.out.println(END_GAME);
    }

    public static void printHintMessage(Score score) {
        int strike = score.getStrike();
        int ball = score.getBall();

        if (BaseballRules.hasStrikeAndBall(strike, ball)) {
            System.out.println(ball + BALL + " " + strike + STRIKE);
        }
        if (BaseballRules.hasStrikeButNoBall(strike, ball)) {
            System.out.println(strike + STRIKE);
        }
        if (BaseballRules.hasBallButNoStrike(strike, ball)) {
            System.out.println(ball + BALL);
        }
        if (BaseballRules.noStrikeAndBall(strike, ball)) {
            System.out.println(NOTHING);
        }
    }

    public static void printErrorMessage() {
        System.out.println(INVALID_INPUT_MESSAGE);
    }
}
