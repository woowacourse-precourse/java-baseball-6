package baseball;

import baseball.controller.GameController;
import baseball.ui.GameView;

public class Application {
    public static void main(String[] args) {
        new GameView(new GameController()).start();
    }
}
