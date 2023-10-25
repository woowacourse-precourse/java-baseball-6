package baseball.view;

import baseball.constants.Constants;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getInputNumber() {
        System.out.print(Constants.NUMBER_QUESTION);
        return Console.readLine();
    }

    public static String getRestartOrQuit() {
        System.out.println(Constants.RESTART_OR_QUIT_QUESTION);
        return Console.readLine();
    }

}
