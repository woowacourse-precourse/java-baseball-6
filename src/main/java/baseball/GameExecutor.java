package baseball;

public class GameExecutor {
    private BaseballGame game;

    public GameExecutor(BaseballGame game) {
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
