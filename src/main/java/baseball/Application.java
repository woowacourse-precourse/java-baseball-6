package baseball;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new Model(), new View());
        controller.startGame();
    }
}
