package baseball;

import baseball.enums.GameProgressMessage;

public class PrintMessage {

    public static void printlnMessage(GameProgressMessage gameProgressMessage) {
        System.out.println(gameProgressMessage.getKorMessage());
    }

    public static void printMessage(GameProgressMessage gameProgressMessage) {
        System.out.print(gameProgressMessage.getKorMessage());
    }

    public static void printMessage(String message) {
        System.out.print(message);
    }

    public static void printlnMessage(String message) {
        System.out.println(message);
    }
}
