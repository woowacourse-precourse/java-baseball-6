package baseball;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleReader implements Reader {

    @Override
    public String read() {
        return Console.readLine();
    }
}
