package baseball;

public class Application {
    public static void main(String[] args) {
        try {
            Game game = new Game();
            game.play();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
