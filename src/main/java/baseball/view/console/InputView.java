package baseball.view.console;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String requestPlayerGuess() {
        return Console.readLine();
    }

    public static String requestRestartChoice() {
        return Console.readLine();
    }
}
