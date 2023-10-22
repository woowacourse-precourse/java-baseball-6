package baseball;

import baseball.controller.BaseballController;

public class Application {
    public static void main(String[] args) {
        BaseballController controller = new BaseballController();
        controller.play();
    }
}
