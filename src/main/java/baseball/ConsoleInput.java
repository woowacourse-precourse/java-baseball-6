package baseball;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput implements Input {
    @Override
    public String readLine() {
        return Console.readLine();
    }
}