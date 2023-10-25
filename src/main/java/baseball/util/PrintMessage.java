package baseball.util;

import baseball.domain.GameResult;
import baseball.game.GameHintEnum;

public class PrintMessage {
    public static void printStartMessage(){
        System.out.println(MessageEnum.START_MESSAGE.getMessage());
    }

    public static void printInputStartMessage(){
        System.out.print(MessageEnum.INPUT_START_MESSAGE.getMessage());
    }

    public static void printSuccessMessage() {
        System.out.println(MessageEnum.SUCCESS_MESSAGE.getMessage());
    }

    public static void printHint(GameResult result) {
        //TODO 힌트 계산
    }
}
