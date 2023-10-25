package baseball;

import baseball.controller.Game;

public class Application {
    private static boolean isReplay;

    public static void main(String[] args) {
        do {
            Game doGame = new Game();
            doGame.run();

            isReplay = doGame.isExit();
        } while (isReplay);
    }
}
