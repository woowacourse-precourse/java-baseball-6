package baseball;

import baseball.controller.GameStarter;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        GameStarter gameStarter = new GameStarter();
        gameStarter.announceStarter();
    }
}
