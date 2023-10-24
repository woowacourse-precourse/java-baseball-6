package baseball.view;

import baseball.constants.OutputMessage;

public class OutputView {
    public static void printGameStartMessage() {
        System.out.println(OutputMessage.GAME_START);
    }

    public static void printResult(int ballCount, int strikeCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println(OutputMessage.NOTHING);
        } else if (strikeCount == 3) {
            System.out.println(3 + OutputMessage.STRIKE
                    + System.lineSeparator() + OutputMessage.GAME_EXIT);
        } else if (strikeCount == 0) {
            System.out.println(ballCount + OutputMessage.BALL);
        } else if (ballCount == 0) {
            System.out.println(strikeCount + OutputMessage.STRIKE);
        } else {
            System.out.println(ballCount + OutputMessage.BALL + " " + strikeCount + OutputMessage.STRIKE);
        }
    }

    public static void printGameExitMessage() {
        System.out.println(OutputMessage.GAME_EXIT);
    }
}