package baseball;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput implements Input {

    private String getInput() {
        return Console.readLine().strip();
    }

    @Override
    public String getRestartInput() {
        return getInput();
    }

    @Override
    public String getGameInput() {
        return getInput();
    }
}
