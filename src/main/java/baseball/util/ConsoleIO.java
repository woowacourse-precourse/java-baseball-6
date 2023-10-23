package baseball.util;

import static baseball.constant.GamePlayMessage.GAME_CLEAR_MESSAGE;
import static baseball.constant.GamePlayMessage.REQUEST_INPUT_NEXT_ROUND_OR_END_GAME_MESSAGE;
import static baseball.constant.GamePlayMessage.REQUEST_INPUT_NUMBER_MESSAGE;
import static baseball.constant.GamePlayMessage.START_GAME_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleIO {
    public static void printStartMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public static String readPlayerNumber() {
        System.out.print(REQUEST_INPUT_NUMBER_MESSAGE);

        return Console.readLine();
    }

    public static void printResultMessage(String resultMessage) {
        System.out.println(resultMessage);
    }

    public static void printEndMessage() {
        System.out.println(GAME_CLEAR_MESSAGE);
    }

    public static String readEndOption() {
        System.out.println(REQUEST_INPUT_NEXT_ROUND_OR_END_GAME_MESSAGE);

        return Console.readLine();
    }
}
