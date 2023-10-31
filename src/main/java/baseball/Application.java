package baseball;

import baseball.domain.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController baseballGame = new GameController();
        baseballGame.gameStart();
    }
}
