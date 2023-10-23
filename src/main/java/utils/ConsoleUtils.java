package utils;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleUtils {
    public static String input() {
        return Console.readLine();
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static void println(String message) {
        System.out.println(message);
    }
}
