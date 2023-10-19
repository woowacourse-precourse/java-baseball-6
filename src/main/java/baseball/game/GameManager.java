package baseball;

public class GameManager {
    private static Game game = null;
    private static boolean isGameRunning = true;
    private static boolean isGameEnd = false;

    public static class GameIsNullException extends NullPointerException {
    }

    public static void register(Game _game) {
        game = _game;
        isGameRunning = true;
        isGameEnd = false;
    }

    public static void start() {
        if (game == null) {
            throw new GameIsNullException();
        }
        game.awake();
        while (!isGameEnd) {
            game.beforeLoop();
            while (isGameRunning) {
                game.gameLoop();
            }
            game.afterLoop();
        }
        game.cleanup();
    }

    public static void notifyGameEnd(boolean status) {
        isGameEnd = status;
    }

    public static void notifyGameRunning(boolean status) {
        isGameRunning = status;
    }
}
