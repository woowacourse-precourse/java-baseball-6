package baseball;

import baseball.model.Game;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new View(), new Game());
        controller.run();
    }
}
