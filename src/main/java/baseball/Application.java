package baseball;


import baseball.controller.GameController;
import baseball.model.GameLogic;
import baseball.view.GameIO;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController(new GameIO(), new GameLogic());
        gameController.init();
        gameController.runGame();
    }
}
