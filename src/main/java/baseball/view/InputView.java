package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getConsoleInput() {
        return Console.readLine();
    }

    public static String getUserBaseballNumbersString() {
        OutputView.printEnterNumber();
        return Console.readLine();
    }

    public static String getRestartOrNot() {
        OutputView.printGameStart();
        return Console.readLine();
    }
}
