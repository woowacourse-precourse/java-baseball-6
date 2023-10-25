package baseball.io;

import camp.nextstep.edu.missionutils.Console;

public final class ConsoleInputReader {

    public static String read() {
        return Console.readLine().strip();
    }
}
