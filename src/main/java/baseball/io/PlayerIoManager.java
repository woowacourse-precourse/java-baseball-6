package baseball.io;

import baseball.io.console.ConsoleReader;
import baseball.io.console.ConsoleWriter;
import baseball.utils.NumberValidator;
import java.util.List;

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

    public List<Integer> askThreeNumbers() {
        consoleWriter.printNumberInputText();

        List<Integer> numbers = consoleReader.readThreeNumbers();
        NumberValidator.validateNumbersInRange(numbers, 1, 9);
        NumberValidator.validateNotDuplicated(numbers);

        return numbers;
    }

}
