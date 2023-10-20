package baseball.view;

import baseball.util.Constants;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static void displayGameStart() {
        System.out.println(Constants.GAME_START_MESSAGE);
    }

    public static String getPlayerInput() {
        System.out.print(Constants.NUMBER_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String inputRestartOrFinish() {
        System.out.println(Constants.GAME_RESTART_MESSAGE);
        return Console.readLine();
    }
}
