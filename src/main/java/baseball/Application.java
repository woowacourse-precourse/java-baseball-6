package baseball;

import baseball.Controller.BaseballGameManager;

public class Application {
    public static void main(String[] args) {
        BaseballGameManager baseballGameManager = new BaseballGameManager();
        baseballGameManager.startGame();
    }
}


