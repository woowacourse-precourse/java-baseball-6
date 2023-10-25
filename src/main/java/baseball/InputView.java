package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String setUserNumber() {
        OutputView.printInputMessage();
        return Console.readLine();
    }

    public static String setRetryNumber() {
        OutputView.printRetryMessage();
        return Console.readLine();
    }

}
