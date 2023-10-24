package baseball.view;

import baseball.constants.OutputMessage;

public class OutputView {
    public static void printGameStartMessage() {
        System.out.println(OutputMessage.GAME_START);
    }

    public static void printResult(int ballCount, int strikeCount) {
        StringBuilder message = new StringBuilder();

        if (strikeCount == 0 && ballCount == 0) {
            message.append(OutputMessage.NOTHING);
        } else if (strikeCount == 3) {
            message.append(3).append(OutputMessage.STRIKE).append(System.lineSeparator())
                    .append(OutputMessage.GAME_EXIT);
        } else if (strikeCount == 0) {
            message.append(ballCount).append(OutputMessage.BALL);
        } else if (ballCount == 0) {
            message.append(strikeCount).append(OutputMessage.STRIKE);
        } else {
            message.append(ballCount).append(OutputMessage.BALL).append(" ").append(strikeCount)
                    .append(OutputMessage.STRIKE);
        }
        System.out.println(message);
    }

    public static void printGameExitMessage() {
        System.out.println(OutputMessage.GAME_EXIT);
    }
}