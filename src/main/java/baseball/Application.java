package baseball;

import baseball.controller.GameManager;
import baseball.service.Computer;
import baseball.service.Player;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager(new Computer(), new Player());
        gameManager.runGame();
    }
}
