package baseball.io;

import baseball.io.console.ConsoleReader;
import baseball.io.console.ConsoleWriter;

public class PlayerIoManager {

    private ConsoleReader consoleReader;
    private ConsoleWriter consoleWriter;

    private PlayerIoManager(ConsoleReader consoleReader, ConsoleWriter consoleWriter) {
        this.consoleReader = consoleReader;
        this.consoleWriter = consoleWriter;
    }

    public static PlayerIoManager create() {
        return new PlayerIoManager(new ConsoleReader(), new ConsoleWriter());
    }

    public void welcomePlayer() {
        consoleWriter.printGameStartText();
    }

}
