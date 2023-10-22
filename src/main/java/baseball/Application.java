package baseball;

import baseball.controller.GameStarter;

public class Application {
    public static void main(String[] args) {
        GameStarter gameStarter = new GameStarter();
        gameStarter.announceStarter();
    }
}
