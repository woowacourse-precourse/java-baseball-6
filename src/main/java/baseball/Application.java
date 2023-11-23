package baseball;

import baseball.controller.GameController;
import baseball.domain.Computer;
import baseball.domain.RandomNumbers;

public class Application {
    public static void main(String[] args) {
        RandomNumbers randomNumbers = new RandomNumbers();
        Computer computer = new Computer();
        GameController gameController = new GameController(randomNumbers, computer);
        gameController.startGame();
    }
}
