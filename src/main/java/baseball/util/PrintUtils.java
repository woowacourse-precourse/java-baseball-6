package baseball.util;

import baseball.enums.Message;

public class PrintUtils {
    public static void println(String message) {
        System.out.println(message.trim());
    }

    public static void printMessage(Message message) {
        System.out.println(message.getMessage().trim());
    }
}
