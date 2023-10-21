package baseball;

public class Application {
    static final GameManager gameManager = new GameManager();
    public static void main(String[] args) {
        gameManager.initGame();
        gameManager.startGame();
        // TODO: 프로그램 구현
    }
}
