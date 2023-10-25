package baseball;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
        while(game.doRegame())
            game.startGame();
    }
}
