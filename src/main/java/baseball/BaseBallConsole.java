package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallConsole {
    public static void print(String line) {
        System.out.print(line);
    }

    public static String readLine(String message) {
        print(message);
        String line = Console.readLine();

        return line;
    }
}
