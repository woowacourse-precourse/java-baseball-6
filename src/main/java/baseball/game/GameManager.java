package baseball.game;

import baseball.utils.Assertions;

public class GameManager {
    private static Game game = null;
    private static boolean isGameRunning;
    private static boolean isGameManagerRunning;

    public static class GameIsNullException extends NullPointerException {
    }

    private static void inGameLoop() {
        Assertions.assertNotNull(game);

        isGameRunning = true;

        game.beforeLoop();
        while (isGameRunning) {
            game.gameLoop();
        }
        game.afterLoop();
    }

    public static void start(Game _game) {
        Assertions.assertNotNull(_game);
        game = _game;

        isGameManagerRunning = true;

        game.awake();
        while (isGameManagerRunning) {
            inGameLoop();
        }
        game.cleanup();
    }

    public static void notifyEndGameManager() {
        isGameManagerRunning = false;
    }

    public static void notifyEndGame() {
        isGameRunning = false;
    }
}
