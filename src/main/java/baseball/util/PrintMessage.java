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
        if(result.isNothing()) {
            System.out.println(GameHintEnum.NOTHING.getHintMessage());
            return;
        }

        int resultBall = result.getBall();
        int resultStrike = result.getStrike();

        if(resultBall != 0)
            System.out.print(resultBall + GameHintEnum.BALL.getHintMessage() + " ");

        if(resultStrike != 0)
            System.out.print(resultStrike + GameHintEnum.STRIKE.getHintMessage());

        System.out.println();
    }
}
