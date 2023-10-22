package baseball;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();

        while (true) {
            gameManager.newGameStart();

            if (gameManager.askGameEnd()) {
                break;
            }
        }
        gameManager.clear();
    }
}
