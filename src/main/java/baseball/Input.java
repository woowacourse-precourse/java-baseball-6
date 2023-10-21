package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String readUserNumbers() {
        System.out.print(Constants.INPUT_USER_NUMBER);
        return Console.readLine();
    }

    public static String readModeRestartOrEnd() {
        System.out.println(Constants.INPUT_MODE_RESTART_OR_END);
        return Console.readLine();
    }
}
