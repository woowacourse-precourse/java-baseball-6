package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String requestUserNumbers() {
        OutputView.printRequestNumber();
        return Console.readLine();
    }

    public static String requestRestartOrExit() {
        OutputView.printGameOver();
        OutputView.printRequestRestartOrExit();
        return Console.readLine();
    }
}
