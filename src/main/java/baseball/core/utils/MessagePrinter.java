package baseball.core.utils;

import baseball.core.code.Message;

public class MessagePrinter {
    private MessagePrinter() {
        throw new IllegalStateException("Utility class");
    }
    public static void print(Message message) {
        System.out.println(message.getDescription());
    }
    public static void print(String str) {
        System.out.println(str);
    }
}
