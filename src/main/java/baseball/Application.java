package baseball;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현
        Game game = new Game();
        try {
            game.start();
        } catch (InterruptedException exception) {
            game.stop();
        } finally {
            game.stop();
        }
    }
}
