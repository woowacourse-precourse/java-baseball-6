package baseball;

public class GameController {

    private final Game game;
    private final GameView gameView;

    GameController() {
        this.game = new Game();
        this.gameView = new GameView();
    }
}
