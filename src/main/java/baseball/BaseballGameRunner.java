package baseball;

public class BaseballGameRunner {
    public static void run() throws IllegalArgumentException {
        Computer.printGameStartMessage();
        Game game = new Game();

        game.play();
        Computer.printCongrats();
        while (game.inputRestart()) {
            game = new Game();
            game.play();
            Computer.printCongrats();
        }
    }
}
