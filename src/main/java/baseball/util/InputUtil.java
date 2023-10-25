package baseball.util;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {
    public static String getString() {
        return Console.readLine();
    }

    public static void closeConsole() {
        Console.close();
    }
}
