package baseball;

import baseball.controller.GameStarter;

public class Application {
    public static void main(String[] args)  {
        new GameStarter().announceStarter();
    }
}
