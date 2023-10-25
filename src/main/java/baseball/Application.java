package baseball;

public class Application {
    public static void main(String[] args) {

        boolean restart;

        Alert.gameStartMessage();

        do {
            Game baseballGame = new Game();
            baseballGame.start();
            restart = Game.reStart();

        } while (restart);

    }
}
