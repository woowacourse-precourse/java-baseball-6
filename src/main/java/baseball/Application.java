package baseball;

import baseball.domain.GameHost;

public class Application {

    public static void main(String[] args) {
        GameHost gameHost = new GameHost();
        gameHost.proceedGame();
    }
}
