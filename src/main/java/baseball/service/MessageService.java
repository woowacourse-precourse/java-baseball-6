package baseball.service;

import baseball.constant.MessageConstant;
import baseball.constant.NumberConstant;

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
            System.out.println(ballCount + MessageConstant.BALL + strikeCount + MessageConstant.STRIKE);
        }
        if (ballCount > 0 && strikeCount == 0){
            System.out.println(ballCount + MessageConstant.BALL);
        }
        if (ballCount == 0 && strikeCount > 0){
            System.out.println(strikeCount + MessageConstant.STRIKE);
        }
    }

}
