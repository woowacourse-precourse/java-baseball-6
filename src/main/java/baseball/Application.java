package baseball;

import baseball.service.GameRunner;

public class Application {

    public static void main(String[] args) {
        GameRunner gameRunner = new GameRunner();
        gameRunner.start();
    }

}
