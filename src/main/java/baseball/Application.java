package baseball;

import baseball.manager.GameManager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameManager gameManager = new GameManager();
        gameManager.play();
    }
}
