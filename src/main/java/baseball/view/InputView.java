package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String requestUserNumber() {
        OutputView.printRequestNumber();
        return Console.readLine();
    }

    public static String requestRestartOrExit() {
        OutputView.printRequestRestartOrExit();
        String input = Console.readLine();
        return input;
    }
}
