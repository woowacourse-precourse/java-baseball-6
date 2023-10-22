package baseball;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();

        while (gameManager.validateRestart()) {

            gameManager.proceedIntro();

            gameManager.proceedMainGame();

            gameManager.proceedOutro();
        }
    }
}
