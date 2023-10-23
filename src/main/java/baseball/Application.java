package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = Game.getInstance();
        try {
            game.startGame();
        }
        catch (InterruptedException exception) {
            game.stop();
        }
    }
}
