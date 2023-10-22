package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String askUserNumbers() {
        OutputView.printAskNumber();
        return Console.readLine();
    }

    public static String askRestartOrExit() {
        OutputView.printGameOver();
        OutputView.printAskRestartOrExit();
        return Console.readLine();
    }
}
