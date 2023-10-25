package baseball.view;

import baseball.util.Messages;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getUserNumber() {
        System.out.print(Messages.GET_USER_NUMBER_MESSAGE.getMessage());
        return Console.readLine();
    }

    public String getRestartOrEndNumber() {
        System.out.println(Messages.RESTART_OR_END_MESSAGE.getMessage());
        return Console.readLine();
    }
}
