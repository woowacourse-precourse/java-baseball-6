package baseball;

public class Application {
    public static void main(String[] args) {

        Game game = new Game(new GameStatus());
        game.start();
    }
}
