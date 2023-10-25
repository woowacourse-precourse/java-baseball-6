package baseball;

import baseball.controller.GameManager;
import baseball.view.Viewer;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameManager gameManager = new GameManager(new Viewer());
        gameManager.run();
    }
}
