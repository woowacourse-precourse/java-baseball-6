package baseball.ui;

public class ConsoleOutput implements OutputUserInterface {

    @Override
    public void print(String s) {
        System.out.print(s);
    }
}
