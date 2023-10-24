package baseball.global.util;

public final class MessagePrinter {

    private MessagePrinter() {
    }
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printNumberAndMessage(int number, String message) {
        System.out.println(number + message);
    }
}
