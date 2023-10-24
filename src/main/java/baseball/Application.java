package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController controller = GameController.getInstance();
        controller.runGame();
    }
}
