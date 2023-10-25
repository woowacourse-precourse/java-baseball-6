package baseball;

import baseball.controller.GameManager;
import baseball.util.Constants;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        System.out.println(Constants.GAME_START_MESSAGE);
        gameManager.gameStart();
    }
}