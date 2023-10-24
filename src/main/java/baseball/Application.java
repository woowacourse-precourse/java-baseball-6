package baseball;

import baseball.controller.GameControllerImpl;
import baseball.ui.GameView;
import baseball.ui.UserInputValidator;

public class Application {
    public static void main(String[] args) {
        new GameView(new GameControllerImpl(), new UserInputValidator()).start();
    }
}
