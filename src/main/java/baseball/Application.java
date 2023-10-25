package baseball;

import baseball.Controller.GameController;
import baseball.Player.Computer;
import baseball.Player.User;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController(new User(), new Computer());
        gameController.startGame();
    }
}
