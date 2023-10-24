package baseball.view;

import baseball.constants.Message;

public class OutputView {
    public static void printGameStartMessage() {
        System.out.println(Message.OutputMessage.GAME_START);
    }

    public static void printResult(int ballCount, int strikeCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println(Message.OutputMessage.NOTHING);
        } else if (strikeCount == 3) {
            System.out.println(3 + Message.OutputMessage.STRIKE
                    + System.lineSeparator() + Message.OutputMessage.GAME_EXIT);
        } else if (strikeCount == 0) {
            System.out.println(ballCount + Message.OutputMessage.BALL);
        } else if (ballCount == 0) {
            System.out.println(strikeCount + Message.OutputMessage.STRIKE);
        } else {
            System.out.println(
                    ballCount + Message.OutputMessage.BALL + " " + strikeCount + Message.OutputMessage.STRIKE);
        }
    }

    public static void printGameExitMessage() {
        System.out.println(Message.OutputMessage.GAME_EXIT);
    }
}