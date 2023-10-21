package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getUserNumber() {
        OutputView.printInputUserNumberMessage();
        return Console.readLine();
    }

    public static String getRestartOrExit() {
        OutputView.printRestartOrExit();
        return Console.readLine();
    }
}
