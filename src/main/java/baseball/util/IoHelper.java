package baseball.util;

import camp.nextstep.edu.missionutils.Console;

public class IoHelper {
    public static void print(Object message) {
        System.out.print(message.toString());
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
