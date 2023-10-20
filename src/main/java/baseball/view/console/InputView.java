package baseball.view.console;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String requestPlayerGuess() {
        return Console.readLine();
    }

    public String requestRestartChoice() {
        return Console.readLine();
    }
}
