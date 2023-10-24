package baseball;

import baseball.controller.BaseballController;
import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView.welcomeMessage();
        BaseballController.StartBaseballGame();
    }
}
