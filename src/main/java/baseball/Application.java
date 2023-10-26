package baseball;

import baseball.game.GameControl;

public class Application {
    public static void main(String[] args) {
        GameControl gameContoller = new GameControl();
        gameContoller.startGame();
    }
}
