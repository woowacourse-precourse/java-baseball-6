package baseball;

import baseball.controller.GameController;
import baseball.util.RandomGenerator;

import static baseball.constant.GameConstant.*;

public class Application {
    public static void main(String[] args) {
        GameController controller;
        do {
            int[] answer=RandomGenerator.getRandomNumbers(SIZE, START_NUMBER, END_NUMBER);
            controller = new GameController(answer, SIZE, START_NUMBER, END_NUMBER, EXIT_NUMBER, RESTART_NUMBER);
            controller.startGame();
        } while (controller.restartOrExit());
    }
}
