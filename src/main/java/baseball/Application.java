package baseball;

import baseball.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        //게임 시작
        gameController.startGame();
    }
}
