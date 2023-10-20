package baseball.game;

public class GameManager {
    private static Game game = null;
    private static boolean isGameRunning;
    private static boolean isGameManagerRunning;

    public static class GameIsNullException extends NullPointerException {
    }

    private static void inGameLoop() {
        if (game == null) {
            throw new GameIsNullException();
        }

        isGameRunning = true;

        game.beforeLoop();
        while (isGameRunning) {
            game.gameLoop();
        }
        game.afterLoop();
    }

    public static void start(Game _game) {
        if (_game == null) {
            throw new GameIsNullException();
        }
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
