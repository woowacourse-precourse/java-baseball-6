package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputManager inputManager = new InputManager();
        JudgementManager judgementManager = new JudgementManager();
        GameManager gameManager = new GameManager(inputManager, judgementManager);

        gameManager.playGame();
    }
}
