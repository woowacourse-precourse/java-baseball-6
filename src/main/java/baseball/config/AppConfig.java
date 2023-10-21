package baseball.config;

import baseball.domain.Batter;
import baseball.domain.BatterImpl;
import baseball.domain.Pitcher;
import baseball.domain.PitcherImpl;
import baseball.util.InputHandler;
import baseball.util.InputHandlerImpl;
import baseball.util.MessagePrinter;
import baseball.util.MessagePrinterImpl;

public class AppConfig {

    private static final MessagePrinter messagePrinter;
    private static final InputHandler inputHandler;
    private static final Pitcher pitcher;
    private static final Batter batter;

    static {
        messagePrinter = new MessagePrinterImpl();
        inputHandler = new InputHandlerImpl();
        pitcher = new PitcherImpl();
        batter = new BatterImpl();
    }

    public static MessagePrinter getMessagePrinter() {
        return messagePrinter;
    }

    public static Pitcher getPitcher() {
        return pitcher;
    }

    public static InputHandler getInputHandler() {
        return inputHandler;
    }

    public static Batter getBatter() {
        return batter;
    }
}
