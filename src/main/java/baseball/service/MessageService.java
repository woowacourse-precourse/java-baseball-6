package baseball.service;

import baseball.constant.MessageConstant;

public class MessageService {
    public void printStartMessage() {
        System.out.println(MessageConstant.GAME_START_MESSAGE);
    }

    public void printUserInputNumberMessage() {
        System.out.print(MessageConstant.INPUT_MESSAGE);
    }

    public void printComparisonResult(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println(MessageConstant.NOTHING);
        }
        if (ballCount > 0 && strikeCount > 0) {
            System.out.println(ballCount + MessageConstant.BALL + " " + strikeCount + MessageConstant.STRIKE);
        }
        if (ballCount > 0 && strikeCount == 0) {
            System.out.println(ballCount + MessageConstant.BALL);
        }
        if (ballCount == 0 && strikeCount > 0) {
            System.out.println(strikeCount + MessageConstant.STRIKE);
        }
    }

    public void printWinMessage() {
        System.out.println(MessageConstant.WINNER_MESSAGE);
    }

    public void printGameRestartOrGameEndMessage() {
        System.out.println(MessageConstant.RESTART_OR_END_MESSAGE);
    }
}
