package baseball.view;

import baseball.util.ConsoleMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readPlayerNumber() {
        System.out.print(ConsoleMessage.READ_PLAYER_NUMBER);
        return Console.readLine();
    }

    public static String readRetryCommand() {
        System.out.print(ConsoleMessage.READ_RETRY_COMMAND);
        return Console.readLine();
    }

}
