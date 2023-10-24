package baseball;

import camp.nextstep.edu.missionutils.Console;

public class DefaultConsoleService implements ConsoleService {
    @Override
    public String readLine() {
        return Console.readLine();
    }

    @Override
    public void close() {
        Console.close();
    }
}
