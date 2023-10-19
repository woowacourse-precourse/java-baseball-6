package baseball;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        do {
            game.play_game();
        } while (game.is_continue());
    }
}
