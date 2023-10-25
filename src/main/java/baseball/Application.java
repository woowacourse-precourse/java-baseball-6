package baseball;

public class Application {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        do {
            game.start();
        } while (!game.isEnd());
    }
}
