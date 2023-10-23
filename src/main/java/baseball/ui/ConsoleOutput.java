package baseball.ui;

public class ConsoleOutput implements OutputUserInterface {

    @Override
    public void print(String output) {
        System.out.print(output);
    }
}
