package baseball;

import baseball.game.GameControl;

public class Application {
    public static void main(String[] args) {
        GameControl gamecontoller = new GameControl();
        gamecontoller.startGame();
    }
}
