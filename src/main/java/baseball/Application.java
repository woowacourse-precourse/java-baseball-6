package baseball;

import baseball.controller.BasketballGameController;

public class Application {

    public static void main(String[] args) {
        BasketballGameController basketballGame = new BasketballGameController();
        basketballGame.playGame();
    }
}