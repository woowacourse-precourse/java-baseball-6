package baseball;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.printStartMessage();

        boolean isRunning = true;
        while (isRunning) {
            Game game = new Game(gameManager);
            game.play();
            isRunning = gameManager.askRestart();
        }
    }
}
