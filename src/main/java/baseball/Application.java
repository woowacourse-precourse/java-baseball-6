package baseball;
import baseball.Controller.GameController;
public class Application {
    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.startGame();
    }
}
