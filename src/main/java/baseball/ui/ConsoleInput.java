package baseball.ui;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput implements InputUserInterface {

    @Override
    public String intercept() {
        return Console.readLine();
    }
}
