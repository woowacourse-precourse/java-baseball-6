package baseball.game;

public class GameManager {
    private static Game game = null;
    private static boolean isGameRunning;
    private static boolean isGameEnd;

    public static class GameIsNullException extends NullPointerException {
    }

    public static void start(Game _game) {
        if (_game == null) {
            throw new GameIsNullException();
        }
        game = _game;

        notifyGameEnd(false);
        game.awake();
        while (!isGameEnd) {
            notifyGameRunning(true);
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
