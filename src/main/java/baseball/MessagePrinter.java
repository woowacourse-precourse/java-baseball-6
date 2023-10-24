package baseball;

public class MessagePrinter {

    public static void printGameStartMessage() {
        System.out.println(GameMessage.GAME_START);
    }

    public static void printRetryInputMessage() {
        System.out.println(GameMessage.RETRY_INPUT);
    }

    public static void printNumberInputMessage() {
        System.out.print(GameMessage.NUMBER_INPUT);
    }

    public static void printGameEndMessage() {
        System.out.println(GameMessage.GAME_END);
    }

    public static void printResultMessage(GameResult result) {
        System.out.println(result.toString());
    }
}
