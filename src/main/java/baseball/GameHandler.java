package baseball;

public class GameHandler {
    private Game game;

    private GameHandler(Game game) {
        this.game = game;
    }

    public GameHandler from(Game game) {
        return new GameHandler(game);
    }

    public void execute() {
        game.execute();
    }
}
