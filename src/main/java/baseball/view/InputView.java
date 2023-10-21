package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {}

    public static String readUserInput() {
        return Console.readLine();
    }
}
