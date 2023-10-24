package baseball;

import baseball.controller.GameMainController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameMainController gameMainController = new GameMainController();
        gameMainController.startGame();
    }
}
