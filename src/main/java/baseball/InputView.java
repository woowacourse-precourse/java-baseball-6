package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readPlayerNumber() {
        OutputView.printPlayerNumMessage();
        return Console.readLine();
    }

    public static String readRetryNumber() {
        OutputView.printRetryMessage();
        return Console.readLine();
    }

}
