package baseball.domain;

import baseball.util.MessagePrinter;

public class BaseballGame {

    private final MessagePrinter messagePrinter;

    private BaseballGame(MessagePrinter messagePrinter) {
        this.messagePrinter = messagePrinter;
    }

    public static BaseballGame from(MessagePrinter messagePrinter) {
        return new BaseballGame(messagePrinter);
    }

    public void start() {
        messagePrinter.printStartMessage();
    }
}
