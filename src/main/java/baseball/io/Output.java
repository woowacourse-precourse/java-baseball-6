package baseball.io;

import baseball.constans.GameMessage;

public class Output {

    private Output() {

    }

    public static void printStartMessage() {
        System.out.println(GameMessage.GAME_START.getMessage());
    }

    public static void printRequestUserNumberInput() {
        System.out.print(GameMessage.REQUEST_USER_NUMBER_INPUT.getMessage());
    }

    public static void printHint(int[] result) {
        StringBuilder stringBuilder = new StringBuilder();
        if (result[0] != 0) {
            stringBuilder.append(result[0]).append(GameMessage.BALL.getMessage());
        }
        if (result[1] != 0) {
            stringBuilder.append(result[1]).append(GameMessage.STRIKE.getMessage());
        }
        if (stringBuilder.isEmpty()) {
            stringBuilder.append(GameMessage.NOTHING.getMessage());
        }
        System.out.println(stringBuilder);
    }

    public static void printFinishOrRestart() {
        System.out.println(GameMessage.FINISHE_OR_RESTART.getMessage());

    }

}
