package baseball;

public class Application {
    public static void main(String[] args) {
        Player player = new Player();
        Game game = new Game(player);

        game.startGame();

    }
}
