package baseball;

public class GameHandler {
    private Game game;

    private GameHandler(Game game) {
        this.game = game;
    }

    public static GameHandler from(Game game) {
        return new GameHandler(game);
    }

    public void executeGame() {
        game.execute();
    }
}
