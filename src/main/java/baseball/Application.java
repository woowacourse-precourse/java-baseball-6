package baseball;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현
        Game game = Game.generate();
        game.start();
    }
}
