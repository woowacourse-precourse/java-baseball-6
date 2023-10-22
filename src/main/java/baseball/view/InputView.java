package baseball.view;

import baseball.utils.Message;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getInputNumber() {
        System.out.print(Message.INPUT_NUMBER);
        return Console.readLine();
    }

    public static String getInputRestartOrExit() {
        System.out.println(Message.RESTART_GAME);
        return Console.readLine();
    }
}
