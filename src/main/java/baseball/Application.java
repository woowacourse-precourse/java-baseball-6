package baseball;

import baseball.core.GameHost;

public class Application {

    public static void main(String[] args) {
        GameHost gameHost = GameHost.createGameHost();
        gameHost.gameStart();
    }
}
