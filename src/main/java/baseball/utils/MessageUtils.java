package baseball.utils;

import baseball.constants.MessageConstants;

public class MessageUtils {
    public static void startMessage() {
        System.out.println(MessageConstants.GAME_START);
    }

    public static void inputPromptMessage() {
        System.out.print(MessageConstants.INPUT_NUMBER);
    }

    public static void resultMessage(int strike, int ball) {
        if (strike < 3 && strike > 0 && ball == 0) {
            System.out.println(strike + MessageConstants.STRIKE);
        }
        if (strike == 0 && ball != 0) {
            System.out.println(ball + MessageConstants.BALL);
        }
        if (strike != 0 && ball != 0) {
            System.out.println(ball + MessageConstants.BALL + " " + strike + MessageConstants.STRIKE);
        }
        if (strike == 0 && ball == 0) {
            System.out.println(MessageConstants.NOTHING);
        }
        if (strike == 3) {
            System.out.println(MessageConstants.THREE_STRIKES);
            System.out.println(MessageConstants.GAME_OVER);
            System.out.println(MessageConstants.RESTART_OR_QUIT);
        }
    }
}
