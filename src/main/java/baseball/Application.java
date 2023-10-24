package baseball;

import baseball.game.GameManager;
import baseball.game.constant.Constants;
import baseball.game.view.InputManager;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        InputManager inputManager = new InputManager();
        while (true) {
            gameManager.playGame();
            String checkRegame = inputManager.askRegame();
            if (checkRegame.equals(Constants.REGAME)) {
                break;
            }
        }
    }
}
