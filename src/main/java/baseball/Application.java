package baseball;

public class Application {
    public static void main(String[] args) {
        BaseBallGame game = new BaseBallGame();
        GameConsole.play(game);
    }
}
