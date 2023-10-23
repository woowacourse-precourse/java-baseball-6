package baseball.ui;

public class ConsoleOutput implements OutputUserInterface {

    @Override
    public void rendering(String output) {
        System.out.print(output);
    }
}
