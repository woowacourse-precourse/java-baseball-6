package baseball;

import baseball.controller.BaseballGameController;
import baseball.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        BaseballGameController baseballGameController = new BaseballGameController(new ConsoleView());
        baseballGameController.play();
    }
}
