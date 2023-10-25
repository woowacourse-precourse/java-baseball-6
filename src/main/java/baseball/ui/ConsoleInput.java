package baseball.ui;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput implements Input {

    @Override
    public String scan() {
        return Console.readLine();
    }
}
