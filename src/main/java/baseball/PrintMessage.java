package baseball;

import baseball.enums.Message;

public class PrintMessage {

    public static void printlnMessage(Message message) {
        System.out.println(message.getKorMessage());
    }

    public static void printMessage(Message message) {
        System.out.print(message.getKorMessage());
    }

    public static void printMessage(String message) {
        System.out.print(message);
    }

    public static void printlnMessage(String message) {
        System.out.println(message);
    }
}
