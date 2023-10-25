package baseball.ui;

public class ConsoleOutput implements IOutput {

    @Override
    public void print(Message message) {
        System.out.print(message.getMessage());
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
