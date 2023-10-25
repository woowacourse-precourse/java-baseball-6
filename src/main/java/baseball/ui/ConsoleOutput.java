package baseball.ui;

public class ConsoleOutput implements Output {

    @Override
    public void print(Message message) {
        System.out.print(message.getMessage());
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
