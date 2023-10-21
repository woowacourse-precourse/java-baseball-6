package baseball;

import baseball.controller.BaseballController;
import baseball.model.Player;

public class Application {
    public static void main(String[] args) {
        Player player = new Player();
        BaseballController baseballController = new BaseballController(player);
        baseballController.run();
    }
}
