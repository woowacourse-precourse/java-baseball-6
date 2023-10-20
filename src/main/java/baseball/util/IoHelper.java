package baseball.util;

import camp.nextstep.edu.missionutils.Console;
import java.io.PrintStream;

public class IoHelper {
    private static final PrintStream outputStream = System.out;

    public static void print(Object message) {
        var messageString = message.toString();
        outputStream.print(messageString);
    }

    public static void println(Object message) {
        print(message + "\n");
    }

    public static String prompt(Object message) {
        print(message);
        return Console.readLine();
    }

    public static String promptColon(Object message) {
        return prompt(message + " : ");
    }

    public static String promptln(Object message) {
        return prompt(message + "\n");
    }

}
