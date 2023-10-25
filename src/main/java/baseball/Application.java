package baseball;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager(new AppConfig());
        gameManager.runGame();
    }
}
