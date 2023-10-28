package baseball;

import baseball.controller.BaseballGameController;

public class Application {

    public static void main(String[] args) {
        BaseballGameController game = new BaseballGameController();
        game.gamePlay();
    }
}
