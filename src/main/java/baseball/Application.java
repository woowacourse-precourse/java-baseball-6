package baseball;

public class Application {
    public static void main(String[] args) {
        BaseballGame game = BaseballGameConfig.createBaseballGame();
        game.startGame();
    }
}
