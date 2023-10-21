package baseball;

import baseball.controller.SystemManager;
import baseball.view.OutputHandler;

public class Application {
    public static void main(String[] args) {
        OutputHandler.theGameStart();
        SystemManager.newGame();
    }
}
