package baseball;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();

        do {
            game.play();
        } while (game.proceed());

        game.end();
    }
}
