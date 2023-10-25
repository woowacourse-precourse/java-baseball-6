package baseball.view;

import baseball.domain.Constants;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getUserNumber() {
        System.out.print(Constants.NUMBER_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String getRestartCommand() {
        System.out.println(Constants.RESTART_OPTION_MESSAGE);
        return Console.readLine();
    }

}
