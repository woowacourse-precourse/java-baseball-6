package baseball;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.printStartMessage();

        do {
            Game game = new Game(gameManager);
            game.play();
        } while (gameManager.askRestart());
    }
}
