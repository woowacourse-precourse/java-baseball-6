package message;

import static constant.StringConstant.BALL;
import static constant.StringConstant.CONTINUE_OR_FINISH;
import static constant.StringConstant.END_GAME;
import static constant.StringConstant.INTEGER_INPUT_FROM_USER;
import static constant.StringConstant.INVALID_INPUT_MESSAGE;
import static constant.StringConstant.NOTHING;
import static constant.StringConstant.STRIKE;
import static constant.StringConstant.THREE_STRIKE;
import static utils.BaseballRules.hasBallButNoStrike;
import static utils.BaseballRules.hasStrikeAndBall;
import static utils.BaseballRules.hasStrikeButNoBall;
import static utils.BaseballRules.noStrikeAndBall;

import score.BaseballScore;

public class Message {

    public static void printIntegerInputFromUserMessage() {
        System.out.print(INTEGER_INPUT_FROM_USER);
    }

    public static void printContinueOrFinishMessage() {
        System.out.println(CONTINUE_OR_FINISH);
    }

    public static void printThreeStrikeMessage() {
        System.out.print(THREE_STRIKE + " ");
        System.out.println(END_GAME);
    }

    public static void printEndGameMessage() {
        System.out.println(END_GAME);
    }

    public static void printHintMessage(BaseballScore score) {
        int strike = score.getStrike();
        int ball = score.getBall();

        if (hasStrikeAndBall(strike, ball)) {
            System.out.println(ball + BALL + " " + strike + STRIKE);
        }
        if (hasStrikeButNoBall(strike, ball)) {
            System.out.println(strike + STRIKE);
        }
        if (hasBallButNoStrike(strike, ball)) {
            System.out.println(ball + BALL);
        }
        if (noStrikeAndBall(strike, ball)) {
            System.out.println(NOTHING);
        }
    }

    public static void printErrorMessage() {
        System.out.println(INVALID_INPUT_MESSAGE);
    }
}
