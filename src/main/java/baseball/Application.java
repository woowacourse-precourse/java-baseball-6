package baseball;

import baseball.controller.GameController;
import baseball.util.Converter;
import baseball.util.RandomGenerator;

public class Application {
    public static void main(String[] args) {
        GameController controller;

        do {
            controller = new GameController(RandomGenerator.getRandomNumbers(3,1,9),3);
            controller.startGame();
        } while (controller.restartOrExit());
    }
}
