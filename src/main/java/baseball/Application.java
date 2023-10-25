package baseball;

public class Application {
    public static void main(String[] args) {
        //TODO: 프로그램 구현
        BaseballGame gameManager = new BaseballGame();
        while (gameManager.gameOver()) {
            gameManager.gameStart();
        }
    }
}
