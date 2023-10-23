package baseball;

import baseball.controller.ComputerController;
import baseball.controller.GameController;
import baseball.model.DecimalNumber;

public class Application {
    public static void main(String[] args) {
        DecimalNumber decimalNumber = new DecimalNumber();
        GameController gameController = new GameController(decimalNumber, new ComputerController(decimalNumber));
        gameController.run();
    }
}
