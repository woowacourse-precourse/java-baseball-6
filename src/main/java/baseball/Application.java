package baseball;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        while (true) {
            baseballGame.startGame();

            if (!baseballGame.restartGame)
                break;
        }
    }
}
