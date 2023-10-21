package baseball;

public class Application {
    public static void main(String[] args) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        BaseBallGame game = new BaseBallGame(randomNumberGenerator);
        game.start();
    }
}
