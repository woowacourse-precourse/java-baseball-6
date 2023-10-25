package baseball;

import baseball.controller.BaseballGameController;
import baseball.view.ConsoleInputView;
import baseball.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        BaseballGameController baseballGameController =
                new BaseballGameController(new ConsoleInputView(), new ConsoleOutputView());
        baseballGameController.play();
    }
}
