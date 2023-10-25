package baseball;

public class Application {
    public static void main(String[] args) {
        System.out.println(Game.START_MESSAGE);
        Game game = new Game();
        game.startGame();
    }
}
