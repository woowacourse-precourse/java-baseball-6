package baseball.ui;

public class ConsoleOutput implements IOutput {

    @Override
    public void printMessage(String message) {
        System.out.print(message);
    }

    @Override
    public void printErrorMessage(String message) {
        System.err.println(message);
    }
}
