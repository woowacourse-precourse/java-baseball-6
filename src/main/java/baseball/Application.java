package baseball;

public class Application {
    public static void main(String[] args) {
        BaseballGameManager baseballGameManager = new BaseballGameManager(3);
        baseballGameManager.startGame();
    }
}
