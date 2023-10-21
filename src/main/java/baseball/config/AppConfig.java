package baseball.config;

import baseball.util.MessagePrinter;
import baseball.util.MessagePrinterImpl;

public class AppConfig {

    private static final MessagePrinter messagePrinter;

    static {
        messagePrinter = new MessagePrinterImpl();
    }

    public static MessagePrinter getMessagePrinter() {
        return messagePrinter;
    }
}
