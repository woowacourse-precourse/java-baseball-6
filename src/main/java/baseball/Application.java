package baseball;


public class Application {
    static final int DIGIT = 3;

    public static void main(String[] args) {
        BaseballGame game;
        do {
            game = new BaseballGame(DIGIT);
            game.play();
        } while (game.retry());
    }
}
