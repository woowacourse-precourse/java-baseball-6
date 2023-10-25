package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        boolean newGame = false;
        do {
            game.play();
        } while (newGame);
    }
}
