package baseball;

public class Application {
    public static void main(String[] args) {
        GameManager<String> gameManager = new GameManager<>(new Baseball());

        gameManager.start();
        gameManager.play();
        gameManager.stop();
    }
}
