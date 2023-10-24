package baseball;

public class DoubleConsoleService implements ConsoleService {

    private final String consoleValue;

    public DoubleConsoleService(String consoleValue) {
        this.consoleValue = consoleValue;
    }

    @Override
    public String readLine() {
        return consoleValue;
    }

    @Override
    public void close() {
    }
}
