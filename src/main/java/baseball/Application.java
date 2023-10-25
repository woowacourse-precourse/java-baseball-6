package baseball;

import baseball.control.GameControl;

public class Application {
    public static void main(String[] args) {
        GameControl gameControl = new GameControl();
        gameControl.startGame();
    }
}
