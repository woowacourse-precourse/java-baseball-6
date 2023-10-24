package baseball.view.output;


public class ConsoleOutput implements Output {

    @Override
    public void printlnMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printMessage(String message) {
        System.out.print(message);
    }
}
