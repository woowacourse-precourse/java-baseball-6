package baseball;

public class Application {
    private static Computer computer;

    public static void main(String[] args) {
    }

    private static void init() {
        computer = new Computer();
        MessageStream.printStartMessage();
    }
}
