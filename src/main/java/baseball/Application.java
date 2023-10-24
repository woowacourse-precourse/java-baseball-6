package baseball;

import baseball.controller.GameControllerImpl;
import baseball.ui.GameView;
import baseball.ui.InputComponentImpl;
import baseball.ui.UserInputValidator;

public class Application {
    public static void main(String[] args) {
        new GameView(new GameControllerImpl(), new UserInputValidator(), new InputComponentImpl()).start();
    }
}
