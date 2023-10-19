package baseball;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new Validator());
        controller.run();
    }
}
