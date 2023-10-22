package baseball.view;

public class ConsoleOutputView implements OutputView {

    @Override
    public void print(final String message) {
        System.out.println(message);
    }
}
