package baseball;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();

        while (true) {
            game.start();
            if (game.restart() == 2) {
                break;
            }
        }
    }
}

