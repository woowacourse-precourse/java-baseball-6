package baseball.view;

import baseball.Message;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputUserNumber() {
        System.out.print(Message.INPUT_USERNUMBER_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String inputRestartOption() {
        System.out.println(Message.INPUT_RESTARTOPTION_MESSAGE.getMessage());
        return Console.readLine();
    }
}
