package baseball.util;

import camp.nextstep.edu.missionutils.Console;

public class IoHelper {
    public static void print(String message) {
        System.out.print(message);
    }

    public static void println(String message) {
        print(message + "\n");
    }

    public static String prompt(String message) {
        print(message);
        return Console.readLine();
    }

    public static String promptColon(String message) {
        return prompt(message + " : ");
    }

    public static String promptln(String message) {
        return prompt(message + "\n");
    }
}
