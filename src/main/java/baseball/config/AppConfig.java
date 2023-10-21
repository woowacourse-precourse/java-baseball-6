package baseball.config;

import baseball.domain.Pitcher;
import baseball.domain.PitcherImpl;
import baseball.util.MessagePrinter;
import baseball.util.MessagePrinterImpl;

public class AppConfig {

    private static final MessagePrinter messagePrinter;
    private static final Pitcher pitcher;

    static {
        messagePrinter = new MessagePrinterImpl();
        pitcher = new PitcherImpl();
    }

    public static MessagePrinter getMessagePrinter() {
        return messagePrinter;
    }

    public static Pitcher getPitcher() {
        return pitcher;
    }
}
