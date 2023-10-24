package baseball;

public class GameExecutor {
    private Game game;

    public GameExecutor(Game game) {
        this.game = game;
    }


    public void run() {
        game.sayHello();
        while (true) {
            game.run();
            if (!game.shouldRetry()) {
                break;
            }
            game = game.createNewGame();
        }
    }
}
